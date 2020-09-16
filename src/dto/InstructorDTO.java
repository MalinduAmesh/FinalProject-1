package dto;

public class InstructorDTO {
    private String InstructID;
    private String InstructName;
    private String InstructGender;
    private String InstructNumber;
    private String InstructJoinDate;
    private String InstructCost;
    private String InstructPayMonth;

    public InstructorDTO() {
    }

    public InstructorDTO(String instructID, String instructName, String instructGender, String instructNumber, String instructJoinDate, String instructCost, String instructPayMonth) {
        InstructID = instructID;
        InstructName = instructName;
        InstructGender = instructGender;
        InstructNumber = instructNumber;
        InstructJoinDate = instructJoinDate;
        InstructCost = instructCost;
        InstructPayMonth = instructPayMonth;
    }

    public String getInstructID() {
        return InstructID;
    }

    public void setInstructID(String instructID) {
        InstructID = instructID;
    }

    public String getInstructName() {
        return InstructName;
    }

    public void setInstructName(String instructName) {
        InstructName = instructName;
    }

    public String getInstructGender() {
        return InstructGender;
    }

    public void setInstructGender(String instructGender) {
        InstructGender = instructGender;
    }

    public String getInstructNumber() {
        return InstructNumber;
    }

    public void setInstructNumber(String instructNumber) {
        InstructNumber = instructNumber;
    }

    public String getInstructJoinDate() {
        return InstructJoinDate;
    }

    public void setInstructJoinDate(String instructJoinDate) {
        InstructJoinDate = instructJoinDate;
    }

    public String getInstructCost() {
        return InstructCost;
    }

    public void setInstructCost(String instructCost) {
        InstructCost = instructCost;
    }

    public String getInstructPayMonth() {
        return InstructPayMonth;
    }

    public void setInstructPayMonth(String instructPayMonth) {
        InstructPayMonth = instructPayMonth;
    }
}
