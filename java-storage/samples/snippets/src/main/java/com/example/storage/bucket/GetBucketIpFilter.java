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

// [START storage_get_ip_filtering]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo.IpFilter;
import com.google.cloud.storage.BucketInfo.IpFilter.VpcNetworkSource;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class GetBucketIpFilter {
  public static IpFilter getBucketIpFilter(String projectId, String bucketName) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);
    IpFilter ipFilter = bucket.getIpFilter();

    if (ipFilter == null) {
      System.out.println("Bucket " + bucketName + " has no IP Filter configured.");
      return null;
    }

    System.out.println("IP Filter Mode: " + ipFilter.getMode());
    System.out.println(
        "Allow All Service Agent Access: " + ipFilter.getAllowAllServiceAgentAccess());
    System.out.println("Allow Cross Org VPCs: " + ipFilter.getAllowCrossOrgVpcs());

    if (ipFilter.getPublicNetworkSource() != null) {
      System.out.println(
          "Allowed Public CIDR Blocks: "
              + ipFilter.getPublicNetworkSource().getAllowedIpCidrRanges());
    }

    if (ipFilter.getVpcNetworkSources() != null) {
      for (VpcNetworkSource vpcSource : ipFilter.getVpcNetworkSources()) {
        System.out.println(
            "VPC Network: "
                + vpcSource.getNetwork()
                + ", Allowed CIDR Ranges: "
                + vpcSource.getAllowedIpCidrRanges());
      }
    }

    return ipFilter;
  }
}
// [END storage_get_ip_filtering]
