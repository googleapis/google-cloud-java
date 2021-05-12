/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.aiplatform.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.ReadFeatureValuesRequest;
import com.google.cloud.aiplatform.v1beta1.ReadFeatureValuesResponse;
import com.google.cloud.aiplatform.v1beta1.StreamingReadFeatureValuesRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the FeaturestoreOnlineServingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcFeaturestoreOnlineServingServiceStub extends FeaturestoreOnlineServingServiceStub {
  private static final MethodDescriptor<ReadFeatureValuesRequest, ReadFeatureValuesResponse>
      readFeatureValuesMethodDescriptor =
          MethodDescriptor.<ReadFeatureValuesRequest, ReadFeatureValuesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeaturestoreOnlineServingService/ReadFeatureValues")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReadFeatureValuesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReadFeatureValuesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          StreamingReadFeatureValuesRequest, ReadFeatureValuesResponse>
      streamingReadFeatureValuesMethodDescriptor =
          MethodDescriptor
              .<StreamingReadFeatureValuesRequest, ReadFeatureValuesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeaturestoreOnlineServingService/StreamingReadFeatureValues")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamingReadFeatureValuesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReadFeatureValuesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ReadFeatureValuesRequest, ReadFeatureValuesResponse>
      readFeatureValuesCallable;
  private final ServerStreamingCallable<
          StreamingReadFeatureValuesRequest, ReadFeatureValuesResponse>
      streamingReadFeatureValuesCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcFeaturestoreOnlineServingServiceStub create(
      FeaturestoreOnlineServingServiceStubSettings settings) throws IOException {
    return new GrpcFeaturestoreOnlineServingServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFeaturestoreOnlineServingServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcFeaturestoreOnlineServingServiceStub(
        FeaturestoreOnlineServingServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFeaturestoreOnlineServingServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFeaturestoreOnlineServingServiceStub(
        FeaturestoreOnlineServingServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcFeaturestoreOnlineServingServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcFeaturestoreOnlineServingServiceStub(
      FeaturestoreOnlineServingServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFeaturestoreOnlineServingServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFeaturestoreOnlineServingServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcFeaturestoreOnlineServingServiceStub(
      FeaturestoreOnlineServingServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ReadFeatureValuesRequest, ReadFeatureValuesResponse>
        readFeatureValuesTransportSettings =
            GrpcCallSettings.<ReadFeatureValuesRequest, ReadFeatureValuesResponse>newBuilder()
                .setMethodDescriptor(readFeatureValuesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ReadFeatureValuesRequest>() {
                      @Override
                      public Map<String, String> extract(ReadFeatureValuesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("entity_type", String.valueOf(request.getEntityType()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<StreamingReadFeatureValuesRequest, ReadFeatureValuesResponse>
        streamingReadFeatureValuesTransportSettings =
            GrpcCallSettings
                .<StreamingReadFeatureValuesRequest, ReadFeatureValuesResponse>newBuilder()
                .setMethodDescriptor(streamingReadFeatureValuesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<StreamingReadFeatureValuesRequest>() {
                      @Override
                      public Map<String, String> extract(
                          StreamingReadFeatureValuesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("entity_type", String.valueOf(request.getEntityType()));
                        return params.build();
                      }
                    })
                .build();

    this.readFeatureValuesCallable =
        callableFactory.createUnaryCallable(
            readFeatureValuesTransportSettings,
            settings.readFeatureValuesSettings(),
            clientContext);
    this.streamingReadFeatureValuesCallable =
        callableFactory.createServerStreamingCallable(
            streamingReadFeatureValuesTransportSettings,
            settings.streamingReadFeatureValuesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ReadFeatureValuesRequest, ReadFeatureValuesResponse>
      readFeatureValuesCallable() {
    return readFeatureValuesCallable;
  }

  @Override
  public ServerStreamingCallable<StreamingReadFeatureValuesRequest, ReadFeatureValuesResponse>
      streamingReadFeatureValuesCallable() {
    return streamingReadFeatureValuesCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
