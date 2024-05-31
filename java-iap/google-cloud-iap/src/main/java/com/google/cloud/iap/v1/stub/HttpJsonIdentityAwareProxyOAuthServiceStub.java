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

package com.google.cloud.iap.v1.stub;

import static com.google.cloud.iap.v1.IdentityAwareProxyOAuthServiceClient.ListIdentityAwareProxyClientsPagedResponse;

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
import com.google.cloud.iap.v1.Brand;
import com.google.cloud.iap.v1.CreateBrandRequest;
import com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest;
import com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest;
import com.google.cloud.iap.v1.GetBrandRequest;
import com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest;
import com.google.cloud.iap.v1.IdentityAwareProxyClient;
import com.google.cloud.iap.v1.ListBrandsRequest;
import com.google.cloud.iap.v1.ListBrandsResponse;
import com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest;
import com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse;
import com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest;
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
 * REST stub implementation for the IdentityAwareProxyOAuthService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonIdentityAwareProxyOAuthServiceStub extends IdentityAwareProxyOAuthServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListBrandsRequest, ListBrandsResponse>
      listBrandsMethodDescriptor =
          ApiMethodDescriptor.<ListBrandsRequest, ListBrandsResponse>newBuilder()
              .setFullMethodName("google.cloud.iap.v1.IdentityAwareProxyOAuthService/ListBrands")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBrandsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/brands",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBrandsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBrandsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBrandsResponse>newBuilder()
                      .setDefaultInstance(ListBrandsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateBrandRequest, Brand> createBrandMethodDescriptor =
      ApiMethodDescriptor.<CreateBrandRequest, Brand>newBuilder()
          .setFullMethodName("google.cloud.iap.v1.IdentityAwareProxyOAuthService/CreateBrand")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateBrandRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*}/brands",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateBrandRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateBrandRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("brand", request.getBrand(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Brand>newBuilder()
                  .setDefaultInstance(Brand.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetBrandRequest, Brand> getBrandMethodDescriptor =
      ApiMethodDescriptor.<GetBrandRequest, Brand>newBuilder()
          .setFullMethodName("google.cloud.iap.v1.IdentityAwareProxyOAuthService/GetBrand")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBrandRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/brands/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetBrandRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetBrandRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Brand>newBuilder()
                  .setDefaultInstance(Brand.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<
          CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      createIdentityAwareProxyClientMethodDescriptor =
          ApiMethodDescriptor
              .<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyOAuthService/CreateIdentityAwareProxyClient")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateIdentityAwareProxyClientRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/brands/*}/identityAwareProxyClients",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIdentityAwareProxyClientRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIdentityAwareProxyClientRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "identityAwareProxyClient",
                                      request.getIdentityAwareProxyClient(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IdentityAwareProxyClient>newBuilder()
                      .setDefaultInstance(IdentityAwareProxyClient.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
      listIdentityAwareProxyClientsMethodDescriptor =
          ApiMethodDescriptor
              .<ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyOAuthService/ListIdentityAwareProxyClients")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIdentityAwareProxyClientsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/brands/*}/identityAwareProxyClients",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIdentityAwareProxyClientsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIdentityAwareProxyClientsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIdentityAwareProxyClientsResponse>newBuilder()
                      .setDefaultInstance(
                          ListIdentityAwareProxyClientsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      getIdentityAwareProxyClientMethodDescriptor =
          ApiMethodDescriptor
              .<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyOAuthService/GetIdentityAwareProxyClient")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIdentityAwareProxyClientRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/brands/*/identityAwareProxyClients/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIdentityAwareProxyClientRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIdentityAwareProxyClientRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IdentityAwareProxyClient>newBuilder()
                      .setDefaultInstance(IdentityAwareProxyClient.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
      resetIdentityAwareProxyClientSecretMethodDescriptor =
          ApiMethodDescriptor
              .<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyOAuthService/ResetIdentityAwareProxyClientSecret")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ResetIdentityAwareProxyClientSecretRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/brands/*/identityAwareProxyClients/*}:resetSecret",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResetIdentityAwareProxyClientSecretRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResetIdentityAwareProxyClientSecretRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IdentityAwareProxyClient>newBuilder()
                      .setDefaultInstance(IdentityAwareProxyClient.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteIdentityAwareProxyClientRequest, Empty>
      deleteIdentityAwareProxyClientMethodDescriptor =
          ApiMethodDescriptor.<DeleteIdentityAwareProxyClientRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.iap.v1.IdentityAwareProxyOAuthService/DeleteIdentityAwareProxyClient")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteIdentityAwareProxyClientRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/brands/*/identityAwareProxyClients/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIdentityAwareProxyClientRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIdentityAwareProxyClientRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListBrandsRequest, ListBrandsResponse> listBrandsCallable;
  private final UnaryCallable<CreateBrandRequest, Brand> createBrandCallable;
  private final UnaryCallable<GetBrandRequest, Brand> getBrandCallable;
  private final UnaryCallable<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      createIdentityAwareProxyClientCallable;
  private final UnaryCallable<
          ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
      listIdentityAwareProxyClientsCallable;
  private final UnaryCallable<
          ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsPagedResponse>
      listIdentityAwareProxyClientsPagedCallable;
  private final UnaryCallable<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      getIdentityAwareProxyClientCallable;
  private final UnaryCallable<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
      resetIdentityAwareProxyClientSecretCallable;
  private final UnaryCallable<DeleteIdentityAwareProxyClientRequest, Empty>
      deleteIdentityAwareProxyClientCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonIdentityAwareProxyOAuthServiceStub create(
      IdentityAwareProxyOAuthServiceStubSettings settings) throws IOException {
    return new HttpJsonIdentityAwareProxyOAuthServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonIdentityAwareProxyOAuthServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonIdentityAwareProxyOAuthServiceStub(
        IdentityAwareProxyOAuthServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonIdentityAwareProxyOAuthServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonIdentityAwareProxyOAuthServiceStub(
        IdentityAwareProxyOAuthServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonIdentityAwareProxyOAuthServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonIdentityAwareProxyOAuthServiceStub(
      IdentityAwareProxyOAuthServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonIdentityAwareProxyOAuthServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonIdentityAwareProxyOAuthServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonIdentityAwareProxyOAuthServiceStub(
      IdentityAwareProxyOAuthServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListBrandsRequest, ListBrandsResponse> listBrandsTransportSettings =
        HttpJsonCallSettings.<ListBrandsRequest, ListBrandsResponse>newBuilder()
            .setMethodDescriptor(listBrandsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateBrandRequest, Brand> createBrandTransportSettings =
        HttpJsonCallSettings.<CreateBrandRequest, Brand>newBuilder()
            .setMethodDescriptor(createBrandMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetBrandRequest, Brand> getBrandTransportSettings =
        HttpJsonCallSettings.<GetBrandRequest, Brand>newBuilder()
            .setMethodDescriptor(getBrandMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
        createIdentityAwareProxyClientTransportSettings =
            HttpJsonCallSettings
                .<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>newBuilder()
                .setMethodDescriptor(createIdentityAwareProxyClientMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
        listIdentityAwareProxyClientsTransportSettings =
            HttpJsonCallSettings
                .<ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
                    newBuilder()
                .setMethodDescriptor(listIdentityAwareProxyClientsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
        getIdentityAwareProxyClientTransportSettings =
            HttpJsonCallSettings
                .<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>newBuilder()
                .setMethodDescriptor(getIdentityAwareProxyClientMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
        resetIdentityAwareProxyClientSecretTransportSettings =
            HttpJsonCallSettings
                .<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>newBuilder()
                .setMethodDescriptor(resetIdentityAwareProxyClientSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteIdentityAwareProxyClientRequest, Empty>
        deleteIdentityAwareProxyClientTransportSettings =
            HttpJsonCallSettings.<DeleteIdentityAwareProxyClientRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteIdentityAwareProxyClientMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.listBrandsCallable =
        callableFactory.createUnaryCallable(
            listBrandsTransportSettings, settings.listBrandsSettings(), clientContext);
    this.createBrandCallable =
        callableFactory.createUnaryCallable(
            createBrandTransportSettings, settings.createBrandSettings(), clientContext);
    this.getBrandCallable =
        callableFactory.createUnaryCallable(
            getBrandTransportSettings, settings.getBrandSettings(), clientContext);
    this.createIdentityAwareProxyClientCallable =
        callableFactory.createUnaryCallable(
            createIdentityAwareProxyClientTransportSettings,
            settings.createIdentityAwareProxyClientSettings(),
            clientContext);
    this.listIdentityAwareProxyClientsCallable =
        callableFactory.createUnaryCallable(
            listIdentityAwareProxyClientsTransportSettings,
            settings.listIdentityAwareProxyClientsSettings(),
            clientContext);
    this.listIdentityAwareProxyClientsPagedCallable =
        callableFactory.createPagedCallable(
            listIdentityAwareProxyClientsTransportSettings,
            settings.listIdentityAwareProxyClientsSettings(),
            clientContext);
    this.getIdentityAwareProxyClientCallable =
        callableFactory.createUnaryCallable(
            getIdentityAwareProxyClientTransportSettings,
            settings.getIdentityAwareProxyClientSettings(),
            clientContext);
    this.resetIdentityAwareProxyClientSecretCallable =
        callableFactory.createUnaryCallable(
            resetIdentityAwareProxyClientSecretTransportSettings,
            settings.resetIdentityAwareProxyClientSecretSettings(),
            clientContext);
    this.deleteIdentityAwareProxyClientCallable =
        callableFactory.createUnaryCallable(
            deleteIdentityAwareProxyClientTransportSettings,
            settings.deleteIdentityAwareProxyClientSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listBrandsMethodDescriptor);
    methodDescriptors.add(createBrandMethodDescriptor);
    methodDescriptors.add(getBrandMethodDescriptor);
    methodDescriptors.add(createIdentityAwareProxyClientMethodDescriptor);
    methodDescriptors.add(listIdentityAwareProxyClientsMethodDescriptor);
    methodDescriptors.add(getIdentityAwareProxyClientMethodDescriptor);
    methodDescriptors.add(resetIdentityAwareProxyClientSecretMethodDescriptor);
    methodDescriptors.add(deleteIdentityAwareProxyClientMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListBrandsRequest, ListBrandsResponse> listBrandsCallable() {
    return listBrandsCallable;
  }

  @Override
  public UnaryCallable<CreateBrandRequest, Brand> createBrandCallable() {
    return createBrandCallable;
  }

  @Override
  public UnaryCallable<GetBrandRequest, Brand> getBrandCallable() {
    return getBrandCallable;
  }

  @Override
  public UnaryCallable<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      createIdentityAwareProxyClientCallable() {
    return createIdentityAwareProxyClientCallable;
  }

  @Override
  public UnaryCallable<ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
      listIdentityAwareProxyClientsCallable() {
    return listIdentityAwareProxyClientsCallable;
  }

  @Override
  public UnaryCallable<
          ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsPagedResponse>
      listIdentityAwareProxyClientsPagedCallable() {
    return listIdentityAwareProxyClientsPagedCallable;
  }

  @Override
  public UnaryCallable<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      getIdentityAwareProxyClientCallable() {
    return getIdentityAwareProxyClientCallable;
  }

  @Override
  public UnaryCallable<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
      resetIdentityAwareProxyClientSecretCallable() {
    return resetIdentityAwareProxyClientSecretCallable;
  }

  @Override
  public UnaryCallable<DeleteIdentityAwareProxyClientRequest, Empty>
      deleteIdentityAwareProxyClientCallable() {
    return deleteIdentityAwareProxyClientCallable;
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
