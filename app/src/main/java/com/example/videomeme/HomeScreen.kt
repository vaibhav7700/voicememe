package com.example.videomeme

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeScreen : AppCompatActivity() {

    private lateinit var mediaAdapter: MediaAdapter
    private lateinit var recyler: RecyclerView
    var listMedia = ArrayList<ResponseMediaData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        fetchData()


         recyler = findViewById<RecyclerView>(R.id.rv_media_items)
        recyler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
//        mediaAdapter =  MediaAdapter(this, listMedia )
//        recyler.adapter = mediaAdapter
    }

//    private fun getApiResponse(){
//        val apiService = Constant.apiService
//        val call = apiService.getData()
//
//        call.enqueue(object : Callback<List<DataList>>{
//            override fun onResponse(
//                call: Call<List<DataList>>,
//                response: Response<List<DataList>>
//            ) {
//                if (response.isSuccessful){
//                    val data = response.body()
//                    Log.d("##response",data.toString())
//                }
//                else{
//                    //handle api error
//                }
//            }
//
//            override fun onFailure(call: Call<List<DataList>>, t: Throwable) {
//              Log.d("###Api Response","network error")
//            }
//
//
//        })


        @OptIn(DelicateCoroutinesApi::class)
        private fun fetchData() {
            val service = Constant.apiService
            GlobalScope.launch(Dispatchers.Main) {
                try {
                    val response = service.getData()
                    if (response.isSuccessful) {
                        val data = response.body()
                        if (data != null) {
                   Log.d("##response",data.toString())
                            mediaAdapter = MediaAdapter(this@HomeScreen,data.data)
                            recyler.adapter = mediaAdapter
                        }
                    } else {
                        // Handle error response
                        Log.d("###Api Response","network error")
                    }
                } catch (e: Exception) {
                    // Handle exception
                    Log.d("###Api Response",e.toString())
                }
            }
        }




















//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menuu, menu)
//        val menuItem = menu.findItem(R.id.search)
//        val searchView = menuItem.actionView as SearchView?
//        searchView!!.queryHint = "Type here to search"
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(s: String): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(s: String): Boolean {
//                mediaAdapter.listItems.get(getfil)
//                    //.getFilter().filter(s)
//                return false
//            }
//        })
//        return super.onCreateOptionsMenu(menu)
//    }
}

