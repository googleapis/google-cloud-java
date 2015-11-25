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
import com.google.gcloud.spi.ResourceManagerRpc;

/**
 * An interface for Google Cloud Resource Manager.
 *
 * @see <a href="https://cloud.google.com/resource-manager/">Google Cloud Resource Manager</a>
 */
public interface ResourceManager extends Service<ResourceManagerOptions> {

  public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";

  /**
   * Class for specifying project list options.
   */
  public class ProjectListOption extends Option {

    private static final long serialVersionUID = 7888768979702012328L;

    private ProjectListOption(ResourceManagerRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a page token.
     *
     * The page token (returned from a previous call to list) indicates from where listing should
     * continue. Pagination is not yet supported; the server ignores this field. Optional.
     */
    public static ProjectListOption pageToken(String pageToken) {
      // return new ProjectListOption(ResourceManagerRpc.Option.PAGE_TOKEN, pageToken);
      throw new UnsupportedOperationException("paging for project lists is not implemented yet.");
    }

    /**
     * Returns an option to specify a filter.
     *
     * Filter rules are case insensitive. The fields eligible for filtering are:
     * <ul>
     * <li>name
     * <li>id
     * <li>labels.key, where key is the name of a label
     * </ul>
     *
     * Some examples of using labels as filters:
     * <ul>
     * <li> name:*  The project has a name.
     * <li> name:Howl   The project's name is Howl or howl.
     * <li> name:HOWL   Equivalent to above.
     * <li> NAME:howl   Equivalent to above.
     * <li> labels.color:*  The project has the label color.
     * <li> labels.color:red    The project's label color has the value red.
     * <li> labels.color:red label.size:big  The project's label color has the value red and its
     *     label size has the value big.
     * </ul>
     *
     * Optional.
     */
    public static ProjectListOption filter(String filter) {
      return new ProjectListOption(ResourceManagerRpc.Option.FILTER, filter);
    }

    /**
     * The maximum number of projects to return in the response.
     *
     * The server can return fewer projects than requested. If unspecified, server picks an
     * appropriate default. Note: pagination is not yet supported; the server ignores this field.
     * Optional.
     */
    public static ProjectListOption pageSize(int pageSize) {
      // return new ProjectListOption(ResourceManagerRpc.Option.PAGE_SIZE, pageSize);
      throw new UnsupportedOperationException("paging for project lists is not implemented yet.");
    }
  }

  /**
   * Create a new project.
   *
   * Initially, the project resource is owned by its creator exclusively. The creator can later
   * grant permission to others to read or update the project. Several APIs are activated
   * automatically for the project, including Google Cloud Storage.
   *
   * @see
   *     <a href="https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/create">
   *     Cloud Resource Manager create</a>
   *
   * @return ProjectInfo object representing the new project's metadata. The returned object will
   *     include the following read-only fields supplied by the server: project number, lifecycle
   *     state, and creation time.
   * @throws ResourceManagerException upon failure
   */
  ProjectInfo create(ProjectInfo project);

  /**
   * Marks the project identified by the specified project ID for deletion.
   *
   * This method will only affect the project if the following criteria are met:
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
   * @see
   *     <a href="https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/delete">
   *     Cloud Resource Manager delete</a>
   * @throws ResourceManagerException upon failure
   */
  void delete(String projectId);

  /**
   * Retrieves the project identified by the specified project ID.
   *
   * The caller must have read permissions for this project.
   *
   * @see <a href="https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/get">
   *     Cloud Resource Manager get</a>
   * @throws ResourceManagerException upon failure
   */
  ProjectInfo get(String projectId);

  /**
   * Lists the projects visible to the current user.
   *
   * This method returns projects in an unspecified order. New projects do not necessarily appear at
   * the end of the list. Use {@link ProjectListOption} to filter this list, set page size, and set
   * page tokens. Note that pagination is currently not implemented by the Cloud Resource Manager
   * API.
   *
   * @see <a href="https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/list">
   *     Cloud Resource Manager list</a>
   * @return {@code Page<ProjectInfo>}, a page of projects.
   * @throws ResourceManagerException upon failure
   */
  Page<ProjectInfo> list(ProjectListOption... options);

  /**
   * Replaces the attributes of the project.
   *
   * The caller must have modify permissions for this project.
   *
   * @see
   *     <a href="https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/update">
   *     Cloud Resource Manager update</a>
   * @return the ProjectInfo representing the new project metadata
   * @throws ResourceManagerException upon failure
   */
  ProjectInfo replace(ProjectInfo newProject);

  /**
   * Restores the project identified by the specified project ID.
   *
   * You can only use this method for a project that has a lifecycle state of
   * {@link ProjectInfo.State#DELETE_REQUESTED}. After deletion starts, as indicated by a lifecycle
   * state of {@link ProjectInfo.State#DELETE_IN_PROGRESS}, the project cannot be restored. The
   * caller must have modify permissions for this project.
   *
   * @see <a href=
   *     "https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/undelete">
   *     Cloud Resource Manager undelete</a>
   * @throws ResourceManagerException
   */
  void undelete(String projectId);
}
