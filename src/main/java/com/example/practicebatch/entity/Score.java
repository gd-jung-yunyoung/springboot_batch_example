package com.example.practicebatch.entity;

import lombok.*;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;

@Entity(immutable = true)
@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    private Long id;

    @Column(name = "math")
    private Integer mathScore;

    @Column(name = "english")
    private Integer englishScore;
}
