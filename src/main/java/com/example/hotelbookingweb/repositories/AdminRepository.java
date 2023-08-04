package com.example.hotelbookingweb.repositories;

import com.example.hotelbookingweb.entities.AdminEntity;
import com.example.hotelbookingweb.entities.GuestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminRepository {

    @Select("select * from my_hotel_web.admin_table")
    List<AdminEntity> findAllAdmins();

    @Select("select * from my_hotel_web.admin_table where admin_id = #{username}")
    Optional<AdminEntity> findByUsername(String username);
}
