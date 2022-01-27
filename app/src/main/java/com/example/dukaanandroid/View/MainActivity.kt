package com.example.dukaanandroid.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.dukaanandroid.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var bottomNavigationView: BottomNavigationView? = null
    //  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        // binding.setHandler(myHandler);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
      //  bottomNavigationView!!.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView!!.setSelectedItemId(R.id.person);

        val firstFragment: Dashboard_fragment = Dashboard_fragment()
        val second_fragment: SecondFragment = SecondFragment()
        val thirdFragment: ThirdFragment = ThirdFragment()

        loadFragment(Dashboard_fragment())
        bottomNavigationView!!.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.person -> {
                    // title=resources.getString(R.string.menu_1)
                    loadFragment(Dashboard_fragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.home -> {
                    // title=resources.getString(R.string.second_menu)
                    loadFragment(SecondFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.settings -> {
                    // title=resources.getString(R.string.third_menu)
                    loadFragment(ThirdFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }



    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}