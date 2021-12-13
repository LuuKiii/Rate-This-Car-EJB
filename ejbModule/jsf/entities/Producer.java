package jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producer database table.
 * 
 */
@Entity
@NamedQuery(name="Producer.findAll", query="SELECT p FROM Producer p")
public class Producer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproducer;

	private String producerCountry;

	@Lob
	private String producerDescription;

	private String producerName;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="producer")
	private List<Vehicle> vehicles;

	public Producer() {
	}

	public int getIdproducer() {
		return this.idproducer;
	}

	public void setIdproducer(int idproducer) {
		this.idproducer = idproducer;
	}

	public String getProducerCountry() {
		return this.producerCountry;
	}

	public void setProducerCountry(String producerCountry) {
		this.producerCountry = producerCountry;
	}

	public String getProducerDescription() {
		return this.producerDescription;
	}

	public void setProducerDescription(String producerDescription) {
		this.producerDescription = producerDescription;
	}

	public String getProducerName() {
		return this.producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		getVehicles().add(vehicle);
		vehicle.setProducer(this);

		return vehicle;
	}

	public Vehicle removeVehicle(Vehicle vehicle) {
		getVehicles().remove(vehicle);
		vehicle.setProducer(null);

		return vehicle;
	}

}