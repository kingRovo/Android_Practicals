package com.example.myapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txuid = findViewById<EditText>(R.id.uidtext)
        val txname = findViewById<EditText>(R.id.nametext)
        val txcity = findViewById<EditText>(R.id.citytext)
        val txaddbtn = findViewById<Button>(R.id.addbtn)
        val spnrList = findViewById<Spinner>(R.id.dropbox)
        val reslt = findViewById<TextView>(R.id.rslt)

        val uidsArr = ArrayList<String>()
        val mapdata = HashMap<String,Student>()

        uidsArr.add("Select UId")

        var ad = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,uidsArr)
        spnrList.adapter=ad
        txaddbtn.setOnClickListener(){
            var valname = txname.text.toString()
            var valcity = txcity.text.toString()
            var valuid = txuid.text.toString()
            uidsArr.add(valuid)
            var obj = Student(valname,valcity)
            txuid.setText("")
            txname.setText("")
            txcity.setText("")

            mapdata.put(valuid,obj)
        }
        spnrList.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                if(p2>0){
                    var uid = uidsArr.get(p2)
                    var obj:Student? = mapdata.get(uid)
                    var name=obj!!.name
                    var city = obj!!.city

                    reslt.setText(" -     "+name+"                    "+city)
                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                reslt.setText("Nothing Selected")


            }
        }


    }
}