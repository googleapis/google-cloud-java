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

import com.google.common.collect.ImmutableList;

import org.junit.Test;

public class QueryResultTest {

  private static final String CURSOR = "cursor";
  private static final Field FIELD_SCHEMA1 =
      Field.newBuilder("StringField", LegacySQLTypeName.STRING)
      .setMode(Field.Mode.NULLABLE)
      .setDescription("FieldDescription1")
      .build();

  private static final Schema SCHEMA = Schema.of(FIELD_SCHEMA1);
  private static final long TOTAL_ROWS = 42L;
  private static final QueryResult.QueryResultsPageFetcher FETCHER =
      new QueryResult.QueryResultsPageFetcher() {

        @Override
        public QueryResult getNextPage() {
          return null;
        }
      };
  private static final long TOTAL_BYTES_PROCESSED = 4200L;
  private static final boolean CACHE_HIT = false;
  private static final QueryResult QUERY_RESULT = QueryResult.newBuilder()
      .setSchema(SCHEMA)
      .setTotalRows(TOTAL_ROWS)
      .setCursor(CURSOR)
      .setPageFetcher(FETCHER)
      .setResults(ImmutableList.<FieldValueList>of())
      .build();
  private static final QueryResult QUERY_RESULT_INCOMPLETE = QueryResult.newBuilder()
      .build();

  @Test
  public void testBuilder() {
    assertEquals(SCHEMA, QUERY_RESULT.getSchema());
    assertEquals(TOTAL_ROWS, QUERY_RESULT.getTotalRows());
    assertEquals(CURSOR, QUERY_RESULT.getNextPageToken());
    assertEquals(null, QUERY_RESULT.getNextPage());

    assertEquals(null, QUERY_RESULT_INCOMPLETE.getSchema());
    assertEquals(0L, QUERY_RESULT_INCOMPLETE.getTotalRows());
    assertEquals(null, QUERY_RESULT_INCOMPLETE.getNextPageToken());
    assertEquals(null, QUERY_RESULT_INCOMPLETE.getNextPage());
  }


  @Test
  public void testEquals() {
    compareQueryResult(QUERY_RESULT, QUERY_RESULT);
    compareQueryResult(QUERY_RESULT_INCOMPLETE, QUERY_RESULT_INCOMPLETE);
  }

  private void compareQueryResult(QueryResult expected, QueryResult value) {
    assertEquals(expected, value);
    assertEquals(expected.getNextPage(), value.getNextPage());
    assertEquals(expected.getNextPageToken(), value.getNextPageToken());
    assertEquals(expected.getValues(), value.getValues());
    assertEquals(expected.getSchema(), value.getSchema());
    assertEquals(expected.getTotalRows(), value.getTotalRows());
  }
}
