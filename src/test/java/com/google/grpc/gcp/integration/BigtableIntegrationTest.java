/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.grpc.gcp;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.BigtableGrpc.BigtableBlockingStub;
import com.google.bigtable.v2.BigtableGrpc.BigtableStub;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.RowSet;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.SettableFuture;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannelBuilder;
import io.grpc.auth.MoreCallCredentials;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Integration tests for GcpManagedChannel with Bigtable. */
@RunWith(JUnit4.class)
public class BigtableIntegrationTest {

  private static final int DEFAULT_MAX_CHANNEL = 10;
  private static final int NEW_MAX_CHANNEL = 5;
  private static final int NEW_MAX_STREAM = 5;

  private static final String TEST_APICONFIG_FILE =
      "src/test/resources/apiconfigtests/empty_method.json";
  private static final String BIGTABLE_TARGET = "bigtable.googleapis.com";
  private static final String FAMILY_NAME = "test-family";
  private static final String TABLE_NAME =
      "projects/cloudprober-test/instances/test-instance/tables/test-table";
  private static final String COLUMN_NAME = "col-";
  private static final String OAUTH_SCOPE = "https://www.googleapis.com/auth/cloud-platform";

  private GcpManagedChannel gcpChannel;
  private ManagedChannelBuilder builder;

  private ByteString getCol(int idx) {
    return ByteString.copyFromUtf8(COLUMN_NAME + idx);
  }

  private GoogleCredentials getCreds() {
    GoogleCredentials creds;
    try {
      creds = GoogleCredentials.getApplicationDefault();
    } catch (Exception e) {
      return null;
    }
    ImmutableList<String> requiredScopes = ImmutableList.of(OAUTH_SCOPE);
    creds = creds.createScoped(requiredScopes);
    return creds;
  }

  private BigtableBlockingStub getBigtableBlockingStub() throws InterruptedException {
    GoogleCredentials creds = getCreds();
    BigtableBlockingStub stub =
        BigtableGrpc.newBlockingStub(gcpChannel)
            .withCallCredentials(MoreCallCredentials.from(creds));
    return stub;
  }

  private BigtableStub getBigtableStub() throws InterruptedException {
    GoogleCredentials creds = getCreds();
    BigtableStub stub =
        BigtableGrpc.newStub(gcpChannel).withCallCredentials(MoreCallCredentials.from(creds));
    return stub;
  }

  @Before
  public void setupBuilder() throws InterruptedException {
    builder = ManagedChannelBuilder.forAddress(BIGTABLE_TARGET, 443);
  }

  @After
  public void shutdownChannel() {
    gcpChannel.shutdownNow();
  }

  @Test
  public void testMutateRowReuse() throws Exception {
    gcpChannel = new GcpManagedChannel(builder);
    BigtableBlockingStub stub = getBigtableBlockingStub();
    ByteString value = ByteString.copyFromUtf8("test-mutation");
    Mutation mutation =
        Mutation.newBuilder()
            .setSetCell(
                Mutation.SetCell.newBuilder()
                    .setFamilyName(FAMILY_NAME)
                    .setColumnQualifier(getCol(100))
                    .setValue(value))
            .build();
    MutateRowRequest request =
        MutateRowRequest.newBuilder()
            .setTableName(TABLE_NAME)
            .setRowKey(ByteString.copyFromUtf8("test-row"))
            .addMutations(mutation)
            .build();
    for (int i = 0; i < DEFAULT_MAX_CHANNEL * 2; i++) {
      MutateRowResponse response = stub.mutateRow(request);
      assertThat(response).isNotEqualTo(null);
      assertEquals(1, gcpChannel.channelRefs.size());
    }
  }

  @Test
  public void testMutateRowAsyncReuse() throws Exception {
    gcpChannel = new GcpManagedChannel(builder);
    BigtableStub stub = getBigtableStub();
    ByteString value = ByteString.copyFromUtf8("test-mutation-async");

    for (int i = 0; i < DEFAULT_MAX_CHANNEL * 2; i++) {
      Mutation mutation =
          Mutation.newBuilder()
              .setSetCell(
                  Mutation.SetCell.newBuilder()
                      .setFamilyName(FAMILY_NAME)
                      .setColumnQualifier(getCol(i))
                      .setValue(value))
              .build();
      MutateRowRequest request =
          MutateRowRequest.newBuilder()
              .setTableName(TABLE_NAME)
              .setRowKey(ByteString.copyFromUtf8("test-row"))
              .addMutations(mutation)
              .build();
      AsyncResponseObserver<MutateRowResponse> responseObserver =
          new AsyncResponseObserver<MutateRowResponse>();
      stub.mutateRow(request, responseObserver);
      assertEquals(1, gcpChannel.channelRefs.size());
      assertEquals(1, gcpChannel.channelRefs.get(0).getActiveStreamsCount());
      responseObserver.awaitCompletion();
      assertEquals(0, gcpChannel.channelRefs.get(0).getActiveStreamsCount());
    }
  }

