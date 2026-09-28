import java.util.ArrayList;
import java.util.Scanner;

public class JobApplicationTracker {

    static ArrayList<JobApplication> applications =
            new ArrayList<JobApplication>();

    static Scanner sc = new Scanner(System.in);

    public static void addApplication() {

        System.out.print("Enter Application ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Company Name: ");
        String companyName = sc.nextLine();

        System.out.print("Enter Job Role: ");
        String jobRole = sc.nextLine();

        System.out.print("Enter Application Date (DD-MM-YYYY): ");
        String applicationDate = sc.nextLine();

        System.out.println("\nSelect Status:");
        System.out.println("1. Applied");
        System.out.println("2. Online Assessment");
        System.out.println("3. Interview");
        System.out.println("4. Selected");
        System.out.println("5. Rejected");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        String status = getStatus(choice);

        if (status.equals("Invalid")) {
            System.out.println("Invalid status.");
            return;
        }

        JobApplication application =
                new JobApplication(id, companyName, jobRole,
                        applicationDate, status);

        applications.add(application);

        System.out.println("Job application added successfully!");
    }

    public static String getStatus(int choice) {

        switch (choice) {

            case 1:
                return "Applied";

            case 2:
                return "Online Assessment";

            case 3:
                return "Interview";

            case 4:
                return "Selected";

            case 5:
                return "Rejected";

            default:
                return "Invalid";
        }
    }

    public static void viewApplications() {

        if (applications.isEmpty()) {
            System.out.println("No job applications found.");
            return;
        }

        System.out.println("\n===== ALL JOB APPLICATIONS =====");

        for (JobApplication application : applications) {
            application.displayApplication();
        }
    }

    public static void searchByCompany() {

        sc.nextLine();

        System.out.print("Enter company name to search: ");
        String company = sc.nextLine();

        boolean found = false;

        for (JobApplication application : applications) {

            if (application.getCompanyName()
                    .equalsIgnoreCase(company)) {

                application.displayApplication();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No application found for this company.");
        }
    }

    public static void updateStatus() {

        System.out.print("Enter Application ID: ");
        int id = sc.nextInt();

        for (JobApplication application : applications) {

            if (application.getId() == id) {

                System.out.println("\nSelect New Status:");
                System.out.println("1. Applied");
                System.out.println("2. Online Assessment");
                System.out.println("3. Interview");
                System.out.println("4. Selected");
                System.out.println("5. Rejected");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                String newStatus = getStatus(choice);

                if (newStatus.equals("Invalid")) {
                    System.out.println("Invalid status.");
                    return;
                }

                application.setStatus(newStatus);

                System.out.println("Application status updated!");
                return;
            }
        }

        System.out.println("Application not found.");
    }

    public static void deleteApplication() {

        System.out.print("Enter Application ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < applications.size(); i++) {

            if (applications.get(i).getId() == id) {

                applications.remove(i);

                System.out.println("Application deleted successfully!");
                return;
            }
        }

        System.out.println("Application not found.");
    }

    public static void filterByStatus() {

        sc.nextLine();

        System.out.println("\nEnter status:");
        System.out.println("Applied");
        System.out.println("Online Assessment");
        System.out.println("Interview");
        System.out.println("Selected");
        System.out.println("Rejected");

        System.out.print("Status: ");
        String status = sc.nextLine();

        boolean found = false;

        for (JobApplication application : applications) {

            if (application.getStatus()
                    .equalsIgnoreCase(status)) {

                application.displayApplication();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No applications found with this status.");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("       JOB APPLICATION TRACKER");
            System.out.println("==================================");

            System.out.println("1. Add Job Application");
            System.out.println("2. View All Applications");
            System.out.println("3. Search by Company");
            System.out.println("4. Update Application Status");
            System.out.println("5. Delete Application");
            System.out.println("6. Filter by Status");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addApplication();
                    break;

                case 2:
                    viewApplications();
                    break;

                case 3:
                    searchByCompany();
                    break;

                case 4:
                    updateStatus();
                    break;

                case 5:
                    deleteApplication();
                    break;

                case 6:
                    filterByStatus();
                    break;

                case 7:
                    System.out.println(
                            "Thank you for using Job Application Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}


