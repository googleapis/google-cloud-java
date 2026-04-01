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

package com.google.cloud.storage;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStream;
import com.google.api.gax.rpc.BidiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ClientStreamReadyObserver;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStream;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StateCheckingResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.Message;
import com.google.rpc.Status;
import com.google.storage.v2.BidiReadObjectError;
import com.google.storage.v2.BidiReadObjectRedirectedError;
import com.google.storage.v2.BidiWriteObjectRedirectedError;
import io.grpc.StatusRuntimeException;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

final class GrpcUtils {

  private GrpcUtils() {}

  static GrpcCallContext contextWithBucketName(String bucketName, GrpcCallContext baseContext) {
    if (bucketName != null && !bucketName.isEmpty()) {
      return baseContext.withExtraHeaders(
          ImmutableMap.of(
              "x-goog-request-params",
              ImmutableList.of(String.format(Locale.US, "bucket=%s", bucketName))));
    }
    return baseContext;
  }

  /**
   * In the event closing the streams results in multiple streams throwing IOExceptions, collect
   * them all as suppressed exceptions on the first occurrence.
   */
  static <C extends Closeable> void closeAll(Collection<C> closeables) throws IOException {
    if (closeables.isEmpty()) {
      return;
    }
    IOException ioException =
        closeables.stream()
            .filter(Objects::nonNull)
            .map(
                stream -> {
                  try {
                    stream.close();
                    return null;
                  } catch (IOException e) {
                    return e;
                  }
                })
            .filter(Objects::nonNull)
            .reduce(
                null,
                (l, r) -> {
                  if (l != null) {
                    l.addSuppressed(r);
                    return l;
                  } else {
                    return r;
                  }
                },
                (l, r) -> l);

    if (ioException != null) {
      throw ioException;
    }
  }

  /**
   * Returns the first occurrence of a {@link BidiReadObjectRedirectedError} if the throwable is an
   * {@link ApiException} with {@link ErrorDetails} that contain an entry that is a {@link
   * BidiReadObjectRedirectedError} (evaluated from index 0 to length). {@code null} otherwise.
   */
  @Nullable
  static BidiReadObjectRedirectedError getBidiReadObjectRedirectedError(Throwable t) {
    return findFirstPackedAny(t, BidiReadObjectRedirectedError.class);
  }

  /**
   * Returns the first occurrence of a {@link BidiWriteObjectRedirectedError} if the throwable is an
   * {@link ApiException} with {@link ErrorDetails} that contain an entry that is a {@link
   * BidiWriteObjectRedirectedError} (evaluated from index 0 to length). {@code null} otherwise.
   */
  @Nullable
  static BidiWriteObjectRedirectedError getBidiWriteObjectRedirectedError(Throwable t) {
    return findFirstPackedAny(t, BidiWriteObjectRedirectedError.class);
  }

  /**
   * Returns the first occurrence of a {@link BidiReadObjectError} if the throwable is an {@link
   * ApiException} with {@link ErrorDetails} that contain an entry that is a {@link
   * BidiReadObjectError} (evaluated from index 0 to length). {@code null} otherwise.
   */
  @Nullable
  static BidiReadObjectError getBidiReadObjectError(Throwable t) {
    return findFirstPackedAny(t, BidiReadObjectError.class);
  }

  static ApiException statusToApiException(Status status) {
    io.grpc.Status grpcStatus = io.grpc.Status.fromCodeValue(status.getCode());
    if (!status.getMessage().isEmpty()) {
      grpcStatus = grpcStatus.withDescription(status.getMessage());
    }
    StatusRuntimeException cause = grpcStatus.asRuntimeException();
    return ApiExceptionFactory.createException(
        cause, GrpcStatusCode.of(grpcStatus.getCode()), false);
  }

  @Nullable
  private static <M extends Message> M findFirstPackedAny(Throwable t, Class<M> clazz) {
    if (t instanceof ApiException) {
      ApiException apiException = (ApiException) t;
      ErrorDetails errorDetails = apiException.getErrorDetails();
      if (errorDetails != null) {
        return errorDetails.getMessage(clazz);
      }
    }
    return null;
  }

  static <R> StateCheckingResponseObserver<R> decorateAsStateChecking(
      ResponseObserver<R> delegate) {
    return new DecoratingStateCheckingResponseObserver<>(delegate);
  }

  private static final class DecoratingStateCheckingResponseObserver<Response>
      extends StateCheckingResponseObserver<Response> {
    private final ResponseObserver<Response> delegate;

    private DecoratingStateCheckingResponseObserver(ResponseObserver<Response> delegate) {
      this.delegate = delegate;
    }

    @Override
    protected void onStartImpl(StreamController controller) {
      delegate.onStart(controller);
    }

    @Override
    protected void onResponseImpl(Response response) {
      delegate.onResponse(response);
    }

    @Override
    protected void onErrorImpl(Throwable t) {
      delegate.onError(t);
    }

    @Override
    protected void onCompleteImpl() {
      delegate.onComplete();
    }
  }

