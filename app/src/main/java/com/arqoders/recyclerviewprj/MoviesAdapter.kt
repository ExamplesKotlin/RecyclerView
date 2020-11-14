package com.arqoders.recyclerviewprj

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arqoders.recyclerviewprj.databinding.ViewMovieItemBinding
import com.bumptech.glide.Glide

class MoviesAdapter(private val movies: List<Movie>):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    class ViewHolder(private val binding: ViewMovieItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie) {
            binding.titleTextView.text = movie.title
            Glide.with(binding.root.context)
                .load(movie.cover)
                .into(binding.profileImageView)
        }
    }

}