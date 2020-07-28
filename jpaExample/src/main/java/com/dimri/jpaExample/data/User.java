package com.dimri.jpaExample.data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="user")
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  @Column(name = "firstName",length=50)
  private String firstName;
  
  @Column(name = "lastName",length=50)
  private String lastName;
  
  protected User() {} //Default constructor 

  //Parameterize constructor
  public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Long getId() {
    return id;
  }
  
  @Column(name = "firstName",length=50)
  public String getFirstName() {
    return firstName;
  }
  @Column(name = "lastName",length=50)
  public String getLastName() {
    return lastName;
  }

@Override
public String toString() {
	return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
}
 
}