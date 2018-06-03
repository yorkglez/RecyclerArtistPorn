package com.pmoviles.fsociety.recyclerartistporn;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.Console;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter
    <RecyclerAdapter.ViewHolderArtist> implements ItemClickListener{

    private final Context context;
    private List<Artist> data;


    public RecyclerAdapter(Context context, List<Artist> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolderArtist onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new ViewHolderArtist(v, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArtist holder, int position) {
        Artist artist = data.get(position);
        holder.txtName.setText(artist.getName());
        holder.txtPhone.setText(artist.getPhone());
        holder.ratingBar.setRating((float)artist.getRating());
        if(artist.CheckPhoto())
        {
            /// hacer algo
        } else {
            holder.cImage.setImageResource(R.drawable.avatar);
        }
    }

    @Override
    public int getItemCount() { return data.size(); }
    @Override
    public void onItemClick(View view, int position) {
        Log.e("Posición", "" + position);

        DescriptionArtist.crearInstancia((Activity) context,
                data.get(position));
    }

    public static class ViewHolderArtist extends RecyclerView.ViewHolder
            implements View.OnClickListener
    {

        @BindView(R.id.artistName)
        TextView txtName;
        @BindView(R.id.Rating)
        RatingBar ratingBar;
        @BindView(R.id.txtPhone)
        TextView txtPhone;
        @BindView(R.id.avatar)
        CircleImageView cImage;

        public ItemClickListener listenert;

        public ViewHolderArtist(View itemView, ItemClickListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.listenert = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listenert.onItemClick(v, getAdapterPosition());
        }
    }
}
