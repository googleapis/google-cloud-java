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

import com.google.api.services.storage.model.BucketAccessControl;
import com.google.api.services.storage.model.ObjectAccessControl;
import com.google.gcloud.storage.Acl.Project.ProjectRole;

import java.io.Serializable;

public abstract class Acl implements Serializable {

  private static final long serialVersionUID = 6435575339887912222L;

  private final Type type;
  private final Role role;

  public enum Role {
    OWNER,
    READER,
    WRITER
  }

  public enum Type {
    DOMAIN,
    GROUP,
    USER,
    PROJECT
  }

  public static class Domain extends Acl {

    private static final long serialVersionUID = -3033025857280447253L;
    private final String domain;

    Domain(String domain, Role role) {
      super(Type.DOMAIN, role);
      this.domain = domain;
    }

    public String domain() {
      return domain;
    }

    String entity() {
      return "domain-" + domain;
    }

    public static Domain of(String domain, Role role) {
      return new Domain(domain, role);
    }
  }

  public static class Group extends Acl {

    private static final long serialVersionUID = -1660987136294408826L;
    private final String email;

    Group(String email, Role role) {
      super(Type.GROUP, role);
      this.email = email;
    }

    public String email() {
      return email;
    }

    String entity() {
      return "group-" + email;
    }

    public static Group of(String email, Role role) {
      return new Group(email, role);
    }
  }

  public static class User extends Acl {

    private static final long serialVersionUID = 3076518036392737008L;
    private static final String ALL_USERS = "allUsers";
    private static final String ALL_AUTHENTICATED_USERS = "allAuthenticatedUsers";

    private final String email;

    User(String email, Role role) {
      super(Type.USER, role);
      this.email = email;
    }

    public String email() {
      return email;
    }

    String entity() {
      switch (email) {
        case ALL_AUTHENTICATED_USERS:
          return ALL_AUTHENTICATED_USERS;
        case ALL_USERS:
          return ALL_USERS;
        default:
          return "user-" + email;
      }
    }


    public static User of(String email, Role role) {
      return new User(email, role);
    }

    public static User ofAllUsers(Role role) {
      return of(ALL_USERS, role);
    }

    public static User ofAllAuthenticatedUsers(Role role) {
      return of(ALL_AUTHENTICATED_USERS, role);
    }
  }

  public static class Project extends Acl {

    private final String projectId;
    private final ProjectRole pRole;

    enum ProjectRole {
      OWNERS,
      EDITORS,
      VIEWERS
    }

    Project(ProjectRole pRole, String projectId, Role role) {
      super(Type.PROJECT, role);
      this.pRole = pRole;
      this.projectId = projectId;
    }

    public ProjectRole projectRole() {
      return pRole;
    }

    public String projectId() {
      return projectId;
    }

    String entity() {
      return "project-" + pRole.name().toLowerCase() + "-" + projectId;
    }

    public static Project of(ProjectRole pRole, String projectId, Role role) {
      return new Project(pRole, projectId, role);
    }
  }

  Acl(Type type, Role role) {
    this.type = type;
    this.role = role;
  }

  public Type type() {
    return type;
  }

  public Role role() {
    return role;
  }

  BucketAccessControl toBucketPb() {
    BucketAccessControl bucketPb = new BucketAccessControl();
    bucketPb.setRole(role().toString());
    bucketPb.setEntity(entity());
    return bucketPb;
  }

  ObjectAccessControl toObjectPb() {
    ObjectAccessControl objectPb = new ObjectAccessControl();
    objectPb.setRole(role().toString());
    objectPb.setEntity(entity());
    return objectPb;
  }

  abstract String entity();

  static Acl fromPb(ObjectAccessControl objectAccessControl) {
    Role role = Role.valueOf(objectAccessControl.getRole());
    return forEntity(objectAccessControl.getEntity(), role);
  }

  static Acl fromPb(BucketAccessControl bucketAccessControl) {
    Role role = Role.valueOf(bucketAccessControl.getRole());
    return forEntity(bucketAccessControl.getEntity(), role);
  }

  private static Acl forEntity(String entity, Role role) {
    if (entity.startsWith("user-")) {
      return User.of(entity.substring(5), role);
    }
    if (entity.equals(User.ALL_USERS)) {
      return User.ofAllUsers(role);
    }
    if (entity.equals(User.ALL_AUTHENTICATED_USERS)) {
      return User.ofAllAuthenticatedUsers(role);
    }
    if (entity.startsWith("group-")) {
      return Group.of(entity.substring(6), role);
    }
    if (entity.startsWith("project-")) {
      int idx = entity.indexOf('-', 9);
      String team = entity.substring(9, idx);
      String projectId = entity.substring(idx + 1);
      return Project.of(ProjectRole.valueOf(team.toUpperCase()), projectId, role);
    }
    return null;
  }
}
