package AndisUT2.ArtistAPI.DTO;

public class ArtistDTO {

    private int artistId;
    private String name;

    public ArtistDTO(int artistId, String name) {
        this.artistId = artistId;
        this.name = name;
    }

    public ArtistDTO(String name){
        this.name = name;
    }

    public ArtistDTO() {}

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
