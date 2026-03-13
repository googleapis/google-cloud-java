/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc;

import com.google.api.client.util.Preconditions;
import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.tracing.ApiTracer.Scope;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.stub.MetadataUtils;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * {@code GrpcClientCalls} creates a new {@code ClientCall} from the given call context.
 *
 * <p>Package-private for internal use.
 */
class GrpcClientCalls {
  private static final Logger LOGGER = Logger.getLogger(GrpcDirectCallable.class.getName());

  private GrpcClientCalls() {}
  ;

  public static <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
      MethodDescriptor<RequestT, ResponseT> descriptor, ApiCallContext context) {
    if (!(context instanceof GrpcCallContext)) {
      throw new IllegalArgumentException(
          "context must be an instance of GrpcCallContext, but found "
              + context.getClass().getName());
    }

    GrpcCallContext grpcContext = (GrpcCallContext) context;
    Preconditions.checkNotNull(grpcContext.getChannel());

    CallOptions callOptions = grpcContext.getCallOptions();
    Preconditions.checkNotNull(callOptions);

    // Try to convert the timeout into a deadline and use it if it occurs before the actual deadline
    if (grpcContext.getTimeoutDuration() != null) {
      Deadline newDeadline =
          Deadline.after(grpcContext.getTimeoutDuration().toMillis(), TimeUnit.MILLISECONDS);
      Deadline oldDeadline = callOptions.getDeadline();

      if (oldDeadline == null || newDeadline.isBefore(oldDeadline)) {
        callOptions = callOptions.withDeadline(newDeadline);
      }
    }

    Channel channel = grpcContext.getChannel();
    if (grpcContext.getChannelAffinity() != null && channel instanceof ChannelPool) {
      channel = ((ChannelPool) channel).getChannel(grpcContext.getChannelAffinity());
    }

    if (!grpcContext.getExtraHeaders().isEmpty()) {
      ClientInterceptor interceptor =
          MetadataUtils.newAttachHeadersInterceptor(grpcContext.getMetadata());
      channel = ClientInterceptors.intercept(channel, interceptor);
    }

    // Validate the Universe Domain prior to the call. Only allow the call to go through
    // if the Universe Domain is valid.
    grpcContext.validateUniverseDomain();

    try (Scope ignored = grpcContext.getTracer().inScope()) {
      return channel.newCall(descriptor, callOptions);
    }
  }

  /**
   * A work-alike of {@link io.grpc.stub.ClientCalls#futureUnaryCall(ClientCall, Object)}.
   *
   * <p>The only difference is that unlike grpc-stub's implementation. This implementation doesn't
   * wait for trailers to resolve a unary RPC. This can save milliseconds when the server is
   * overloaded.
   */
  @BetaApi
  static <RequestT, ResponseT> ApiFuture<ResponseT> eagerFutureUnaryCall(
      ClientCall<RequestT, ResponseT> clientCall, RequestT request) {
    // Start the call
    GrpcFuture<ResponseT> future = new GrpcFuture<>(clientCall);
    clientCall.start(new EagerFutureListener<>(future), new Metadata());

    // Send the request
    try {
      clientCall.sendMessage(request);
      clientCall.halfClose();
      // Request an extra message to detect misconfigured servers
      clientCall.request(2);
    } catch (Throwable sendError) {
      // Cancel if anything goes wrong
      try {
        clientCall.cancel(null, sendError);
      } catch (Throwable cancelError) {
        LOGGER.log(Level.SEVERE, "Error encountered while closing it", sendError);
      }

      throw sendError;
    }

    return future;
  }

  /** Thin wrapper around an ApiFuture that will cancel the underlying ClientCall. */
  private static class GrpcFuture<T> extends AbstractApiFuture<T> {
    private final ClientCall<?, T> call;

    private GrpcFuture(ClientCall<?, T> call) {
      this.call = call;
    }

    @Override
    protected void interruptTask() {
      call.cancel("GrpcFuture was cancelled", null);
    }

    @Override
    public boolean set(T value) {
      return super.set(value);
    }

    @Override
    public boolean setException(Throwable throwable) {
      return super.setException(throwable);
    }
  }

  /**
   * A bridge between gRPC's ClientCall.Listener to an ApiFuture.
   *
   * <p>The Listener will eagerly resolve the future when the first message is received and will not
   * wait for the trailers. This should cut down on the latency at the expense of safety. If the
   * server is misconfigured and sends a second response for a unary call, the error will be logged,
   * but the future will still be successful.
   */
  private static class EagerFutureListener<T> extends ClientCall.Listener<T> {
    private final GrpcFuture<T> future;

    private EagerFutureListener(GrpcFuture<T> future) {
      this.future = future;
    }

    @Override
    public void onMessage(T message) {
      if (!future.set(message)) {
        throw Status.INTERNAL
            .withDescription("More than one value received for unary call")
            .asRuntimeException();
      }
    }

    @Override
    public void onClose(Status status, Metadata trailers) {
      if (!future.isDone()) {
        future.setException(
            Status.INTERNAL
                .withDescription("No value received for unary call")
                .asException(trailers));
      }
      if (!status.isOk()) {
        LOGGER.log(
            Level.WARNING, "Received error for unary call after receiving a successful response");
      }
    }
  }
}
