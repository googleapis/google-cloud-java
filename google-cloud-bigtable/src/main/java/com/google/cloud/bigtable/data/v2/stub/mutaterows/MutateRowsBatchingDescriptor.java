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
package com.google.cloud.bigtable.data.v2.stub.mutaterows;

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.BatchedRequestIssuer;
import com.google.api.gax.rpc.BatchingDescriptor;
import com.google.api.gax.rpc.StatusCode;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import com.google.rpc.Code;
import com.google.rpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.Collection;
import java.util.Set;

/**
 * A custom implementation of a {@link BatchingDescriptor} to split individual results of a bulk
 * MutateRowsResponse. Each individual result will be matched with its issuer. Since the embedded
 * results bypass gax's result processing chains, this class is responsible for wrapping errors in
 * {@link ApiException}s and marking each error as retryable.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications directly.
 */
@InternalApi
public class MutateRowsBatchingDescriptor
    implements BatchingDescriptor<MutateRowsRequest, MutateRowsResponse> {

  // Shared response to notify individual issuers of a successful mutation.
  private static final MutateRowsResponse OK_RESPONSE =
      MutateRowsResponse.newBuilder()
          .addEntries(
              MutateRowsResponse.Entry.newBuilder()
                  .setIndex(0)
                  .setStatus(Status.newBuilder().setCode(Code.OK_VALUE)))
          .build();

  private final ImmutableSet<StatusCode.Code> retryableCodes;

  public MutateRowsBatchingDescriptor(Set<StatusCode.Code> retryableCodes) {
    this.retryableCodes = ImmutableSet.copyOf(retryableCodes);
  }

  /** Return the target table name. This will be used to combine batcheable requests */
  @Override
  public PartitionKey getBatchPartitionKey(MutateRowsRequest request) {
    return new PartitionKey(request.getTableName());
  }

  /** {@inheritDoc} */
  @Override
  public RequestBuilder<MutateRowsRequest> getRequestBuilder() {
    return new MyRequestBuilder();
  }

  /** {@inheritDoc} */
  @Override
  public void splitResponse(
      MutateRowsResponse batchResponse,
      Collection<? extends BatchedRequestIssuer<MutateRowsResponse>> batch) {

    // Sort the result entries by index.
    Status[] sortedEntries = new Status[batchResponse.getEntriesCount()];

    for (MutateRowsResponse.Entry entry : batchResponse.getEntriesList()) {
      int index = Ints.checkedCast(entry.getIndex());
      Preconditions.checkState(
          sortedEntries[index] == null, "Got multiple results for the same sub-mutation");
      sortedEntries[index] = entry.getStatus();
    }

    // Notify all of issuers of the corresponding result.
    int i = 0;
    for (BatchedRequestIssuer<MutateRowsResponse> issuer : batch) {
      Status entry = sortedEntries[i++];
      Preconditions.checkState(entry != null, "Missing result for entry");

      if (entry.getCode() == Code.OK_VALUE) {
        issuer.setResponse(OK_RESPONSE);
      } else {
        issuer.setException(createElementException(entry));
      }
    }
  }

  /** {@inheritDoc} */
  @Override
  public void splitException(
      Throwable throwable, Collection<? extends BatchedRequestIssuer<MutateRowsResponse>> batch) {
    throwable = createElementException(throwable);

    for (BatchedRequestIssuer<MutateRowsResponse> responder : batch) {
      responder.setException(throwable);
    }
  }

  /** {@inheritDoc} */
  @Override
  public long countElements(MutateRowsRequest request) {
    return request.getEntriesCount();
  }

  /** {@inheritDoc} */
  @Override
  public long countBytes(MutateRowsRequest request) {
    return request.getSerializedSize();
  }

  /** Convert an element error Status into an ApiException */
  private ApiException createElementException(Status protoStatus) {
    Preconditions.checkArgument(protoStatus.getCode() != Code.OK_VALUE, "OK is not an error");

    StatusRuntimeException throwable =
        io.grpc.Status.fromCodeValue(protoStatus.getCode())
            .withDescription(protoStatus.getMessage())
            .asRuntimeException();

    return createElementException(throwable);
  }

  /** Convert a Throwable into an ApiException, marking it as retryable when appropriate. */
  private ApiException createElementException(Throwable throwable) {
    final io.grpc.Status.Code code;

    if (throwable instanceof ApiException) {
      return (ApiException) throwable;
    } else if (throwable instanceof StatusRuntimeException) {
      code = ((StatusRuntimeException) throwable).getStatus().getCode();
    } else if (throwable instanceof StatusException) {
      code = ((StatusException) throwable).getStatus().getCode();
    } else {
      code = io.grpc.Status.Code.UNKNOWN;
    }

    GrpcStatusCode gaxStatusCode = GrpcStatusCode.of(code);
    boolean isRetryable = retryableCodes.contains(gaxStatusCode.getCode());

    return ApiExceptionFactory.createException(throwable, gaxStatusCode, isRetryable);
  }

  /** A {@link com.google.api.gax.batching.RequestBuilder} that can aggregate MutateRowsRequest */
  static class MyRequestBuilder implements RequestBuilder<MutateRowsRequest> {
    private MutateRowsRequest.Builder builder;

    @Override
    public void appendRequest(MutateRowsRequest request) {
      if (builder == null) {
        builder = request.toBuilder();
      } else {
        builder.addAllEntries(request.getEntriesList());
      }
    }

    @Override
    public MutateRowsRequest build() {
      return builder.build();
    }
  }
}
