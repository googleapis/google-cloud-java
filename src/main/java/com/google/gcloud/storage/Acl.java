/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.storage;

public final class Acl {

  private final String domain;
  private final Entity entity;
  private final String entityId;

  String email();

  String etag();

  String generation();


  ProjectTeam projectTeam();

  String role();

  class ProjectTeam {
      // ProjectNumber: The project number.
  //ProjectNumber string `json:"projectNumber,omitempty"`

  // Team: The team. Can be owners, editors, or viewers.
  //Team string `json:"team,omitempty"`
  }

  public static abstract class Entity {

    private final Type type;

    public static final Entity ALL_USERS = new Entity(Type.ALL_USERS);

    public enum Type {
      USER_ID("user-userId"),
      USER_EMAIL("user-emailAddress"),
      GROUP_ID("group-groupId"),
      GROUP_EMAIL("group-emailAddress"),
      ALL_USERS("allUsers"),
      ALL_AUTHENTICATED_USERS("allAuthenticatedUsers");

      private final String value;

      Type(String value) {
        this.value = value;
      }
    }

    Entity(EntityType type) {
      this.type = type;
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
