/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner.spi;

import com.google.rpc.BadRequest;
import com.google.rpc.Help;
import com.google.rpc.LocalizedMessage;
import com.google.rpc.QuotaFailure;
import com.google.rpc.RequestInfo;
import com.google.rpc.ResourceInfo;
import com.google.rpc.RetryInfo;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Adds error details to statuses returned by the Cloud Spanner API. TODO(user): Add integration
 * tests to check for error details.
 */
public final class SpannerErrorInterceptor implements ClientInterceptor {
  private static final Logger logger = Logger.getLogger(SpannerErrorInterceptor.class.getName());

  private static final Metadata.Key<LocalizedMessage> LOCALIZED_MESSAGE_KEY =
      ProtoUtils.keyForProto(LocalizedMessage.getDefaultInstance());
  private static final Metadata.Key<BadRequest> BAD_REQUEST_KEY =
      ProtoUtils.keyForProto(BadRequest.getDefaultInstance());
  private static final Metadata.Key<Help> HELP_KEY =
      ProtoUtils.keyForProto(Help.getDefaultInstance());
  private static final Metadata.Key<QuotaFailure> QUOTA_FAILURE_KEY =
      ProtoUtils.keyForProto(QuotaFailure.getDefaultInstance());
  private static final Metadata.Key<RequestInfo> REQUEST_INFO_KEY =
      ProtoUtils.keyForProto(RequestInfo.getDefaultInstance());
  private static final Metadata.Key<ResourceInfo> RESOURCE_INFO_KEY =
      ProtoUtils.keyForProto(ResourceInfo.getDefaultInstance());
  private static final Metadata.Key<RetryInfo> RETRY_INFO_KEY =
      ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());

  @Override
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
      MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
    return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
      @Override
      public void start(Listener<RespT> responseListener, Metadata headers) {
        super.start(
            new SimpleForwardingClientCallListener<RespT>(responseListener) {
              @Override
              public void onClose(Status status, Metadata trailers) {
                try {
                  if (trailers.containsKey(LOCALIZED_MESSAGE_KEY)) {
                    status =
                        Status.fromCodeValue(status.getCode().value())
                            .withDescription(trailers.get(LOCALIZED_MESSAGE_KEY).getMessage());
                  }
                  if (trailers.containsKey(BAD_REQUEST_KEY)) {
                    status = status.augmentDescription(trailers.get(BAD_REQUEST_KEY).toString());
                  }
                  if (trailers.containsKey(HELP_KEY)) {
                    status = status.augmentDescription(trailers.get(HELP_KEY).toString());
                  }
                  if (trailers.containsKey(QUOTA_FAILURE_KEY)) {
                    status = status.augmentDescription(trailers.get(QUOTA_FAILURE_KEY).toString());
                  }
                  if (trailers.containsKey(REQUEST_INFO_KEY)) {
                    status = status.augmentDescription(trailers.get(REQUEST_INFO_KEY).toString());
                  }
                  if (trailers.containsKey(RESOURCE_INFO_KEY)) {
                    status = status.augmentDescription(trailers.get(RESOURCE_INFO_KEY).toString());
                  }
                  if (trailers.containsKey(RETRY_INFO_KEY)) {
                    status = status.augmentDescription(trailers.get(RETRY_INFO_KEY).toString());
                  }
                } catch (IllegalArgumentException e) {
                  // Messages could be invalid if, say, some invalid UTF8 is echoed back in some
                  // error text.
                  logger.log(Level.WARNING, "Invalid protocol message in metadata", e);
                } finally {
                  super.onClose(status, trailers);
                }
              }
            },
            headers);
      }
    };
  }
}
