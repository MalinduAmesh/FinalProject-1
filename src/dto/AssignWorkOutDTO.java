package dto;

public class AssignWorkOutDTO {

    private String assWorkId;
    private String assMemID;
    private String assSchID;
    private String assInDate;
    private String assOutDate;

    public AssignWorkOutDTO() {
    }

    public AssignWorkOutDTO(String assWorkId, String assMemID, String assSchID, String assInDate, String assOutDate) {
        this.assWorkId = assWorkId;
        this.assMemID = assMemID;
            this.assSchID = assSchID;
        this.assInDate = assInDate;
        this.assOutDate = assOutDate;
    }

    @Override
    public String toString() {
        return "AssignWorkOutDTO{" +
                "assWorkId='" + assWorkId + '\'' +
                ", assMemID='" + assMemID + '\'' +
                ", assSchID='" + assSchID + '\'' +
                ", assInDate='" + assInDate + '\'' +
                ", assOutDate='" + assOutDate + '\'' +
                '}';
    }

    public String getAssWorkId() {
        return assWorkId;
    }

    public void setAssWorkId(String assWorkId) {
        this.assWorkId = assWorkId;
    }

    public String getAssMemID() {
        return assMemID;
    }

    public void setAssMemID(String assMemID) {
        this.assMemID = assMemID;
    }

    public String getAssSchID() {
        return assSchID;
    }

    public void setAssSchID(String assSchID) {
        this.assSchID = assSchID;
    }

    public String getAssInDate() {
        return assInDate;
    }

    public void setAssInDate(String assInDate) {
        this.assInDate = assInDate;
    }

    public String getAssOutDate() {
        return assOutDate;
    }

    public void setAssOutDate(String assOutDate) {
        this.assOutDate = assOutDate;
    }
}
