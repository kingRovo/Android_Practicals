package com.example.myapps


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class Home : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tabLayout = findViewById<TabLayout>(R.id.tab1)
        viewPager = findViewById<ViewPager>(R.id.v1)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Home"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Status"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Pics"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL


        val adapter = MyAdapter( supportFragmentManager)
        this.viewPager!!.adapter = adapter


        //this.viewPager.adapter=viewpageradapter  //Binding PagerAdapter with ViewPager
        this.tabLayout!!.setupWithViewPager(this.viewPager) //Binding ViewPager with TabLayout


        //viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        /*  tabLayout!!.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
               override fun onTabReselected(tab: TabLayout.Tab?) {
                   TODO("Not yet implemented")
               }
               override fun onTabUnselected(tab: TabLayout.Tab?) {
                   TODO("Not yet implemented")
               }
               override fun onTabSelected(tab: TabLayout.Tab?) {
                   viewPager!!.currentItem = tab!!.position
               }
           })
   */
    }
}