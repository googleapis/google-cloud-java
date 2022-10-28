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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.AuthorizedCertificatesClient.ListAuthorizedCertificatesPagedResponse;

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
import com.google.appengine.v1.AuthorizedCertificate;
import com.google.appengine.v1.CreateAuthorizedCertificateRequest;
import com.google.appengine.v1.DeleteAuthorizedCertificateRequest;
import com.google.appengine.v1.GetAuthorizedCertificateRequest;
import com.google.appengine.v1.ListAuthorizedCertificatesRequest;
import com.google.appengine.v1.ListAuthorizedCertificatesResponse;
import com.google.appengine.v1.UpdateAuthorizedCertificateRequest;
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
 * REST stub implementation for the AuthorizedCertificates service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAuthorizedCertificatesStub extends AuthorizedCertificatesStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>
      listAuthorizedCertificatesMethodDescriptor =
          ApiMethodDescriptor
              .<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>newBuilder()
              .setFullMethodName(
                  "google.appengine.v1.AuthorizedCertificates/ListAuthorizedCertificates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAuthorizedCertificatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=apps/*}/authorizedCertificates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAuthorizedCertificatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAuthorizedCertificatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAuthorizedCertificatesResponse>newBuilder()
                      .setDefaultInstance(ListAuthorizedCertificatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAuthorizedCertificateRequest, AuthorizedCertificate>
      getAuthorizedCertificateMethodDescriptor =
          ApiMethodDescriptor.<GetAuthorizedCertificateRequest, AuthorizedCertificate>newBuilder()
              .setFullMethodName(
                  "google.appengine.v1.AuthorizedCertificates/GetAuthorizedCertificate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAuthorizedCertificateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*/authorizedCertificates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAuthorizedCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAuthorizedCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuthorizedCertificate>newBuilder()
                      .setDefaultInstance(AuthorizedCertificate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateAuthorizedCertificateRequest, AuthorizedCertificate>
      createAuthorizedCertificateMethodDescriptor =
          ApiMethodDescriptor
              .<CreateAuthorizedCertificateRequest, AuthorizedCertificate>newBuilder()
              .setFullMethodName(
                  "google.appengine.v1.AuthorizedCertificates/CreateAuthorizedCertificate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAuthorizedCertificateRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=apps/*}/authorizedCertificates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAuthorizedCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAuthorizedCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("certificate", request.getCertificate(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuthorizedCertificate>newBuilder()
                      .setDefaultInstance(AuthorizedCertificate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
      updateAuthorizedCertificateMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>newBuilder()
              .setFullMethodName(
                  "google.appengine.v1.AuthorizedCertificates/UpdateAuthorizedCertificate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAuthorizedCertificateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*/authorizedCertificates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAuthorizedCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAuthorizedCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("certificate", request.getCertificate(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AuthorizedCertificate>newBuilder()
                      .setDefaultInstance(AuthorizedCertificate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAuthorizedCertificateRequest, Empty>
      deleteAuthorizedCertificateMethodDescriptor =
          ApiMethodDescriptor.<DeleteAuthorizedCertificateRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.appengine.v1.AuthorizedCertificates/DeleteAuthorizedCertificate")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAuthorizedCertificateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*/authorizedCertificates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAuthorizedCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAuthorizedCertificateRequest> serializer =
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

  private final UnaryCallable<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>
      listAuthorizedCertificatesCallable;
  private final UnaryCallable<
          ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesPagedResponse>
      listAuthorizedCertificatesPagedCallable;
  private final UnaryCallable<GetAuthorizedCertificateRequest, AuthorizedCertificate>
      getAuthorizedCertificateCallable;
  private final UnaryCallable<CreateAuthorizedCertificateRequest, AuthorizedCertificate>
      createAuthorizedCertificateCallable;
  private final UnaryCallable<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
      updateAuthorizedCertificateCallable;
  private final UnaryCallable<DeleteAuthorizedCertificateRequest, Empty>
      deleteAuthorizedCertificateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAuthorizedCertificatesStub create(
      AuthorizedCertificatesStubSettings settings) throws IOException {
    return new HttpJsonAuthorizedCertificatesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAuthorizedCertificatesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAuthorizedCertificatesStub(
        AuthorizedCertificatesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAuthorizedCertificatesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAuthorizedCertificatesStub(
        AuthorizedCertificatesStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAuthorizedCertificatesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAuthorizedCertificatesStub(
      AuthorizedCertificatesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAuthorizedCertificatesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAuthorizedCertificatesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAuthorizedCertificatesStub(
      AuthorizedCertificatesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>
        listAuthorizedCertificatesTransportSettings =
            HttpJsonCallSettings
                .<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>newBuilder()
                .setMethodDescriptor(listAuthorizedCertificatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAuthorizedCertificateRequest, AuthorizedCertificate>
        getAuthorizedCertificateTransportSettings =
            HttpJsonCallSettings
                .<GetAuthorizedCertificateRequest, AuthorizedCertificate>newBuilder()
                .setMethodDescriptor(getAuthorizedCertificateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateAuthorizedCertificateRequest, AuthorizedCertificate>
        createAuthorizedCertificateTransportSettings =
            HttpJsonCallSettings
                .<CreateAuthorizedCertificateRequest, AuthorizedCertificate>newBuilder()
                .setMethodDescriptor(createAuthorizedCertificateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
        updateAuthorizedCertificateTransportSettings =
            HttpJsonCallSettings
                .<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>newBuilder()
                .setMethodDescriptor(updateAuthorizedCertificateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAuthorizedCertificateRequest, Empty>
        deleteAuthorizedCertificateTransportSettings =
            HttpJsonCallSettings.<DeleteAuthorizedCertificateRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAuthorizedCertificateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listAuthorizedCertificatesCallable =
        callableFactory.createUnaryCallable(
            listAuthorizedCertificatesTransportSettings,
            settings.listAuthorizedCertificatesSettings(),
            clientContext);
    this.listAuthorizedCertificatesPagedCallable =
        callableFactory.createPagedCallable(
            listAuthorizedCertificatesTransportSettings,
            settings.listAuthorizedCertificatesSettings(),
            clientContext);
    this.getAuthorizedCertificateCallable =
        callableFactory.createUnaryCallable(
            getAuthorizedCertificateTransportSettings,
            settings.getAuthorizedCertificateSettings(),
            clientContext);
    this.createAuthorizedCertificateCallable =
        callableFactory.createUnaryCallable(
            createAuthorizedCertificateTransportSettings,
            settings.createAuthorizedCertificateSettings(),
            clientContext);
    this.updateAuthorizedCertificateCallable =
        callableFactory.createUnaryCallable(
            updateAuthorizedCertificateTransportSettings,
            settings.updateAuthorizedCertificateSettings(),
            clientContext);
    this.deleteAuthorizedCertificateCallable =
        callableFactory.createUnaryCallable(
            deleteAuthorizedCertificateTransportSettings,
            settings.deleteAuthorizedCertificateSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listAuthorizedCertificatesMethodDescriptor);
    methodDescriptors.add(getAuthorizedCertificateMethodDescriptor);
    methodDescriptors.add(createAuthorizedCertificateMethodDescriptor);
    methodDescriptors.add(updateAuthorizedCertificateMethodDescriptor);
    methodDescriptors.add(deleteAuthorizedCertificateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>
      listAuthorizedCertificatesCallable() {
    return listAuthorizedCertificatesCallable;
  }

  @Override
  public UnaryCallable<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesPagedResponse>
      listAuthorizedCertificatesPagedCallable() {
    return listAuthorizedCertificatesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuthorizedCertificateRequest, AuthorizedCertificate>
      getAuthorizedCertificateCallable() {
    return getAuthorizedCertificateCallable;
  }

  @Override
  public UnaryCallable<CreateAuthorizedCertificateRequest, AuthorizedCertificate>
      createAuthorizedCertificateCallable() {
    return createAuthorizedCertificateCallable;
  }

  @Override
  public UnaryCallable<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
      updateAuthorizedCertificateCallable() {
    return updateAuthorizedCertificateCallable;
  }

  @Override
  public UnaryCallable<DeleteAuthorizedCertificateRequest, Empty>
      deleteAuthorizedCertificateCallable() {
    return deleteAuthorizedCertificateCallable;
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
