/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Mr.Thinh
 */
public class Lecturer {
    private int id;
    private String name;
    private ArrayList<Group> groups = new ArrayList<>();
    private ArrayList<Session> sessions = new ArrayList<>();
    private ArrayList<Lecturer_Login> lecturer_logins = new ArrayList<>();

    public ArrayList<Lecturer_Login> getLecturer_logins() {
        return lecturer_logins;
    }

    public void setLecturer_logins(ArrayList<Lecturer_Login> lecturer_logins) {
        this.lecturer_logins = lecturer_logins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }
    
    
}