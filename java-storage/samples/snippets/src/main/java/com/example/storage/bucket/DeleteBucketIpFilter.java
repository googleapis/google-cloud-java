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

// [START storage_delete_ip_filtering_rules]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo.IpFilter;
import com.google.cloud.storage.BucketInfo.IpFilter.PublicNetworkSource;
import com.google.cloud.storage.BucketInfo.IpFilter.VpcNetworkSource;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.ArrayList;
import java.util.List;

public class DeleteBucketIpFilter {
  public static Bucket deleteBucketIpFilterRules(
      String projectId, String bucketName, String publicRange, String vpcNetwork) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The public IPv4/IPv6 CIDR range to remove
    // String publicRange = "192.0.2.0/24";

    // The VPC network name to remove
    // String vpcNetwork = "projects/my-project/global/networks/my-vpc";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);
    IpFilter filter = bucket.getIpFilter();

    if (filter == null) {
      System.out.println("Bucket " + bucketName + " has no IP Filter configured.");
      return bucket;
    }

    IpFilter.Builder builder = filter.toBuilder();
    if (publicRange != null && filter.getPublicNetworkSource() != null) {
      List<String> ranges =
          new ArrayList<>(filter.getPublicNetworkSource().getAllowedIpCidrRanges());
      ranges.remove(publicRange);
      builder.setPublicNetworkSource(ranges.isEmpty() ? null : PublicNetworkSource.of(ranges));
    }

    if (vpcNetwork != null && filter.getVpcNetworkSources() != null) {
      List<VpcNetworkSource> vpcs = new ArrayList<>(filter.getVpcNetworkSources());
      vpcs.removeIf(source -> vpcNetwork.equals(source.getNetwork()));
      builder.setVpcNetworkSources(vpcs.isEmpty() ? null : vpcs);
    }

    Bucket updatedBucket = storage.update(bucket.toBuilder().setIpFilter(builder.build()).build());
    System.out.println("Deleted specified IP filtering rules for bucket " + bucketName);
    return updatedBucket;
  }
}
// [END storage_delete_ip_filtering_rules]
