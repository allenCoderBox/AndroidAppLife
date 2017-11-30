package bg.coder.allen.com.appbackground;

import android.util.Log;

import bg.coder.allen.com.bglib.BfApp;
import bg.coder.allen.com.bglib.OnAppRunStatusListener;

/**
 * Created by husongzhen on 17/11/29.
 */

public class App extends BfApp implements OnAppRunStatusListener {


    @Override
    public void onCreate() {
        super.onCreate();

        registerAppLifeListener(this);
    }

    @Override
    public void onBackgroundListener() {


        Log.e(getClass().getName(), "bg");


    }

    @Override
    public void onForegroundListener() {
        Log.e(getClass().getName(), "onForegroundListener");
    }
}
