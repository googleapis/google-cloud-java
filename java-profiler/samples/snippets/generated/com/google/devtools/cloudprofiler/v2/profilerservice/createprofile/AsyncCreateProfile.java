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

package com.google.devtools.cloudprofiler.v2.samples;

// [START cloudprofiler_v2_generated_ProfilerService_CreateProfile_async]
import com.google.api.core.ApiFuture;
import com.google.devtools.cloudprofiler.v2.CreateProfileRequest;
import com.google.devtools.cloudprofiler.v2.Deployment;
import com.google.devtools.cloudprofiler.v2.Profile;
import com.google.devtools.cloudprofiler.v2.ProfileType;
import com.google.devtools.cloudprofiler.v2.ProfilerServiceClient;
import com.google.devtools.cloudprofiler.v2.ProjectName;
import java.util.ArrayList;

public class AsyncCreateProfile {

  public static void main(String[] args) throws Exception {
    asyncCreateProfile();
  }

  public static void asyncCreateProfile() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (ProfilerServiceClient profilerServiceClient = ProfilerServiceClient.create()) {
      CreateProfileRequest request =
          CreateProfileRequest.newBuilder()
              .setParent(ProjectName.of("[PROJECT]").toString())
              .setDeployment(Deployment.newBuilder().build())
              .addAllProfileType(new ArrayList<ProfileType>())
              .build();
      ApiFuture<Profile> future = profilerServiceClient.createProfileCallable().futureCall(request);
      // Do something.
      Profile response = future.get();
    }
  }
}
// [END cloudprofiler_v2_generated_ProfilerService_CreateProfile_async]
