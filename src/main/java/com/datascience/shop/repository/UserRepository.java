package com.datascience.shop.repository;

import com.datascience.shop.entity.Item;
import com.datascience.shop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByNameIs(String name);

    @Query(value = "select * from users where name=:name_param", nativeQuery = true)
    List<User> userRrr(@Param("name_param") String name);

    @Query(value = "select u from User u where u.name='rrr'")
    List<User> userRrrrr();

    @Query("select i from Item i where size(i.users)>0")
    List<Item> basketOfUser();

    Page<User> findAllByNameContaining(String name, Pageable pageable);
}
