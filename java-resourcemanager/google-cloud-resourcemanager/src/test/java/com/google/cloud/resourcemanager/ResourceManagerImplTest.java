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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.paging.Page;
import com.google.api.services.cloudresourcemanager.model.Constraint;
import com.google.api.services.cloudresourcemanager.model.OrgPolicy;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.resourcemanager.OrgPolicyInfo.BoolPolicy;
import com.google.cloud.resourcemanager.ProjectInfo.ResourceId;
import com.google.cloud.resourcemanager.ResourceManager.ProjectField;
import com.google.cloud.resourcemanager.ResourceManager.ProjectGetOption;
import com.google.cloud.resourcemanager.ResourceManager.ProjectListOption;
import com.google.cloud.resourcemanager.spi.ResourceManagerRpcFactory;
import com.google.cloud.resourcemanager.spi.v1beta1.ResourceManagerRpc;
import com.google.cloud.resourcemanager.spi.v1beta1.ResourceManagerRpc.ListResult;
import com.google.cloud.resourcemanager.testing.LocalResourceManagerHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResourceManagerImplTest {

  private static final LocalResourceManagerHelper RESOURCE_MANAGER_HELPER =
      LocalResourceManagerHelper.create();
  private static final ResourceManager RESOURCE_MANAGER =
      RESOURCE_MANAGER_HELPER.getOptions().getService();
  private static final ProjectGetOption GET_FIELDS =
      ProjectGetOption.fields(ProjectField.NAME, ProjectField.CREATE_TIME);
  private static final ProjectListOption LIST_FIELDS =
      ProjectListOption.fields(ProjectField.NAME, ProjectField.LABELS);
  private static final ProjectListOption LIST_FILTER =
      ProjectListOption.filter("id:* name:myProject labels.color:blue LABELS.SIZE:*");
  private static final ProjectInfo PARTIAL_PROJECT =
      ProjectInfo.newBuilder("partial-project").build();
  private static final ResourceId PARENT = new ResourceId("id", "type");
  private static final ProjectInfo COMPLETE_PROJECT =
      ProjectInfo.newBuilder("complete-project")
          .setName("name")
          .setLabels(ImmutableMap.of("k1", "v1"))
          .setParent(PARENT)
          .build();
  private static final Map<ResourceManagerRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();
  private static final Policy POLICY =
      Policy.newBuilder()
          .addIdentity(Role.owner(), Identity.user("me@gmail.com"))
          .addIdentity(Role.editor(), Identity.serviceAccount("serviceaccount@gmail.com"))
          .build();
  private static final String CURSOR = "cursor";
  private static final String RESOURCE = "folders/my-folder";
  private static final String CONSTRAINTS = "constraints/serviceuser.services";
  private static final String ETAG = "abcd12";
  private static final String UPDATE_TIME = "014-10-02T15:01:23.045123456Z";
  private static final String NAME = "constraints/serviceuser.services";
  private static final String CONSTRAINT_DEFAULT = "ALLOW";
  private static final String DISPLAY_NAME = "constraints-display-name";
  private static final String DESCRIPTION =
      "Detailed description of what this Constraint controls as well as how and where it is enforced";
  private static final Integer VERSION = 1;
  private static final BoolPolicy BOOLEAN_POLICY = new BoolPolicy(true);
  private static final OrgPolicyInfo.Policies LIST_POLICY =
      new OrgPolicyInfo.Policies(
          "allvaluse",
          Arrays.asList("allowedValues"),
          Arrays.asList("deniedValues"),
          true,
          "suggestedValue");
  private static final OrgPolicyInfo ORG_POLICY_INFO =
      OrgPolicyInfo.newBuilder()
          .setBoolPolicy(BOOLEAN_POLICY)
          .setConstraint(CONSTRAINTS)
          .setListPolicy(LIST_POLICY)
          .setEtag(ETAG)
          .setUpdateTime(UPDATE_TIME)
          .setVersion(VERSION)
          .build();
  private static final ConstraintInfo.Constraints LIST_CONSTRAINT =
      new ConstraintInfo.Constraints("suggested-value", true);
  private static final ConstraintInfo CONSTRAINT_INFO =
      ConstraintInfo.newBuilder(NAME)
          .setConstraintDefault(CONSTRAINT_DEFAULT)
          .setDisplayName(DISPLAY_NAME)
          .setDescription(DESCRIPTION)
          .setConstraints(LIST_CONSTRAINT)
          .setVersion(VERSION)
          .build();

  private ResourceManagerRpcFactory rpcFactoryMock = Mockito.mock(ResourceManagerRpcFactory.class);
  private ResourceManagerRpc resourceManagerRpcMock = Mockito.mock(ResourceManagerRpc.class);

  @BeforeClass
  public static void beforeClass() {
    RESOURCE_MANAGER_HELPER.start();
  }

  @Before
  public void setUp() {
    clearProjects();
  }

  private void clearProjects() {
    for (Project project : RESOURCE_MANAGER.list().getValues()) {
      RESOURCE_MANAGER_HELPER.removeProject(project.getProjectId());
    }
  }

  @AfterClass
  public static void afterClass() {
    RESOURCE_MANAGER_HELPER.stop();
  }

  private void compareReadWriteFields(ProjectInfo expected, ProjectInfo actual) {
    assertEquals(expected.getProjectId(), actual.getProjectId());
    assertEquals(expected.getName(), actual.getName());
    assertEquals(expected.getLabels(), actual.getLabels());
    assertEquals(expected.getParent(), actual.getParent());
  }

  @Test
  public void testCreate() {
    Project returnedProject = RESOURCE_MANAGER.create(PARTIAL_PROJECT);
    compareReadWriteFields(PARTIAL_PROJECT, returnedProject);
    assertEquals(ProjectInfo.State.ACTIVE, returnedProject.getState());
    assertNull(returnedProject.getName());
    assertNull(returnedProject.getParent());
    assertNotNull(returnedProject.getProjectNumber());
    assertNotNull(returnedProject.getCreateTimeMillis());
    assertSame(RESOURCE_MANAGER, returnedProject.getResourceManager());
    try {
      RESOURCE_MANAGER.create(PARTIAL_PROJECT);
      fail("Should fail, project already exists.");
    } catch (ResourceManagerException e) {
      assertEquals(409, e.getCode());
      assertTrue(
          e.getMessage().startsWith("A project with the same project ID")
              && e.getMessage().endsWith("already exists."));
    }
    returnedProject = RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    compareReadWriteFields(COMPLETE_PROJECT, returnedProject);
    assertEquals(ProjectInfo.State.ACTIVE, returnedProject.getState());
    assertNotNull(returnedProject.getProjectNumber());
    assertNotNull(returnedProject.getCreateTimeMillis());
    assertSame(RESOURCE_MANAGER, returnedProject.getResourceManager());
  }

  @Test
  public void testDelete() {
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    RESOURCE_MANAGER.delete(COMPLETE_PROJECT.getProjectId());
    assertEquals(
        ProjectInfo.State.DELETE_REQUESTED,
        RESOURCE_MANAGER.get(COMPLETE_PROJECT.getProjectId()).getState());
    try {
      RESOURCE_MANAGER.delete("some-nonexistant-project-id");
      fail("Should fail because the project doesn't exist.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.getCode());
      assertTrue(e.getMessage().contains("not found."));
    }
  }

  @Test
  public void testGet() {
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    Project returnedProject = RESOURCE_MANAGER.get(COMPLETE_PROJECT.getProjectId());
    compareReadWriteFields(COMPLETE_PROJECT, returnedProject);
    assertEquals(RESOURCE_MANAGER, returnedProject.getResourceManager());
    RESOURCE_MANAGER_HELPER.removeProject(COMPLETE_PROJECT.getProjectId());
    assertNull(RESOURCE_MANAGER.get(COMPLETE_PROJECT.getProjectId()));
  }

  @Test
  public void testGetWithOptions() {
    Project originalProject = RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    Project returnedProject = RESOURCE_MANAGER.get(COMPLETE_PROJECT.getProjectId(), GET_FIELDS);
    assertFalse(COMPLETE_PROJECT.equals(returnedProject));
    assertEquals(COMPLETE_PROJECT.getProjectId(), returnedProject.getProjectId());
    assertEquals(COMPLETE_PROJECT.getName(), returnedProject.getName());
    assertEquals(originalProject.getCreateTimeMillis(), returnedProject.getCreateTimeMillis());
    assertNull(returnedProject.getParent());
    assertNull(returnedProject.getProjectNumber());
    assertNull(returnedProject.getState());
    assertTrue(returnedProject.getLabels().isEmpty());
    assertEquals(RESOURCE_MANAGER, originalProject.getResourceManager());
    assertEquals(RESOURCE_MANAGER, returnedProject.getResourceManager());
  }

  @Test
  public void testList() {
    Page<Project> projects = RESOURCE_MANAGER.list();
    assertFalse(projects.getValues().iterator().hasNext());
    RESOURCE_MANAGER.create(PARTIAL_PROJECT);
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    for (Project p : RESOURCE_MANAGER.list().getValues()) {
      if (p.getProjectId().equals(PARTIAL_PROJECT.getProjectId())) {
        compareReadWriteFields(PARTIAL_PROJECT, p);
      } else if (p.getProjectId().equals(COMPLETE_PROJECT.getProjectId())) {
        compareReadWriteFields(COMPLETE_PROJECT, p);
      } else {
        fail("Some unexpected project returned by list.");
      }
      assertSame(RESOURCE_MANAGER, p.getResourceManager());
    }
  }

  @Test
  public void testListPaging() {
    RESOURCE_MANAGER.create(PARTIAL_PROJECT);
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    Page<Project> page = RESOURCE_MANAGER.list(ProjectListOption.pageSize(1));
    assertNotNull(page.getNextPageToken());
    Iterator<Project> iterator = page.getValues().iterator();
    compareReadWriteFields(COMPLETE_PROJECT, iterator.next());
    assertFalse(iterator.hasNext());
    page = page.getNextPage();
    iterator = page.getValues().iterator();
    compareReadWriteFields(PARTIAL_PROJECT, iterator.next());
    assertFalse(iterator.hasNext());
    assertNull(page.getNextPageToken());
  }

  @Test
  public void testListFieldOptions() {
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    Page<Project> projects = RESOURCE_MANAGER.list(LIST_FIELDS);
    Project returnedProject = projects.iterateAll().iterator().next();
    assertEquals(COMPLETE_PROJECT.getProjectId(), returnedProject.getProjectId());
    assertEquals(COMPLETE_PROJECT.getName(), returnedProject.getName());
    assertEquals(COMPLETE_PROJECT.getLabels(), returnedProject.getLabels());
    assertNull(returnedProject.getParent());
    assertNull(returnedProject.getProjectNumber());
    assertNull(returnedProject.getState());
    assertNull(returnedProject.getCreateTimeMillis());
    assertSame(RESOURCE_MANAGER, returnedProject.getResourceManager());
  }

  @Test
  public void testListPagingWithFieldOptions() {
    RESOURCE_MANAGER.create(PARTIAL_PROJECT);
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    Page<Project> projects = RESOURCE_MANAGER.list(LIST_FIELDS, ProjectListOption.pageSize(1));
    assertNotNull(projects.getNextPageToken());
    Iterator<Project> iterator = projects.getValues().iterator();
    Project returnedProject = iterator.next();
    assertEquals(COMPLETE_PROJECT.getProjectId(), returnedProject.getProjectId());
    assertEquals(COMPLETE_PROJECT.getName(), returnedProject.getName());
    assertEquals(COMPLETE_PROJECT.getLabels(), returnedProject.getLabels());
    assertNull(returnedProject.getParent());
    assertNull(returnedProject.getProjectNumber());
    assertNull(returnedProject.getState());
    assertNull(returnedProject.getCreateTimeMillis());
    assertSame(RESOURCE_MANAGER, returnedProject.getResourceManager());
    assertFalse(iterator.hasNext());
    projects = projects.getNextPage();
    iterator = projects.getValues().iterator();
    returnedProject = iterator.next();
    assertEquals(PARTIAL_PROJECT.getProjectId(), returnedProject.getProjectId());
    assertEquals(PARTIAL_PROJECT.getName(), returnedProject.getName());
    assertEquals(PARTIAL_PROJECT.getLabels(), returnedProject.getLabels());
    assertNull(returnedProject.getParent());
    assertNull(returnedProject.getProjectNumber());
    assertNull(returnedProject.getState());
    assertNull(returnedProject.getCreateTimeMillis());
    assertSame(RESOURCE_MANAGER, returnedProject.getResourceManager());
    assertFalse(iterator.hasNext());
    assertNull(projects.getNextPageToken());
  }

  @Test
  public void testListFilterOptions() {
    ProjectInfo matchingProject =
        ProjectInfo.newBuilder("matching-project")
            .setName("MyProject")
            .setLabels(ImmutableMap.of("color", "blue", "size", "big"))
            .build();
    ProjectInfo nonMatchingProject1 =
        ProjectInfo.newBuilder("non-matching-project1")
            .setName("myProject")
            .setLabels(ImmutableMap.of("color", "blue"))
            .build();
    ProjectInfo nonMatchingProject2 =
        ProjectInfo.newBuilder("non-matching-project2")
            .setName("myProj")
            .setLabels(ImmutableMap.of("color", "blue", "size", "big"))
            .build();
    ProjectInfo nonMatchingProject3 = ProjectInfo.newBuilder("non-matching-project3").build();
    RESOURCE_MANAGER.create(matchingProject);
    RESOURCE_MANAGER.create(nonMatchingProject1);
    RESOURCE_MANAGER.create(nonMatchingProject2);
    RESOURCE_MANAGER.create(nonMatchingProject3);
    for (Project p : RESOURCE_MANAGER.list(LIST_FILTER).getValues()) {
      assertFalse(p.equals(nonMatchingProject1));
      assertFalse(p.equals(nonMatchingProject2));
      compareReadWriteFields(matchingProject, p);
      assertSame(RESOURCE_MANAGER, p.getResourceManager());
    }
  }

  @Test
  public void testReplace() {
    ProjectInfo createdProject = RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    Map<String, String> newLabels = ImmutableMap.of("new k1", "new v1");
    ProjectInfo anotherCompleteProject =
        ProjectInfo.newBuilder(COMPLETE_PROJECT.getProjectId())
            .setLabels(newLabels)
            .setProjectNumber(987654321L)
            .setCreateTimeMillis(230682061315L)
            .setState(ProjectInfo.State.DELETE_REQUESTED)
            .setParent(createdProject.getParent())
            .build();
    Project returnedProject = RESOURCE_MANAGER.replace(anotherCompleteProject);
    compareReadWriteFields(anotherCompleteProject, returnedProject);
    assertEquals(createdProject.getProjectNumber(), returnedProject.getProjectNumber());
    assertEquals(createdProject.getCreateTimeMillis(), returnedProject.getCreateTimeMillis());
    assertEquals(createdProject.getState(), returnedProject.getState());
    assertEquals(RESOURCE_MANAGER, returnedProject.getResourceManager());
    ProjectInfo nonexistantProject =
        ProjectInfo.newBuilder("some-project-id-that-does-not-exist").build();
    try {
      RESOURCE_MANAGER.replace(nonexistantProject);
      fail("Should fail because the project doesn't exist.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.getCode());
      assertTrue(e.getMessage().contains("the project was not found"));
    }
  }

  @Test
  public void testUndelete() {
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    RESOURCE_MANAGER.delete(COMPLETE_PROJECT.getProjectId());
    assertEquals(
        ProjectInfo.State.DELETE_REQUESTED,
        RESOURCE_MANAGER.get(COMPLETE_PROJECT.getProjectId()).getState());
    RESOURCE_MANAGER.undelete(COMPLETE_PROJECT.getProjectId());
    ProjectInfo revivedProject = RESOURCE_MANAGER.get(COMPLETE_PROJECT.getProjectId());
    compareReadWriteFields(COMPLETE_PROJECT, revivedProject);
    assertEquals(ProjectInfo.State.ACTIVE, revivedProject.getState());
    try {
      RESOURCE_MANAGER.undelete("invalid-project-id");
      fail("Should fail because the project doesn't exist.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.getCode());
      assertTrue(e.getMessage().contains("the project was not found"));
    }
  }

  @Test
  public void testGetPolicy() {
    assertNull(RESOURCE_MANAGER.getPolicy(COMPLETE_PROJECT.getProjectId()));
    RESOURCE_MANAGER.create(COMPLETE_PROJECT);
    RESOURCE_MANAGER.replacePolicy(COMPLETE_PROJECT.getProjectId(), POLICY);
    Policy retrieved = RESOURCE_MANAGER.getPolicy(COMPLETE_PROJECT.getProjectId());
    assertEquals(POLICY.getBindings(), retrieved.getBindings());
    assertNotNull(retrieved.getEtag());
    assertEquals(0, retrieved.getVersion());
  }

  @Test
  public void testReplacePolicy() {
    try {
      RESOURCE_MANAGER.replacePolicy("nonexistent-project", POLICY);
      fail("Project doesn't exist.");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.getCode());
      assertTrue(e.getMessage().endsWith("project was not found."));
    }
    RESOURCE_MANAGER.create(PARTIAL_PROJECT);
    Policy oldPolicy = RESOURCE_MANAGER.getPolicy(PARTIAL_PROJECT.getProjectId());
    RESOURCE_MANAGER.replacePolicy(PARTIAL_PROJECT.getProjectId(), POLICY);
    try {
      RESOURCE_MANAGER.replacePolicy(PARTIAL_PROJECT.getProjectId(), oldPolicy);
      fail("Policy with an invalid etag didn't cause error.");
    } catch (ResourceManagerException e) {
      assertEquals(409, e.getCode());
      assertTrue(e.getMessage().contains("Policy etag mismatch"));
    }
    String originalEtag = RESOURCE_MANAGER.getPolicy(PARTIAL_PROJECT.getProjectId()).getEtag();
    Policy newPolicy = RESOURCE_MANAGER.replacePolicy(PARTIAL_PROJECT.getProjectId(), POLICY);
    assertEquals(POLICY.getBindings(), newPolicy.getBindings());
    assertNotNull(newPolicy.getEtag());
    assertNotEquals(originalEtag, newPolicy.getEtag());
  }

  @Test
  public void testTestPermissions() {
    List<String> permissions = ImmutableList.of("resourcemanager.projects.get");
    try {
      RESOURCE_MANAGER.testPermissions("nonexistent-project", permissions);
      fail("Nonexistent project");
    } catch (ResourceManagerException e) {
      assertEquals(403, e.getCode());
      assertEquals("Project nonexistent-project not found.", e.getMessage());
    }
    RESOURCE_MANAGER.create(PARTIAL_PROJECT);
    assertEquals(
        ImmutableList.of(true),
        RESOURCE_MANAGER.testPermissions(PARTIAL_PROJECT.getProjectId(), permissions));
  }

  @Test
  public void testRetryableException() {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    String exceptionMessage = "Internal Error";
    doThrow(new ResourceManagerException(500, exceptionMessage))
        .when(resourceManagerRpcMock)
        .get(PARTIAL_PROJECT.getProjectId(), EMPTY_RPC_OPTIONS);
    try {
      resourceManager.get(PARTIAL_PROJECT.getProjectId());
    } catch (ResourceManagerException expected) {
      assertEquals(500, expected.getCode());
      assertEquals(exceptionMessage, expected.getMessage());
    }
  }

  @Test
  public void testNonRetryableException() {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    String exceptionMessage = "Project " + PARTIAL_PROJECT.getProjectId() + " not found.";
    doThrow(new ResourceManagerException(404, exceptionMessage))
        .when(resourceManagerRpcMock)
        .get(PARTIAL_PROJECT.getProjectId(), EMPTY_RPC_OPTIONS);
    try {
      resourceManager.get(PARTIAL_PROJECT.getProjectId());
    } catch (ResourceManagerException expected) {
      assertEquals(404, expected.getCode());
      assertEquals(exceptionMessage, expected.getMessage());
    }
  }

  @Test
  public void testRuntimeException() {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    String exceptionMessage = "Artificial runtime exception";
    doThrow(new RuntimeException(exceptionMessage))
        .when(resourceManagerRpcMock)
        .get(PARTIAL_PROJECT.getProjectId(), EMPTY_RPC_OPTIONS);
    try {
      resourceManager.get(PARTIAL_PROJECT.getProjectId());
    } catch (RuntimeException expected) {
      assertTrue(expected.getMessage().contains(exceptionMessage));
    }
  }

  @Test
  public void testTestOrgPermissions() throws IOException {
    String organization = "organization/12345";
    List<String> permissions =
        ImmutableList.of(
            "resourcemanager.organizations.get", "resourcemanager.organizations.getIamPolicy");
    Map<String, Boolean> expected =
        ImmutableMap.of(
            "resourcemanager.organizations.get",
            true,
            "resourcemanager.organizations.getIamPolicy",
            false);
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    when(resourceManagerRpcMock.testOrgPermissions(organization, permissions)).thenReturn(expected);
    Map<String, Boolean> actual = resourceManager.testOrgPermissions(organization, permissions);
    assertEquals(expected, actual);
    verify(resourceManagerRpcMock).testOrgPermissions(organization, permissions);
  }

  @Test
  public void testTestOrgPermissionsWithResourceManagerException() throws IOException {
    String organization = "organizations/12345";
    String exceptionMessage = "Not Found";
    List<String> permissions =
        ImmutableList.of(
            "resourcemanager.organizations.get", "resourcemanager.organizations.getIamPolicy");
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    doThrow(new ResourceManagerException(404, exceptionMessage))
        .when(resourceManagerRpcMock)
        .testOrgPermissions(organization, permissions);
    try {
      resourceManager.testOrgPermissions(organization, permissions);
    } catch (ResourceManagerException expected) {
      assertEquals(404, expected.getCode());
      assertEquals(exceptionMessage, expected.getMessage());
    }
  }

  @Test
  public void testClearOrgPolicy() throws IOException {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    doNothing().when(resourceManagerRpcMock).clearOrgPolicy(RESOURCE, ORG_POLICY_INFO.toProtobuf());
    resourceManager.clearOrgPolicy(RESOURCE, ORG_POLICY_INFO);
    verify(resourceManagerRpcMock).clearOrgPolicy(RESOURCE, ORG_POLICY_INFO.toProtobuf());
  }

  @Test
  public void testClearOrgPolicyWithResourceManagerException() throws IOException {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    String exceptionMessage = "Should fail because the organization policy doesn't exist.";
    doThrow(new ResourceManagerException(404, exceptionMessage))
        .when(resourceManagerRpcMock)
        .clearOrgPolicy(RESOURCE, ORG_POLICY_INFO.toProtobuf());
    try {
      resourceManager.clearOrgPolicy(RESOURCE, ORG_POLICY_INFO);
    } catch (ResourceManagerException expected) {
      assertEquals(404, expected.getCode());
      assertEquals(exceptionMessage, expected.getMessage());
    }
  }

  @Test
  public void testGetEffectiveOrgPolicy() throws IOException {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    when(resourceManagerRpcMock.getEffectiveOrgPolicy(RESOURCE, CONSTRAINTS))
        .thenReturn(ORG_POLICY_INFO.toProtobuf());
    OrgPolicyInfo policyInfo = resourceManager.getEffectiveOrgPolicy(RESOURCE, CONSTRAINTS);
    assertEquals(CONSTRAINTS, policyInfo.getConstraint());
    assertEquals(BOOLEAN_POLICY, policyInfo.getBoolPolicy());
    assertEquals(ETAG, policyInfo.getEtag());
    assertEquals(LIST_POLICY, policyInfo.getPolicies());
    assertEquals(UPDATE_TIME, policyInfo.getUpdateTime());
    assertEquals(VERSION, policyInfo.getVersion());

    verify(resourceManagerRpcMock).getEffectiveOrgPolicy(RESOURCE, CONSTRAINTS);
  }

  @Test
  public void testGetEffectiveOrgPolicyWithResourceManagerException() throws IOException {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    String exceptionMessage = "Not Found";
    doThrow(new ResourceManagerException(404, exceptionMessage))
        .when(resourceManagerRpcMock)
        .getEffectiveOrgPolicy(RESOURCE, CONSTRAINTS);
    try {
      resourceManager.getEffectiveOrgPolicy(RESOURCE, CONSTRAINTS);
    } catch (ResourceManagerException expected) {
      assertEquals(404, expected.getCode());
      assertEquals(exceptionMessage, expected.getMessage());
    }
  }

  @Test
  public void testGetOrgPolicy() throws IOException {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    when(resourceManagerRpcMock.getOrgPolicy(RESOURCE, CONSTRAINTS))
        .thenReturn(ORG_POLICY_INFO.toProtobuf());
    OrgPolicyInfo policyInfo = resourceManager.getOrgPolicy(RESOURCE, CONSTRAINTS);
    assertEquals(CONSTRAINTS, policyInfo.getConstraint());
    assertEquals(BOOLEAN_POLICY, policyInfo.getBoolPolicy());
    assertEquals(LIST_POLICY, policyInfo.getPolicies());
    assertEquals(UPDATE_TIME, policyInfo.getUpdateTime());
    assertEquals(VERSION, policyInfo.getVersion());

    verify(resourceManagerRpcMock).getOrgPolicy(RESOURCE, CONSTRAINTS);
  }

  @Test
  public void testGetOrgPolicyWithResourceManagerException() throws IOException {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    String exceptionMessage = "Not Found";
    doThrow(new ResourceManagerException(404, exceptionMessage))
        .when(resourceManagerRpcMock)
        .getOrgPolicy(RESOURCE, CONSTRAINTS);
    try {
      resourceManager.getOrgPolicy(RESOURCE, CONSTRAINTS);
    } catch (ResourceManagerException expected) {
      assertEquals(404, expected.getCode());
      assertEquals(exceptionMessage, expected.getMessage());
    }
  }

  @Test
  public void testListAvailableOrgPolicyConstraints() throws IOException {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    ListResult<Constraint> expectedResult =
        ListResult.of(CURSOR, ImmutableList.of(CONSTRAINT_INFO.toProtobuf()));
    when(resourceManagerRpcMock.listAvailableOrgPolicyConstraints(NAME, EMPTY_RPC_OPTIONS))
        .thenReturn(expectedResult);
    Page<ConstraintInfo> page = resourceManager.listAvailableOrgPolicyConstraints(NAME);
    assertEquals(CURSOR, page.getNextPageToken());
    for (ConstraintInfo constraintInfo : page.getValues()) {
      assertEquals(NAME, constraintInfo.getName());
      assertEquals(CONSTRAINT_DEFAULT, constraintInfo.getConstraintDefault());
      assertEquals(DISPLAY_NAME, constraintInfo.getDisplayName());
      assertEquals(DESCRIPTION, constraintInfo.getDescription());
      assertEquals(LIST_CONSTRAINT, constraintInfo.getConstraints());
      assertEquals(VERSION, constraintInfo.getVersion());
    }
    verify(resourceManagerRpcMock).listAvailableOrgPolicyConstraints(NAME, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void listAvailableOrgPolicyConstraintsWithResourceManagerException() throws IOException {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    String exceptionMessage = "Not Found";
    doThrow(new ResourceManagerException(404, exceptionMessage))
        .when(resourceManagerRpcMock)
        .listAvailableOrgPolicyConstraints(RESOURCE, EMPTY_RPC_OPTIONS);
    try {
      resourceManager.listAvailableOrgPolicyConstraints(RESOURCE);
    } catch (ResourceManagerException expected) {
      assertEquals(404, expected.getCode());
      assertEquals(exceptionMessage, expected.getMessage());
    }
  }

  @Test
  public void testListOrgPolicies() throws IOException {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    ListResult<OrgPolicy> expectedResult =
        ListResult.of(CURSOR, ImmutableList.of(ORG_POLICY_INFO.toProtobuf()));
    when(resourceManagerRpcMock.listOrgPolicies(RESOURCE, EMPTY_RPC_OPTIONS))
        .thenReturn(expectedResult);
    Page<OrgPolicyInfo> policies = resourceManager.listOrgPolicies(RESOURCE);
    assertEquals(CURSOR, policies.getNextPageToken());
    for (OrgPolicyInfo orgPolicyInfo : policies.getValues()) {
      assertEquals(CONSTRAINTS, orgPolicyInfo.getConstraint());
      assertEquals(ETAG, orgPolicyInfo.getEtag());
      assertEquals(BOOLEAN_POLICY, orgPolicyInfo.getBoolPolicy());
      assertEquals(LIST_POLICY, orgPolicyInfo.getPolicies());
      assertEquals(UPDATE_TIME, orgPolicyInfo.getUpdateTime());
      assertEquals(VERSION, orgPolicyInfo.getVersion());
    }
    verify(resourceManagerRpcMock).listOrgPolicies(RESOURCE, EMPTY_RPC_OPTIONS);
  }

  @Test
  public void testListOrgPoliciesWithResourceManagerException() throws IOException {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    String exceptionMessage = "Not Found";
    doThrow(new ResourceManagerException(404, exceptionMessage))
        .when(resourceManagerRpcMock)
        .listOrgPolicies(RESOURCE, EMPTY_RPC_OPTIONS);
    try {
      resourceManager.listOrgPolicies(RESOURCE);
    } catch (ResourceManagerException expected) {
      assertEquals(404, expected.getCode());
      assertEquals(exceptionMessage, expected.getMessage());
    }
  }

  @Test
  public void testSetOrgPolicy() throws IOException {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    when(resourceManagerRpcMock.replaceOrgPolicy(RESOURCE, ORG_POLICY_INFO.toProtobuf()))
        .thenReturn(ORG_POLICY_INFO.toProtobuf());
    OrgPolicyInfo policyInfo = resourceManager.replaceOrgPolicy(RESOURCE, ORG_POLICY_INFO);
    assertEquals(CONSTRAINTS, policyInfo.getConstraint());
    assertEquals(BOOLEAN_POLICY, policyInfo.getBoolPolicy());
    assertEquals(LIST_POLICY, policyInfo.getPolicies());
    assertEquals(UPDATE_TIME, policyInfo.getUpdateTime());
    assertEquals(VERSION, policyInfo.getVersion());

    verify(resourceManagerRpcMock).replaceOrgPolicy(RESOURCE, ORG_POLICY_INFO.toProtobuf());
  }

  @Test
  public void testSetOrgPolicyWithResourceManagerException() throws IOException {
    when(rpcFactoryMock.create(Mockito.any(ResourceManagerOptions.class)))
        .thenReturn(resourceManagerRpcMock);
    ResourceManager resourceManager =
        ResourceManagerOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .build()
            .getService();
    String exceptionMessage = "Not Found";
    doThrow(new ResourceManagerException(404, exceptionMessage))
        .when(resourceManagerRpcMock)
        .replaceOrgPolicy(RESOURCE, ORG_POLICY_INFO.toProtobuf());
    try {
      resourceManager.replaceOrgPolicy(RESOURCE, ORG_POLICY_INFO);
    } catch (ResourceManagerException expected) {
      assertEquals(404, expected.getCode());
      assertEquals(exceptionMessage, expected.getMessage());
    }
  }
}
