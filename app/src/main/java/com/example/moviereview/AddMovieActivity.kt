package com.example.moviereview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_movie.Description_Input
import kotlinx.android.synthetic.main.activity_add_movie.LanguageUsed
import kotlinx.android.synthetic.main.activity_add_movie.Name_Input
import kotlinx.android.synthetic.main.activity_add_movie.RadioGroup
import kotlinx.android.synthetic.main.activity_add_movie.ReleaseDate_Input
import kotlinx.android.synthetic.main.activity_add_movie.Violence
import kotlinx.android.synthetic.main.activity_add_movie.appropriate
import kotlinx.android.synthetic.main.activity_add_movie_old.Chinese
import kotlinx.android.synthetic.main.activity_add_movie_old.English
import kotlinx.android.synthetic.main.activity_add_movie_old.Malay
import kotlinx.android.synthetic.main.activity_add_movie_old.Tamil

class AddMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        val actionbar = supportActionBar
        actionbar?.title = "Movie Rater"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        val checkBox: CheckBox = appropriate
        val checkBox1: CheckBox = Violence
        val checkBox2: CheckBox = LanguageUsed

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
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun handleShowToast() {
        val input1 = Name_Input.text.toString()
        val input2 = Description_Input.text.toString()
        val input3 = ReleaseDate_Input.text.toString()
        val radioGroup1: RadioButton = English
        val radioGroup2: RadioButton = Chinese
        val radioGroup3: RadioButton = Malay
        val radioGroup4: RadioButton = Tamil

        if (input1.isEmpty()) {
            Name_Input.error = "Field Empty"
        }
        if (input2.isEmpty()) {
            Description_Input.error = "Field Empty"
        }
        if (input3.isEmpty()) {
            ReleaseDate_Input.error = "Field Empty"
        }

        var input4 = ""
        if (radioGroup1.isChecked) {
            input4 = "English"
        } else if (radioGroup2.isChecked) {
            input4 = "Chinese"
        } else if (radioGroup3.isChecked) {
            input4 = "Malay"
        } else if (radioGroup4.isChecked) {
            input4 = "Tamil"
        }

        if (input4 == "") {
            showToast("Language Field Empty")
        } else if (input1.isNotEmpty() && input2.isNotEmpty() && input3.isNotEmpty()) {
            var input5 = if (appropriate.isChecked) "True" else "False"
            var input6 = ""
            var input7 = ""
            if (Violence.isChecked && LanguageUsed.isChecked) {
                input6 = "Violence"
                input7 = "Language"
                showToast("Title: $input1 \nOverview: $input2 \nRelease Date: $input3 \nLanguage: $input4 \nNot Suitable For All Ages: $input5 \nReason: \n$input6 \n$input7")
            } else if (Violence.isChecked) {
                input6 = "Violence"
                showToast("Title: $input1 \nOverview: $input2 \nRelease Date: $input3 \nLanguage: $input4 \nNot Suitable For All Ages: $input5 \nReason: \n$input6")
            } else if (LanguageUsed.isChecked) {
                input7 = "Language"
                showToast("Title: $input1 \nOverview: $input2 \nRelease Date: $input3 \nLanguage: $input4 \nNot Suitable For All Ages: $input5 \nReason: \n$input7")
            } else if (Violence.isChecked == false && LanguageUsed.isChecked == false) {
                showToast("Title: $input1 \nOverview: $input2 \nRelease Date: $input3 \nLanguage: $input4 \nNot Suitable For All Ages: $input5 \nReason:")
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_movie, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.clearentry -> {
                Name_Input.setText("")
                Description_Input.setText("")
                ReleaseDate_Input.setText("")
                RadioGroup.clearCheck()
                appropriate.isChecked = false
            }
            R.id.AddMovieMI -> {
                handleShowToast()
                val input1 = Name_Input.text.toString()
                val input2 = Description_Input.text.toString()
                val input3 = ReleaseDate_Input.text.toString()
                if (input1.isEmpty())
                    Name_Input.error = "Field Empty"
                if (input2.isEmpty())
                    Description_Input.error = "Field Empty"
                if (input3.isEmpty())
                    ReleaseDate_Input.error = "Field Empty"
                else if (input1.isNotEmpty() && input2.isNotEmpty() && input3.isNotEmpty()) {
                    AddActivity()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun AddActivity() {
        // Retrieve the review text from your UI elements using synthetic properties
        val input1 = Name_Input.text.toString()
        val input2 = Description_Input.text.toString()
        val input3 = ReleaseDate_Input.text.toString()
        val radioGroup1: RadioButton = English
        val radioGroup2: RadioButton = Chinese
        val radioGroup3: RadioButton = Malay
        val radioGroup4: RadioButton = Tamil
        var input4 = ""
        val isAppropriateChecked = appropriate.isChecked
        // Create an Intent and pass the review text
        val intent = Intent(this, MovieDetails::class.java)
        intent.putExtra("input1", input1)
        intent.putExtra("input2", input2)
        intent.putExtra("input3",input3)
        if (radioGroup1.isChecked){
            input4 = "English"
        }
        else if (radioGroup2.isChecked){
            input4 = "Chinese"
        }
        else if (radioGroup3.isChecked){
            input4 = "Malay"
        }
        else if (radioGroup4.isChecked) {
            input4 = "Tamil"
        }
        intent.putExtra("input4", input4)
        intent.putExtra("isAppropriateChecked", isAppropriateChecked)

        // Start MovieDetails activity with the intent
        startActivity(intent)
    }
}
