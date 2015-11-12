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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ProjectInfoTest {

  private static final String ID = "project-id";
  private static final String NAME = "myProj";
  private static final Map<String, String> LABELS = new HashMap<String, String>();
  static {
    LABELS.put("k1", "v1");
    LABELS.put("k2", "k2");
  }
  private static final Long NUMBER = 123L;
  private static final Long CREATE_TIME_MILLIS = 123456789L;
  private static final ProjectInfo.State STATE = ProjectInfo.State.DELETE_REQUESTED;
  private static final ResourceId PARENT = ResourceId.of("owner-id", ResourceId.Type.ORGANIZATION);
  private static final ProjectInfo FULL_PROJECT_INFO =
      ProjectInfo.builder(ID)
          .name(NAME)
          .labels(LABELS)
          .number(NUMBER)
          .createTimeMillis(CREATE_TIME_MILLIS)
          .state(STATE)
          .parent(PARENT)
          .build();
  private static final ProjectInfo PARTIAL_PROJECT_INFO = ProjectInfo.builder(ID).build();

  @Test
  public void testBuilder() {
    assertEquals(ID, FULL_PROJECT_INFO.id());
    assertEquals(NAME, FULL_PROJECT_INFO.name());
    assertEquals(LABELS, FULL_PROJECT_INFO.labels());
    assertEquals(NUMBER, FULL_PROJECT_INFO.number());
    assertEquals(CREATE_TIME_MILLIS, FULL_PROJECT_INFO.createTimeMillis());
    assertEquals(STATE, FULL_PROJECT_INFO.state());
    assertEquals(PARENT, FULL_PROJECT_INFO.parent());
  }

  @Test
  public void testToBuilder() {
    assertEquals(FULL_PROJECT_INFO, FULL_PROJECT_INFO.toBuilder().build());
    assertEquals(PARTIAL_PROJECT_INFO, PARTIAL_PROJECT_INFO.toBuilder().build());
  }

  @Test
  public void testToAndFromPb() {
    assertEquals(FULL_PROJECT_INFO, ProjectInfo.fromPb(FULL_PROJECT_INFO.toPb()));
    assertEquals(PARTIAL_PROJECT_INFO, ProjectInfo.fromPb(PARTIAL_PROJECT_INFO.toPb()));
  }
}

