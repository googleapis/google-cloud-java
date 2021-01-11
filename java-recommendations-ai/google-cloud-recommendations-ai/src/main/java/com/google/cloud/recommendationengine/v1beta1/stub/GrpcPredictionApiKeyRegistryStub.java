/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.recommendationengine.v1beta1.stub;

import static com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistryClient.ListPredictionApiKeyRegistrationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.recommendationengine.v1beta1.CreatePredictionApiKeyRegistrationRequest;
import com.google.cloud.recommendationengine.v1beta1.DeletePredictionApiKeyRegistrationRequest;
import com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsRequest;
import com.google.cloud.recommendationengine.v1beta1.ListPredictionApiKeyRegistrationsResponse;
import com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistration;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the PredictionApiKeyRegistry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcPredictionApiKeyRegistryStub extends PredictionApiKeyRegistryStub {
  private static final MethodDescriptor<
          CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
      createPredictionApiKeyRegistrationMethodDescriptor =
          MethodDescriptor
              .<CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry/CreatePredictionApiKeyRegistration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreatePredictionApiKeyRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PredictionApiKeyRegistration.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsResponse>
      listPredictionApiKeyRegistrationsMethodDescriptor =
          MethodDescriptor
              .<ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry/ListPredictionApiKeyRegistrations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListPredictionApiKeyRegistrationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListPredictionApiKeyRegistrationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePredictionApiKeyRegistrationRequest, Empty>
      deletePredictionApiKeyRegistrationMethodDescriptor =
          MethodDescriptor.<DeletePredictionApiKeyRegistrationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistry/DeletePredictionApiKeyRegistration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeletePredictionApiKeyRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<
          CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
      createPredictionApiKeyRegistrationCallable;
  private final UnaryCallable<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsResponse>
      listPredictionApiKeyRegistrationsCallable;
  private final UnaryCallable<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsPagedResponse>
      listPredictionApiKeyRegistrationsPagedCallable;
  private final UnaryCallable<DeletePredictionApiKeyRegistrationRequest, Empty>
      deletePredictionApiKeyRegistrationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPredictionApiKeyRegistryStub create(
      PredictionApiKeyRegistryStubSettings settings) throws IOException {
    return new GrpcPredictionApiKeyRegistryStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPredictionApiKeyRegistryStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPredictionApiKeyRegistryStub(
        PredictionApiKeyRegistryStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPredictionApiKeyRegistryStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPredictionApiKeyRegistryStub(
        PredictionApiKeyRegistryStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPredictionApiKeyRegistryStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPredictionApiKeyRegistryStub(
      PredictionApiKeyRegistryStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPredictionApiKeyRegistryCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPredictionApiKeyRegistryStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPredictionApiKeyRegistryStub(
      PredictionApiKeyRegistryStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
        createPredictionApiKeyRegistrationTransportSettings =
            GrpcCallSettings
                .<CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
                    newBuilder()
                .setMethodDescriptor(createPredictionApiKeyRegistrationMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreatePredictionApiKeyRegistrationRequest>() {
                      @Override
                      public Map<String, String> extract(
                          CreatePredictionApiKeyRegistrationRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<
            ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsResponse>
        listPredictionApiKeyRegistrationsTransportSettings =
            GrpcCallSettings
                .<ListPredictionApiKeyRegistrationsRequest,
                    ListPredictionApiKeyRegistrationsResponse>
                    newBuilder()
                .setMethodDescriptor(listPredictionApiKeyRegistrationsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListPredictionApiKeyRegistrationsRequest>() {
                      @Override
                      public Map<String, String> extract(
                          ListPredictionApiKeyRegistrationsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeletePredictionApiKeyRegistrationRequest, Empty>
        deletePredictionApiKeyRegistrationTransportSettings =
            GrpcCallSettings.<DeletePredictionApiKeyRegistrationRequest, Empty>newBuilder()
                .setMethodDescriptor(deletePredictionApiKeyRegistrationMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<DeletePredictionApiKeyRegistrationRequest>() {
                      @Override
                      public Map<String, String> extract(
                          DeletePredictionApiKeyRegistrationRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();

    this.createPredictionApiKeyRegistrationCallable =
        callableFactory.createUnaryCallable(
            createPredictionApiKeyRegistrationTransportSettings,
            settings.createPredictionApiKeyRegistrationSettings(),
            clientContext);
    this.listPredictionApiKeyRegistrationsCallable =
        callableFactory.createUnaryCallable(
            listPredictionApiKeyRegistrationsTransportSettings,
            settings.listPredictionApiKeyRegistrationsSettings(),
            clientContext);
    this.listPredictionApiKeyRegistrationsPagedCallable =
        callableFactory.createPagedCallable(
            listPredictionApiKeyRegistrationsTransportSettings,
            settings.listPredictionApiKeyRegistrationsSettings(),
            clientContext);
    this.deletePredictionApiKeyRegistrationCallable =
        callableFactory.createUnaryCallable(
            deletePredictionApiKeyRegistrationTransportSettings,
            settings.deletePredictionApiKeyRegistrationSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
      createPredictionApiKeyRegistrationCallable() {
    return createPredictionApiKeyRegistrationCallable;
  }

  public UnaryCallable<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsResponse>
      listPredictionApiKeyRegistrationsCallable() {
    return listPredictionApiKeyRegistrationsCallable;
  }

  public UnaryCallable<
          ListPredictionApiKeyRegistrationsRequest, ListPredictionApiKeyRegistrationsPagedResponse>
      listPredictionApiKeyRegistrationsPagedCallable() {
    return listPredictionApiKeyRegistrationsPagedCallable;
  }

  public UnaryCallable<DeletePredictionApiKeyRegistrationRequest, Empty>
      deletePredictionApiKeyRegistrationCallable() {
    return deletePredictionApiKeyRegistrationCallable;
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
