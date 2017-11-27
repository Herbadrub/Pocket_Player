package com.example.jurij.player;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    ApplicationMy app;
    RecyclerView moj_recycler;
    final String MEDIA_PATH = Environment.getExternalStorageDirectory().getPath() + "/";
    ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    ArrayList<Song> moje_pesmi;
    String mp3Pattern = ".mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        moj_recycler = (RecyclerView)(findViewById(R.id.recycl_test));
        setSupportActionBar(toolbar);

        moje_pesmi= new ArrayList<Song>();
        getPlayList();
        costumizeSongList();
        for(int i=0;i<moje_pesmi.size();i++)
        {
            Song temp_song = new Song();
            temp_song=moje_pesmi.get(i);
            Log.e("PESEM: ",temp_song.getNaslov()+" | "+temp_song.getPath());
        }


        //moj_recycler = (RecyclerView)(findViewById(R.id.recycl_test));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        moj_recycler.setLayoutManager(manager);
        recycle_adapter adapter = new recycle_adapter(this,moje_pesmi);
        moj_recycler.setAdapter(adapter);
        moj_recycler.invalidate();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_play_lists) {
            Intent intent = new Intent(this, PlayListActivity.class);
            startActivity(intent);
        }else if (id == R.id.action_profile) {
            Intent intent = new Intent(this, ProfilActivity.class);
            startActivity(intent);
        }else if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }else if (id == R.id.action_logout) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<HashMap<String, String>> getPlayList(){
        System.out.println(MEDIA_PATH);
        if (MEDIA_PATH != null) {
            File home = new File(MEDIA_PATH);
            File[] listFiles = home.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    System.out.println(file.getAbsolutePath());
                    if (file.isDirectory()) {
                        scanDirectory(file);
                    } else {
                        addSongToList(file);
                    }
                }
            }
        }
        // return songs list array
        return songsList;
    }

    private void scanDirectory(File directory) {
        if (directory != null) {
            File[] listFiles = directory.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        scanDirectory(file);
                    } else {
                        addSongToList(file);
                    }

                }
            }
        }
    }

    private void addSongToList(File song) {
        if (song.getName().endsWith(mp3Pattern)) {
            HashMap<String, String> songMap = new HashMap<String, String>();
            songMap.put("songTitle",
                    song.getName().substring(0, (song.getName().length() - 4)));
            songMap.put("songPath", song.getPath());

            // Adding each song to SongList
            songsList.add(songMap);
        }
    }
    class FileExtensionFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            return (name.endsWith(".mp3") || name.endsWith(".MP3"));
        }
    }
    private void costumizeSongList ()
    {

        ArrayList<String> vse = new ArrayList<String>();
        for (int i=0;i<songsList.size();i++){

            for (Map.Entry<String, String> e : songsList.get(i).entrySet()) {
                e.getKey();
                e.getValue();


                vse.add(e.getValue());
            }

        }
        Song temp_song = new Song();
        for(int j=0;j<vse.size();j=j+2)
        {
            temp_song = new Song();
            temp_song.setPath(vse.get(j));
            temp_song.setNaslov(vse.get(j+1));
            moje_pesmi.add(temp_song);

        }
    }

}
