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

package com.google.cloud.lifesciences.v2beta.stub;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.lifesciences.v2beta.Metadata;
import com.google.cloud.lifesciences.v2beta.RunPipelineRequest;
import com.google.cloud.lifesciences.v2beta.RunPipelineResponse;
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
 * REST stub implementation for the WorkflowsServiceV2Beta service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonWorkflowsServiceV2BetaStub extends WorkflowsServiceV2BetaStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Metadata.getDescriptor())
          .add(RunPipelineResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<RunPipelineRequest, Operation>
      runPipelineMethodDescriptor =
          ApiMethodDescriptor.<RunPipelineRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.lifesciences.v2beta.WorkflowsServiceV2Beta/RunPipeline")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunPipelineRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*}/pipelines:run",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunPipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunPipelineRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build()))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RunPipelineRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<RunPipelineRequest, Operation> runPipelineCallable;
  private final OperationCallable<RunPipelineRequest, RunPipelineResponse, Metadata>
      runPipelineOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonWorkflowsServiceV2BetaStub create(
      WorkflowsServiceV2BetaStubSettings settings) throws IOException {
    return new HttpJsonWorkflowsServiceV2BetaStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWorkflowsServiceV2BetaStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonWorkflowsServiceV2BetaStub(
        WorkflowsServiceV2BetaStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonWorkflowsServiceV2BetaStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWorkflowsServiceV2BetaStub(
        WorkflowsServiceV2BetaStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWorkflowsServiceV2BetaStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWorkflowsServiceV2BetaStub(
      WorkflowsServiceV2BetaStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonWorkflowsServiceV2BetaCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWorkflowsServiceV2BetaStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonWorkflowsServiceV2BetaStub(
      WorkflowsServiceV2BetaStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<RunPipelineRequest, Operation> runPipelineTransportSettings =
        HttpJsonCallSettings.<RunPipelineRequest, Operation>newBuilder()
            .setMethodDescriptor(runPipelineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.runPipelineCallable =
        callableFactory.createUnaryCallable(
            runPipelineTransportSettings, settings.runPipelineSettings(), clientContext);
    this.runPipelineOperationCallable =
        callableFactory.createOperationCallable(
            runPipelineTransportSettings,
            settings.runPipelineOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(runPipelineMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<RunPipelineRequest, Operation> runPipelineCallable() {
    return runPipelineCallable;
  }

  @Override
  public OperationCallable<RunPipelineRequest, RunPipelineResponse, Metadata>
      runPipelineOperationCallable() {
    return runPipelineOperationCallable;
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
