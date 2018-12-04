package com.cg.capbook.daoservices;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.capbook.beans.ProfilePicture;
public interface ProfilePicDAO extends JpaRepository<ProfilePicture,String> {

}
