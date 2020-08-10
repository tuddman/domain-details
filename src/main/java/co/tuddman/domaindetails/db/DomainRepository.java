package co.tuddman.domaindetails.db;

import co.tuddman.domaindetails.model.Domain;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<Domain, UUID> {
    Domain findByUrl(String url);
}