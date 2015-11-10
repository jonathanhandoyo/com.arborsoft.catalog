package com.arborsoft.catalog.repository;

import com.arborsoft.catalog.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GraphRepository<User> {

    @Query(" MATCH (user:User) " +
            " WHERE user.code = {0} " +
            "RETURN user; ")
    User findByCode(String code);
}
