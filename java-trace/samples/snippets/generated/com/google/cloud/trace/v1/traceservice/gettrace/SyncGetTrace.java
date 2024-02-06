/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.trace.v1.samples;

// [START cloudtrace_v1_generated_TraceService_GetTrace_sync]
import com.google.cloud.trace.v1.TraceServiceClient;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.Trace;

public class SyncGetTrace {

  public static void main(String[] args) throws Exception {
    syncGetTrace();
  }

  public static void syncGetTrace() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
      GetTraceRequest request =
          GetTraceRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setTraceId("traceId-1067401920")
              .build();
      Trace response = traceServiceClient.getTrace(request);
    }
  }
}
// [END cloudtrace_v1_generated_TraceService_GetTrace_sync]
