package com.sign.login.intercept

import android.content.Context
import android.text.TextUtils
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.sign.base.config.RouterConfig
import com.sign.componentbase.service.ServiceFactory
import java.lang.RuntimeException

/**
 * Created by CaoYongSheng
 * on 3/10/21
 *
 */
@Interceptor(priority = 1, name = "登陆拦截器")
class LoginInterceptor : IInterceptor {

    private lateinit var context: Context

    override fun init(context: Context) {
        // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        this.context = context
    }

    // onContinue 和 onInterrupt 至少需要调用其中一种，否则不会继续路由
    override fun process(postcard: Postcard, callback: InterceptorCallback) {
        if (TextUtils.equals(postcard.path, RouterConfig.SHARE_ACTIVITY)) {
            if (ServiceFactory.getInstance().getLoginService().isLogin()) {
                callback.onContinue(postcard)
            } else {
                // 中断路由流程
                callback.onInterrupt(RuntimeException("请先登陆"))
            }
        } else {
            // 处理完成，交还控制权
            callback.onContinue(postcard)
        }
    }
}