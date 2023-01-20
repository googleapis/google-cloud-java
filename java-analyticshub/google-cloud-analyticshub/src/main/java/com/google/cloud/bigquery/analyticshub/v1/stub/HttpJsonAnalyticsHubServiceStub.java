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

package com.google.cloud.bigquery.analyticshub.v1.stub;

import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListDataExchangesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListListingsPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListOrgDataExchangesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.DataExchange;
import com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.GetListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse;
import com.google.cloud.bigquery.analyticshub.v1.Listing;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse;
import com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AnalyticsHubService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAnalyticsHubServiceStub extends AnalyticsHubServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListDataExchangesRequest, ListDataExchangesResponse>
      listDataExchangesMethodDescriptor =
          ApiMethodDescriptor.<ListDataExchangesRequest, ListDataExchangesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/ListDataExchanges")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDataExchangesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataExchanges",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataExchangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDataExchangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDataExchangesResponse>newBuilder()
                      .setDefaultInstance(ListDataExchangesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>
      listOrgDataExchangesMethodDescriptor =
          ApiMethodDescriptor
              .<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/ListOrgDataExchanges")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOrgDataExchangesRequest>newBuilder()
                      .setPath(
                          "/v1/{organization=organizations/*/locations/*}/dataExchanges",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrgDataExchangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "organization", request.getOrganization());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrgDataExchangesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOrgDataExchangesResponse>newBuilder()
                      .setDefaultInstance(ListOrgDataExchangesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDataExchangeRequest, DataExchange>
      getDataExchangeMethodDescriptor =
          ApiMethodDescriptor.<GetDataExchangeRequest, DataExchange>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/GetDataExchange")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDataExchangeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataExchanges/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataExchangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDataExchangeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataExchange>newBuilder()
                      .setDefaultInstance(DataExchange.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDataExchangeRequest, DataExchange>
      createDataExchangeMethodDescriptor =
          ApiMethodDescriptor.<CreateDataExchangeRequest, DataExchange>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/CreateDataExchange")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDataExchangeRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/dataExchanges",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataExchangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDataExchangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "dataExchangeId", request.getDataExchangeId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataExchange", request.getDataExchange(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataExchange>newBuilder()
                      .setDefaultInstance(DataExchange.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateDataExchangeRequest, DataExchange>
      updateDataExchangeMethodDescriptor =
          ApiMethodDescriptor.<UpdateDataExchangeRequest, DataExchange>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/UpdateDataExchange")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateDataExchangeRequest>newBuilder()
                      .setPath(
                          "/v1/{dataExchange.name=projects/*/locations/*/dataExchanges/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataExchangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "dataExchange.name", request.getDataExchange().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateDataExchangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("dataExchange", request.getDataExchange(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DataExchange>newBuilder()
                      .setDefaultInstance(DataExchange.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDataExchangeRequest, Empty>
      deleteDataExchangeMethodDescriptor =
          ApiMethodDescriptor.<DeleteDataExchangeRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/DeleteDataExchange")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDataExchangeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataExchanges/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataExchangeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDataExchangeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListListingsRequest, ListListingsResponse>
      listListingsMethodDescriptor =
          ApiMethodDescriptor.<ListListingsRequest, ListListingsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/ListListings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListListingsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataExchanges/*}/listings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListListingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListListingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListListingsResponse>newBuilder()
                      .setDefaultInstance(ListListingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetListingRequest, Listing> getListingMethodDescriptor =
      ApiMethodDescriptor.<GetListingRequest, Listing>newBuilder()
          .setFullMethodName("google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/GetListing")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetListingRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/dataExchanges/*/listings/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetListingRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetListingRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Listing>newBuilder()
                  .setDefaultInstance(Listing.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateListingRequest, Listing>
      createListingMethodDescriptor =
          ApiMethodDescriptor.<CreateListingRequest, Listing>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/CreateListing")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateListingRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/dataExchanges/*}/listings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateListingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateListingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "listingId", request.getListingId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("listing", request.getListing(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Listing>newBuilder()
                      .setDefaultInstance(Listing.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateListingRequest, Listing>
      updateListingMethodDescriptor =
          ApiMethodDescriptor.<UpdateListingRequest, Listing>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/UpdateListing")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateListingRequest>newBuilder()
                      .setPath(
                          "/v1/{listing.name=projects/*/locations/*/dataExchanges/*/listings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateListingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "listing.name", request.getListing().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateListingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("listing", request.getListing(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Listing>newBuilder()
                      .setDefaultInstance(Listing.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteListingRequest, Empty>
      deleteListingMethodDescriptor =
          ApiMethodDescriptor.<DeleteListingRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/DeleteListing")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteListingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataExchanges/*/listings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteListingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteListingRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SubscribeListingRequest, SubscribeListingResponse>
      subscribeListingMethodDescriptor =
          ApiMethodDescriptor.<SubscribeListingRequest, SubscribeListingResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/SubscribeListing")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SubscribeListingRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/dataExchanges/*/listings/*}:subscribe",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SubscribeListingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SubscribeListingRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SubscribeListingResponse>newBuilder()
                      .setDefaultInstance(SubscribeListingResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/GetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/dataExchanges/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/dataExchanges/*/listings/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/dataExchanges/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/dataExchanges/*/listings/*}:setIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/dataExchanges/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/dataExchanges/*/listings/*}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAnalyticsHubServiceStub create(
      AnalyticsHubServiceStubSettings settings) throws IOException {
    return new HttpJsonAnalyticsHubServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAnalyticsHubServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAnalyticsHubServiceStub(
        AnalyticsHubServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAnalyticsHubServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAnalyticsHubServiceStub(
        AnalyticsHubServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAnalyticsHubServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAnalyticsHubServiceStub(
      AnalyticsHubServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAnalyticsHubServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAnalyticsHubServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAnalyticsHubServiceStub(
      AnalyticsHubServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListDataExchangesRequest, ListDataExchangesResponse>
        listDataExchangesTransportSettings =
            HttpJsonCallSettings.<ListDataExchangesRequest, ListDataExchangesResponse>newBuilder()
                .setMethodDescriptor(listDataExchangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>
        listOrgDataExchangesTransportSettings =
            HttpJsonCallSettings
                .<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse>newBuilder()
                .setMethodDescriptor(listOrgDataExchangesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDataExchangeRequest, DataExchange> getDataExchangeTransportSettings =
        HttpJsonCallSettings.<GetDataExchangeRequest, DataExchange>newBuilder()
            .setMethodDescriptor(getDataExchangeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateDataExchangeRequest, DataExchange>
        createDataExchangeTransportSettings =
            HttpJsonCallSettings.<CreateDataExchangeRequest, DataExchange>newBuilder()
                .setMethodDescriptor(createDataExchangeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateDataExchangeRequest, DataExchange>
        updateDataExchangeTransportSettings =
            HttpJsonCallSettings.<UpdateDataExchangeRequest, DataExchange>newBuilder()
                .setMethodDescriptor(updateDataExchangeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteDataExchangeRequest, Empty> deleteDataExchangeTransportSettings =
        HttpJsonCallSettings.<DeleteDataExchangeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDataExchangeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListListingsRequest, ListListingsResponse> listListingsTransportSettings =
        HttpJsonCallSettings.<ListListingsRequest, ListListingsResponse>newBuilder()
            .setMethodDescriptor(listListingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetListingRequest, Listing> getListingTransportSettings =
        HttpJsonCallSettings.<GetListingRequest, Listing>newBuilder()
            .setMethodDescriptor(getListingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateListingRequest, Listing> createListingTransportSettings =
        HttpJsonCallSettings.<CreateListingRequest, Listing>newBuilder()
            .setMethodDescriptor(createListingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateListingRequest, Listing> updateListingTransportSettings =
        HttpJsonCallSettings.<UpdateListingRequest, Listing>newBuilder()
            .setMethodDescriptor(updateListingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteListingRequest, Empty> deleteListingTransportSettings =
        HttpJsonCallSettings.<DeleteListingRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteListingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SubscribeListingRequest, SubscribeListingResponse>
        subscribeListingTransportSettings =
            HttpJsonCallSettings.<SubscribeListingRequest, SubscribeListingResponse>newBuilder()
                .setMethodDescriptor(subscribeListingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listDataExchangesMethodDescriptor);
    methodDescriptors.add(listOrgDataExchangesMethodDescriptor);
    methodDescriptors.add(getDataExchangeMethodDescriptor);
    methodDescriptors.add(createDataExchangeMethodDescriptor);
    methodDescriptors.add(updateDataExchangeMethodDescriptor);
    methodDescriptors.add(deleteDataExchangeMethodDescriptor);
    methodDescriptors.add(listListingsMethodDescriptor);
    methodDescriptors.add(getListingMethodDescriptor);
    methodDescriptors.add(createListingMethodDescriptor);
    methodDescriptors.add(updateListingMethodDescriptor);
    methodDescriptors.add(deleteListingMethodDescriptor);
    methodDescriptors.add(subscribeListingMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
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
