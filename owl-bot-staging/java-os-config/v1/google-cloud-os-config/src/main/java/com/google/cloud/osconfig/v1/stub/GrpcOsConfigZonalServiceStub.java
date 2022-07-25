/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.osconfig.v1.stub;

import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListInventoriesPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListOSPolicyAssignmentReportsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListOSPolicyAssignmentRevisionsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListOSPolicyAssignmentsPagedResponse;
import static com.google.cloud.osconfig.v1.OsConfigZonalServiceClient.ListVulnerabilityReportsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.osconfig.v1.CreateOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1.DeleteOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1.GetInventoryRequest;
import com.google.cloud.osconfig.v1.GetOSPolicyAssignmentReportRequest;
import com.google.cloud.osconfig.v1.GetOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1.GetVulnerabilityReportRequest;
import com.google.cloud.osconfig.v1.Inventory;
import com.google.cloud.osconfig.v1.ListInventoriesRequest;
import com.google.cloud.osconfig.v1.ListInventoriesResponse;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentReportsRequest;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentReportsResponse;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentRevisionsRequest;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentRevisionsResponse;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentsRequest;
import com.google.cloud.osconfig.v1.ListOSPolicyAssignmentsResponse;
import com.google.cloud.osconfig.v1.ListVulnerabilityReportsRequest;
import com.google.cloud.osconfig.v1.ListVulnerabilityReportsResponse;
import com.google.cloud.osconfig.v1.OSPolicyAssignment;
import com.google.cloud.osconfig.v1.OSPolicyAssignmentOperationMetadata;
import com.google.cloud.osconfig.v1.OSPolicyAssignmentReport;
import com.google.cloud.osconfig.v1.UpdateOSPolicyAssignmentRequest;
import com.google.cloud.osconfig.v1.VulnerabilityReport;
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
 * gRPC stub implementation for the OsConfigZonalService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcOsConfigZonalServiceStub extends OsConfigZonalServiceStub {
  private static final MethodDescriptor<CreateOSPolicyAssignmentRequest, Operation>
      createOSPolicyAssignmentMethodDescriptor =
          MethodDescriptor.<CreateOSPolicyAssignmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/CreateOSPolicyAssignment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateOSPolicyAssignmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateOSPolicyAssignmentRequest, Operation>
      updateOSPolicyAssignmentMethodDescriptor =
          MethodDescriptor.<UpdateOSPolicyAssignmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/UpdateOSPolicyAssignment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateOSPolicyAssignmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetOSPolicyAssignmentRequest, OSPolicyAssignment>
      getOSPolicyAssignmentMethodDescriptor =
          MethodDescriptor.<GetOSPolicyAssignmentRequest, OSPolicyAssignment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/GetOSPolicyAssignment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOSPolicyAssignmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(OSPolicyAssignment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>
      listOSPolicyAssignmentsMethodDescriptor =
          MethodDescriptor
              .<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/ListOSPolicyAssignments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOSPolicyAssignmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOSPolicyAssignmentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
      listOSPolicyAssignmentRevisionsMethodDescriptor =
          MethodDescriptor
              .<ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/ListOSPolicyAssignmentRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListOSPolicyAssignmentRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListOSPolicyAssignmentRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteOSPolicyAssignmentRequest, Operation>
      deleteOSPolicyAssignmentMethodDescriptor =
          MethodDescriptor.<DeleteOSPolicyAssignmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/DeleteOSPolicyAssignment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteOSPolicyAssignmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>
      getOSPolicyAssignmentReportMethodDescriptor =
          MethodDescriptor
              .<GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/GetOSPolicyAssignmentReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOSPolicyAssignmentReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(OSPolicyAssignmentReport.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
      listOSPolicyAssignmentReportsMethodDescriptor =
          MethodDescriptor
              .<ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/ListOSPolicyAssignmentReports")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOSPolicyAssignmentReportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOSPolicyAssignmentReportsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInventoryRequest, Inventory>
      getInventoryMethodDescriptor =
          MethodDescriptor.<GetInventoryRequest, Inventory>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1.OsConfigZonalService/GetInventory")
              .setRequestMarshaller(ProtoUtils.marshaller(GetInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Inventory.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListInventoriesRequest, ListInventoriesResponse>
      listInventoriesMethodDescriptor =
          MethodDescriptor.<ListInventoriesRequest, ListInventoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.osconfig.v1.OsConfigZonalService/ListInventories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInventoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInventoriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVulnerabilityReportRequest, VulnerabilityReport>
      getVulnerabilityReportMethodDescriptor =
          MethodDescriptor.<GetVulnerabilityReportRequest, VulnerabilityReport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/GetVulnerabilityReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetVulnerabilityReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(VulnerabilityReport.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>
      listVulnerabilityReportsMethodDescriptor =
          MethodDescriptor
              .<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.osconfig.v1.OsConfigZonalService/ListVulnerabilityReports")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListVulnerabilityReportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVulnerabilityReportsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateOSPolicyAssignmentRequest, Operation>
      createOSPolicyAssignmentCallable;
  private final OperationCallable<
          CreateOSPolicyAssignmentRequest, OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      createOSPolicyAssignmentOperationCallable;
  private final UnaryCallable<UpdateOSPolicyAssignmentRequest, Operation>
      updateOSPolicyAssignmentCallable;
  private final OperationCallable<
          UpdateOSPolicyAssignmentRequest, OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      updateOSPolicyAssignmentOperationCallable;
  private final UnaryCallable<GetOSPolicyAssignmentRequest, OSPolicyAssignment>
      getOSPolicyAssignmentCallable;
  private final UnaryCallable<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>
      listOSPolicyAssignmentsCallable;
  private final UnaryCallable<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsPagedResponse>
      listOSPolicyAssignmentsPagedCallable;
  private final UnaryCallable<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
      listOSPolicyAssignmentRevisionsCallable;
  private final UnaryCallable<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsPagedResponse>
      listOSPolicyAssignmentRevisionsPagedCallable;
  private final UnaryCallable<DeleteOSPolicyAssignmentRequest, Operation>
      deleteOSPolicyAssignmentCallable;
  private final OperationCallable<
          DeleteOSPolicyAssignmentRequest, Empty, OSPolicyAssignmentOperationMetadata>
      deleteOSPolicyAssignmentOperationCallable;
  private final UnaryCallable<GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>
      getOSPolicyAssignmentReportCallable;
  private final UnaryCallable<
          ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
      listOSPolicyAssignmentReportsCallable;
  private final UnaryCallable<
          ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsPagedResponse>
      listOSPolicyAssignmentReportsPagedCallable;
  private final UnaryCallable<GetInventoryRequest, Inventory> getInventoryCallable;
  private final UnaryCallable<ListInventoriesRequest, ListInventoriesResponse>
      listInventoriesCallable;
  private final UnaryCallable<ListInventoriesRequest, ListInventoriesPagedResponse>
      listInventoriesPagedCallable;
  private final UnaryCallable<GetVulnerabilityReportRequest, VulnerabilityReport>
      getVulnerabilityReportCallable;
  private final UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>
      listVulnerabilityReportsCallable;
  private final UnaryCallable<
          ListVulnerabilityReportsRequest, ListVulnerabilityReportsPagedResponse>
      listVulnerabilityReportsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcOsConfigZonalServiceStub create(OsConfigZonalServiceStubSettings settings)
      throws IOException {
    return new GrpcOsConfigZonalServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOsConfigZonalServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOsConfigZonalServiceStub(
        OsConfigZonalServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOsConfigZonalServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOsConfigZonalServiceStub(
        OsConfigZonalServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcOsConfigZonalServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcOsConfigZonalServiceStub(
      OsConfigZonalServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcOsConfigZonalServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOsConfigZonalServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcOsConfigZonalServiceStub(
      OsConfigZonalServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateOSPolicyAssignmentRequest, Operation>
        createOSPolicyAssignmentTransportSettings =
            GrpcCallSettings.<CreateOSPolicyAssignmentRequest, Operation>newBuilder()
                .setMethodDescriptor(createOSPolicyAssignmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateOSPolicyAssignmentRequest, Operation>
        updateOSPolicyAssignmentTransportSettings =
            GrpcCallSettings.<UpdateOSPolicyAssignmentRequest, Operation>newBuilder()
                .setMethodDescriptor(updateOSPolicyAssignmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "os_policy_assignment.name",
                          String.valueOf(request.getOsPolicyAssignment().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetOSPolicyAssignmentRequest, OSPolicyAssignment>
        getOSPolicyAssignmentTransportSettings =
            GrpcCallSettings.<GetOSPolicyAssignmentRequest, OSPolicyAssignment>newBuilder()
                .setMethodDescriptor(getOSPolicyAssignmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>
        listOSPolicyAssignmentsTransportSettings =
            GrpcCallSettings
                .<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>newBuilder()
                .setMethodDescriptor(listOSPolicyAssignmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<
            ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
        listOSPolicyAssignmentRevisionsTransportSettings =
            GrpcCallSettings
                .<ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
                    newBuilder()
                .setMethodDescriptor(listOSPolicyAssignmentRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteOSPolicyAssignmentRequest, Operation>
        deleteOSPolicyAssignmentTransportSettings =
            GrpcCallSettings.<DeleteOSPolicyAssignmentRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteOSPolicyAssignmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>
        getOSPolicyAssignmentReportTransportSettings =
            GrpcCallSettings
                .<GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>newBuilder()
                .setMethodDescriptor(getOSPolicyAssignmentReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
        listOSPolicyAssignmentReportsTransportSettings =
            GrpcCallSettings
                .<ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
                    newBuilder()
                .setMethodDescriptor(listOSPolicyAssignmentReportsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetInventoryRequest, Inventory> getInventoryTransportSettings =
        GrpcCallSettings.<GetInventoryRequest, Inventory>newBuilder()
            .setMethodDescriptor(getInventoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListInventoriesRequest, ListInventoriesResponse>
        listInventoriesTransportSettings =
            GrpcCallSettings.<ListInventoriesRequest, ListInventoriesResponse>newBuilder()
                .setMethodDescriptor(listInventoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetVulnerabilityReportRequest, VulnerabilityReport>
        getVulnerabilityReportTransportSettings =
            GrpcCallSettings.<GetVulnerabilityReportRequest, VulnerabilityReport>newBuilder()
                .setMethodDescriptor(getVulnerabilityReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>
        listVulnerabilityReportsTransportSettings =
            GrpcCallSettings
                .<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>newBuilder()
                .setMethodDescriptor(listVulnerabilityReportsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();

    this.createOSPolicyAssignmentCallable =
        callableFactory.createUnaryCallable(
            createOSPolicyAssignmentTransportSettings,
            settings.createOSPolicyAssignmentSettings(),
            clientContext);
    this.createOSPolicyAssignmentOperationCallable =
        callableFactory.createOperationCallable(
            createOSPolicyAssignmentTransportSettings,
            settings.createOSPolicyAssignmentOperationSettings(),
            clientContext,
            operationsStub);
    this.updateOSPolicyAssignmentCallable =
        callableFactory.createUnaryCallable(
            updateOSPolicyAssignmentTransportSettings,
            settings.updateOSPolicyAssignmentSettings(),
            clientContext);
    this.updateOSPolicyAssignmentOperationCallable =
        callableFactory.createOperationCallable(
            updateOSPolicyAssignmentTransportSettings,
            settings.updateOSPolicyAssignmentOperationSettings(),
            clientContext,
            operationsStub);
    this.getOSPolicyAssignmentCallable =
        callableFactory.createUnaryCallable(
            getOSPolicyAssignmentTransportSettings,
            settings.getOSPolicyAssignmentSettings(),
            clientContext);
    this.listOSPolicyAssignmentsCallable =
        callableFactory.createUnaryCallable(
            listOSPolicyAssignmentsTransportSettings,
            settings.listOSPolicyAssignmentsSettings(),
            clientContext);
    this.listOSPolicyAssignmentsPagedCallable =
        callableFactory.createPagedCallable(
            listOSPolicyAssignmentsTransportSettings,
            settings.listOSPolicyAssignmentsSettings(),
            clientContext);
    this.listOSPolicyAssignmentRevisionsCallable =
        callableFactory.createUnaryCallable(
            listOSPolicyAssignmentRevisionsTransportSettings,
            settings.listOSPolicyAssignmentRevisionsSettings(),
            clientContext);
    this.listOSPolicyAssignmentRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listOSPolicyAssignmentRevisionsTransportSettings,
            settings.listOSPolicyAssignmentRevisionsSettings(),
            clientContext);
    this.deleteOSPolicyAssignmentCallable =
        callableFactory.createUnaryCallable(
            deleteOSPolicyAssignmentTransportSettings,
            settings.deleteOSPolicyAssignmentSettings(),
            clientContext);
    this.deleteOSPolicyAssignmentOperationCallable =
        callableFactory.createOperationCallable(
            deleteOSPolicyAssignmentTransportSettings,
            settings.deleteOSPolicyAssignmentOperationSettings(),
            clientContext,
            operationsStub);
    this.getOSPolicyAssignmentReportCallable =
        callableFactory.createUnaryCallable(
            getOSPolicyAssignmentReportTransportSettings,
            settings.getOSPolicyAssignmentReportSettings(),
            clientContext);
    this.listOSPolicyAssignmentReportsCallable =
        callableFactory.createUnaryCallable(
            listOSPolicyAssignmentReportsTransportSettings,
            settings.listOSPolicyAssignmentReportsSettings(),
            clientContext);
    this.listOSPolicyAssignmentReportsPagedCallable =
        callableFactory.createPagedCallable(
            listOSPolicyAssignmentReportsTransportSettings,
            settings.listOSPolicyAssignmentReportsSettings(),
            clientContext);
    this.getInventoryCallable =
        callableFactory.createUnaryCallable(
            getInventoryTransportSettings, settings.getInventorySettings(), clientContext);
    this.listInventoriesCallable =
        callableFactory.createUnaryCallable(
            listInventoriesTransportSettings, settings.listInventoriesSettings(), clientContext);
    this.listInventoriesPagedCallable =
        callableFactory.createPagedCallable(
            listInventoriesTransportSettings, settings.listInventoriesSettings(), clientContext);
    this.getVulnerabilityReportCallable =
        callableFactory.createUnaryCallable(
            getVulnerabilityReportTransportSettings,
            settings.getVulnerabilityReportSettings(),
            clientContext);
    this.listVulnerabilityReportsCallable =
        callableFactory.createUnaryCallable(
            listVulnerabilityReportsTransportSettings,
            settings.listVulnerabilityReportsSettings(),
            clientContext);
    this.listVulnerabilityReportsPagedCallable =
        callableFactory.createPagedCallable(
            listVulnerabilityReportsTransportSettings,
            settings.listVulnerabilityReportsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateOSPolicyAssignmentRequest, Operation>
      createOSPolicyAssignmentCallable() {
    return createOSPolicyAssignmentCallable;
  }

  @Override
  public OperationCallable<
          CreateOSPolicyAssignmentRequest, OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      createOSPolicyAssignmentOperationCallable() {
    return createOSPolicyAssignmentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateOSPolicyAssignmentRequest, Operation>
      updateOSPolicyAssignmentCallable() {
    return updateOSPolicyAssignmentCallable;
  }

  @Override
  public OperationCallable<
          UpdateOSPolicyAssignmentRequest, OSPolicyAssignment, OSPolicyAssignmentOperationMetadata>
      updateOSPolicyAssignmentOperationCallable() {
    return updateOSPolicyAssignmentOperationCallable;
  }

  @Override
  public UnaryCallable<GetOSPolicyAssignmentRequest, OSPolicyAssignment>
      getOSPolicyAssignmentCallable() {
    return getOSPolicyAssignmentCallable;
  }

  @Override
  public UnaryCallable<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsResponse>
      listOSPolicyAssignmentsCallable() {
    return listOSPolicyAssignmentsCallable;
  }

  @Override
  public UnaryCallable<ListOSPolicyAssignmentsRequest, ListOSPolicyAssignmentsPagedResponse>
      listOSPolicyAssignmentsPagedCallable() {
    return listOSPolicyAssignmentsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsResponse>
      listOSPolicyAssignmentRevisionsCallable() {
    return listOSPolicyAssignmentRevisionsCallable;
  }

  @Override
  public UnaryCallable<
          ListOSPolicyAssignmentRevisionsRequest, ListOSPolicyAssignmentRevisionsPagedResponse>
      listOSPolicyAssignmentRevisionsPagedCallable() {
    return listOSPolicyAssignmentRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteOSPolicyAssignmentRequest, Operation>
      deleteOSPolicyAssignmentCallable() {
    return deleteOSPolicyAssignmentCallable;
  }

  @Override
  public OperationCallable<
          DeleteOSPolicyAssignmentRequest, Empty, OSPolicyAssignmentOperationMetadata>
      deleteOSPolicyAssignmentOperationCallable() {
    return deleteOSPolicyAssignmentOperationCallable;
  }

  @Override
  public UnaryCallable<GetOSPolicyAssignmentReportRequest, OSPolicyAssignmentReport>
      getOSPolicyAssignmentReportCallable() {
    return getOSPolicyAssignmentReportCallable;
  }

  @Override
  public UnaryCallable<ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsResponse>
      listOSPolicyAssignmentReportsCallable() {
    return listOSPolicyAssignmentReportsCallable;
  }

  @Override
  public UnaryCallable<
          ListOSPolicyAssignmentReportsRequest, ListOSPolicyAssignmentReportsPagedResponse>
      listOSPolicyAssignmentReportsPagedCallable() {
    return listOSPolicyAssignmentReportsPagedCallable;
  }

  @Override
  public UnaryCallable<GetInventoryRequest, Inventory> getInventoryCallable() {
    return getInventoryCallable;
  }

  @Override
  public UnaryCallable<ListInventoriesRequest, ListInventoriesResponse> listInventoriesCallable() {
    return listInventoriesCallable;
  }

  @Override
  public UnaryCallable<ListInventoriesRequest, ListInventoriesPagedResponse>
      listInventoriesPagedCallable() {
    return listInventoriesPagedCallable;
  }

  @Override
  public UnaryCallable<GetVulnerabilityReportRequest, VulnerabilityReport>
      getVulnerabilityReportCallable() {
    return getVulnerabilityReportCallable;
  }

  @Override
  public UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>
      listVulnerabilityReportsCallable() {
    return listVulnerabilityReportsCallable;
  }

  @Override
  public UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsPagedResponse>
      listVulnerabilityReportsPagedCallable() {
    return listVulnerabilityReportsPagedCallable;
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
