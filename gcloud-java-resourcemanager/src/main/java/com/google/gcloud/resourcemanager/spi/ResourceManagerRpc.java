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

package com.google.gcloud.resourcemanager.spi;

import com.google.api.services.cloudresourcemanager.model.Policy;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.gcloud.resourcemanager.ResourceManagerException;

import java.util.List;
import java.util.Map;

public interface ResourceManagerRpc {

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

  class Tuple<X, Y> {
    private final X x;
    private final Y y;

    private Tuple(X x, Y y) {
      this.x = x;
      this.y = y;
    }

    public static <X, Y> Tuple<X, Y> of(X x, Y y) {
      return new Tuple<>(x, y);
    }

    public X x() {
      return x;
    }

    public Y y() {
      return y;
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

  // TODO(ajaykannan): implement "Organization" functionality when available (issue #319)
}
