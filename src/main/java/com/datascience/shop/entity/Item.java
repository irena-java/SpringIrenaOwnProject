package com.datascience.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "items")
public class Item extends BaseEntity {
    @Column(name = "data_science_section_id")
    private String dataScienceSection; //    MASHINE_LEARNING,COMPUTER_VISION,NATURAL_LANGUAGE_PROCESSING,BIG_DATA
    @Column(name = "data_science_direction_id")
    private String dataScienceDirection; // DATA_WAREHOUSE,MATHEMATICAL_MODEL,AUTOMATION
    @Column(name = "job_type_id")
    private String jobType;  //DEVELOPMENT,AUDIT,CORPORATE_TRAINING

    @Column(name = "start_date")
    private LocalDate startDate;
    private LocalDate deadline;
    private Double price;

    @Override
    public String toString() {
        return "Item{" +
                "Id='" + super.getId() + '\'' +
                "dataScienceSection='" + dataScienceSection + '\'' +
                ", dataScienceDirection='" + dataScienceDirection + '\'' +
                ", jobType='" + jobType + '\'' +
                ", startDate=" + startDate +
                ", deadline=" + deadline +
                ", price=" + price +
                '}';
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "items")
    private List<User> users;
}