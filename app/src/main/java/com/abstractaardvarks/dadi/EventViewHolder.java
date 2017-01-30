package com.abstractaardvarks.dadi;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Russell on 1/7/2017.
 */

public class EventViewHolder {
    private ImageView eventPic;
    private ImageView newEvent;
    private TextView newEvText;
    private TextView hostName;
    private TextView eventTopic;
    private TextView attendeeList;
    private Button eventButton;

    public EventViewHolder(ImageView eventPic, ImageView newEvent, TextView newEvText, TextView hostName, TextView eventTopic, TextView attendeeList, Button eventButton)
    {
        this.eventPic = eventPic;
        this.newEvent = newEvent;
        this.newEvText = newEvText;
        this.hostName = hostName;
        this.eventTopic = eventTopic;
        this.attendeeList = attendeeList;
        this.eventButton = eventButton;
    }

    public EventViewHolder() {}

    public Button getEventButton() {
        return eventButton;
    }

    public void setEventButton(Button eventButton) {
        this.eventButton = eventButton;
    }

    public TextView getAttendeeList() {
        return attendeeList;
    }

    public void setAttendeeList(TextView attendeeList) {
        this.attendeeList = attendeeList;
    }

    public TextView getEventTopic() {
        return eventTopic;
    }

    public void setEventTopic(TextView eventTopic) {
        this.eventTopic = eventTopic;
    }

    public TextView getHostName() {
        return hostName;
    }

    public void setHostName(TextView hostName) {
        this.hostName = hostName;
    }

    public TextView getNewEvText() {
        return newEvText;
    }

    public void setNewEvText(TextView newEvText) {
        this.newEvText = newEvText;
    }

    public ImageView getNewEvent() {
        return newEvent;
    }

    public void setNewEvent(ImageView newEvent) {
        this.newEvent = newEvent;
    }

    public ImageView getEventPic() {
        return eventPic;
    }

    public void setEventPic(ImageView eventPic) {
        this.eventPic = eventPic;
    }
}
