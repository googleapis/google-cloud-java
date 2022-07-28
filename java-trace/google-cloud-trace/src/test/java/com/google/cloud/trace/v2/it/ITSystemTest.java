/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.trace.v2.it;

import static org.junit.Assert.assertEquals;

import com.google.cloud.ServiceOptions;
import com.google.cloud.trace.v2.TraceServiceClient;
import com.google.common.io.BaseEncoding;
import com.google.devtools.cloudtrace.v2.Span;
import com.google.devtools.cloudtrace.v2.TruncatableString;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.Instant;

public class ITSystemTest {

  private static TraceServiceClient client;
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String TRACE_ID = UUID.randomUUID().toString().replace("-", "");
  private static final String SPAN_ID = BaseEncoding.base16().encode("spantest".getBytes());
  private static final String SPAN_NAME =
      "projects/" + PROJECT_ID + "/traces/" + TRACE_ID + "/spans/" + SPAN_ID;
  private static final TruncatableString DISPLAY_NAME =
      TruncatableString.newBuilder()
          .setValue("display-name-test-" + UUID.randomUUID().toString().substring(0, 8))
          .build();

  private static final Instant NOW = Instant.now();
  private static final Timestamp START_TIME =
      Timestamp.newBuilder().setSeconds(NOW.getEpochSecond()).setNanos(NOW.getNano()).build();
  private static final Timestamp END_TIME =
      Timestamp.newBuilder()
          .setSeconds(NOW.plusSeconds(5).getEpochSecond())
          .setNanos(NOW.plusSeconds(5).getNano())
          .build();

  @BeforeClass
  public static void beforeTest() throws IOException {
    client = TraceServiceClient.create();
  }

  @AfterClass
  public static void afterTest() {
    client.close();
  }

  @Test
  public void createSpanTest() {
    Span span =
        Span.newBuilder()
            .setName(SPAN_NAME)
            .setSpanId(SPAN_ID)
            .setDisplayName(DISPLAY_NAME)
            .setStartTime(START_TIME)
            .setEndTime(END_TIME)
            .build();
    Span actual = client.createSpan(span);
    assertEquals(SPAN_ID, actual.getSpanId().toUpperCase());
    assertEquals(DISPLAY_NAME, actual.getDisplayName());
    assertEquals(START_TIME, actual.getStartTime());
    assertEquals(END_TIME, actual.getEndTime());
  }
}
