package de.htwberlin.webtech;

public class BookEntry {
     String title;
     String author;
     int releaseYear;
     int rating;

    BookEntry() {}

    public BookEntry(String title, String autor, int releaseYear) {
         this.title = title;
         this.author = autor;
         this.releaseYear = releaseYear;
     }
     public String getTitle() {
         return this.title;
     }
     public void setTitle(String title) {
        this.title = title;
     }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
