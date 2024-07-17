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

import com.google.common.annotations.VisibleForTesting;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * A profiler that would periodically generate a report for the past period with the latency report
 * for the slowest requests. This is used for debugging only. A request id would be generated for
 * each request at runtime. Certain part of the code would be wrapped with startOperation(...) and
 * endOperation(...) to measure the latency of operations of individual request.
 *
 * <pre>
 * The report will contain the execution details of the TOP_K slowest requests, one example:
 *
 * INFO: During the last 60000 milliseconds at system time 1720825020138, in total 2 requests finished. Total dropped request is 0. The top 10 long latency requests details report:
 * -----------------------------
 * 	Request uuid: request_1 with total time 1000 milliseconds
 * 		Operation name json_to_proto_conversion starts at: 1720566109971, ends at: 1720566109971, total time: 200 milliseconds
 * 		Operation name backend_latency starts at: 1720566109971, ends at: 1720566109971, total time: 800 milliseconds
 * -----------------------------
 * 	Request uuid: request_2 with total time 500 milliseconds
 * 		Operation name json_to_proto_conversion starts at: 1720566109971, ends at: 1720566109971, total time: 250 milliseconds
 * 		Operation name backend_latency starts at: 1720566109971, ends at: 1720566109971, total time: 250 milliseconds
 * ...
 * </pre>
 */
public class RequestProfiler {
  enum OperationName {
    // The total end to end latency for a request.
    TOTAL_LATENCY("append_request_total_latency"),
    // Json to proto conversion time.
    JSON_TO_PROTO_CONVERSION("json_to_proto_conversion"),
    // Time spent within wait queue before it get picked up.
    WAIT_QUEUE("wait_queue"),
    // Time spent during retry backoff.
    RETRY_BACKOFF("retry_backoff"),
    // Time spent within backend + the time spent over network.
    RESPONSE_LATENCY("response_latency"),
    // Time spent to wait wait queue to have vacancy.
    WAIT_INFLIGHT_QUOTA("wait_inflight_quota");
    private final String operationName;

    OperationName(String operationName) {
      this.operationName = operationName;
    }
  }

  private static final Logger log = Logger.getLogger(RequestProfiler.class.getName());

  // Discard the requests if we are caching too many requests.
  private static final int MAX_CACHED_REQUEST = 100000;

  // Singleton for easier access.
  static final RequestProfiler REQUEST_PROFILER_SINGLETON = new RequestProfiler();

  // Tunable static variable indicate how many top longest latency requests we should consider.
  private static final int DEFAULT_TOP_K = 20;
  private static int TOP_K = DEFAULT_TOP_K;

  // Tunable static variable indicate how often the report should be generated.
  private static final Duration DEFAULT_FLUSH_PERIOD = Duration.ofMinutes(1);
  private static Duration FLUSH_PERIOD = DEFAULT_FLUSH_PERIOD;

  // From request uuid to the profiler of individual request. This will be cleaned up periodically.
  private final Map<String, IndividualRequestProfiler> idToIndividualOperation =
      new ConcurrentHashMap<>();

  private Thread flushThread;

  // Whether the periodical logging is enabled or not.
  private boolean enableProfiiler = false;

  // Count the total number of dropped operations.
  AtomicLong droppedOperationCount = new AtomicLong(0);

  // Mark an operation for a given request id to be start.
  void startOperation(OperationName operationName, String requestUniqueId) {
    try {
      // Skip the whole endOperation is profiler is not enabled.
      if (!enableProfiiler) {
        return;
      }
      if (!idToIndividualOperation.containsKey(requestUniqueId)) {
        if (idToIndividualOperation.size() > MAX_CACHED_REQUEST) {
          log.warning(
              String.format(
                  "startOperation is triggered for request_id: %s that's hasn't "
                      + "seen before, this is possible when "
                      + "we are recording too much ongoing requests. So far we has dropped %s operations.",
                  requestUniqueId, droppedOperationCount));
          droppedOperationCount.incrementAndGet();
          return;
        }
        idToIndividualOperation.put(
            requestUniqueId, new IndividualRequestProfiler(requestUniqueId));
      }
      idToIndividualOperation.get(requestUniqueId).startOperation(operationName);
    } catch (Exception ex) {
      // Mute any exception thrown from profiler process as we don't want to interrupt normal
      // operations.
      log.warning(
          "Exception thrown request profiler ignored, this is suggesting faulty implementation of "
              + "RequestProfiler, exception context: "
              + ex.toString());
    }
  }

