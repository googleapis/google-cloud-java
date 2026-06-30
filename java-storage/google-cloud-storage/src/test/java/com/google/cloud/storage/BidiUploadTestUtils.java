/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.storage.StorageV2ProtoUtils.fmtProto;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.AbortedException;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ClientStreamReadyObserver;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.storage.ChunkSegmenter.ChunkSegment;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import com.google.protobuf.Timestamp;
import com.google.rpc.Code;
import com.google.storage.v2.BidiWriteObjectRedirectedError;
import com.google.storage.v2.BidiWriteObjectRequest;
import com.google.storage.v2.BidiWriteObjectResponse;
import com.google.storage.v2.ChecksummedData;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.nio.ByteBuffer;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.NonNull;

final class BidiUploadTestUtils {

  private BidiUploadTestUtils() {}

  static @NonNull BidiWriteObjectRedirectedError makeRedirect(String routingToken) {
    return BidiWriteObjectRedirectedError.newBuilder()
        .setRoutingToken(routingToken)
        .setGeneration(1)
        .build();
  }

  static @NonNull AbortedException newAbortedException(String message) {
    return new AbortedException(message, null, GrpcStatusCode.of(Status.Code.ABORTED), false);
  }

  static @NonNull AbortedException packRedirectIntoAbortedException(
      BidiWriteObjectRedirectedError redirect) {
    String description = fmtProto(redirect);
    com.google.rpc.Status grpcStatusDetails =
        com.google.rpc.Status.newBuilder()
            .setCode(Code.ABORTED_VALUE)
            .setMessage(description)
            .addDetails(Any.pack(redirect))
            .build();

    Metadata trailers = new Metadata();
    trailers.put(TestUtils.GRPC_STATUS_DETAILS_KEY, grpcStatusDetails);
    StatusRuntimeException statusRuntimeException =
        Status.ABORTED.withDescription(description).asRuntimeException(trailers);
    ErrorDetails errorDetails =
        ErrorDetails.builder().setRawErrorMessages(grpcStatusDetails.getDetailsList()).build();
    return new AbortedException(
        statusRuntimeException, GrpcStatusCode.of(Status.Code.ABORTED), true, errorDetails);
  }

  static @NonNull BidiWriteObjectResponse incremental(long persistedSize) {
    return BidiWriteObjectResponse.newBuilder().setPersistedSize(persistedSize).build();
  }

  static ChunkSegment createSegment(int length) {
    return createSegment(ChecksummedTestContent.gen(length).asChecksummedData());
  }

  static ChunkSegment createSegment(ChecksummedData cd) {
    ByteString content = cd.getContent();
    ChunkSegmenter segmenter =
        new ChunkSegmenter(
            Hasher.enabled(), ByteStringStrategy.copy(), content.size(), content.size());
    ChunkSegment[] segments =
        segmenter.segmentBuffers(new ByteBuffer[] {content.asReadOnlyByteBuffer()});
    assertThat(segments).hasLength(1);
    return segments[0];
  }

  static List<BidiWriteObjectRequest> sinkToList(BidiUploadState state) {
    ImmutableList.Builder<BidiWriteObjectRequest> b = ImmutableList.builder();
    state.sendVia(b::add);
    return b.build();
  }

  static @NonNull BidiWriteObjectRequest finishAt(int totalOffset) {
    return BidiWriteObjectRequest.newBuilder()
        .setFinishWrite(true)
        .setWriteOffset(totalOffset)
        .build();
  }

  static BidiWriteObjectRequest withRedirectToken(
      BidiWriteObjectRequest redirectReconcile, String routingToken) {
    BidiWriteObjectRequest.Builder b = redirectReconcile.toBuilder();
    b.getAppendObjectSpecBuilder().setRoutingToken(routingToken);
    return b.build();
  }

  static BidiWriteObjectRequest withFlushAndStateLookup(BidiWriteObjectRequest orig) {
    return orig.toBuilder().setFlush(true).setStateLookup(true).build();
  }

  static Timestamp timestampNow() {
    return Conversions.grpc().timestampCodec.encode(OffsetDateTime.now());
  }

  static BidiStreamingCallable<BidiWriteObjectRequest, BidiWriteObjectResponse>
      alwaysErrorBidiStreamingCallable(Status status) {
    return adaptOnlySend(respond -> request -> respond.onError(status.asRuntimeException()));
  }

  static <ReqT extends Message, ResT> BidiStreamingCallable<ReqT, ResT> adaptOnlySend(
      Function<ResponseObserver<ResT>, OnlySendClientStream<ReqT>> func) {
    return adapt(func::apply);
  }

  static <ReqT extends Message, ResT> BidiStreamingCallable<ReqT, ResT> adapt(
      Function<ResponseObserver<ResT>, ClientStream<ReqT>> func) {
    return adapt(
        (respond, onReady, context) -> {
          ClientStream<ReqT> clientStream = func.apply(respond);
          StreamController controller = TestUtils.nullStreamController();
          respond.onStart(controller);
          return clientStream;
        });
  }

  /**
   * BidiStreamingCallable isn't functional even though it's a single abstract method.
   *
   * <p>Define a method that can adapt a TriFunc as the required implementation of {@link
   * BidiStreamingCallable#internalCall(ResponseObserver, ClientStreamReadyObserver,
   * ApiCallContext)}.
   *
   * <p>Saves several lines of boilerplate in each test.
   */
  static <ReqT, ResT> BidiStreamingCallable<ReqT, ResT> adapt(
      TriFunc<
              ResponseObserver<ResT>,
              ClientStreamReadyObserver<ReqT>,
              ApiCallContext,
              ClientStream<ReqT>>
          func) {
    return new BidiStreamingCallable<ReqT, ResT>() {
      @Override
      public ClientStream<ReqT> internalCall(
          ResponseObserver<ResT> respond,
          ClientStreamReadyObserver<ReqT> onReady,
          ApiCallContext context) {
        return func.apply(respond, onReady, context);
      }
    };
  }

  @FunctionalInterface
  interface TriFunc<A, B, C, R> {
    R apply(A a, B b, C c);
  }

  @FunctionalInterface
  interface OnlySendClientStream<ReqT> extends ClientStream<ReqT> {
    @Override
    default void closeSendWithError(Throwable t) {}

    @Override
    default void closeSend() {}

    @Override
    default boolean isSendReady() {
      return true;
    }
  }
}
