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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class QueryResponseTest {

  private static final String ETAG = "etag";
  private static final Field FIELD_SCHEMA1 =
      Field.newBuilder("StringField", LegacySQLTypeName.STRING)
      .setMode(Field.Mode.NULLABLE)
      .setDescription("FieldDescription1")
      .build();

  private static final Schema SCHEMA = Schema.of(FIELD_SCHEMA1);
  private static final JobId JOB_ID = JobId.of("project", "job");
  private static final Long NUM_DML_AFFECTED_ROWS = 24L;
  private static final Long TOTAL_ROWS = 42L;
  private static final QueryResult.QueryResultsPageFetcher FETCHER =
      new QueryResult.QueryResultsPageFetcher() {

        private static final long serialVersionUID = -5754008940284215560L;

        @Override
        public QueryResult getNextPage() {
          return null;
        }
      };
  private static final Long TOTAL_BYTES_PROCESSED = 4200L;
  private static final Boolean JOB_COMPLETE = true;
  private static final List<BigQueryError> ERRORS = ImmutableList.of(
      new BigQueryError("reason1", "location1", "message1", "debugInfo1"),
      new BigQueryError("reason2", "location2", "message2", "debugInfo2")
  );
  private static final Boolean CACHE_HIT = false;
  private static final QueryResult QUERY_RESULT = QueryResult.newBuilder()
      .setSchema(SCHEMA)
      .setTotalRows(TOTAL_ROWS)
      .setTotalBytesProcessed(TOTAL_BYTES_PROCESSED)
      .setCursor("cursor")
      .setPageFetcher(FETCHER)
      .setResults(ImmutableList.<FieldValueList>of())
      .setCacheHit(CACHE_HIT)
      .build();
  private static final QueryResponse QUERY_RESPONSE = QueryResponse.newBuilder()
      .setEtag(ETAG)
      .setJobId(JOB_ID)
      .setNumDmlAffectedRows(NUM_DML_AFFECTED_ROWS)
      .setJobCompleted(JOB_COMPLETE)
      .setExecutionErrors(ERRORS)
      .setResult(QUERY_RESULT)
      .build();

  @Test
  public void testBuilder() {
    assertEquals(ETAG, QUERY_RESPONSE.getEtag());
    assertEquals(QUERY_RESULT, QUERY_RESPONSE.getResult());
    assertEquals(JOB_ID, QUERY_RESPONSE.getJobId());
    assertEquals(NUM_DML_AFFECTED_ROWS, QUERY_RESPONSE.getNumDmlAffectedRows());
    assertEquals(JOB_COMPLETE, QUERY_RESPONSE.jobCompleted());
    assertEquals(ERRORS, QUERY_RESPONSE.getExecutionErrors());
    assertTrue(QUERY_RESPONSE.hasErrors());
  }


  @Test
  public void testBuilderIncomplete() {
    QueryResponse queryResponse = QueryResponse.newBuilder().setJobCompleted(false).build();
    assertNull(queryResponse.getEtag());
    assertNull(queryResponse.getResult());
    assertNull(queryResponse.getJobId());
    assertNull(queryResponse.getNumDmlAffectedRows());
    assertFalse(queryResponse.jobCompleted());
    assertEquals(ImmutableList.<BigQueryError>of(), queryResponse.getExecutionErrors());
    assertFalse(queryResponse.hasErrors());
  }

  @Test
  public void testEquals() {
    compareQueryResponse(QUERY_RESPONSE, QUERY_RESPONSE);
  }

  private void compareQueryResponse(QueryResponse expected, QueryResponse value) {
    assertEquals(expected, value);
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getResult(), value.getResult());
    assertEquals(expected.getJobId(), value.getJobId());
    assertEquals(expected.getNumDmlAffectedRows(), value.getNumDmlAffectedRows());
    assertEquals(expected.jobCompleted(), value.jobCompleted());
    assertEquals(expected.getExecutionErrors(), value.getExecutionErrors());
    assertEquals(expected.hasErrors(), value.hasErrors());
  }
}
