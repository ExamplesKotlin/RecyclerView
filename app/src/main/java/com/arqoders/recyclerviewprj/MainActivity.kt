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
            Movie("Title 1", "url 1"),
            Movie("Title 2", "url 2"),
            Movie("Title 3", "url 3"),
            Movie("Title 4", "url 4"),
            Movie("Title 5", "url 5"),
            Movie("Title 6", "url 6")
        )

        binding.recycler.adapter = MoviesAdapter(movies)
        binding.recycler.layoutManager = LinearLayoutManager(this)

    }
}