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

package com.google.cloud.storage.it;

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.MoveBlobRequest;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.BucketFixture;
import com.google.cloud.storage.it.runner.annotations.BucketType;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableMap;
import com.google.storage.control.v2.BucketName;
import com.google.storage.control.v2.CreateFolderRequest;
import com.google.storage.control.v2.Folder;
import com.google.storage.control.v2.FolderName;
import com.google.storage.control.v2.StorageControlClient;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = Backend.PROD,
    transports = {Transport.HTTP, Transport.GRPC})
public class ITFoldersTest {

  @Inject public StorageControlClient ctrl;
  @Inject public Storage storage;

  @Inject
  @BucketFixture(BucketType.HNS)
  public BucketInfo bucket;

  @Inject public Generator generator;

  @Test
  public void createFolder() throws Exception {
    String folderId = generator.randomObjectName() + "/";
    String bucketName = bucket.getName();
    Folder folder =
        ctrl.createFolder(
            CreateFolderRequest.newBuilder()
                .setParent(BucketName.format("_", bucketName))
                .setFolderId(folderId)
                .build());
    assertAll(
        () -> assertThat(folder.getName()).isEqualTo(FolderName.format("_", bucketName, folderId)),
        () -> assertThat(folder.getMetageneration()).isGreaterThan(0));
  }

  @Test
  public void moveObject() throws Exception {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(5286));

    BlobId id1 = BlobId.of(bucket.getName(), generator.randomObjectName());
    BlobId id2 = BlobId.of(bucket.getName(), generator.randomObjectName());

    ImmutableMap<String, String> metadata = ImmutableMap.of("a", "b", "c", "d");
    BlobInfo info1 = BlobInfo.newBuilder(id1).setMetadata(metadata).build();
    Blob blob1 = storage.create(info1, testContent.getBytes(), BlobTargetOption.doesNotExist());

    Blob blob2 =
        storage.moveBlob(
            MoveBlobRequest.newBuilder()
                .setSource(blob1.getBlobId())
                .setTarget(id2)
                .setSourceOptions(BlobSourceOption.generationMatch())
                .setTargetOptions(BlobTargetOption.doesNotExist())
                .build());

    assertAll(
        () -> assertThat(blob2.getCrc32c()).isEqualTo(testContent.getCrc32cBase64()),
        () -> assertThat(blob2.getMetadata()).isEqualTo(metadata));
  }
}
