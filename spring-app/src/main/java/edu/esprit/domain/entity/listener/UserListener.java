package edu.esprit.domain.entity.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserListener.class);

	@PrePersist
	public void prePersist(Object object) {
		LOGGER.debug("PersistenceContextListener :: Method PrePersist Invoked Upon Entity :: "
				+ object);
	}

	@PostPersist
	public void postPersist(Object object) {
		LOGGER.debug("PersistenceContextListener :: Method PostPersist Invoked Upon Entity :: "
				+ object);
	}

	@PreRemove
	public void preRemove(Object object) {
		LOGGER.debug("PersistenceContextListener :: Method PreRemove Invoked Upon Entity :: "
				+ object);
	}

	@PostRemove
	public void postRemove(Object object) {
		LOGGER.debug("PersistenceContextListener :: Method PostRemove Invoked Upon Entity :: "
				+ object);
	}

	@PreUpdate
	public void preUpdatea(Object object) {
		LOGGER.debug("PersistenceContextListener :: Method PreUpdate Invoked Upon Entity :: "
				+ object);
	}

	@PostUpdate
	public void postUpdate(Object object) {
		LOGGER.debug("PersistenceContextListener :: Method PostUpdate Invoked Upon Entity :: "
				+ object);
	}

}
