package com.example.jurij.player;

/**
 * Created by Jurij on 20. 11. 2017.
 */

public class User_Data {
    private String user_ID;
    private String user_ime;
    private String user_priimek;

    public  User_Data(){
        this.user_ID="null";
        this.user_ime="null";
        this.user_priimek="null";
    }

    public User_Data(String idUser, String Ime, String Priimek, String pass,String telefonska,String mail) {
        this.user_ID = idUser;
        this.user_ime = Ime;
        this.user_priimek = Priimek;
    }
    public void setUser_ID(String ID){
        this.user_ID=ID;
    }
    public void setUser_ime(String Ime){
        this.user_ime=Ime;
    }
    public void setUser_priimek(String Priimek){
        this.user_priimek=Priimek;
    }
    public String getUser_ID(){
        return this.user_ID;
    }
    public String getUser_ime(){
        return this.user_ime;
    }
    public String getUser_priimek(){
        return this.user_priimek;
    }
    @Override
    public String toString(){
        return "\nUporabnik: "+this.user_ID+" - "+this.user_ime+" "+this.user_priimek;
    }
}
