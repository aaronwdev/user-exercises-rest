package com.williams.userexercisesrest.repository;

import com.williams.userexercisesrest.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{
    UserEntity findById(int id);
}
