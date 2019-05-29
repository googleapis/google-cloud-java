/*
 * Copyright 2015 Google LLC
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
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class InsertAllResponseTest {

  private static final List<BigQueryError> ERRORS1 =
      ImmutableList.of(
          new BigQueryError("reason1", "location1", "message1"),
          new BigQueryError("reason2", "location2", "message2"));
  private static final List<BigQueryError> ERRORS2 =
      ImmutableList.of(
          new BigQueryError("reason3", "location3", "message3"),
          new BigQueryError("reason4", "location4", "message4"));
  private static final Map<Long, List<BigQueryError>> ERRORS_MAP =
      ImmutableMap.of(0L, ERRORS1, 1L, ERRORS2);
  private static final InsertAllResponse INSERT_ALL_RESPONSE = new InsertAllResponse(ERRORS_MAP);
  private static final InsertAllResponse EMPTY_INSERT_ALL_RESPONSE = new InsertAllResponse(null);

  @Test
  public void testConstructor() {
    assertEquals(INSERT_ALL_RESPONSE, INSERT_ALL_RESPONSE);
  }

  @Test
  public void testErrorsFor() {
    assertEquals(ERRORS_MAP, INSERT_ALL_RESPONSE.getInsertErrors());
    assertEquals(ERRORS1, INSERT_ALL_RESPONSE.getErrorsFor(0L));
    assertEquals(ERRORS2, INSERT_ALL_RESPONSE.getErrorsFor(1L));
    assertNull(INSERT_ALL_RESPONSE.getErrorsFor(2L));
  }

  @Test
  public void testHasErrors() {
    assertTrue(INSERT_ALL_RESPONSE.hasErrors());
    assertFalse(EMPTY_INSERT_ALL_RESPONSE.hasErrors());
  }

  @Test
  public void testToPbAndFromPb() {
    compareInsertAllResponse(
        INSERT_ALL_RESPONSE, InsertAllResponse.fromPb(INSERT_ALL_RESPONSE.toPb()));
    compareInsertAllResponse(
        EMPTY_INSERT_ALL_RESPONSE, InsertAllResponse.fromPb(EMPTY_INSERT_ALL_RESPONSE.toPb()));
  }

  private void compareInsertAllResponse(InsertAllResponse expected, InsertAllResponse value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getInsertErrors(), value.getInsertErrors());
  }
}
