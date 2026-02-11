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

package com.google.cloud.cloudsecuritycompliance.v1.stub;

import static com.google.cloud.cloudsecuritycompliance.v1.AuditClient.ListFrameworkAuditsPagedResponse;
import static com.google.cloud.cloudsecuritycompliance.v1.AuditClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudsecuritycompliance.v1.CreateFrameworkAuditRequest;
import com.google.cloud.cloudsecuritycompliance.v1.FrameworkAudit;
import com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportRequest;
import com.google.cloud.cloudsecuritycompliance.v1.GenerateFrameworkAuditScopeReportResponse;
import com.google.cloud.cloudsecuritycompliance.v1.GetFrameworkAuditRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsRequest;
import com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkAuditsResponse;
import com.google.cloud.cloudsecuritycompliance.v1.OperationMetadata;
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
 * gRPC stub implementation for the Audit service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAuditStub extends AuditStub {
  private static final MethodDescriptor<
          GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
      generateFrameworkAuditScopeReportMethodDescriptor =
          MethodDescriptor
              .<GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Audit/GenerateFrameworkAuditScopeReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GenerateFrameworkAuditScopeReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      GenerateFrameworkAuditScopeReportResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateFrameworkAuditRequest, Operation>
      createFrameworkAuditMethodDescriptor =
          MethodDescriptor.<CreateFrameworkAuditRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Audit/CreateFrameworkAudit")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFrameworkAuditRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>
      listFrameworkAuditsMethodDescriptor =
          MethodDescriptor.<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.cloudsecuritycompliance.v1.Audit/ListFrameworkAudits")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFrameworkAuditsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFrameworkAuditsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetFrameworkAuditRequest, FrameworkAudit>
      getFrameworkAuditMethodDescriptor =
          MethodDescriptor.<GetFrameworkAuditRequest, FrameworkAudit>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.cloudsecuritycompliance.v1.Audit/GetFrameworkAudit")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFrameworkAuditRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FrameworkAudit.getDefaultInstance()))
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

  private final UnaryCallable<
          GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
      generateFrameworkAuditScopeReportCallable;
  private final UnaryCallable<CreateFrameworkAuditRequest, Operation> createFrameworkAuditCallable;
  private final OperationCallable<CreateFrameworkAuditRequest, FrameworkAudit, OperationMetadata>
      createFrameworkAuditOperationCallable;
  private final UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>
      listFrameworkAuditsCallable;
  private final UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsPagedResponse>
      listFrameworkAuditsPagedCallable;
  private final UnaryCallable<GetFrameworkAuditRequest, FrameworkAudit> getFrameworkAuditCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAuditStub create(AuditStubSettings settings) throws IOException {
    return new GrpcAuditStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAuditStub create(ClientContext clientContext) throws IOException {
    return new GrpcAuditStub(AuditStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAuditStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAuditStub(
        AuditStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAuditStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAuditStub(AuditStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAuditCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAuditStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAuditStub(
      AuditStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<
            GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
        generateFrameworkAuditScopeReportTransportSettings =
            GrpcCallSettings
                .<GenerateFrameworkAuditScopeReportRequest,
                    GenerateFrameworkAuditScopeReportResponse>
                    newBuilder()
                .setMethodDescriptor(generateFrameworkAuditScopeReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("scope", String.valueOf(request.getScope()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateFrameworkAuditRequest, Operation> createFrameworkAuditTransportSettings =
        GrpcCallSettings.<CreateFrameworkAuditRequest, Operation>newBuilder()
            .setMethodDescriptor(createFrameworkAuditMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>
        listFrameworkAuditsTransportSettings =
            GrpcCallSettings.<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>newBuilder()
                .setMethodDescriptor(listFrameworkAuditsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetFrameworkAuditRequest, FrameworkAudit> getFrameworkAuditTransportSettings =
        GrpcCallSettings.<GetFrameworkAuditRequest, FrameworkAudit>newBuilder()
            .setMethodDescriptor(getFrameworkAuditMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
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

    this.generateFrameworkAuditScopeReportCallable =
        callableFactory.createUnaryCallable(
            generateFrameworkAuditScopeReportTransportSettings,
            settings.generateFrameworkAuditScopeReportSettings(),
            clientContext);
    this.createFrameworkAuditCallable =
        callableFactory.createUnaryCallable(
            createFrameworkAuditTransportSettings,
            settings.createFrameworkAuditSettings(),
            clientContext);
    this.createFrameworkAuditOperationCallable =
        callableFactory.createOperationCallable(
            createFrameworkAuditTransportSettings,
            settings.createFrameworkAuditOperationSettings(),
            clientContext,
            operationsStub);
    this.listFrameworkAuditsCallable =
        callableFactory.createUnaryCallable(
            listFrameworkAuditsTransportSettings,
            settings.listFrameworkAuditsSettings(),
            clientContext);
    this.listFrameworkAuditsPagedCallable =
        callableFactory.createPagedCallable(
            listFrameworkAuditsTransportSettings,
            settings.listFrameworkAuditsSettings(),
            clientContext);
    this.getFrameworkAuditCallable =
        callableFactory.createUnaryCallable(
            getFrameworkAuditTransportSettings,
            settings.getFrameworkAuditSettings(),
            clientContext);
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
  public UnaryCallable<
          GenerateFrameworkAuditScopeReportRequest, GenerateFrameworkAuditScopeReportResponse>
      generateFrameworkAuditScopeReportCallable() {
    return generateFrameworkAuditScopeReportCallable;
  }

  @Override
  public UnaryCallable<CreateFrameworkAuditRequest, Operation> createFrameworkAuditCallable() {
    return createFrameworkAuditCallable;
  }

  @Override
  public OperationCallable<CreateFrameworkAuditRequest, FrameworkAudit, OperationMetadata>
      createFrameworkAuditOperationCallable() {
    return createFrameworkAuditOperationCallable;
  }

  @Override
  public UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsResponse>
      listFrameworkAuditsCallable() {
    return listFrameworkAuditsCallable;
  }

  @Override
  public UnaryCallable<ListFrameworkAuditsRequest, ListFrameworkAuditsPagedResponse>
      listFrameworkAuditsPagedCallable() {
    return listFrameworkAuditsPagedCallable;
  }

  @Override
  public UnaryCallable<GetFrameworkAuditRequest, FrameworkAudit> getFrameworkAuditCallable() {
    return getFrameworkAuditCallable;
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
