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

package com.google.cloud.storage.it.runner.registry;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.collect.ImmutableMap;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/** Globally scoped objects correlated with a specific backend and bucket */
public final class ObjectsFixture implements ManagedLifecycle {

  private final Storage s;
  private final BucketInfo bucket;

  private final BlobTargetOption[] blobTargetOptions;
  private final BlobGetOption[] blobGetOptions;

  private BlobInfo info1;
  private BlobInfo info2;
  private BlobInfo info3;
  private BlobInfo info4;
  private ObjectAndContent obj512KiB;

  ObjectsFixture(Storage s, BucketInfo bucket) {
    this.s = s;
    this.bucket = bucket;
    boolean isRequesterPays = Boolean.TRUE.equals(bucket.requesterPays());
    String projectId = s.getOptions().getProjectId();
    if (isRequesterPays) {
      blobTargetOptions =
          new BlobTargetOption[] {
            BlobTargetOption.doesNotExist(), BlobTargetOption.userProject(projectId)
          };
    } else {
      blobTargetOptions = new BlobTargetOption[] {BlobTargetOption.doesNotExist()};
    }
    if (isRequesterPays) {
      blobGetOptions = new BlobGetOption[] {BlobGetOption.userProject(projectId)};
    } else {
      blobGetOptions = new BlobGetOption[] {};
    }
  }

  @Override
  public Object get() {
    return this;
  }

  public BlobInfo getInfo1() {
    return info1;
  }

  public BlobInfo getInfo2() {
    return info2;
  }

  public BlobInfo getInfo3() {
    return info3;
  }

  public BlobInfo getInfo4() {
    return info4;
  }

  public ObjectAndContent getObj512KiB() {
    return obj512KiB;
  }

  @Override
  public void start() {
    String bucketName = bucket.getName();

    BlobId blobId1 = BlobId.of(bucketName, objName("001"));
    BlobId blobId2 = BlobId.of(bucketName, objName("002"));
    BlobId blobId3 = BlobId.of(bucketName, objName("003"));
    BlobId blobId4 = BlobId.of(bucketName, objName("004"));

    BlobInfo info1 = BlobInfo.newBuilder(blobId1).setMetadata(ImmutableMap.of("pow", "1")).build();
    BlobInfo info2 = BlobInfo.newBuilder(blobId2).setMetadata(ImmutableMap.of("pow", "2")).build();
    BlobInfo info3 = BlobInfo.newBuilder(blobId3).setMetadata(ImmutableMap.of("pow", "3")).build();
    BlobInfo info4 = BlobInfo.newBuilder(blobId4).setMetadata(ImmutableMap.of("pow", "4")).build();
    this.info1 =
        s.create(info1, "A".getBytes(StandardCharsets.UTF_8), blobTargetOptions).asBlobInfo();

    ComposeRequest c2 =
        ComposeRequest.newBuilder()
            .addSource(blobId1.getName(), blobId1.getName())
            .setTarget(info2)
            .setTargetOptions(blobTargetOptions)
            .build();
    ComposeRequest c3 =
        ComposeRequest.newBuilder()
            .addSource(blobId2.getName(), blobId2.getName())
            .setTarget(info3)
            .setTargetOptions(blobTargetOptions)
            .build();
    ComposeRequest c4 =
        ComposeRequest.newBuilder()
            .addSource(blobId3.getName(), blobId3.getName())
            .setTarget(info4)
            .setTargetOptions(blobTargetOptions)
            .build();
    this.info2 = s.compose(c2).asBlobInfo();
    this.info3 = s.compose(c3).asBlobInfo();
    this.info4 = s.compose(c4).asBlobInfo();

    byte[] bytes = DataGenerator.base64Characters().genBytes(512 * 1024);
    Blob obj512KiB =
        s.create(BlobInfo.newBuilder(bucket, "obj512KiB").build(), bytes, blobTargetOptions);
    this.obj512KiB = new ObjectAndContent(obj512KiB.asBlobInfo(), ChecksummedTestContent.of(bytes));
  }

  @Override
  public void stop() {}

  private static String objName(String name) {
    return String.format(Locale.US, "%s/%s", ObjectsFixture.class.getSimpleName(), name);
  }

  public static final class ObjectAndContent {
    private final BlobInfo info;
    private final ChecksummedTestContent content;

    private ObjectAndContent(BlobInfo info, ChecksummedTestContent content) {
      this.info = info;
      this.content = content;
    }

    public BlobInfo getInfo() {
      return info;
    }

    public ChecksummedTestContent getContent() {
      return content;
    }
  }
}
