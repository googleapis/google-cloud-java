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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IpFilterTest extends TestBase {

  private static final String PUBLIC_RANGE = "192.0.2.0/24";
  private static final String VPC_NETWORK =
      "projects/" + GOOGLE_CLOUD_PROJECT + "/global/networks/default";
  private static final String VPC_RANGE = "10.0.0.0/24";

  private String bucketName;

  @Before
  public void setUp() {
    bucketName = RemoteStorageHelper.generateBucketName();
  }

  @After
  public void tearDown() {
    if (bucketName != null) {
      try {
        Bucket b = storage.get(bucketName);
        if (b != null && b.getIpFilter() != null && "Enabled".equals(b.getIpFilter().getMode())) {
          DisableBucketIpFilter.disableBucketIpFilter(GOOGLE_CLOUD_PROJECT, bucketName);
        }
      } catch (Exception ignored) {
        // Ignore cleanup errors before force delete
      }
      RemoteStorageHelper.forceDelete(storage, bucketName);
    }
  }

  @Test
  public void testCreateBucketIpFilter() {
    CreateBucketIpFilter.createBucketIpFilter(GOOGLE_CLOUD_PROJECT, bucketName, PUBLIC_RANGE);
    Bucket created = storage.get(bucketName);
    assertThat(created.getIpFilter()).isNotNull();
  }

  @Test
  public void testEnableBucketIpFilter() {
    storage.create(BucketInfo.of(bucketName));
    Bucket enabled =
        EnableBucketIpFilter.enableBucketIpFilter(
            GOOGLE_CLOUD_PROJECT, bucketName, PUBLIC_RANGE, VPC_NETWORK, VPC_RANGE);
    assertThat(enabled.getIpFilter().getMode()).isEqualTo("Enabled");
  }

  @Test
  public void testGetBucketIpFilter() {
    storage.create(BucketInfo.of(bucketName));
    EnableBucketIpFilter.enableBucketIpFilter(
        GOOGLE_CLOUD_PROJECT, bucketName, PUBLIC_RANGE, VPC_NETWORK, VPC_RANGE);

    BucketInfo.IpFilter fetched =
        GetBucketIpFilter.getBucketIpFilter(GOOGLE_CLOUD_PROJECT, bucketName);
    assertThat(fetched.getMode()).isEqualTo("Enabled");
  }

  @Test
  public void testDeleteBucketIpFilterRules() {
    storage.create(BucketInfo.of(bucketName));
    EnableBucketIpFilter.enableBucketIpFilter(
        GOOGLE_CLOUD_PROJECT, bucketName, PUBLIC_RANGE, VPC_NETWORK, VPC_RANGE);

    Bucket modified =
        DeleteBucketIpFilter.deleteBucketIpFilterRules(
            GOOGLE_CLOUD_PROJECT, bucketName, PUBLIC_RANGE, VPC_NETWORK);
    assertThat(modified.getIpFilter()).isNotNull();
  }

  @Test
  public void testDisableBucketIpFilter() {
    storage.create(BucketInfo.of(bucketName));
    EnableBucketIpFilter.enableBucketIpFilter(
        GOOGLE_CLOUD_PROJECT, bucketName, PUBLIC_RANGE, VPC_NETWORK, VPC_RANGE);

    Bucket disabled = DisableBucketIpFilter.disableBucketIpFilter(GOOGLE_CLOUD_PROJECT, bucketName);
    assertThat(disabled.getIpFilter().getMode()).isEqualTo("Disabled");
  }

  @Test
  public void testListBucketsIpFilter() {
    CreateBucketIpFilter.createBucketIpFilter(GOOGLE_CLOUD_PROJECT, bucketName, PUBLIC_RANGE);

    ListBucketsIpFilter.listBucketsIpFilter(GOOGLE_CLOUD_PROJECT);
    assertThat(stdOut.getCapturedOutputAsUtf8String()).contains(bucketName);
  }
}
