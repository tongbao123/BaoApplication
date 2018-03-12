package com.example.daniel.myapplication.Adapter

import android.app.Activity
import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.daniel.myapplication.R


/**
 * Created by Daniel on 3/9/2018.
 */
class FullScreenAdapter(val act : Activity,  val list : ArrayList<String>) : PagerAdapter() {
    lateinit var lInflater : LayoutInflater
    override fun isViewFromObject(view: View, obj : Any): Boolean {
        return view === obj as RelativeLayout
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        lInflater = act.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = lInflater.inflate(R.layout.full_scr, container, false)

        var imgDisplay = view.findViewById<ImageView>(R.id.imgDisplay)
        var btnClose = view.findViewById<Button>(R.id.btnClose)

        var rq = RequestOptions().placeholder(R.drawable.loading_spinner)
        Glide.with(act.applicationContext)
                .load(list[position])
                .apply(rq)
                .into(imgDisplay)

        btnClose.setOnClickListener {
            act.finish()
        }

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as RelativeLayout)
    }
}