public class Course {
    private String name;
    private String code;
    private String meetingTime;

    public Course(String name, String code, String meetingTime) {
        this.name = name;
        this.code = code;
        this.meetingTime = meetingTime;

    }

    public String toString() {
        return code + ": " + name + " meets at, " + meetingTime;
    }

}
