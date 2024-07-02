package com.example.mvvm;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener {

    private ContactModel[] dataSet;

    public MyAdapter(ContactModel[] _dataSet) {

        dataSet = _dataSet;
    }


    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        // create a new view
        View rootView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_contact, viewGroup, false);

        return new MyViewHolder(rootView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.nameTextView.setText(dataSet[position].name);
        holder.phoneTextView.setText(dataSet[position].phoneNumber);

        if (dataSet[position].enabled) {

            holder.callButton.setOnClickListener(this);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    @Override
    public void onClick(View v) {
        Log.d("RecyclerView", "CLICK!");
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView phoneTextView;
        public Button callButton;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            this.nameTextView = itemView.findViewById(R.id.name_text);
            this.phoneTextView = itemView.findViewById(R.id.phone_text);
            this.callButton = itemView.findViewById(R.id.call_button);

        }
    }
}
