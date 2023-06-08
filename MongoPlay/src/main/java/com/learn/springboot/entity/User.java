package com.learn.springboot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

   @Transient
   public static final String SEQUENCE_NAME = "users_sequence";

   @Id
   private Long id;

   private String email;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
