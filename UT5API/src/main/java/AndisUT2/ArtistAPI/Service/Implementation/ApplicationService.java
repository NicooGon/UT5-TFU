package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.DTO.*;
import AndisUT2.ArtistAPI.Mapper.AlbumWithInfoMapper;
import AndisUT2.ArtistAPI.Mapper.PlaylistWithInfoMapper;
import AndisUT2.ArtistAPI.Mapper.SongWithInfoMapper;
import AndisUT2.ArtistAPI.Service.Interface.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    private final IAlbumService albumService;
    private final IArtistService artistService;
    private final IPlaylistService playlistService;
    private final IPlaylistSongService playlistSongService;
    private final IUserService userService;
    private final ISongService songService;
    private final SongWithInfoMapper songWithInfoMapper;
    private final AlbumWithInfoMapper albumWithInfoMapper;
    private final PlaylistWithInfoMapper playlistWithInfoMapper;


    public ApplicationService(
            IAlbumService albumService, IArtistService artistService,
            IPlaylistService playlistService, IPlaylistSongService playlistSongService,
            SongService songService, AlbumWithInfoMapper albumWithInfoMapper,
            SongWithInfoMapper songWithInfoMapper,  PlaylistWithInfoMapper playlistWithInfoMapper,
            UserService userService) {
        this.albumService = albumService;
        this.artistService = artistService;
        this.playlistService = playlistService;
        this.playlistSongService = playlistSongService;
        this.songService = songService;
        this.albumWithInfoMapper = albumWithInfoMapper;
        this.songWithInfoMapper = songWithInfoMapper;
        this.playlistWithInfoMapper = playlistWithInfoMapper;
        this.userService = userService;
    }


    public SongWithInfoDTO getSongWithInfo(int songId) {

        SongDTO song = songService.getSongById(songId);
        ArtistDTO artist = artistService.getArtistById(song.getArtistId());
        AlbumDTO album = albumService.getAlbumById(song.getAlbumId());

        return songWithInfoMapper.toSongWithInfoDTO(song, artist, album);
    }

    public AlbumWithInfoDTO getAlbumWithInfo(int albumId) {

        AlbumDTO album = albumService.getAlbumById(albumId);
        ArtistDTO artist = artistService.getArtistById(album.getArtistId());
        List<SongDTO> songs = songService.getSongsByAlbumId(albumId);

        return albumWithInfoMapper.toAlbumWithInfoDTO(album, artist, songs);
    }

    public PlaylistWithInfoDTO getPlaylistWithInfo(int playlistId) {

        PlaylistDTO playlist = playlistService.getPlaylistById(playlistId);
        UserDTO userDTO = userService.getUserById(playlist.getUserId());

        List<Integer> songIdList = playlistSongService.getSongsByPlaylistId(playlistId);

        List<SongDTO> songsListDTO = songIdList.stream()
                .map(songService::getSongById)
                .toList();

        List<SongWithInfoDTO> songsWithInfo = songsListDTO.stream()
                .map(songDTO -> {
                    ArtistDTO artist = artistService.getArtistById(songDTO.getArtistId());
                    AlbumDTO album  = albumService.getAlbumById(songDTO.getAlbumId());
                    return songWithInfoMapper.toSongWithInfoDTO(songDTO, artist, album);
                })
                .toList();


        return playlistWithInfoMapper.toPlaylistWithInfoDTO(playlist, userDTO, songsWithInfo);
    }

    public PlaylistWithInfoDTO optimizedGetPlaylistWithInfo(int playlistId) {

        PlaylistDTO playlist = playlistService.getPlaylistById(playlistId);
        UserDTO userDTO = userService.getUserById(playlist.getUserId());

        List<Integer> songIdList = playlistSongService.getSongsByPlaylistId(playlistId);

        List<SongDTO> songsListDTO = songService.getSongsById(songIdList);

        List<ArtistDTO> artistDTOS = artistService.getArtistsByIds(songIdList);
        Map<Integer, ArtistDTO> artistMap = artistDTOS.stream().collect(Collectors.toMap(ArtistDTO::getArtistId, a -> a));

        List<Integer> albumIds = songsListDTO.stream().map(SongDTO::getAlbumId).distinct().toList();
        List<AlbumDTO> albums = albumService.getAlbumsByIds(albumIds);
        Map<Integer, AlbumDTO> albumMap = albums.stream().collect(Collectors.toMap(AlbumDTO::getAlbumId, a -> a));

        List<SongWithInfoDTO> songsWithInfo = songsListDTO.stream()
                .map(song -> {
                    ArtistDTO artist = artistMap.get(song.getArtistId());
                    AlbumDTO album = albumMap.get(song.getAlbumId());
                    return songWithInfoMapper.toSongWithInfoDTO(song, artist, album);
                })
                .toList();

        return playlistWithInfoMapper.toPlaylistWithInfoDTO(playlist, userDTO, songsWithInfo);
    }

    @Transactional
    public PlaylistWithInfoDTO optimizedSavePlaylistWithInfo(PlaylistCreateRequestDTO requestDTO) {
        PlaylistDTO playlistDTO = playlistService.savePlaylist(requestDTO.getName(), requestDTO.getUserId());

        playlistSongService.addSongsToPlaylist(playlistDTO.getPlaylistId(), requestDTO.getSongIds());

        return optimizedGetPlaylistWithInfo(playlistDTO.getPlaylistId());
    }

    @Transactional
    public PlaylistWithInfoDTO savePlaylistWithInfo(PlaylistCreateRequestDTO requestDTO) {
        PlaylistDTO playlistDTO = playlistService.savePlaylist(requestDTO.getName(), requestDTO.getUserId());

        playlistSongService.addSongsToPlaylist(playlistDTO.getPlaylistId(), requestDTO.getSongIds());

        return getPlaylistWithInfo(playlistDTO.getPlaylistId());
    }
}
