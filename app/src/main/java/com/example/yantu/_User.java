package com.example.yantu;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

public class _User extends BmobUser {


    private String nickName;

    private BmobFile headPicture;

    private String imagePath;

    private String password_record;

    public String getPassword_record() {
        return password_record;
    }

    public void setPassword_record(String password_record) {
        this.password_record = password_record;
    }

    public BmobFile getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(BmobFile headPicture) {
        this.headPicture = headPicture;
    }

    public String getNickName() {

        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImagePath() {

        return imagePath;
    }

    public void setImagePath(String imagePath) {

        this.imagePath = imagePath;
    }
}
