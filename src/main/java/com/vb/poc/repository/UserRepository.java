package com.vb.poc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.vb.poc.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
