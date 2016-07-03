package co.com.aptamob.core.base.model;

import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity extends AbstractPersistable<Long> {
    public BaseEntity() {
    }
}