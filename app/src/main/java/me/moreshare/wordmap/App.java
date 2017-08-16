package me.moreshare.wordmap;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import me.moreshare.wordmap.model.User;
import me.moreshare.wordmap.model.network.HttpClient;
import com.orhanobut.logger.Logger;

/**
 * 程序的Application对象
 * Created by liuheng on 16/6/7.
 */
public class App extends Application{

    private static final String TAG_NAME = "MY_TAG";

    @Override
    public void onCreate() {
        super.onCreate();

        //可以在Application对象中初始化一些类库

        Logger.init(TAG_NAME);
        HttpClient.init(this);

        User.init(getApplicationContext());

        SDKInitializer.initialize(getApplicationContext());
    }
}
