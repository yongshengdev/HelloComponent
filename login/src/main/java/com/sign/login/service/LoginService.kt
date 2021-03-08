package com.sign.login.service

import android.text.TextUtils
import com.sign.componentbase.service.`interface`.ILoginService
import com.sign.login.manage.AccountManager

/**
 * Created by CaoYongSheng
 * on 3/8/21
 *
 */
class LoginService : ILoginService {

    override fun isLogin(): Boolean {
        return !TextUtils.isEmpty(AccountManager.accountId)
    }

    override fun getAccountId(): String? {
        return AccountManager.accountId
    }
}