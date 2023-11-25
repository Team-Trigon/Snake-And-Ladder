package com.example.snakeandladder1

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Initialize MediaPlayer with your MP3 file
        mediaPlayer = MediaPlayer.create(this, R.raw.splash)

        // Start playing the music
        mediaPlayer?.start()

        val myThread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(4000)
                    val intent = Intent(applicationContext, Button::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        myThread.start()
    }

    override fun onDestroy() {
        super.onDestroy()

        // Release the MediaPlayer when the activity is destroyed
        mediaPlayer?.release()
    }
}
