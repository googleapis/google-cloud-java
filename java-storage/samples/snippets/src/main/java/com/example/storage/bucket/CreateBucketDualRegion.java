/*
 * Copyright 2022 Google LLC
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

package com.example.storage.bucket;

// [START storage_create_bucket_dual_region]

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.CustomPlacementConfig;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.Arrays;

public class CreateBucketDualRegion {

  public static void createBucketDualRegion(
      String projectId,
      String bucketName,
      String location,
      String firstRegion,
      String secondRegion) {
    // The ID of your GCP project.
    // String projectId = "your-project-id";

    // The ID to give your GCS bucket.
    // String bucketName = "your-unique-bucket-name";

    // The location your dual regions will be located in.
    // String location = "US";

    // One of the regions the dual region bucket is to be created in.
    // String firstRegion = "US-EAST1";

    // The second region the dual region bucket is to be created in.
    // String secondRegion = "US-WEST1";

    // See this documentation for other valid locations and regions:
    // https://cloud.google.com/storage/docs/locations

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    CustomPlacementConfig config =
        CustomPlacementConfig.newBuilder()
            .setDataLocations(Arrays.asList(firstRegion, secondRegion))
            .build();

    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setLocation(location)
            .setCustomPlacementConfig(config)
            .build();

    Bucket bucket = storage.create(bucketInfo);

    System.out.println(
        "Created bucket "
            + bucket.getName()
            + " in location "
            + bucket.getLocation()
            + " with location type "
            + bucket.getLocationType()
            + " with Custom Placement Config "
            + bucket.getCustomPlacementConfig().toString());
  }
}
// [END storage_create_bucket_dual_region]
