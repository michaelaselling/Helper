package com.example.micka.drinkgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


/**
 * Activity that handles the power drinking game. This game takes
 * a random video that contains a word or sentence several times
 * and each time the contestant hears that word they have to drink.
 */
public class PowerDrinkActivity extends YouTubeBaseActivity {

    private String API_KEY = "AIzaSyD53i4xbG_ZUcysQo99rSwDdNCM1W4gA2g";

    private Button playVideoButton;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onPlayInitializedListener;
    private HashMap<String, String> powerDrinkSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.power_drink_activity);

        initListOfSongs();
        initYouTubeComponents();
        initPlayVideoButtons();
    }

    /**
     * Initializes the youtubeplayerView and listener to start youtube video.
     */
    private void initYouTubeComponents() {
        if (null == youTubePlayerView) {
            youTubePlayerView = findViewById(R.id.youtubeView);
        }

        if (null == onPlayInitializedListener) {
            onPlayInitializedListener = new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    String randomKey = getRandom(powerDrinkSongs);
                    String randomSong = powerDrinkSongs.get(randomKey);
                    youTubePlayer.loadVideo(randomSong);
                    TextView drinkingWord = findViewById(R.id.power_drink_word);
                    drinkingWord.setText(getString(R.string.drinking_word_title, randomKey));
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                   //Not needed
                }
            };
        }
    }

    /**
     * Initializes the play button with a listener.
     */
    private void initPlayVideoButtons() {
        if (null == playVideoButton) {
            playVideoButton = findViewById(R.id.play_video_button);
        }
        playVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(API_KEY, onPlayInitializedListener);
            }
        });

    }

    /**
     * Initializes the map with a word or sentence as key and
     * URL as value.
     */
    private void initListOfSongs() {
        if (null == powerDrinkSongs) {
            powerDrinkSongs = new HashMap<>();
        }
        powerDrinkSongs.put("Break your heart","y_SI2EDM6Lo"); // Taio Cruz - Break your heart
        powerDrinkSongs.put("Baby","kffacxfA7G4"); // Just Bieber - Baby
        powerDrinkSongs.put("Beat it","T2PAkPp0_bY"); // Michael Jackson - Beat it
        powerDrinkSongs.put("Hey ya","Fi8rsCncwF8"); // OutKast - Hey Ya!
        powerDrinkSongs.put("Roxanne","3T1c7GkzRQQ"); // The Police - Roxanne
        powerDrinkSongs.put("Who let the dogs out","Qkuu0Lwb5EM"); // Bahamen - Who let the dogs out
        powerDrinkSongs.put("Best","h_L4Rixya64"); // Foo fighters - Best of you
        powerDrinkSongs.put("Shots","h-VTua1tZQs"); // LMFAO ft. Lil Jon - Shots
        powerDrinkSongs.put("Tacata","oqFtayBRdfs"); // Tacabro - Tacata
        powerDrinkSongs.put("Ont","hvkShLKfl54"); // Lena Philipson - Det gör ont
        powerDrinkSongs.put("Sorry","fRh_vgS2dFE"); // Justin Bieber - Sorry
        powerDrinkSongs.put("Happy","ZbZSe6N_BXs"); // Pharrell Williams - Happy
        powerDrinkSongs.put("My Hump","iEe_eraFWWs"); // The Black Eyed Peas - My Hump
        powerDrinkSongs.put("No","cMTAUr3Nm6I"); // Meghan Tranor - NO
    }

    /**
     * Gets random song from list.
     *
     * @param aMap The list of songs.
     * @return A random song.
     */
    private String getRandom(HashMap<String, String> aMap) {
        Random random = new Random();
        List<String> keys = new ArrayList<>(aMap.keySet());
        return keys.get(random.nextInt(keys.size()));
    }
}
