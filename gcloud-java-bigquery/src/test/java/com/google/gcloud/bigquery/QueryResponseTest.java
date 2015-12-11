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

import com.google.common.collect.ImmutableList;
import com.google.gcloud.Page;
import com.google.gcloud.PageImpl;

import org.junit.Test;

import java.util.List;

public class QueryResponseTest {

  private static final String ETAG = "etag";
  private static final Field FIELD_SCHEMA1 =
      Field.builder("StringField", Field.Type.string())
          .mode(Field.Mode.NULLABLE)
          .description("FieldDescription1")
          .build();
  private static final Schema SCHEMA = Schema.of(FIELD_SCHEMA1);
  private static final JobId JOB_ID = JobId.of("project", "job");
  private static final Long TOTAL_ROWS = 42L;
  private static final PageImpl.NextPageFetcher<List<FieldValue>> FETCHER =
      new PageImpl.NextPageFetcher<List<FieldValue>>() {
        @Override
        public Page<List<FieldValue>> nextPage() {
          return null;
        }
      };
  private static final Page<List<FieldValue>> ROWS =
      new PageImpl<List<FieldValue>>(FETCHER, "cursor", ImmutableList.<List<FieldValue>>of());
  private static final Long TOTAL_BYTES_PROCESSED = 4200L;
  private static final Boolean JOB_COMPLETE = true;
  private static final List<BigQueryError> ERRORS = ImmutableList.of(
      new BigQueryError("reason1", "location1", "message1", "debugInfo1"),
      new BigQueryError("reason2", "location2", "message2", "debugInfo2")
  );
  private static final Boolean CACHE_HIT = false;
  private static final QueryResponse QUERY_RESPONSE = QueryResponse.builder()
      .etag(ETAG)
      .schema(SCHEMA)
      .job(JOB_ID)
      .totalRows(TOTAL_ROWS)
      .rows(ROWS)
      .totalBytesProcessed(TOTAL_BYTES_PROCESSED)
      .jobComplete(JOB_COMPLETE)
      .errors(ERRORS)
      .cacheHit(CACHE_HIT)
      .build();

  @Test
  public void testBuilder() {
    assertEquals(ETAG, QUERY_RESPONSE.etag());
    assertEquals(SCHEMA, QUERY_RESPONSE.schema());
    assertEquals(JOB_ID, QUERY_RESPONSE.job());
    assertEquals(TOTAL_ROWS, QUERY_RESPONSE.totalRows());
    assertEquals(ROWS, QUERY_RESPONSE.rows());
    assertEquals(TOTAL_BYTES_PROCESSED, QUERY_RESPONSE.totalBytesProcessed());
    assertEquals(JOB_COMPLETE, QUERY_RESPONSE.jobComplete());
    assertEquals(ERRORS, QUERY_RESPONSE.errors());
    assertEquals(CACHE_HIT, QUERY_RESPONSE.cacheHit());
  }

  @Test
  public void testBuilderIncomplete() {
    QueryResponse queryResponse = QueryResponse.builder().jobComplete(false).build();
    assertNull(queryResponse.etag());
    assertNull(queryResponse.schema());
    assertNull(queryResponse.job());
    assertNull(queryResponse.totalRows());
    assertNull(queryResponse.rows());
    assertNull(queryResponse.totalBytesProcessed());
    assertEquals(false, queryResponse.jobComplete());
    assertNull(queryResponse.errors());
    assertNull(queryResponse.cacheHit());
  }

  @Test
  public void testEquals() {
    compareQueryResponse(QUERY_RESPONSE, QUERY_RESPONSE);
  }

  private void compareQueryResponse(QueryResponse expected, QueryResponse value) {
    assertEquals(expected, value);
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.schema(), value.schema());
    assertEquals(expected.job(), value.job());
    assertEquals(expected.totalRows(), value.totalRows());
    assertEquals(expected.rows(), value.rows());
    assertEquals(expected.totalBytesProcessed(), value.totalBytesProcessed());
    assertEquals(expected.jobComplete(), value.jobComplete());
    assertEquals(expected.errors(), value.errors());
    assertEquals(expected.cacheHit(), value.cacheHit());
  }
}
