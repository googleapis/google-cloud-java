/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.rapidmigrationassessment.v1.stub;

import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListCollectorsPagedResponse;
import static com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.rapidmigrationassessment.v1.Annotation;
import com.google.cloud.rapidmigrationassessment.v1.Collector;
import com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest;
import com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest;
import com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest;
import com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse;
import com.google.cloud.rapidmigrationassessment.v1.OperationMetadata;
import com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest;
import com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the RapidMigrationAssessment service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcRapidMigrationAssessmentStub extends RapidMigrationAssessmentStub {
  private static final MethodDescriptor<CreateCollectorRequest, Operation>
      createCollectorMethodDescriptor =
          MethodDescriptor.<CreateCollectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/CreateCollector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCollectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAnnotationRequest, Operation>
      createAnnotationMethodDescriptor =
          MethodDescriptor.<CreateAnnotationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/CreateAnnotation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAnnotationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAnnotationRequest, Annotation>
      getAnnotationMethodDescriptor =
          MethodDescriptor.<GetAnnotationRequest, Annotation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/GetAnnotation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAnnotationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Annotation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCollectorsRequest, ListCollectorsResponse>
      listCollectorsMethodDescriptor =
          MethodDescriptor.<ListCollectorsRequest, ListCollectorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/ListCollectors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCollectorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCollectorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCollectorRequest, Collector>
      getCollectorMethodDescriptor =
          MethodDescriptor.<GetCollectorRequest, Collector>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/GetCollector")
              .setRequestMarshaller(ProtoUtils.marshaller(GetCollectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Collector.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCollectorRequest, Operation>
      updateCollectorMethodDescriptor =
          MethodDescriptor.<UpdateCollectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/UpdateCollector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCollectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCollectorRequest, Operation>
      deleteCollectorMethodDescriptor =
          MethodDescriptor.<DeleteCollectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/DeleteCollector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCollectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResumeCollectorRequest, Operation>
      resumeCollectorMethodDescriptor =
          MethodDescriptor.<ResumeCollectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/ResumeCollector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResumeCollectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RegisterCollectorRequest, Operation>
      registerCollectorMethodDescriptor =
          MethodDescriptor.<RegisterCollectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/RegisterCollector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RegisterCollectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PauseCollectorRequest, Operation>
      pauseCollectorMethodDescriptor =
          MethodDescriptor.<PauseCollectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment/PauseCollector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PauseCollectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateCollectorRequest, Operation> createCollectorCallable;
  private final OperationCallable<CreateCollectorRequest, Collector, OperationMetadata>
      createCollectorOperationCallable;
  private final UnaryCallable<CreateAnnotationRequest, Operation> createAnnotationCallable;
  private final OperationCallable<CreateAnnotationRequest, Annotation, OperationMetadata>
      createAnnotationOperationCallable;
  private final UnaryCallable<GetAnnotationRequest, Annotation> getAnnotationCallable;
  private final UnaryCallable<ListCollectorsRequest, ListCollectorsResponse> listCollectorsCallable;
  private final UnaryCallable<ListCollectorsRequest, ListCollectorsPagedResponse>
      listCollectorsPagedCallable;
  private final UnaryCallable<GetCollectorRequest, Collector> getCollectorCallable;
  private final UnaryCallable<UpdateCollectorRequest, Operation> updateCollectorCallable;
  private final OperationCallable<UpdateCollectorRequest, Collector, OperationMetadata>
      updateCollectorOperationCallable;
  private final UnaryCallable<DeleteCollectorRequest, Operation> deleteCollectorCallable;
  private final OperationCallable<DeleteCollectorRequest, Collector, OperationMetadata>
      deleteCollectorOperationCallable;
  private final UnaryCallable<ResumeCollectorRequest, Operation> resumeCollectorCallable;
  private final OperationCallable<ResumeCollectorRequest, Collector, OperationMetadata>
      resumeCollectorOperationCallable;
  private final UnaryCallable<RegisterCollectorRequest, Operation> registerCollectorCallable;
  private final OperationCallable<RegisterCollectorRequest, Collector, OperationMetadata>
      registerCollectorOperationCallable;
  private final UnaryCallable<PauseCollectorRequest, Operation> pauseCollectorCallable;
  private final OperationCallable<PauseCollectorRequest, Collector, OperationMetadata>
      pauseCollectorOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRapidMigrationAssessmentStub create(
      RapidMigrationAssessmentStubSettings settings) throws IOException {
    return new GrpcRapidMigrationAssessmentStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRapidMigrationAssessmentStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcRapidMigrationAssessmentStub(
        RapidMigrationAssessmentStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRapidMigrationAssessmentStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRapidMigrationAssessmentStub(
        RapidMigrationAssessmentStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcRapidMigrationAssessmentStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcRapidMigrationAssessmentStub(
      RapidMigrationAssessmentStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRapidMigrationAssessmentCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRapidMigrationAssessmentStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcRapidMigrationAssessmentStub(
      RapidMigrationAssessmentStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateCollectorRequest, Operation> createCollectorTransportSettings =
        GrpcCallSettings.<CreateCollectorRequest, Operation>newBuilder()
            .setMethodDescriptor(createCollectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAnnotationRequest, Operation> createAnnotationTransportSettings =
        GrpcCallSettings.<CreateAnnotationRequest, Operation>newBuilder()
            .setMethodDescriptor(createAnnotationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAnnotationRequest, Annotation> getAnnotationTransportSettings =
        GrpcCallSettings.<GetAnnotationRequest, Annotation>newBuilder()
            .setMethodDescriptor(getAnnotationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCollectorsRequest, ListCollectorsResponse>
        listCollectorsTransportSettings =
            GrpcCallSettings.<ListCollectorsRequest, ListCollectorsResponse>newBuilder()
                .setMethodDescriptor(listCollectorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetCollectorRequest, Collector> getCollectorTransportSettings =
        GrpcCallSettings.<GetCollectorRequest, Collector>newBuilder()
            .setMethodDescriptor(getCollectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateCollectorRequest, Operation> updateCollectorTransportSettings =
        GrpcCallSettings.<UpdateCollectorRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCollectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("collector.name", String.valueOf(request.getCollector().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteCollectorRequest, Operation> deleteCollectorTransportSettings =
        GrpcCallSettings.<DeleteCollectorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCollectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ResumeCollectorRequest, Operation> resumeCollectorTransportSettings =
        GrpcCallSettings.<ResumeCollectorRequest, Operation>newBuilder()
            .setMethodDescriptor(resumeCollectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RegisterCollectorRequest, Operation> registerCollectorTransportSettings =
        GrpcCallSettings.<RegisterCollectorRequest, Operation>newBuilder()
            .setMethodDescriptor(registerCollectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<PauseCollectorRequest, Operation> pauseCollectorTransportSettings =
        GrpcCallSettings.<PauseCollectorRequest, Operation>newBuilder()
            .setMethodDescriptor(pauseCollectorMethodDescriptor)
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

    this.createCollectorCallable =
        callableFactory.createUnaryCallable(
            createCollectorTransportSettings, settings.createCollectorSettings(), clientContext);
    this.createCollectorOperationCallable =
        callableFactory.createOperationCallable(
            createCollectorTransportSettings,
            settings.createCollectorOperationSettings(),
            clientContext,
            operationsStub);
    this.createAnnotationCallable =
        callableFactory.createUnaryCallable(
            createAnnotationTransportSettings, settings.createAnnotationSettings(), clientContext);
    this.createAnnotationOperationCallable =
        callableFactory.createOperationCallable(
            createAnnotationTransportSettings,
            settings.createAnnotationOperationSettings(),
            clientContext,
            operationsStub);
    this.getAnnotationCallable =
        callableFactory.createUnaryCallable(
            getAnnotationTransportSettings, settings.getAnnotationSettings(), clientContext);
    this.listCollectorsCallable =
        callableFactory.createUnaryCallable(
            listCollectorsTransportSettings, settings.listCollectorsSettings(), clientContext);
    this.listCollectorsPagedCallable =
        callableFactory.createPagedCallable(
            listCollectorsTransportSettings, settings.listCollectorsSettings(), clientContext);
    this.getCollectorCallable =
        callableFactory.createUnaryCallable(
            getCollectorTransportSettings, settings.getCollectorSettings(), clientContext);
    this.updateCollectorCallable =
        callableFactory.createUnaryCallable(
            updateCollectorTransportSettings, settings.updateCollectorSettings(), clientContext);
    this.updateCollectorOperationCallable =
        callableFactory.createOperationCallable(
            updateCollectorTransportSettings,
            settings.updateCollectorOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCollectorCallable =
        callableFactory.createUnaryCallable(
            deleteCollectorTransportSettings, settings.deleteCollectorSettings(), clientContext);
    this.deleteCollectorOperationCallable =
        callableFactory.createOperationCallable(
            deleteCollectorTransportSettings,
            settings.deleteCollectorOperationSettings(),
            clientContext,
            operationsStub);
    this.resumeCollectorCallable =
        callableFactory.createUnaryCallable(
            resumeCollectorTransportSettings, settings.resumeCollectorSettings(), clientContext);
    this.resumeCollectorOperationCallable =
        callableFactory.createOperationCallable(
            resumeCollectorTransportSettings,
            settings.resumeCollectorOperationSettings(),
            clientContext,
            operationsStub);
    this.registerCollectorCallable =
        callableFactory.createUnaryCallable(
            registerCollectorTransportSettings,
            settings.registerCollectorSettings(),
            clientContext);
    this.registerCollectorOperationCallable =
        callableFactory.createOperationCallable(
            registerCollectorTransportSettings,
            settings.registerCollectorOperationSettings(),
            clientContext,
            operationsStub);
    this.pauseCollectorCallable =
        callableFactory.createUnaryCallable(
            pauseCollectorTransportSettings, settings.pauseCollectorSettings(), clientContext);
    this.pauseCollectorOperationCallable =
        callableFactory.createOperationCallable(
            pauseCollectorTransportSettings,
            settings.pauseCollectorOperationSettings(),
            clientContext,
            operationsStub);
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
  public UnaryCallable<CreateCollectorRequest, Operation> createCollectorCallable() {
    return createCollectorCallable;
  }

  @Override
  public OperationCallable<CreateCollectorRequest, Collector, OperationMetadata>
      createCollectorOperationCallable() {
    return createCollectorOperationCallable;
  }

  @Override
  public UnaryCallable<CreateAnnotationRequest, Operation> createAnnotationCallable() {
    return createAnnotationCallable;
  }

  @Override
  public OperationCallable<CreateAnnotationRequest, Annotation, OperationMetadata>
      createAnnotationOperationCallable() {
    return createAnnotationOperationCallable;
  }

  @Override
  public UnaryCallable<GetAnnotationRequest, Annotation> getAnnotationCallable() {
    return getAnnotationCallable;
  }

  @Override
  public UnaryCallable<ListCollectorsRequest, ListCollectorsResponse> listCollectorsCallable() {
    return listCollectorsCallable;
  }

  @Override
  public UnaryCallable<ListCollectorsRequest, ListCollectorsPagedResponse>
      listCollectorsPagedCallable() {
    return listCollectorsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCollectorRequest, Collector> getCollectorCallable() {
    return getCollectorCallable;
  }

  @Override
  public UnaryCallable<UpdateCollectorRequest, Operation> updateCollectorCallable() {
    return updateCollectorCallable;
  }

  @Override
  public OperationCallable<UpdateCollectorRequest, Collector, OperationMetadata>
      updateCollectorOperationCallable() {
    return updateCollectorOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCollectorRequest, Operation> deleteCollectorCallable() {
    return deleteCollectorCallable;
  }

  @Override
  public OperationCallable<DeleteCollectorRequest, Collector, OperationMetadata>
      deleteCollectorOperationCallable() {
    return deleteCollectorOperationCallable;
  }

  @Override
  public UnaryCallable<ResumeCollectorRequest, Operation> resumeCollectorCallable() {
    return resumeCollectorCallable;
  }

  @Override
  public OperationCallable<ResumeCollectorRequest, Collector, OperationMetadata>
      resumeCollectorOperationCallable() {
    return resumeCollectorOperationCallable;
  }

  @Override
  public UnaryCallable<RegisterCollectorRequest, Operation> registerCollectorCallable() {
    return registerCollectorCallable;
  }

  @Override
  public OperationCallable<RegisterCollectorRequest, Collector, OperationMetadata>
      registerCollectorOperationCallable() {
    return registerCollectorOperationCallable;
  }

  @Override
  public UnaryCallable<PauseCollectorRequest, Operation> pauseCollectorCallable() {
    return pauseCollectorCallable;
  }

  @Override
  public OperationCallable<PauseCollectorRequest, Collector, OperationMetadata>
      pauseCollectorOperationCallable() {
    return pauseCollectorOperationCallable;
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
