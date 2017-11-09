package edu.chapman.cpsc356.pickylandlord.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import edu.chapman.cpsc356.pickylandlord.fragments.CrimeFragment;

public class CrimeActivity extends SingleFragmentActivity
{
    public static final String EXTRA_CRIME_ID = "crime_id";

    @Override
    protected Fragment getFragment()
    {
        Bundle extras = getIntent().getExtras();

        CrimeFragment frag = new CrimeFragment();
        frag.setArguments(extras);

        return frag;
    }
}
