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

package com.google.cloud.ftp.v1.stub;

import static com.google.cloud.ftp.v1.CloudFtpClient.ListLocationsPagedResponse;
import static com.google.cloud.ftp.v1.CloudFtpClient.ListServersPagedResponse;
import static com.google.cloud.ftp.v1.CloudFtpClient.ListUsersPagedResponse;

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
import com.google.cloud.ftp.v1.CreateServerRequest;
import com.google.cloud.ftp.v1.CreateUserRequest;
import com.google.cloud.ftp.v1.DeleteServerRequest;
import com.google.cloud.ftp.v1.DeleteUserRequest;
import com.google.cloud.ftp.v1.GetServerRequest;
import com.google.cloud.ftp.v1.GetUserRequest;
import com.google.cloud.ftp.v1.ListServersRequest;
import com.google.cloud.ftp.v1.ListServersResponse;
import com.google.cloud.ftp.v1.ListUsersRequest;
import com.google.cloud.ftp.v1.ListUsersResponse;
import com.google.cloud.ftp.v1.OperationMetadata;
import com.google.cloud.ftp.v1.Server;
import com.google.cloud.ftp.v1.StartServerRequest;
import com.google.cloud.ftp.v1.StopServerRequest;
import com.google.cloud.ftp.v1.UpdateServerRequest;
import com.google.cloud.ftp.v1.UpdateUserRequest;
import com.google.cloud.ftp.v1.User;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CloudFtp service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonCloudFtpStub extends CloudFtpStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(User.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Server.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListServersRequest, ListServersResponse>
      listServersMethodDescriptor =
          ApiMethodDescriptor.<ListServersRequest, ListServersResponse>newBuilder()
              .setFullMethodName("google.cloud.ftp.v1.CloudFtp/ListServers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/servers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListServersResponse>newBuilder()
                      .setDefaultInstance(ListServersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServerRequest, Server> getServerMethodDescriptor =
      ApiMethodDescriptor.<GetServerRequest, Server>newBuilder()
          .setFullMethodName("google.cloud.ftp.v1.CloudFtp/GetServer")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetServerRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/servers/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetServerRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetServerRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getViewValue());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Server>newBuilder()
                  .setDefaultInstance(Server.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateServerRequest, Operation>
      createServerMethodDescriptor =
          ApiMethodDescriptor.<CreateServerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ftp.v1.CloudFtp/CreateServer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateServerRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/servers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "serverId", request.getServerId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("server", request.getServer(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateServerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateServerRequest, Operation>
      updateServerMethodDescriptor =
          ApiMethodDescriptor.<UpdateServerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ftp.v1.CloudFtp/UpdateServer")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateServerRequest>newBuilder()
                      .setPath(
                          "/v1/{server.name=projects/*/locations/*/servers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "server.name", request.getServer().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("server", request.getServer(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateServerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteServerRequest, Operation>
      deleteServerMethodDescriptor =
          ApiMethodDescriptor.<DeleteServerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ftp.v1.CloudFtp/DeleteServer")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteServerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/servers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServerRequest> serializer =
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
                  (DeleteServerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListUsersRequest, ListUsersResponse>
      listUsersMethodDescriptor =
          ApiMethodDescriptor.<ListUsersRequest, ListUsersResponse>newBuilder()
              .setFullMethodName("google.cloud.ftp.v1.CloudFtp/ListUsers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUsersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/servers/*}/users",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListUsersResponse>newBuilder()
                      .setDefaultInstance(ListUsersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetUserRequest, User> getUserMethodDescriptor =
      ApiMethodDescriptor.<GetUserRequest, User>newBuilder()
          .setFullMethodName("google.cloud.ftp.v1.CloudFtp/GetUser")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetUserRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/servers/*/users/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getViewValue());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<User>newBuilder()
                  .setDefaultInstance(User.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateUserRequest, Operation>
      createUserMethodDescriptor =
          ApiMethodDescriptor.<CreateUserRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ftp.v1.CloudFtp/CreateUser")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUserRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/servers/*}/users",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "userId", request.getUserId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("user", request.getUser(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateUserRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateUserRequest, Operation>
      updateUserMethodDescriptor =
          ApiMethodDescriptor.<UpdateUserRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ftp.v1.CloudFtp/UpdateUser")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateUserRequest>newBuilder()
                      .setPath(
                          "/v1/{user.name=projects/*/locations/*/servers/*/users/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "user.name", request.getUser().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("user", request.getUser(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateUserRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteUserRequest, Operation>
      deleteUserMethodDescriptor =
          ApiMethodDescriptor.<DeleteUserRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ftp.v1.CloudFtp/DeleteUser")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteUserRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/servers/*/users/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteUserRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StartServerRequest, Operation>
      startServerMethodDescriptor =
          ApiMethodDescriptor.<StartServerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ftp.v1.CloudFtp/StartServer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartServerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/servers/*}:start",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartServerRequest> serializer =
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
                  (StartServerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StopServerRequest, Operation>
      stopServerMethodDescriptor =
          ApiMethodDescriptor.<StopServerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.ftp.v1.CloudFtp/StopServer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StopServerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/servers/*}:stop",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopServerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopServerRequest> serializer =
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
                  (StopServerRequest request, Operation response) ->
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

  private final UnaryCallable<ListServersRequest, ListServersResponse> listServersCallable;
  private final UnaryCallable<ListServersRequest, ListServersPagedResponse>
      listServersPagedCallable;
  private final UnaryCallable<GetServerRequest, Server> getServerCallable;
  private final UnaryCallable<CreateServerRequest, Operation> createServerCallable;
  private final OperationCallable<CreateServerRequest, Server, OperationMetadata>
      createServerOperationCallable;
  private final UnaryCallable<UpdateServerRequest, Operation> updateServerCallable;
  private final OperationCallable<UpdateServerRequest, Server, OperationMetadata>
      updateServerOperationCallable;
  private final UnaryCallable<DeleteServerRequest, Operation> deleteServerCallable;
  private final OperationCallable<DeleteServerRequest, Empty, OperationMetadata>
      deleteServerOperationCallable;
  private final UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable;
  private final UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable;
  private final UnaryCallable<GetUserRequest, User> getUserCallable;
  private final UnaryCallable<CreateUserRequest, Operation> createUserCallable;
  private final OperationCallable<CreateUserRequest, User, OperationMetadata>
      createUserOperationCallable;
  private final UnaryCallable<UpdateUserRequest, Operation> updateUserCallable;
  private final OperationCallable<UpdateUserRequest, User, OperationMetadata>
      updateUserOperationCallable;
  private final UnaryCallable<DeleteUserRequest, Operation> deleteUserCallable;
  private final OperationCallable<DeleteUserRequest, Empty, OperationMetadata>
      deleteUserOperationCallable;
  private final UnaryCallable<StartServerRequest, Operation> startServerCallable;
  private final OperationCallable<StartServerRequest, Server, OperationMetadata>
      startServerOperationCallable;
  private final UnaryCallable<StopServerRequest, Operation> stopServerCallable;
  private final OperationCallable<StopServerRequest, Server, OperationMetadata>
      stopServerOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudFtpStub create(CloudFtpStubSettings settings)
      throws IOException {
    return new HttpJsonCloudFtpStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudFtpStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonCloudFtpStub(CloudFtpStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudFtpStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudFtpStub(
        CloudFtpStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudFtpStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCloudFtpStub(CloudFtpStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCloudFtpCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudFtpStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCloudFtpStub(
      CloudFtpStubSettings settings,
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

    HttpJsonCallSettings<ListServersRequest, ListServersResponse> listServersTransportSettings =
        HttpJsonCallSettings.<ListServersRequest, ListServersResponse>newBuilder()
            .setMethodDescriptor(listServersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetServerRequest, Server> getServerTransportSettings =
        HttpJsonCallSettings.<GetServerRequest, Server>newBuilder()
            .setMethodDescriptor(getServerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateServerRequest, Operation> createServerTransportSettings =
        HttpJsonCallSettings.<CreateServerRequest, Operation>newBuilder()
            .setMethodDescriptor(createServerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateServerRequest, Operation> updateServerTransportSettings =
        HttpJsonCallSettings.<UpdateServerRequest, Operation>newBuilder()
            .setMethodDescriptor(updateServerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("server.name", String.valueOf(request.getServer().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteServerRequest, Operation> deleteServerTransportSettings =
        HttpJsonCallSettings.<DeleteServerRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteServerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListUsersRequest, ListUsersResponse> listUsersTransportSettings =
        HttpJsonCallSettings.<ListUsersRequest, ListUsersResponse>newBuilder()
            .setMethodDescriptor(listUsersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<GetUserRequest, User> getUserTransportSettings =
        HttpJsonCallSettings.<GetUserRequest, User>newBuilder()
            .setMethodDescriptor(getUserMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateUserRequest, Operation> createUserTransportSettings =
        HttpJsonCallSettings.<CreateUserRequest, Operation>newBuilder()
            .setMethodDescriptor(createUserMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateUserRequest, Operation> updateUserTransportSettings =
        HttpJsonCallSettings.<UpdateUserRequest, Operation>newBuilder()
            .setMethodDescriptor(updateUserMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("user.name", String.valueOf(request.getUser().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteUserRequest, Operation> deleteUserTransportSettings =
        HttpJsonCallSettings.<DeleteUserRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteUserMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<StartServerRequest, Operation> startServerTransportSettings =
        HttpJsonCallSettings.<StartServerRequest, Operation>newBuilder()
            .setMethodDescriptor(startServerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<StopServerRequest, Operation> stopServerTransportSettings =
        HttpJsonCallSettings.<StopServerRequest, Operation>newBuilder()
            .setMethodDescriptor(stopServerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
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

    this.listServersCallable =
        callableFactory.createUnaryCallable(
            listServersTransportSettings, settings.listServersSettings(), clientContext);
    this.listServersPagedCallable =
        callableFactory.createPagedCallable(
            listServersTransportSettings, settings.listServersSettings(), clientContext);
    this.getServerCallable =
        callableFactory.createUnaryCallable(
            getServerTransportSettings, settings.getServerSettings(), clientContext);
    this.createServerCallable =
        callableFactory.createUnaryCallable(
            createServerTransportSettings, settings.createServerSettings(), clientContext);
    this.createServerOperationCallable =
        callableFactory.createOperationCallable(
            createServerTransportSettings,
            settings.createServerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateServerCallable =
        callableFactory.createUnaryCallable(
            updateServerTransportSettings, settings.updateServerSettings(), clientContext);
    this.updateServerOperationCallable =
        callableFactory.createOperationCallable(
            updateServerTransportSettings,
            settings.updateServerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteServerCallable =
        callableFactory.createUnaryCallable(
            deleteServerTransportSettings, settings.deleteServerSettings(), clientContext);
    this.deleteServerOperationCallable =
        callableFactory.createOperationCallable(
            deleteServerTransportSettings,
            settings.deleteServerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listUsersCallable =
        callableFactory.createUnaryCallable(
            listUsersTransportSettings, settings.listUsersSettings(), clientContext);
    this.listUsersPagedCallable =
        callableFactory.createPagedCallable(
            listUsersTransportSettings, settings.listUsersSettings(), clientContext);
    this.getUserCallable =
        callableFactory.createUnaryCallable(
            getUserTransportSettings, settings.getUserSettings(), clientContext);
    this.createUserCallable =
        callableFactory.createUnaryCallable(
            createUserTransportSettings, settings.createUserSettings(), clientContext);
    this.createUserOperationCallable =
        callableFactory.createOperationCallable(
            createUserTransportSettings,
            settings.createUserOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateUserCallable =
        callableFactory.createUnaryCallable(
            updateUserTransportSettings, settings.updateUserSettings(), clientContext);
    this.updateUserOperationCallable =
        callableFactory.createOperationCallable(
            updateUserTransportSettings,
            settings.updateUserOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteUserCallable =
        callableFactory.createUnaryCallable(
            deleteUserTransportSettings, settings.deleteUserSettings(), clientContext);
    this.deleteUserOperationCallable =
        callableFactory.createOperationCallable(
            deleteUserTransportSettings,
            settings.deleteUserOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.startServerCallable =
        callableFactory.createUnaryCallable(
            startServerTransportSettings, settings.startServerSettings(), clientContext);
    this.startServerOperationCallable =
        callableFactory.createOperationCallable(
            startServerTransportSettings,
            settings.startServerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.stopServerCallable =
        callableFactory.createUnaryCallable(
            stopServerTransportSettings, settings.stopServerSettings(), clientContext);
    this.stopServerOperationCallable =
        callableFactory.createOperationCallable(
            stopServerTransportSettings,
            settings.stopServerOperationSettings(),
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listServersMethodDescriptor);
    methodDescriptors.add(getServerMethodDescriptor);
    methodDescriptors.add(createServerMethodDescriptor);
    methodDescriptors.add(updateServerMethodDescriptor);
    methodDescriptors.add(deleteServerMethodDescriptor);
    methodDescriptors.add(listUsersMethodDescriptor);
    methodDescriptors.add(getUserMethodDescriptor);
    methodDescriptors.add(createUserMethodDescriptor);
    methodDescriptors.add(updateUserMethodDescriptor);
    methodDescriptors.add(deleteUserMethodDescriptor);
    methodDescriptors.add(startServerMethodDescriptor);
    methodDescriptors.add(stopServerMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListServersRequest, ListServersResponse> listServersCallable() {
    return listServersCallable;
  }

  @Override
  public UnaryCallable<ListServersRequest, ListServersPagedResponse> listServersPagedCallable() {
    return listServersPagedCallable;
  }

  @Override
  public UnaryCallable<GetServerRequest, Server> getServerCallable() {
    return getServerCallable;
  }

  @Override
  public UnaryCallable<CreateServerRequest, Operation> createServerCallable() {
    return createServerCallable;
  }

  @Override
  public OperationCallable<CreateServerRequest, Server, OperationMetadata>
      createServerOperationCallable() {
    return createServerOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateServerRequest, Operation> updateServerCallable() {
    return updateServerCallable;
  }

  @Override
  public OperationCallable<UpdateServerRequest, Server, OperationMetadata>
      updateServerOperationCallable() {
    return updateServerOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServerRequest, Operation> deleteServerCallable() {
    return deleteServerCallable;
  }

  @Override
  public OperationCallable<DeleteServerRequest, Empty, OperationMetadata>
      deleteServerOperationCallable() {
    return deleteServerOperationCallable;
  }

  @Override
  public UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable() {
    return listUsersCallable;
  }

  @Override
  public UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable() {
    return listUsersPagedCallable;
  }

  @Override
  public UnaryCallable<GetUserRequest, User> getUserCallable() {
    return getUserCallable;
  }

  @Override
  public UnaryCallable<CreateUserRequest, Operation> createUserCallable() {
    return createUserCallable;
  }

  @Override
  public OperationCallable<CreateUserRequest, User, OperationMetadata>
      createUserOperationCallable() {
    return createUserOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateUserRequest, Operation> updateUserCallable() {
    return updateUserCallable;
  }

  @Override
  public OperationCallable<UpdateUserRequest, User, OperationMetadata>
      updateUserOperationCallable() {
    return updateUserOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteUserRequest, Operation> deleteUserCallable() {
    return deleteUserCallable;
  }

  @Override
  public OperationCallable<DeleteUserRequest, Empty, OperationMetadata>
      deleteUserOperationCallable() {
    return deleteUserOperationCallable;
  }

  @Override
  public UnaryCallable<StartServerRequest, Operation> startServerCallable() {
    return startServerCallable;
  }

  @Override
  public OperationCallable<StartServerRequest, Server, OperationMetadata>
      startServerOperationCallable() {
    return startServerOperationCallable;
  }

  @Override
  public UnaryCallable<StopServerRequest, Operation> stopServerCallable() {
    return stopServerCallable;
  }

  @Override
  public OperationCallable<StopServerRequest, Server, OperationMetadata>
      stopServerOperationCallable() {
    return stopServerOperationCallable;
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
