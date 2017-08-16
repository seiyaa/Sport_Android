package me.moreshare.wordmap.floatview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by jiangjunhou on 2017-8-16.
 */

public class FloatingManager {
    private static final String TAG = "FloatingManager";
    private WindowManager windowManger;
    private static FloatingManager instance;
    private Context context;

    public static FloatingManager getInstance(Context context) {
         if(instance == null) {
             instance = new FloatingManager(context);
         }
         return instance;
    }

    private FloatingManager(Context context) {
        context = context;
        windowManger = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }

    protected boolean addView(View view, WindowManager.LayoutParams params) {
        try{
            windowManger.addView(view, params);
            return true;
        } catch (Exception e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
        return false;
    }

    protected boolean removeView(View view) {
        try{
            windowManger.removeView(view);
            return true;
        } catch (Exception e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
        return false;
    }
    protected boolean updateView(View view, WindowManager.LayoutParams params) {
        try{
            windowManger.updateViewLayout(view, params);
            return true;
        } catch (Exception e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
        return false;
    }
}
