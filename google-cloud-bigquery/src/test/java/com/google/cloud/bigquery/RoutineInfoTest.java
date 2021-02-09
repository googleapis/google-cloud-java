/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class RoutineInfoTest {

  private static final RoutineId ROUTINE_ID = RoutineId.of("dataset", "routine");
  private static final String ETAG = "etag";
  private static final String ROUTINE_TYPE = "SCALAR_FUNCTION";
  private static final Long CREATION_TIME = 10L;
  private static final String DESCRIPTION = "description";
  private static final String DETERMINISM = "DETERMINISTIC";
  private static final Long LAST_MODIFIED_TIME = 20L;
  private static final String LANGUAGE = "SQL";

  private static final RoutineArgument ARG_1 =
      RoutineArgument.newBuilder()
          .setDataType(StandardSQLDataType.newBuilder("STRING").build())
          .setName("arg1")
          .build();

  private static final List<RoutineArgument> ARGUMENT_LIST = ImmutableList.of(ARG_1);

  private static final StandardSQLDataType RETURN_TYPE =
      StandardSQLDataType.newBuilder("FLOAT64").build();

  private static final List<String> IMPORTED_LIBRARIES =
      ImmutableList.of("gs://foo", "gs://bar", "gs://baz");

  private static final String BODY = "body";

  private static final RoutineInfo ROUTINE_INFO =
      RoutineInfo.of(ROUTINE_ID)
          .toBuilder()
          .setEtag(ETAG)
          .setRoutineType(ROUTINE_TYPE)
          .setCreationTime(CREATION_TIME)
          .setDescription(DESCRIPTION)
          .setDeterminismLevel(DETERMINISM)
          .setLastModifiedTime(LAST_MODIFIED_TIME)
          .setLanguage(LANGUAGE)
          .setArguments(ARGUMENT_LIST)
          .setReturnType(RETURN_TYPE)
          .setImportedLibraries(IMPORTED_LIBRARIES)
          .setBody(BODY)
          .build();

  @Test
  public void testToBuilder() {
    compareRoutineInfo(ROUTINE_INFO, ROUTINE_INFO.toBuilder().build());
  }

  @Test
  public void testBuilderIncomplete() {
    RoutineInfo routineInfo = RoutineInfo.of(ROUTINE_ID);
    assertEquals(routineInfo, routineInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(ROUTINE_ID, ROUTINE_INFO.getRoutineId());
    assertEquals(ETAG, ROUTINE_INFO.getEtag());
    assertEquals(ROUTINE_TYPE, ROUTINE_INFO.getRoutineType());
    assertEquals(CREATION_TIME, ROUTINE_INFO.getCreationTime());
    assertEquals(DESCRIPTION, ROUTINE_INFO.getDescription());
    assertEquals(DETERMINISM, ROUTINE_INFO.getDeterminismLevel());
    assertEquals(LAST_MODIFIED_TIME, ROUTINE_INFO.getLastModifiedTime());
    assertEquals(LANGUAGE, ROUTINE_INFO.getLanguage());
    assertEquals(ARGUMENT_LIST, ROUTINE_INFO.getArguments());
    assertEquals(RETURN_TYPE, ROUTINE_INFO.getReturnType());
    assertEquals(IMPORTED_LIBRARIES, ROUTINE_INFO.getImportedLibraries());
    assertEquals(BODY, ROUTINE_INFO.getBody());
  }

  @Test
  public void testOf() {
    RoutineInfo routineInfo = RoutineInfo.of(ROUTINE_ID);
    assertEquals(ROUTINE_ID, ROUTINE_INFO.getRoutineId());
    assertNull(routineInfo.getEtag());
    assertNull(routineInfo.getRoutineType());
    assertNull(routineInfo.getCreationTime());
    assertNull(routineInfo.getDescription());
    assertNull(routineInfo.getDeterminismLevel());
    assertNull(routineInfo.getLastModifiedTime());
    assertNull(routineInfo.getLanguage());
    assertNull(routineInfo.getArguments());
    assertNull(routineInfo.getReturnType());
    assertNull(routineInfo.getImportedLibraries());
    assertNull(routineInfo.getBody());
  }

  public void testToAndFromPb() {
    compareRoutineInfo(ROUTINE_INFO, RoutineInfo.fromPb(ROUTINE_INFO.toPb()));
  }

  @Test
  public void testSetProjectId() {
    assertEquals("project", ROUTINE_INFO.setProjectId("project").getRoutineId().getProject());
  }

  public void compareRoutineInfo(RoutineInfo expected, RoutineInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getRoutineId(), value.getRoutineId());
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getRoutineType(), value.getRoutineType());
    assertEquals(expected.getCreationTime(), value.getCreationTime());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getDeterminismLevel(), value.getDeterminismLevel());
    assertEquals(expected.getLastModifiedTime(), value.getLastModifiedTime());
    assertEquals(expected.getLanguage(), value.getLanguage());
    assertEquals(expected.getArguments(), value.getArguments());
    assertEquals(expected.getReturnType(), value.getReturnType());
    assertEquals(expected.getImportedLibraries(), value.getImportedLibraries());
    assertEquals(expected.getBody(), value.getBody());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
  }
}
