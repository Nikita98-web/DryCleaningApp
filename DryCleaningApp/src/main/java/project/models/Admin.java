package project.models;

import javax.persistence.*;

@Entity
@Table(name="admins")
@PrimaryKeyJoinColumn(referencedColumnName="user_id")
public class Admin extends User {
	
}


