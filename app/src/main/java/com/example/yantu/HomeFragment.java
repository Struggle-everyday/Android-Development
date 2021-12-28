package com.example.yantu;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    private RecyclerView lvCardList;
    private List<Card> CardData;
    private CardAdapter adapter;
    private Context context = null;
    //home视图
    private View rootView;
    //card视图
    private View cardView;

    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        rootView = inflater.inflate(R.layout.home,
                container, false);
        cardView = inflater.inflate(R.layout.picture,
                container, false);
        //初始化布局
        initView();
        //初始化对象并保存数据
        initData();
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //初始化布局
    private void initView() {
        lvCardList = rootView.findViewById(R.id.lv_card_list);

//        lvCardList.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> adapterView,
//                                            View view, int i, long l) {
//
//                        Intent intent = new Intent(context,
//                                DetailActivity.class);
//
//                        Card Card = adapter.getItem(i);
//                        Log.d(TAG, "Card为: " + Card);
//                        intent.putExtra(Constants.Card_DETAIL_URL_KEY,
//                                Card.getContentUrl());
//                        intent.putExtra(Constants.GET_Card_KEY,
//                                Card);
//                        startActivity(intent);
//                    }
//                });

//        //下拉功能
//        swipe = rootView.findViewById(R.id.swipe);
//        swipe.setOnRefreshListener(
//                new SwipeRefreshLayout.OnRefreshListener() {
//                    @Override
//                    public void onRefresh() {
//                        downRefreshData();
//                    }
//                });
    }

//    //下拉刷新数据
//    private void downRefreshData() {
//        mPage++;
//        Log.d(TAG,"下拉刷新");
//        adapter.clear();
//        adapter.notifyDataSetChanged();
//        refreshData(mPage,source);
//        swipe.setRefreshing(false);
//    }


    //初始化对象并保存数据
    private void initData() {
        CardData = new ArrayList<>();
//        StaggeredGridLayoutManager layoutManager =
//                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager layoutManager = new GridLayoutManager(this.context,1);
        lvCardList.setLayoutManager(layoutManager);
        adapter = new CardAdapter(context, CardData);
        lvCardList.setAdapter(adapter);
        //获取首页卡片数据列表
        getCardData();
    }

    //从Bmob后台数据库，获取首页卡片数据
    private void getCardData() {
        BmobQuery<Card> query = new BmobQuery<>();
        //按照时间降序
        query.order("-createdAt");
        query.findObjects(new FindListener<Card>() {
            @Override
            public void done(List<Card> cardData, BmobException e) {
                if (e == null) {
                    adapter.setData(cardData);
                    adapter.notifyDataSetChanged();
                    //Snackbar.make(rootView, "查询成功：" + cardData.size(), Snackbar.LENGTH_LONG).show();
                } else {
                    Log.e("BMOB", e.toString());
                    //Snackbar.make(rootView, e.getMessage(), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}