  // Mark an operation for a given request id to be end.
  void endOperation(OperationName operationName, String requestUniqueId) {
    try {
      // Skip the whole endOperation is profiler is not enabled.
      if (!enableProfiiler) {
        return;
      }
      if (!idToIndividualOperation.containsKey(requestUniqueId)) {
        log.warning(
            String.format(
                "endOperation is triggered for request_id: %s that's hasn't "
                    + "seen before, this is possible when "
                    + "we are recording too much ongoing requests. So far we has dropped %s operations.",
                requestUniqueId, droppedOperationCount));
        return;
      }
      idToIndividualOperation.get(requestUniqueId).endOperation(operationName);
    } catch (Exception ex) {
      // Mute any exception thrown from profiler process as we don't want to interrupt normal
      // operations.
      log.warning(
          "Exception thrown request profiler ignored, this is suggesting faulty implementation of "
              + "RequestProfiler, exception context: "
              + ex.toString());
    }
  }

  void flushAndPrintReport() {
    if (!enableProfiiler) {
      // Only do work when enabled.
      return;
    }
    log.info(flushAndGenerateReportText());
  }

  // Periodically trigger the report generation.
  void startPeriodicalReportFlushing() {
    this.enableProfiiler = true;
    this.flushThread =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  while (true) {
                    try {
                      TimeUnit.MILLISECONDS.sleep(FLUSH_PERIOD.toMillis());
                    } catch (InterruptedException e) {
                      log.warning("Flush report thread is interrupted by " + e.toString());
                      throw new RuntimeException(e);
                    }
                    flushAndPrintReport();
                  }
                } catch (Exception ex) {
                  // Mute any exception thrown from profiler process as we don't want to
                  // interrupt normal operations.
                  log.warning(
                      "Exception thrown request profiler ignored, this is suggesting faulty "
                          + "implementation of "
                          + "RequestProfiler, exception context: "
                          + ex.toString());
                }
              }
            });
    this.flushThread.start();
  }

  String flushAndGenerateReportText() {
    RequestProfilerComparator comparator = new RequestProfilerComparator();

    // Find the top k requests with the longest latency.
    PriorityQueue<IndividualRequestProfiler> minHeap =
        new PriorityQueue<IndividualRequestProfiler>(comparator);
    Iterator<Entry<String, IndividualRequestProfiler>> iterator =
        idToIndividualOperation.entrySet().iterator();
    int finishedRequestCount = 0;
    // Iterate through all the requests stats, add to min heap if that's a finished request and has
    // longer total
    // latency than the least amount of latency in the min heap.
    while (iterator.hasNext()) {
      Entry<String, IndividualRequestProfiler> individualRequestProfiler = iterator.next();
      if (!individualRequestProfiler.getValue().finalized) {
        continue;
      }
      finishedRequestCount++;
      if (minHeap.size() < TOP_K
          || individualRequestProfiler.getValue().totalTime > minHeap.peek().totalTime) {
        minHeap.add(individualRequestProfiler.getValue());
      }
      if (minHeap.size() > TOP_K) {
        minHeap.poll();
      }
      // Remove during using iterator is safe.
      iterator.remove();
    }

    // Generate report for the TOP_K longest requests.
    String reportText =
        String.format(
            "During the last %s milliseconds at system time %s, in total %s requests finished. Total dropped "
                + "request is %s. The top %s long latency requests details report:\n",
            FLUSH_PERIOD.toMillis(),
            System.currentTimeMillis(),
            finishedRequestCount,
            droppedOperationCount.getAndSet(0),
            TOP_K);
    if (minHeap.isEmpty()) {
      reportText += "-----------------------------\n";
      reportText += "\t0 requests finished during the last period.";
    } else {
      // Print the report for the top k requests.
      ArrayList<String> reportList = new ArrayList<>();
      while (minHeap.size() > 0) {
        reportList.add("-----------------------------\n" + minHeap.poll().generateReport());
      }
      // Output in reverse order to make sure the longest latency request shows up in front.
      for (int i = 0; i < reportList.size(); i++) {
        reportText += reportList.get(reportList.size() - i - 1);
      }
    }
    return reportText;
  }

  // Min heap comparator
  private class RequestProfilerComparator implements Comparator<IndividualRequestProfiler> {
    @Override
    public int compare(IndividualRequestProfiler x, IndividualRequestProfiler y) {
      if (x.totalTime > y.totalTime) {
        return 1;
      } else if (x.totalTime < y.totalTime) {
        return -1;
      }
      return 0;
    }
  }

  /**
   * Record the profiling information for each individual request. Act like a buffer of the past
   * requests, either finished or not finished.
   */
  private static final class IndividualRequestProfiler {
    // From operation name to the list of time spent each time we do this operation.
    // e.g. some operation is retried two times, resulting in two time recorded in the queue.
    private final Map<OperationName, Queue<Long>> timeRecorderMap;

    // All current finished operations.
    private final List<IndividualOperation> finishedOperations;

    private final String requestUniqueId;

    // TOTAL_REQUEST has been marked as finished for this request. In this state `finalized` will
    // be true and totalTime will have non zero value.
    private long totalTime;
    private boolean finalized;

    IndividualRequestProfiler(String requestUniqueId) {
      this.timeRecorderMap = new ConcurrentHashMap<>();
      this.finishedOperations = Collections.synchronizedList(new ArrayList<IndividualOperation>());
      this.requestUniqueId = requestUniqueId;
    }

    void startOperation(OperationName operationName) {
      timeRecorderMap.putIfAbsent(operationName, new ConcurrentLinkedDeque<>());
      // Please be aware that System.currentTimeMillis() is not accurate in Windows system.
      timeRecorderMap.get(operationName).add(System.currentTimeMillis());
    }

    void endOperation(OperationName operationName) {
      if (!timeRecorderMap.containsKey(operationName)) {
        String warningMessage =
            String.format(
                "Operation %s ignored for request %s due to "
                    + "startOperation() is not called before calling endOperation().",
                operationName, requestUniqueId);
        log.warning(warningMessage);
        return;
      }
      if (timeRecorderMap.get(operationName).isEmpty()) {
        String warningMessage =
            String.format(
                "Operation %s ignored for request %s due to no previous startOperation() triggered for "
                    + "this operation",
                operationName, requestUniqueId);
        log.warning(warningMessage);
        return;
      }

      long startTime = timeRecorderMap.get(operationName).poll();
      long endTime = System.currentTimeMillis();
      long totalTime = endTime - startTime;
      finishedOperations.add(new IndividualOperation(operationName, startTime, endTime, totalTime));
      if (operationName == OperationName.TOTAL_LATENCY) {
        finalized = true;
        this.totalTime = totalTime;
      }
    }

    String generateReport() {
      String message =
          "\tRequest uuid: "
              + requestUniqueId
              + " with total time "
              + this.totalTime
              + " milliseconds\n";
      for (int i = 0; i < finishedOperations.size(); i++) {
        if (finishedOperations.get(i).operationName == OperationName.TOTAL_LATENCY) {
          continue;
        }
        message += "\t\t";
        message += finishedOperations.get(i).format();
        message += "\n";
      }
      return message;
    }

    // Record the stats of individual operation.
    private static final class IndividualOperation {
      OperationName operationName;

      // Runtime stats for individual operation.
      long totalTime;
      long startTimestamp;
      long endTimestamp;

      IndividualOperation(
          OperationName operationName, long startTimestamp, long endTimestamp, long totalTime) {
        this.operationName = operationName;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.totalTime = totalTime;
      }

      String format() {
        return String.format(
            "Operation name %s starts at: %s, ends at: " + "%s, total time: %s milliseconds",
            operationName.operationName, startTimestamp, endTimestamp, totalTime);
      }
    }
  }

  // Sets how many top latency requests to log during every report period.
  public static void setTopKRequestsToLog(int topK) {
    TOP_K = topK;
  }

  // Sets the report period of the profiler.
  public static void setReportPeriod(Duration flushPeriod) {
    FLUSH_PERIOD = flushPeriod;
  }

  @VisibleForTesting
  void enableProfiler() {
    this.enableProfiiler = true;
  }

  void internalDisableAndClearProfiler() {
    this.enableProfiiler = false;
    if (this.flushThread != null) {
      this.flushThread.interrupt();
    }
    this.idToIndividualOperation.clear();
    this.droppedOperationCount.set(0);

    // Set back to default value.
    TOP_K = DEFAULT_TOP_K;
    FLUSH_PERIOD = DEFAULT_FLUSH_PERIOD;
  }

  public static void disableAndClearProfiler() {
    REQUEST_PROFILER_SINGLETON.internalDisableAndClearProfiler();
  }
}
