package com.example.daniel.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.daniel.myapplication.Adapter.FullScreenAdapter
import kotlinx.android.synthetic.main.activity_full_screen.*

class FullScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)
        var position = intent.getIntExtra("position", 0)
        var lists = intent.getStringArrayListExtra("list")

        var adapter = FullScreenAdapter(this, lists)
        viewPager.adapter = adapter
        viewPager.currentItem = position
    }
}
