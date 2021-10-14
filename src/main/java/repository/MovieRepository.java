package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestBody;

import model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

}