  @Test
  public void testConcurrentStreams() throws Exception {
    // For our current channel pool, the max_stream is 5 and the max_size is 5.
    gcpChannel = new GcpManagedChannel(builder, TEST_APICONFIG_FILE);
    BigtableStub stub = getBigtableStub();
    ByteString value = ByteString.copyFromUtf8("test-mutation-async");
    Mutation mutation =
        Mutation.newBuilder()
            .setSetCell(
                Mutation.SetCell.newBuilder()
                    .setFamilyName(FAMILY_NAME)
                    .setColumnQualifier(getCol(100))
                    .setValue(value))
            .build();
    MutateRowRequest request =
        MutateRowRequest.newBuilder()
            .setTableName(TABLE_NAME)
            .setRowKey(ByteString.copyFromUtf8("test-row-async"))
            .addMutations(mutation)
            .build();
    List<AsyncResponseObserver<MutateRowResponse>> clearObservers = new ArrayList<>();

    // The number of streams is <= 5 * 5.
    for (int i = 0; i < NEW_MAX_STREAM * NEW_MAX_CHANNEL; i++) {
      AsyncResponseObserver<MutateRowResponse> responseObserver =
          new AsyncResponseObserver<MutateRowResponse>();
      stub.mutateRow(request, responseObserver);
      // Test the number of channels.
      assertEquals((i / NEW_MAX_CHANNEL) + 1, gcpChannel.channelRefs.size());
      // Test the number of streams.
      if ((i % NEW_MAX_STREAM) == 0) {
        assertEquals(
            (i % NEW_MAX_STREAM) + 1,
            gcpChannel.channelRefs.get(i / NEW_MAX_CHANNEL).getActiveStreamsCount());
      } else {
        assertEquals(
            (i % NEW_MAX_STREAM) + 1, gcpChannel.channelRefs.get(0).getActiveStreamsCount());
      }
      clearObservers.add(responseObserver);
    }

    // The number of streams is 26, new channel won't be created.
    AsyncResponseObserver<MutateRowResponse> responseObserver =
        new AsyncResponseObserver<MutateRowResponse>();
    stub.mutateRow(request, responseObserver);
    assertEquals(5, gcpChannel.channelRefs.size());
    clearObservers.add(responseObserver);

    // Clear the streams and check the channels.
    for (AsyncResponseObserver<MutateRowResponse> observer : clearObservers) {
      observer.awaitCompletion();
    }
    for (ChannelRef channelRef : gcpChannel.channelRefs) {
      assertEquals(0, channelRef.getActiveStreamsCount());
    }
  }

  @Test
  public void testReadRows() throws Exception {
    gcpChannel = new GcpManagedChannel(builder);
    BigtableBlockingStub stub = getBigtableBlockingStub();
    ReadRowsRequest request =
        ReadRowsRequest.newBuilder()
            .setTableName(TABLE_NAME)
            .setRows(RowSet.newBuilder().addRowKeys(ByteString.copyFromUtf8("test-row")))
            .build();
    Iterator<ReadRowsResponse> response = stub.readRows(request);
    assertEquals(21, response.next().getChunksCount());
    assertEquals(1, gcpChannel.channelRefs.size());
  }

  private static class AsyncResponseObserver<RespT> implements StreamObserver<RespT> {
    private final SettableFuture<Void> future = SettableFuture.create();

    AsyncResponseObserver() {}

    void awaitCompletion() throws InterruptedException, ExecutionException, TimeoutException {
      future.get(1, TimeUnit.HOURS);
    }

    @Override
    public void onNext(RespT response) {}

    @Override
    public void onError(Throwable t) {
      future.setException(t);
    }

    @Override
    public void onCompleted() {
      future.set(null);
    }
  }
}
