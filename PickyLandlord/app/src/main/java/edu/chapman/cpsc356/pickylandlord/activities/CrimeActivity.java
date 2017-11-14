package edu.chapman.cpsc356.pickylandlord.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.Toast;

import edu.chapman.cpsc356.pickylandlord.R;
import edu.chapman.cpsc356.pickylandlord.fragments.CrimeFragment;
import edu.chapman.cpsc356.pickylandlord.models.CrimeModel;

public class CrimeActivity extends SingleFragmentActivity
{
    public static final String EXTRA_CRIME_ID = "crime_id";

    public static Intent BuildIntent(CrimeModel crime, Context ctx)
    {
        Intent i = new Intent(ctx, CrimeActivity.class);
        i.putExtra(CrimeActivity.EXTRA_CRIME_ID, crime.getId());

        return i;
    }

    @Override
    protected Fragment getFragment()
    {
        Bundle extras = getIntent().getExtras();

        CrimeFragment frag = new CrimeFragment();
        frag.setArguments(extras);

        return frag;
    }
}
