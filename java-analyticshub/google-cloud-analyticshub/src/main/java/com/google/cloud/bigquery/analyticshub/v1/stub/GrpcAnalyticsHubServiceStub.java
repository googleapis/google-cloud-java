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

package com.google.cloud.bigquery.analyticshub.v1.stub;

import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListDataExchangesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListListingsPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListOrgDataExchangesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListSharedResourceSubscriptionsPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListSubscriptionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.DataExchange;
import com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest;
import com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.GetListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse;
import com.google.cloud.bigquery.analyticshub.v1.Listing;
import com.google.cloud.bigquery.analyticshub.v1.OperationMetadata;
import com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest;
import com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionResponse;
import com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest;
import com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeResponse;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse;
import com.google.cloud.bigquery.analyticshub.v1.Subscription;
import com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest;
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
 * gRPC stub implementation for the AnalyticsHubService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAnalyticsHubServiceStub extends AnalyticsHubServiceStub {
  private static final MethodDescriptor<ListDataExchangesRequest, ListDataExchangesResponse>
      listDataExchangesMethodDescriptor =
          MethodDescriptor.<ListDataExchangesRequest, ListDataExchangesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/ListDataExchanges")
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
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/ListOrgDataExchanges")
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
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/GetDataExchange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataExchange.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDataExchangeRequest, DataExchange>
      createDataExchangeMethodDescriptor =
          MethodDescriptor.<CreateDataExchangeRequest, DataExchange>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/CreateDataExchange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataExchange.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataExchangeRequest, DataExchange>
      updateDataExchangeMethodDescriptor =
          MethodDescriptor.<UpdateDataExchangeRequest, DataExchange>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/UpdateDataExchange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataExchange.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataExchangeRequest, Empty>
      deleteDataExchangeMethodDescriptor =
          MethodDescriptor.<DeleteDataExchangeRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/DeleteDataExchange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListListingsRequest, ListListingsResponse>
      listListingsMethodDescriptor =
          MethodDescriptor.<ListListingsRequest, ListListingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/ListListings")
              .setRequestMarshaller(ProtoUtils.marshaller(ListListingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListListingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetListingRequest, Listing> getListingMethodDescriptor =
      MethodDescriptor.<GetListingRequest, Listing>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/GetListing")
          .setRequestMarshaller(ProtoUtils.marshaller(GetListingRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Listing.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateListingRequest, Listing>
      createListingMethodDescriptor =
          MethodDescriptor.<CreateListingRequest, Listing>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/CreateListing")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateListingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Listing.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateListingRequest, Listing>
      updateListingMethodDescriptor =
          MethodDescriptor.<UpdateListingRequest, Listing>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/UpdateListing")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateListingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Listing.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteListingRequest, Empty> deleteListingMethodDescriptor =
      MethodDescriptor.<DeleteListingRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/DeleteListing")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteListingRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SubscribeListingRequest, SubscribeListingResponse>
      subscribeListingMethodDescriptor =
          MethodDescriptor.<SubscribeListingRequest, SubscribeListingResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/SubscribeListing")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SubscribeListingRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SubscribeListingResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SubscribeDataExchangeRequest, Operation>
      subscribeDataExchangeMethodDescriptor =
          MethodDescriptor.<SubscribeDataExchangeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/SubscribeDataExchange")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SubscribeDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RefreshSubscriptionRequest, Operation>
      refreshSubscriptionMethodDescriptor =
          MethodDescriptor.<RefreshSubscriptionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/RefreshSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RefreshSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSubscriptionRequest, Subscription>
      getSubscriptionMethodDescriptor =
          MethodDescriptor.<GetSubscriptionRequest, Subscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/GetSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Subscription.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsMethodDescriptor =
          MethodDescriptor.<ListSubscriptionsRequest, ListSubscriptionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/ListSubscriptions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSubscriptionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListSharedResourceSubscriptionsRequest, ListSharedResourceSubscriptionsResponse>
      listSharedResourceSubscriptionsMethodDescriptor =
          MethodDescriptor
              .<ListSharedResourceSubscriptionsRequest, ListSharedResourceSubscriptionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/ListSharedResourceSubscriptions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListSharedResourceSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListSharedResourceSubscriptionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RevokeSubscriptionRequest, RevokeSubscriptionResponse>
      revokeSubscriptionMethodDescriptor =
          MethodDescriptor.<RevokeSubscriptionRequest, RevokeSubscriptionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/RevokeSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RevokeSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RevokeSubscriptionResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSubscriptionRequest, Operation>
      deleteSubscriptionMethodDescriptor =
          MethodDescriptor.<DeleteSubscriptionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/DeleteSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
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
  private final UnaryCallable<SubscribeDataExchangeRequest, Operation>
      subscribeDataExchangeCallable;
  private final OperationCallable<
          SubscribeDataExchangeRequest, SubscribeDataExchangeResponse, OperationMetadata>
      subscribeDataExchangeOperationCallable;
  private final UnaryCallable<RefreshSubscriptionRequest, Operation> refreshSubscriptionCallable;
  private final OperationCallable<
          RefreshSubscriptionRequest, RefreshSubscriptionResponse, OperationMetadata>
      refreshSubscriptionOperationCallable;
  private final UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable;
  private final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable;
  private final UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable;
  private final UnaryCallable<
          ListSharedResourceSubscriptionsRequest, ListSharedResourceSubscriptionsResponse>
      listSharedResourceSubscriptionsCallable;
  private final UnaryCallable<
          ListSharedResourceSubscriptionsRequest, ListSharedResourceSubscriptionsPagedResponse>
      listSharedResourceSubscriptionsPagedCallable;
  private final UnaryCallable<RevokeSubscriptionRequest, RevokeSubscriptionResponse>
      revokeSubscriptionCallable;
  private final UnaryCallable<DeleteSubscriptionRequest, Operation> deleteSubscriptionCallable;
  private final OperationCallable<DeleteSubscriptionRequest, Empty, OperationMetadata>
      deleteSubscriptionOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

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
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>
        listOrgDataExchangesTransportSettings =
            GrpcCallSettings.<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>newBuilder()
                .setMethodDescriptor(listOrgDataExchangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("organization", String.valueOf(request.getOrganization()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDataExchangeRequest, DataExchange> getDataExchangeTransportSettings =
        GrpcCallSettings.<GetDataExchangeRequest, DataExchange>newBuilder()
            .setMethodDescriptor(getDataExchangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDataExchangeRequest, DataExchange> createDataExchangeTransportSettings =
        GrpcCallSettings.<CreateDataExchangeRequest, DataExchange>newBuilder()
            .setMethodDescriptor(createDataExchangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDataExchangeRequest, DataExchange> updateDataExchangeTransportSettings =
        GrpcCallSettings.<UpdateDataExchangeRequest, DataExchange>newBuilder()
            .setMethodDescriptor(updateDataExchangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_exchange.name", String.valueOf(request.getDataExchange().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDataExchangeRequest, Empty> deleteDataExchangeTransportSettings =
        GrpcCallSettings.<DeleteDataExchangeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataExchangeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListListingsRequest, ListListingsResponse> listListingsTransportSettings =
        GrpcCallSettings.<ListListingsRequest, ListListingsResponse>newBuilder()
            .setMethodDescriptor(listListingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetListingRequest, Listing> getListingTransportSettings =
        GrpcCallSettings.<GetListingRequest, Listing>newBuilder()
            .setMethodDescriptor(getListingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateListingRequest, Listing> createListingTransportSettings =
        GrpcCallSettings.<CreateListingRequest, Listing>newBuilder()
            .setMethodDescriptor(createListingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateListingRequest, Listing> updateListingTransportSettings =
        GrpcCallSettings.<UpdateListingRequest, Listing>newBuilder()
            .setMethodDescriptor(updateListingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("listing.name", String.valueOf(request.getListing().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteListingRequest, Empty> deleteListingTransportSettings =
        GrpcCallSettings.<DeleteListingRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteListingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SubscribeListingRequest, SubscribeListingResponse>
        subscribeListingTransportSettings =
            GrpcCallSettings.<SubscribeListingRequest, SubscribeListingResponse>newBuilder()
                .setMethodDescriptor(subscribeListingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SubscribeDataExchangeRequest, Operation>
        subscribeDataExchangeTransportSettings =
            GrpcCallSettings.<SubscribeDataExchangeRequest, Operation>newBuilder()
                .setMethodDescriptor(subscribeDataExchangeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RefreshSubscriptionRequest, Operation> refreshSubscriptionTransportSettings =
        GrpcCallSettings.<RefreshSubscriptionRequest, Operation>newBuilder()
            .setMethodDescriptor(refreshSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionTransportSettings =
        GrpcCallSettings.<GetSubscriptionRequest, Subscription>newBuilder()
            .setMethodDescriptor(getSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSubscriptionsRequest, ListSubscriptionsResponse>
        listSubscriptionsTransportSettings =
            GrpcCallSettings.<ListSubscriptionsRequest, ListSubscriptionsResponse>newBuilder()
                .setMethodDescriptor(listSubscriptionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            ListSharedResourceSubscriptionsRequest, ListSharedResourceSubscriptionsResponse>
        listSharedResourceSubscriptionsTransportSettings =
            GrpcCallSettings
                .<ListSharedResourceSubscriptionsRequest, ListSharedResourceSubscriptionsResponse>
                    newBuilder()
                .setMethodDescriptor(listSharedResourceSubscriptionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RevokeSubscriptionRequest, RevokeSubscriptionResponse>
        revokeSubscriptionTransportSettings =
            GrpcCallSettings.<RevokeSubscriptionRequest, RevokeSubscriptionResponse>newBuilder()
                .setMethodDescriptor(revokeSubscriptionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSubscriptionRequest, Operation> deleteSubscriptionTransportSettings =
        GrpcCallSettings.<DeleteSubscriptionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSubscriptionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
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
    this.subscribeDataExchangeCallable =
        callableFactory.createUnaryCallable(
            subscribeDataExchangeTransportSettings,
            settings.subscribeDataExchangeSettings(),
            clientContext);
    this.subscribeDataExchangeOperationCallable =
        callableFactory.createOperationCallable(
            subscribeDataExchangeTransportSettings,
            settings.subscribeDataExchangeOperationSettings(),
            clientContext,
            operationsStub);
    this.refreshSubscriptionCallable =
        callableFactory.createUnaryCallable(
            refreshSubscriptionTransportSettings,
            settings.refreshSubscriptionSettings(),
            clientContext);
    this.refreshSubscriptionOperationCallable =
        callableFactory.createOperationCallable(
            refreshSubscriptionTransportSettings,
            settings.refreshSubscriptionOperationSettings(),
            clientContext,
            operationsStub);
    this.getSubscriptionCallable =
        callableFactory.createUnaryCallable(
            getSubscriptionTransportSettings, settings.getSubscriptionSettings(), clientContext);
    this.listSubscriptionsCallable =
        callableFactory.createUnaryCallable(
            listSubscriptionsTransportSettings,
            settings.listSubscriptionsSettings(),
            clientContext);
    this.listSubscriptionsPagedCallable =
        callableFactory.createPagedCallable(
            listSubscriptionsTransportSettings,
            settings.listSubscriptionsSettings(),
            clientContext);
    this.listSharedResourceSubscriptionsCallable =
        callableFactory.createUnaryCallable(
            listSharedResourceSubscriptionsTransportSettings,
            settings.listSharedResourceSubscriptionsSettings(),
            clientContext);
    this.listSharedResourceSubscriptionsPagedCallable =
        callableFactory.createPagedCallable(
            listSharedResourceSubscriptionsTransportSettings,
            settings.listSharedResourceSubscriptionsSettings(),
            clientContext);
    this.revokeSubscriptionCallable =
        callableFactory.createUnaryCallable(
            revokeSubscriptionTransportSettings,
            settings.revokeSubscriptionSettings(),
            clientContext);
    this.deleteSubscriptionCallable =
        callableFactory.createUnaryCallable(
            deleteSubscriptionTransportSettings,
            settings.deleteSubscriptionSettings(),
            clientContext);
    this.deleteSubscriptionOperationCallable =
        callableFactory.createOperationCallable(
            deleteSubscriptionTransportSettings,
            settings.deleteSubscriptionOperationSettings(),
            clientContext,
            operationsStub);
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
  public UnaryCallable<SubscribeDataExchangeRequest, Operation> subscribeDataExchangeCallable() {
    return subscribeDataExchangeCallable;
  }

  @Override
  public OperationCallable<
          SubscribeDataExchangeRequest, SubscribeDataExchangeResponse, OperationMetadata>
      subscribeDataExchangeOperationCallable() {
    return subscribeDataExchangeOperationCallable;
  }

  @Override
  public UnaryCallable<RefreshSubscriptionRequest, Operation> refreshSubscriptionCallable() {
    return refreshSubscriptionCallable;
  }

  @Override
  public OperationCallable<
          RefreshSubscriptionRequest, RefreshSubscriptionResponse, OperationMetadata>
      refreshSubscriptionOperationCallable() {
    return refreshSubscriptionOperationCallable;
  }

  @Override
  public UnaryCallable<GetSubscriptionRequest, Subscription> getSubscriptionCallable() {
    return getSubscriptionCallable;
  }

  @Override
  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse>
      listSubscriptionsCallable() {
    return listSubscriptionsCallable;
  }

  @Override
  public UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsPagedResponse>
      listSubscriptionsPagedCallable() {
    return listSubscriptionsPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListSharedResourceSubscriptionsRequest, ListSharedResourceSubscriptionsResponse>
      listSharedResourceSubscriptionsCallable() {
    return listSharedResourceSubscriptionsCallable;
  }

  @Override
  public UnaryCallable<
          ListSharedResourceSubscriptionsRequest, ListSharedResourceSubscriptionsPagedResponse>
      listSharedResourceSubscriptionsPagedCallable() {
    return listSharedResourceSubscriptionsPagedCallable;
  }

  @Override
  public UnaryCallable<RevokeSubscriptionRequest, RevokeSubscriptionResponse>
      revokeSubscriptionCallable() {
    return revokeSubscriptionCallable;
  }

  @Override
  public UnaryCallable<DeleteSubscriptionRequest, Operation> deleteSubscriptionCallable() {
    return deleteSubscriptionCallable;
  }

  @Override
  public OperationCallable<DeleteSubscriptionRequest, Empty, OperationMetadata>
      deleteSubscriptionOperationCallable() {
    return deleteSubscriptionOperationCallable;
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
