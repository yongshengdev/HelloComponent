package com.sign.login.application

import android.app.Application
import com.sign.base.BaseApp
import com.sign.componentbase.service.ServiceFactory
import com.sign.login.service.LoginService

/**
 * Created by CaoYongSheng
 * on 3/8/21
 *
 * 组件application初始化的问题：
 *      但是一个项目只能有一个Application初始化，Login作为组件时，主模块的application会初始化，而LoginApp不会被初始化了
 *
 * 如何解决：
 *
 */
class LoginApp : BaseApp() {

    override fun initModule(application: Application) {
        ServiceFactory.getInstance().setLoginService(LoginService())
    }

    override fun hasInitAllModule(application: Application) {
    }

    override fun onCreate() {
        super.onCreate()
        // 向ServiceFactory中注册Login组件提供的服务实例
//        ServiceFactory.getInstance().setLoginService(LoginService())

        // 单独调试时，直接在LoginApp中初始化
//        initModule(this)
//        hasInitAllModule(this)
    }
}