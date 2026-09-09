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

import static com.example.storage.Env.GOOGLE_CLOUD_PROJECT;
import static com.google.common.truth.Truth.assertThat;

import com.example.storage.TestBase;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import org.junit.Test;

public class IpFilterTest extends TestBase {

  @Test
  public void testBucketIpFilterLifecycle() throws Exception {
    String bucketName = RemoteStorageHelper.generateBucketName();
    String publicRange = "192.0.2.0/24";
    String vpcNetwork = "projects/" + GOOGLE_CLOUD_PROJECT + "/global/networks/default";
    String vpcRange = "10.0.0.0/24";

    try {
      // 1. Create with IP Filter
      CreateBucketIpFilter.createBucketIpFilter(GOOGLE_CLOUD_PROJECT, bucketName, publicRange);
      Bucket created = storage.get(bucketName);
      assertThat(created.getIpFilter()).isNotNull();

      // 2. Enable IP Filter with Public and VPC ranges
      Bucket enabled =
          EnableBucketIpFilter.enableBucketIpFilter(
              GOOGLE_CLOUD_PROJECT, bucketName, publicRange, vpcNetwork, vpcRange);
      assertThat(enabled.getIpFilter().getMode()).isEqualTo("Enabled");

      // 3. Get IP Filter
      BucketInfo.IpFilter fetched =
          GetBucketIpFilter.getBucketIpFilter(GOOGLE_CLOUD_PROJECT, bucketName);
      assertThat(fetched.getMode()).isEqualTo("Enabled");

      // 4. Delete IP Filter rules
      Bucket modified =
          DeleteBucketIpFilter.deleteBucketIpFilterRules(
              GOOGLE_CLOUD_PROJECT, bucketName, publicRange, vpcNetwork);
      assertThat(modified.getIpFilter()).isNotNull();

      // 5. Disable IP Filter
      Bucket disabled =
          DisableBucketIpFilter.disableBucketIpFilter(GOOGLE_CLOUD_PROJECT, bucketName);
      assertThat(disabled.getIpFilter().getMode()).isEqualTo("Disabled");

      // 6. List Buckets with IP Filter
      ListBucketsIpFilter.listBucketsIpFilter(GOOGLE_CLOUD_PROJECT);
      assertThat(stdOut.getCapturedOutputAsUtf8String()).contains(bucketName);
    } finally {
      RemoteStorageHelper.forceDelete(storage, bucketName);
    }
  }
}
