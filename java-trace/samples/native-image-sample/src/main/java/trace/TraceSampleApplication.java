/*
 * Copyright 2020-2021 Google LLC
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

package trace;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.ServiceOptions;
import com.google.cloud.trace.v1.TraceServiceClient;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.TraceSpan;
import com.google.devtools.cloudtrace.v1.Traces;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import java.util.UUID;

/** Sample application demonstrating using the Google Trace client libraries. */
public class TraceSampleApplication {

  /** Runs basic methods in the Trace client libraries. */
  public static void main(String[] args) throws IOException, InterruptedException {
    String projectId = ServiceOptions.getDefaultProjectId();
    TraceServiceClient traceServiceClient = TraceServiceClient.create();

    // Create a trace in the current project.
    String traceId = UUID.randomUUID().toString().replaceAll("-", "");
    PatchTracesRequest createRequest = createPatchTraceRequest(traceId, projectId);
    traceServiceClient.patchTraces(createRequest);

    // Wait for the trace to be populated in Cloud Trace.
    System.out.println("Wait some time for the Trace to be populated.");
    Thread.sleep(15000);

    try {
      // This checks Cloud trace for the new trace that was just created.
      GetTraceRequest getTraceRequest =
          GetTraceRequest.newBuilder().setProjectId(projectId).setTraceId(traceId).build();

      Trace trace = traceServiceClient.getTrace(getTraceRequest);

      System.out.println("Retrieved trace: " + trace.getTraceId());
      System.out.println("It has the following spans: ");
      for (TraceSpan span : trace.getSpansList()) {
        System.out.println("Span: " + span.getName());
      }
    } catch (NotFoundException e) {
      System.out.println(
          "We didn't find the trace: "
              + traceId
              + ". "
              + "This is usually because we did not wait long enough. "
              + "Please check https://console.cloud.google.com/traces/traces to "
              + "find your trace in the traces viewer.");
    }
  }

  private static PatchTracesRequest createPatchTraceRequest(String traceId, String projectId) {
    long currentTime = Instant.now().toEpochMilli() / 1000;

    Trace trace =
        Trace.newBuilder()
            .setProjectId(projectId)
            .setTraceId(traceId)
            .addSpans(
                TraceSpan.newBuilder()
                    .setSpanId(1)
                    .setName("nativeimage-trace-sample-test")
                    .setStartTime(Timestamp.newBuilder().setSeconds(currentTime - 5))
                    .setEndTime(Timestamp.newBuilder().setSeconds(currentTime)))
            .build();

    PatchTracesRequest request =
        PatchTracesRequest.newBuilder()
            .setProjectId(projectId)
            .setTraces(Traces.newBuilder().addTraces(trace))
            .build();

    return request;
  }
}
