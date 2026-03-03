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

package com.google.showcase.v1beta1.stub;

import static com.google.showcase.v1beta1.EchoClient.ListLocationsPagedResponse;
import static com.google.showcase.v1beta1.EchoClient.PagedExpandLegacyMappedPagedResponse;
import static com.google.showcase.v1beta1.EchoClient.PagedExpandPagedResponse;

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
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.TypeRegistry;
import com.google.showcase.v1beta1.BlockRequest;
import com.google.showcase.v1beta1.BlockResponse;
import com.google.showcase.v1beta1.EchoErrorDetailsRequest;
import com.google.showcase.v1beta1.EchoErrorDetailsResponse;
import com.google.showcase.v1beta1.EchoRequest;
import com.google.showcase.v1beta1.EchoResponse;
import com.google.showcase.v1beta1.ExpandRequest;
import com.google.showcase.v1beta1.FailEchoWithDetailsRequest;
import com.google.showcase.v1beta1.FailEchoWithDetailsResponse;
import com.google.showcase.v1beta1.PagedExpandLegacyMappedResponse;
import com.google.showcase.v1beta1.PagedExpandLegacyRequest;
import com.google.showcase.v1beta1.PagedExpandRequest;
import com.google.showcase.v1beta1.PagedExpandResponse;
import com.google.showcase.v1beta1.WaitMetadata;
import com.google.showcase.v1beta1.WaitRequest;
import com.google.showcase.v1beta1.WaitResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Echo service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonEchoStub extends EchoStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(WaitResponse.getDescriptor())
          .add(WaitMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<EchoRequest, EchoResponse> echoMethodDescriptor =
      ApiMethodDescriptor.<EchoRequest, EchoResponse>newBuilder()
          .setFullMethodName("google.showcase.v1beta1.Echo/Echo")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<EchoRequest>newBuilder()
                  .setPath(
                      "/v1beta1/echo:echo",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<EchoRequest> serializer = ProtoRestSerializer.create();
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<EchoRequest> serializer = ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<EchoResponse>newBuilder()
                  .setDefaultInstance(EchoResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<EchoErrorDetailsRequest, EchoErrorDetailsResponse>
      echoErrorDetailsMethodDescriptor =
          ApiMethodDescriptor.<EchoErrorDetailsRequest, EchoErrorDetailsResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Echo/EchoErrorDetails")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EchoErrorDetailsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/echo:error-details",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EchoErrorDetailsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EchoErrorDetailsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EchoErrorDetailsResponse>newBuilder()
                      .setDefaultInstance(EchoErrorDetailsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>
      failEchoWithDetailsMethodDescriptor =
          ApiMethodDescriptor.<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Echo/FailEchoWithDetails")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FailEchoWithDetailsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/echo:failWithDetails",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FailEchoWithDetailsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FailEchoWithDetailsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FailEchoWithDetailsResponse>newBuilder()
                      .setDefaultInstance(FailEchoWithDetailsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExpandRequest, EchoResponse> expandMethodDescriptor =
      ApiMethodDescriptor.<ExpandRequest, EchoResponse>newBuilder()
          .setFullMethodName("google.showcase.v1beta1.Echo/Expand")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ExpandRequest>newBuilder()
                  .setPath(
                      "/v1beta1/echo:expand",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ExpandRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ExpandRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<EchoResponse>newBuilder()
                  .setDefaultInstance(EchoResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<PagedExpandRequest, PagedExpandResponse>
      pagedExpandMethodDescriptor =
          ApiMethodDescriptor.<PagedExpandRequest, PagedExpandResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Echo/PagedExpand")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PagedExpandRequest>newBuilder()
                      .setPath(
                          "/v1beta1/echo:pagedExpand",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PagedExpandRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PagedExpandRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PagedExpandResponse>newBuilder()
                      .setDefaultInstance(PagedExpandResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PagedExpandLegacyRequest, PagedExpandResponse>
      pagedExpandLegacyMethodDescriptor =
          ApiMethodDescriptor.<PagedExpandLegacyRequest, PagedExpandResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Echo/PagedExpandLegacy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PagedExpandLegacyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/echo:pagedExpandLegacy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PagedExpandLegacyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PagedExpandLegacyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PagedExpandResponse>newBuilder()
                      .setDefaultInstance(PagedExpandResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PagedExpandRequest, PagedExpandLegacyMappedResponse>
      pagedExpandLegacyMappedMethodDescriptor =
          ApiMethodDescriptor.<PagedExpandRequest, PagedExpandLegacyMappedResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Echo/PagedExpandLegacyMapped")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PagedExpandRequest>newBuilder()
                      .setPath(
                          "/v1beta1/echo:pagedExpandLegacyMapped",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PagedExpandRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PagedExpandRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PagedExpandLegacyMappedResponse>newBuilder()
                      .setDefaultInstance(PagedExpandLegacyMappedResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<WaitRequest, Operation> waitMethodDescriptor =
      ApiMethodDescriptor.<WaitRequest, Operation>newBuilder()
          .setFullMethodName("google.showcase.v1beta1.Echo/Wait")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<WaitRequest>newBuilder()
                  .setPath(
                      "/v1beta1/echo:wait",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<WaitRequest> serializer = ProtoRestSerializer.create();
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<WaitRequest> serializer = ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (WaitRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<BlockRequest, BlockResponse> blockMethodDescriptor =
      ApiMethodDescriptor.<BlockRequest, BlockResponse>newBuilder()
          .setFullMethodName("google.showcase.v1beta1.Echo/Block")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<BlockRequest>newBuilder()
                  .setPath(
                      "/v1beta1/echo:block",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<BlockRequest> serializer = ProtoRestSerializer.create();
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<BlockRequest> serializer = ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<BlockResponse>newBuilder()
                  .setDefaultInstance(BlockResponse.getDefaultInstance())
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
                          "/v1beta1/{resource=users/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=rooms/*}:setIamPolicy",
                          "/v1beta1/{resource=rooms/*/blurbs/*}:setIamPolicy",
                          "/v1beta1/{resource=sequences/*}:setIamPolicy")
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

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=users/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=rooms/*}:getIamPolicy",
                          "/v1beta1/{resource=rooms/*/blurbs/*}:getIamPolicy",
                          "/v1beta1/{resource=sequences/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
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
                          "/v1beta1/{resource=users/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=rooms/*}:testIamPermissions",
                          "/v1beta1/{resource=rooms/*/blurbs/*}:testIamPermissions",
                          "/v1beta1/{resource=sequences/*}:testIamPermissions")
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

  private final UnaryCallable<EchoRequest, EchoResponse> echoCallable;
  private final UnaryCallable<EchoErrorDetailsRequest, EchoErrorDetailsResponse>
      echoErrorDetailsCallable;
  private final UnaryCallable<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>
      failEchoWithDetailsCallable;
  private final ServerStreamingCallable<ExpandRequest, EchoResponse> expandCallable;
  private final UnaryCallable<PagedExpandRequest, PagedExpandResponse> pagedExpandCallable;
  private final UnaryCallable<PagedExpandRequest, PagedExpandPagedResponse>
      pagedExpandPagedCallable;
  private final UnaryCallable<PagedExpandLegacyRequest, PagedExpandResponse>
      pagedExpandLegacyCallable;
  private final UnaryCallable<PagedExpandRequest, PagedExpandLegacyMappedResponse>
      pagedExpandLegacyMappedCallable;
  private final UnaryCallable<PagedExpandRequest, PagedExpandLegacyMappedPagedResponse>
      pagedExpandLegacyMappedPagedCallable;
  private final UnaryCallable<WaitRequest, Operation> waitCallable;
  private final OperationCallable<WaitRequest, WaitResponse, WaitMetadata> waitOperationCallable;
  private final UnaryCallable<BlockRequest, BlockResponse> blockCallable;
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

  private static final PathTemplate ECHO_0_PATH_TEMPLATE = PathTemplate.create("{header=**}");
  private static final PathTemplate ECHO_1_PATH_TEMPLATE = PathTemplate.create("{routing_id=**}");
  private static final PathTemplate ECHO_2_PATH_TEMPLATE =
      PathTemplate.create("{table_name=regions/*/zones/*/**}");
  private static final PathTemplate ECHO_3_PATH_TEMPLATE =
      PathTemplate.create("{super_id=projects/*}/**");
  private static final PathTemplate ECHO_4_PATH_TEMPLATE =
      PathTemplate.create("{table_name=projects/*/instances/*/**}");
  private static final PathTemplate ECHO_5_PATH_TEMPLATE =
      PathTemplate.create("projects/*/{instance_id=instances/*}/**");
  private static final PathTemplate ECHO_6_PATH_TEMPLATE = PathTemplate.create("{baz=**}");
  private static final PathTemplate ECHO_7_PATH_TEMPLATE =
      PathTemplate.create("{qux=projects/*}/**");

  public static final HttpJsonEchoStub create(EchoStubSettings settings) throws IOException {
    return new HttpJsonEchoStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEchoStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonEchoStub(EchoStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEchoStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEchoStub(
        EchoStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEchoStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HttpJsonEchoStub(EchoStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonEchoCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEchoStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HttpJsonEchoStub(
      EchoStubSettings settings,
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
                    HttpRule.newBuilder().setPost("/v1beta1/{name=operations/**}:cancel").build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder().setDelete("/v1beta1/{name=operations/**}").build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder().setGet("/v1beta1/{name=operations/**}").build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder().setGet("/v1beta1/operations").build())
                .build());

    HttpJsonCallSettings<EchoRequest, EchoResponse> echoTransportSettings =
        HttpJsonCallSettings.<EchoRequest, EchoResponse>newBuilder()
            .setMethodDescriptor(echoMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getHeader(), "header", ECHO_0_PATH_TEMPLATE);
                  builder.add(request.getHeader(), "routing_id", ECHO_1_PATH_TEMPLATE);
                  builder.add(request.getHeader(), "table_name", ECHO_2_PATH_TEMPLATE);
                  builder.add(request.getHeader(), "super_id", ECHO_3_PATH_TEMPLATE);
                  builder.add(request.getHeader(), "table_name", ECHO_4_PATH_TEMPLATE);
                  builder.add(request.getHeader(), "instance_id", ECHO_5_PATH_TEMPLATE);
                  builder.add(request.getOtherHeader(), "baz", ECHO_6_PATH_TEMPLATE);
                  builder.add(request.getOtherHeader(), "qux", ECHO_7_PATH_TEMPLATE);
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  EchoRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  if (Strings.isNullOrEmpty(request.getOtherRequestId())) {
                    requestBuilder.setOtherRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .build();
    HttpJsonCallSettings<EchoErrorDetailsRequest, EchoErrorDetailsResponse>
        echoErrorDetailsTransportSettings =
            HttpJsonCallSettings.<EchoErrorDetailsRequest, EchoErrorDetailsResponse>newBuilder()
                .setMethodDescriptor(echoErrorDetailsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>
        failEchoWithDetailsTransportSettings =
            HttpJsonCallSettings
                .<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>newBuilder()
                .setMethodDescriptor(failEchoWithDetailsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ExpandRequest, EchoResponse> expandTransportSettings =
        HttpJsonCallSettings.<ExpandRequest, EchoResponse>newBuilder()
            .setMethodDescriptor(expandMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PagedExpandRequest, PagedExpandResponse> pagedExpandTransportSettings =
        HttpJsonCallSettings.<PagedExpandRequest, PagedExpandResponse>newBuilder()
            .setMethodDescriptor(pagedExpandMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PagedExpandLegacyRequest, PagedExpandResponse>
        pagedExpandLegacyTransportSettings =
            HttpJsonCallSettings.<PagedExpandLegacyRequest, PagedExpandResponse>newBuilder()
                .setMethodDescriptor(pagedExpandLegacyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PagedExpandRequest, PagedExpandLegacyMappedResponse>
        pagedExpandLegacyMappedTransportSettings =
            HttpJsonCallSettings.<PagedExpandRequest, PagedExpandLegacyMappedResponse>newBuilder()
                .setMethodDescriptor(pagedExpandLegacyMappedMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<WaitRequest, Operation> waitTransportSettings =
        HttpJsonCallSettings.<WaitRequest, Operation>newBuilder()
            .setMethodDescriptor(waitMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BlockRequest, BlockResponse> blockTransportSettings =
        HttpJsonCallSettings.<BlockRequest, BlockResponse>newBuilder()
            .setMethodDescriptor(blockMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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

    this.echoCallable =
        callableFactory.createUnaryCallable(
            echoTransportSettings, settings.echoSettings(), clientContext);
    this.echoErrorDetailsCallable =
        callableFactory.createUnaryCallable(
            echoErrorDetailsTransportSettings, settings.echoErrorDetailsSettings(), clientContext);
    this.failEchoWithDetailsCallable =
        callableFactory.createUnaryCallable(
            failEchoWithDetailsTransportSettings,
            settings.failEchoWithDetailsSettings(),
            clientContext);
    this.expandCallable =
        callableFactory.createServerStreamingCallable(
            expandTransportSettings, settings.expandSettings(), clientContext);
    this.pagedExpandCallable =
        callableFactory.createUnaryCallable(
            pagedExpandTransportSettings, settings.pagedExpandSettings(), clientContext);
    this.pagedExpandPagedCallable =
        callableFactory.createPagedCallable(
            pagedExpandTransportSettings, settings.pagedExpandSettings(), clientContext);
    this.pagedExpandLegacyCallable =
        callableFactory.createUnaryCallable(
            pagedExpandLegacyTransportSettings,
            settings.pagedExpandLegacySettings(),
            clientContext);
    this.pagedExpandLegacyMappedCallable =
        callableFactory.createUnaryCallable(
            pagedExpandLegacyMappedTransportSettings,
            settings.pagedExpandLegacyMappedSettings(),
            clientContext);
    this.pagedExpandLegacyMappedPagedCallable =
        callableFactory.createPagedCallable(
            pagedExpandLegacyMappedTransportSettings,
            settings.pagedExpandLegacyMappedSettings(),
            clientContext);
    this.waitCallable =
        callableFactory.createUnaryCallable(
            waitTransportSettings, settings.waitSettings(), clientContext);
    this.waitOperationCallable =
        callableFactory.createOperationCallable(
            waitTransportSettings,
            settings.waitOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.blockCallable =
        callableFactory.createUnaryCallable(
            blockTransportSettings, settings.blockSettings(), clientContext);
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
    methodDescriptors.add(echoMethodDescriptor);
    methodDescriptors.add(echoErrorDetailsMethodDescriptor);
    methodDescriptors.add(failEchoWithDetailsMethodDescriptor);
    methodDescriptors.add(expandMethodDescriptor);
    methodDescriptors.add(pagedExpandMethodDescriptor);
    methodDescriptors.add(pagedExpandLegacyMethodDescriptor);
    methodDescriptors.add(pagedExpandLegacyMappedMethodDescriptor);
    methodDescriptors.add(waitMethodDescriptor);
    methodDescriptors.add(blockMethodDescriptor);
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
  public UnaryCallable<EchoRequest, EchoResponse> echoCallable() {
    return echoCallable;
  }

  @Override
  public UnaryCallable<EchoErrorDetailsRequest, EchoErrorDetailsResponse>
      echoErrorDetailsCallable() {
    return echoErrorDetailsCallable;
  }

  @Override
  public UnaryCallable<FailEchoWithDetailsRequest, FailEchoWithDetailsResponse>
      failEchoWithDetailsCallable() {
    return failEchoWithDetailsCallable;
  }

  @Override
  public ServerStreamingCallable<ExpandRequest, EchoResponse> expandCallable() {
    return expandCallable;
  }

  @Override
  public UnaryCallable<PagedExpandRequest, PagedExpandResponse> pagedExpandCallable() {
    return pagedExpandCallable;
  }

  @Override
  public UnaryCallable<PagedExpandRequest, PagedExpandPagedResponse> pagedExpandPagedCallable() {
    return pagedExpandPagedCallable;
  }

  @Override
  public UnaryCallable<PagedExpandLegacyRequest, PagedExpandResponse> pagedExpandLegacyCallable() {
    return pagedExpandLegacyCallable;
  }

  @Override
  public UnaryCallable<PagedExpandRequest, PagedExpandLegacyMappedResponse>
      pagedExpandLegacyMappedCallable() {
    return pagedExpandLegacyMappedCallable;
  }

  @Override
  public UnaryCallable<PagedExpandRequest, PagedExpandLegacyMappedPagedResponse>
      pagedExpandLegacyMappedPagedCallable() {
    return pagedExpandLegacyMappedPagedCallable;
  }

  @Override
  public UnaryCallable<WaitRequest, Operation> waitCallable() {
    return waitCallable;
  }

  @Override
  public OperationCallable<WaitRequest, WaitResponse, WaitMetadata> waitOperationCallable() {
    return waitOperationCallable;
  }

  @Override
  public UnaryCallable<BlockRequest, BlockResponse> blockCallable() {
    return blockCallable;
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
  public ClientStreamingCallable<EchoRequest, EchoResponse> collectCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: collectCallable(). REST transport is not implemented for this method"
            + " yet.");
  }

  @Override
  public BidiStreamingCallable<EchoRequest, EchoResponse> chatCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: chatCallable(). REST transport is not implemented for this method yet.");
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
