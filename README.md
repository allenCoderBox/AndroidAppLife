# AndroidAppLife
监听app前后台切换操作。


##操作说明
在项目build.gradle 中添加repositories
```groovy

 repositories {
        google()
        jcenter()
        maven { url 'https://github.com/allenCoderBox/AndroidAppLife/raw/master'}
 }

```



在主工程下的build.gradle中添加依赖地址


```groovy
implementation "maven.com.allen.cool:bfLib:0.0.2"

```

可以通过继承BfApp
```java

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




```



如果你已经继承了其他的Application

```java

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




```




