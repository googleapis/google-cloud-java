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

import static com.google.cloud.aiplatform.v1beta1.NotebookServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.NotebookServiceClient.ListNotebookExecutionJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.NotebookServiceClient.ListNotebookRuntimeTemplatesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.NotebookServiceClient.ListNotebookRuntimesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest;
import com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest;
import com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest;
import com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse;
import com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest;
import com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse;
import com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest;
import com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse;
import com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob;
import com.google.cloud.aiplatform.v1beta1.NotebookRuntime;
import com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate;
import com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeResponse;
import com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeResponse;
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
 * gRPC stub implementation for the NotebookService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcNotebookServiceStub extends NotebookServiceStub {
  private static final MethodDescriptor<CreateNotebookRuntimeTemplateRequest, Operation>
      createNotebookRuntimeTemplateMethodDescriptor =
          MethodDescriptor.<CreateNotebookRuntimeTemplateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/CreateNotebookRuntimeTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNotebookRuntimeTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>
      getNotebookRuntimeTemplateMethodDescriptor =
          MethodDescriptor.<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/GetNotebookRuntimeTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNotebookRuntimeTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(NotebookRuntimeTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesResponse>
      listNotebookRuntimeTemplatesMethodDescriptor =
          MethodDescriptor
              .<ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/ListNotebookRuntimeTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNotebookRuntimeTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNotebookRuntimeTemplatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNotebookRuntimeTemplateRequest, Operation>
      deleteNotebookRuntimeTemplateMethodDescriptor =
          MethodDescriptor.<DeleteNotebookRuntimeTemplateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/DeleteNotebookRuntimeTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNotebookRuntimeTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AssignNotebookRuntimeRequest, Operation>
      assignNotebookRuntimeMethodDescriptor =
          MethodDescriptor.<AssignNotebookRuntimeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/AssignNotebookRuntime")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AssignNotebookRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNotebookRuntimeRequest, NotebookRuntime>
      getNotebookRuntimeMethodDescriptor =
          MethodDescriptor.<GetNotebookRuntimeRequest, NotebookRuntime>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/GetNotebookRuntime")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNotebookRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NotebookRuntime.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse>
      listNotebookRuntimesMethodDescriptor =
          MethodDescriptor.<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/ListNotebookRuntimes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNotebookRuntimesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNotebookRuntimesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNotebookRuntimeRequest, Operation>
      deleteNotebookRuntimeMethodDescriptor =
          MethodDescriptor.<DeleteNotebookRuntimeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/DeleteNotebookRuntime")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNotebookRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpgradeNotebookRuntimeRequest, Operation>
      upgradeNotebookRuntimeMethodDescriptor =
          MethodDescriptor.<UpgradeNotebookRuntimeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/UpgradeNotebookRuntime")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpgradeNotebookRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartNotebookRuntimeRequest, Operation>
      startNotebookRuntimeMethodDescriptor =
          MethodDescriptor.<StartNotebookRuntimeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/StartNotebookRuntime")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartNotebookRuntimeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNotebookExecutionJobRequest, NotebookExecutionJob>
      getNotebookExecutionJobMethodDescriptor =
          MethodDescriptor.<GetNotebookExecutionJobRequest, NotebookExecutionJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/GetNotebookExecutionJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNotebookExecutionJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(NotebookExecutionJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListNotebookExecutionJobsRequest, ListNotebookExecutionJobsResponse>
      listNotebookExecutionJobsMethodDescriptor =
          MethodDescriptor
              .<ListNotebookExecutionJobsRequest, ListNotebookExecutionJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/ListNotebookExecutionJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNotebookExecutionJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNotebookExecutionJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNotebookExecutionJobRequest, Operation>
      deleteNotebookExecutionJobMethodDescriptor =
          MethodDescriptor.<DeleteNotebookExecutionJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.NotebookService/DeleteNotebookExecutionJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNotebookExecutionJobRequest.getDefaultInstance()))
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

  private final UnaryCallable<CreateNotebookRuntimeTemplateRequest, Operation>
      createNotebookRuntimeTemplateCallable;
  private final OperationCallable<
          CreateNotebookRuntimeTemplateRequest,
          NotebookRuntimeTemplate,
          CreateNotebookRuntimeTemplateOperationMetadata>
      createNotebookRuntimeTemplateOperationCallable;
  private final UnaryCallable<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>
      getNotebookRuntimeTemplateCallable;
  private final UnaryCallable<
          ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesResponse>
      listNotebookRuntimeTemplatesCallable;
  private final UnaryCallable<
          ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesPagedResponse>
      listNotebookRuntimeTemplatesPagedCallable;
  private final UnaryCallable<DeleteNotebookRuntimeTemplateRequest, Operation>
      deleteNotebookRuntimeTemplateCallable;
  private final OperationCallable<
          DeleteNotebookRuntimeTemplateRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeTemplateOperationCallable;
  private final UnaryCallable<AssignNotebookRuntimeRequest, Operation>
      assignNotebookRuntimeCallable;
  private final OperationCallable<
          AssignNotebookRuntimeRequest, NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
      assignNotebookRuntimeOperationCallable;
  private final UnaryCallable<GetNotebookRuntimeRequest, NotebookRuntime>
      getNotebookRuntimeCallable;
  private final UnaryCallable<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse>
      listNotebookRuntimesCallable;
  private final UnaryCallable<ListNotebookRuntimesRequest, ListNotebookRuntimesPagedResponse>
      listNotebookRuntimesPagedCallable;
  private final UnaryCallable<DeleteNotebookRuntimeRequest, Operation>
      deleteNotebookRuntimeCallable;
  private final OperationCallable<DeleteNotebookRuntimeRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeOperationCallable;
  private final UnaryCallable<UpgradeNotebookRuntimeRequest, Operation>
      upgradeNotebookRuntimeCallable;
  private final OperationCallable<
          UpgradeNotebookRuntimeRequest,
          UpgradeNotebookRuntimeResponse,
          UpgradeNotebookRuntimeOperationMetadata>
      upgradeNotebookRuntimeOperationCallable;
  private final UnaryCallable<StartNotebookRuntimeRequest, Operation> startNotebookRuntimeCallable;
  private final OperationCallable<
          StartNotebookRuntimeRequest,
          StartNotebookRuntimeResponse,
          StartNotebookRuntimeOperationMetadata>
      startNotebookRuntimeOperationCallable;
  private final UnaryCallable<GetNotebookExecutionJobRequest, NotebookExecutionJob>
      getNotebookExecutionJobCallable;
  private final UnaryCallable<ListNotebookExecutionJobsRequest, ListNotebookExecutionJobsResponse>
      listNotebookExecutionJobsCallable;
  private final UnaryCallable<
          ListNotebookExecutionJobsRequest, ListNotebookExecutionJobsPagedResponse>
      listNotebookExecutionJobsPagedCallable;
  private final UnaryCallable<DeleteNotebookExecutionJobRequest, Operation>
      deleteNotebookExecutionJobCallable;
  private final OperationCallable<DeleteNotebookExecutionJobRequest, Empty, DeleteOperationMetadata>
      deleteNotebookExecutionJobOperationCallable;
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

  public static final GrpcNotebookServiceStub create(NotebookServiceStubSettings settings)
      throws IOException {
    return new GrpcNotebookServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNotebookServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcNotebookServiceStub(
        NotebookServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNotebookServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNotebookServiceStub(
        NotebookServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcNotebookServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcNotebookServiceStub(
      NotebookServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcNotebookServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNotebookServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcNotebookServiceStub(
      NotebookServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateNotebookRuntimeTemplateRequest, Operation>
        createNotebookRuntimeTemplateTransportSettings =
            GrpcCallSettings.<CreateNotebookRuntimeTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(createNotebookRuntimeTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>
        getNotebookRuntimeTemplateTransportSettings =
            GrpcCallSettings
                .<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>newBuilder()
                .setMethodDescriptor(getNotebookRuntimeTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesResponse>
        listNotebookRuntimeTemplatesTransportSettings =
            GrpcCallSettings
                .<ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesResponse>
                    newBuilder()
                .setMethodDescriptor(listNotebookRuntimeTemplatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteNotebookRuntimeTemplateRequest, Operation>
        deleteNotebookRuntimeTemplateTransportSettings =
            GrpcCallSettings.<DeleteNotebookRuntimeTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteNotebookRuntimeTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<AssignNotebookRuntimeRequest, Operation>
        assignNotebookRuntimeTransportSettings =
            GrpcCallSettings.<AssignNotebookRuntimeRequest, Operation>newBuilder()
                .setMethodDescriptor(assignNotebookRuntimeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetNotebookRuntimeRequest, NotebookRuntime>
        getNotebookRuntimeTransportSettings =
            GrpcCallSettings.<GetNotebookRuntimeRequest, NotebookRuntime>newBuilder()
                .setMethodDescriptor(getNotebookRuntimeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse>
        listNotebookRuntimesTransportSettings =
            GrpcCallSettings.<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse>newBuilder()
                .setMethodDescriptor(listNotebookRuntimesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteNotebookRuntimeRequest, Operation>
        deleteNotebookRuntimeTransportSettings =
            GrpcCallSettings.<DeleteNotebookRuntimeRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteNotebookRuntimeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpgradeNotebookRuntimeRequest, Operation>
        upgradeNotebookRuntimeTransportSettings =
            GrpcCallSettings.<UpgradeNotebookRuntimeRequest, Operation>newBuilder()
                .setMethodDescriptor(upgradeNotebookRuntimeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<StartNotebookRuntimeRequest, Operation> startNotebookRuntimeTransportSettings =
        GrpcCallSettings.<StartNotebookRuntimeRequest, Operation>newBuilder()
            .setMethodDescriptor(startNotebookRuntimeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetNotebookExecutionJobRequest, NotebookExecutionJob>
        getNotebookExecutionJobTransportSettings =
            GrpcCallSettings.<GetNotebookExecutionJobRequest, NotebookExecutionJob>newBuilder()
                .setMethodDescriptor(getNotebookExecutionJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListNotebookExecutionJobsRequest, ListNotebookExecutionJobsResponse>
        listNotebookExecutionJobsTransportSettings =
            GrpcCallSettings
                .<ListNotebookExecutionJobsRequest, ListNotebookExecutionJobsResponse>newBuilder()
                .setMethodDescriptor(listNotebookExecutionJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteNotebookExecutionJobRequest, Operation>
        deleteNotebookExecutionJobTransportSettings =
            GrpcCallSettings.<DeleteNotebookExecutionJobRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteNotebookExecutionJobMethodDescriptor)
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

    this.createNotebookRuntimeTemplateCallable =
        callableFactory.createUnaryCallable(
            createNotebookRuntimeTemplateTransportSettings,
            settings.createNotebookRuntimeTemplateSettings(),
            clientContext);
    this.createNotebookRuntimeTemplateOperationCallable =
        callableFactory.createOperationCallable(
            createNotebookRuntimeTemplateTransportSettings,
            settings.createNotebookRuntimeTemplateOperationSettings(),
            clientContext,
            operationsStub);
    this.getNotebookRuntimeTemplateCallable =
        callableFactory.createUnaryCallable(
            getNotebookRuntimeTemplateTransportSettings,
            settings.getNotebookRuntimeTemplateSettings(),
            clientContext);
    this.listNotebookRuntimeTemplatesCallable =
        callableFactory.createUnaryCallable(
            listNotebookRuntimeTemplatesTransportSettings,
            settings.listNotebookRuntimeTemplatesSettings(),
            clientContext);
    this.listNotebookRuntimeTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listNotebookRuntimeTemplatesTransportSettings,
            settings.listNotebookRuntimeTemplatesSettings(),
            clientContext);
    this.deleteNotebookRuntimeTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteNotebookRuntimeTemplateTransportSettings,
            settings.deleteNotebookRuntimeTemplateSettings(),
            clientContext);
    this.deleteNotebookRuntimeTemplateOperationCallable =
        callableFactory.createOperationCallable(
            deleteNotebookRuntimeTemplateTransportSettings,
            settings.deleteNotebookRuntimeTemplateOperationSettings(),
            clientContext,
            operationsStub);
    this.assignNotebookRuntimeCallable =
        callableFactory.createUnaryCallable(
            assignNotebookRuntimeTransportSettings,
            settings.assignNotebookRuntimeSettings(),
            clientContext);
    this.assignNotebookRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            assignNotebookRuntimeTransportSettings,
            settings.assignNotebookRuntimeOperationSettings(),
            clientContext,
            operationsStub);
    this.getNotebookRuntimeCallable =
        callableFactory.createUnaryCallable(
            getNotebookRuntimeTransportSettings,
            settings.getNotebookRuntimeSettings(),
            clientContext);
    this.listNotebookRuntimesCallable =
        callableFactory.createUnaryCallable(
            listNotebookRuntimesTransportSettings,
            settings.listNotebookRuntimesSettings(),
            clientContext);
    this.listNotebookRuntimesPagedCallable =
        callableFactory.createPagedCallable(
            listNotebookRuntimesTransportSettings,
            settings.listNotebookRuntimesSettings(),
            clientContext);
    this.deleteNotebookRuntimeCallable =
        callableFactory.createUnaryCallable(
            deleteNotebookRuntimeTransportSettings,
            settings.deleteNotebookRuntimeSettings(),
            clientContext);
    this.deleteNotebookRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            deleteNotebookRuntimeTransportSettings,
            settings.deleteNotebookRuntimeOperationSettings(),
            clientContext,
            operationsStub);
    this.upgradeNotebookRuntimeCallable =
        callableFactory.createUnaryCallable(
            upgradeNotebookRuntimeTransportSettings,
            settings.upgradeNotebookRuntimeSettings(),
            clientContext);
    this.upgradeNotebookRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            upgradeNotebookRuntimeTransportSettings,
            settings.upgradeNotebookRuntimeOperationSettings(),
            clientContext,
            operationsStub);
    this.startNotebookRuntimeCallable =
        callableFactory.createUnaryCallable(
            startNotebookRuntimeTransportSettings,
            settings.startNotebookRuntimeSettings(),
            clientContext);
    this.startNotebookRuntimeOperationCallable =
        callableFactory.createOperationCallable(
            startNotebookRuntimeTransportSettings,
            settings.startNotebookRuntimeOperationSettings(),
            clientContext,
            operationsStub);
    this.getNotebookExecutionJobCallable =
        callableFactory.createUnaryCallable(
            getNotebookExecutionJobTransportSettings,
            settings.getNotebookExecutionJobSettings(),
            clientContext);
    this.listNotebookExecutionJobsCallable =
        callableFactory.createUnaryCallable(
            listNotebookExecutionJobsTransportSettings,
            settings.listNotebookExecutionJobsSettings(),
            clientContext);
    this.listNotebookExecutionJobsPagedCallable =
        callableFactory.createPagedCallable(
            listNotebookExecutionJobsTransportSettings,
            settings.listNotebookExecutionJobsSettings(),
            clientContext);
    this.deleteNotebookExecutionJobCallable =
        callableFactory.createUnaryCallable(
            deleteNotebookExecutionJobTransportSettings,
            settings.deleteNotebookExecutionJobSettings(),
            clientContext);
    this.deleteNotebookExecutionJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteNotebookExecutionJobTransportSettings,
            settings.deleteNotebookExecutionJobOperationSettings(),
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
  public UnaryCallable<CreateNotebookRuntimeTemplateRequest, Operation>
      createNotebookRuntimeTemplateCallable() {
    return createNotebookRuntimeTemplateCallable;
  }

  @Override
  public OperationCallable<
          CreateNotebookRuntimeTemplateRequest,
          NotebookRuntimeTemplate,
          CreateNotebookRuntimeTemplateOperationMetadata>
      createNotebookRuntimeTemplateOperationCallable() {
    return createNotebookRuntimeTemplateOperationCallable;
  }

  @Override
  public UnaryCallable<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>
      getNotebookRuntimeTemplateCallable() {
    return getNotebookRuntimeTemplateCallable;
  }

  @Override
  public UnaryCallable<ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesResponse>
      listNotebookRuntimeTemplatesCallable() {
    return listNotebookRuntimeTemplatesCallable;
  }

  @Override
  public UnaryCallable<
          ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesPagedResponse>
      listNotebookRuntimeTemplatesPagedCallable() {
    return listNotebookRuntimeTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteNotebookRuntimeTemplateRequest, Operation>
      deleteNotebookRuntimeTemplateCallable() {
    return deleteNotebookRuntimeTemplateCallable;
  }

  @Override
  public OperationCallable<DeleteNotebookRuntimeTemplateRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeTemplateOperationCallable() {
    return deleteNotebookRuntimeTemplateOperationCallable;
  }

  @Override
  public UnaryCallable<AssignNotebookRuntimeRequest, Operation> assignNotebookRuntimeCallable() {
    return assignNotebookRuntimeCallable;
  }

  @Override
  public OperationCallable<
          AssignNotebookRuntimeRequest, NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
      assignNotebookRuntimeOperationCallable() {
    return assignNotebookRuntimeOperationCallable;
  }

  @Override
  public UnaryCallable<GetNotebookRuntimeRequest, NotebookRuntime> getNotebookRuntimeCallable() {
    return getNotebookRuntimeCallable;
  }

  @Override
  public UnaryCallable<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse>
      listNotebookRuntimesCallable() {
    return listNotebookRuntimesCallable;
  }

  @Override
  public UnaryCallable<ListNotebookRuntimesRequest, ListNotebookRuntimesPagedResponse>
      listNotebookRuntimesPagedCallable() {
    return listNotebookRuntimesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteNotebookRuntimeRequest, Operation> deleteNotebookRuntimeCallable() {
    return deleteNotebookRuntimeCallable;
  }

  @Override
  public OperationCallable<DeleteNotebookRuntimeRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeOperationCallable() {
    return deleteNotebookRuntimeOperationCallable;
  }

  @Override
  public UnaryCallable<UpgradeNotebookRuntimeRequest, Operation> upgradeNotebookRuntimeCallable() {
    return upgradeNotebookRuntimeCallable;
  }

  @Override
  public OperationCallable<
          UpgradeNotebookRuntimeRequest,
          UpgradeNotebookRuntimeResponse,
          UpgradeNotebookRuntimeOperationMetadata>
      upgradeNotebookRuntimeOperationCallable() {
    return upgradeNotebookRuntimeOperationCallable;
  }

  @Override
  public UnaryCallable<StartNotebookRuntimeRequest, Operation> startNotebookRuntimeCallable() {
    return startNotebookRuntimeCallable;
  }

  @Override
  public OperationCallable<
          StartNotebookRuntimeRequest,
          StartNotebookRuntimeResponse,
          StartNotebookRuntimeOperationMetadata>
      startNotebookRuntimeOperationCallable() {
    return startNotebookRuntimeOperationCallable;
  }

  @Override
  public UnaryCallable<GetNotebookExecutionJobRequest, NotebookExecutionJob>
      getNotebookExecutionJobCallable() {
    return getNotebookExecutionJobCallable;
  }

  @Override
  public UnaryCallable<ListNotebookExecutionJobsRequest, ListNotebookExecutionJobsResponse>
      listNotebookExecutionJobsCallable() {
    return listNotebookExecutionJobsCallable;
  }

  @Override
  public UnaryCallable<ListNotebookExecutionJobsRequest, ListNotebookExecutionJobsPagedResponse>
      listNotebookExecutionJobsPagedCallable() {
    return listNotebookExecutionJobsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteNotebookExecutionJobRequest, Operation>
      deleteNotebookExecutionJobCallable() {
    return deleteNotebookExecutionJobCallable;
  }

  @Override
  public OperationCallable<DeleteNotebookExecutionJobRequest, Empty, DeleteOperationMetadata>
      deleteNotebookExecutionJobOperationCallable() {
    return deleteNotebookExecutionJobOperationCallable;
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
