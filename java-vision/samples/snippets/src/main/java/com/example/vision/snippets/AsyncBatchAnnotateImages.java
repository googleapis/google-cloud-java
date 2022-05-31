/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.vision.snippets;

// [START vision_async_batch_annotate_images]
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AsyncBatchAnnotateImagesRequest;
import com.google.cloud.vision.v1.AsyncBatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.GcsDestination;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageSource;
import com.google.cloud.vision.v1.OutputConfig;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class AsyncBatchAnnotateImages {

  public static void asyncBatchAnnotateImages()
      throws InterruptedException, ExecutionException, IOException {
    String inputImageUri = "gs://cloud-samples-data/vision/label/wakeupcat.jpg";
    String outputUri = "gs://YOUR_BUCKET_ID/path/to/save/results/";
    asyncBatchAnnotateImages(inputImageUri, outputUri);
  }

  public static void asyncBatchAnnotateImages(String inputImageUri, String outputUri)
      throws IOException, ExecutionException, InterruptedException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {

      // You can send multiple images to be annotated, this sample demonstrates how to do this with
      // one image. If you want to use multiple images, you have to create a `AnnotateImageRequest`
      // object for each image that you want annotated.
      // First specify where the vision api can find the image
      ImageSource source = ImageSource.newBuilder().setImageUri(inputImageUri).build();
      Image image = Image.newBuilder().setSource(source).build();

      // Set the type of annotation you want to perform on the image
      // https://cloud.google.com/vision/docs/reference/rpc/google.cloud.vision.v1#google.cloud.vision.v1.Feature.Type
      Feature feature = Feature.newBuilder().setType(Feature.Type.LABEL_DETECTION).build();

      // Build the request object for that one image. Note: for additional images you have to create
      // additional `AnnotateImageRequest` objects and store them in a list to be used below.
      AnnotateImageRequest imageRequest =
          AnnotateImageRequest.newBuilder().setImage(image).addFeatures(feature).build();

      // Set where to store the results for the images that will be annotated.
      GcsDestination gcsDestination = GcsDestination.newBuilder().setUri(outputUri).build();
      OutputConfig outputConfig =
          OutputConfig.newBuilder()
              .setGcsDestination(gcsDestination)
              .setBatchSize(2) // The max number of responses to output in each JSON file
              .build();

      // Add each `AnnotateImageRequest` object to the batch request and add the output config.
      AsyncBatchAnnotateImagesRequest request =
          AsyncBatchAnnotateImagesRequest.newBuilder()
              .addRequests(imageRequest)
              .setOutputConfig(outputConfig)
              .build();

      // Make the asynchronous batch request.
      AsyncBatchAnnotateImagesResponse response =
          imageAnnotatorClient.asyncBatchAnnotateImagesAsync(request).get();

      // The output is written to GCS with the provided output_uri as prefix
      String gcsOutputUri = response.getOutputConfig().getGcsDestination().getUri();
      System.out.format("Output written to GCS with prefix: %s%n", gcsOutputUri);
    }
  }
}
// [END vision_async_batch_annotate_images]
