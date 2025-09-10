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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub;

import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListLocationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListRolloutKindsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListRolloutsPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest;
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
 * REST stub implementation for the SaasRollouts service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSaasRolloutsStub extends SaasRolloutsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListRolloutsRequest, ListRolloutsResponse>
      listRolloutsMethodDescriptor =
          ApiMethodDescriptor.<ListRolloutsRequest, ListRolloutsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/ListRollouts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRolloutsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/rollouts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRolloutsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRolloutsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRolloutsResponse>newBuilder()
                      .setDefaultInstance(ListRolloutsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRolloutRequest, Rollout> getRolloutMethodDescriptor =
      ApiMethodDescriptor.<GetRolloutRequest, Rollout>newBuilder()
          .setFullMethodName(
              "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/GetRollout")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRolloutRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/locations/*/rollouts/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRolloutRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRolloutRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Rollout>newBuilder()
                  .setDefaultInstance(Rollout.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateRolloutRequest, Rollout>
      createRolloutMethodDescriptor =
          ApiMethodDescriptor.<CreateRolloutRequest, Rollout>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/CreateRollout")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRolloutRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/rollouts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "rolloutId", request.getRolloutId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rollout", request.getRollout(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Rollout>newBuilder()
                      .setDefaultInstance(Rollout.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRolloutRequest, Rollout>
      updateRolloutMethodDescriptor =
          ApiMethodDescriptor.<UpdateRolloutRequest, Rollout>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/UpdateRollout")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRolloutRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{rollout.name=projects/*/locations/*/rollouts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "rollout.name", request.getRollout().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rollout", request.getRollout(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Rollout>newBuilder()
                      .setDefaultInstance(Rollout.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRolloutRequest, Empty>
      deleteRolloutMethodDescriptor =
          ApiMethodDescriptor.<DeleteRolloutRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/DeleteRollout")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRolloutRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/rollouts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRolloutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<ListRolloutKindsRequest, ListRolloutKindsResponse>
      listRolloutKindsMethodDescriptor =
          ApiMethodDescriptor.<ListRolloutKindsRequest, ListRolloutKindsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/ListRolloutKinds")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRolloutKindsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/rolloutKinds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRolloutKindsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRolloutKindsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRolloutKindsResponse>newBuilder()
                      .setDefaultInstance(ListRolloutKindsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRolloutKindRequest, RolloutKind>
      getRolloutKindMethodDescriptor =
          ApiMethodDescriptor.<GetRolloutKindRequest, RolloutKind>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/GetRolloutKind")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRolloutKindRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/rolloutKinds/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRolloutKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRolloutKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RolloutKind>newBuilder()
                      .setDefaultInstance(RolloutKind.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateRolloutKindRequest, RolloutKind>
      createRolloutKindMethodDescriptor =
          ApiMethodDescriptor.<CreateRolloutKindRequest, RolloutKind>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/CreateRolloutKind")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRolloutKindRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/rolloutKinds",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRolloutKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRolloutKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "rolloutKindId", request.getRolloutKindId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rolloutKind", request.getRolloutKind(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RolloutKind>newBuilder()
                      .setDefaultInstance(RolloutKind.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRolloutKindRequest, RolloutKind>
      updateRolloutKindMethodDescriptor =
          ApiMethodDescriptor.<UpdateRolloutKindRequest, RolloutKind>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/UpdateRolloutKind")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRolloutKindRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{rolloutKind.name=projects/*/locations/*/rolloutKinds/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRolloutKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "rolloutKind.name", request.getRolloutKind().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRolloutKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("rolloutKind", request.getRolloutKind(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RolloutKind>newBuilder()
                      .setDefaultInstance(RolloutKind.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRolloutKindRequest, Empty>
      deleteRolloutKindMethodDescriptor =
          ApiMethodDescriptor.<DeleteRolloutKindRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRollouts/DeleteRolloutKind")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRolloutKindRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/rolloutKinds/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRolloutKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRolloutKindRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> listRolloutsCallable;
  private final UnaryCallable<ListRolloutsRequest, ListRolloutsPagedResponse>
      listRolloutsPagedCallable;
  private final UnaryCallable<GetRolloutRequest, Rollout> getRolloutCallable;
  private final UnaryCallable<CreateRolloutRequest, Rollout> createRolloutCallable;
  private final UnaryCallable<UpdateRolloutRequest, Rollout> updateRolloutCallable;
  private final UnaryCallable<DeleteRolloutRequest, Empty> deleteRolloutCallable;
  private final UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsResponse>
      listRolloutKindsCallable;
  private final UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsPagedResponse>
      listRolloutKindsPagedCallable;
  private final UnaryCallable<GetRolloutKindRequest, RolloutKind> getRolloutKindCallable;
  private final UnaryCallable<CreateRolloutKindRequest, RolloutKind> createRolloutKindCallable;
  private final UnaryCallable<UpdateRolloutKindRequest, RolloutKind> updateRolloutKindCallable;
  private final UnaryCallable<DeleteRolloutKindRequest, Empty> deleteRolloutKindCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSaasRolloutsStub create(SaasRolloutsStubSettings settings)
      throws IOException {
    return new HttpJsonSaasRolloutsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSaasRolloutsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSaasRolloutsStub(
        SaasRolloutsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSaasRolloutsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSaasRolloutsStub(
        SaasRolloutsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSaasRolloutsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSaasRolloutsStub(SaasRolloutsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSaasRolloutsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSaasRolloutsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSaasRolloutsStub(
      SaasRolloutsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListRolloutsRequest, ListRolloutsResponse> listRolloutsTransportSettings =
        HttpJsonCallSettings.<ListRolloutsRequest, ListRolloutsResponse>newBuilder()
            .setMethodDescriptor(listRolloutsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetRolloutRequest, Rollout> getRolloutTransportSettings =
        HttpJsonCallSettings.<GetRolloutRequest, Rollout>newBuilder()
            .setMethodDescriptor(getRolloutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateRolloutRequest, Rollout> createRolloutTransportSettings =
        HttpJsonCallSettings.<CreateRolloutRequest, Rollout>newBuilder()
            .setMethodDescriptor(createRolloutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateRolloutRequest, Rollout> updateRolloutTransportSettings =
        HttpJsonCallSettings.<UpdateRolloutRequest, Rollout>newBuilder()
            .setMethodDescriptor(updateRolloutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("rollout.name", String.valueOf(request.getRollout().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteRolloutRequest, Empty> deleteRolloutTransportSettings =
        HttpJsonCallSettings.<DeleteRolloutRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRolloutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRolloutKindsRequest, ListRolloutKindsResponse>
        listRolloutKindsTransportSettings =
            HttpJsonCallSettings.<ListRolloutKindsRequest, ListRolloutKindsResponse>newBuilder()
                .setMethodDescriptor(listRolloutKindsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetRolloutKindRequest, RolloutKind> getRolloutKindTransportSettings =
        HttpJsonCallSettings.<GetRolloutKindRequest, RolloutKind>newBuilder()
            .setMethodDescriptor(getRolloutKindMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateRolloutKindRequest, RolloutKind> createRolloutKindTransportSettings =
        HttpJsonCallSettings.<CreateRolloutKindRequest, RolloutKind>newBuilder()
            .setMethodDescriptor(createRolloutKindMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateRolloutKindRequest, RolloutKind> updateRolloutKindTransportSettings =
        HttpJsonCallSettings.<UpdateRolloutKindRequest, RolloutKind>newBuilder()
            .setMethodDescriptor(updateRolloutKindMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "rollout_kind.name", String.valueOf(request.getRolloutKind().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteRolloutKindRequest, Empty> deleteRolloutKindTransportSettings =
        HttpJsonCallSettings.<DeleteRolloutKindRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRolloutKindMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listRolloutsCallable =
        callableFactory.createUnaryCallable(
            listRolloutsTransportSettings, settings.listRolloutsSettings(), clientContext);
    this.listRolloutsPagedCallable =
        callableFactory.createPagedCallable(
            listRolloutsTransportSettings, settings.listRolloutsSettings(), clientContext);
    this.getRolloutCallable =
        callableFactory.createUnaryCallable(
            getRolloutTransportSettings, settings.getRolloutSettings(), clientContext);
    this.createRolloutCallable =
        callableFactory.createUnaryCallable(
            createRolloutTransportSettings, settings.createRolloutSettings(), clientContext);
    this.updateRolloutCallable =
        callableFactory.createUnaryCallable(
            updateRolloutTransportSettings, settings.updateRolloutSettings(), clientContext);
    this.deleteRolloutCallable =
        callableFactory.createUnaryCallable(
            deleteRolloutTransportSettings, settings.deleteRolloutSettings(), clientContext);
    this.listRolloutKindsCallable =
        callableFactory.createUnaryCallable(
            listRolloutKindsTransportSettings, settings.listRolloutKindsSettings(), clientContext);
    this.listRolloutKindsPagedCallable =
        callableFactory.createPagedCallable(
            listRolloutKindsTransportSettings, settings.listRolloutKindsSettings(), clientContext);
    this.getRolloutKindCallable =
        callableFactory.createUnaryCallable(
            getRolloutKindTransportSettings, settings.getRolloutKindSettings(), clientContext);
    this.createRolloutKindCallable =
        callableFactory.createUnaryCallable(
            createRolloutKindTransportSettings,
            settings.createRolloutKindSettings(),
            clientContext);
    this.updateRolloutKindCallable =
        callableFactory.createUnaryCallable(
            updateRolloutKindTransportSettings,
            settings.updateRolloutKindSettings(),
            clientContext);
    this.deleteRolloutKindCallable =
        callableFactory.createUnaryCallable(
            deleteRolloutKindTransportSettings,
            settings.deleteRolloutKindSettings(),
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listRolloutsMethodDescriptor);
    methodDescriptors.add(getRolloutMethodDescriptor);
    methodDescriptors.add(createRolloutMethodDescriptor);
    methodDescriptors.add(updateRolloutMethodDescriptor);
    methodDescriptors.add(deleteRolloutMethodDescriptor);
    methodDescriptors.add(listRolloutKindsMethodDescriptor);
    methodDescriptors.add(getRolloutKindMethodDescriptor);
    methodDescriptors.add(createRolloutKindMethodDescriptor);
    methodDescriptors.add(updateRolloutKindMethodDescriptor);
    methodDescriptors.add(deleteRolloutKindMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
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
  public UnaryCallable<CreateRolloutRequest, Rollout> createRolloutCallable() {
    return createRolloutCallable;
  }

  @Override
  public UnaryCallable<UpdateRolloutRequest, Rollout> updateRolloutCallable() {
    return updateRolloutCallable;
  }

  @Override
  public UnaryCallable<DeleteRolloutRequest, Empty> deleteRolloutCallable() {
    return deleteRolloutCallable;
  }

  @Override
  public UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsResponse>
      listRolloutKindsCallable() {
    return listRolloutKindsCallable;
  }

  @Override
  public UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsPagedResponse>
      listRolloutKindsPagedCallable() {
    return listRolloutKindsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRolloutKindRequest, RolloutKind> getRolloutKindCallable() {
    return getRolloutKindCallable;
  }

  @Override
  public UnaryCallable<CreateRolloutKindRequest, RolloutKind> createRolloutKindCallable() {
    return createRolloutKindCallable;
  }

  @Override
  public UnaryCallable<UpdateRolloutKindRequest, RolloutKind> updateRolloutKindCallable() {
    return updateRolloutKindCallable;
  }

  @Override
  public UnaryCallable<DeleteRolloutKindRequest, Empty> deleteRolloutKindCallable() {
    return deleteRolloutKindCallable;
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
