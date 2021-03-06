package com.dxn.retrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dxn.retrofit.R
import com.dxn.retrofit.model.Post
import com.dxn.retrofit.network.NetworkService
import com.dxn.retrofit.util.ModelMapper
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofitService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val posts = mutableListOf<Post>()

        GlobalScope.launch {
            val list = ModelMapper.networkEntityListToModelList(retrofitService.get())
            posts.addAll(list)
            Log.d("DEBUG", "onCreate: $posts")
        }
    }
}