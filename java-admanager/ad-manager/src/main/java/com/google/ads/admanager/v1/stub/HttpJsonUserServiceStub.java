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

import static com.google.ads.admanager.v1.UserServiceClient.ListUsersPagedResponse;

import com.google.ads.admanager.v1.BatchActivateUsersRequest;
import com.google.ads.admanager.v1.BatchActivateUsersResponse;
import com.google.ads.admanager.v1.BatchCreateUsersRequest;
import com.google.ads.admanager.v1.BatchCreateUsersResponse;
import com.google.ads.admanager.v1.BatchDeactivateUsersRequest;
import com.google.ads.admanager.v1.BatchDeactivateUsersResponse;
import com.google.ads.admanager.v1.BatchUpdateUsersRequest;
import com.google.ads.admanager.v1.BatchUpdateUsersResponse;
import com.google.ads.admanager.v1.CreateUserRequest;
import com.google.ads.admanager.v1.GetUserRequest;
import com.google.ads.admanager.v1.ListUsersRequest;
import com.google.ads.admanager.v1.ListUsersResponse;
import com.google.ads.admanager.v1.UpdateUserRequest;
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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the UserService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
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

  private static final ApiMethodDescriptor<CreateUserRequest, User> createUserMethodDescriptor =
      ApiMethodDescriptor.<CreateUserRequest, User>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.UserService/CreateUser")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateUserRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=networks/*}/users",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("user", request.getUser(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<User>newBuilder()
                  .setDefaultInstance(User.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchCreateUsersRequest, BatchCreateUsersResponse>
      batchCreateUsersMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateUsersRequest, BatchCreateUsersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.UserService/BatchCreateUsers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateUsersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/users:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateUsersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateUsersRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateUsersResponse>newBuilder()
                      .setDefaultInstance(BatchCreateUsersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchActivateUsersRequest, BatchActivateUsersResponse>
      batchActivateUsersMethodDescriptor =
          ApiMethodDescriptor.<BatchActivateUsersRequest, BatchActivateUsersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.UserService/BatchActivateUsers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateUsersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/users:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateUsersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateUsersRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchActivateUsersResponse>newBuilder()
                      .setDefaultInstance(BatchActivateUsersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateUsersRequest, BatchDeactivateUsersResponse>
      batchDeactivateUsersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateUsersRequest, BatchDeactivateUsersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.UserService/BatchDeactivateUsers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeactivateUsersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/users:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateUsersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateUsersRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchDeactivateUsersResponse>newBuilder()
                      .setDefaultInstance(BatchDeactivateUsersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateUserRequest, User> updateUserMethodDescriptor =
      ApiMethodDescriptor.<UpdateUserRequest, User>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.UserService/UpdateUser")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateUserRequest>newBuilder()
                  .setPath(
                      "/v1/{user.name=networks/*/users/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "user.name", request.getUser().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateUserRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("user", request.getUser(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<User>newBuilder()
                  .setDefaultInstance(User.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchUpdateUsersRequest, BatchUpdateUsersResponse>
      batchUpdateUsersMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdateUsersRequest, BatchUpdateUsersResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.UserService/BatchUpdateUsers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateUsersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/users:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateUsersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateUsersRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateUsersResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateUsersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetUserRequest, User> getUserCallable;
  private final UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable;
  private final UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable;
  private final UnaryCallable<CreateUserRequest, User> createUserCallable;
  private final UnaryCallable<BatchCreateUsersRequest, BatchCreateUsersResponse>
      batchCreateUsersCallable;
  private final UnaryCallable<BatchActivateUsersRequest, BatchActivateUsersResponse>
      batchActivateUsersCallable;
  private final UnaryCallable<BatchDeactivateUsersRequest, BatchDeactivateUsersResponse>
      batchDeactivateUsersCallable;
  private final UnaryCallable<UpdateUserRequest, User> updateUserCallable;
  private final UnaryCallable<BatchUpdateUsersRequest, BatchUpdateUsersResponse>
      batchUpdateUsersCallable;

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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreateUserRequest, User> createUserTransportSettings =
        HttpJsonCallSettings.<CreateUserRequest, User>newBuilder()
            .setMethodDescriptor(createUserMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchCreateUsersRequest, BatchCreateUsersResponse>
        batchCreateUsersTransportSettings =
            HttpJsonCallSettings.<BatchCreateUsersRequest, BatchCreateUsersResponse>newBuilder()
                .setMethodDescriptor(batchCreateUsersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchActivateUsersRequest, BatchActivateUsersResponse>
        batchActivateUsersTransportSettings =
            HttpJsonCallSettings.<BatchActivateUsersRequest, BatchActivateUsersResponse>newBuilder()
                .setMethodDescriptor(batchActivateUsersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchDeactivateUsersRequest, BatchDeactivateUsersResponse>
        batchDeactivateUsersTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateUsersRequest, BatchDeactivateUsersResponse>newBuilder()
                .setMethodDescriptor(batchDeactivateUsersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateUserRequest, User> updateUserTransportSettings =
        HttpJsonCallSettings.<UpdateUserRequest, User>newBuilder()
            .setMethodDescriptor(updateUserMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("user.name", String.valueOf(request.getUser().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateUsersRequest, BatchUpdateUsersResponse>
        batchUpdateUsersTransportSettings =
            HttpJsonCallSettings.<BatchUpdateUsersRequest, BatchUpdateUsersResponse>newBuilder()
                .setMethodDescriptor(batchUpdateUsersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
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
    this.createUserCallable =
        callableFactory.createUnaryCallable(
            createUserTransportSettings, settings.createUserSettings(), clientContext);
    this.batchCreateUsersCallable =
        callableFactory.createUnaryCallable(
            batchCreateUsersTransportSettings, settings.batchCreateUsersSettings(), clientContext);
    this.batchActivateUsersCallable =
        callableFactory.createUnaryCallable(
            batchActivateUsersTransportSettings,
            settings.batchActivateUsersSettings(),
            clientContext);
    this.batchDeactivateUsersCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateUsersTransportSettings,
            settings.batchDeactivateUsersSettings(),
            clientContext);
    this.updateUserCallable =
        callableFactory.createUnaryCallable(
            updateUserTransportSettings, settings.updateUserSettings(), clientContext);
    this.batchUpdateUsersCallable =
        callableFactory.createUnaryCallable(
            batchUpdateUsersTransportSettings, settings.batchUpdateUsersSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getUserMethodDescriptor);
    methodDescriptors.add(listUsersMethodDescriptor);
    methodDescriptors.add(createUserMethodDescriptor);
    methodDescriptors.add(batchCreateUsersMethodDescriptor);
    methodDescriptors.add(batchActivateUsersMethodDescriptor);
    methodDescriptors.add(batchDeactivateUsersMethodDescriptor);
    methodDescriptors.add(updateUserMethodDescriptor);
    methodDescriptors.add(batchUpdateUsersMethodDescriptor);
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
  public UnaryCallable<CreateUserRequest, User> createUserCallable() {
    return createUserCallable;
  }

  @Override
  public UnaryCallable<BatchCreateUsersRequest, BatchCreateUsersResponse>
      batchCreateUsersCallable() {
    return batchCreateUsersCallable;
  }

  @Override
  public UnaryCallable<BatchActivateUsersRequest, BatchActivateUsersResponse>
      batchActivateUsersCallable() {
    return batchActivateUsersCallable;
  }

  @Override
  public UnaryCallable<BatchDeactivateUsersRequest, BatchDeactivateUsersResponse>
      batchDeactivateUsersCallable() {
    return batchDeactivateUsersCallable;
  }

  @Override
  public UnaryCallable<UpdateUserRequest, User> updateUserCallable() {
    return updateUserCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateUsersRequest, BatchUpdateUsersResponse>
      batchUpdateUsersCallable() {
    return batchUpdateUsersCallable;
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
