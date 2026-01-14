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

import static com.google.ads.admanager.v1.CustomFieldServiceClient.ListCustomFieldsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCustomFieldsRequest;
import com.google.ads.admanager.v1.BatchActivateCustomFieldsResponse;
import com.google.ads.admanager.v1.BatchCreateCustomFieldsRequest;
import com.google.ads.admanager.v1.BatchCreateCustomFieldsResponse;
import com.google.ads.admanager.v1.BatchDeactivateCustomFieldsRequest;
import com.google.ads.admanager.v1.BatchDeactivateCustomFieldsResponse;
import com.google.ads.admanager.v1.BatchUpdateCustomFieldsRequest;
import com.google.ads.admanager.v1.BatchUpdateCustomFieldsResponse;
import com.google.ads.admanager.v1.CreateCustomFieldRequest;
import com.google.ads.admanager.v1.CustomField;
import com.google.ads.admanager.v1.GetCustomFieldRequest;
import com.google.ads.admanager.v1.ListCustomFieldsRequest;
import com.google.ads.admanager.v1.ListCustomFieldsResponse;
import com.google.ads.admanager.v1.UpdateCustomFieldRequest;
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

  private static final ApiMethodDescriptor<CreateCustomFieldRequest, CustomField>
      createCustomFieldMethodDescriptor =
          ApiMethodDescriptor.<CreateCustomFieldRequest, CustomField>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CustomFieldService/CreateCustomField")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomFieldRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customFields",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customField", request.getCustomField(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomField>newBuilder()
                      .setDefaultInstance(CustomField.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateCustomFieldsRequest, BatchCreateCustomFieldsResponse>
      batchCreateCustomFieldsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateCustomFieldsRequest, BatchCreateCustomFieldsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomFieldService/BatchCreateCustomFields")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateCustomFieldsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customFields:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateCustomFieldsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateCustomFieldsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateCustomFieldsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateCustomFieldsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCustomFieldRequest, CustomField>
      updateCustomFieldMethodDescriptor =
          ApiMethodDescriptor.<UpdateCustomFieldRequest, CustomField>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CustomFieldService/UpdateCustomField")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomFieldRequest>newBuilder()
                      .setPath(
                          "/v1/{customField.name=networks/*/customFields/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "customField.name", request.getCustomField().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomFieldRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customField", request.getCustomField(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomField>newBuilder()
                      .setDefaultInstance(CustomField.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateCustomFieldsRequest, BatchUpdateCustomFieldsResponse>
      batchUpdateCustomFieldsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateCustomFieldsRequest, BatchUpdateCustomFieldsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomFieldService/BatchUpdateCustomFields")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateCustomFieldsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customFields:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateCustomFieldsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateCustomFieldsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateCustomFieldsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateCustomFieldsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateCustomFieldsRequest, BatchActivateCustomFieldsResponse>
      batchActivateCustomFieldsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateCustomFieldsRequest, BatchActivateCustomFieldsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomFieldService/BatchActivateCustomFields")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateCustomFieldsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customFields:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateCustomFieldsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateCustomFieldsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchActivateCustomFieldsResponse>newBuilder()
                      .setDefaultInstance(BatchActivateCustomFieldsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateCustomFieldsRequest, BatchDeactivateCustomFieldsResponse>
      batchDeactivateCustomFieldsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateCustomFieldsRequest, BatchDeactivateCustomFieldsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CustomFieldService/BatchDeactivateCustomFields")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeactivateCustomFieldsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/customFields:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateCustomFieldsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateCustomFieldsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchDeactivateCustomFieldsResponse>newBuilder()
                      .setDefaultInstance(BatchDeactivateCustomFieldsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCustomFieldRequest, CustomField> getCustomFieldCallable;
  private final UnaryCallable<ListCustomFieldsRequest, ListCustomFieldsResponse>
      listCustomFieldsCallable;
  private final UnaryCallable<ListCustomFieldsRequest, ListCustomFieldsPagedResponse>
      listCustomFieldsPagedCallable;
  private final UnaryCallable<CreateCustomFieldRequest, CustomField> createCustomFieldCallable;
  private final UnaryCallable<BatchCreateCustomFieldsRequest, BatchCreateCustomFieldsResponse>
      batchCreateCustomFieldsCallable;
  private final UnaryCallable<UpdateCustomFieldRequest, CustomField> updateCustomFieldCallable;
  private final UnaryCallable<BatchUpdateCustomFieldsRequest, BatchUpdateCustomFieldsResponse>
      batchUpdateCustomFieldsCallable;
  private final UnaryCallable<BatchActivateCustomFieldsRequest, BatchActivateCustomFieldsResponse>
      batchActivateCustomFieldsCallable;
  private final UnaryCallable<
          BatchDeactivateCustomFieldsRequest, BatchDeactivateCustomFieldsResponse>
      batchDeactivateCustomFieldsCallable;

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
    HttpJsonCallSettings<CreateCustomFieldRequest, CustomField> createCustomFieldTransportSettings =
        HttpJsonCallSettings.<CreateCustomFieldRequest, CustomField>newBuilder()
            .setMethodDescriptor(createCustomFieldMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchCreateCustomFieldsRequest, BatchCreateCustomFieldsResponse>
        batchCreateCustomFieldsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateCustomFieldsRequest, BatchCreateCustomFieldsResponse>newBuilder()
                .setMethodDescriptor(batchCreateCustomFieldsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateCustomFieldRequest, CustomField> updateCustomFieldTransportSettings =
        HttpJsonCallSettings.<UpdateCustomFieldRequest, CustomField>newBuilder()
            .setMethodDescriptor(updateCustomFieldMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "custom_field.name", String.valueOf(request.getCustomField().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateCustomFieldsRequest, BatchUpdateCustomFieldsResponse>
        batchUpdateCustomFieldsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateCustomFieldsRequest, BatchUpdateCustomFieldsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateCustomFieldsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchActivateCustomFieldsRequest, BatchActivateCustomFieldsResponse>
        batchActivateCustomFieldsTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateCustomFieldsRequest, BatchActivateCustomFieldsResponse>newBuilder()
                .setMethodDescriptor(batchActivateCustomFieldsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchDeactivateCustomFieldsRequest, BatchDeactivateCustomFieldsResponse>
        batchDeactivateCustomFieldsTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateCustomFieldsRequest, BatchDeactivateCustomFieldsResponse>
                    newBuilder()
                .setMethodDescriptor(batchDeactivateCustomFieldsMethodDescriptor)
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
    this.createCustomFieldCallable =
        callableFactory.createUnaryCallable(
            createCustomFieldTransportSettings,
            settings.createCustomFieldSettings(),
            clientContext);
    this.batchCreateCustomFieldsCallable =
        callableFactory.createUnaryCallable(
            batchCreateCustomFieldsTransportSettings,
            settings.batchCreateCustomFieldsSettings(),
            clientContext);
    this.updateCustomFieldCallable =
        callableFactory.createUnaryCallable(
            updateCustomFieldTransportSettings,
            settings.updateCustomFieldSettings(),
            clientContext);
    this.batchUpdateCustomFieldsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateCustomFieldsTransportSettings,
            settings.batchUpdateCustomFieldsSettings(),
            clientContext);
    this.batchActivateCustomFieldsCallable =
        callableFactory.createUnaryCallable(
            batchActivateCustomFieldsTransportSettings,
            settings.batchActivateCustomFieldsSettings(),
            clientContext);
    this.batchDeactivateCustomFieldsCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateCustomFieldsTransportSettings,
            settings.batchDeactivateCustomFieldsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCustomFieldMethodDescriptor);
    methodDescriptors.add(listCustomFieldsMethodDescriptor);
    methodDescriptors.add(createCustomFieldMethodDescriptor);
    methodDescriptors.add(batchCreateCustomFieldsMethodDescriptor);
    methodDescriptors.add(updateCustomFieldMethodDescriptor);
    methodDescriptors.add(batchUpdateCustomFieldsMethodDescriptor);
    methodDescriptors.add(batchActivateCustomFieldsMethodDescriptor);
    methodDescriptors.add(batchDeactivateCustomFieldsMethodDescriptor);
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
  public UnaryCallable<CreateCustomFieldRequest, CustomField> createCustomFieldCallable() {
    return createCustomFieldCallable;
  }

  @Override
  public UnaryCallable<BatchCreateCustomFieldsRequest, BatchCreateCustomFieldsResponse>
      batchCreateCustomFieldsCallable() {
    return batchCreateCustomFieldsCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomFieldRequest, CustomField> updateCustomFieldCallable() {
    return updateCustomFieldCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateCustomFieldsRequest, BatchUpdateCustomFieldsResponse>
      batchUpdateCustomFieldsCallable() {
    return batchUpdateCustomFieldsCallable;
  }

  @Override
  public UnaryCallable<BatchActivateCustomFieldsRequest, BatchActivateCustomFieldsResponse>
      batchActivateCustomFieldsCallable() {
    return batchActivateCustomFieldsCallable;
  }

  @Override
  public UnaryCallable<BatchDeactivateCustomFieldsRequest, BatchDeactivateCustomFieldsResponse>
      batchDeactivateCustomFieldsCallable() {
    return batchDeactivateCustomFieldsCallable;
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
