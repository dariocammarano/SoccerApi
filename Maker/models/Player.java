package comfuttoolmaker.Football.Tool.Maker.models;

import java.io.InputStream;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JacksonAnnotation;

import comfuttoolmaker.Football.Tool.Maker.models.constants.Position;

public class Player {
	
	@Id
	private ObjectId _id;
	
    private String name;
    private String referenceCode; //DNI
    private String lastName;
    private Country country;
    private Position position;
    private Photo photo;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public String get_id() {
		return _id.toHexString();
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public Player(ObjectId _id, String name, String lastName, Country country, Position position) {
		super();
		this._id = _id;
		this.name = name;
		this.lastName = lastName;
		this.country = country;
		this.position = position;
	}
	
	public Player() {
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", lastName=" + lastName + ", country=" + country + ", position=" + position
				+ "]";
	}
	public String getReferenceCode() {
		return referenceCode;
	}
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
    

}
