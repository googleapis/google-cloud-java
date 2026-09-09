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
import java.util.Iterator;
import java.util.List;

public class DeleteBucketIpFilter {
  public static Bucket deleteBucketIpFilterRules(
      String projectId, String bucketName, String publicRangeToDelete, String vpcNetworkToDelete) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The public IPv4/IPv6 CIDR range to remove
    // String publicRangeToDelete = "192.0.2.0/24";

    // The VPC network name to remove
    // String vpcNetworkToDelete = "projects/my-project/global/networks/my-vpc";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);
    IpFilter ipFilter = bucket.getIpFilter();

    if (ipFilter == null) {
      System.out.println("Bucket " + bucketName + " has no IP Filter configured.");
      return bucket;
    }

    boolean modified = false;
    List<String> publicRanges = new ArrayList<>();
    if (ipFilter.getPublicNetworkSource() != null
        && ipFilter.getPublicNetworkSource().getAllowedIpCidrRanges() != null) {
      publicRanges.addAll(ipFilter.getPublicNetworkSource().getAllowedIpCidrRanges());
    }
    if (publicRangeToDelete != null && publicRanges.remove(publicRangeToDelete)) {
      modified = true;
    }

    List<VpcNetworkSource> vpcSources = new ArrayList<>();
    if (ipFilter.getVpcNetworkSources() != null) {
      vpcSources.addAll(ipFilter.getVpcNetworkSources());
    }
    if (vpcNetworkToDelete != null) {
      Iterator<VpcNetworkSource> iterator = vpcSources.iterator();
      while (iterator.hasNext()) {
        VpcNetworkSource source = iterator.next();
        if (vpcNetworkToDelete.equals(source.getNetwork())) {
          iterator.remove();
          modified = true;
        }
      }
    }

    if (modified) {
      IpFilter.Builder updatedIpFilterBuilder = ipFilter.toBuilder();
      updatedIpFilterBuilder.setPublicNetworkSource(
          publicRanges.isEmpty() ? null : PublicNetworkSource.of(publicRanges));
      updatedIpFilterBuilder.setVpcNetworkSources(vpcSources.isEmpty() ? null : vpcSources);

      Bucket updatedBucket =
          storage.update(bucket.toBuilder().setIpFilter(updatedIpFilterBuilder.build()).build());
      System.out.println("Deleted specified IP filtering rules for bucket " + bucketName);
      return updatedBucket;
    } else {
      System.out.println("No matching IP filtering rules found to delete for bucket " + bucketName);
      return bucket;
    }
  }
}
// [END storage_delete_ip_filtering_rules]
