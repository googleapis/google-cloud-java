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

import static com.google.ads.admanager.v1.LineItemTemplateServiceClient.ListLineItemTemplatesPagedResponse;

import com.google.ads.admanager.v1.GetLineItemTemplateRequest;
import com.google.ads.admanager.v1.LineItemTemplate;
import com.google.ads.admanager.v1.ListLineItemTemplatesRequest;
import com.google.ads.admanager.v1.ListLineItemTemplatesResponse;
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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the LineItemTemplateService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonLineItemTemplateServiceStub extends LineItemTemplateServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetLineItemTemplateRequest, LineItemTemplate>
      getLineItemTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetLineItemTemplateRequest, LineItemTemplate>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemTemplateService/GetLineItemTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLineItemTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/lineItemTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLineItemTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLineItemTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LineItemTemplate>newBuilder()
                      .setDefaultInstance(LineItemTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListLineItemTemplatesRequest, ListLineItemTemplatesResponse>
      listLineItemTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<ListLineItemTemplatesRequest, ListLineItemTemplatesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.LineItemTemplateService/ListLineItemTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLineItemTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/lineItemTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLineItemTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLineItemTemplatesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListLineItemTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListLineItemTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetLineItemTemplateRequest, LineItemTemplate>
      getLineItemTemplateCallable;
  private final UnaryCallable<ListLineItemTemplatesRequest, ListLineItemTemplatesResponse>
      listLineItemTemplatesCallable;
  private final UnaryCallable<ListLineItemTemplatesRequest, ListLineItemTemplatesPagedResponse>
      listLineItemTemplatesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLineItemTemplateServiceStub create(
      LineItemTemplateServiceStubSettings settings) throws IOException {
    return new HttpJsonLineItemTemplateServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLineItemTemplateServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLineItemTemplateServiceStub(
        LineItemTemplateServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonLineItemTemplateServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLineItemTemplateServiceStub(
        LineItemTemplateServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLineItemTemplateServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLineItemTemplateServiceStub(
      LineItemTemplateServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonLineItemTemplateServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLineItemTemplateServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLineItemTemplateServiceStub(
      LineItemTemplateServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetLineItemTemplateRequest, LineItemTemplate>
        getLineItemTemplateTransportSettings =
            HttpJsonCallSettings.<GetLineItemTemplateRequest, LineItemTemplate>newBuilder()
                .setMethodDescriptor(getLineItemTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListLineItemTemplatesRequest, ListLineItemTemplatesResponse>
        listLineItemTemplatesTransportSettings =
            HttpJsonCallSettings
                .<ListLineItemTemplatesRequest, ListLineItemTemplatesResponse>newBuilder()
                .setMethodDescriptor(listLineItemTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getLineItemTemplateCallable =
        callableFactory.createUnaryCallable(
            getLineItemTemplateTransportSettings,
            settings.getLineItemTemplateSettings(),
            clientContext);
    this.listLineItemTemplatesCallable =
        callableFactory.createUnaryCallable(
            listLineItemTemplatesTransportSettings,
            settings.listLineItemTemplatesSettings(),
            clientContext);
    this.listLineItemTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listLineItemTemplatesTransportSettings,
            settings.listLineItemTemplatesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getLineItemTemplateMethodDescriptor);
    methodDescriptors.add(listLineItemTemplatesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetLineItemTemplateRequest, LineItemTemplate> getLineItemTemplateCallable() {
    return getLineItemTemplateCallable;
  }

  @Override
  public UnaryCallable<ListLineItemTemplatesRequest, ListLineItemTemplatesResponse>
      listLineItemTemplatesCallable() {
    return listLineItemTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListLineItemTemplatesRequest, ListLineItemTemplatesPagedResponse>
      listLineItemTemplatesPagedCallable() {
    return listLineItemTemplatesPagedCallable;
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