  @SuppressWarnings("deprecation")
  static final class ZeroCopyBidiStreamingCallable<RequestT, ResponseT>
      extends BidiStreamingCallable<RequestT, ResponseT> {
    private final BidiStreamingCallable<RequestT, ResponseT> delegate;
    private final ResponseContentLifecycleManager<ResponseT> responseContentLifecycleManager;

    ZeroCopyBidiStreamingCallable(
        BidiStreamingCallable<RequestT, ResponseT> delegate,
        ResponseContentLifecycleManager<ResponseT> responseContentLifecycleManager) {
      this.delegate = delegate;
      this.responseContentLifecycleManager = responseContentLifecycleManager;
    }

    @Override
    public ClientStream<RequestT> internalCall(
        ResponseObserver<ResponseT> responseObserver,
        ClientStreamReadyObserver<RequestT> onReady,
        ApiCallContext context) {
      return delegate.internalCall(responseObserver, onReady, context);
    }

    @Override
    public void call(BidiStreamObserver<RequestT, ResponseT> bidiObserver) {
      delegate.call(bidiObserver);
    }

    @Override
    public void call(BidiStreamObserver<RequestT, ResponseT> bidiObserver, ApiCallContext context) {
      delegate.call(bidiObserver, context);
    }

    @Override
    public BidiStream<RequestT, ResponseT> call() {
      return delegate.call();
    }

    @Override
    public BidiStream<RequestT, ResponseT> call(ApiCallContext context) {
      return delegate.call(context);
    }

    @Override
    public ClientStream<RequestT> splitCall(ResponseObserver<ResponseT> responseObserver) {
      return delegate.splitCall(responseObserver);
    }

    @Override
    public ClientStream<RequestT> splitCall(
        ResponseObserver<ResponseT> responseObserver, ApiCallContext context) {
      return delegate.splitCall(responseObserver, context);
    }

    @Override
    @Deprecated
    public ApiStreamObserver<RequestT> bidiStreamingCall(
        ApiStreamObserver<ResponseT> responseObserver, ApiCallContext context) {
      return delegate.bidiStreamingCall(responseObserver, context);
    }

    @Override
    @Deprecated
    public ApiStreamObserver<RequestT> bidiStreamingCall(
        ApiStreamObserver<ResponseT> responseObserver) {
      return delegate.bidiStreamingCall(responseObserver);
    }

    @Override
    public ZeroCopyBidiStreamingCallable<RequestT, ResponseT> withDefaultCallContext(
        ApiCallContext defaultCallContext) {
      return new ZeroCopyBidiStreamingCallable<>(
          delegate.withDefaultCallContext(defaultCallContext), responseContentLifecycleManager);
    }

    ResponseContentLifecycleManager<ResponseT> getResponseContentLifecycleManager() {
      return responseContentLifecycleManager;
    }
  }

  @SuppressWarnings("deprecation")
  static final class ZeroCopyServerStreamingCallable<RequestT, ResponseT>
      extends ServerStreamingCallable<RequestT, ResponseT> {
    private final ServerStreamingCallable<RequestT, ResponseT> delegate;
    private final ResponseContentLifecycleManager<ResponseT> responseContentLifecycleManager;

    ZeroCopyServerStreamingCallable(
        ServerStreamingCallable<RequestT, ResponseT> delegate,
        ResponseContentLifecycleManager<ResponseT> responseContentLifecycleManager) {
      this.delegate = delegate;
      this.responseContentLifecycleManager = responseContentLifecycleManager;
    }

    @Override
    public ServerStream<ResponseT> call(RequestT request) {
      return delegate.call(request);
    }

    @Override
    public ServerStream<ResponseT> call(RequestT request, ApiCallContext context) {
      return delegate.call(request, context);
    }

    @Override
    public void call(
        RequestT request, ResponseObserver<ResponseT> responseObserver, ApiCallContext context) {
      delegate.call(request, responseObserver, context);
    }

    @Override
    public void call(RequestT request, ResponseObserver<ResponseT> responseObserver) {
      delegate.call(request, responseObserver);
    }

    @Override
    public UnaryCallable<RequestT, ResponseT> first() {
      return delegate.first();
    }

    @Override
    public UnaryCallable<RequestT, List<ResponseT>> all() {
      return delegate.all();
    }

    @Override
    @Deprecated
    public void serverStreamingCall(
        RequestT request, ApiStreamObserver<ResponseT> responseObserver, ApiCallContext context) {
      delegate.serverStreamingCall(request, responseObserver, context);
    }

    @Override
    @Deprecated
    public void serverStreamingCall(
        RequestT request, ApiStreamObserver<ResponseT> responseObserver) {
      delegate.serverStreamingCall(request, responseObserver);
    }

    @Override
    @Deprecated
    public Iterator<ResponseT> blockingServerStreamingCall(
        RequestT request, ApiCallContext context) {
      return delegate.blockingServerStreamingCall(request, context);
    }

    @Override
    @Deprecated
    public Iterator<ResponseT> blockingServerStreamingCall(RequestT request) {
      return delegate.blockingServerStreamingCall(request);
    }

    @Override
    public ZeroCopyServerStreamingCallable<RequestT, ResponseT> withDefaultCallContext(
        ApiCallContext defaultCallContext) {
      return new ZeroCopyServerStreamingCallable<>(
          delegate.withDefaultCallContext(defaultCallContext), responseContentLifecycleManager);
    }

    ResponseContentLifecycleManager<ResponseT> getResponseContentLifecycleManager() {
      return responseContentLifecycleManager;
    }
  }
}
