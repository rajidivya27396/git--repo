package com.ideas2it.usermodule.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.usermodule.entity.User;

@Repository
public interface UserElasticRepository extends ElasticsearchRepository<User,Long> {
	@Query("{\"bool\": {\"must\": [{\"match\": {\"roles.name\": \"?0\"}}]}}")
    List<User> findByRoles(String name);
}
