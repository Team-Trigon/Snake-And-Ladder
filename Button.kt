package com.example.snakeandladder1

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Button : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        // Initialize MediaPlayer with your MP3 file
        mediaPlayer = MediaPlayer.create(this, R.raw.button)

        // Start playing the music
        mediaPlayer?.start()
    }

    fun goTos(view: View?) {
        // Stop the music before navigating to the next activity
        mediaPlayer?.stop()
        mediaPlayer?.release()

        val nextPage = Intent(this@Button, Play::class.java)
        startActivity(nextPage)
        finish()
    }

    fun goTox(view: View?) {
        // Stop the music before navigating to the next activity
        mediaPlayer?.stop()
        mediaPlayer?.release()

        val nextPages = Intent(this@Button, Instruction::class.java)
        startActivity(nextPages)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()

        // Release the MediaPlayer when the activity is destroyed
        mediaPlayer?.release()
    }
}

