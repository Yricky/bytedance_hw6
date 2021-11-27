package com.yricky.hw6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    val viewModel:MainActivityViewModel by lazy{
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    val adapter:PagerAdapter by lazy{
        object :PagerAdapter(){
            override fun getCount(): Int {
                return viewModel.imgList.value?.size ?: 0
            }

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                return super.instantiateItem(container, position)
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

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
        vpMain.adapter
    }
}