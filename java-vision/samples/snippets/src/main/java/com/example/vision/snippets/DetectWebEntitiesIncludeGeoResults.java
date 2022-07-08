/*
 * Copyright 2017 Google Inc.
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

// [START vision_web_detection_include_geo]

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageContext;
import com.google.cloud.vision.v1.WebDetectionParams;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class DetectWebEntitiesIncludeGeoResults {

  public static void detectWebEntitiesIncludeGeoResults() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String filePath = "path/to/your/image/file.jpg";
    detectWebEntitiesIncludeGeoResults(filePath);
  }

  // Find web entities given a local image.
  public static void detectWebEntitiesIncludeGeoResults(String filePath) throws IOException {

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      // Read in the local image
      ByteString contents = ByteString.readFrom(new FileInputStream(filePath));

      // Build the image
      Image image = Image.newBuilder().setContent(contents).build();

      // Enable `IncludeGeoResults`
      WebDetectionParams webDetectionParams =
          WebDetectionParams.newBuilder().setIncludeGeoResults(true).build();

      // Set the parameters for the image
      ImageContext imageContext =
          ImageContext.newBuilder().setWebDetectionParams(webDetectionParams).build();

      // Create the request with the image, imageContext, and the specified feature: web detection
      AnnotateImageRequest request =
          AnnotateImageRequest.newBuilder()
              .addFeatures(Feature.newBuilder().setType(Type.WEB_DETECTION))
              .setImage(image)
              .setImageContext(imageContext)
              .build();

      // Perform the request
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(Arrays.asList(request));

      // Display the results
      response.getResponsesList().stream()
          .forEach(
              r ->
                  r.getWebDetection().getWebEntitiesList().stream()
                      .forEach(
                          entity -> {
                            System.out.format("Description: %s%n", entity.getDescription());
                            System.out.format("Score: %f%n", entity.getScore());
                          }));
    }
  }
}
// [END vision_web_detection_include_geo]
