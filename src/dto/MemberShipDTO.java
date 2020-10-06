package dto;

public class MemberShipDTO {

    private String memShipid;
    private String name;
    private String duration;
    private String Fee;

    public MemberShipDTO() {
    }

    public MemberShipDTO(String memShipid, String name,String Fee) {
        this.memShipid = memShipid;
        this.name = name;
        this.Fee =Fee;
    }

    public MemberShipDTO(String memShipid, String name, String duration, String fee) {
        this.memShipid = memShipid;
        this.name = name;
        this.duration = duration;
        Fee = fee;
    }

    public String getMemShipid() {
        return memShipid;
    }

    public void setMemShipid(String memShipid) {
        this.memShipid = memShipid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return Fee;
    }

    public void setFee(String fee) {
        Fee = fee;
    }
}
