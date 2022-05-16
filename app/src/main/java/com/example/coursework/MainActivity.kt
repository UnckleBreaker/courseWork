package com.example.coursework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.coursework.baseFragments.EpisodesFragment
import com.example.coursework.baseFragments.LocationFragment
import com.example.coursework.baseFragments.СharactersFragment
import com.example.coursework.deatailsFragments.DetailsCharactersFragment
import com.example.coursework.deatailsFragments.DetailsEpisodesFragment
import com.example.coursework.deatailsFragments.DetailsLocationsFragment
import com.example.coursework.listeners.CharacterClickListener
import com.example.coursework.listeners.EpisodeClickListener
import com.example.coursework.listeners.LocationClickListener
import com.example.coursework.listeners.LocationItemClickListener
import com.example.coursework.model.DetailsCharacterFragmentArguments
import com.example.coursework.model.DetailsLocationFragmentArguments
import com.example.coursework.model.character.ResultCharacter
import com.example.coursework.model.episode.ResultEpisode
import com.example.coursework.model.location.ResultLocation
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CharacterClickListener, EpisodeClickListener,
    LocationItemClickListener, LocationClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CourseWork)
        setContentView(R.layout.activity_main)
        replaceFragment(СharactersFragment.newInstance())
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        bottom_nav.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.menu_charactes -> replaceFragment(СharactersFragment.newInstance())
                    R.id.menu_episods -> replaceFragment(EpisodesFragment.newInstance())
                    R.id.menu_locations -> replaceFragment(LocationFragment.newInstance())
                }
                return true
            }
        })
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            when (fragment) {
                is СharactersFragment -> title = "Characters"
                is EpisodesFragment -> title = "Episodes"
                is LocationFragment -> title = "Locations"
                is DetailsCharactersFragment -> {
                    title = "DetailsCharacter"
                    addToBackStack(DetailsCharactersFragment.DETAILS_FRAGMENT_TAG)
                }
                is DetailsEpisodesFragment -> {
                    title = "DetailsEpisode"
                    addToBackStack(DetailsEpisodesFragment.DETAILS_EPISODE_FRAGMENT_TAG)
                }
                is DetailsLocationsFragment -> {
                    title = "DetailsLocation"
                    addToBackStack(DetailsLocationsFragment.DETAILS_LOCATIONS_FRAGMENT_TAG)
                }

            }
            replace(R.id.frame, fragment)
            commit()
        }
    }

    override fun onClick(tag: String, item: ResultCharacter) {
        replaceFragment(DetailsCharactersFragment.newInstance(DetailsCharacterFragmentArguments(item,this)))
    }

    override fun onEpisodeClick(item: ResultEpisode) {
        replaceFragment(DetailsEpisodesFragment.newInstance(item))
    }

    override fun onLocationItemClick(item: ResultLocation) {
        replaceFragment(DetailsLocationsFragment.newInstance(DetailsLocationFragmentArguments(null,item)))
    }

    override fun onLocationClick(url: String) {
        replaceFragment(DetailsLocationsFragment.newInstance(DetailsLocationFragmentArguments(url,null)))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}