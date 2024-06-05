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

package com.google.cloud.networkservices.v1.stub;

import static com.google.cloud.networkservices.v1.DepServiceClient.ListLbRouteExtensionsPagedResponse;
import static com.google.cloud.networkservices.v1.DepServiceClient.ListLbTrafficExtensionsPagedResponse;
import static com.google.cloud.networkservices.v1.DepServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest;
import com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest;
import com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest;
import com.google.cloud.networkservices.v1.LbRouteExtension;
import com.google.cloud.networkservices.v1.LbTrafficExtension;
import com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest;
import com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse;
import com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest;
import com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse;
import com.google.cloud.networkservices.v1.OperationMetadata;
import com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest;
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
 * gRPC stub implementation for the DepService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDepServiceStub extends DepServiceStub {
  private static final MethodDescriptor<
          ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>
      listLbTrafficExtensionsMethodDescriptor =
          MethodDescriptor
              .<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/ListLbTrafficExtensions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLbTrafficExtensionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLbTrafficExtensionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLbTrafficExtensionRequest, LbTrafficExtension>
      getLbTrafficExtensionMethodDescriptor =
          MethodDescriptor.<GetLbTrafficExtensionRequest, LbTrafficExtension>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.DepService/GetLbTrafficExtension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLbTrafficExtensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LbTrafficExtension.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateLbTrafficExtensionRequest, Operation>
      createLbTrafficExtensionMethodDescriptor =
          MethodDescriptor.<CreateLbTrafficExtensionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/CreateLbTrafficExtension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateLbTrafficExtensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateLbTrafficExtensionRequest, Operation>
      updateLbTrafficExtensionMethodDescriptor =
          MethodDescriptor.<UpdateLbTrafficExtensionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/UpdateLbTrafficExtension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateLbTrafficExtensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteLbTrafficExtensionRequest, Operation>
      deleteLbTrafficExtensionMethodDescriptor =
          MethodDescriptor.<DeleteLbTrafficExtensionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/DeleteLbTrafficExtension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteLbTrafficExtensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>
      listLbRouteExtensionsMethodDescriptor =
          MethodDescriptor.<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.DepService/ListLbRouteExtensions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLbRouteExtensionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLbRouteExtensionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLbRouteExtensionRequest, LbRouteExtension>
      getLbRouteExtensionMethodDescriptor =
          MethodDescriptor.<GetLbRouteExtensionRequest, LbRouteExtension>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networkservices.v1.DepService/GetLbRouteExtension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLbRouteExtensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LbRouteExtension.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateLbRouteExtensionRequest, Operation>
      createLbRouteExtensionMethodDescriptor =
          MethodDescriptor.<CreateLbRouteExtensionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/CreateLbRouteExtension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateLbRouteExtensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateLbRouteExtensionRequest, Operation>
      updateLbRouteExtensionMethodDescriptor =
          MethodDescriptor.<UpdateLbRouteExtensionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/UpdateLbRouteExtension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateLbRouteExtensionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteLbRouteExtensionRequest, Operation>
      deleteLbRouteExtensionMethodDescriptor =
          MethodDescriptor.<DeleteLbRouteExtensionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/DeleteLbRouteExtension")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteLbRouteExtensionRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>
      listLbTrafficExtensionsCallable;
  private final UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsPagedResponse>
      listLbTrafficExtensionsPagedCallable;
  private final UnaryCallable<GetLbTrafficExtensionRequest, LbTrafficExtension>
      getLbTrafficExtensionCallable;
  private final UnaryCallable<CreateLbTrafficExtensionRequest, Operation>
      createLbTrafficExtensionCallable;
  private final OperationCallable<
          CreateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      createLbTrafficExtensionOperationCallable;
  private final UnaryCallable<UpdateLbTrafficExtensionRequest, Operation>
      updateLbTrafficExtensionCallable;
  private final OperationCallable<
          UpdateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      updateLbTrafficExtensionOperationCallable;
  private final UnaryCallable<DeleteLbTrafficExtensionRequest, Operation>
      deleteLbTrafficExtensionCallable;
  private final OperationCallable<DeleteLbTrafficExtensionRequest, Empty, OperationMetadata>
      deleteLbTrafficExtensionOperationCallable;
  private final UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>
      listLbRouteExtensionsCallable;
  private final UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsPagedResponse>
      listLbRouteExtensionsPagedCallable;
  private final UnaryCallable<GetLbRouteExtensionRequest, LbRouteExtension>
      getLbRouteExtensionCallable;
  private final UnaryCallable<CreateLbRouteExtensionRequest, Operation>
      createLbRouteExtensionCallable;
  private final OperationCallable<
          CreateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      createLbRouteExtensionOperationCallable;
  private final UnaryCallable<UpdateLbRouteExtensionRequest, Operation>
      updateLbRouteExtensionCallable;
  private final OperationCallable<
          UpdateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      updateLbRouteExtensionOperationCallable;
  private final UnaryCallable<DeleteLbRouteExtensionRequest, Operation>
      deleteLbRouteExtensionCallable;
  private final OperationCallable<DeleteLbRouteExtensionRequest, Empty, OperationMetadata>
      deleteLbRouteExtensionOperationCallable;
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

  public static final GrpcDepServiceStub create(DepServiceStubSettings settings)
      throws IOException {
    return new GrpcDepServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDepServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcDepServiceStub(DepServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDepServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDepServiceStub(
        DepServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDepServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDepServiceStub(DepServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDepServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDepServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDepServiceStub(
      DepServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>
        listLbTrafficExtensionsTransportSettings =
            GrpcCallSettings
                .<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>newBuilder()
                .setMethodDescriptor(listLbTrafficExtensionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetLbTrafficExtensionRequest, LbTrafficExtension>
        getLbTrafficExtensionTransportSettings =
            GrpcCallSettings.<GetLbTrafficExtensionRequest, LbTrafficExtension>newBuilder()
                .setMethodDescriptor(getLbTrafficExtensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateLbTrafficExtensionRequest, Operation>
        createLbTrafficExtensionTransportSettings =
            GrpcCallSettings.<CreateLbTrafficExtensionRequest, Operation>newBuilder()
                .setMethodDescriptor(createLbTrafficExtensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateLbTrafficExtensionRequest, Operation>
        updateLbTrafficExtensionTransportSettings =
            GrpcCallSettings.<UpdateLbTrafficExtensionRequest, Operation>newBuilder()
                .setMethodDescriptor(updateLbTrafficExtensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "lb_traffic_extension.name",
                          String.valueOf(request.getLbTrafficExtension().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteLbTrafficExtensionRequest, Operation>
        deleteLbTrafficExtensionTransportSettings =
            GrpcCallSettings.<DeleteLbTrafficExtensionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteLbTrafficExtensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>
        listLbRouteExtensionsTransportSettings =
            GrpcCallSettings
                .<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>newBuilder()
                .setMethodDescriptor(listLbRouteExtensionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetLbRouteExtensionRequest, LbRouteExtension>
        getLbRouteExtensionTransportSettings =
            GrpcCallSettings.<GetLbRouteExtensionRequest, LbRouteExtension>newBuilder()
                .setMethodDescriptor(getLbRouteExtensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateLbRouteExtensionRequest, Operation>
        createLbRouteExtensionTransportSettings =
            GrpcCallSettings.<CreateLbRouteExtensionRequest, Operation>newBuilder()
                .setMethodDescriptor(createLbRouteExtensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateLbRouteExtensionRequest, Operation>
        updateLbRouteExtensionTransportSettings =
            GrpcCallSettings.<UpdateLbRouteExtensionRequest, Operation>newBuilder()
                .setMethodDescriptor(updateLbRouteExtensionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "lb_route_extension.name",
                          String.valueOf(request.getLbRouteExtension().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteLbRouteExtensionRequest, Operation>
        deleteLbRouteExtensionTransportSettings =
            GrpcCallSettings.<DeleteLbRouteExtensionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteLbRouteExtensionMethodDescriptor)
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

    this.listLbTrafficExtensionsCallable =
        callableFactory.createUnaryCallable(
            listLbTrafficExtensionsTransportSettings,
            settings.listLbTrafficExtensionsSettings(),
            clientContext);
    this.listLbTrafficExtensionsPagedCallable =
        callableFactory.createPagedCallable(
            listLbTrafficExtensionsTransportSettings,
            settings.listLbTrafficExtensionsSettings(),
            clientContext);
    this.getLbTrafficExtensionCallable =
        callableFactory.createUnaryCallable(
            getLbTrafficExtensionTransportSettings,
            settings.getLbTrafficExtensionSettings(),
            clientContext);
    this.createLbTrafficExtensionCallable =
        callableFactory.createUnaryCallable(
            createLbTrafficExtensionTransportSettings,
            settings.createLbTrafficExtensionSettings(),
            clientContext);
    this.createLbTrafficExtensionOperationCallable =
        callableFactory.createOperationCallable(
            createLbTrafficExtensionTransportSettings,
            settings.createLbTrafficExtensionOperationSettings(),
            clientContext,
            operationsStub);
    this.updateLbTrafficExtensionCallable =
        callableFactory.createUnaryCallable(
            updateLbTrafficExtensionTransportSettings,
            settings.updateLbTrafficExtensionSettings(),
            clientContext);
    this.updateLbTrafficExtensionOperationCallable =
        callableFactory.createOperationCallable(
            updateLbTrafficExtensionTransportSettings,
            settings.updateLbTrafficExtensionOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteLbTrafficExtensionCallable =
        callableFactory.createUnaryCallable(
            deleteLbTrafficExtensionTransportSettings,
            settings.deleteLbTrafficExtensionSettings(),
            clientContext);
    this.deleteLbTrafficExtensionOperationCallable =
        callableFactory.createOperationCallable(
            deleteLbTrafficExtensionTransportSettings,
            settings.deleteLbTrafficExtensionOperationSettings(),
            clientContext,
            operationsStub);
    this.listLbRouteExtensionsCallable =
        callableFactory.createUnaryCallable(
            listLbRouteExtensionsTransportSettings,
            settings.listLbRouteExtensionsSettings(),
            clientContext);
    this.listLbRouteExtensionsPagedCallable =
        callableFactory.createPagedCallable(
            listLbRouteExtensionsTransportSettings,
            settings.listLbRouteExtensionsSettings(),
            clientContext);
    this.getLbRouteExtensionCallable =
        callableFactory.createUnaryCallable(
            getLbRouteExtensionTransportSettings,
            settings.getLbRouteExtensionSettings(),
            clientContext);
    this.createLbRouteExtensionCallable =
        callableFactory.createUnaryCallable(
            createLbRouteExtensionTransportSettings,
            settings.createLbRouteExtensionSettings(),
            clientContext);
    this.createLbRouteExtensionOperationCallable =
        callableFactory.createOperationCallable(
            createLbRouteExtensionTransportSettings,
            settings.createLbRouteExtensionOperationSettings(),
            clientContext,
            operationsStub);
    this.updateLbRouteExtensionCallable =
        callableFactory.createUnaryCallable(
            updateLbRouteExtensionTransportSettings,
            settings.updateLbRouteExtensionSettings(),
            clientContext);
    this.updateLbRouteExtensionOperationCallable =
        callableFactory.createOperationCallable(
            updateLbRouteExtensionTransportSettings,
            settings.updateLbRouteExtensionOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteLbRouteExtensionCallable =
        callableFactory.createUnaryCallable(
            deleteLbRouteExtensionTransportSettings,
            settings.deleteLbRouteExtensionSettings(),
            clientContext);
    this.deleteLbRouteExtensionOperationCallable =
        callableFactory.createOperationCallable(
            deleteLbRouteExtensionTransportSettings,
            settings.deleteLbRouteExtensionOperationSettings(),
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
  public UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>
      listLbTrafficExtensionsCallable() {
    return listLbTrafficExtensionsCallable;
  }

  @Override
  public UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsPagedResponse>
      listLbTrafficExtensionsPagedCallable() {
    return listLbTrafficExtensionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLbTrafficExtensionRequest, LbTrafficExtension>
      getLbTrafficExtensionCallable() {
    return getLbTrafficExtensionCallable;
  }

  @Override
  public UnaryCallable<CreateLbTrafficExtensionRequest, Operation>
      createLbTrafficExtensionCallable() {
    return createLbTrafficExtensionCallable;
  }

  @Override
  public OperationCallable<CreateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      createLbTrafficExtensionOperationCallable() {
    return createLbTrafficExtensionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateLbTrafficExtensionRequest, Operation>
      updateLbTrafficExtensionCallable() {
    return updateLbTrafficExtensionCallable;
  }

  @Override
  public OperationCallable<UpdateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      updateLbTrafficExtensionOperationCallable() {
    return updateLbTrafficExtensionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteLbTrafficExtensionRequest, Operation>
      deleteLbTrafficExtensionCallable() {
    return deleteLbTrafficExtensionCallable;
  }

  @Override
  public OperationCallable<DeleteLbTrafficExtensionRequest, Empty, OperationMetadata>
      deleteLbTrafficExtensionOperationCallable() {
    return deleteLbTrafficExtensionOperationCallable;
  }

  @Override
  public UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>
      listLbRouteExtensionsCallable() {
    return listLbRouteExtensionsCallable;
  }

  @Override
  public UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsPagedResponse>
      listLbRouteExtensionsPagedCallable() {
    return listLbRouteExtensionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLbRouteExtensionRequest, LbRouteExtension> getLbRouteExtensionCallable() {
    return getLbRouteExtensionCallable;
  }

  @Override
  public UnaryCallable<CreateLbRouteExtensionRequest, Operation> createLbRouteExtensionCallable() {
    return createLbRouteExtensionCallable;
  }

  @Override
  public OperationCallable<CreateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      createLbRouteExtensionOperationCallable() {
    return createLbRouteExtensionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateLbRouteExtensionRequest, Operation> updateLbRouteExtensionCallable() {
    return updateLbRouteExtensionCallable;
  }

  @Override
  public OperationCallable<UpdateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      updateLbRouteExtensionOperationCallable() {
    return updateLbRouteExtensionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteLbRouteExtensionRequest, Operation> deleteLbRouteExtensionCallable() {
    return deleteLbRouteExtensionCallable;
  }

  @Override
  public OperationCallable<DeleteLbRouteExtensionRequest, Empty, OperationMetadata>
      deleteLbRouteExtensionOperationCallable() {
    return deleteLbRouteExtensionOperationCallable;
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
