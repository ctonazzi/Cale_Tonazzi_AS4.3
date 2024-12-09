import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Job
{
    protected String companyName;
    protected String position;
    protected LocalDate startDate;
    protected LocalDate endDate;

    // Displays basic information about the job, such as the company name, position, and the duration of the job.
    // Job duration is calculated through floor dividing to find the year and using the modulo operator to find remaining months.
    public void displayJobDetails()
    {
        System.out.println("Company name: " + companyName);
        System.out.println("Position: " + position);
        System.out.println("Duration: " + (calculateJobDuration() / 12) + " years and " + (calculateJobDuration() % 12) + " months");
    }

    // Returns the time between two LocalDates to the nearest month (rounded down)
    // This is done through the use of the ChronoUnit class. To my knowledge, this class is used only to describe common measurements of time.
    // This method is public in the event that someone wishes to use the job duration elsewhere.
    public long calculateJobDuration()
    {   
        return ChronoUnit.MONTHS.between(startDate, endDate);
    }

    // Returns an integer value that represents a score 1-10 of how satisfied the person was with the job.
    // This score could take into account many factors. In this abstract class, it will only take into account job duration.
    public int AssessJobSatisfaction()
    {
        int satisfactionRating = 0;
        long duration = calculateJobDuration();

        // This is where the job duration is factored into the score.
        // Presumably, the longer you worked at a company, the more satisfied you are. The rating score given does not scale linearly.
        if (duration < 12)
            satisfactionRating += 1;
        else if (duration < 24)
            satisfactionRating += 2;
        else if (duration < 36)
            satisfactionRating += 3;
        else if (duration < 60)
            satisfactionRating += 6;
        else if (duration < 120)
            satisfactionRating += 8;
        else
            satisfactionRating += 10;
        
        return satisfactionRating;
    }
}
