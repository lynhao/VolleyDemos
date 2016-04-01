package demo.volley.com.bypost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volleyPost();


    }
    private void volleyPost(){
        String url = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this,volleyError.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
//            重写Request类的getParams()方法将请求参数名和参数值放入Map中进行传递。
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("tel","15914506683");
                return map;
            }
        };

        /**
         * 使用Post方式请求数据返回JsonObject对象
         */
//        String url = "http://www.kuaidi100.com/query";
//        Map<String,String> map = new HashMap<>();
//        map.put("type","yuantong");
//        map.put("postid","229728279823");
//        //将map转化为JSONObject对象
//        JSONObject json = new JSONObject(map);
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, json,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject jsonObject) {//jsonObject为请求返回的Json格式数据
//                        Toast.makeText(MainActivity.this,jsonObject.toString(),Toast.LENGTH_LONG).show();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//                        Toast.makeText(MainActivity.this,volleyError.toString(),Toast.LENGTH_LONG).show();
//                    }
//                });
        request.setTag("testpost");
        MyApplication.getHttpRequestQueue().add(request);
    }

    /**
     * 在Activity关闭时取消请求队列中的请求。
     */
    @Override
    protected void onStop() {
        super.onStop();
        //通过Tag标签取消请求队列中对应的全部请求
        MyApplication.getHttpRequestQueue().cancelAll("abcGet");
    }
}
