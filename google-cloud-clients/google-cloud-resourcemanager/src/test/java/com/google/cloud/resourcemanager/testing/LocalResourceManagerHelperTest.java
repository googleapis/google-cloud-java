/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.resourcemanager.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.services.cloudresourcemanager.model.Binding;
import com.google.cloud.Tuple;
import com.google.cloud.resourcemanager.ResourceManagerException;
import com.google.cloud.resourcemanager.spi.v1beta1.HttpResourceManagerRpc;
import com.google.cloud.resourcemanager.spi.v1beta1.ResourceManagerRpc;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LocalResourceManagerHelperTest {

  private static final String DEFAULT_PARENT_ID = "12345";
  private static final String DEFAULT_PARENT_TYPE = "organization";
  private static final com.google.api.services.cloudresourcemanager.model.ResourceId PARENT =
      new com.google.api.services.cloudresourcemanager.model.ResourceId()
          .setId(DEFAULT_PARENT_ID)
          .setType(DEFAULT_PARENT_TYPE);
  private static final Map<ResourceManagerRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();
  private static final LocalResourceManagerHelper RESOURCE_MANAGER_HELPER =
      LocalResourceManagerHelper.create();
  private static final ResourceManagerRpc rpc =
      new HttpResourceManagerRpc(RESOURCE_MANAGER_HELPER.getOptions());
  private static final com.google.api.services.cloudresourcemanager.model.Project PARTIAL_PROJECT =
      new com.google.api.services.cloudresourcemanager.model.Project()
          .setProjectId("partial-project");
  private static final com.google.api.services.cloudresourcemanager.model.Project COMPLETE_PROJECT =
      new com.google.api.services.cloudresourcemanager.model.Project()
          .setProjectId("complete-project")
          .setName("full project")
          .setLabels(ImmutableMap.of("k1", "v1", "k2", "v2"));
  private static final com.google.api.services.cloudresourcemanager.model.Project
      PROJECT_WITH_PARENT =
          copyFrom(COMPLETE_PROJECT).setProjectId("project-with-parent-id").setParent(PARENT);
  private static final List<Binding> BINDINGS =
      ImmutableList.of(
          new Binding().setRole("roles/owner").setMembers(ImmutableList.of("user:me@gmail.com")),
          new Binding()
              .setRole("roles/viewer")
              .setMembers(ImmutableList.of("group:group@gmail.com")));
  private static final com.google.api.services.cloudresourcemanager.model.Policy POLICY =
      new com.google.api.services.cloudresourcemanager.model.Policy().setBindings(BINDINGS);

  @BeforeClass
  public static void beforeClass() {
    RESOURCE_MANAGER_HELPER.start();
  }

  private static com.google.api.services.cloudresourcemanager.model.Project copyFrom(
      com.google.api.services.cloudresourcemanager.model.Project from) {
    return new com.google.api.services.cloudresourcemanager.model.Project()
        .setProjectId(from.getProjectId())
        .setName(from.getName())
        .setLabels(from.getLabels() != null ? ImmutableMap.copyOf(from.getLabels()) : null)
        .setProjectNumber(from.getProjectNumber())
        .setCreateTime(from.getCreateTime())
        .setLifecycleState(from.getLifecycleState())
        .setParent(from.getParent() != null ? from.getParent().clone() : null);
  }

  private void clearProjects() {
    for (com.google.api.services.cloudresourcemanager.model.Project project :
        rpc.list(EMPTY_RPC_OPTIONS).y()) {
      RESOURCE_MANAGER_HELPER.removeProject(project.getProjectId());
    }
  }

  @Before
  public void setUp() {
    clearProjects();
  }

  @AfterClass
  public static void afterClass() {
    RESOURCE_MANAGER_HELPER.stop();
  }

  @Test
  public void testCreate() {
    com.google.api.services.cloudresourcemanager.model.Project returnedProject =
        rpc.create(PARTIAL_PROJECT);
    compareReadWriteFields(PARTIAL_PROJECT, returnedProject);
    assertEquals("ACTIVE", returnedProject.getLifecycleState());
    assertNull(returnedProject.getLabels());
    assertNull(returnedProject.getName());
    assertNull(returnedProject.getParent());
    assertNotNull(returnedProject.getProjectNumber());
    assertNotNull(returnedProject.getCreateTime());
    com.google.api.services.cloudresourcemanager.model.Policy policy =
        rpc.getPolicy(PARTIAL_PROJECT.getProjectId());
    assertEquals(Collections.emptyList(), policy.getBindings());
    assertNotNull(policy.getEtag());
    assertEquals(0, policy.getVersion().intValue());
    rpc.replacePolicy(PARTIAL_PROJECT.getProjectId(), POLICY);
    assertEquals(POLICY.getBindings(), rpc.getPolicy(PARTIAL_PROJECT.getProjectId()).getBindings());
    try {
      rpc.create(PARTIAL_PROJECT);
      fail("Should fail, project already exists.");
    } catch (ResourceManagerException e) {
      assertEquals(409, e.getCode());
      assertTrue(
          e.getMessage().startsWith("A project with the same project ID")
              && e.getMessage().endsWith("already exists."));
      assertEquals(
          POLICY.getBindings(), rpc.getPolicy(PARTIAL_PROJECT.getProjectId()).getBindings());
    }
    returnedProject = rpc.create(PROJECT_WITH_PARENT);
    compareReadWriteFields(PROJECT_WITH_PARENT, returnedProject);
    assertEquals("ACTIVE", returnedProject.getLifecycleState());
    assertNotNull(returnedProject.getProjectNumber());
    assertNotNull(returnedProject.getCreateTime());
  }

  @Test
  public void testIsInvalidProjectId() {
    com.google.api.services.cloudresourcemanager.model.Project project =
        new com.google.api.services.cloudresourcemanager.model.Project();
    String invalidIDMessageSubstring = "invalid ID";
    expectInvalidArgumentException(project, "Project ID cannot be empty.");
    project.setProjectId("abcde");
    expectInvalidArgumentException(project, invalidIDMessageSubstring);
    project.setProjectId("this-project-id-is-more-than-thirty-characters-long");
    expectInvalidArgumentException(project, invalidIDMessageSubstring);
    project.setProjectId("project-id-with-invalid-character-?");
    expectInvalidArgumentException(project, invalidIDMessageSubstring);
    project.setProjectId("-invalid-start-character");
    expectInvalidArgumentException(project, invalidIDMessageSubstring);
    project.setProjectId("invalid-ending-character-");
    expectInvalidArgumentException(project, invalidIDMessageSubstring);
    project.setProjectId("some-valid-project-id-12345");
    rpc.create(project);
    assertNotNull(rpc.get(project.getProjectId(), EMPTY_RPC_OPTIONS));
  }

  private void expectInvalidArgumentException(
      com.google.api.services.cloudresourcemanager.model.Project project,
      String errorMessageSubstring) {
    try {
      rpc.create(project);
      fail("Should fail because of an invalid argument.");
    } catch (ResourceManagerException e) {
      assertEquals(400, e.getCode());
      assertTrue(e.getMessage().contains(errorMessageSubstring));
    }
  }

  @Test
  public void testIsInvalidProjectName() {
    com.google.api.services.cloudresourcemanager.model.Project project =
        new com.google.api.services.cloudresourcemanager.model.Project()
            .setProjectId("some-project-id");
    rpc.create(project);
    assertNull(rpc.get(project.getProjectId(), EMPTY_RPC_OPTIONS).getName());
    RESOURCE_MANAGER_HELPER.removeProject(project.getProjectId());
    project.setName("This is a valid name-'\"!");
    rpc.create(project);
    assertEquals(project.getName(), rpc.get(project.getProjectId(), EMPTY_RPC_OPTIONS).getName());
    RESOURCE_MANAGER_HELPER.removeProject(project.getProjectId());
    project.setName("invalid-character-,");
    try {
      rpc.create(project);
      fail("Should fail because of invalid project name.");
    } catch (ResourceManagerException e) {
      assertEquals(400, e.getCode());
      assertTrue(e.getMessage().contains("invalid name"));
    }
  }

  @Test
  public void testIsInvalidProjectLabels() {
    com.google.api.services.cloudresourcemanager.model.Project project =
        new com.google.api.services.cloudresourcemanager.model.Project()
            .setProjectId("some-valid-project-id");
    String invalidLabelMessageSubstring = "invalid label entry";
    project.setLabels(ImmutableMap.of("", "v1"));
    expectInvalidArgumentException(project, invalidLabelMessageSubstring);
    project.setLabels(
        ImmutableMap.of(
            "this-project-label-is-more-than-sixty-three-characters-long-so-it-should-fail", "v1"));
    expectInvalidArgumentException(project, invalidLabelMessageSubstring);
    project.setLabels(
        ImmutableMap.of(
            "k1", "this-project-label-is-more-than-sixty-three-characters-long-so-it-should-fail"));
    expectInvalidArgumentException(project, invalidLabelMessageSubstring);
    project.setLabels(ImmutableMap.of("k1?", "v1"));
    expectInvalidArgumentException(project, invalidLabelMessageSubstring);
    project.setLabels(ImmutableMap.of("k1", "v1*"));
    expectInvalidArgumentException(project, invalidLabelMessageSubstring);
    project.setLabels(ImmutableMap.of("-k1", "v1"));
    expectInvalidArgumentException(project, invalidLabelMessageSubstring);
    project.setLabels(ImmutableMap.of("k1", "-v1"));
    expectInvalidArgumentException(project, invalidLabelMessageSubstring);
    project.setLabels(ImmutableMap.of("k1-", "v1"));
    expectInvalidArgumentException(project, invalidLabelMessageSubstring);
    project.setLabels(ImmutableMap.of("k1", "v1-"));
    expectInvalidArgumentException(project, invalidLabelMessageSubstring);
    Map<String, String> tooManyLabels = new HashMap<>();
    for (int i = 0; i < 257; i++) {
      tooManyLabels.put("k" + Integer.toString(i), "v" + Integer.toString(i));
    }
    project.setLabels(tooManyLabels);
    expectInvalidArgumentException(project, "exceeds the limit of 256 labels");
    project.setLabels(ImmutableMap.of("k-1", ""));
    rpc.create(project);
    assertNotNull(rpc.get(project.getProjectId(), EMPTY_RPC_OPTIONS));
    assertTrue(rpc.get(project.getProjectId(), EMPTY_RPC_OPTIONS).getLabels().get("k-1").isEmpty());
  }

  @Test
  public void testDelete() {
    rpc.create(COMPLETE_PROJECT);
    rpc.delete(COMPLETE_PROJECT.getProjectId());
    assertEquals(
        "DELETE_REQUESTED",
        rpc.get(COMPLETE_PROJECT.getProjectId(), EMPTY_RPC_OPTIONS).getLifecycleState());
    try {
      rpc.delete("some-nonexistant-project-id");
      fail("Should fail because the project doesn't exist.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.getCode());
      assertTrue(e.getMessage().contains("not found."));
    }
  }

  @Test
  public void testDeleteWhenDeleteInProgress() {
    rpc.create(COMPLETE_PROJECT);
    RESOURCE_MANAGER_HELPER.changeLifecycleState(
        COMPLETE_PROJECT.getProjectId(), "DELETE_IN_PROGRESS");
    try {
      rpc.delete(COMPLETE_PROJECT.getProjectId());
      fail("Should fail because the project is not ACTIVE.");
    } catch (ResourceManagerException e) {
      assertEquals(400, e.getCode());
      assertTrue(e.getMessage().contains("the lifecycle state was not ACTIVE"));
    }
  }

  @Test
  public void testDeleteWhenDeleteRequested() {
    rpc.create(COMPLETE_PROJECT);
    RESOURCE_MANAGER_HELPER.changeLifecycleState(
        COMPLETE_PROJECT.getProjectId(), "DELETE_REQUESTED");
    try {
      rpc.delete(COMPLETE_PROJECT.getProjectId());
      fail("Should fail because the project is not ACTIVE.");
    } catch (ResourceManagerException e) {
      assertEquals(400, e.getCode());
      assertTrue(e.getMessage().contains("the lifecycle state was not ACTIVE"));
    }
  }

  @Test
  public void testGet() {
    rpc.create(COMPLETE_PROJECT);
    com.google.api.services.cloudresourcemanager.model.Project returnedProject =
        rpc.get(COMPLETE_PROJECT.getProjectId(), EMPTY_RPC_OPTIONS);
    compareReadWriteFields(COMPLETE_PROJECT, returnedProject);
    RESOURCE_MANAGER_HELPER.removeProject(COMPLETE_PROJECT.getProjectId());
    assertNull(rpc.get(COMPLETE_PROJECT.getProjectId(), EMPTY_RPC_OPTIONS));
  }

  @Test
  public void testGetWithOptions() {
    com.google.api.services.cloudresourcemanager.model.Project originalProject =
        rpc.create(COMPLETE_PROJECT);
    Map<ResourceManagerRpc.Option, Object> rpcOptions = new HashMap<>();
    rpcOptions.put(ResourceManagerRpc.Option.FIELDS, "projectId,name,createTime");
    com.google.api.services.cloudresourcemanager.model.Project returnedProject =
        rpc.get(COMPLETE_PROJECT.getProjectId(), rpcOptions);
    assertFalse(COMPLETE_PROJECT.equals(returnedProject));
    assertEquals(COMPLETE_PROJECT.getProjectId(), returnedProject.getProjectId());
    assertEquals(COMPLETE_PROJECT.getName(), returnedProject.getName());
    assertEquals(originalProject.getCreateTime(), returnedProject.getCreateTime());
    assertNull(returnedProject.getParent());
    assertNull(returnedProject.getProjectNumber());
    assertNull(returnedProject.getLifecycleState());
    assertNull(returnedProject.getLabels());
  }

  @Test
  public void testList() {
    Tuple<String, Iterable<com.google.api.services.cloudresourcemanager.model.Project>> projects =
        rpc.list(EMPTY_RPC_OPTIONS);
    assertNull(projects.x());
    assertFalse(projects.y().iterator().hasNext());
    rpc.create(COMPLETE_PROJECT);
    RESOURCE_MANAGER_HELPER.changeLifecycleState(
        COMPLETE_PROJECT.getProjectId(), "DELETE_REQUESTED");
    rpc.create(PROJECT_WITH_PARENT);
    projects = rpc.list(EMPTY_RPC_OPTIONS);
    for (com.google.api.services.cloudresourcemanager.model.Project p : projects.y()) {
      if (p.getProjectId().equals(COMPLETE_PROJECT.getProjectId())) {
        compareReadWriteFields(COMPLETE_PROJECT, p);
      } else if (p.getProjectId().equals(PROJECT_WITH_PARENT.getProjectId())) {
        compareReadWriteFields(PROJECT_WITH_PARENT, p);
      } else {
        fail("Unexpected project in list.");
      }
    }
  }

  @Test
  public void testInvalidListPaging() {
    Map<ResourceManagerRpc.Option, Object> rpcOptions = new HashMap<>();
    rpcOptions.put(ResourceManagerRpc.Option.PAGE_SIZE, -1);
    try {
      rpc.list(rpcOptions);
    } catch (ResourceManagerException e) {
      assertEquals("Page size must be greater than 0.", e.getMessage());
    }
  }

  @Test
  public void testListPaging() {
    Map<ResourceManagerRpc.Option, Object> rpcOptions = new HashMap<>();
    rpcOptions.put(ResourceManagerRpc.Option.PAGE_SIZE, 1);
    rpc.create(PARTIAL_PROJECT);
    rpc.create(COMPLETE_PROJECT);
    Tuple<String, Iterable<com.google.api.services.cloudresourcemanager.model.Project>> projects =
        rpc.list(rpcOptions);
    assertNotNull(projects.x());
    Iterator<com.google.api.services.cloudresourcemanager.model.Project> iterator =
        projects.y().iterator();
    compareReadWriteFields(COMPLETE_PROJECT, iterator.next());
    assertFalse(iterator.hasNext());
    rpcOptions = new HashMap<>();
    rpcOptions.put(ResourceManagerRpc.Option.PAGE_TOKEN, projects.x());
    projects = rpc.list(rpcOptions);
    iterator = projects.y().iterator();
    compareReadWriteFields(PARTIAL_PROJECT, iterator.next());
    assertFalse(iterator.hasNext());
    assertNull(projects.x());
  }

  @Test
  public void testListFieldOptions() {
    Map<ResourceManagerRpc.Option, Object> rpcOptions = new HashMap<>();
    rpcOptions.put(
        ResourceManagerRpc.Option.FIELDS, "projects(projectId,name,labels),nextPageToken");
    rpc.create(PROJECT_WITH_PARENT);
    Tuple<String, Iterable<com.google.api.services.cloudresourcemanager.model.Project>> projects =
        rpc.list(rpcOptions);
    com.google.api.services.cloudresourcemanager.model.Project returnedProject =
        projects.y().iterator().next();
    assertFalse(PROJECT_WITH_PARENT.equals(returnedProject));
    assertEquals(PROJECT_WITH_PARENT.getProjectId(), returnedProject.getProjectId());
    assertEquals(PROJECT_WITH_PARENT.getName(), returnedProject.getName());
    assertEquals(PROJECT_WITH_PARENT.getLabels(), returnedProject.getLabels());
    assertNull(returnedProject.getParent());
    assertNull(returnedProject.getProjectNumber());
    assertNull(returnedProject.getLifecycleState());
    assertNull(returnedProject.getCreateTime());
  }

  @Test
  public void testListPageTokenFieldOptions() {
    Map<ResourceManagerRpc.Option, Object> rpcOptions = new HashMap<>();
    rpcOptions.put(ResourceManagerRpc.Option.PAGE_SIZE, 1);
    rpcOptions.put(ResourceManagerRpc.Option.FIELDS, "nextPageToken,projects(projectId,name)");
    rpc.create(PARTIAL_PROJECT);
    rpc.create(COMPLETE_PROJECT);
    Tuple<String, Iterable<com.google.api.services.cloudresourcemanager.model.Project>> projects =
        rpc.list(rpcOptions);
    assertNotNull(projects.x());
    Iterator<com.google.api.services.cloudresourcemanager.model.Project> iterator =
        projects.y().iterator();
    com.google.api.services.cloudresourcemanager.model.Project returnedProject = iterator.next();
    assertEquals(COMPLETE_PROJECT.getProjectId(), returnedProject.getProjectId());
    assertEquals(COMPLETE_PROJECT.getName(), returnedProject.getName());
    assertNull(returnedProject.getLabels());
    assertNull(returnedProject.getParent());
    assertNull(returnedProject.getProjectNumber());
    assertNull(returnedProject.getLifecycleState());
    assertNull(returnedProject.getCreateTime());
    assertFalse(iterator.hasNext());
    rpcOptions.put(ResourceManagerRpc.Option.PAGE_TOKEN, projects.x());
    projects = rpc.list(rpcOptions);
    iterator = projects.y().iterator();
    returnedProject = iterator.next();
    assertEquals(PARTIAL_PROJECT.getProjectId(), returnedProject.getProjectId());
    assertEquals(PARTIAL_PROJECT.getName(), returnedProject.getName());
    assertNull(returnedProject.getLabels());
    assertNull(returnedProject.getParent());
    assertNull(returnedProject.getProjectNumber());
    assertNull(returnedProject.getLifecycleState());
    assertNull(returnedProject.getCreateTime());
    assertNull(projects.x());
  }

  @Test
  public void testListNoPageTokenFieldOptions() {
    Map<ResourceManagerRpc.Option, Object> rpcOptions = new HashMap<>();
    rpcOptions.put(ResourceManagerRpc.Option.PAGE_SIZE, 1);
    rpcOptions.put(ResourceManagerRpc.Option.FIELDS, "projects(projectId,name)");
    rpc.create(PARTIAL_PROJECT);
    rpc.create(COMPLETE_PROJECT);
    Tuple<String, Iterable<com.google.api.services.cloudresourcemanager.model.Project>> projects =
        rpc.list(rpcOptions);
    assertNull(projects.x());
    Iterator<com.google.api.services.cloudresourcemanager.model.Project> iterator =
        projects.y().iterator();
    com.google.api.services.cloudresourcemanager.model.Project returnedProject = iterator.next();
    assertEquals(COMPLETE_PROJECT.getProjectId(), returnedProject.getProjectId());
    assertEquals(COMPLETE_PROJECT.getName(), returnedProject.getName());
    assertNull(returnedProject.getLabels());
    assertNull(returnedProject.getParent());
    assertNull(returnedProject.getProjectNumber());
    assertNull(returnedProject.getLifecycleState());
    assertNull(returnedProject.getCreateTime());
    assertFalse(iterator.hasNext());
  }

  @Test
  public void testListPageTokenNoFieldsOptions() {
    Map<ResourceManagerRpc.Option, Object> rpcOptions = new HashMap<>();
    rpcOptions.put(ResourceManagerRpc.Option.PAGE_SIZE, 1);
    rpcOptions.put(ResourceManagerRpc.Option.FIELDS, "nextPageToken");
    rpc.create(PARTIAL_PROJECT);
    rpc.create(COMPLETE_PROJECT);
    Tuple<String, Iterable<com.google.api.services.cloudresourcemanager.model.Project>> projects =
        rpc.list(rpcOptions);
    assertNotNull(projects.x());
    assertNull(projects.y());
    rpcOptions.put(ResourceManagerRpc.Option.PAGE_TOKEN, projects.x());
    projects = rpc.list(rpcOptions);
    assertNull(projects.x());
    assertNull(projects.y());
  }

  @Test
  public void testListFilterOptions() {
    Map<ResourceManagerRpc.Option, Object> rpcFilterOptions = new HashMap<>();
    rpcFilterOptions.put(
        ResourceManagerRpc.Option.FILTER, "id:* name:myProject labels.color:blue LABELS.SIZE:*");
    com.google.api.services.cloudresourcemanager.model.Project matchingProject =
        new com.google.api.services.cloudresourcemanager.model.Project()
            .setProjectId("matching-project")
            .setName("MyProject")
            .setLabels(ImmutableMap.of("color", "blue", "size", "big"));
    com.google.api.services.cloudresourcemanager.model.Project nonMatchingProject1 =
        new com.google.api.services.cloudresourcemanager.model.Project()
            .setProjectId("non-matching-project1")
            .setName("myProject");
    nonMatchingProject1.setLabels(ImmutableMap.of("color", "blue"));
    com.google.api.services.cloudresourcemanager.model.Project nonMatchingProject2 =
        new com.google.api.services.cloudresourcemanager.model.Project()
            .setProjectId("non-matching-project2")
            .setName("myProj")
            .setLabels(ImmutableMap.of("color", "blue", "size", "big"));
    com.google.api.services.cloudresourcemanager.model.Project nonMatchingProject3 =
        new com.google.api.services.cloudresourcemanager.model.Project()
            .setProjectId("non-matching-project3");
    rpc.create(matchingProject);
    rpc.create(nonMatchingProject1);
    rpc.create(nonMatchingProject2);
    rpc.create(nonMatchingProject3);
    for (com.google.api.services.cloudresourcemanager.model.Project p :
        rpc.list(rpcFilterOptions).y()) {
      assertFalse(p.equals(nonMatchingProject1));
      assertFalse(p.equals(nonMatchingProject2));
      compareReadWriteFields(matchingProject, p);
    }
  }

  @Test
  public void testReplace() {
    com.google.api.services.cloudresourcemanager.model.Project createdProject =
        rpc.create(COMPLETE_PROJECT);
    String newName = "new name";
    Map<String, String> newLabels = ImmutableMap.of("new k1", "new v1");
    com.google.api.services.cloudresourcemanager.model.Project anotherCompleteProject =
        new com.google.api.services.cloudresourcemanager.model.Project()
            .setProjectId(COMPLETE_PROJECT.getProjectId())
            .setName(newName)
            .setLabels(newLabels)
            .setProjectNumber(987654321L)
            .setCreateTime("2000-01-01T00:00:00.001Z")
            .setLifecycleState("DELETE_REQUESTED");
    com.google.api.services.cloudresourcemanager.model.Project returnedProject =
        rpc.replace(anotherCompleteProject);
    compareReadWriteFields(anotherCompleteProject, returnedProject);
    assertEquals(createdProject.getProjectNumber(), returnedProject.getProjectNumber());
    assertEquals(createdProject.getCreateTime(), returnedProject.getCreateTime());
    assertEquals(createdProject.getLifecycleState(), returnedProject.getLifecycleState());
    com.google.api.services.cloudresourcemanager.model.Project nonexistantProject =
        new com.google.api.services.cloudresourcemanager.model.Project();
    nonexistantProject.setProjectId("some-project-id-that-does-not-exist");
    try {
      rpc.replace(nonexistantProject);
      fail("Should fail because the project doesn't exist.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.getCode());
      assertTrue(e.getMessage().contains("the project was not found"));
    }
  }

  @Test
  public void testReplaceWhenDeleteRequested() {
    rpc.create(COMPLETE_PROJECT);
    rpc.delete(COMPLETE_PROJECT.getProjectId());
    com.google.api.services.cloudresourcemanager.model.Project anotherProject =
        new com.google.api.services.cloudresourcemanager.model.Project()
            .setProjectId(COMPLETE_PROJECT.getProjectId());
    try {
      rpc.replace(anotherProject);
      fail("Should fail because the project is not ACTIVE.");
    } catch (ResourceManagerException e) {
      assertEquals(400, e.getCode());
      assertTrue(e.getMessage().contains("the lifecycle state was not ACTIVE"));
    }
  }

  @Test
  public void testReplaceWhenDeleteInProgress() {
    rpc.create(COMPLETE_PROJECT);
    RESOURCE_MANAGER_HELPER.changeLifecycleState(
        COMPLETE_PROJECT.getProjectId(), "DELETE_IN_PROGRESS");
    com.google.api.services.cloudresourcemanager.model.Project anotherProject =
        new com.google.api.services.cloudresourcemanager.model.Project()
            .setProjectId(COMPLETE_PROJECT.getProjectId());
    try {
      rpc.replace(anotherProject);
      fail("Should fail because the project is not ACTIVE.");
    } catch (ResourceManagerException e) {
      assertEquals(400, e.getCode());
      assertTrue(e.getMessage().contains("the lifecycle state was not ACTIVE"));
    }
  }

  @Test
  public void testReplaceAddingParent() {
    rpc.create(COMPLETE_PROJECT);
    com.google.api.services.cloudresourcemanager.model.Project anotherProject =
        new com.google.api.services.cloudresourcemanager.model.Project()
            .setProjectId(COMPLETE_PROJECT.getProjectId())
            .setParent(PARENT);
    try {
      rpc.replace(anotherProject);
      fail("Should fail because the project's parent was modified after creation.");
    } catch (ResourceManagerException e) {
      assertEquals(400, e.getCode());
      assertEquals(
          "The server currently only supports setting the parent once "
              + "and does not allow unsetting it.",
          e.getMessage());
    }
  }

  @Test
  public void testReplaceRemovingParent() {
    rpc.create(PROJECT_WITH_PARENT);
    com.google.api.services.cloudresourcemanager.model.Project anotherProject =
        new com.google.api.services.cloudresourcemanager.model.Project()
            .setProjectId(PROJECT_WITH_PARENT.getProjectId());
    try {
      rpc.replace(anotherProject);
      fail("Should fail because the project's parent was unset.");
    } catch (ResourceManagerException e) {
      assertEquals(400, e.getCode());
      assertEquals(
          "The server currently only supports setting the parent once "
              + "and does not allow unsetting it.",
          e.getMessage());
    }
  }

  @Test
  public void testUndelete() {
    rpc.create(COMPLETE_PROJECT);
    rpc.delete(COMPLETE_PROJECT.getProjectId());
    assertEquals(
        "DELETE_REQUESTED",
        rpc.get(COMPLETE_PROJECT.getProjectId(), EMPTY_RPC_OPTIONS).getLifecycleState());
    rpc.undelete(COMPLETE_PROJECT.getProjectId());
    com.google.api.services.cloudresourcemanager.model.Project revivedProject =
        rpc.get(COMPLETE_PROJECT.getProjectId(), EMPTY_RPC_OPTIONS);
    compareReadWriteFields(COMPLETE_PROJECT, revivedProject);
    assertEquals("ACTIVE", revivedProject.getLifecycleState());
    try {
      rpc.undelete("invalid-project-id");
      fail("Should fail because the project doesn't exist.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.getCode());
      assertTrue(e.getMessage().contains("the project was not found"));
    }
  }

  @Test
  public void testUndeleteWhenActive() {
    rpc.create(COMPLETE_PROJECT);
    try {
      rpc.undelete(COMPLETE_PROJECT.getProjectId());
      fail("Should fail because the project is not deleted.");
    } catch (ResourceManagerException e) {
      assertEquals(400, e.getCode());
      assertTrue(e.getMessage().contains("lifecycle state was not DELETE_REQUESTED"));
    }
  }

  @Test
  public void testUndeleteWhenDeleteInProgress() {
    rpc.create(COMPLETE_PROJECT);
    RESOURCE_MANAGER_HELPER.changeLifecycleState(
        COMPLETE_PROJECT.getProjectId(), "DELETE_IN_PROGRESS");
    try {
      rpc.undelete(COMPLETE_PROJECT.getProjectId());
      fail("Should fail because the project is in the process of being deleted.");
    } catch (ResourceManagerException e) {
      assertEquals(400, e.getCode());
      assertTrue(e.getMessage().contains("lifecycle state was not DELETE_REQUESTED"));
    }
  }

  @Test
  public void testGetPolicy() {
    assertNull(rpc.getPolicy("nonexistent-project"));
    rpc.create(PARTIAL_PROJECT);
    com.google.api.services.cloudresourcemanager.model.Policy policy =
        rpc.getPolicy(PARTIAL_PROJECT.getProjectId());
    assertEquals(Collections.emptyList(), policy.getBindings());
    assertNotNull(policy.getEtag());
  }

  @Test
  public void testReplacePolicy() {
    try {
      rpc.replacePolicy("nonexistent-project", POLICY);
      fail("Project doesn't exist.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.getCode());
      assertTrue(e.getMessage().contains("project was not found"));
    }
    rpc.create(PARTIAL_PROJECT);
    com.google.api.services.cloudresourcemanager.model.Policy invalidPolicy =
        new com.google.api.services.cloudresourcemanager.model.Policy().setEtag("wrong-etag");
    try {
      rpc.replacePolicy(PARTIAL_PROJECT.getProjectId(), invalidPolicy);
      fail("Invalid etag.");
    } catch (ResourceManagerException e) {
      assertEquals(409, e.getCode());
      assertTrue(e.getMessage().startsWith("Policy etag mismatch"));
    }
    String originalEtag = rpc.getPolicy(PARTIAL_PROJECT.getProjectId()).getEtag();
    com.google.api.services.cloudresourcemanager.model.Policy newPolicy =
        rpc.replacePolicy(PARTIAL_PROJECT.getProjectId(), POLICY);
    assertEquals(POLICY.getBindings(), newPolicy.getBindings());
    assertNotNull(newPolicy.getEtag());
    assertNotEquals(originalEtag, newPolicy.getEtag());
  }

  @Test
  public void testTestPermissions() {
    List<String> permissions = ImmutableList.of("resourcemanager.projects.get");
    try {
      rpc.testPermissions("nonexistent-project", permissions);
      fail("Nonexistent project.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.getCode());
      assertEquals("Project nonexistent-project not found.", e.getMessage());
    }
    rpc.create(PARTIAL_PROJECT);
    assertEquals(
        ImmutableList.of(true), rpc.testPermissions(PARTIAL_PROJECT.getProjectId(), permissions));
  }

  @Test
  public void testChangeLifecycleStatus() {
    assertFalse(
        RESOURCE_MANAGER_HELPER.changeLifecycleState(
            COMPLETE_PROJECT.getProjectId(), "DELETE_IN_PROGRESS"));
    rpc.create(COMPLETE_PROJECT);
    assertTrue(
        RESOURCE_MANAGER_HELPER.changeLifecycleState(
            COMPLETE_PROJECT.getProjectId(), "DELETE_IN_PROGRESS"));
    assertEquals(
        "DELETE_IN_PROGRESS",
        rpc.get(COMPLETE_PROJECT.getProjectId(), EMPTY_RPC_OPTIONS).getLifecycleState());
    try {
      RESOURCE_MANAGER_HELPER.changeLifecycleState(
          COMPLETE_PROJECT.getProjectId(), "INVALID_STATE");
      fail("Should fail because of an invalid lifecycle state");
    } catch (IllegalArgumentException e) {
      // ignore
    }
  }

  @Test
  public void testRemoveProject() {
    assertFalse(RESOURCE_MANAGER_HELPER.removeProject(COMPLETE_PROJECT.getProjectId()));
    rpc.create(COMPLETE_PROJECT);
    assertNotNull(rpc.getPolicy(COMPLETE_PROJECT.getProjectId()));
    assertTrue(RESOURCE_MANAGER_HELPER.removeProject(COMPLETE_PROJECT.getProjectId()));
    assertNull(rpc.get(COMPLETE_PROJECT.getProjectId(), EMPTY_RPC_OPTIONS));
    assertNull(rpc.getPolicy(COMPLETE_PROJECT.getProjectId()));
  }

  private void compareReadWriteFields(
      com.google.api.services.cloudresourcemanager.model.Project expected,
      com.google.api.services.cloudresourcemanager.model.Project actual) {
    assertEquals(expected.getProjectId(), actual.getProjectId());
    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getLabels(), actual.getLabels());
    assertEquals(expected.getParent(), actual.getParent());
  }
}
