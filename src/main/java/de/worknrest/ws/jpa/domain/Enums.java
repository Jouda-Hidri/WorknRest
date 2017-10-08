package de.worknrest.ws.jpa.domain;

public final class Enums {

	public enum ExerciseType {
		RUNNING,
		CYCLING,
		SWIMMING,
		ROWING,
		WALKING,
		CIRCUIT_TRAINING,
		STRENGTH_TRAINING,
		FITNESS_COURSE,
		SPORTS,
		OTHER
	}
	
	public static int getPointsByType(ExerciseType exerciseType) {
		int points = 0;
		switch (exerciseType) {
		case RUNNING:
			points = 2;
			break;
		case CYCLING:
			points = 2;
			break;
		case SWIMMING:
			points = 3;
			break;
		case ROWING:
			points = 2;
			break;
		case WALKING:
			points = 1;
			break;
		case CIRCUIT_TRAINING:
			points = 4;
			break;
		case STRENGTH_TRAINING:
			points = 3;
			break;
		case FITNESS_COURSE:
			points = 2;
			break;
		case SPORTS:
			points = 3;
			break;
		case OTHER:
			points = 1;
			break;
		}
		return points;
	}
}
