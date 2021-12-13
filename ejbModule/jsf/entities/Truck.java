package jsf.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the truck database table.
 * 
 */
@Entity
@NamedQuery(name="Truck.findAll", query="SELECT t FROM Truck t")
public class Truck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtruck;

	private double clearance;

	private String truckType;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	private Vehicle vehicle;

	public Truck() {
	}

	public int getIdtruck() {
		return this.idtruck;
	}

	public void setIdtruck(int idtruck) {
		this.idtruck = idtruck;
	}

	public double getClearance() {
		return this.clearance;
	}

	public void setClearance(double clearance) {
		this.clearance = clearance;
	}

	public String getTruckType() {
		return this.truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}