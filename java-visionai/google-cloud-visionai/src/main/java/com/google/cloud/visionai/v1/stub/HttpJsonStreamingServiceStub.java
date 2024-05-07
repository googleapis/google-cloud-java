/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.visionai.v1.stub;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.visionai.v1.AcquireLeaseRequest;
import com.google.cloud.visionai.v1.Lease;
import com.google.cloud.visionai.v1.ReceiveEventsRequest;
import com.google.cloud.visionai.v1.ReceiveEventsResponse;
import com.google.cloud.visionai.v1.ReceivePacketsRequest;
import com.google.cloud.visionai.v1.ReceivePacketsResponse;
import com.google.cloud.visionai.v1.ReleaseLeaseRequest;
import com.google.cloud.visionai.v1.ReleaseLeaseResponse;
import com.google.cloud.visionai.v1.RenewLeaseRequest;
import com.google.cloud.visionai.v1.SendPacketsRequest;
import com.google.cloud.visionai.v1.SendPacketsResponse;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the StreamingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonStreamingServiceStub extends StreamingServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<AcquireLeaseRequest, Lease>
      acquireLeaseMethodDescriptor =
          ApiMethodDescriptor.<AcquireLeaseRequest, Lease>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamingService/AcquireLease")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AcquireLeaseRequest>newBuilder()
                      .setPath(
                          "/v1/{series=projects/*/locations/*/clusters/*/series/*}:acquireLease",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AcquireLeaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "series", request.getSeries());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AcquireLeaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearSeries().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Lease>newBuilder()
                      .setDefaultInstance(Lease.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RenewLeaseRequest, Lease> renewLeaseMethodDescriptor =
      ApiMethodDescriptor.<RenewLeaseRequest, Lease>newBuilder()
          .setFullMethodName("google.cloud.visionai.v1.StreamingService/RenewLease")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<RenewLeaseRequest>newBuilder()
                  .setPath(
                      "/v1/{series=projects/*/locations/*/clusters/*/series/*}:renewLease",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<RenewLeaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "series", request.getSeries());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<RenewLeaseRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearSeries().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Lease>newBuilder()
                  .setDefaultInstance(Lease.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ReleaseLeaseRequest, ReleaseLeaseResponse>
      releaseLeaseMethodDescriptor =
          ApiMethodDescriptor.<ReleaseLeaseRequest, ReleaseLeaseResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.StreamingService/ReleaseLease")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReleaseLeaseRequest>newBuilder()
                      .setPath(
                          "/v1/{series=projects/*/locations/*/clusters/*/series/*}:releaseLease",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReleaseLeaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "series", request.getSeries());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReleaseLeaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearSeries().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReleaseLeaseResponse>newBuilder()
                      .setDefaultInstance(ReleaseLeaseResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<AcquireLeaseRequest, Lease> acquireLeaseCallable;
  private final UnaryCallable<RenewLeaseRequest, Lease> renewLeaseCallable;
  private final UnaryCallable<ReleaseLeaseRequest, ReleaseLeaseResponse> releaseLeaseCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonStreamingServiceStub create(StreamingServiceStubSettings settings)
      throws IOException {
    return new HttpJsonStreamingServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonStreamingServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonStreamingServiceStub(
        StreamingServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonStreamingServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonStreamingServiceStub(
        StreamingServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonStreamingServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStreamingServiceStub(
      StreamingServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonStreamingServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonStreamingServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStreamingServiceStub(
      StreamingServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AcquireLeaseRequest, Lease> acquireLeaseTransportSettings =
        HttpJsonCallSettings.<AcquireLeaseRequest, Lease>newBuilder()
            .setMethodDescriptor(acquireLeaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("series", String.valueOf(request.getSeries()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RenewLeaseRequest, Lease> renewLeaseTransportSettings =
        HttpJsonCallSettings.<RenewLeaseRequest, Lease>newBuilder()
            .setMethodDescriptor(renewLeaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("series", String.valueOf(request.getSeries()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ReleaseLeaseRequest, ReleaseLeaseResponse> releaseLeaseTransportSettings =
        HttpJsonCallSettings.<ReleaseLeaseRequest, ReleaseLeaseResponse>newBuilder()
            .setMethodDescriptor(releaseLeaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("series", String.valueOf(request.getSeries()));
                  return builder.build();
                })
            .build();

    this.acquireLeaseCallable =
        callableFactory.createUnaryCallable(
            acquireLeaseTransportSettings, settings.acquireLeaseSettings(), clientContext);
    this.renewLeaseCallable =
        callableFactory.createUnaryCallable(
            renewLeaseTransportSettings, settings.renewLeaseSettings(), clientContext);
    this.releaseLeaseCallable =
        callableFactory.createUnaryCallable(
            releaseLeaseTransportSettings, settings.releaseLeaseSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(acquireLeaseMethodDescriptor);
    methodDescriptors.add(renewLeaseMethodDescriptor);
    methodDescriptors.add(releaseLeaseMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AcquireLeaseRequest, Lease> acquireLeaseCallable() {
    return acquireLeaseCallable;
  }

  @Override
  public UnaryCallable<RenewLeaseRequest, Lease> renewLeaseCallable() {
    return renewLeaseCallable;
  }

  @Override
  public UnaryCallable<ReleaseLeaseRequest, ReleaseLeaseResponse> releaseLeaseCallable() {
    return releaseLeaseCallable;
  }

  @Override
  public BidiStreamingCallable<SendPacketsRequest, SendPacketsResponse> sendPacketsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: sendPacketsCallable(). REST transport is not implemented for this method yet.");
  }

  @Override
  public BidiStreamingCallable<ReceivePacketsRequest, ReceivePacketsResponse>
      receivePacketsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: receivePacketsCallable(). REST transport is not implemented for this method yet.");
  }

  @Override
  public BidiStreamingCallable<ReceiveEventsRequest, ReceiveEventsResponse>
      receiveEventsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: receiveEventsCallable(). REST transport is not implemented for this method yet.");
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
