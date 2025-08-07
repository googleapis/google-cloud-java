/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.accounts.v1.stub;

import static com.google.shopping.merchant.accounts.v1.AccountServicesServiceClient.ListAccountServicesPagedResponse;

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
import com.google.shopping.merchant.accounts.v1.AccountService;
import com.google.shopping.merchant.accounts.v1.ApproveAccountServiceRequest;
import com.google.shopping.merchant.accounts.v1.GetAccountServiceRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountServicesRequest;
import com.google.shopping.merchant.accounts.v1.ListAccountServicesResponse;
import com.google.shopping.merchant.accounts.v1.ProposeAccountServiceRequest;
import com.google.shopping.merchant.accounts.v1.RejectAccountServiceRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AccountServicesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAccountServicesServiceStub extends AccountServicesServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAccountServiceRequest, AccountService>
      getAccountServiceMethodDescriptor =
          ApiMethodDescriptor.<GetAccountServiceRequest, AccountService>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountServicesService/GetAccountService")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAccountServiceRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=accounts/*/services/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccountServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccountServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccountService>newBuilder()
                      .setDefaultInstance(AccountService.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAccountServicesRequest, ListAccountServicesResponse>
      listAccountServicesMethodDescriptor =
          ApiMethodDescriptor.<ListAccountServicesRequest, ListAccountServicesResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountServicesService/ListAccountServices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccountServicesRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{parent=accounts/*}/services",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccountServicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAccountServicesResponse>newBuilder()
                      .setDefaultInstance(ListAccountServicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ProposeAccountServiceRequest, AccountService>
      proposeAccountServiceMethodDescriptor =
          ApiMethodDescriptor.<ProposeAccountServiceRequest, AccountService>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountServicesService/ProposeAccountService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ProposeAccountServiceRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{parent=accounts/*}/services:propose",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ProposeAccountServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ProposeAccountServiceRequest> serializer =
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
                  ProtoMessageResponseParser.<AccountService>newBuilder()
                      .setDefaultInstance(AccountService.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ApproveAccountServiceRequest, AccountService>
      approveAccountServiceMethodDescriptor =
          ApiMethodDescriptor.<ApproveAccountServiceRequest, AccountService>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountServicesService/ApproveAccountService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ApproveAccountServiceRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=accounts/*/services/*}:approve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveAccountServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveAccountServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccountService>newBuilder()
                      .setDefaultInstance(AccountService.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RejectAccountServiceRequest, Empty>
      rejectAccountServiceMethodDescriptor =
          ApiMethodDescriptor.<RejectAccountServiceRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.AccountServicesService/RejectAccountService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RejectAccountServiceRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=accounts/*/services/*}:reject",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RejectAccountServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RejectAccountServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAccountServiceRequest, AccountService> getAccountServiceCallable;
  private final UnaryCallable<ListAccountServicesRequest, ListAccountServicesResponse>
      listAccountServicesCallable;
  private final UnaryCallable<ListAccountServicesRequest, ListAccountServicesPagedResponse>
      listAccountServicesPagedCallable;
  private final UnaryCallable<ProposeAccountServiceRequest, AccountService>
      proposeAccountServiceCallable;
  private final UnaryCallable<ApproveAccountServiceRequest, AccountService>
      approveAccountServiceCallable;
  private final UnaryCallable<RejectAccountServiceRequest, Empty> rejectAccountServiceCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAccountServicesServiceStub create(
      AccountServicesServiceStubSettings settings) throws IOException {
    return new HttpJsonAccountServicesServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAccountServicesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAccountServicesServiceStub(
        AccountServicesServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAccountServicesServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAccountServicesServiceStub(
        AccountServicesServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAccountServicesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccountServicesServiceStub(
      AccountServicesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAccountServicesServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAccountServicesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccountServicesServiceStub(
      AccountServicesServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAccountServiceRequest, AccountService>
        getAccountServiceTransportSettings =
            HttpJsonCallSettings.<GetAccountServiceRequest, AccountService>newBuilder()
                .setMethodDescriptor(getAccountServiceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListAccountServicesRequest, ListAccountServicesResponse>
        listAccountServicesTransportSettings =
            HttpJsonCallSettings
                .<ListAccountServicesRequest, ListAccountServicesResponse>newBuilder()
                .setMethodDescriptor(listAccountServicesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ProposeAccountServiceRequest, AccountService>
        proposeAccountServiceTransportSettings =
            HttpJsonCallSettings.<ProposeAccountServiceRequest, AccountService>newBuilder()
                .setMethodDescriptor(proposeAccountServiceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ApproveAccountServiceRequest, AccountService>
        approveAccountServiceTransportSettings =
            HttpJsonCallSettings.<ApproveAccountServiceRequest, AccountService>newBuilder()
                .setMethodDescriptor(approveAccountServiceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RejectAccountServiceRequest, Empty> rejectAccountServiceTransportSettings =
        HttpJsonCallSettings.<RejectAccountServiceRequest, Empty>newBuilder()
            .setMethodDescriptor(rejectAccountServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getAccountServiceCallable =
        callableFactory.createUnaryCallable(
            getAccountServiceTransportSettings,
            settings.getAccountServiceSettings(),
            clientContext);
    this.listAccountServicesCallable =
        callableFactory.createUnaryCallable(
            listAccountServicesTransportSettings,
            settings.listAccountServicesSettings(),
            clientContext);
    this.listAccountServicesPagedCallable =
        callableFactory.createPagedCallable(
            listAccountServicesTransportSettings,
            settings.listAccountServicesSettings(),
            clientContext);
    this.proposeAccountServiceCallable =
        callableFactory.createUnaryCallable(
            proposeAccountServiceTransportSettings,
            settings.proposeAccountServiceSettings(),
            clientContext);
    this.approveAccountServiceCallable =
        callableFactory.createUnaryCallable(
            approveAccountServiceTransportSettings,
            settings.approveAccountServiceSettings(),
            clientContext);
    this.rejectAccountServiceCallable =
        callableFactory.createUnaryCallable(
            rejectAccountServiceTransportSettings,
            settings.rejectAccountServiceSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAccountServiceMethodDescriptor);
    methodDescriptors.add(listAccountServicesMethodDescriptor);
    methodDescriptors.add(proposeAccountServiceMethodDescriptor);
    methodDescriptors.add(approveAccountServiceMethodDescriptor);
    methodDescriptors.add(rejectAccountServiceMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAccountServiceRequest, AccountService> getAccountServiceCallable() {
    return getAccountServiceCallable;
  }

  @Override
  public UnaryCallable<ListAccountServicesRequest, ListAccountServicesResponse>
      listAccountServicesCallable() {
    return listAccountServicesCallable;
  }

  @Override
  public UnaryCallable<ListAccountServicesRequest, ListAccountServicesPagedResponse>
      listAccountServicesPagedCallable() {
    return listAccountServicesPagedCallable;
  }

  @Override
  public UnaryCallable<ProposeAccountServiceRequest, AccountService>
      proposeAccountServiceCallable() {
    return proposeAccountServiceCallable;
  }

  @Override
  public UnaryCallable<ApproveAccountServiceRequest, AccountService>
      approveAccountServiceCallable() {
    return approveAccountServiceCallable;
  }

  @Override
  public UnaryCallable<RejectAccountServiceRequest, Empty> rejectAccountServiceCallable() {
    return rejectAccountServiceCallable;
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
