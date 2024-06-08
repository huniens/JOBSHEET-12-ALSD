public class DaftarFilm11 {
    public Film11 head, tail;

    public void addFirstData(int id, String title, double rating) {
        Film11 newFilm11 = new Film11(id, title, rating);
        if (head == null) {
            head = tail = newFilm11;
        } else {
            newFilm11.next = head;
            head.prev = newFilm11;
            head = newFilm11;
        }
    }

    public void addLastData(int id, String title, double rating) {
        Film11 newFilm11 = new Film11(id, title, rating);
        if (head == null) {
            head = tail = newFilm11;
        } else {
            tail.next = newFilm11;
            newFilm11.prev = tail;
            tail = newFilm11;
        }
    }

    public void addIndexData(int index, int id, String title, double rating) {
        if (index < 0) {
            System.out.println("Invalid index.");
            return;
        }
        Film11 newFilm11 = new Film11(id, title, rating);
        if (index == 0) {
            addFirstData(id, title, rating);
        } else {
            Film11 current = head;
            int i = 0;
            while (i < index - 1 && current != null) {
                current = current.next;
                i++;
            }
            if (current == null) {
                System.out.println("Invalid index.");
                return;
            }
            newFilm11.next = current.next;
            if (current.next != null) {
                current.next.prev = newFilm11;
            }
            current.next = newFilm11;
            newFilm11.prev = current;
        }
    }

    public void removeFirstData() {
        if (head == null) {
            System.out.println("The movie list is empty.");
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
    }

    public void removeLastData() {
        if (head == null) {
            System.out.println("The movie list is empty.");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void removeSpecificData(int index) {
        if (index < 0 || head == null) {
            System.out.println("Invalid index.");
            return;
        }
        if (index == 0) {
            removeFirstData();
            return;
        }
        Film11 current = head;
        int i = 0;
        while (i < index && current != null) {
            current = current.next;
            i++;
        }
        if (current == null) {
            System.out.println("Invalid index.");
            return;
        }
        if (current == tail) {
            removeLastData();
        } else {
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("The movie list is empty.");
            return;
        }
        System.out.println("Movie List:");
        Film11 current = head;
        while (current != null) {
            System.out.println("ID: " + current.id + ", Title: " + current.title + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    public Film11 searchFilmById(int id) {
        Film11 current = head;
        while (current != null) {
            if (current.id == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void sortDataByRatingDesc() {
        if (head == null || head == tail) {
            return;
        }
        Film11 current = head;
        while (current != null) {
            Film11 maxRatingFilm = current;
            Film11 temp = current.next;
            while (temp != null) {
                if (temp.rating > maxRatingFilm.rating) {
                    maxRatingFilm = temp;
                }
                temp = temp.next;
            }
            if (maxRatingFilm != current) {
                int tempId = current.id;
                String tempTitle = current.title;
                double tempRating = current.rating;
                current.id = maxRatingFilm.id;
                current.title = maxRatingFilm.title;
                current.rating = maxRatingFilm.rating;
                maxRatingFilm.id = tempId;
                maxRatingFilm.title = tempTitle;
                maxRatingFilm.rating = tempRating;
            }
            current = current.next;
        }
    }
}
