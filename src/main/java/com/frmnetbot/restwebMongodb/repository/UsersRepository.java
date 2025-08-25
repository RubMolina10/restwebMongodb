package com.frmnetbot.restwebMongodb.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.frmnetbot.restwebMongodb.model.UsersDATA;

public interface UsersRepository extends MongoRepository<UsersDATA, String> {
    Optional<UsersDATA> findByUserName(String userName);
    Optional<UsersDATA> findByUserNameAndClvPass(String userName, String clvPass);
}
