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

package com.google.cloud.essentialcontacts.v1.stub;

import static com.google.cloud.essentialcontacts.v1.EssentialContactsServiceClient.ComputeContactsPagedResponse;
import static com.google.cloud.essentialcontacts.v1.EssentialContactsServiceClient.ListContactsPagedResponse;

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
import com.google.cloud.essentialcontacts.v1.ComputeContactsRequest;
import com.google.cloud.essentialcontacts.v1.ComputeContactsResponse;
import com.google.cloud.essentialcontacts.v1.Contact;
import com.google.cloud.essentialcontacts.v1.CreateContactRequest;
import com.google.cloud.essentialcontacts.v1.DeleteContactRequest;
import com.google.cloud.essentialcontacts.v1.GetContactRequest;
import com.google.cloud.essentialcontacts.v1.ListContactsRequest;
import com.google.cloud.essentialcontacts.v1.ListContactsResponse;
import com.google.cloud.essentialcontacts.v1.SendTestMessageRequest;
import com.google.cloud.essentialcontacts.v1.UpdateContactRequest;
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
 * REST stub implementation for the EssentialContactsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonEssentialContactsServiceStub extends EssentialContactsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateContactRequest, Contact>
      createContactMethodDescriptor =
          ApiMethodDescriptor.<CreateContactRequest, Contact>newBuilder()
              .setFullMethodName(
                  "google.cloud.essentialcontacts.v1.EssentialContactsService/CreateContact")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateContactRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/contacts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateContactRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*}/contacts",
                          "/v1/{parent=organizations/*}/contacts")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateContactRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("contact", request.getContact(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Contact>newBuilder()
                      .setDefaultInstance(Contact.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateContactRequest, Contact>
      updateContactMethodDescriptor =
          ApiMethodDescriptor.<UpdateContactRequest, Contact>newBuilder()
              .setFullMethodName(
                  "google.cloud.essentialcontacts.v1.EssentialContactsService/UpdateContact")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateContactRequest>newBuilder()
                      .setPath(
                          "/v1/{contact.name=projects/*/contacts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateContactRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "contact.name", request.getContact().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{contact.name=folders/*/contacts/*}",
                          "/v1/{contact.name=organizations/*/contacts/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateContactRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("contact", request.getContact(), false))
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
              .setFullMethodName(
                  "google.cloud.essentialcontacts.v1.EssentialContactsService/ListContacts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListContactsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/contacts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListContactsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*}/contacts",
                          "/v1/{parent=organizations/*}/contacts")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListContactsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
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

  private static final ApiMethodDescriptor<GetContactRequest, Contact> getContactMethodDescriptor =
      ApiMethodDescriptor.<GetContactRequest, Contact>newBuilder()
          .setFullMethodName(
              "google.cloud.essentialcontacts.v1.EssentialContactsService/GetContact")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetContactRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/contacts/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetContactRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1/{name=folders/*/contacts/*}", "/v1/{name=organizations/*/contacts/*}")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetContactRequest> serializer =
                            ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<DeleteContactRequest, Empty>
      deleteContactMethodDescriptor =
          ApiMethodDescriptor.<DeleteContactRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.essentialcontacts.v1.EssentialContactsService/DeleteContact")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteContactRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/contacts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteContactRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/contacts/*}",
                          "/v1/{name=organizations/*/contacts/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteContactRequest> serializer =
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

  private static final ApiMethodDescriptor<ComputeContactsRequest, ComputeContactsResponse>
      computeContactsMethodDescriptor =
          ApiMethodDescriptor.<ComputeContactsRequest, ComputeContactsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.essentialcontacts.v1.EssentialContactsService/ComputeContacts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ComputeContactsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/contacts:compute",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeContactsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*}/contacts:compute",
                          "/v1/{parent=organizations/*}/contacts:compute")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeContactsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "notificationCategories",
                                request.getNotificationCategoriesList());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ComputeContactsResponse>newBuilder()
                      .setDefaultInstance(ComputeContactsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SendTestMessageRequest, Empty>
      sendTestMessageMethodDescriptor =
          ApiMethodDescriptor.<SendTestMessageRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.essentialcontacts.v1.EssentialContactsService/SendTestMessage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SendTestMessageRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*}/contacts:sendTestMessage",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SendTestMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=folders/*}/contacts:sendTestMessage",
                          "/v1/{resource=organizations/*}/contacts:sendTestMessage")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SendTestMessageRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateContactRequest, Contact> createContactCallable;
  private final UnaryCallable<UpdateContactRequest, Contact> updateContactCallable;
  private final UnaryCallable<ListContactsRequest, ListContactsResponse> listContactsCallable;
  private final UnaryCallable<ListContactsRequest, ListContactsPagedResponse>
      listContactsPagedCallable;
  private final UnaryCallable<GetContactRequest, Contact> getContactCallable;
  private final UnaryCallable<DeleteContactRequest, Empty> deleteContactCallable;
  private final UnaryCallable<ComputeContactsRequest, ComputeContactsResponse>
      computeContactsCallable;
  private final UnaryCallable<ComputeContactsRequest, ComputeContactsPagedResponse>
      computeContactsPagedCallable;
  private final UnaryCallable<SendTestMessageRequest, Empty> sendTestMessageCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEssentialContactsServiceStub create(
      EssentialContactsServiceStubSettings settings) throws IOException {
    return new HttpJsonEssentialContactsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEssentialContactsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonEssentialContactsServiceStub(
        EssentialContactsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEssentialContactsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEssentialContactsServiceStub(
        EssentialContactsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEssentialContactsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEssentialContactsServiceStub(
      EssentialContactsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonEssentialContactsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEssentialContactsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEssentialContactsServiceStub(
      EssentialContactsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateContactRequest, Contact> createContactTransportSettings =
        HttpJsonCallSettings.<CreateContactRequest, Contact>newBuilder()
            .setMethodDescriptor(createContactMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateContactRequest, Contact> updateContactTransportSettings =
        HttpJsonCallSettings.<UpdateContactRequest, Contact>newBuilder()
            .setMethodDescriptor(updateContactMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListContactsRequest, ListContactsResponse> listContactsTransportSettings =
        HttpJsonCallSettings.<ListContactsRequest, ListContactsResponse>newBuilder()
            .setMethodDescriptor(listContactsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetContactRequest, Contact> getContactTransportSettings =
        HttpJsonCallSettings.<GetContactRequest, Contact>newBuilder()
            .setMethodDescriptor(getContactMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteContactRequest, Empty> deleteContactTransportSettings =
        HttpJsonCallSettings.<DeleteContactRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteContactMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ComputeContactsRequest, ComputeContactsResponse>
        computeContactsTransportSettings =
            HttpJsonCallSettings.<ComputeContactsRequest, ComputeContactsResponse>newBuilder()
                .setMethodDescriptor(computeContactsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SendTestMessageRequest, Empty> sendTestMessageTransportSettings =
        HttpJsonCallSettings.<SendTestMessageRequest, Empty>newBuilder()
            .setMethodDescriptor(sendTestMessageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createContactCallable =
        callableFactory.createUnaryCallable(
            createContactTransportSettings, settings.createContactSettings(), clientContext);
    this.updateContactCallable =
        callableFactory.createUnaryCallable(
            updateContactTransportSettings, settings.updateContactSettings(), clientContext);
    this.listContactsCallable =
        callableFactory.createUnaryCallable(
            listContactsTransportSettings, settings.listContactsSettings(), clientContext);
    this.listContactsPagedCallable =
        callableFactory.createPagedCallable(
            listContactsTransportSettings, settings.listContactsSettings(), clientContext);
    this.getContactCallable =
        callableFactory.createUnaryCallable(
            getContactTransportSettings, settings.getContactSettings(), clientContext);
    this.deleteContactCallable =
        callableFactory.createUnaryCallable(
            deleteContactTransportSettings, settings.deleteContactSettings(), clientContext);
    this.computeContactsCallable =
        callableFactory.createUnaryCallable(
            computeContactsTransportSettings, settings.computeContactsSettings(), clientContext);
    this.computeContactsPagedCallable =
        callableFactory.createPagedCallable(
            computeContactsTransportSettings, settings.computeContactsSettings(), clientContext);
    this.sendTestMessageCallable =
        callableFactory.createUnaryCallable(
            sendTestMessageTransportSettings, settings.sendTestMessageSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createContactMethodDescriptor);
    methodDescriptors.add(updateContactMethodDescriptor);
    methodDescriptors.add(listContactsMethodDescriptor);
    methodDescriptors.add(getContactMethodDescriptor);
    methodDescriptors.add(deleteContactMethodDescriptor);
    methodDescriptors.add(computeContactsMethodDescriptor);
    methodDescriptors.add(sendTestMessageMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateContactRequest, Contact> createContactCallable() {
    return createContactCallable;
  }

  @Override
  public UnaryCallable<UpdateContactRequest, Contact> updateContactCallable() {
    return updateContactCallable;
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
  public UnaryCallable<GetContactRequest, Contact> getContactCallable() {
    return getContactCallable;
  }

  @Override
  public UnaryCallable<DeleteContactRequest, Empty> deleteContactCallable() {
    return deleteContactCallable;
  }

  @Override
  public UnaryCallable<ComputeContactsRequest, ComputeContactsResponse> computeContactsCallable() {
    return computeContactsCallable;
  }

  @Override
  public UnaryCallable<ComputeContactsRequest, ComputeContactsPagedResponse>
      computeContactsPagedCallable() {
    return computeContactsPagedCallable;
  }

  @Override
  public UnaryCallable<SendTestMessageRequest, Empty> sendTestMessageCallable() {
    return sendTestMessageCallable;
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
