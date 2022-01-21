package jsf.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the car database table.
 * 
 */
@Entity
@NamedQuery(name="Car.findAll", query="SELECT c FROM Car c")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcar;

	private String carType;

	private String drive;

	private byte seats;

	private double topSpeed;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_idvehicle")
	private Vehicle vehicle;

	public Car() {
	}

	public int getIdcar() {
		return this.idcar;
	}

	public void setIdcar(int idcar) {
		this.idcar = idcar;
	}

	public String getCarType() {
		return this.carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getDrive() {
		return this.drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	public byte getSeats() {
		return this.seats;
	}

	public void setSeats(byte seats) {
		this.seats = seats;
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