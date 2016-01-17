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

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class ProjectTest {
  private static final String PROJECT_ID = "project-id";
  private static final String NAME = "myProj";
  private static final Map<String, String> LABELS = ImmutableMap.of("k1", "v1", "k2", "v2");
  private static final Long PROJECT_NUMBER = 123L;
  private static final Long CREATE_TIME_MILLIS = 123456789L;
  private static final Project.State STATE = Project.State.DELETE_REQUESTED;
  private static final Project.ResourceId PARENT = new Project.ResourceId("id", "organization");
  private ResourceManager resourceManager;
  private Project fullProject;
  private Project fullProjectFromConstructor;
  private Project partialProject;
  private Project unnamedProjectFromList;

  private void initializeProjects() {
    fullProject =
        Project.builder(resourceManager, PROJECT_ID)
        .name(NAME)
        .labels(LABELS)
        .projectNumber(PROJECT_NUMBER)
        .createTimeMillis(CREATE_TIME_MILLIS)
        .state(STATE)
        .parent(PARENT)
        .build();
    partialProject = Project.builder(resourceManager, PROJECT_ID).build();
    unnamedProjectFromList = partialProject.toBuilder().name("Unnamed").build();
  }

  @Before
  public void setup() {
    resourceManager = createMock(ResourceManager.class);
    fullProjectFromConstructor = new Project(NAME, PROJECT_ID, LABELS, PROJECT_NUMBER, STATE,
        CREATE_TIME_MILLIS, PARENT, null, resourceManager);
    expect(resourceManager.options()).andReturn(null).anyTimes();
  }

  @After
  public void tearDown() throws Exception {
    verify(resourceManager);
  }

  @Test
  public void testBuilder() {
    replay(resourceManager);
    initializeProjects();
    assertEquals(PROJECT_ID, fullProject.projectId());
    assertEquals(NAME, fullProject.name());
    assertEquals(LABELS, fullProject.labels());
    assertEquals(PROJECT_NUMBER, fullProject.projectNumber());
    assertEquals(CREATE_TIME_MILLIS, fullProject.createTimeMillis());
    assertEquals(STATE, fullProject.state());
    assertEquals(PARENT, fullProject.parent());
    assertEquals(resourceManager.options(), fullProject.resourceManager().options());

    assertEquals(PROJECT_ID, partialProject.projectId());
    assertEquals(null, partialProject.name());
    assertTrue(partialProject.labels().isEmpty());
    assertEquals(null, partialProject.projectNumber());
    assertEquals(null, partialProject.createTimeMillis());
    assertEquals(null, partialProject.state());
    assertEquals(null, partialProject.parent());
    assertEquals(resourceManager.options(), partialProject.resourceManager().options());
  }

  @Test
  public void testToBuilder() {
    replay(resourceManager);
    initializeProjects();
    compareProjects(fullProject, fullProject.toBuilder().build());
    compareProjects(partialProject, partialProject.toBuilder().build());
  }

  @Test
  public void testToAndFromPb() {
    replay(resourceManager);
    initializeProjects();
    assertTrue(fullProject.toPb().getCreateTime().endsWith("Z"));
    compareProjects(fullProject, Project.fromPb(resourceManager, fullProject.toPb()));
    compareProjects(partialProject, Project.fromPb(resourceManager, partialProject.toPb()));
    compareProjects(partialProject, Project.fromPb(resourceManager, unnamedProjectFromList.toPb()));
  }

  @Test
  public void testEquals() {
    replay(resourceManager);
    initializeProjects();
    compareProjects(
        fullProject,
        Project.builder(resourceManager, PROJECT_ID)
            .name(NAME)
            .labels(LABELS)
            .projectNumber(PROJECT_NUMBER)
            .createTimeMillis(CREATE_TIME_MILLIS)
            .state(STATE)
            .parent(PARENT)
            .build());
    compareProjects(partialProject, Project.builder(resourceManager, PROJECT_ID).build());
    assertNotEquals(fullProject, partialProject);
  }

  @Test
  public void testCreate() {
    expect(resourceManager.get(PROJECT_ID)).andReturn(fullProjectFromConstructor);
    replay(resourceManager);
    initializeProjects();
    Project loadedProject = Project.get(resourceManager, fullProject.projectId());
    assertEquals(fullProject, loadedProject);
  }

  @Test
  public void testGet() {
    expect(resourceManager.get(PROJECT_ID)).andReturn(fullProjectFromConstructor);
    replay(resourceManager);
    initializeProjects();
    Project loadedProject = Project.get(resourceManager, fullProject.projectId());
    assertEquals(fullProject, loadedProject);
  }

  @Test
  public void testReload() {
    Map<String, String> newLabels = ImmutableMap.of("k1", "v1", "k2", "v2", "k3", "v3");
    Project project = new Project(NAME, PROJECT_ID, newLabels, PROJECT_NUMBER, STATE,
        CREATE_TIME_MILLIS, PARENT, null, resourceManager);
    expect(resourceManager.get(PROJECT_ID)).andReturn(project);
    replay(resourceManager);
    initializeProjects();
    Project newProject = project.reload();
    assertSame(resourceManager, newProject.resourceManager());
    assertEquals(project, newProject);
  }

  @Test
  public void testGetNull() {
    expect(resourceManager.get(PROJECT_ID)).andReturn(null);
    replay(resourceManager);
    initializeProjects();
    assertNull(Project.get(resourceManager, fullProject.projectId()));
  }

  @Test
  public void testReloadDeletedProject() {
    expect(resourceManager.get(PROJECT_ID)).andReturn(fullProjectFromConstructor);
    expect(resourceManager.get(PROJECT_ID)).andReturn(null);
    replay(resourceManager);
    initializeProjects();
    Project loadedProject = Project.get(resourceManager, fullProject.projectId());
    assertNotNull(loadedProject);
    Project reloadedProject = loadedProject.reload();
    assertNull(reloadedProject);
  }

  @Test
  public void testResourceManager() {
    replay(resourceManager);
    initializeProjects();
    assertEquals(resourceManager, fullProject.resourceManager());
  }

  @Test
  public void testDelete() {
    resourceManager.delete(PROJECT_ID);
    replay(resourceManager);
    initializeProjects();
    fullProject.delete();
  }

  @Test
  public void testUndelete() {
    resourceManager.undelete(PROJECT_ID);
    replay(resourceManager);
    initializeProjects();
    fullProject.undelete();
  }

  @Test
  public void testReplace() {
    Map<String, String> newLabels = ImmutableMap.of("k1", "v1", "k2", "v2", "k3", "v3");
    Project expected = new Project(NAME, PROJECT_ID, newLabels, PROJECT_NUMBER, STATE,
        CREATE_TIME_MILLIS, PARENT, null, resourceManager);
    expect(resourceManager.replace(expected)).andReturn(expected);
    replay(resourceManager);
    initializeProjects();
    Project actual = expected.replace(expected);
    assertSame(resourceManager, actual.resourceManager());
    compareProjects(expected, actual);
  }

  private void compareProjects(Project expected, Project value) {
    assertEquals(expected, value);
    assertEquals(expected.projectId(), value.projectId());
    assertEquals(expected.name(), value.name());
    assertEquals(expected.labels(), value.labels());
    assertEquals(expected.projectNumber(), value.projectNumber());
    assertEquals(expected.createTimeMillis(), value.createTimeMillis());
    assertEquals(expected.state(), value.state());
    assertEquals(expected.parent(), value.parent());
    assertEquals(expected.resourceManager().options(), value.resourceManager().options());
  }
}
