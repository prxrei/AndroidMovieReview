package com.example.moviereview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_movie.Chinese
import kotlinx.android.synthetic.main.activity_add_movie.English
import kotlinx.android.synthetic.main.activity_add_movie.LanguageUsed
import kotlinx.android.synthetic.main.activity_add_movie.Malay
import kotlinx.android.synthetic.main.activity_add_movie.Tamil
import kotlinx.android.synthetic.main.activity_add_movie.Violence
import kotlinx.android.synthetic.main.activity_add_movie.appropriate
import kotlinx.android.synthetic.main.activity_edit_movie.Description_Input
import kotlinx.android.synthetic.main.activity_edit_movie.Name_Input
import kotlinx.android.synthetic.main.activity_edit_movie.ReleaseDate_Input

class EditMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)

        val actionbar = supportActionBar

        actionbar?.title = "Movie Rater"

        actionbar?.setDisplayHomeAsUpEnabled(true)

        val checkBox: CheckBox = appropriate
        val checkBox1: CheckBox = Violence
        val checkBox2: CheckBox = LanguageUsed

        val Radio1: RadioButton = English
        val Radio2: RadioButton = Chinese
        val Radio3: RadioButton = Malay
        val Radio4: RadioButton = Tamil

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            checkBox1.visibility =
                if (isChecked) View.VISIBLE
                else View.GONE
            checkBox1.isChecked = false
            checkBox2.visibility =
                if (isChecked) View.VISIBLE
                else View.GONE
            checkBox2.isChecked = false
        }

        val movieList = Movie(
            "Venom",
            "OverView",
            "English",
            "19-10-2018",
            "Yes"
        )

        val displayedmovieTitle = movieList.movieTitle
        val displayedmovieOverview = movieList.movieOverview
        val displayedmovieReleaseDate = movieList.movieReleaseDate

        if (movieList.movieSuitable == "Yes"){
            checkBox.isChecked = true
            checkBox1.isChecked = true
        }

        if (movieList.movieLanguage == "English"){
            Radio1.isChecked = true
        }

        if (movieList.movieLanguage == "Chinese"){
            Radio2.isChecked = true
        }

        if (movieList.movieLanguage == "Malay"){
            Radio3.isChecked = true
        }

        if (movieList.movieLanguage == "Tamil"){
            Radio4.isChecked = true 
        }
        Name_Input.setText(displayedmovieTitle)
        Description_Input.setText(displayedmovieOverview)
        ReleaseDate_Input.setText(displayedmovieReleaseDate)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_movie, menu)

        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
    override fun onBackPressed(){
        super.onBackPressed()
        val intent = Intent(this, MovieDetails::class.java)
        startActivity(intent)
        finish()
    }

}