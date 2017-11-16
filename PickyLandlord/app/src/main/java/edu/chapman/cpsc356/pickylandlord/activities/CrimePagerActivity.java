package edu.chapman.cpsc356.pickylandlord.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.chapman.cpsc356.pickylandlord.CrimeCollection;
import edu.chapman.cpsc356.pickylandlord.R;
import edu.chapman.cpsc356.pickylandlord.adapters.CrimePagerAdapter;

public class CrimePagerActivity extends AppCompatActivity
{
    public static final String EXTRA_CRIME_ID = "crime_id";

    private ViewPager crimePager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

        this.crimePager = findViewById(R.id.vp_crimes);

        CrimePagerAdapter adapter = new CrimePagerAdapter(getSupportFragmentManager());
        this.crimePager.setAdapter(adapter);

        String crimeId = getIntent().getStringExtra(CrimePagerActivity.EXTRA_CRIME_ID);
        int crimeIndex = CrimeCollection.GetInstance().indexOf(crimeId);

        this.crimePager.setCurrentItem(crimeIndex);
    }
}
