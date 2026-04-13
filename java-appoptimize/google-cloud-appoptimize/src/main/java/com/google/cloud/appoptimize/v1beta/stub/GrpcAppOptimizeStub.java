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

package com.google.cloud.appoptimize.v1beta.stub;

import static com.google.cloud.appoptimize.v1beta.AppOptimizeClient.ListLocationsPagedResponse;
import static com.google.cloud.appoptimize.v1beta.AppOptimizeClient.ListReportsPagedResponse;
import static com.google.cloud.appoptimize.v1beta.AppOptimizeClient.ReadReportPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.appoptimize.v1beta.CreateReportRequest;
import com.google.cloud.appoptimize.v1beta.DeleteReportRequest;
import com.google.cloud.appoptimize.v1beta.GetReportRequest;
import com.google.cloud.appoptimize.v1beta.ListReportsRequest;
import com.google.cloud.appoptimize.v1beta.ListReportsResponse;
import com.google.cloud.appoptimize.v1beta.OperationMetadata;
import com.google.cloud.appoptimize.v1beta.ReadReportRequest;
import com.google.cloud.appoptimize.v1beta.ReadReportResponse;
import com.google.cloud.appoptimize.v1beta.Report;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AppOptimize service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAppOptimizeStub extends AppOptimizeStub {
  private static final MethodDescriptor<CreateReportRequest, Operation>
      createReportMethodDescriptor =
          MethodDescriptor.<CreateReportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.appoptimize.v1beta.AppOptimize/CreateReport")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetReportRequest, Report> getReportMethodDescriptor =
      MethodDescriptor.<GetReportRequest, Report>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.appoptimize.v1beta.AppOptimize/GetReport")
          .setRequestMarshaller(ProtoUtils.marshaller(GetReportRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Report.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListReportsRequest, ListReportsResponse>
      listReportsMethodDescriptor =
          MethodDescriptor.<ListReportsRequest, ListReportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.appoptimize.v1beta.AppOptimize/ListReports")
              .setRequestMarshaller(ProtoUtils.marshaller(ListReportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReportsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteReportRequest, Empty> deleteReportMethodDescriptor =
      MethodDescriptor.<DeleteReportRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.appoptimize.v1beta.AppOptimize/DeleteReport")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteReportRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ReadReportRequest, ReadReportResponse>
      readReportMethodDescriptor =
          MethodDescriptor.<ReadReportRequest, ReadReportResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.appoptimize.v1beta.AppOptimize/ReadReport")
              .setRequestMarshaller(ProtoUtils.marshaller(ReadReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReadReportResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateReportRequest, Operation> createReportCallable;
  private final OperationCallable<CreateReportRequest, Report, OperationMetadata>
      createReportOperationCallable;
  private final UnaryCallable<GetReportRequest, Report> getReportCallable;
  private final UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable;
  private final UnaryCallable<ListReportsRequest, ListReportsPagedResponse>
      listReportsPagedCallable;
  private final UnaryCallable<DeleteReportRequest, Empty> deleteReportCallable;
  private final UnaryCallable<ReadReportRequest, ReadReportResponse> readReportCallable;
  private final UnaryCallable<ReadReportRequest, ReadReportPagedResponse> readReportPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAppOptimizeStub create(AppOptimizeStubSettings settings)
      throws IOException {
    return new GrpcAppOptimizeStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAppOptimizeStub create(ClientContext clientContext) throws IOException {
    return new GrpcAppOptimizeStub(AppOptimizeStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAppOptimizeStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAppOptimizeStub(
        AppOptimizeStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAppOptimizeStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAppOptimizeStub(AppOptimizeStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAppOptimizeCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAppOptimizeStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAppOptimizeStub(
      AppOptimizeStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateReportRequest, Operation> createReportTransportSettings =
        GrpcCallSettings.<CreateReportRequest, Operation>newBuilder()
            .setMethodDescriptor(createReportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetReportRequest, Report> getReportTransportSettings =
        GrpcCallSettings.<GetReportRequest, Report>newBuilder()
            .setMethodDescriptor(getReportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListReportsRequest, ListReportsResponse> listReportsTransportSettings =
        GrpcCallSettings.<ListReportsRequest, ListReportsResponse>newBuilder()
            .setMethodDescriptor(listReportsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<DeleteReportRequest, Empty> deleteReportTransportSettings =
        GrpcCallSettings.<DeleteReportRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteReportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ReadReportRequest, ReadReportResponse> readReportTransportSettings =
        GrpcCallSettings.<ReadReportRequest, ReadReportResponse>newBuilder()
            .setMethodDescriptor(readReportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
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

    this.createReportCallable =
        callableFactory.createUnaryCallable(
            createReportTransportSettings, settings.createReportSettings(), clientContext);
    this.createReportOperationCallable =
        callableFactory.createOperationCallable(
            createReportTransportSettings,
            settings.createReportOperationSettings(),
            clientContext,
            operationsStub);
    this.getReportCallable =
        callableFactory.createUnaryCallable(
            getReportTransportSettings, settings.getReportSettings(), clientContext);
    this.listReportsCallable =
        callableFactory.createUnaryCallable(
            listReportsTransportSettings, settings.listReportsSettings(), clientContext);
    this.listReportsPagedCallable =
        callableFactory.createPagedCallable(
            listReportsTransportSettings, settings.listReportsSettings(), clientContext);
    this.deleteReportCallable =
        callableFactory.createUnaryCallable(
            deleteReportTransportSettings, settings.deleteReportSettings(), clientContext);
    this.readReportCallable =
        callableFactory.createUnaryCallable(
            readReportTransportSettings, settings.readReportSettings(), clientContext);
    this.readReportPagedCallable =
        callableFactory.createPagedCallable(
            readReportTransportSettings, settings.readReportSettings(), clientContext);
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
  public UnaryCallable<CreateReportRequest, Operation> createReportCallable() {
    return createReportCallable;
  }

  @Override
  public OperationCallable<CreateReportRequest, Report, OperationMetadata>
      createReportOperationCallable() {
    return createReportOperationCallable;
  }

  @Override
  public UnaryCallable<GetReportRequest, Report> getReportCallable() {
    return getReportCallable;
  }

  @Override
  public UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable() {
    return listReportsCallable;
  }

  @Override
  public UnaryCallable<ListReportsRequest, ListReportsPagedResponse> listReportsPagedCallable() {
    return listReportsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteReportRequest, Empty> deleteReportCallable() {
    return deleteReportCallable;
  }

  @Override
  public UnaryCallable<ReadReportRequest, ReadReportResponse> readReportCallable() {
    return readReportCallable;
  }

  @Override
  public UnaryCallable<ReadReportRequest, ReadReportPagedResponse> readReportPagedCallable() {
    return readReportPagedCallable;
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
