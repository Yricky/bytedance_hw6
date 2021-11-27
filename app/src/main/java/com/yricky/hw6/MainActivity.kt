package com.yricky.hw6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import java.io.File

class MainActivity : AppCompatActivity() {
    val viewModel:MainActivityViewModel by lazy{
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    val adapter:PagerAdapter by lazy{
        object :PagerAdapter(){
            override fun getCount(): Int {
                return (viewModel.imgList.value?.size ?: 0) + 1
            }

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                return when(position){
                    in (viewModel.imgList.value!!.indices) ->{
                        ImageView(container.context).also {
                            container.addView(it)
                            GlideApp
                                .with(this@MainActivity)
                                .load(viewModel.imgList.value!![position])
                                .placeholder(R.drawable.ic_launcher_background)
                                .into(it)
                        }
                    }
                    else ->{
                        VideoView(container.context).also{
                            container.addView(it)
                            val f = File(externalCacheDir,"1.mkv")
                            if(!f.exists()){
                                f.writeBytes(assets.open("1.mkv").readBytes())
                            }
                            it.setMediaController(MediaController(container.context))

                            it.setVideoPath(f.path)
                        }
                    }
                }
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                container.removeView(`object` as View)
            }

            override fun isViewFromObject(view: View, `object`: Any): Boolean {
                return view == `object`
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val vpMain = findViewById<ViewPager>(R.id.vp_main)
        vpMain.adapter = adapter
    }
}