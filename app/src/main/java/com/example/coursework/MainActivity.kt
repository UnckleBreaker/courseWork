package com.example.coursework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.coursework.baseFragments.EpisodesFragment
import com.example.coursework.baseFragments.LocationFragment
import com.example.coursework.baseFragments.СharactersFragment
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CourseWork)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().run {
            replace(R.id.frame, СharactersFragment.newInstance())
            commit()
        }
        bottom_nav.setOnItemSelectedListener(object :NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.menu_charactes -> replaceFragment(СharactersFragment.newInstance())
                    R.id.menu_episods->replaceFragment(EpisodesFragment.newInstance())
                    R.id.menu_locations->replaceFragment(LocationFragment.newInstance())
                }
                return true
            }
        })
    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame, fragment)
            commit()
        }
    }
}