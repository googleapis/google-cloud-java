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

import static com.google.cloud.aiplatform.v1beta1.FeatureOnlineStoreServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesRequest;
import com.google.cloud.aiplatform.v1beta1.FetchFeatureValuesResponse;
import com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesRequest;
import com.google.cloud.aiplatform.v1beta1.SearchNearestEntitiesResponse;
import com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesRequest;
import com.google.cloud.aiplatform.v1beta1.StreamingFetchFeatureValuesResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the FeatureOnlineStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcFeatureOnlineStoreServiceStub extends FeatureOnlineStoreServiceStub {
  private static final MethodDescriptor<FetchFeatureValuesRequest, FetchFeatureValuesResponse>
      fetchFeatureValuesMethodDescriptor =
          MethodDescriptor.<FetchFeatureValuesRequest, FetchFeatureValuesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeatureOnlineStoreService/FetchFeatureValues")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchFeatureValuesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchFeatureValuesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          StreamingFetchFeatureValuesRequest, StreamingFetchFeatureValuesResponse>
      streamingFetchFeatureValuesMethodDescriptor =
          MethodDescriptor
              .<StreamingFetchFeatureValuesRequest, StreamingFetchFeatureValuesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeatureOnlineStoreService/StreamingFetchFeatureValues")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamingFetchFeatureValuesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamingFetchFeatureValuesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchNearestEntitiesRequest, SearchNearestEntitiesResponse>
      searchNearestEntitiesMethodDescriptor =
          MethodDescriptor.<SearchNearestEntitiesRequest, SearchNearestEntitiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.FeatureOnlineStoreService/SearchNearestEntities")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchNearestEntitiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchNearestEntitiesResponse.getDefaultInstance()))
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

  private final UnaryCallable<FetchFeatureValuesRequest, FetchFeatureValuesResponse>
      fetchFeatureValuesCallable;
  private final BidiStreamingCallable<
          StreamingFetchFeatureValuesRequest, StreamingFetchFeatureValuesResponse>
      streamingFetchFeatureValuesCallable;
  private final UnaryCallable<SearchNearestEntitiesRequest, SearchNearestEntitiesResponse>
      searchNearestEntitiesCallable;
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

  public static final GrpcFeatureOnlineStoreServiceStub create(
      FeatureOnlineStoreServiceStubSettings settings) throws IOException {
    return new GrpcFeatureOnlineStoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFeatureOnlineStoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcFeatureOnlineStoreServiceStub(
        FeatureOnlineStoreServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFeatureOnlineStoreServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFeatureOnlineStoreServiceStub(
        FeatureOnlineStoreServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFeatureOnlineStoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcFeatureOnlineStoreServiceStub(
      FeatureOnlineStoreServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFeatureOnlineStoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFeatureOnlineStoreServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcFeatureOnlineStoreServiceStub(
      FeatureOnlineStoreServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<FetchFeatureValuesRequest, FetchFeatureValuesResponse>
        fetchFeatureValuesTransportSettings =
            GrpcCallSettings.<FetchFeatureValuesRequest, FetchFeatureValuesResponse>newBuilder()
                .setMethodDescriptor(fetchFeatureValuesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("feature_view", String.valueOf(request.getFeatureView()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<StreamingFetchFeatureValuesRequest, StreamingFetchFeatureValuesResponse>
        streamingFetchFeatureValuesTransportSettings =
            GrpcCallSettings
                .<StreamingFetchFeatureValuesRequest, StreamingFetchFeatureValuesResponse>
                    newBuilder()
                .setMethodDescriptor(streamingFetchFeatureValuesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("feature_view", String.valueOf(request.getFeatureView()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchNearestEntitiesRequest, SearchNearestEntitiesResponse>
        searchNearestEntitiesTransportSettings =
            GrpcCallSettings
                .<SearchNearestEntitiesRequest, SearchNearestEntitiesResponse>newBuilder()
                .setMethodDescriptor(searchNearestEntitiesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("feature_view", String.valueOf(request.getFeatureView()));
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

    this.fetchFeatureValuesCallable =
        callableFactory.createUnaryCallable(
            fetchFeatureValuesTransportSettings,
            settings.fetchFeatureValuesSettings(),
            clientContext);
    this.streamingFetchFeatureValuesCallable =
        callableFactory.createBidiStreamingCallable(
            streamingFetchFeatureValuesTransportSettings,
            settings.streamingFetchFeatureValuesSettings(),
            clientContext);
    this.searchNearestEntitiesCallable =
        callableFactory.createUnaryCallable(
            searchNearestEntitiesTransportSettings,
            settings.searchNearestEntitiesSettings(),
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
  public UnaryCallable<FetchFeatureValuesRequest, FetchFeatureValuesResponse>
      fetchFeatureValuesCallable() {
    return fetchFeatureValuesCallable;
  }

  @Override
  public BidiStreamingCallable<
          StreamingFetchFeatureValuesRequest, StreamingFetchFeatureValuesResponse>
      streamingFetchFeatureValuesCallable() {
    return streamingFetchFeatureValuesCallable;
  }

  @Override
  public UnaryCallable<SearchNearestEntitiesRequest, SearchNearestEntitiesResponse>
      searchNearestEntitiesCallable() {
    return searchNearestEntitiesCallable;
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
