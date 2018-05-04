package com.example.weisslogia.automatedattendancesystem;

public class Student {

    private String studentId;
    private String studentPassword;
    private String studentName;

    public Student()
    {

    }

    public Student(String _studentId, String _studentPassword)
    {
        this.studentId = _studentId;
        this.studentPassword = _studentPassword;
    }

    public Student(String _studentId, String _studentName, String _studentPassword)
    {
        this.studentId = _studentId;
        this.studentPassword = _studentPassword;
        this.studentName = _studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
