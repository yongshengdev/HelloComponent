package com.sign.componentbase.service.empty

import com.sign.componentbase.service.interf.ILoginService

/**
 * Created by CaoYongSheng
 * on 3/8/21
 *
 * ILoginService的空实现，避免调试时实现类对象为空引起的异常
 */
class EmptyLoginService : ILoginService {

    override fun isLogin(): Boolean {
        return false
    }

    override fun getAccountId(): String? {
        return null
    }
}