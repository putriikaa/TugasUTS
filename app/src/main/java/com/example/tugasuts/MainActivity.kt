package com.example.tugasuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasuts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usernameValue = intent.getStringExtra(LoginActivity.EXTRA_USERNAME)
        with(binding) {
            yourUsn.text = usernameValue
        }
        populateFilm()

    }

    private fun populateFilm() {
        val film1 = Film(
            R.drawable.sherina,
            "Midnight Serenade",
            "Director Name",
            "Drama, Romance, Music",
            "Description of the film.",
            4.5,
            10
        )
        filmlist.add(film1)

        val film2 = Film(
            R.drawable.mermaid,
            "The Little Mermaid",
            "Director Name",
            "Drama, Romance, Music",
            "Description of the film.",
            4.5,
            10
        )
        filmlist.add(film2)

        val film3 = Film(
            R.drawable.aladin,
            "Aladin",
            "Director Name",
            "Drama, Romance, Music",
            "Description of the film.",
            4.5,
            10
        )
        filmlist.add(film3)

        val film4 = Film(
            R.drawable.moana,
            "Moana",
            "Director Name",
            "Drama, Romance, Music",
            "Description of the film.",
            4.5,
            10
        )
        filmlist.add(film4)

        val film5 = Film(
            R.drawable.avatar,
            "Avatar",
            "Director Name",
            "Drama, Romance, Music",
            "Description of the film.",
            4.5,
            10
        )
        filmlist.add(film5)

        val film6 = Film(
            R.drawable.mulan,
            "Mulan",
            "Director Name",
            "Drama, Romance, Music",
            "Description of the film.",
            4.5,
            10
        )
        filmlist.add(film6)

    }
    fun openMovieDetails(film: Film) {
        val intent = Intent(this, DetailsMovie::class.java)
        intent.putExtra("film", film)
        startActivity(intent)
    }

}