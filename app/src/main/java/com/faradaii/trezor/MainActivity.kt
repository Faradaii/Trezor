package com.faradaii.trezor

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.faradaii.trezor.databinding.ActivityMainBinding
import com.faradaii.trezor.home.HomeFragment
import com.faradaii.trezor.setting.SettingActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        drawerLayout = binding.drawerLayout

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            binding.appBar.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, HomeFragment())
                .commit()
            supportActionBar?.title = getString(R.string.app_name)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        var fragment: Fragment? = null
        var title = getString(R.string.app_name)
        when (item.itemId) {
            R.id.nav_home -> {
                fragment = HomeFragment()
                title = getString(R.string.app_name)
            }

            R.id.nav_setting -> {
                val intent = Intent(this, SettingActivity::class.java)
                startActivity(intent)
            }

            R.id.nav_favorite -> {
                val uri = Uri.parse("trezor://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }
        supportActionBar?.title = title
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}