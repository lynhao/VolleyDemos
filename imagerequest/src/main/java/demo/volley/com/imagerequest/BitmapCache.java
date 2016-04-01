package demo.volley.com.imagerequest;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by linhao on 16/4/1.
 */
public class BitmapCache implements ImageLoader.ImageCache {
    //LruCache是基于内存的缓存类
    private LruCache<String,Bitmap> lruCache;
    //LruCache的最大缓存大小
    private int max= 10 * 1024 *1024;
    public BitmapCache(){
        lruCache = new LruCache<String,Bitmap>(max){
            //缓存图片的大小

            @Override
            protected int sizeOf(String key, Bitmap value) {
                //getRowBytes ->返回位图像素中行之间的字节数
                return value.getRowBytes() * value.getHeight();
            }
        };
    }


    @Override
    public Bitmap getBitmap(String s) {
        return lruCache.get(s);
    }

    @Override
    public void putBitmap(String s, Bitmap bitmap) {
        lruCache.put(s,bitmap);
    }
}
