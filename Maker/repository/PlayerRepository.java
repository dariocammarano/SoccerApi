package comfuttoolmaker.Football.Tool.Maker.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import comfuttoolmaker.Football.Tool.Maker.models.Player;

public interface PlayerRepository  extends MongoRepository<Player, String>{
	Player findBy_id(ObjectId _id);
	
}
