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
package com.example.androiddevchallenge

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.ui.DetailActivity
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val context = LocalContext.current

    val cats = mutableListOf<Cat>()

    cats.apply {
        add(Cat("Olly", R.drawable.cat1, "Zwolle, Netherlands"))
        add(Cat("Vito", R.drawable.cat2, "Nicosia, Cyprus"))
        add(Cat("Snowball", R.drawable.cat3, "Zagreb, Croatia"))
        add(Cat("WorldDestroyer", R.drawable.cat4, "Oslo, Norways"))
        add(Cat("Dusty", R.drawable.cat5, "Brussels, Belgium"))
        add(Cat("Tora", R.drawable.cat6, "Jakarta, Indonesia"))
        add(Cat("Buster", R.drawable.cat7, "New York City, United States"))
        add(Cat("Shrapnel", R.drawable.cat8, "Caracas, Venezuela"))
        add(Cat("TigerLilly", R.drawable.cat9, "Tunis, Tunisia"))
        add(Cat("Skip", R.drawable.cat10, "Kathmandu, Nepal"))
        add(Cat("first", R.drawable.cat11, "Kuwait City, Kuwait"))
    }

    ListCats(cats) {
        Log.d("Hahahah", "dipilih ${it.name}")
        openDetail(context, it)
    }
}

fun openDetail(LocalContext: Context, cat: Cat) {
    DetailActivity.getInstance(LocalContext, cat)
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

// @Preview("Dark Theme", widthDp = 360, heightDp = 640)
// @Composable
// fun DarkPreview() {
//     MyTheme(darkTheme = true) {
//         MyApp()
//     }
// }
