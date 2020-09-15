package com.example.newsapiapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.newsapiapk.Model.ArticlesItem

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_NEWS = "DETAIL_NEWS"
    }
    private lateinit var binding : ActivityDetailBiding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBiding.Inflate(layoutInflater)

        val data = intent.getParcelableArrayExtra(DETAIL_NEWS)as ArticlesItem
        binding.run {
            setContentView(R.layout.activity_detail)
        }
    }
}