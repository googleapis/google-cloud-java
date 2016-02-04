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

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Objects;

/**
 * A Google Cloud Resource Manager project object.
 *
 * <p>A Project is a high-level Google Cloud Platform entity. It is a container for ACLs, APIs,
 * AppEngine Apps, VMs, and other Google Cloud Platform resources. This class' member variables are
 * immutable. Methods that change or update the underlying Project information return a new Project
 * instance. {@code Project} adds a layer of service-related functionality over {@link ProjectInfo}.
 */
public class Project extends ProjectInfo {

  private static final long serialVersionUID = 6767630161335155133L;

  private final ResourceManagerOptions options;
  private transient ResourceManager resourceManager;

  public static class Builder extends ProjectInfo.Builder {
    private final ResourceManager resourceManager;
    private final ProjectInfo.BuilderImpl infoBuilder;

    Builder(ResourceManager resourceManager) {
      this.resourceManager = resourceManager;
      this.infoBuilder = new ProjectInfo.BuilderImpl();
    }

    Builder(Project project) {
      this.resourceManager = project.resourceManager;
      this.infoBuilder = new ProjectInfo.BuilderImpl(project);
    }

    @Override
    public Builder name(String name) {
      infoBuilder.name(name);
      return this;
    }

    @Override
    public Builder projectId(String projectId) {
      infoBuilder.projectId(projectId);
      return this;
    }

    @Override
    public Builder addLabel(String key, String value) {
      infoBuilder.addLabel(key, value);
      return this;
    }

    @Override
    public Builder removeLabel(String key) {
      infoBuilder.removeLabel(key);
      return this;
    }

    @Override
    public Builder clearLabels() {
      infoBuilder.clearLabels();
      return this;
    }

    @Override
    public Builder labels(Map<String, String> labels) {
      infoBuilder.labels(labels);
      return this;
    }

    @Override
    Builder projectNumber(Long projectNumber) {
      infoBuilder.projectNumber(projectNumber);
      return this;
    }

    @Override
    Builder state(State state) {
      infoBuilder.state(state);
      return this;
    }

    @Override
    Builder createTimeMillis(Long createTimeMillis) {
      infoBuilder.createTimeMillis(createTimeMillis);
      return this;
    }

    @Override
    Builder parent(ResourceId parent) {
      infoBuilder.parent(parent);
      return this;
    }

    @Override
    public Project build() {
      return new Project(resourceManager, infoBuilder);
    }
  }

  Project(ResourceManager resourceManager, ProjectInfo.BuilderImpl infoBuilder) {
    super(infoBuilder);
    this.resourceManager = checkNotNull(resourceManager);
    this.options = resourceManager.options();
  }

  /**
   * Returns the {@link ResourceManager} service object associated with this Project.
   */
  public ResourceManager resourceManager() {
    return resourceManager;
  }

  /**
   * Fetches the current project's latest information. Returns {@code null} if the job does not
   * exist.
   *
   * @return Project containing the project's updated metadata or {@code null} if not found
   * @throws ResourceManagerException upon failure
   */
  public Project reload() {
    return resourceManager.get(projectId());
  }

  /**
   * Marks the project identified by the specified project ID for deletion.
   *
   * <p>This method will only affect the project if the following criteria are met:
   * <ul>
   * <li>The project does not have a billing account associated with it.
   * <li>The project has a lifecycle state of {@link ProjectInfo.State#ACTIVE}.
   * </ul>
   * This method changes the project's lifecycle state from {@link ProjectInfo.State#ACTIVE} to
   * {@link ProjectInfo.State#DELETE_REQUESTED}. The deletion starts at an unspecified time, at
   * which point the lifecycle state changes to {@link ProjectInfo.State#DELETE_IN_PROGRESS}. Until
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
    resourceManager.delete(projectId());
  }

  /**
   * Restores the project identified by the specified project ID.
   *
   * <p>You can only use this method for a project that has a lifecycle state of
   * {@link ProjectInfo.State#DELETE_REQUESTED}. After deletion starts, as indicated by a lifecycle
   * state of {@link ProjectInfo.State#DELETE_IN_PROGRESS}, the project cannot be restored. The
   * caller must have modify permissions for this project.
   *
   * @see <a
   * href="https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/undelete">Cloud
   * Resource Manager undelete</a>
   * @throws ResourceManagerException upon failure (including when the project can't be restored)
   */
  public void undelete() {
    resourceManager.undelete(projectId());
  }

  /**
   * Replaces the attributes of the project with the attributes of this project.
   *
   * <p>The caller must have modify permissions for this project.
   *
   * @see <a
   * href="https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/update">Cloud
   * Resource Manager update</a>
   * @return the Project representing the new project metadata
   * @throws ResourceManagerException upon failure
   */
  public Project replace() {
    return resourceManager.replace(this);
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Project && Objects.equals(toPb(), ((Project) obj).toPb())
        && Objects.equals(options, ((Project) obj).options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), options);
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    this.resourceManager = options.service();
  }

  static Project fromPb(ResourceManager resourceManager,
      com.google.api.services.cloudresourcemanager.model.Project answer) {
    ProjectInfo info = ProjectInfo.fromPb(answer);
    return new Project(resourceManager, new ProjectInfo.BuilderImpl(info));
  }
}
