package com.example.daniel.myapplication.Adapter


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.daniel.myapplication.FullScreen
import com.example.daniel.myapplication.R


/**
 * Created by Daniel on 3/9/2018.
 */
class AdapterGrView(val act : Activity, val ctx : Context, val lst : ArrayList<String>) : BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val v = LayoutInflater.from(ctx).inflate(R.layout.item_gr, null, false)
        var imgView = v.findViewById<ImageView>(R.id.imgView)

        var rq = RequestOptions().placeholder(R.drawable.loading_spinner)
        Glide.with(ctx)
                .load(lst[p0])
                .apply(rq)
                .into(imgView)

        v.setOnClickListener {
            act.startActivity(Intent(ctx, FullScreen::class.java).putExtra("position", p0).putExtra("list", lst))
        }
        return v
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return lst.size
    }

}