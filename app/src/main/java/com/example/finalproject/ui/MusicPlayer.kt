package com.example.finalproject.ui

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.widget.Toast
import com.example.finalproject.R


class MusicPlayer :Service(){
    private lateinit var player:MediaPlayer
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, R.raw.pianomusic)
        player.setLooping(true)

        // starting the process
        player.start()
        Toast.makeText(applicationContext,"music on",Toast.LENGTH_SHORT).show()
        // returns the status of the program
        return START_STICKY
    }

    // execution of the service will stop on calling this method
    override fun onDestroy() {
        Toast.makeText(applicationContext,"music off",Toast.LENGTH_SHORT).show()
        player.stop()
        super.onDestroy()

        // stopping the process

    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }


}
