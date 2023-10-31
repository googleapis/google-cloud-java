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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListFeatureGroupsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListFeaturesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest;
import com.google.cloud.aiplatform.v1beta1.CreateRegistryFeatureOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.Feature;
import com.google.cloud.aiplatform.v1beta1.FeatureGroup;
import com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest;
import com.google.cloud.aiplatform.v1beta1.GetFeatureRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse;
import com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the FeatureRegistryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcFeatureRegistryServiceStub extends FeatureRegistryServiceStub {
  private static final MethodDescriptor<CreateFeatureGroupRequest, Operation>
      createFeatureGroupMethodDescriptor =
          MethodDescriptor.<CreateFeatureGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeatureRegistryService/CreateFeatureGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFeatureGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFeatureGroupRequest, FeatureGroup>
      getFeatureGroupMethodDescriptor =
          MethodDescriptor.<GetFeatureGroupRequest, FeatureGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeatureRegistryService/GetFeatureGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFeatureGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FeatureGroup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListFeatureGroupsRequest, ListFeatureGroupsResponse>
      listFeatureGroupsMethodDescriptor =
          MethodDescriptor.<ListFeatureGroupsRequest, ListFeatureGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeatureRegistryService/ListFeatureGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFeatureGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFeatureGroupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFeatureGroupRequest, Operation>
      updateFeatureGroupMethodDescriptor =
          MethodDescriptor.<UpdateFeatureGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeatureRegistryService/UpdateFeatureGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFeatureGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteFeatureGroupRequest, Operation>
      deleteFeatureGroupMethodDescriptor =
          MethodDescriptor.<DeleteFeatureGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeatureRegistryService/DeleteFeatureGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFeatureGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFeatureRequest, Operation>
      createFeatureMethodDescriptor =
          MethodDescriptor.<CreateFeatureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeatureRegistryService/CreateFeature")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFeatureRequest, Feature> getFeatureMethodDescriptor =
      MethodDescriptor.<GetFeatureRequest, Feature>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.FeatureRegistryService/GetFeature")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFeatureRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Feature.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListFeaturesRequest, ListFeaturesResponse>
      listFeaturesMethodDescriptor =
          MethodDescriptor.<ListFeaturesRequest, ListFeaturesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeatureRegistryService/ListFeatures")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFeaturesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFeaturesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFeatureRequest, Operation>
      updateFeatureMethodDescriptor =
          MethodDescriptor.<UpdateFeatureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeatureRegistryService/UpdateFeature")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFeatureRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteFeatureRequest, Operation>
      deleteFeatureMethodDescriptor =
          MethodDescriptor.<DeleteFeatureRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeatureRegistryService/DeleteFeature")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFeatureRequest.getDefaultInstance()))
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

  private final UnaryCallable<CreateFeatureGroupRequest, Operation> createFeatureGroupCallable;
  private final OperationCallable<
          CreateFeatureGroupRequest, FeatureGroup, CreateFeatureGroupOperationMetadata>
      createFeatureGroupOperationCallable;
  private final UnaryCallable<GetFeatureGroupRequest, FeatureGroup> getFeatureGroupCallable;
  private final UnaryCallable<ListFeatureGroupsRequest, ListFeatureGroupsResponse>
      listFeatureGroupsCallable;
  private final UnaryCallable<ListFeatureGroupsRequest, ListFeatureGroupsPagedResponse>
      listFeatureGroupsPagedCallable;
  private final UnaryCallable<UpdateFeatureGroupRequest, Operation> updateFeatureGroupCallable;
  private final OperationCallable<
          UpdateFeatureGroupRequest, FeatureGroup, UpdateFeatureGroupOperationMetadata>
      updateFeatureGroupOperationCallable;
  private final UnaryCallable<DeleteFeatureGroupRequest, Operation> deleteFeatureGroupCallable;
  private final OperationCallable<DeleteFeatureGroupRequest, Empty, DeleteOperationMetadata>
      deleteFeatureGroupOperationCallable;
  private final UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable;
  private final OperationCallable<
          CreateFeatureRequest, Feature, CreateRegistryFeatureOperationMetadata>
      createFeatureOperationCallable;
  private final UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable;
  private final UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable;
  private final UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse>
      listFeaturesPagedCallable;
  private final UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable;
  private final OperationCallable<UpdateFeatureRequest, Feature, UpdateFeatureOperationMetadata>
      updateFeatureOperationCallable;
  private final UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable;
  private final OperationCallable<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOperationCallable;
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

  public static final GrpcFeatureRegistryServiceStub create(
      FeatureRegistryServiceStubSettings settings) throws IOException {
    return new GrpcFeatureRegistryServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFeatureRegistryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcFeatureRegistryServiceStub(
        FeatureRegistryServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFeatureRegistryServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFeatureRegistryServiceStub(
        FeatureRegistryServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFeatureRegistryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcFeatureRegistryServiceStub(
      FeatureRegistryServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcFeatureRegistryServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFeatureRegistryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcFeatureRegistryServiceStub(
      FeatureRegistryServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateFeatureGroupRequest, Operation> createFeatureGroupTransportSettings =
        GrpcCallSettings.<CreateFeatureGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(createFeatureGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetFeatureGroupRequest, FeatureGroup> getFeatureGroupTransportSettings =
        GrpcCallSettings.<GetFeatureGroupRequest, FeatureGroup>newBuilder()
            .setMethodDescriptor(getFeatureGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListFeatureGroupsRequest, ListFeatureGroupsResponse>
        listFeatureGroupsTransportSettings =
            GrpcCallSettings.<ListFeatureGroupsRequest, ListFeatureGroupsResponse>newBuilder()
                .setMethodDescriptor(listFeatureGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateFeatureGroupRequest, Operation> updateFeatureGroupTransportSettings =
        GrpcCallSettings.<UpdateFeatureGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFeatureGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "feature_group.name", String.valueOf(request.getFeatureGroup().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteFeatureGroupRequest, Operation> deleteFeatureGroupTransportSettings =
        GrpcCallSettings.<DeleteFeatureGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFeatureGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateFeatureRequest, Operation> createFeatureTransportSettings =
        GrpcCallSettings.<CreateFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(createFeatureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetFeatureRequest, Feature> getFeatureTransportSettings =
        GrpcCallSettings.<GetFeatureRequest, Feature>newBuilder()
            .setMethodDescriptor(getFeatureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListFeaturesRequest, ListFeaturesResponse> listFeaturesTransportSettings =
        GrpcCallSettings.<ListFeaturesRequest, ListFeaturesResponse>newBuilder()
            .setMethodDescriptor(listFeaturesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateFeatureRequest, Operation> updateFeatureTransportSettings =
        GrpcCallSettings.<UpdateFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFeatureMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("feature.name", String.valueOf(request.getFeature().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteFeatureRequest, Operation> deleteFeatureTransportSettings =
        GrpcCallSettings.<DeleteFeatureRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFeatureMethodDescriptor)
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

    this.createFeatureGroupCallable =
        callableFactory.createUnaryCallable(
            createFeatureGroupTransportSettings,
            settings.createFeatureGroupSettings(),
            clientContext);
    this.createFeatureGroupOperationCallable =
        callableFactory.createOperationCallable(
            createFeatureGroupTransportSettings,
            settings.createFeatureGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.getFeatureGroupCallable =
        callableFactory.createUnaryCallable(
            getFeatureGroupTransportSettings, settings.getFeatureGroupSettings(), clientContext);
    this.listFeatureGroupsCallable =
        callableFactory.createUnaryCallable(
            listFeatureGroupsTransportSettings,
            settings.listFeatureGroupsSettings(),
            clientContext);
    this.listFeatureGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listFeatureGroupsTransportSettings,
            settings.listFeatureGroupsSettings(),
            clientContext);
    this.updateFeatureGroupCallable =
        callableFactory.createUnaryCallable(
            updateFeatureGroupTransportSettings,
            settings.updateFeatureGroupSettings(),
            clientContext);
    this.updateFeatureGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateFeatureGroupTransportSettings,
            settings.updateFeatureGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFeatureGroupCallable =
        callableFactory.createUnaryCallable(
            deleteFeatureGroupTransportSettings,
            settings.deleteFeatureGroupSettings(),
            clientContext);
    this.deleteFeatureGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteFeatureGroupTransportSettings,
            settings.deleteFeatureGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.createFeatureCallable =
        callableFactory.createUnaryCallable(
            createFeatureTransportSettings, settings.createFeatureSettings(), clientContext);
    this.createFeatureOperationCallable =
        callableFactory.createOperationCallable(
            createFeatureTransportSettings,
            settings.createFeatureOperationSettings(),
            clientContext,
            operationsStub);
    this.getFeatureCallable =
        callableFactory.createUnaryCallable(
            getFeatureTransportSettings, settings.getFeatureSettings(), clientContext);
    this.listFeaturesCallable =
        callableFactory.createUnaryCallable(
            listFeaturesTransportSettings, settings.listFeaturesSettings(), clientContext);
    this.listFeaturesPagedCallable =
        callableFactory.createPagedCallable(
            listFeaturesTransportSettings, settings.listFeaturesSettings(), clientContext);
    this.updateFeatureCallable =
        callableFactory.createUnaryCallable(
            updateFeatureTransportSettings, settings.updateFeatureSettings(), clientContext);
    this.updateFeatureOperationCallable =
        callableFactory.createOperationCallable(
            updateFeatureTransportSettings,
            settings.updateFeatureOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFeatureCallable =
        callableFactory.createUnaryCallable(
            deleteFeatureTransportSettings, settings.deleteFeatureSettings(), clientContext);
    this.deleteFeatureOperationCallable =
        callableFactory.createOperationCallable(
            deleteFeatureTransportSettings,
            settings.deleteFeatureOperationSettings(),
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
  public UnaryCallable<CreateFeatureGroupRequest, Operation> createFeatureGroupCallable() {
    return createFeatureGroupCallable;
  }

  @Override
  public OperationCallable<
          CreateFeatureGroupRequest, FeatureGroup, CreateFeatureGroupOperationMetadata>
      createFeatureGroupOperationCallable() {
    return createFeatureGroupOperationCallable;
  }

  @Override
  public UnaryCallable<GetFeatureGroupRequest, FeatureGroup> getFeatureGroupCallable() {
    return getFeatureGroupCallable;
  }

  @Override
  public UnaryCallable<ListFeatureGroupsRequest, ListFeatureGroupsResponse>
      listFeatureGroupsCallable() {
    return listFeatureGroupsCallable;
  }

  @Override
  public UnaryCallable<ListFeatureGroupsRequest, ListFeatureGroupsPagedResponse>
      listFeatureGroupsPagedCallable() {
    return listFeatureGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateFeatureGroupRequest, Operation> updateFeatureGroupCallable() {
    return updateFeatureGroupCallable;
  }

  @Override
  public OperationCallable<
          UpdateFeatureGroupRequest, FeatureGroup, UpdateFeatureGroupOperationMetadata>
      updateFeatureGroupOperationCallable() {
    return updateFeatureGroupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFeatureGroupRequest, Operation> deleteFeatureGroupCallable() {
    return deleteFeatureGroupCallable;
  }

  @Override
  public OperationCallable<DeleteFeatureGroupRequest, Empty, DeleteOperationMetadata>
      deleteFeatureGroupOperationCallable() {
    return deleteFeatureGroupOperationCallable;
  }

  @Override
  public UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable() {
    return createFeatureCallable;
  }

  @Override
  public OperationCallable<CreateFeatureRequest, Feature, CreateRegistryFeatureOperationMetadata>
      createFeatureOperationCallable() {
    return createFeatureOperationCallable;
  }

  @Override
  public UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable() {
    return getFeatureCallable;
  }

  @Override
  public UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable() {
    return listFeaturesCallable;
  }

  @Override
  public UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse> listFeaturesPagedCallable() {
    return listFeaturesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable() {
    return updateFeatureCallable;
  }

  @Override
  public OperationCallable<UpdateFeatureRequest, Feature, UpdateFeatureOperationMetadata>
      updateFeatureOperationCallable() {
    return updateFeatureOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable() {
    return deleteFeatureCallable;
  }

  @Override
  public OperationCallable<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOperationCallable() {
    return deleteFeatureOperationCallable;
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
