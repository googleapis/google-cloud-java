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

package com.google.cloud.contentwarehouse.v1.stub;

import static com.google.cloud.contentwarehouse.v1.DocumentLinkServiceClient.ListLinkedSourcesPagedResponse;

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
import com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest;
import com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest;
import com.google.cloud.contentwarehouse.v1.DocumentLink;
import com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest;
import com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse;
import com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest;
import com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the DocumentLinkService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDocumentLinkServiceStub extends DocumentLinkServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
      listLinkedTargetsMethodDescriptor =
          ApiMethodDescriptor.<ListLinkedTargetsRequest, ListLinkedTargetsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentLinkService/ListLinkedTargets")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLinkedTargetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/documents/*}/linkedTargets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLinkedTargetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLinkedTargetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLinkedTargetsResponse>newBuilder()
                      .setDefaultInstance(ListLinkedTargetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLinkedSourcesRequest, ListLinkedSourcesResponse>
      listLinkedSourcesMethodDescriptor =
          ApiMethodDescriptor.<ListLinkedSourcesRequest, ListLinkedSourcesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentLinkService/ListLinkedSources")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLinkedSourcesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/documents/*}/linkedSources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLinkedSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLinkedSourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLinkedSourcesResponse>newBuilder()
                      .setDefaultInstance(ListLinkedSourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDocumentLinkRequest, DocumentLink>
      createDocumentLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateDocumentLinkRequest, DocumentLink>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentLinkService/CreateDocumentLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDocumentLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/documents/*}/documentLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDocumentLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDocumentLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DocumentLink>newBuilder()
                      .setDefaultInstance(DocumentLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteDocumentLinkRequest, Empty>
      deleteDocumentLinkMethodDescriptor =
          ApiMethodDescriptor.<DeleteDocumentLinkRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.contentwarehouse.v1.DocumentLinkService/DeleteDocumentLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDocumentLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/documents/*/documentLinks/*}:delete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDocumentLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDocumentLinkRequest> serializer =
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
      listLinkedTargetsCallable;
  private final UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesResponse>
      listLinkedSourcesCallable;
  private final UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesPagedResponse>
      listLinkedSourcesPagedCallable;
  private final UnaryCallable<CreateDocumentLinkRequest, DocumentLink> createDocumentLinkCallable;
  private final UnaryCallable<DeleteDocumentLinkRequest, Empty> deleteDocumentLinkCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDocumentLinkServiceStub create(
      DocumentLinkServiceStubSettings settings) throws IOException {
    return new HttpJsonDocumentLinkServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDocumentLinkServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDocumentLinkServiceStub(
        DocumentLinkServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDocumentLinkServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDocumentLinkServiceStub(
        DocumentLinkServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDocumentLinkServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDocumentLinkServiceStub(
      DocumentLinkServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDocumentLinkServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDocumentLinkServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDocumentLinkServiceStub(
      DocumentLinkServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
        listLinkedTargetsTransportSettings =
            HttpJsonCallSettings.<ListLinkedTargetsRequest, ListLinkedTargetsResponse>newBuilder()
                .setMethodDescriptor(listLinkedTargetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListLinkedSourcesRequest, ListLinkedSourcesResponse>
        listLinkedSourcesTransportSettings =
            HttpJsonCallSettings.<ListLinkedSourcesRequest, ListLinkedSourcesResponse>newBuilder()
                .setMethodDescriptor(listLinkedSourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateDocumentLinkRequest, DocumentLink>
        createDocumentLinkTransportSettings =
            HttpJsonCallSettings.<CreateDocumentLinkRequest, DocumentLink>newBuilder()
                .setMethodDescriptor(createDocumentLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteDocumentLinkRequest, Empty> deleteDocumentLinkTransportSettings =
        HttpJsonCallSettings.<DeleteDocumentLinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDocumentLinkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listLinkedTargetsCallable =
        callableFactory.createUnaryCallable(
            listLinkedTargetsTransportSettings,
            settings.listLinkedTargetsSettings(),
            clientContext);
    this.listLinkedSourcesCallable =
        callableFactory.createUnaryCallable(
            listLinkedSourcesTransportSettings,
            settings.listLinkedSourcesSettings(),
            clientContext);
    this.listLinkedSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listLinkedSourcesTransportSettings,
            settings.listLinkedSourcesSettings(),
            clientContext);
    this.createDocumentLinkCallable =
        callableFactory.createUnaryCallable(
            createDocumentLinkTransportSettings,
            settings.createDocumentLinkSettings(),
            clientContext);
    this.deleteDocumentLinkCallable =
        callableFactory.createUnaryCallable(
            deleteDocumentLinkTransportSettings,
            settings.deleteDocumentLinkSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listLinkedTargetsMethodDescriptor);
    methodDescriptors.add(listLinkedSourcesMethodDescriptor);
    methodDescriptors.add(createDocumentLinkMethodDescriptor);
    methodDescriptors.add(deleteDocumentLinkMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
      listLinkedTargetsCallable() {
    return listLinkedTargetsCallable;
  }

  @Override
  public UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesResponse>
      listLinkedSourcesCallable() {
    return listLinkedSourcesCallable;
  }

  @Override
  public UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesPagedResponse>
      listLinkedSourcesPagedCallable() {
    return listLinkedSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDocumentLinkRequest, DocumentLink> createDocumentLinkCallable() {
    return createDocumentLinkCallable;
  }

  @Override
  public UnaryCallable<DeleteDocumentLinkRequest, Empty> deleteDocumentLinkCallable() {
    return deleteDocumentLinkCallable;
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
