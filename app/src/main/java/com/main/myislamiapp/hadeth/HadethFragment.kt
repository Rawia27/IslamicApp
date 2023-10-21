package com.main.myislamiapp.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.main.myislamiapp.Constants
import com.main.myislamiapp.databinding.FragmentHadethBinding

class HadethFragment : Fragment() {
    lateinit var binding: FragmentHadethBinding
    lateinit var adapter: HadethAdapter
    lateinit var allAhadeth: ArrayList<HadethModel>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

    }

    private fun initViews() {
        allAhadeth = ArrayList()
        readAhadethFile()
        adapter = HadethAdapter(allAhadeth)
        passHadeth()
        binding.rec.adapter = adapter
    }

    private fun readAhadethFile() {
        val fileContent = activity?.assets?.open("ahadeth .txt")?.bufferedReader().use {
            it?.readText()
        }
        fileContent?.let {
            val ahadethFile = fileContent.trim().split("#")
            ahadethFile.forEach {
                val title = it.trim().substringBefore('\n')
                val content = it.trim().substringAfter('\n')
                allAhadeth.add(HadethModel(title, content))
            }
        }
    }

    private fun passHadeth() {
        adapter.onItemClick = object : HadethAdapter.OnHadethClickListener {
            override fun onHadethclick(position: Int, item: HadethModel) {
                val intent = Intent(requireContext(), HadethContentActivity::class.java)
                   intent.putExtra(Constants.HADETH_CONTENT,item)
                startActivity(intent)

            }

        }
    }
}