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

import java.util.ArrayList;
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

  public Project(ResourceManager resourceManager, ProjectInfo projectInfo, Policy policy) {
    this.resourceManager = checkNotNull(resourceManager);
    this.info = checkNotNull(projectInfo);
    this.policy = checkNotNull(policy);
  }

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

  public Project reload() {
    return new Project(
        resourceManager, resourceManager.get(info.id()), resourceManager.getIamPolicy(info.id()));
  }

  public void delete() {
    resourceManager.delete(info.id());
  }

  public void undelete() {
    resourceManager.undelete(info.id());
  }

  public Project replace(ProjectInfo projectInfo) {
    return new Project(resourceManager, resourceManager.replace(checkNotNull(projectInfo)), policy);
  }

  public Project replaceIamPolicy(Policy policy) {
    return new Project(
        resourceManager, info, resourceManager.replaceIamPolicy(info.id(), checkNotNull(policy)));
  }

  public List<Boolean> hasPermissions(Permission first, Permission... others) {
    List<Permission> permissions = new ArrayList<>();
    permissions.add(first);
    for (Permission other : others) {
      permissions.add(other);
    }
    return resourceManager.hasPermissions(info.id(), permissions);
  }

  public boolean hasAllPermissions(Permission first, Permission... others) {
    return !(hasPermissions(first, others).contains(false));
  }
}
