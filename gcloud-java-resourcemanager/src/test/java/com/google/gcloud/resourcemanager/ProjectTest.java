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

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

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
  private static final ProjectInfo.State STATE = ProjectInfo.State.DELETE_REQUESTED;
  private static final ProjectInfo PROJECT_INFO = ProjectInfo.builder(PROJECT_ID)
      .name(NAME)
      .labels(LABELS)
      .projectNumber(PROJECT_NUMBER)
      .createTimeMillis(CREATE_TIME_MILLIS)
      .state(STATE)
      .build();

  private ResourceManager resourceManager;
  private Project project;

  @Before
  public void setUp() throws Exception {
    resourceManager = createStrictMock(ResourceManager.class);
    project = new Project(resourceManager, PROJECT_INFO);
  }

  @After
  public void tearDown() throws Exception {
    verify(resourceManager);
  }

  @Test
  public void testLoad() {
    expect(resourceManager.get(PROJECT_INFO.projectId())).andReturn(PROJECT_INFO);
    replay(resourceManager);
    Project loadedProject = Project.load(resourceManager, PROJECT_INFO.projectId());
    assertEquals(PROJECT_INFO, loadedProject.info());
  }

  @Test
  public void testReload() {
    ProjectInfo newInfo = PROJECT_INFO.toBuilder().addLabel("k3", "v3").build();
    expect(resourceManager.get(PROJECT_INFO.projectId())).andReturn(newInfo);
    replay(resourceManager);
    Project newProject = project.reload();
    assertSame(resourceManager, newProject.resourceManager());
    assertEquals(newInfo, newProject.info());
  }

  @Test
  public void testLoadNull() {
    expect(resourceManager.get(PROJECT_INFO.projectId())).andReturn(null);
    replay(resourceManager);
    assertNull(Project.load(resourceManager, PROJECT_INFO.projectId()));
  }

  @Test
  public void testReloadDeletedProject() {
    expect(resourceManager.get(PROJECT_INFO.projectId())).andReturn(PROJECT_INFO);
    expect(resourceManager.get(PROJECT_INFO.projectId())).andReturn(null);
    replay(resourceManager);
    Project loadedProject = Project.load(resourceManager, PROJECT_INFO.projectId());
    assertNotNull(loadedProject);
    Project reloadedProject = loadedProject.reload();
    assertNull(reloadedProject);
  }

  @Test
  public void testInfo() {
    replay(resourceManager);
    assertEquals(PROJECT_INFO, project.info());
  }

  @Test
  public void testResourceManager() {
    replay(resourceManager);
    assertEquals(resourceManager, project.resourceManager());
  }

  @Test
  public void testDelete() {
    resourceManager.delete(PROJECT_INFO.projectId());
    replay(resourceManager);
    project.delete();
  }

  @Test
  public void testUndelete() {
    resourceManager.undelete(PROJECT_INFO.projectId());
    replay(resourceManager);
    project.undelete();
  }

  @Test
  public void testReplace() {
    ProjectInfo newInfo = PROJECT_INFO.toBuilder().addLabel("k3", "v3").build();
    expect(resourceManager.replace(newInfo)).andReturn(newInfo);
    replay(resourceManager);
    Project newProject = project.replace(newInfo);
    assertSame(resourceManager, newProject.resourceManager());
    assertEquals(newInfo, newProject.info());
  }
}
