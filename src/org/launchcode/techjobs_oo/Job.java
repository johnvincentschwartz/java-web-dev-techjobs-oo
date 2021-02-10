package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private final int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // DONE: The first constructor should initialize a unique ID.
    public Job(){
        id = nextId;
        nextId++; //increments id for next instance
    }

    //  DONE: The second constructor should initialize the other five fields
    //   and also call the first in order to initialize the 'id' field.
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this(); //call first constructor
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // DONE: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        String nameString = this.getName().equals("") ? "Data not available" : this.getName();
        String employerString = this.getEmployer().getValue().isEmpty() ? "Data not available" : this.getEmployer().toString();
        String locationString = this.getLocation().toString().equals("") ? "Data not available" : this.getLocation().toString();
        String positionTypeString = this.getPositionType().toString().equals("") ? "Data not available" : this.getPositionType().toString();
        String coreCompetencyString = this.getCoreCompetency().toString().equals("") ? "Data not available" : this.getCoreCompetency().toString();

        String jobString = "";
        jobString += '\n';
        jobString += "ID: " + this.getId() + '\n';
        jobString += "Name: " + nameString + '\n';
        jobString += "Employer: " + employerString + '\n';
        jobString += "Location: " + locationString + '\n';
        jobString += "Position Type: " + positionTypeString + '\n';
        jobString += "Core Competency: " + coreCompetencyString;
        jobString += '\n';
        return jobString;
    }

    // DONE: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
