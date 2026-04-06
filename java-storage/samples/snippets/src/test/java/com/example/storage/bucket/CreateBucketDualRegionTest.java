/*
 * Copyright 2022 Google LLC
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
import static org.junit.Assert.assertNotNull;

import com.example.storage.TestBase;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import org.junit.Test;

public class CreateBucketDualRegionTest extends TestBase {

  @Test
  public void testCreateBucketDualRegion() {
    assertNotNull("Unable to determine Project ID", GOOGLE_CLOUD_PROJECT);
    String newBucket = RemoteStorageHelper.generateBucketName();
    CreateBucketDualRegion.createBucketDualRegion(
        GOOGLE_CLOUD_PROJECT, newBucket, "US", "US-EAST1", "US-WEST1");
    assertThat(stdOut.getCapturedOutputAsUtf8String()).contains("US-WEST1");
    assertThat(stdOut.getCapturedOutputAsUtf8String()).contains("US-EAST1");
    assertThat(stdOut.getCapturedOutputAsUtf8String()).contains("Created bucket");
  }
}
