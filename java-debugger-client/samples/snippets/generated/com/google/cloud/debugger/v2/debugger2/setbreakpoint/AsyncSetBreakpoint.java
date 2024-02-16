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

package com.google.cloud.debugger.v2.samples;

// [START clouddebugger_v2_generated_Debugger2_SetBreakpoint_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.debugger.v2.Debugger2Client;
import com.google.devtools.clouddebugger.v2.Breakpoint;
import com.google.devtools.clouddebugger.v2.SetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.SetBreakpointResponse;

public class AsyncSetBreakpoint {

  public static void main(String[] args) throws Exception {
    asyncSetBreakpoint();
  }

  public static void asyncSetBreakpoint() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (Debugger2Client debugger2Client = Debugger2Client.create()) {
      SetBreakpointRequest request =
          SetBreakpointRequest.newBuilder()
              .setDebuggeeId("debuggeeId-1833285553")
              .setBreakpoint(Breakpoint.newBuilder().build())
              .setClientVersion("clientVersion771880589")
              .build();
      ApiFuture<SetBreakpointResponse> future =
          debugger2Client.setBreakpointCallable().futureCall(request);
      // Do something.
      SetBreakpointResponse response = future.get();
    }
  }
}
// [END clouddebugger_v2_generated_Debugger2_SetBreakpoint_async]
