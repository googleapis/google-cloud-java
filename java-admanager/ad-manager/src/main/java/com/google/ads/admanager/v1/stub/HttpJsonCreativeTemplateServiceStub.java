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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.CreativeTemplateServiceClient.ListCreativeTemplatesPagedResponse;

import com.google.ads.admanager.v1.CreativeTemplate;
import com.google.ads.admanager.v1.GetCreativeTemplateRequest;
import com.google.ads.admanager.v1.ListCreativeTemplatesRequest;
import com.google.ads.admanager.v1.ListCreativeTemplatesResponse;
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
 * REST stub implementation for the CreativeTemplateService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCreativeTemplateServiceStub extends CreativeTemplateServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCreativeTemplateRequest, CreativeTemplate>
      getCreativeTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetCreativeTemplateRequest, CreativeTemplate>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CreativeTemplateService/GetCreativeTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCreativeTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/creativeTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCreativeTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCreativeTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CreativeTemplate>newBuilder()
                      .setDefaultInstance(CreativeTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCreativeTemplatesRequest, ListCreativeTemplatesResponse>
      listCreativeTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<ListCreativeTemplatesRequest, ListCreativeTemplatesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CreativeTemplateService/ListCreativeTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCreativeTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/creativeTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCreativeTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCreativeTemplatesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCreativeTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListCreativeTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCreativeTemplateRequest, CreativeTemplate>
      getCreativeTemplateCallable;
  private final UnaryCallable<ListCreativeTemplatesRequest, ListCreativeTemplatesResponse>
      listCreativeTemplatesCallable;
  private final UnaryCallable<ListCreativeTemplatesRequest, ListCreativeTemplatesPagedResponse>
      listCreativeTemplatesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCreativeTemplateServiceStub create(
      CreativeTemplateServiceStubSettings settings) throws IOException {
    return new HttpJsonCreativeTemplateServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCreativeTemplateServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCreativeTemplateServiceStub(
        CreativeTemplateServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCreativeTemplateServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCreativeTemplateServiceStub(
        CreativeTemplateServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCreativeTemplateServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCreativeTemplateServiceStub(
      CreativeTemplateServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCreativeTemplateServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCreativeTemplateServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCreativeTemplateServiceStub(
      CreativeTemplateServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCreativeTemplateRequest, CreativeTemplate>
        getCreativeTemplateTransportSettings =
            HttpJsonCallSettings.<GetCreativeTemplateRequest, CreativeTemplate>newBuilder()
                .setMethodDescriptor(getCreativeTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCreativeTemplatesRequest, ListCreativeTemplatesResponse>
        listCreativeTemplatesTransportSettings =
            HttpJsonCallSettings
                .<ListCreativeTemplatesRequest, ListCreativeTemplatesResponse>newBuilder()
                .setMethodDescriptor(listCreativeTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getCreativeTemplateCallable =
        callableFactory.createUnaryCallable(
            getCreativeTemplateTransportSettings,
            settings.getCreativeTemplateSettings(),
            clientContext);
    this.listCreativeTemplatesCallable =
        callableFactory.createUnaryCallable(
            listCreativeTemplatesTransportSettings,
            settings.listCreativeTemplatesSettings(),
            clientContext);
    this.listCreativeTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listCreativeTemplatesTransportSettings,
            settings.listCreativeTemplatesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCreativeTemplateMethodDescriptor);
    methodDescriptors.add(listCreativeTemplatesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCreativeTemplateRequest, CreativeTemplate> getCreativeTemplateCallable() {
    return getCreativeTemplateCallable;
  }

  @Override
  public UnaryCallable<ListCreativeTemplatesRequest, ListCreativeTemplatesResponse>
      listCreativeTemplatesCallable() {
    return listCreativeTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListCreativeTemplatesRequest, ListCreativeTemplatesPagedResponse>
      listCreativeTemplatesPagedCallable() {
    return listCreativeTemplatesPagedCallable;
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
