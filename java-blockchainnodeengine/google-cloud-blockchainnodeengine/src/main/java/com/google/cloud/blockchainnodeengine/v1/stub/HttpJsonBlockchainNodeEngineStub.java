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

package com.google.cloud.blockchainnodeengine.v1.stub;

import static com.google.cloud.blockchainnodeengine.v1.BlockchainNodeEngineClient.ListBlockchainNodesPagedResponse;
import static com.google.cloud.blockchainnodeengine.v1.BlockchainNodeEngineClient.ListLocationsPagedResponse;

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
import com.google.cloud.blockchainnodeengine.v1.BlockchainNode;
import com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest;
import com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest;
import com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest;
import com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest;
import com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse;
import com.google.cloud.blockchainnodeengine.v1.OperationMetadata;
import com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest;
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
 * REST stub implementation for the BlockchainNodeEngine service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonBlockchainNodeEngineStub extends BlockchainNodeEngineStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(BlockchainNode.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListBlockchainNodesRequest, ListBlockchainNodesResponse>
      listBlockchainNodesMethodDescriptor =
          ApiMethodDescriptor.<ListBlockchainNodesRequest, ListBlockchainNodesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.blockchainnodeengine.v1.BlockchainNodeEngine/ListBlockchainNodes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBlockchainNodesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/blockchainNodes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBlockchainNodesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBlockchainNodesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListBlockchainNodesResponse>newBuilder()
                      .setDefaultInstance(ListBlockchainNodesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetBlockchainNodeRequest, BlockchainNode>
      getBlockchainNodeMethodDescriptor =
          ApiMethodDescriptor.<GetBlockchainNodeRequest, BlockchainNode>newBuilder()
              .setFullMethodName(
                  "google.cloud.blockchainnodeengine.v1.BlockchainNodeEngine/GetBlockchainNode")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBlockchainNodeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/blockchainNodes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBlockchainNodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBlockchainNodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BlockchainNode>newBuilder()
                      .setDefaultInstance(BlockchainNode.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateBlockchainNodeRequest, Operation>
      createBlockchainNodeMethodDescriptor =
          ApiMethodDescriptor.<CreateBlockchainNodeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.blockchainnodeengine.v1.BlockchainNodeEngine/CreateBlockchainNode")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBlockchainNodeRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/blockchainNodes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBlockchainNodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBlockchainNodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "blockchainNodeId", request.getBlockchainNodeId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("blockchainNode", request.getBlockchainNode(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBlockchainNodeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateBlockchainNodeRequest, Operation>
      updateBlockchainNodeMethodDescriptor =
          ApiMethodDescriptor.<UpdateBlockchainNodeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.blockchainnodeengine.v1.BlockchainNodeEngine/UpdateBlockchainNode")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBlockchainNodeRequest>newBuilder()
                      .setPath(
                          "/v1/{blockchainNode.name=projects/*/locations/*/blockchainNodes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBlockchainNodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "blockchainNode.name",
                                request.getBlockchainNode().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBlockchainNodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("blockchainNode", request.getBlockchainNode(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateBlockchainNodeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteBlockchainNodeRequest, Operation>
      deleteBlockchainNodeMethodDescriptor =
          ApiMethodDescriptor.<DeleteBlockchainNodeRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.blockchainnodeengine.v1.BlockchainNodeEngine/DeleteBlockchainNode")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBlockchainNodeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/blockchainNodes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBlockchainNodeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBlockchainNodeRequest> serializer =
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
                  (DeleteBlockchainNodeRequest request, Operation response) ->
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

  private final UnaryCallable<ListBlockchainNodesRequest, ListBlockchainNodesResponse>
      listBlockchainNodesCallable;
  private final UnaryCallable<ListBlockchainNodesRequest, ListBlockchainNodesPagedResponse>
      listBlockchainNodesPagedCallable;
  private final UnaryCallable<GetBlockchainNodeRequest, BlockchainNode> getBlockchainNodeCallable;
  private final UnaryCallable<CreateBlockchainNodeRequest, Operation> createBlockchainNodeCallable;
  private final OperationCallable<CreateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
      createBlockchainNodeOperationCallable;
  private final UnaryCallable<UpdateBlockchainNodeRequest, Operation> updateBlockchainNodeCallable;
  private final OperationCallable<UpdateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
      updateBlockchainNodeOperationCallable;
  private final UnaryCallable<DeleteBlockchainNodeRequest, Operation> deleteBlockchainNodeCallable;
  private final OperationCallable<DeleteBlockchainNodeRequest, Empty, OperationMetadata>
      deleteBlockchainNodeOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBlockchainNodeEngineStub create(
      BlockchainNodeEngineStubSettings settings) throws IOException {
    return new HttpJsonBlockchainNodeEngineStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBlockchainNodeEngineStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBlockchainNodeEngineStub(
        BlockchainNodeEngineStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBlockchainNodeEngineStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBlockchainNodeEngineStub(
        BlockchainNodeEngineStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBlockchainNodeEngineStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBlockchainNodeEngineStub(
      BlockchainNodeEngineStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBlockchainNodeEngineCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBlockchainNodeEngineStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBlockchainNodeEngineStub(
      BlockchainNodeEngineStubSettings settings,
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

    HttpJsonCallSettings<ListBlockchainNodesRequest, ListBlockchainNodesResponse>
        listBlockchainNodesTransportSettings =
            HttpJsonCallSettings
                .<ListBlockchainNodesRequest, ListBlockchainNodesResponse>newBuilder()
                .setMethodDescriptor(listBlockchainNodesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetBlockchainNodeRequest, BlockchainNode>
        getBlockchainNodeTransportSettings =
            HttpJsonCallSettings.<GetBlockchainNodeRequest, BlockchainNode>newBuilder()
                .setMethodDescriptor(getBlockchainNodeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<CreateBlockchainNodeRequest, Operation>
        createBlockchainNodeTransportSettings =
            HttpJsonCallSettings.<CreateBlockchainNodeRequest, Operation>newBuilder()
                .setMethodDescriptor(createBlockchainNodeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateBlockchainNodeRequest, Operation>
        updateBlockchainNodeTransportSettings =
            HttpJsonCallSettings.<UpdateBlockchainNodeRequest, Operation>newBuilder()
                .setMethodDescriptor(updateBlockchainNodeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "blockchain_node.name",
                          String.valueOf(request.getBlockchainNode().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteBlockchainNodeRequest, Operation>
        deleteBlockchainNodeTransportSettings =
            HttpJsonCallSettings.<DeleteBlockchainNodeRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteBlockchainNodeMethodDescriptor)
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

    this.listBlockchainNodesCallable =
        callableFactory.createUnaryCallable(
            listBlockchainNodesTransportSettings,
            settings.listBlockchainNodesSettings(),
            clientContext);
    this.listBlockchainNodesPagedCallable =
        callableFactory.createPagedCallable(
            listBlockchainNodesTransportSettings,
            settings.listBlockchainNodesSettings(),
            clientContext);
    this.getBlockchainNodeCallable =
        callableFactory.createUnaryCallable(
            getBlockchainNodeTransportSettings,
            settings.getBlockchainNodeSettings(),
            clientContext);
    this.createBlockchainNodeCallable =
        callableFactory.createUnaryCallable(
            createBlockchainNodeTransportSettings,
            settings.createBlockchainNodeSettings(),
            clientContext);
    this.createBlockchainNodeOperationCallable =
        callableFactory.createOperationCallable(
            createBlockchainNodeTransportSettings,
            settings.createBlockchainNodeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateBlockchainNodeCallable =
        callableFactory.createUnaryCallable(
            updateBlockchainNodeTransportSettings,
            settings.updateBlockchainNodeSettings(),
            clientContext);
    this.updateBlockchainNodeOperationCallable =
        callableFactory.createOperationCallable(
            updateBlockchainNodeTransportSettings,
            settings.updateBlockchainNodeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteBlockchainNodeCallable =
        callableFactory.createUnaryCallable(
            deleteBlockchainNodeTransportSettings,
            settings.deleteBlockchainNodeSettings(),
            clientContext);
    this.deleteBlockchainNodeOperationCallable =
        callableFactory.createOperationCallable(
            deleteBlockchainNodeTransportSettings,
            settings.deleteBlockchainNodeOperationSettings(),
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
    methodDescriptors.add(listBlockchainNodesMethodDescriptor);
    methodDescriptors.add(getBlockchainNodeMethodDescriptor);
    methodDescriptors.add(createBlockchainNodeMethodDescriptor);
    methodDescriptors.add(updateBlockchainNodeMethodDescriptor);
    methodDescriptors.add(deleteBlockchainNodeMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListBlockchainNodesRequest, ListBlockchainNodesResponse>
      listBlockchainNodesCallable() {
    return listBlockchainNodesCallable;
  }

  @Override
  public UnaryCallable<ListBlockchainNodesRequest, ListBlockchainNodesPagedResponse>
      listBlockchainNodesPagedCallable() {
    return listBlockchainNodesPagedCallable;
  }

  @Override
  public UnaryCallable<GetBlockchainNodeRequest, BlockchainNode> getBlockchainNodeCallable() {
    return getBlockchainNodeCallable;
  }

  @Override
  public UnaryCallable<CreateBlockchainNodeRequest, Operation> createBlockchainNodeCallable() {
    return createBlockchainNodeCallable;
  }

  @Override
  public OperationCallable<CreateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
      createBlockchainNodeOperationCallable() {
    return createBlockchainNodeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateBlockchainNodeRequest, Operation> updateBlockchainNodeCallable() {
    return updateBlockchainNodeCallable;
  }

  @Override
  public OperationCallable<UpdateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
      updateBlockchainNodeOperationCallable() {
    return updateBlockchainNodeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBlockchainNodeRequest, Operation> deleteBlockchainNodeCallable() {
    return deleteBlockchainNodeCallable;
  }

  @Override
  public OperationCallable<DeleteBlockchainNodeRequest, Empty, OperationMetadata>
      deleteBlockchainNodeOperationCallable() {
    return deleteBlockchainNodeOperationCallable;
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
