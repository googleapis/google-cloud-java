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

package com.google.gcloud.spi;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.cloudresourcemanager.model.Policy;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.common.collect.ImmutableList;
import com.google.gcloud.resourcemanager.ResourceManagerException;

import java.util.Collections;
import java.util.List;

public interface ResourceManagerRpc {

  public enum Permission {
    CREATE,
    DELETE,
    GET,
    LIST,
    UPDATE,
    GET_IAM_POLICY,
    SET_IAM_POLICY
  }

  public enum DeleteResult {
    SUCCESS,
    ALREADY_DELETED
  }

  public enum UndeleteResult {
    SUCCESS,
    DELETE_IN_PROGRESS,
    GONE
  }

  public enum SetIamPolicyResult {
    SUCCESS,
    ETAG_NOT_MATCH
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

  public class ListOptions {
    private List<String> filters;
    private String pageToken;
    private int pageSize;

    private static final ListOptions DEFAULT_INSTANCE =
        new ListOptions(Collections.<String>emptyList(), null, -1);

    ListOptions(List<String> filters, String pageToken, int pageSize) {
      this.filters = checkNotNull(ImmutableList.copyOf(filters));
      this.pageToken = pageToken;
      this.pageSize = pageSize;
    }

    public static ListOptions getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    public static ListOptions createListOption(
        List<String> filters, String pageToken, int pageSize) {
      return new ListOptions(filters, pageToken, pageSize);
    }

    public String pageToken() {
      return pageToken;
    }

    public List<String> filters() {
      return filters;
    }

    public int pageSize() {
      return pageSize;
    }
  }

  Project create(Project project) throws ResourceManagerException;

  DeleteResult delete(String projectId) throws ResourceManagerException;

  Project get(String projectId) throws ResourceManagerException;

  Tuple<String, Iterable<Project>> list(ListOptions listOptions) throws ResourceManagerException;

  UndeleteResult undelete(String projectId) throws ResourceManagerException;

  Project update(Project project) throws ResourceManagerException;

  Policy getIamPolicy(String projectId) throws ResourceManagerException;

  SetIamPolicyResult setIamPolicy(String projectId, Policy policy) throws ResourceManagerException;

  List<Boolean> hasPermissions(String projectId, List<Permission> permissions)
      throws ResourceManagerException;

  // TODO(ajaykannan): implement "Organization" functionality when available
}
