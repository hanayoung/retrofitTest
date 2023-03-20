package com.aoreo.httpcommunicationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aoreo.httpcommunicationtest.adapter.CustomAdapter
import com.aoreo.httpcommunicationtest.api.MyApi
import com.aoreo.httpcommunicationtest.api.RetrofitInstance
import com.aoreo.httpcommunicationtest.databinding.ActivityMainBinding
import com.aoreo.httpcommunicationtest.model.Post
import com.aoreo.httpcommunicationtest.viewModel.MainViewModel
import com.aoreo.httpcommunicationtest.viewModel.PlantViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PlantViewModel

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        Log.d("TEST", "START")

        val viewModel = ViewModelProvider(this).get(PlantViewModel::class.java)
        viewModel.getAllPlants()

        viewModel.result.observe(this, Observer {
            val customAdapter = CustomAdapter(it,this)
            binding.rv.adapter = customAdapter
            binding.rv.layoutManager = LinearLayoutManager(this)
        })

        // Retrofit 간단한 예제 변경 + RecyclerView 추가 - MainViewModel
//        lateinit var viewModel : MainViewModel
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        viewModel.getPost1()
//        viewModel.getPostNumber(3)
//        viewModel.getPostAll()
//
//        viewModel.liveWord1.observe(this, Observer {
//            binding.area1.text=it.toString()
//        })
//        viewModel.liveWord2.observe(this, Observer {
//            binding.area2.text=it.toString()
//        }
//        )
//        val rv = binding.rv
//        viewModel.liveWordList.observe(this, Observer {
//            val customAdapter = CustomAdapter(it as ArrayList<Post>)
//            rv.adapter = customAdapter
//            rv.layoutManager = LinearLayoutManager(this)
//        })


//        CoroutineScope(Dispatchers.IO).launch {
////            Log.d("TEST", "CoroutineScope START")
//            a()
//            b()
////            Log.d("TEST", "CoroutineScope END")
//        }
//        Log.d("TEST", "END")
//        val api = RetrofitInstance.getInstance().create(MyApi::class.java)
//        api.getPost1().enqueue(object : Callback<Post>{
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Log.d("API1",response.body().toString())
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("API1","fail")
//            }
//        })
//
//        api.getPostNumber(2).enqueue(object : Callback<Post>{
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                Log.d("API2",response.body().toString())
//            }
//
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.d("API2","fail")
//            }
//        })
    }
    suspend fun a() {

        // a작업은 오래걸려서 2초정도
        delay(1000)

        Log.d("TEST", "AP1")

        delay(1000)

        Log.d("TEST", "AP2")
    }

    suspend fun b() {

        // b 작업은 오래걸려서 2초정도
        delay(1000)

        Log.d("TEST", "BP1")

        delay(1000)

        Log.d("TEST", "BP2")

    }
}