package Entites;

public class email {

    private String ToEmail;

    private String Subjects;
    private String Msg;

    public email(String toEmail, String msg) {
        ToEmail = toEmail;
        Msg = msg;
    }

    public email(String toEmail, String subjects, String msg) {
        ToEmail = toEmail;
        Subjects = subjects;
        Msg = msg;
    }

    public email() {
    }

    public void setToEmail(String toEmail) {
        ToEmail = toEmail;
    }

    public void setSubjects(String subjects) {
        Subjects = subjects;
    }

    public String getToEmail() {
        return ToEmail;
    }

    public String getSubjects() {
        return Subjects;
    }

    public class Authenticator {
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getMsg() {
        return Msg;
    }

}
