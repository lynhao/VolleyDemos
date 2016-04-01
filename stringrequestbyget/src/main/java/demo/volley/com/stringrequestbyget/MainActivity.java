package demo.volley.com.stringrequestbyget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volleyGet();
    }

    /**
     *  new StringRequest(int method,String url,Listener listener,ErrorListener errorListener)
     *  method：请求方式，Get请求为Method.GET，Post请求为Method.POST
     *  url：请求地址
     *  listener：请求成功后的回调
     *  errorListener：请求失败的回调
     *
     */
    private void volleyGet() {
        String url = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=218.4.255.255";
//        StringRequest request = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String s) {//s为请求返回的字符串数据
//                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//                        Toast.makeText(MainActivity.this,volleyError.toString(),Toast.LENGTH_LONG).show();
//                    }
//                });
        /**
         *  new JsonObjectRequest(int method,String url,JsonObject jsonObject,Listener listener,ErrorListener errorListener)
         *  method：请求方式，Get请求为Method.GET，Post请求为Method.POST
         *  url：请求地址
         *  JsonObject：Json格式的请求参数。如果使用的是Get请求方式，请求参数已经包含在url中，所以可以将此参数置为null
         *  listener：请求成功后的回调
         *  errorListener：请求失败的回调
         */
//       JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//           @Override
//           public void onResponse(JSONObject jsonObject) {
//               Toast.makeText(MainActivity.this, jsonObject.toString(), Toast.LENGTH_LONG).show();
//           }
//       }, new Response.ErrorListener() {
//           @Override
//           public void onErrorResponse(VolleyError volleyError) {
//               Toast.makeText(MainActivity.this,volleyError.toString(),Toast.LENGTH_LONG).show();
//
//           }
//       });
        /**
         * JsonArrayRequest
         * params:url
         * params:Listen:
         * params:ErrorListen
         *
         */
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Toast.makeText(MainActivity.this, jsonArray.toString(), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this,volleyError.toString(),Toast.LENGTH_LONG).show();
            }
        });
        //设置请求的Tag标签，可以在全局请求队列中通过Tag标签进行请求的查找
        request.setTag("testGet");
        //将请求加入全局队列中
        MyApplication.getHttpQueues().add(request);
    }

}