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

package com.google.cloud.networkservices.v1.stub;

import static com.google.cloud.networkservices.v1.DepServiceClient.ListLbRouteExtensionsPagedResponse;
import static com.google.cloud.networkservices.v1.DepServiceClient.ListLbTrafficExtensionsPagedResponse;
import static com.google.cloud.networkservices.v1.DepServiceClient.ListLocationsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.cloud.networkservices.v1.CreateLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.CreateLbTrafficExtensionRequest;
import com.google.cloud.networkservices.v1.DeleteLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.DeleteLbTrafficExtensionRequest;
import com.google.cloud.networkservices.v1.GetLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.GetLbTrafficExtensionRequest;
import com.google.cloud.networkservices.v1.LbRouteExtension;
import com.google.cloud.networkservices.v1.LbTrafficExtension;
import com.google.cloud.networkservices.v1.ListLbRouteExtensionsRequest;
import com.google.cloud.networkservices.v1.ListLbRouteExtensionsResponse;
import com.google.cloud.networkservices.v1.ListLbTrafficExtensionsRequest;
import com.google.cloud.networkservices.v1.ListLbTrafficExtensionsResponse;
import com.google.cloud.networkservices.v1.OperationMetadata;
import com.google.cloud.networkservices.v1.UpdateLbRouteExtensionRequest;
import com.google.cloud.networkservices.v1.UpdateLbTrafficExtensionRequest;
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
 * REST stub implementation for the DepService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonDepServiceStub extends DepServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(LbRouteExtension.getDescriptor())
          .add(LbTrafficExtension.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>
      listLbTrafficExtensionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/ListLbTrafficExtensions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLbTrafficExtensionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/lbTrafficExtensions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLbTrafficExtensionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLbTrafficExtensionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListLbTrafficExtensionsResponse>newBuilder()
                      .setDefaultInstance(ListLbTrafficExtensionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLbTrafficExtensionRequest, LbTrafficExtension>
      getLbTrafficExtensionMethodDescriptor =
          ApiMethodDescriptor.<GetLbTrafficExtensionRequest, LbTrafficExtension>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.DepService/GetLbTrafficExtension")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLbTrafficExtensionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/lbTrafficExtensions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLbTrafficExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLbTrafficExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LbTrafficExtension>newBuilder()
                      .setDefaultInstance(LbTrafficExtension.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateLbTrafficExtensionRequest, Operation>
      createLbTrafficExtensionMethodDescriptor =
          ApiMethodDescriptor.<CreateLbTrafficExtensionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/CreateLbTrafficExtension")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateLbTrafficExtensionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/lbTrafficExtensions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLbTrafficExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLbTrafficExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "lbTrafficExtensionId", request.getLbTrafficExtensionId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "lbTrafficExtension", request.getLbTrafficExtension(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateLbTrafficExtensionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateLbTrafficExtensionRequest, Operation>
      updateLbTrafficExtensionMethodDescriptor =
          ApiMethodDescriptor.<UpdateLbTrafficExtensionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/UpdateLbTrafficExtension")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateLbTrafficExtensionRequest>newBuilder()
                      .setPath(
                          "/v1/{lbTrafficExtension.name=projects/*/locations/*/lbTrafficExtensions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLbTrafficExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "lbTrafficExtension.name",
                                request.getLbTrafficExtension().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLbTrafficExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "lbTrafficExtension", request.getLbTrafficExtension(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateLbTrafficExtensionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteLbTrafficExtensionRequest, Operation>
      deleteLbTrafficExtensionMethodDescriptor =
          ApiMethodDescriptor.<DeleteLbTrafficExtensionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/DeleteLbTrafficExtension")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteLbTrafficExtensionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/lbTrafficExtensions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLbTrafficExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLbTrafficExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteLbTrafficExtensionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>
      listLbRouteExtensionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.DepService/ListLbRouteExtensions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLbRouteExtensionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/lbRouteExtensions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLbRouteExtensionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLbRouteExtensionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListLbRouteExtensionsResponse>newBuilder()
                      .setDefaultInstance(ListLbRouteExtensionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLbRouteExtensionRequest, LbRouteExtension>
      getLbRouteExtensionMethodDescriptor =
          ApiMethodDescriptor.<GetLbRouteExtensionRequest, LbRouteExtension>newBuilder()
              .setFullMethodName("google.cloud.networkservices.v1.DepService/GetLbRouteExtension")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLbRouteExtensionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/lbRouteExtensions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLbRouteExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLbRouteExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LbRouteExtension>newBuilder()
                      .setDefaultInstance(LbRouteExtension.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateLbRouteExtensionRequest, Operation>
      createLbRouteExtensionMethodDescriptor =
          ApiMethodDescriptor.<CreateLbRouteExtensionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/CreateLbRouteExtension")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateLbRouteExtensionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/lbRouteExtensions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLbRouteExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLbRouteExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "lbRouteExtensionId", request.getLbRouteExtensionId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("lbRouteExtension", request.getLbRouteExtension(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateLbRouteExtensionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateLbRouteExtensionRequest, Operation>
      updateLbRouteExtensionMethodDescriptor =
          ApiMethodDescriptor.<UpdateLbRouteExtensionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/UpdateLbRouteExtension")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateLbRouteExtensionRequest>newBuilder()
                      .setPath(
                          "/v1/{lbRouteExtension.name=projects/*/locations/*/lbRouteExtensions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLbRouteExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "lbRouteExtension.name",
                                request.getLbRouteExtension().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLbRouteExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("lbRouteExtension", request.getLbRouteExtension(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateLbRouteExtensionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteLbRouteExtensionRequest, Operation>
      deleteLbRouteExtensionMethodDescriptor =
          ApiMethodDescriptor.<DeleteLbRouteExtensionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkservices.v1.DepService/DeleteLbRouteExtension")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteLbRouteExtensionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/lbRouteExtensions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLbRouteExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLbRouteExtensionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteLbRouteExtensionRequest request, Operation response) ->
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
                          "/v1/{name=projects/*}/locations",
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
                          "/v1/{name=projects/*/locations/*}",
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/edgeCacheKeysets/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/edgeCacheOrigins/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/edgeCacheServices/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/endpointPolicies/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/serviceBindings/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/meshes/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/gateways/*}:setIamPolicy")
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
                          "/v1/{resource=projects/*/locations/*/edgeCacheKeysets/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/edgeCacheOrigins/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/edgeCacheServices/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/endpointPolicies/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/serviceBindings/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/meshes/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/gateways/*}:getIamPolicy")
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
                          "/v1/{resource=projects/*/locations/*/edgeCacheKeysets/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/edgeCacheOrigins/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/edgeCacheServices/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/endpointPolicies/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/serviceBindings/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/meshes/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/gateways/*}:testIamPermissions")
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

  private final UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>
      listLbTrafficExtensionsCallable;
  private final UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsPagedResponse>
      listLbTrafficExtensionsPagedCallable;
  private final UnaryCallable<GetLbTrafficExtensionRequest, LbTrafficExtension>
      getLbTrafficExtensionCallable;
  private final UnaryCallable<CreateLbTrafficExtensionRequest, Operation>
      createLbTrafficExtensionCallable;
  private final OperationCallable<
          CreateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      createLbTrafficExtensionOperationCallable;
  private final UnaryCallable<UpdateLbTrafficExtensionRequest, Operation>
      updateLbTrafficExtensionCallable;
  private final OperationCallable<
          UpdateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      updateLbTrafficExtensionOperationCallable;
  private final UnaryCallable<DeleteLbTrafficExtensionRequest, Operation>
      deleteLbTrafficExtensionCallable;
  private final OperationCallable<DeleteLbTrafficExtensionRequest, Empty, OperationMetadata>
      deleteLbTrafficExtensionOperationCallable;
  private final UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>
      listLbRouteExtensionsCallable;
  private final UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsPagedResponse>
      listLbRouteExtensionsPagedCallable;
  private final UnaryCallable<GetLbRouteExtensionRequest, LbRouteExtension>
      getLbRouteExtensionCallable;
  private final UnaryCallable<CreateLbRouteExtensionRequest, Operation>
      createLbRouteExtensionCallable;
  private final OperationCallable<
          CreateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      createLbRouteExtensionOperationCallable;
  private final UnaryCallable<UpdateLbRouteExtensionRequest, Operation>
      updateLbRouteExtensionCallable;
  private final OperationCallable<
          UpdateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      updateLbRouteExtensionOperationCallable;
  private final UnaryCallable<DeleteLbRouteExtensionRequest, Operation>
      deleteLbRouteExtensionCallable;
  private final OperationCallable<DeleteLbRouteExtensionRequest, Empty, OperationMetadata>
      deleteLbRouteExtensionOperationCallable;
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

  public static final HttpJsonDepServiceStub create(DepServiceStubSettings settings)
      throws IOException {
    return new HttpJsonDepServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDepServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDepServiceStub(
        DepServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDepServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDepServiceStub(
        DepServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDepServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDepServiceStub(DepServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDepServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDepServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDepServiceStub(
      DepServiceStubSettings settings,
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
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>
        listLbTrafficExtensionsTransportSettings =
            HttpJsonCallSettings
                .<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>newBuilder()
                .setMethodDescriptor(listLbTrafficExtensionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLbTrafficExtensionRequest, LbTrafficExtension>
        getLbTrafficExtensionTransportSettings =
            HttpJsonCallSettings.<GetLbTrafficExtensionRequest, LbTrafficExtension>newBuilder()
                .setMethodDescriptor(getLbTrafficExtensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateLbTrafficExtensionRequest, Operation>
        createLbTrafficExtensionTransportSettings =
            HttpJsonCallSettings.<CreateLbTrafficExtensionRequest, Operation>newBuilder()
                .setMethodDescriptor(createLbTrafficExtensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateLbTrafficExtensionRequest, Operation>
        updateLbTrafficExtensionTransportSettings =
            HttpJsonCallSettings.<UpdateLbTrafficExtensionRequest, Operation>newBuilder()
                .setMethodDescriptor(updateLbTrafficExtensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "lb_traffic_extension.name",
                          String.valueOf(request.getLbTrafficExtension().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteLbTrafficExtensionRequest, Operation>
        deleteLbTrafficExtensionTransportSettings =
            HttpJsonCallSettings.<DeleteLbTrafficExtensionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteLbTrafficExtensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>
        listLbRouteExtensionsTransportSettings =
            HttpJsonCallSettings
                .<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>newBuilder()
                .setMethodDescriptor(listLbRouteExtensionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLbRouteExtensionRequest, LbRouteExtension>
        getLbRouteExtensionTransportSettings =
            HttpJsonCallSettings.<GetLbRouteExtensionRequest, LbRouteExtension>newBuilder()
                .setMethodDescriptor(getLbRouteExtensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateLbRouteExtensionRequest, Operation>
        createLbRouteExtensionTransportSettings =
            HttpJsonCallSettings.<CreateLbRouteExtensionRequest, Operation>newBuilder()
                .setMethodDescriptor(createLbRouteExtensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateLbRouteExtensionRequest, Operation>
        updateLbRouteExtensionTransportSettings =
            HttpJsonCallSettings.<UpdateLbRouteExtensionRequest, Operation>newBuilder()
                .setMethodDescriptor(updateLbRouteExtensionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "lb_route_extension.name",
                          String.valueOf(request.getLbRouteExtension().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteLbRouteExtensionRequest, Operation>
        deleteLbRouteExtensionTransportSettings =
            HttpJsonCallSettings.<DeleteLbRouteExtensionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteLbRouteExtensionMethodDescriptor)
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

    this.listLbTrafficExtensionsCallable =
        callableFactory.createUnaryCallable(
            listLbTrafficExtensionsTransportSettings,
            settings.listLbTrafficExtensionsSettings(),
            clientContext);
    this.listLbTrafficExtensionsPagedCallable =
        callableFactory.createPagedCallable(
            listLbTrafficExtensionsTransportSettings,
            settings.listLbTrafficExtensionsSettings(),
            clientContext);
    this.getLbTrafficExtensionCallable =
        callableFactory.createUnaryCallable(
            getLbTrafficExtensionTransportSettings,
            settings.getLbTrafficExtensionSettings(),
            clientContext);
    this.createLbTrafficExtensionCallable =
        callableFactory.createUnaryCallable(
            createLbTrafficExtensionTransportSettings,
            settings.createLbTrafficExtensionSettings(),
            clientContext);
    this.createLbTrafficExtensionOperationCallable =
        callableFactory.createOperationCallable(
            createLbTrafficExtensionTransportSettings,
            settings.createLbTrafficExtensionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateLbTrafficExtensionCallable =
        callableFactory.createUnaryCallable(
            updateLbTrafficExtensionTransportSettings,
            settings.updateLbTrafficExtensionSettings(),
            clientContext);
    this.updateLbTrafficExtensionOperationCallable =
        callableFactory.createOperationCallable(
            updateLbTrafficExtensionTransportSettings,
            settings.updateLbTrafficExtensionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteLbTrafficExtensionCallable =
        callableFactory.createUnaryCallable(
            deleteLbTrafficExtensionTransportSettings,
            settings.deleteLbTrafficExtensionSettings(),
            clientContext);
    this.deleteLbTrafficExtensionOperationCallable =
        callableFactory.createOperationCallable(
            deleteLbTrafficExtensionTransportSettings,
            settings.deleteLbTrafficExtensionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listLbRouteExtensionsCallable =
        callableFactory.createUnaryCallable(
            listLbRouteExtensionsTransportSettings,
            settings.listLbRouteExtensionsSettings(),
            clientContext);
    this.listLbRouteExtensionsPagedCallable =
        callableFactory.createPagedCallable(
            listLbRouteExtensionsTransportSettings,
            settings.listLbRouteExtensionsSettings(),
            clientContext);
    this.getLbRouteExtensionCallable =
        callableFactory.createUnaryCallable(
            getLbRouteExtensionTransportSettings,
            settings.getLbRouteExtensionSettings(),
            clientContext);
    this.createLbRouteExtensionCallable =
        callableFactory.createUnaryCallable(
            createLbRouteExtensionTransportSettings,
            settings.createLbRouteExtensionSettings(),
            clientContext);
    this.createLbRouteExtensionOperationCallable =
        callableFactory.createOperationCallable(
            createLbRouteExtensionTransportSettings,
            settings.createLbRouteExtensionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateLbRouteExtensionCallable =
        callableFactory.createUnaryCallable(
            updateLbRouteExtensionTransportSettings,
            settings.updateLbRouteExtensionSettings(),
            clientContext);
    this.updateLbRouteExtensionOperationCallable =
        callableFactory.createOperationCallable(
            updateLbRouteExtensionTransportSettings,
            settings.updateLbRouteExtensionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteLbRouteExtensionCallable =
        callableFactory.createUnaryCallable(
            deleteLbRouteExtensionTransportSettings,
            settings.deleteLbRouteExtensionSettings(),
            clientContext);
    this.deleteLbRouteExtensionOperationCallable =
        callableFactory.createOperationCallable(
            deleteLbRouteExtensionTransportSettings,
            settings.deleteLbRouteExtensionOperationSettings(),
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
    methodDescriptors.add(listLbTrafficExtensionsMethodDescriptor);
    methodDescriptors.add(getLbTrafficExtensionMethodDescriptor);
    methodDescriptors.add(createLbTrafficExtensionMethodDescriptor);
    methodDescriptors.add(updateLbTrafficExtensionMethodDescriptor);
    methodDescriptors.add(deleteLbTrafficExtensionMethodDescriptor);
    methodDescriptors.add(listLbRouteExtensionsMethodDescriptor);
    methodDescriptors.add(getLbRouteExtensionMethodDescriptor);
    methodDescriptors.add(createLbRouteExtensionMethodDescriptor);
    methodDescriptors.add(updateLbRouteExtensionMethodDescriptor);
    methodDescriptors.add(deleteLbRouteExtensionMethodDescriptor);
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
  public UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsResponse>
      listLbTrafficExtensionsCallable() {
    return listLbTrafficExtensionsCallable;
  }

  @Override
  public UnaryCallable<ListLbTrafficExtensionsRequest, ListLbTrafficExtensionsPagedResponse>
      listLbTrafficExtensionsPagedCallable() {
    return listLbTrafficExtensionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLbTrafficExtensionRequest, LbTrafficExtension>
      getLbTrafficExtensionCallable() {
    return getLbTrafficExtensionCallable;
  }

  @Override
  public UnaryCallable<CreateLbTrafficExtensionRequest, Operation>
      createLbTrafficExtensionCallable() {
    return createLbTrafficExtensionCallable;
  }

  @Override
  public OperationCallable<CreateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      createLbTrafficExtensionOperationCallable() {
    return createLbTrafficExtensionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateLbTrafficExtensionRequest, Operation>
      updateLbTrafficExtensionCallable() {
    return updateLbTrafficExtensionCallable;
  }

  @Override
  public OperationCallable<UpdateLbTrafficExtensionRequest, LbTrafficExtension, OperationMetadata>
      updateLbTrafficExtensionOperationCallable() {
    return updateLbTrafficExtensionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteLbTrafficExtensionRequest, Operation>
      deleteLbTrafficExtensionCallable() {
    return deleteLbTrafficExtensionCallable;
  }

  @Override
  public OperationCallable<DeleteLbTrafficExtensionRequest, Empty, OperationMetadata>
      deleteLbTrafficExtensionOperationCallable() {
    return deleteLbTrafficExtensionOperationCallable;
  }

  @Override
  public UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsResponse>
      listLbRouteExtensionsCallable() {
    return listLbRouteExtensionsCallable;
  }

  @Override
  public UnaryCallable<ListLbRouteExtensionsRequest, ListLbRouteExtensionsPagedResponse>
      listLbRouteExtensionsPagedCallable() {
    return listLbRouteExtensionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLbRouteExtensionRequest, LbRouteExtension> getLbRouteExtensionCallable() {
    return getLbRouteExtensionCallable;
  }

  @Override
  public UnaryCallable<CreateLbRouteExtensionRequest, Operation> createLbRouteExtensionCallable() {
    return createLbRouteExtensionCallable;
  }

  @Override
  public OperationCallable<CreateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      createLbRouteExtensionOperationCallable() {
    return createLbRouteExtensionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateLbRouteExtensionRequest, Operation> updateLbRouteExtensionCallable() {
    return updateLbRouteExtensionCallable;
  }

  @Override
  public OperationCallable<UpdateLbRouteExtensionRequest, LbRouteExtension, OperationMetadata>
      updateLbRouteExtensionOperationCallable() {
    return updateLbRouteExtensionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteLbRouteExtensionRequest, Operation> deleteLbRouteExtensionCallable() {
    return deleteLbRouteExtensionCallable;
  }

  @Override
  public OperationCallable<DeleteLbRouteExtensionRequest, Empty, OperationMetadata>
      deleteLbRouteExtensionOperationCallable() {
    return deleteLbRouteExtensionOperationCallable;
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
