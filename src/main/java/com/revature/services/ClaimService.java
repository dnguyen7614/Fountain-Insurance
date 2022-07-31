package com.revature.services;

import com.revature.models.Claim;
import com.revature.models.User;
import com.revature.repository.ClaimRepository;
import com.revature.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ClaimService {

@Autowired
private ClaimRepository repository;

@Autowired
private UserRepository userRepository;

  public ClaimService() {

    }

    public List<Claim> getAllClaims() {
        return repository.findAll();
    }

    public Claim addNewClaim(Claim newClaim) {
    return repository.save(newClaim);
  }

  public List<Claim> getClaimByStatus(String status){
      return repository.getClaimByStatus(status);
  }

  public List<Claim> getClaimByUser(User user){
      return repository.getClaimByUser(user);
  }



  public Optional<Claim> getClaimById(int claimId) {
      return repository.findById(claimId);
  }
  public void setClaimStatusById(String status, int claimId){
      repository.setClaimStatusById(status, claimId);
  }

}
