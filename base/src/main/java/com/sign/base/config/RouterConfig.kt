package com.sign.base.config

/**
 * Created by CaoYongSheng
 * on 3/10/21
 *
 */
object RouterConfig {

    private const val LOGIN = "/login"
    private const val SHARE = "/share"
    private const val HOME = "/home"

    const val LOGIN_ACTIVITY = "$LOGIN/LoginActivity"
    const val SHARE_ACTIVITY = "$SHARE/ShareActivity"
    const val HOME_ACTIVITY = "$HOME/HomeActivity"

    object Params {

        const val SHARE_TITLE = "shareTitle"
    }
}