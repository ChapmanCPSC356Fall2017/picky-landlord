package edu.chapman.cpsc356.pickylandlord.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import edu.chapman.cpsc356.pickylandlord.CrimeCollection;
import edu.chapman.cpsc356.pickylandlord.fragments.CrimeFragment;
import edu.chapman.cpsc356.pickylandlord.models.CrimeModel;


public class CrimePagerAdapter extends FragmentStatePagerAdapter
{
    public CrimePagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        CrimeModel crime = CrimeCollection.GetInstance().getCrimes().get(position);

        CrimeFragment frag = new CrimeFragment();

        Bundle args = new Bundle();
        args.putString(CrimeFragment.ARG_CRIME_ID, crime.getId());

        frag.setArguments(args);

        return frag;
    }

    @Override
    public int getCount()
    {
        return CrimeCollection.GetInstance().getCrimes().size();
    }
}
