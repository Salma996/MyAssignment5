package com.example.mohammad.assignmentfive;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by M.Eslim on 09/03/2018.
 */

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.ViewHolder> {


   private List<String> mylistitem ;
Context context;

    public MyAdapter(List<String> Datee, Context context) {
        this.mylistitem = Datee;
        this.context =  context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

      return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String listitem = mylistitem.get(position);
        holder.name.setText(listitem);

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (holder.checkBox.isChecked())
        {
            holder.name.append("  done ");
        }

    }
});
    }


    @Override
    public int getItemCount() {
        return mylistitem.size();
    }

    public class   ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public CheckBox checkBox;
        public RelativeLayout myRelativ;






        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            checkBox = (CheckBox)itemView.findViewById(R.id.checkBox);
            myRelativ = (RelativeLayout)itemView.findViewById(R.id.myRelativ);
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
