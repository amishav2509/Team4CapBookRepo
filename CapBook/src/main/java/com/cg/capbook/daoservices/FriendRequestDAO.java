package com.cg.capbook.daoservices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cg.capbook.beans.FriendRequest;

public interface FriendRequestDAO extends JpaRepository<FriendRequest, Integer>{
	@Query("select fr from FriendRequest fr where fr.senderMailID=:senderEmailID and fr.receiverMailID=:receiverEmailID")
	FriendRequest getFriendRequest(@Param("senderMailID") String senderEmailID,@Param("receiverMailID") String receiverEmailID);
}
