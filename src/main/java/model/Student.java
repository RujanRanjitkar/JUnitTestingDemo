package model;

public class Student {
    private int id;
    private String student_name;
    private String address;

    public Student(int id, String student_name, String address) {
        this.id = id;
        this.student_name = student_name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
