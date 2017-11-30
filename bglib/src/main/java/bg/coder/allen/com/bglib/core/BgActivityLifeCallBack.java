package bg.coder.allen.com.bglib.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;

import bg.coder.allen.com.bglib.OnAppRunStatusListener;

/**
 * Created by husongzhen on 17/11/29.
 */

public class BgActivityLifeCallBack implements Application.ActivityLifecycleCallbacks {


    private ArrayList<OnAppRunStatusListener> listeners = new ArrayList<>();


    public void register(OnAppRunStatusListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }


    public void unRegister(OnAppRunStatusListener listener) {
        if (listener != null) {
            listeners.remove(listener);
        }
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        if (AppStatus.isForeground(activity)) {
            for (OnAppRunStatusListener l : listeners) {
                l.onForegroundListener();
            }
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        if (AppStatus.isBackground(activity)) {
            for (OnAppRunStatusListener l : listeners) {
                l.onBackgroundListener();
            }
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
