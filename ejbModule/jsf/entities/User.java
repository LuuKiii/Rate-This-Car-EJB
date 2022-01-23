package jsf.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iduser")
	private int iduser;

	private String email;

	private String password;

	private String role;

	private String userName;

	//bi-directional many-to-one association to UserRatesVehicle
	@OneToMany(fetch = FetchType.LAZY,mappedBy="user")
	private List<UserRatesVehicle> userRatesVehicles;

	public User() {
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<UserRatesVehicle> getUserRatesVehicles() {
		return this.userRatesVehicles;
	}

	public void setUserRatesVehicles(List<UserRatesVehicle> userRatesVehicles) {
		this.userRatesVehicles = userRatesVehicles;
	}

	public UserRatesVehicle addUserRatesVehicle(UserRatesVehicle userRatesVehicle) {
		getUserRatesVehicles().add(userRatesVehicle);
		userRatesVehicle.setUser(this);

		return userRatesVehicle;
	}

	public UserRatesVehicle removeUserRatesVehicle(UserRatesVehicle userRatesVehicle) {
		getUserRatesVehicles().remove(userRatesVehicle);
		userRatesVehicle.setUser(null);

		return userRatesVehicle;
	}

}