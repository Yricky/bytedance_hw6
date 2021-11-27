package com.yricky.hw6

import android.app.Application

/**
 * @author Yricky
 * @date 2021/11/27
 */
class Hw6App:Application() {
    companion object{
        lateinit var inst:Hw6App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        inst = this
    }
}