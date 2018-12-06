package com.cg.capbook.daoservices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cg.capbook.beans.FriendRequest;

public interface FriendRequestDAO extends JpaRepository<FriendRequest, Integer>{
	@Query("select fr from FriendRequest fr where fr.senderMailID=:senderMailID and fr.receiverMailID=:receiverMailID")
	FriendRequest getFriendRequest(@Param("senderMailID") String senderMailID,@Param("receiverMailID") String receiverMailID);
}
