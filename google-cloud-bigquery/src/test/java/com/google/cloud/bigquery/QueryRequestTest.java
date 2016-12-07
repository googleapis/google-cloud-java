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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QueryRequestTest {

  private static final String QUERY = "BigQuery SQL";
  private static final DatasetId DATASET_ID = DatasetId.of("dataset");
  private static final Boolean USE_QUERY_CACHE = true;
  private static final Boolean DRY_RUN = false;
  private static final Long PAGE_SIZE = 42L;
  private static final Long MAX_WAIT_TIME = 42000L;
  private static final Boolean USE_LEGACY_SQL = false;
  private static final String QUERY_PARAMETER_NAME = "paramName";
  private static final QueryParameterValue QUERY_PARAMETER_VALUE = QueryParameterValue.int64(7);
  private static final List<QueryParameterValue> POSITIONAL_PARAMETERS =
      Arrays.asList(QUERY_PARAMETER_VALUE);
  private static final QueryRequest QUERY_REQUEST = QueryRequest.newBuilder(QUERY)
      .setUseQueryCache(USE_QUERY_CACHE)
      .setDefaultDataset(DATASET_ID)
      .setDryRun(DRY_RUN)
      .setPageSize(PAGE_SIZE)
      .setMaxWaitTime(MAX_WAIT_TIME)
      .setUseLegacySql(USE_LEGACY_SQL)
      .setPositionalParameters(POSITIONAL_PARAMETERS)
      .build();
  private static final QueryRequest DEPRECATED_QUERY_REQUEST = QueryRequest.builder(QUERY)
      .useQueryCache(USE_QUERY_CACHE)
      .defaultDataset(DATASET_ID)
      .dryRun(DRY_RUN)
      .pageSize(PAGE_SIZE)
      .maxWaitTime(MAX_WAIT_TIME)
      .useLegacySql(USE_LEGACY_SQL)
      .build();

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testToBuilder() {
    compareQueryRequest(QUERY_REQUEST, QUERY_REQUEST.toBuilder().build());
    QueryRequest queryRequest = QUERY_REQUEST.toBuilder()
        .setQuery("New BigQuery SQL")
        .build();
    assertEquals("New BigQuery SQL", queryRequest.getQuery());
    queryRequest = queryRequest.toBuilder().setQuery(QUERY).build();
    compareQueryRequest(QUERY_REQUEST, queryRequest);
  }

  @Test
  public void testToBuilderIncomplete() {
    QueryRequest queryRequest = QueryRequest.of(QUERY);
    compareQueryRequest(queryRequest, queryRequest.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(QUERY, QUERY_REQUEST.getQuery());
    assertEquals(USE_QUERY_CACHE, QUERY_REQUEST.useQueryCache());
    assertEquals(DATASET_ID, QUERY_REQUEST.getDefaultDataset());
    assertEquals(DRY_RUN, QUERY_REQUEST.dryRun());
    assertEquals(PAGE_SIZE, QUERY_REQUEST.getPageSize());
    assertEquals(MAX_WAIT_TIME, QUERY_REQUEST.getMaxWaitTime());
    assertEquals(1, QUERY_REQUEST.getPositionalParameters().size());
    assertEquals(QUERY_PARAMETER_VALUE, QUERY_REQUEST.getPositionalParameters().get(0));
    assertTrue(QUERY_REQUEST.getNamedParameters().isEmpty());
    assertFalse(QUERY_REQUEST.useLegacySql());
    thrown.expect(NullPointerException.class);
    QueryRequest.newBuilder(null);
  }

  @Test
  public void testBuilderDeprecated() {
    assertEquals(QUERY, DEPRECATED_QUERY_REQUEST.query());
    assertEquals(USE_QUERY_CACHE, DEPRECATED_QUERY_REQUEST.useQueryCache());
    assertEquals(DATASET_ID, DEPRECATED_QUERY_REQUEST.defaultDataset());
    assertEquals(DRY_RUN, DEPRECATED_QUERY_REQUEST.dryRun());
    assertEquals(PAGE_SIZE, DEPRECATED_QUERY_REQUEST.pageSize());
    assertEquals(MAX_WAIT_TIME, DEPRECATED_QUERY_REQUEST.maxWaitTime());
    assertTrue(DEPRECATED_QUERY_REQUEST.getNamedParameters().isEmpty());
    assertTrue(DEPRECATED_QUERY_REQUEST.getPositionalParameters().isEmpty());
    assertFalse(DEPRECATED_QUERY_REQUEST.useLegacySql());
    thrown.expect(NullPointerException.class);
    QueryRequest.builder(null);
  }

  @Test
  public void testNamedParameters() {
    QueryRequest queryRequestNamedParams =
        QueryRequest.newBuilder(QUERY)
            .addNamedParameter(QUERY_PARAMETER_NAME, QUERY_PARAMETER_VALUE)
            .build();
    assertEquals(1, queryRequestNamedParams.getNamedParameters().size());
    assertTrue(queryRequestNamedParams.getNamedParameters().containsKey(QUERY_PARAMETER_NAME));
    assertEquals(
        QUERY_PARAMETER_VALUE,
        queryRequestNamedParams.getNamedParameters().get(QUERY_PARAMETER_NAME));
    assertTrue(queryRequestNamedParams.getPositionalParameters().isEmpty());
  }

  @Test(expected = IllegalStateException.class)
  public void testAddNamedAfterAddPositional() {
    QueryRequest.newBuilder(QUERY)
        .addPositionalParameter(QUERY_PARAMETER_VALUE)
        .addNamedParameter(QUERY_PARAMETER_NAME, QUERY_PARAMETER_VALUE);
  }

  @Test(expected = IllegalStateException.class)
  public void testSetNamedAfterAddPositional() {
    QueryRequest.newBuilder(QUERY)
        .addPositionalParameter(QUERY_PARAMETER_VALUE)
        .setNamedParameters(Collections.singletonMap(QUERY_PARAMETER_NAME, QUERY_PARAMETER_VALUE));
  }

  @Test(expected = IllegalStateException.class)
  public void testAddPositionalAfterNamed() {
    QueryRequest.newBuilder(QUERY)
        .addNamedParameter(QUERY_PARAMETER_NAME, QUERY_PARAMETER_VALUE)
        .addPositionalParameter(QUERY_PARAMETER_VALUE);
  }

  @Test(expected = IllegalStateException.class)
  public void testSetPositionalAfterNamed() {
    QueryRequest.newBuilder(QUERY)
        .addNamedParameter(QUERY_PARAMETER_NAME, QUERY_PARAMETER_VALUE)
        .setPositionalParameters(Arrays.asList(QUERY_PARAMETER_VALUE));
  }

  @Test
  public void testOf() {
    QueryRequest request = QueryRequest.of(QUERY);
    assertEquals(QUERY, request.getQuery());
    assertNull(request.useQueryCache());
    assertNull(request.getDefaultDataset());
    assertNull(request.dryRun());
    assertNull(request.getPageSize());
    assertNull(request.getMaxWaitTime());
    assertNull(request.useLegacySql());
    assertNotNull(request.getPositionalParameters());
    assertTrue(request.getPositionalParameters().isEmpty());
    assertNotNull(request.getNamedParameters());
    assertTrue(request.getNamedParameters().isEmpty());
    thrown.expect(NullPointerException.class);
    QueryRequest.of(null);
  }

  @Test
  public void testToPbAndFromPb() {
    compareQueryRequest(QUERY_REQUEST, QueryRequest.fromPb(QUERY_REQUEST.toPb()));
    QueryRequest queryRequest = QueryRequest.of(QUERY);
    compareQueryRequest(queryRequest, QueryRequest.fromPb(queryRequest.toPb()));
  }

  @Test
  public void testToPbAndFromPbWithNamedParameters() {
    QueryRequest withNamedParams =
        QUERY_REQUEST
            .toBuilder()
            .setPositionalParameters(null)
            .addNamedParameter(QUERY_PARAMETER_NAME, QUERY_PARAMETER_VALUE)
            .build();
    compareQueryRequest(withNamedParams, QueryRequest.fromPb(withNamedParams.toPb()));
  }

  @Test
  public void testSetProjectId() {
    assertEquals("p", QUERY_REQUEST.setProjectId("p").getDefaultDataset().getProject());
  }

  private void compareQueryRequest(QueryRequest expected, QueryRequest value) {
    assertEquals(expected, value);
    assertEquals(expected.getQuery(), value.getQuery());
    assertEquals(expected.useQueryCache(), value.useQueryCache());
    assertEquals(expected.getDefaultDataset(), value.getDefaultDataset());
    assertEquals(expected.dryRun(), value.dryRun());
    assertEquals(expected.getPageSize(), value.getPageSize());
    assertEquals(expected.getMaxWaitTime(), value.getMaxWaitTime());
    assertEquals(expected.useLegacySql(), value.useLegacySql());
    assertArrayEquals(expected.getPositionalParameters().toArray(new QueryParameterValue[0]),
        value.getPositionalParameters().toArray(new QueryParameterValue[0]));
    assertEquals(expected.getNamedParameters().size(), value.getNamedParameters().size());
    for (Map.Entry<String, QueryParameterValue> entry : expected.getNamedParameters().entrySet()) {
      QueryParameterValue paramValue = value.getNamedParameters().get(entry.getKey());
      assertNotNull(paramValue);
      assertEquals(entry.getValue(), paramValue);
    }
  }
}
