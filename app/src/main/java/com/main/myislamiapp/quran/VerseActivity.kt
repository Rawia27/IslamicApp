package com.main.myislamiapp.quran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.main.myislamiapp.quran.QuranFragment.Companion.EXTRA_SURA_INDEX
import com.main.myislamiapp.quran.QuranFragment.Companion.EXTRA_SURA_NAME
import com.main.myislamiapp.databinding.ActivityVerseBinding

class VerseActivity : AppCompatActivity() {
    lateinit var binding:ActivityVerseBinding
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityVerseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val suraName: String = intent.getStringExtra(EXTRA_SURA_NAME) ?: ""
        val index = intent.getIntExtra(EXTRA_SURA_INDEX, 0)
        binding.chapterName.text=suraName
        val verses = readSuraFile(index)
        adapter = VersesAdapter(verses)
        binding.suraDetails.rec.adapter = adapter


    }

    private fun readSuraFile(index: Int): List<String> {
        val file_name = "${index+1}.txt"
        val fileContent = application.assets.open(file_name).bufferedReader().use {
            it.readText()
        }
        val verses = fileContent.split("\n");
        return verses;
    }
}