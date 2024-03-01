/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.trace.v2.samples;

// [START cloudtrace_v2_generated_TraceService_CreateSpan_sync]
import com.google.cloud.trace.v2.TraceServiceClient;
import com.google.devtools.cloudtrace.v2.Span;
import com.google.devtools.cloudtrace.v2.SpanName;
import com.google.devtools.cloudtrace.v2.StackTrace;
import com.google.devtools.cloudtrace.v2.TruncatableString;
import com.google.protobuf.BoolValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;

public class SyncCreateSpan {

  public static void main(String[] args) throws Exception {
    syncCreateSpan();
  }

  public static void syncCreateSpan() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
      Span request =
          Span.newBuilder()
              .setName(SpanName.of("[PROJECT]", "[TRACE]", "[SPAN]").toString())
              .setSpanId("spanId-896182779")
              .setParentSpanId("parentSpanId1059234639")
              .setDisplayName(TruncatableString.newBuilder().build())
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .setAttributes(Span.Attributes.newBuilder().build())
              .setStackTrace(StackTrace.newBuilder().build())
              .setTimeEvents(Span.TimeEvents.newBuilder().build())
              .setLinks(Span.Links.newBuilder().build())
              .setStatus(Status.newBuilder().build())
              .setSameProcessAsParentSpan(BoolValue.newBuilder().build())
              .setChildSpanCount(Int32Value.newBuilder().build())
              .build();
      Span response = traceServiceClient.createSpan(request);
    }
  }
}
// [END cloudtrace_v2_generated_TraceService_CreateSpan_sync]
