package com.example.hp.music_player;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/*
  * A Service is an application component that can perform long-running operations in the background
       and it does not provide a user interface.
  * Creating class Music_Service and extends it from Service base class .

 */
public class Music_Service extends Service {
    // MediaPlayer class can be used to control playback of audio/video files and streams.
    MediaPlayer mediaPlayer; //Declaring variable
    @Nullable
    @Override
    /*
    onBind()returns an IBinder object that defines the programming interface that clients
       can use to interact with the service.
     */
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() { //onCreate is Called by the system when the service is first created.
        /*
          Raw folder in Android is used to keep mp3 or ogg audio files and also video files.
         The raw folder is created inside resource folder.
         */
        // Creating & initializing Mediaplayer object by ID.
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.pappleen);
        mediaPlayer.setLooping(true); //Loop will execute till the condition is true
    }

    @Override
    // onStartCommand is called by the system every time a client explicitly starts the service.
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start(); //Starting media player

        //Providing the arguments it supplied and a unique integer token representing the start request.
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    //onDestroy is called by the system to notify a Service that it is no longer used .
    public void onDestroy() {
        mediaPlayer.stop();// Media player stops
    }
}
