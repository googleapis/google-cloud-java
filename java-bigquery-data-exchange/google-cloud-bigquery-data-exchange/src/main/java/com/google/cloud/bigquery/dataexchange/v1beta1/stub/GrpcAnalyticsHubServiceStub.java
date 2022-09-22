/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.bigquery.dataexchange.v1beta1.stub;

import static com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceClient.ListDataExchangesPagedResponse;
import static com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceClient.ListListingsPagedResponse;
import static com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceClient.ListOrgDataExchangesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.dataexchange.v1beta1.CreateDataExchangeRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.CreateListingRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.DataExchange;
import com.google.cloud.bigquery.dataexchange.v1beta1.DeleteDataExchangeRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.DeleteListingRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.GetDataExchangeRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.GetListingRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListDataExchangesRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListDataExchangesResponse;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListListingsRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListListingsResponse;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListOrgDataExchangesRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListOrgDataExchangesResponse;
import com.google.cloud.bigquery.dataexchange.v1beta1.Listing;
import com.google.cloud.bigquery.dataexchange.v1beta1.SubscribeListingRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.SubscribeListingResponse;
import com.google.cloud.bigquery.dataexchange.v1beta1.UpdateDataExchangeRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.UpdateListingRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AnalyticsHubService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAnalyticsHubServiceStub extends AnalyticsHubServiceStub {
  private static final MethodDescriptor<ListDataExchangesRequest, ListDataExchangesResponse>
      listDataExchangesMethodDescriptor =
          MethodDescriptor.<ListDataExchangesRequest, ListDataExchangesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/ListDataExchanges")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataExchangesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataExchangesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>
      listOrgDataExchangesMethodDescriptor =
          MethodDescriptor.<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/ListOrgDataExchanges")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOrgDataExchangesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOrgDataExchangesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataExchangeRequest, DataExchange>
      getDataExchangeMethodDescriptor =
          MethodDescriptor.<GetDataExchangeRequest, DataExchange>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/GetDataExchange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataExchange.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDataExchangeRequest, DataExchange>
      createDataExchangeMethodDescriptor =
          MethodDescriptor.<CreateDataExchangeRequest, DataExchange>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/CreateDataExchange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataExchange.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataExchangeRequest, DataExchange>
      updateDataExchangeMethodDescriptor =
          MethodDescriptor.<UpdateDataExchangeRequest, DataExchange>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/UpdateDataExchange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataExchange.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataExchangeRequest, Empty>
      deleteDataExchangeMethodDescriptor =
          MethodDescriptor.<DeleteDataExchangeRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/DeleteDataExchange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListListingsRequest, ListListingsResponse>
      listListingsMethodDescriptor =
          MethodDescriptor.<ListListingsRequest, ListListingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/ListListings")
              .setRequestMarshaller(ProtoUtils.marshaller(ListListingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListListingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetListingRequest, Listing> getListingMethodDescriptor =
      MethodDescriptor.<GetListingRequest, Listing>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/GetListing")
          .setRequestMarshaller(ProtoUtils.marshaller(GetListingRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Listing.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateListingRequest, Listing>
      createListingMethodDescriptor =
          MethodDescriptor.<CreateListingRequest, Listing>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/CreateListing")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateListingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Listing.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateListingRequest, Listing>
      updateListingMethodDescriptor =
          MethodDescriptor.<UpdateListingRequest, Listing>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/UpdateListing")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateListingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Listing.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteListingRequest, Empty> deleteListingMethodDescriptor =
      MethodDescriptor.<DeleteListingRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/DeleteListing")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteListingRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SubscribeListingRequest, SubscribeListingResponse>
      subscribeListingMethodDescriptor =
          MethodDescriptor.<SubscribeListingRequest, SubscribeListingResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/SubscribeListing")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SubscribeListingRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SubscribeListingResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubService/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListDataExchangesRequest, ListDataExchangesResponse>
      listDataExchangesCallable;
  private final UnaryCallable<ListDataExchangesRequest, ListDataExchangesPagedResponse>
      listDataExchangesPagedCallable;
  private final UnaryCallable<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>
      listOrgDataExchangesCallable;
  private final UnaryCallable<ListOrgDataExchangesRequest, ListOrgDataExchangesPagedResponse>
      listOrgDataExchangesPagedCallable;
  private final UnaryCallable<GetDataExchangeRequest, DataExchange> getDataExchangeCallable;
  private final UnaryCallable<CreateDataExchangeRequest, DataExchange> createDataExchangeCallable;
  private final UnaryCallable<UpdateDataExchangeRequest, DataExchange> updateDataExchangeCallable;
  private final UnaryCallable<DeleteDataExchangeRequest, Empty> deleteDataExchangeCallable;
  private final UnaryCallable<ListListingsRequest, ListListingsResponse> listListingsCallable;
  private final UnaryCallable<ListListingsRequest, ListListingsPagedResponse>
      listListingsPagedCallable;
  private final UnaryCallable<GetListingRequest, Listing> getListingCallable;
  private final UnaryCallable<CreateListingRequest, Listing> createListingCallable;
  private final UnaryCallable<UpdateListingRequest, Listing> updateListingCallable;
  private final UnaryCallable<DeleteListingRequest, Empty> deleteListingCallable;
  private final UnaryCallable<SubscribeListingRequest, SubscribeListingResponse>
      subscribeListingCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAnalyticsHubServiceStub create(AnalyticsHubServiceStubSettings settings)
      throws IOException {
    return new GrpcAnalyticsHubServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAnalyticsHubServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAnalyticsHubServiceStub(
        AnalyticsHubServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAnalyticsHubServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAnalyticsHubServiceStub(
        AnalyticsHubServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAnalyticsHubServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAnalyticsHubServiceStub(
      AnalyticsHubServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAnalyticsHubServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAnalyticsHubServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAnalyticsHubServiceStub(
      AnalyticsHubServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListDataExchangesRequest, ListDataExchangesResponse>
        listDataExchangesTransportSettings =
            GrpcCallSettings.<ListDataExchangesRequest, ListDataExchangesResponse>newBuilder()
                .setMethodDescriptor(listDataExchangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>
        listOrgDataExchangesTransportSettings =
            GrpcCallSettings.<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>newBuilder()
                .setMethodDescriptor(listOrgDataExchangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("organization", String.valueOf(request.getOrganization()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetDataExchangeRequest, DataExchange> getDataExchangeTransportSettings =
        GrpcCallSettings.<GetDataExchangeRequest, DataExchange>newBuilder()
            .setMethodDescriptor(getDataExchangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateDataExchangeRequest, DataExchange> createDataExchangeTransportSettings =
        GrpcCallSettings.<CreateDataExchangeRequest, DataExchange>newBuilder()
            .setMethodDescriptor(createDataExchangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateDataExchangeRequest, DataExchange> updateDataExchangeTransportSettings =
        GrpcCallSettings.<UpdateDataExchangeRequest, DataExchange>newBuilder()
            .setMethodDescriptor(updateDataExchangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "data_exchange.name", String.valueOf(request.getDataExchange().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteDataExchangeRequest, Empty> deleteDataExchangeTransportSettings =
        GrpcCallSettings.<DeleteDataExchangeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataExchangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListListingsRequest, ListListingsResponse> listListingsTransportSettings =
        GrpcCallSettings.<ListListingsRequest, ListListingsResponse>newBuilder()
            .setMethodDescriptor(listListingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetListingRequest, Listing> getListingTransportSettings =
        GrpcCallSettings.<GetListingRequest, Listing>newBuilder()
            .setMethodDescriptor(getListingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateListingRequest, Listing> createListingTransportSettings =
        GrpcCallSettings.<CreateListingRequest, Listing>newBuilder()
            .setMethodDescriptor(createListingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateListingRequest, Listing> updateListingTransportSettings =
        GrpcCallSettings.<UpdateListingRequest, Listing>newBuilder()
            .setMethodDescriptor(updateListingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("listing.name", String.valueOf(request.getListing().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteListingRequest, Empty> deleteListingTransportSettings =
        GrpcCallSettings.<DeleteListingRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteListingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SubscribeListingRequest, SubscribeListingResponse>
        subscribeListingTransportSettings =
            GrpcCallSettings.<SubscribeListingRequest, SubscribeListingResponse>newBuilder()
                .setMethodDescriptor(subscribeListingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listDataExchangesCallable =
        callableFactory.createUnaryCallable(
            listDataExchangesTransportSettings,
            settings.listDataExchangesSettings(),
            clientContext);
    this.listDataExchangesPagedCallable =
        callableFactory.createPagedCallable(
            listDataExchangesTransportSettings,
            settings.listDataExchangesSettings(),
            clientContext);
    this.listOrgDataExchangesCallable =
        callableFactory.createUnaryCallable(
            listOrgDataExchangesTransportSettings,
            settings.listOrgDataExchangesSettings(),
            clientContext);
    this.listOrgDataExchangesPagedCallable =
        callableFactory.createPagedCallable(
            listOrgDataExchangesTransportSettings,
            settings.listOrgDataExchangesSettings(),
            clientContext);
    this.getDataExchangeCallable =
        callableFactory.createUnaryCallable(
            getDataExchangeTransportSettings, settings.getDataExchangeSettings(), clientContext);
    this.createDataExchangeCallable =
        callableFactory.createUnaryCallable(
            createDataExchangeTransportSettings,
            settings.createDataExchangeSettings(),
            clientContext);
    this.updateDataExchangeCallable =
        callableFactory.createUnaryCallable(
            updateDataExchangeTransportSettings,
            settings.updateDataExchangeSettings(),
            clientContext);
    this.deleteDataExchangeCallable =
        callableFactory.createUnaryCallable(
            deleteDataExchangeTransportSettings,
            settings.deleteDataExchangeSettings(),
            clientContext);
    this.listListingsCallable =
        callableFactory.createUnaryCallable(
            listListingsTransportSettings, settings.listListingsSettings(), clientContext);
    this.listListingsPagedCallable =
        callableFactory.createPagedCallable(
            listListingsTransportSettings, settings.listListingsSettings(), clientContext);
    this.getListingCallable =
        callableFactory.createUnaryCallable(
            getListingTransportSettings, settings.getListingSettings(), clientContext);
    this.createListingCallable =
        callableFactory.createUnaryCallable(
            createListingTransportSettings, settings.createListingSettings(), clientContext);
    this.updateListingCallable =
        callableFactory.createUnaryCallable(
            updateListingTransportSettings, settings.updateListingSettings(), clientContext);
    this.deleteListingCallable =
        callableFactory.createUnaryCallable(
            deleteListingTransportSettings, settings.deleteListingSettings(), clientContext);
    this.subscribeListingCallable =
        callableFactory.createUnaryCallable(
            subscribeListingTransportSettings, settings.subscribeListingSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListDataExchangesRequest, ListDataExchangesResponse>
      listDataExchangesCallable() {
    return listDataExchangesCallable;
  }

  @Override
  public UnaryCallable<ListDataExchangesRequest, ListDataExchangesPagedResponse>
      listDataExchangesPagedCallable() {
    return listDataExchangesPagedCallable;
  }

  @Override
  public UnaryCallable<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>
      listOrgDataExchangesCallable() {
    return listOrgDataExchangesCallable;
  }

  @Override
  public UnaryCallable<ListOrgDataExchangesRequest, ListOrgDataExchangesPagedResponse>
      listOrgDataExchangesPagedCallable() {
    return listOrgDataExchangesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataExchangeRequest, DataExchange> getDataExchangeCallable() {
    return getDataExchangeCallable;
  }

  @Override
  public UnaryCallable<CreateDataExchangeRequest, DataExchange> createDataExchangeCallable() {
    return createDataExchangeCallable;
  }

  @Override
  public UnaryCallable<UpdateDataExchangeRequest, DataExchange> updateDataExchangeCallable() {
    return updateDataExchangeCallable;
  }

  @Override
  public UnaryCallable<DeleteDataExchangeRequest, Empty> deleteDataExchangeCallable() {
    return deleteDataExchangeCallable;
  }

  @Override
  public UnaryCallable<ListListingsRequest, ListListingsResponse> listListingsCallable() {
    return listListingsCallable;
  }

  @Override
  public UnaryCallable<ListListingsRequest, ListListingsPagedResponse> listListingsPagedCallable() {
    return listListingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetListingRequest, Listing> getListingCallable() {
    return getListingCallable;
  }

  @Override
  public UnaryCallable<CreateListingRequest, Listing> createListingCallable() {
    return createListingCallable;
  }

  @Override
  public UnaryCallable<UpdateListingRequest, Listing> updateListingCallable() {
    return updateListingCallable;
  }

  @Override
  public UnaryCallable<DeleteListingRequest, Empty> deleteListingCallable() {
    return deleteListingCallable;
  }

  @Override
  public UnaryCallable<SubscribeListingRequest, SubscribeListingResponse>
      subscribeListingCallable() {
    return subscribeListingCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
