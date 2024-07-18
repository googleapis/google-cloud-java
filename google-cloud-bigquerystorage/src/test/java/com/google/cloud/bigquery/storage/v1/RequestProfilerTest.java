/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigquery.storage.v1;

import static org.junit.Assert.assertTrue;

import com.google.cloud.bigquery.storage.v1.RequestProfiler.OperationName;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RequestProfilerTest {
  private static final Logger log = Logger.getLogger(RequestProfiler.class.getName());

  private RequestProfiler.RequestProfilerHook profilerHook =
      new RequestProfiler.RequestProfilerHook(true);

  @Before
  public void setup() {
    RequestProfiler.disableAndResetProfiler();
    profilerHook.enableProfiler();
  }

  @After
  public void close() {
    RequestProfiler.disableAndResetProfiler();
  }

  @Test
  public void testNormalCase() throws Exception {
    profilerHook.startOperation(OperationName.TOTAL_LATENCY, "request_1");
    profilerHook.startOperation(OperationName.JSON_TO_PROTO_CONVERSION, "request_1");
    profilerHook.endOperation(OperationName.JSON_TO_PROTO_CONVERSION, "request_1");
    profilerHook.startOperation(OperationName.RESPONSE_LATENCY, "request_1");

    // Another request starts in the middle
    profilerHook.startOperation(OperationName.TOTAL_LATENCY, "request_2");
    profilerHook.startOperation(OperationName.JSON_TO_PROTO_CONVERSION, "request_2");
    profilerHook.endOperation(OperationName.JSON_TO_PROTO_CONVERSION, "request_2");

    // Continue request 1
    profilerHook.endOperation(OperationName.RESPONSE_LATENCY, "request_1");

    // Continue request 2
    profilerHook.startOperation(OperationName.RESPONSE_LATENCY, "request_2");
    profilerHook.endOperation(OperationName.RESPONSE_LATENCY, "request_2");
    profilerHook.endOperation(OperationName.TOTAL_LATENCY, "request_2");

    // Continue request 1
    profilerHook.endOperation(OperationName.TOTAL_LATENCY, "request_1");

    // Test the report generated.
    String reportText = profilerHook.flushAndGenerateReportText();
    log.info(reportText);
    assertTrue(reportText.contains("Request uuid: request_1 with total time"));
    assertTrue(reportText.contains("Operation name json_to_proto_conversion starts at"));
    assertTrue(reportText.contains("Operation name response_latency starts at"));
    assertTrue(reportText.contains("Request uuid: request_2 with total time"));

    // Second time flush is called, it should generate empty report.
    reportText = profilerHook.flushAndGenerateReportText();
    assertTrue(reportText.contains("0 requests finished during"));
  }

  @Test
  public void mixFinishedAndUnfinishedRequest() throws Exception {
    // Start request 1.
    profilerHook.startOperation(OperationName.TOTAL_LATENCY, "request_1");
    profilerHook.startOperation(OperationName.JSON_TO_PROTO_CONVERSION, "request_1");
    profilerHook.endOperation(OperationName.JSON_TO_PROTO_CONVERSION, "request_1");
    profilerHook.startOperation(OperationName.RESPONSE_LATENCY, "request_1");

    // Another request starts in the middle
    profilerHook.startOperation(OperationName.TOTAL_LATENCY, "request_2");
    profilerHook.startOperation(OperationName.JSON_TO_PROTO_CONVERSION, "request_2");

    // First report should be empty since no requests end.
    String reportText = profilerHook.flushAndGenerateReportText();
    assertTrue(reportText.contains("0 requests finished during"));

    // End one of them.
    profilerHook.endOperation(OperationName.TOTAL_LATENCY, "request_1");
    reportText = profilerHook.flushAndGenerateReportText();
    assertTrue(reportText.contains("Request uuid: request_1 with total time"));

    // End another, expect the first request's log not showing up.
    profilerHook.endOperation(OperationName.TOTAL_LATENCY, "request_2");
    reportText = profilerHook.flushAndGenerateReportText();
    assertTrue(!reportText.contains("Request uuid: request_1 with total time"));
    assertTrue(reportText.contains("Request uuid: request_2 with total time"));

    // Flush again will be empty report.
    reportText = profilerHook.flushAndGenerateReportText();
    assertTrue(reportText.contains("0 requests finished during"));
  }

  @Test
  public void concurrentProfilingTest_1000ReqsRunTogether() throws Exception {
    int totalRequest = 1000;
    ListeningExecutorService threadPool =
        MoreExecutors.listeningDecorator(
            Executors.newCachedThreadPool(
                new ThreadFactoryBuilder().setDaemon(true).setNameFormat("TestThread").build()));

    List<Future<?>> futures = new ArrayList<>();
    // Make some request particularly slower than the others.
    ImmutableSet<Integer> slowRequestIndex = ImmutableSet.of(10, 15, 20, 25, 30, 40, 50);
    for (int i = 0; i < totalRequest; i++) {
      int finalI = i;
      futures.add(
          threadPool.submit(
              () -> {
                String uuid = String.format("request_%s", finalI);
                profilerHook.startOperation(OperationName.TOTAL_LATENCY, uuid);
                profilerHook.startOperation(OperationName.JSON_TO_PROTO_CONVERSION, uuid);
                if (slowRequestIndex.contains(finalI)) {
                  try {
                    TimeUnit.MILLISECONDS.sleep(finalI * 100);
                  } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                  }
                }
                profilerHook.endOperation(OperationName.JSON_TO_PROTO_CONVERSION, uuid);
                profilerHook.startOperation(OperationName.JSON_TO_PROTO_CONVERSION, uuid);
                profilerHook.endOperation(OperationName.JSON_TO_PROTO_CONVERSION, uuid);
                profilerHook.startOperation(OperationName.WAIT_QUEUE, uuid);
                profilerHook.endOperation(OperationName.WAIT_QUEUE, uuid);
                profilerHook.endOperation(OperationName.TOTAL_LATENCY, uuid);
              }));
    }

    // Wait all requests to finish.
    for (int i = 0; i < futures.size(); i++) {
      futures.get(i).get();
    }
    String reportText = profilerHook.flushAndGenerateReportText();
    assertTrue(reportText.contains("During the last 60000 milliseconds at system time"));
    assertTrue(reportText.contains("in total 1000 requests finished"));
    assertTrue(reportText.contains("Request uuid: request_50 with total time"));
    assertTrue(reportText.contains("Request uuid: request_40 with total time"));
    assertTrue(reportText.contains("Request uuid: request_30 with total time"));
    assertTrue(reportText.contains("Request uuid: request_25 with total time"));
    assertTrue(reportText.contains("Request uuid: request_20 with total time"));
  }

  @Test
  public void concurrentProfilingTest_RunWhileFlushing() throws Exception {
    int totalRequest = 1000;
    ListeningExecutorService threadPool =
        MoreExecutors.listeningDecorator(
            Executors.newCachedThreadPool(
                new ThreadFactoryBuilder().setDaemon(true).setNameFormat("TestThread").build()));

    List<Future<?>> futures = new ArrayList<>();
    // Make some request particularly slower than the others.
    ImmutableSet<Integer> slowRequestIndex = ImmutableSet.of(10, 15, 20, 25, 30, 40, 50);
    for (int i = 0; i < totalRequest; i++) {
      int finalI = i;
      futures.add(
          threadPool.submit(
              () -> {
                try {
                  String uuid = String.format("request_%s", finalI);
                  profilerHook.startOperation(OperationName.TOTAL_LATENCY, uuid);
                  profilerHook.startOperation(OperationName.JSON_TO_PROTO_CONVERSION, uuid);
                  if (slowRequestIndex.contains(finalI)) {
                    TimeUnit.MILLISECONDS.sleep(finalI * 100);
                  }
                  profilerHook.endOperation(OperationName.JSON_TO_PROTO_CONVERSION, uuid);
                  profilerHook.startOperation(OperationName.JSON_TO_PROTO_CONVERSION, uuid);
                  profilerHook.endOperation(OperationName.JSON_TO_PROTO_CONVERSION, uuid);
                  profilerHook.startOperation(OperationName.WAIT_QUEUE, uuid);
                  profilerHook.endOperation(OperationName.WAIT_QUEUE, uuid);
                  profilerHook.endOperation(OperationName.TOTAL_LATENCY, uuid);
                  String unused = profilerHook.flushAndGenerateReportText();
                } catch (InterruptedException e) {
                  throw new RuntimeException(e);
                }
              }));
    }

    // Wait all requests to finish.
    for (int i = 0; i < futures.size(); i++) {
      futures.get(i).get();
    }
    String reportText = profilerHook.flushAndGenerateReportText();
    assertTrue(reportText.contains("0 requests finished during"));
  }
}
