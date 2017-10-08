package de.worknrest.ws.rest;

import java.util.List;

import javax.annotation.Nonnull;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.worknrest.ws.jpa.domain.Exercise;
import io.swagger.annotations.Api;

@Path("/exercise")
@Api(value = "Exercise Service")
public interface ExerciseService {
	/**
	 * Get all the the exercises.
	 * 
	 * @param no
	 *            params
	 *
	 * @return the exercise for the given exerciseId
	 */
	@GET
	@Path("/all")
	@Nonnull
	@Produces(MediaType.APPLICATION_JSON)
	List<Exercise> getAllExercises();

	/**
	 * Get the exercise for a given exerciseId.
	 *
	 * @param exerciseId
	 *            id to search
	 * @return the exercise for the given exerciseId
	 */
	@GET
	@Path("/id/{exerciseId}")
	@Nonnull
	@Produces(MediaType.APPLICATION_JSON)
	Exercise getExerciseById(@Nonnull @PathParam("exerciseId") Long exerciseId);

	/**
	 * Get the exercises with the given user id.
	 *
	 * @param user
	 *            id.
	 * @return the exercises for the given user id.
	 */
	@GET
	@Path("/user/{userId}/")
	@Nonnull
	@Produces(MediaType.APPLICATION_JSON)
	List<Exercise> getExerciseByUserId(@Nonnull @PathParam("exerciseId") Long userId);

	/**
	 * creates a new exercice
	 *
	 * @param the
	 *            type and the description of the exercise to create
	 * @return the created exercise
	 */
	@POST
	@Path("/create/")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	Exercise createExcercice(@FormParam("type") String type, @FormParam("description") String description);
	/* not allowed */

	/**
	 * exercise for a given exerciseId.
	 * 
	 * @param no
	 *            params
	 *
	 * @return the created exercise
	 */
	@POST
	@Path("/empty/")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	Exercise createEmptyExcercice();

	/**
	 * updates the description of a given excercise.
	 * 
	 * @param the
	 *            id of the exercise to update and the new description.
	 * 
	 * @return the exercise updated
	 */
	@POST
	@Path("/update/")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	Exercise updateExercice(@FormParam("id") String id, @FormParam("description") String description);

}
