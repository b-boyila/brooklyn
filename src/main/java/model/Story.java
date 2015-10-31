package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ktagintsev on 09.10.15.
 */
@Entity
@Table(name = "comments")
public class Story implements Serializable {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateOfCall")
    private String dateOfCall;

    @Column(name = "comment")
    private String comment;


    public Story() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateOfCall() {
        return dateOfCall;
    }

    public void setDateOfCall(String dateOfCall) {
        this.dateOfCall = dateOfCall;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
