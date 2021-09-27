package com.example.myapps

import android.content.ContentResolver
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.ArrayList

class ContactWorksheet : AppCompatActivity() {
    var uri:Uri?=null
    var myprojection:Array<String>?=null
    var list:ListView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_worksheet)
        uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        myprojection= arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        );

        list=findViewById<ListView>(R.id.contact_list)
        getContact()


    }

    fun getContact()
    {
        val getcr : ContentResolver=contentResolver

        val cr:Cursor?= uri?.let { getcr.query(it,myprojection,null,null,null) }
        val str = ArrayList<String>()
        str.add("Name                                                Phone Num")
        while(cr!!.moveToNext()) {

            val s =cr.getString(0)+"                                               "+cr.getString(1);
            str.add(s);
        }

        val adapter =  ArrayAdapter<String>(
            this,android.R.layout.simple_list_item_1,
            str
        );
        list!!.adapter=adapter;

        list!!.onItemClickListener=object :AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(applicationContext,"Rovo ji ",Toast.LENGTH_LONG).show()
                val uridata=Uri.parse("tel:"+ str.get(position))
                val i:Intent = Intent(Intent.ACTION_DIAL,uridata)
                startActivity(i)

            }
        }

        list!!.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
}