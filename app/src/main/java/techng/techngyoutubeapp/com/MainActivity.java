package techng.techngyoutubeapp.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youTubePlayerView;
    private static final String GOOGLE_API_KEY = "AIzaSyAcYJcJR3dGxSnrv2B8VtCi6SrVI0Y6UD0";

    private YouTubePlayer.PlaybackEventListener playbackEventListener;
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();
        ouvinteDoYoutube();
        ouvinteDeMudancaDeEstado();

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean foiRestaurado) {

        //youTubePlayer.loadVideo("cbfajxqboBE");
        //youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener( playerStateChangeListener );
        if (!foiRestaurado) {
            //youTubePlayer.cueVideo("cbfajxqboBE");
            youTubePlayer.cuePlaylist("PLHz_AreHm4dkZ9-atkcmcBaMZdmLHft8n");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(getApplication(), "Player não foi iniciado!" + youTubeInitializationResult.toString(), Toast.LENGTH_LONG).show();
    }

    public void ouvinteDoYoutube() {

        playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {
                Toast.makeText(MainActivity.this,
                        "O player está rodando",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPaused() {
                Toast.makeText(MainActivity.this,
                        "O player está pausado",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopped() {
                Toast.makeText(MainActivity.this,
                        "O player foi parado",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBuffering(boolean b) {
                Toast.makeText(MainActivity.this,
                        "O player está carregando",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSeekTo(int i) {
                Toast.makeText(MainActivity.this,
                        "Movimentando a seekbar",
                        Toast.LENGTH_SHORT).show();
            }
        };

    }

    public void ouvinteDeMudancaDeEstado() {
        playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {
                Toast.makeText(MainActivity.this,
                        "Video carregando",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLoaded(String s) {
                Toast.makeText(MainActivity.this,
                        "Video carregado",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdStarted() {
                Toast.makeText(MainActivity.this,
                        "Propaganda iniciou",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onVideoStarted() {
                Toast.makeText(MainActivity.this,
                        "Video está começando",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onVideoEnded() {
                Toast.makeText(MainActivity.this,
                        "Video chegou ao final",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {
                Toast.makeText(MainActivity.this,
                        "Erro ao recuperar eventos de carregamento!",
                        Toast.LENGTH_SHORT).show();
            }
        };
    }

    public void iniciarComponentes() {

        youTubePlayerView = findViewById(R.id.viewYoutubePlayer);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);

    }
}