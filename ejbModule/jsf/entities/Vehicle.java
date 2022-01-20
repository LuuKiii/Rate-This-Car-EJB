package jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idvehicle;

	private String vehicleEngCap;

	private String vehicleFuel;

	private String vehicleImage;

	private String vehicleName;

	private String vehiclePower;

	private double vehiclePrice;

	private String vehicleTransmission;

	private String vehicleType;

	private short vehicleYear;

	//bi-directional many-to-one association to Car
	@OneToMany(mappedBy="vehicle")
	private List<Car> cars;

	//bi-directional many-to-one association to Motor
	@OneToMany(mappedBy="vehicle")
	private List<Motor> motors;

	//bi-directional many-to-one association to Truck
	@OneToMany(mappedBy="vehicle")
	private List<Truck> trucks;

	//bi-directional many-to-one association to UserRatesVehicle
	@OneToMany(mappedBy="vehicle")
	private List<UserRatesVehicle> userRatesVehicles;

	//bi-directional many-to-one association to Producer

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producer_idproducer")
	private Producer producer;

	public Vehicle() {
	}

	public int getIdvehicle() {
		return this.idvehicle;
	}

	public void setIdvehicle(int idvehicle) {
		this.idvehicle = idvehicle;
	}

	public String getVehicleEngCap() {
		return this.vehicleEngCap;
	}

	public void setVehicleEngCap(String vehicleEngCap) {
		this.vehicleEngCap = vehicleEngCap;
	}

	public String getVehicleFuel() {
		return this.vehicleFuel;
	}

	public void setVehicleFuel(String vehicleFuel) {
		this.vehicleFuel = vehicleFuel;
	}

	public String getVehicleImage() {
		return this.vehicleImage;
	}

	public void setVehicleImage(String vehicleImage) {
		this.vehicleImage = vehicleImage;
	}

	public String getVehicleName() {
		return this.vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehiclePower() {
		return this.vehiclePower;
	}

	public void setVehiclePower(String vehiclePower) {
		this.vehiclePower = vehiclePower;
	}

	public double getVehiclePrice() {
		return this.vehiclePrice;
	}

	public void setVehiclePrice(double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public String getVehicleTransmission() {
		return this.vehicleTransmission;
	}

	public void setVehicleTransmission(String vehicleTransmission) {
		this.vehicleTransmission = vehicleTransmission;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public short getVehicleYear() {
		return this.vehicleYear;
	}

	public void setVehicleYear(short vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Car addCar(Car car) {
		getCars().add(car);
		car.setVehicle(this);

		return car;
	}

	public Car removeCar(Car car) {
		getCars().remove(car);
		car.setVehicle(null);

		return car;
	}

	public List<Motor> getMotors() {
		return this.motors;
	}

	public void setMotors(List<Motor> motors) {
		this.motors = motors;
	}

	public Motor addMotor(Motor motor) {
		getMotors().add(motor);
		motor.setVehicle(this);

		return motor;
	}

	public Motor removeMotor(Motor motor) {
		getMotors().remove(motor);
		motor.setVehicle(null);

		return motor;
	}

	public List<Truck> getTrucks() {
		return this.trucks;
	}

	public void setTrucks(List<Truck> trucks) {
		this.trucks = trucks;
	}

	public Truck addTruck(Truck truck) {
		getTrucks().add(truck);
		truck.setVehicle(this);

		return truck;
	}

	public Truck removeTruck(Truck truck) {
		getTrucks().remove(truck);
		truck.setVehicle(null);

		return truck;
	}

	public List<UserRatesVehicle> getUserRatesVehicles() {
		return this.userRatesVehicles;
	}

	public void setUserRatesVehicles(List<UserRatesVehicle> userRatesVehicles) {
		this.userRatesVehicles = userRatesVehicles;
	}

	public UserRatesVehicle addUserRatesVehicle(UserRatesVehicle userRatesVehicle) {
		getUserRatesVehicles().add(userRatesVehicle);
		userRatesVehicle.setVehicle(this);

		return userRatesVehicle;
	}

	public UserRatesVehicle removeUserRatesVehicle(UserRatesVehicle userRatesVehicle) {
		getUserRatesVehicles().remove(userRatesVehicle);
		userRatesVehicle.setVehicle(null);

		return userRatesVehicle;
	}

	public Producer getProducer() {
		return this.producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

}