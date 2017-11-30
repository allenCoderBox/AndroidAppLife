package bg.coder.allen.com.appbackground;

import android.app.Application;
import android.os.Build;

import bg.coder.allen.com.bglib.OnAppRunStatusListener;
import bg.coder.allen.com.bglib.core.BgActivityLifeCallBack;

/**
 * Created by husongzhen on 17/11/30.
 */

public class NApp extends Application {
    private BgActivityLifeCallBack activityLifeCallBack = new BgActivityLifeCallBack();

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            registerActivityLifecycleCallbacks(activityLifeCallBack);
        }
    }


    public void registerAppLifeListener(OnAppRunStatusListener listener) {
        activityLifeCallBack.register(listener);
    }


    public void unRegisterAppLifeListener(OnAppRunStatusListener listener) {
        activityLifeCallBack.unRegister(listener);
    }

}
