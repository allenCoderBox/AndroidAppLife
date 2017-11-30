package bg.coder.allen.com.bglib;

/**
 * 监听应用是前台还是后台运行
 *
 * @author husongzhen
 * @date 17/11/29
 */

public interface OnAppRunStatusListener {
    void onBackgroundListener();

    void onForegroundListener();
}
