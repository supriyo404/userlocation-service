package com.supriyo.userlocation.repository;

import com.supriyo.userlocation.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
