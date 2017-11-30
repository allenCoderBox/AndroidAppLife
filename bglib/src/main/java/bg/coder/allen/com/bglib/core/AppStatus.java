package bg.coder.allen.com.bglib.core;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Created by husongzhen on 17/11/29.
 */

public class AppStatus {


    public static final boolean isBackground(Context context) {
        return !isForeground(context);
    }

    public static final boolean isForeground(Context context) {
        String packageName = context.getPackageName();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (packageName.equals("") | packageName == null) {
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager
                .getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo runinfo : runningAppProcesses) {
            String pn = runinfo.processName;
            if (pn.equals(packageName)
                    && runinfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }


}
