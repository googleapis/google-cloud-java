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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.SecuritySettingsServiceClient.ListSecuritySettingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateSecuritySettingsRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteSecuritySettingsRequest;
import com.google.cloud.dialogflow.cx.v3.GetSecuritySettingsRequest;
import com.google.cloud.dialogflow.cx.v3.ListSecuritySettingsRequest;
import com.google.cloud.dialogflow.cx.v3.ListSecuritySettingsResponse;
import com.google.cloud.dialogflow.cx.v3.SecuritySettings;
import com.google.cloud.dialogflow.cx.v3.UpdateSecuritySettingsRequest;
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
 * gRPC stub implementation for the SecuritySettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSecuritySettingsServiceStub extends SecuritySettingsServiceStub {
  private static final MethodDescriptor<CreateSecuritySettingsRequest, SecuritySettings>
      createSecuritySettingsMethodDescriptor =
          MethodDescriptor.<CreateSecuritySettingsRequest, SecuritySettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3.SecuritySettingsService/CreateSecuritySettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSecuritySettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SecuritySettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSecuritySettingsRequest, SecuritySettings>
      getSecuritySettingsMethodDescriptor =
          MethodDescriptor.<GetSecuritySettingsRequest, SecuritySettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3.SecuritySettingsService/GetSecuritySettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSecuritySettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SecuritySettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSecuritySettingsRequest, SecuritySettings>
      updateSecuritySettingsMethodDescriptor =
          MethodDescriptor.<UpdateSecuritySettingsRequest, SecuritySettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3.SecuritySettingsService/UpdateSecuritySettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSecuritySettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SecuritySettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSecuritySettingsRequest, ListSecuritySettingsResponse>
      listSecuritySettingsMethodDescriptor =
          MethodDescriptor.<ListSecuritySettingsRequest, ListSecuritySettingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3.SecuritySettingsService/ListSecuritySettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSecuritySettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSecuritySettingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSecuritySettingsRequest, Empty>
      deleteSecuritySettingsMethodDescriptor =
          MethodDescriptor.<DeleteSecuritySettingsRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3.SecuritySettingsService/DeleteSecuritySettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSecuritySettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateSecuritySettingsRequest, SecuritySettings>
      createSecuritySettingsCallable;
  private final UnaryCallable<GetSecuritySettingsRequest, SecuritySettings>
      getSecuritySettingsCallable;
  private final UnaryCallable<UpdateSecuritySettingsRequest, SecuritySettings>
      updateSecuritySettingsCallable;
  private final UnaryCallable<ListSecuritySettingsRequest, ListSecuritySettingsResponse>
      listSecuritySettingsCallable;
  private final UnaryCallable<ListSecuritySettingsRequest, ListSecuritySettingsPagedResponse>
      listSecuritySettingsPagedCallable;
  private final UnaryCallable<DeleteSecuritySettingsRequest, Empty> deleteSecuritySettingsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSecuritySettingsServiceStub create(
      SecuritySettingsServiceStubSettings settings) throws IOException {
    return new GrpcSecuritySettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSecuritySettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSecuritySettingsServiceStub(
        SecuritySettingsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSecuritySettingsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSecuritySettingsServiceStub(
        SecuritySettingsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSecuritySettingsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSecuritySettingsServiceStub(
      SecuritySettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSecuritySettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSecuritySettingsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSecuritySettingsServiceStub(
      SecuritySettingsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSecuritySettingsRequest, SecuritySettings>
        createSecuritySettingsTransportSettings =
            GrpcCallSettings.<CreateSecuritySettingsRequest, SecuritySettings>newBuilder()
                .setMethodDescriptor(createSecuritySettingsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateSecuritySettingsRequest>() {
                      @Override
                      public Map<String, String> extract(CreateSecuritySettingsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetSecuritySettingsRequest, SecuritySettings>
        getSecuritySettingsTransportSettings =
            GrpcCallSettings.<GetSecuritySettingsRequest, SecuritySettings>newBuilder()
                .setMethodDescriptor(getSecuritySettingsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetSecuritySettingsRequest>() {
                      @Override
                      public Map<String, String> extract(GetSecuritySettingsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateSecuritySettingsRequest, SecuritySettings>
        updateSecuritySettingsTransportSettings =
            GrpcCallSettings.<UpdateSecuritySettingsRequest, SecuritySettings>newBuilder()
                .setMethodDescriptor(updateSecuritySettingsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UpdateSecuritySettingsRequest>() {
                      @Override
                      public Map<String, String> extract(UpdateSecuritySettingsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "security_settings.name",
                            String.valueOf(request.getSecuritySettings().getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListSecuritySettingsRequest, ListSecuritySettingsResponse>
        listSecuritySettingsTransportSettings =
            GrpcCallSettings.<ListSecuritySettingsRequest, ListSecuritySettingsResponse>newBuilder()
                .setMethodDescriptor(listSecuritySettingsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListSecuritySettingsRequest>() {
                      @Override
                      public Map<String, String> extract(ListSecuritySettingsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteSecuritySettingsRequest, Empty> deleteSecuritySettingsTransportSettings =
        GrpcCallSettings.<DeleteSecuritySettingsRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSecuritySettingsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteSecuritySettingsRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteSecuritySettingsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.createSecuritySettingsCallable =
        callableFactory.createUnaryCallable(
            createSecuritySettingsTransportSettings,
            settings.createSecuritySettingsSettings(),
            clientContext);
    this.getSecuritySettingsCallable =
        callableFactory.createUnaryCallable(
            getSecuritySettingsTransportSettings,
            settings.getSecuritySettingsSettings(),
            clientContext);
    this.updateSecuritySettingsCallable =
        callableFactory.createUnaryCallable(
            updateSecuritySettingsTransportSettings,
            settings.updateSecuritySettingsSettings(),
            clientContext);
    this.listSecuritySettingsCallable =
        callableFactory.createUnaryCallable(
            listSecuritySettingsTransportSettings,
            settings.listSecuritySettingsSettings(),
            clientContext);
    this.listSecuritySettingsPagedCallable =
        callableFactory.createPagedCallable(
            listSecuritySettingsTransportSettings,
            settings.listSecuritySettingsSettings(),
            clientContext);
    this.deleteSecuritySettingsCallable =
        callableFactory.createUnaryCallable(
            deleteSecuritySettingsTransportSettings,
            settings.deleteSecuritySettingsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateSecuritySettingsRequest, SecuritySettings>
      createSecuritySettingsCallable() {
    return createSecuritySettingsCallable;
  }

  @Override
  public UnaryCallable<GetSecuritySettingsRequest, SecuritySettings> getSecuritySettingsCallable() {
    return getSecuritySettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateSecuritySettingsRequest, SecuritySettings>
      updateSecuritySettingsCallable() {
    return updateSecuritySettingsCallable;
  }

  @Override
  public UnaryCallable<ListSecuritySettingsRequest, ListSecuritySettingsResponse>
      listSecuritySettingsCallable() {
    return listSecuritySettingsCallable;
  }

  @Override
  public UnaryCallable<ListSecuritySettingsRequest, ListSecuritySettingsPagedResponse>
      listSecuritySettingsPagedCallable() {
    return listSecuritySettingsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSecuritySettingsRequest, Empty> deleteSecuritySettingsCallable() {
    return deleteSecuritySettingsCallable;
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
