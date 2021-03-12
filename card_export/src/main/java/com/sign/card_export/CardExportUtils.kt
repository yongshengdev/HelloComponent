package com.sign.card_export

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Created by CaoYongSheng
 * on 3/12/21
 *
 * 定义对外暴露的页面跳转、服务对象、及服务对象的方法
 */
class CardExportUtils {

    companion object {

        @JvmStatic
        fun openCardActivity() {
            ARouter.getInstance().build(CardRouteTable.ACTIVITY_CARD).navigation()
        }

        @JvmStatic
        fun getCardFragment(): Fragment {
            return ARouter.getInstance().build(CardRouteTable.FRAGMENT_CARD)
                .navigation() as Fragment
        }

        @JvmStatic
        fun getCardService(): ICardService {
            return ARouter.getInstance().build(CardRouteTable.SERVICE_CARD)
                .navigation() as ICardService
        }

        @JvmStatic
        fun getCardInfo(): CardInfo {
            return getCardService().getCardInfo()
        }
    }
}