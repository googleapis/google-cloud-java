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

package com.google.cloud.dataproc.v1.stub;

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
import com.google.cloud.dataproc.v1.CreateNodeGroupRequest;
import com.google.cloud.dataproc.v1.GetNodeGroupRequest;
import com.google.cloud.dataproc.v1.NodeGroup;
import com.google.cloud.dataproc.v1.NodeGroupOperationMetadata;
import com.google.cloud.dataproc.v1.ResizeNodeGroupRequest;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the NodeGroupController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonNodeGroupControllerStub extends NodeGroupControllerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(NodeGroup.getDescriptor())
          .add(NodeGroupOperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateNodeGroupRequest, Operation>
      createNodeGroupMethodDescriptor =
          ApiMethodDescriptor.<CreateNodeGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.NodeGroupController/CreateNodeGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateNodeGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/regions/*/clusters/*}/nodeGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "nodeGroupId", request.getNodeGroupId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("nodeGroup", request.getNodeGroup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateNodeGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ResizeNodeGroupRequest, Operation>
      resizeNodeGroupMethodDescriptor =
          ApiMethodDescriptor.<ResizeNodeGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.NodeGroupController/ResizeNodeGroup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResizeNodeGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/regions/*/clusters/*/nodeGroups/*}:resize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResizeNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResizeNodeGroupRequest> serializer =
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
                  (ResizeNodeGroupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetNodeGroupRequest, NodeGroup>
      getNodeGroupMethodDescriptor =
          ApiMethodDescriptor.<GetNodeGroupRequest, NodeGroup>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.NodeGroupController/GetNodeGroup")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNodeGroupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/regions/*/clusters/*/nodeGroups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNodeGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NodeGroup>newBuilder()
                      .setDefaultInstance(NodeGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateNodeGroupRequest, Operation> createNodeGroupCallable;
  private final OperationCallable<CreateNodeGroupRequest, NodeGroup, NodeGroupOperationMetadata>
      createNodeGroupOperationCallable;
  private final UnaryCallable<ResizeNodeGroupRequest, Operation> resizeNodeGroupCallable;
  private final OperationCallable<ResizeNodeGroupRequest, NodeGroup, NodeGroupOperationMetadata>
      resizeNodeGroupOperationCallable;
  private final UnaryCallable<GetNodeGroupRequest, NodeGroup> getNodeGroupCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNodeGroupControllerStub create(
      NodeGroupControllerStubSettings settings) throws IOException {
    return new HttpJsonNodeGroupControllerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNodeGroupControllerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNodeGroupControllerStub(
        NodeGroupControllerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonNodeGroupControllerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNodeGroupControllerStub(
        NodeGroupControllerStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNodeGroupControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNodeGroupControllerStub(
      NodeGroupControllerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonNodeGroupControllerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNodeGroupControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNodeGroupControllerStub(
      NodeGroupControllerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateNodeGroupRequest, Operation> createNodeGroupTransportSettings =
        HttpJsonCallSettings.<CreateNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(createNodeGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ResizeNodeGroupRequest, Operation> resizeNodeGroupTransportSettings =
        HttpJsonCallSettings.<ResizeNodeGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeNodeGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetNodeGroupRequest, NodeGroup> getNodeGroupTransportSettings =
        HttpJsonCallSettings.<GetNodeGroupRequest, NodeGroup>newBuilder()
            .setMethodDescriptor(getNodeGroupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createNodeGroupCallable =
        callableFactory.createUnaryCallable(
            createNodeGroupTransportSettings, settings.createNodeGroupSettings(), clientContext);
    this.createNodeGroupOperationCallable =
        callableFactory.createOperationCallable(
            createNodeGroupTransportSettings,
            settings.createNodeGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.resizeNodeGroupCallable =
        callableFactory.createUnaryCallable(
            resizeNodeGroupTransportSettings, settings.resizeNodeGroupSettings(), clientContext);
    this.resizeNodeGroupOperationCallable =
        callableFactory.createOperationCallable(
            resizeNodeGroupTransportSettings,
            settings.resizeNodeGroupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getNodeGroupCallable =
        callableFactory.createUnaryCallable(
            getNodeGroupTransportSettings, settings.getNodeGroupSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createNodeGroupMethodDescriptor);
    methodDescriptors.add(resizeNodeGroupMethodDescriptor);
    methodDescriptors.add(getNodeGroupMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateNodeGroupRequest, Operation> createNodeGroupCallable() {
    return createNodeGroupCallable;
  }

  @Override
  public OperationCallable<CreateNodeGroupRequest, NodeGroup, NodeGroupOperationMetadata>
      createNodeGroupOperationCallable() {
    return createNodeGroupOperationCallable;
  }

  @Override
  public UnaryCallable<ResizeNodeGroupRequest, Operation> resizeNodeGroupCallable() {
    return resizeNodeGroupCallable;
  }

  @Override
  public OperationCallable<ResizeNodeGroupRequest, NodeGroup, NodeGroupOperationMetadata>
      resizeNodeGroupOperationCallable() {
    return resizeNodeGroupOperationCallable;
  }

  @Override
  public UnaryCallable<GetNodeGroupRequest, NodeGroup> getNodeGroupCallable() {
    return getNodeGroupCallable;
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
