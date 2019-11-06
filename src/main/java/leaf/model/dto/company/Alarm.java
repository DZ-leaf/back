package leaf.model.dto.company;

import java.util.Date;

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
    private String _id;
    private boolean repetition; 
    private Date time;
    private String name;

}