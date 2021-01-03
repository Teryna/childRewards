package com.example.rewards.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "points")
    private int points;
    @Column(name = "isItDone")
    private byte isItDone;
    @Column(name = "totalPoints")
    private int totalPoints;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name="child_id", referencedColumnName = "id", nullable = false)
    private Child child;


    public int countOfPoints(int points, byte isItDone, int totalPoints) {
        if(isItDone == 1) {
            totalPoints = totalPoints + points;
        }
        return totalPoints;
    }

}
