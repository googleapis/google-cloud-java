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

package com.google.developers.knowledge.v1.stub;

import static com.google.developers.knowledge.v1.DeveloperKnowledgeClient.SearchDocumentChunksPagedResponse;

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
import com.google.developers.knowledge.v1.AnswerQueryRequest;
import com.google.developers.knowledge.v1.AnswerQueryResponse;
import com.google.developers.knowledge.v1.BatchGetDocumentsRequest;
import com.google.developers.knowledge.v1.BatchGetDocumentsResponse;
import com.google.developers.knowledge.v1.Document;
import com.google.developers.knowledge.v1.GetDocumentRequest;
import com.google.developers.knowledge.v1.SearchDocumentChunksRequest;
import com.google.developers.knowledge.v1.SearchDocumentChunksResponse;
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
 * REST stub implementation for the DeveloperKnowledge service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonDeveloperKnowledgeStub extends DeveloperKnowledgeStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          SearchDocumentChunksRequest, SearchDocumentChunksResponse>
      searchDocumentChunksMethodDescriptor =
          ApiMethodDescriptor
              .<SearchDocumentChunksRequest, SearchDocumentChunksResponse>newBuilder()
              .setFullMethodName(
                  "google.developers.knowledge.v1.DeveloperKnowledge/SearchDocumentChunks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchDocumentChunksRequest>newBuilder()
                      .setPath(
                          "/v1/documents:searchDocumentChunks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchDocumentChunksRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchDocumentChunksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchDocumentChunksResponse>newBuilder()
                      .setDefaultInstance(SearchDocumentChunksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetDocumentRequest, Document>
      getDocumentMethodDescriptor =
          ApiMethodDescriptor.<GetDocumentRequest, Document>newBuilder()
              .setFullMethodName("google.developers.knowledge.v1.DeveloperKnowledge/GetDocument")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDocumentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=documents/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDocumentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Document>newBuilder()
                      .setDefaultInstance(Document.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsMethodDescriptor =
          ApiMethodDescriptor.<BatchGetDocumentsRequest, BatchGetDocumentsResponse>newBuilder()
              .setFullMethodName(
                  "google.developers.knowledge.v1.DeveloperKnowledge/BatchGetDocuments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchGetDocumentsRequest>newBuilder()
                      .setPath(
                          "/v1/documents:batchGet",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchGetDocumentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "names", request.getNamesList());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchGetDocumentsResponse>newBuilder()
                      .setDefaultInstance(BatchGetDocumentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AnswerQueryRequest, AnswerQueryResponse>
      answerQueryMethodDescriptor =
          ApiMethodDescriptor.<AnswerQueryRequest, AnswerQueryResponse>newBuilder()
              .setFullMethodName("google.developers.knowledge.v1.DeveloperKnowledge/AnswerQuery")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnswerQueryRequest>newBuilder()
                      .setPath(
                          "/v1:answerQuery",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnswerQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnswerQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnswerQueryResponse>newBuilder()
                      .setDefaultInstance(AnswerQueryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksResponse>
      searchDocumentChunksCallable;
  private final UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksPagedResponse>
      searchDocumentChunksPagedCallable;
  private final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable;
  private final UnaryCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable;
  private final UnaryCallable<AnswerQueryRequest, AnswerQueryResponse> answerQueryCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDeveloperKnowledgeStub create(DeveloperKnowledgeStubSettings settings)
      throws IOException {
    return new HttpJsonDeveloperKnowledgeStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDeveloperKnowledgeStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDeveloperKnowledgeStub(
        DeveloperKnowledgeStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDeveloperKnowledgeStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDeveloperKnowledgeStub(
        DeveloperKnowledgeStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDeveloperKnowledgeStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDeveloperKnowledgeStub(
      DeveloperKnowledgeStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDeveloperKnowledgeCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDeveloperKnowledgeStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDeveloperKnowledgeStub(
      DeveloperKnowledgeStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SearchDocumentChunksRequest, SearchDocumentChunksResponse>
        searchDocumentChunksTransportSettings =
            HttpJsonCallSettings
                .<SearchDocumentChunksRequest, SearchDocumentChunksResponse>newBuilder()
                .setMethodDescriptor(searchDocumentChunksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetDocumentRequest, Document> getDocumentTransportSettings =
        HttpJsonCallSettings.<GetDocumentRequest, Document>newBuilder()
            .setMethodDescriptor(getDocumentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        batchGetDocumentsTransportSettings =
            HttpJsonCallSettings.<BatchGetDocumentsRequest, BatchGetDocumentsResponse>newBuilder()
                .setMethodDescriptor(batchGetDocumentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AnswerQueryRequest, AnswerQueryResponse> answerQueryTransportSettings =
        HttpJsonCallSettings.<AnswerQueryRequest, AnswerQueryResponse>newBuilder()
            .setMethodDescriptor(answerQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.searchDocumentChunksCallable =
        callableFactory.createUnaryCallable(
            searchDocumentChunksTransportSettings,
            settings.searchDocumentChunksSettings(),
            clientContext);
    this.searchDocumentChunksPagedCallable =
        callableFactory.createPagedCallable(
            searchDocumentChunksTransportSettings,
            settings.searchDocumentChunksSettings(),
            clientContext);
    this.getDocumentCallable =
        callableFactory.createUnaryCallable(
            getDocumentTransportSettings, settings.getDocumentSettings(), clientContext);
    this.batchGetDocumentsCallable =
        callableFactory.createUnaryCallable(
            batchGetDocumentsTransportSettings,
            settings.batchGetDocumentsSettings(),
            clientContext);
    this.answerQueryCallable =
        callableFactory.createUnaryCallable(
            answerQueryTransportSettings, settings.answerQuerySettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(searchDocumentChunksMethodDescriptor);
    methodDescriptors.add(getDocumentMethodDescriptor);
    methodDescriptors.add(batchGetDocumentsMethodDescriptor);
    methodDescriptors.add(answerQueryMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksResponse>
      searchDocumentChunksCallable() {
    return searchDocumentChunksCallable;
  }

  @Override
  public UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksPagedResponse>
      searchDocumentChunksPagedCallable() {
    return searchDocumentChunksPagedCallable;
  }

  @Override
  public UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return getDocumentCallable;
  }

  @Override
  public UnaryCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable() {
    return batchGetDocumentsCallable;
  }

  @Override
  public UnaryCallable<AnswerQueryRequest, AnswerQueryResponse> answerQueryCallable() {
    return answerQueryCallable;
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
