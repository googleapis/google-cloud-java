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

package com.google.dataflow.v1beta3.stub;

import static com.google.dataflow.v1beta3.MessagesV1Beta3Client.ListJobMessagesPagedResponse;

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
import com.google.dataflow.v1beta3.ListJobMessagesRequest;
import com.google.dataflow.v1beta3.ListJobMessagesResponse;
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
 * REST stub implementation for the MessagesV1Beta3 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonMessagesV1Beta3Stub extends MessagesV1Beta3Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListJobMessagesRequest, ListJobMessagesResponse>
      listJobMessagesMethodDescriptor =
          ApiMethodDescriptor.<ListJobMessagesRequest, ListJobMessagesResponse>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.MessagesV1Beta3/ListJobMessages")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListJobMessagesRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/messages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobMessagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "jobId", request.getJobId());
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1b3/projects/{projectId}/jobs/{jobId}/messages")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListJobMessagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "endTime", request.getEndTime());
                            serializer.putQueryParam(
                                fields, "minimumImportance", request.getMinimumImportanceValue());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "startTime", request.getStartTime());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListJobMessagesResponse>newBuilder()
                      .setDefaultInstance(ListJobMessagesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListJobMessagesRequest, ListJobMessagesResponse>
      listJobMessagesCallable;
  private final UnaryCallable<ListJobMessagesRequest, ListJobMessagesPagedResponse>
      listJobMessagesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonMessagesV1Beta3Stub create(MessagesV1Beta3StubSettings settings)
      throws IOException {
    return new HttpJsonMessagesV1Beta3Stub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonMessagesV1Beta3Stub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonMessagesV1Beta3Stub(
        MessagesV1Beta3StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonMessagesV1Beta3Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonMessagesV1Beta3Stub(
        MessagesV1Beta3StubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonMessagesV1Beta3Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMessagesV1Beta3Stub(
      MessagesV1Beta3StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonMessagesV1Beta3CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonMessagesV1Beta3Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonMessagesV1Beta3Stub(
      MessagesV1Beta3StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListJobMessagesRequest, ListJobMessagesResponse>
        listJobMessagesTransportSettings =
            HttpJsonCallSettings.<ListJobMessagesRequest, ListJobMessagesResponse>newBuilder()
                .setMethodDescriptor(listJobMessagesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listJobMessagesCallable =
        callableFactory.createUnaryCallable(
            listJobMessagesTransportSettings, settings.listJobMessagesSettings(), clientContext);
    this.listJobMessagesPagedCallable =
        callableFactory.createPagedCallable(
            listJobMessagesTransportSettings, settings.listJobMessagesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listJobMessagesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListJobMessagesRequest, ListJobMessagesResponse> listJobMessagesCallable() {
    return listJobMessagesCallable;
  }

  @Override
  public UnaryCallable<ListJobMessagesRequest, ListJobMessagesPagedResponse>
      listJobMessagesPagedCallable() {
    return listJobMessagesPagedCallable;
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
