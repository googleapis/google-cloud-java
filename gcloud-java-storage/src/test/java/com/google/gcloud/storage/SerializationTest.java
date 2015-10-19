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

package com.google.gcloud.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import com.google.common.collect.ImmutableMap;
import com.google.gcloud.AuthCredentials;
import com.google.gcloud.RestorableState;
import com.google.gcloud.RetryParams;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.storage.Acl.Project.ProjectRole;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

public class SerializationTest {

  private static final Acl.Domain ACL_DOMAIN = new Acl.Domain("domain");
  private static final Acl.Group ACL_GROUP = new Acl.Group("group");
  private static final Acl.Project ACL_PROJECT_ = new Acl.Project(ProjectRole.VIEWERS, "pid");
  private static final Acl.User ACL_USER = new Acl.User("user");
  private static final Acl.RawEntity ACL_RAW = new Acl.RawEntity("raw");
  private static final BlobInfo BLOB_INFO = BlobInfo.builder("b", "n").build();
  private static final BucketInfo BUCKET_INFO = BucketInfo.of("b");
  private static final Cors.Origin ORIGIN = Cors.Origin.any();
  private static final Cors CORS =
      Cors.builder().maxAgeSeconds(1).origins(Collections.singleton(ORIGIN)).build();
  private static final BatchRequest BATCH_REQUEST = BatchRequest.builder().delete("B", "N").build();
  private static final BatchResponse BATCH_RESPONSE = new BatchResponse(
      Collections.singletonList(BatchResponse.Result.of(true)),
      Collections.<BatchResponse.Result<BlobInfo>>emptyList(),
      Collections.<BatchResponse.Result<BlobInfo>>emptyList());
  private static final BaseListResult<BlobInfo> LIST_RESULT =
      new BaseListResult<>(null, "c", Collections.singletonList(BlobInfo.builder("b", "n").build()));
  private static final Storage.BlobListOption BLOB_LIST_OPTIONS =
      Storage.BlobListOption.maxResults(100);
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

  @Test
  public void testServiceOptions() throws Exception {
    StorageOptions options = StorageOptions.builder()
        .projectId("p1")
        .authCredentials(AuthCredentials.createForAppEngine())
        .build();
    StorageOptions serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);

    options = options.toBuilder()
        .projectId("p2")
        .retryParams(RetryParams.getDefaultInstance())
        .authCredentials(AuthCredentials.noCredentials())
        .pathDelimiter(":")
        .build();
    serializedCopy = serializeAndDeserialize(options);
    assertEquals(options, serializedCopy);
  }

  @Test
  public void testModelAndRequests() throws Exception {
    Serializable[] objects = {ACL_DOMAIN, ACL_GROUP, ACL_PROJECT_, ACL_USER, ACL_RAW, BLOB_INFO,
        BUCKET_INFO,
        ORIGIN, CORS, BATCH_REQUEST, BATCH_RESPONSE, LIST_RESULT, BLOB_LIST_OPTIONS,
        BLOB_SOURCE_OPTIONS, BLOB_TARGET_OPTIONS, BUCKET_LIST_OPTIONS, BUCKET_SOURCE_OPTIONS,
        BUCKET_TARGET_OPTIONS};
    for (Serializable obj : objects) {
      Object copy = serializeAndDeserialize(obj);
      assertEquals(obj, obj);
      assertEquals(obj, copy);
      assertNotSame(obj, copy);
      assertEquals(copy, copy);
    }
  }

  @Test
  public void testReadChannelState() throws IOException, ClassNotFoundException {
    StorageOptions options = StorageOptions.builder()
        .projectId("p2")
        .retryParams(RetryParams.getDefaultInstance())
        .authCredentials(AuthCredentials.noCredentials())
        .build();
    BlobReadChannel reader =
        new BlobReadChannelImpl(options, BlobId.of("b", "n"), EMPTY_RPC_OPTIONS);
    RestorableState<BlobReadChannel> state = reader.save();
    RestorableState<BlobReadChannel> deserializedState = serializeAndDeserialize(state);
    assertEquals(state, deserializedState);
    assertEquals(state.hashCode(), deserializedState.hashCode());
    assertEquals(state.toString(), deserializedState.toString());
  }

  @Test
  public void testWriteChannelState() throws IOException, ClassNotFoundException {
    StorageOptions options = StorageOptions.builder()
        .projectId("p2")
        .retryParams(RetryParams.getDefaultInstance())
        .authCredentials(AuthCredentials.noCredentials())
        .build();
    BlobWriteChannelImpl writer = new BlobWriteChannelImpl(
        options, BlobInfo.builder(BlobId.of("b", "n")).build(), "upload-id");
    RestorableState<BlobWriteChannel> state = writer.save();
    RestorableState<BlobWriteChannel> deserializedState = serializeAndDeserialize(state);
    assertEquals(state, deserializedState);
    assertEquals(state.hashCode(), deserializedState.hashCode());
    assertEquals(state.toString(), deserializedState.toString());
  }

  @SuppressWarnings("unchecked")
  private <T> T serializeAndDeserialize(T obj)
      throws IOException, ClassNotFoundException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
      output.writeObject(obj);
    }
    try (ObjectInputStream input =
        new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
      return (T) input.readObject();
    }
  }
}
