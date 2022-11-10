package model;

import java.util.ArrayList;

/**
 *
 * @author Mr.Thinh
 */
public class Subject {

    private int id;
    private String name;
    private ArrayList<Group> groups = new ArrayList<>();

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

}
