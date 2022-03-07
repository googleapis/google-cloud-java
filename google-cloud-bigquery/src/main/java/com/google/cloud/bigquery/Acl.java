/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.bigquery;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFunction;
import com.google.api.services.bigquery.model.Dataset.Access;
import com.google.api.services.bigquery.model.DatasetAccessEntry;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import java.io.Serializable;
import java.util.List;
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
  public static final class Role extends StringEnumValue {
    private static final long serialVersionUID = -1992679397135956912L;

    private static final ApiFunction<String, Role> CONSTRUCTOR =
        new ApiFunction<String, Role>() {
          @Override
          public Role apply(String constant) {
            return new Role(constant);
          }
        };

    private static final StringEnumType<Role> type =
        new StringEnumType<Role>(Role.class, CONSTRUCTOR);

    /** Can read, query, copy or export tables in the dataset. */
    public static final Role READER = type.createAndRegister("READER");

    /** Same as {@link #READER} plus can edit or append data in the dataset. */
    public static final Role WRITER = type.createAndRegister("WRITER");

    /** Same as {@link #WRITER} plus can update and delete the dataset. */
    public static final Role OWNER = type.createAndRegister("OWNER");

    private Role(String constant) {
      super(constant);
    }

    /**
     * Get the Role for the given String constant, and throw an exception if the constant is not
     * recognized.
     */
    public static Role valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /** Get the Role for the given String constant, and allow unrecognized values. */
    public static Role valueOf(String constant) {
      return type.valueOf(constant);
    }

    /** Return the known values for Role. */
    public static Role[] values() {
      return type.values();
    }
  }

  /** Base class for BigQuery entities that can be grant access to the dataset. */
  public abstract static class Entity implements Serializable {

    private static final long serialVersionUID = 8111776788607959944L;

    private final Type type;

    /** Types of BigQuery entities. */
    public enum Type {
      DOMAIN,
      GROUP,
      USER,
      VIEW,
      IAM_MEMBER,
      ROUTINE,
      DATASET
    }

    Entity(Type type) {
      this.type = type;
    }

    public Type getType() {
      return type;
    }

    abstract Access toPb();

    static Entity fromPb(Access access) {
      if (access.getDataset() != null) {
        return new DatasetAclEntity(
            DatasetId.fromPb(access.getDataset().getDataset()),
            access.getDataset().getTargetTypes());
      }
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
      if (access.getIamMember() != null) {
        return new IamMember(access.getIamMember());
      }
      if (access.getRoutine() != null) {
        return new Routine(RoutineId.fromPb(access.getRoutine()));
      }
      // Unreachable
      throw new BigQueryException(
          BigQueryException.UNKNOWN_CODE, "Unrecognized access configuration");
    }
  }

  /**
   * Class for a BigQuery DatasetAclEntity ACL entity. Objects of this class represent a
   * DatasetAclEntity from a different DatasetAclEntity to grant access to. Only views are supported
   * for now. The role field is not required when this field is set. If that DatasetAclEntity is
   * deleted and re-created, its access needs to be granted again via an update operation.
   */
  public static final class DatasetAclEntity extends Entity {

    private static final long serialVersionUID = -8392885851733136526L;

    private final DatasetId id;
    private final List<String> targetTypes;

    /** Creates a DatasetAclEntity given the DatasetAclEntity's id. */
    public DatasetAclEntity(DatasetId id, List<String> targetTypes) {
      super(Type.DATASET);
      this.id = id;
      this.targetTypes = targetTypes;
    }

    /** Returns DatasetAclEntity's identity. */
    public DatasetId getId() {
      return id;
    }

    public List<String> getTargetTypes() {
      return targetTypes;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      DatasetAclEntity datasetAclEntity = (DatasetAclEntity) obj;
      return Objects.equals(getType(), datasetAclEntity.getType())
          && Objects.equals(id, datasetAclEntity.id)
          && Objects.equals(targetTypes, datasetAclEntity.targetTypes);
    }

    @Override
    public int hashCode() {
      return Objects.hash(getType(), id);
    }

    @Override
    public String toString() {
      return toPb().toString();
    }

    @Override
    Access toPb() {
      return new Access()
          .setDataset(new DatasetAccessEntry().setDataset(id.toPb()).setTargetTypes(targetTypes));
    }
  }

  /**
   * Class for a BigQuery Domain entity. Objects of this class represent a domain to grant access
   * to. Any users signed in with the domain specified will be granted the specified access.
   */
  public static final class Domain extends Entity {

    private static final long serialVersionUID = -3033025857280447253L;

    private final String domain;

    /** Creates a Domain entity given the domain name. */
    public Domain(String domain) {
      super(Type.DOMAIN);
      this.domain = domain;
    }

    /** Returns the domain name. */
    public String getDomain() {
      return domain;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      Domain domainEntity = (Domain) obj;
      return Objects.equals(getType(), domainEntity.getType())
          && Objects.equals(domain, domainEntity.getDomain());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getType(), domain);
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
   * Class for a BigQuery Group entity. Objects of this class represent a group to granted access
   * to. A Group entity can be created given the group's email or can be a special group: {@link
   * #ofProjectOwners()}, {@link #ofProjectReaders()}, {@link #ofProjectWriters()} or {@link
   * #ofAllAuthenticatedUsers()}.
   */
  public static final class Group extends Entity {

    private static final String PROJECT_OWNERS = "projectOwners";
    private static final String PROJECT_READERS = "projectReaders";
    private static final String PROJECT_WRITERS = "projectWriters";
    private static final String ALL_AUTHENTICATED_USERS = "allAuthenticatedUsers";
    private static final long serialVersionUID = 5146829352398103029L;

    private final String identifier;

    /**
     * Creates a Group entity given its identifier. Identifier can be either a <a
     * href="https://cloud.google.com/bigquery/docs/reference/v2/datasets#access.specialGroup">
     * special group identifier</a> or a group email.
     */
    public Group(String identifier) {
      super(Type.GROUP);
      this.identifier = identifier;
    }

    /**
     * Returns group's identifier, can be either a <a
     * href="https://cloud.google.com/bigquery/docs/reference/v2/datasets#access.specialGroup">
     * special group identifier</a> or a group email.
     */
    public String getIdentifier() {
      return identifier;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      Group group = (Group) obj;
      return Objects.equals(getType(), group.getType())
          && Objects.equals(identifier, group.identifier);
    }

    @Override
    public int hashCode() {
      return Objects.hash(getType(), identifier);
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

    /** Returns a Group entity representing all project's owners. */
    public static Group ofProjectOwners() {
      return new Group(PROJECT_OWNERS);
    }

    /** Returns a Group entity representing all project's readers. */
    public static Group ofProjectReaders() {
      return new Group(PROJECT_READERS);
    }

    /** Returns a Group entity representing all project's writers. */
    public static Group ofProjectWriters() {
      return new Group(PROJECT_WRITERS);
    }

    /** Returns a Group entity representing all BigQuery authenticated users. */
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

    /** Creates a User entity given the user's email. */
    public User(String email) {
      super(Type.USER);
      this.email = email;
    }

    /** Returns user's email. */
    public String getEmail() {
      return email;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      User user = (User) obj;
      return Objects.equals(getType(), user.getType()) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
      return Objects.hash(getType(), email);
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
   * datasetAclEntity to grant access to. Queries executed against that view will have read access
   * to tables in this datasetAclEntity. The role field is not required when this field is set. If
   * that view is updated by any user, access to the view needs to be granted again via an update
   * operation.
   */
  public static final class View extends Entity {

    private static final long serialVersionUID = -6851072781269419383L;

    private final TableId id;

    /** Creates a View entity given the view's id. */
    public View(TableId id) {
      super(Type.VIEW);
      this.id = id;
    }

    /** Returns table's identity. */
    public TableId getId() {
      return id;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      View view = (View) obj;
      return Objects.equals(getType(), view.getType()) && Objects.equals(id, view.id);
    }

    @Override
    public int hashCode() {
      return Objects.hash(getType(), id);
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
   * Class for a BigQuery Routine entity. Objects of this class represent a routine from a different
   * datasetAclEntity to grant access to. Queries executed against that routine will have read
   * access to views/tables/routines in this datasetAclEntity. Only UDF is supported for now. The
   * role field is not required when this field is set. If that routine is updated by any user,
   * access to the routine needs to be granted again via an update operation.
   */
  public static final class Routine extends Entity {

    private static final long serialVersionUID = -8392885851733136262L;

    private final RoutineId id;

    /** Creates a Routine entity given the routine's id. */
    public Routine(RoutineId id) {
      super(Type.ROUTINE);
      this.id = id;
    }

    /** Returns routine's identity. */
    public RoutineId getId() {
      return id;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      Routine routine = (Routine) obj;
      return Objects.equals(getType(), routine.getType()) && Objects.equals(id, routine.id);
    }

    @Override
    public int hashCode() {
      return Objects.hash(getType(), id);
    }

    @Override
    public String toString() {
      return toPb().toString();
    }

    @Override
    Access toPb() {
      return new Access().setRoutine(id.toPb());
    }
  }

  /**
   * Class for a BigQuery IamMember entity. Objects of this class represent a iamMember to grant
   * access to given the IAM Policy.
   */
  public static final class IamMember extends Entity {

    private static final long serialVersionUID = 3562909264454016939L;
    private final String iamMember;

    /** Creates a iamMember entity given the iamMember. */
    public IamMember(String iamMember) {
      super(Type.IAM_MEMBER);
      this.iamMember = iamMember;
    }

    /** Returns iamMember. */
    public String getIamMember() {
      return iamMember;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
        return false;
      }
      IamMember iam = (IamMember) obj;
      return Objects.equals(getType(), iam.getType()) && Objects.equals(iamMember, iam.iamMember);
    }

    @Override
    public int hashCode() {
      return Objects.hash(getType(), iamMember);
    }

    @Override
    public String toString() {
      return toPb().toString();
    }

    @Override
    Access toPb() {
      return new Access().setIamMember(iamMember);
    }
  }

  private Acl(Entity entity, Role role) {
    this.entity = checkNotNull(entity);
    this.role = role;
  }

  /** Returns the entity for this ACL. */
  public Entity getEntity() {
    return entity;
  }

  /** Returns the role specified by this ACL. */
  public Role getRole() {
    return role;
  }

  /**
   * Returns an Acl object.
   *
   * @param entity the entity for this ACL object
   * @param role the role to associate to the {@code entity} object
   */
  public static Acl of(Entity entity, Role role) {
    return new Acl(entity, role);
  }

  /** Returns an Acl object for a datasetAclEntity. */
  public static Acl of(DatasetAclEntity datasetAclEntity) {
    return new Acl(datasetAclEntity, null);
  }

  /** Returns an Acl object for a view entity. */
  public static Acl of(View view) {
    return new Acl(view, null);
  }

  /** Returns an Acl object for a routine entity. */
  public static Acl of(Routine routine) {
    return new Acl(routine, null);
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
    return Objects.equals(this.entity, other.entity) && Objects.equals(this.role, other.role);
  }

  Access toPb() {
    Access accessPb = entity.toPb();
    if (role != null) {
      accessPb.setRole(role.name());
    }
    return accessPb;
  }

  static Acl fromPb(Access access) {
    return Acl.of(
        Entity.fromPb(access), access.getRole() != null ? Role.valueOf(access.getRole()) : null);
  }
}
