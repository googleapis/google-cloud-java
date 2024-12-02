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

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.resourcemanager.ProjectInfo.ResourceId;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProjectTest {
  private static final String PROJECT_ID = "project-id";
  private static final String NAME = "myProj";
  private static final Map<String, String> LABELS = ImmutableMap.of("k1", "v1", "k2", "v2");
  private static final Long PROJECT_NUMBER = 123L;
  private static final Long CREATE_TIME_MILLIS = 123456789L;
  private static final ProjectInfo.State STATE = ProjectInfo.State.DELETE_REQUESTED;
  private static final ProjectInfo PROJECT_INFO =
      ProjectInfo.newBuilder(PROJECT_ID)
          .setName(NAME)
          .setLabels(LABELS)
          .setProjectNumber(PROJECT_NUMBER)
          .setCreateTimeMillis(CREATE_TIME_MILLIS)
          .setState(STATE)
          .build();
  private static final Identity USER = Identity.user("abc@gmail.com");
  private static final Identity SERVICE_ACCOUNT =
      Identity.serviceAccount("service-account@gmail.com");
  private static final Policy POLICY =
      Policy.newBuilder()
          .addIdentity(Role.owner(), USER)
          .addIdentity(Role.editor(), SERVICE_ACCOUNT)
          .build();

  private ResourceManager serviceMockReturnsOptions = createStrictMock(ResourceManager.class);
  private ResourceManagerOptions mockOptions = createMock(ResourceManagerOptions.class);
  private ResourceManager resourceManager;
  private Project expectedProject;
  private Project project;

  @Before
  public void setUp() {
    resourceManager = createStrictMock(ResourceManager.class);
  }

  @After
  public void tearDown() throws Exception {
    verify(resourceManager);
  }

  private void initializeExpectedProject(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    expectedProject =
        new Project(serviceMockReturnsOptions, new ProjectInfo.BuilderImpl(PROJECT_INFO));
  }

  private void initializeProject() {
    project = new Project(resourceManager, new ProjectInfo.BuilderImpl(PROJECT_INFO));
  }

  @Test
  public void testToBuilder() {
    initializeExpectedProject(4);
    replay(resourceManager);
    compareProjects(expectedProject, expectedProject.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    expect(resourceManager.getOptions()).andReturn(mockOptions).times(7);
    replay(resourceManager);
    Project.Builder builder =
        new Project.Builder(new Project(resourceManager, new ProjectInfo.BuilderImpl("wrong-id")));
    Project project =
        builder
            .setProjectId(PROJECT_ID)
            .setName(NAME)
            .setLabels(LABELS)
            .setProjectNumber(PROJECT_NUMBER)
            .setCreateTimeMillis(CREATE_TIME_MILLIS)
            .setState(STATE)
            .build();
    assertEquals(PROJECT_ID, project.getProjectId());
    assertEquals(NAME, project.getName());
    assertEquals(LABELS, project.getLabels());
    assertEquals(PROJECT_NUMBER, project.getProjectNumber());
    assertEquals(CREATE_TIME_MILLIS, project.getCreateTimeMillis());
    assertEquals(STATE, project.getState());
    assertEquals(resourceManager.getOptions(), project.getResourceManager().getOptions());
    assertNull(project.getParent());
    ResourceId parent = new ResourceId("id", "type");
    project =
        project
            .toBuilder()
            .clearLabels()
            .addLabel("k3", "v3")
            .addLabel("k4", "v4")
            .removeLabel("k4")
            .setParent(parent)
            .build();
    assertEquals(PROJECT_ID, project.getProjectId());
    assertEquals(NAME, project.getName());
    assertEquals(ImmutableMap.of("k3", "v3"), project.getLabels());
    assertEquals(PROJECT_NUMBER, project.getProjectNumber());
    assertEquals(CREATE_TIME_MILLIS, project.getCreateTimeMillis());
    assertEquals(STATE, project.getState());
    assertEquals(resourceManager.getOptions(), project.getResourceManager().getOptions());
    assertEquals(parent, project.getParent());
  }

  @Test
  public void testGet() {
    initializeExpectedProject(1);
    expect(resourceManager.get(PROJECT_INFO.getProjectId())).andReturn(expectedProject);
    replay(resourceManager);
    Project loadedProject = resourceManager.get(PROJECT_INFO.getProjectId());
    assertEquals(expectedProject, loadedProject);
  }

  @Test
  public void testReload() {
    initializeExpectedProject(2);
    ProjectInfo newInfo = PROJECT_INFO.toBuilder().addLabel("k3", "v3").build();
    Project expectedProject =
        new Project(serviceMockReturnsOptions, new ProjectInfo.BuilderImpl(newInfo));
    expect(resourceManager.getOptions()).andReturn(mockOptions);
    expect(resourceManager.get(PROJECT_INFO.getProjectId())).andReturn(expectedProject);
    replay(resourceManager);
    initializeProject();
    Project newProject = project.reload();
    assertEquals(expectedProject, newProject);
  }

  @Test
  public void testLoadNull() {
    initializeExpectedProject(1);
    expect(resourceManager.get(PROJECT_INFO.getProjectId())).andReturn(null);
    replay(resourceManager);
    assertNull(resourceManager.get(PROJECT_INFO.getProjectId()));
  }

  @Test
  public void testReloadNull() {
    initializeExpectedProject(1);
    expect(resourceManager.getOptions()).andReturn(mockOptions);
    expect(resourceManager.get(PROJECT_INFO.getProjectId())).andReturn(null);
    replay(resourceManager);
    Project reloadedProject =
        new Project(resourceManager, new ProjectInfo.BuilderImpl(PROJECT_INFO)).reload();
    assertNull(reloadedProject);
  }

  @Test
  public void testResourceManager() {
    initializeExpectedProject(1);
    replay(resourceManager);
    assertEquals(serviceMockReturnsOptions, expectedProject.getResourceManager());
  }

  @Test
  public void testDelete() {
    initializeExpectedProject(1);
    expect(resourceManager.getOptions()).andReturn(mockOptions);
    resourceManager.delete(PROJECT_INFO.getProjectId());
    replay(resourceManager);
    initializeProject();
    project.delete();
  }

  @Test
  public void testUndelete() {
    initializeExpectedProject(1);
    expect(resourceManager.getOptions()).andReturn(mockOptions);
    resourceManager.undelete(PROJECT_INFO.getProjectId());
    replay(resourceManager);
    initializeProject();
    project.undelete();
  }

  @Test
  public void testReplace() {
    initializeExpectedProject(2);
    Project expectedReplacedProject = expectedProject.toBuilder().addLabel("k3", "v3").build();
    expect(resourceManager.getOptions()).andReturn(mockOptions).times(2);
    expect(resourceManager.replace(anyObject(Project.class))).andReturn(expectedReplacedProject);
    replay(resourceManager);
    initializeProject();
    Project newProject =
        new Project(resourceManager, new ProjectInfo.BuilderImpl(expectedReplacedProject));
    Project actualReplacedProject = newProject.replace();
    compareProjectInfos(expectedReplacedProject, actualReplacedProject);
  }

  @Test
  public void testGetPolicy() {
    expect(resourceManager.getOptions()).andReturn(mockOptions).times(1);
    expect(resourceManager.getPolicy(PROJECT_ID)).andReturn(POLICY);
    replay(resourceManager);
    initializeProject();
    assertEquals(POLICY, project.getPolicy());
  }

  @Test
  public void testReplacePolicy() {
    expect(resourceManager.getOptions()).andReturn(mockOptions).times(1);
    expect(resourceManager.replacePolicy(PROJECT_ID, POLICY)).andReturn(POLICY);
    replay(resourceManager);
    initializeProject();
    assertEquals(POLICY, project.replacePolicy(POLICY));
  }

  @Test
  public void testTestPermissions() {
    List<Boolean> response = ImmutableList.of(true, true);
    String getPermission = "resourcemanager.projects.get";
    String deletePermission = "resourcemanager.projects.delete";
    expect(resourceManager.getOptions()).andReturn(mockOptions).times(1);
    expect(
            resourceManager.testPermissions(
                PROJECT_ID, ImmutableList.of(getPermission, deletePermission)))
        .andReturn(response);
    replay(resourceManager);
    initializeProject();
    assertEquals(
        response, project.testPermissions(ImmutableList.of(getPermission, deletePermission)));
  }

  private void compareProjects(Project expected, Project value) {
    assertEquals(expected, value);
    compareProjectInfos(expected, value);
    assertEquals(
        expected.getResourceManager().getOptions(), value.getResourceManager().getOptions());
  }

  private void compareProjectInfos(ProjectInfo expected, ProjectInfo value) {
    assertEquals(expected.getProjectId(), value.getProjectId());
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getLabels(), value.getLabels());
    assertEquals(expected.getProjectNumber(), value.getProjectNumber());
    assertEquals(expected.getCreateTimeMillis(), value.getCreateTimeMillis());
    assertEquals(expected.getState(), value.getState());
    assertEquals(expected.getParent(), value.getParent());
  }
}
