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

package com.google.gcloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.bigquery.model.Dataset.Access;

import java.io.Serializable;
import java.util.Objects;

/**
 * Access Control for a BigQuery Dataset. BigQuery uses ACLs to manage permissions on datasets. ACLs
 * are not directly supported on tables. A table inherits its ACL from the dataset that contains it.
 * Project roles affect your ability to run jobs or manage the project, while dataset roles affect
 * how you can access or modify the data inside of a project.
 *
 * @see <a href="https://cloud.google.com/bigquery/access-control">Access Control</a>
 */
public final class Acl implements Serializable {

  private static final long serialVersionUID = 8357269726277191556L;

  private final Entity entity;
  private final Role role;

  /**
   * Dataset roles supported by BigQuery.
   *
   * @see <a href="https://cloud.google.com/bigquery/access-control#datasetroles">Dataset Roles</a>
   */
  public enum Role {
    /**
     * Can read, query, copy or export tables in the dataset.
     */
    READER,
    /**
     * Same as {@link #READER} plus can edit or append data in the dataset.
     */
    WRITER,
    /**
     * Same as {@link #WRITER} plus can update and delete the dataset.
     */
    OWNER
  }

  /**
   * Base class for BigQuery entities that can be grant access to the dataset.
   */
  public static abstract class Entity implements Serializable {

    private static final long serialVersionUID = 8111776788607959944L;

    private final Type type;

    /**
     * Types of BigQuery entities.
     */
    public enum Type {
      DOMAIN, GROUP, USER, VIEW
    }

    Entity(Type type) {
      this.type = type;
    }

    public Type type() {
      return type;
    }

    abstract Access toPb();

    static Entity fromPb(Access access) {
      if (access.getDomain() != null) {
        return new Domain(access.getDomain());
      }
      if (access.getGroupByEmail() != null) {
        return new Group(access.getGroupByEmail());
      }
      if (access.getSpecialGroup() != null) {
        return new Group(access.getSpecialGroup());
      }
      if (access.getUserByEmail() != null) {
        return new User(access.getUserByEmail());
      }
      if (access.getView() != null) {
        return new View(TableId.fromPb(access.getView()));
      }
      // Unreachable
      throw new BigQueryException(BigQueryException.UNKNOWN_CODE,
          "Unrecognized access configuration", false);
    }
  }

  /**
   * Class for a BigQuery Domain entity. Objects of this class represent a domain to grant access
   * to. Any users signed in with the domain specified will be granted the specified access.
   */
  public static final class Domain extends Entity {

    private static final long serialVersionUID = -3033025857280447253L;
    
    private final String domain;

    /**
     * Creates a Domain entity given the domain name.
     */
    public Domain(String domain) {
      super(Type.DOMAIN);
      this.domain = domain;
    }

    /**
     * Returns the domain name.
     */
    public String domain() {
      return domain;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Domain domainEntity = (Domain) o;
      return Objects.equals(type(), domainEntity.type())
          && Objects.equals(domain, domainEntity.domain());
    }

    @Override
    public int hashCode() {
      return Objects.hash(type(), domain);
    }

    @Override
    public String toString() {
      return toPb().toString();
    }

    @Override
    Access toPb() {
      return new Access().setDomain(domain);
    }
  }

  /**
   * Class for a BigQuery Group entity. Objects of this class represent a group to grante access to.
   * A Group entity can be created given the group's email or can be a special group:
   * {@link #ofProjectOwners()}, {@link #ofProjectReaders()}, {@link #ofProjectWriters()} or
   * {@link #ofAllAuthenticatedUsers()}.
   */
  public static final class Group extends Entity {

    private static final String PROJECT_OWNERS = "projectOwners";
    private static final String PROJECT_READERS = "projectReaders";
    private static final String PROJECT_WRITERS = "projectWriters";
    private static final String ALL_AUTHENTICATED_USERS = "allAuthenticatedUsers";
    private static final long serialVersionUID = 5146829352398103029L;
    
    private final String identifier;

    /**
     * Creates a Group entity given its identifier. Identifier can be either a
     * <a href="https://cloud.google.com/bigquery/docs/reference/v2/datasets#access.specialGroup">
     *     special group identifier</a> or a group email.
     */
    public Group(String identifier) {
      super(Type.GROUP);
      this.identifier = identifier;
    }

