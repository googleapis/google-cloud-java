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

// [START storage_enable_ip_filtering]
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo.IpFilter;
import com.google.cloud.storage.BucketInfo.IpFilter.PublicNetworkSource;
import com.google.cloud.storage.BucketInfo.IpFilter.VpcNetworkSource;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnableBucketIpFilter {
  public static Bucket enableBucketIpFilter(
      String projectId,
      String bucketName,
      String publicRange,
      String vpcNetworkName,
      String vpcRange) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The public IPv4/IPv6 CIDR range to allow
    // String publicRange = "192.0.2.0/24";

    // The VPC network name in the format: projects/PROJECT_ID/global/networks/NETWORK_NAME
    // String vpcNetworkName = "projects/my-project/global/networks/my-vpc";

    // The VPC IPv4/IPv6 CIDR range to allow
    // String vpcRange = "10.0.0.0/24";

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
    Bucket bucket = storage.get(bucketName);

    List<String> publicRanges = new ArrayList<>();
    List<VpcNetworkSource> vpcSources = new ArrayList<>();

    IpFilter existingIpFilter = bucket.getIpFilter();
    if (existingIpFilter != null) {
      if (existingIpFilter.getPublicNetworkSource() != null
          && existingIpFilter.getPublicNetworkSource().getAllowedIpCidrRanges() != null) {
        publicRanges.addAll(existingIpFilter.getPublicNetworkSource().getAllowedIpCidrRanges());
      }
      if (existingIpFilter.getVpcNetworkSources() != null) {
        vpcSources.addAll(existingIpFilter.getVpcNetworkSources());
      }
    }

    if (publicRange != null && !publicRanges.contains(publicRange)) {
      publicRanges.add(publicRange);
    }

    if (vpcNetworkName != null && vpcRange != null) {
      boolean found = false;
      for (int i = 0; i < vpcSources.size(); i++) {
        VpcNetworkSource vpcSource = vpcSources.get(i);
        if (vpcNetworkName.equals(vpcSource.getNetwork())) {
          found = true;
          List<String> ranges = new ArrayList<>();
          if (vpcSource.getAllowedIpCidrRanges() != null) {
            ranges.addAll(vpcSource.getAllowedIpCidrRanges());
          }
          if (!ranges.contains(vpcRange)) {
            ranges.add(vpcRange);
          }
          vpcSources.set(i, vpcSource.toBuilder().setAllowedIpCidrRanges(ranges).build());
          break;
        }
      }
      if (!found) {
        vpcSources.add(
            VpcNetworkSource.newBuilder()
                .setNetwork(vpcNetworkName)
                .setAllowedIpCidrRanges(Collections.singletonList(vpcRange))
                .build());
      }
    }

    IpFilter.Builder ipFilterBuilder =
        IpFilter.newBuilder()
            .setMode("Enabled")
            .setAllowAllServiceAgentAccess(true)
            .setAllowCrossOrgVpcs(true);

    if (!publicRanges.isEmpty()) {
      ipFilterBuilder.setPublicNetworkSource(PublicNetworkSource.of(publicRanges));
    }
    if (!vpcSources.isEmpty()) {
      ipFilterBuilder.setVpcNetworkSources(vpcSources);
    }

    IpFilter newIpFilter = ipFilterBuilder.build();
    Bucket updatedBucket = storage.update(bucket.toBuilder().setIpFilter(newIpFilter).build());

    System.out.println(
        "Enabled IP filtering for bucket "
            + bucketName
            + ", allowed public CIDRs: "
            + publicRanges
            + ", VPC sources: "
            + vpcSources);

    return updatedBucket;
  }
}
// [END storage_enable_ip_filtering]
