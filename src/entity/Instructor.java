package entity;

public class Instructor {

    private String InstructID;
    private String InstructName;
    private String InstructorNIC;
    private String InstructGender;
    private String InstructNumber;
    private String InstrDOB;
    private String InsStatus;

    public Instructor() {
    }

    public Instructor(String InstructID) {
        this.InstructID=InstructID;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "InstructID='" + InstructID + '\'' +
                ", InstructName='" + InstructName + '\'' +
                ", InstructorNIC='" + InstructorNIC + '\'' +
                ", InstructGender='" + InstructGender + '\'' +
                ", InstructNumber='" + InstructNumber + '\'' +
                ", InstrDOB='" + InstrDOB + '\'' +
                ", InsStatus='" + InsStatus + '\'' +
                '}';
    }

    public Instructor(String instructID, String instructName, String instructorNIC, String instructGender, String instructNumber, String instrDOB, String insStatus) {
        InstructID = instructID;
        InstructName = instructName;
        InstructorNIC = instructorNIC;
        InstructGender = instructGender;
        InstructNumber = instructNumber;
        InstrDOB = instrDOB;
        InsStatus = insStatus;
    }

    public String getInsStatus() {
        return InsStatus;
    }

    public void setInsStatus(String insStatus) {
        InsStatus = insStatus;
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

    public String getInstructorNIC() {
        return InstructorNIC;
    }

    public void setInstructorNIC(String instructorNIC) {
        InstructorNIC = instructorNIC;
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

    public String getInstrDOB() {
        return InstrDOB;
    }

    public void setInstrDOB(String instrDOB) {
        InstrDOB = instrDOB;
    }
}
