package com.example.moviereview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_rating.Rating
import kotlinx.android.synthetic.main.activity_rating.shareview
import kotlinx.android.synthetic.main.activity_rating.title2

class RatingActivity : AppCompatActivity() {
    companion object {
        val RETURN_MSG = "message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        val movieListing = Movie(
            "Venom",
            "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego Venom to save his life.",
            "English",
            "03-10-2018",
            "Yes"
        )

        val displayedMovieTitle = movieListing.movieTitle

        title2.text = "Enter your review for the movie: $displayedMovieTitle"

        if (intent.hasExtra("movieTitle")) {
            val movieTitle = intent.getStringExtra("movieTitle")
            title2.text = "Enter your review for the movie: $movieTitle"
//            val NewTitle = intent.getStringExtra("movieTitle")
//            val NewOverview = intent.getStringExtra("movieOverview")
//            val NewRelease = intent.getStringExtra("movieRelease")
//            val NewLanguage = intent.getStringExtra("movieLanguage")
//            val NewSuitable = intent.getStringExtra("movieSuitable")
//
//            var1.text = NewTitle
//            var2.text = NewOverview
//            var3.text = NewRelease
//            var4.text = NewLanguage
//            var5.text = NewSuitable
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)

        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == R.id.AddMovieMI) {
            val reviewText = shareview.text.toString()
            val rating = Rating.rating

            val myintent = Intent(this, MovieDetails::class.java)
            myintent.putExtra("reviewText", reviewText)
            myintent.putExtra("rating", rating)
            myintent.putExtra("newTitle", intent.getStringExtra("movieTitle"))
            myintent.putExtra("newOverview", intent.getStringExtra("movieOverview"))
            myintent.putExtra("newRelease", intent.getStringExtra("movieRelease"))
            myintent.putExtra("newLanguage", intent.getStringExtra("movieLanguage"))
            myintent.putExtra("newSuitable", intent.getStringExtra("movieSuitable"))

            startActivity(myintent)
        }
        return super.onOptionsItemSelected(item)
    }

}