package com.revature.repository;

import com.revature.models.Claim;
import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {

    List<Claim> getClaimByStatus(String status);

    List<Claim> getClaimByUser(User user);

    @Modifying
   @Query("update Claim c set c.status = :status where c.claimId = :claimId")
    void setClaimStatusById(@Param(value = "status")String status,@Param(value = "claimId") int claimId);
}
