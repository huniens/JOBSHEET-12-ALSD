import java.util.Scanner;

public class FilmMain11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DaftarFilm11 filmList = new DaftarFilm11();
        int choice;

        do {
            System.out.println("\nMovie Data");
            System.out.println("1. Add First Data");
            System.out.println("2. Add Last Data");
            System.out.println("3. Add Data at Specific Index");
            System.out.println("4. Remove First Data");
            System.out.println("5. Remove Last Data");
            System.out.println("6. Remove Data at Specific Index");
            System.out.println("7. Print");
            System.out.println("8. Search by ID");
            System.out.println("9. Sort Movie Ratings in Descending Order");
            System.out.println("10. Exit");
            System.out.print("Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Movie ID: ");
                    int idFirst = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Movie Title: ");
                    String titleFirst = sc.nextLine();
                    System.out.print("Enter Movie Rating: ");
                    double ratingFirst = sc.nextDouble();
                    filmList.addFirstData(idFirst, titleFirst, ratingFirst);
                    break;
                case 2:
                    System.out.print("Enter Movie ID: ");
                    int idLast = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Movie Title: ");
                    String titleLast = sc.nextLine();
                    System.out.print("Enter Movie Rating: ");
                    double ratingLast = sc.nextDouble();
                    filmList.addLastData(idLast, titleLast, ratingLast);
                    break;
                case 3:
                    System.out.print("Enter Index: ");
                    int specificIndex = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Movie ID: ");
                    int specificId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Movie Title: ");
                    String specificTitle = sc.nextLine();
                    System.out.print("Enter Movie Rating: ");
                    double specificRating = sc.nextDouble();
                    filmList.addIndexData(specificIndex, specificId, specificTitle, specificRating);
                    break;
                case 4:
                    filmList.removeFirstData();
                    break;
                case 5:
                    filmList.removeLastData();
                    break;
                case 6:
                    System.out.print("Enter index to be removed: ");
                    int removeIndex = sc.nextInt();
                    filmList.removeSpecificData(removeIndex);
                    break;
                case 7:
                    filmList.print();
                    break;
                case 8:
                    System.out.print("Enter the ID of the movie you want to search: ");
                    int searchId = sc.nextInt();
                    Film11 film = filmList.searchFilmById(searchId);
                    if (film != null) {
                        System.out.println("Movie with ID " + searchId + " found:");
                        System.out.println("Title: " + film.title + ", Rating: " + film.rating);
                    } else {
                        System.out.println("Movie with ID " + searchId + " not found.");
                    }
                    break;
                case 9:
                    filmList.sortDataByRatingDesc();
                    System.out.println("Movie ratings successfully sorted in descending order.");
                    break;
                case 10:
                    System.out.println("Thank you for using our service.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 10);
        sc.close();
    }
}
