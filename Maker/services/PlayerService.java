package comfuttoolmaker.Football.Tool.Maker.services;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import comfuttoolmaker.Football.Tool.Maker.models.Photo;
import comfuttoolmaker.Football.Tool.Maker.models.Player;
import comfuttoolmaker.Football.Tool.Maker.repository.PlayerRepository;
import comfuttoolmaker.Football.Tool.Maker.services.PhotoService;

@Service
public class PlayerService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PlayerRepository repository;
	
	@Autowired
	private PhotoService photoService;
	
	public List<Player> getAll(){
		return repository.findAll();
	}

	public Player create(@Valid @RequestBody Player player) throws IOException {
		player.set_id(ObjectId.get());
		repository.save(player);
		return player;
	}
	
	public @Valid List<Player> createMultiple(@Valid @RequestBody List<Player> players) {
		for (Player player : players) {
			player.set_id(ObjectId.get());
			repository.save(player);
		}
		return players;
	}
	
	public Player getById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	
	public void delete(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}

	public void modifyById(@PathVariable("id") ObjectId id, @Valid @RequestBody Player player) {
		player.set_id(id);
		repository.save(player);
	}
	
	public void savePhoto(@PathVariable("id") ObjectId id, MultipartFile file) throws IOException {
		String title = "PROFILEPIC";
		Player player = this.getById(id);
		
        Photo photo = new Photo(title); 
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        player.setPhoto(photo);
        
        this.repository.save(player);
	}

}
