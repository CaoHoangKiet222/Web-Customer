package com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** Customer */
@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, length = 11, unique = true)
  private int id;

  @Column(name = "name", nullable = true, length = 45)
  private String name;

  @Column(name = "email", nullable = true, length = 45)
  private String email;

  public Customer() {}

  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Customer[id = " + this.id + ", name = " + this.name + ", email = " + this.email + "]";
  }
}