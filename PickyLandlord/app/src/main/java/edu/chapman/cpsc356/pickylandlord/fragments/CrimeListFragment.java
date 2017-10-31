package edu.chapman.cpsc356.pickylandlord.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.chapman.cpsc356.pickylandlord.CrimeCollection;
import edu.chapman.cpsc356.pickylandlord.R;
import edu.chapman.cpsc356.pickylandlord.models.CrimeModel;


public class CrimeListFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.fragment_crime_list, container, false);

        List<CrimeModel> crimes = CrimeCollection.GetInstance().getCrimes();

        for (CrimeModel crime : crimes)
        {
            TextView tv = new TextView(getActivity());
            tv.setText(crime.getTitle());
            tv.setPadding(10,10,10,10);
            tv.setTextSize(25);

            vg.addView(tv);
        }

        return vg;
    }
}
