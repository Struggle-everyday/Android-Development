package com.example.yantu;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.loader.content.CursorLoader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;

public class CloudFragment extends Fragment  {

    private RelativeLayout like;
    private RelativeLayout send;
    private RelativeLayout share;
    private Context mContext = null;
    private View rootView;
    private LikeFragment lFragment;
    private PublishFragment pFragment;
    private ShareFragment sFragment;


    public CloudFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mContext = getActivity();
        rootView = inflater.inflate(R.layout.cloud, container, false);
        like=rootView.findViewById(R.id.like);
        send=rootView.findViewById(R.id.send);
        share=rootView.findViewById(R.id.share);
        lFragment=new LikeFragment();
        pFragment=new PublishFragment();
        sFragment=new ShareFragment();

        //我喜欢的
        like.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_body,lFragment).commit();
            }
        });

        //我发布的
        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_body,pFragment).commit();
            }
        });


        //我分享的
        share.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_body,sFragment).commit();
            }
        });
        return rootView;
    }
}