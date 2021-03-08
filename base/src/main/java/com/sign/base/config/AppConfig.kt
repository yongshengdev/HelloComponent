package com.sign.base.config

/**
 * Created by CaoYongSheng
 * on 3/8/21
 *
 * 配置组件application，供主工程application在onCreate时反射创建组件application，初始化组件
 */
class AppConfig {

    companion object {

        private const val LoginApp = "com.sign.login.application.LoginApp"

        @JvmStatic
        val moduleApp = arrayOf(LoginApp)
    }
}