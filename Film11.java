public class Film11 { 
    int id; 
    String title; 
    double rating; 
    Film11 prev, next;

    public Film11(int id, String title, double rating) { 
        this.id = id; 
        this.title = title; 
        this.rating = rating; 
        this.prev = null; 
        this.next = null; 
    } 
}
