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

package com.google.cloud.run.v2.stub;

import static com.google.cloud.run.v2.ExecutionsClient.ListExecutionsPagedResponse;

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
import com.google.cloud.run.v2.DeleteExecutionRequest;
import com.google.cloud.run.v2.Execution;
import com.google.cloud.run.v2.GetExecutionRequest;
import com.google.cloud.run.v2.ListExecutionsRequest;
import com.google.cloud.run.v2.ListExecutionsResponse;
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
 * REST stub implementation for the Executions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonExecutionsStub extends ExecutionsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Execution.getDescriptor()).build();

  private static final ApiMethodDescriptor<GetExecutionRequest, Execution>
      getExecutionMethodDescriptor =
          ApiMethodDescriptor.<GetExecutionRequest, Execution>newBuilder()
              .setFullMethodName("google.cloud.run.v2.Executions/GetExecution")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetExecutionRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/jobs/*/executions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetExecutionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetExecutionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Execution>newBuilder()
                      .setDefaultInstance(Execution.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListExecutionsRequest, ListExecutionsResponse>
      listExecutionsMethodDescriptor =
          ApiMethodDescriptor.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
              .setFullMethodName("google.cloud.run.v2.Executions/ListExecutions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListExecutionsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/jobs/*}/executions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListExecutionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListExecutionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListExecutionsResponse>newBuilder()
                      .setDefaultInstance(ListExecutionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteExecutionRequest, Operation>
      deleteExecutionMethodDescriptor =
          ApiMethodDescriptor.<DeleteExecutionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.run.v2.Executions/DeleteExecution")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteExecutionRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/jobs/*/executions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExecutionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteExecutionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteExecutionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable;
  private final UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable;
  private final OperationCallable<DeleteExecutionRequest, Execution, Execution>
      deleteExecutionOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonExecutionsStub create(ExecutionsStubSettings settings)
      throws IOException {
    return new HttpJsonExecutionsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonExecutionsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonExecutionsStub(
        ExecutionsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonExecutionsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonExecutionsStub(
        ExecutionsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonExecutionsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonExecutionsStub(ExecutionsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonExecutionsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonExecutionsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonExecutionsStub(
      ExecutionsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<GetExecutionRequest, Execution> getExecutionTransportSettings =
        HttpJsonCallSettings.<GetExecutionRequest, Execution>newBuilder()
            .setMethodDescriptor(getExecutionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListExecutionsRequest, ListExecutionsResponse>
        listExecutionsTransportSettings =
            HttpJsonCallSettings.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
                .setMethodDescriptor(listExecutionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteExecutionRequest, Operation> deleteExecutionTransportSettings =
        HttpJsonCallSettings.<DeleteExecutionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteExecutionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.getExecutionCallable =
        callableFactory.createUnaryCallable(
            getExecutionTransportSettings, settings.getExecutionSettings(), clientContext);
    this.listExecutionsCallable =
        callableFactory.createUnaryCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.listExecutionsPagedCallable =
        callableFactory.createPagedCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.deleteExecutionCallable =
        callableFactory.createUnaryCallable(
            deleteExecutionTransportSettings, settings.deleteExecutionSettings(), clientContext);
    this.deleteExecutionOperationCallable =
        callableFactory.createOperationCallable(
            deleteExecutionTransportSettings,
            settings.deleteExecutionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getExecutionMethodDescriptor);
    methodDescriptors.add(listExecutionsMethodDescriptor);
    methodDescriptors.add(deleteExecutionMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    return getExecutionCallable;
  }

  @Override
  public UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable() {
    return listExecutionsCallable;
  }

  @Override
  public UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    return listExecutionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable() {
    return deleteExecutionCallable;
  }

  @Override
  public OperationCallable<DeleteExecutionRequest, Execution, Execution>
      deleteExecutionOperationCallable() {
    return deleteExecutionOperationCallable;
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
