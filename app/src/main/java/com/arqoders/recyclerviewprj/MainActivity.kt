package com.arqoders.recyclerviewprj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arqoders.recyclerviewprj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movies: List<Movie> = listOf(
            Movie("Title 1", "https://loremflickr.com/320/240?lock=1"),
            Movie("Title 2", "https://loremflickr.com/320/240?lock=2"),
            Movie("Title 3", "https://loremflickr.com/320/240?lock=3"),
            Movie("Title 4", "https://loremflickr.com/320/240?lock=4"),
            Movie("Title 5", "https://loremflickr.com/320/240?lock=5"),
            Movie("Title 6", "https://loremflickr.com/320/240?lock=6"),
            Movie("Title 7", "https://loremflickr.com/320/240?lock=7"),
            Movie("Title 8", "https://loremflickr.com/320/240?lock=8"),
            Movie("Title 9", "https://loremflickr.com/320/240?lock=9"),
            Movie("Title 10", "https://loremflickr.com/320/240?lock=10")
        )

        binding.recycler.adapter = MoviesAdapter(movies)
        binding.recycler.layoutManager = LinearLayoutManager(this)

    }
}