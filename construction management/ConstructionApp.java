 import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.Scanner;

class ConstructionApp {
    private static Map<String, String> adminCredentials;
    private static List<ConstructionMaterial> materialList;
    private static List<Labor> laborList;

    public static void main(String[] args) {
        initializeData();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Construction Material Buy and Sell App");
        System.out.println("--------------------------------------");

        // Login
        boolean loggedIn = false;
        String username, password;
        do {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            loggedIn = login(username, password);
            if (!loggedIn) {
                System.out.println("Invalid credentials. Please try again.\n");
            }
        } while (!loggedIn);

        // Menu
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Buy Construction Material");
            System.out.println("2. Sell Construction Material");
            System.out.println("3. Manage Labor Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    buyConstructionMaterial(scanner);
                    break;
                case 2:
                    sellConstructionMaterial(scanner);
                    break;
                case 3:
                    manageLaborDetails(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the Construction App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void initializeData() {
        adminCredentials = new HashMap<>();
        adminCredentials.put("admin", "admin123");

        materialList = new ArrayList<>();
        materialList.add(new ConstructionMaterial("Cement", 100));
        materialList.add(new ConstructionMaterial("Bricks", 50));
        materialList.add(new ConstructionMaterial("Sand", 200));
        materialList.add(new ConstructionMaterial("Steel Bars", 500));

        laborList = new ArrayList<>();
        laborList.add(new Labor("John Doe", "Mason", 1000));
        laborList.add(new Labor("Jane Smith", "Carpenter", 900));
        laborList.add(new Labor("Mike Johnson", "Electrician", 1100));
    }

    private static boolean login(String username, String password) {
        if (adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password)) {
            System.out.println("\nWelcome, Admin!\n");
            return true;
        } else {
            return false;
        }
    }

    private static void buyConstructionMaterial(Scanner scanner) {
        System.out.println("\nAvailable Construction Materials:");
        for (int i = 0; i < materialList.size(); i++) {
            ConstructionMaterial material = materialList.get(i);
            System.out.println((i + 1) + ". " + material.getName() + " (Price: $" + material.getPrice() + ")");
        }

        System.out.print("Enter the material number to buy: ");
        int materialNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (materialNumber >= 1 && materialNumber <= materialList.size()) {
            ConstructionMaterial selectedMaterial = materialList.get(materialNumber - 1);
            System.out.print("Enter the quantity to buy: ");
            int quantity = scanner.nextInt();

            // Perform the buy operation (you can add your own logic here)
            System.out.println(quantity + " units of " + selectedMaterial.getName() + " bought successfully!");
        } else {
            System.out.println("Invalid material number.");
        }
    }

    private static void sellConstructionMaterial(Scanner scanner) {
        System.out.println("\nAvailable Construction Materials:");
        for (int i = 0; i < materialList.size(); i++) {
            ConstructionMaterial material = materialList.get(i);
            System.out.println((i + 1) + ". " + material.getName() + " (Price: $" + material.getPrice() + ")");
        }

        System.out.print("Enter the material number to sell: ");
        int materialNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (materialNumber >= 1 && materialNumber <= materialList.size()) {
            ConstructionMaterial selectedMaterial = materialList.get(materialNumber - 1);
            System.out.print("Enter the quantity to sell: ");
            int quantity = scanner.nextInt();

            // Perform the sell operation (you can add your own logic here)
            System.out.println(quantity + " units of " + selectedMaterial.getName() + " sold successfully!");
        } else {
            System.out.println("Invalid material number.");
        }
    }

    private static void manageLaborDetails(Scanner scanner) {
        System.out.println("\nLabor Details:");
        for (int i = 0; i < laborList.size(); i++) {
            Labor labor = laborList.get(i);
            System.out.println((i + 1) + ". " + labor.getName() + " (" + labor.getRole() + ", Salary: $" + labor.getSalary() + ")");
        }

        System.out.println("\nOptions:");
        System.out.println("1. Add Labor");
        System.out.println("2. Remove Labor");
        System.out.print("Enter your choice: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (option) {
            case 1:
                System.out.print("Enter the labor name: ");
                String name = scanner.nextLine();
                System.out.print("Enter the labor role: ");
                String role = scanner.nextLine();
                System.out.print("Enter the labor salary: ");
                double salary = scanner.nextDouble();

                // Perform the add labor operation (you can add your own logic here)
                laborList.add(new Labor(name, role, salary));
                System.out.println("Labor added successfully!");
                break;
            case 2:
                System.out.print("Enter the labor number to remove: ");
                int laborNumber = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (laborNumber >= 1 && laborNumber <= laborList.size()) {
                    Labor removedLabor = laborList.remove(laborNumber - 1);
                    System.out.println(removedLabor.getName() + " removed successfully!");
                } else {
                    System.out.println("Invalid labor number.");
                }
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}

class ConstructionMaterial {
    private String name;
    private double price;

    public ConstructionMaterial(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Labor {
    private String name;
    private String role;
    private double salary;

    public Labor(String name, String role, double salary) {
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }
}
{
}
