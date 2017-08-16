package me.moreshare.wordmap.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import me.moreshare.wordmap.R;
import me.moreshare.wordmap.fragment.FragmentNews;
import me.moreshare.wordmap.fragment.FragmentMine;
import me.moreshare.wordmap.fragment.FragmentSport;
import me.moreshare.wordmap.view.MainBottomView;
import com.orhanobut.logger.Logger;

/**
 * 主页面
 * Created by liuheng on 16/7/12.
 */
public class ActivityMain extends me.moreshare.wordmap.activity.BaseActivity {

    private static final String FRAGMENT_BASE_TAG = "base_fragment";

    private MainBottomView mBottomView;

    private int mSelectPosition = 0;

    private MainBottomView.OnBottomChooseListener mBottomChooseListener = new BottomChooseListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        selectPositionFragment(mSelectPosition);
    }

    private void initView() {
        mBottomView = (MainBottomView) findViewById(R.id.main_bottom_tab);
        mBottomView.setBottomCLickListener(mBottomChooseListener);
    }

    //初始化一个Fragment，并将其添加到指定位置
    private void initFragment(int position){

        Fragment fragment;
        switch (position){

            case 0:
                fragment = new FragmentNews();
                break;

            case 1:
                fragment = new FragmentSport();
                break;

            default:
                fragment = new FragmentMine();
                break;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.main_content_ll,fragment,getFragmentTagByPosition(position)).commit();
    }

    //得到指定Tag的Fragment
    private Fragment getFragmentByTag(int position){
        return  getSupportFragmentManager().findFragmentByTag(getFragmentTagByPosition(position));
    }

    //得到每个Fragment对应的tag
    private String getFragmentTagByPosition(int position){
        return FRAGMENT_BASE_TAG + position;
    }

    private void selectPositionFragment(int position){
        Fragment selectFragment = getFragmentByTag(position);

        if (selectFragment == null){
            initFragment(position);
        } else {
            getSupportFragmentManager().beginTransaction().show(selectFragment).commit();
        }
    }


    private class BottomChooseListener implements MainBottomView.OnBottomChooseListener {

        @Override
        public void onClick(int oldPosition, int selectPosition) {

            Fragment nowFragment = getFragmentByTag(oldPosition);
            getSupportFragmentManager().beginTransaction().hide(nowFragment).commit();
            selectPositionFragment(selectPosition);

            mSelectPosition = selectPosition;
        }
    }


}
