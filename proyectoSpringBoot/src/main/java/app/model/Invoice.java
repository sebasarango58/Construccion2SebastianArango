/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Sebastian
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @JoinColumn(name="personid")
    @OneToOne
    private Person personId;
    @OneToOne
    @JoinColumn(name="partnetId")
    private Partner partnerId;
    @Column(name="creationdate")
    private Date creation_date;
    @Column(name="amount")
    private double totalAmount;
    @Column(name="status")
    private boolean status;

    
    
    
    
    
}
