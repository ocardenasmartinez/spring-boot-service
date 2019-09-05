package cl.subtel.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.subtel.dao.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}