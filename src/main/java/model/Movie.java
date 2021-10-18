package model;

import javax.persistence.*;

@Entity
@Table(name="movie")
public class Movie 
{
    private int movieId;
    private int movieYear;
    private int movieTime;
	private String movieTitle;
    private String movieLanguage;
    private String movieReleasingCountry;
    private String movieReleasingDate;

    public Movie()
    {

    }

    public Movie(int movieId, int movieYear, int movieTime, String movieTitle, String movieLanguage,
            String movieReleasingCountry, String movieReleasingDate) {
        this.movieId = movieId;
        this.movieYear = movieYear;
        this.movieTime = movieTime;
        this.movieTitle = movieTitle;
        this.movieLanguage = movieLanguage;
        this.movieReleasingCountry = movieReleasingCountry;
        this.movieReleasingDate = movieReleasingDate;
    }

    @Id
    @Column(name="movieId", nullable=false)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Column(name="movieYear", nullable=false)
    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    @Column(name="movieTime", nullable=false)
    public int getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(int movieTime) {
        this.movieTime = movieTime;
    }

    @Column(name="movieTitle", nullable=false)
    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Column(name="movieLanguage", nullable=false)
    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    @Column(name="movieReleasingCountry", nullable=false)
    public String getMovieReleasingCountry() {
        return movieReleasingCountry;
    }

    public void setMovieReleasingCountry(String movieReleasingCountry) {
        this.movieReleasingCountry = movieReleasingCountry;
    }

    @Column(name="movieReleasingDate", nullable=false)
    public String getMovieReleasingDate() {
        return movieReleasingDate;
    }

    public void setMovieReleasingDate(String movieReleasingDate) {
        this.movieReleasingDate = movieReleasingDate;
    }    
    
}