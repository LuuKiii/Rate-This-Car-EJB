package jsf.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the motor database table.
 * 
 */
@Entity
@NamedQuery(name="Motor.findAll", query="SELECT m FROM Motor m")
public class Motor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmotor;

	private String motorType;

	private double topSpeed;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	private Vehicle vehicle;

	public Motor() {
	}

	public int getIdmotor() {
		return this.idmotor;
	}

	public void setIdmotor(int idmotor) {
		this.idmotor = idmotor;
	}

	public String getMotorType() {
		return this.motorType;
	}

	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}

	public double getTopSpeed() {
		return this.topSpeed;
	}

	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}