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
package com.google.cloud.bigtable.data.v2.internal.dp;

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.PeerInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.DirectPathCompatibleTracer;
import com.google.cloud.bigtable.data.v2.stub.MetadataExtractorInterceptor;
import com.google.cloud.bigtable.gaxx.grpc.ChannelPrimer;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.protobuf.Any;
import com.google.rpc.ErrorInfo;
import com.google.rpc.PreconditionFailure;
import com.google.rpc.Status;
import io.grpc.Channel;
import io.grpc.ClientInterceptors;
import io.grpc.ManagedChannel;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * Evaluates whether a given channel has Direct Access (DirectPath) routing by executing a RPC and
 * inspecting the response headers.
 */
@InternalApi
public class ClassicDirectAccessChecker implements DirectAccessChecker {
  private static final Logger LOG = Logger.getLogger(ClassicDirectAccessChecker.class.getName());
  private final DirectPathCompatibleTracer tracer;
  private final ChannelPrimer channelPrimer;
  private final ScheduledExecutorService executor;

  public ClassicDirectAccessChecker(
      DirectPathCompatibleTracer tracer,
      ChannelPrimer channelPrimer,
      ScheduledExecutorService executor) {
    this.tracer = Preconditions.checkNotNull(tracer);
    this.channelPrimer = Preconditions.checkNotNull(channelPrimer);
    this.executor = Preconditions.checkNotNull(executor);
  }

  @VisibleForTesting
  MetadataExtractorInterceptor createInterceptor() {
    return new MetadataExtractorInterceptor();
  }

  @Override
  public boolean check(Channel channel) {
    try {
      return evaluateEligibility(channel);
    } catch (Exception e) {
      investigateFailure(e);
      LOG.log(Level.WARNING, "Failed to evaluate direct access eligibility.", e);
      return false;
    } finally {
      if (channel instanceof ManagedChannel) {
        ManagedChannel managedChannel = (ManagedChannel) channel;
        managedChannel.shutdownNow();
      }
    }
  }

  /** Checks if the exception is due to a VPC Service Controls policy violation. */
  private boolean isVpcScViolation(StatusRuntimeException e) {
    try {
      Status status = StatusProto.fromThrowable(e);
      if (status != null) {
        for (Any detail : status.getDetailsList()) {
          // Check for ErrorInfo reason
          if (detail.is(ErrorInfo.class)) {
            ErrorInfo errorInfo = detail.unpack(ErrorInfo.class);
            if ("VPC_SERVICE_CONTROLS".equals(errorInfo.getReason())) {
              return true;
            }
          }
          // Check for PreconditionFailure violation type
          if (detail.is(PreconditionFailure.class)) {
            PreconditionFailure failure = detail.unpack(PreconditionFailure.class);
            for (PreconditionFailure.Violation violation : failure.getViolationsList()) {
              if ("VPC_SERVICE_CONTROLS".equals(violation.getType())) {
                return true;
              }
            }
          }
        }
      }
    } catch (Exception ex) {
      // Fall back silently to string matching if protobuf unpacking fails
    }

    // Check the error message if we can't parse ErrorDetails
    String description = e.getStatus().getDescription();
    String message = e.getMessage();

    return (description != null
            && (description.contains("VPC Service Controls")
                || description.contains("VPC_SERVICE_CONTROLS")))
        || (message != null
            && (message.contains("VPC Service Controls")
                || message.contains("VPC_SERVICE_CONTROLS")));
  }

  /** Executes the underlying RPC and evaluates the eligibility. */
  private boolean evaluateEligibility(Channel channel) {
    MetadataExtractorInterceptor interceptor = createInterceptor();
    Channel interceptedChannel = ClientInterceptors.intercept(channel, interceptor);
    MetadataExtractorInterceptor.SidebandData sidebandData = interceptor.getSidebandData();
    boolean isEligible = false;
    try {
      channelPrimer.primeChannel(interceptedChannel);
      isEligible =
          Optional.ofNullable(sidebandData.getPeerInfo())
              .map(PeerInfo::getTransportType)
              .map(type -> type == PeerInfo.TransportType.TRANSPORT_TYPE_DIRECT_ACCESS)
              .orElse(false);
    } catch (StatusRuntimeException e) {
      if (e.getStatus().getCode() != Code.PERMISSION_DENIED) {
        throw e;
      }

      if (isVpcScViolation(e)) {
        LOG.log(
            Level.WARNING,
            "DirectPath is blocked by a VPC Service Controls perimeter policy violation.");
      } else {
        // Failed with standard permission error, resorting to ALTS check.
        isEligible = sidebandData.isAlts();
      }
    }

    if (isEligible) {
      // getIp should be non-null as isEligible is true
      tracer.recordSuccess(sidebandData.getIpProtocol());
    } else {
      investigateFailure(null);
    }
    return isEligible;
  }

  @Override
  public void investigateFailure(@Nullable Throwable originalError) {
    if (executor != null) {
      executor.execute(() -> DirectAccessInvestigator.investigateAndReport(tracer, originalError));
    }
  }
}
