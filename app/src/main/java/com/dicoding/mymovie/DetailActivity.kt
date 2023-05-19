package com.dicoding.mymovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dicoding.mymovie.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataMovie = intent.getParcelableExtra<Movie>("key_movie") as Movie

        val tvDetailName = binding.tvDetailName
        val tvDetailDirector = binding.tvDetailDirector
        val tvDetailWriter = binding.tvDetailWriter
        val tvDetailNetwork = binding.tvDetailNetwork
        val tvDetailEpisodes = binding.tvDetailEpisodes
        val tvDetailReleasedDate = binding.tvDetailReleasedDate
        val tvDetailSynopsis = binding.tvDetailSynopsis
        val ivDetailPhoto = binding.ivDetailPhoto

        tvDetailName.text = dataMovie.name
        tvDetailDirector.text = dataMovie.director
        tvDetailWriter.text = dataMovie.writer
        tvDetailNetwork.text = dataMovie.network
        tvDetailEpisodes.text = dataMovie.episodes
        tvDetailReleasedDate.text = dataMovie.released_date
        tvDetailSynopsis.text = dataMovie.synopsis
        Glide.with(this)
            .load(dataMovie.photo)
            .into(ivDetailPhoto)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }



}