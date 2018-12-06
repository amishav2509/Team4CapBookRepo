package com.cg.capbook.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capbook.beans.Status;

public interface StatusDAO extends JpaRepository<Status, Integer>{

}
