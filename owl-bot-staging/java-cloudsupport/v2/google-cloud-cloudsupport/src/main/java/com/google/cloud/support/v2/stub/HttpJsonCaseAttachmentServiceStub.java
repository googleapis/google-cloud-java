/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.support.v2.stub;

import static com.google.cloud.support.v2.CaseAttachmentServiceClient.ListAttachmentsPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2.ListAttachmentsRequest;
import com.google.cloud.support.v2.ListAttachmentsResponse;
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
 * REST stub implementation for the CaseAttachmentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCaseAttachmentServiceStub extends CaseAttachmentServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListAttachmentsRequest, ListAttachmentsResponse>
      listAttachmentsMethodDescriptor =
          ApiMethodDescriptor.<ListAttachmentsRequest, ListAttachmentsResponse>newBuilder()
              .setFullMethodName("google.cloud.support.v2.CaseAttachmentService/ListAttachments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAttachmentsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/cases/*}/attachments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAttachmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=organizations/*/cases/*}/attachments")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAttachmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAttachmentsResponse>newBuilder()
                      .setDefaultInstance(ListAttachmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListAttachmentsRequest, ListAttachmentsResponse>
      listAttachmentsCallable;
  private final UnaryCallable<ListAttachmentsRequest, ListAttachmentsPagedResponse>
      listAttachmentsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCaseAttachmentServiceStub create(
      CaseAttachmentServiceStubSettings settings) throws IOException {
    return new HttpJsonCaseAttachmentServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCaseAttachmentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCaseAttachmentServiceStub(
        CaseAttachmentServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCaseAttachmentServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCaseAttachmentServiceStub(
        CaseAttachmentServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCaseAttachmentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCaseAttachmentServiceStub(
      CaseAttachmentServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCaseAttachmentServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCaseAttachmentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCaseAttachmentServiceStub(
      CaseAttachmentServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListAttachmentsRequest, ListAttachmentsResponse>
        listAttachmentsTransportSettings =
            HttpJsonCallSettings.<ListAttachmentsRequest, ListAttachmentsResponse>newBuilder()
                .setMethodDescriptor(listAttachmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listAttachmentsCallable =
        callableFactory.createUnaryCallable(
            listAttachmentsTransportSettings, settings.listAttachmentsSettings(), clientContext);
    this.listAttachmentsPagedCallable =
        callableFactory.createPagedCallable(
            listAttachmentsTransportSettings, settings.listAttachmentsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listAttachmentsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListAttachmentsRequest, ListAttachmentsResponse> listAttachmentsCallable() {
    return listAttachmentsCallable;
  }

  @Override
  public UnaryCallable<ListAttachmentsRequest, ListAttachmentsPagedResponse>
      listAttachmentsPagedCallable() {
    return listAttachmentsPagedCallable;
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
