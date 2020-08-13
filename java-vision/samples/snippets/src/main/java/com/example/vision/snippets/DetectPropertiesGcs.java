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

// [START vision_image_property_detection_gcs]

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.ColorInfo;
import com.google.cloud.vision.v1.DominantColorsAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DetectPropertiesGcs {

  public static void detectPropertiesGcs() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String filePath = "gs://your-gcs-bucket/path/to/image/file.jpg";
    detectPropertiesGcs(filePath);
  }

  // Detects image properties such as color frequency from the specified remote image on Google
  // Cloud Storage.
  public static void detectPropertiesGcs(String gcsPath) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Feature.Type.IMAGE_PROPERTIES).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
      List<AnnotateImageResponse> responses = response.getResponsesList();

      for (AnnotateImageResponse res : responses) {
        if (res.hasError()) {
          System.out.format("Error: %s%n", res.getError().getMessage());
          return;
        }

        // For full list of available annotations, see http://g.co/cloud/vision/docs
        DominantColorsAnnotation colors = res.getImagePropertiesAnnotation().getDominantColors();
        for (ColorInfo color : colors.getColorsList()) {
          System.out.format(
              "fraction: %f%nr: %f, g: %f, b: %f%n",
              color.getPixelFraction(),
              color.getColor().getRed(),
              color.getColor().getGreen(),
              color.getColor().getBlue());
        }
      }
    }
  }
}
// [END vision_image_property_detection_gcs]
