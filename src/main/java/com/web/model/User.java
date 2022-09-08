package com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/** User */
@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, length = 11, unique = true)
  private int id;

  @NotNull
  @Column(name = "name", nullable = false, length = 128, unique = true)
  private String name;

  @NotNull
  @Column(name = "password", nullable = false, length = 128)
  private String password;

  @Column(name = "active", nullable = false, length = 128)
  private boolean active;

  @Column(name = "roles", nullable = false, length = 128)
  private String roles;

  public User() {}

  public User(String name, String password) {
    this.name = name;
    this.password = password;
    this.active = true;
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

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean getActive() {
    return this.active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getRoles() {
    return this.roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "User[id = " + this.id + ", name = " + this.name + "]";
  }
}
