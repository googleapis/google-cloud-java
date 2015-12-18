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

import java.io.Serializable;
import java.util.Objects;

/**
 * Access Control List for buckets or blobs.
 *
 * @see <a href="https://cloud.google.com/storage/docs/access-control#About-Access-Control-Lists">
 *     About Access Control Lists</a>
 */
public final class Acl implements Serializable {

  private static final long serialVersionUID = 6435575339887912222L;

  private final Entity entity;
  private final Role role;

  public enum Role {
    OWNER, READER, WRITER
  }

  /**
   * Base class for Access Control List entities.
   */
  public abstract static class Entity implements Serializable {

    private static final long serialVersionUID = -2707407252771255840L;

    private final Type type;
    private final String value;

    public enum Type {
      DOMAIN, GROUP, USER, PROJECT, UNKNOWN
    }

    Entity(Type type, String value) {
      this.type = type;
      this.value = value;
    }

    /**
     * Returns the type of entity.
     */
    public Type type() {
      return type;
    }

    /**
     * Returns the entity's value.
     */
    protected String value() {
      return value;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Entity entity = (Entity) o;
      return Objects.equals(type, entity.type) && Objects.equals(value, entity.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(type, value);
    }

    @Override
    public String toString() {
      return toPb();
    }

    String toPb() {
      return type.name().toLowerCase() + "-" + value();
    }

    static Entity fromPb(String entity) {
      if (entity.startsWith("user-")) {
        return new User(entity.substring(5));
      }
      if (entity.equals(User.ALL_USERS)) {
        return User.ofAllUsers();
      }
      if (entity.equals(User.ALL_AUTHENTICATED_USERS)) {
        return User.ofAllAuthenticatedUsers();
      }
      if (entity.startsWith("group-")) {
        return new Group(entity.substring(6));
      }
      if (entity.startsWith("domain-")) {
        return new Domain(entity.substring(7));
      }
      if (entity.startsWith("project-")) {
        int idx = entity.indexOf('-', 8);
        String team = entity.substring(8, idx);
        String projectId = entity.substring(idx + 1);
        return new Project(Project.ProjectRole.valueOf(team.toUpperCase()), projectId);
      }
      return new RawEntity(entity);
    }
  }

  /**
   * Class for ACL Domain entities.
   */
  public static final class Domain extends Entity {

    private static final long serialVersionUID = -3033025857280447253L;

    /**
     * Creates a domain entity.
     *
     * @param domain the domain associated to this entity
     */
    public Domain(String domain) {
      super(Type.DOMAIN, domain);
    }

    /**
     * Returns the domain associated to this entity.
     */
    public String domain() {
      return value();
    }
  }

  /**
   * Class for ACL Group entities.
   */
  public static final class Group extends Entity {

    private static final long serialVersionUID = -1660987136294408826L;

    /**
     * Creates a group entity.
     *
     * @param email the group email
     */
    public Group(String email) {
      super(Type.GROUP, email);
    }

    /**
     * Returns the group email.
     */
    public String email() {
      return value();
    }
  }

  /**
   * Class for ACL User entities.
   */
  public static final class User extends Entity {

    private static final long serialVersionUID = 3076518036392737008L;
    private static final String ALL_USERS = "allUsers";
    private static final String ALL_AUTHENTICATED_USERS = "allAuthenticatedUsers";

    /**
     * Creates a user entity.
     *
     * @param email the user email
     */
    public User(String email) {
      super(Type.USER, email);
    }

    /**
     * Returns the user email.
     */
    public String email() {
      return value();
    }

    @Override
    String toPb() {
      switch (value()) {
        case ALL_AUTHENTICATED_USERS:
          return ALL_AUTHENTICATED_USERS;
        case ALL_USERS:
          return ALL_USERS;
        default:
          break;
      }
      return super.toPb();
    }

    public static User ofAllUsers() {
      return new User(ALL_USERS);
    }

    public static User ofAllAuthenticatedUsers() {
      return new User(ALL_AUTHENTICATED_USERS);
    }
  }

  /**
   * Class for ACL Project entities.
   */
  public static final class Project extends Entity {

    private static final long serialVersionUID = 7933776866530023027L;

    private final ProjectRole pRole;
    private final String projectId;

    public enum ProjectRole {
      OWNERS, EDITORS, VIEWERS
    }

    /**
     * Creates a project entity.
     *
     * @param pRole a role in the project, used to select project's teams
     * @param projectId id of the project
     */
    public Project(ProjectRole pRole, String projectId) {
      super(Type.PROJECT, pRole.name().toLowerCase() + "-" + projectId);
      this.pRole = pRole;
      this.projectId = projectId;
    }

    /**
     * Returns the role in the project for this entity.
     */
    public ProjectRole projectRole() {
      return pRole;
    }

    /**
     * Returns the project id for this entity.
     */
    public String projectId() {
      return projectId;
    }
  }

  public static final class RawEntity extends Entity {

    private static final long serialVersionUID = 3966205614223053950L;

    RawEntity(String entity) {
      super(Type.UNKNOWN, entity);
    }

    @Override
    String toPb() {
      return value();
    }
  }

  /**
   * Creats an ACL object.
   *
   * @param entity the entity for this ACL object
   * @param role the role to associate to the {@code entity} object
   */
  public Acl(Entity entity, Role role) {
    this.entity = entity;
    this.role = role;
  }

  /**
   * Returns the entity for this ACL object.
   */
  public Entity entity() {
    return entity;
  }

  /**
   * Returns the role associated to the entity in this ACL object.
   */
  public Role role() {
    return role;
  }

  @Override
  public int hashCode() {
    return Objects.hash(entity, role);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    final Acl other = (Acl) obj;
    return Objects.equals(this.entity, other.entity)
        && Objects.equals(this.role, other.role);
  }

  BucketAccessControl toBucketPb() {
    BucketAccessControl bucketPb = new BucketAccessControl();
    bucketPb.setRole(role().toString());
    bucketPb.setEntity(entity().toString());
    return bucketPb;
  }

  ObjectAccessControl toObjectPb() {
    ObjectAccessControl objectPb = new ObjectAccessControl();
    objectPb.setRole(role().name());
    objectPb.setEntity(entity().toPb());
    return objectPb;
  }

  static Acl fromPb(ObjectAccessControl objectAccessControl) {
    Role role = Role.valueOf(objectAccessControl.getRole());
    return new Acl(Entity.fromPb(objectAccessControl.getEntity()), role);
  }

  static Acl fromPb(BucketAccessControl bucketAccessControl) {
    Role role = Role.valueOf(bucketAccessControl.getRole());
    return new Acl(Entity.fromPb(bucketAccessControl.getEntity()), role);
  }
}
