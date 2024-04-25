/*
 * Copyright 2024 Google LLC
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

import static com.google.ads.admanager.v1.CustomFieldServiceClient.ListCustomFieldsPagedResponse;

import com.google.ads.admanager.v1.CustomField;
import com.google.ads.admanager.v1.GetCustomFieldRequest;
import com.google.ads.admanager.v1.ListCustomFieldsRequest;
import com.google.ads.admanager.v1.ListCustomFieldsResponse;
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
 * REST stub implementation for the CustomFieldService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCustomFieldServiceStub extends CustomFieldServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCustomFieldRequest, CustomField>
      getCustomFieldMethodDescriptor =
          ApiMethodDescriptor.<GetCustomFieldRequest, CustomField>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CustomFieldService/GetCustomField")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomFieldRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/customFields/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomField>newBuilder()
                      .setDefaultInstance(CustomField.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCustomFieldsRequest, ListCustomFieldsResponse>
      listCustomFieldsMethodDescriptor =
          ApiMethodDescriptor.<ListCustomFieldsRequest, ListCustomFieldsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CustomFieldService/ListCustomFields")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomFieldsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customFields",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomFieldsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomFieldsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCustomFieldsResponse>newBuilder()
                      .setDefaultInstance(ListCustomFieldsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCustomFieldRequest, CustomField> getCustomFieldCallable;
  private final UnaryCallable<ListCustomFieldsRequest, ListCustomFieldsResponse>
      listCustomFieldsCallable;
  private final UnaryCallable<ListCustomFieldsRequest, ListCustomFieldsPagedResponse>
      listCustomFieldsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCustomFieldServiceStub create(CustomFieldServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCustomFieldServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCustomFieldServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCustomFieldServiceStub(
        CustomFieldServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCustomFieldServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCustomFieldServiceStub(
        CustomFieldServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCustomFieldServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCustomFieldServiceStub(
      CustomFieldServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCustomFieldServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCustomFieldServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCustomFieldServiceStub(
      CustomFieldServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCustomFieldRequest, CustomField> getCustomFieldTransportSettings =
        HttpJsonCallSettings.<GetCustomFieldRequest, CustomField>newBuilder()
            .setMethodDescriptor(getCustomFieldMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCustomFieldsRequest, ListCustomFieldsResponse>
        listCustomFieldsTransportSettings =
            HttpJsonCallSettings.<ListCustomFieldsRequest, ListCustomFieldsResponse>newBuilder()
                .setMethodDescriptor(listCustomFieldsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getCustomFieldCallable =
        callableFactory.createUnaryCallable(
            getCustomFieldTransportSettings, settings.getCustomFieldSettings(), clientContext);
    this.listCustomFieldsCallable =
        callableFactory.createUnaryCallable(
            listCustomFieldsTransportSettings, settings.listCustomFieldsSettings(), clientContext);
    this.listCustomFieldsPagedCallable =
        callableFactory.createPagedCallable(
            listCustomFieldsTransportSettings, settings.listCustomFieldsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCustomFieldMethodDescriptor);
    methodDescriptors.add(listCustomFieldsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCustomFieldRequest, CustomField> getCustomFieldCallable() {
    return getCustomFieldCallable;
  }

  @Override
  public UnaryCallable<ListCustomFieldsRequest, ListCustomFieldsResponse>
      listCustomFieldsCallable() {
    return listCustomFieldsCallable;
  }

  @Override
  public UnaryCallable<ListCustomFieldsRequest, ListCustomFieldsPagedResponse>
      listCustomFieldsPagedCallable() {
    return listCustomFieldsPagedCallable;
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
