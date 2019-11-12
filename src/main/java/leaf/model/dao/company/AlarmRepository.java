package leaf.model.dao.company;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import leaf.model.dto.company.Alarm;

public interface AlarmRepository extends MongoRepository<Alarm, String> {

    List<Alarm> findByName(String name);

}