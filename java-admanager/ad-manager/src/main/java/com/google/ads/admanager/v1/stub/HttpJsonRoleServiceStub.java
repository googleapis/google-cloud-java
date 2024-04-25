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

import static com.google.ads.admanager.v1.RoleServiceClient.ListRolesPagedResponse;

import com.google.ads.admanager.v1.GetRoleRequest;
import com.google.ads.admanager.v1.ListRolesRequest;
import com.google.ads.admanager.v1.ListRolesResponse;
import com.google.ads.admanager.v1.Role;
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
 * REST stub implementation for the RoleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonRoleServiceStub extends RoleServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetRoleRequest, Role> getRoleMethodDescriptor =
      ApiMethodDescriptor.<GetRoleRequest, Role>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.RoleService/GetRole")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRoleRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/roles/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRoleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRoleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Role>newBuilder()
                  .setDefaultInstance(Role.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListRolesRequest, ListRolesResponse>
      listRolesMethodDescriptor =
          ApiMethodDescriptor.<ListRolesRequest, ListRolesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.RoleService/ListRoles")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRolesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/roles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRolesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRolesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListRolesResponse>newBuilder()
                      .setDefaultInstance(ListRolesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetRoleRequest, Role> getRoleCallable;
  private final UnaryCallable<ListRolesRequest, ListRolesResponse> listRolesCallable;
  private final UnaryCallable<ListRolesRequest, ListRolesPagedResponse> listRolesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRoleServiceStub create(RoleServiceStubSettings settings)
      throws IOException {
    return new HttpJsonRoleServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRoleServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRoleServiceStub(RoleServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRoleServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRoleServiceStub(
        RoleServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRoleServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRoleServiceStub(RoleServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRoleServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRoleServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRoleServiceStub(
      RoleServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetRoleRequest, Role> getRoleTransportSettings =
        HttpJsonCallSettings.<GetRoleRequest, Role>newBuilder()
            .setMethodDescriptor(getRoleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRolesRequest, ListRolesResponse> listRolesTransportSettings =
        HttpJsonCallSettings.<ListRolesRequest, ListRolesResponse>newBuilder()
            .setMethodDescriptor(listRolesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getRoleCallable =
        callableFactory.createUnaryCallable(
            getRoleTransportSettings, settings.getRoleSettings(), clientContext);
    this.listRolesCallable =
        callableFactory.createUnaryCallable(
            listRolesTransportSettings, settings.listRolesSettings(), clientContext);
    this.listRolesPagedCallable =
        callableFactory.createPagedCallable(
            listRolesTransportSettings, settings.listRolesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getRoleMethodDescriptor);
    methodDescriptors.add(listRolesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetRoleRequest, Role> getRoleCallable() {
    return getRoleCallable;
  }

  @Override
  public UnaryCallable<ListRolesRequest, ListRolesResponse> listRolesCallable() {
    return listRolesCallable;
  }

  @Override
  public UnaryCallable<ListRolesRequest, ListRolesPagedResponse> listRolesPagedCallable() {
    return listRolesPagedCallable;
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
