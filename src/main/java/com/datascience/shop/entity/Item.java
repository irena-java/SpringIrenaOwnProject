package com.datascience.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
//@Data
//@ToString(exclude = "items")
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
//    @Temporal(TemporalType.DATE)
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
//@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "baskets",
//            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
//    private Set<User> users;


    @ManyToMany (fetch = FetchType.EAGER, mappedBy = "items")
    private List<User> users;


    //            joinColumns = @JoinColumn(name = "user_id"),
    //          inverseJoinColumns = @JoinColumn(name = "item_id"))


//    public Item() {
//    }
//
//    public Item(Integer id, String dataScienceSection, String dataScienceDirection, String jobType, LocalDate startDate, LocalDate deadline, Double price) {
//        super(id);
//        this.dataScienceSection = dataScienceSection;
//        this.dataScienceDirection = dataScienceDirection;
//        this.jobType = jobType;
//        this.startDate = startDate;
//        this.deadline = deadline;
//        this.price = price;
//    }
//
//    public Item(String dataScienceSection, String dataScienceDirection, String jobType, LocalDate startDate, LocalDate deadline, Double price) {
//        this.dataScienceSection = dataScienceSection;
//        this.dataScienceDirection = dataScienceDirection;
//        this.jobType = jobType;
//        this.startDate = startDate;
//        this.deadline = deadline;
//        this.price = price;
//    }

//    public String getDataScienceSection() {
//        return dataScienceSection;
//    }
//
////    public void setDataScienceSection(String dataScienceSection) {
////        this.dataScienceSection =dataScienceSection;
////}
//
//    public String getDataScienceDirection() {
//        return dataScienceDirection;
//    }
//
////    public void setDataScienceDirection(String dataScienceDirection) {
////        this.dataScienceDirection = dataScienceDirection;
////    }
//
//    public String getJobType() {
//        return jobType;
//    }
//
////    public void setJobType(String jobType) {
////        this.jobType = jobType;
////    }
//
//    public LocalDate getStartDate() {
//        return startDate;
//    }
//
////    public void setStartDate(LocalDate startDate) {
////        this.startDate = startDate;
////    }
//
//    public LocalDate getDeadline() {
//        return deadline;
//    }
//
////    public void setDeadline(LocalDate deadline) {
////        this.deadline = deadline;
////    }
//
//    public Double getPrice() {
//        return price;
//    }
//
////    public void setPrice(Double price) {
////        this.price = price;
////    }
//
//    @Override
//    public String toString() {
//        return "Item{" +
//                "id='" + getId() + '\'' +
//                "dataScienceSection='" + dataScienceSection + '\'' +
//                ", dataScienceDirection='" + dataScienceDirection + '\'' +
//                ", jobType='" + jobType + '\'' +
//                ", startDate=" + startDate +
//                ", deadline=" + deadline +
//                ", price=" + price +
//                '}' + "\n";
//    }
//
//    public static Builder builder() {
//        return new Item().new Builder();
//
//    }
//
//public class Builder {
//    public Builder dataScienceSection(String dataScienceSection) {
//        Item.this.dataScienceSection = dataScienceSection;
//        return this;
//    }
//
//    public Builder dataScienceDirection(String dataScienceDirection) {
//        Item.this.dataScienceDirection = dataScienceDirection;
//        return this;
//    }
//
//    public Builder jobType(String jobType) {
//        Item.this.jobType = jobType;
//        return this;
//    }
//
//    public Builder startDate(LocalDate startDate) {
//        Item.this.startDate = startDate;
//        return this;
//    }
//
//    public Builder deadline(LocalDate deadline) {
//        Item.this.deadline = deadline;
//        return this;
//    }
//
//    public Builder price(Double price) {
//        Item.this.price = price;
//        return this;
//    }
//
//    public Item build() {
//        return Item.this;
//    }
//}
}