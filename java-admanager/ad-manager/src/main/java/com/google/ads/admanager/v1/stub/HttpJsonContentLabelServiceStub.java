/*
 * Copyright 2025 Google LLC
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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.ContentLabelServiceClient.ListContentLabelsPagedResponse;

import com.google.ads.admanager.v1.ContentLabel;
import com.google.ads.admanager.v1.GetContentLabelRequest;
import com.google.ads.admanager.v1.ListContentLabelsRequest;
import com.google.ads.admanager.v1.ListContentLabelsResponse;
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
 * REST stub implementation for the ContentLabelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonContentLabelServiceStub extends ContentLabelServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetContentLabelRequest, ContentLabel>
      getContentLabelMethodDescriptor =
          ApiMethodDescriptor.<GetContentLabelRequest, ContentLabel>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ContentLabelService/GetContentLabel")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetContentLabelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/contentLabels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetContentLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetContentLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ContentLabel>newBuilder()
                      .setDefaultInstance(ContentLabel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListContentLabelsRequest, ListContentLabelsResponse>
      listContentLabelsMethodDescriptor =
          ApiMethodDescriptor.<ListContentLabelsRequest, ListContentLabelsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ContentLabelService/ListContentLabels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListContentLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/contentLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListContentLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListContentLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListContentLabelsResponse>newBuilder()
                      .setDefaultInstance(ListContentLabelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetContentLabelRequest, ContentLabel> getContentLabelCallable;
  private final UnaryCallable<ListContentLabelsRequest, ListContentLabelsResponse>
      listContentLabelsCallable;
  private final UnaryCallable<ListContentLabelsRequest, ListContentLabelsPagedResponse>
      listContentLabelsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonContentLabelServiceStub create(
      ContentLabelServiceStubSettings settings) throws IOException {
    return new HttpJsonContentLabelServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonContentLabelServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonContentLabelServiceStub(
        ContentLabelServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonContentLabelServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonContentLabelServiceStub(
        ContentLabelServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonContentLabelServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonContentLabelServiceStub(
      ContentLabelServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonContentLabelServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonContentLabelServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonContentLabelServiceStub(
      ContentLabelServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetContentLabelRequest, ContentLabel> getContentLabelTransportSettings =
        HttpJsonCallSettings.<GetContentLabelRequest, ContentLabel>newBuilder()
            .setMethodDescriptor(getContentLabelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListContentLabelsRequest, ListContentLabelsResponse>
        listContentLabelsTransportSettings =
            HttpJsonCallSettings.<ListContentLabelsRequest, ListContentLabelsResponse>newBuilder()
                .setMethodDescriptor(listContentLabelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getContentLabelCallable =
        callableFactory.createUnaryCallable(
            getContentLabelTransportSettings, settings.getContentLabelSettings(), clientContext);
    this.listContentLabelsCallable =
        callableFactory.createUnaryCallable(
            listContentLabelsTransportSettings,
            settings.listContentLabelsSettings(),
            clientContext);
    this.listContentLabelsPagedCallable =
        callableFactory.createPagedCallable(
            listContentLabelsTransportSettings,
            settings.listContentLabelsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getContentLabelMethodDescriptor);
    methodDescriptors.add(listContentLabelsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetContentLabelRequest, ContentLabel> getContentLabelCallable() {
    return getContentLabelCallable;
  }

  @Override
  public UnaryCallable<ListContentLabelsRequest, ListContentLabelsResponse>
      listContentLabelsCallable() {
    return listContentLabelsCallable;
  }

  @Override
  public UnaryCallable<ListContentLabelsRequest, ListContentLabelsPagedResponse>
      listContentLabelsPagedCallable() {
    return listContentLabelsPagedCallable;
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
