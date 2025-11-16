package AndisUT2.ArtistAPI.DTO;

import java.util.ArrayList;
import java.util.List;

public class AlbumWithInfoDTO {

    private int albumId;
    private String albumName;
    private int artistId;
    private String artistName;
    private List<SongInAlbumDTO> songNames;

    public AlbumWithInfoDTO(){};

    public AlbumWithInfoDTO(int albumId, String albumName, int artistId, String artistName) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.artistId = artistId;
        this.artistName = artistName;
        this.songNames = new ArrayList<SongInAlbumDTO>();
    }

    public int getAlbumId() {return albumId;}

    public void setAlbumId(int albumId) {this.albumId = albumId;}

    public String getAlbumName() {return albumName;}

    public void setAlbumName(String albumName) {this.albumName = albumName;}

    public int getArtistId() {return artistId;}

    public void setArtistId(int artistId) {this.artistId = artistId;}

    public String getArtistName() {return artistName;}

    public void setArtistName(String artistName) {this.artistName = artistName;}

    public List<SongInAlbumDTO> getSongNames() {return songNames;}

    public void setSongNames(List<SongInAlbumDTO> songNames) {this.songNames = songNames;}


    public void addSong(SongInAlbumDTO song){songNames.add(song);}

    public void removeSong(SongInAlbumDTO song){songNames.remove(song);}
}
