package de.htwberlin.webtech.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "status")
    private String status;

    public BookEntity() {}

    public BookEntity(String title, String author, int releaseYear, String status) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}