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

import com.google.gcloud.Page;
import com.google.gcloud.Service;
import com.google.gcloud.spi.ResourceManagerRpc.ListOptions;
import com.google.gcloud.spi.ResourceManagerRpc.Permission;

import java.util.List;

/**
 * An interface for Google Cloud Resource Manager.
 *
 * @see <a href="https://cloud.google.com/resource-manager/">Google Cloud Resource Manager</a>
 */
public interface ResourceManager extends Service<ResourceManagerOptions> {

  public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";

  /**
   * Create a new project.
   *
   * @return ProjectInfo object representing the new project's metadata. The returned object will
   *     include additional read-only information, namely project number, lifecycle state, and
   *     creation time.
   * @throws ResourceManagerException upon failure
   */
  ProjectInfo create(ProjectInfo project);

  /**
   * Sends a request to delete a project. For an unspecified amount of time, this action can be
   * undone using {@link #undelete}.
   *
   * @throws ResourceManagerException upon failure
   */
  void delete(String projectId);

  /**
   * Return the requested project or {@code null} if not found.
   *
   * @throws ResourceManagerException upon failure
   */
  ProjectInfo get(String projectId);

  /**
   * List the projects viewable by the current user. Use {@link ListOptions} to filter this list,
   * set page size, and set page tokens. Note that pagination is currently not implemented by the
   * Cloud Resource Manager API.
   *
   * @return {@code Page<ProjectInfo>}, a paginated list of projects.
   * @throws ResourceManagerException upon failure
   */
  Page<ProjectInfo> list(ListOptions listOptions);

  /**
   * Replace project metadata.
   *
   * @return the ProjectInfo representing the new project metadata
   * @throws ResourceManagerException upon failure
   */
  ProjectInfo replace(ProjectInfo newProject);

  /**
   * Undo a delete request. This will only succeed if the server processes the undelete request
   * while the project's state is {@code DELETE_REQUESTED}.
   *
   * @throws ResourceManagerException
   */
  void undelete(String projectId);

  /**
   * Get the IAM policy for the project specified.
   *
   * @return IAM Policy
   * @throws ResourceManagerException upon failure
   */
  Policy getIamPolicy(String projectId);

  /**
   * Replace the IAM Policy for a project with the policy given.
   *
   * @return the new IAM Policy
   * @throws ResourceManagerException upon failure
   */
  Policy replaceIamPolicy(String projectId, Policy policy);

  /**
   * Test whether the caller of this function has the permissions provided as arguments.
   *
   * @return List of booleans representing whether the caller has the corresponding permission in
   *     the given permissions array.
   * @throws ResourceManagerException upon failure
   */
  List<Boolean> hasPermissions(String projectId, Permission... permissions);
}
