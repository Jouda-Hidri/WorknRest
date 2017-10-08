package de.worknrest.ws.rest;

import java.util.List;

import javax.annotation.Nonnull;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.worknrest.ws.jpa.dao.ExerciseDao;
import de.worknrest.ws.jpa.domain.Enums;
import de.worknrest.ws.jpa.domain.Exercise;

@Singleton
public class ExerciseServiceImpl implements ExerciseService {

	private static final Logger log = LoggerFactory.getLogger(ExerciseServiceImpl.class);

	private final ExerciseDao exerciseDao;

	@Inject
	ExerciseServiceImpl(final ExerciseDao exerciseDao) {
		this.exerciseDao = exerciseDao;
	}

	@Override
	public List<Exercise> getAllExercises() {
		final List<Exercise> exercises = exerciseDao.findAll();
		if (exercises == null) {
			throw new NotFoundException("No Exercise could not be found.");
		}

		return exercises;
	}

	@Nonnull
	@Override
	public Exercise getExerciseById(@Nonnull final Long exerciseId) {
		log.debug("Get exercise by id.");

		final Exercise exercise = exerciseDao.findById(exerciseId);
		if (exercise == null) {
			throw new NotFoundException("Exercise with id = " + exerciseId + " could not be found.");
		}

		return exercise;
	}

	@Override
	public List<Exercise> getExerciseByUserId(Long userId) {
		List<Exercise> list = exerciseDao.findByUserId(userId);
		return list;
	}

	@Override
	public Exercise createExcercice(String type, String description) {
		if (description == null || description.isEmpty()) {
			description = "No description";
		}
		return exerciseDao.create(new Exercise(Enums.ExerciseType.OTHER, description));
	}

	@Override
	public Exercise createEmptyExcercice() {
		return exerciseDao.create(new Exercise());
	}

	@Override
	public Exercise updateExercice(String id, String description) {
		Exercise exercise = exerciseDao.findById(Long.parseLong(id, 10));
		exercise.setDescription(description);
		return exerciseDao.update(exercise);
	}

	private Boolean validDescription(final String description) {
		return description.matches("^[a-zA-Z0-9 ]*$");
	}

	Status validFields(Exercise exercise) {
		if (!exercise.getDescription().equals(null) && validDescription(exercise.getDescription())
				&& !exercise.getType().equals(null)) {
			return Response.Status.OK;
		}
		return Response.Status.NOT_ACCEPTABLE;
	}

}
