import java.util.Scanner;

public class VaksinMain11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vaksin11 queue = new Vaksin11();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add vaccine recipient data");
            System.out.println("2. Remove vaccine recipient data");
            System.out.println("3. List of vaccine recipients");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the vaccine recipient: ");
                    String name = sc.nextLine();
                    queue.enqueue(name);
                    System.out.println("Vaccine recipient data successfully added.");
                    break;
                case 2:
                    String removedName = queue.dequeue();
                    if (removedName != null) {
                        System.out.println("The vaccine recipient named " + removedName + " has been vaccinated.");
                    } else {
                        System.out.println("No vaccine recipients in queue.");
                    }
                    break;
                case 3:
                    queue.printQueue();
                    System.out.println("Remaining queue size: " + queue.getSize());
                    break;
                case 4:
                    System.out.println("Thank you for using our service.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        sc.close();
    }
}
