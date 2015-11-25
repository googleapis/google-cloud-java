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

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import com.google.gcloud.Page;
import com.google.gcloud.Service;
import com.google.gcloud.spi.ResourceManagerRpc;

import java.util.HashSet;

/**
 * An interface for Google Cloud Resource Manager.
 *
 * @see <a href="https://cloud.google.com/resource-manager/">Google Cloud Resource Manager</a>
 */
public interface ResourceManager extends Service<ResourceManagerOptions> {

  public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";

  /**
   * The fields of a project.
   *
   * These values can be used to specify the fields to include of in a partial response when calling
   * {@link ResourceManager#get} or {@link ResourceManager#list}. Project ID is always returned,
   * even if not specified.
   */
  enum ProjectField {
    ID("projectId"),
    NAME("name"),
    LABELS("labels"),
    NUMBER("projectNumber"),
    STATE("lifecycleState"),
    CREATE_TIME("createTime");

    private final String selector;

    ProjectField(String selector) {
      this.selector = selector;
    }

    public String selector() {
      return selector;
    }

    static String selector(ProjectField... fields) {
      HashSet<String> fieldStrings = Sets.newHashSetWithExpectedSize(fields.length + 1);
      fieldStrings.add(ID.selector());
      for (ProjectField field : fields) {
        fieldStrings.add(field.selector());
      }
      return Joiner.on(',').join(fieldStrings);
    }
  }

  public class ProjectGetOption extends Option {

    private static final long serialVersionUID = 270185129961146874L;

    private ProjectGetOption(ResourceManagerRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the project's fields to be returned by the RPC call.
     *
     * If this option is not provided all project fields are returned.
     * {@code ProjectListOption.fields} can be used to specify only the fields of interest. Project
     * ID is always returned, even if not specified. {@link ProjectField} provides a list of fields
     * that can be used.
     */
    public static ProjectGetOption fields(ProjectField... fields) {
      return new ProjectGetOption(ResourceManagerRpc.Option.FIELDS, ProjectField.selector(fields));
    }
  }

  /**
   * Class for specifying project list options.
   */
  public class ProjectListOption extends Option {

    private static final long serialVersionUID = 7888768979702012328L;

    private ProjectListOption(ResourceManagerRpc.Option option, Object value) {
      super(option, value);
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
     * Returns an option to specify the project's fields to be returned by the RPC call.
     *
     * If this option is not provided all project fields are returned.
     * {@code ProjectListOption.fields} can be used to specify only the fields of interest. Project
     * ID is always returned, even if not specified. {@link ProjectField} provides a list of fields
     * that can be used.
     */
    public static ProjectListOption fields(ProjectField... fields) {
      StringBuilder builder = new StringBuilder();
      builder.append("projects(").append(ProjectField.selector(fields)).append(")");
      return new ProjectListOption(ResourceManagerRpc.Option.FIELDS, builder.toString());
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
  ProjectInfo get(String projectId, ProjectGetOption... options);

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
