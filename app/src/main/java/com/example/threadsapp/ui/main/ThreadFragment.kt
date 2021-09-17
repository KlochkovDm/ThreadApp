package com.example.threadsapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.threadsapp.R
import com.example.threadsapp.databinding.ThreadFragmentBinding
import java.util.*
import java.util.concurrent.TimeUnit

class ThreadFragment : Fragment() {

    private var _binding : ThreadFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ThreadFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ThreadFragmentBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            binding.textView.text = startCalulation(binding.editText.text.toString().toInt())
            binding.mainContainer.addView(AppCompatTextView(it.context).apply{
                text = getString(R.string.in_main_thread)
                textSize = resources.getDimension(R.dimen.main_container_text_size)
            })
        }

    }

    private fun startCalulation(seconds: Int): CharSequence? {
        val date = Date()
        var diffInSecs: Long
        do {
            val currentDate = Date()
            val diffInMs: Long = currentDate.time - date.time
            diffInSecs = TimeUnit.MILLISECONDS.toSeconds(diffInMs)
        }while (diffInSecs<seconds)
        return diffInSecs.toString()
    }

}