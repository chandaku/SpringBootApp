package com.learn.springboot.resources;

import com.learn.springboot.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

interface UserRepository extends MongoRepository<User, Long> {
}
