/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in READMEs. Any change to this file should be reflected in
 * the project's READMEs.
 */

package com.google.cloud.examples.vision.snippets;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.FieldDescriptor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A snippet for Google Cloud Vision API demonstrating how to determine what is shown on a picture.
 */
public class AnnotateImage {
  public static void main(String... args) throws Exception {
    // Instantiates a client
    ImageAnnotatorClient vision = ImageAnnotatorClient.create();

    // The path to the image file to annotate
    String fileName = "your/image/path.jpg"; // for example "./resources/wakeupcat.jpg";

    // Reads the image file into memory
    Path path = Paths.get(fileName);
    byte[] data = Files.readAllBytes(path);
    ByteString imgBytes = ByteString.copyFrom(data);

    // Builds the image annotation request
    List<AnnotateImageRequest> requests = new ArrayList<>();
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    requests.add(request);

    // Performs label detection on the image file
    BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
    List<AnnotateImageResponse> responses = response.getResponsesList();

    for (AnnotateImageResponse res : responses) {
      if (res.hasError()) {
        System.out.printf("Error: %s\n", res.getError().getMessage());
        return;
      }

      for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
        for (Map.Entry<FieldDescriptor, Object> entry : annotation.getAllFields().entrySet()) {
          System.out.printf("%s : %s\n", entry.getKey(), entry.getValue());
        }
      }
    }
  }
}
