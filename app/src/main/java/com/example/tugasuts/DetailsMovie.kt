package com.example.tugasuts

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class DetailsMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)

        val film = intent.getParcelableExtra<Film>("film")

        val movieImage = findViewById<ImageView>(R.id.image)
        val movieTitle = findViewById<TextView>(R.id.title)
        val movieDirector = findViewById<TextView>(R.id.director)
        val movieCategories = findViewById<TextView>(R.id.categories)
        val movieShortStoryline = findViewById<TextView>(R.id.description)
        val movieRating = findViewById<RatingBar>(R.id.rating)
        val movieTicketPrice = findViewById<TextView>(R.id.price)
        val movieButton = findViewById<Button>(R.id.GetTicket)

        movieImage.setImageResource(film!!.imageResId)
        movieTitle.text = film?.title
        movieDirector.text = film?.director
        movieCategories.text = film?.categories
        movieShortStoryline.text = film?.description
        movieRating.numStars = film!!.rating
        movieTicketPrice.text = "Ticket Price: $${film?.price}"

        movieButton.setOnClickListener {
            val intent = Intent(this@DetailsMovie, PaymentMethod::class.java)
            intent.putExtra("film", film)
            startActivity(intent)
        }
    }
}