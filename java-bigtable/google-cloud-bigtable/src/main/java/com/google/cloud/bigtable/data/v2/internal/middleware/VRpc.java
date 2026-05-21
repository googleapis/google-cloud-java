/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.middleware;

import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.ClusterInformation;
import com.google.bigtable.v2.ErrorResponse;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ticker;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Any;
import com.google.rpc.RetryInfo;
import io.grpc.Context;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.StatusProto;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * Internal Bigtable representation of an RPC.
 *
 * <p>The primary intent is to model the RPC as a chain of composable middleware. This abstraction
 * models Unary and ServerStreaming style RPCs by generalizing them as ServerStreaming.
 */
public interface VRpc<ReqT, RespT> {

  /**
   * Start the RPC and send the request message.
   *
   * <p>This must be called before any other method on this object. The {@code listener} will be
   * notified of the results. Please note, that the first response of the response stream will be
   * delivered by default.
   */
  void start(ReqT req, VRpcCallContext ctx, VRpcListener<RespT> listener);

  /** Cancel a started RPC. This will be done by best effort. */
  void cancel(@Nullable String message, @Nullable Throwable cause);

  /**
   * TBD - server streaming rpcs. This will be used to request more data. Unlike gRPC's request(n),
   * starting a call will implicitly request the first message.
   */
  void requestNext();

  /**
   * Bigtable specific version of ClientCall.Listener - simplified to only cater to client unary
   * RPCs. Methods on this class are guaranteed to be called sequentially.
   */
  interface VRpcListener<RespT> {

    /** Called when the next response message is the received. */
    void onMessage(RespT msg);

    /** Called when the vRPC completes. */
    void onClose(VRpcResult result);
  }

  /** vRPC side band data. */
  // TODO: set grpc deadline on callOptions or context
  @AutoValue
  abstract class VRpcCallContext {

    private static final Logger logger = Logger.getLogger(VRpcCallContext.class.getName());

    /** Retry related metadata. */
    public abstract OperationInfo getOperationInfo();

    /** The TraceId of the caller. */
    public abstract String getTraceParent();

    public abstract VRpcTracer getTracer();

    // TODO: csm
    // Clientside metrics instrument
    // public abstract BigtableTracer getTracer();

    public static VRpcCallContext create(
        Deadline deadline, boolean isIdempotent, VRpcTracer tracer) {

      Deadline grpcContextDeadline = Context.current().getDeadline();

      Duration operationTimeout;
      if (grpcContextDeadline != null && grpcContextDeadline.isBefore(deadline)) {
        logger.log(
            Level.FINE,
            "grpc Context deadline {} is shorter than VrpcCallContext deadline {}",
            new Object[] {grpcContextDeadline, deadline});
        operationTimeout =
            Duration.ofNanos(grpcContextDeadline.timeRemaining(TimeUnit.NANOSECONDS));
      } else {
        operationTimeout = Duration.ofNanos(deadline.timeRemaining(TimeUnit.NANOSECONDS));
      }

      return new AutoValue_VRpc_VRpcCallContext(
          OperationInfo.create(operationTimeout, isIdempotent), "TODO", tracer);
    }

    public VRpcCallContext createForNextAttempt() {
      return new AutoValue_VRpc_VRpcCallContext(
          getOperationInfo().createForNextAttempt(), getTraceParent(), getTracer());
    }
  }

  /** Sideband data required for retries and/or hedging. */
  @AutoValue
  abstract class OperationInfo {
    /**
     * Monotonically increasing number of retry attempt per operation. Starts with 0 for the
     * original attempt.
     */
    public abstract int getAttemptNumber();

    /**
     * When the caller started the operation (ie. when the first attempt was sent). This is the
     * machine time.
     */
    abstract long getOperationStartTickNs();

    /**
     * Original timeout of the operation (OperationStart + OperationTimeout = original deadline).
     */
    public abstract Duration getOperationTimeout();

    /** If it's safe to retry the vRPC after its been commited. */
    public abstract boolean isIdempotent();

    abstract Ticker getTicker();

    public Deadline getDeadline() {
      return Deadline.after(
          getOperationTimeout().toNanos() + getOperationStartTickNs() - getTicker().read(),
          TimeUnit.NANOSECONDS);
    }

    /** Create a new copy of the {@link OperationInfo} for the next retry/heding attempt. */
    public OperationInfo createForNextAttempt() {
      return new AutoValue_VRpc_OperationInfo(
          getAttemptNumber() + 1,
          getOperationStartTickNs(),
          getOperationTimeout(),
          isIdempotent(),
          getTicker());
    }

    /** Create new {@link OperationInfo} for the first attempt. */
    public static OperationInfo create(Duration operationTimeout, boolean isIdempotent) {
      return create(Ticker.systemTicker(), operationTimeout, isIdempotent);
    }

    @VisibleForTesting
    static OperationInfo create(Ticker ticker, Duration operationTimeout, boolean isIdempotent) {
      return new AutoValue_VRpc_OperationInfo(
          0, ticker.read(), operationTimeout, isIdempotent, ticker);
    }
  }

