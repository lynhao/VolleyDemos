package demo.volley.com.stringrequestbyget;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by linhao on 16/4/1.
 */
public class MyApplication extends Application {
    //首先创建一个全局的请求队列
    private static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getHttpQueues(){
        return queue;
    }
}
