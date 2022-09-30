/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.resourcemanager.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.ServiceOptions;
import com.google.cloud.resourcemanager.Project;
import com.google.cloud.resourcemanager.ProjectInfo;
import com.google.cloud.resourcemanager.ResourceManager;
import com.google.cloud.resourcemanager.ResourceManagerOptions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class ITSystemTest {

  private static final String PROJECT = ServiceOptions.getDefaultProjectId();
  private static final ResourceManager RESOURCE_MANAGER =
      ResourceManagerOptions.getDefaultInstance().getService();

  @Test
  public void getProjectTest() {
    Project project = RESOURCE_MANAGER.get(PROJECT);
    assertNotNull(project);
    assertNotNull(project.getName());
    assertEquals(PROJECT, project.getProjectId());
    assertEquals(ProjectInfo.State.ACTIVE, project.getState());
  }

  @Test
  public void getPolicyTest() {
    Policy policy = RESOURCE_MANAGER.getPolicy(PROJECT);
    assertNotNull(policy);
    assertNotNull(policy.getEtag());
    assertEquals(1, policy.getVersion());

    /* policy bindings */
    Map<Role, Set<Identity>> policyBindings = policy.getBindings();
    assertTrue(policyBindings.size() > 0);
  }

  @Test
  public void resourceManagerTest() {
    ResourceManager resourceManager = RESOURCE_MANAGER.get(PROJECT).getResourceManager();
    Project project = resourceManager.get(PROJECT);
    assertNotNull(project);
    assertNotNull(project.getName());
    assertEquals(PROJECT, project.getProjectId());
    assertEquals(ProjectInfo.State.ACTIVE, project.getState());

    Policy policy = resourceManager.getPolicy(PROJECT);
    assertNotNull(policy);
    assertNotNull(policy.getEtag());
    assertEquals(1, policy.getVersion());

    /* policy bindings */
    Map<Role, Set<Identity>> policyBindings = policy.getBindings();
    assertTrue(policyBindings.size() > 0);
  }

  @Test
  public void testPermissionsTest() {
    String getPermission = "resourcemanager.projects.get";
    String deletePermission = "resourcemanager.projects.delete";
    List<Boolean> booleanList =
        RESOURCE_MANAGER.testPermissions(
            PROJECT, ImmutableList.of(getPermission, deletePermission));
    assertTrue(booleanList.size() > 0);
    assertTrue(booleanList.contains(true));
  }
}
