/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_CAT = "cat"
        fun getInstance(context: Context, cat: Cat) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_CAT, cat)
            context.startActivity(intent)
        }
    }

    var cat: Cat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retrieveData()
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }

    private fun retrieveData() {
        cat = intent.getParcelableExtra(EXTRA_CAT)
    }

    @Preview("MyApp", widthDp = 360, heightDp = 640)
    @Composable
    fun MyApp() {
        if (cat == null) return

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = cat!!.picture),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)

            )
            Text(
                text = " ${cat!!.name}",
                fontWeight = FontWeight.Bold
            )

            Text(cat!!.from)
        }
    }
}
