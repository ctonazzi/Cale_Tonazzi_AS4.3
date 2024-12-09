import java.time.LocalDate;

public class PartTimeJob extends Job
{
    private double wage;
    private int hours;


    public PartTimeJob(String companyName, String position, LocalDate startDate, LocalDate endDate, double wage, int hours)
    {
        this.companyName = companyName;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.wage = wage;
        this.hours = hours;
    }

    // Calculates the income from this job per month.
    public double calculateMonthlyIncome()
    {
        double income = (wage * hours) * 4.345; // 4.345 is the average number of weeks in a month.
        return income;
    }

    // Calculates income plus any overtime hours.
    public double calculateMonthlyIncome(int overtime)
    {   
        double income = (wage * (hours + overtime)) * 4.345; 
        return income;
    }
    
    // Internal method to score the satisfaction of hours worked on a scale of 1-10.
    // Generally, a part time job would be working 30 hours or less.
    // The score given to someone working more than 30 hours is 1. Working more than 30 hours for a part time job would not be satisfactory.
    private int calculateHoursSatisfaction()
    {
        int satisfactionScore;

        if (hours == 30)
            satisfactionScore = 10;
        else if (hours <= 25)
            satisfactionScore = 8;
        else if (hours <= 20)
            satisfactionScore = 5;
        else
            satisfactionScore = 1;
        return satisfactionScore;
    }

    // Returns a string representation of hours satisfaction.
    public String evaluateHoursSatisfaction()
    {
        String evaluation;
        int satisfactionScore = calculateHoursSatisfaction();

        if (satisfactionScore == 10)
            evaluation = "Excellent";
        else if (satisfactionScore < 10 && satisfactionScore > 5)
            evaluation = "Good";
        else
            evaluation = "Poor";
        return evaluation;
    }

    // Calculates the total amount of money made during this job.
    public double calculateTotalIncome()
    {
        double income;
        income = calculateMonthlyIncome() * calculateJobDuration();
        return income;
    }

    // Assesses job satisfaction using the superclass' calculation added to the score given by the hours worked.
    // These scores are averaged together to create an overall satisfaction score.
    // This should reflect how satisfied the employee was with their hours and how long they worked at a company.
    @Override
    public int AssessJobSatisfaction()
    {
        int timeScore;
        int hoursScore;
        int score;

        timeScore = super.AssessJobSatisfaction();
        hoursScore = calculateHoursSatisfaction();

        score = (timeScore + hoursScore) / 2;
        return score;
    }

    @Override
    public void displayJobDetails()
    {
        System.out.println("Company name: " + companyName);
        System.out.println("Position: " + position);
        System.out.println("Contract duration: " + (calculateJobDuration() / 12) + " years and " + (calculateJobDuration() % 12) + " months");
        System.out.println("Monthly income: " + calculateMonthlyIncome());
        System.out.println("Job satisfaction: " + AssessJobSatisfaction() + "/10");
    }
}
