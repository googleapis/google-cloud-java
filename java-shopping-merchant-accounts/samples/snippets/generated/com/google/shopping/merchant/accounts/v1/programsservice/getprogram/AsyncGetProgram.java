/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.accounts.v1.samples;

// [START merchantapi_v1_generated_ProgramsService_GetProgram_async]
import com.google.api.core.ApiFuture;
import com.google.shopping.merchant.accounts.v1.GetProgramRequest;
import com.google.shopping.merchant.accounts.v1.Program;
import com.google.shopping.merchant.accounts.v1.ProgramName;
import com.google.shopping.merchant.accounts.v1.ProgramsServiceClient;

public class AsyncGetProgram {

  public static void main(String[] args) throws Exception {
    asyncGetProgram();
  }

  public static void asyncGetProgram() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ProgramsServiceClient programsServiceClient = ProgramsServiceClient.create()) {
      GetProgramRequest request =
          GetProgramRequest.newBuilder()
              .setName(ProgramName.of("[ACCOUNT]", "[PROGRAM]").toString())
              .build();
      ApiFuture<Program> future = programsServiceClient.getProgramCallable().futureCall(request);
      // Do something.
      Program response = future.get();
    }
  }
}
// [END merchantapi_v1_generated_ProgramsService_GetProgram_async]
