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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class QueryRequestTest {

  private static final String QUERY = "BigQuery SQL";
  private static final DatasetId DATASET_ID = DatasetId.of("project", "dataset");
  private static final Boolean USE_QUERY_CACHE = true;
  private static final Boolean DRY_RUN = false;
  private static final Long MAX_RESULTS = 42L;
  private static final Long MAX_WAIT_TIME = 42000L;
  private static final QueryRequest QUERY_REQUEST = QueryRequest.builder(QUERY)
      .useQueryCache(USE_QUERY_CACHE)
      .defaultDataset(DATASET_ID)
      .dryRun(DRY_RUN)
      .maxResults(MAX_RESULTS)
      .maxWaitTime(MAX_WAIT_TIME)
      .build();

  @Test
  public void testToBuilder() {
    compareQueryRequest(QUERY_REQUEST, QUERY_REQUEST.toBuilder().build());
    QueryRequest queryRequest = QUERY_REQUEST.toBuilder()
        .query("New BigQuery SQL")
        .build();
    assertEquals("New BigQuery SQL", queryRequest.query());
    queryRequest = queryRequest.toBuilder().query(QUERY).build();
    compareQueryRequest(QUERY_REQUEST, queryRequest);
  }

  @Test
  public void testToBuilderIncomplete() {
    QueryRequest queryRequest = QueryRequest.of(QUERY);
    compareQueryRequest(queryRequest, queryRequest.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(QUERY, QUERY_REQUEST.query());
    assertEquals(USE_QUERY_CACHE, QUERY_REQUEST.useQueryCache());
    assertEquals(DATASET_ID, QUERY_REQUEST.defaultDataset());
    assertEquals(DRY_RUN, QUERY_REQUEST.dryRun());
    assertEquals(MAX_RESULTS, QUERY_REQUEST.maxResults());
    assertEquals(MAX_WAIT_TIME, QUERY_REQUEST.maxWaitTime());
  }

  @Test
  public void testOf() {
    QueryRequest request = QueryRequest.of(QUERY);
    assertEquals(QUERY, request.query());
    assertNull(request.useQueryCache());
    assertNull(request.defaultDataset());
    assertNull(request.dryRun());
    assertNull(request.maxResults());
    assertNull(request.maxWaitTime());
  }

  @Test
  public void testToPbAndFromPb() {
    compareQueryRequest(QUERY_REQUEST, QueryRequest.fromPb(QUERY_REQUEST.toPb()));
    QueryRequest queryRequest = QueryRequest.of(QUERY);
    compareQueryRequest(queryRequest, QueryRequest.fromPb(queryRequest.toPb()));
  }

  private void compareQueryRequest(QueryRequest expected, QueryRequest value) {
    assertEquals(expected, value);
    assertEquals(expected.query(), value.query());
    assertEquals(expected.useQueryCache(), value.useQueryCache());
    assertEquals(expected.defaultDataset(), value.defaultDataset());
    assertEquals(expected.dryRun(), value.dryRun());
    assertEquals(expected.maxResults(), value.maxResults());
    assertEquals(expected.maxWaitTime(), value.maxWaitTime());
  }
}
