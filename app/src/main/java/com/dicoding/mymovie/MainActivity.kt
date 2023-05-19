package com.dicoding.mymovie

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMovies: RecyclerView
    private val list = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListMovies(): ArrayList<Movie> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDirector = resources.getStringArray(R.array.data_director)
        val dataWriter = resources.getStringArray(R.array.data_writer)
        val dataNetwork = resources.getStringArray(R.array.data_network)
        val dataEpisodes = resources.getStringArray(R.array.data_episodes)
        val dataReleasedDate = resources.getStringArray(R.array.data_released_date)
        val dataSynopsis = resources.getStringArray(R.array.data_synopsis)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listMovie = ArrayList<Movie>()
        for (i in dataName.indices) {
            val movie = Movie(dataName[i], dataDirector[i], dataWriter[i], dataNetwork[i], dataEpisodes[i], dataReleasedDate[i], dataSynopsis[i], dataPhoto[i])
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun showRecyclerList() {
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = ListMovieAdapter(list)
        rvMovies.adapter = listMovieAdapter

        listMovieAdapter.setOnItemClickCallback(object : ListMovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Movie) {
                showSelectedMovie(data)
            }
        })
    }

    private fun showSelectedMovie(movie: Movie) {
        Toast.makeText(this, "Kamu memilih " + movie.name, Toast.LENGTH_SHORT).show()
    }
}