/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.LicenseConfigServiceClient.ListLicenseConfigsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.CreateLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.DistributeLicenseConfigResponse;
import com.google.cloud.discoveryengine.v1beta.GetLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.LicenseConfig;
import com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsRequest;
import com.google.cloud.discoveryengine.v1beta.ListLicenseConfigsResponse;
import com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigRequest;
import com.google.cloud.discoveryengine.v1beta.RetractLicenseConfigResponse;
import com.google.cloud.discoveryengine.v1beta.UpdateLicenseConfigRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the LicenseConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcLicenseConfigServiceStub extends LicenseConfigServiceStub {
  private static final MethodDescriptor<CreateLicenseConfigRequest, LicenseConfig>
      createLicenseConfigMethodDescriptor =
          MethodDescriptor.<CreateLicenseConfigRequest, LicenseConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.LicenseConfigService/CreateLicenseConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateLicenseConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LicenseConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateLicenseConfigRequest, LicenseConfig>
      updateLicenseConfigMethodDescriptor =
          MethodDescriptor.<UpdateLicenseConfigRequest, LicenseConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.LicenseConfigService/UpdateLicenseConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateLicenseConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LicenseConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLicenseConfigRequest, LicenseConfig>
      getLicenseConfigMethodDescriptor =
          MethodDescriptor.<GetLicenseConfigRequest, LicenseConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.LicenseConfigService/GetLicenseConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLicenseConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LicenseConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLicenseConfigsRequest, ListLicenseConfigsResponse>
      listLicenseConfigsMethodDescriptor =
          MethodDescriptor.<ListLicenseConfigsRequest, ListLicenseConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.LicenseConfigService/ListLicenseConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLicenseConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLicenseConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>
      distributeLicenseConfigMethodDescriptor =
          MethodDescriptor
              .<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.LicenseConfigService/DistributeLicenseConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DistributeLicenseConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DistributeLicenseConfigResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RetractLicenseConfigRequest, RetractLicenseConfigResponse>
      retractLicenseConfigMethodDescriptor =
          MethodDescriptor.<RetractLicenseConfigRequest, RetractLicenseConfigResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.LicenseConfigService/RetractLicenseConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RetractLicenseConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RetractLicenseConfigResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateLicenseConfigRequest, LicenseConfig>
      createLicenseConfigCallable;
  private final UnaryCallable<UpdateLicenseConfigRequest, LicenseConfig>
      updateLicenseConfigCallable;
  private final UnaryCallable<GetLicenseConfigRequest, LicenseConfig> getLicenseConfigCallable;
  private final UnaryCallable<ListLicenseConfigsRequest, ListLicenseConfigsResponse>
      listLicenseConfigsCallable;
  private final UnaryCallable<ListLicenseConfigsRequest, ListLicenseConfigsPagedResponse>
      listLicenseConfigsPagedCallable;
  private final UnaryCallable<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>
      distributeLicenseConfigCallable;
  private final UnaryCallable<RetractLicenseConfigRequest, RetractLicenseConfigResponse>
      retractLicenseConfigCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLicenseConfigServiceStub create(LicenseConfigServiceStubSettings settings)
      throws IOException {
    return new GrpcLicenseConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLicenseConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLicenseConfigServiceStub(
        LicenseConfigServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLicenseConfigServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLicenseConfigServiceStub(
        LicenseConfigServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLicenseConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLicenseConfigServiceStub(
      LicenseConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcLicenseConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLicenseConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLicenseConfigServiceStub(
      LicenseConfigServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateLicenseConfigRequest, LicenseConfig>
        createLicenseConfigTransportSettings =
            GrpcCallSettings.<CreateLicenseConfigRequest, LicenseConfig>newBuilder()
                .setMethodDescriptor(createLicenseConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateLicenseConfigRequest, LicenseConfig>
        updateLicenseConfigTransportSettings =
            GrpcCallSettings.<UpdateLicenseConfigRequest, LicenseConfig>newBuilder()
                .setMethodDescriptor(updateLicenseConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "license_config.name",
                          String.valueOf(request.getLicenseConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetLicenseConfigRequest, LicenseConfig> getLicenseConfigTransportSettings =
        GrpcCallSettings.<GetLicenseConfigRequest, LicenseConfig>newBuilder()
            .setMethodDescriptor(getLicenseConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListLicenseConfigsRequest, ListLicenseConfigsResponse>
        listLicenseConfigsTransportSettings =
            GrpcCallSettings.<ListLicenseConfigsRequest, ListLicenseConfigsResponse>newBuilder()
                .setMethodDescriptor(listLicenseConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>
        distributeLicenseConfigTransportSettings =
            GrpcCallSettings
                .<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>newBuilder()
                .setMethodDescriptor(distributeLicenseConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "billing_account_license_config",
                          String.valueOf(request.getBillingAccountLicenseConfig()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getBillingAccountLicenseConfig())
                .build();
    GrpcCallSettings<RetractLicenseConfigRequest, RetractLicenseConfigResponse>
        retractLicenseConfigTransportSettings =
            GrpcCallSettings.<RetractLicenseConfigRequest, RetractLicenseConfigResponse>newBuilder()
                .setMethodDescriptor(retractLicenseConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "billing_account_license_config",
                          String.valueOf(request.getBillingAccountLicenseConfig()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getBillingAccountLicenseConfig())
                .build();

    this.createLicenseConfigCallable =
        callableFactory.createUnaryCallable(
            createLicenseConfigTransportSettings,
            settings.createLicenseConfigSettings(),
            clientContext);
    this.updateLicenseConfigCallable =
        callableFactory.createUnaryCallable(
            updateLicenseConfigTransportSettings,
            settings.updateLicenseConfigSettings(),
            clientContext);
    this.getLicenseConfigCallable =
        callableFactory.createUnaryCallable(
            getLicenseConfigTransportSettings, settings.getLicenseConfigSettings(), clientContext);
    this.listLicenseConfigsCallable =
        callableFactory.createUnaryCallable(
            listLicenseConfigsTransportSettings,
            settings.listLicenseConfigsSettings(),
            clientContext);
    this.listLicenseConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listLicenseConfigsTransportSettings,
            settings.listLicenseConfigsSettings(),
            clientContext);
    this.distributeLicenseConfigCallable =
        callableFactory.createUnaryCallable(
            distributeLicenseConfigTransportSettings,
            settings.distributeLicenseConfigSettings(),
            clientContext);
    this.retractLicenseConfigCallable =
        callableFactory.createUnaryCallable(
            retractLicenseConfigTransportSettings,
            settings.retractLicenseConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateLicenseConfigRequest, LicenseConfig> createLicenseConfigCallable() {
    return createLicenseConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateLicenseConfigRequest, LicenseConfig> updateLicenseConfigCallable() {
    return updateLicenseConfigCallable;
  }

  @Override
  public UnaryCallable<GetLicenseConfigRequest, LicenseConfig> getLicenseConfigCallable() {
    return getLicenseConfigCallable;
  }

  @Override
  public UnaryCallable<ListLicenseConfigsRequest, ListLicenseConfigsResponse>
      listLicenseConfigsCallable() {
    return listLicenseConfigsCallable;
  }

  @Override
  public UnaryCallable<ListLicenseConfigsRequest, ListLicenseConfigsPagedResponse>
      listLicenseConfigsPagedCallable() {
    return listLicenseConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<DistributeLicenseConfigRequest, DistributeLicenseConfigResponse>
      distributeLicenseConfigCallable() {
    return distributeLicenseConfigCallable;
  }

  @Override
  public UnaryCallable<RetractLicenseConfigRequest, RetractLicenseConfigResponse>
      retractLicenseConfigCallable() {
    return retractLicenseConfigCallable;
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
