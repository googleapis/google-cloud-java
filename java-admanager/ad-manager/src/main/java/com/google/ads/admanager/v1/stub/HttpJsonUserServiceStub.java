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

import static com.google.ads.admanager.v1.UserServiceClient.ListUsersPagedResponse;

import com.google.ads.admanager.v1.GetUserRequest;
import com.google.ads.admanager.v1.ListUsersRequest;
import com.google.ads.admanager.v1.ListUsersResponse;
import com.google.ads.admanager.v1.User;
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
 * REST stub implementation for the UserService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonUserServiceStub extends UserServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetUserRequest, User> getUserMethodDescriptor =
      ApiMethodDescriptor.<GetUserRequest, User>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.UserService/GetUser")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetUserRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/users/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<User>newBuilder()
                  .setDefaultInstance(User.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListUsersRequest, ListUsersResponse>
      listUsersMethodDescriptor =
          ApiMethodDescriptor.<ListUsersRequest, ListUsersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.UserService/ListUsers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUsersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/users",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUsersRequest> serializer =
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
                  ProtoMessageResponseParser.<ListUsersResponse>newBuilder()
                      .setDefaultInstance(ListUsersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetUserRequest, User> getUserCallable;
  private final UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable;
  private final UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonUserServiceStub create(UserServiceStubSettings settings)
      throws IOException {
    return new HttpJsonUserServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonUserServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonUserServiceStub(UserServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonUserServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonUserServiceStub(
        UserServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonUserServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonUserServiceStub(UserServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonUserServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonUserServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonUserServiceStub(
      UserServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetUserRequest, User> getUserTransportSettings =
        HttpJsonCallSettings.<GetUserRequest, User>newBuilder()
            .setMethodDescriptor(getUserMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListUsersRequest, ListUsersResponse> listUsersTransportSettings =
        HttpJsonCallSettings.<ListUsersRequest, ListUsersResponse>newBuilder()
            .setMethodDescriptor(listUsersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getUserCallable =
        callableFactory.createUnaryCallable(
            getUserTransportSettings, settings.getUserSettings(), clientContext);
    this.listUsersCallable =
        callableFactory.createUnaryCallable(
            listUsersTransportSettings, settings.listUsersSettings(), clientContext);
    this.listUsersPagedCallable =
        callableFactory.createPagedCallable(
            listUsersTransportSettings, settings.listUsersSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getUserMethodDescriptor);
    methodDescriptors.add(listUsersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetUserRequest, User> getUserCallable() {
    return getUserCallable;
  }

  @Override
  public UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable() {
    return listUsersCallable;
  }

  @Override
  public UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable() {
    return listUsersPagedCallable;
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
