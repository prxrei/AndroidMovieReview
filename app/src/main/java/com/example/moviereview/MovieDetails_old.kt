package com.example.moviereview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_details_old.language
import kotlinx.android.synthetic.main.activity_movie_details_old.overview
import kotlinx.android.synthetic.main.activity_movie_details_old.releasedate
import kotlinx.android.synthetic.main.activity_movie_details_old.suitable
import kotlinx.android.synthetic.main.activity_movie_details_old.title1

class MovieDetails_old : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details_old)

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
    }
}