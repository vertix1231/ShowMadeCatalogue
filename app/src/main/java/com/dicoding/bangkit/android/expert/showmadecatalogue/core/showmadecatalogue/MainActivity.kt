package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.dicoding.bangkit.android.expert.showmadecatalogue.R
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.favorite.FavoriteFragment
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.home.HomeFragment
import com.dicoding.bangkit.android.expert.showmadecatalogue.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerMainLayout,
            binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerMainLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        var title = getString(R.string.app_name)
        when (item.itemId) {
            R.id.nav_home -> {
                fragment = HomeFragment()
                title = getString(R.string.app_name)
            }
            R.id.nav_favorite -> {
                fragment = FavoriteFragment()
                title = getString(R.string.menu_favorite)
            }
            R.id.nav_map -> {
                val uri = Uri.parse("madecataloguemapappp://maps")
                startActivity(Intent(Intent.ACTION_VIEW, uri))

                Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show()
            }
        }
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }
        supportActionBar?.title = title

        binding.drawerMainLayout.closeDrawer(GravityCompat.START)
        return true
    }
}