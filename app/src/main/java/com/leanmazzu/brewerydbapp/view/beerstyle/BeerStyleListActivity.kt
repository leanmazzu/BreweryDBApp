package com.leanmazzu.brewerydbapp.view.beerstyle

import android.os.Bundle
import android.support.v4.app.FragmentManager

import com.leanmazzu.brewerydbapp.R

import dagger.android.support.DaggerAppCompatActivity

const val BEER_STYLE_LIST_FRAGMENT_TAG = "beerStyleListFragment"

class BeerStyleListActivity : DaggerAppCompatActivity() {

    private var beerStyleListFragment: BeerStyleFragment? = null
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager
        beerStyleListFragment = fragmentManager.findFragmentByTag(BEER_STYLE_LIST_FRAGMENT_TAG) as? BeerStyleFragment

        if (beerStyleListFragment == null) {
            beerStyleListFragment = BeerStyleFragment.newInstance()
            beerStyleListFragment?.arguments = intent.extras
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, beerStyleListFragment, BEER_STYLE_LIST_FRAGMENT_TAG).commit()
        }
    }

    override fun onPause() {
        super.onPause()
        if (isFinishing) {
            supportFragmentManager.beginTransaction().remove(beerStyleListFragment).commit()
        }
    }

}
