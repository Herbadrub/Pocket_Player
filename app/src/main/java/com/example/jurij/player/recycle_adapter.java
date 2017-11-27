package com.example.jurij.player;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jurij on 20. 03. 2017.
 */

public class recycle_adapter extends RecyclerView.Adapter<recycle_adapter.ViewHolder> {


    MediaPlayer mediaPlayer;
    private Context context;
    private ArrayList<Song> itemList;
    public recycle_adapter(Context context, ArrayList<Song> itemList){
        this.context=context;
        this.itemList=itemList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflejter = LayoutInflater.from(parent.getContext());
        View view = inflejter.from(parent.getContext()).inflate(R.layout.main_layout, parent, false);
        recycle_adapter.ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(recycle_adapter.ViewHolder holder, int position) {



        final Song termin = itemList.get(position);

        holder.naslov.setText(termin.getNaslov());

        MediaMetadataRetriever metaRetriever = new MediaMetadataRetriever();
        metaRetriever.setDataSource(termin.getPath());

        String out = "";
        String duration =
                metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        Log.v("time", duration);
        long dur = Long.parseLong(duration);
        String seconds = String.valueOf((dur % 60000) / 1000);

        Log.v("seconds", seconds);
        String minutes = String.valueOf(dur / 60000);
        out = minutes + ":" + seconds;
        if (seconds.length() == 1) {
            holder.trajanje.setText("0" + minutes + ":0" + seconds);
        }else {
            holder.trajanje.setText("0" + minutes + ":" + seconds);
        }
        Log.v("minutes", minutes);
        // close object
        metaRetriever.release();

        holder.avtor.setText("Neznan");
        holder.moj_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Predvajam: ",termin.getNaslov()+"");
            }
        });

        holder.moj_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(context, Uri.parse(termin.getPath()));
                mediaPlayer.start();
                //mpintro = MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/Music/intro.mp3"));
                //mpintro.setLooping(true);
                //mpintro.start();
            }
        });

    }

    @Override
    public int getItemCount() {
        if(itemList != null)
        {
            return itemList.size();
        }
        else
        {
            return 0;
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        //implements View.OnClickListener
        public ConstraintLayout moj_layout;
        public TextView naslov;
        public TextView avtor;
        public TextView trajanje;
        public ViewHolder(View itemView) {
            super(itemView);
            moj_layout = (ConstraintLayout)itemView.findViewById(R.id.main_lay);
            naslov = (TextView)itemView.findViewById(R.id.textView);
            avtor = (TextView)itemView.findViewById(R.id.textView2);
            trajanje = (TextView)itemView.findViewById(R.id.textView3);

        }
    }

}
