package com.example.demo.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.example.demo.model.*;


public interface UserRepository extends CassandraRepository<UserModel, Integer> {

	@AllowFiltering
	List<UserModel> findByAgeGreaterThan(int age);

}
