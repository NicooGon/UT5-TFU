package AndisUT2.ArtistAPI.Service.Implementation;

import AndisUT2.ArtistAPI.Service.Interface.IAlbumService;
import AndisUT2.ArtistAPI.Service.Interface.IArtistService;
import AndisUT2.ArtistAPI.Service.Interface.IPlaylistService;
import AndisUT2.ArtistAPI.Service.Interface.IPlaylistSongService;
import org.springframework.stereotype.Service;

@Service
public class PlaylistApplicationService {

    private final IAlbumService albumService;
    private final IArtistService artistService;
    private final IPlaylistService playlistService;
    private final IPlaylistSongService playlistSongService;

    public PlaylistApplicationService(IAlbumService albumService, IArtistService artistService, IPlaylistService playlistService, IPlaylistSongService playlistSongService) {
        this.albumService = albumService;
        this.artistService = artistService;
        this.playlistService = playlistService;
        this.playlistSongService = playlistSongService;
    }

}
