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

package com.google.cloud.cloudcontrolspartner.v1beta.stub;

import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient.ListAccessApprovalRequestsPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient.ListCustomersPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient.ListWorkloadsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudcontrolspartner.v1beta.Customer;
import com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections;
import com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse;
import com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse;
import com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse;
import com.google.cloud.cloudcontrolspartner.v1beta.Partner;
import com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions;
import com.google.cloud.cloudcontrolspartner.v1beta.Workload;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudControlsPartnerCore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcCloudControlsPartnerCoreStub extends CloudControlsPartnerCoreStub {
  private static final MethodDescriptor<GetWorkloadRequest, Workload> getWorkloadMethodDescriptor =
      MethodDescriptor.<GetWorkloadRequest, Workload>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/GetWorkload")
          .setRequestMarshaller(ProtoUtils.marshaller(GetWorkloadRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Workload.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListWorkloadsRequest, ListWorkloadsResponse>
      listWorkloadsMethodDescriptor =
          MethodDescriptor.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/ListWorkloads")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkloadsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkloadsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCustomerRequest, Customer> getCustomerMethodDescriptor =
      MethodDescriptor.<GetCustomerRequest, Customer>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/GetCustomer")
          .setRequestMarshaller(ProtoUtils.marshaller(GetCustomerRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Customer.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListCustomersRequest, ListCustomersResponse>
      listCustomersMethodDescriptor =
          MethodDescriptor.<ListCustomersRequest, ListCustomersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/ListCustomers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCustomersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCustomersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEkmConnectionsRequest, EkmConnections>
      getEkmConnectionsMethodDescriptor =
          MethodDescriptor.<GetEkmConnectionsRequest, EkmConnections>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/GetEkmConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEkmConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EkmConnections.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPartnerPermissionsRequest, PartnerPermissions>
      getPartnerPermissionsMethodDescriptor =
          MethodDescriptor.<GetPartnerPermissionsRequest, PartnerPermissions>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/GetPartnerPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPartnerPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PartnerPermissions.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>
      listAccessApprovalRequestsMethodDescriptor =
          MethodDescriptor
              .<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/ListAccessApprovalRequests")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccessApprovalRequestsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccessApprovalRequestsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPartnerRequest, Partner> getPartnerMethodDescriptor =
      MethodDescriptor.<GetPartnerRequest, Partner>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/GetPartner")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPartnerRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Partner.getDefaultInstance()))
          .build();

  private final UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable;
  private final UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable;
  private final UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable;
  private final UnaryCallable<GetCustomerRequest, Customer> getCustomerCallable;
  private final UnaryCallable<ListCustomersRequest, ListCustomersResponse> listCustomersCallable;
  private final UnaryCallable<ListCustomersRequest, ListCustomersPagedResponse>
      listCustomersPagedCallable;
  private final UnaryCallable<GetEkmConnectionsRequest, EkmConnections> getEkmConnectionsCallable;
  private final UnaryCallable<GetPartnerPermissionsRequest, PartnerPermissions>
      getPartnerPermissionsCallable;
  private final UnaryCallable<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>
      listAccessApprovalRequestsCallable;
  private final UnaryCallable<
          ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsPagedResponse>
      listAccessApprovalRequestsPagedCallable;
  private final UnaryCallable<GetPartnerRequest, Partner> getPartnerCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudControlsPartnerCoreStub create(
      CloudControlsPartnerCoreStubSettings settings) throws IOException {
    return new GrpcCloudControlsPartnerCoreStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudControlsPartnerCoreStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCloudControlsPartnerCoreStub(
        CloudControlsPartnerCoreStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudControlsPartnerCoreStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudControlsPartnerCoreStub(
        CloudControlsPartnerCoreStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudControlsPartnerCoreStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudControlsPartnerCoreStub(
      CloudControlsPartnerCoreStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCloudControlsPartnerCoreCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudControlsPartnerCoreStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudControlsPartnerCoreStub(
      CloudControlsPartnerCoreStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetWorkloadRequest, Workload> getWorkloadTransportSettings =
        GrpcCallSettings.<GetWorkloadRequest, Workload>newBuilder()
            .setMethodDescriptor(getWorkloadMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsTransportSettings =
        GrpcCallSettings.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
            .setMethodDescriptor(listWorkloadsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetCustomerRequest, Customer> getCustomerTransportSettings =
        GrpcCallSettings.<GetCustomerRequest, Customer>newBuilder()
            .setMethodDescriptor(getCustomerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCustomersRequest, ListCustomersResponse> listCustomersTransportSettings =
        GrpcCallSettings.<ListCustomersRequest, ListCustomersResponse>newBuilder()
            .setMethodDescriptor(listCustomersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEkmConnectionsRequest, EkmConnections> getEkmConnectionsTransportSettings =
        GrpcCallSettings.<GetEkmConnectionsRequest, EkmConnections>newBuilder()
            .setMethodDescriptor(getEkmConnectionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPartnerPermissionsRequest, PartnerPermissions>
        getPartnerPermissionsTransportSettings =
            GrpcCallSettings.<GetPartnerPermissionsRequest, PartnerPermissions>newBuilder()
                .setMethodDescriptor(getPartnerPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>
        listAccessApprovalRequestsTransportSettings =
            GrpcCallSettings
                .<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>newBuilder()
                .setMethodDescriptor(listAccessApprovalRequestsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPartnerRequest, Partner> getPartnerTransportSettings =
        GrpcCallSettings.<GetPartnerRequest, Partner>newBuilder()
            .setMethodDescriptor(getPartnerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getWorkloadCallable =
        callableFactory.createUnaryCallable(
            getWorkloadTransportSettings, settings.getWorkloadSettings(), clientContext);
    this.listWorkloadsCallable =
        callableFactory.createUnaryCallable(
            listWorkloadsTransportSettings, settings.listWorkloadsSettings(), clientContext);
    this.listWorkloadsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkloadsTransportSettings, settings.listWorkloadsSettings(), clientContext);
    this.getCustomerCallable =
        callableFactory.createUnaryCallable(
            getCustomerTransportSettings, settings.getCustomerSettings(), clientContext);
    this.listCustomersCallable =
        callableFactory.createUnaryCallable(
            listCustomersTransportSettings, settings.listCustomersSettings(), clientContext);
    this.listCustomersPagedCallable =
        callableFactory.createPagedCallable(
            listCustomersTransportSettings, settings.listCustomersSettings(), clientContext);
    this.getEkmConnectionsCallable =
        callableFactory.createUnaryCallable(
            getEkmConnectionsTransportSettings,
            settings.getEkmConnectionsSettings(),
            clientContext);
    this.getPartnerPermissionsCallable =
        callableFactory.createUnaryCallable(
            getPartnerPermissionsTransportSettings,
            settings.getPartnerPermissionsSettings(),
            clientContext);
    this.listAccessApprovalRequestsCallable =
        callableFactory.createUnaryCallable(
            listAccessApprovalRequestsTransportSettings,
            settings.listAccessApprovalRequestsSettings(),
            clientContext);
    this.listAccessApprovalRequestsPagedCallable =
        callableFactory.createPagedCallable(
            listAccessApprovalRequestsTransportSettings,
            settings.listAccessApprovalRequestsSettings(),
            clientContext);
    this.getPartnerCallable =
        callableFactory.createUnaryCallable(
            getPartnerTransportSettings, settings.getPartnerSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable() {
    return getWorkloadCallable;
  }

  @Override
  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable() {
    return listWorkloadsCallable;
  }

  @Override
  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable() {
    return listWorkloadsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCustomerRequest, Customer> getCustomerCallable() {
    return getCustomerCallable;
  }

  @Override
  public UnaryCallable<ListCustomersRequest, ListCustomersResponse> listCustomersCallable() {
    return listCustomersCallable;
  }

  @Override
  public UnaryCallable<ListCustomersRequest, ListCustomersPagedResponse>
      listCustomersPagedCallable() {
    return listCustomersPagedCallable;
  }

  @Override
  public UnaryCallable<GetEkmConnectionsRequest, EkmConnections> getEkmConnectionsCallable() {
    return getEkmConnectionsCallable;
  }

  @Override
  public UnaryCallable<GetPartnerPermissionsRequest, PartnerPermissions>
      getPartnerPermissionsCallable() {
    return getPartnerPermissionsCallable;
  }

  @Override
  public UnaryCallable<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>
      listAccessApprovalRequestsCallable() {
    return listAccessApprovalRequestsCallable;
  }

  @Override
  public UnaryCallable<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsPagedResponse>
      listAccessApprovalRequestsPagedCallable() {
    return listAccessApprovalRequestsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPartnerRequest, Partner> getPartnerCallable() {
    return getPartnerCallable;
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
