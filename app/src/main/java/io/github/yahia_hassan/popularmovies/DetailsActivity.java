package io.github.yahia_hassan.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        TextView mMovieTitleTextView = findViewById(R.id.original_title_tv);
        ImageView mMoviePosterImageView = findViewById(R.id.movie_poster_iv);
        TextView mPlotSynopsisTextView = findViewById(R.id.plot_synopsis_tv);
        TextView mUserRatingTextView = findViewById(R.id.user_rating_tv);
        TextView mReleaseDateTextView = findViewById(R.id.release_date_tv);


        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra(PopularMoviesAdapter.EXTRA_MESSAGE);
        mMovieTitleTextView.setText(movie.getMovieTitle());

        String UrlFirstPart = "https://image.tmdb.org/t/p/w780/";
        Picasso.with(this)
                .load(UrlFirstPart + movie.getMoviePoster())
                .into(mMoviePosterImageView);

        mPlotSynopsisTextView.setText(movie.getPlotSynopsis());
        mUserRatingTextView.setText(movie.getUserRating());
        mReleaseDateTextView.setText(movie.getReleaseDate());
    }
}
