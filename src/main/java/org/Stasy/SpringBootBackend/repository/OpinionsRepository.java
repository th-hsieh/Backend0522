package org.Stasy.SpringBootBackend.repository;

import org.Stasy.SpringBootBackend.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionsRepository extends JpaRepository<Opinion, Long> {
}
