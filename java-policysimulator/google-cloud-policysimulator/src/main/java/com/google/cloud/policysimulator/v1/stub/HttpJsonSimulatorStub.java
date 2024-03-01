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

package com.google.cloud.policysimulator.v1.stub;

import static com.google.cloud.policysimulator.v1.SimulatorClient.ListReplayResultsPagedResponse;

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
import com.google.cloud.policysimulator.v1.CreateReplayRequest;
import com.google.cloud.policysimulator.v1.GetReplayRequest;
import com.google.cloud.policysimulator.v1.ListReplayResultsRequest;
import com.google.cloud.policysimulator.v1.ListReplayResultsResponse;
import com.google.cloud.policysimulator.v1.Replay;
import com.google.cloud.policysimulator.v1.ReplayOperationMetadata;
import com.google.common.collect.ImmutableMap;
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
 * REST stub implementation for the Simulator service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonSimulatorStub extends SimulatorStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Replay.getDescriptor())
          .add(ReplayOperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetReplayRequest, Replay> getReplayMethodDescriptor =
      ApiMethodDescriptor.<GetReplayRequest, Replay>newBuilder()
          .setFullMethodName("google.cloud.policysimulator.v1.Simulator/GetReplay")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetReplayRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/replays/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetReplayRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1/{name=folders/*/locations/*/replays/*}",
                      "/v1/{name=organizations/*/locations/*/replays/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetReplayRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Replay>newBuilder()
                  .setDefaultInstance(Replay.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateReplayRequest, Operation>
      createReplayMethodDescriptor =
          ApiMethodDescriptor.<CreateReplayRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.policysimulator.v1.Simulator/CreateReplay")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReplayRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/replays",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReplayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/replays",
                          "/v1/{parent=organizations/*/locations/*}/replays")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReplayRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("replay", request.getReplay(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateReplayRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListReplayResultsRequest, ListReplayResultsResponse>
      listReplayResultsMethodDescriptor =
          ApiMethodDescriptor.<ListReplayResultsRequest, ListReplayResultsResponse>newBuilder()
              .setFullMethodName("google.cloud.policysimulator.v1.Simulator/ListReplayResults")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReplayResultsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/replays/*}/results",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReplayResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*/replays/*}/results",
                          "/v1/{parent=organizations/*/locations/*/replays/*}/results")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReplayResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReplayResultsResponse>newBuilder()
                      .setDefaultInstance(ListReplayResultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetReplayRequest, Replay> getReplayCallable;
  private final UnaryCallable<CreateReplayRequest, Operation> createReplayCallable;
  private final OperationCallable<CreateReplayRequest, Replay, ReplayOperationMetadata>
      createReplayOperationCallable;
  private final UnaryCallable<ListReplayResultsRequest, ListReplayResultsResponse>
      listReplayResultsCallable;
  private final UnaryCallable<ListReplayResultsRequest, ListReplayResultsPagedResponse>
      listReplayResultsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSimulatorStub create(SimulatorStubSettings settings)
      throws IOException {
    return new HttpJsonSimulatorStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSimulatorStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonSimulatorStub(
        SimulatorStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSimulatorStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSimulatorStub(
        SimulatorStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSimulatorStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSimulatorStub(SimulatorStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSimulatorCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSimulatorStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSimulatorStub(
      SimulatorStubSettings settings,
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
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=operations/**}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/replays/*/operations/**}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=folders/*/locations/*/replays/*/operations/**}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=organizations/*/locations/*/replays/*/operations/**}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=operations}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/replays/*/operations}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=folders/*/locations/*/replays/*/operations}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=organizations/*/locations/*/replays/*/operations}")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<GetReplayRequest, Replay> getReplayTransportSettings =
        HttpJsonCallSettings.<GetReplayRequest, Replay>newBuilder()
            .setMethodDescriptor(getReplayMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateReplayRequest, Operation> createReplayTransportSettings =
        HttpJsonCallSettings.<CreateReplayRequest, Operation>newBuilder()
            .setMethodDescriptor(createReplayMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListReplayResultsRequest, ListReplayResultsResponse>
        listReplayResultsTransportSettings =
            HttpJsonCallSettings.<ListReplayResultsRequest, ListReplayResultsResponse>newBuilder()
                .setMethodDescriptor(listReplayResultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getReplayCallable =
        callableFactory.createUnaryCallable(
            getReplayTransportSettings, settings.getReplaySettings(), clientContext);
    this.createReplayCallable =
        callableFactory.createUnaryCallable(
            createReplayTransportSettings, settings.createReplaySettings(), clientContext);
    this.createReplayOperationCallable =
        callableFactory.createOperationCallable(
            createReplayTransportSettings,
            settings.createReplayOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listReplayResultsCallable =
        callableFactory.createUnaryCallable(
            listReplayResultsTransportSettings,
            settings.listReplayResultsSettings(),
            clientContext);
    this.listReplayResultsPagedCallable =
        callableFactory.createPagedCallable(
            listReplayResultsTransportSettings,
            settings.listReplayResultsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getReplayMethodDescriptor);
    methodDescriptors.add(createReplayMethodDescriptor);
    methodDescriptors.add(listReplayResultsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetReplayRequest, Replay> getReplayCallable() {
    return getReplayCallable;
  }

  @Override
  public UnaryCallable<CreateReplayRequest, Operation> createReplayCallable() {
    return createReplayCallable;
  }

  @Override
  public OperationCallable<CreateReplayRequest, Replay, ReplayOperationMetadata>
      createReplayOperationCallable() {
    return createReplayOperationCallable;
  }

  @Override
  public UnaryCallable<ListReplayResultsRequest, ListReplayResultsResponse>
      listReplayResultsCallable() {
    return listReplayResultsCallable;
  }

  @Override
  public UnaryCallable<ListReplayResultsRequest, ListReplayResultsPagedResponse>
      listReplayResultsPagedCallable() {
    return listReplayResultsPagedCallable;
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
