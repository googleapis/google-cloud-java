/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.vision.v1;

import com.google.cloud.vision.v1.Feature.Type;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@javax.annotation.Generated("by GAPIC")
public class ImageAnnotatorSmokeTest {
  private static final String PROJECT_ENV_NAME = "GOOGLE_CLOUD_PROJECT";
  private static final String LEGACY_PROJECT_ENV_NAME = "GCLOUD_PROJECT";

  public static void main(String args[]) {
    Logger.getLogger("").setLevel(Level.WARNING);
    try {
      executeNoCatch();
      System.out.println("OK");
    } catch (Exception e) {
      System.err.println("Failed with exception:");
      e.printStackTrace(System.err);
      System.exit(1);
    }
  }

  public static void executeNoCatch() throws Exception {
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      String gcsImageUri = "gs://gapic-toolkit/President_Barack_Obama.jpg";
      ImageSource source = ImageSource.newBuilder().setGcsImageUri(gcsImageUri).build();
      Image image = Image.newBuilder().setSource(source).build();
      Feature.Type type = Feature.Type.FACE_DETECTION;
      Feature featuresElement = Feature.newBuilder().setType(type).build();
      List<Feature> features = Arrays.asList(featuresElement);
      AnnotateImageRequest requestsElement =
          AnnotateImageRequest.newBuilder().setImage(image).addAllFeatures(features).build();
      List<AnnotateImageRequest> requests = Arrays.asList(requestsElement);

      BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
    }
  }

  private static String getProjectId() {
    String projectId = System.getProperty(PROJECT_ENV_NAME, System.getenv(PROJECT_ENV_NAME));
    if (projectId == null) {
      projectId =
          System.getProperty(LEGACY_PROJECT_ENV_NAME, System.getenv(LEGACY_PROJECT_ENV_NAME));
    }
    Preconditions.checkArgument(projectId != null, "A project ID is required.");
    return projectId;
  }
}
