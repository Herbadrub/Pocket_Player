package com.example.jurij.player;
import java.util.ArrayList;
/**
 * Created by Jurij on 20. 11. 2017.
 */

public class DataAll {
private User_Data userMe;
private int flag;

public int getFlag() {
        return flag;
        }

public void setFlag(int flag) {
        this.flag = flag;
        }

public DataAll(){
        userMe = new User_Data();
        flag =0;
        }
//to je test
public User_Data getUserMe() {
        return userMe;
        }
public void setUserMe(User_Data userMe) {
        this.userMe = userMe;
        }

/*public static DataAll scenarijA()
        {
        DataAll da = new DataAll();
        }*/
}
