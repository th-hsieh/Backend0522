package org.Stasy.SpringBootBackend.repository;

import org.Stasy.SpringBootBackend.entity.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CollaboratorsRepository extends JpaRepository<Collaborator, Long>  {
    //Optional<Collaborator> findOneByEmailAndPassword();
    Optional<Collaborator> findOneByEmailAndPassword(String email, String password);
    Collaborator findByEmail(String email);
}
