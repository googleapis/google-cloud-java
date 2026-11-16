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

import static com.google.ads.admanager.v1.AudienceSegmentCategoryServiceClient.ListAudienceSegmentCategoriesPagedResponse;

import com.google.ads.admanager.v1.AudienceSegmentCategory;
import com.google.ads.admanager.v1.GetAudienceSegmentCategoryRequest;
import com.google.ads.admanager.v1.ListAudienceSegmentCategoriesRequest;
import com.google.ads.admanager.v1.ListAudienceSegmentCategoriesResponse;
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
 * REST stub implementation for the AudienceSegmentCategoryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonAudienceSegmentCategoryServiceStub extends AudienceSegmentCategoryServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          GetAudienceSegmentCategoryRequest, AudienceSegmentCategory>
      getAudienceSegmentCategoryMethodDescriptor =
          ApiMethodDescriptor
              .<GetAudienceSegmentCategoryRequest, AudienceSegmentCategory>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.AudienceSegmentCategoryService/GetAudienceSegmentCategory")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAudienceSegmentCategoryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/audienceSegmentCategories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAudienceSegmentCategoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAudienceSegmentCategoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AudienceSegmentCategory>newBuilder()
                      .setDefaultInstance(AudienceSegmentCategory.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAudienceSegmentCategoriesRequest, ListAudienceSegmentCategoriesResponse>
      listAudienceSegmentCategoriesMethodDescriptor =
          ApiMethodDescriptor
              .<ListAudienceSegmentCategoriesRequest, ListAudienceSegmentCategoriesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.AudienceSegmentCategoryService/ListAudienceSegmentCategories")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAudienceSegmentCategoriesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/audienceSegmentCategories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAudienceSegmentCategoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAudienceSegmentCategoriesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAudienceSegmentCategoriesResponse>newBuilder()
                      .setDefaultInstance(
                          ListAudienceSegmentCategoriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAudienceSegmentCategoryRequest, AudienceSegmentCategory>
      getAudienceSegmentCategoryCallable;
  private final UnaryCallable<
          ListAudienceSegmentCategoriesRequest, ListAudienceSegmentCategoriesResponse>
      listAudienceSegmentCategoriesCallable;
  private final UnaryCallable<
          ListAudienceSegmentCategoriesRequest, ListAudienceSegmentCategoriesPagedResponse>
      listAudienceSegmentCategoriesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAudienceSegmentCategoryServiceStub create(
      AudienceSegmentCategoryServiceStubSettings settings) throws IOException {
    return new HttpJsonAudienceSegmentCategoryServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAudienceSegmentCategoryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAudienceSegmentCategoryServiceStub(
        AudienceSegmentCategoryServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAudienceSegmentCategoryServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAudienceSegmentCategoryServiceStub(
        AudienceSegmentCategoryServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAudienceSegmentCategoryServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonAudienceSegmentCategoryServiceStub(
      AudienceSegmentCategoryServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAudienceSegmentCategoryServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAudienceSegmentCategoryServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonAudienceSegmentCategoryServiceStub(
      AudienceSegmentCategoryServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAudienceSegmentCategoryRequest, AudienceSegmentCategory>
        getAudienceSegmentCategoryTransportSettings =
            HttpJsonCallSettings
                .<GetAudienceSegmentCategoryRequest, AudienceSegmentCategory>newBuilder()
                .setMethodDescriptor(getAudienceSegmentCategoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<
            ListAudienceSegmentCategoriesRequest, ListAudienceSegmentCategoriesResponse>
        listAudienceSegmentCategoriesTransportSettings =
            HttpJsonCallSettings
                .<ListAudienceSegmentCategoriesRequest, ListAudienceSegmentCategoriesResponse>
                    newBuilder()
                .setMethodDescriptor(listAudienceSegmentCategoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getAudienceSegmentCategoryCallable =
        callableFactory.createUnaryCallable(
            getAudienceSegmentCategoryTransportSettings,
            settings.getAudienceSegmentCategorySettings(),
            clientContext);
    this.listAudienceSegmentCategoriesCallable =
        callableFactory.createUnaryCallable(
            listAudienceSegmentCategoriesTransportSettings,
            settings.listAudienceSegmentCategoriesSettings(),
            clientContext);
    this.listAudienceSegmentCategoriesPagedCallable =
        callableFactory.createPagedCallable(
            listAudienceSegmentCategoriesTransportSettings,
            settings.listAudienceSegmentCategoriesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAudienceSegmentCategoryMethodDescriptor);
    methodDescriptors.add(listAudienceSegmentCategoriesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAudienceSegmentCategoryRequest, AudienceSegmentCategory>
      getAudienceSegmentCategoryCallable() {
    return getAudienceSegmentCategoryCallable;
  }

  @Override
  public UnaryCallable<ListAudienceSegmentCategoriesRequest, ListAudienceSegmentCategoriesResponse>
      listAudienceSegmentCategoriesCallable() {
    return listAudienceSegmentCategoriesCallable;
  }

  @Override
  public UnaryCallable<
          ListAudienceSegmentCategoriesRequest, ListAudienceSegmentCategoriesPagedResponse>
      listAudienceSegmentCategoriesPagedCallable() {
    return listAudienceSegmentCategoriesPagedCallable;
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
