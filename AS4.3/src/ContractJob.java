import java.time.LocalDate;

public class ContractJob extends Job
{
    private int payment;
    private String contractStatus;

    public ContractJob(String companyName, String position, LocalDate startDate, LocalDate endDate, int payment, String contractStatus)
    {
        this.companyName = companyName;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payment = payment;
        this.contractStatus = contractStatus;
    }

    // Returns the amount of money this employee was paid per month for this contract.
    // This needs to exist because this job does not pay an hourly rate.
    // Instead, we use this to find the hourly rate from the given total payment of the contract.
    public double calculateMonthlyRate()
    {
        double rate;
        rate = payment / super.calculateJobDuration();
        return rate;
    }

    // Returns true if contract is complete.
    // Else, returns false.
    public Boolean isContractComplete()
    {
        if (contractStatus.equals("Complete"))
            return true;
        else
            return false;
    }

    // Displays job details related to this job.
    @Override
    public void displayJobDetails()
    {
        System.out.println("Company name: " + companyName);
        System.out.println("Position: " + position);
        System.out.println("Duration: " + (calculateJobDuration() / 12) + " years and " + (calculateJobDuration() % 12) + " months");
        System.out.println("Monthly rate: " + calculateMonthlyRate());
        System.out.println("Contract status: " + contractStatus);
    }

    @Override
    public int AssessJobSatisfaction()
    {
        int satisfactionRating = 0;
        
        satisfactionRating += super.AssessJobSatisfaction();
        // Reduce score if contract was incomplete.
        if (isContractComplete())
            satisfactionRating += 1;
        else   
            satisfactionRating += 10;
        
        return satisfactionRating / 2;
    }
}
