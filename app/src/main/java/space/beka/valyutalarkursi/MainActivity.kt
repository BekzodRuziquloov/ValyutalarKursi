package space.beka.valyutalarkursi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import space.beka.valyutalarkursi.adapter.CurrencyAdapter
import space.beka.valyutalarkursi.model.CurrencyData

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.list)

        startDownload()

    }

    private fun startDownload() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://cbu.uz/uz/arkhiv-kursov-valyut/json/"

        val stringRequest = StringRequest(Request.Method.GET, url,
            {
                jsonToDataClass(it)
            },
            {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        )

        queue.add(stringRequest)
    }

    private fun jsonToDataClass(string: String) =
        createList(Gson().fromJson(string, CurrencyData::class.java))

    private fun createList(data: CurrencyData) {
        recyclerView.adapter = CurrencyAdapter(data)
    }
}