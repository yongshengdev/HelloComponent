package com.sign.hellocomponent.application

import android.app.Application
import com.sign.base.BaseApp
import com.sign.base.config.AppConfig

/**
 * Created by CaoYongSheng
 * on 3/8/21
 *
 */
class MainApplication : BaseApp() {

    override fun onCreate() {
        super.onCreate()
        // 初始化application
        initModule(this)
        // ... 其它操作
        // 所有application都初始化后的自定义操作
        hasInitAllModule(this)
    }

    override fun initModule(application: Application) {
        for (name in AppConfig.moduleApp) {
            try {
                val moduleClass = Class.forName(name)
                val instance: BaseApp = moduleClass.newInstance() as BaseApp
                instance.initModule(this)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            }
        }
    }

    override fun hasInitAllModule(application: Application) {
        for (name in AppConfig.moduleApp) {
            try {
                val moduleClass = Class.forName(name)
                val instance: BaseApp = moduleClass.newInstance() as BaseApp
                instance.hasInitAllModule(this)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            }
        }
    }

}