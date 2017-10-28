package edu.chapman.cpsc356.pickylandlord.models;

import org.joda.time.DateTime;

import java.util.UUID;

public class CrimeModel
{
    private String id;
    private String title;
    private boolean solved;
    private DateTime date;

    public CrimeModel()
    {
        this.id = UUID.randomUUID().toString();
        this.date = DateTime.now();
    }

    public String getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean isSolved()
    {
        return solved;
    }

    public void setSolved(boolean solved)
    {
        this.solved = solved;
    }

    public DateTime getDate()
    {
        return date;
    }
}
