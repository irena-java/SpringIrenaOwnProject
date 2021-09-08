package com.datascience.shop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ItemDTO {
    private String dataScienceSection; //    MASHINE_LEARNING,COMPUTER_VISION,NATURAL_LANGUAGE_PROCESSING,BIG_DATA
    private String dataScienceDirection; // DATA_WAREHOUSE,MATHEMATICAL_MODEL,AUTOMATION
    private String jobType;  //DEVELOPMENT,AUDIT,CORPORATE_TRAINING
    private LocalDate startDate;
    private LocalDate deadline;
    private Double price;
}