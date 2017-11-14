package edu.chapman.cpsc356.pickylandlord.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import edu.chapman.cpsc356.pickylandlord.CrimeCollection;
import edu.chapman.cpsc356.pickylandlord.R;
import edu.chapman.cpsc356.pickylandlord.fragments.CrimeListFragment;
import edu.chapman.cpsc356.pickylandlord.models.CrimeModel;

public class CrimeListActivity extends SingleFragmentActivity
{
    private CrimeListFragment fragment;

    @Override
    protected Fragment getFragment()
    {
        this.fragment = new CrimeListFragment();
        return this.fragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_crime_list, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_add_crime:

                CrimeModel newCrime = new CrimeModel();
                newCrime.setTitle("Brand New Crime");
                CrimeCollection.GetInstance().getCrimes().add(0, newCrime);

                Intent crimeIntent = CrimeActivity.BuildIntent(newCrime, this);
                startActivity(crimeIntent);

                return true; // We handled it

            case R.id.menu_solve_all:

                for (CrimeModel crime : CrimeCollection.GetInstance().getCrimes())
                {
                    crime.setSolved(true);
                }

                this.fragment.notifyDataChanged();
                return true;

            default:
                return false;
        }
    }
}
