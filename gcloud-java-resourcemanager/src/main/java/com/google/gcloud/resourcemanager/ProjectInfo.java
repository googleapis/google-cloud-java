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

import org.joda.time.DateTime;
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
  private final ResourceId parent;

  public enum State {
    LIFECYCLE_STATE_UNSPECIFIED,
    ACTIVE,
    DELETE_REQUESTED,
    DELETE_IN_PROGRESS;
  }

  public static class Builder {
    private String name;
    private String id;
    private Map<String, String> labels;
    private Long number;
    private State state;
    private Long createTimeMillis;
    private ResourceId parent;

    Builder() {
      labels = new HashMap<String, String>();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder addLabel(String key, String value) {
      this.labels.put(key, value);
      return this;
    }

    public Builder removeLabel(String key) {
      this.labels.remove(key);
      return this;
    }

    public Builder clearLabels() {
      this.labels.clear();
      return this;
    }

    public Builder labels(Map<String, String> labels) {
      this.labels = checkNotNull(labels);
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

    public Builder parent(ResourceId parent) {
      this.parent = parent;
      return this;
    }

    public ProjectInfo build() {
      return new ProjectInfo(name, id, labels, number, state, createTimeMillis, parent);
    }
  }

  ProjectInfo(String name, String id, Map<String, String> labels, Long number, State state,
      Long createTimeMillis, ResourceId parent) {
    this.name = name;
    this.id = checkNotNull(id);
    ImmutableMap.Builder<String, String> labelsMapBuilder = ImmutableMap.builder();
    for (Map.Entry<String, String> entry : labels.entrySet()) {
      labelsMapBuilder.put(entry.getKey(), entry.getValue());
    }
    this.labels = (labels == null) ? null : labelsMapBuilder.build();
    this.number = number;
    this.state = state;
    this.createTimeMillis = createTimeMillis;
    this.parent = parent;
  }

  public String id() {
    return id;
  }

  public String name() {
    return name;
  }

  public Long number() {
    return number;
  }

  public Map<String, String> labels() {
    return labels;
  }

  public State state() {
    return state;
  }

  public Long createTimeMillis() {
    return createTimeMillis;
  }

  public ResourceId parent() {
    return parent;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    } else if (obj instanceof ProjectInfo) {
      ProjectInfo other = (ProjectInfo) obj;
      return Objects.equals(this.name, other.name) && Objects.equals(this.id, other.id)
          && Objects.equals(this.labels, other.labels) && Objects.equals(this.number, other.number)
          && Objects.equals(this.state, other.state)
          && Objects.equals(this.createTimeMillis, other.createTimeMillis)
          && Objects.equals(this.parent, other.parent);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, labels, number, state, createTimeMillis, parent);
  }

  public static Builder builder(String id) {
    return new Builder().id(id);
  }

  public Builder toBuilder() {
    Map<String, String> mutableLabels = new HashMap<String, String>();
    for (Map.Entry<String, String> entry : labels.entrySet()) {
      mutableLabels.put(entry.getKey(), entry.getValue());
    }
    return new Builder()
        .name(name)
        .id(id)
        .labels(mutableLabels)
        .number(number)
        .state(state)
        .createTimeMillis(createTimeMillis)
        .parent(parent);
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
    if (parent != null) {
      projectPb.setParent(parent.toPb());
    }
    return projectPb;
  }

  static ProjectInfo fromPb(com.google.api.services.cloudresourcemanager.model.Project projectPb) {
    ProjectInfo.Builder builder = 
        ProjectInfo.builder(projectPb.getProjectId())
            .name(projectPb.getName())
            .number(projectPb.getProjectNumber());
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
}
