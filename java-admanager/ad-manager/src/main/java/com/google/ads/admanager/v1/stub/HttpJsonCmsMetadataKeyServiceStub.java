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

import static com.google.ads.admanager.v1.CmsMetadataKeyServiceClient.ListCmsMetadataKeysPagedResponse;

import com.google.ads.admanager.v1.CmsMetadataKey;
import com.google.ads.admanager.v1.GetCmsMetadataKeyRequest;
import com.google.ads.admanager.v1.ListCmsMetadataKeysRequest;
import com.google.ads.admanager.v1.ListCmsMetadataKeysResponse;
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
 * REST stub implementation for the CmsMetadataKeyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCmsMetadataKeyServiceStub extends CmsMetadataKeyServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCmsMetadataKeyRequest, CmsMetadataKey>
      getCmsMetadataKeyMethodDescriptor =
          ApiMethodDescriptor.<GetCmsMetadataKeyRequest, CmsMetadataKey>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CmsMetadataKeyService/GetCmsMetadataKey")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCmsMetadataKeyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/cmsMetadataKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCmsMetadataKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCmsMetadataKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CmsMetadataKey>newBuilder()
                      .setDefaultInstance(CmsMetadataKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCmsMetadataKeysRequest, ListCmsMetadataKeysResponse>
      listCmsMetadataKeysMethodDescriptor =
          ApiMethodDescriptor.<ListCmsMetadataKeysRequest, ListCmsMetadataKeysResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.CmsMetadataKeyService/ListCmsMetadataKeys")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCmsMetadataKeysRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/cmsMetadataKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCmsMetadataKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCmsMetadataKeysRequest> serializer =
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
                  ProtoMessageResponseParser.<ListCmsMetadataKeysResponse>newBuilder()
                      .setDefaultInstance(ListCmsMetadataKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCmsMetadataKeyRequest, CmsMetadataKey> getCmsMetadataKeyCallable;
  private final UnaryCallable<ListCmsMetadataKeysRequest, ListCmsMetadataKeysResponse>
      listCmsMetadataKeysCallable;
  private final UnaryCallable<ListCmsMetadataKeysRequest, ListCmsMetadataKeysPagedResponse>
      listCmsMetadataKeysPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCmsMetadataKeyServiceStub create(
      CmsMetadataKeyServiceStubSettings settings) throws IOException {
    return new HttpJsonCmsMetadataKeyServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCmsMetadataKeyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCmsMetadataKeyServiceStub(
        CmsMetadataKeyServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCmsMetadataKeyServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCmsMetadataKeyServiceStub(
        CmsMetadataKeyServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCmsMetadataKeyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCmsMetadataKeyServiceStub(
      CmsMetadataKeyServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCmsMetadataKeyServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCmsMetadataKeyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCmsMetadataKeyServiceStub(
      CmsMetadataKeyServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCmsMetadataKeyRequest, CmsMetadataKey>
        getCmsMetadataKeyTransportSettings =
            HttpJsonCallSettings.<GetCmsMetadataKeyRequest, CmsMetadataKey>newBuilder()
                .setMethodDescriptor(getCmsMetadataKeyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListCmsMetadataKeysRequest, ListCmsMetadataKeysResponse>
        listCmsMetadataKeysTransportSettings =
            HttpJsonCallSettings
                .<ListCmsMetadataKeysRequest, ListCmsMetadataKeysResponse>newBuilder()
                .setMethodDescriptor(listCmsMetadataKeysMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getCmsMetadataKeyCallable =
        callableFactory.createUnaryCallable(
            getCmsMetadataKeyTransportSettings,
            settings.getCmsMetadataKeySettings(),
            clientContext);
    this.listCmsMetadataKeysCallable =
        callableFactory.createUnaryCallable(
            listCmsMetadataKeysTransportSettings,
            settings.listCmsMetadataKeysSettings(),
            clientContext);
    this.listCmsMetadataKeysPagedCallable =
        callableFactory.createPagedCallable(
            listCmsMetadataKeysTransportSettings,
            settings.listCmsMetadataKeysSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCmsMetadataKeyMethodDescriptor);
    methodDescriptors.add(listCmsMetadataKeysMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCmsMetadataKeyRequest, CmsMetadataKey> getCmsMetadataKeyCallable() {
    return getCmsMetadataKeyCallable;
  }

  @Override
  public UnaryCallable<ListCmsMetadataKeysRequest, ListCmsMetadataKeysResponse>
      listCmsMetadataKeysCallable() {
    return listCmsMetadataKeysCallable;
  }

  @Override
  public UnaryCallable<ListCmsMetadataKeysRequest, ListCmsMetadataKeysPagedResponse>
      listCmsMetadataKeysPagedCallable() {
    return listCmsMetadataKeysPagedCallable;
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
