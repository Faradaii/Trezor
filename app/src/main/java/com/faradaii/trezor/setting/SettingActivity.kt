package com.faradaii.trezor.setting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.faradaii.trezor.R
import com.faradaii.trezor.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, SettingFragment())
                .commit()
        }
    }
}