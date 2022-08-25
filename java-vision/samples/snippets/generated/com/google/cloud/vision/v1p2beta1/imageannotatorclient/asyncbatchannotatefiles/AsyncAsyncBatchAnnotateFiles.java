/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.vision.v1p2beta1.samples;

// [START vision_v1p2beta1_generated_imageannotatorclient_asyncbatchannotatefiles_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.vision.v1p2beta1.AsyncAnnotateFileRequest;
import com.google.cloud.vision.v1p2beta1.AsyncBatchAnnotateFilesRequest;
import com.google.cloud.vision.v1p2beta1.ImageAnnotatorClient;
import com.google.longrunning.Operation;
import java.util.ArrayList;

public class AsyncAsyncBatchAnnotateFiles {

  public static void main(String[] args) throws Exception {
    asyncAsyncBatchAnnotateFiles();
  }

  public static void asyncAsyncBatchAnnotateFiles() throws Exception {
    // This snippet has been automatically generated for illustrative purposes only.
    // It may require modifications to work in your environment.
    try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
      AsyncBatchAnnotateFilesRequest request =
          AsyncBatchAnnotateFilesRequest.newBuilder()
              .addAllRequests(new ArrayList<AsyncAnnotateFileRequest>())
              .build();
      ApiFuture<Operation> future =
          imageAnnotatorClient.asyncBatchAnnotateFilesCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END vision_v1p2beta1_generated_imageannotatorclient_asyncbatchannotatefiles_async]
