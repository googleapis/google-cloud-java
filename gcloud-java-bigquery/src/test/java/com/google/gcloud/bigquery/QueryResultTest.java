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

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class QueryResultTest {

  private static final String CURSOR = "cursor";
  private static final Field FIELD_SCHEMA1 =
      Field.builder("StringField", Field.Type.string())
          .mode(Field.Mode.NULLABLE)
          .description("FieldDescription1")
          .build();
  private static final Schema SCHEMA = Schema.of(FIELD_SCHEMA1);
  private static final long TOTAL_ROWS = 42L;
  private static final QueryResult.QueryResultsPageFetcher FETCHER =
      new QueryResult.QueryResultsPageFetcher() {
        @Override
        public QueryResult nextPage() {
          return null;
        }
      };
  private static final long TOTAL_BYTES_PROCESSED = 4200L;
  private static final boolean CACHE_HIT = false;
  private static final QueryResult QUERY_RESULT = QueryResult.builder()
      .schema(SCHEMA)
      .totalRows(TOTAL_ROWS)
      .totalBytesProcessed(TOTAL_BYTES_PROCESSED)
      .cursor(CURSOR)
      .pageFetcher(FETCHER)
      .results(ImmutableList.<List<FieldValue>>of())
      .cacheHit(CACHE_HIT)
      .build();
  private static final QueryResult QUERY_RESULT_INCOMPLETE = QueryResult.builder()
      .totalBytesProcessed(TOTAL_BYTES_PROCESSED)
      .build();

  @Test
  public void testBuilder() {
    assertEquals(SCHEMA, QUERY_RESULT.schema());
    assertEquals(TOTAL_ROWS, QUERY_RESULT.totalRows());
    assertEquals(TOTAL_BYTES_PROCESSED, QUERY_RESULT.totalBytesProcessed());
    assertEquals(CACHE_HIT, QUERY_RESULT.cacheHit());
    assertEquals(CURSOR, QUERY_RESULT.nextPageCursor());
    assertEquals(null, QUERY_RESULT.nextPage());
    assertEquals(null, QUERY_RESULT_INCOMPLETE.schema());
    assertEquals(0L, QUERY_RESULT_INCOMPLETE.totalRows());
    assertEquals(TOTAL_BYTES_PROCESSED, QUERY_RESULT_INCOMPLETE.totalBytesProcessed());
    assertEquals(false, QUERY_RESULT_INCOMPLETE.cacheHit());
    assertEquals(null, QUERY_RESULT_INCOMPLETE.nextPageCursor());
    assertEquals(null, QUERY_RESULT_INCOMPLETE.nextPage());
  }

  @Test
  public void testEquals() {
    compareQueryResult(QUERY_RESULT, QUERY_RESULT);
    compareQueryResult(QUERY_RESULT_INCOMPLETE, QUERY_RESULT_INCOMPLETE);
  }

  private void compareQueryResult(QueryResult expected, QueryResult value) {
    assertEquals(expected, value);
    assertEquals(expected.nextPage(), value.nextPage());
    assertEquals(expected.nextPageCursor(), value.nextPageCursor());
    assertEquals(expected.values(), value.values());
    assertEquals(expected.schema(), value.schema());
    assertEquals(expected.totalRows(), value.totalRows());
    assertEquals(expected.totalBytesProcessed(), value.totalBytesProcessed());
    assertEquals(expected.cacheHit(), value.cacheHit());
  }
}
