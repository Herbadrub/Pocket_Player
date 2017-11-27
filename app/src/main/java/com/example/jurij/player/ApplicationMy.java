package com.example.jurij.player;

import android.app.Application;
import android.os.Bundle;
import android.provider.ContactsContract;

import java.io.File;
import java.util.List;

/**
 * Created by Jurij on 13. 03. 2017.
 */

public class ApplicationMy extends Application {

    DataAll all;

    private static final String DATA_MAP = "pacientidatamap";
    private static final String FILE_NAME = "pacienti.json";

    @Override
    public void onCreate() {
        super.onCreate();
        //all = DataAll.scenarijA();
    }
    public boolean save() {

        File file = new File(this.getExternalFilesDir(DATA_MAP), ""
                + FILE_NAME);

        return ApplicationJson.save(all,file);
    }
    public boolean load(){
        File file = new File(this.getExternalFilesDir(DATA_MAP), ""
                + FILE_NAME);
        DataAll tmp = ApplicationJson.load(file);
        if (tmp!=null)
        {
            all = tmp;
        }
        else return false;
        return true;
    }
}
