package com.example.tugasuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
    }
    fun openMovieDetails(view: View) {
        val idx = Integer.parseInt(view.tag.toString())
        val film = filmlist.elementAt(idx)
        val intent = Intent(this, DetailsMovie::class.java)
        intent.putExtra("film", film)
        startActivity(intent)
    }
}