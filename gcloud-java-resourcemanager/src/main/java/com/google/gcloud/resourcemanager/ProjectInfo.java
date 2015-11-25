/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.gcloud.resourcemanager;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import org.joda.time.format.ISODateTimeFormat;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A Google Cloud Resource Manager project metadata object.
 */
public class ProjectInfo implements Serializable {

  private static final long serialVersionUID = 9148970963697734236L;
  private final String name;
  private final String id;
  private final Map<String, String> labels;
  private final Long number;
  private final State state;
  private final Long createTimeMillis;

  /**
   * The project lifecycle state.
   *
   * <ul>
   * <li>LIFECYCLE_STATE_UNSPECIFIED:
   * <li>ACTIVE:
   * <li>DELETE_REQUESTED:
   * <li>DELETE_IN_PROGRESS:
   * <ul>
   */
  public enum State {
    /**
     * Only used/useful for distinguishing unset values
     */
    LIFECYCLE_STATE_UNSPECIFIED,

    /**
     * The normal and active state
     */
    ACTIVE,

    /**
     * The project has been marked for deletion by the user or by the system (Google Cloud
     * Platform). This can generally be reversed by calling {@link ResourceManager#undelete}.
     */
    DELETE_REQUESTED,

    /**
     * the process of deleting the project has begun. Reversing the deletion is no longer possible.
     */
    DELETE_IN_PROGRESS
  }

  public static class Builder {
    private String name;
    private String id;
    private Map<String, String> labels;
    private Long number;
    private State state;
    private Long createTimeMillis;

    Builder() {
      labels = new HashMap<>();
    }

    /**
     * Set the user-assigned name of the project.
     *
     * This field is optional and can remain unset. Allowed characters are: lowercase and uppercase
     * letters, numbers, hyphen, single-quote, double-quote, space, and exclamation point. This
     * field can be changed after project creation.
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the unique, user-assigned ID of the project.
     *
     * The ID must be 6 to 30 lowercase letters, digits, or hyphens. It must start with a letter.
     * Trailing hyphens are prohibited. This field cannot be changed after the server creates the
     * project.
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Add a label associated with this project.
     *
     * See {@link #labels} for label restrictions.
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
     * Label keys must be between 1 and 63 characters long and must conform to the following regular
     * expression: [a-z]([-a-z0-9]*[a-z0-9])?. Label values must be between 0 and 63 characters long
     * and must conform to the regular expression ([a-z]([-a-z0-9]*[a-z0-9])?)?. No more than 256
     * labels can be associated with a given resource. This field can be changed after project
     * creation.
     */
    public Builder labels(Map<String, String> labels) {
      this.labels = Maps.newHashMap(checkNotNull(labels));
      return this;
    }

    Builder number(Long number) {
      this.number = number;
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

    public ProjectInfo build() {
      return new ProjectInfo(this);
    }
  }

  ProjectInfo(Builder builder) {
    this.name = builder.name;
    this.id = checkNotNull(builder.id);
    this.labels = ImmutableMap.copyOf(builder.labels);
    this.number = builder.number;
    this.state = builder.state;
    this.createTimeMillis = builder.createTimeMillis;
  }

  /**
   * Get the unique, user-assigned ID of the project.
   *
   * This field cannot be changed after the server creates the project.
   */
  public String id() {
    return id;
  }

  /**
   * Get the user-assigned name of the project.
   *
   * This field is optional, can remain unset, and can be changed after project creation.
   */
  public String name() {
    return name;
  }

  /**
   * Get number uniquely identifying the project.
   *
   * This field is set by the server and is read-only.
   */
  public Long number() {
    return number;
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
   * This is a read-only field. To change the lifecycle state of your project, use the
   * {@code delete} or {@code undelete} method.
   */
  public State state() {
    return state;
  }

  /**
   * Get the project's creation time (in milliseconds).
   *
   * This field is set by the server and is read-only.
   */
  public Long createTimeMillis() {
    return createTimeMillis;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ProjectInfo && Objects.equals(toPb(), ((ProjectInfo) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, labels, number, state, createTimeMillis);
  }

  public static Builder builder(String id) {
    return new Builder().id(id);
  }

  public Builder toBuilder() {
    return new Builder()
        .name(name)
        .id(id)
        .labels(labels)
        .number(number)
        .state(state)
        .createTimeMillis(createTimeMillis);
  }

  com.google.api.services.cloudresourcemanager.model.Project toPb() {
    com.google.api.services.cloudresourcemanager.model.Project projectPb =
        new com.google.api.services.cloudresourcemanager.model.Project();
    projectPb.setName(name);
    projectPb.setProjectId(id);
    projectPb.setLabels(labels);
    projectPb.setProjectNumber(number);
    if (state != null) {
      projectPb.setLifecycleState(state.toString());
    }
    if (createTimeMillis != null) {
      projectPb.setCreateTime(ISODateTimeFormat.dateTime().print(createTimeMillis));
    }
    return projectPb;
  }

  static ProjectInfo fromPb(com.google.api.services.cloudresourcemanager.model.Project projectPb) {
    ProjectInfo.Builder builder =
        ProjectInfo.builder(projectPb.getProjectId()).name(projectPb.getName());
    if (projectPb.getLabels() != null) {
      builder.labels(projectPb.getLabels());
    }
    return builder.build();
  }
}
