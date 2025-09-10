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

package com.google.cloud.networkmanagement.v1beta1.stub;

import static com.google.cloud.networkmanagement.v1beta1.ReachabilityServiceClient.ListConnectivityTestsPagedResponse;
import static com.google.cloud.networkmanagement.v1beta1.ReachabilityServiceClient.ListLocationsPagedResponse;

import com.google.api.HttpRule;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkmanagement.v1beta1.ConnectivityTest;
import com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest;
import com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse;
import com.google.cloud.networkmanagement.v1beta1.OperationMetadata;
import com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the ReachabilityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonReachabilityServiceStub extends ReachabilityServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(ConnectivityTest.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListConnectivityTestsRequest, ListConnectivityTestsResponse>
      listConnectivityTestsMethodDescriptor =
          ApiMethodDescriptor
              .<ListConnectivityTestsRequest, ListConnectivityTestsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.ReachabilityService/ListConnectivityTests")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConnectivityTestsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/global}/connectivityTests",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectivityTestsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectivityTestsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListConnectivityTestsResponse>newBuilder()
                      .setDefaultInstance(ListConnectivityTestsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConnectivityTestRequest, ConnectivityTest>
      getConnectivityTestMethodDescriptor =
          ApiMethodDescriptor.<GetConnectivityTestRequest, ConnectivityTest>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.ReachabilityService/GetConnectivityTest")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConnectivityTestRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/global/connectivityTests/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConnectivityTest>newBuilder()
                      .setDefaultInstance(ConnectivityTest.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateConnectivityTestRequest, Operation>
      createConnectivityTestMethodDescriptor =
          ApiMethodDescriptor.<CreateConnectivityTestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.ReachabilityService/CreateConnectivityTest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConnectivityTestRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/global}/connectivityTests",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "testId", request.getTestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resource", request.getResource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateConnectivityTestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateConnectivityTestRequest, Operation>
      updateConnectivityTestMethodDescriptor =
          ApiMethodDescriptor.<UpdateConnectivityTestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.ReachabilityService/UpdateConnectivityTest")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConnectivityTestRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource.name=projects/*/locations/global/connectivityTests/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "resource.name", request.getResource().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resource", request.getResource(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateConnectivityTestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RerunConnectivityTestRequest, Operation>
      rerunConnectivityTestMethodDescriptor =
          ApiMethodDescriptor.<RerunConnectivityTestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.ReachabilityService/RerunConnectivityTest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RerunConnectivityTestRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/global/connectivityTests/*}:rerun",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RerunConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RerunConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RerunConnectivityTestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteConnectivityTestRequest, Operation>
      deleteConnectivityTestMethodDescriptor =
          ApiMethodDescriptor.<DeleteConnectivityTestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1beta1.ReachabilityService/DeleteConnectivityTest")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConnectivityTestRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/global/connectivityTests/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteConnectivityTestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
                      .setAdditionalPaths("/v1beta1/{name=organizations/*}/locations")
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
                      .setAdditionalPaths("/v1beta1/{name=organizations/*/locations/*}")
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/global/connectivityTests/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/global/connectivityTests/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
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
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/global/connectivityTests/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsResponse>
      listConnectivityTestsCallable;
  private final UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsPagedResponse>
      listConnectivityTestsPagedCallable;
  private final UnaryCallable<GetConnectivityTestRequest, ConnectivityTest>
      getConnectivityTestCallable;
  private final UnaryCallable<CreateConnectivityTestRequest, Operation>
      createConnectivityTestCallable;
  private final OperationCallable<
          CreateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      createConnectivityTestOperationCallable;
  private final UnaryCallable<UpdateConnectivityTestRequest, Operation>
      updateConnectivityTestCallable;
  private final OperationCallable<
          UpdateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      updateConnectivityTestOperationCallable;
  private final UnaryCallable<RerunConnectivityTestRequest, Operation>
      rerunConnectivityTestCallable;
  private final OperationCallable<RerunConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      rerunConnectivityTestOperationCallable;
  private final UnaryCallable<DeleteConnectivityTestRequest, Operation>
      deleteConnectivityTestCallable;
  private final OperationCallable<DeleteConnectivityTestRequest, Empty, OperationMetadata>
      deleteConnectivityTestOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonReachabilityServiceStub create(
      ReachabilityServiceStubSettings settings) throws IOException {
    return new HttpJsonReachabilityServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonReachabilityServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonReachabilityServiceStub(
        ReachabilityServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonReachabilityServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonReachabilityServiceStub(
        ReachabilityServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonReachabilityServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReachabilityServiceStub(
      ReachabilityServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonReachabilityServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonReachabilityServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReachabilityServiceStub(
      ReachabilityServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1beta1/{name=projects/*/locations/global/operations/*}:cancel")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1beta1/{name=organizations/*/locations/global/operations/*}:cancel")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1beta1/{name=projects/*/locations/global/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setDelete(
                                    "/v1beta1/{name=organizations/*/locations/global/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1beta1/{name=projects/*/locations/global/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1beta1/{name=organizations/*/locations/global/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1beta1/{name=projects/*/locations/global}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1beta1/{name=organizations/*/locations/global}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<ListConnectivityTestsRequest, ListConnectivityTestsResponse>
        listConnectivityTestsTransportSettings =
            HttpJsonCallSettings
                .<ListConnectivityTestsRequest, ListConnectivityTestsResponse>newBuilder()
                .setMethodDescriptor(listConnectivityTestsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetConnectivityTestRequest, ConnectivityTest>
        getConnectivityTestTransportSettings =
            HttpJsonCallSettings.<GetConnectivityTestRequest, ConnectivityTest>newBuilder()
                .setMethodDescriptor(getConnectivityTestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateConnectivityTestRequest, Operation>
        createConnectivityTestTransportSettings =
            HttpJsonCallSettings.<CreateConnectivityTestRequest, Operation>newBuilder()
                .setMethodDescriptor(createConnectivityTestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateConnectivityTestRequest, Operation>
        updateConnectivityTestTransportSettings =
            HttpJsonCallSettings.<UpdateConnectivityTestRequest, Operation>newBuilder()
                .setMethodDescriptor(updateConnectivityTestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource.name", String.valueOf(request.getResource().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RerunConnectivityTestRequest, Operation>
        rerunConnectivityTestTransportSettings =
            HttpJsonCallSettings.<RerunConnectivityTestRequest, Operation>newBuilder()
                .setMethodDescriptor(rerunConnectivityTestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteConnectivityTestRequest, Operation>
        deleteConnectivityTestTransportSettings =
            HttpJsonCallSettings.<DeleteConnectivityTestRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConnectivityTestMethodDescriptor)
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
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.listConnectivityTestsCallable =
        callableFactory.createUnaryCallable(
            listConnectivityTestsTransportSettings,
            settings.listConnectivityTestsSettings(),
            clientContext);
    this.listConnectivityTestsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectivityTestsTransportSettings,
            settings.listConnectivityTestsSettings(),
            clientContext);
    this.getConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            getConnectivityTestTransportSettings,
            settings.getConnectivityTestSettings(),
            clientContext);
    this.createConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            createConnectivityTestTransportSettings,
            settings.createConnectivityTestSettings(),
            clientContext);
    this.createConnectivityTestOperationCallable =
        callableFactory.createOperationCallable(
            createConnectivityTestTransportSettings,
            settings.createConnectivityTestOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            updateConnectivityTestTransportSettings,
            settings.updateConnectivityTestSettings(),
            clientContext);
    this.updateConnectivityTestOperationCallable =
        callableFactory.createOperationCallable(
            updateConnectivityTestTransportSettings,
            settings.updateConnectivityTestOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.rerunConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            rerunConnectivityTestTransportSettings,
            settings.rerunConnectivityTestSettings(),
            clientContext);
    this.rerunConnectivityTestOperationCallable =
        callableFactory.createOperationCallable(
            rerunConnectivityTestTransportSettings,
            settings.rerunConnectivityTestOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            deleteConnectivityTestTransportSettings,
            settings.deleteConnectivityTestSettings(),
            clientContext);
    this.deleteConnectivityTestOperationCallable =
        callableFactory.createOperationCallable(
            deleteConnectivityTestTransportSettings,
            settings.deleteConnectivityTestOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listConnectivityTestsMethodDescriptor);
    methodDescriptors.add(getConnectivityTestMethodDescriptor);
    methodDescriptors.add(createConnectivityTestMethodDescriptor);
    methodDescriptors.add(updateConnectivityTestMethodDescriptor);
    methodDescriptors.add(rerunConnectivityTestMethodDescriptor);
    methodDescriptors.add(deleteConnectivityTestMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsResponse>
      listConnectivityTestsCallable() {
    return listConnectivityTestsCallable;
  }

  @Override
  public UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsPagedResponse>
      listConnectivityTestsPagedCallable() {
    return listConnectivityTestsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConnectivityTestRequest, ConnectivityTest> getConnectivityTestCallable() {
    return getConnectivityTestCallable;
  }

  @Override
  public UnaryCallable<CreateConnectivityTestRequest, Operation> createConnectivityTestCallable() {
    return createConnectivityTestCallable;
  }

  @Override
  public OperationCallable<CreateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      createConnectivityTestOperationCallable() {
    return createConnectivityTestOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectivityTestRequest, Operation> updateConnectivityTestCallable() {
    return updateConnectivityTestCallable;
  }

  @Override
  public OperationCallable<UpdateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      updateConnectivityTestOperationCallable() {
    return updateConnectivityTestOperationCallable;
  }

  @Override
  public UnaryCallable<RerunConnectivityTestRequest, Operation> rerunConnectivityTestCallable() {
    return rerunConnectivityTestCallable;
  }

  @Override
  public OperationCallable<RerunConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      rerunConnectivityTestOperationCallable() {
    return rerunConnectivityTestOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectivityTestRequest, Operation> deleteConnectivityTestCallable() {
    return deleteConnectivityTestCallable;
  }

  @Override
  public OperationCallable<DeleteConnectivityTestRequest, Empty, OperationMetadata>
      deleteConnectivityTestOperationCallable() {
    return deleteConnectivityTestOperationCallable;
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
