package com.yricky.hw6;

/**
 * @author Yricky
 * @date 2021/11/27
 */

import android.app.ActivityManager;
import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;


/**
 * @author Yricky
 * @date 2021/7/25 下午10:53
 */
@com.bumptech.glide.annotation.GlideModule
public class GlideModule extends AppGlideModule {
    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        //        设置缓存大小为20mb
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (am != null) {
            int memoryCacheSize = 1024 * 1024 * am.getMemoryClass() / 3;
            builder.setMemoryCache(new LruResourceCache(memoryCacheSize));
        }
        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.format(DecodeFormat.PREFER_ARGB_8888);
        builder.setDefaultRequestOptions(requestOptions);
        int diskCacheSizeBytes = 1024 * 1024 * 32; // 32mb
        builder.setDiskCache(new DiskLruCacheFactory(
                Hw6App.Companion.getInst().getExternalFilesDir("glideLruCache").getPath(),
                diskCacheSizeBytes));

    }
}