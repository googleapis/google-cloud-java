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

package com.google.cloud.gaming.v1beta.stub;

import static com.google.cloud.gaming.v1beta.RealmsServiceClient.ListRealmsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1beta.CreateRealmRequest;
import com.google.cloud.gaming.v1beta.DeleteRealmRequest;
import com.google.cloud.gaming.v1beta.GetRealmRequest;
import com.google.cloud.gaming.v1beta.ListRealmsRequest;
import com.google.cloud.gaming.v1beta.ListRealmsResponse;
import com.google.cloud.gaming.v1beta.OperationMetadata;
import com.google.cloud.gaming.v1beta.PreviewRealmUpdateRequest;
import com.google.cloud.gaming.v1beta.PreviewRealmUpdateResponse;
import com.google.cloud.gaming.v1beta.Realm;
import com.google.cloud.gaming.v1beta.UpdateRealmRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * gRPC stub implementation for the RealmsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcRealmsServiceStub extends RealmsServiceStub {
  private static final MethodDescriptor<ListRealmsRequest, ListRealmsResponse>
      listRealmsMethodDescriptor =
          MethodDescriptor.<ListRealmsRequest, ListRealmsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gaming.v1beta.RealmsService/ListRealms")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRealmsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListRealmsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRealmRequest, Realm> getRealmMethodDescriptor =
      MethodDescriptor.<GetRealmRequest, Realm>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gaming.v1beta.RealmsService/GetRealm")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRealmRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Realm.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateRealmRequest, Operation> createRealmMethodDescriptor =
      MethodDescriptor.<CreateRealmRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gaming.v1beta.RealmsService/CreateRealm")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateRealmRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteRealmRequest, Operation> deleteRealmMethodDescriptor =
      MethodDescriptor.<DeleteRealmRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gaming.v1beta.RealmsService/DeleteRealm")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteRealmRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateRealmRequest, Operation> updateRealmMethodDescriptor =
      MethodDescriptor.<UpdateRealmRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gaming.v1beta.RealmsService/UpdateRealm")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateRealmRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>
      previewRealmUpdateMethodDescriptor =
          MethodDescriptor.<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gaming.v1beta.RealmsService/PreviewRealmUpdate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PreviewRealmUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PreviewRealmUpdateResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListRealmsRequest, ListRealmsResponse> listRealmsCallable;
  private final UnaryCallable<ListRealmsRequest, ListRealmsPagedResponse> listRealmsPagedCallable;
  private final UnaryCallable<GetRealmRequest, Realm> getRealmCallable;
  private final UnaryCallable<CreateRealmRequest, Operation> createRealmCallable;
  private final OperationCallable<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationCallable;
  private final UnaryCallable<DeleteRealmRequest, Operation> deleteRealmCallable;
  private final OperationCallable<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationCallable;
  private final UnaryCallable<UpdateRealmRequest, Operation> updateRealmCallable;
  private final OperationCallable<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationCallable;
  private final UnaryCallable<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>
      previewRealmUpdateCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRealmsServiceStub create(RealmsServiceStubSettings settings)
      throws IOException {
    return new GrpcRealmsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRealmsServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcRealmsServiceStub(RealmsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRealmsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRealmsServiceStub(
        RealmsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcRealmsServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcRealmsServiceStub(RealmsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRealmsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRealmsServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcRealmsServiceStub(
      RealmsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListRealmsRequest, ListRealmsResponse> listRealmsTransportSettings =
        GrpcCallSettings.<ListRealmsRequest, ListRealmsResponse>newBuilder()
            .setMethodDescriptor(listRealmsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListRealmsRequest>() {
                  @Override
                  public Map<String, String> extract(ListRealmsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetRealmRequest, Realm> getRealmTransportSettings =
        GrpcCallSettings.<GetRealmRequest, Realm>newBuilder()
            .setMethodDescriptor(getRealmMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetRealmRequest>() {
                  @Override
                  public Map<String, String> extract(GetRealmRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateRealmRequest, Operation> createRealmTransportSettings =
        GrpcCallSettings.<CreateRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(createRealmMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateRealmRequest>() {
                  @Override
                  public Map<String, String> extract(CreateRealmRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteRealmRequest, Operation> deleteRealmTransportSettings =
        GrpcCallSettings.<DeleteRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRealmMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteRealmRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteRealmRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateRealmRequest, Operation> updateRealmTransportSettings =
        GrpcCallSettings.<UpdateRealmRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRealmMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateRealmRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateRealmRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("realm.name", String.valueOf(request.getRealm().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>
        previewRealmUpdateTransportSettings =
            GrpcCallSettings.<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>newBuilder()
                .setMethodDescriptor(previewRealmUpdateMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<PreviewRealmUpdateRequest>() {
                      @Override
                      public Map<String, String> extract(PreviewRealmUpdateRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("realm.name", String.valueOf(request.getRealm().getName()));
                        return params.build();
                      }
                    })
                .build();

    this.listRealmsCallable =
        callableFactory.createUnaryCallable(
            listRealmsTransportSettings, settings.listRealmsSettings(), clientContext);
    this.listRealmsPagedCallable =
        callableFactory.createPagedCallable(
            listRealmsTransportSettings, settings.listRealmsSettings(), clientContext);
    this.getRealmCallable =
        callableFactory.createUnaryCallable(
            getRealmTransportSettings, settings.getRealmSettings(), clientContext);
    this.createRealmCallable =
        callableFactory.createUnaryCallable(
            createRealmTransportSettings, settings.createRealmSettings(), clientContext);
    this.createRealmOperationCallable =
        callableFactory.createOperationCallable(
            createRealmTransportSettings,
            settings.createRealmOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteRealmCallable =
        callableFactory.createUnaryCallable(
            deleteRealmTransportSettings, settings.deleteRealmSettings(), clientContext);
    this.deleteRealmOperationCallable =
        callableFactory.createOperationCallable(
            deleteRealmTransportSettings,
            settings.deleteRealmOperationSettings(),
            clientContext,
            operationsStub);
    this.updateRealmCallable =
        callableFactory.createUnaryCallable(
            updateRealmTransportSettings, settings.updateRealmSettings(), clientContext);
    this.updateRealmOperationCallable =
        callableFactory.createOperationCallable(
            updateRealmTransportSettings,
            settings.updateRealmOperationSettings(),
            clientContext,
            operationsStub);
    this.previewRealmUpdateCallable =
        callableFactory.createUnaryCallable(
            previewRealmUpdateTransportSettings,
            settings.previewRealmUpdateSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ListRealmsRequest, ListRealmsResponse> listRealmsCallable() {
    return listRealmsCallable;
  }

  public UnaryCallable<ListRealmsRequest, ListRealmsPagedResponse> listRealmsPagedCallable() {
    return listRealmsPagedCallable;
  }

  public UnaryCallable<GetRealmRequest, Realm> getRealmCallable() {
    return getRealmCallable;
  }

  public UnaryCallable<CreateRealmRequest, Operation> createRealmCallable() {
    return createRealmCallable;
  }

  public OperationCallable<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationCallable() {
    return createRealmOperationCallable;
  }

  public UnaryCallable<DeleteRealmRequest, Operation> deleteRealmCallable() {
    return deleteRealmCallable;
  }

  public OperationCallable<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationCallable() {
    return deleteRealmOperationCallable;
  }

  public UnaryCallable<UpdateRealmRequest, Operation> updateRealmCallable() {
    return updateRealmCallable;
  }

  public OperationCallable<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationCallable() {
    return updateRealmOperationCallable;
  }

  public UnaryCallable<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>
      previewRealmUpdateCallable() {
    return previewRealmUpdateCallable;
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
