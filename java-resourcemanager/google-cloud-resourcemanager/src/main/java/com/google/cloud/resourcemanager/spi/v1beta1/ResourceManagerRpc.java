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

package com.google.cloud.resourcemanager.spi.v1beta1;

import com.google.api.services.cloudresourcemanager.model.Constraint;
import com.google.api.services.cloudresourcemanager.model.OrgPolicy;
import com.google.api.services.cloudresourcemanager.model.Policy;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.cloud.ServiceRpc;
import com.google.cloud.Tuple;
import com.google.cloud.resourcemanager.ResourceManagerException;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/** @deprecated v3 GAPIC client of ResourceManager is now available */
@Deprecated
public interface ResourceManagerRpc extends ServiceRpc {

  enum Option {
    FILTER("filter"),
    FIELDS("fields"),
    PAGE_SIZE("pageSize"),
    PAGE_TOKEN("pageToken");

    private final String value;

    Option(String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }

    @SuppressWarnings("unchecked")
    <T> T get(Map<Option, ?> options) {
      return (T) options.get(this);
    }

    String getString(Map<Option, ?> options) {
      return get(options);
    }

    Integer getInt(Map<Option, ?> options) {
      return get(options);
    }
  }

  class ListResult<T> {

    private final Iterable<T> results;
    private final String pageToken;

    ListResult(String pageToken, Iterable<T> results) {
      this.results = ImmutableList.copyOf(results);
      this.pageToken = pageToken;
    }

    public static <T> ListResult<T> of(String pageToken, Iterable<T> list) {
      return new ListResult<>(pageToken, list);
    }

    public Iterable<T> results() {
      return results;
    }

    public String pageToken() {
      return pageToken;
    }
  }
  /**
   * Creates a new project.
   *
   * @throws ResourceManagerException upon failure
   */
  Project create(Project project);

  /**
   * Marks the project identified by the specified project ID for deletion.
   *
   * @throws ResourceManagerException upon failure
   */
  void delete(String projectId);

  /**
   * Retrieves the project identified by the specified project ID. Returns {@code null} if the
   * project is not found or if the user doesn't have read permissions for the project.
   *
   * @throws ResourceManagerException upon failure
   */
  Project get(String projectId, Map<Option, ?> options);

  /**
   * Lists the projects visible to the current user.
   *
   * @throws ResourceManagerException upon failure
   */
  Tuple<String, Iterable<Project>> list(Map<Option, ?> options);

  /**
   * Restores the project identified by the specified project ID. Undelete will only succeed if the
   * project has a lifecycle state of {@code DELETE_REQUESTED} state. The caller must have modify
   * permissions for this project.
   *
   * @throws ResourceManagerException upon failure
   */
  void undelete(String projectId);

  /**
   * Replaces the attributes of the project. The caller must have modify permissions for this
   * project.
   *
   * @throws ResourceManagerException upon failure
   */
  Project replace(Project project);

  /**
   * Returns the IAM policy associated with a project.
   *
   * @throws ResourceManagerException upon failure
   */
  Policy getPolicy(String projectId);

  /**
   * Replaces the IAM policy associated with the given project.
   *
   * @throws ResourceManagerException upon failure
   */
  Policy replacePolicy(String projectId, Policy newPolicy);

  /**
   * Tests whether the caller has the given permissions. Returns a list of booleans corresponding to
   * whether or not the user has the permission in the same position of input list.
   *
   * @throws ResourceManagerException upon failure
   */
  List<Boolean> testPermissions(String projectId, List<String> permissions);

  /**
   * Tests whether the caller has the given permissions on the specified Organization. Returns the
   * permissions and their results.
   *
   * @throws ResourceManagerException upon failure
   */
  Map<String, Boolean> testOrgPermissions(String resource, List<String> permissions)
      throws IOException;

  // TODO(ajaykannan): implement "Organization" functionality when available (issue #319)

  /** Clears the Policy from a resource. */
  void clearOrgPolicy(String resource, OrgPolicy orgPolicy) throws IOException;

  /**
   * Gets the effective Policy on a resource.
   *
   * <p>This is the result of merging Policies in the resource hierarchy. The returned Policy does
   * not have an etag set because it is a computed Policy across multiple resources. Subtrees of
   * Resource Manager resource hierarchy with 'under:' prefix will not be expanded.
   *
   * @throws ResourceManagerException upon failure
   */
  OrgPolicy getEffectiveOrgPolicy(String resource, String constraint) throws IOException;

  /**
   * Gets the Policy on a resource.
   *
   * <p>If no Policy is set on the resource, a Policy is returned with default values including
   * POLICY_TYPE_NOT_SET for the policy_type oneof. The etag value can be used with
   * projects.setOrgPolicy() to create or update a Policy during read-modify-write.
   *
   * @throws ResourceManagerException upon failure
   */
  OrgPolicy getOrgPolicy(String resource, String constraint) throws IOException;

  /**
   * Lists all the Constraints that can be applied on the specified resource.
   *
   * @throws ResourceManagerException upon failure
   */
  ListResult<Constraint> listAvailableOrgPolicyConstraints(String resource, Map<Option, ?> options)
      throws IOException;

  /**
   * Lists all the Policies set for a particular resource.
   *
   * @throws ResourceManagerException upon failure
   */
  ListResult<OrgPolicy> listOrgPolicies(String resource, Map<Option, ?> options) throws IOException;

  /**
   * Updates the specified Policy on the resource. Creates a new Policy for that Constraint on the
   * resource if one does not exist.
   *
   * <p>Not supplying an etag on the request Policy results in an unconditional write of the Policy.
   *
   * @throws ResourceManagerException upon failure
   */
  OrgPolicy replaceOrgPolicy(String resource, OrgPolicy orgPolicy) throws IOException;
}
