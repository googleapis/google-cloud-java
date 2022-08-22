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

import com.google.api.gax.paging.Page;
import com.google.cloud.FieldSelector;
import com.google.cloud.FieldSelector.Helper;
import com.google.cloud.Policy;
import com.google.cloud.Service;
import com.google.cloud.resourcemanager.spi.v1beta1.ResourceManagerRpc;
import com.google.cloud.resourcemanager.v3.GetProjectRequest;
import com.google.cloud.resourcemanager.v3.ListProjectsRequest;
import com.google.cloud.resourcemanager.v3.ProjectName;
import com.google.cloud.resourcemanager.v3.ProjectsSettings;
import com.google.cloud.resourcemanager.v3.UndeleteProjectRequest;
import com.google.cloud.resourcemanager.v3.UpdateProjectRequest;
import com.google.common.collect.ImmutableList;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import java.util.List;
import java.util.Map;

/**
 * An interface for Google Cloud Resource Manager.
 *
 * @see <a href="https://cloud.google.com/resource-manager/">Google Cloud Resource Manager</a>
 * @deprecated v3 GAPIC client of ResourceManager is now available
 */
@Deprecated
public interface ResourceManager extends Service<ResourceManagerOptions> {

  String DEFAULT_CONTENT_TYPE = "application/octet-stream";

  /**
   * The fields of a project.
   *
   * <p>These values can be used to specify the fields to include in a partial response when calling
   * {@link ResourceManager#get} or {@link ResourceManager#list}. Project ID is always returned,
   * even if not specified.
   */
  enum ProjectField implements FieldSelector {
    PROJECT_ID("projectId"),
    NAME("name"),
    LABELS("labels"),
    PROJECT_NUMBER("projectNumber"),
    STATE("lifecycleState"),
    CREATE_TIME("createTime");

    static final List<? extends FieldSelector> REQUIRED_FIELDS = ImmutableList.of(PROJECT_ID);

    private final String selector;

    ProjectField(String selector) {
      this.selector = selector;
    }

    @Override
    public String getSelector() {
      return selector;
    }
  }

  /** Class for specifying project get options. */
  class ProjectGetOption extends Option {

    private static final long serialVersionUID = 270185129961146874L;

    private ProjectGetOption(ResourceManagerRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the project's fields to be returned by the RPC call.
     *
     * <p>If this option is not provided all project fields are returned. {@code
     * ProjectGetOption.fields} can be used to specify only the fields of interest. Project ID is
     * always returned, even if not specified. {@link ProjectField} provides a list of fields that
     * can be used.
     */
    public static ProjectGetOption fields(ProjectField... fields) {
      return new ProjectGetOption(
          ResourceManagerRpc.Option.FIELDS, Helper.selector(ProjectField.REQUIRED_FIELDS, fields));
    }
  }

  /** Class for specifying project list options. */
  class ProjectListOption extends Option {

    private static final long serialVersionUID = 7888768979702012328L;

