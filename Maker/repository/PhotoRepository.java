package comfuttoolmaker.Football.Tool.Maker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import comfuttoolmaker.Football.Tool.Maker.models.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> {

}
