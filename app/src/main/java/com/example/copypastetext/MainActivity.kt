package com.example.copypastetext

import android.content.ClipData
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.copypastetext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var clipboardManager: ClipboardManager
    lateinit var clipData: ClipData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //code copy text
        binding.buttonCopyText.setOnClickListener {
            val copyText = binding.editTextTitle.text.toString()
            clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            clipData  = ClipData.newPlainText("copied",copyText)
            clipboardManager.setPrimaryClip(clipData)
        }

        binding.buttonPasteText.setOnClickListener {
            val paste = clipboardManager.primaryClip
            binding.editTextPaste.setText(paste.toString())
        }

    }
}