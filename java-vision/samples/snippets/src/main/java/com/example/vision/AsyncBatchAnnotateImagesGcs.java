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

package com.example.vision;

// [START vision_async_batch_annotate_images_beta]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.vision.v1p4beta1.AnnotateImageRequest;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesResponse;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse.Builder;
import com.google.cloud.vision.v1p4beta1.Feature;
import com.google.cloud.vision.v1p4beta1.Feature.Type;
import com.google.cloud.vision.v1p4beta1.GcsDestination;
import com.google.cloud.vision.v1p4beta1.Image;
import com.google.cloud.vision.v1p4beta1.ImageAnnotatorClient;
import com.google.cloud.vision.v1p4beta1.ImageSource;
import com.google.cloud.vision.v1p4beta1.OperationMetadata;
import com.google.cloud.vision.v1p4beta1.OutputConfig;
import com.google.protobuf.util.JsonFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsyncBatchAnnotateImagesGcs {

  // Performs asynchronous batch annotation of images on Google Cloud Storage
  public static void asyncBatchAnnotateImagesGcs(String gcsSourcePath, String gcsDestinationPath)
      throws Exception {
    // String gcsSourcePath = "gs://YOUR_BUCKET_ID/path_to_your_data";
    // String gcsDestinationPath = "gs://YOUR_BUCKET_ID/path_to_store_annotation";
    try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
      List<AnnotateImageRequest> requests = new ArrayList<>();

      ImageSource imgSource = ImageSource.newBuilder().setImageUri(gcsSourcePath).build();

      Image image = Image.newBuilder().setSource(imgSource).build();

      // Set the GCS destination path for where to save the results.
      GcsDestination gcsDestination =
          GcsDestination.newBuilder().setUri(gcsDestinationPath).build();

      // Create the configuration for the output with the batch size.
      // The batch size sets how many pages should be grouped into each json output file.
      OutputConfig outputConfig =
          OutputConfig.newBuilder().setGcsDestination(gcsDestination).setBatchSize(2).build();

      // Select the Features required by the vision API
      Feature features =
          Feature.newBuilder()
              .setType(Type.LABEL_DETECTION)
              .setType(Type.TEXT_DETECTION)
              .setType(Type.IMAGE_PROPERTIES)
              .build();

      // Build the request
      AnnotateImageRequest annotateImageRequest =
          AnnotateImageRequest.newBuilder().setImage(image).addFeatures(features).build();

      requests.add(annotateImageRequest);
      AsyncBatchAnnotateImagesRequest request =
          AsyncBatchAnnotateImagesRequest.newBuilder()
              .addAllRequests(requests)
              .setOutputConfig(outputConfig)
              .build();

      OperationFuture<AsyncBatchAnnotateImagesResponse, OperationMetadata> response =
          client.asyncBatchAnnotateImagesAsync(request);
      System.out.println("Waiting for the operation to finish.");

      // we're not processing the response, since we'll be reading the output from GCS.
      response.get(180, TimeUnit.SECONDS);

      // Once the request has completed and the output has been
      // written to GCS, we can list all the output files.
      Storage storage = StorageOptions.getDefaultInstance().getService();

      // Get the destination location from the gcsDestinationPath
      Pattern pattern = Pattern.compile("gs://([^/]+)/(.+)");
      Matcher matcher = pattern.matcher(gcsDestinationPath);

      if (matcher.find()) {
        String bucketName = matcher.group(1);
        String prefix = matcher.group(2);

        // Get the list of objects with the given prefix from the GCS bucket
        Bucket bucket = storage.get(bucketName);
        Page<Blob> pageList = bucket.list(BlobListOption.prefix(prefix));

        Blob firstOutputFile = null;

        // List objects with the given prefix.
        System.out.println("Output files:");
        for (Blob blob : pageList.iterateAll()) {
          System.out.println(blob.getName());

          // Process the first output file from GCS.
          // Since we specified batch size = 2, the first response contains
          // the first two image requests
          if (firstOutputFile == null) {
            firstOutputFile = blob;
          }
        }

        // Get the contents of the file and convert the JSON contents to an
        // BatchAnnotateImagesResponse
        // object. If the Blob is small read all its content in one request
        // (Note: the file is a .json file)
        // Storage guide: https://cloud.google.com/storage/docs/downloading-objects
        String jsonContents = new String(firstOutputFile.getContent());
        Builder builder = BatchAnnotateImagesResponse.newBuilder();
        JsonFormat.parser().merge(jsonContents, builder);

        // Build the AnnotateFileResponse object
        BatchAnnotateImagesResponse batchAnnotateImagesResponse = builder.build();

        // Here we print the response for the first image
        // The response contains more information:
        // annotation/pages/blocks/paragraphs/words/symbols/colors
        // including confidence score and bounding boxes
        System.out.format("\nResponse: %s\n", batchAnnotateImagesResponse.getResponses(0));

      } else {
        System.out.println("No MATCH");
      }
    } catch (Exception e) {
      System.out.println("Error during asyncBatchAnnotateImagesGcs: \n" + e.toString());
    }
  }
}

// [END vision_async_batch_annotate_images_beta]
