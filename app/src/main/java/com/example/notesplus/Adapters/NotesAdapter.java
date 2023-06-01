package com.example.notesplus.Adapters;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesplus.Entities.Notes;
import com.example.notesplus.Líteners.NotesListener;
import com.example.notesplus.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class NotesAdapter extends  RecyclerView.Adapter<NotesAdapter.NoteViewHodel>{

    private List<Notes> notes;
     private NotesListener notesListener;


    public NotesAdapter(List<Notes> notes, NotesListener notesListener) {
        this.notes = notes;
        this.notesListener = notesListener;
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
    public void onBindViewHolder(@NonNull NoteViewHodel holder, @SuppressLint("RecyclerView") final int position) {

        holder.setNote(notes.get(position));
        holder.layoutNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notesListener.onNoteClicked( notes.get(position), position);
            }
        });

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
        LinearLayout linearLayout;
        View layoutNote;
        RoundedImageView imageNote;
        public NoteViewHodel(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textSubtitle = itemView.findViewById(R.id.textSubTitle);
            textDateTime = itemView.findViewById(R.id.textDateTime);
            layoutNote = itemView.findViewById(R.id.layoutNote);
            imageNote = itemView.findViewById(R.id.imageNote);
        }

        void setNote(Notes notes){
            textTitle.setText(notes.getTitle());
            if(notes.getSubtitle().trim().isEmpty()){
                textSubtitle.setVisibility(View.GONE);
            }else {
                textSubtitle.setText(notes.getSubtitle());
            }
            textDateTime.setText(notes.getDateTime());

            GradientDrawable gradientDrawable=(GradientDrawable) layoutNote.getBackground();
            if(notes.getColor() != null)
            {
                gradientDrawable.setColor(Color.parseColor(notes.getColor()));
            }
            else
            {
                gradientDrawable.setColor(Color.parseColor("#333333"));
            }

            if(notes.getImagePath() != null){
                imageNote.setImageBitmap(BitmapFactory.decodeFile(notes.getImagePath()));
                imageNote.setVisibility(View.VISIBLE);
            }else{
                imageNote.setVisibility(View.GONE);
            }
        }
    }
}
