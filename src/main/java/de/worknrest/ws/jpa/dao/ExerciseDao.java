package de.worknrest.ws.jpa.dao;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import de.worknrest.ws.jpa.domain.Exercise;

public interface ExerciseDao extends BaseDao<Exercise> {

	/**
	 * Returns a list of exercises with the given userId
	 *
	 * @param userId
	 * 
	 * @return filters list of exercises
	 */
	@Nonnull
	List<Exercise> findByUserId(@Nullable Long userId);
}
