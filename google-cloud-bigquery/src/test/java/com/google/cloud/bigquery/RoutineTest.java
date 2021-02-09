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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

@RunWith(MockitoJUnitRunner.class)
public class RoutineTest {

  private static final RoutineId ROUTINE_ID = RoutineId.of("dataset", "routine");
  private static final String DETERMINISM_LEVEL = "DETERMINISTIC";
  private static final String ETAG = "etag";
  private static final String ROUTINE_TYPE = "SCALAR_FUNCTION";
  private static final Long CREATION_TIME = 10L;
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
      RoutineInfo.newBuilder(ROUTINE_ID)
          .setEtag(ETAG)
          .setRoutineType(ROUTINE_TYPE)
          .setCreationTime(CREATION_TIME)
          .setDeterminismLevel(DETERMINISM_LEVEL)
          .setLastModifiedTime(LAST_MODIFIED_TIME)
          .setLanguage(LANGUAGE)
          .setArguments(ARGUMENT_LIST)
          .setReturnType(RETURN_TYPE)
          .setImportedLibraries(IMPORTED_LIBRARIES)
          .setBody(BODY)
          .build();

  @Rule public MockitoRule rule;

  private BigQuery bigquery;
  private BigQueryOptions mockOptions;
  private Routine expectedRoutine;
  private Routine routine;

  @Before
  public void setUp() {
    bigquery = mock(BigQuery.class);
    mockOptions = mock(BigQueryOptions.class);
    when(bigquery.getOptions()).thenReturn(mockOptions);
    expectedRoutine = new Routine(bigquery, new RoutineInfo.BuilderImpl(ROUTINE_INFO));
    routine = new Routine(bigquery, new RoutineInfo.BuilderImpl(ROUTINE_INFO));
  }

  @Test
  public void testBuilder() {
    Routine builtRoutine =
        new Routine.Builder(bigquery, ROUTINE_ID)
            .setEtag(ETAG)
            .setRoutineType(ROUTINE_TYPE)
            .setCreationTime(CREATION_TIME)
            .setDeterminismLevel(DETERMINISM_LEVEL)
            .setLastModifiedTime(LAST_MODIFIED_TIME)
            .setLanguage(LANGUAGE)
            .setArguments(ARGUMENT_LIST)
            .setReturnType(RETURN_TYPE)
            .setImportedLibraries(IMPORTED_LIBRARIES)
            .setBody(BODY)
            .build();
    assertEquals(ETAG, builtRoutine.getEtag());
    assertEquals(DETERMINISM_LEVEL, builtRoutine.getDeterminismLevel());
    assertSame(bigquery, builtRoutine.getBigQuery());
  }

  @Test
  public void testToBuilder() {
    compareRoutineInfo(expectedRoutine, expectedRoutine.toBuilder().build());
  }

  @Test
  public void testExists_True() {
    BigQuery.RoutineOption[] expectedOptions = {BigQuery.RoutineOption.fields()};
    when(bigquery.getRoutine(ROUTINE_INFO.getRoutineId(), expectedOptions)).thenReturn(null);
    assertFalse(routine.exists());
    verify(bigquery).getRoutine(ROUTINE_INFO.getRoutineId(), expectedOptions);
  }

  @Test
  public void testExists_False() {
    BigQuery.RoutineOption[] expectedOptions = {BigQuery.RoutineOption.fields()};
    when(bigquery.getRoutine(ROUTINE_INFO.getRoutineId(), expectedOptions))
        .thenReturn(expectedRoutine);
    assertTrue(routine.exists());
    verify(bigquery).getRoutine(ROUTINE_INFO.getRoutineId(), expectedOptions);
  }

  @Test
  public void testReload() {
    RoutineInfo updatedInfo = ROUTINE_INFO.toBuilder().setBody("body2").build();
    Routine expectedRoutine = new Routine(bigquery, new RoutineInfo.BuilderImpl(updatedInfo));
    when(bigquery.getRoutine(ROUTINE_INFO.getRoutineId())).thenReturn(expectedRoutine);
    Routine updatedRoutine = routine.reload();
    compareRoutine(expectedRoutine, updatedRoutine);
    verify(bigquery).getRoutine(ROUTINE_INFO.getRoutineId());
  }

  @Test
  public void testReload_Null() {
    when(bigquery.getRoutine(ROUTINE_INFO.getRoutineId())).thenReturn(null);
    assertNull(routine.reload());
    verify(bigquery).getRoutine(ROUTINE_INFO.getRoutineId());
  }

  @Test
  public void testUpdate() {
    Routine expectedUpdatedRoutine = expectedRoutine.toBuilder().setBody("body2").build();
    when(bigquery.update(eq(expectedRoutine))).thenReturn(expectedUpdatedRoutine);
    Routine actualUpdatedRoutine = routine.update();
    compareRoutine(expectedUpdatedRoutine, actualUpdatedRoutine);
    verify(bigquery).update(eq(expectedRoutine));
  }

  @Test
  public void testUpdateWithOptions() {
    Routine expectedUpdatedRoutine = expectedRoutine.toBuilder().setBody("body2").build();
    when(bigquery.update(eq(expectedRoutine), eq(BigQuery.RoutineOption.fields())))
        .thenReturn(expectedUpdatedRoutine);
    Routine actualUpdatedRoutine = routine.update(BigQuery.RoutineOption.fields());
    compareRoutine(expectedUpdatedRoutine, actualUpdatedRoutine);
    verify(bigquery).update(eq(expectedRoutine), eq(BigQuery.RoutineOption.fields()));
  }

  @Test
  public void testDeleteTrue() {
    when(bigquery.delete(ROUTINE_INFO.getRoutineId())).thenReturn(true);
    assertTrue(routine.delete());
    verify(bigquery).delete(ROUTINE_INFO.getRoutineId());
  }

  @Test
  public void testDeleteFalse() {
    when(bigquery.delete(ROUTINE_INFO.getRoutineId())).thenReturn(false);
    assertFalse(routine.delete());
    verify(bigquery).delete(ROUTINE_INFO.getRoutineId());
  }

  private void compareRoutine(Routine expected, Routine value) {
    assertEquals(expected, value);
    compareRoutineInfo(expected, value);
    assertEquals(expected.getBigQuery().getOptions(), value.getBigQuery().getOptions());
  }

  public void compareRoutineInfo(RoutineInfo expected, RoutineInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getRoutineId(), value.getRoutineId());
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getRoutineType(), value.getRoutineType());
    assertEquals(expected.getCreationTime(), value.getCreationTime());
    assertEquals(expected.getDeterminismLevel(), value.getDeterminismLevel());
    assertEquals(expected.getLastModifiedTime(), value.getLastModifiedTime());
    assertEquals(expected.getLanguage(), value.getLanguage());
    assertEquals(expected.getArguments(), value.getArguments());
    assertEquals(expected.getReturnType(), value.getReturnType());
    assertEquals(expected.getImportedLibraries(), value.getImportedLibraries());
    assertEquals(expected.getBody(), value.getBody());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
