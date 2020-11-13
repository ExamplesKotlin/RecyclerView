package com.arqoders.recyclerviewprj

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MoviesAdapter(private val movies: List<Movie>):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }

}