  /** Represents the final state of a vRPC. */
  @AutoValue
  abstract class VRpcResult {
    /**
     * Describes how far the vRPC progressed prior to failure:
     *
     * <dl>
     *   <dt>{@code UNCOMMITED}
     *   <dd>The vRPC never left the client
     *   <dt>{@code TRANSPORT_FAILURE}
     *   <dd>The vRPC failed due to transport
     *   <dt>{@code SERVER_RESULT}
     *   <dd>The vRPC result was explicitly communicated by the server
     *   <dt>{@code USER_FAILURE}
     *   <dd>The vRPC failed due to errors in users callback
     * </dl>
     */
    public enum State {
      UNCOMMITED,
      TRANSPORT_FAILURE,
      SERVER_RESULT,
      USER_FAILURE
    }

    /**
     * How far the vRPC progressed before reaching terminal state.
     *
     * @see State
     */
    public abstract State getState();

    public abstract Status getStatus();

    /** The status details. */
    @Nullable
    protected abstract List<Any> getDetails();

    /**
     * Side channel metadata for client side metrics - describes the cluster that handled the
     * request.
     */
    @Nullable
    public abstract ClusterInformation getClusterInfo();

    /** Latency returned in SessionRequestStats. */
    public abstract Duration getBackendLatency();

    /** Server directed retries. */
    // Server directed retries
    @Nullable
    public abstract RetryInfo getRetryInfo();

    /** If the vrpc should be rejected for retry. */
    public abstract boolean getRejected();

    public static VRpcResult createUncommitedError(Status status) {
      return new AutoValue_VRpc_VRpcResult(
          State.UNCOMMITED, status, ImmutableList.of(), null, Duration.ZERO, null, false);
    }

    public static VRpcResult createRejectedError(Status status) {
      return new AutoValue_VRpc_VRpcResult(
          State.UNCOMMITED, status, ImmutableList.of(), null, Duration.ZERO, null, true);
    }

    /**
     * vRPC failed because the underlying transport failed. We don't know if the vRPC made it to the
     * nodes, so we must assume complete uncertainty.
     */
    public static VRpcResult createRemoteTransportError(Status transportStatus, Metadata trailers) {
      Status status = Status.UNAVAILABLE.withDescription("vRPC failed due to transport error");

      if (transportStatus.getCause() != null) {
        status = status.withCause(transportStatus.getCause());
      } else {
        status =
            status.augmentDescription(
                String.format(
                    "Transport error: %s: %s",
                    transportStatus.getCode(), transportStatus.getDescription()));
      }

      List<Any> details =
          StatusProto.fromStatusAndTrailers(transportStatus, trailers).getDetailsList();

      return new AutoValue_VRpc_VRpcResult(
          // TODO: need clusterInfo
          State.TRANSPORT_FAILURE, status, details, null, Duration.ZERO, null, false);
    }

    /**
     * vRPC failed because the underlying transport failed. We don't know if the the vRPC made it to
     * the nodes, so we must assume complete uncertainty.
     */
    public static VRpcResult createLocalTransportError(Status status) {
      return new AutoValue_VRpc_VRpcResult(
          State.TRANSPORT_FAILURE, status, null, null, Duration.ZERO, null, false);
    }

    public static VRpcResult createUserError(Throwable throwable) {
      return new AutoValue_VRpc_VRpcResult(
          State.USER_FAILURE,
          Status.CANCELLED
              .withCause(throwable)
              .withDescription("Cancelling RPC due to exception thrown by user callback"),
          ImmutableList.of(),
          null,
          Duration.ZERO,
          // TODO: use server retry delay if available
          null,
          true);
    }

    /** Wrap an OK from the server. */
    public static VRpcResult createServerOk(VirtualRpcResponse r) {
      return new AutoValue_VRpc_VRpcResult(
          State.SERVER_RESULT,
          Status.OK,
          ImmutableList.of(),
          normalizeClusterInfo(r.getClusterInfo()),
          Duration.ofSeconds(
              r.getStats().getBackendLatency().getSeconds(),
              r.getStats().getBackendLatency().getNanos()),
          null,
          false);
    }

    /** Wrap the error response from the server. */
    public static VRpcResult createServerError(ErrorResponse r) {
      Status grpcStatus =
          Status.fromCodeValue(r.getStatus().getCode()).withDescription(r.getStatus().getMessage());
      return new AutoValue_VRpc_VRpcResult(
          State.SERVER_RESULT,
          grpcStatus,
          r.getStatus().getDetailsList(),
          normalizeClusterInfo(r.getClusterInfo()),
          Duration.ZERO,
          r.getRetryInfo(),
          false);
    }

    @Nullable
    private static ClusterInformation normalizeClusterInfo(ClusterInformation clusterInformation) {
      if (ClusterInformation.getDefaultInstance().equals(clusterInformation)) {
        return null;
      }
      return clusterInformation;
    }
  }
}
