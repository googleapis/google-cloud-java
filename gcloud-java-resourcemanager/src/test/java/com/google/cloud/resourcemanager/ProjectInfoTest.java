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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.util.Map;

public class ProjectInfoTest {

  private static final String PROJECT_ID = "project-id";
  private static final String NAME = "myProj";
  private static final Map<String, String> LABELS = ImmutableMap.of("k1", "v1", "k2", "v2");
  private static final Long PROJECT_NUMBER = 123L;
  private static final Long CREATE_TIME_MILLIS = 123456789L;
  private static final ProjectInfo.State STATE = ProjectInfo.State.DELETE_REQUESTED;
  private static final ProjectInfo.ResourceId PARENT =
      new ProjectInfo.ResourceId("id", "organization");
  private static final ProjectInfo FULL_PROJECT_INFO = ProjectInfo.builder(PROJECT_ID)
      .name(NAME)
      .labels(LABELS)
      .projectNumber(PROJECT_NUMBER)
      .createTimeMillis(CREATE_TIME_MILLIS)
      .state(STATE)
      .parent(PARENT)
      .build();
  private static final ProjectInfo PARTIAL_PROJECT_INFO = ProjectInfo.builder(PROJECT_ID).build();
  private static final ProjectInfo UNNAMED_PROJECT_FROM_LIST =
      PARTIAL_PROJECT_INFO.toBuilder().name("Unnamed").build();

  @Test
  public void testBuilder() {
    assertEquals(PROJECT_ID, FULL_PROJECT_INFO.projectId());
    assertEquals(NAME, FULL_PROJECT_INFO.name());
    assertEquals(LABELS, FULL_PROJECT_INFO.labels());
    assertEquals(PROJECT_NUMBER, FULL_PROJECT_INFO.projectNumber());
    assertEquals(CREATE_TIME_MILLIS, FULL_PROJECT_INFO.createTimeMillis());
    assertEquals(STATE, FULL_PROJECT_INFO.state());

    assertEquals(PROJECT_ID, PARTIAL_PROJECT_INFO.projectId());
    assertEquals(null, PARTIAL_PROJECT_INFO.name());
    assertTrue(PARTIAL_PROJECT_INFO.labels().isEmpty());
    assertEquals(null, PARTIAL_PROJECT_INFO.projectNumber());
    assertEquals(null, PARTIAL_PROJECT_INFO.createTimeMillis());
    assertEquals(null, PARTIAL_PROJECT_INFO.state());
  }

  @Test
  public void testToBuilder() {
    compareProjects(FULL_PROJECT_INFO, FULL_PROJECT_INFO.toBuilder().build());
    compareProjects(PARTIAL_PROJECT_INFO, PARTIAL_PROJECT_INFO.toBuilder().build());
  }

  @Test
  public void testToAndFromPb() {
    assertTrue(FULL_PROJECT_INFO.toPb().getCreateTime().endsWith("Z"));
    compareProjects(FULL_PROJECT_INFO, ProjectInfo.fromPb(FULL_PROJECT_INFO.toPb()));
    compareProjects(PARTIAL_PROJECT_INFO, ProjectInfo.fromPb(PARTIAL_PROJECT_INFO.toPb()));
    compareProjects(PARTIAL_PROJECT_INFO, ProjectInfo.fromPb(UNNAMED_PROJECT_FROM_LIST.toPb()));
  }

  @Test
  public void testEquals() {
    compareProjects(
        FULL_PROJECT_INFO,
        ProjectInfo.builder(PROJECT_ID)
            .name(NAME)
            .labels(LABELS)
            .projectNumber(PROJECT_NUMBER)
            .createTimeMillis(CREATE_TIME_MILLIS)
            .state(STATE)
            .parent(PARENT)
            .build());
    compareProjects(PARTIAL_PROJECT_INFO, ProjectInfo.builder(PROJECT_ID).build());
    assertNotEquals(FULL_PROJECT_INFO, PARTIAL_PROJECT_INFO);
  }

  private void compareProjects(ProjectInfo expected, ProjectInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.projectId(), value.projectId());
    assertEquals(expected.name(), value.name());
    assertEquals(expected.labels(), value.labels());
    assertEquals(expected.projectNumber(), value.projectNumber());
    assertEquals(expected.createTimeMillis(), value.createTimeMillis());
    assertEquals(expected.state(), value.state());
    assertEquals(expected.parent(), value.parent());
  }
}

