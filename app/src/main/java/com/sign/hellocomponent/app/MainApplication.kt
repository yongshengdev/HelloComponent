package com.sign.hellocomponent.app

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.sign.base.BaseApp
import com.sign.base.config.AppConfig
import com.sign.hellocomponent.BuildConfig

/**
 * Created by CaoYongSheng
 * on 3/8/21
 *
 */
class MainApplication : BaseApp() {

    override fun onCreate() {
        super.onCreate()
        // 初始化 ARouter
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        // 初始化 ARouter
        ARouter.init(this);

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