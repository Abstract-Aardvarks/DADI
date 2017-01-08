package com.abstractaardvarks.dadi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Russell on 1/7/2017.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    private Context context;
    private ArrayList<Event> events;
    private EventViewHolder viewHolder;


    public EventAdapter(Context context, int layoutID, ArrayList<Event> eventList) {
        super(context, layoutID, eventList);
        this.context = context;
        this.events = new ArrayList<Event>();
        this.viewHolder = new EventViewHolder();

        this.events.addAll(eventList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        this.viewHolder = null;
        CurrentUser cu = CurrentUser.getInstance();

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.list_events, parent, true);

            this.viewHolder = new EventViewHolder();

            this.viewHolder.setEventPic((ImageView) convertView.findViewById(R.id.eventPicture));
            this.viewHolder.setNewEvent((ImageView) convertView.findViewById(R.id.newEvent));
            this.viewHolder.setNewEvText ((TextView) convertView.findViewById(R.id.newEventText));
            this.viewHolder.setHostName ((TextView) convertView.findViewById(R.id.hostName));
            this.viewHolder.setEventTopic ((TextView) convertView.findViewById(R.id.eventTopic));
            this.viewHolder.setAttendeeList ((TextView) convertView.findViewById(R.id.attendeeList));
            this.viewHolder.setEventButton ((Button) convertView.findViewById(R.id.goToEvent));

            convertView.setTag(this.viewHolder);
        } else {
            this.viewHolder = (EventViewHolder) convertView.getTag();
        }

        final Event event = events.get(position);
        this.viewHolder.getNewEvent().setVisibility(View.GONE);
        this.viewHolder.getNewEvText().setVisibility(View.GONE);

        if (event.getViewedList() == null) {
            this.viewHolder.getNewEvent().setVisibility(View.VISIBLE);
            this.viewHolder.getNewEvText().setVisibility(View.VISIBLE);
            this.viewHolder.getNewEvent().setImageResource(R.mipmap.ic_favorite_black_48dp);
            this.viewHolder.getNewEvText().setText("NEW!");
        } else {

            String viewed[] = event.getViewedList().split(",");
            boolean alreadyViewed = false;
            for (int k = 0; k < viewed.length; k++) {

                if (viewed[k].contentEquals(cu.getUserID())) {
                    alreadyViewed = true;
                    break;
                }
            }
            if (!alreadyViewed) {
                this.viewHolder.getNewEvent().setVisibility(View.VISIBLE);
                this.viewHolder.getNewEvText().setVisibility(View.VISIBLE);
                this.viewHolder.getNewEvent().setImageResource(R.mipmap.ic_favorite_black_48dp);
                this.viewHolder.getNewEvText().setText("NEW!");
            }
        }
        this.viewHolder.getEventButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        String cat = event.getCategory();

        this.viewHolder.getEventTopic().setText("The topic is: " + event.getTopic());


        String attenName = "";

        this.viewHolder.getAttendeeList().setText(attenName);

        this.viewHolder.getHostName().setText(event.getHostName());

        if (cat == null) {
            this.viewHolder.getEventPic().setImageResource(R.mipmap.ic_favorite_black_48dp);
        } else {
            cat = cat.toLowerCase();

            if (cat.contains("location")) {
                this.viewHolder.getEventPic().setImageResource(R.mipmap.ic_favorite_black_48dp);
            } else if (cat.contains("food")) {
                this.viewHolder.getEventPic().setImageResource(R.mipmap.ic_favorite_black_48dp);
            } else if (cat.contains("entertainment")) {
                this.viewHolder.getEventPic().setImageResource(R.mipmap.ic_favorite_black_48dp);
            } else if (cat.contains("random")) {
                this.viewHolder.getEventPic().setImageResource(R.mipmap.ic_favorite_black_48dp);
            } else {
                this.viewHolder.getEventPic().setImageResource(R.mipmap.ic_favorite_black_48dp);
            }
        }

        this.viewHolder.getEventTopic().setTag(event);

        return convertView;
    }


}
