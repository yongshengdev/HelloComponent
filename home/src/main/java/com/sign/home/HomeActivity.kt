package com.sign.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.sign.base.config.RouterConfig
import com.sign.card_export.CardExportUtils
import com.sign.home.databinding.ActivityHomeBinding

@Route(path = RouterConfig.HOME_ACTIVITY)
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGetCount.setOnClickListener {
            binding.tvCount.text = "购物车数量：${CardExportUtils.getCardInfo().count}"
        }

        binding.btnGetCardFragment.setOnClickListener {
            val fragment: Fragment = CardExportUtils.getCardFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.fl_container, fragment)
            transaction.commitAllowingStateLoss()
        }
    }
}