package com.main.myislamiapp.hadeth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.main.myislamiapp.Constants.HADETH_CONTENT
import com.main.myislamiapp.R
import com.main.myislamiapp.databinding.ActivityHadethContentBinding

class HadethContentActivity : AppCompatActivity() {
   private lateinit var binding:ActivityHadethContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHadethContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val getIntent=intent.getSerializableExtra(HADETH_CONTENT) as? HadethModel
        binding.hadethTitleTv.text=getIntent?.title
        binding.hadethContentTv.text=getIntent?.content

    }
}