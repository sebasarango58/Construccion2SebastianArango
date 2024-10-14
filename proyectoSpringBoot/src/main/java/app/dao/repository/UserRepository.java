/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.repository;

import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sebastian
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    public User findByUsername(String username);

    public User findById(long id);

    public boolean existsByUsername(String username);

    
}
