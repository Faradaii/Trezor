package com.faradaii.trezor.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.faradaii.trezor.di.favoriteModule
import com.faradaii.trezor.favorite.databinding.ActivityFavoriteBinding
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        supportActionBar?.title = "Favorite"

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, FavoriteFragment())
                .commit()
        }
    }
}