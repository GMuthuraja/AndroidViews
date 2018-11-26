package app.example.app.androidviews;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    RatingBar rBar;
    Float rating_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rBar=(RatingBar)findViewById(R.id.ratingBar);

        rBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rating_value = rating;
            }
        });
    }

    public void registerCompletion(View v){
        if(rating_value == null){
            Toast.makeText(getApplicationContext(), "Please give a rating!",Toast.LENGTH_SHORT).show();
        }else {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", "YES");
            resultIntent.putExtra("rating", rating_value+"");
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        }
    }

    @Override
    public void onBackPressed(){
        Intent resultIntent  = new Intent();
        resultIntent.putExtra("result","YES");
        setResult(Activity.RESULT_CANCELED,resultIntent);
        finish();
    }

}
