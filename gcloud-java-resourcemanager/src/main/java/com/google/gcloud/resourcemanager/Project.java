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

package com.google.gcloud.resourcemanager;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Data;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A Google Cloud Resource Manager project object.
 *
 * <p>A Project is a high-level Google Cloud Platform entity. It is a container for ACLs, APIs,
 * AppEngine Apps, VMs, and other Google Cloud Platform resources. This class' member variables are
 * immutable.  Methods that change or update the underlying Project information return a new Project
 * instance.
 */
public class Project implements Serializable {

  private static final long serialVersionUID = 6772622204012731332L;

  private final String name;
  private final String projectId;
  private final Map<String, String> labels;
  private final Long projectNumber;
  private final State state;
  private final Long createTimeMillis;
  private final ResourceId parent;
  private final ResourceManagerOptions options;
  private transient ResourceManager resourceManager;

  /**
   * The project lifecycle states.
   */
  public enum State {
    /**
     * Only used/useful for distinguishing unset values.
     */
    LIFECYCLE_STATE_UNSPECIFIED,

    /**
     * The normal and active state.
     */
    ACTIVE,

    /**
     * The project has been marked for deletion by the user or by the system (Google Cloud
     * Platform). This can generally be reversed by calling {@link ResourceManager#undelete}.
     */
    DELETE_REQUESTED,

    /**
     * The process of deleting the project has begun. Reversing the deletion is no longer possible.
     */
    DELETE_IN_PROGRESS
  }

  static class ResourceId implements Serializable {

    private static final long serialVersionUID = 214964928747889072L;

    private final String id;
    private final String type;

    ResourceId(String id, String type) {
      this.id = checkNotNull(id);
      this.type = checkNotNull(type);
    }

    String id() {
      return id;
    }

    String type() {
      return type;
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof ResourceId && Objects.equals(toPb(), ((ResourceId) obj).toPb());
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, type);
    }

    com.google.api.services.cloudresourcemanager.model.ResourceId toPb() {
      com.google.api.services.cloudresourcemanager.model.ResourceId resourceIdPb =
          new com.google.api.services.cloudresourcemanager.model.ResourceId();
      resourceIdPb.setId(id);
      resourceIdPb.setType(type.toLowerCase());
      return resourceIdPb;
    }

