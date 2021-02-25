package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddevchallenge.model.Cat

class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_CAT = "cat"
        fun getInstance(context: Context, cat: Cat) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_CAT, cat)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}