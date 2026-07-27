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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.RuleExecutionErrorServiceClient.ListRuleExecutionErrorsPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.ListRuleExecutionErrorsRequest;
import com.google.cloud.chronicle.v1.ListRuleExecutionErrorsResponse;
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
 * REST stub implementation for the RuleExecutionErrorService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonRuleExecutionErrorServiceStub extends RuleExecutionErrorServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>
      listRuleExecutionErrorsMethodDescriptor =
          ApiMethodDescriptor
              .<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.RuleExecutionErrorService/ListRuleExecutionErrors")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRuleExecutionErrorsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/ruleExecutionErrors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuleExecutionErrorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuleExecutionErrorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRuleExecutionErrorsResponse>newBuilder()
                      .setDefaultInstance(ListRuleExecutionErrorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>
      listRuleExecutionErrorsCallable;
  private final UnaryCallable<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsPagedResponse>
      listRuleExecutionErrorsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRuleExecutionErrorServiceStub create(
      RuleExecutionErrorServiceStubSettings settings) throws IOException {
    return new HttpJsonRuleExecutionErrorServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRuleExecutionErrorServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRuleExecutionErrorServiceStub(
        RuleExecutionErrorServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRuleExecutionErrorServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRuleExecutionErrorServiceStub(
        RuleExecutionErrorServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRuleExecutionErrorServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRuleExecutionErrorServiceStub(
      RuleExecutionErrorServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRuleExecutionErrorServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRuleExecutionErrorServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRuleExecutionErrorServiceStub(
      RuleExecutionErrorServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>
        listRuleExecutionErrorsTransportSettings =
            HttpJsonCallSettings
                .<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>newBuilder()
                .setMethodDescriptor(listRuleExecutionErrorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.listRuleExecutionErrorsCallable =
        callableFactory.createUnaryCallable(
            listRuleExecutionErrorsTransportSettings,
            settings.listRuleExecutionErrorsSettings(),
            clientContext);
    this.listRuleExecutionErrorsPagedCallable =
        callableFactory.createPagedCallable(
            listRuleExecutionErrorsTransportSettings,
            settings.listRuleExecutionErrorsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listRuleExecutionErrorsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsResponse>
      listRuleExecutionErrorsCallable() {
    return listRuleExecutionErrorsCallable;
  }

  @Override
  public UnaryCallable<ListRuleExecutionErrorsRequest, ListRuleExecutionErrorsPagedResponse>
      listRuleExecutionErrorsPagedCallable() {
    return listRuleExecutionErrorsPagedCallable;
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
