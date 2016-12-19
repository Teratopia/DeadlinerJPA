package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonManagedReference(value="deadlines")
	private Set<Deadline> deadlines;
	
	public User(){}

	public void removeDeadline(Deadline d){
		if(this.deadlines.contains(d)){
			d.setUser(null);
			deadlines.remove(d);
		}
	}
	
	public void addDeadlines(Deadline d){
		if(!this.deadlines.contains(d)){
			deadlines.add(d);
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Deadline> getDeadlines() {
		return deadlines;
	}

	public void setDeadlines(Set<Deadline> deadlines) {
		this.deadlines = deadlines;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", questions=" + "]";
	}

}

//+----------+-------------+------+-----+---------+----------------+
//| Field    | Type        | Null | Key | Default | Extra          |
//+----------+-------------+------+-----+---------+----------------+
//| id       | int(11)     | NO   | PRI | NULL    | auto_increment |
//| name     | varchar(32) | NO   |     | NULL    |                |
//| password | varchar(48) | YES  |     | NULL    |                |
//+----------+-------------+------+-----+---------+----------------+