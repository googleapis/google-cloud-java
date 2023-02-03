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

package com.google.cloud.datastream.v1alpha1.stub;

import static com.google.cloud.datastream.v1alpha1.DatastreamClient.FetchStaticIpsPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListPrivateConnectionsPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListRoutesPagedResponse;
import static com.google.cloud.datastream.v1alpha1.DatastreamClient.ListStreamsPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datastream.v1alpha1.ConnectionProfile;
import com.google.cloud.datastream.v1alpha1.CreateConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.CreatePrivateConnectionRequest;
import com.google.cloud.datastream.v1alpha1.CreateRouteRequest;
import com.google.cloud.datastream.v1alpha1.CreateStreamRequest;
import com.google.cloud.datastream.v1alpha1.DeleteConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.DeletePrivateConnectionRequest;
import com.google.cloud.datastream.v1alpha1.DeleteRouteRequest;
import com.google.cloud.datastream.v1alpha1.DeleteStreamRequest;
import com.google.cloud.datastream.v1alpha1.DiscoverConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.DiscoverConnectionProfileResponse;
import com.google.cloud.datastream.v1alpha1.FetchErrorsRequest;
import com.google.cloud.datastream.v1alpha1.FetchErrorsResponse;
import com.google.cloud.datastream.v1alpha1.FetchStaticIpsRequest;
import com.google.cloud.datastream.v1alpha1.FetchStaticIpsResponse;
import com.google.cloud.datastream.v1alpha1.GetConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.GetPrivateConnectionRequest;
import com.google.cloud.datastream.v1alpha1.GetRouteRequest;
import com.google.cloud.datastream.v1alpha1.GetStreamRequest;
import com.google.cloud.datastream.v1alpha1.ListConnectionProfilesRequest;
import com.google.cloud.datastream.v1alpha1.ListConnectionProfilesResponse;
import com.google.cloud.datastream.v1alpha1.ListPrivateConnectionsRequest;
import com.google.cloud.datastream.v1alpha1.ListPrivateConnectionsResponse;
import com.google.cloud.datastream.v1alpha1.ListRoutesRequest;
import com.google.cloud.datastream.v1alpha1.ListRoutesResponse;
import com.google.cloud.datastream.v1alpha1.ListStreamsRequest;
import com.google.cloud.datastream.v1alpha1.ListStreamsResponse;
import com.google.cloud.datastream.v1alpha1.OperationMetadata;
import com.google.cloud.datastream.v1alpha1.PrivateConnection;
import com.google.cloud.datastream.v1alpha1.Route;
import com.google.cloud.datastream.v1alpha1.Stream;
import com.google.cloud.datastream.v1alpha1.UpdateConnectionProfileRequest;
import com.google.cloud.datastream.v1alpha1.UpdateStreamRequest;
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
 * REST stub implementation for the Datastream service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonDatastreamStub extends DatastreamStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Route.getDescriptor())
          .add(FetchErrorsResponse.getDescriptor())
          .add(ConnectionProfile.getDescriptor())
          .add(Stream.getDescriptor())
          .add(PrivateConnection.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesMethodDescriptor =
          ApiMethodDescriptor
              .<ListConnectionProfilesRequest, ListConnectionProfilesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/ListConnectionProfiles")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConnectionProfilesRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*}/connectionProfiles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectionProfilesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectionProfilesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListConnectionProfilesResponse>newBuilder()
                      .setDefaultInstance(ListConnectionProfilesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileMethodDescriptor =
          ApiMethodDescriptor.<GetConnectionProfileRequest, ConnectionProfile>newBuilder()
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/GetConnectionProfile")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConnectionProfileRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/connectionProfiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectionProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectionProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConnectionProfile>newBuilder()
                      .setDefaultInstance(ConnectionProfile.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateConnectionProfileRequest, Operation>
      createConnectionProfileMethodDescriptor =
          ApiMethodDescriptor.<CreateConnectionProfileRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/CreateConnectionProfile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConnectionProfileRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*}/connectionProfiles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectionProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectionProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "connectionProfileId", request.getConnectionProfileId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "connectionProfile", request.getConnectionProfile(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateConnectionProfileRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileMethodDescriptor =
          ApiMethodDescriptor.<UpdateConnectionProfileRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/UpdateConnectionProfile")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConnectionProfileRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{connectionProfile.name=projects/*/locations/*/connectionProfiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectionProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "connectionProfile.name",
                                request.getConnectionProfile().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectionProfileRequest> serializer =
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
                                      "connectionProfile", request.getConnectionProfile(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateConnectionProfileRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileMethodDescriptor =
          ApiMethodDescriptor.<DeleteConnectionProfileRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/DeleteConnectionProfile")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConnectionProfileRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/connectionProfiles/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectionProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectionProfileRequest> serializer =
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
                  (DeleteConnectionProfileRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
      discoverConnectionProfileMethodDescriptor =
          ApiMethodDescriptor
              .<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/DiscoverConnectionProfile")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DiscoverConnectionProfileRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*}/connectionProfiles:discover",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DiscoverConnectionProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DiscoverConnectionProfileRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DiscoverConnectionProfileResponse>newBuilder()
                      .setDefaultInstance(DiscoverConnectionProfileResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListStreamsRequest, ListStreamsResponse>
      listStreamsMethodDescriptor =
          ApiMethodDescriptor.<ListStreamsRequest, ListStreamsResponse>newBuilder()
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/ListStreams")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListStreamsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*}/streams",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListStreamsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListStreamsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListStreamsResponse>newBuilder()
                      .setDefaultInstance(ListStreamsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetStreamRequest, Stream> getStreamMethodDescriptor =
      ApiMethodDescriptor.<GetStreamRequest, Stream>newBuilder()
          .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/GetStream")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetStreamRequest>newBuilder()
                  .setPath(
                      "/v1alpha1/{name=projects/*/locations/*/streams/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetStreamRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetStreamRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Stream>newBuilder()
                  .setDefaultInstance(Stream.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateStreamRequest, Operation>
      createStreamMethodDescriptor =
          ApiMethodDescriptor.<CreateStreamRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/CreateStream")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateStreamRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*}/streams",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "streamId", request.getStreamId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("stream", request.getStream(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateStreamRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateStreamRequest, Operation>
      updateStreamMethodDescriptor =
          ApiMethodDescriptor.<UpdateStreamRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/UpdateStream")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateStreamRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{stream.name=projects/*/locations/*/streams/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "stream.name", request.getStream().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                                  .toBody("stream", request.getStream(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateStreamRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteStreamRequest, Operation>
      deleteStreamMethodDescriptor =
          ApiMethodDescriptor.<DeleteStreamRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/DeleteStream")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteStreamRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/streams/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteStreamRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteStreamRequest> serializer =
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
                  (DeleteStreamRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<FetchErrorsRequest, Operation>
      fetchErrorsMethodDescriptor =
          ApiMethodDescriptor.<FetchErrorsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/FetchErrors")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchErrorsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{stream=projects/*/locations/*/streams/*}:fetchErrors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchErrorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "stream", request.getStream());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchErrorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearStream().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (FetchErrorsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<FetchStaticIpsRequest, FetchStaticIpsResponse>
      fetchStaticIpsMethodDescriptor =
          ApiMethodDescriptor.<FetchStaticIpsRequest, FetchStaticIpsResponse>newBuilder()
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/FetchStaticIps")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchStaticIpsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*}:fetchStaticIps",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchStaticIpsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchStaticIpsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchStaticIpsResponse>newBuilder()
                      .setDefaultInstance(FetchStaticIpsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionMethodDescriptor =
          ApiMethodDescriptor.<CreatePrivateConnectionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/CreatePrivateConnection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePrivateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*}/privateConnections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePrivateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "privateConnectionId", request.getPrivateConnectionId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "privateConnection", request.getPrivateConnection(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePrivateConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionMethodDescriptor =
          ApiMethodDescriptor.<GetPrivateConnectionRequest, PrivateConnection>newBuilder()
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/GetPrivateConnection")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPrivateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/privateConnections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPrivateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PrivateConnection>newBuilder()
                      .setDefaultInstance(PrivateConnection.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/ListPrivateConnections")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPrivateConnectionsRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*}/privateConnections",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateConnectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPrivateConnectionsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListPrivateConnectionsResponse>newBuilder()
                      .setDefaultInstance(ListPrivateConnectionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionMethodDescriptor =
          ApiMethodDescriptor.<DeletePrivateConnectionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.datastream.v1alpha1.Datastream/DeletePrivateConnection")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePrivateConnectionRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/privateConnections/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePrivateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePrivateConnectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeletePrivateConnectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateRouteRequest, Operation>
      createRouteMethodDescriptor =
          ApiMethodDescriptor.<CreateRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/CreateRoute")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRouteRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*/privateConnections/*}/routes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "routeId", request.getRouteId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("route", request.getRoute(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetRouteRequest, Route> getRouteMethodDescriptor =
      ApiMethodDescriptor.<GetRouteRequest, Route>newBuilder()
          .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/GetRoute")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRouteRequest>newBuilder()
                  .setPath(
                      "/v1alpha1/{name=projects/*/locations/*/privateConnections/*/routes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRouteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRouteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Route>newBuilder()
                  .setDefaultInstance(Route.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListRoutesRequest, ListRoutesResponse>
      listRoutesMethodDescriptor =
          ApiMethodDescriptor.<ListRoutesRequest, ListRoutesResponse>newBuilder()
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/ListRoutes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRoutesRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{parent=projects/*/locations/*/privateConnections/*}/routes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRoutesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRoutesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListRoutesResponse>newBuilder()
                      .setDefaultInstance(ListRoutesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRouteRequest, Operation>
      deleteRouteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRouteRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.datastream.v1alpha1.Datastream/DeleteRoute")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRouteRequest>newBuilder()
                      .setPath(
                          "/v1alpha1/{name=projects/*/locations/*/privateConnections/*/routes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRouteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRouteRequest> serializer =
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
                  (DeleteRouteRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesCallable;
  private final UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesPagedResponse>
      listConnectionProfilesPagedCallable;
  private final UnaryCallable<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileCallable;
  private final UnaryCallable<CreateConnectionProfileRequest, Operation>
      createConnectionProfileCallable;
  private final OperationCallable<
          CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationCallable;
  private final UnaryCallable<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileCallable;
  private final OperationCallable<
          UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationCallable;
  private final UnaryCallable<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileCallable;
  private final OperationCallable<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationCallable;
  private final UnaryCallable<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
      discoverConnectionProfileCallable;
  private final UnaryCallable<ListStreamsRequest, ListStreamsResponse> listStreamsCallable;
  private final UnaryCallable<ListStreamsRequest, ListStreamsPagedResponse>
      listStreamsPagedCallable;
  private final UnaryCallable<GetStreamRequest, Stream> getStreamCallable;
  private final UnaryCallable<CreateStreamRequest, Operation> createStreamCallable;
  private final OperationCallable<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationCallable;
  private final UnaryCallable<UpdateStreamRequest, Operation> updateStreamCallable;
  private final OperationCallable<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationCallable;
  private final UnaryCallable<DeleteStreamRequest, Operation> deleteStreamCallable;
  private final OperationCallable<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationCallable;
  private final UnaryCallable<FetchErrorsRequest, Operation> fetchErrorsCallable;
  private final OperationCallable<FetchErrorsRequest, FetchErrorsResponse, OperationMetadata>
      fetchErrorsOperationCallable;
  private final UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsResponse> fetchStaticIpsCallable;
  private final UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsPagedResponse>
      fetchStaticIpsPagedCallable;
  private final UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable;
  private final OperationCallable<
          CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable;
  private final UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable;
  private final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable;
  private final UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable;
  private final UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable;
  private final OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable;
  private final UnaryCallable<CreateRouteRequest, Operation> createRouteCallable;
  private final OperationCallable<CreateRouteRequest, Route, OperationMetadata>
      createRouteOperationCallable;
  private final UnaryCallable<GetRouteRequest, Route> getRouteCallable;
  private final UnaryCallable<ListRoutesRequest, ListRoutesResponse> listRoutesCallable;
  private final UnaryCallable<ListRoutesRequest, ListRoutesPagedResponse> listRoutesPagedCallable;
  private final UnaryCallable<DeleteRouteRequest, Operation> deleteRouteCallable;
  private final OperationCallable<DeleteRouteRequest, Empty, OperationMetadata>
      deleteRouteOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDatastreamStub create(DatastreamStubSettings settings)
      throws IOException {
    return new HttpJsonDatastreamStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDatastreamStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDatastreamStub(
        DatastreamStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDatastreamStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDatastreamStub(
        DatastreamStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDatastreamStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDatastreamStub(DatastreamStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDatastreamCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDatastreamStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDatastreamStub(
      DatastreamStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
        listConnectionProfilesTransportSettings =
            HttpJsonCallSettings
                .<ListConnectionProfilesRequest, ListConnectionProfilesResponse>newBuilder()
                .setMethodDescriptor(listConnectionProfilesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetConnectionProfileRequest, ConnectionProfile>
        getConnectionProfileTransportSettings =
            HttpJsonCallSettings.<GetConnectionProfileRequest, ConnectionProfile>newBuilder()
                .setMethodDescriptor(getConnectionProfileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateConnectionProfileRequest, Operation>
        createConnectionProfileTransportSettings =
            HttpJsonCallSettings.<CreateConnectionProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(createConnectionProfileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateConnectionProfileRequest, Operation>
        updateConnectionProfileTransportSettings =
            HttpJsonCallSettings.<UpdateConnectionProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(updateConnectionProfileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteConnectionProfileRequest, Operation>
        deleteConnectionProfileTransportSettings =
            HttpJsonCallSettings.<DeleteConnectionProfileRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConnectionProfileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
        discoverConnectionProfileTransportSettings =
            HttpJsonCallSettings
                .<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>newBuilder()
                .setMethodDescriptor(discoverConnectionProfileMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListStreamsRequest, ListStreamsResponse> listStreamsTransportSettings =
        HttpJsonCallSettings.<ListStreamsRequest, ListStreamsResponse>newBuilder()
            .setMethodDescriptor(listStreamsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetStreamRequest, Stream> getStreamTransportSettings =
        HttpJsonCallSettings.<GetStreamRequest, Stream>newBuilder()
            .setMethodDescriptor(getStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateStreamRequest, Operation> createStreamTransportSettings =
        HttpJsonCallSettings.<CreateStreamRequest, Operation>newBuilder()
            .setMethodDescriptor(createStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateStreamRequest, Operation> updateStreamTransportSettings =
        HttpJsonCallSettings.<UpdateStreamRequest, Operation>newBuilder()
            .setMethodDescriptor(updateStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteStreamRequest, Operation> deleteStreamTransportSettings =
        HttpJsonCallSettings.<DeleteStreamRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteStreamMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<FetchErrorsRequest, Operation> fetchErrorsTransportSettings =
        HttpJsonCallSettings.<FetchErrorsRequest, Operation>newBuilder()
            .setMethodDescriptor(fetchErrorsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<FetchStaticIpsRequest, FetchStaticIpsResponse>
        fetchStaticIpsTransportSettings =
            HttpJsonCallSettings.<FetchStaticIpsRequest, FetchStaticIpsResponse>newBuilder()
                .setMethodDescriptor(fetchStaticIpsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionTransportSettings =
            HttpJsonCallSettings.<CreatePrivateConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(createPrivateConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionTransportSettings =
            HttpJsonCallSettings.<GetPrivateConnectionRequest, PrivateConnection>newBuilder()
                .setMethodDescriptor(getPrivateConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
        listPrivateConnectionsTransportSettings =
            HttpJsonCallSettings
                .<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>newBuilder()
                .setMethodDescriptor(listPrivateConnectionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionTransportSettings =
            HttpJsonCallSettings.<DeletePrivateConnectionRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePrivateConnectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateRouteRequest, Operation> createRouteTransportSettings =
        HttpJsonCallSettings.<CreateRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(createRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetRouteRequest, Route> getRouteTransportSettings =
        HttpJsonCallSettings.<GetRouteRequest, Route>newBuilder()
            .setMethodDescriptor(getRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRoutesRequest, ListRoutesResponse> listRoutesTransportSettings =
        HttpJsonCallSettings.<ListRoutesRequest, ListRoutesResponse>newBuilder()
            .setMethodDescriptor(listRoutesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteRouteRequest, Operation> deleteRouteTransportSettings =
        HttpJsonCallSettings.<DeleteRouteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRouteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listConnectionProfilesCallable =
        callableFactory.createUnaryCallable(
            listConnectionProfilesTransportSettings,
            settings.listConnectionProfilesSettings(),
            clientContext);
    this.listConnectionProfilesPagedCallable =
        callableFactory.createPagedCallable(
            listConnectionProfilesTransportSettings,
            settings.listConnectionProfilesSettings(),
            clientContext);
    this.getConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            getConnectionProfileTransportSettings,
            settings.getConnectionProfileSettings(),
            clientContext);
    this.createConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            createConnectionProfileTransportSettings,
            settings.createConnectionProfileSettings(),
            clientContext);
    this.createConnectionProfileOperationCallable =
        callableFactory.createOperationCallable(
            createConnectionProfileTransportSettings,
            settings.createConnectionProfileOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            updateConnectionProfileTransportSettings,
            settings.updateConnectionProfileSettings(),
            clientContext);
    this.updateConnectionProfileOperationCallable =
        callableFactory.createOperationCallable(
            updateConnectionProfileTransportSettings,
            settings.updateConnectionProfileOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            deleteConnectionProfileTransportSettings,
            settings.deleteConnectionProfileSettings(),
            clientContext);
    this.deleteConnectionProfileOperationCallable =
        callableFactory.createOperationCallable(
            deleteConnectionProfileTransportSettings,
            settings.deleteConnectionProfileOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.discoverConnectionProfileCallable =
        callableFactory.createUnaryCallable(
            discoverConnectionProfileTransportSettings,
            settings.discoverConnectionProfileSettings(),
            clientContext);
    this.listStreamsCallable =
        callableFactory.createUnaryCallable(
            listStreamsTransportSettings, settings.listStreamsSettings(), clientContext);
    this.listStreamsPagedCallable =
        callableFactory.createPagedCallable(
            listStreamsTransportSettings, settings.listStreamsSettings(), clientContext);
    this.getStreamCallable =
        callableFactory.createUnaryCallable(
            getStreamTransportSettings, settings.getStreamSettings(), clientContext);
    this.createStreamCallable =
        callableFactory.createUnaryCallable(
            createStreamTransportSettings, settings.createStreamSettings(), clientContext);
    this.createStreamOperationCallable =
        callableFactory.createOperationCallable(
            createStreamTransportSettings,
            settings.createStreamOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateStreamCallable =
        callableFactory.createUnaryCallable(
            updateStreamTransportSettings, settings.updateStreamSettings(), clientContext);
    this.updateStreamOperationCallable =
        callableFactory.createOperationCallable(
            updateStreamTransportSettings,
            settings.updateStreamOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteStreamCallable =
        callableFactory.createUnaryCallable(
            deleteStreamTransportSettings, settings.deleteStreamSettings(), clientContext);
    this.deleteStreamOperationCallable =
        callableFactory.createOperationCallable(
            deleteStreamTransportSettings,
            settings.deleteStreamOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.fetchErrorsCallable =
        callableFactory.createUnaryCallable(
            fetchErrorsTransportSettings, settings.fetchErrorsSettings(), clientContext);
    this.fetchErrorsOperationCallable =
        callableFactory.createOperationCallable(
            fetchErrorsTransportSettings,
            settings.fetchErrorsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.fetchStaticIpsCallable =
        callableFactory.createUnaryCallable(
            fetchStaticIpsTransportSettings, settings.fetchStaticIpsSettings(), clientContext);
    this.fetchStaticIpsPagedCallable =
        callableFactory.createPagedCallable(
            fetchStaticIpsTransportSettings, settings.fetchStaticIpsSettings(), clientContext);
    this.createPrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            createPrivateConnectionTransportSettings,
            settings.createPrivateConnectionSettings(),
            clientContext);
    this.createPrivateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createPrivateConnectionTransportSettings,
            settings.createPrivateConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getPrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            getPrivateConnectionTransportSettings,
            settings.getPrivateConnectionSettings(),
            clientContext);
    this.listPrivateConnectionsCallable =
        callableFactory.createUnaryCallable(
            listPrivateConnectionsTransportSettings,
            settings.listPrivateConnectionsSettings(),
            clientContext);
    this.listPrivateConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listPrivateConnectionsTransportSettings,
            settings.listPrivateConnectionsSettings(),
            clientContext);
    this.deletePrivateConnectionCallable =
        callableFactory.createUnaryCallable(
            deletePrivateConnectionTransportSettings,
            settings.deletePrivateConnectionSettings(),
            clientContext);
    this.deletePrivateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            deletePrivateConnectionTransportSettings,
            settings.deletePrivateConnectionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createRouteCallable =
        callableFactory.createUnaryCallable(
            createRouteTransportSettings, settings.createRouteSettings(), clientContext);
    this.createRouteOperationCallable =
        callableFactory.createOperationCallable(
            createRouteTransportSettings,
            settings.createRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getRouteCallable =
        callableFactory.createUnaryCallable(
            getRouteTransportSettings, settings.getRouteSettings(), clientContext);
    this.listRoutesCallable =
        callableFactory.createUnaryCallable(
            listRoutesTransportSettings, settings.listRoutesSettings(), clientContext);
    this.listRoutesPagedCallable =
        callableFactory.createPagedCallable(
            listRoutesTransportSettings, settings.listRoutesSettings(), clientContext);
    this.deleteRouteCallable =
        callableFactory.createUnaryCallable(
            deleteRouteTransportSettings, settings.deleteRouteSettings(), clientContext);
    this.deleteRouteOperationCallable =
        callableFactory.createOperationCallable(
            deleteRouteTransportSettings,
            settings.deleteRouteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listConnectionProfilesMethodDescriptor);
    methodDescriptors.add(getConnectionProfileMethodDescriptor);
    methodDescriptors.add(createConnectionProfileMethodDescriptor);
    methodDescriptors.add(updateConnectionProfileMethodDescriptor);
    methodDescriptors.add(deleteConnectionProfileMethodDescriptor);
    methodDescriptors.add(discoverConnectionProfileMethodDescriptor);
    methodDescriptors.add(listStreamsMethodDescriptor);
    methodDescriptors.add(getStreamMethodDescriptor);
    methodDescriptors.add(createStreamMethodDescriptor);
    methodDescriptors.add(updateStreamMethodDescriptor);
    methodDescriptors.add(deleteStreamMethodDescriptor);
    methodDescriptors.add(fetchErrorsMethodDescriptor);
    methodDescriptors.add(fetchStaticIpsMethodDescriptor);
    methodDescriptors.add(createPrivateConnectionMethodDescriptor);
    methodDescriptors.add(getPrivateConnectionMethodDescriptor);
    methodDescriptors.add(listPrivateConnectionsMethodDescriptor);
    methodDescriptors.add(deletePrivateConnectionMethodDescriptor);
    methodDescriptors.add(createRouteMethodDescriptor);
    methodDescriptors.add(getRouteMethodDescriptor);
    methodDescriptors.add(listRoutesMethodDescriptor);
    methodDescriptors.add(deleteRouteMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesCallable() {
    return listConnectionProfilesCallable;
  }

  @Override
  public UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesPagedResponse>
      listConnectionProfilesPagedCallable() {
    return listConnectionProfilesPagedCallable;
  }

  @Override
  public UnaryCallable<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileCallable() {
    return getConnectionProfileCallable;
  }

  @Override
  public UnaryCallable<CreateConnectionProfileRequest, Operation>
      createConnectionProfileCallable() {
    return createConnectionProfileCallable;
  }

  @Override
  public OperationCallable<CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationCallable() {
    return createConnectionProfileOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileCallable() {
    return updateConnectionProfileCallable;
  }

  @Override
  public OperationCallable<UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationCallable() {
    return updateConnectionProfileOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileCallable() {
    return deleteConnectionProfileCallable;
  }

  @Override
  public OperationCallable<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationCallable() {
    return deleteConnectionProfileOperationCallable;
  }

  @Override
  public UnaryCallable<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
      discoverConnectionProfileCallable() {
    return discoverConnectionProfileCallable;
  }

  @Override
  public UnaryCallable<ListStreamsRequest, ListStreamsResponse> listStreamsCallable() {
    return listStreamsCallable;
  }

  @Override
  public UnaryCallable<ListStreamsRequest, ListStreamsPagedResponse> listStreamsPagedCallable() {
    return listStreamsPagedCallable;
  }

  @Override
  public UnaryCallable<GetStreamRequest, Stream> getStreamCallable() {
    return getStreamCallable;
  }

  @Override
  public UnaryCallable<CreateStreamRequest, Operation> createStreamCallable() {
    return createStreamCallable;
  }

  @Override
  public OperationCallable<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationCallable() {
    return createStreamOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateStreamRequest, Operation> updateStreamCallable() {
    return updateStreamCallable;
  }

  @Override
  public OperationCallable<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationCallable() {
    return updateStreamOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteStreamRequest, Operation> deleteStreamCallable() {
    return deleteStreamCallable;
  }

  @Override
  public OperationCallable<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationCallable() {
    return deleteStreamOperationCallable;
  }

  @Override
  public UnaryCallable<FetchErrorsRequest, Operation> fetchErrorsCallable() {
    return fetchErrorsCallable;
  }

  @Override
  public OperationCallable<FetchErrorsRequest, FetchErrorsResponse, OperationMetadata>
      fetchErrorsOperationCallable() {
    return fetchErrorsOperationCallable;
  }

  @Override
  public UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsResponse> fetchStaticIpsCallable() {
    return fetchStaticIpsCallable;
  }

  @Override
  public UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsPagedResponse>
      fetchStaticIpsPagedCallable() {
    return fetchStaticIpsPagedCallable;
  }

  @Override
  public UnaryCallable<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionCallable() {
    return createPrivateConnectionCallable;
  }

  @Override
  public OperationCallable<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationCallable() {
    return createPrivateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionCallable() {
    return getPrivateConnectionCallable;
  }

  @Override
  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
      listPrivateConnectionsCallable() {
    return listPrivateConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsPagedCallable() {
    return listPrivateConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionCallable() {
    return deletePrivateConnectionCallable;
  }

  @Override
  public OperationCallable<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationCallable() {
    return deletePrivateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<CreateRouteRequest, Operation> createRouteCallable() {
    return createRouteCallable;
  }

  @Override
  public OperationCallable<CreateRouteRequest, Route, OperationMetadata>
      createRouteOperationCallable() {
    return createRouteOperationCallable;
  }

  @Override
  public UnaryCallable<GetRouteRequest, Route> getRouteCallable() {
    return getRouteCallable;
  }

  @Override
  public UnaryCallable<ListRoutesRequest, ListRoutesResponse> listRoutesCallable() {
    return listRoutesCallable;
  }

  @Override
  public UnaryCallable<ListRoutesRequest, ListRoutesPagedResponse> listRoutesPagedCallable() {
    return listRoutesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRouteRequest, Operation> deleteRouteCallable() {
    return deleteRouteCallable;
  }

  @Override
  public OperationCallable<DeleteRouteRequest, Empty, OperationMetadata>
      deleteRouteOperationCallable() {
    return deleteRouteOperationCallable;
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
