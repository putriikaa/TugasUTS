package com.example.tugasuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)

        val film = intent.getParcelableExtra<Film>("film")

        val movieTitle = findViewById<TextView>(R.id.title)
        val movieDirector = findViewById<TextView>(R.id.director)
        val movieCategories = findViewById<TextView>(R.id.categories)
        val movieShortStoryline = findViewById<TextView>(R.id.description)
        val movieTicketPrice = findViewById<TextView>(R.id.price)

        movieTitle.text = film?.title
        movieDirector.text = film?.director
        movieCategories.text = film?.categories
        movieShortStoryline.text = film?.description
        movieTicketPrice.text = "Ticket Price: $${film?.price}"
    }
}