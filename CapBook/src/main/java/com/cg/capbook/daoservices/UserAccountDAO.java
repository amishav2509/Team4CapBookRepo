package com.cg.capbook.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capbook.beans.UserAccount;

public interface UserAccountDAO extends JpaRepository<UserAccount,String> {

}
