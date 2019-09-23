/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.BatchingRequestBuilder;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.UnavailableException;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.MutateRowsException;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.common.collect.ImmutableList;
import io.grpc.Status;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MutateRowsBatchingDescriptorTest {
  private static final String ROW_KEY = "fake-row-key";
  private static final String FAMILY = "fake-family";
  private static final String QUALIFIER = "fake-qualifier";
  private static final String VALUE = "fake-value";

  private static final RequestContext requestContext =
      RequestContext.create("fake-project", "fake-instance", "fake-profile");

  @Test
  public void countBytesTest() {
    RowMutationEntry request = RowMutationEntry.create(ROW_KEY).setCell(FAMILY, QUALIFIER, VALUE);
    long bytes = request.toProto().getSerializedSize();

    MutateRowsBatchingDescriptor underTest = new MutateRowsBatchingDescriptor();
    assertThat(underTest.countBytes(request)).isEqualTo(bytes);
  }

  @Test
  public void requestBuilderTest() {
    MutateRowsBatchingDescriptor underTest = new MutateRowsBatchingDescriptor();
    long timestamp = 10_000L;
    BulkMutation bulkMutation = BulkMutation.create("fake-table");
    BatchingRequestBuilder<RowMutationEntry, BulkMutation> requestBuilder =
        underTest.newRequestBuilder(bulkMutation);
    requestBuilder.add(
        RowMutationEntry.create(ROW_KEY).setCell(FAMILY, QUALIFIER, timestamp, VALUE));
    requestBuilder.add(
        RowMutationEntry.create("rowKey-2").setCell("family-2", "q", 20_000L, "some-value"));

    BulkMutation actualBulkMutation = requestBuilder.build();
    assertThat(actualBulkMutation.toProto(requestContext))
        .isEqualTo(
            BulkMutation.create("fake-table")
                .add(ROW_KEY, Mutation.create().setCell(FAMILY, QUALIFIER, timestamp, VALUE))
                .add("rowKey-2", Mutation.create().setCell("family-2", "q", 20_000L, "some-value"))
                .toProto(requestContext));
  }

  @Test
  public void splitResponseTest() {
    List<SettableApiFuture<Void>> batchResponse =
        ImmutableList.of(SettableApiFuture.<Void>create(), SettableApiFuture.<Void>create());
    assertThat(batchResponse.get(0).isDone()).isFalse();
    assertThat(batchResponse.get(1).isDone()).isFalse();

    MutateRowsBatchingDescriptor underTest = new MutateRowsBatchingDescriptor();
    underTest.splitResponse(null, batchResponse);
    assertThat(batchResponse.get(0).isDone()).isTrue();
    assertThat(batchResponse.get(1).isDone()).isTrue();
  }

  @Test
  public void splitExceptionTest() {
    MutateRowsBatchingDescriptor underTest = new MutateRowsBatchingDescriptor();
    final RuntimeException expectedEx = new RuntimeException("Caused while batching");
    List<SettableApiFuture<Void>> batchResponses =
        ImmutableList.of(SettableApiFuture.<Void>create(), SettableApiFuture.<Void>create());

    underTest.splitException(expectedEx, batchResponses);

    for (SettableApiFuture fu : batchResponses) {
      try {
        fu.get();
      } catch (ExecutionException | InterruptedException ex) {
        assertThat(ex).hasCauseThat().isSameInstanceAs(expectedEx);
      }
    }
  }

  @Test
  public void splitExceptionWithFailedMutationsTest() {
    MutateRowsBatchingDescriptor underTest = new MutateRowsBatchingDescriptor();
    Throwable actualThrowable = null;
    SettableApiFuture<Void> resultFuture1 = SettableApiFuture.create();
    SettableApiFuture<Void> resultFuture2 = SettableApiFuture.create();
    SettableApiFuture<Void> resultFuture3 = SettableApiFuture.create();

    // Threw an exception at 1st and 3rd entry
    MutateRowsException serverError =
        new MutateRowsException(
            null,
            ImmutableList.of(
                MutateRowsException.FailedMutation.create(
                    0,
                    new UnavailableException(
                        null, GrpcStatusCode.of(Status.Code.UNAVAILABLE), true)),
                MutateRowsException.FailedMutation.create(
                    2,
                    new DeadlineExceededException(
                        null, GrpcStatusCode.of(Status.Code.DEADLINE_EXCEEDED), true))),
            true);
    underTest.splitException(
        serverError, ImmutableList.of(resultFuture1, resultFuture2, resultFuture3));

    try {
      resultFuture1.get();
    } catch (ExecutionException | InterruptedException e) {
      actualThrowable = e;
    }
    assertThat(actualThrowable)
        .hasCauseThat()
        .isEqualTo(serverError.getFailedMutations().get(0).getError());

    // As there is no exception for 2nd entry so it should not throw any exception
    actualThrowable = null;
    try {
      resultFuture2.get();
    } catch (ExecutionException | InterruptedException e) {
      actualThrowable = e;
    }
    assertThat(actualThrowable).isNull();

    actualThrowable = null;
    try {
      resultFuture3.get();
    } catch (ExecutionException | InterruptedException e) {
      actualThrowable = e;
    }
    // The third response should has the last found failed mutation error.
    assertThat(actualThrowable)
        .hasCauseThat()
        .isEqualTo(serverError.getFailedMutations().get(1).getError());
  }
}
