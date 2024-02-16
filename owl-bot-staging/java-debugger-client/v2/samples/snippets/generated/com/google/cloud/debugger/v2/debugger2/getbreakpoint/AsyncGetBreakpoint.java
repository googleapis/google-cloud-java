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

// [START clouddebugger_v2_generated_Debugger2_GetBreakpoint_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.debugger.v2.Debugger2Client;
import com.google.devtools.clouddebugger.v2.GetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointResponse;

public class AsyncGetBreakpoint {

  public static void main(String[] args) throws Exception {
    asyncGetBreakpoint();
  }

  public static void asyncGetBreakpoint() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (Debugger2Client debugger2Client = Debugger2Client.create()) {
      GetBreakpointRequest request =
          GetBreakpointRequest.newBuilder()
              .setDebuggeeId("debuggeeId-1833285553")
              .setBreakpointId("breakpointId570266860")
              .setClientVersion("clientVersion771880589")
              .build();
      ApiFuture<GetBreakpointResponse> future =
          debugger2Client.getBreakpointCallable().futureCall(request);
      // Do something.
      GetBreakpointResponse response = future.get();
    }
  }
}
// [END clouddebugger_v2_generated_Debugger2_GetBreakpoint_async]
