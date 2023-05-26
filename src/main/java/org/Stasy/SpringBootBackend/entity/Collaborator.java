package org.Stasy.SpringBootBackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name="collaborator")

public class Collaborator {

    //attributes
    @Id
    @Column(name="collaborator_id", length=45)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int collaborator_id;

    @Column(name="collaborator_name",nullable=false)
    private String collaborator_name;

    @Column(name="collaborator_email", nullable=false)
    private String email;

    @Column(name="collaborator_password", nullable=false)
    private String password;

    //Constructor1
    public Collaborator(int collaborator_id, String collaborator_name, String email, String password){
        this.collaborator_id=collaborator_id;
        this.collaborator_name=collaborator_name;
        this.email=email;
        this.password=password;
    }

    //Constructor2
    public Collaborator(){}

    //getters and setters
    public int getCollaborator_id() {
        return collaborator_id;
    }

    public void setCollaborator_id(int collaborator_id) {
        this.collaborator_id = collaborator_id;
    }

    public String getCollaborator_name() {
        return collaborator_name;
    }

    public void setCollaborator_name(String collaborator_name) {
        this.collaborator_name = collaborator_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Collaborator{" +
                "collaborator_id=" + collaborator_id +
                ", collaborator_name='" + collaborator_name + '\'' +
                ", collaborator_email='" + email + '\'' +
                ", collaborator_password='" + password + '\'' +
                '}';
    }
}
