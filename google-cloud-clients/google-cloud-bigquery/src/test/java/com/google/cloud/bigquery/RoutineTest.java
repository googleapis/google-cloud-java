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

import static org.easymock.EasyMock.*;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class RoutineTest {

  private BigQuery serviceMockReturnsOptions = createStrictMock(BigQuery.class);
  private BigQueryOptions mockOptions = createMock(BigQueryOptions.class);

  private static final RoutineId ROUTINE_ID = RoutineId.of("dataset", "routine");
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
          .setLastModifiedTime(LAST_MODIFIED_TIME)
          .setLanguage(LANGUAGE)
          .setArguments(ARGUMENT_LIST)
          .setReturnType(RETURN_TYPE)
          .setImportedLibraries(IMPORTED_LIBRARIES)
          .setBody(BODY)
          .build();

  private BigQuery bigquery;
  private Routine expectedRoutine;
  private Routine routine;

  private void initializeExpectedRoutine(int optionsCalls) {
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    bigquery = createStrictMock(BigQuery.class);
    expectedRoutine =
        new Routine(serviceMockReturnsOptions, new RoutineInfo.BuilderImpl(ROUTINE_INFO));
  }

  private void initializeRoutine() {
    routine = new Routine(bigquery, new RoutineInfo.BuilderImpl(ROUTINE_INFO));
  }

  private void tearDown() throws Exception {
    verify(bigquery, serviceMockReturnsOptions);
  }

  @Test
  public void testBuilder() {
    initializeExpectedRoutine(2);
    replay(bigquery);
    Routine builtRoutine =
        new Routine.Builder(serviceMockReturnsOptions, ROUTINE_ID)
            .setEtag(ETAG)
            .setRoutineType(ROUTINE_TYPE)
            .setCreationTime(CREATION_TIME)
            .setLastModifiedTime(LAST_MODIFIED_TIME)
            .setLanguage(LANGUAGE)
            .setArguments(ARGUMENT_LIST)
            .setReturnType(RETURN_TYPE)
            .setImportedLibraries(IMPORTED_LIBRARIES)
            .setBody(BODY)
            .build();
    assertEquals(ETAG, builtRoutine.getEtag());
    assertSame(serviceMockReturnsOptions, builtRoutine.getBigQuery());
  }

  @Test
  public void testToBuilder() {
    initializeExpectedRoutine(2);
    replay(bigquery);
    compareRoutineInfo(expectedRoutine, expectedRoutine.toBuilder().build());
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedRoutine(1);
    BigQuery.RoutineOption[] expectedOptions = {BigQuery.RoutineOption.fields()};
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getRoutine(ROUTINE_INFO.getRoutineId(), expectedOptions)).andReturn(null);
    replay(bigquery);
    initializeRoutine();
    assertFalse(routine.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedRoutine(1);
    BigQuery.RoutineOption[] expectedOptions = {BigQuery.RoutineOption.fields()};
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getRoutine(ROUTINE_INFO.getRoutineId(), expectedOptions))
        .andReturn(expectedRoutine);
    replay(bigquery);
    initializeRoutine();
    assertTrue(routine.exists());
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedRoutine(4);
    RoutineInfo updatedInfo = ROUTINE_INFO.toBuilder().setBody("body2").build();
    Routine expectedRoutine =
        new Routine(serviceMockReturnsOptions, new RoutineInfo.BuilderImpl(updatedInfo));
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getRoutine(ROUTINE_INFO.getRoutineId())).andReturn(expectedRoutine);
    replay(bigquery);
    initializeRoutine();
    Routine updatedRoutine = routine.reload();
    compareRoutine(expectedRoutine, updatedRoutine);
  }

  @Test
  public void testReload_Null() throws Exception {
    initializeExpectedRoutine(1);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.getRoutine(ROUTINE_INFO.getRoutineId())).andReturn(null);
    replay(bigquery);
    initializeRoutine();
    assertNull(routine.reload());
  }

  @Test
  public void testUpdate() {
    initializeExpectedRoutine(4);
    Routine expectedUpdatedRoutine = expectedRoutine.toBuilder().setBody("body2").build();
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.update(eq(expectedRoutine))).andReturn(expectedUpdatedRoutine);
    replay(bigquery);
    initializeRoutine();
    Routine actualUpdatedRoutine = routine.update();
    compareRoutine(expectedUpdatedRoutine, actualUpdatedRoutine);
  }

  @Test
  public void testUpdateWithOptions() {
    initializeExpectedRoutine(4);
    Routine expectedUpdatedRoutine = expectedRoutine.toBuilder().setBody("body2").build();
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.update(eq(expectedRoutine), eq(BigQuery.RoutineOption.fields())))
        .andReturn(expectedUpdatedRoutine);
    replay(bigquery);
    initializeRoutine();
    Routine actualUpdatedRoutine = routine.update(BigQuery.RoutineOption.fields());
    compareRoutine(expectedUpdatedRoutine, actualUpdatedRoutine);
  }

  @Test
  public void testDeleteTrue() {
    initializeExpectedRoutine(1);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.delete(ROUTINE_INFO.getRoutineId())).andReturn(true);
    replay(bigquery);
    initializeRoutine();
    assertTrue(routine.delete());
  }

  @Test
  public void testDeleteFalse() {
    initializeExpectedRoutine(1);
    expect(bigquery.getOptions()).andReturn(mockOptions);
    expect(bigquery.delete(ROUTINE_INFO.getRoutineId())).andReturn(false);
    replay(bigquery);
    initializeRoutine();
    assertFalse(routine.delete());
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
    assertEquals(expected.getLastModifiedTime(), value.getLastModifiedTime());
    assertEquals(expected.getLanguage(), value.getLanguage());
    assertEquals(expected.getArguments(), value.getArguments());
    assertEquals(expected.getReturnType(), value.getReturnType());
    assertEquals(expected.getImportedLibraries(), value.getImportedLibraries());
    assertEquals(expected.getBody(), value.getBody());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
