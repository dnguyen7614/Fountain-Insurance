package com.revature.controllers;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.revature.models.Claim;
import com.revature.services.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/claim-app")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    @GetMapping("/claims")
    public List<Claim> getClaims(){
        System.out.println(claimService.getAllClaims());
        return claimService.getAllClaims();
    }

    @GetMapping("/claims/{claimId}")
    public Optional<Claim> getClaimById(@PathVariable("claimId") int idParam){
        return claimService.getClaimById(idParam);
    }
    @GetMapping("/claims/status/{status}")
    public List<Claim> getClaimsByStatus(@PathVariable("status") String statusParam){
        return claimService.getClaimByStatus(statusParam);
    }

    @PostMapping("/claims")
    public Claim addNewClaim(@RequestBody Claim newClaim) {
        System.out.println(newClaim);
        return claimService.addNewClaim(newClaim);
    }
    
      @PutMapping("/claims/{claimId}")
    public void setClaimStatusById(@RequestBody Claim claim, @PathVariable("claimId") int claimId){
        claimService.setClaimStatusById(claim.getStatus(), claimId);
    }

}
