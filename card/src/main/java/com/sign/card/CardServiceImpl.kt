package com.sign.card

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.sign.card_export.CardInfo
import com.sign.card_export.CardRouteTable
import com.sign.card_export.ICardService

/**
 * Created by CaoYongSheng
 * on 3/12/21
 *
 * 实现组件对外提供的服务，并配置对应路由
 */
@Route(path = CardRouteTable.SERVICE_CARD)
class CardServiceImpl : ICardService {

    override fun getCardInfo(): CardInfo {
        return CardInfo(666)
    }

    override fun init(context: Context?) {

    }
}