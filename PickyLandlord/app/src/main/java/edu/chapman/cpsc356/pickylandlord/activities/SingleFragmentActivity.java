package edu.chapman.cpsc356.pickylandlord.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.chapman.cpsc356.pickylandlord.R;
import edu.chapman.cpsc356.pickylandlord.fragments.CrimeFragment;

public abstract class SingleFragmentActivity extends AppCompatActivity
{
    protected abstract Fragment getFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        showFragment(getFragment());
    }

    private void showFragment(Fragment frag)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_fragment_container, frag)
                .commit();
    }
}
