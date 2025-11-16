package AndisUT2.ArtistAPI.DTO;

public class SongInAlbumDTO {

    private int songId;
    private String songName;

    public SongInAlbumDTO() {}

    public SongInAlbumDTO(int songId, String songName) {
        this.songId = songId;
        this.songName = songName;
    }

    public int getSongId() {return songId;}

    public void setSongId(int songId) {this.songId = songId;}

    public String getSongName() {return songName;}

    public void setSongName(String songName) {this.songName = songName;}
}
