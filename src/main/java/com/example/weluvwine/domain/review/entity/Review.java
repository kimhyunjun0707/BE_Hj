package com.example.weluvwine.domain.review.entity;

import com.example.weluvwine.domain.member.entity.Member;
import com.example.weluvwine.domain.review.dto.ReviewRequestDto;
import com.example.weluvwine.domain.wine.entity.Wine;
import com.example.weluvwine.util.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Review extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Wine wine;

    public Review (ReviewRequestDto requestDto, Member member, Wine wine){
        this.content = requestDto.getContent();
        this.member = member;
        this.wine = wine;
    }

    public void update(ReviewRequestDto requestDto){
        this.content = requestDto.getContent();
    }
}
