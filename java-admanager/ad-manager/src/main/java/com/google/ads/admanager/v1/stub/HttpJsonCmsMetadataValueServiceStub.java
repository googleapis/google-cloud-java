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

import static com.google.ads.admanager.v1.CmsMetadataValueServiceClient.ListCmsMetadataValuesPagedResponse;

import com.google.ads.admanager.v1.CmsMetadataValue;
import com.google.ads.admanager.v1.GetCmsMetadataValueRequest;
import com.google.ads.admanager.v1.ListCmsMetadataValuesRequest;
import com.google.ads.admanager.v1.ListCmsMetadataValuesResponse;
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
 * REST stub implementation for the CmsMetadataValueService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCmsMetadataValueServiceStub extends CmsMetadataValueServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCmsMetadataValueRequest, CmsMetadataValue>
      getCmsMetadataValueMethodDescriptor =
          ApiMethodDescriptor.<GetCmsMetadataValueRequest, CmsMetadataValue>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CmsMetadataValueService/GetCmsMetadataValue")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCmsMetadataValueRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/cmsMetadataValues/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCmsMetadataValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCmsMetadataValueRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CmsMetadataValue>newBuilder()
                      .setDefaultInstance(CmsMetadataValue.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCmsMetadataValuesRequest, ListCmsMetadataValuesResponse>
      listCmsMetadataValuesMethodDescriptor =
          ApiMethodDescriptor
              .<ListCmsMetadataValuesRequest, ListCmsMetadataValuesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CmsMetadataValueService/ListCmsMetadataValues")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCmsMetadataValuesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/cmsMetadataValues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCmsMetadataValuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCmsMetadataValuesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCmsMetadataValuesResponse>newBuilder()
                      .setDefaultInstance(ListCmsMetadataValuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCmsMetadataValueRequest, CmsMetadataValue>
      getCmsMetadataValueCallable;
  private final UnaryCallable<ListCmsMetadataValuesRequest, ListCmsMetadataValuesResponse>
      listCmsMetadataValuesCallable;
  private final UnaryCallable<ListCmsMetadataValuesRequest, ListCmsMetadataValuesPagedResponse>
      listCmsMetadataValuesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCmsMetadataValueServiceStub create(
      CmsMetadataValueServiceStubSettings settings) throws IOException {
    return new HttpJsonCmsMetadataValueServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCmsMetadataValueServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCmsMetadataValueServiceStub(
        CmsMetadataValueServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCmsMetadataValueServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCmsMetadataValueServiceStub(
        CmsMetadataValueServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCmsMetadataValueServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCmsMetadataValueServiceStub(
      CmsMetadataValueServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCmsMetadataValueServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCmsMetadataValueServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCmsMetadataValueServiceStub(
      CmsMetadataValueServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCmsMetadataValueRequest, CmsMetadataValue>
        getCmsMetadataValueTransportSettings =
            HttpJsonCallSettings.<GetCmsMetadataValueRequest, CmsMetadataValue>newBuilder()
                .setMethodDescriptor(getCmsMetadataValueMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCmsMetadataValuesRequest, ListCmsMetadataValuesResponse>
        listCmsMetadataValuesTransportSettings =
            HttpJsonCallSettings
                .<ListCmsMetadataValuesRequest, ListCmsMetadataValuesResponse>newBuilder()
                .setMethodDescriptor(listCmsMetadataValuesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getCmsMetadataValueCallable =
        callableFactory.createUnaryCallable(
            getCmsMetadataValueTransportSettings,
            settings.getCmsMetadataValueSettings(),
            clientContext);
    this.listCmsMetadataValuesCallable =
        callableFactory.createUnaryCallable(
            listCmsMetadataValuesTransportSettings,
            settings.listCmsMetadataValuesSettings(),
            clientContext);
    this.listCmsMetadataValuesPagedCallable =
        callableFactory.createPagedCallable(
            listCmsMetadataValuesTransportSettings,
            settings.listCmsMetadataValuesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCmsMetadataValueMethodDescriptor);
    methodDescriptors.add(listCmsMetadataValuesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCmsMetadataValueRequest, CmsMetadataValue> getCmsMetadataValueCallable() {
    return getCmsMetadataValueCallable;
  }

  @Override
  public UnaryCallable<ListCmsMetadataValuesRequest, ListCmsMetadataValuesResponse>
      listCmsMetadataValuesCallable() {
    return listCmsMetadataValuesCallable;
  }

  @Override
  public UnaryCallable<ListCmsMetadataValuesRequest, ListCmsMetadataValuesPagedResponse>
      listCmsMetadataValuesPagedCallable() {
    return listCmsMetadataValuesPagedCallable;
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