    static ResourceId fromPb(
        com.google.api.services.cloudresourcemanager.model.ResourceId resourceIdPb) {
      return new ResourceId(resourceIdPb.getId(), resourceIdPb.getType());
    }
  }

  public static class Builder {

    private String name;
    private String projectId;
    private Map<String, String> labels = new HashMap<>();
    private Long projectNumber;
    private State state;
    private Long createTimeMillis;
    private ResourceId parent;
    private ResourceManager resourceManager;

    private Builder() {
    }

    Builder(Project project) {
      this.name = project.name;
      this.projectId = project.projectId;
      this.labels.putAll(project.labels);
      this.projectNumber = project.projectNumber;
      this.state = project.state;
      this.createTimeMillis = project.createTimeMillis;
      this.parent = project.parent;
      this.resourceManager = project.resourceManager;
    }

    /**
     * Set the user-assigned name of the project.
     *
     * <p>This field is optional and can remain unset. Allowed characters are: lowercase and
     * uppercase letters, numbers, hyphen, single-quote, double-quote, space, and exclamation point.
     * This field can be changed after project creation.
     */
    public Builder name(String name) {
      this.name = firstNonNull(name, Data.<String>nullOf(String.class));
      return this;
    }

    /**
     * Set the unique, user-assigned ID of the project.
     *
     * <p>The ID must be 6 to 30 lowercase letters, digits, or hyphens. It must start with a letter.
     * Trailing hyphens are prohibited. This field cannot be changed after the server creates the
     * project.
     */
    public Builder projectId(String projectId) {
      this.projectId = checkNotNull(projectId);
      return this;
    }

    /**
     * Add a label associated with this project.
     *
     * <p>See {@link #labels} for label restrictions.
     */
    public Builder addLabel(String key, String value) {
      this.labels.put(key, value);
      return this;
    }

    /**
     * Remove a label associated with this project.
     */
    public Builder removeLabel(String key) {
      this.labels.remove(key);
      return this;
    }

    /**
     * Clear the labels associated with this project.
     */
    public Builder clearLabels() {
      this.labels.clear();
      return this;
    }

    /**
     * Set the labels associated with this project.
     *
     * <p>Label keys must be between 1 and 63 characters long and must conform to the following
     * regular expression: [a-z]([-a-z0-9]*[a-z0-9])?. Label values must be between 0 and 63
     * characters long and must conform to the regular expression ([a-z]([-a-z0-9]*[a-z0-9])?)?. No
     * more than 256 labels can be associated with a given resource. This field can be changed after
     * project creation.
     */
    public Builder labels(Map<String, String> labels) {
      this.labels = Maps.newHashMap(checkNotNull(labels));
      return this;
    }

    Builder projectNumber(Long projectNumber) {
      this.projectNumber = projectNumber;
      return this;
    }

    Builder state(State state) {
      this.state = state;
      return this;
    }

    Builder createTimeMillis(Long createTimeMillis) {
      this.createTimeMillis = createTimeMillis;
      return this;
    }

    Builder parent(ResourceId parent) {
      this.parent = parent;
      return this;
    }

    /**
     * Sets the service object associated with this Project. This service object is used to send
     * requests relevant to this blob (e.g. {@link #delete}, {@link #reload}, {@link #replace},
     * {@link #undelete}).
     */
    public Builder resourceManager(ResourceManager resourceManager) {
      this.resourceManager = checkNotNull(resourceManager);
      return this;
    }

    public Project build() {
      return new Project(this);
    }
  }

  Project(Builder builder) {
    this.name = builder.name;
    this.projectId = builder.projectId;
    this.labels = ImmutableMap.copyOf(builder.labels);
    this.projectNumber = builder.projectNumber;
    this.state = builder.state;
    this.createTimeMillis = builder.createTimeMillis;
    this.parent = builder.parent;
    this.options = builder.resourceManager.options();
    this.resourceManager = builder.resourceManager;
  }

  /**
   * Get the unique, user-assigned ID of the project.
   *
   * <p>This field cannot be changed after the server creates the project.
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Get the user-assigned name of the project.
   *
   * <p>This field is optional, can remain unset, and can be changed after project creation.
   */
  public String name() {
    return Data.isNull(name) ? null : name;
  }

  /**
   * Get number uniquely identifying the project.
   *
   * <p>This field is set by the server and is read-only.
   */
  public Long projectNumber() {
    return projectNumber;
  }

  /**
   * Get the immutable map of labels associated with this project.
   */
  public Map<String, String> labels() {
    return labels;
  }

  /**
   * Get the project's lifecycle state.
   *
   * <p>This is a read-only field. To change the lifecycle state of your project, use the
   * {@code delete} or {@code undelete} method.
   */
  public State state() {
    return state;
  }

  ResourceId parent() {
    return parent;
  }

  /**
   * Get the project's creation time (in milliseconds).
   *
   * <p>This field is set by the server and is read-only.
   */
  public Long createTimeMillis() {
    return createTimeMillis;
  }

  /**
   * Returns the {@link ResourceManager} service object associated with this Project.
   */
  public ResourceManager resourceManager() {
    return resourceManager;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Project && Objects.equals(toPb(), ((Project) obj).toPb())
        && Objects.equals(options, ((Project) obj).options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        name, projectId, labels, projectNumber, state, createTimeMillis, parent, options);
  }

  public static Builder builder(ResourceManager resourceManager, String id) {
    return new Builder().projectId(id).resourceManager(resourceManager);
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Creates a project.
   *
   * @return a Project containing the project's data
   * @throws ResourceManagerException upon failure
   */
  public Project create() {
    return resourceManager.create(this);
  }

  /**
   * Constructs a Project object that contains project information loaded from the server.
   *
   * @return Project object containing the project's data or {@code null} if not found
   * @throws ResourceManagerException upon failure
   */
  public static Project get(ResourceManager resourceManager, String projectId) {
    return resourceManager.get(projectId);
  }

  /**
   * Fetches the current project's latest information. Returns {@code null} if the job does not
   * exist.
   *
   * @return Project containing the project's updated metadata or {@code null} if not found
   * @throws ResourceManagerException upon failure
   */
  public Project reload() {
    return resourceManager.get(projectId);
  }

  /**
   * Marks the project identified by the specified project ID for deletion.
   *
   * <p>This method will only affect the project if the following criteria are met:
   * <ul>
   * <li>The project does not have a billing account associated with it.
   * <li>The project has a lifecycle state of {@link Project.State#ACTIVE}.
   * </ul>
   * This method changes the project's lifecycle state from {@link Project.State#ACTIVE} to
   * {@link Project.State#DELETE_REQUESTED}. The deletion starts at an unspecified time, at
   * which point the lifecycle state changes to {@link Project.State#DELETE_IN_PROGRESS}. Until
   * the deletion completes, you can check the lifecycle state checked by retrieving the project
   * with {@link ResourceManager#get}, and the project remains visible to
   * {@link ResourceManager#list}. However, you cannot update the project. After the deletion
   * completes, the project is not retrievable by the {@link ResourceManager#get} and
   * {@link ResourceManager#list} methods. The caller must have modify permissions for this project.
   *
   * @see <a
   * href="https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/delete">Cloud
   * Resource Manager delete</a>
   * @throws ResourceManagerException upon failure
   */
  public void delete() {
    resourceManager.delete(projectId);
  }

  /**
   * Restores the project identified by the specified project ID.
   *
   * <p>You can only use this method for a project that has a lifecycle state of
   * {@link Project.State#DELETE_REQUESTED}. After deletion starts, as indicated by a lifecycle
   * state of {@link Project.State#DELETE_IN_PROGRESS}, the project cannot be restored. The
   * caller must have modify permissions for this project.
   *
   * @see <a
   * href="https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/undelete">Cloud
   * Resource Manager undelete</a>
   * @throws ResourceManagerException upon failure (including when the project can't be restored)
   */
  public void undelete() {
    resourceManager.undelete(projectId);
  }

  /**
   * Replaces the attributes of the project.
   *
   * <p>The caller must have modify permissions for this project.
   *
   * @see <a
   * href="https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/update">Cloud
   * Resource Manager update</a>
   * @return the Project representing the new project metadata
   * @throws ResourceManagerException upon failure
   */
  public Project replace(Project project) {
    return resourceManager.replace(checkNotNull(project));
  }

  com.google.api.services.cloudresourcemanager.model.Project toPb() {
    com.google.api.services.cloudresourcemanager.model.Project projectPb =
        new com.google.api.services.cloudresourcemanager.model.Project();
    projectPb.setName(name);
    projectPb.setProjectId(projectId);
    projectPb.setLabels(labels);
    projectPb.setProjectNumber(projectNumber);
    if (state != null) {
      projectPb.setLifecycleState(state.toString());
    }
    if (createTimeMillis != null) {
      projectPb.setCreateTime(ISODateTimeFormat.dateTime().withZoneUTC().print(createTimeMillis));
    }
    if (parent != null) {
      projectPb.setParent(parent.toPb());
    }
    return projectPb;
  }

  static Project fromPb(
      ResourceManager resourceManager,
      com.google.api.services.cloudresourcemanager.model.Project projectPb) {
    Builder builder =
        builder(resourceManager, projectPb.getProjectId())
            .projectNumber(projectPb.getProjectNumber());
    if (projectPb.getName() != null && !projectPb.getName().equals("Unnamed")) {
      builder.name(projectPb.getName());
    }
    if (projectPb.getLabels() != null) {
      builder.labels(projectPb.getLabels());
    }
    if (projectPb.getLifecycleState() != null) {
      builder.state(State.valueOf(projectPb.getLifecycleState()));
    }
    if (projectPb.getCreateTime() != null) {
      builder.createTimeMillis(DateTime.parse(projectPb.getCreateTime()).getMillis());
    }
    if (projectPb.getParent() != null) {
      builder.parent(ResourceId.fromPb(projectPb.getParent()));
    }
    return builder.build();
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.resourceManager = options.service();
  }
}
