/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.talent.v4.stub;

import static com.google.cloud.talent.v4.TenantServiceClient.ListTenantsPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.talent.v4.CreateTenantRequest;
import com.google.cloud.talent.v4.DeleteTenantRequest;
import com.google.cloud.talent.v4.GetTenantRequest;
import com.google.cloud.talent.v4.ListTenantsRequest;
import com.google.cloud.talent.v4.ListTenantsResponse;
import com.google.cloud.talent.v4.Tenant;
import com.google.cloud.talent.v4.UpdateTenantRequest;
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
 * REST stub implementation for the TenantService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTenantServiceStub extends TenantServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateTenantRequest, Tenant>
      createTenantMethodDescriptor =
          ApiMethodDescriptor.<CreateTenantRequest, Tenant>newBuilder()
              .setFullMethodName("google.cloud.talent.v4.TenantService/CreateTenant")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTenantRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=projects/*}/tenants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTenantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTenantRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tenant", request.getTenant(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Tenant>newBuilder()
                      .setDefaultInstance(Tenant.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTenantRequest, Tenant> getTenantMethodDescriptor =
      ApiMethodDescriptor.<GetTenantRequest, Tenant>newBuilder()
          .setFullMethodName("google.cloud.talent.v4.TenantService/GetTenant")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetTenantRequest>newBuilder()
                  .setPath(
                      "/v4/{name=projects/*/tenants/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetTenantRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetTenantRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Tenant>newBuilder()
                  .setDefaultInstance(Tenant.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateTenantRequest, Tenant>
      updateTenantMethodDescriptor =
          ApiMethodDescriptor.<UpdateTenantRequest, Tenant>newBuilder()
              .setFullMethodName("google.cloud.talent.v4.TenantService/UpdateTenant")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTenantRequest>newBuilder()
                      .setPath(
                          "/v4/{tenant.name=projects/*/tenants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTenantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "tenant.name", request.getTenant().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTenantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("tenant", request.getTenant(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Tenant>newBuilder()
                      .setDefaultInstance(Tenant.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteTenantRequest, Empty>
      deleteTenantMethodDescriptor =
          ApiMethodDescriptor.<DeleteTenantRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.talent.v4.TenantService/DeleteTenant")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteTenantRequest>newBuilder()
                      .setPath(
                          "/v4/{name=projects/*/tenants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTenantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteTenantRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<ListTenantsRequest, ListTenantsResponse>
      listTenantsMethodDescriptor =
          ApiMethodDescriptor.<ListTenantsRequest, ListTenantsResponse>newBuilder()
              .setFullMethodName("google.cloud.talent.v4.TenantService/ListTenants")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTenantsRequest>newBuilder()
                      .setPath(
                          "/v4/{parent=projects/*}/tenants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTenantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTenantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTenantsResponse>newBuilder()
                      .setDefaultInstance(ListTenantsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateTenantRequest, Tenant> createTenantCallable;
  private final UnaryCallable<GetTenantRequest, Tenant> getTenantCallable;
  private final UnaryCallable<UpdateTenantRequest, Tenant> updateTenantCallable;
  private final UnaryCallable<DeleteTenantRequest, Empty> deleteTenantCallable;
  private final UnaryCallable<ListTenantsRequest, ListTenantsResponse> listTenantsCallable;
  private final UnaryCallable<ListTenantsRequest, ListTenantsPagedResponse>
      listTenantsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTenantServiceStub create(TenantServiceStubSettings settings)
      throws IOException {
    return new HttpJsonTenantServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTenantServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTenantServiceStub(
        TenantServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTenantServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTenantServiceStub(
        TenantServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTenantServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTenantServiceStub(
      TenantServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTenantServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTenantServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTenantServiceStub(
      TenantServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateTenantRequest, Tenant> createTenantTransportSettings =
        HttpJsonCallSettings.<CreateTenantRequest, Tenant>newBuilder()
            .setMethodDescriptor(createTenantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetTenantRequest, Tenant> getTenantTransportSettings =
        HttpJsonCallSettings.<GetTenantRequest, Tenant>newBuilder()
            .setMethodDescriptor(getTenantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateTenantRequest, Tenant> updateTenantTransportSettings =
        HttpJsonCallSettings.<UpdateTenantRequest, Tenant>newBuilder()
            .setMethodDescriptor(updateTenantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteTenantRequest, Empty> deleteTenantTransportSettings =
        HttpJsonCallSettings.<DeleteTenantRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTenantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListTenantsRequest, ListTenantsResponse> listTenantsTransportSettings =
        HttpJsonCallSettings.<ListTenantsRequest, ListTenantsResponse>newBuilder()
            .setMethodDescriptor(listTenantsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createTenantCallable =
        callableFactory.createUnaryCallable(
            createTenantTransportSettings, settings.createTenantSettings(), clientContext);
    this.getTenantCallable =
        callableFactory.createUnaryCallable(
            getTenantTransportSettings, settings.getTenantSettings(), clientContext);
    this.updateTenantCallable =
        callableFactory.createUnaryCallable(
            updateTenantTransportSettings, settings.updateTenantSettings(), clientContext);
    this.deleteTenantCallable =
        callableFactory.createUnaryCallable(
            deleteTenantTransportSettings, settings.deleteTenantSettings(), clientContext);
    this.listTenantsCallable =
        callableFactory.createUnaryCallable(
            listTenantsTransportSettings, settings.listTenantsSettings(), clientContext);
    this.listTenantsPagedCallable =
        callableFactory.createPagedCallable(
            listTenantsTransportSettings, settings.listTenantsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createTenantMethodDescriptor);
    methodDescriptors.add(getTenantMethodDescriptor);
    methodDescriptors.add(updateTenantMethodDescriptor);
    methodDescriptors.add(deleteTenantMethodDescriptor);
    methodDescriptors.add(listTenantsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateTenantRequest, Tenant> createTenantCallable() {
    return createTenantCallable;
  }

  @Override
  public UnaryCallable<GetTenantRequest, Tenant> getTenantCallable() {
    return getTenantCallable;
  }

  @Override
  public UnaryCallable<UpdateTenantRequest, Tenant> updateTenantCallable() {
    return updateTenantCallable;
  }

  @Override
  public UnaryCallable<DeleteTenantRequest, Empty> deleteTenantCallable() {
    return deleteTenantCallable;
  }

  @Override
  public UnaryCallable<ListTenantsRequest, ListTenantsResponse> listTenantsCallable() {
    return listTenantsCallable;
  }

  @Override
  public UnaryCallable<ListTenantsRequest, ListTenantsPagedResponse> listTenantsPagedCallable() {
    return listTenantsPagedCallable;
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
