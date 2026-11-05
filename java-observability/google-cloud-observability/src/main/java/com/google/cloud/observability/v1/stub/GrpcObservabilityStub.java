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

package com.google.cloud.observability.v1.stub;

import static com.google.cloud.observability.v1.ObservabilityClient.ListBucketsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListDatasetsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListLinksPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListLocationsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListTraceScopesPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListViewsPagedResponse;

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
import com.google.cloud.observability.v1.Bucket;
import com.google.cloud.observability.v1.CreateBucketRequest;
import com.google.cloud.observability.v1.CreateLinkRequest;
import com.google.cloud.observability.v1.CreateTraceScopeRequest;
import com.google.cloud.observability.v1.Dataset;
import com.google.cloud.observability.v1.DeleteLinkRequest;
import com.google.cloud.observability.v1.DeleteTraceScopeRequest;
import com.google.cloud.observability.v1.GetBucketRequest;
import com.google.cloud.observability.v1.GetDatasetRequest;
import com.google.cloud.observability.v1.GetLinkRequest;
import com.google.cloud.observability.v1.GetScopeRequest;
import com.google.cloud.observability.v1.GetSettingsRequest;
import com.google.cloud.observability.v1.GetTraceScopeRequest;
import com.google.cloud.observability.v1.GetViewRequest;
import com.google.cloud.observability.v1.Link;
import com.google.cloud.observability.v1.ListBucketsRequest;
import com.google.cloud.observability.v1.ListBucketsResponse;
import com.google.cloud.observability.v1.ListDatasetsRequest;
import com.google.cloud.observability.v1.ListDatasetsResponse;
import com.google.cloud.observability.v1.ListLinksRequest;
import com.google.cloud.observability.v1.ListLinksResponse;
import com.google.cloud.observability.v1.ListTraceScopesRequest;
import com.google.cloud.observability.v1.ListTraceScopesResponse;
import com.google.cloud.observability.v1.ListViewsRequest;
import com.google.cloud.observability.v1.ListViewsResponse;
import com.google.cloud.observability.v1.OperationMetadata;
import com.google.cloud.observability.v1.Scope;
import com.google.cloud.observability.v1.Settings;
import com.google.cloud.observability.v1.TraceScope;
import com.google.cloud.observability.v1.UpdateBucketRequest;
import com.google.cloud.observability.v1.UpdateLinkRequest;
import com.google.cloud.observability.v1.UpdateScopeRequest;
import com.google.cloud.observability.v1.UpdateSettingsRequest;
import com.google.cloud.observability.v1.UpdateTraceScopeRequest;
import com.google.cloud.observability.v1.View;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Observability service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcObservabilityStub extends ObservabilityStub {
  private static final MethodDescriptor<GetScopeRequest, Scope> getScopeMethodDescriptor =
      MethodDescriptor.<GetScopeRequest, Scope>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.observability.v1.Observability/GetScope")
          .setRequestMarshaller(ProtoUtils.marshaller(GetScopeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Scope.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateScopeRequest, Scope> updateScopeMethodDescriptor =
      MethodDescriptor.<UpdateScopeRequest, Scope>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.observability.v1.Observability/UpdateScope")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateScopeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Scope.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetBucketRequest, Bucket> getBucketMethodDescriptor =
      MethodDescriptor.<GetBucketRequest, Bucket>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.observability.v1.Observability/GetBucket")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBucketRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Bucket.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListBucketsRequest, ListBucketsResponse>
      listBucketsMethodDescriptor =
          MethodDescriptor.<ListBucketsRequest, ListBucketsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.observability.v1.Observability/ListBuckets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBucketsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBucketsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBucketRequest, Operation>
      createBucketMethodDescriptor =
          MethodDescriptor.<CreateBucketRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.observability.v1.Observability/CreateBucket")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateBucketRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBucketRequest, Operation>
      updateBucketMethodDescriptor =
          MethodDescriptor.<UpdateBucketRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.observability.v1.Observability/UpdateBucket")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateBucketRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      MethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.observability.v1.Observability/GetDataset")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDatasetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          MethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.observability.v1.Observability/ListDatasets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatasetsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetViewRequest, View> getViewMethodDescriptor =
      MethodDescriptor.<GetViewRequest, View>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.observability.v1.Observability/GetView")
          .setRequestMarshaller(ProtoUtils.marshaller(GetViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(View.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListViewsRequest, ListViewsResponse>
      listViewsMethodDescriptor =
          MethodDescriptor.<ListViewsRequest, ListViewsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.observability.v1.Observability/ListViews")
              .setRequestMarshaller(ProtoUtils.marshaller(ListViewsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListViewsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLinkRequest, Link> getLinkMethodDescriptor =
      MethodDescriptor.<GetLinkRequest, Link>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.observability.v1.Observability/GetLink")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Link.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListLinksRequest, ListLinksResponse>
      listLinksMethodDescriptor =
          MethodDescriptor.<ListLinksRequest, ListLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.observability.v1.Observability/ListLinks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListLinksResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateLinkRequest, Operation> createLinkMethodDescriptor =
      MethodDescriptor.<CreateLinkRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.observability.v1.Observability/CreateLink")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateLinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateLinkRequest, Operation> updateLinkMethodDescriptor =
      MethodDescriptor.<UpdateLinkRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.observability.v1.Observability/UpdateLink")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateLinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteLinkRequest, Operation> deleteLinkMethodDescriptor =
      MethodDescriptor.<DeleteLinkRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.observability.v1.Observability/DeleteLink")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteLinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetTraceScopeRequest, TraceScope>
      getTraceScopeMethodDescriptor =
          MethodDescriptor.<GetTraceScopeRequest, TraceScope>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.observability.v1.Observability/GetTraceScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTraceScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TraceScope.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListTraceScopesRequest, ListTraceScopesResponse>
      listTraceScopesMethodDescriptor =
          MethodDescriptor.<ListTraceScopesRequest, ListTraceScopesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.observability.v1.Observability/ListTraceScopes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTraceScopesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTraceScopesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateTraceScopeRequest, TraceScope>
      createTraceScopeMethodDescriptor =
          MethodDescriptor.<CreateTraceScopeRequest, TraceScope>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.observability.v1.Observability/CreateTraceScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTraceScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TraceScope.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateTraceScopeRequest, TraceScope>
      updateTraceScopeMethodDescriptor =
          MethodDescriptor.<UpdateTraceScopeRequest, TraceScope>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.observability.v1.Observability/UpdateTraceScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTraceScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TraceScope.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteTraceScopeRequest, Empty>
      deleteTraceScopeMethodDescriptor =
          MethodDescriptor.<DeleteTraceScopeRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.observability.v1.Observability/DeleteTraceScope")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTraceScopeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSettingsRequest, Settings> getSettingsMethodDescriptor =
      MethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.observability.v1.Observability/GetSettings")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSettingsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateSettingsRequest, Operation>
      updateSettingsMethodDescriptor =
          MethodDescriptor.<UpdateSettingsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.observability.v1.Observability/UpdateSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private final UnaryCallable<GetScopeRequest, Scope> getScopeCallable;
  private final UnaryCallable<UpdateScopeRequest, Scope> updateScopeCallable;
  private final UnaryCallable<GetBucketRequest, Bucket> getBucketCallable;
  private final UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable;
  private final UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse>
      listBucketsPagedCallable;
  private final UnaryCallable<CreateBucketRequest, Operation> createBucketCallable;
  private final OperationCallable<CreateBucketRequest, Bucket, OperationMetadata>
      createBucketOperationCallable;
  private final UnaryCallable<UpdateBucketRequest, Operation> updateBucketCallable;
  private final OperationCallable<UpdateBucketRequest, Bucket, OperationMetadata>
      updateBucketOperationCallable;
  private final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable;
  private final UnaryCallable<GetViewRequest, View> getViewCallable;
  private final UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable;
  private final UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable;
  private final UnaryCallable<GetLinkRequest, Link> getLinkCallable;
  private final UnaryCallable<ListLinksRequest, ListLinksResponse> listLinksCallable;
  private final UnaryCallable<ListLinksRequest, ListLinksPagedResponse> listLinksPagedCallable;
  private final UnaryCallable<CreateLinkRequest, Operation> createLinkCallable;
  private final OperationCallable<CreateLinkRequest, Link, OperationMetadata>
      createLinkOperationCallable;
  private final UnaryCallable<UpdateLinkRequest, Operation> updateLinkCallable;
  private final OperationCallable<UpdateLinkRequest, Link, OperationMetadata>
      updateLinkOperationCallable;
  private final UnaryCallable<DeleteLinkRequest, Operation> deleteLinkCallable;
  private final OperationCallable<DeleteLinkRequest, Empty, OperationMetadata>
      deleteLinkOperationCallable;
  private final UnaryCallable<GetTraceScopeRequest, TraceScope> getTraceScopeCallable;
  private final UnaryCallable<ListTraceScopesRequest, ListTraceScopesResponse>
      listTraceScopesCallable;
  private final UnaryCallable<ListTraceScopesRequest, ListTraceScopesPagedResponse>
      listTraceScopesPagedCallable;
  private final UnaryCallable<CreateTraceScopeRequest, TraceScope> createTraceScopeCallable;
  private final UnaryCallable<UpdateTraceScopeRequest, TraceScope> updateTraceScopeCallable;
  private final UnaryCallable<DeleteTraceScopeRequest, Empty> deleteTraceScopeCallable;
  private final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable;
  private final UnaryCallable<UpdateSettingsRequest, Operation> updateSettingsCallable;
  private final OperationCallable<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcObservabilityStub create(ObservabilityStubSettings settings)
      throws IOException {
    return new GrpcObservabilityStub(settings, ClientContext.create(settings));
  }

  public static final GrpcObservabilityStub create(ClientContext clientContext) throws IOException {
    return new GrpcObservabilityStub(ObservabilityStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcObservabilityStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcObservabilityStub(
        ObservabilityStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcObservabilityStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcObservabilityStub(ObservabilityStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcObservabilityCallableFactory());
  }

  /**
   * Constructs an instance of GrpcObservabilityStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcObservabilityStub(
      ObservabilityStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetScopeRequest, Scope> getScopeTransportSettings =
        GrpcCallSettings.<GetScopeRequest, Scope>newBuilder()
            .setMethodDescriptor(getScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateScopeRequest, Scope> updateScopeTransportSettings =
        GrpcCallSettings.<UpdateScopeRequest, Scope>newBuilder()
            .setMethodDescriptor(updateScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("scope.name", String.valueOf(request.getScope().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetBucketRequest, Bucket> getBucketTransportSettings =
        GrpcCallSettings.<GetBucketRequest, Bucket>newBuilder()
            .setMethodDescriptor(getBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListBucketsRequest, ListBucketsResponse> listBucketsTransportSettings =
        GrpcCallSettings.<ListBucketsRequest, ListBucketsResponse>newBuilder()
            .setMethodDescriptor(listBucketsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<CreateBucketRequest, Operation> createBucketTransportSettings =
        GrpcCallSettings.<CreateBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(createBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateBucketRequest, Operation> updateBucketTransportSettings =
        GrpcCallSettings.<UpdateBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("bucket.name", String.valueOf(request.getBucket().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        GrpcCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        GrpcCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetViewRequest, View> getViewTransportSettings =
        GrpcCallSettings.<GetViewRequest, View>newBuilder()
            .setMethodDescriptor(getViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListViewsRequest, ListViewsResponse> listViewsTransportSettings =
        GrpcCallSettings.<ListViewsRequest, ListViewsResponse>newBuilder()
            .setMethodDescriptor(listViewsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetLinkRequest, Link> getLinkTransportSettings =
        GrpcCallSettings.<GetLinkRequest, Link>newBuilder()
            .setMethodDescriptor(getLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListLinksRequest, ListLinksResponse> listLinksTransportSettings =
        GrpcCallSettings.<ListLinksRequest, ListLinksResponse>newBuilder()
            .setMethodDescriptor(listLinksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<CreateLinkRequest, Operation> createLinkTransportSettings =
        GrpcCallSettings.<CreateLinkRequest, Operation>newBuilder()
            .setMethodDescriptor(createLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateLinkRequest, Operation> updateLinkTransportSettings =
        GrpcCallSettings.<UpdateLinkRequest, Operation>newBuilder()
            .setMethodDescriptor(updateLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("link.name", String.valueOf(request.getLink().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteLinkRequest, Operation> deleteLinkTransportSettings =
        GrpcCallSettings.<DeleteLinkRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetTraceScopeRequest, TraceScope> getTraceScopeTransportSettings =
        GrpcCallSettings.<GetTraceScopeRequest, TraceScope>newBuilder()
            .setMethodDescriptor(getTraceScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListTraceScopesRequest, ListTraceScopesResponse>
        listTraceScopesTransportSettings =
            GrpcCallSettings.<ListTraceScopesRequest, ListTraceScopesResponse>newBuilder()
                .setMethodDescriptor(listTraceScopesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateTraceScopeRequest, TraceScope> createTraceScopeTransportSettings =
        GrpcCallSettings.<CreateTraceScopeRequest, TraceScope>newBuilder()
            .setMethodDescriptor(createTraceScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateTraceScopeRequest, TraceScope> updateTraceScopeTransportSettings =
        GrpcCallSettings.<UpdateTraceScopeRequest, TraceScope>newBuilder()
            .setMethodDescriptor(updateTraceScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "trace_scope.name", String.valueOf(request.getTraceScope().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTraceScopeRequest, Empty> deleteTraceScopeTransportSettings =
        GrpcCallSettings.<DeleteTraceScopeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTraceScopeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        GrpcCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateSettingsRequest, Operation> updateSettingsTransportSettings =
        GrpcCallSettings.<UpdateSettingsRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("settings.name", String.valueOf(request.getSettings().getName()));
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

    this.getScopeCallable =
        callableFactory.createUnaryCallable(
            getScopeTransportSettings, settings.getScopeSettings(), clientContext);
    this.updateScopeCallable =
        callableFactory.createUnaryCallable(
            updateScopeTransportSettings, settings.updateScopeSettings(), clientContext);
    this.getBucketCallable =
        callableFactory.createUnaryCallable(
            getBucketTransportSettings, settings.getBucketSettings(), clientContext);
    this.listBucketsCallable =
        callableFactory.createUnaryCallable(
            listBucketsTransportSettings, settings.listBucketsSettings(), clientContext);
    this.listBucketsPagedCallable =
        callableFactory.createPagedCallable(
            listBucketsTransportSettings, settings.listBucketsSettings(), clientContext);
    this.createBucketCallable =
        callableFactory.createUnaryCallable(
            createBucketTransportSettings, settings.createBucketSettings(), clientContext);
    this.createBucketOperationCallable =
        callableFactory.createOperationCallable(
            createBucketTransportSettings,
            settings.createBucketOperationSettings(),
            clientContext,
            operationsStub);
    this.updateBucketCallable =
        callableFactory.createUnaryCallable(
            updateBucketTransportSettings, settings.updateBucketSettings(), clientContext);
    this.updateBucketOperationCallable =
        callableFactory.createOperationCallable(
            updateBucketTransportSettings,
            settings.updateBucketOperationSettings(),
            clientContext,
            operationsStub);
    this.getDatasetCallable =
        callableFactory.createUnaryCallable(
            getDatasetTransportSettings, settings.getDatasetSettings(), clientContext);
    this.listDatasetsCallable =
        callableFactory.createUnaryCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.listDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.getViewCallable =
        callableFactory.createUnaryCallable(
            getViewTransportSettings, settings.getViewSettings(), clientContext);
    this.listViewsCallable =
        callableFactory.createUnaryCallable(
            listViewsTransportSettings, settings.listViewsSettings(), clientContext);
    this.listViewsPagedCallable =
        callableFactory.createPagedCallable(
            listViewsTransportSettings, settings.listViewsSettings(), clientContext);
    this.getLinkCallable =
        callableFactory.createUnaryCallable(
            getLinkTransportSettings, settings.getLinkSettings(), clientContext);
    this.listLinksCallable =
        callableFactory.createUnaryCallable(
            listLinksTransportSettings, settings.listLinksSettings(), clientContext);
    this.listLinksPagedCallable =
        callableFactory.createPagedCallable(
            listLinksTransportSettings, settings.listLinksSettings(), clientContext);
    this.createLinkCallable =
        callableFactory.createUnaryCallable(
            createLinkTransportSettings, settings.createLinkSettings(), clientContext);
    this.createLinkOperationCallable =
        callableFactory.createOperationCallable(
            createLinkTransportSettings,
            settings.createLinkOperationSettings(),
            clientContext,
            operationsStub);
    this.updateLinkCallable =
        callableFactory.createUnaryCallable(
            updateLinkTransportSettings, settings.updateLinkSettings(), clientContext);
    this.updateLinkOperationCallable =
        callableFactory.createOperationCallable(
            updateLinkTransportSettings,
            settings.updateLinkOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteLinkCallable =
        callableFactory.createUnaryCallable(
            deleteLinkTransportSettings, settings.deleteLinkSettings(), clientContext);
    this.deleteLinkOperationCallable =
        callableFactory.createOperationCallable(
            deleteLinkTransportSettings,
            settings.deleteLinkOperationSettings(),
            clientContext,
            operationsStub);
    this.getTraceScopeCallable =
        callableFactory.createUnaryCallable(
            getTraceScopeTransportSettings, settings.getTraceScopeSettings(), clientContext);
    this.listTraceScopesCallable =
        callableFactory.createUnaryCallable(
            listTraceScopesTransportSettings, settings.listTraceScopesSettings(), clientContext);
    this.listTraceScopesPagedCallable =
        callableFactory.createPagedCallable(
            listTraceScopesTransportSettings, settings.listTraceScopesSettings(), clientContext);
    this.createTraceScopeCallable =
        callableFactory.createUnaryCallable(
            createTraceScopeTransportSettings, settings.createTraceScopeSettings(), clientContext);
    this.updateTraceScopeCallable =
        callableFactory.createUnaryCallable(
            updateTraceScopeTransportSettings, settings.updateTraceScopeSettings(), clientContext);
    this.deleteTraceScopeCallable =
        callableFactory.createUnaryCallable(
            deleteTraceScopeTransportSettings, settings.deleteTraceScopeSettings(), clientContext);
    this.getSettingsCallable =
        callableFactory.createUnaryCallable(
            getSettingsTransportSettings, settings.getSettingsSettings(), clientContext);
    this.updateSettingsCallable =
        callableFactory.createUnaryCallable(
            updateSettingsTransportSettings, settings.updateSettingsSettings(), clientContext);
    this.updateSettingsOperationCallable =
        callableFactory.createOperationCallable(
            updateSettingsTransportSettings,
            settings.updateSettingsOperationSettings(),
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
  public UnaryCallable<GetScopeRequest, Scope> getScopeCallable() {
    return getScopeCallable;
  }

  @Override
  public UnaryCallable<UpdateScopeRequest, Scope> updateScopeCallable() {
    return updateScopeCallable;
  }

  @Override
  public UnaryCallable<GetBucketRequest, Bucket> getBucketCallable() {
    return getBucketCallable;
  }

  @Override
  public UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable() {
    return listBucketsCallable;
  }

  @Override
  public UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse> listBucketsPagedCallable() {
    return listBucketsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateBucketRequest, Operation> createBucketCallable() {
    return createBucketCallable;
  }

  @Override
  public OperationCallable<CreateBucketRequest, Bucket, OperationMetadata>
      createBucketOperationCallable() {
    return createBucketOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateBucketRequest, Operation> updateBucketCallable() {
    return updateBucketCallable;
  }

  @Override
  public OperationCallable<UpdateBucketRequest, Bucket, OperationMetadata>
      updateBucketOperationCallable() {
    return updateBucketOperationCallable;
  }

  @Override
  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return getDatasetCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return listDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    return listDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetViewRequest, View> getViewCallable() {
    return getViewCallable;
  }

  @Override
  public UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable() {
    return listViewsCallable;
  }

  @Override
  public UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable() {
    return listViewsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLinkRequest, Link> getLinkCallable() {
    return getLinkCallable;
  }

  @Override
  public UnaryCallable<ListLinksRequest, ListLinksResponse> listLinksCallable() {
    return listLinksCallable;
  }

  @Override
  public UnaryCallable<ListLinksRequest, ListLinksPagedResponse> listLinksPagedCallable() {
    return listLinksPagedCallable;
  }

  @Override
  public UnaryCallable<CreateLinkRequest, Operation> createLinkCallable() {
    return createLinkCallable;
  }

  @Override
  public OperationCallable<CreateLinkRequest, Link, OperationMetadata>
      createLinkOperationCallable() {
    return createLinkOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateLinkRequest, Operation> updateLinkCallable() {
    return updateLinkCallable;
  }

  @Override
  public OperationCallable<UpdateLinkRequest, Link, OperationMetadata>
      updateLinkOperationCallable() {
    return updateLinkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteLinkRequest, Operation> deleteLinkCallable() {
    return deleteLinkCallable;
  }

  @Override
  public OperationCallable<DeleteLinkRequest, Empty, OperationMetadata>
      deleteLinkOperationCallable() {
    return deleteLinkOperationCallable;
  }

  @Override
  public UnaryCallable<GetTraceScopeRequest, TraceScope> getTraceScopeCallable() {
    return getTraceScopeCallable;
  }

  @Override
  public UnaryCallable<ListTraceScopesRequest, ListTraceScopesResponse> listTraceScopesCallable() {
    return listTraceScopesCallable;
  }

  @Override
  public UnaryCallable<ListTraceScopesRequest, ListTraceScopesPagedResponse>
      listTraceScopesPagedCallable() {
    return listTraceScopesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateTraceScopeRequest, TraceScope> createTraceScopeCallable() {
    return createTraceScopeCallable;
  }

  @Override
  public UnaryCallable<UpdateTraceScopeRequest, TraceScope> updateTraceScopeCallable() {
    return updateTraceScopeCallable;
  }

  @Override
  public UnaryCallable<DeleteTraceScopeRequest, Empty> deleteTraceScopeCallable() {
    return deleteTraceScopeCallable;
  }

  @Override
  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return getSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateSettingsRequest, Operation> updateSettingsCallable() {
    return updateSettingsCallable;
  }

  @Override
  public OperationCallable<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationCallable() {
    return updateSettingsOperationCallable;
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
