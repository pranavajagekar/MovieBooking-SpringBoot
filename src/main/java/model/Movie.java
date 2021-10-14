package model;

import javax.persistence.*;

@Entity
@Table(name="Movie")
public class Movie 
{
    private int movieId;
	private String moviename;
	private String genre;

    public Movie()
    {

    }
    public Movie(int movieId, String moviename, String genre) {
        this.movieId = movieId;
        this.moviename = moviename;
        this.genre = genre;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="movieId", nullable=false)
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    @Column(name="moviename", nullable=false)
    public String getMoviename() {
        return moviename;
    }
    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }
    @Column(name="genre", nullable=false)
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    
}