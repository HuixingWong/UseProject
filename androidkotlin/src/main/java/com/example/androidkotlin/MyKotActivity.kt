package com.example.androidkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_my_kot.*
import java.net.URL
import java.util.*

class MyKotActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_kot)
        val add = add(34, 85)
        button2.text = "123"+add

        button2.setOnClickListener {
            toast123()
            val url = "https://www.baidu.com"

            Thread({
                val text = URL(url).readText()
                runOnUiThread { Log.d("123",text) }
            }).start()

        }

        val intent = Intent(this@MyKotActivity, KotlinActivity2::class.java)

        val s = "Example"
        val c = s[2]
        for (c in s){
           Log.d("123",""+c)
        }


        val f1 = Forecast(Date(), 27.5f, "shiny day")
        val f2 = f1.copy(temperature = 30f)



        button3.setOnClickListener {
            startActivity(intent)
        }

    }

    fun add(x: Int,y: Int) : Int = x+y

    fun toast(message: String,length: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this,message,length).show()
    }
}
