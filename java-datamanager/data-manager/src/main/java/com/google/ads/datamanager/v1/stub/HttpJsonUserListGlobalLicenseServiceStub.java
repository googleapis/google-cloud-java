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

import static com.google.ads.datamanager.v1.UserListGlobalLicenseServiceClient.ListUserListGlobalLicenseCustomerInfosPagedResponse;
import static com.google.ads.datamanager.v1.UserListGlobalLicenseServiceClient.ListUserListGlobalLicensesPagedResponse;

import com.google.ads.datamanager.v1.CreateUserListGlobalLicenseRequest;
import com.google.ads.datamanager.v1.GetUserListGlobalLicenseRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicenseCustomerInfosResponse;
import com.google.ads.datamanager.v1.ListUserListGlobalLicensesRequest;
import com.google.ads.datamanager.v1.ListUserListGlobalLicensesResponse;
import com.google.ads.datamanager.v1.UpdateUserListGlobalLicenseRequest;
import com.google.ads.datamanager.v1.UserListGlobalLicense;
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
 * REST stub implementation for the UserListGlobalLicenseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonUserListGlobalLicenseServiceStub extends UserListGlobalLicenseServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
      createUserListGlobalLicenseMethodDescriptor =
          ApiMethodDescriptor
              .<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>newBuilder()
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListGlobalLicenseService/CreateUserListGlobalLicense")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUserListGlobalLicenseRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accountTypes/*/accounts/*}/userListGlobalLicenses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserListGlobalLicenseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserListGlobalLicenseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "userListGlobalLicense",
                                      request.getUserListGlobalLicense(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserListGlobalLicense>newBuilder()
                      .setDefaultInstance(UserListGlobalLicense.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
      updateUserListGlobalLicenseMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>newBuilder()
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListGlobalLicenseService/UpdateUserListGlobalLicense")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateUserListGlobalLicenseRequest>newBuilder()
                      .setPath(
                          "/v1/{userListGlobalLicense.name=accountTypes/*/accounts/*/userListGlobalLicenses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserListGlobalLicenseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "userListGlobalLicense.name",
                                request.getUserListGlobalLicense().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserListGlobalLicenseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "userListGlobalLicense",
                                      request.getUserListGlobalLicense(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserListGlobalLicense>newBuilder()
                      .setDefaultInstance(UserListGlobalLicense.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
      getUserListGlobalLicenseMethodDescriptor =
          ApiMethodDescriptor.<GetUserListGlobalLicenseRequest, UserListGlobalLicense>newBuilder()
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListGlobalLicenseService/GetUserListGlobalLicense")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUserListGlobalLicenseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accountTypes/*/accounts/*/userListGlobalLicenses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserListGlobalLicenseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserListGlobalLicenseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserListGlobalLicense>newBuilder()
                      .setDefaultInstance(UserListGlobalLicense.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>
      listUserListGlobalLicensesMethodDescriptor =
          ApiMethodDescriptor
              .<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListGlobalLicenseService/ListUserListGlobalLicenses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUserListGlobalLicensesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accountTypes/*/accounts/*}/userListGlobalLicenses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserListGlobalLicensesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserListGlobalLicensesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListUserListGlobalLicensesResponse>newBuilder()
                      .setDefaultInstance(ListUserListGlobalLicensesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse>
      listUserListGlobalLicenseCustomerInfosMethodDescriptor =
          ApiMethodDescriptor
              .<ListUserListGlobalLicenseCustomerInfosRequest,
                  ListUserListGlobalLicenseCustomerInfosResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListGlobalLicenseService/ListUserListGlobalLicenseCustomerInfos")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListUserListGlobalLicenseCustomerInfosRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accountTypes/*/accounts/*/userListGlobalLicenses/*}/userListGlobalLicenseCustomerInfos",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserListGlobalLicenseCustomerInfosRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserListGlobalLicenseCustomerInfosRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListUserListGlobalLicenseCustomerInfosResponse>newBuilder()
                      .setDefaultInstance(
                          ListUserListGlobalLicenseCustomerInfosResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
      createUserListGlobalLicenseCallable;
  private final UnaryCallable<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
      updateUserListGlobalLicenseCallable;
  private final UnaryCallable<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
      getUserListGlobalLicenseCallable;
  private final UnaryCallable<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>
      listUserListGlobalLicensesCallable;
  private final UnaryCallable<
          ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesPagedResponse>
      listUserListGlobalLicensesPagedCallable;
  private final UnaryCallable<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse>
      listUserListGlobalLicenseCustomerInfosCallable;
  private final UnaryCallable<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosPagedResponse>
      listUserListGlobalLicenseCustomerInfosPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonUserListGlobalLicenseServiceStub create(
      UserListGlobalLicenseServiceStubSettings settings) throws IOException {
    return new HttpJsonUserListGlobalLicenseServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonUserListGlobalLicenseServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonUserListGlobalLicenseServiceStub(
        UserListGlobalLicenseServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonUserListGlobalLicenseServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonUserListGlobalLicenseServiceStub(
        UserListGlobalLicenseServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonUserListGlobalLicenseServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonUserListGlobalLicenseServiceStub(
      UserListGlobalLicenseServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonUserListGlobalLicenseServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonUserListGlobalLicenseServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonUserListGlobalLicenseServiceStub(
      UserListGlobalLicenseServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
        createUserListGlobalLicenseTransportSettings =
            HttpJsonCallSettings
                .<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>newBuilder()
                .setMethodDescriptor(createUserListGlobalLicenseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
        updateUserListGlobalLicenseTransportSettings =
            HttpJsonCallSettings
                .<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>newBuilder()
                .setMethodDescriptor(updateUserListGlobalLicenseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "user_list_global_license.name",
                          String.valueOf(request.getUserListGlobalLicense().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
        getUserListGlobalLicenseTransportSettings =
            HttpJsonCallSettings
                .<GetUserListGlobalLicenseRequest, UserListGlobalLicense>newBuilder()
                .setMethodDescriptor(getUserListGlobalLicenseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>
        listUserListGlobalLicensesTransportSettings =
            HttpJsonCallSettings
                .<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>newBuilder()
                .setMethodDescriptor(listUserListGlobalLicensesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListUserListGlobalLicenseCustomerInfosRequest,
            ListUserListGlobalLicenseCustomerInfosResponse>
        listUserListGlobalLicenseCustomerInfosTransportSettings =
            HttpJsonCallSettings
                .<ListUserListGlobalLicenseCustomerInfosRequest,
                    ListUserListGlobalLicenseCustomerInfosResponse>
                    newBuilder()
                .setMethodDescriptor(listUserListGlobalLicenseCustomerInfosMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createUserListGlobalLicenseCallable =
        callableFactory.createUnaryCallable(
            createUserListGlobalLicenseTransportSettings,
            settings.createUserListGlobalLicenseSettings(),
            clientContext);
    this.updateUserListGlobalLicenseCallable =
        callableFactory.createUnaryCallable(
            updateUserListGlobalLicenseTransportSettings,
            settings.updateUserListGlobalLicenseSettings(),
            clientContext);
    this.getUserListGlobalLicenseCallable =
        callableFactory.createUnaryCallable(
            getUserListGlobalLicenseTransportSettings,
            settings.getUserListGlobalLicenseSettings(),
            clientContext);
    this.listUserListGlobalLicensesCallable =
        callableFactory.createUnaryCallable(
            listUserListGlobalLicensesTransportSettings,
            settings.listUserListGlobalLicensesSettings(),
            clientContext);
    this.listUserListGlobalLicensesPagedCallable =
        callableFactory.createPagedCallable(
            listUserListGlobalLicensesTransportSettings,
            settings.listUserListGlobalLicensesSettings(),
            clientContext);
    this.listUserListGlobalLicenseCustomerInfosCallable =
        callableFactory.createUnaryCallable(
            listUserListGlobalLicenseCustomerInfosTransportSettings,
            settings.listUserListGlobalLicenseCustomerInfosSettings(),
            clientContext);
    this.listUserListGlobalLicenseCustomerInfosPagedCallable =
        callableFactory.createPagedCallable(
            listUserListGlobalLicenseCustomerInfosTransportSettings,
            settings.listUserListGlobalLicenseCustomerInfosSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createUserListGlobalLicenseMethodDescriptor);
    methodDescriptors.add(updateUserListGlobalLicenseMethodDescriptor);
    methodDescriptors.add(getUserListGlobalLicenseMethodDescriptor);
    methodDescriptors.add(listUserListGlobalLicensesMethodDescriptor);
    methodDescriptors.add(listUserListGlobalLicenseCustomerInfosMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateUserListGlobalLicenseRequest, UserListGlobalLicense>
      createUserListGlobalLicenseCallable() {
    return createUserListGlobalLicenseCallable;
  }

  @Override
  public UnaryCallable<UpdateUserListGlobalLicenseRequest, UserListGlobalLicense>
      updateUserListGlobalLicenseCallable() {
    return updateUserListGlobalLicenseCallable;
  }

  @Override
  public UnaryCallable<GetUserListGlobalLicenseRequest, UserListGlobalLicense>
      getUserListGlobalLicenseCallable() {
    return getUserListGlobalLicenseCallable;
  }

  @Override
  public UnaryCallable<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesResponse>
      listUserListGlobalLicensesCallable() {
    return listUserListGlobalLicensesCallable;
  }

  @Override
  public UnaryCallable<ListUserListGlobalLicensesRequest, ListUserListGlobalLicensesPagedResponse>
      listUserListGlobalLicensesPagedCallable() {
    return listUserListGlobalLicensesPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosResponse>
      listUserListGlobalLicenseCustomerInfosCallable() {
    return listUserListGlobalLicenseCustomerInfosCallable;
  }

  @Override
  public UnaryCallable<
          ListUserListGlobalLicenseCustomerInfosRequest,
          ListUserListGlobalLicenseCustomerInfosPagedResponse>
      listUserListGlobalLicenseCustomerInfosPagedCallable() {
    return listUserListGlobalLicenseCustomerInfosPagedCallable;
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
