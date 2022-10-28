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

package com.google.cloud.talent.v4beta1.stub;

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
import com.google.cloud.talent.v4beta1.CompleteQueryRequest;
import com.google.cloud.talent.v4beta1.CompleteQueryResponse;
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
 * REST stub implementation for the Completion service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonCompletionStub extends CompletionStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CompleteQueryRequest, CompleteQueryResponse>
      completeQueryMethodDescriptor =
          ApiMethodDescriptor.<CompleteQueryRequest, CompleteQueryResponse>newBuilder()
              .setFullMethodName("google.cloud.talent.v4beta1.Completion/CompleteQuery")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CompleteQueryRequest>newBuilder()
                      .setPath(
                          "/v4beta1/{parent=projects/*/tenants/*}:complete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CompleteQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v4beta1/{parent=projects/*}:complete")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CompleteQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "company", request.getCompany());
                            serializer.putQueryParam(
                                fields, "languageCodes", request.getLanguageCodesList());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "scope", request.getScopeValue());
                            serializer.putQueryParam(fields, "type", request.getTypeValue());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompleteQueryResponse>newBuilder()
                      .setDefaultInstance(CompleteQueryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CompleteQueryRequest, CompleteQueryResponse> completeQueryCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCompletionStub create(CompletionStubSettings settings)
      throws IOException {
    return new HttpJsonCompletionStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCompletionStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCompletionStub(
        CompletionStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCompletionStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCompletionStub(
        CompletionStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCompletionStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCompletionStub(CompletionStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCompletionCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCompletionStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCompletionStub(
      CompletionStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CompleteQueryRequest, CompleteQueryResponse>
        completeQueryTransportSettings =
            HttpJsonCallSettings.<CompleteQueryRequest, CompleteQueryResponse>newBuilder()
                .setMethodDescriptor(completeQueryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.completeQueryCallable =
        callableFactory.createUnaryCallable(
            completeQueryTransportSettings, settings.completeQuerySettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(completeQueryMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CompleteQueryRequest, CompleteQueryResponse> completeQueryCallable() {
    return completeQueryCallable;
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
