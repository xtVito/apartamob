package co.com.aptamob.core.base.model;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity extends AbstractPersistable<Long> {

    /*@Version
    private int version;*/

    @Column(length=36)
    private String uuid;

    //private Date timeCreated;

    public BaseEntity() {
        this(UUID.randomUUID());
    }

    public BaseEntity(UUID guid) {
        Assert.notNull(guid, "UUID es requerido");
        setUuid(guid.toString());
        //this.timeCreated = new Date();
    }

    public UUID getUuid() {
        return UUID.fromString(uuid);
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int hashCode() {
        return getUuid().hashCode();
    }
    
    public Object getIdentifier() {
        return getUuid().toString();
    }

    /*public int getVersion() {
        return version;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }*/
}