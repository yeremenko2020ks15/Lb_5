package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;


public interface UsersRepository extends CrudRepository<Users, Integer> {

}
