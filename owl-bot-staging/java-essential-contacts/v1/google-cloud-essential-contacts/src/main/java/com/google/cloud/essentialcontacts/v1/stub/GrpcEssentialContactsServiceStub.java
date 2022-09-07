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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the EssentialContactsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEssentialContactsServiceStub extends EssentialContactsServiceStub {
  private static final MethodDescriptor<CreateContactRequest, Contact>
      createContactMethodDescriptor =
          MethodDescriptor.<CreateContactRequest, Contact>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.essentialcontacts.v1.EssentialContactsService/CreateContact")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateContactRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Contact.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateContactRequest, Contact>
      updateContactMethodDescriptor =
          MethodDescriptor.<UpdateContactRequest, Contact>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.essentialcontacts.v1.EssentialContactsService/UpdateContact")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateContactRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Contact.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListContactsRequest, ListContactsResponse>
      listContactsMethodDescriptor =
          MethodDescriptor.<ListContactsRequest, ListContactsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.essentialcontacts.v1.EssentialContactsService/ListContacts")
              .setRequestMarshaller(ProtoUtils.marshaller(ListContactsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListContactsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetContactRequest, Contact> getContactMethodDescriptor =
      MethodDescriptor.<GetContactRequest, Contact>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.essentialcontacts.v1.EssentialContactsService/GetContact")
          .setRequestMarshaller(ProtoUtils.marshaller(GetContactRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Contact.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteContactRequest, Empty> deleteContactMethodDescriptor =
      MethodDescriptor.<DeleteContactRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.essentialcontacts.v1.EssentialContactsService/DeleteContact")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteContactRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ComputeContactsRequest, ComputeContactsResponse>
      computeContactsMethodDescriptor =
          MethodDescriptor.<ComputeContactsRequest, ComputeContactsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.essentialcontacts.v1.EssentialContactsService/ComputeContacts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ComputeContactsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ComputeContactsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SendTestMessageRequest, Empty>
      sendTestMessageMethodDescriptor =
          MethodDescriptor.<SendTestMessageRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.essentialcontacts.v1.EssentialContactsService/SendTestMessage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SendTestMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEssentialContactsServiceStub create(
      EssentialContactsServiceStubSettings settings) throws IOException {
    return new GrpcEssentialContactsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEssentialContactsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcEssentialContactsServiceStub(
        EssentialContactsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEssentialContactsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEssentialContactsServiceStub(
        EssentialContactsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEssentialContactsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcEssentialContactsServiceStub(
      EssentialContactsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEssentialContactsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEssentialContactsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcEssentialContactsServiceStub(
      EssentialContactsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateContactRequest, Contact> createContactTransportSettings =
        GrpcCallSettings.<CreateContactRequest, Contact>newBuilder()
            .setMethodDescriptor(createContactMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateContactRequest, Contact> updateContactTransportSettings =
        GrpcCallSettings.<UpdateContactRequest, Contact>newBuilder()
            .setMethodDescriptor(updateContactMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("contact.name", String.valueOf(request.getContact().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListContactsRequest, ListContactsResponse> listContactsTransportSettings =
        GrpcCallSettings.<ListContactsRequest, ListContactsResponse>newBuilder()
            .setMethodDescriptor(listContactsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetContactRequest, Contact> getContactTransportSettings =
        GrpcCallSettings.<GetContactRequest, Contact>newBuilder()
            .setMethodDescriptor(getContactMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteContactRequest, Empty> deleteContactTransportSettings =
        GrpcCallSettings.<DeleteContactRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteContactMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ComputeContactsRequest, ComputeContactsResponse>
        computeContactsTransportSettings =
            GrpcCallSettings.<ComputeContactsRequest, ComputeContactsResponse>newBuilder()
                .setMethodDescriptor(computeContactsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SendTestMessageRequest, Empty> sendTestMessageTransportSettings =
        GrpcCallSettings.<SendTestMessageRequest, Empty>newBuilder()
            .setMethodDescriptor(sendTestMessageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
