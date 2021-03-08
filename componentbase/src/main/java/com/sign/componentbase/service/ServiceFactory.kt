package com.sign.componentbase.service

import com.sign.componentbase.service.`interface`.ILoginService
import com.sign.componentbase.service.empty.EmptyLoginService

/**
 * Created by CaoYongSheng
 * on 3/8/21
 *
 */
class ServiceFactory private constructor() {

    companion object {
        @Volatile
        private var serviceFactory: ServiceFactory? = null

        fun getInstance(): ServiceFactory {
            return serviceFactory ?: synchronized(this) {
                serviceFactory?.let {
                    return it
                }
                val instance = ServiceFactory()
                serviceFactory = instance
                instance
            }
        }
    }

    private var loginService: ILoginService? = null

    fun setLoginService(loginService: ILoginService) {
        this.loginService = loginService
    }

    fun getLoginService(): ILoginService {
        this.loginService?.let { return it }
        val loginService = EmptyLoginService()
        this.loginService = loginService
        return loginService
    }
}