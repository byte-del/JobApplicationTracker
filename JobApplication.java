public class JobApplication {

    private int id;
    private String companyName;
    private String jobRole;
    private String applicationDate;
    private String status;

    public JobApplication(int id, String companyName, String jobRole,
                          String applicationDate, String status) {

        this.id = id;
        this.companyName = companyName;
        this.jobRole = jobRole;
        this.applicationDate = applicationDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobRole() {
        return jobRole;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayApplication() {

        System.out.println("Application ID: " + id);
        System.out.println("Company: " + companyName);
        System.out.println("Job Role: " + jobRole);
        System.out.println("Application Date: " + applicationDate);
        System.out.println("Status: " + status);
        System.out.println("--------------------------------");
    }
}