    private ProjectListOption(ResourceManagerRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a filter.
     *
     * <p>Filter rules are case insensitive. The fields eligible for filtering are:
     *
     * <ul>
     *   <li>name
     *   <li>project ID
     *   <li>labels.key, where key is the name of a label
     * </ul>
     *
     * <p>You can specify multiple filters by adding a space between each filter. Multiple filters
     * are composed using "and".
     *
     * <p>Some examples of filters:
     *
     * <ul>
     *   <li>name:* The project has a name.
     *   <li>name:Howl The project's name is Howl or howl.
     *   <li>name:HOWL Equivalent to above.
     *   <li>NAME:howl Equivalent to above.
     *   <li>labels.color:* The project has the label color.
     *   <li>labels.color:red The project's label color has the value red.
     *   <li>labels.color:red label.size:big The project's label color has the value red and its
     *       label size has the value big.
     * </ul>
     */
    public static ProjectListOption filter(String filter) {
      return new ProjectListOption(ResourceManagerRpc.Option.FILTER, filter);
    }

    /**
     * Returns an option to specify a page token.
     *
     * <p>The page token (returned from a previous call to list) indicates from where listing should
     * continue.
     */
    public static ProjectListOption pageToken(String pageToken) {
      return new ProjectListOption(ResourceManagerRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * The maximum number of projects to return per RPC.
     *
     * <p>The server can return fewer projects than requested. When there are more results than the
     * page size, the server will return a page token that can be used to fetch other results.
     */
    public static ProjectListOption pageSize(int pageSize) {
      return new ProjectListOption(ResourceManagerRpc.Option.PAGE_SIZE, pageSize);
    }

    /**
     * Returns an option to specify the project's fields to be returned by the RPC call.
     *
     * <p>If this option is not provided all project fields are returned. {@code
     * ProjectListOption.fields} can be used to specify only the fields of interest. Project ID is
     * always returned, even if not specified. {@link ProjectField} provides a list of fields that
     * can be used.
     */
    public static ProjectListOption fields(ProjectField... fields) {
      return new ProjectListOption(
          ResourceManagerRpc.Option.FIELDS,
          Helper.listSelector("projects", ProjectField.REQUIRED_FIELDS, fields));
    }
  }

  /**
   * Creates a new project.
   *
   * <p>Initially, the project resource is owned by its creator exclusively. The creator can later
   * grant permission to others to read or update the project. Several APIs are activated
   * automatically for the project, including Google Cloud Storage.
   *
   * @return Project object representing the new project's metadata. The returned object will
   *     include the following read-only fields supplied by the server: project number, lifecycle
   *     state, and creation time.
   * @throws ResourceManagerException upon failure
   * @see <a href=
   *     "https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/create">Cloud
   *     Resource Manager create</a>
   * @deprecated Please use {@link
   *     com.google.cloud.resourcemanager.v3.ProjectsClient#create(ProjectsSettings)} instead
   */
  @Deprecated
  Project create(ProjectInfo project);

  /**
   * Marks the project identified by the specified project ID for deletion.
   *
   * <p>This method will only affect the project if the following criteria are met:
   *
   * <ul>
   *   <li>The project does not have a billing account associated with it.
   *   <li>The project has a lifecycle state of {@link ProjectInfo.State#ACTIVE}.
   * </ul>
   *
   * This method changes the project's lifecycle state from {@link ProjectInfo.State#ACTIVE} to
   * {@link ProjectInfo.State#DELETE_REQUESTED}. The deletion starts at an unspecified time, at
   * which point the lifecycle state changes to {@link ProjectInfo.State#DELETE_IN_PROGRESS}. Until
   * the deletion completes, you can check the lifecycle state checked by retrieving the project
   * with {@link ResourceManager#get}, and the project remains visible to {@link
   * ResourceManager#list}. However, you cannot update the project. After the deletion completes,
   * the project is not retrievable by the {@link ResourceManager#get} and {@link
   * ResourceManager#list} methods. The caller must have modify permissions for this project.
   *
   * @throws ResourceManagerException upon failure
   * @see <a href=
   *     "https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/delete">Cloud
   *     Resource Manager delete</a>
   * @deprecated Please use {@link
   *     com.google.cloud.resourcemanager.v3.ProjectsClient#deleteProjectAsync(ProjectName)} instead
   */
  @Deprecated
  void delete(String projectId);

  /**
   * Retrieves the project identified by the specified project ID.
   *
   * <p>Returns {@code null} if the project is not found or if the user doesn't have read
   * permissions for the project.
   *
   * @throws ResourceManagerException upon failure
   * @see <a href="https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/get">
   *     Cloud Resource Manager get</a>
   * @deprecated Please use {@link
   *     com.google.cloud.resourcemanager.v3.ProjectsClient#getProject(GetProjectRequest)} instead
   */
  @Deprecated
  Project get(String projectId, ProjectGetOption... options);

  /**
   * Lists the projects visible to the current user.
   *
   * <p>This method returns projects in an unspecified order. New projects do not necessarily appear
   * at the end of the list. Use {@link ProjectListOption} to filter this list, set page size, and
   * set page tokens.
   *
   * @return {@code Page<Project>}, a page of projects
   * @throws ResourceManagerException upon failure
   * @see <a href=
   *     "https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/list">Cloud
   *     Resource Manager list</a>
   * @deprecated Please use {@link
   *     com.google.cloud.resourcemanager.v3.ProjectsClient#listProjects(ListProjectsRequest)}
   *     instead
   */
  @Deprecated
  Page<Project> list(ProjectListOption... options);

  /**
   * Replaces the attributes of the project.
   *
   * <p>The caller must have modify permissions for this project.
   *
   * @return the Project representing the new project metadata
   * @throws ResourceManagerException upon failure
   * @see <a href=
   *     "https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/update">Cloud
   *     Resource Manager update</a>
   * @deprecated Please use {@link
   *     com.google.cloud.resourcemanager.v3.ProjectsClient#updateProjectAsync(UpdateProjectRequest)}
   *     instead
   */
  @Deprecated
  Project replace(ProjectInfo newProject);

  /**
   * Restores the project identified by the specified project ID.
   *
   * <p>You can only use this method for a project that has a lifecycle state of {@link
   * ProjectInfo.State#DELETE_REQUESTED}. After deletion starts, as indicated by a lifecycle state
   * of {@link ProjectInfo.State#DELETE_IN_PROGRESS}, the project cannot be restored. The caller
   * must have modify permissions for this project.
   *
   * @throws ResourceManagerException upon failure
   * @see <a href=
   *     "https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/undelete">Cloud
   *     Resource Manager undelete</a>
   * @deprecated Please use {@link
   *     com.google.cloud.resourcemanager.v3.ProjectsClient#undeleteProjectAsync(UndeleteProjectRequest)}
   *     instead
   */
  @Deprecated
  void undelete(String projectId);

  /**
   * Returns the IAM access control policy for the specified project. Returns {@code null} if the
   * resource does not exist or if you do not have adequate permission to view the project or get
   * the policy.
   *
   * @throws ResourceManagerException upon failure
   * @see <a href=
   *     "https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/getIamPolicy">
   *     Resource Manager getIamPolicy</a>
   * @deprecated Please use {@link
   *     com.google.cloud.resourcemanager.v3.ProjectsClient#getIamPolicy(GetIamPolicyRequest)}
   *     instead
   */
  @Deprecated
  Policy getPolicy(String projectId);

  /**
   * Sets the IAM access control policy for the specified project. Replaces any existing policy. The
   * following constraints apply:
   *
   * <ul>
   *   <li>Projects currently support only <i>user:{emailid}</i> and <i>serviceAccount:{emailid}</i>
   *       members in a binding of a policy.
   *   <li>To be added as an owner, a user must be invited via Cloud Platform console and must
   *       accept the invitation.
   *   <li>Members cannot be added to more than one role in the same policy.
   *   <li>There must be at least one owner who has accepted the Terms of Service (ToS) agreement in
   *       the policy. An attempt to set a policy that removes the last ToS-accepted owner from the
   *       policy will fail.
   *   <li>Calling this method requires enabling the App Engine Admin API.
   * </ul>
   *
   * Note: Removing service accounts from policies or changing their roles can render services
   * completely inoperable. It is important to understand how the service account is being used
   * before removing or updating its roles.
   *
   * <p>It is recommended that you use the read-modify-write pattern. This pattern entails reading
   * the project's current policy, updating it locally, and then sending the modified policy for
   * writing. Cloud IAM solves the problem of conflicting processes simultaneously attempting to
   * modify a policy by using the {@link Policy#getEtag etag} property. This property is used to
   * verify whether the policy has changed since the last request. When you make a request to Cloud
   * IAM with an etag value, Cloud IAM compares the etag value in the request with the existing etag
   * value associated with the policy. It writes the policy only if the etag values match. If the
   * etags don't match, a {@code ResourceManagerException} is thrown, denoting that the server
   * aborted update. If an etag is not provided, the policy is overwritten blindly.
   *
   * <p>An example of using the read-write-modify pattern is as follows:
   *
   * <pre>{@code
   * Policy currentPolicy = resourceManager.getPolicy("my-project-id");
   * Policy modifiedPolicy = current.toBuilder()
   *     .removeIdentity(Role.viewer(), Identity.user("user@gmail.com"))
   *     .build();
   * Policy newPolicy = resourceManager.replacePolicy("my-project-id", modified);
   * }</pre>
   *
   * @throws ResourceManagerException upon failure
   * @see <a href=
   *     "https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/setIamPolicy">
   *     Resource Manager setIamPolicy</a>
   * @deprecated
   */
  @Deprecated
  Policy replacePolicy(String projectId, Policy newPolicy);

  /**
   * Returns the permissions that a caller has on the specified project. You typically don't call
   * this method if you're using Google Cloud Platform directly to manage permissions. This method
   * is intended for integration with your proprietary software, such as a customized graphical user
   * interface. For example, the Cloud Platform Console tests IAM permissions internally to
   * determine which UI should be available to the logged-in user. Each service that supports IAM
   * lists the possible permissions; see the <i>Supported Cloud Platform services</i> page below for
   * links to these lists.
   *
   * @return A list of booleans representing whether the caller has the permissions specified (in
   *     the order of the given permissions)
   * @throws ResourceManagerException upon failure
   * @see <a href=
   *     "https://cloud.google.com/resource-manager/reference/rest/v1beta1/projects/testIamPermissions">
   *     Resource Manager testIamPermissions</a>
   * @see <a href= "https://cloud.google.com/iam/#supported_cloud_platform_services">Supported Cloud
   *     Platform Services</a>
   * @deprecated {@link
   *     com.google.cloud.resourcemanager.v3.ProjectsClient#testIamPermissions(TestIamPermissionsRequest)}
   */
  @Deprecated
  List<Boolean> testPermissions(String projectId, List<String> permissions);

  /** Class for specifying project list options. */
  class ListOption extends Option {

    private ListOption(ResourceManagerRpc.Option option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify a page token.
     *
     * <p>The page token (returned from a previous call to list) indicates from where listing should
     * continue.
     */
    public static ListOption pageToken(String pageToken) {
      return new ListOption(ResourceManagerRpc.Option.PAGE_TOKEN, pageToken);
    }

    /**
     * The maximum number of records to return per RPC.
     *
     * <p>The server can return fewer records than requested. When there are more results than the
     * page size, the server will return a page token that can be used to fetch other results.
     */
    public static ListOption pageSize(int pageSize) {
      return new ListOption(ResourceManagerRpc.Option.PAGE_SIZE, pageSize);
    }
  }
  /**
   * Returns the permissions and their results representing whether the caller has the permissions
   * on the specified Organization.
   *
   * @param resource the organization's resource name, e.g. "organizations/123"
   * @param permissions the set of permissions to check for the resource. Permissions with wildcards
   *     (such as '*' or 'storage.*') are not allowed.
   * @return the permissions and their results representing whether the caller has the permissions
   *     on the specified Organization.
   * @throws ResourceManagerException upon failure
   * @see <a href=
   *     "https://cloud.google.com/resource-manager/reference/rest/v1/organizations/testIamPermissions">
   *     Resource Manager testIamPermissions</a>
   * @deprecated
   */
  @Deprecated
  Map<String, Boolean> testOrgPermissions(String resource, List<String> permissions);

  /**
   * Clears a Policy from a resource.
   *
   * @throws ResourceManagerException upon failure
   * @see <a href=
   *     "https://cloud.google.com/resource-manager/reference/rest/v1/folders/clearOrgPolicy">Resource
   *     Manager clearOrgPolicy</a>
   */
  void clearOrgPolicy(String resource, OrgPolicyInfo orgPolicy);

  /**
   * Gets the effective Policy on a resource.
   *
   * <p>This is the result of merging Policies in the resource hierarchy. The returned Policy will
   * not have an etag set because it is a computed Policy across multiple resources. Subtrees of
   * Resource Manager resource hierarchy with 'under:' prefix are not expanded.
   *
   * @throws ResourceManagerException upon failure
   * @see <a
   *     href="https://cloud.google.com/resource-manager/reference/rest/v1/folders/getEffectiveOrgPolicy">Resource
   *     Manager getEffectiveOrgPolicy</a>
   * @deprecated
   */
  @Deprecated
  OrgPolicyInfo getEffectiveOrgPolicy(String resource, String constraint);

  /**
   * Gets the Policy on a resource.
   *
   * <p>If no Policy is set on the resource, a Policy is returned with default values including
   * POLICY_TYPE_NOT_SET for the policy_type one of. The etag value can be used with
   * projects.setOrgPolicy() to create or update a Policy during read-modify-write.
   *
   * @throws ResourceManagerException upon failure
   * @see <a
   *     href="https://cloud.google.com/resource-manager/reference/rest/v1/folders/getOrgPolicy">Resource
   *     Manager getOrgPolicy</a>
   */
  OrgPolicyInfo getOrgPolicy(String resource, String constraint);

  /**
   * Lists the Constraints that could be applied on the specified resource.
   *
   * @throws ResourceManagerException upon failure
   * @see <a
   *     href="https://cloud.google.com/resource-manager/reference/rest/v1/folders/listAvailableOrgPolicyConstraints">Resource
   *     Manager listAvailableOrgPolicyConstraints</a>
   * @deprecated
   */
  @Deprecated
  Page<ConstraintInfo> listAvailableOrgPolicyConstraints(String resource, ListOption... options);

  /**
   * Lists the Policies set for a particular resource.
   *
   * @throws ResourceManagerException upon failure
   * @see <a
   *     href="https://cloud.google.com/resource-manager/reference/rest/v1/folders/listOrgPolicies">Resource
   *     Manager listOrgPolicies</a>
   * @deprecated
   */
  @Deprecated
  Page<OrgPolicyInfo> listOrgPolicies(String resource, ListOption... options);

  /**
   * Updates the specified Policy on the resource. Creates a new Policy for that Constraint on the
   * resource if one does not exist.
   *
   * <p>Not supplying an etag on the request Policy results in an unconditional write of the Policy.
   *
   * @throws ResourceManagerException upon failure
   * @see <a
   *     href="https://cloud.google.com/resource-manager/reference/rest/v1/folders/setOrgPolicy">Resource
   *     Manager setOrgPolicy</a>
   * @deprecated
   */
  @Deprecated
  OrgPolicyInfo replaceOrgPolicy(String resource, OrgPolicyInfo orgPolicy);
}
