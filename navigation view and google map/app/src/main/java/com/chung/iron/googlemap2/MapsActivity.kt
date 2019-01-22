package com.chung.iron.googlemap2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import android.support.design.widget.BottomNavigationView
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.view.MenuItem
import android.R.attr.fragment
import com.chung.iron.googlemap2.fragments.ShopFragment
import android.R.attr.fragment
import com.chung.iron.googlemap2.fragments.CartFragment
import com.chung.iron.googlemap2.fragments.GiftsFragment
import com.chung.iron.googlemap2.fragments.ProfileFragment


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private var toolbar: ActionBar? = null
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.frame_container) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // navigation view
        toolbar = supportActionBar

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        toolbar?.setTitle("Shop")
    }

    // navigation view
    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            val fragment: Fragment
            when (item.getItemId()) {
                R.id.navigation_shop -> {
                    toolbar?.setTitle("Shop")
                    fragment = ShopFragment()
                    loadFragment(fragment)
                    return true
                }
                R.id.navigation_gifts -> {
                    toolbar?.setTitle("My Gifts")
                    fragment = GiftsFragment()
                    loadFragment(fragment)
                    return true
                }
                R.id.navigation_cart -> {
                    toolbar?.setTitle("Cart")
                    fragment = CartFragment()
                    loadFragment(fragment)
                    return true
                }
                R.id.navigation_profile -> {
                    toolbar?.setTitle("Profile")
                    fragment = ProfileFragment()
                    loadFragment(fragment)
                    return true
                }
            }
            return false
        }
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
    // load fragment when click item bottom navigation view
    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
