/*
 * Copyright 2021 Google LLC
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

package com.example.storage;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.it.BucketCleaner;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.cloud.testing.junit4.StdOutCaptureRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public final class ConfigureRetriesTest {
  @Rule public StdOutCaptureRule stdOut = new StdOutCaptureRule();

  private String bucketName;
  private Storage storage;
  private String blobName;

  private Blob blob;

  @Before
  public void setUp() {
    blobName = "blob";
    bucketName = RemoteStorageHelper.generateBucketName();
    storage = StorageOptions.getDefaultInstance().getService();
    storage.create(BucketInfo.of(bucketName));
    blob = storage.create(BlobInfo.newBuilder(bucketName, blobName).build());
  }

  @After
  public void tearDown() throws Exception {
    try (Storage ignore = storage) {
      BucketCleaner.doCleanup(bucketName, storage);
    }
  }

  @Test
  public void testConfigureRetries() {
    ConfigureRetries.deleteBlob(bucketName, blobName);
    assertThat(stdOut.getCapturedOutputAsUtf8String()).contains("Deletion");
    assertThat(stdOut.getCapturedOutputAsUtf8String()).contains("successfully");
    assertThat(stdOut.getCapturedOutputAsUtf8String()).doesNotContain("unsuccessfully");
  }
}
