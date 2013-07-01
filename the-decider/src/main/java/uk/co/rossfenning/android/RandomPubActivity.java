package uk.co.rossfenning.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import uk.co.rossfenning.android.model.PlaceSearchResponse;
import uk.co.rossfenning.android.model.Place;

import java.util.List;
import java.util.Random;


public class RandomPubActivity extends Activity {

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut
     * down then this Bundle contains the data it most recently supplied in
     * onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final PlaceSearchResponse response
            = (PlaceSearchResponse) this.getIntent().getSerializableExtra("response");

        final List<Place> results = response.getResults();
        final Place randomPlace = results.get(
            new Random(System.currentTimeMillis()).nextInt(results.size()));

        setContentView(R.layout.activity_main);

        final TextView pubView = (TextView) findViewById(R.id.pub_name);
        pubView.setText(randomPlace.getName());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
