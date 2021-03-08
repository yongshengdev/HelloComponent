package com.sign.base

import android.app.Application

/**
 * Created by CaoYongSheng
 * on 3/8/21
 *
 */
abstract class BaseApp : Application() {

    /**
     * 组件application初始化
     */
    abstract fun initModule(application: Application)

    /**
     * 所有组件application初始化后的自定义操作
     */
    abstract fun hasInitAllModule(application: Application)
}