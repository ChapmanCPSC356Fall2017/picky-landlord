package edu.chapman.cpsc356.pickylandlord;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.chapman.cpsc356.pickylandlord.models.CrimeModel;

public class CrimeCollection
{
    private static CrimeCollection collection;

    public static CrimeCollection GetInstance()
    {
        if (collection == null)
        {
            collection = new CrimeCollection();
        }

        return collection;
    }

    private List<CrimeModel> crimes;

    private CrimeCollection()
    {
        this.crimes = new ArrayList<>();

        // Randomly generate 100 crimes
        for (int i = 0; i < 100; ++i)
        {
            Log.i("Test", "Generating stuff");

            CrimeModel crime = new CrimeModel();
            crime.setTitle("Crime #" + (i+1));
            crime.setSolved(i % 2 == 0);

            this.crimes.add(crime);
        }
    }

    public List<CrimeModel> getCrimes()
    {
        return this.crimes;
    }

    public CrimeModel getCrime(String id)
    {
        for(CrimeModel crime : this.crimes)
        {
            if (crime.getId().equals(id))
            {
                return crime;
            }
        }

        return null;
    }
}
