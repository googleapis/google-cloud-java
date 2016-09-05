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

package com.google.cloud.resourcemanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.Identity;
import com.google.cloud.Page;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.resourcemanager.ProjectInfo.ResourceId;
import com.google.cloud.resourcemanager.ResourceManager.ProjectField;
import com.google.cloud.resourcemanager.ResourceManager.ProjectGetOption;
import com.google.cloud.resourcemanager.ResourceManager.ProjectListOption;
import com.google.cloud.resourcemanager.spi.ResourceManagerRpc;
import com.google.cloud.resourcemanager.spi.ResourceManagerRpcFactory;
import com.google.cloud.resourcemanager.testing.LocalResourceManagerHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ResourceManagerImplTest {

  private static final LocalResourceManagerHelper RESOURCE_MANAGER_HELPER =
      LocalResourceManagerHelper.create();
  private static final ResourceManager RESOURCE_MANAGER =
      RESOURCE_MANAGER_HELPER.options().service();
  private static final ProjectGetOption GET_FIELDS =
      ProjectGetOption.fields(ProjectField.NAME, ProjectField.CREATE_TIME);
  private static final ProjectListOption LIST_FIELDS =
      ProjectListOption.fields(ProjectField.NAME, ProjectField.LABELS);
  private static final ProjectListOption LIST_FILTER =
      ProjectListOption.filter("id:* name:myProject labels.color:blue LABELS.SIZE:*");
  private static final ProjectInfo PARTIAL_PROJECT = ProjectInfo.builder("partial-project").build();
  private static final ResourceId PARENT = new ResourceId("id", "type");
  private static final ProjectInfo COMPLETE_PROJECT = ProjectInfo.builder("complete-project")
      .name("name")
      .labels(ImmutableMap.of("k1", "v1"))
      .parent(PARENT)
      .build();
  private static final Map<ResourceManagerRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();
  private static final Policy POLICY = Policy.builder()
      .addIdentity(Role.owner(), Identity.user("me@gmail.com"))
      .addIdentity(Role.editor(), Identity.serviceAccount("serviceaccount@gmail.com"))
      .build();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @BeforeClass
  public static void beforeClass() {
    RESOURCE_MANAGER_HELPER.start();
  }

  @Before
  public void setUp() {
    clearProjects();
  }

  private void clearProjects() {
    for (Project project : RESOURCE_MANAGER.list().values()) {
      RESOURCE_MANAGER_HELPER.removeProject(project.projectId());
    }
  }

  @AfterClass
  public static void afterClass() {
    RESOURCE_MANAGER_HELPER.stop();
  }

  private void compareReadWriteFields(ProjectInfo expected, ProjectInfo actual) {
    assertEquals(expected.projectId(), actual.projectId());
    assertEquals(expected.name(), actual.name());
    assertEquals(expected.labels(), actual.labels());
    assertEquals(expected.parent(), actual.parent());
  }

  @Test
  public void testCreate() {
    Project returnedProject = RESOURCE_MANAGER.create(PARTIAL_PROJECT);
    compareReadWriteFields(PARTIAL_PROJECT, returnedProject);
    assertEquals(ProjectInfo.State.ACTIVE, returnedProject.state());
    assertNull(returnedProject.name());
    assertNull(returnedProject.parent());
    assertNotNull(returnedProject.projectNumber());
    assertNotNull(returnedProject.createTimeMillis());
    assertSame(RESOURCE_MANAGER, returnedProject.resourceManager());
    try {
      RESOURCE_MANAGER.create(PARTIAL_PROJECT);
      fail("Should fail, project already exists.");
    } catch (ResourceManagerException e) {
      assertEquals(409, e.code());
      assertTrue(e.getMessage().startsWith("A project with the same project ID")
          && e.getMessage().endsWith("already exists."));
    }
    returnedProject = RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    compareReadWriteFields(COMPLETE_PROJECT, returnedProject);
    assertEquals(ProjectInfo.State.ACTIVE, returnedProject.state());
    assertNotNull(returnedProject.projectNumber());
    assertNotNull(returnedProject.createTimeMillis());
    assertSame(RESOURCE_MANAGER, returnedProject.resourceManager());
  }

  @Test
  public void testDelete() {
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    RESOURCE_MANAGER.delete(COMPLETE_PROJECT.projectId());
    assertEquals(ProjectInfo.State.DELETE_REQUESTED,
        RESOURCE_MANAGER.get(COMPLETE_PROJECT.projectId()).state());
    try {
      RESOURCE_MANAGER.delete("some-nonexistant-project-id");
      fail("Should fail because the project doesn't exist.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.code());
      assertTrue(e.getMessage().contains("not found."));
    }
  }

  @Test
  public void testGet() {
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    Project returnedProject = RESOURCE_MANAGER.get(COMPLETE_PROJECT.projectId());
    compareReadWriteFields(COMPLETE_PROJECT, returnedProject);
    assertEquals(RESOURCE_MANAGER, returnedProject.resourceManager());
    RESOURCE_MANAGER_HELPER.removeProject(COMPLETE_PROJECT.projectId());
    assertNull(RESOURCE_MANAGER.get(COMPLETE_PROJECT.projectId()));
  }

  @Test
  public void testGetWithOptions() {
    Project originalProject = RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    Project returnedProject = RESOURCE_MANAGER.get(COMPLETE_PROJECT.projectId(), GET_FIELDS);
    assertFalse(COMPLETE_PROJECT.equals(returnedProject));
    assertEquals(COMPLETE_PROJECT.projectId(), returnedProject.projectId());
    assertEquals(COMPLETE_PROJECT.name(), returnedProject.name());
    assertEquals(originalProject.createTimeMillis(), returnedProject.createTimeMillis());
    assertNull(returnedProject.parent());
    assertNull(returnedProject.projectNumber());
    assertNull(returnedProject.state());
    assertTrue(returnedProject.labels().isEmpty());
    assertEquals(RESOURCE_MANAGER, originalProject.resourceManager());
    assertEquals(RESOURCE_MANAGER, returnedProject.resourceManager());
  }

  @Test
  public void testList() {
    Page<Project> projects = RESOURCE_MANAGER.list();
    assertFalse(projects.values().iterator().hasNext());
    RESOURCE_MANAGER.create(PARTIAL_PROJECT);
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    for (Project p : RESOURCE_MANAGER.list().values()) {
      if (p.projectId().equals(PARTIAL_PROJECT.projectId())) {
        compareReadWriteFields(PARTIAL_PROJECT, p);
      } else if (p.projectId().equals(COMPLETE_PROJECT.projectId())) {
        compareReadWriteFields(COMPLETE_PROJECT, p);
      } else {
        fail("Some unexpected project returned by list.");
      }
      assertSame(RESOURCE_MANAGER, p.resourceManager());
    }
  }

  @Test
  public void testListPaging() {
    RESOURCE_MANAGER.create(PARTIAL_PROJECT);
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    Page<Project> page = RESOURCE_MANAGER.list(ProjectListOption.pageSize(1));
    assertNotNull(page.nextPageCursor());
    Iterator<Project> iterator = page.values().iterator();
    compareReadWriteFields(COMPLETE_PROJECT, iterator.next());
    assertFalse(iterator.hasNext());
    page = page.nextPage();
    iterator = page.values().iterator();
    compareReadWriteFields(PARTIAL_PROJECT, iterator.next());
    assertFalse(iterator.hasNext());
    assertNull(page.nextPageCursor());
  }

  @Test
  public void testListFieldOptions() {
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    Page<Project> projects = RESOURCE_MANAGER.list(LIST_FIELDS);
    Project returnedProject = projects.iterateAll().next();
    assertEquals(COMPLETE_PROJECT.projectId(), returnedProject.projectId());
    assertEquals(COMPLETE_PROJECT.name(), returnedProject.name());
    assertEquals(COMPLETE_PROJECT.labels(), returnedProject.labels());
    assertNull(returnedProject.parent());
    assertNull(returnedProject.projectNumber());
    assertNull(returnedProject.state());
    assertNull(returnedProject.createTimeMillis());
    assertSame(RESOURCE_MANAGER, returnedProject.resourceManager());
  }

  @Test
  public void testListPagingWithFieldOptions() {
    RESOURCE_MANAGER.create(PARTIAL_PROJECT);
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    Page<Project> projects = RESOURCE_MANAGER.list(LIST_FIELDS, ProjectListOption.pageSize(1));
    assertNotNull(projects.nextPageCursor());
    Iterator<Project> iterator = projects.values().iterator();
    Project returnedProject = iterator.next();
    assertEquals(COMPLETE_PROJECT.projectId(), returnedProject.projectId());
    assertEquals(COMPLETE_PROJECT.name(), returnedProject.name());
    assertEquals(COMPLETE_PROJECT.labels(), returnedProject.labels());
    assertNull(returnedProject.parent());
    assertNull(returnedProject.projectNumber());
    assertNull(returnedProject.state());
    assertNull(returnedProject.createTimeMillis());
    assertSame(RESOURCE_MANAGER, returnedProject.resourceManager());
    assertFalse(iterator.hasNext());
    projects = projects.nextPage();
    iterator = projects.values().iterator();
    returnedProject = iterator.next();
    assertEquals(PARTIAL_PROJECT.projectId(), returnedProject.projectId());
    assertEquals(PARTIAL_PROJECT.name(), returnedProject.name());
    assertEquals(PARTIAL_PROJECT.labels(), returnedProject.labels());
    assertNull(returnedProject.parent());
    assertNull(returnedProject.projectNumber());
    assertNull(returnedProject.state());
    assertNull(returnedProject.createTimeMillis());
    assertSame(RESOURCE_MANAGER, returnedProject.resourceManager());
    assertFalse(iterator.hasNext());
    assertNull(projects.nextPageCursor());
  }

  @Test
  public void testListFilterOptions() {
    ProjectInfo matchingProject = ProjectInfo.builder("matching-project")
        .name("MyProject")
        .labels(ImmutableMap.of("color", "blue", "size", "big"))
        .build();
    ProjectInfo nonMatchingProject1 = ProjectInfo.builder("non-matching-project1")
        .name("myProject")
        .labels(ImmutableMap.of("color", "blue"))
        .build();
    ProjectInfo nonMatchingProject2 = ProjectInfo.builder("non-matching-project2")
        .name("myProj")
        .labels(ImmutableMap.of("color", "blue", "size", "big"))
        .build();
    ProjectInfo nonMatchingProject3 = ProjectInfo.builder("non-matching-project3").build();
    RESOURCE_MANAGER.create(matchingProject);
    RESOURCE_MANAGER.create(nonMatchingProject1);
    RESOURCE_MANAGER.create(nonMatchingProject2);
    RESOURCE_MANAGER.create(nonMatchingProject3);
    for (Project p : RESOURCE_MANAGER.list(LIST_FILTER).values()) {
      assertFalse(p.equals(nonMatchingProject1));
      assertFalse(p.equals(nonMatchingProject2));
      compareReadWriteFields(matchingProject, p);
      assertSame(RESOURCE_MANAGER, p.resourceManager());
    }
  }

  @Test
  public void testReplace() {
    ProjectInfo createdProject = RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    Map<String, String> newLabels = ImmutableMap.of("new k1", "new v1");
    ProjectInfo anotherCompleteProject = ProjectInfo.builder(COMPLETE_PROJECT.projectId())
        .labels(newLabels)
        .projectNumber(987654321L)
        .createTimeMillis(230682061315L)
        .state(ProjectInfo.State.DELETE_REQUESTED)
        .parent(createdProject.parent())
        .build();
    Project returnedProject = RESOURCE_MANAGER.replace(anotherCompleteProject);
    compareReadWriteFields(anotherCompleteProject, returnedProject);
    assertEquals(createdProject.projectNumber(), returnedProject.projectNumber());
    assertEquals(createdProject.createTimeMillis(), returnedProject.createTimeMillis());
    assertEquals(createdProject.state(), returnedProject.state());
    assertEquals(RESOURCE_MANAGER, returnedProject.resourceManager());
    ProjectInfo nonexistantProject =
        ProjectInfo.builder("some-project-id-that-does-not-exist").build();
    try {
      RESOURCE_MANAGER.replace(nonexistantProject);
      fail("Should fail because the project doesn't exist.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.code());
      assertTrue(e.getMessage().contains("the project was not found"));
    }
  }

  @Test
  public void testUndelete() {
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    RESOURCE_MANAGER.delete(COMPLETE_PROJECT.projectId());
    assertEquals(
        ProjectInfo.State.DELETE_REQUESTED,
        RESOURCE_MANAGER.get(COMPLETE_PROJECT.projectId()).state());
    RESOURCE_MANAGER.undelete(COMPLETE_PROJECT.projectId());
    ProjectInfo revivedProject = RESOURCE_MANAGER.get(COMPLETE_PROJECT.projectId());
    compareReadWriteFields(COMPLETE_PROJECT, revivedProject);
    assertEquals(ProjectInfo.State.ACTIVE, revivedProject.state());
    try {
      RESOURCE_MANAGER.undelete("invalid-project-id");
      fail("Should fail because the project doesn't exist.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.code());
      assertTrue(e.getMessage().contains("the project was not found"));
    }
  }

  @Test
  public void testGetPolicy() {
    assertNull(RESOURCE_MANAGER.getPolicy(COMPLETE_PROJECT.projectId()));
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    RESOURCE_MANAGER.replacePolicy(COMPLETE_PROJECT.projectId(), POLICY);
    Policy retrieved = RESOURCE_MANAGER.getPolicy(COMPLETE_PROJECT.projectId());
    assertEquals(POLICY.bindings(), retrieved.bindings());
    assertNotNull(retrieved.etag());
    assertEquals(0, retrieved.version());
  }

  @Test
  public void testReplacePolicy() {
    try {
      RESOURCE_MANAGER.replacePolicy("nonexistent-project", POLICY);
      fail("Project doesn't exist.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.code());
      assertTrue(e.getMessage().endsWith("project was not found."));
    }
    RESOURCE_MANAGER.create(PARTIAL_PROJECT);
    Policy oldPolicy = RESOURCE_MANAGER.getPolicy(PARTIAL_PROJECT.projectId());
    RESOURCE_MANAGER.replacePolicy(PARTIAL_PROJECT.projectId(), POLICY);
    try {
      RESOURCE_MANAGER.replacePolicy(PARTIAL_PROJECT.projectId(), oldPolicy);
      fail("Policy with an invalid etag didn't cause error.");
    } catch (ResourceManagerException e) {
      assertEquals(409, e.code());
      assertTrue(e.getMessage().contains("Policy etag mismatch"));
    }
    String originalEtag = RESOURCE_MANAGER.getPolicy(PARTIAL_PROJECT.projectId()).etag();
    Policy newPolicy = RESOURCE_MANAGER.replacePolicy(PARTIAL_PROJECT.projectId(), POLICY);
    assertEquals(POLICY.bindings(), newPolicy.bindings());
    assertNotNull(newPolicy.etag());
    assertNotEquals(originalEtag, newPolicy.etag());
  }

  @Test
  public void testTestPermissions() {
    List<String> permissions = ImmutableList.of("resourcemanager.projects.get");
    try {
      RESOURCE_MANAGER.testPermissions("nonexistent-project", permissions);
      fail("Nonexistent project");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.code());
      assertEquals("Project nonexistent-project not found.", e.getMessage());
    }
    RESOURCE_MANAGER.create(PARTIAL_PROJECT);
    assertEquals(ImmutableList.of(true),
        RESOURCE_MANAGER.testPermissions(PARTIAL_PROJECT.projectId(), permissions));
  }

  @Test
  public void testRetryableException() {
    ResourceManagerRpcFactory rpcFactoryMock = EasyMock.createMock(ResourceManagerRpcFactory.class);
    ResourceManagerRpc resourceManagerRpcMock = EasyMock.createMock(ResourceManagerRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(ResourceManagerOptions.class)))
        .andReturn(resourceManagerRpcMock);
    EasyMock.replay(rpcFactoryMock);
    ResourceManager resourceManagerMock = ResourceManagerOptions.builder()
        .serviceRpcFactory(rpcFactoryMock)
        .build()
        .service();
    EasyMock.expect(resourceManagerRpcMock.get(PARTIAL_PROJECT.projectId(), EMPTY_RPC_OPTIONS))
        .andThrow(new ResourceManagerException(500, "Internal Error"))
        .andReturn(PARTIAL_PROJECT.toPb());
    EasyMock.replay(resourceManagerRpcMock);
    Project returnedProject = resourceManagerMock.get(PARTIAL_PROJECT.projectId());
    assertEquals(
        new Project(resourceManagerMock, new ProjectInfo.BuilderImpl(PARTIAL_PROJECT)),
        returnedProject);
  }

  @Test
  public void testNonRetryableException() {
    ResourceManagerRpcFactory rpcFactoryMock = EasyMock.createMock(ResourceManagerRpcFactory.class);
    ResourceManagerRpc resourceManagerRpcMock = EasyMock.createMock(ResourceManagerRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(ResourceManagerOptions.class)))
        .andReturn(resourceManagerRpcMock);
    EasyMock.replay(rpcFactoryMock);
    ResourceManager resourceManagerMock = ResourceManagerOptions.builder()
        .serviceRpcFactory(rpcFactoryMock)
        .build()
        .service();
    EasyMock.expect(resourceManagerRpcMock.get(PARTIAL_PROJECT.projectId(), EMPTY_RPC_OPTIONS))
        .andThrow(new ResourceManagerException(
            403, "Project " + PARTIAL_PROJECT.projectId() + " not found."))
        .once();
    EasyMock.replay(resourceManagerRpcMock);
    thrown.expect(ResourceManagerException.class);
    thrown.expectMessage("Project " + PARTIAL_PROJECT.projectId() + " not found.");
    resourceManagerMock.get(PARTIAL_PROJECT.projectId());
  }

  @Test
  public void testRuntimeException() {
    ResourceManagerRpcFactory rpcFactoryMock = EasyMock.createMock(ResourceManagerRpcFactory.class);
    ResourceManagerRpc resourceManagerRpcMock = EasyMock.createMock(ResourceManagerRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(ResourceManagerOptions.class)))
        .andReturn(resourceManagerRpcMock);
    EasyMock.replay(rpcFactoryMock);
    ResourceManager resourceManagerMock =
        ResourceManagerOptions.builder().serviceRpcFactory(rpcFactoryMock).build().service();
    String exceptionMessage = "Artificial runtime exception";
    EasyMock.expect(resourceManagerRpcMock.get(PARTIAL_PROJECT.projectId(), EMPTY_RPC_OPTIONS))
        .andThrow(new RuntimeException(exceptionMessage));
    EasyMock.replay(resourceManagerRpcMock);
    thrown.expect(ResourceManagerException.class);
    thrown.expectMessage(exceptionMessage);
    resourceManagerMock.get(PARTIAL_PROJECT.projectId());
  }
}
