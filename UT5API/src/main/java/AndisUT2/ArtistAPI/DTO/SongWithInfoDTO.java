package AndisUT2.ArtistAPI.DTO;

public class SongWithInfoDTO {

    private int songId;
    private String songName;
    private ArtistDTO artist;
    private int albumId;
    private String albumName;

    public SongWithInfoDTO(int songId, String songName, ArtistDTO artist, int albumId, String albumName) {
        this.songId = songId;
        this.songName = songName;
        this.artist = artist;
        this.albumId = albumId;
        this.albumName = albumName;
    }

    public SongWithInfoDTO() {
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public ArtistDTO getArtist() {
        return artist;
    }

    public void setArtist(ArtistDTO artist) {
        this.artist = artist;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
