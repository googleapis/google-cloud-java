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
package com.google.cloud.trace.v1.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.ServiceOptions;
import com.google.cloud.trace.v1.TraceServiceClient;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.TraceSpan;
import com.google.devtools.cloudtrace.v1.Traces;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.threeten.bp.Instant;

public class ITSystemTest {

  private static TraceServiceClient client;
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String SPAN_NAME =
      "span-test-" + UUID.randomUUID().toString().substring(0, 8);
  private static final Long SPAN_ID = new Random().nextLong();
  private static final String TRACE_ID = UUID.randomUUID().toString().replace("-", "");
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
    TraceSpan traceSpan =
        TraceSpan.newBuilder()
            .setSpanId(SPAN_ID)
            .setStartTime(START_TIME)
            .setEndTime(END_TIME)
            .setName(SPAN_NAME)
            .build();
    Trace trace =
        Trace.newBuilder()
            .setProjectId(PROJECT_ID)
            .setTraceId(TRACE_ID)
            .addSpans(traceSpan)
            .build();
    Traces traces = Traces.newBuilder().addTraces(trace).build();
    PatchTracesRequest request =
        PatchTracesRequest.newBuilder().setProjectId(PROJECT_ID).setTraces(traces).build();
    client.patchTraces(request);
  }

  @AfterClass
  public static void afterTest() {
    client.close();
  }

  @Test
  public void getTraceTest() throws InterruptedException {
    Thread.sleep(5000);
    GetTraceRequest request =
        GetTraceRequest.newBuilder().setProjectId(PROJECT_ID).setTraceId(TRACE_ID).build();
    Trace trace = client.getTrace(request);
    assertEquals(PROJECT_ID, trace.getProjectId());
    assertEquals(TRACE_ID, trace.getTraceId());
    assertEquals(SPAN_ID.longValue(), trace.getSpans(0).getSpanId());
    assertEquals(START_TIME, trace.getSpans(0).getStartTime());
    assertEquals(END_TIME, trace.getSpans(0).getEndTime());
  }

  @Test
  public void listTracesTest() throws InterruptedException {
    Thread.sleep(5000);
    ListTracesRequest request = ListTracesRequest.newBuilder().setProjectId(PROJECT_ID).build();
    TraceServiceClient.ListTracesPagedResponse trace = client.listTraces(request);
    assertNotNull(trace);
  }
}
