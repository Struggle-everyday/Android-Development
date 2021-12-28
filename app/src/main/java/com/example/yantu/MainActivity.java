package com.example.yantu;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout bottom_bar_1_btn;
    private TextView bottom_bar_text_1;
    private ImageView bottom_bar_image_1;
    private RelativeLayout bottom_bar_2_btn;
    private TextView bottom_bar_text_2;
    private ImageView bottom_bar_image_2;
    private RelativeLayout bottom_bar_3_btn;
    private TextView bottom_bar_text_3;
    private ImageView bottom_bar_image_3;
    private RelativeLayout bottom_bar_4_btn;
    private TextView bottom_bar_text_4;
    private ImageView bottom_bar_image_4;

    //Fragment页面
    private HomeFragment mHomeFragment;
    private AddFragment mAddFragment;
    private MyFragment mMyFragment;
    private CloudFragment mCloudFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(this, "3303c01552f8329718ae5a364ff1b782");
        //初始化页面
        initView();
        //设置开始页面
        setMain();
    }

    //实例化
    private void initView(){
        //底部导航栏
        //来自activity_main.xml
        RelativeLayout main_body = findViewById(R.id.main_body);
        //包含底部
        LinearLayout main_bottom_bar = findViewById(R.id.main_bottom_bar);

        //首页
        bottom_bar_1_btn=findViewById(R.id.bottom_bar_1_btn);
        bottom_bar_text_1=findViewById(R.id.bottom_bar_text_1);
        bottom_bar_image_1=findViewById(R.id.bottom_bar_image_1);
        //添加点击事件
        bottom_bar_1_btn.setOnClickListener(this);

        //发布
        bottom_bar_2_btn=findViewById(R.id.bottom_bar_2_btn);
        bottom_bar_text_2=findViewById(R.id.bottom_bar_text_2);
        bottom_bar_image_2=findViewById(R.id.bottom_bar_image_2);
        //添加点击事件
        bottom_bar_2_btn.setOnClickListener(this);

        //我的
        bottom_bar_3_btn=findViewById(R.id.bottom_bar_3_btn);
        bottom_bar_text_3=findViewById(R.id.bottom_bar_text_3);
        bottom_bar_image_3=findViewById(R.id.bottom_bar_image_3);
        //添加点击事件
        bottom_bar_3_btn.setOnClickListener(this);

        //个人动态
        bottom_bar_4_btn=findViewById(R.id.bottom_bar_4_btn);
        bottom_bar_text_4=findViewById(R.id.bottom_bar_text_4);
        bottom_bar_image_4=findViewById(R.id.bottom_bar_image_4);
        //添加点击事件
        bottom_bar_4_btn.setOnClickListener(this);

        //Fragment页面
        mHomeFragment = new HomeFragment();
        mAddFragment = new AddFragment();
        mMyFragment = new MyFragment();
        mCloudFragment = new CloudFragment();

    }
    //点击Button切换状态
    private void setSelectStatus(int index) {
        switch (index){
            case 0:
                //图片点击选择变换图片，颜色的改变，其他变为原来的颜色，并保持原有的图片
                initButton(bottom_bar_1_btn);
                bottom_bar_image_1.setImageResource(R.drawable.dynamic);
                bottom_bar_text_1.setTextColor( getResources().getColor(R.color.purple_200) );
                //其他的文本颜色不变
                bottom_bar_text_2.setTextColor(getResources().getColor(R.color.wenzi));
                bottom_bar_text_3.setTextColor(getResources().getColor(R.color.wenzi));
                bottom_bar_text_4.setTextColor(getResources().getColor(R.color.wenzi));
                //图片也不变
                bottom_bar_image_2.setImageResource(R.drawable.add);
                bottom_bar_image_3.setImageResource(R.drawable.yun);
                bottom_bar_image_4.setImageResource(R.drawable.my);
                break;

            case 1://同理如上
                //图片点击选择变换图片，颜色的改变，其他变为原来的颜色，并保持原有的图片
                initButton(bottom_bar_2_btn);
                bottom_bar_image_2.setImageResource(R.drawable.add);
                bottom_bar_text_2.setTextColor( getResources().getColor(R.color.purple_200) );
                //其他的文本颜色不变
                bottom_bar_text_1.setTextColor(getResources().getColor(R.color.wenzi));
                bottom_bar_text_3.setTextColor(getResources().getColor(R.color.wenzi));
                bottom_bar_text_4.setTextColor(getResources().getColor(R.color.wenzi));
                //图片也不变
                bottom_bar_image_1.setImageResource(R.drawable.dynamic);
                bottom_bar_image_3.setImageResource(R.drawable.yun);
                bottom_bar_image_4.setImageResource(R.drawable.my);
                break;

            case 2://同理如上
                //图片点击选择变换图片，颜色的改变，其他变为原来的颜色，并保持原有的图片
                initButton(bottom_bar_3_btn);
                bottom_bar_image_3.setImageResource(R.drawable.yun);
                bottom_bar_text_3.setTextColor( getResources().getColor(R.color.purple_200) );
                //其他的文本颜色不变
                bottom_bar_text_1.setTextColor(getResources().getColor(R.color.wenzi));
                bottom_bar_text_2.setTextColor(getResources().getColor(R.color.wenzi));
                bottom_bar_text_4.setTextColor(getResources().getColor(R.color.wenzi));
                //图片也不变
                bottom_bar_image_1.setImageResource(R.drawable.dynamic);
                bottom_bar_image_2.setImageResource(R.drawable.add);
                bottom_bar_image_4.setImageResource(R.drawable.my);
                break;

            case 3://同理如上
                //图片点击选择变换图片，颜色的改变，其他变为原来的颜色，并保持原有的图片
                initButton(bottom_bar_4_btn);
                bottom_bar_image_4.setImageResource(R.drawable.my);
                bottom_bar_text_4.setTextColor( getResources().getColor(R.color.purple_200) );
                //其他的文本颜色不变
                bottom_bar_text_1.setTextColor(getResources().getColor(R.color.wenzi));
                bottom_bar_text_2.setTextColor(getResources().getColor(R.color.wenzi));
                bottom_bar_text_3.setTextColor(getResources().getColor(R.color.wenzi));
                //图片也不变
                bottom_bar_image_1.setImageResource(R.drawable.dynamic);
                bottom_bar_image_2.setImageResource(R.drawable.add);
                bottom_bar_image_3.setImageResource(R.drawable.yun);
                break;
        }
    }

    //按钮特效
    private void initButton(RelativeLayout bt){
        Animation animation=new AlphaAnimation(1.0f,0.0f);
        animation.setDuration(300);
        bt.startAnimation(animation);
    }

    //重写底部导航栏的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bottom_bar_1_btn:
                //切换Fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,mHomeFragment).commit();
                setSelectStatus(0);
                break;
            case R.id.bottom_bar_2_btn:
                //切换Fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,mAddFragment).commit();
                setSelectStatus(1);
                break;
            case R.id.bottom_bar_3_btn:
                //切换Fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,mCloudFragment).commit();
                setSelectStatus(2);
                break;
            case R.id.bottom_bar_4_btn:
                //切换Fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.main_body,mMyFragment).commit();
                setSelectStatus(3);
                break;
        }
    }

    //用于打开初始页面
    private void setMain() {
        //默认进入首页
        setSelectStatus(0);
        this.getSupportFragmentManager().beginTransaction().add(R.id.main_body,mHomeFragment).commit();
    }

}