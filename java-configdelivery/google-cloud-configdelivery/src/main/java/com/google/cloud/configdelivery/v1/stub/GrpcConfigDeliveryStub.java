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

package com.google.cloud.configdelivery.v1.stub;

import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListFleetPackagesPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListLocationsPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListReleasesPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListResourceBundlesPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListRolloutsPagedResponse;
import static com.google.cloud.configdelivery.v1.ConfigDeliveryClient.ListVariantsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.configdelivery.v1.AbortRolloutRequest;
import com.google.cloud.configdelivery.v1.CreateFleetPackageRequest;
import com.google.cloud.configdelivery.v1.CreateReleaseRequest;
import com.google.cloud.configdelivery.v1.CreateResourceBundleRequest;
import com.google.cloud.configdelivery.v1.CreateVariantRequest;
import com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest;
import com.google.cloud.configdelivery.v1.DeleteReleaseRequest;
import com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest;
import com.google.cloud.configdelivery.v1.DeleteVariantRequest;
import com.google.cloud.configdelivery.v1.FleetPackage;
import com.google.cloud.configdelivery.v1.GetFleetPackageRequest;
import com.google.cloud.configdelivery.v1.GetReleaseRequest;
import com.google.cloud.configdelivery.v1.GetResourceBundleRequest;
import com.google.cloud.configdelivery.v1.GetRolloutRequest;
import com.google.cloud.configdelivery.v1.GetVariantRequest;
import com.google.cloud.configdelivery.v1.ListFleetPackagesRequest;
import com.google.cloud.configdelivery.v1.ListFleetPackagesResponse;
import com.google.cloud.configdelivery.v1.ListReleasesRequest;
import com.google.cloud.configdelivery.v1.ListReleasesResponse;
import com.google.cloud.configdelivery.v1.ListResourceBundlesRequest;
import com.google.cloud.configdelivery.v1.ListResourceBundlesResponse;
import com.google.cloud.configdelivery.v1.ListRolloutsRequest;
import com.google.cloud.configdelivery.v1.ListRolloutsResponse;
import com.google.cloud.configdelivery.v1.ListVariantsRequest;
import com.google.cloud.configdelivery.v1.ListVariantsResponse;
import com.google.cloud.configdelivery.v1.OperationMetadata;
import com.google.cloud.configdelivery.v1.Release;
import com.google.cloud.configdelivery.v1.ResourceBundle;
import com.google.cloud.configdelivery.v1.ResumeRolloutRequest;
import com.google.cloud.configdelivery.v1.Rollout;
import com.google.cloud.configdelivery.v1.SuspendRolloutRequest;
import com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest;
import com.google.cloud.configdelivery.v1.UpdateReleaseRequest;
import com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest;
import com.google.cloud.configdelivery.v1.UpdateVariantRequest;
import com.google.cloud.configdelivery.v1.Variant;
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
 * gRPC stub implementation for the ConfigDelivery service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcConfigDeliveryStub extends ConfigDeliveryStub {
  private static final MethodDescriptor<ListResourceBundlesRequest, ListResourceBundlesResponse>
      listResourceBundlesMethodDescriptor =
          MethodDescriptor.<ListResourceBundlesRequest, ListResourceBundlesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.configdelivery.v1.ConfigDelivery/ListResourceBundles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListResourceBundlesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListResourceBundlesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetResourceBundleRequest, ResourceBundle>
      getResourceBundleMethodDescriptor =
          MethodDescriptor.<GetResourceBundleRequest, ResourceBundle>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/GetResourceBundle")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetResourceBundleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ResourceBundle.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateResourceBundleRequest, Operation>
      createResourceBundleMethodDescriptor =
          MethodDescriptor.<CreateResourceBundleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.configdelivery.v1.ConfigDelivery/CreateResourceBundle")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateResourceBundleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateResourceBundleRequest, Operation>
      updateResourceBundleMethodDescriptor =
          MethodDescriptor.<UpdateResourceBundleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.configdelivery.v1.ConfigDelivery/UpdateResourceBundle")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateResourceBundleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteResourceBundleRequest, Operation>
      deleteResourceBundleMethodDescriptor =
          MethodDescriptor.<DeleteResourceBundleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.configdelivery.v1.ConfigDelivery/DeleteResourceBundle")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteResourceBundleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListFleetPackagesRequest, ListFleetPackagesResponse>
      listFleetPackagesMethodDescriptor =
          MethodDescriptor.<ListFleetPackagesRequest, ListFleetPackagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/ListFleetPackages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFleetPackagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFleetPackagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFleetPackageRequest, FleetPackage>
      getFleetPackageMethodDescriptor =
          MethodDescriptor.<GetFleetPackageRequest, FleetPackage>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/GetFleetPackage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFleetPackageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FleetPackage.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFleetPackageRequest, Operation>
      createFleetPackageMethodDescriptor =
          MethodDescriptor.<CreateFleetPackageRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/CreateFleetPackage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFleetPackageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFleetPackageRequest, Operation>
      updateFleetPackageMethodDescriptor =
          MethodDescriptor.<UpdateFleetPackageRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/UpdateFleetPackage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFleetPackageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteFleetPackageRequest, Operation>
      deleteFleetPackageMethodDescriptor =
          MethodDescriptor.<DeleteFleetPackageRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/DeleteFleetPackage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFleetPackageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReleasesRequest, ListReleasesResponse>
      listReleasesMethodDescriptor =
          MethodDescriptor.<ListReleasesRequest, ListReleasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/ListReleases")
              .setRequestMarshaller(ProtoUtils.marshaller(ListReleasesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReleasesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetReleaseRequest, Release> getReleaseMethodDescriptor =
      MethodDescriptor.<GetReleaseRequest, Release>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/GetRelease")
          .setRequestMarshaller(ProtoUtils.marshaller(GetReleaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Release.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateReleaseRequest, Operation>
      createReleaseMethodDescriptor =
          MethodDescriptor.<CreateReleaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/CreateRelease")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReleaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateReleaseRequest, Operation>
      updateReleaseMethodDescriptor =
          MethodDescriptor.<UpdateReleaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/UpdateRelease")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateReleaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteReleaseRequest, Operation>
      deleteReleaseMethodDescriptor =
          MethodDescriptor.<DeleteReleaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/DeleteRelease")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteReleaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListVariantsRequest, ListVariantsResponse>
      listVariantsMethodDescriptor =
          MethodDescriptor.<ListVariantsRequest, ListVariantsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/ListVariants")
              .setRequestMarshaller(ProtoUtils.marshaller(ListVariantsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVariantsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVariantRequest, Variant> getVariantMethodDescriptor =
      MethodDescriptor.<GetVariantRequest, Variant>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/GetVariant")
          .setRequestMarshaller(ProtoUtils.marshaller(GetVariantRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Variant.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateVariantRequest, Operation>
      createVariantMethodDescriptor =
          MethodDescriptor.<CreateVariantRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/CreateVariant")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateVariantRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateVariantRequest, Operation>
      updateVariantMethodDescriptor =
          MethodDescriptor.<UpdateVariantRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/UpdateVariant")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateVariantRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteVariantRequest, Operation>
      deleteVariantMethodDescriptor =
          MethodDescriptor.<DeleteVariantRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/DeleteVariant")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteVariantRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRolloutsRequest, ListRolloutsResponse>
      listRolloutsMethodDescriptor =
          MethodDescriptor.<ListRolloutsRequest, ListRolloutsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/ListRollouts")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRolloutsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRolloutsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRolloutRequest, Rollout> getRolloutMethodDescriptor =
      MethodDescriptor.<GetRolloutRequest, Rollout>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/GetRollout")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRolloutRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Rollout.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SuspendRolloutRequest, Operation>
      suspendRolloutMethodDescriptor =
          MethodDescriptor.<SuspendRolloutRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/SuspendRollout")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SuspendRolloutRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResumeRolloutRequest, Operation>
      resumeRolloutMethodDescriptor =
          MethodDescriptor.<ResumeRolloutRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/ResumeRollout")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResumeRolloutRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AbortRolloutRequest, Operation>
      abortRolloutMethodDescriptor =
          MethodDescriptor.<AbortRolloutRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.configdelivery.v1.ConfigDelivery/AbortRollout")
              .setRequestMarshaller(ProtoUtils.marshaller(AbortRolloutRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesResponse>
      listResourceBundlesCallable;
  private final UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesPagedResponse>
      listResourceBundlesPagedCallable;
  private final UnaryCallable<GetResourceBundleRequest, ResourceBundle> getResourceBundleCallable;
  private final UnaryCallable<CreateResourceBundleRequest, Operation> createResourceBundleCallable;
  private final OperationCallable<CreateResourceBundleRequest, ResourceBundle, OperationMetadata>
      createResourceBundleOperationCallable;
  private final UnaryCallable<UpdateResourceBundleRequest, Operation> updateResourceBundleCallable;
  private final OperationCallable<UpdateResourceBundleRequest, ResourceBundle, OperationMetadata>
      updateResourceBundleOperationCallable;
  private final UnaryCallable<DeleteResourceBundleRequest, Operation> deleteResourceBundleCallable;
  private final OperationCallable<DeleteResourceBundleRequest, Empty, OperationMetadata>
      deleteResourceBundleOperationCallable;
  private final UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesResponse>
      listFleetPackagesCallable;
  private final UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesPagedResponse>
      listFleetPackagesPagedCallable;
  private final UnaryCallable<GetFleetPackageRequest, FleetPackage> getFleetPackageCallable;
  private final UnaryCallable<CreateFleetPackageRequest, Operation> createFleetPackageCallable;
  private final OperationCallable<CreateFleetPackageRequest, FleetPackage, OperationMetadata>
      createFleetPackageOperationCallable;
  private final UnaryCallable<UpdateFleetPackageRequest, Operation> updateFleetPackageCallable;
  private final OperationCallable<UpdateFleetPackageRequest, FleetPackage, OperationMetadata>
      updateFleetPackageOperationCallable;
  private final UnaryCallable<DeleteFleetPackageRequest, Operation> deleteFleetPackageCallable;
  private final OperationCallable<DeleteFleetPackageRequest, Empty, OperationMetadata>
      deleteFleetPackageOperationCallable;
  private final UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable;
  private final UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse>
      listReleasesPagedCallable;
  private final UnaryCallable<GetReleaseRequest, Release> getReleaseCallable;
  private final UnaryCallable<CreateReleaseRequest, Operation> createReleaseCallable;
  private final OperationCallable<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationCallable;
  private final UnaryCallable<UpdateReleaseRequest, Operation> updateReleaseCallable;
  private final OperationCallable<UpdateReleaseRequest, Release, OperationMetadata>
      updateReleaseOperationCallable;
  private final UnaryCallable<DeleteReleaseRequest, Operation> deleteReleaseCallable;
  private final OperationCallable<DeleteReleaseRequest, Empty, OperationMetadata>
      deleteReleaseOperationCallable;
  private final UnaryCallable<ListVariantsRequest, ListVariantsResponse> listVariantsCallable;
  private final UnaryCallable<ListVariantsRequest, ListVariantsPagedResponse>
      listVariantsPagedCallable;
  private final UnaryCallable<GetVariantRequest, Variant> getVariantCallable;
  private final UnaryCallable<CreateVariantRequest, Operation> createVariantCallable;
  private final OperationCallable<CreateVariantRequest, Variant, OperationMetadata>
      createVariantOperationCallable;
  private final UnaryCallable<UpdateVariantRequest, Operation> updateVariantCallable;
  private final OperationCallable<UpdateVariantRequest, Variant, OperationMetadata>
      updateVariantOperationCallable;
  private final UnaryCallable<DeleteVariantRequest, Operation> deleteVariantCallable;
  private final OperationCallable<DeleteVariantRequest, Empty, OperationMetadata>
      deleteVariantOperationCallable;
  private final UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable;
  private final UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse>
      listRolloutsPagedCallable;
  private final UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable;
  private final UnaryCallable<SuspendRolloutRequest, Operation> suspendRolloutCallable;
  private final OperationCallable<SuspendRolloutRequest, Rollout, OperationMetadata>
      suspendRolloutOperationCallable;
  private final UnaryCallable<ResumeRolloutRequest, Operation> resumeRolloutCallable;
  private final OperationCallable<ResumeRolloutRequest, Rollout, OperationMetadata>
      resumeRolloutOperationCallable;
  private final UnaryCallable<AbortRolloutRequest, Operation> abortRolloutCallable;
  private final OperationCallable<AbortRolloutRequest, Rollout, OperationMetadata>
      abortRolloutOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConfigDeliveryStub create(ConfigDeliveryStubSettings settings)
      throws IOException {
    return new GrpcConfigDeliveryStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConfigDeliveryStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConfigDeliveryStub(
        ConfigDeliveryStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConfigDeliveryStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConfigDeliveryStub(
        ConfigDeliveryStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConfigDeliveryStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcConfigDeliveryStub(ConfigDeliveryStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcConfigDeliveryCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConfigDeliveryStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcConfigDeliveryStub(
      ConfigDeliveryStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListResourceBundlesRequest, ListResourceBundlesResponse>
        listResourceBundlesTransportSettings =
            GrpcCallSettings.<ListResourceBundlesRequest, ListResourceBundlesResponse>newBuilder()
                .setMethodDescriptor(listResourceBundlesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetResourceBundleRequest, ResourceBundle> getResourceBundleTransportSettings =
        GrpcCallSettings.<GetResourceBundleRequest, ResourceBundle>newBuilder()
            .setMethodDescriptor(getResourceBundleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateResourceBundleRequest, Operation> createResourceBundleTransportSettings =
        GrpcCallSettings.<CreateResourceBundleRequest, Operation>newBuilder()
            .setMethodDescriptor(createResourceBundleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateResourceBundleRequest, Operation> updateResourceBundleTransportSettings =
        GrpcCallSettings.<UpdateResourceBundleRequest, Operation>newBuilder()
            .setMethodDescriptor(updateResourceBundleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "resource_bundle.name",
                      String.valueOf(request.getResourceBundle().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteResourceBundleRequest, Operation> deleteResourceBundleTransportSettings =
        GrpcCallSettings.<DeleteResourceBundleRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteResourceBundleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListFleetPackagesRequest, ListFleetPackagesResponse>
        listFleetPackagesTransportSettings =
            GrpcCallSettings.<ListFleetPackagesRequest, ListFleetPackagesResponse>newBuilder()
                .setMethodDescriptor(listFleetPackagesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetFleetPackageRequest, FleetPackage> getFleetPackageTransportSettings =
        GrpcCallSettings.<GetFleetPackageRequest, FleetPackage>newBuilder()
            .setMethodDescriptor(getFleetPackageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateFleetPackageRequest, Operation> createFleetPackageTransportSettings =
        GrpcCallSettings.<CreateFleetPackageRequest, Operation>newBuilder()
            .setMethodDescriptor(createFleetPackageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateFleetPackageRequest, Operation> updateFleetPackageTransportSettings =
        GrpcCallSettings.<UpdateFleetPackageRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFleetPackageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "fleet_package.name", String.valueOf(request.getFleetPackage().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteFleetPackageRequest, Operation> deleteFleetPackageTransportSettings =
        GrpcCallSettings.<DeleteFleetPackageRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFleetPackageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReleasesRequest, ListReleasesResponse> listReleasesTransportSettings =
        GrpcCallSettings.<ListReleasesRequest, ListReleasesResponse>newBuilder()
            .setMethodDescriptor(listReleasesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetReleaseRequest, Release> getReleaseTransportSettings =
        GrpcCallSettings.<GetReleaseRequest, Release>newBuilder()
            .setMethodDescriptor(getReleaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateReleaseRequest, Operation> createReleaseTransportSettings =
        GrpcCallSettings.<CreateReleaseRequest, Operation>newBuilder()
            .setMethodDescriptor(createReleaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateReleaseRequest, Operation> updateReleaseTransportSettings =
        GrpcCallSettings.<UpdateReleaseRequest, Operation>newBuilder()
            .setMethodDescriptor(updateReleaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("release.name", String.valueOf(request.getRelease().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteReleaseRequest, Operation> deleteReleaseTransportSettings =
        GrpcCallSettings.<DeleteReleaseRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteReleaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListVariantsRequest, ListVariantsResponse> listVariantsTransportSettings =
        GrpcCallSettings.<ListVariantsRequest, ListVariantsResponse>newBuilder()
            .setMethodDescriptor(listVariantsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetVariantRequest, Variant> getVariantTransportSettings =
        GrpcCallSettings.<GetVariantRequest, Variant>newBuilder()
            .setMethodDescriptor(getVariantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateVariantRequest, Operation> createVariantTransportSettings =
        GrpcCallSettings.<CreateVariantRequest, Operation>newBuilder()
            .setMethodDescriptor(createVariantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateVariantRequest, Operation> updateVariantTransportSettings =
        GrpcCallSettings.<UpdateVariantRequest, Operation>newBuilder()
            .setMethodDescriptor(updateVariantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("variant.name", String.valueOf(request.getVariant().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteVariantRequest, Operation> deleteVariantTransportSettings =
        GrpcCallSettings.<DeleteVariantRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteVariantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRolloutsRequest, ListRolloutsResponse> listRolloutsTransportSettings =
        GrpcCallSettings.<ListRolloutsRequest, ListRolloutsResponse>newBuilder()
            .setMethodDescriptor(listRolloutsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetRolloutRequest, Rollout> getRolloutTransportSettings =
        GrpcCallSettings.<GetRolloutRequest, Rollout>newBuilder()
            .setMethodDescriptor(getRolloutMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SuspendRolloutRequest, Operation> suspendRolloutTransportSettings =
        GrpcCallSettings.<SuspendRolloutRequest, Operation>newBuilder()
            .setMethodDescriptor(suspendRolloutMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ResumeRolloutRequest, Operation> resumeRolloutTransportSettings =
        GrpcCallSettings.<ResumeRolloutRequest, Operation>newBuilder()
            .setMethodDescriptor(resumeRolloutMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AbortRolloutRequest, Operation> abortRolloutTransportSettings =
        GrpcCallSettings.<AbortRolloutRequest, Operation>newBuilder()
            .setMethodDescriptor(abortRolloutMethodDescriptor)
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

    this.listResourceBundlesCallable =
        callableFactory.createUnaryCallable(
            listResourceBundlesTransportSettings,
            settings.listResourceBundlesSettings(),
            clientContext);
    this.listResourceBundlesPagedCallable =
        callableFactory.createPagedCallable(
            listResourceBundlesTransportSettings,
            settings.listResourceBundlesSettings(),
            clientContext);
    this.getResourceBundleCallable =
        callableFactory.createUnaryCallable(
            getResourceBundleTransportSettings,
            settings.getResourceBundleSettings(),
            clientContext);
    this.createResourceBundleCallable =
        callableFactory.createUnaryCallable(
            createResourceBundleTransportSettings,
            settings.createResourceBundleSettings(),
            clientContext);
    this.createResourceBundleOperationCallable =
        callableFactory.createOperationCallable(
            createResourceBundleTransportSettings,
            settings.createResourceBundleOperationSettings(),
            clientContext,
            operationsStub);
    this.updateResourceBundleCallable =
        callableFactory.createUnaryCallable(
            updateResourceBundleTransportSettings,
            settings.updateResourceBundleSettings(),
            clientContext);
    this.updateResourceBundleOperationCallable =
        callableFactory.createOperationCallable(
            updateResourceBundleTransportSettings,
            settings.updateResourceBundleOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteResourceBundleCallable =
        callableFactory.createUnaryCallable(
            deleteResourceBundleTransportSettings,
            settings.deleteResourceBundleSettings(),
            clientContext);
    this.deleteResourceBundleOperationCallable =
        callableFactory.createOperationCallable(
            deleteResourceBundleTransportSettings,
            settings.deleteResourceBundleOperationSettings(),
            clientContext,
            operationsStub);
    this.listFleetPackagesCallable =
        callableFactory.createUnaryCallable(
            listFleetPackagesTransportSettings,
            settings.listFleetPackagesSettings(),
            clientContext);
    this.listFleetPackagesPagedCallable =
        callableFactory.createPagedCallable(
            listFleetPackagesTransportSettings,
            settings.listFleetPackagesSettings(),
            clientContext);
    this.getFleetPackageCallable =
        callableFactory.createUnaryCallable(
            getFleetPackageTransportSettings, settings.getFleetPackageSettings(), clientContext);
    this.createFleetPackageCallable =
        callableFactory.createUnaryCallable(
            createFleetPackageTransportSettings,
            settings.createFleetPackageSettings(),
            clientContext);
    this.createFleetPackageOperationCallable =
        callableFactory.createOperationCallable(
            createFleetPackageTransportSettings,
            settings.createFleetPackageOperationSettings(),
            clientContext,
            operationsStub);
    this.updateFleetPackageCallable =
        callableFactory.createUnaryCallable(
            updateFleetPackageTransportSettings,
            settings.updateFleetPackageSettings(),
            clientContext);
    this.updateFleetPackageOperationCallable =
        callableFactory.createOperationCallable(
            updateFleetPackageTransportSettings,
            settings.updateFleetPackageOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFleetPackageCallable =
        callableFactory.createUnaryCallable(
            deleteFleetPackageTransportSettings,
            settings.deleteFleetPackageSettings(),
            clientContext);
    this.deleteFleetPackageOperationCallable =
        callableFactory.createOperationCallable(
            deleteFleetPackageTransportSettings,
            settings.deleteFleetPackageOperationSettings(),
            clientContext,
            operationsStub);
    this.listReleasesCallable =
        callableFactory.createUnaryCallable(
            listReleasesTransportSettings, settings.listReleasesSettings(), clientContext);
    this.listReleasesPagedCallable =
        callableFactory.createPagedCallable(
            listReleasesTransportSettings, settings.listReleasesSettings(), clientContext);
    this.getReleaseCallable =
        callableFactory.createUnaryCallable(
            getReleaseTransportSettings, settings.getReleaseSettings(), clientContext);
    this.createReleaseCallable =
        callableFactory.createUnaryCallable(
            createReleaseTransportSettings, settings.createReleaseSettings(), clientContext);
    this.createReleaseOperationCallable =
        callableFactory.createOperationCallable(
            createReleaseTransportSettings,
            settings.createReleaseOperationSettings(),
            clientContext,
            operationsStub);
    this.updateReleaseCallable =
        callableFactory.createUnaryCallable(
            updateReleaseTransportSettings, settings.updateReleaseSettings(), clientContext);
    this.updateReleaseOperationCallable =
        callableFactory.createOperationCallable(
            updateReleaseTransportSettings,
            settings.updateReleaseOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteReleaseCallable =
        callableFactory.createUnaryCallable(
            deleteReleaseTransportSettings, settings.deleteReleaseSettings(), clientContext);
    this.deleteReleaseOperationCallable =
        callableFactory.createOperationCallable(
            deleteReleaseTransportSettings,
            settings.deleteReleaseOperationSettings(),
            clientContext,
            operationsStub);
    this.listVariantsCallable =
        callableFactory.createUnaryCallable(
            listVariantsTransportSettings, settings.listVariantsSettings(), clientContext);
    this.listVariantsPagedCallable =
        callableFactory.createPagedCallable(
            listVariantsTransportSettings, settings.listVariantsSettings(), clientContext);
    this.getVariantCallable =
        callableFactory.createUnaryCallable(
            getVariantTransportSettings, settings.getVariantSettings(), clientContext);
    this.createVariantCallable =
        callableFactory.createUnaryCallable(
            createVariantTransportSettings, settings.createVariantSettings(), clientContext);
    this.createVariantOperationCallable =
        callableFactory.createOperationCallable(
            createVariantTransportSettings,
            settings.createVariantOperationSettings(),
            clientContext,
            operationsStub);
    this.updateVariantCallable =
        callableFactory.createUnaryCallable(
            updateVariantTransportSettings, settings.updateVariantSettings(), clientContext);
    this.updateVariantOperationCallable =
        callableFactory.createOperationCallable(
            updateVariantTransportSettings,
            settings.updateVariantOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteVariantCallable =
        callableFactory.createUnaryCallable(
            deleteVariantTransportSettings, settings.deleteVariantSettings(), clientContext);
    this.deleteVariantOperationCallable =
        callableFactory.createOperationCallable(
            deleteVariantTransportSettings,
            settings.deleteVariantOperationSettings(),
            clientContext,
            operationsStub);
    this.listRolloutsCallable =
        callableFactory.createUnaryCallable(
            listRolloutsTransportSettings, settings.listRolloutsSettings(), clientContext);
    this.listRolloutsPagedCallable =
        callableFactory.createPagedCallable(
            listRolloutsTransportSettings, settings.listRolloutsSettings(), clientContext);
    this.getRolloutCallable =
        callableFactory.createUnaryCallable(
            getRolloutTransportSettings, settings.getRolloutSettings(), clientContext);
    this.suspendRolloutCallable =
        callableFactory.createUnaryCallable(
            suspendRolloutTransportSettings, settings.suspendRolloutSettings(), clientContext);
    this.suspendRolloutOperationCallable =
        callableFactory.createOperationCallable(
            suspendRolloutTransportSettings,
            settings.suspendRolloutOperationSettings(),
            clientContext,
            operationsStub);
    this.resumeRolloutCallable =
        callableFactory.createUnaryCallable(
            resumeRolloutTransportSettings, settings.resumeRolloutSettings(), clientContext);
    this.resumeRolloutOperationCallable =
        callableFactory.createOperationCallable(
            resumeRolloutTransportSettings,
            settings.resumeRolloutOperationSettings(),
            clientContext,
            operationsStub);
    this.abortRolloutCallable =
        callableFactory.createUnaryCallable(
            abortRolloutTransportSettings, settings.abortRolloutSettings(), clientContext);
    this.abortRolloutOperationCallable =
        callableFactory.createOperationCallable(
            abortRolloutTransportSettings,
            settings.abortRolloutOperationSettings(),
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
  public UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesResponse>
      listResourceBundlesCallable() {
    return listResourceBundlesCallable;
  }

  @Override
  public UnaryCallable<ListResourceBundlesRequest, ListResourceBundlesPagedResponse>
      listResourceBundlesPagedCallable() {
    return listResourceBundlesPagedCallable;
  }

  @Override
  public UnaryCallable<GetResourceBundleRequest, ResourceBundle> getResourceBundleCallable() {
    return getResourceBundleCallable;
  }

  @Override
  public UnaryCallable<CreateResourceBundleRequest, Operation> createResourceBundleCallable() {
    return createResourceBundleCallable;
  }

  @Override
  public OperationCallable<CreateResourceBundleRequest, ResourceBundle, OperationMetadata>
      createResourceBundleOperationCallable() {
    return createResourceBundleOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateResourceBundleRequest, Operation> updateResourceBundleCallable() {
    return updateResourceBundleCallable;
  }

  @Override
  public OperationCallable<UpdateResourceBundleRequest, ResourceBundle, OperationMetadata>
      updateResourceBundleOperationCallable() {
    return updateResourceBundleOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteResourceBundleRequest, Operation> deleteResourceBundleCallable() {
    return deleteResourceBundleCallable;
  }

  @Override
  public OperationCallable<DeleteResourceBundleRequest, Empty, OperationMetadata>
      deleteResourceBundleOperationCallable() {
    return deleteResourceBundleOperationCallable;
  }

  @Override
  public UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesResponse>
      listFleetPackagesCallable() {
    return listFleetPackagesCallable;
  }

  @Override
  public UnaryCallable<ListFleetPackagesRequest, ListFleetPackagesPagedResponse>
      listFleetPackagesPagedCallable() {
    return listFleetPackagesPagedCallable;
  }

  @Override
  public UnaryCallable<GetFleetPackageRequest, FleetPackage> getFleetPackageCallable() {
    return getFleetPackageCallable;
  }

  @Override
  public UnaryCallable<CreateFleetPackageRequest, Operation> createFleetPackageCallable() {
    return createFleetPackageCallable;
  }

  @Override
  public OperationCallable<CreateFleetPackageRequest, FleetPackage, OperationMetadata>
      createFleetPackageOperationCallable() {
    return createFleetPackageOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFleetPackageRequest, Operation> updateFleetPackageCallable() {
    return updateFleetPackageCallable;
  }

  @Override
  public OperationCallable<UpdateFleetPackageRequest, FleetPackage, OperationMetadata>
      updateFleetPackageOperationCallable() {
    return updateFleetPackageOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFleetPackageRequest, Operation> deleteFleetPackageCallable() {
    return deleteFleetPackageCallable;
  }

  @Override
  public OperationCallable<DeleteFleetPackageRequest, Empty, OperationMetadata>
      deleteFleetPackageOperationCallable() {
    return deleteFleetPackageOperationCallable;
  }

  @Override
  public UnaryCallable<ListReleasesRequest, ListReleasesResponse> listReleasesCallable() {
    return listReleasesCallable;
  }

  @Override
  public UnaryCallable<ListReleasesRequest, ListReleasesPagedResponse> listReleasesPagedCallable() {
    return listReleasesPagedCallable;
  }

  @Override
  public UnaryCallable<GetReleaseRequest, Release> getReleaseCallable() {
    return getReleaseCallable;
  }

  @Override
  public UnaryCallable<CreateReleaseRequest, Operation> createReleaseCallable() {
    return createReleaseCallable;
  }

  @Override
  public OperationCallable<CreateReleaseRequest, Release, OperationMetadata>
      createReleaseOperationCallable() {
    return createReleaseOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateReleaseRequest, Operation> updateReleaseCallable() {
    return updateReleaseCallable;
  }

  @Override
  public OperationCallable<UpdateReleaseRequest, Release, OperationMetadata>
      updateReleaseOperationCallable() {
    return updateReleaseOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteReleaseRequest, Operation> deleteReleaseCallable() {
    return deleteReleaseCallable;
  }

  @Override
  public OperationCallable<DeleteReleaseRequest, Empty, OperationMetadata>
      deleteReleaseOperationCallable() {
    return deleteReleaseOperationCallable;
  }

  @Override
  public UnaryCallable<ListVariantsRequest, ListVariantsResponse> listVariantsCallable() {
    return listVariantsCallable;
  }

  @Override
  public UnaryCallable<ListVariantsRequest, ListVariantsPagedResponse> listVariantsPagedCallable() {
    return listVariantsPagedCallable;
  }

  @Override
  public UnaryCallable<GetVariantRequest, Variant> getVariantCallable() {
    return getVariantCallable;
  }

  @Override
  public UnaryCallable<CreateVariantRequest, Operation> createVariantCallable() {
    return createVariantCallable;
  }

  @Override
  public OperationCallable<CreateVariantRequest, Variant, OperationMetadata>
      createVariantOperationCallable() {
    return createVariantOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateVariantRequest, Operation> updateVariantCallable() {
    return updateVariantCallable;
  }

  @Override
  public OperationCallable<UpdateVariantRequest, Variant, OperationMetadata>
      updateVariantOperationCallable() {
    return updateVariantOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteVariantRequest, Operation> deleteVariantCallable() {
    return deleteVariantCallable;
  }

  @Override
  public OperationCallable<DeleteVariantRequest, Empty, OperationMetadata>
      deleteVariantOperationCallable() {
    return deleteVariantOperationCallable;
  }

  @Override
  public UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable() {
    return listRolloutsCallable;
  }

  @Override
  public UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse> listRolloutsPagedCallable() {
    return listRolloutsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable() {
    return getRolloutCallable;
  }

  @Override
  public UnaryCallable<SuspendRolloutRequest, Operation> suspendRolloutCallable() {
    return suspendRolloutCallable;
  }

  @Override
  public OperationCallable<SuspendRolloutRequest, Rollout, OperationMetadata>
      suspendRolloutOperationCallable() {
    return suspendRolloutOperationCallable;
  }

  @Override
  public UnaryCallable<ResumeRolloutRequest, Operation> resumeRolloutCallable() {
    return resumeRolloutCallable;
  }

  @Override
  public OperationCallable<ResumeRolloutRequest, Rollout, OperationMetadata>
      resumeRolloutOperationCallable() {
    return resumeRolloutOperationCallable;
  }

  @Override
  public UnaryCallable<AbortRolloutRequest, Operation> abortRolloutCallable() {
    return abortRolloutCallable;
  }

  @Override
  public OperationCallable<AbortRolloutRequest, Rollout, OperationMetadata>
      abortRolloutOperationCallable() {
    return abortRolloutOperationCallable;
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
