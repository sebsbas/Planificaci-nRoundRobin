package com.example.planificacinroundrobin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ProcessViewHolder>{

    private ArrayList <Process> process;

    public Adapter(ArrayList<Process> process) {
        this.process = process;
    }

    @NonNull
    @Override
    public ProcessViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context myContext = parent.getContext();
        int layoutIdListItem = R.layout.list_process_row;
        LayoutInflater inflater = LayoutInflater.from(myContext);
        boolean attachToParentFast = false;

        View view = inflater.inflate(layoutIdListItem,parent,attachToParentFast);

        ProcessViewHolder viewHolder = new ProcessViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProcessViewHolder holder, int position) {

        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return process.size();
    }

    class ProcessViewHolder extends RecyclerView.ViewHolder{

        TextView tvProcessView;

        public ProcessViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProcessView = itemView.findViewById(R.id.tv_unit_process);

        }

        void bind(int position){
            tvProcessView.setText(process.get(position).toString());
        }

    }
}
