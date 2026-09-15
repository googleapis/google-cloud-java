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

package com.example.storage.control.v2;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.HierarchicalNamespace;
import com.google.cloud.storage.BucketInfo.IamConfiguration;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.it.BucketCleaner;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.cloud.testing.junit4.StdOutCaptureRule;
import com.google.storage.control.v2.BucketName;
import com.google.storage.control.v2.Folder;
import com.google.storage.control.v2.FolderName;
import com.google.storage.control.v2.StorageControlClient;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public final class FoldersTest {

  @Rule public StdOutCaptureRule stdOut = new StdOutCaptureRule();

  private Storage storage;
  private BucketInfo bucket;
  private StorageControlClient storageControl;

  @Before
  public void setUp() throws Exception {
    storage = StorageOptions.http().build().getService();
    String bucketName = RemoteStorageHelper.generateBucketName();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setIamConfiguration(
                // Hierarchical namespace buckets must use uniform bucket-level access.
                IamConfiguration.newBuilder().setIsUniformBucketLevelAccessEnabled(true).build())
            .setHierarchicalNamespace(HierarchicalNamespace.newBuilder().setEnabled(true).build())
            .build();

    bucket = storage.create(bucketInfo).asBucketInfo();
    storageControl = StorageControlClient.create();
  }

  @After
  public void tearDown() throws Exception {
    // Use try-with-resource to handle the dance closing multiple things
    try (AutoCloseable ignore1 = storage;
        AutoCloseable ignore2 = storageControl) {
      BucketCleaner.doCleanup(bucket.getName(), storage, storageControl);
    }
  }

  @Test
  public void createFolder() throws IOException {
    String folderName = UUID.randomUUID().toString();
    CreateFolder.createFolder(bucket.getName(), folderName);
    try {
      assertThat(stdOut.getCapturedOutputAsUtf8String()).contains(folderName);
    } finally {
      storageControl.deleteFolder(FolderName.of("_", bucket.getName(), folderName));
    }
  }

  @Test
  public void getFolder() throws IOException {
    FolderName folderName = FolderName.of("_", bucket.getName(), UUID.randomUUID().toString());
    Folder gen1 =
        storageControl.createFolder(
            BucketName.of("_", bucket.getName()),
            Folder.getDefaultInstance(),
            folderName.getFolder());

    GetFolder.getFolder(bucket.getName(), folderName.getFolder());
    try {
      assertThat(stdOut.getCapturedOutputAsUtf8String()).contains(folderName.toString());
    } finally {
      storageControl.deleteFolder(folderName);
    }
  }

  @Test
  public void renameFolder()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    FolderName srcFolderName = FolderName.of("_", bucket.getName(), UUID.randomUUID().toString());
    Folder gen1 =
        storageControl.createFolder(
            BucketName.of("_", bucket.getName()),
            Folder.getDefaultInstance(),
            srcFolderName.getFolder());

    FolderName dstFolderName = FolderName.of("_", bucket.getName(), UUID.randomUUID().toString());

    RenameFolder.renameFolder(
        bucket.getName(), srcFolderName.getFolder(), dstFolderName.getFolder());
    try {
      assertThat(stdOut.getCapturedOutputAsUtf8String()).contains(srcFolderName.toString());
      assertThat(stdOut.getCapturedOutputAsUtf8String()).contains(dstFolderName.toString());
      assertThrows(NotFoundException.class, () -> storageControl.getFolder(srcFolderName));
    } finally {
      storageControl.deleteFolder(dstFolderName);
    }
  }

  @Test
  public void deleteFolder() throws IOException {
    FolderName folderName = FolderName.of("_", bucket.getName(), UUID.randomUUID().toString());
    Folder gen1 =
        storageControl.createFolder(
            BucketName.of("_", bucket.getName()),
            Folder.getDefaultInstance(),
            folderName.getFolder());

    DeleteFolder.deleteFolder(bucket.getName(), folderName.getFolder());
    assertThat(stdOut.getCapturedOutputAsUtf8String()).contains(folderName.toString());
    assertThrows(NotFoundException.class, () -> storageControl.getFolder(folderName));
  }

  @Test
  public void listFolder() throws IOException {
    FolderName folderName = FolderName.of("_", bucket.getName(), UUID.randomUUID().toString());
    Folder gen1 =
        storageControl.createFolder(
            BucketName.of("_", bucket.getName()),
            Folder.getDefaultInstance(),
            folderName.getFolder());

    ListFolders.listFolders(bucket.getName());
    try {
      assertThat(stdOut.getCapturedOutputAsUtf8String()).contains(folderName.toString());
    } finally {
      storageControl.deleteFolder(folderName);
    }
  }
}
