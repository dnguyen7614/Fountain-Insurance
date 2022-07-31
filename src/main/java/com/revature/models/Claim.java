package com.revature.models;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table(name = "claims")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "claimId")
    private int claimId;

    @NotNull
    @NotEmpty
    @Column(name="description")
    private String description;

    @NotNull
    @Min(0)
    @Max(10000)
    @Column(name="amount")
    private double amount;

    @NotNull
    @NotEmpty
    @Column(name="email", unique = true)
    private String email;

    @NotNull
    @Column(name="date")
    private LocalDate date;
    @ManyToOne
    private User user;
    private String status;


    public Claim() {
    }
    public Claim(int claimId, String description, double amount, LocalDate date, User user, String status){
        this.claimId = claimId;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.user = user;
        this.status = status;
    }


    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Claim claim = (Claim) o;
        return claimId == claim.claimId && Objects.equals(description, claim.description) && Objects.equals(amount, claim.amount) && Objects.equals(date, claim.date) && Objects.equals(status, claim.status) && Objects.equals(user, claim.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(claimId, description, amount, date, status, user);
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId=" + claimId +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", status=" + status +
                ", user=" + user +
                '}';
    }
}
