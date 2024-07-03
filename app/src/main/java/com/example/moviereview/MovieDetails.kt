package com.example.moviereview

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_details.language
import kotlinx.android.synthetic.main.activity_movie_details.overview
import kotlinx.android.synthetic.main.activity_movie_details.ratingText
import kotlinx.android.synthetic.main.activity_movie_details.releasedate
import kotlinx.android.synthetic.main.activity_movie_details.reviewhere
import kotlinx.android.synthetic.main.activity_movie_details.suitable
import kotlinx.android.synthetic.main.activity_movie_details.title1

class MovieDetails : AppCompatActivity() {
    val RATING_ACTIVITY_RESULT_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movieList = Movie(
            "Venom",
            "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego Venom to save his life.",
            "English",
            "03-10-2018",
            "Yes"
        )

        val displayedmovieTitle = movieList.movieTitle
        val displayedmovieOverview = movieList.movieOverview
        val displayedmovieLanguage = movieList.movieLanguage
        val displayedmovieReleaseDate = movieList.movieReleaseDate
        val displayedmovieSuitable = movieList.movieSuitable

        title1.text = "$displayedmovieTitle"
        overview.text = "$displayedmovieOverview"
        language.text = "$displayedmovieLanguage"
        releasedate.text = "$displayedmovieReleaseDate"
        suitable.text = "$displayedmovieSuitable"

        registerForContextMenu(ratingText)

        val actionbar = supportActionBar

        actionbar?.title = "Movie Rater"

        actionbar?.setDisplayHomeAsUpEnabled(true)

        if (intent.hasExtra("reviewText")) {
            val reviewText = intent.getStringExtra("reviewText")
            val rating = intent.getFloatExtra("rating", 0.0f)

            if (reviewText!!.isNotEmpty() && rating != 0.0f){
                reviewhere.text = reviewText
                ratingText.text = "Rating: $rating Stars"
            }
            if (rating != 0.0f) {
                ratingText.text = "Rating: $rating Stars"
                reviewhere.text = "Long press below to add reviews."
            }
            if (reviewText!!.isNotEmpty()){
                reviewhere.text = reviewText
            }
        }
        if (intent.hasExtra("input1")){
            val input1 = intent.getStringExtra("input1")
            val input2 = intent.getStringExtra("input2")
            val input3 = intent.getStringExtra("input3")
            val input4 = intent.getStringExtra("input4")
            val isAppropriateChecked = intent.getBooleanExtra("isAppropriateChecked", false)

            title1.text = input1
            overview.text = input2
            releasedate.text = input3
            language.text = input4
            suitable.text = if (isAppropriateChecked) "No" else "Yes"
        }
        if (intent.hasExtra("newTitle")) {
            val newTitle = intent.getStringExtra("newTitle")
            val newOverview = intent.getStringExtra("newOverview")
            val newRelease = intent.getStringExtra("newRelease")
            val newLanguage = intent.getStringExtra("newLanguage")
            val newSuitable = intent.getStringExtra("newSuitable")

            title1.text = newTitle
            overview.text = newOverview
            releasedate.text = newRelease
            language.text = newLanguage
            suitable.text = newSuitable
        }
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        if (v != null) {
            if (v.id  == R.id.ratingText) {
                menu?.add(1, 0, 0, "Add Review")
            }
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            0 -> {
                val myintent = Intent(this, RatingActivity::class.java)
                myintent.putExtra("movieTitle", title1.text)
                myintent.putExtra("movieOverview", overview.text)
                myintent.putExtra("movieRelease", releasedate.text)
                myintent.putExtra("movieLanguage", language.text)
                myintent.putExtra("movieSuitable", suitable.text)
                startActivity(myintent)
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
    override fun onBackPressed(){
        super.onBackPressed()
        val myintent = Intent(this, MainActivity::class.java)
        startActivity(myintent)
        finish()
    }
}