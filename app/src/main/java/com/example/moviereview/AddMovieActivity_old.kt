package com.example.moviereview

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_movie_old.AddMovie
import kotlinx.android.synthetic.main.activity_add_movie_old.Chinese
import kotlinx.android.synthetic.main.activity_add_movie_old.Description_Input
import kotlinx.android.synthetic.main.activity_add_movie_old.English
import kotlinx.android.synthetic.main.activity_add_movie_old.LanguageUsed
import kotlinx.android.synthetic.main.activity_add_movie_old.Malay
import kotlinx.android.synthetic.main.activity_add_movie_old.Name_Input
import kotlinx.android.synthetic.main.activity_add_movie_old.ReleaseDate_Input
import kotlinx.android.synthetic.main.activity_add_movie_old.Tamil
import kotlinx.android.synthetic.main.activity_add_movie_old.Violence
import kotlinx.android.synthetic.main.activity_add_movie_old.appropriate

class AddMovieActivity_old : AppCompatActivity() {

    private lateinit var showToastdisplay: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie_old)

        val checkBox: CheckBox = appropriate
        val checkBox1: CheckBox = Violence
        val checkBox2: CheckBox = LanguageUsed

        showToastdisplay = AddMovie

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
        showToastdisplay.setOnClickListener {
            val input1 = Name_Input.text.toString()
            val input2 = Description_Input.text.toString()
            val input3 = ReleaseDate_Input.text.toString()
            val radioGroup1: RadioButton = English
            val radioGroup2: RadioButton = Chinese
            val radioGroup3: RadioButton = Malay
            val radioGroup4: RadioButton = Tamil
            if (input1.isEmpty())
                Name_Input.error = "Field Empty"
            if (input2.isEmpty())
                Description_Input.error = "Field Empty"
            if (input3.isEmpty())
                ReleaseDate_Input.error = "Field Empty"
            var input4 = ""
            if (radioGroup1.isChecked){
                input4 = "English"
            }
            else if (radioGroup2.isChecked){
                input4 = "Chinese"
            }
            else if (radioGroup3.isChecked){
                input4 = "Malay"
            }
            else if (radioGroup4.isChecked){
                input4 = "Tamil"
            }
            if (input4 == "") {
                showToast("Language Field Empty")
            }
            else if (input1.isNotEmpty() && input2.isNotEmpty() && input3.isNotEmpty()) {
                var input5 = ""
                if (appropriate.isChecked) {
                    input5 = "True"
                }
                else{
                    input5 = "False"
                }
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
                } else if (Violence.isChecked == false && LanguageUsed.isChecked == false)
                    showToast("Title: $input1 \nOverview: $input2 \nRelease Date: $input3 \nLanguage: $input4 \nNot Suitable For All Ages: $input5")
            }
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}