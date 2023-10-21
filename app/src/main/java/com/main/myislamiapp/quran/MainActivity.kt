package com.main.myislamiapp.quran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.main.myislamiapp.R
import com.main.myislamiapp.databinding.ActivityMainBinding
import com.main.myislamiapp.hadeth.HadethFragment
import com.main.myislamiapp.tasbih.TasbihFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomNavItems()
    }
    private fun bottomNavItems(){
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.quran -> showFragment(QuranFragment())
                R.id.sebha -> showFragment((TasbihFragment()))
                R.id.hadeth -> showFragment((HadethFragment()))
            }
            true
        }
        binding.bottomNav.selectedItemId= R.id.quran
    }
    private fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
    }
}