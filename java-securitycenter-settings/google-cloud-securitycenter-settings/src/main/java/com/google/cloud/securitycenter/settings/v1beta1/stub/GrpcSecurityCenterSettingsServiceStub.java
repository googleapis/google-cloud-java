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

package com.google.cloud.securitycenter.settings.v1beta1.stub;

import static com.google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsServiceClient.ListComponentsPagedResponse;
import static com.google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsServiceClient.ListDetectorsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.BatchCalculateEffectiveSettingsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.BatchGetSettingsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveComponentSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.CalculateEffectiveSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ComponentSettings;
import com.google.cloud.securitycenter.settings.v1beta1.GetComponentSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.GetServiceAccountRequest;
import com.google.cloud.securitycenter.settings.v1beta1.GetSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ListComponentsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ListComponentsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ListDetectorsResponse;
import com.google.cloud.securitycenter.settings.v1beta1.ResetComponentSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ResetSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.ServiceAccount;
import com.google.cloud.securitycenter.settings.v1beta1.Settings;
import com.google.cloud.securitycenter.settings.v1beta1.UpdateComponentSettingsRequest;
import com.google.cloud.securitycenter.settings.v1beta1.UpdateSettingsRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SecurityCenterSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSecurityCenterSettingsServiceStub extends SecurityCenterSettingsServiceStub {
  private static final MethodDescriptor<GetServiceAccountRequest, ServiceAccount>
      getServiceAccountMethodDescriptor =
          MethodDescriptor.<GetServiceAccountRequest, ServiceAccount>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/GetServiceAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServiceAccount.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSettingsRequest, Settings> getSettingsMethodDescriptor =
      MethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/GetSettings")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSettingsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateSettingsRequest, Settings>
      updateSettingsMethodDescriptor =
          MethodDescriptor.<UpdateSettingsRequest, Settings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/UpdateSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ResetSettingsRequest, Empty> resetSettingsMethodDescriptor =
      MethodDescriptor.<ResetSettingsRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/ResetSettings")
          .setRequestMarshaller(ProtoUtils.marshaller(ResetSettingsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<BatchGetSettingsRequest, BatchGetSettingsResponse>
      batchGetSettingsMethodDescriptor =
          MethodDescriptor.<BatchGetSettingsRequest, BatchGetSettingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/BatchGetSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchGetSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchGetSettingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CalculateEffectiveSettingsRequest, Settings>
      calculateEffectiveSettingsMethodDescriptor =
          MethodDescriptor.<CalculateEffectiveSettingsRequest, Settings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/CalculateEffectiveSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CalculateEffectiveSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
      batchCalculateEffectiveSettingsMethodDescriptor =
          MethodDescriptor
              .<BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/BatchCalculateEffectiveSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      BatchCalculateEffectiveSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      BatchCalculateEffectiveSettingsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetComponentSettingsRequest, ComponentSettings>
      getComponentSettingsMethodDescriptor =
          MethodDescriptor.<GetComponentSettingsRequest, ComponentSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/GetComponentSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetComponentSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ComponentSettings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateComponentSettingsRequest, ComponentSettings>
      updateComponentSettingsMethodDescriptor =
          MethodDescriptor.<UpdateComponentSettingsRequest, ComponentSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/UpdateComponentSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateComponentSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ComponentSettings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ResetComponentSettingsRequest, Empty>
      resetComponentSettingsMethodDescriptor =
          MethodDescriptor.<ResetComponentSettingsRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/ResetComponentSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResetComponentSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          CalculateEffectiveComponentSettingsRequest, ComponentSettings>
      calculateEffectiveComponentSettingsMethodDescriptor =
          MethodDescriptor
              .<CalculateEffectiveComponentSettingsRequest, ComponentSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/CalculateEffectiveComponentSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CalculateEffectiveComponentSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ComponentSettings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDetectorsRequest, ListDetectorsResponse>
      listDetectorsMethodDescriptor =
          MethodDescriptor.<ListDetectorsRequest, ListDetectorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/ListDetectors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDetectorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDetectorsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListComponentsRequest, ListComponentsResponse>
      listComponentsMethodDescriptor =
          MethodDescriptor.<ListComponentsRequest, ListComponentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.settings.v1beta1.SecurityCenterSettingsService/ListComponents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListComponentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListComponentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetServiceAccountRequest, ServiceAccount> getServiceAccountCallable;
  private final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable;
  private final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable;
  private final UnaryCallable<ResetSettingsRequest, Empty> resetSettingsCallable;
  private final UnaryCallable<BatchGetSettingsRequest, BatchGetSettingsResponse>
      batchGetSettingsCallable;
  private final UnaryCallable<CalculateEffectiveSettingsRequest, Settings>
      calculateEffectiveSettingsCallable;
  private final UnaryCallable<
          BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
      batchCalculateEffectiveSettingsCallable;
  private final UnaryCallable<GetComponentSettingsRequest, ComponentSettings>
      getComponentSettingsCallable;
  private final UnaryCallable<UpdateComponentSettingsRequest, ComponentSettings>
      updateComponentSettingsCallable;
  private final UnaryCallable<ResetComponentSettingsRequest, Empty> resetComponentSettingsCallable;
  private final UnaryCallable<CalculateEffectiveComponentSettingsRequest, ComponentSettings>
      calculateEffectiveComponentSettingsCallable;
  private final UnaryCallable<ListDetectorsRequest, ListDetectorsResponse> listDetectorsCallable;
  private final UnaryCallable<ListDetectorsRequest, ListDetectorsPagedResponse>
      listDetectorsPagedCallable;
  private final UnaryCallable<ListComponentsRequest, ListComponentsResponse> listComponentsCallable;
  private final UnaryCallable<ListComponentsRequest, ListComponentsPagedResponse>
      listComponentsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSecurityCenterSettingsServiceStub create(
      SecurityCenterSettingsServiceStubSettings settings) throws IOException {
    return new GrpcSecurityCenterSettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSecurityCenterSettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSecurityCenterSettingsServiceStub(
        SecurityCenterSettingsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSecurityCenterSettingsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSecurityCenterSettingsServiceStub(
        SecurityCenterSettingsServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcSecurityCenterSettingsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSecurityCenterSettingsServiceStub(
      SecurityCenterSettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSecurityCenterSettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSecurityCenterSettingsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSecurityCenterSettingsServiceStub(
      SecurityCenterSettingsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetServiceAccountRequest, ServiceAccount> getServiceAccountTransportSettings =
        GrpcCallSettings.<GetServiceAccountRequest, ServiceAccount>newBuilder()
            .setMethodDescriptor(getServiceAccountMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        GrpcCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSettingsRequest, Settings> updateSettingsTransportSettings =
        GrpcCallSettings.<UpdateSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("settings.name", String.valueOf(request.getSettings().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ResetSettingsRequest, Empty> resetSettingsTransportSettings =
        GrpcCallSettings.<ResetSettingsRequest, Empty>newBuilder()
            .setMethodDescriptor(resetSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchGetSettingsRequest, BatchGetSettingsResponse>
        batchGetSettingsTransportSettings =
            GrpcCallSettings.<BatchGetSettingsRequest, BatchGetSettingsResponse>newBuilder()
                .setMethodDescriptor(batchGetSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CalculateEffectiveSettingsRequest, Settings>
        calculateEffectiveSettingsTransportSettings =
            GrpcCallSettings.<CalculateEffectiveSettingsRequest, Settings>newBuilder()
                .setMethodDescriptor(calculateEffectiveSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
        batchCalculateEffectiveSettingsTransportSettings =
            GrpcCallSettings
                .<BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
                    newBuilder()
                .setMethodDescriptor(batchCalculateEffectiveSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetComponentSettingsRequest, ComponentSettings>
        getComponentSettingsTransportSettings =
            GrpcCallSettings.<GetComponentSettingsRequest, ComponentSettings>newBuilder()
                .setMethodDescriptor(getComponentSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateComponentSettingsRequest, ComponentSettings>
        updateComponentSettingsTransportSettings =
            GrpcCallSettings.<UpdateComponentSettingsRequest, ComponentSettings>newBuilder()
                .setMethodDescriptor(updateComponentSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "component_settings.name",
                          String.valueOf(request.getComponentSettings().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ResetComponentSettingsRequest, Empty> resetComponentSettingsTransportSettings =
        GrpcCallSettings.<ResetComponentSettingsRequest, Empty>newBuilder()
            .setMethodDescriptor(resetComponentSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CalculateEffectiveComponentSettingsRequest, ComponentSettings>
        calculateEffectiveComponentSettingsTransportSettings =
            GrpcCallSettings
                .<CalculateEffectiveComponentSettingsRequest, ComponentSettings>newBuilder()
                .setMethodDescriptor(calculateEffectiveComponentSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDetectorsRequest, ListDetectorsResponse> listDetectorsTransportSettings =
        GrpcCallSettings.<ListDetectorsRequest, ListDetectorsResponse>newBuilder()
            .setMethodDescriptor(listDetectorsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListComponentsRequest, ListComponentsResponse>
        listComponentsTransportSettings =
            GrpcCallSettings.<ListComponentsRequest, ListComponentsResponse>newBuilder()
                .setMethodDescriptor(listComponentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getServiceAccountCallable =
        callableFactory.createUnaryCallable(
            getServiceAccountTransportSettings,
            settings.getServiceAccountSettings(),
            clientContext);
    this.getSettingsCallable =
        callableFactory.createUnaryCallable(
            getSettingsTransportSettings, settings.getSettingsSettings(), clientContext);
    this.updateSettingsCallable =
        callableFactory.createUnaryCallable(
            updateSettingsTransportSettings, settings.updateSettingsSettings(), clientContext);
    this.resetSettingsCallable =
        callableFactory.createUnaryCallable(
            resetSettingsTransportSettings, settings.resetSettingsSettings(), clientContext);
    this.batchGetSettingsCallable =
        callableFactory.createUnaryCallable(
            batchGetSettingsTransportSettings, settings.batchGetSettingsSettings(), clientContext);
    this.calculateEffectiveSettingsCallable =
        callableFactory.createUnaryCallable(
            calculateEffectiveSettingsTransportSettings,
            settings.calculateEffectiveSettingsSettings(),
            clientContext);
    this.batchCalculateEffectiveSettingsCallable =
        callableFactory.createUnaryCallable(
            batchCalculateEffectiveSettingsTransportSettings,
            settings.batchCalculateEffectiveSettingsSettings(),
            clientContext);
    this.getComponentSettingsCallable =
        callableFactory.createUnaryCallable(
            getComponentSettingsTransportSettings,
            settings.getComponentSettingsSettings(),
            clientContext);
    this.updateComponentSettingsCallable =
        callableFactory.createUnaryCallable(
            updateComponentSettingsTransportSettings,
            settings.updateComponentSettingsSettings(),
            clientContext);
    this.resetComponentSettingsCallable =
        callableFactory.createUnaryCallable(
            resetComponentSettingsTransportSettings,
            settings.resetComponentSettingsSettings(),
            clientContext);
    this.calculateEffectiveComponentSettingsCallable =
        callableFactory.createUnaryCallable(
            calculateEffectiveComponentSettingsTransportSettings,
            settings.calculateEffectiveComponentSettingsSettings(),
            clientContext);
    this.listDetectorsCallable =
        callableFactory.createUnaryCallable(
            listDetectorsTransportSettings, settings.listDetectorsSettings(), clientContext);
    this.listDetectorsPagedCallable =
        callableFactory.createPagedCallable(
            listDetectorsTransportSettings, settings.listDetectorsSettings(), clientContext);
    this.listComponentsCallable =
        callableFactory.createUnaryCallable(
            listComponentsTransportSettings, settings.listComponentsSettings(), clientContext);
    this.listComponentsPagedCallable =
        callableFactory.createPagedCallable(
            listComponentsTransportSettings, settings.listComponentsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetServiceAccountRequest, ServiceAccount> getServiceAccountCallable() {
    return getServiceAccountCallable;
  }

  @Override
  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return getSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    return updateSettingsCallable;
  }

  @Override
  public UnaryCallable<ResetSettingsRequest, Empty> resetSettingsCallable() {
    return resetSettingsCallable;
  }

  @Override
  public UnaryCallable<BatchGetSettingsRequest, BatchGetSettingsResponse>
      batchGetSettingsCallable() {
    return batchGetSettingsCallable;
  }

  @Override
  public UnaryCallable<CalculateEffectiveSettingsRequest, Settings>
      calculateEffectiveSettingsCallable() {
    return calculateEffectiveSettingsCallable;
  }

  @Override
  public UnaryCallable<
          BatchCalculateEffectiveSettingsRequest, BatchCalculateEffectiveSettingsResponse>
      batchCalculateEffectiveSettingsCallable() {
    return batchCalculateEffectiveSettingsCallable;
  }

  @Override
  public UnaryCallable<GetComponentSettingsRequest, ComponentSettings>
      getComponentSettingsCallable() {
    return getComponentSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateComponentSettingsRequest, ComponentSettings>
      updateComponentSettingsCallable() {
    return updateComponentSettingsCallable;
  }

  @Override
  public UnaryCallable<ResetComponentSettingsRequest, Empty> resetComponentSettingsCallable() {
    return resetComponentSettingsCallable;
  }

  @Override
  public UnaryCallable<CalculateEffectiveComponentSettingsRequest, ComponentSettings>
      calculateEffectiveComponentSettingsCallable() {
    return calculateEffectiveComponentSettingsCallable;
  }

  @Override
  public UnaryCallable<ListDetectorsRequest, ListDetectorsResponse> listDetectorsCallable() {
    return listDetectorsCallable;
  }

  @Override
  public UnaryCallable<ListDetectorsRequest, ListDetectorsPagedResponse>
      listDetectorsPagedCallable() {
    return listDetectorsPagedCallable;
  }

  @Override
  public UnaryCallable<ListComponentsRequest, ListComponentsResponse> listComponentsCallable() {
    return listComponentsCallable;
  }

  @Override
  public UnaryCallable<ListComponentsRequest, ListComponentsPagedResponse>
      listComponentsPagedCallable() {
    return listComponentsPagedCallable;
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
