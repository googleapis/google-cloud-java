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

import com.google.api.services.cloudresourcemanager.model.Policy;
import com.google.api.services.cloudresourcemanager.model.Project;
import com.google.gcloud.resourcemanager.ResourceManagerException;

import java.util.List;

public interface ResourceManagerRpc {

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

  Project create(Project project) throws ResourceManagerException;

  void delete(String projectId) throws ResourceManagerException;

  Project get(String projectId) throws ResourceManagerException;

  Tuple<String, Iterable<Project>> list() throws ResourceManagerException;

  Tuple<String, Iterable<Project>> list(String filter) throws ResourceManagerException;

  void undelete(String projectId) throws ResourceManagerException;

  Project update(String projectId, Project project) throws ResourceManagerException;

  Policy getIamPolicy(String projectId) throws ResourceManagerException;

  void setIamPolicy(String projectId, Policy policy) throws ResourceManagerException;

  List<String> testIamPermissions(String projectId, List<String> permissions)
      throws ResourceManagerException;
}
