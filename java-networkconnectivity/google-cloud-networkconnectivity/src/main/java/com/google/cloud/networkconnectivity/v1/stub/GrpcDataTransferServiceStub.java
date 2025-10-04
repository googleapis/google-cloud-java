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

package com.google.cloud.networkconnectivity.v1.stub;

import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListDestinationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListMulticloudDataTransferConfigsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListMulticloudDataTransferSupportedServicesPagedResponse;

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
import com.google.cloud.networkconnectivity.v1.CreateDestinationRequest;
import com.google.cloud.networkconnectivity.v1.CreateMulticloudDataTransferConfigRequest;
import com.google.cloud.networkconnectivity.v1.DeleteDestinationRequest;
import com.google.cloud.networkconnectivity.v1.DeleteMulticloudDataTransferConfigRequest;
import com.google.cloud.networkconnectivity.v1.Destination;
import com.google.cloud.networkconnectivity.v1.GetDestinationRequest;
import com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferConfigRequest;
import com.google.cloud.networkconnectivity.v1.GetMulticloudDataTransferSupportedServiceRequest;
import com.google.cloud.networkconnectivity.v1.ListDestinationsRequest;
import com.google.cloud.networkconnectivity.v1.ListDestinationsResponse;
import com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsRequest;
import com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferConfigsResponse;
import com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferSupportedServicesRequest;
import com.google.cloud.networkconnectivity.v1.ListMulticloudDataTransferSupportedServicesResponse;
import com.google.cloud.networkconnectivity.v1.MulticloudDataTransferConfig;
import com.google.cloud.networkconnectivity.v1.MulticloudDataTransferSupportedService;
import com.google.cloud.networkconnectivity.v1.OperationMetadata;
import com.google.cloud.networkconnectivity.v1.UpdateDestinationRequest;
import com.google.cloud.networkconnectivity.v1.UpdateMulticloudDataTransferConfigRequest;
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
 * gRPC stub implementation for the DataTransferService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataTransferServiceStub extends DataTransferServiceStub {
  private static final MethodDescriptor<
          ListMulticloudDataTransferConfigsRequest, ListMulticloudDataTransferConfigsResponse>
      listMulticloudDataTransferConfigsMethodDescriptor =
          MethodDescriptor
              .<ListMulticloudDataTransferConfigsRequest, ListMulticloudDataTransferConfigsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.DataTransferService/ListMulticloudDataTransferConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListMulticloudDataTransferConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListMulticloudDataTransferConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>
      getMulticloudDataTransferConfigMethodDescriptor =
          MethodDescriptor
              .<GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.DataTransferService/GetMulticloudDataTransferConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetMulticloudDataTransferConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(MulticloudDataTransferConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateMulticloudDataTransferConfigRequest, Operation>
      createMulticloudDataTransferConfigMethodDescriptor =
          MethodDescriptor.<CreateMulticloudDataTransferConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.DataTransferService/CreateMulticloudDataTransferConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateMulticloudDataTransferConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateMulticloudDataTransferConfigRequest, Operation>
      updateMulticloudDataTransferConfigMethodDescriptor =
          MethodDescriptor.<UpdateMulticloudDataTransferConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.DataTransferService/UpdateMulticloudDataTransferConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateMulticloudDataTransferConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteMulticloudDataTransferConfigRequest, Operation>
      deleteMulticloudDataTransferConfigMethodDescriptor =
          MethodDescriptor.<DeleteMulticloudDataTransferConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.DataTransferService/DeleteMulticloudDataTransferConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteMulticloudDataTransferConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDestinationsRequest, ListDestinationsResponse>
      listDestinationsMethodDescriptor =
          MethodDescriptor.<ListDestinationsRequest, ListDestinationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.DataTransferService/ListDestinations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDestinationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDestinationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDestinationRequest, Destination>
      getDestinationMethodDescriptor =
          MethodDescriptor.<GetDestinationRequest, Destination>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.DataTransferService/GetDestination")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDestinationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Destination.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateDestinationRequest, Operation>
      createDestinationMethodDescriptor =
          MethodDescriptor.<CreateDestinationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.DataTransferService/CreateDestination")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDestinationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDestinationRequest, Operation>
      updateDestinationMethodDescriptor =
          MethodDescriptor.<UpdateDestinationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.DataTransferService/UpdateDestination")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDestinationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDestinationRequest, Operation>
      deleteDestinationMethodDescriptor =
          MethodDescriptor.<DeleteDestinationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.DataTransferService/DeleteDestination")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDestinationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetMulticloudDataTransferSupportedServiceRequest, MulticloudDataTransferSupportedService>
      getMulticloudDataTransferSupportedServiceMethodDescriptor =
          MethodDescriptor
              .<GetMulticloudDataTransferSupportedServiceRequest,
                  MulticloudDataTransferSupportedService>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.DataTransferService/GetMulticloudDataTransferSupportedService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetMulticloudDataTransferSupportedServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      MulticloudDataTransferSupportedService.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse>
      listMulticloudDataTransferSupportedServicesMethodDescriptor =
          MethodDescriptor
              .<ListMulticloudDataTransferSupportedServicesRequest,
                  ListMulticloudDataTransferSupportedServicesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkconnectivity.v1.DataTransferService/ListMulticloudDataTransferSupportedServices")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListMulticloudDataTransferSupportedServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListMulticloudDataTransferSupportedServicesResponse.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<
          ListMulticloudDataTransferConfigsRequest, ListMulticloudDataTransferConfigsResponse>
      listMulticloudDataTransferConfigsCallable;
  private final UnaryCallable<
          ListMulticloudDataTransferConfigsRequest, ListMulticloudDataTransferConfigsPagedResponse>
      listMulticloudDataTransferConfigsPagedCallable;
  private final UnaryCallable<GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>
      getMulticloudDataTransferConfigCallable;
  private final UnaryCallable<CreateMulticloudDataTransferConfigRequest, Operation>
      createMulticloudDataTransferConfigCallable;
  private final OperationCallable<
          CreateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      createMulticloudDataTransferConfigOperationCallable;
  private final UnaryCallable<UpdateMulticloudDataTransferConfigRequest, Operation>
      updateMulticloudDataTransferConfigCallable;
  private final OperationCallable<
          UpdateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      updateMulticloudDataTransferConfigOperationCallable;
  private final UnaryCallable<DeleteMulticloudDataTransferConfigRequest, Operation>
      deleteMulticloudDataTransferConfigCallable;
  private final OperationCallable<
          DeleteMulticloudDataTransferConfigRequest, Empty, OperationMetadata>
      deleteMulticloudDataTransferConfigOperationCallable;
  private final UnaryCallable<ListDestinationsRequest, ListDestinationsResponse>
      listDestinationsCallable;
  private final UnaryCallable<ListDestinationsRequest, ListDestinationsPagedResponse>
      listDestinationsPagedCallable;
  private final UnaryCallable<GetDestinationRequest, Destination> getDestinationCallable;
  private final UnaryCallable<CreateDestinationRequest, Operation> createDestinationCallable;
  private final OperationCallable<CreateDestinationRequest, Destination, OperationMetadata>
      createDestinationOperationCallable;
  private final UnaryCallable<UpdateDestinationRequest, Operation> updateDestinationCallable;
  private final OperationCallable<UpdateDestinationRequest, Destination, OperationMetadata>
      updateDestinationOperationCallable;
  private final UnaryCallable<DeleteDestinationRequest, Operation> deleteDestinationCallable;
  private final OperationCallable<DeleteDestinationRequest, Empty, OperationMetadata>
      deleteDestinationOperationCallable;
  private final UnaryCallable<
          GetMulticloudDataTransferSupportedServiceRequest, MulticloudDataTransferSupportedService>
      getMulticloudDataTransferSupportedServiceCallable;
  private final UnaryCallable<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse>
      listMulticloudDataTransferSupportedServicesCallable;
  private final UnaryCallable<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesPagedResponse>
      listMulticloudDataTransferSupportedServicesPagedCallable;
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

  public static final GrpcDataTransferServiceStub create(DataTransferServiceStubSettings settings)
      throws IOException {
    return new GrpcDataTransferServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataTransferServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataTransferServiceStub(
        DataTransferServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataTransferServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataTransferServiceStub(
        DataTransferServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataTransferServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataTransferServiceStub(
      DataTransferServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataTransferServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataTransferServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataTransferServiceStub(
      DataTransferServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<
            ListMulticloudDataTransferConfigsRequest, ListMulticloudDataTransferConfigsResponse>
        listMulticloudDataTransferConfigsTransportSettings =
            GrpcCallSettings
                .<ListMulticloudDataTransferConfigsRequest,
                    ListMulticloudDataTransferConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(listMulticloudDataTransferConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>
        getMulticloudDataTransferConfigTransportSettings =
            GrpcCallSettings
                .<GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>newBuilder()
                .setMethodDescriptor(getMulticloudDataTransferConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateMulticloudDataTransferConfigRequest, Operation>
        createMulticloudDataTransferConfigTransportSettings =
            GrpcCallSettings.<CreateMulticloudDataTransferConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(createMulticloudDataTransferConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateMulticloudDataTransferConfigRequest, Operation>
        updateMulticloudDataTransferConfigTransportSettings =
            GrpcCallSettings.<UpdateMulticloudDataTransferConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(updateMulticloudDataTransferConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "multicloud_data_transfer_config.name",
                          String.valueOf(request.getMulticloudDataTransferConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteMulticloudDataTransferConfigRequest, Operation>
        deleteMulticloudDataTransferConfigTransportSettings =
            GrpcCallSettings.<DeleteMulticloudDataTransferConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMulticloudDataTransferConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDestinationsRequest, ListDestinationsResponse>
        listDestinationsTransportSettings =
            GrpcCallSettings.<ListDestinationsRequest, ListDestinationsResponse>newBuilder()
                .setMethodDescriptor(listDestinationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDestinationRequest, Destination> getDestinationTransportSettings =
        GrpcCallSettings.<GetDestinationRequest, Destination>newBuilder()
            .setMethodDescriptor(getDestinationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDestinationRequest, Operation> createDestinationTransportSettings =
        GrpcCallSettings.<CreateDestinationRequest, Operation>newBuilder()
            .setMethodDescriptor(createDestinationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDestinationRequest, Operation> updateDestinationTransportSettings =
        GrpcCallSettings.<UpdateDestinationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDestinationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "destination.name", String.valueOf(request.getDestination().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDestinationRequest, Operation> deleteDestinationTransportSettings =
        GrpcCallSettings.<DeleteDestinationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDestinationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<
            GetMulticloudDataTransferSupportedServiceRequest,
            MulticloudDataTransferSupportedService>
        getMulticloudDataTransferSupportedServiceTransportSettings =
            GrpcCallSettings
                .<GetMulticloudDataTransferSupportedServiceRequest,
                    MulticloudDataTransferSupportedService>
                    newBuilder()
                .setMethodDescriptor(getMulticloudDataTransferSupportedServiceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListMulticloudDataTransferSupportedServicesRequest,
            ListMulticloudDataTransferSupportedServicesResponse>
        listMulticloudDataTransferSupportedServicesTransportSettings =
            GrpcCallSettings
                .<ListMulticloudDataTransferSupportedServicesRequest,
                    ListMulticloudDataTransferSupportedServicesResponse>
                    newBuilder()
                .setMethodDescriptor(listMulticloudDataTransferSupportedServicesMethodDescriptor)
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

    this.listMulticloudDataTransferConfigsCallable =
        callableFactory.createUnaryCallable(
            listMulticloudDataTransferConfigsTransportSettings,
            settings.listMulticloudDataTransferConfigsSettings(),
            clientContext);
    this.listMulticloudDataTransferConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listMulticloudDataTransferConfigsTransportSettings,
            settings.listMulticloudDataTransferConfigsSettings(),
            clientContext);
    this.getMulticloudDataTransferConfigCallable =
        callableFactory.createUnaryCallable(
            getMulticloudDataTransferConfigTransportSettings,
            settings.getMulticloudDataTransferConfigSettings(),
            clientContext);
    this.createMulticloudDataTransferConfigCallable =
        callableFactory.createUnaryCallable(
            createMulticloudDataTransferConfigTransportSettings,
            settings.createMulticloudDataTransferConfigSettings(),
            clientContext);
    this.createMulticloudDataTransferConfigOperationCallable =
        callableFactory.createOperationCallable(
            createMulticloudDataTransferConfigTransportSettings,
            settings.createMulticloudDataTransferConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMulticloudDataTransferConfigCallable =
        callableFactory.createUnaryCallable(
            updateMulticloudDataTransferConfigTransportSettings,
            settings.updateMulticloudDataTransferConfigSettings(),
            clientContext);
    this.updateMulticloudDataTransferConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateMulticloudDataTransferConfigTransportSettings,
            settings.updateMulticloudDataTransferConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMulticloudDataTransferConfigCallable =
        callableFactory.createUnaryCallable(
            deleteMulticloudDataTransferConfigTransportSettings,
            settings.deleteMulticloudDataTransferConfigSettings(),
            clientContext);
    this.deleteMulticloudDataTransferConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteMulticloudDataTransferConfigTransportSettings,
            settings.deleteMulticloudDataTransferConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.listDestinationsCallable =
        callableFactory.createUnaryCallable(
            listDestinationsTransportSettings, settings.listDestinationsSettings(), clientContext);
    this.listDestinationsPagedCallable =
        callableFactory.createPagedCallable(
            listDestinationsTransportSettings, settings.listDestinationsSettings(), clientContext);
    this.getDestinationCallable =
        callableFactory.createUnaryCallable(
            getDestinationTransportSettings, settings.getDestinationSettings(), clientContext);
    this.createDestinationCallable =
        callableFactory.createUnaryCallable(
            createDestinationTransportSettings,
            settings.createDestinationSettings(),
            clientContext);
    this.createDestinationOperationCallable =
        callableFactory.createOperationCallable(
            createDestinationTransportSettings,
            settings.createDestinationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDestinationCallable =
        callableFactory.createUnaryCallable(
            updateDestinationTransportSettings,
            settings.updateDestinationSettings(),
            clientContext);
    this.updateDestinationOperationCallable =
        callableFactory.createOperationCallable(
            updateDestinationTransportSettings,
            settings.updateDestinationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDestinationCallable =
        callableFactory.createUnaryCallable(
            deleteDestinationTransportSettings,
            settings.deleteDestinationSettings(),
            clientContext);
    this.deleteDestinationOperationCallable =
        callableFactory.createOperationCallable(
            deleteDestinationTransportSettings,
            settings.deleteDestinationOperationSettings(),
            clientContext,
            operationsStub);
    this.getMulticloudDataTransferSupportedServiceCallable =
        callableFactory.createUnaryCallable(
            getMulticloudDataTransferSupportedServiceTransportSettings,
            settings.getMulticloudDataTransferSupportedServiceSettings(),
            clientContext);
    this.listMulticloudDataTransferSupportedServicesCallable =
        callableFactory.createUnaryCallable(
            listMulticloudDataTransferSupportedServicesTransportSettings,
            settings.listMulticloudDataTransferSupportedServicesSettings(),
            clientContext);
    this.listMulticloudDataTransferSupportedServicesPagedCallable =
        callableFactory.createPagedCallable(
            listMulticloudDataTransferSupportedServicesTransportSettings,
            settings.listMulticloudDataTransferSupportedServicesSettings(),
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
  public UnaryCallable<
          ListMulticloudDataTransferConfigsRequest, ListMulticloudDataTransferConfigsResponse>
      listMulticloudDataTransferConfigsCallable() {
    return listMulticloudDataTransferConfigsCallable;
  }

  @Override
  public UnaryCallable<
          ListMulticloudDataTransferConfigsRequest, ListMulticloudDataTransferConfigsPagedResponse>
      listMulticloudDataTransferConfigsPagedCallable() {
    return listMulticloudDataTransferConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>
      getMulticloudDataTransferConfigCallable() {
    return getMulticloudDataTransferConfigCallable;
  }

  @Override
  public UnaryCallable<CreateMulticloudDataTransferConfigRequest, Operation>
      createMulticloudDataTransferConfigCallable() {
    return createMulticloudDataTransferConfigCallable;
  }

  @Override
  public OperationCallable<
          CreateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      createMulticloudDataTransferConfigOperationCallable() {
    return createMulticloudDataTransferConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMulticloudDataTransferConfigRequest, Operation>
      updateMulticloudDataTransferConfigCallable() {
    return updateMulticloudDataTransferConfigCallable;
  }

  @Override
  public OperationCallable<
          UpdateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      updateMulticloudDataTransferConfigOperationCallable() {
    return updateMulticloudDataTransferConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMulticloudDataTransferConfigRequest, Operation>
      deleteMulticloudDataTransferConfigCallable() {
    return deleteMulticloudDataTransferConfigCallable;
  }

  @Override
  public OperationCallable<DeleteMulticloudDataTransferConfigRequest, Empty, OperationMetadata>
      deleteMulticloudDataTransferConfigOperationCallable() {
    return deleteMulticloudDataTransferConfigOperationCallable;
  }

  @Override
  public UnaryCallable<ListDestinationsRequest, ListDestinationsResponse>
      listDestinationsCallable() {
    return listDestinationsCallable;
  }

  @Override
  public UnaryCallable<ListDestinationsRequest, ListDestinationsPagedResponse>
      listDestinationsPagedCallable() {
    return listDestinationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDestinationRequest, Destination> getDestinationCallable() {
    return getDestinationCallable;
  }

  @Override
  public UnaryCallable<CreateDestinationRequest, Operation> createDestinationCallable() {
    return createDestinationCallable;
  }

  @Override
  public OperationCallable<CreateDestinationRequest, Destination, OperationMetadata>
      createDestinationOperationCallable() {
    return createDestinationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDestinationRequest, Operation> updateDestinationCallable() {
    return updateDestinationCallable;
  }

  @Override
  public OperationCallable<UpdateDestinationRequest, Destination, OperationMetadata>
      updateDestinationOperationCallable() {
    return updateDestinationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDestinationRequest, Operation> deleteDestinationCallable() {
    return deleteDestinationCallable;
  }

  @Override
  public OperationCallable<DeleteDestinationRequest, Empty, OperationMetadata>
      deleteDestinationOperationCallable() {
    return deleteDestinationOperationCallable;
  }

  @Override
  public UnaryCallable<
          GetMulticloudDataTransferSupportedServiceRequest, MulticloudDataTransferSupportedService>
      getMulticloudDataTransferSupportedServiceCallable() {
    return getMulticloudDataTransferSupportedServiceCallable;
  }

  @Override
  public UnaryCallable<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse>
      listMulticloudDataTransferSupportedServicesCallable() {
    return listMulticloudDataTransferSupportedServicesCallable;
  }

  @Override
  public UnaryCallable<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesPagedResponse>
      listMulticloudDataTransferSupportedServicesPagedCallable() {
    return listMulticloudDataTransferSupportedServicesPagedCallable;
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
