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

package com.google.cloud.commerce.consumer.procurement.v1.stub;

import static com.google.cloud.commerce.consumer.procurement.v1.LicenseManagementServiceClient.EnumerateLicensedUsersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.commerce.consumer.procurement.v1.AssignRequest;
import com.google.cloud.commerce.consumer.procurement.v1.AssignResponse;
import com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersRequest;
import com.google.cloud.commerce.consumer.procurement.v1.EnumerateLicensedUsersResponse;
import com.google.cloud.commerce.consumer.procurement.v1.GetLicensePoolRequest;
import com.google.cloud.commerce.consumer.procurement.v1.LicensePool;
import com.google.cloud.commerce.consumer.procurement.v1.UnassignRequest;
import com.google.cloud.commerce.consumer.procurement.v1.UnassignResponse;
import com.google.cloud.commerce.consumer.procurement.v1.UpdateLicensePoolRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the LicenseManagementService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcLicenseManagementServiceStub extends LicenseManagementServiceStub {
  private static final MethodDescriptor<GetLicensePoolRequest, LicensePool>
      getLicensePoolMethodDescriptor =
          MethodDescriptor.<GetLicensePoolRequest, LicensePool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerce.consumer.procurement.v1.LicenseManagementService/GetLicensePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLicensePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LicensePool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateLicensePoolRequest, LicensePool>
      updateLicensePoolMethodDescriptor =
          MethodDescriptor.<UpdateLicensePoolRequest, LicensePool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerce.consumer.procurement.v1.LicenseManagementService/UpdateLicensePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateLicensePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LicensePool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AssignRequest, AssignResponse> assignMethodDescriptor =
      MethodDescriptor.<AssignRequest, AssignResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.commerce.consumer.procurement.v1.LicenseManagementService/Assign")
          .setRequestMarshaller(ProtoUtils.marshaller(AssignRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(AssignResponse.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UnassignRequest, UnassignResponse>
      unassignMethodDescriptor =
          MethodDescriptor.<UnassignRequest, UnassignResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerce.consumer.procurement.v1.LicenseManagementService/Unassign")
              .setRequestMarshaller(ProtoUtils.marshaller(UnassignRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UnassignResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>
      enumerateLicensedUsersMethodDescriptor =
          MethodDescriptor
              .<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.commerce.consumer.procurement.v1.LicenseManagementService/EnumerateLicensedUsers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnumerateLicensedUsersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(EnumerateLicensedUsersResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetLicensePoolRequest, LicensePool> getLicensePoolCallable;
  private final UnaryCallable<UpdateLicensePoolRequest, LicensePool> updateLicensePoolCallable;
  private final UnaryCallable<AssignRequest, AssignResponse> assignCallable;
  private final UnaryCallable<UnassignRequest, UnassignResponse> unassignCallable;
  private final UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>
      enumerateLicensedUsersCallable;
  private final UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersPagedResponse>
      enumerateLicensedUsersPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLicenseManagementServiceStub create(
      LicenseManagementServiceStubSettings settings) throws IOException {
    return new GrpcLicenseManagementServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLicenseManagementServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLicenseManagementServiceStub(
        LicenseManagementServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLicenseManagementServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLicenseManagementServiceStub(
        LicenseManagementServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLicenseManagementServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLicenseManagementServiceStub(
      LicenseManagementServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcLicenseManagementServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLicenseManagementServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLicenseManagementServiceStub(
      LicenseManagementServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetLicensePoolRequest, LicensePool> getLicensePoolTransportSettings =
        GrpcCallSettings.<GetLicensePoolRequest, LicensePool>newBuilder()
            .setMethodDescriptor(getLicensePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateLicensePoolRequest, LicensePool> updateLicensePoolTransportSettings =
        GrpcCallSettings.<UpdateLicensePoolRequest, LicensePool>newBuilder()
            .setMethodDescriptor(updateLicensePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "license_pool.name", String.valueOf(request.getLicensePool().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AssignRequest, AssignResponse> assignTransportSettings =
        GrpcCallSettings.<AssignRequest, AssignResponse>newBuilder()
            .setMethodDescriptor(assignMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UnassignRequest, UnassignResponse> unassignTransportSettings =
        GrpcCallSettings.<UnassignRequest, UnassignResponse>newBuilder()
            .setMethodDescriptor(unassignMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>
        enumerateLicensedUsersTransportSettings =
            GrpcCallSettings
                .<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>newBuilder()
                .setMethodDescriptor(enumerateLicensedUsersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getLicensePoolCallable =
        callableFactory.createUnaryCallable(
            getLicensePoolTransportSettings, settings.getLicensePoolSettings(), clientContext);
    this.updateLicensePoolCallable =
        callableFactory.createUnaryCallable(
            updateLicensePoolTransportSettings,
            settings.updateLicensePoolSettings(),
            clientContext);
    this.assignCallable =
        callableFactory.createUnaryCallable(
            assignTransportSettings, settings.assignSettings(), clientContext);
    this.unassignCallable =
        callableFactory.createUnaryCallable(
            unassignTransportSettings, settings.unassignSettings(), clientContext);
    this.enumerateLicensedUsersCallable =
        callableFactory.createUnaryCallable(
            enumerateLicensedUsersTransportSettings,
            settings.enumerateLicensedUsersSettings(),
            clientContext);
    this.enumerateLicensedUsersPagedCallable =
        callableFactory.createPagedCallable(
            enumerateLicensedUsersTransportSettings,
            settings.enumerateLicensedUsersSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetLicensePoolRequest, LicensePool> getLicensePoolCallable() {
    return getLicensePoolCallable;
  }

  @Override
  public UnaryCallable<UpdateLicensePoolRequest, LicensePool> updateLicensePoolCallable() {
    return updateLicensePoolCallable;
  }

  @Override
  public UnaryCallable<AssignRequest, AssignResponse> assignCallable() {
    return assignCallable;
  }

  @Override
  public UnaryCallable<UnassignRequest, UnassignResponse> unassignCallable() {
    return unassignCallable;
  }

  @Override
  public UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersResponse>
      enumerateLicensedUsersCallable() {
    return enumerateLicensedUsersCallable;
  }

  @Override
  public UnaryCallable<EnumerateLicensedUsersRequest, EnumerateLicensedUsersPagedResponse>
      enumerateLicensedUsersPagedCallable() {
    return enumerateLicensedUsersPagedCallable;
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
