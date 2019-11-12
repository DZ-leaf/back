package leaf.model.dto.company;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Alarm
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Document(collection = "alarm")
public class Alarm {

    @Id
    @Column(name = "_id")
    private String idx;

    @Column(name = "repetition")
    private boolean repetition;

    @Column(name = "time")
    private Date time;

    @Column(name = "name")
    private String name;

}