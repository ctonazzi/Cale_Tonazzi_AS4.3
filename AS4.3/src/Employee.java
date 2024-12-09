import java.util.ArrayList;

public class Employee
{
    private ArrayList<Job> jobs;

    // Constructor to initialize a new job history array.
    public Employee()
    {
        jobs = new ArrayList<>();
    }

    // Adds a Job type object to the job history.
    public void addJob(Job job)
    {
        jobs.add(job);
    }

    // Calls the method to display job details on all jobs in the history.
    // This is possible because the Job class has a displayJobDetails method.
    public void displayJobs()
    {
        for (Job job : jobs)
        {
            job.displayJobDetails();
        }
    }

    // Returns the sum of all job durations in months.
    public long calculateTotalWorkExperience()
    {
        long result = 0;

        for (Job job : jobs)
            result += job.calculateJobDuration();

        return result;
    }

    // Returns the average of all the satisfaction scores for each job in the job history.
    // This should be used in combination with a method to display it in a meaningful way.
    public int calculateAverageSatisfaction()
    {
        int score = 0;
        for (Job job : jobs)
            score += job.AssessJobSatisfaction();
        score /= jobs.size();

        return score;
    }
}
