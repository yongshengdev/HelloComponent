package com.sign.card_export

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * Created by CaoYongSheng
 * on 3/12/21
 *
 * 定义对外提供的服务，需要继承IProvider
 */
interface ICardService : IProvider {

    fun getCardInfo(): CardInfo
}

// 购物车信息数据实体类
data class CardInfo(val count: Int) {
}