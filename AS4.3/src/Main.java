import java.time.LocalDate;

public class Main
{
    public static void main(String[] args) throws Exception {
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();

        // Create two new jobs and add them to Employee1.
        employee1.addJob(new FullTimeJob("Apple", "Software Engineer", LocalDate.of(2000, 7, 20), LocalDate.of(2006, 9, 24), 15, 40));
        employee1.addJob(new ContractJob("Google", "Web Developer", LocalDate.of(2010, 7, 20), LocalDate.of(2012, 9, 24), 150000, "Complete"));
        // Call the displayJobs method on the employee to show all the jobs in the history.
        employee1.displayJobs();
        // Call the two methods in the Employee class to calculate total work experience and average satisfaction.
        System.out.println("Total work experience: " + employee1.calculateTotalWorkExperience() + " months");
        System.out.println("Average satisfaction: " + employee1.calculateAverageSatisfaction() + "/10");

        // blank space between employees.
        System.out.println();

        // Create two new jobs and add them to Employee2.
        employee2.addJob(new PartTimeJob("Awesome Company", "Lead Engineer", LocalDate.of(1996, 12, 25), LocalDate.of(2010, 3, 15), 30, 30));
        employee2.addJob(new ContractJob("Self-employed", "Photographer", LocalDate.of(2010, 5, 19), LocalDate.of(2010, 8, 29), 3500, "Incomplete"));
        // Call the displayJobs method on the employee to show all the jobs in the history.
        employee2.displayJobs();
        // Call the two methods in the Employee class to calculate total work experience and average satisfaction.
        System.out.println("Total work experience: " + employee2.calculateTotalWorkExperience() + " months");
        System.out.println("Average satisfaction: " + employee2.calculateAverageSatisfaction() + "/10");

        // blank space between employees.
        System.out.println();

        // Create two new jobs and add them to Employee3.
        employee3.addJob(new PartTimeJob("Krusty Krab", "Fry cook", LocalDate.of(1996, 3, 25), LocalDate.of(2004, 9, 12), 12, 25));
        employee3.addJob(new FullTimeJob("Chum Bucket", "Owner", LocalDate.of(2004, 9, 17), LocalDate.of(2016, 1, 2), 2, 65));
        // Call the displayJobs method on the employee to show all the jobs in the history.
        employee3.displayJobs();
        // Call the two methods in the Employee class to calculate total work experience and average satisfaction.
        System.out.println("Total work experience: " + employee3.calculateTotalWorkExperience() + " months");
        System.out.println("Average satisfaction: " + employee3.calculateAverageSatisfaction() + "/10");
    }
}