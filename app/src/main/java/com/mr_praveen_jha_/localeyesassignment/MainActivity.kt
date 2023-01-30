package com.mr_praveen_jha_.localeyesassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.mr_praveen_jha_.localeyesassignment.activities.NumberActivity
import com.mr_praveen_jha_.localeyesassignment.adapters.ViewPagerAdapter
import com.mr_praveen_jha_.localeyesassignment.databinding.ActivityMainBinding
import com.mr_praveen_jha_.localeyesassignment.ui.CallFragment
import com.mr_praveen_jha_.localeyesassignment.ui.ChatFragment
import com.mr_praveen_jha_.localeyesassignment.ui.StatusFragment

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)


        val fragmentArrayList = ArrayList<Fragment>()
        fragmentArrayList.add(ChatFragment())
        fragmentArrayList.add(StatusFragment())
        fragmentArrayList.add(CallFragment())


        auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null){
            startActivity(Intent(this,NumberActivity::class.java))
            finish()
        }



        val adapter = ViewPagerAdapter(this,supportFragmentManager,fragmentArrayList)

        binding!!.viewPager.adapter = adapter
        binding!!.tabs.setupWithViewPager(binding!!.viewPager)
    }
}