    /**
     * Returns group's identifier, can be either a
     * <a href="https://cloud.google.com/bigquery/docs/reference/v2/datasets#access.specialGroup">
     *     special group identifier</a> or a group email.
     */
    public String identifier() {
      return identifier;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Group group = (Group) o;
      return Objects.equals(type(), group.type()) && Objects.equals(identifier, group.identifier);
    }

    @Override
    public int hashCode() {
      return Objects.hash(type(), identifier);
    }

    @Override
    public String toString() {
      return toPb().toString();
    }

    @Override
    Access toPb() {
      switch (identifier) {
        case PROJECT_OWNERS:
          return new Access().setSpecialGroup(PROJECT_OWNERS);
        case PROJECT_READERS:
          return new Access().setSpecialGroup(PROJECT_READERS);
        case PROJECT_WRITERS:
          return new Access().setSpecialGroup(PROJECT_WRITERS);
        case ALL_AUTHENTICATED_USERS:
          return new Access().setSpecialGroup(ALL_AUTHENTICATED_USERS);
        default:
          return new Access().setGroupByEmail(identifier);
      }
    }

    /**
     * Returns a Group entity representing all project's owners.
     */
    public static Group ofProjectOwners() {
      return new Group(PROJECT_OWNERS);
    }

    /**
     * Returns a Group entity representing all project's readers.
     */
    public static Group ofProjectReaders() {
      return new Group(PROJECT_READERS);
    }

    /**
     * Returns a Group entity representing all project's writers.
     */
    public static Group ofProjectWriters() {
      return new Group(PROJECT_WRITERS);
    }

    /**
     * Returns a Group entity representing all BigQuery authenticated users.
     */
    public static Group ofAllAuthenticatedUsers() {
      return new Group(ALL_AUTHENTICATED_USERS);
    }
  }

  /**
   * Class for a BigQuery User entity. Objects of this class represent a user to grant access to
   * given the email address.
   */
  public static final class User extends Entity {
    
    private static final long serialVersionUID = -4942821351073996141L;
    
    private final String email;

    /**
     * Creates a User entity given the user's email.
     */
    public User(String email) {
      super(Type.USER);
      this.email = email;
    }

    /**
     * Returns user's email.
     */
    public String email() {
      return email;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      User user = (User) o;
      return Objects.equals(type(), user.type()) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
      return Objects.hash(type(), email);
    }

    @Override
    public String toString() {
      return toPb().toString();
    }

    @Override
    Access toPb() {
      return new Access().setUserByEmail(email);
    }
  }

  /**
   * Class for a BigQuery View entity. Objects of this class represent a view from a different
   * dataset to grant access to. Queries executed against that view will have read access to tables
   * in this dataset. The role field is not required when this field is set. If that view is updated
   * by any user, access to the view needs to be granted again via an update operation.
   */
  public static final class View extends Entity {

    private final TableId id;

    /**
     * Creates a View entity given the view's id.
     */
    public View(TableId id) {
      super(Type.VIEW);
      this.id = id;
    }

    /**
     * Returns table's identity.
     */
    public TableId id() {
      return id;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      View view = (View) o;
      return Objects.equals(type(), view.type()) && Objects.equals(id, view.id);
    }

    @Override
    public int hashCode() {
      return Objects.hash(type(), id);
    }

    @Override
    public String toString() {
      return toPb().toString();
    }

    @Override
    Access toPb() {
      return new Access().setView(id.toPb());
    }
  }

  /**
   * Build an ACL for an {@code entity} and a {@code role}.
   */
  public Acl(Entity entity, Role role) {
    this.entity = checkNotNull(entity);
    this.role = role;
  }

  /**
   * Build an ACL for a view entity.
   */
  public Acl(View view) {
    this.entity = checkNotNull(view);
    this.role = null;
  }

  /**
   * Returns the entity for this ACL.
   */
  public Entity entity() {
    return entity;
  }

  /**
   * Returns the role specified by this ACL.
   */
  public Role role() {
    return role;
  }

  @Override
  public int hashCode() {
    return Objects.hash(entity, role);
  }

  @Override
  public String toString() {
    return toPb().toString();
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

  Access toPb() {
    Access accessPb = entity.toPb();
    if (role != null) {
      accessPb.setRole(role.name());
    }
    return accessPb;
  }

  static Acl fromPb(Access access) {
    return new Acl(Entity.fromPb(access),
        access.getRole() != null ? Role.valueOf(access.getRole()) : null);
  }
}
