/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.accounts.v1.stub;

import static com.google.shopping.merchant.accounts.v1.OmnichannelSettingsServiceClient.ListOmnichannelSettingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.accounts.v1.CreateOmnichannelSettingRequest;
import com.google.shopping.merchant.accounts.v1.GetOmnichannelSettingRequest;
import com.google.shopping.merchant.accounts.v1.ListOmnichannelSettingsRequest;
import com.google.shopping.merchant.accounts.v1.ListOmnichannelSettingsResponse;
import com.google.shopping.merchant.accounts.v1.OmnichannelSetting;
import com.google.shopping.merchant.accounts.v1.RequestInventoryVerificationRequest;
import com.google.shopping.merchant.accounts.v1.RequestInventoryVerificationResponse;
import com.google.shopping.merchant.accounts.v1.UpdateOmnichannelSettingRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the OmnichannelSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcOmnichannelSettingsServiceStub extends OmnichannelSettingsServiceStub {
  private static final MethodDescriptor<GetOmnichannelSettingRequest, OmnichannelSetting>
      getOmnichannelSettingMethodDescriptor =
          MethodDescriptor.<GetOmnichannelSettingRequest, OmnichannelSetting>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OmnichannelSettingsService/GetOmnichannelSetting")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOmnichannelSettingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(OmnichannelSetting.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>
      listOmnichannelSettingsMethodDescriptor =
          MethodDescriptor
              .<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OmnichannelSettingsService/ListOmnichannelSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOmnichannelSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOmnichannelSettingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateOmnichannelSettingRequest, OmnichannelSetting>
      createOmnichannelSettingMethodDescriptor =
          MethodDescriptor.<CreateOmnichannelSettingRequest, OmnichannelSetting>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OmnichannelSettingsService/CreateOmnichannelSetting")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateOmnichannelSettingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(OmnichannelSetting.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateOmnichannelSettingRequest, OmnichannelSetting>
      updateOmnichannelSettingMethodDescriptor =
          MethodDescriptor.<UpdateOmnichannelSettingRequest, OmnichannelSetting>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OmnichannelSettingsService/UpdateOmnichannelSetting")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateOmnichannelSettingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(OmnichannelSetting.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
      requestInventoryVerificationMethodDescriptor =
          MethodDescriptor
              .<RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.OmnichannelSettingsService/RequestInventoryVerification")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RequestInventoryVerificationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RequestInventoryVerificationResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetOmnichannelSettingRequest, OmnichannelSetting>
      getOmnichannelSettingCallable;
  private final UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>
      listOmnichannelSettingsCallable;
  private final UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsPagedResponse>
      listOmnichannelSettingsPagedCallable;
  private final UnaryCallable<CreateOmnichannelSettingRequest, OmnichannelSetting>
      createOmnichannelSettingCallable;
  private final UnaryCallable<UpdateOmnichannelSettingRequest, OmnichannelSetting>
      updateOmnichannelSettingCallable;
  private final UnaryCallable<
          RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
      requestInventoryVerificationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcOmnichannelSettingsServiceStub create(
      OmnichannelSettingsServiceStubSettings settings) throws IOException {
    return new GrpcOmnichannelSettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOmnichannelSettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOmnichannelSettingsServiceStub(
        OmnichannelSettingsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOmnichannelSettingsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOmnichannelSettingsServiceStub(
        OmnichannelSettingsServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcOmnichannelSettingsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcOmnichannelSettingsServiceStub(
      OmnichannelSettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcOmnichannelSettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOmnichannelSettingsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcOmnichannelSettingsServiceStub(
      OmnichannelSettingsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetOmnichannelSettingRequest, OmnichannelSetting>
        getOmnichannelSettingTransportSettings =
            GrpcCallSettings.<GetOmnichannelSettingRequest, OmnichannelSetting>newBuilder()
                .setMethodDescriptor(getOmnichannelSettingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>
        listOmnichannelSettingsTransportSettings =
            GrpcCallSettings
                .<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>newBuilder()
                .setMethodDescriptor(listOmnichannelSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateOmnichannelSettingRequest, OmnichannelSetting>
        createOmnichannelSettingTransportSettings =
            GrpcCallSettings.<CreateOmnichannelSettingRequest, OmnichannelSetting>newBuilder()
                .setMethodDescriptor(createOmnichannelSettingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateOmnichannelSettingRequest, OmnichannelSetting>
        updateOmnichannelSettingTransportSettings =
            GrpcCallSettings.<UpdateOmnichannelSettingRequest, OmnichannelSetting>newBuilder()
                .setMethodDescriptor(updateOmnichannelSettingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "omnichannel_setting.name",
                          String.valueOf(request.getOmnichannelSetting().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
        requestInventoryVerificationTransportSettings =
            GrpcCallSettings
                .<RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
                    newBuilder()
                .setMethodDescriptor(requestInventoryVerificationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.getOmnichannelSettingCallable =
        callableFactory.createUnaryCallable(
            getOmnichannelSettingTransportSettings,
            settings.getOmnichannelSettingSettings(),
            clientContext);
    this.listOmnichannelSettingsCallable =
        callableFactory.createUnaryCallable(
            listOmnichannelSettingsTransportSettings,
            settings.listOmnichannelSettingsSettings(),
            clientContext);
    this.listOmnichannelSettingsPagedCallable =
        callableFactory.createPagedCallable(
            listOmnichannelSettingsTransportSettings,
            settings.listOmnichannelSettingsSettings(),
            clientContext);
    this.createOmnichannelSettingCallable =
        callableFactory.createUnaryCallable(
            createOmnichannelSettingTransportSettings,
            settings.createOmnichannelSettingSettings(),
            clientContext);
    this.updateOmnichannelSettingCallable =
        callableFactory.createUnaryCallable(
            updateOmnichannelSettingTransportSettings,
            settings.updateOmnichannelSettingSettings(),
            clientContext);
    this.requestInventoryVerificationCallable =
        callableFactory.createUnaryCallable(
            requestInventoryVerificationTransportSettings,
            settings.requestInventoryVerificationSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetOmnichannelSettingRequest, OmnichannelSetting>
      getOmnichannelSettingCallable() {
    return getOmnichannelSettingCallable;
  }

  @Override
  public UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsResponse>
      listOmnichannelSettingsCallable() {
    return listOmnichannelSettingsCallable;
  }

  @Override
  public UnaryCallable<ListOmnichannelSettingsRequest, ListOmnichannelSettingsPagedResponse>
      listOmnichannelSettingsPagedCallable() {
    return listOmnichannelSettingsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateOmnichannelSettingRequest, OmnichannelSetting>
      createOmnichannelSettingCallable() {
    return createOmnichannelSettingCallable;
  }

  @Override
  public UnaryCallable<UpdateOmnichannelSettingRequest, OmnichannelSetting>
      updateOmnichannelSettingCallable() {
    return updateOmnichannelSettingCallable;
  }

  @Override
  public UnaryCallable<RequestInventoryVerificationRequest, RequestInventoryVerificationResponse>
      requestInventoryVerificationCallable() {
    return requestInventoryVerificationCallable;
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
