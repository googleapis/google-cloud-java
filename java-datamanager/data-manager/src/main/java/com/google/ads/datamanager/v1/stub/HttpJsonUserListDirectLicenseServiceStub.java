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

import static com.google.ads.datamanager.v1.UserListDirectLicenseServiceClient.ListUserListDirectLicensesPagedResponse;

import com.google.ads.datamanager.v1.CreateUserListDirectLicenseRequest;
import com.google.ads.datamanager.v1.GetUserListDirectLicenseRequest;
import com.google.ads.datamanager.v1.ListUserListDirectLicensesRequest;
import com.google.ads.datamanager.v1.ListUserListDirectLicensesResponse;
import com.google.ads.datamanager.v1.UpdateUserListDirectLicenseRequest;
import com.google.ads.datamanager.v1.UserListDirectLicense;
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
 * REST stub implementation for the UserListDirectLicenseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonUserListDirectLicenseServiceStub extends UserListDirectLicenseServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          CreateUserListDirectLicenseRequest, UserListDirectLicense>
      createUserListDirectLicenseMethodDescriptor =
          ApiMethodDescriptor
              .<CreateUserListDirectLicenseRequest, UserListDirectLicense>newBuilder()
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListDirectLicenseService/CreateUserListDirectLicense")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUserListDirectLicenseRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accountTypes/*/accounts/*}/userListDirectLicenses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserListDirectLicenseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserListDirectLicenseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "userListDirectLicense",
                                      request.getUserListDirectLicense(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserListDirectLicense>newBuilder()
                      .setDefaultInstance(UserListDirectLicense.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetUserListDirectLicenseRequest, UserListDirectLicense>
      getUserListDirectLicenseMethodDescriptor =
          ApiMethodDescriptor.<GetUserListDirectLicenseRequest, UserListDirectLicense>newBuilder()
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListDirectLicenseService/GetUserListDirectLicense")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUserListDirectLicenseRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accountTypes/*/accounts/*/userListDirectLicenses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserListDirectLicenseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserListDirectLicenseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserListDirectLicense>newBuilder()
                      .setDefaultInstance(UserListDirectLicense.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateUserListDirectLicenseRequest, UserListDirectLicense>
      updateUserListDirectLicenseMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateUserListDirectLicenseRequest, UserListDirectLicense>newBuilder()
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListDirectLicenseService/UpdateUserListDirectLicense")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateUserListDirectLicenseRequest>newBuilder()
                      .setPath(
                          "/v1/{userListDirectLicense.name=accountTypes/*/accounts/*/userListDirectLicenses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserListDirectLicenseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "userListDirectLicense.name",
                                request.getUserListDirectLicense().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserListDirectLicenseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "userListDirectLicense",
                                      request.getUserListDirectLicense(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserListDirectLicense>newBuilder()
                      .setDefaultInstance(UserListDirectLicense.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>
      listUserListDirectLicensesMethodDescriptor =
          ApiMethodDescriptor
              .<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.datamanager.v1.UserListDirectLicenseService/ListUserListDirectLicenses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUserListDirectLicensesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accountTypes/*/accounts/*}/userListDirectLicenses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserListDirectLicensesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserListDirectLicensesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListUserListDirectLicensesResponse>newBuilder()
                      .setDefaultInstance(ListUserListDirectLicensesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateUserListDirectLicenseRequest, UserListDirectLicense>
      createUserListDirectLicenseCallable;
  private final UnaryCallable<GetUserListDirectLicenseRequest, UserListDirectLicense>
      getUserListDirectLicenseCallable;
  private final UnaryCallable<UpdateUserListDirectLicenseRequest, UserListDirectLicense>
      updateUserListDirectLicenseCallable;
  private final UnaryCallable<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>
      listUserListDirectLicensesCallable;
  private final UnaryCallable<
          ListUserListDirectLicensesRequest, ListUserListDirectLicensesPagedResponse>
      listUserListDirectLicensesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonUserListDirectLicenseServiceStub create(
      UserListDirectLicenseServiceStubSettings settings) throws IOException {
    return new HttpJsonUserListDirectLicenseServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonUserListDirectLicenseServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonUserListDirectLicenseServiceStub(
        UserListDirectLicenseServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonUserListDirectLicenseServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonUserListDirectLicenseServiceStub(
        UserListDirectLicenseServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonUserListDirectLicenseServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonUserListDirectLicenseServiceStub(
      UserListDirectLicenseServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonUserListDirectLicenseServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonUserListDirectLicenseServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonUserListDirectLicenseServiceStub(
      UserListDirectLicenseServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateUserListDirectLicenseRequest, UserListDirectLicense>
        createUserListDirectLicenseTransportSettings =
            HttpJsonCallSettings
                .<CreateUserListDirectLicenseRequest, UserListDirectLicense>newBuilder()
                .setMethodDescriptor(createUserListDirectLicenseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetUserListDirectLicenseRequest, UserListDirectLicense>
        getUserListDirectLicenseTransportSettings =
            HttpJsonCallSettings
                .<GetUserListDirectLicenseRequest, UserListDirectLicense>newBuilder()
                .setMethodDescriptor(getUserListDirectLicenseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateUserListDirectLicenseRequest, UserListDirectLicense>
        updateUserListDirectLicenseTransportSettings =
            HttpJsonCallSettings
                .<UpdateUserListDirectLicenseRequest, UserListDirectLicense>newBuilder()
                .setMethodDescriptor(updateUserListDirectLicenseMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "user_list_direct_license.name",
                          String.valueOf(request.getUserListDirectLicense().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>
        listUserListDirectLicensesTransportSettings =
            HttpJsonCallSettings
                .<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>newBuilder()
                .setMethodDescriptor(listUserListDirectLicensesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createUserListDirectLicenseCallable =
        callableFactory.createUnaryCallable(
            createUserListDirectLicenseTransportSettings,
            settings.createUserListDirectLicenseSettings(),
            clientContext);
    this.getUserListDirectLicenseCallable =
        callableFactory.createUnaryCallable(
            getUserListDirectLicenseTransportSettings,
            settings.getUserListDirectLicenseSettings(),
            clientContext);
    this.updateUserListDirectLicenseCallable =
        callableFactory.createUnaryCallable(
            updateUserListDirectLicenseTransportSettings,
            settings.updateUserListDirectLicenseSettings(),
            clientContext);
    this.listUserListDirectLicensesCallable =
        callableFactory.createUnaryCallable(
            listUserListDirectLicensesTransportSettings,
            settings.listUserListDirectLicensesSettings(),
            clientContext);
    this.listUserListDirectLicensesPagedCallable =
        callableFactory.createPagedCallable(
            listUserListDirectLicensesTransportSettings,
            settings.listUserListDirectLicensesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createUserListDirectLicenseMethodDescriptor);
    methodDescriptors.add(getUserListDirectLicenseMethodDescriptor);
    methodDescriptors.add(updateUserListDirectLicenseMethodDescriptor);
    methodDescriptors.add(listUserListDirectLicensesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateUserListDirectLicenseRequest, UserListDirectLicense>
      createUserListDirectLicenseCallable() {
    return createUserListDirectLicenseCallable;
  }

  @Override
  public UnaryCallable<GetUserListDirectLicenseRequest, UserListDirectLicense>
      getUserListDirectLicenseCallable() {
    return getUserListDirectLicenseCallable;
  }

  @Override
  public UnaryCallable<UpdateUserListDirectLicenseRequest, UserListDirectLicense>
      updateUserListDirectLicenseCallable() {
    return updateUserListDirectLicenseCallable;
  }

  @Override
  public UnaryCallable<ListUserListDirectLicensesRequest, ListUserListDirectLicensesResponse>
      listUserListDirectLicensesCallable() {
    return listUserListDirectLicensesCallable;
  }

  @Override
  public UnaryCallable<ListUserListDirectLicensesRequest, ListUserListDirectLicensesPagedResponse>
      listUserListDirectLicensesPagedCallable() {
    return listUserListDirectLicensesPagedCallable;
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
