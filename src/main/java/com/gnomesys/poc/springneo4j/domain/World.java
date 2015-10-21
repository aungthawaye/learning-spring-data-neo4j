package com.gnomesys.poc.springneo4j.domain;

import java.util.Set;

import org.joda.time.DateTime;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

@NodeEntity
public class World {
	private final static String REACHABLE_BY_ROCKET = "REACHABLE_BY_ROCKET";

	@GraphId
	private Long id;

	// Uses default schema based index
	@Indexed
	private String name;

	// Uses legacy index mechanism
	@SuppressWarnings("deprecation")
	@Indexed(indexType = IndexType.SIMPLE)
	private int moons;

	@Fetch
	@RelatedTo(type = REACHABLE_BY_ROCKET, direction = Direction.BOTH)
	private Set<World> reachableByRocket;

	@GraphProperty(propertyType = Long.class)
	private DateTime dob;

	public World(String name, int moons) {
		this.name = name;
		this.moons = moons;
		this.dob = new DateTime();
	}

	public World() {
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getMoons() {
		return moons;
	}

	public DateTime getDob() {
		return dob;
	}

	public void setDob(DateTime dob) {
		this.dob = dob;
	}

	public void addRocketRouteTo(World otherWorld) {
		reachableByRocket.add(otherWorld);
	}

	public boolean canBeReachedFrom(World otherWorld) {
		return reachableByRocket.contains(otherWorld);
	}

	@Override
	public int hashCode() {
		return (id == null) ? 0 : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		World other = (World) obj;
		if (id == null)
			return other.id == null;
		return id.equals(other.id);
	}

	@Override
	public String toString() {
		return String.format("World{name='%s', moons=%d}", name, moons);
	}
}