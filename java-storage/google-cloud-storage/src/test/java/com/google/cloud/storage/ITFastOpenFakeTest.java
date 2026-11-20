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

package com.google.cloud.storage;

import static com.google.cloud.storage.ByteSizeConstants._2MiB;
import static com.google.cloud.storage.ITObjectReadSessionFakeTest.getReadRange;
import static com.google.cloud.storage.PackagePrivateMethodWorkarounds.maybeGetStorageDataClient;
import static com.google.common.truth.Truth.assertThat;
import static java.util.concurrent.TimeUnit.SECONDS;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.cloud.storage.ITObjectReadSessionFakeTest.FakeStorage;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.BidiReadObjectSpec;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.Object;
import com.google.storage.v2.ObjectRangeData;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.junit.Test;

public final class ITFastOpenFakeTest {

  private static final byte[] ALL_OBJECT_BYTES = DataGenerator.base64Characters().genBytes(64);
  private static final Object METADATA =
      Object.newBuilder()
          .setBucket(BucketName.format("_", "b"))
          .setName("o")
          .setGeneration(1)
          .setSize(_2MiB)
          .build();
  private static final GrpcCallContext CTX = GrpcCallContext.createDefault();

  private static final BidiReadObjectRequest OPEN =
      BidiReadObjectRequest.newBuilder()
          .setReadObjectSpec(
              BidiReadObjectSpec.newBuilder()
                  .setBucket(METADATA.getBucket())
                  .setObject(METADATA.getName())
                  .build())
          .build();
  private static final BidiReadObjectRequest OPEN_WITH_READ_OF_10_TO_20 =
      OPEN.toBuilder().addReadRanges(getReadRange(1, 10, 10)).build();

  private static final ReadAsFutureBytes READ_10_TO_20 =
      ReadProjectionConfigs.asFutureBytes().withRangeSpec(RangeSpec.of(10, 10));

  /** Every request the fake server received, in order. */
  private final List<BidiReadObjectRequest> requestsReceived =
      Collections.synchronizedList(new ArrayList<>());

  @Test
  public void openRequest_includesTheFastOpenRead() throws Exception {
    FakeStorage server =
        fakeServer(ImmutableMap.of(OPEN_WITH_READ_OF_10_TO_20, metadataAndBytes(1, 10, 10)));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      ObjectReadSession session =
          dataClient.readSession(OPEN, CTX, ImmutableList.of(READ_10_TO_20)).get(5, SECONDS);
      session.close();
    }

    assertThat(requestsReceived).containsExactly(OPEN_WITH_READ_OF_10_TO_20);
  }

  @Test
  public void openRequest_withoutFastOpenReads_isUnchanged() throws Exception {
    FakeStorage server = fakeServer(ImmutableMap.of(OPEN, metadataOnly()));

    try (FakeServer fakeServer = FakeServer.of(server);
        Storage storage = fakeServer.getGrpcStorageOptions().getService()) {
      StorageDataClient dataClient = maybeGetStorageDataClient(storage);

      ObjectReadSession session =
          dataClient.readSession(OPEN, CTX, ImmutableList.of()).get(5, SECONDS);
      session.close();
    }

    assertThat(requestsReceived).containsExactly(OPEN);
  }

  /**
   * A fake server that answers each request in {@code responses} and adds it to {@link
   * #requestsReceived}. Any other request is answered with an error.
   */
  private FakeStorage fakeServer(Map<BidiReadObjectRequest, BidiReadObjectResponse> responses) {
    ImmutableMap.Builder<BidiReadObjectRequest, Consumer<StreamObserver<BidiReadObjectResponse>>>
        behaviour = ImmutableMap.builder();
    responses.forEach(
        (request, response) ->
            behaviour.put(
                request,
                client -> {
                  requestsReceived.add(request);
                  client.onNext(response);
                }));
    return FakeStorage.of(behaviour.buildOrThrow());
  }

  private static BidiReadObjectResponse metadataOnly() {
    return BidiReadObjectResponse.newBuilder().setMetadata(METADATA).build();
  }

  /** The response to an open request that has a read of {@code [offset, offset + length)}. */
  private static BidiReadObjectResponse metadataAndBytes(int readId, int offset, int length) {
    return BidiReadObjectResponse.newBuilder()
        .setMetadata(METADATA)
        .addObjectDataRanges(
            ObjectRangeData.newBuilder()
                .setChecksummedData(
                    ChecksummedTestContent.of(ALL_OBJECT_BYTES, offset, length).asChecksummedData())
                .setReadRange(getReadRange(readId, offset, length))
                .setRangeEnd(true))
        .build();
  }
}
