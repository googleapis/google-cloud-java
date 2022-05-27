/*
 * Copyright 2019 Google LLC
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

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageAnnotatorSettings;
import com.google.cloud.vision.v1.ImageSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetEndpoint {

  // Change your endpoint
  public static void setEndpoint() throws IOException {
    // [START vision_set_endpoint]
    ImageAnnotatorSettings settings =
        ImageAnnotatorSettings.newBuilder().setEndpoint("eu-vision.googleapis.com:443").build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    ImageAnnotatorClient client = ImageAnnotatorClient.create(settings);
    // [END vision_set_endpoint]

    ImageSource imgSource =
        ImageSource.newBuilder()
            .setGcsImageUri("gs://cloud-samples-data/vision/text/screen.jpg")
            .build();
    Image image = Image.newBuilder().setSource(imgSource).build();
    Feature feature = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feature).setImage(image).build();
    List<AnnotateImageRequest> requests = new ArrayList<>();
    requests.add(request);

    BatchAnnotateImagesResponse batchResponse = client.batchAnnotateImages(requests);

    for (AnnotateImageResponse response : batchResponse.getResponsesList()) {
      for (EntityAnnotation annotation : response.getTextAnnotationsList()) {
        System.out.format("Text: %s%n", annotation.getDescription());
        System.out.println("Position:");
        System.out.format("%s%n", annotation.getBoundingPoly());
      }
    }
    client.close();
  }
}
