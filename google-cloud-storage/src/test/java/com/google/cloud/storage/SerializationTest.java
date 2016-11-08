/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud.storage;

import com.google.cloud.BaseSerializationTest;
import com.google.cloud.NoCredentials;
import com.google.cloud.PageImpl;
import com.google.cloud.ReadChannel;
import com.google.cloud.Restorable;
import com.google.cloud.storage.Acl.Project.ProjectRole;
import com.google.cloud.storage.spi.StorageRpc;
import com.google.common.collect.ImmutableMap;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

public class SerializationTest extends BaseSerializationTest {

  private static final Storage STORAGE = StorageOptions.newBuilder().setProjectId("p").build().getService();
  private static final Acl.Domain ACL_DOMAIN = new Acl.Domain("domain");
  private static final Acl.Group ACL_GROUP = new Acl.Group("group");
  private static final Acl.Project ACL_PROJECT_ = new Acl.Project(ProjectRole.VIEWERS, "pid");
  private static final Acl.User ACL_USER = new Acl.User("user");
  private static final Acl.RawEntity ACL_RAW = new Acl.RawEntity("raw");
  private static final Acl ACL = Acl.of(ACL_DOMAIN, Acl.Role.OWNER);
  private static final BlobInfo BLOB_INFO = BlobInfo.newBuilder("b", "n").build();
  private static final BucketInfo BUCKET_INFO = BucketInfo.of("b");
  private static final Blob BLOB = new Blob(STORAGE, new BlobInfo.BuilderImpl(BLOB_INFO));
  private static final Bucket BUCKET = new Bucket(STORAGE, new BucketInfo.BuilderImpl(BUCKET_INFO));
  private static final Cors.Origin ORIGIN = Cors.Origin.any();
  private static final Cors CORS =
      Cors.newBuilder().setMaxAgeSeconds(1).setOrigins(Collections.singleton(ORIGIN)).build();
  private static final PageImpl<Blob> PAGE_RESULT =
      new PageImpl<>(null, "c", Collections.singletonList(BLOB));
  private static final StorageException STORAGE_EXCEPTION = new StorageException(42, "message");
  private static final Storage.BlobListOption BLOB_LIST_OPTIONS =
      Storage.BlobListOption.pageSize(100);
  private static final Storage.BlobSourceOption BLOB_SOURCE_OPTIONS =
      Storage.BlobSourceOption.generationMatch(1);
  private static final Storage.BlobTargetOption BLOB_TARGET_OPTIONS =
      Storage.BlobTargetOption.generationMatch();
  private static final Storage.BucketListOption BUCKET_LIST_OPTIONS =
      Storage.BucketListOption.prefix("bla");
  private static final Storage.BucketSourceOption BUCKET_SOURCE_OPTIONS =
      Storage.BucketSourceOption.metagenerationMatch(1);
  private static final Storage.BucketTargetOption BUCKET_TARGET_OPTIONS =
      Storage.BucketTargetOption.metagenerationNotMatch();
  private static final Map<StorageRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();

  @Override
  protected Serializable[] serializableObjects() {
    StorageOptions options = StorageOptions.newBuilder()
        .setProjectId("p1")
        .setCredentials(NoCredentials.getInstance())
        .build();
    StorageOptions otherOptions = options.toBuilder().setProjectId("p2").build();
    return new Serializable[]{ACL_DOMAIN, ACL_GROUP, ACL_PROJECT_, ACL_USER, ACL_RAW, ACL,
        BLOB_INFO, BLOB, BUCKET_INFO, BUCKET, ORIGIN, CORS, PAGE_RESULT, BLOB_LIST_OPTIONS,
        BLOB_SOURCE_OPTIONS, BLOB_TARGET_OPTIONS, BUCKET_LIST_OPTIONS, BUCKET_SOURCE_OPTIONS,
        BUCKET_TARGET_OPTIONS, STORAGE_EXCEPTION, options, otherOptions};
  }

  @Override
  protected Restorable<?>[] restorableObjects() {
    StorageOptions options = StorageOptions.newBuilder().setProjectId("p2").build();
    ReadChannel reader =
        new BlobReadChannel(options, BlobId.of("b", "n"), EMPTY_RPC_OPTIONS);
    // avoid closing when you don't want partial writes to GCS upon failure
    @SuppressWarnings("resource")
    BlobWriteChannel writer = new BlobWriteChannel(options,
        BlobInfo.newBuilder(BlobId.of("b", "n")).build(), "upload-id");
    return new Restorable<?>[]{reader, writer};
  }
}
