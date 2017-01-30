package com.abstractaardvarks.dadi;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Russell on 1/7/2017.
 */

public class EventAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Event> events;
    private EventViewHolder viewHolder;
    private LayoutInflater inflater = null;


    public EventAdapter(Context context, String[] events) {

        this.context = context;
        this.events = new ArrayList<Event>();
        this.viewHolder = new EventViewHolder();

        //this.events.addAll(eventList);

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return EventModel.events.length;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        return EventModel.events.length;
    }


    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        ViewHolder holder;
        if(convertview == null) {

            convertview =inflater.inflate(R.layout.event_template,null);
            holder = new ViewHolder();

            holder._cover = (ImageView) convertview.findViewById(R.id.img_cover_d);
            holder._background = (ImageView) convertview.findViewById(R.id.img_background);
            holder._event = (TextView) convertview.findViewById(R.id.txt_event_details);
            holder._event_detail = (TextView) convertview.findViewById(R.id.txt_event_details);
            holder._event_date = (TextView) convertview.findViewById(R.id.txt_event_date);
            holder._vw_blayer =  convertview.findViewById(R.id.vw_blacklayer);

            convertview.setTag(holder);

        } else {
            holder = (ViewHolder) convertview.getTag();
        }


        holder._event.setText(EventModel.events[i]);
        holder._event_detail.setText(EventModel.event_details[i]);
        holder._event_date.setText("o "+EventModel.event_dates[i]);
        //holder._cover.setImageResource(cover[i]);
        Picasso.with(context).load(EventModel.cover[i]).into(holder._cover);
        // holder._background.setImageResource(background[i]);
        Picasso.with(context).load(EventModel.background[i]).into(holder._background);


        ObjectAnimator fade = ObjectAnimator.ofFloat(holder._vw_blayer, View.ALPHA, 1f,.3f);
        fade.setDuration(1500);
        fade.setInterpolator(new LinearInterpolator());
        fade.start();


        return convertview;
    }

    public class ViewHolder {

        ImageView _cover;
        ImageView _background;
        TextView _event;
        TextView _event_detail;
        TextView _event_date;
        View _vw_blayer;
    }


    /*
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
    */


}
