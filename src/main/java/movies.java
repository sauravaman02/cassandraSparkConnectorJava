import org.apache.spark.sql.catalyst.expressions.Uuid;

import java.io.Serializable;

public class movies implements Serializable {

    private Uuid movie_id;
    private String title;
    private int release_year;

    //constructor
    movies(Uuid movie_id, String title, int release_year){

        this.movie_id=movie_id;
        this.title=title;
        this.release_year= release_year;
    }

    //getters

    public int getRelease_year() {
        return release_year;
    }

    public String getTitle() {
        return title;
    }

    public Uuid getMovie_id() {
        return movie_id;
    }

    //setter


    public void setMovie_id(Uuid movie_id) {
        this.movie_id = movie_id;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
