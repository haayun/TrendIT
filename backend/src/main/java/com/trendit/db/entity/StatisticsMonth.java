package com.trendit.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(indexes = @Index(name = "s_month_target_time_index", columnList = "targetTime"))
public class StatisticsMonth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long statisticsMonthId;

    @Column(nullable = false)
    LocalDate targetTime;

    @Column(nullable = false)
    int frequency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyword_id")
    Keyword keyword;
}
