package com.maolv.tmall.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.maolv.tmall.R;
import com.maolv.tmall.adapter.GoodsAdapter;
import com.maolv.tmall.bean.CycleImageInfo;
import com.maolv.tmall.bean.GoodInfo;
import com.maolv.tmall.data.GoodsInfoRepository;
import com.maolv.tmall.view.imageCycleView.ImageCycleView;
import com.maolv.tmall.view.imageCycleView.LoadImageCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhujingling on 16/5/8.
 */
public class HomepageFragment extends Fragment {

    private ImageCycleView mImageCycleView;
    private List<CycleImageInfo> cycleImageInfoList;

    private ListView hotGoodsListView;
    private List<GoodInfo> goodInfoList;
    private GoodsAdapter goodsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepahe_fragment, container, false);
        try {
            mImageCycleView = (ImageCycleView) view.findViewById(R.id.icv_topView);
            hotGoodsListView = (ListView) view.findViewById(R.id.hotgoogs_listview);
            initControl(view);

            goodsAdapter = new GoodsAdapter(getContext(), goodInfoList);
            hotGoodsListView.setAdapter(goodsAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    private void initControl(View view) {
        cycleImageInfoList = new ArrayList<CycleImageInfo>();
        goodInfoList = GoodsInfoRepository.getGoodInfoList();

        //res图片资源
        cycleImageInfoList.add(new CycleImageInfo(R.drawable.raw_1460973761, "", ""));
        cycleImageInfoList.add(new CycleImageInfo(R.drawable.raw_1460973779, "", ""));
        cycleImageInfoList.add(new CycleImageInfo(R.drawable.raw_1460973852, "", ""));
        cycleImageInfoList.add(new CycleImageInfo(R.drawable.raw_1460973871, "", ""));

//		mImageCycleView.setAutoCycle(false); //关闭自动播放
//		mImageCycleView.setCycleDelayed(2000);//设置自动轮播循环时间
//
//		mImageCycleView.setIndicationStyle(ImageCycleView.IndicationStyle.COLOR,
//				Color.BLUE, Color.RED, 1f);

//		mImageCycleView.setIndicationStyle(ImageCycleView.IndicationStyle.IMAGE,
//				R.drawable.dian_unfocus, R.drawable.dian_focus, 1f);

//		Log.e("eee", Environment.getExternalStorageDirectory().getPath()+ File.separator+"a1.jpg");


        //SD卡图片资源
//		cycleImageInfoList.add(new ImageCycleView.ImageInfo(new File(Environment.getExternalStorageDirectory(),"a1.jpg"),"11111",""));
//		cycleImageInfoList.add(new ImageCycleView.ImageInfo(new File(Environment.getExternalStorageDirectory(),"a2.jpg"),"22222",""));
//		cycleImageInfoList.add(new ImageCycleView.ImageInfo(new File(Environment.getExternalStorageDirectory(),"a3.jpg"),"33333",""));


        //使用网络加载图片
//		cycleImageInfoList.add(new ImageCycleView.ImageInfo("http://img.lakalaec.com/ad/57ab6dc2-43f2-4087-81e2-b5ab5681642d.jpg","11","eeee"));
//		cycleImageInfoList.add(new ImageCycleView.ImageInfo("http://img.lakalaec.com/ad/cb56a1a6-6c33-41e4-9c3c-363f4ec6b728.jpg","222","rrrr"));
//		cycleImageInfoList.add(new ImageCycleView.ImageInfo("http://img.lakalaec.com/ad/e4229e25-3906-4049-9fe8-e2b52a98f6d1.jpg", "333", "tttt"));

//		mImageCycleView.setOnPageClickListener(new ImageCycleView.OnPageClickListener() {
//			@Override
//			public void onClick(View imageView, ImageCycleView.ImageInfo imageInfo) {
//				Toast.makeText(MainActivity.this, "你点击了" + imageInfo.value.toString(), Toast.LENGTH_SHORT).show();
//			}
//		});

        mImageCycleView.loadData(cycleImageInfoList, new LoadImageCallBack() {


            @Override
            public ImageView loadAndDisplay(CycleImageInfo cycleImageInfo) {

                //本地图片
                ImageView imageView = new ImageView(getActivity());
                imageView.setImageResource(Integer.parseInt(cycleImageInfo.image.toString()));
                return imageView;


//				//使用SD卡图片
//				SmartImageView smartImageView=new SmartImageView(MainActivity.this);
//				smartImageView.setImageURI(Uri.fromFile((File)imageInfo.image));
//				return smartImageView;

//				//使用SmartImageView，既可以使用网络图片也可以使用本地资源
//				SmartImageView smartImageView=new SmartImageView(MainActivity.this);
//				smartImageView.setImageResource(Integer.parseInt(imageInfo.image.toString()));
//				return smartImageView;

                //使用BitmapUtils,只能使用网络图片
//				BitmapUtils bitmapUtils = new BitmapUtils(MainActivity.this);
//				ImageView imageView = new ImageView(MainActivity.this);
//				bitmapUtils.display(imageView, imageInfo.image.toString());
//				return imageView;


            }
        });
    }
}
