package org.Stasy.SpringBootBackend.dto;

public class CollaboratorsDTO {

    private int collaborator_id;

    private String collaborator_name;

    private String email;

    private String password;

    //constructor1
    public CollaboratorsDTO(int collaborator_id, String collaborator_name, String email, String password) {
        this.collaborator_id = collaborator_id;
        this.collaborator_name = collaborator_name;
        this.email = email;
        this.password = password;
    }

    //constructor2
    public CollaboratorsDTO(){}

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

    public void setCollaborator_email(String email) {
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
        return "CollaboratorsDTO{" +
                "collaborator_id=" + collaborator_id +
                ", collaborator_name='" + collaborator_name + '\'' +
                ", collaborator_email='" + email + '\'' +
                ", collaborator_password='" + password + '\'' +
                '}';
    }
}
