package com.example.daniel.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.daniel.myapplication.Adapter.AdapterGrView
import kotlinx.android.synthetic.main.activity_main.*

import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
    }

    private fun loadData() {
        try{
            val url = "https://dog.ceo/api/breed/dachshund/images"
            val queue = Volley.newRequestQueue(this)
            val strRequest = StringRequest(Request.Method.GET,
                    url,
                    Response.Listener {
                        response ->
                        onSuccess(response)
                    },
                    Response.ErrorListener {
                        error ->
                        onFail(error)
                    }
            )
            queue.add(strRequest)

        }catch (ex : Exception){
            ex.printStackTrace()
        }
    }

    private fun onFail(error: VolleyError?) {
        Toast.makeText(this, "Can't Load From API", Toast.LENGTH_LONG).show()
    }

    private fun onSuccess(res: String?) {
        try {
            val jo = JSONObject(res)
            if (jo?.getString("status") == "success"){

                loadGrView(jo?.getJSONArray("message"))
            }else{

            }

        }catch (ex : Exception){
            ex.printStackTrace()
        }
    }

    private fun loadGrView(data: JSONArray) {
        if (data.length() > 0){

            var dataAdapter = ArrayList<String>()
            for (i in 0 until data.length()){
                dataAdapter.add(data.getString(i))
            }

            System.out.println(dataAdapter)
            val adapter = AdapterGrView(this , this, dataAdapter)
            adapter.notifyDataSetChanged()
            grView.invalidateViews()
            grView.adapter = adapter
        }
    }
}
