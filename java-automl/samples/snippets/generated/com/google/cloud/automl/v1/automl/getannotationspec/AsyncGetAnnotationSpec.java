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

package com.google.cloud.automl.v1.samples;

// [START automl_v1_generated_AutoMl_GetAnnotationSpec_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.automl.v1.AnnotationSpec;
import com.google.cloud.automl.v1.AnnotationSpecName;
import com.google.cloud.automl.v1.AutoMlClient;
import com.google.cloud.automl.v1.GetAnnotationSpecRequest;

public class AsyncGetAnnotationSpec {

  public static void main(String[] args) throws Exception {
    asyncGetAnnotationSpec();
  }

  public static void asyncGetAnnotationSpec() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (AutoMlClient autoMlClient = AutoMlClient.create()) {
      GetAnnotationSpecRequest request =
          GetAnnotationSpecRequest.newBuilder()
              .setName(
                  AnnotationSpecName.of("[PROJECT]", "[LOCATION]", "[DATASET]", "[ANNOTATION_SPEC]")
                      .toString())
              .build();
      ApiFuture<AnnotationSpec> future =
          autoMlClient.getAnnotationSpecCallable().futureCall(request);
      // Do something.
      AnnotationSpec response = future.get();
    }
  }
}
// [END automl_v1_generated_AutoMl_GetAnnotationSpec_async]
