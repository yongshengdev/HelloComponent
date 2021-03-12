package com.sign.card

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.sign.card_export.CardRouteTable

/**
 * Created by CaoYongSheng
 * on 3/12/21
 *
 */
@Route(path = CardRouteTable.FRAGMENT_CARD)
class CardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.card_fragment_card, container, false)
    }

}