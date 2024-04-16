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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListModelMonitoringJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListModelMonitorsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.SearchModelMonitoringAlertsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.SearchModelMonitoringStatsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateModelMonitorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest;
import com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest;
import com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse;
import com.google.cloud.aiplatform.v1beta1.ModelMonitor;
import com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * gRPC stub implementation for the ModelMonitoringService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcModelMonitoringServiceStub extends ModelMonitoringServiceStub {
  private static final MethodDescriptor<CreateModelMonitorRequest, Operation>
      createModelMonitorMethodDescriptor =
          MethodDescriptor.<CreateModelMonitorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelMonitoringService/CreateModelMonitor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateModelMonitorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateModelMonitorRequest, Operation>
      updateModelMonitorMethodDescriptor =
          MethodDescriptor.<UpdateModelMonitorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelMonitoringService/UpdateModelMonitor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateModelMonitorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetModelMonitorRequest, ModelMonitor>
      getModelMonitorMethodDescriptor =
          MethodDescriptor.<GetModelMonitorRequest, ModelMonitor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelMonitoringService/GetModelMonitor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetModelMonitorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ModelMonitor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListModelMonitorsRequest, ListModelMonitorsResponse>
      listModelMonitorsMethodDescriptor =
          MethodDescriptor.<ListModelMonitorsRequest, ListModelMonitorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelMonitoringService/ListModelMonitors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListModelMonitorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListModelMonitorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteModelMonitorRequest, Operation>
      deleteModelMonitorMethodDescriptor =
          MethodDescriptor.<DeleteModelMonitorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelMonitoringService/DeleteModelMonitor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteModelMonitorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateModelMonitoringJobRequest, ModelMonitoringJob>
      createModelMonitoringJobMethodDescriptor =
          MethodDescriptor.<CreateModelMonitoringJobRequest, ModelMonitoringJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelMonitoringService/CreateModelMonitoringJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateModelMonitoringJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ModelMonitoringJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetModelMonitoringJobRequest, ModelMonitoringJob>
      getModelMonitoringJobMethodDescriptor =
          MethodDescriptor.<GetModelMonitoringJobRequest, ModelMonitoringJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelMonitoringService/GetModelMonitoringJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetModelMonitoringJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ModelMonitoringJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse>
      listModelMonitoringJobsMethodDescriptor =
          MethodDescriptor
              .<ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelMonitoringService/ListModelMonitoringJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListModelMonitoringJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListModelMonitoringJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteModelMonitoringJobRequest, Operation>
      deleteModelMonitoringJobMethodDescriptor =
          MethodDescriptor.<DeleteModelMonitoringJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelMonitoringService/DeleteModelMonitoringJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteModelMonitoringJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsResponse>
      searchModelMonitoringStatsMethodDescriptor =
          MethodDescriptor
              .<SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelMonitoringService/SearchModelMonitoringStats")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchModelMonitoringStatsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchModelMonitoringStatsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsResponse>
      searchModelMonitoringAlertsMethodDescriptor =
          MethodDescriptor
              .<SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.ModelMonitoringService/SearchModelMonitoringAlerts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchModelMonitoringAlertsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchModelMonitoringAlertsResponse.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateModelMonitorRequest, Operation> createModelMonitorCallable;
  private final OperationCallable<
          CreateModelMonitorRequest, ModelMonitor, CreateModelMonitorOperationMetadata>
      createModelMonitorOperationCallable;
  private final UnaryCallable<UpdateModelMonitorRequest, Operation> updateModelMonitorCallable;
  private final OperationCallable<
          UpdateModelMonitorRequest, ModelMonitor, UpdateModelMonitorOperationMetadata>
      updateModelMonitorOperationCallable;
  private final UnaryCallable<GetModelMonitorRequest, ModelMonitor> getModelMonitorCallable;
  private final UnaryCallable<ListModelMonitorsRequest, ListModelMonitorsResponse>
      listModelMonitorsCallable;
  private final UnaryCallable<ListModelMonitorsRequest, ListModelMonitorsPagedResponse>
      listModelMonitorsPagedCallable;
  private final UnaryCallable<DeleteModelMonitorRequest, Operation> deleteModelMonitorCallable;
  private final OperationCallable<DeleteModelMonitorRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitorOperationCallable;
  private final UnaryCallable<CreateModelMonitoringJobRequest, ModelMonitoringJob>
      createModelMonitoringJobCallable;
  private final UnaryCallable<GetModelMonitoringJobRequest, ModelMonitoringJob>
      getModelMonitoringJobCallable;
  private final UnaryCallable<ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse>
      listModelMonitoringJobsCallable;
  private final UnaryCallable<ListModelMonitoringJobsRequest, ListModelMonitoringJobsPagedResponse>
      listModelMonitoringJobsPagedCallable;
  private final UnaryCallable<DeleteModelMonitoringJobRequest, Operation>
      deleteModelMonitoringJobCallable;
  private final OperationCallable<DeleteModelMonitoringJobRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitoringJobOperationCallable;
  private final UnaryCallable<SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsResponse>
      searchModelMonitoringStatsCallable;
  private final UnaryCallable<
          SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsPagedResponse>
      searchModelMonitoringStatsPagedCallable;
  private final UnaryCallable<
          SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsResponse>
      searchModelMonitoringAlertsCallable;
  private final UnaryCallable<
          SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsPagedResponse>
      searchModelMonitoringAlertsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcModelMonitoringServiceStub create(
      ModelMonitoringServiceStubSettings settings) throws IOException {
    return new GrpcModelMonitoringServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcModelMonitoringServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcModelMonitoringServiceStub(
        ModelMonitoringServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcModelMonitoringServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcModelMonitoringServiceStub(
        ModelMonitoringServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcModelMonitoringServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcModelMonitoringServiceStub(
      ModelMonitoringServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcModelMonitoringServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcModelMonitoringServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcModelMonitoringServiceStub(
      ModelMonitoringServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateModelMonitorRequest, Operation> createModelMonitorTransportSettings =
        GrpcCallSettings.<CreateModelMonitorRequest, Operation>newBuilder()
            .setMethodDescriptor(createModelMonitorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateModelMonitorRequest, Operation> updateModelMonitorTransportSettings =
        GrpcCallSettings.<UpdateModelMonitorRequest, Operation>newBuilder()
            .setMethodDescriptor(updateModelMonitorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "model_monitor.name", String.valueOf(request.getModelMonitor().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetModelMonitorRequest, ModelMonitor> getModelMonitorTransportSettings =
        GrpcCallSettings.<GetModelMonitorRequest, ModelMonitor>newBuilder()
            .setMethodDescriptor(getModelMonitorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListModelMonitorsRequest, ListModelMonitorsResponse>
        listModelMonitorsTransportSettings =
            GrpcCallSettings.<ListModelMonitorsRequest, ListModelMonitorsResponse>newBuilder()
                .setMethodDescriptor(listModelMonitorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteModelMonitorRequest, Operation> deleteModelMonitorTransportSettings =
        GrpcCallSettings.<DeleteModelMonitorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteModelMonitorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateModelMonitoringJobRequest, ModelMonitoringJob>
        createModelMonitoringJobTransportSettings =
            GrpcCallSettings.<CreateModelMonitoringJobRequest, ModelMonitoringJob>newBuilder()
                .setMethodDescriptor(createModelMonitoringJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetModelMonitoringJobRequest, ModelMonitoringJob>
        getModelMonitoringJobTransportSettings =
            GrpcCallSettings.<GetModelMonitoringJobRequest, ModelMonitoringJob>newBuilder()
                .setMethodDescriptor(getModelMonitoringJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse>
        listModelMonitoringJobsTransportSettings =
            GrpcCallSettings
                .<ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse>newBuilder()
                .setMethodDescriptor(listModelMonitoringJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteModelMonitoringJobRequest, Operation>
        deleteModelMonitoringJobTransportSettings =
            GrpcCallSettings.<DeleteModelMonitoringJobRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteModelMonitoringJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsResponse>
        searchModelMonitoringStatsTransportSettings =
            GrpcCallSettings
                .<SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsResponse>newBuilder()
                .setMethodDescriptor(searchModelMonitoringStatsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("model_monitor", String.valueOf(request.getModelMonitor()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsResponse>
        searchModelMonitoringAlertsTransportSettings =
            GrpcCallSettings
                .<SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsResponse>
                    newBuilder()
                .setMethodDescriptor(searchModelMonitoringAlertsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("model_monitor", String.valueOf(request.getModelMonitor()));
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
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.createModelMonitorCallable =
        callableFactory.createUnaryCallable(
            createModelMonitorTransportSettings,
            settings.createModelMonitorSettings(),
            clientContext);
    this.createModelMonitorOperationCallable =
        callableFactory.createOperationCallable(
            createModelMonitorTransportSettings,
            settings.createModelMonitorOperationSettings(),
            clientContext,
            operationsStub);
    this.updateModelMonitorCallable =
        callableFactory.createUnaryCallable(
            updateModelMonitorTransportSettings,
            settings.updateModelMonitorSettings(),
            clientContext);
    this.updateModelMonitorOperationCallable =
        callableFactory.createOperationCallable(
            updateModelMonitorTransportSettings,
            settings.updateModelMonitorOperationSettings(),
            clientContext,
            operationsStub);
    this.getModelMonitorCallable =
        callableFactory.createUnaryCallable(
            getModelMonitorTransportSettings, settings.getModelMonitorSettings(), clientContext);
    this.listModelMonitorsCallable =
        callableFactory.createUnaryCallable(
            listModelMonitorsTransportSettings,
            settings.listModelMonitorsSettings(),
            clientContext);
    this.listModelMonitorsPagedCallable =
        callableFactory.createPagedCallable(
            listModelMonitorsTransportSettings,
            settings.listModelMonitorsSettings(),
            clientContext);
    this.deleteModelMonitorCallable =
        callableFactory.createUnaryCallable(
            deleteModelMonitorTransportSettings,
            settings.deleteModelMonitorSettings(),
            clientContext);
    this.deleteModelMonitorOperationCallable =
        callableFactory.createOperationCallable(
            deleteModelMonitorTransportSettings,
            settings.deleteModelMonitorOperationSettings(),
            clientContext,
            operationsStub);
    this.createModelMonitoringJobCallable =
        callableFactory.createUnaryCallable(
            createModelMonitoringJobTransportSettings,
            settings.createModelMonitoringJobSettings(),
            clientContext);
    this.getModelMonitoringJobCallable =
        callableFactory.createUnaryCallable(
            getModelMonitoringJobTransportSettings,
            settings.getModelMonitoringJobSettings(),
            clientContext);
    this.listModelMonitoringJobsCallable =
        callableFactory.createUnaryCallable(
            listModelMonitoringJobsTransportSettings,
            settings.listModelMonitoringJobsSettings(),
            clientContext);
    this.listModelMonitoringJobsPagedCallable =
        callableFactory.createPagedCallable(
            listModelMonitoringJobsTransportSettings,
            settings.listModelMonitoringJobsSettings(),
            clientContext);
    this.deleteModelMonitoringJobCallable =
        callableFactory.createUnaryCallable(
            deleteModelMonitoringJobTransportSettings,
            settings.deleteModelMonitoringJobSettings(),
            clientContext);
    this.deleteModelMonitoringJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteModelMonitoringJobTransportSettings,
            settings.deleteModelMonitoringJobOperationSettings(),
            clientContext,
            operationsStub);
    this.searchModelMonitoringStatsCallable =
        callableFactory.createUnaryCallable(
            searchModelMonitoringStatsTransportSettings,
            settings.searchModelMonitoringStatsSettings(),
            clientContext);
    this.searchModelMonitoringStatsPagedCallable =
        callableFactory.createPagedCallable(
            searchModelMonitoringStatsTransportSettings,
            settings.searchModelMonitoringStatsSettings(),
            clientContext);
    this.searchModelMonitoringAlertsCallable =
        callableFactory.createUnaryCallable(
            searchModelMonitoringAlertsTransportSettings,
            settings.searchModelMonitoringAlertsSettings(),
            clientContext);
    this.searchModelMonitoringAlertsPagedCallable =
        callableFactory.createPagedCallable(
            searchModelMonitoringAlertsTransportSettings,
            settings.searchModelMonitoringAlertsSettings(),
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
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateModelMonitorRequest, Operation> createModelMonitorCallable() {
    return createModelMonitorCallable;
  }

  @Override
  public OperationCallable<
          CreateModelMonitorRequest, ModelMonitor, CreateModelMonitorOperationMetadata>
      createModelMonitorOperationCallable() {
    return createModelMonitorOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateModelMonitorRequest, Operation> updateModelMonitorCallable() {
    return updateModelMonitorCallable;
  }

  @Override
  public OperationCallable<
          UpdateModelMonitorRequest, ModelMonitor, UpdateModelMonitorOperationMetadata>
      updateModelMonitorOperationCallable() {
    return updateModelMonitorOperationCallable;
  }

  @Override
  public UnaryCallable<GetModelMonitorRequest, ModelMonitor> getModelMonitorCallable() {
    return getModelMonitorCallable;
  }

  @Override
  public UnaryCallable<ListModelMonitorsRequest, ListModelMonitorsResponse>
      listModelMonitorsCallable() {
    return listModelMonitorsCallable;
  }

  @Override
  public UnaryCallable<ListModelMonitorsRequest, ListModelMonitorsPagedResponse>
      listModelMonitorsPagedCallable() {
    return listModelMonitorsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteModelMonitorRequest, Operation> deleteModelMonitorCallable() {
    return deleteModelMonitorCallable;
  }

  @Override
  public OperationCallable<DeleteModelMonitorRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitorOperationCallable() {
    return deleteModelMonitorOperationCallable;
  }

  @Override
  public UnaryCallable<CreateModelMonitoringJobRequest, ModelMonitoringJob>
      createModelMonitoringJobCallable() {
    return createModelMonitoringJobCallable;
  }

  @Override
  public UnaryCallable<GetModelMonitoringJobRequest, ModelMonitoringJob>
      getModelMonitoringJobCallable() {
    return getModelMonitoringJobCallable;
  }

  @Override
  public UnaryCallable<ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse>
      listModelMonitoringJobsCallable() {
    return listModelMonitoringJobsCallable;
  }

  @Override
  public UnaryCallable<ListModelMonitoringJobsRequest, ListModelMonitoringJobsPagedResponse>
      listModelMonitoringJobsPagedCallable() {
    return listModelMonitoringJobsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteModelMonitoringJobRequest, Operation>
      deleteModelMonitoringJobCallable() {
    return deleteModelMonitoringJobCallable;
  }

  @Override
  public OperationCallable<DeleteModelMonitoringJobRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitoringJobOperationCallable() {
    return deleteModelMonitoringJobOperationCallable;
  }

  @Override
  public UnaryCallable<SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsResponse>
      searchModelMonitoringStatsCallable() {
    return searchModelMonitoringStatsCallable;
  }

  @Override
  public UnaryCallable<SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsPagedResponse>
      searchModelMonitoringStatsPagedCallable() {
    return searchModelMonitoringStatsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsResponse>
      searchModelMonitoringAlertsCallable() {
    return searchModelMonitoringAlertsCallable;
  }

  @Override
  public UnaryCallable<SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsPagedResponse>
      searchModelMonitoringAlertsPagedCallable() {
    return searchModelMonitoringAlertsPagedCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
