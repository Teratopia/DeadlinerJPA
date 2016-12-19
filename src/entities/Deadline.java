package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Deadline {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int priority;
	private String name;
	@Column(name = "due_date")
	private Date dueDate;
	@Column(name = "create_date")
	private Date createDate;
	@ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference(value="deadlines")
    private User user;
	
	public Deadline(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Deadline [id=" + id + ", priority=" + priority + ", name=" + name + ", dueDate=" + dueDate
				+ ", createDate=" + createDate + ", user=" + user + "]";
	}
	
}

//+-------------+----------+------+-----+---------+----------------+
//| Field       | Type     | Null | Key | Default | Extra          |
//+-------------+----------+------+-----+---------+----------------+
//| id          | int(11)  | NO   | PRI | NULL    | auto_increment |
//| priority    | int(11)  | NO   |     | NULL    |                |
//| name        | vc(48)   | NO   |     | NULL    |                |
//| due_date    | datetime | NO   |     | NULL    |                |
//| create_date | datetime | NO   |     | NULL    |                |
//| user_id     | int(11)  | NO   | MUL | NULL    |                |
//+-------------+----------+------+-----+---------+----------------+