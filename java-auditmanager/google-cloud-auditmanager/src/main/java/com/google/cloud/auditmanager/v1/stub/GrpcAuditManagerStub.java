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

package com.google.cloud.auditmanager.v1.stub;

import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListAuditReportsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListControlsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListResourceEnrollmentStatusesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.auditmanager.v1.AuditReport;
import com.google.cloud.auditmanager.v1.AuditScopeReport;
import com.google.cloud.auditmanager.v1.EnrollResourceRequest;
import com.google.cloud.auditmanager.v1.Enrollment;
import com.google.cloud.auditmanager.v1.GenerateAuditReportRequest;
import com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest;
import com.google.cloud.auditmanager.v1.GetAuditReportRequest;
import com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest;
import com.google.cloud.auditmanager.v1.ListAuditReportsRequest;
import com.google.cloud.auditmanager.v1.ListAuditReportsResponse;
import com.google.cloud.auditmanager.v1.ListControlsRequest;
import com.google.cloud.auditmanager.v1.ListControlsResponse;
import com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest;
import com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse;
import com.google.cloud.auditmanager.v1.OperationMetadata;
import com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AuditManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAuditManagerStub extends AuditManagerStub {
  private static final MethodDescriptor<EnrollResourceRequest, Enrollment>
      enrollResourceMethodDescriptor =
          MethodDescriptor.<EnrollResourceRequest, Enrollment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.auditmanager.v1.AuditManager/EnrollResource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnrollResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Enrollment.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GenerateAuditScopeReportRequest, AuditScopeReport>
      generateAuditScopeReportMethodDescriptor =
          MethodDescriptor.<GenerateAuditScopeReportRequest, AuditScopeReport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.auditmanager.v1.AuditManager/GenerateAuditScopeReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateAuditScopeReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AuditScopeReport.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GenerateAuditReportRequest, Operation>
      generateAuditReportMethodDescriptor =
          MethodDescriptor.<GenerateAuditReportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.auditmanager.v1.AuditManager/GenerateAuditReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateAuditReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAuditReportsRequest, ListAuditReportsResponse>
      listAuditReportsMethodDescriptor =
          MethodDescriptor.<ListAuditReportsRequest, ListAuditReportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.auditmanager.v1.AuditManager/ListAuditReports")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAuditReportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAuditReportsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAuditReportRequest, AuditReport>
      getAuditReportMethodDescriptor =
          MethodDescriptor.<GetAuditReportRequest, AuditReport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.auditmanager.v1.AuditManager/GetAuditReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAuditReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AuditReport.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
      getResourceEnrollmentStatusMethodDescriptor =
          MethodDescriptor
              .<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.auditmanager.v1.AuditManager/GetResourceEnrollmentStatus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetResourceEnrollmentStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ResourceEnrollmentStatus.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
      listResourceEnrollmentStatusesMethodDescriptor =
          MethodDescriptor
              .<ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.auditmanager.v1.AuditManager/ListResourceEnrollmentStatuses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListResourceEnrollmentStatusesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListResourceEnrollmentStatusesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListControlsRequest, ListControlsResponse>
      listControlsMethodDescriptor =
          MethodDescriptor.<ListControlsRequest, ListControlsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.auditmanager.v1.AuditManager/ListControls")
              .setRequestMarshaller(ProtoUtils.marshaller(ListControlsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListControlsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<EnrollResourceRequest, Enrollment> enrollResourceCallable;
  private final UnaryCallable<GenerateAuditScopeReportRequest, AuditScopeReport>
      generateAuditScopeReportCallable;
  private final UnaryCallable<GenerateAuditReportRequest, Operation> generateAuditReportCallable;
  private final OperationCallable<GenerateAuditReportRequest, AuditReport, OperationMetadata>
      generateAuditReportOperationCallable;
  private final UnaryCallable<ListAuditReportsRequest, ListAuditReportsResponse>
      listAuditReportsCallable;
  private final UnaryCallable<ListAuditReportsRequest, ListAuditReportsPagedResponse>
      listAuditReportsPagedCallable;
  private final UnaryCallable<GetAuditReportRequest, AuditReport> getAuditReportCallable;
  private final UnaryCallable<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
      getResourceEnrollmentStatusCallable;
  private final UnaryCallable<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
      listResourceEnrollmentStatusesCallable;
  private final UnaryCallable<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesPagedResponse>
      listResourceEnrollmentStatusesPagedCallable;
  private final UnaryCallable<ListControlsRequest, ListControlsResponse> listControlsCallable;
  private final UnaryCallable<ListControlsRequest, ListControlsPagedResponse>
      listControlsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAuditManagerStub create(AuditManagerStubSettings settings)
      throws IOException {
    return new GrpcAuditManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAuditManagerStub create(ClientContext clientContext) throws IOException {
    return new GrpcAuditManagerStub(AuditManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAuditManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAuditManagerStub(
        AuditManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAuditManagerStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAuditManagerStub(AuditManagerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAuditManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAuditManagerStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAuditManagerStub(
      AuditManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<EnrollResourceRequest, Enrollment> enrollResourceTransportSettings =
        GrpcCallSettings.<EnrollResourceRequest, Enrollment>newBuilder()
            .setMethodDescriptor(enrollResourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("scope", String.valueOf(request.getScope()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GenerateAuditScopeReportRequest, AuditScopeReport>
        generateAuditScopeReportTransportSettings =
            GrpcCallSettings.<GenerateAuditScopeReportRequest, AuditScopeReport>newBuilder()
                .setMethodDescriptor(generateAuditScopeReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("scope", String.valueOf(request.getScope()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GenerateAuditReportRequest, Operation> generateAuditReportTransportSettings =
        GrpcCallSettings.<GenerateAuditReportRequest, Operation>newBuilder()
            .setMethodDescriptor(generateAuditReportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("scope", String.valueOf(request.getScope()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAuditReportsRequest, ListAuditReportsResponse>
        listAuditReportsTransportSettings =
            GrpcCallSettings.<ListAuditReportsRequest, ListAuditReportsResponse>newBuilder()
                .setMethodDescriptor(listAuditReportsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAuditReportRequest, AuditReport> getAuditReportTransportSettings =
        GrpcCallSettings.<GetAuditReportRequest, AuditReport>newBuilder()
            .setMethodDescriptor(getAuditReportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
        getResourceEnrollmentStatusTransportSettings =
            GrpcCallSettings
                .<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>newBuilder()
                .setMethodDescriptor(getResourceEnrollmentStatusMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
        listResourceEnrollmentStatusesTransportSettings =
            GrpcCallSettings
                .<ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
                    newBuilder()
                .setMethodDescriptor(listResourceEnrollmentStatusesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListControlsRequest, ListControlsResponse> listControlsTransportSettings =
        GrpcCallSettings.<ListControlsRequest, ListControlsResponse>newBuilder()
            .setMethodDescriptor(listControlsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.enrollResourceCallable =
        callableFactory.createUnaryCallable(
            enrollResourceTransportSettings, settings.enrollResourceSettings(), clientContext);
    this.generateAuditScopeReportCallable =
        callableFactory.createUnaryCallable(
            generateAuditScopeReportTransportSettings,
            settings.generateAuditScopeReportSettings(),
            clientContext);
    this.generateAuditReportCallable =
        callableFactory.createUnaryCallable(
            generateAuditReportTransportSettings,
            settings.generateAuditReportSettings(),
            clientContext);
    this.generateAuditReportOperationCallable =
        callableFactory.createOperationCallable(
            generateAuditReportTransportSettings,
            settings.generateAuditReportOperationSettings(),
            clientContext,
            operationsStub);
    this.listAuditReportsCallable =
        callableFactory.createUnaryCallable(
            listAuditReportsTransportSettings, settings.listAuditReportsSettings(), clientContext);
    this.listAuditReportsPagedCallable =
        callableFactory.createPagedCallable(
            listAuditReportsTransportSettings, settings.listAuditReportsSettings(), clientContext);
    this.getAuditReportCallable =
        callableFactory.createUnaryCallable(
            getAuditReportTransportSettings, settings.getAuditReportSettings(), clientContext);
    this.getResourceEnrollmentStatusCallable =
        callableFactory.createUnaryCallable(
            getResourceEnrollmentStatusTransportSettings,
            settings.getResourceEnrollmentStatusSettings(),
            clientContext);
    this.listResourceEnrollmentStatusesCallable =
        callableFactory.createUnaryCallable(
            listResourceEnrollmentStatusesTransportSettings,
            settings.listResourceEnrollmentStatusesSettings(),
            clientContext);
    this.listResourceEnrollmentStatusesPagedCallable =
        callableFactory.createPagedCallable(
            listResourceEnrollmentStatusesTransportSettings,
            settings.listResourceEnrollmentStatusesSettings(),
            clientContext);
    this.listControlsCallable =
        callableFactory.createUnaryCallable(
            listControlsTransportSettings, settings.listControlsSettings(), clientContext);
    this.listControlsPagedCallable =
        callableFactory.createPagedCallable(
            listControlsTransportSettings, settings.listControlsSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<EnrollResourceRequest, Enrollment> enrollResourceCallable() {
    return enrollResourceCallable;
  }

  @Override
  public UnaryCallable<GenerateAuditScopeReportRequest, AuditScopeReport>
      generateAuditScopeReportCallable() {
    return generateAuditScopeReportCallable;
  }

  @Override
  public UnaryCallable<GenerateAuditReportRequest, Operation> generateAuditReportCallable() {
    return generateAuditReportCallable;
  }

  @Override
  public OperationCallable<GenerateAuditReportRequest, AuditReport, OperationMetadata>
      generateAuditReportOperationCallable() {
    return generateAuditReportOperationCallable;
  }

  @Override
  public UnaryCallable<ListAuditReportsRequest, ListAuditReportsResponse>
      listAuditReportsCallable() {
    return listAuditReportsCallable;
  }

  @Override
  public UnaryCallable<ListAuditReportsRequest, ListAuditReportsPagedResponse>
      listAuditReportsPagedCallable() {
    return listAuditReportsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuditReportRequest, AuditReport> getAuditReportCallable() {
    return getAuditReportCallable;
  }

  @Override
  public UnaryCallable<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
      getResourceEnrollmentStatusCallable() {
    return getResourceEnrollmentStatusCallable;
  }

  @Override
  public UnaryCallable<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesResponse>
      listResourceEnrollmentStatusesCallable() {
    return listResourceEnrollmentStatusesCallable;
  }

  @Override
  public UnaryCallable<
          ListResourceEnrollmentStatusesRequest, ListResourceEnrollmentStatusesPagedResponse>
      listResourceEnrollmentStatusesPagedCallable() {
    return listResourceEnrollmentStatusesPagedCallable;
  }

  @Override
  public UnaryCallable<ListControlsRequest, ListControlsResponse> listControlsCallable() {
    return listControlsCallable;
  }

  @Override
  public UnaryCallable<ListControlsRequest, ListControlsPagedResponse> listControlsPagedCallable() {
    return listControlsPagedCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
