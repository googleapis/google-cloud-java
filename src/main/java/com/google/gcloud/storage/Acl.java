package com.google.gcloud.storage;

public interface Acl {

  public class ProjectTeam {
    	// ProjectNumber: The project number.
	//ProjectNumber string `json:"projectNumber,omitempty"`

	// Team: The team. Can be owners, editors, or viewers.
	//Team string `json:"team,omitempty"`
  }

  enum Entity {
    USER_ID("user-userId"),
    USER_EMAIL("user-emailAddress"),
    GROUP_ID("group-groupId"),
    GROUP_EMAIL("group-emailAddress"),
    ALL_USERS("allUsers"),
    ALL_AUTHENTICATED_USERS("allAuthenticatedUsers");

    private final String value;

    Entity(String value) {
      this.value = value;
    }
  }

  String domain();

  Entity entity();

  String entityId();

  String email();

  String etag();

  String generation();


  ProjectTeam projectTeam();

  String role();
}
