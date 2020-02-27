/*
 * Copyright 2020 Google LLC
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
// DO NOT EDIT! This is a generated sample ("LongRunningRequestAsync",  "vision_async_batch_annotate_images")
// sample-metadata:
//   title: Async Batch Image Annotation
//   description: Perform async batch image annotation
//   usage: gradle run -PmainClass=com.google.cloud.examples.vision.v1.VisionAsyncBatchAnnotateImages [--args='[--input_image_uri "gs://cloud-samples-data/vision/label/wakeupcat.jpg"] [--output_uri "gs://your-bucket/prefix/"]']

package com.google.cloud.examples.vision.v1;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AsyncBatchAnnotateImagesRequest;
import com.google.cloud.vision.v1.AsyncBatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.GcsDestination;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageSource;
import com.google.cloud.vision.v1.OperationMetadata;
import com.google.cloud.vision.v1.OutputConfig;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class VisionAsyncBatchAnnotateImages {
  // [START vision_async_batch_annotate_images]
  /*
   * Please include the following imports to run this sample.
   *
   * import com.google.api.gax.longrunning.OperationFuture;
   * import com.google.cloud.vision.v1.AnnotateImageRequest;
   * import com.google.cloud.vision.v1.AsyncBatchAnnotateImagesRequest;
   * import com.google.cloud.vision.v1.AsyncBatchAnnotateImagesResponse;
   * import com.google.cloud.vision.v1.Feature;
   * import com.google.cloud.vision.v1.GcsDestination;
   * import com.google.cloud.vision.v1.Image;
   * import com.google.cloud.vision.v1.ImageAnnotatorClient;
   * import com.google.cloud.vision.v1.ImageSource;
   * import com.google.cloud.vision.v1.OperationMetadata;
   * import com.google.cloud.vision.v1.OutputConfig;
   * import java.util.Arrays;
   * import java.util.List;
   */

  public static void sampleAsyncBatchAnnotateImages() {
    // TODO(developer): Replace these variables before running the sample.
    String inputImageUri = "gs://cloud-samples-data/vision/label/wakeupcat.jpg";
    String outputUri = "gs://your-bucket/prefix/";
    sampleAsyncBatchAnnotateImages(inputImageUri, outputUri);
  }

  /** Perform async batch image annotation */
  public static void sampleAsyncBatchAnnotateImages(String inputImageUri, String outputUri) {
    try (ImageAnnotatorClient imageAnnotatorClient = ImageAnnotatorClient.create()) {
      ImageSource source = ImageSource.newBuilder().setImageUri(inputImageUri).build();
      Image image = Image.newBuilder().setSource(source).build();
      Feature.Type type = Feature.Type.LABEL_DETECTION;
      Feature featuresElement = Feature.newBuilder().setType(type).build();
      Feature.Type type2 = Feature.Type.IMAGE_PROPERTIES;
      Feature featuresElement2 = Feature.newBuilder().setType(type2).build();
      List<Feature> features = Arrays.asList(featuresElement, featuresElement2);
      AnnotateImageRequest requestsElement =
          AnnotateImageRequest.newBuilder().setImage(image).addAllFeatures(features).build();
      List<AnnotateImageRequest> requests = Arrays.asList(requestsElement);
      GcsDestination gcsDestination = GcsDestination.newBuilder().setUri(outputUri).build();

      // The max number of responses to output in each JSON file
      int batchSize = 2;
      OutputConfig outputConfig =
          OutputConfig.newBuilder()
              .setGcsDestination(gcsDestination)
              .setBatchSize(batchSize)
              .build();
      AsyncBatchAnnotateImagesRequest request =
          AsyncBatchAnnotateImagesRequest.newBuilder()
              .addAllRequests(requests)
              .setOutputConfig(outputConfig)
              .build();
      OperationFuture<AsyncBatchAnnotateImagesResponse, OperationMetadata> future =
          imageAnnotatorClient.asyncBatchAnnotateImagesAsync(request);

      System.out.println("Waiting for operation to complete...");
      AsyncBatchAnnotateImagesResponse response = future.get();
      // The output is written to GCS with the provided output_uri as prefix
      String gcsOutputUri = response.getOutputConfig().getGcsDestination().getUri();
      System.out.printf("Output written to GCS with prefix: %s\n", gcsOutputUri);
    } catch (Exception exception) {
      System.err.println("Failed to create the client due to: " + exception);
    }
  }
  // [END vision_async_batch_annotate_images]

  public static void main(String[] args) throws Exception {
    Options options = new Options();
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("input_image_uri").build());
    options.addOption(
        Option.builder("").required(false).hasArg(true).longOpt("output_uri").build());

    CommandLine cl = (new DefaultParser()).parse(options, args);
    String inputImageUri =
        cl.getOptionValue("input_image_uri", "gs://cloud-samples-data/vision/label/wakeupcat.jpg");
    String outputUri = cl.getOptionValue("output_uri", "gs://your-bucket/prefix/");

    sampleAsyncBatchAnnotateImages(inputImageUri, outputUri);
  }
}
