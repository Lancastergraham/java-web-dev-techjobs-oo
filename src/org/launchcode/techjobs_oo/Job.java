package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer,
               Location location,
               PositionType positionType,
               CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.


    @Override
    public boolean equals(Object o) { // Two objects are equal if they have
        // the same id.
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

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

    public void setCoreCompetency(
            CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {

        int theID = this.getId();
        String theName;
        String theEmployer;
        String theLocation;
        String thePosition;
        String theCoreCompetency;

        if (getName() == null && getLocation() == null && getEmployer() == null && getPositionType() == null && getCoreCompetency() == null) {
            return "OOPS! This job does not seem to exist.";
        }

        if (name == null || name.equals("")) {
            theName = "Data not available";
        } else {
            theName = this.getName();
        }

        if (employer == null || employer.getValue().equals("")) {
            theEmployer = "Data not available";
        } else {
            theEmployer = this.getEmployer().toString();
        }

        if (location == null || location.getValue().equals("")) {
            theLocation = "Data not available";
        } else {
            theLocation = this.getLocation().toString();
        }

        if (positionType == null || positionType.getValue().equals("")) {
            thePosition = "Data not available";
        } else {
            thePosition = this.getPositionType().toString();
        }

        if (coreCompetency == null || coreCompetency.getValue().equals("")) {
            theCoreCompetency = "Data not available";
        } else {
            theCoreCompetency = this.getCoreCompetency().toString();
        }

        return "\n" +
                "ID:  " + theID + "\n"+
                "Name: " + theName + "\n" +
                "Employer: " + theEmployer + "\n" +
                "Location: " + theLocation + "\n" +
                "Position Type: " + thePosition + "\n" +
                "Core Competency: " + theCoreCompetency + "\n";
    }
}
