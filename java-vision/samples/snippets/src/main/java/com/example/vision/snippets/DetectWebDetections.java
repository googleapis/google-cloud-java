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

// [START vision_web_detection]

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.WebDetection;
import com.google.cloud.vision.v1.WebDetection.WebEntity;
import com.google.cloud.vision.v1.WebDetection.WebImage;
import com.google.cloud.vision.v1.WebDetection.WebLabel;
import com.google.cloud.vision.v1.WebDetection.WebPage;
import com.google.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DetectWebDetections {

  public static void detectWebDetections() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String filePath = "path/to/your/image/file.jpg";
    detectWebDetections(filePath);
  }

  // Finds references to the specified image on the web.
  public static void detectWebDetections(String filePath) throws IOException {
    List<AnnotateImageRequest> requests = new ArrayList<>();

    ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
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

        // Search the web for usages of the image. You could use these signals later
        // for user input moderation or linking external references.
        // For a full list of available annotations, see http://g.co/cloud/vision/docs
        WebDetection annotation = res.getWebDetection();
        System.out.println("Entity:Id:Score");
        System.out.println("===============");
        for (WebEntity entity : annotation.getWebEntitiesList()) {
          System.out.println(
              entity.getDescription() + " : " + entity.getEntityId() + " : " + entity.getScore());
        }
        for (WebLabel label : annotation.getBestGuessLabelsList()) {
          System.out.format("%nBest guess label: %s", label.getLabel());
        }
        System.out.println("%nPages with matching images: Score%n==");
        for (WebPage page : annotation.getPagesWithMatchingImagesList()) {
          System.out.println(page.getUrl() + " : " + page.getScore());
        }
        System.out.println("%nPages with partially matching images: Score%n==");
        for (WebImage image : annotation.getPartialMatchingImagesList()) {
          System.out.println(image.getUrl() + " : " + image.getScore());
        }
        System.out.println("%nPages with fully matching images: Score%n==");
        for (WebImage image : annotation.getFullMatchingImagesList()) {
          System.out.println(image.getUrl() + " : " + image.getScore());
        }
        System.out.println("%nPages with visually similar images: Score%n==");
        for (WebImage image : annotation.getVisuallySimilarImagesList()) {
          System.out.println(image.getUrl() + " : " + image.getScore());
        }
      }
    }
  }
}
// [END vision_web_detection]
