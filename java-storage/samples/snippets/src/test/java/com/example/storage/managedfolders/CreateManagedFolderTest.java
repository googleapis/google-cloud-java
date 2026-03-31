/*
 * Copyright 2024 Google LLC
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

package com.example.storage.managedfolders;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.IamConfiguration;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.it.BucketCleaner;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.cloud.testing.junit4.StdOutCaptureRule;
import com.google.storage.control.v2.StorageControlClient;
import java.io.IOException;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class CreateManagedFolderTest {

  @Rule public StdOutCaptureRule stdOut = new StdOutCaptureRule();

  protected String bucketName;
  protected Storage storage;
  protected Bucket bucket;
  protected String managedFolderId;
  protected StorageControlClient storageControl;

  @Before
  public void setUp() throws IOException {
    bucketName = RemoteStorageHelper.generateBucketName();
    storageControl = StorageControlClient.create();
    storage = StorageOptions.getDefaultInstance().getService();
    managedFolderId = "new-managed-folder-" + UUID.randomUUID();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setIamConfiguration(
                IamConfiguration.newBuilder().setIsUniformBucketLevelAccessEnabled(true).build())
            .build();
    bucket = storage.create(bucketInfo);
  }

  @After
  public void tearDown() throws Exception {
    try (Storage ignore1 = storage;
        StorageControlClient ignore2 = storageControl) {
      BucketCleaner.doCleanup(bucketName, storage, storageControl);
    }
  }

  @Test
  public void testCreateManagedFolder() throws Exception {
    CreateManagedFolder.managedFolderCreate(bucketName, managedFolderId);
    String got = stdOut.getCapturedOutputAsUtf8String();
    assertThat(got).contains(String.format(managedFolderId));
  }
}
