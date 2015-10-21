package com.gnomesys.poc.springneo4j.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.gnomesys.poc.springneo4j.domain.World;
import com.gnomesys.poc.springneo4j.repositories.ext.ExtWorldRepository;

@Repository("worldRepository")
public interface WorldRepository extends GraphRepository<World>,
		ExtWorldRepository {
}