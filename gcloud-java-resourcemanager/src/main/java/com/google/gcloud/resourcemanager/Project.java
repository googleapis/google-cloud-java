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

import com.google.gcloud.spi.ResourceManagerRpc.Permission;

import java.util.List;

/**
 * A Google Cloud Resource Manager project object.
 *
 * This class' member variables are immutable.  Methods that change or update the underlying Project
 * information return a new Project instance.
 */
public class Project {

  private final ResourceManager resourceManager;
  private final ProjectInfo info;
  private final Policy policy;

  /**
   * Constructs a Project object that contains the ProjectInfo and Policy given.
   */
  public Project(ResourceManager resourceManager, ProjectInfo projectInfo, Policy policy) {
    this.resourceManager = checkNotNull(resourceManager);
    this.info = checkNotNull(projectInfo);
    this.policy = checkNotNull(policy);
  }

  /**
   * Constructs a Project object that contains project and policy information loaded from the
   * server.
   *
   * @return Project object containing the project's metadata and IAM policy
   * @throws ResourceManagerException upon failure
   */
  public static Project load(ResourceManager resourceManager, String projectId) {
    ProjectInfo projectInfo = resourceManager.get(projectId);
    Policy policy = resourceManager.getIamPolicy(projectId);
    return new Project(resourceManager, projectInfo, policy);
  }

  public ProjectInfo info() {
    return info;
  }

  public Policy policy() {
    return policy;
  }

  public ResourceManager resourceManager() {
    return resourceManager;
  }

  /**
   * Returns a Project object with updated project and policy information.
   *
   * @return Project object containing the project's updated metadata and IAM policy
   * @throws ResourceManagerException upon failure
   */
  public Project reload() {
    return new Project(
        resourceManager, resourceManager.get(info.id()), resourceManager.getIamPolicy(info.id()));
  }

  /**
   * Requests that this project be deleted. For an unspecified amount of time, this action can be
   * undone by calling {@link #undelete}.
   *
   * @throws ResourceManagerException upon failure
   */
  public void delete() {
    resourceManager.delete(info.id());
  }

  /**
   * Requests that a project's lifecycle status be changed from {@code DELETE_REQUESTED} to
   * {@code ACTIVE}.
   *
   * @throws ResourceManagerException upon failure
   */
  public void undelete() {
    resourceManager.undelete(info.id());
  }

  /**
   * Replaces the project metadata (not including the IAM policy) using the given ProjectInfo.
   *
   * @return Project object containing the project's updated metadata
   * @throws ResourceManagerException upon failure
   */
  public Project replace(ProjectInfo projectInfo) {
    return new Project(resourceManager, resourceManager.replace(checkNotNull(projectInfo)), policy);
  }

  /**
   * Replaces the project's IAM policy using the given policy.
   *
   * @return Project object containing the project's updated IAM policy
   * @throws ResourceManagerException upon failure
   */
  public Project replaceIamPolicy(Policy policy) {
    return new Project(
        resourceManager, info, resourceManager.replaceIamPolicy(info.id(), checkNotNull(policy)));
  }

  /**
   * Returns whether the caller has the permissions specified in the parameters.
   *
   * @return List of booleans representing whether the user has the corresponding permission
   *     provided as a parameter
   * @throws ResourceManagerException upon failure
   */
  public List<Boolean> hasPermissions(Permission... permissions) {
    return resourceManager.hasPermissions(info.id(), permissions);
  }

  /**
   * Returns whether the caller has all the permissions specified in the parameters.
   *
   * @return true if the caller has all the permissions specified, otherwise false.
   * @throws ResourceManagerException upon failure
   */
  public boolean hasAllPermissions(Permission... permissions) {
    return !(hasPermissions(permissions).contains(false));
  }
}
