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

import static com.google.cloud.run.v2.TasksClient.ListTasksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.GetTaskRequest;
import com.google.cloud.run.v2.ListTasksRequest;
import com.google.cloud.run.v2.ListTasksResponse;
import com.google.cloud.run.v2.Task;
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
 * REST stub implementation for the Tasks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTasksStub extends TasksStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetTaskRequest, Task> getTaskMethodDescriptor =
      ApiMethodDescriptor.<GetTaskRequest, Task>newBuilder()
          .setFullMethodName("google.cloud.run.v2.Tasks/GetTask")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTaskRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/jobs/*/executions/*/tasks/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetTaskRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetTaskRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Task>newBuilder()
                  .setDefaultInstance(Task.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListTasksRequest, ListTasksResponse>
      listTasksMethodDescriptor =
          ApiMethodDescriptor.<ListTasksRequest, ListTasksResponse>newBuilder()
              .setFullMethodName("google.cloud.run.v2.Tasks/ListTasks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTasksRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/jobs/*/executions/*}/tasks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTasksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTasksRequest> serializer =
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
                  ProtoMessageResponseParser.<ListTasksResponse>newBuilder()
                      .setDefaultInstance(ListTasksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetTaskRequest, Task> getTaskCallable;
  private final UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable;
  private final UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTasksStub create(TasksStubSettings settings) throws IOException {
    return new HttpJsonTasksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTasksStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonTasksStub(TasksStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTasksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTasksStub(
        TasksStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTasksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTasksStub(TasksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTasksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTasksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTasksStub(
      TasksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetTaskRequest, Task> getTaskTransportSettings =
        HttpJsonCallSettings.<GetTaskRequest, Task>newBuilder()
            .setMethodDescriptor(getTaskMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListTasksRequest, ListTasksResponse> listTasksTransportSettings =
        HttpJsonCallSettings.<ListTasksRequest, ListTasksResponse>newBuilder()
            .setMethodDescriptor(listTasksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.getTaskCallable =
        callableFactory.createUnaryCallable(
            getTaskTransportSettings, settings.getTaskSettings(), clientContext);
    this.listTasksCallable =
        callableFactory.createUnaryCallable(
            listTasksTransportSettings, settings.listTasksSettings(), clientContext);
    this.listTasksPagedCallable =
        callableFactory.createPagedCallable(
            listTasksTransportSettings, settings.listTasksSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getTaskMethodDescriptor);
    methodDescriptors.add(listTasksMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetTaskRequest, Task> getTaskCallable() {
    return getTaskCallable;
  }

  @Override
  public UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable() {
    return listTasksCallable;
  }

  @Override
  public UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable() {
    return listTasksPagedCallable;
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
