package com.sign.componentbase.service.interf

/**
 * Created by CaoYongSheng
 * on 3/8/21
 *
 * 定义Login组件提供的服务
 */
interface ILoginService {

    fun isLogin(): Boolean

    fun getAccountId(): String?
}