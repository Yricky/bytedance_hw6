package com.yricky.hw6

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Yricky
 * @date 2021/11/27
 */
class MainActivityViewModel:ViewModel() {
    val imgList:MutableLiveData<List<String>> by lazy {
        MutableLiveData(
            listOf(
                "https://img.nga.178.com/attachments/mon_202108/06/mhQ174-icc4ZdT1kSdw-dw.gif",
                "https://img.nga.178.com/attachments/mon_202111/24/mhQ17d-bpy1K1kT3cSjy-ez.jpg",
                "https://img.nga.178.com/attachments/mon_202111/24/mhQ17d-burjK25T3cSlb-mc.jpg"
            )
        )
    }
}