package co.tuddman.domaindetails.model;

import java.util.Date;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Domain {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID requestId;
    private String commonName = null;
    private String details = null;
    private String notes = null;
    private String url = null;

    protected Domain() {}

    public Domain(String url) {
        this.requestId = UUID.randomUUID();
        this.url = url;
        this.details = null;
        this.notes = null;
        Date firstDiscovered = new Date();
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

}