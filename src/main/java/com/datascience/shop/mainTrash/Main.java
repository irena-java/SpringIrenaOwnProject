
package com.datascience.shop.mainTrash;


import com.datascience.shop.entity.Item;
import com.datascience.shop.entity.User;

public class Main {




    public static void main(String[] args)  {

        Item item11=Item.builder()
                .dataScienceSection("fdf")
                .dataScienceDirection("hgfg")
                .jobType("fgfg")
                .build();


        User user7=User.builder()
                .name("dfd")
                .clientInn("454545")
        .build();

        user7.setClientInn("ghgh");
    //    User user18=new User(17,"ghfghf","fghfghfg","fgdfg")

    }



}


