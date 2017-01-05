package com.cloudwalk.validate.validateapp.mainscreen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

import com.cloudwalk.validate.validateapp.R;
import com.cloudwalk.validate.validateapp.data.local.models.Event;
import com.cloudwalk.validate.validateapp.eventproperscreen.EventProperActivity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by nkmcheng on 04/01/2017.
 */

public class EventsAdapter extends
            RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    // Store a member variable for the contacts
    private List<Event> mEvents;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public EventsAdapter(Context context, List<Event> events) {
        mEvents = events;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View eventsView = inflater.inflate(R.layout.events_list, parent, false);

        // Return a new holder instance
        RecyclerView.ViewHolder viewHolder = new ViewHolder(eventsView);

        return (ViewHolder) viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Event contact = mEvents.get(position);

        // Set item views based on your views and data model
        TextView nameTextView = viewHolder.nameTextView;
        nameTextView.setText(contact.getName());

        TextView jonumTextView = viewHolder.jonumTextView;
        jonumTextView.setText(contact.getJonum());

        TextView dateTextView = viewHolder.dateTextView;
        dateTextView.setText(contact.getEventdate());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView jonumTextView;
        public TextView dateTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.event_name);
            jonumTextView = (TextView) itemView.findViewById(R.id.jo_num);
            dateTextView = (TextView) itemView.findViewById(R.id.event_date);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition(); // gets item position

            Event event = mEvents.get(position);

            EventProperActivity.mCurrentEvent = event;
            Intent intent = new Intent(getContext(), EventProperActivity.class);
            getContext().startActivity(intent);
        }
    }


}
