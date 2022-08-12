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

package com.google.cloud.resourcemanager;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Data;
import com.google.api.core.ApiFunction;
import com.google.cloud.StringEnumType;
import com.google.cloud.StringEnumValue;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * A Google Cloud Resource Manager project metadata object. A Project is a high-level Google Cloud
 * Platform entity. It is a container for ACLs, APIs, AppEngine Apps, VMs, and other Google Cloud
 * Platform resources.
 *
 * @deprecated v3 GAPIC client of ResourceManager is now available
 */
@Deprecated
public class ProjectInfo implements Serializable {

  public static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneOffset.UTC);
  private static final long serialVersionUID = 9148970963697734236L;
  private final String name;
  private final String projectId;
  private final Map<String, String> labels;
  private final Long projectNumber;
  private final State state;
  private final Long createTimeMillis;
  private final ResourceId parent;

  /** The project lifecycle states. */
  public static final class State extends StringEnumValue {
    private static final long serialVersionUID = 869635563976629566L;

    private static final ApiFunction<String, State> CONSTRUCTOR =
        new ApiFunction<String, State>() {
          @Override
          public State apply(String constant) {
            return new State(constant);
          }
        };

    private static final StringEnumType<State> type = new StringEnumType(State.class, CONSTRUCTOR);

    /** Only used/useful for distinguishing unset values. */
    public static final State LIFECYCLE_STATE_UNSPECIFIED =
        type.createAndRegister("LIFECYCLE_STATE_UNSPECIFIED");

    /** The normal and active state. */
    public static final State ACTIVE = type.createAndRegister("ACTIVE");

    /**
     * The project has been marked for deletion by the user or by the system (Google Cloud
     * Platform). This can generally be reversed by calling {@link ResourceManager#undelete}.
     */
    public static final State DELETE_REQUESTED = type.createAndRegister("DELETE_REQUESTED");

    /**
     * The process of deleting the project has begun. Reversing the deletion is no longer possible.
     */
    public static final State DELETE_IN_PROGRESS = type.createAndRegister("DELETE_IN_PROGRESS");

    private State(String constant) {
      super(constant);
    }

    /**
     * Get the State for the given String constant, and throw an exception if the constant is not
     * recognized.
     */
    public static State valueOfStrict(String constant) {
      return type.valueOfStrict(constant);
    }

    /** Get the State for the given String constant, and allow unrecognized values. */
    public static State valueOf(String constant) {
      return type.valueOf(constant);
    }

    /** Return the known values for State. */
    public static State[] values() {
      return type.values();
    }
  }

  public static class ResourceId implements Serializable {

    private static final long serialVersionUID = -325199985993344726L;

    private final String id;
    private final String type;

    ResourceId(String id, String type) {
      this.id = checkNotNull(id);
      this.type = checkNotNull(type);
    }

    public static ResourceId of(String id, String type) {
      return new ResourceId(checkNotNull(id), checkNotNull(type));
    }

    public String getId() {
      return id;
    }

    public String getType() {
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

  /** Builder for {@code ProjectInfo}. */
  public abstract static class Builder {

    /**
     * Set the user-assigned name of the project.
     *
     * <p>This field is optional and can remain unset. Allowed characters are: lowercase and
     * uppercase letters, numbers, hyphen, single-quote, double-quote, space, and exclamation point.
     * This field can be changed after project creation.
     */
    public abstract Builder setName(String name);

    /**
     * Set the unique, user-assigned ID of the project.
     *
     * <p>The ID must be 6 to 30 lowercase letters, digits, or hyphens. It must start with a letter.
     * Trailing hyphens are prohibited. This field cannot be changed after the server creates the
     * project.
     */
    public abstract Builder setProjectId(String projectId);

    /**
     * Add a label associated with this project.
     *
     * <p>See {@link #labels} for label restrictions.
     */
    public abstract Builder addLabel(String key, String value);

    /** Remove a label associated with this project. */
    public abstract Builder removeLabel(String key);

    /** Clear the labels associated with this project. */
    public abstract Builder clearLabels();

    /**
     * Set the labels associated with this project.
     *
     * <p>Label keys must be between 1 and 63 characters long and must conform to the following
     * regular expression: [a-z]([-a-z0-9]*[a-z0-9])?. Label values must be between 0 and 63
     * characters long and must conform to the regular expression ([a-z]([-a-z0-9]*[a-z0-9])?)?. No
     * more than 256 labels can be associated with a given resource. This field can be changed after
     * project creation.
     */
    public abstract Builder setLabels(Map<String, String> labels);

    abstract Builder setProjectNumber(Long projectNumber);

    abstract Builder setState(State state);

    abstract Builder setCreateTimeMillis(Long createTimeMillis);

    public abstract Builder setParent(ResourceId parent);

    public abstract ProjectInfo build();
  }

  static class BuilderImpl extends Builder {

    private String name;
    private String projectId;
    private Map<String, String> labels = new HashMap<>();
    private Long projectNumber;
    private State state;
    private Long createTimeMillis;
    private ResourceId parent;

    BuilderImpl(String projectId) {
      this.projectId = projectId;
    }

    BuilderImpl(ProjectInfo info) {
      this.name = info.name;
      this.projectId = info.projectId;
      this.labels.putAll(info.labels);
      this.projectNumber = info.projectNumber;
      this.state = info.state;
      this.createTimeMillis = info.createTimeMillis;
      this.parent = info.parent;
    }

    @Override
    public Builder setName(String name) {
      this.name = firstNonNull(name, Data.<String>nullOf(String.class));
      return this;
    }

    @Override
    public Builder setProjectId(String projectId) {
      this.projectId = checkNotNull(projectId);
      return this;
    }

    @Override
    public Builder addLabel(String key, String value) {
      this.labels.put(key, value);
      return this;
    }

    @Override
    public Builder removeLabel(String key) {
      this.labels.remove(key);
      return this;
    }

    @Override
    public Builder clearLabels() {
      this.labels.clear();
      return this;
    }

    @Override
    public Builder setLabels(Map<String, String> labels) {
      this.labels = Maps.newHashMap(checkNotNull(labels));
      return this;
    }

    @Override
    Builder setProjectNumber(Long projectNumber) {
      this.projectNumber = projectNumber;
      return this;
    }

    @Override
    Builder setState(State state) {
      this.state = state;
      return this;
    }

    @Override
    Builder setCreateTimeMillis(Long createTimeMillis) {
      this.createTimeMillis = createTimeMillis;
      return this;
    }

    @Override
    public Builder setParent(ResourceId parent) {
      this.parent = parent;
      return this;
    }

    @Override
    public ProjectInfo build() {
      return new ProjectInfo(this);
    }
  }

  ProjectInfo(BuilderImpl builder) {
    this.name = builder.name;
    this.projectId = builder.projectId;
    this.labels = ImmutableMap.copyOf(builder.labels);
    this.projectNumber = builder.projectNumber;
    this.state = builder.state;
    this.createTimeMillis = builder.createTimeMillis;
    this.parent = builder.parent;
  }

  /**
   * Get the unique, user-assigned ID of the project.
   *
   * <p>This field cannot be changed after the server creates the project.
   */
  public String getProjectId() {
    return projectId;
  }

  /**
   * Get the user-assigned name of the project.
   *
   * <p>This field is optional, can remain unset, and can be changed after project creation.
   */
  public String getName() {
    return Data.isNull(name) ? null : name;
  }

  /**
   * Get number uniquely identifying the project.
   *
   * <p>This field is set by the server and is read-only.
   */
  public Long getProjectNumber() {
    return projectNumber;
  }

  /** Get the immutable map of labels associated with this project. */
  public Map<String, String> getLabels() {
    return labels;
  }

  /**
   * Get the project's lifecycle state.
   *
   * <p>This is a read-only field. To change the lifecycle state of your project, use the {@code
   * delete} or {@code undelete} method.
   */
  public State getState() {
    return state;
  }

  ResourceId getParent() {
    return parent;
  }

  /**
   * Get the project's creation time (in milliseconds).
   *
   * <p>This field is set by the server and is read-only.
   */
  public Long getCreateTimeMillis() {
    return createTimeMillis;
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
            && obj.getClass().equals(ProjectInfo.class)
            && Objects.equals(toPb(), ((ProjectInfo) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, projectId, labels, projectNumber, state, createTimeMillis, parent);
  }

  public static Builder newBuilder(String id) {
    return new BuilderImpl(id);
  }

  public Builder toBuilder() {
    return new BuilderImpl(this);
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
      projectPb.setCreateTime(
          DateTimeFormatter.ISO_DATE_TIME
              .withZone(ZoneOffset.UTC)
              .format(Instant.ofEpochMilli(createTimeMillis)));
    }
    if (parent != null) {
      projectPb.setParent(parent.toPb());
    }
    return projectPb;
  }

  static ProjectInfo fromPb(com.google.api.services.cloudresourcemanager.model.Project projectPb) {
    Builder builder =
        newBuilder(projectPb.getProjectId()).setProjectNumber(projectPb.getProjectNumber());
    if (projectPb.getName() != null && !projectPb.getName().equals("Unnamed")) {
      builder.setName(projectPb.getName());
    }
    if (projectPb.getLabels() != null) {
      builder.setLabels(projectPb.getLabels());
    }
    if (projectPb.getLifecycleState() != null) {
      builder.setState(State.valueOf(projectPb.getLifecycleState()));
    }
    if (projectPb.getCreateTime() != null) {
      builder.setCreateTimeMillis(
          DATE_TIME_FORMATTER.parse(projectPb.getCreateTime(), Instant.FROM).toEpochMilli());
    }
    if (projectPb.getParent() != null) {
      builder.setParent(ResourceId.fromPb(projectPb.getParent()));
    }
    return builder.build();
  }
}
