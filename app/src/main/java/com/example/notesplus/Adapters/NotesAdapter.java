package com.example.notesplus.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesplus.Entities.Notes;
import com.example.notesplus.R;

import java.util.List;

public class NotesAdapter extends  RecyclerView.Adapter<NotesAdapter.NoteViewHodel>{

    private List<Notes> notes;

    public NotesAdapter(List<Notes> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHodel(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_note,parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHodel holder, int position) {

        holder.setNote(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static  class  NoteViewHodel extends RecyclerView.ViewHolder{

        TextView textTitle, textSubtitle,textDateTime;

        public NoteViewHodel(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textSubtitle = itemView.findViewById(R.id.textSubTitle);
            textDateTime = itemView.findViewById(R.id.textDateTime);
        }

        void setNote(Notes notes){
            textTitle.setText(notes.getTitle());
            if(notes.getSubtitle().trim().isEmpty()){
                textSubtitle.setVisibility(View.GONE);
            }else {
                textSubtitle.setText(notes.getSubtitle());
            }
            textDateTime.setText(notes.getDateTime());

        }
    }
}
