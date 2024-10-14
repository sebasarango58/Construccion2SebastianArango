/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.repository;

import app.model.Partner;
import app.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sebastian
 */
@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long>{
    
   public Partner findById(long id);

    public boolean existsByUserId(User user);

    public Partner findByUserId(User user);
    
    
}
