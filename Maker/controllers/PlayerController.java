package comfuttoolmaker.Football.Tool.Maker.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import comfuttoolmaker.Football.Tool.Maker.models.Player;
import comfuttoolmaker.Football.Tool.Maker.models.Team;
import comfuttoolmaker.Football.Tool.Maker.services.PlayerService;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Player> getAll(){
		return this.playerService.getAll();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Player create(@Valid @RequestBody Player player) throws IOException {
		return this.playerService.create(player);
	}

	@RequestMapping(value = "/multiple/", method = RequestMethod.POST)
	public @Valid List<Player> createMultiple(@Valid @RequestBody List<Player> players) {
		return this.playerService.createMultiple(players);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Player getById(@PathVariable("id") ObjectId id) {
		return this.playerService.getById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable ObjectId id) {
		this.playerService.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyById(@PathVariable("id") ObjectId id, @Valid @RequestBody Player player) {
		this.playerService.modifyById(id, player);
	}
	
	@RequestMapping(value = "/{id}/createPhoto/", method = RequestMethod.POST)
	public void uploadPhoto(@PathVariable("id") ObjectId id, @Valid @RequestPart("photo") MultipartFile photo) throws IOException {
		this.playerService.savePhoto(id, photo);
	}

}
