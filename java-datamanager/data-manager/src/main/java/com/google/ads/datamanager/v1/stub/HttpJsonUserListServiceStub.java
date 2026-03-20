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

package com.google.ads.datamanager.v1.stub;

import static com.google.ads.datamanager.v1.UserListServiceClient.ListUserListsPagedResponse;

import com.google.ads.datamanager.v1.CreateUserListRequest;
import com.google.ads.datamanager.v1.DeleteUserListRequest;
import com.google.ads.datamanager.v1.GetUserListRequest;
import com.google.ads.datamanager.v1.ListUserListsRequest;
import com.google.ads.datamanager.v1.ListUserListsResponse;
import com.google.ads.datamanager.v1.UpdateUserListRequest;
import com.google.ads.datamanager.v1.UserList;
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
 * REST stub implementation for the UserListService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonUserListServiceStub extends UserListServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetUserListRequest, UserList>
      getUserListMethodDescriptor =
          ApiMethodDescriptor.<GetUserListRequest, UserList>newBuilder()
              .setFullMethodName("google.ads.datamanager.v1.UserListService/GetUserList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUserListRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accountTypes/*/accounts/*/userLists/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserList>newBuilder()
                      .setDefaultInstance(UserList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListUserListsRequest, ListUserListsResponse>
      listUserListsMethodDescriptor =
          ApiMethodDescriptor.<ListUserListsRequest, ListUserListsResponse>newBuilder()
              .setFullMethodName("google.ads.datamanager.v1.UserListService/ListUserLists")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUserListsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accountTypes/*/accounts/*}/userLists",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserListsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserListsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListUserListsResponse>newBuilder()
                      .setDefaultInstance(ListUserListsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateUserListRequest, UserList>
      createUserListMethodDescriptor =
          ApiMethodDescriptor.<CreateUserListRequest, UserList>newBuilder()
              .setFullMethodName("google.ads.datamanager.v1.UserListService/CreateUserList")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUserListRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accountTypes/*/accounts/*}/userLists",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("userList", request.getUserList(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserList>newBuilder()
                      .setDefaultInstance(UserList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateUserListRequest, UserList>
      updateUserListMethodDescriptor =
          ApiMethodDescriptor.<UpdateUserListRequest, UserList>newBuilder()
              .setFullMethodName("google.ads.datamanager.v1.UserListService/UpdateUserList")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateUserListRequest>newBuilder()
                      .setPath(
                          "/v1/{userList.name=accountTypes/*/accounts/*/userLists/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "userList.name", request.getUserList().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("userList", request.getUserList(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserList>newBuilder()
                      .setDefaultInstance(UserList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteUserListRequest, Empty>
      deleteUserListMethodDescriptor =
          ApiMethodDescriptor.<DeleteUserListRequest, Empty>newBuilder()
              .setFullMethodName("google.ads.datamanager.v1.UserListService/DeleteUserList")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteUserListRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accountTypes/*/accounts/*/userLists/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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

  private final UnaryCallable<GetUserListRequest, UserList> getUserListCallable;
  private final UnaryCallable<ListUserListsRequest, ListUserListsResponse> listUserListsCallable;
  private final UnaryCallable<ListUserListsRequest, ListUserListsPagedResponse>
      listUserListsPagedCallable;
  private final UnaryCallable<CreateUserListRequest, UserList> createUserListCallable;
  private final UnaryCallable<UpdateUserListRequest, UserList> updateUserListCallable;
  private final UnaryCallable<DeleteUserListRequest, Empty> deleteUserListCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonUserListServiceStub create(UserListServiceStubSettings settings)
      throws IOException {
    return new HttpJsonUserListServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonUserListServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonUserListServiceStub(
        UserListServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonUserListServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonUserListServiceStub(
        UserListServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonUserListServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonUserListServiceStub(
      UserListServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonUserListServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonUserListServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonUserListServiceStub(
      UserListServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetUserListRequest, UserList> getUserListTransportSettings =
        HttpJsonCallSettings.<GetUserListRequest, UserList>newBuilder()
            .setMethodDescriptor(getUserListMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListUserListsRequest, ListUserListsResponse>
        listUserListsTransportSettings =
            HttpJsonCallSettings.<ListUserListsRequest, ListUserListsResponse>newBuilder()
                .setMethodDescriptor(listUserListsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateUserListRequest, UserList> createUserListTransportSettings =
        HttpJsonCallSettings.<CreateUserListRequest, UserList>newBuilder()
            .setMethodDescriptor(createUserListMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateUserListRequest, UserList> updateUserListTransportSettings =
        HttpJsonCallSettings.<UpdateUserListRequest, UserList>newBuilder()
            .setMethodDescriptor(updateUserListMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("user_list.name", String.valueOf(request.getUserList().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteUserListRequest, Empty> deleteUserListTransportSettings =
        HttpJsonCallSettings.<DeleteUserListRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUserListMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getUserListCallable =
        callableFactory.createUnaryCallable(
            getUserListTransportSettings, settings.getUserListSettings(), clientContext);
    this.listUserListsCallable =
        callableFactory.createUnaryCallable(
            listUserListsTransportSettings, settings.listUserListsSettings(), clientContext);
    this.listUserListsPagedCallable =
        callableFactory.createPagedCallable(
            listUserListsTransportSettings, settings.listUserListsSettings(), clientContext);
    this.createUserListCallable =
        callableFactory.createUnaryCallable(
            createUserListTransportSettings, settings.createUserListSettings(), clientContext);
    this.updateUserListCallable =
        callableFactory.createUnaryCallable(
            updateUserListTransportSettings, settings.updateUserListSettings(), clientContext);
    this.deleteUserListCallable =
        callableFactory.createUnaryCallable(
            deleteUserListTransportSettings, settings.deleteUserListSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getUserListMethodDescriptor);
    methodDescriptors.add(listUserListsMethodDescriptor);
    methodDescriptors.add(createUserListMethodDescriptor);
    methodDescriptors.add(updateUserListMethodDescriptor);
    methodDescriptors.add(deleteUserListMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetUserListRequest, UserList> getUserListCallable() {
    return getUserListCallable;
  }

  @Override
  public UnaryCallable<ListUserListsRequest, ListUserListsResponse> listUserListsCallable() {
    return listUserListsCallable;
  }

  @Override
  public UnaryCallable<ListUserListsRequest, ListUserListsPagedResponse>
      listUserListsPagedCallable() {
    return listUserListsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateUserListRequest, UserList> createUserListCallable() {
    return createUserListCallable;
  }

  @Override
  public UnaryCallable<UpdateUserListRequest, UserList> updateUserListCallable() {
    return updateUserListCallable;
  }

  @Override
  public UnaryCallable<DeleteUserListRequest, Empty> deleteUserListCallable() {
    return deleteUserListCallable;
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
