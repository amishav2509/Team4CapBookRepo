package com.cg.capbook.daoservices;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cg.capbook.beans.FriendList;
import com.cg.capbook.beans.UserAccount;
public interface FriendListDAO extends JpaRepository<FriendList,Integer>{
@Query("select fl from FriendList fl where fl.user=:user")
List<FriendList> getFriendList(@Param("user") UserAccount user);
@Query("select fl from FriendList fl where fl.userMailID=:userMailID and fl.friendEmailID=:friendEmailID ")
FriendList getFriend(@Param("userMailID") String userMailID,@Param("friendEmailID") String friendEmailID);
}
