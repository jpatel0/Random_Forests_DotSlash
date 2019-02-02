package com.randomforests.saaransh.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.randomforests.saaransh.R;
import com.randomforests.saaransh.activity.NotesDashboard;
import com.randomforests.saaransh.models.Notes;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    ArrayList<Notes> list ;
    Context context;
    public NotesAdapter(Context context, ArrayList<Notes> list) {
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notes_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title.setText(list.get(i).getTitle());
        viewHolder.description.setText(list.get(i).getDesc().length()>30?list.get(i).getDesc().substring(0,30)+"...":list.get(i).getDesc());
        viewHolder.timestamp.setText(list.get(i).getTimestamp());
        viewHolder.uploadedBy.setText(list.get(i).getUploadedBy());
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NotesDashboard.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,timestamp,uploadedBy,description;
        RelativeLayout parentLayout;

        private ViewHolder(View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.note_title);
            timestamp=itemView.findViewById(R.id.note_timestamp);
            description=itemView.findViewById(R.id.note_description);
            uploadedBy=itemView.findViewById(R.id.uploaded_by);
            parentLayout=itemView.findViewById(R.id.note_lay);
        }
    }
}
