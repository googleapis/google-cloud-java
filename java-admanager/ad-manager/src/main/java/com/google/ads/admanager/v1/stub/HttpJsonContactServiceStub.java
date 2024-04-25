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

import static com.google.ads.admanager.v1.ContactServiceClient.ListContactsPagedResponse;

import com.google.ads.admanager.v1.Contact;
import com.google.ads.admanager.v1.GetContactRequest;
import com.google.ads.admanager.v1.ListContactsRequest;
import com.google.ads.admanager.v1.ListContactsResponse;
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
 * REST stub implementation for the ContactService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonContactServiceStub extends ContactServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetContactRequest, Contact> getContactMethodDescriptor =
      ApiMethodDescriptor.<GetContactRequest, Contact>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.ContactService/GetContact")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetContactRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/contacts/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetContactRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetContactRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Contact>newBuilder()
                  .setDefaultInstance(Contact.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListContactsRequest, ListContactsResponse>
      listContactsMethodDescriptor =
          ApiMethodDescriptor.<ListContactsRequest, ListContactsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ContactService/ListContacts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListContactsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/contacts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListContactsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListContactsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListContactsResponse>newBuilder()
                      .setDefaultInstance(ListContactsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetContactRequest, Contact> getContactCallable;
  private final UnaryCallable<ListContactsRequest, ListContactsResponse> listContactsCallable;
  private final UnaryCallable<ListContactsRequest, ListContactsPagedResponse>
      listContactsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonContactServiceStub create(ContactServiceStubSettings settings)
      throws IOException {
    return new HttpJsonContactServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonContactServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonContactServiceStub(
        ContactServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonContactServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonContactServiceStub(
        ContactServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonContactServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonContactServiceStub(
      ContactServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonContactServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonContactServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonContactServiceStub(
      ContactServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetContactRequest, Contact> getContactTransportSettings =
        HttpJsonCallSettings.<GetContactRequest, Contact>newBuilder()
            .setMethodDescriptor(getContactMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListContactsRequest, ListContactsResponse> listContactsTransportSettings =
        HttpJsonCallSettings.<ListContactsRequest, ListContactsResponse>newBuilder()
            .setMethodDescriptor(listContactsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getContactCallable =
        callableFactory.createUnaryCallable(
            getContactTransportSettings, settings.getContactSettings(), clientContext);
    this.listContactsCallable =
        callableFactory.createUnaryCallable(
            listContactsTransportSettings, settings.listContactsSettings(), clientContext);
    this.listContactsPagedCallable =
        callableFactory.createPagedCallable(
            listContactsTransportSettings, settings.listContactsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getContactMethodDescriptor);
    methodDescriptors.add(listContactsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetContactRequest, Contact> getContactCallable() {
    return getContactCallable;
  }

  @Override
  public UnaryCallable<ListContactsRequest, ListContactsResponse> listContactsCallable() {
    return listContactsCallable;
  }

  @Override
  public UnaryCallable<ListContactsRequest, ListContactsPagedResponse> listContactsPagedCallable() {
    return listContactsPagedCallable;
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
