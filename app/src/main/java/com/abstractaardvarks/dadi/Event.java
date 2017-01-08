package com.abstractaardvarks.dadi;

/**
 * Created by Russell on 12/22/2016.
 */

public class Event {
    private String eventID;
    private String hostID;
    private String hostName;
    private String attendees;
    private String rsvpList;
    private String topic;
    private String dateCreated;
    private String category;
    private String viewedList;
    private double latitude;
    private double longitude;
    private boolean isPrivate;

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getHostID() {
        return hostID;
    }

    public void setHostID(String hostID) {
        this.hostID = hostID;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }

    public String getRsvpList() {
        return rsvpList;
    }

    public void setRsvpList(String rsvpList) {
        this.rsvpList = rsvpList;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getViewedList() {
        return viewedList;
    }

    public void setViewedList(String viewedList) {
        this.viewedList = viewedList;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
}
