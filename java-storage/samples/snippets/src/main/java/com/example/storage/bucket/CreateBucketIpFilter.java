/*
 * Copyright 2026 Google LLC
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

package com.example.storage.bucket;

// [START storage_create_bucket_ip_filtering]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.IpFilter;
import com.google.cloud.storage.BucketInfo.IpFilter.PublicNetworkSource;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.Arrays;

public class CreateBucketIpFilter {
  public static void createBucketIpFilter(
      String projectId, String bucketName, String publicCidrRange) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID to give your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The public IPv4 CIDR range to allow
    // String publicCidrRange = "192.0.2.0/24";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    IpFilter ipFilter =
        IpFilter.newBuilder()
            .setMode("Disabled")
            .setAllowAllServiceAgentAccess(true)
            .setPublicNetworkSource(PublicNetworkSource.of(Arrays.asList(publicCidrRange)))
            .build();

    BucketInfo bucketInfo = BucketInfo.newBuilder(bucketName).setIpFilter(ipFilter).build();

    Bucket bucket = storage.create(bucketInfo);

    System.out.println(
        "Created bucket " + bucketName + " with IP filter mode " + bucket.getIpFilter().getMode());
  }
}
// [END storage_create_bucket_ip_filtering]
