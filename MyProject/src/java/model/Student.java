/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mr Thinh
 */

public class Student {
    private String stid;
    private String stmember;
    private String stsurname;
    private String stmiddlename;
    private String stgivenname;

    public Student() {
    }

    public Student(String stid, String stmember, String stsurname, String stmiddlename, String stgivenname) {
        this.stid = stid;
        this.stmember = stmember;
        this.stsurname = stsurname;
        this.stmiddlename = stmiddlename;
        this.stgivenname = stgivenname;
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid;
    }

    public String getStmember() {
        return stmember;
    }

    public void setStmember(String stmember) {
        this.stmember = stmember;
    }

    public String getStsurname() {
        return stsurname;
    }

    public void setStsurname(String stsurname) {
        this.stsurname = stsurname;
    }

    public String getStmiddlename() {
        return stmiddlename;
    }

    public void setStmiddlename(String stmiddlename) {
        this.stmiddlename = stmiddlename;
    }

    public String getStgivenname() {
        return stgivenname;
    }

    public void setStgivenname(String stgivenname) {
        this.stgivenname = stgivenname;
    }  
}