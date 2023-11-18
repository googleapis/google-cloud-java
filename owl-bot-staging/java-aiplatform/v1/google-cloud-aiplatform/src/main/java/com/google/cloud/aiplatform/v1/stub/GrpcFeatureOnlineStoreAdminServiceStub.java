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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient.ListFeatureOnlineStoresPagedResponse;
import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient.ListFeatureViewSyncsPagedResponse;
import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient.ListFeatureViewsPagedResponse;
import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest;
import com.google.cloud.aiplatform.v1.CreateFeatureViewOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateFeatureViewRequest;
import com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest;
import com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.FeatureOnlineStore;
import com.google.cloud.aiplatform.v1.FeatureView;
import com.google.cloud.aiplatform.v1.FeatureViewSync;
import com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest;
import com.google.cloud.aiplatform.v1.GetFeatureViewRequest;
import com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest;
import com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest;
import com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse;
import com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest;
import com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse;
import com.google.cloud.aiplatform.v1.ListFeatureViewsRequest;
import com.google.cloud.aiplatform.v1.ListFeatureViewsResponse;
import com.google.cloud.aiplatform.v1.SyncFeatureViewRequest;
import com.google.cloud.aiplatform.v1.SyncFeatureViewResponse;
import com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest;
import com.google.cloud.aiplatform.v1.UpdateFeatureViewOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest;
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
 * gRPC stub implementation for the FeatureOnlineStoreAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcFeatureOnlineStoreAdminServiceStub extends FeatureOnlineStoreAdminServiceStub {
  private static final MethodDescriptor<CreateFeatureOnlineStoreRequest, Operation>
      createFeatureOnlineStoreMethodDescriptor =
          MethodDescriptor.<CreateFeatureOnlineStoreRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/CreateFeatureOnlineStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFeatureOnlineStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFeatureOnlineStoreRequest, FeatureOnlineStore>
      getFeatureOnlineStoreMethodDescriptor =
          MethodDescriptor.<GetFeatureOnlineStoreRequest, FeatureOnlineStore>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/GetFeatureOnlineStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFeatureOnlineStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FeatureOnlineStore.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse>
      listFeatureOnlineStoresMethodDescriptor =
          MethodDescriptor
              .<ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/ListFeatureOnlineStores")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFeatureOnlineStoresRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFeatureOnlineStoresResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFeatureOnlineStoreRequest, Operation>
      updateFeatureOnlineStoreMethodDescriptor =
          MethodDescriptor.<UpdateFeatureOnlineStoreRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/UpdateFeatureOnlineStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFeatureOnlineStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteFeatureOnlineStoreRequest, Operation>
      deleteFeatureOnlineStoreMethodDescriptor =
          MethodDescriptor.<DeleteFeatureOnlineStoreRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/DeleteFeatureOnlineStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFeatureOnlineStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFeatureViewRequest, Operation>
      createFeatureViewMethodDescriptor =
          MethodDescriptor.<CreateFeatureViewRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/CreateFeatureView")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFeatureViewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFeatureViewRequest, FeatureView>
      getFeatureViewMethodDescriptor =
          MethodDescriptor.<GetFeatureViewRequest, FeatureView>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/GetFeatureView")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFeatureViewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FeatureView.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListFeatureViewsRequest, ListFeatureViewsResponse>
      listFeatureViewsMethodDescriptor =
          MethodDescriptor.<ListFeatureViewsRequest, ListFeatureViewsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/ListFeatureViews")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFeatureViewsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFeatureViewsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFeatureViewRequest, Operation>
      updateFeatureViewMethodDescriptor =
          MethodDescriptor.<UpdateFeatureViewRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/UpdateFeatureView")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFeatureViewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteFeatureViewRequest, Operation>
      deleteFeatureViewMethodDescriptor =
          MethodDescriptor.<DeleteFeatureViewRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/DeleteFeatureView")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFeatureViewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SyncFeatureViewRequest, SyncFeatureViewResponse>
      syncFeatureViewMethodDescriptor =
          MethodDescriptor.<SyncFeatureViewRequest, SyncFeatureViewResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/SyncFeatureView")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SyncFeatureViewRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SyncFeatureViewResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFeatureViewSyncRequest, FeatureViewSync>
      getFeatureViewSyncMethodDescriptor =
          MethodDescriptor.<GetFeatureViewSyncRequest, FeatureViewSync>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/GetFeatureViewSync")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFeatureViewSyncRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FeatureViewSync.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse>
      listFeatureViewSyncsMethodDescriptor =
          MethodDescriptor.<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService/ListFeatureViewSyncs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFeatureViewSyncsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFeatureViewSyncsResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateFeatureOnlineStoreRequest, Operation>
      createFeatureOnlineStoreCallable;
  private final OperationCallable<
          CreateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          CreateFeatureOnlineStoreOperationMetadata>
      createFeatureOnlineStoreOperationCallable;
  private final UnaryCallable<GetFeatureOnlineStoreRequest, FeatureOnlineStore>
      getFeatureOnlineStoreCallable;
  private final UnaryCallable<ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse>
      listFeatureOnlineStoresCallable;
  private final UnaryCallable<ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresPagedResponse>
      listFeatureOnlineStoresPagedCallable;
  private final UnaryCallable<UpdateFeatureOnlineStoreRequest, Operation>
      updateFeatureOnlineStoreCallable;
  private final OperationCallable<
          UpdateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          UpdateFeatureOnlineStoreOperationMetadata>
      updateFeatureOnlineStoreOperationCallable;
  private final UnaryCallable<DeleteFeatureOnlineStoreRequest, Operation>
      deleteFeatureOnlineStoreCallable;
  private final OperationCallable<DeleteFeatureOnlineStoreRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOnlineStoreOperationCallable;
  private final UnaryCallable<CreateFeatureViewRequest, Operation> createFeatureViewCallable;
  private final OperationCallable<
          CreateFeatureViewRequest, FeatureView, CreateFeatureViewOperationMetadata>
      createFeatureViewOperationCallable;
  private final UnaryCallable<GetFeatureViewRequest, FeatureView> getFeatureViewCallable;
  private final UnaryCallable<ListFeatureViewsRequest, ListFeatureViewsResponse>
      listFeatureViewsCallable;
  private final UnaryCallable<ListFeatureViewsRequest, ListFeatureViewsPagedResponse>
      listFeatureViewsPagedCallable;
  private final UnaryCallable<UpdateFeatureViewRequest, Operation> updateFeatureViewCallable;
  private final OperationCallable<
          UpdateFeatureViewRequest, FeatureView, UpdateFeatureViewOperationMetadata>
      updateFeatureViewOperationCallable;
  private final UnaryCallable<DeleteFeatureViewRequest, Operation> deleteFeatureViewCallable;
  private final OperationCallable<DeleteFeatureViewRequest, Empty, DeleteOperationMetadata>
      deleteFeatureViewOperationCallable;
  private final UnaryCallable<SyncFeatureViewRequest, SyncFeatureViewResponse>
      syncFeatureViewCallable;
  private final UnaryCallable<GetFeatureViewSyncRequest, FeatureViewSync>
      getFeatureViewSyncCallable;
  private final UnaryCallable<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse>
      listFeatureViewSyncsCallable;
  private final UnaryCallable<ListFeatureViewSyncsRequest, ListFeatureViewSyncsPagedResponse>
      listFeatureViewSyncsPagedCallable;
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

  public static final GrpcFeatureOnlineStoreAdminServiceStub create(
      FeatureOnlineStoreAdminServiceStubSettings settings) throws IOException {
    return new GrpcFeatureOnlineStoreAdminServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFeatureOnlineStoreAdminServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcFeatureOnlineStoreAdminServiceStub(
        FeatureOnlineStoreAdminServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFeatureOnlineStoreAdminServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFeatureOnlineStoreAdminServiceStub(
        FeatureOnlineStoreAdminServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcFeatureOnlineStoreAdminServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcFeatureOnlineStoreAdminServiceStub(
      FeatureOnlineStoreAdminServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFeatureOnlineStoreAdminServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFeatureOnlineStoreAdminServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcFeatureOnlineStoreAdminServiceStub(
      FeatureOnlineStoreAdminServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateFeatureOnlineStoreRequest, Operation>
        createFeatureOnlineStoreTransportSettings =
            GrpcCallSettings.<CreateFeatureOnlineStoreRequest, Operation>newBuilder()
                .setMethodDescriptor(createFeatureOnlineStoreMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetFeatureOnlineStoreRequest, FeatureOnlineStore>
        getFeatureOnlineStoreTransportSettings =
            GrpcCallSettings.<GetFeatureOnlineStoreRequest, FeatureOnlineStore>newBuilder()
                .setMethodDescriptor(getFeatureOnlineStoreMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse>
        listFeatureOnlineStoresTransportSettings =
            GrpcCallSettings
                .<ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse>newBuilder()
                .setMethodDescriptor(listFeatureOnlineStoresMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateFeatureOnlineStoreRequest, Operation>
        updateFeatureOnlineStoreTransportSettings =
            GrpcCallSettings.<UpdateFeatureOnlineStoreRequest, Operation>newBuilder()
                .setMethodDescriptor(updateFeatureOnlineStoreMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "feature_online_store.name",
                          String.valueOf(request.getFeatureOnlineStore().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteFeatureOnlineStoreRequest, Operation>
        deleteFeatureOnlineStoreTransportSettings =
            GrpcCallSettings.<DeleteFeatureOnlineStoreRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteFeatureOnlineStoreMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateFeatureViewRequest, Operation> createFeatureViewTransportSettings =
        GrpcCallSettings.<CreateFeatureViewRequest, Operation>newBuilder()
            .setMethodDescriptor(createFeatureViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetFeatureViewRequest, FeatureView> getFeatureViewTransportSettings =
        GrpcCallSettings.<GetFeatureViewRequest, FeatureView>newBuilder()
            .setMethodDescriptor(getFeatureViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListFeatureViewsRequest, ListFeatureViewsResponse>
        listFeatureViewsTransportSettings =
            GrpcCallSettings.<ListFeatureViewsRequest, ListFeatureViewsResponse>newBuilder()
                .setMethodDescriptor(listFeatureViewsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateFeatureViewRequest, Operation> updateFeatureViewTransportSettings =
        GrpcCallSettings.<UpdateFeatureViewRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFeatureViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "feature_view.name", String.valueOf(request.getFeatureView().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteFeatureViewRequest, Operation> deleteFeatureViewTransportSettings =
        GrpcCallSettings.<DeleteFeatureViewRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFeatureViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SyncFeatureViewRequest, SyncFeatureViewResponse>
        syncFeatureViewTransportSettings =
            GrpcCallSettings.<SyncFeatureViewRequest, SyncFeatureViewResponse>newBuilder()
                .setMethodDescriptor(syncFeatureViewMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("feature_view", String.valueOf(request.getFeatureView()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetFeatureViewSyncRequest, FeatureViewSync>
        getFeatureViewSyncTransportSettings =
            GrpcCallSettings.<GetFeatureViewSyncRequest, FeatureViewSync>newBuilder()
                .setMethodDescriptor(getFeatureViewSyncMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse>
        listFeatureViewSyncsTransportSettings =
            GrpcCallSettings.<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse>newBuilder()
                .setMethodDescriptor(listFeatureViewSyncsMethodDescriptor)
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

    this.createFeatureOnlineStoreCallable =
        callableFactory.createUnaryCallable(
            createFeatureOnlineStoreTransportSettings,
            settings.createFeatureOnlineStoreSettings(),
            clientContext);
    this.createFeatureOnlineStoreOperationCallable =
        callableFactory.createOperationCallable(
            createFeatureOnlineStoreTransportSettings,
            settings.createFeatureOnlineStoreOperationSettings(),
            clientContext,
            operationsStub);
    this.getFeatureOnlineStoreCallable =
        callableFactory.createUnaryCallable(
            getFeatureOnlineStoreTransportSettings,
            settings.getFeatureOnlineStoreSettings(),
            clientContext);
    this.listFeatureOnlineStoresCallable =
        callableFactory.createUnaryCallable(
            listFeatureOnlineStoresTransportSettings,
            settings.listFeatureOnlineStoresSettings(),
            clientContext);
    this.listFeatureOnlineStoresPagedCallable =
        callableFactory.createPagedCallable(
            listFeatureOnlineStoresTransportSettings,
            settings.listFeatureOnlineStoresSettings(),
            clientContext);
    this.updateFeatureOnlineStoreCallable =
        callableFactory.createUnaryCallable(
            updateFeatureOnlineStoreTransportSettings,
            settings.updateFeatureOnlineStoreSettings(),
            clientContext);
    this.updateFeatureOnlineStoreOperationCallable =
        callableFactory.createOperationCallable(
            updateFeatureOnlineStoreTransportSettings,
            settings.updateFeatureOnlineStoreOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFeatureOnlineStoreCallable =
        callableFactory.createUnaryCallable(
            deleteFeatureOnlineStoreTransportSettings,
            settings.deleteFeatureOnlineStoreSettings(),
            clientContext);
    this.deleteFeatureOnlineStoreOperationCallable =
        callableFactory.createOperationCallable(
            deleteFeatureOnlineStoreTransportSettings,
            settings.deleteFeatureOnlineStoreOperationSettings(),
            clientContext,
            operationsStub);
    this.createFeatureViewCallable =
        callableFactory.createUnaryCallable(
            createFeatureViewTransportSettings,
            settings.createFeatureViewSettings(),
            clientContext);
    this.createFeatureViewOperationCallable =
        callableFactory.createOperationCallable(
            createFeatureViewTransportSettings,
            settings.createFeatureViewOperationSettings(),
            clientContext,
            operationsStub);
    this.getFeatureViewCallable =
        callableFactory.createUnaryCallable(
            getFeatureViewTransportSettings, settings.getFeatureViewSettings(), clientContext);
    this.listFeatureViewsCallable =
        callableFactory.createUnaryCallable(
            listFeatureViewsTransportSettings, settings.listFeatureViewsSettings(), clientContext);
    this.listFeatureViewsPagedCallable =
        callableFactory.createPagedCallable(
            listFeatureViewsTransportSettings, settings.listFeatureViewsSettings(), clientContext);
    this.updateFeatureViewCallable =
        callableFactory.createUnaryCallable(
            updateFeatureViewTransportSettings,
            settings.updateFeatureViewSettings(),
            clientContext);
    this.updateFeatureViewOperationCallable =
        callableFactory.createOperationCallable(
            updateFeatureViewTransportSettings,
            settings.updateFeatureViewOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteFeatureViewCallable =
        callableFactory.createUnaryCallable(
            deleteFeatureViewTransportSettings,
            settings.deleteFeatureViewSettings(),
            clientContext);
    this.deleteFeatureViewOperationCallable =
        callableFactory.createOperationCallable(
            deleteFeatureViewTransportSettings,
            settings.deleteFeatureViewOperationSettings(),
            clientContext,
            operationsStub);
    this.syncFeatureViewCallable =
        callableFactory.createUnaryCallable(
            syncFeatureViewTransportSettings, settings.syncFeatureViewSettings(), clientContext);
    this.getFeatureViewSyncCallable =
        callableFactory.createUnaryCallable(
            getFeatureViewSyncTransportSettings,
            settings.getFeatureViewSyncSettings(),
            clientContext);
    this.listFeatureViewSyncsCallable =
        callableFactory.createUnaryCallable(
            listFeatureViewSyncsTransportSettings,
            settings.listFeatureViewSyncsSettings(),
            clientContext);
    this.listFeatureViewSyncsPagedCallable =
        callableFactory.createPagedCallable(
            listFeatureViewSyncsTransportSettings,
            settings.listFeatureViewSyncsSettings(),
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
  public UnaryCallable<CreateFeatureOnlineStoreRequest, Operation>
      createFeatureOnlineStoreCallable() {
    return createFeatureOnlineStoreCallable;
  }

  @Override
  public OperationCallable<
          CreateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          CreateFeatureOnlineStoreOperationMetadata>
      createFeatureOnlineStoreOperationCallable() {
    return createFeatureOnlineStoreOperationCallable;
  }

  @Override
  public UnaryCallable<GetFeatureOnlineStoreRequest, FeatureOnlineStore>
      getFeatureOnlineStoreCallable() {
    return getFeatureOnlineStoreCallable;
  }

  @Override
  public UnaryCallable<ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse>
      listFeatureOnlineStoresCallable() {
    return listFeatureOnlineStoresCallable;
  }

  @Override
  public UnaryCallable<ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresPagedResponse>
      listFeatureOnlineStoresPagedCallable() {
    return listFeatureOnlineStoresPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateFeatureOnlineStoreRequest, Operation>
      updateFeatureOnlineStoreCallable() {
    return updateFeatureOnlineStoreCallable;
  }

  @Override
  public OperationCallable<
          UpdateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          UpdateFeatureOnlineStoreOperationMetadata>
      updateFeatureOnlineStoreOperationCallable() {
    return updateFeatureOnlineStoreOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFeatureOnlineStoreRequest, Operation>
      deleteFeatureOnlineStoreCallable() {
    return deleteFeatureOnlineStoreCallable;
  }

  @Override
  public OperationCallable<DeleteFeatureOnlineStoreRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOnlineStoreOperationCallable() {
    return deleteFeatureOnlineStoreOperationCallable;
  }

  @Override
  public UnaryCallable<CreateFeatureViewRequest, Operation> createFeatureViewCallable() {
    return createFeatureViewCallable;
  }

  @Override
  public OperationCallable<
          CreateFeatureViewRequest, FeatureView, CreateFeatureViewOperationMetadata>
      createFeatureViewOperationCallable() {
    return createFeatureViewOperationCallable;
  }

  @Override
  public UnaryCallable<GetFeatureViewRequest, FeatureView> getFeatureViewCallable() {
    return getFeatureViewCallable;
  }

  @Override
  public UnaryCallable<ListFeatureViewsRequest, ListFeatureViewsResponse>
      listFeatureViewsCallable() {
    return listFeatureViewsCallable;
  }

  @Override
  public UnaryCallable<ListFeatureViewsRequest, ListFeatureViewsPagedResponse>
      listFeatureViewsPagedCallable() {
    return listFeatureViewsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateFeatureViewRequest, Operation> updateFeatureViewCallable() {
    return updateFeatureViewCallable;
  }

  @Override
  public OperationCallable<
          UpdateFeatureViewRequest, FeatureView, UpdateFeatureViewOperationMetadata>
      updateFeatureViewOperationCallable() {
    return updateFeatureViewOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFeatureViewRequest, Operation> deleteFeatureViewCallable() {
    return deleteFeatureViewCallable;
  }

  @Override
  public OperationCallable<DeleteFeatureViewRequest, Empty, DeleteOperationMetadata>
      deleteFeatureViewOperationCallable() {
    return deleteFeatureViewOperationCallable;
  }

  @Override
  public UnaryCallable<SyncFeatureViewRequest, SyncFeatureViewResponse> syncFeatureViewCallable() {
    return syncFeatureViewCallable;
  }

  @Override
  public UnaryCallable<GetFeatureViewSyncRequest, FeatureViewSync> getFeatureViewSyncCallable() {
    return getFeatureViewSyncCallable;
  }

  @Override
  public UnaryCallable<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse>
      listFeatureViewSyncsCallable() {
    return listFeatureViewSyncsCallable;
  }

  @Override
  public UnaryCallable<ListFeatureViewSyncsRequest, ListFeatureViewSyncsPagedResponse>
      listFeatureViewSyncsPagedCallable() {
    return listFeatureViewSyncsPagedCallable;
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
