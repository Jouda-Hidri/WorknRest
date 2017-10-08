package de.worknrest.ws.jpa.dao;

import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import de.worknrest.ws.jpa.domain.Exercise;

@Transactional
public class ExerciseDaoImpl extends AbstractBaseDao<Exercise> implements ExerciseDao {

	@Inject
	ExerciseDaoImpl(final Provider<EntityManager> entityManagerProvider) {
		super(entityManagerProvider, Exercise.class);
	}



	@Override
	public List<Exercise> findByUserId(Long userId) {
		if (userId == null) {
			return Collections.emptyList();
		}

		try {
			return getEntityManager().createQuery("SELECT e FROM Exercise e WHERE userId = :userId")
					.setParameter("userId", userId).getResultList();
		} catch (NoResultException e) {
			return Collections.emptyList();
		}
	}

}
