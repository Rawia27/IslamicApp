package com.main.myislamiapp.tasbih

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.main.myislamiapp.Constants
import com.main.myislamiapp.databinding.FragmentTasbihBinding

class TasbihFragment:Fragment() {
    private var count: Int = 0
    lateinit var binding: FragmentTasbihBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasbihBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCount.text = "$count"
        rotateImg()
    }

    private fun rotateImg() {
        binding.imgSebha.setOnClickListener {
            binding.imgSebha.rotation += 5
            setCount(++count)
            changeZeker()
        }
    }

    private fun setCount(counter:Int) {
        binding.tvCount.text = "$counter"
    }

    private fun changeZeker() {
        if (count == 34) {
            when (binding.tasbihName.text) {
                Constants.SOPHAN_ALLAH -> {
                    binding.tasbihName.text=Constants.ALHAMED_ALLAH
                    count=0
                   setCount(count)
                }
                Constants.ALHAMED_ALLAH -> {
                    binding.tasbihName.text =Constants.LAALLAHALA_ALLA
                    count=0
                    setCount(0)
                }
                Constants.LAALLAHALA_ALLA -> {
                    binding.tasbihName.text =Constants.ALLAH_AKBER
                    count=0
                    setCount(0)
                }
                Constants.ALLAH_AKBER-> {
                    binding.tasbihName.text =Constants.SOPHAN_ALLAH
                    count=0
                    setCount(0)
                }
            }
        }
    }
}