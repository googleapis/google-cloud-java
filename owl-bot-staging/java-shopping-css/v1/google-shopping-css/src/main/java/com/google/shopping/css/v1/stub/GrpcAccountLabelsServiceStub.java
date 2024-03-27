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

package com.google.shopping.css.v1.stub;

import static com.google.shopping.css.v1.AccountLabelsServiceClient.ListAccountLabelsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.css.v1.AccountLabel;
import com.google.shopping.css.v1.CreateAccountLabelRequest;
import com.google.shopping.css.v1.DeleteAccountLabelRequest;
import com.google.shopping.css.v1.ListAccountLabelsRequest;
import com.google.shopping.css.v1.ListAccountLabelsResponse;
import com.google.shopping.css.v1.UpdateAccountLabelRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AccountLabelsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAccountLabelsServiceStub extends AccountLabelsServiceStub {
  private static final MethodDescriptor<ListAccountLabelsRequest, ListAccountLabelsResponse>
      listAccountLabelsMethodDescriptor =
          MethodDescriptor.<ListAccountLabelsRequest, ListAccountLabelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.shopping.css.v1.AccountLabelsService/ListAccountLabels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAccountLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAccountLabelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAccountLabelRequest, AccountLabel>
      createAccountLabelMethodDescriptor =
          MethodDescriptor.<CreateAccountLabelRequest, AccountLabel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.shopping.css.v1.AccountLabelsService/CreateAccountLabel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAccountLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccountLabel.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAccountLabelRequest, AccountLabel>
      updateAccountLabelMethodDescriptor =
          MethodDescriptor.<UpdateAccountLabelRequest, AccountLabel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.shopping.css.v1.AccountLabelsService/UpdateAccountLabel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAccountLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AccountLabel.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAccountLabelRequest, Empty>
      deleteAccountLabelMethodDescriptor =
          MethodDescriptor.<DeleteAccountLabelRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.shopping.css.v1.AccountLabelsService/DeleteAccountLabel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAccountLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsResponse>
      listAccountLabelsCallable;
  private final UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsPagedResponse>
      listAccountLabelsPagedCallable;
  private final UnaryCallable<CreateAccountLabelRequest, AccountLabel> createAccountLabelCallable;
  private final UnaryCallable<UpdateAccountLabelRequest, AccountLabel> updateAccountLabelCallable;
  private final UnaryCallable<DeleteAccountLabelRequest, Empty> deleteAccountLabelCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAccountLabelsServiceStub create(AccountLabelsServiceStubSettings settings)
      throws IOException {
    return new GrpcAccountLabelsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAccountLabelsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAccountLabelsServiceStub(
        AccountLabelsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAccountLabelsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAccountLabelsServiceStub(
        AccountLabelsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAccountLabelsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccountLabelsServiceStub(
      AccountLabelsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAccountLabelsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAccountLabelsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAccountLabelsServiceStub(
      AccountLabelsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAccountLabelsRequest, ListAccountLabelsResponse>
        listAccountLabelsTransportSettings =
            GrpcCallSettings.<ListAccountLabelsRequest, ListAccountLabelsResponse>newBuilder()
                .setMethodDescriptor(listAccountLabelsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateAccountLabelRequest, AccountLabel> createAccountLabelTransportSettings =
        GrpcCallSettings.<CreateAccountLabelRequest, AccountLabel>newBuilder()
            .setMethodDescriptor(createAccountLabelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAccountLabelRequest, AccountLabel> updateAccountLabelTransportSettings =
        GrpcCallSettings.<UpdateAccountLabelRequest, AccountLabel>newBuilder()
            .setMethodDescriptor(updateAccountLabelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "account_label.name", String.valueOf(request.getAccountLabel().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAccountLabelRequest, Empty> deleteAccountLabelTransportSettings =
        GrpcCallSettings.<DeleteAccountLabelRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAccountLabelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listAccountLabelsCallable =
        callableFactory.createUnaryCallable(
            listAccountLabelsTransportSettings,
            settings.listAccountLabelsSettings(),
            clientContext);
    this.listAccountLabelsPagedCallable =
        callableFactory.createPagedCallable(
            listAccountLabelsTransportSettings,
            settings.listAccountLabelsSettings(),
            clientContext);
    this.createAccountLabelCallable =
        callableFactory.createUnaryCallable(
            createAccountLabelTransportSettings,
            settings.createAccountLabelSettings(),
            clientContext);
    this.updateAccountLabelCallable =
        callableFactory.createUnaryCallable(
            updateAccountLabelTransportSettings,
            settings.updateAccountLabelSettings(),
            clientContext);
    this.deleteAccountLabelCallable =
        callableFactory.createUnaryCallable(
            deleteAccountLabelTransportSettings,
            settings.deleteAccountLabelSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsResponse>
      listAccountLabelsCallable() {
    return listAccountLabelsCallable;
  }

  @Override
  public UnaryCallable<ListAccountLabelsRequest, ListAccountLabelsPagedResponse>
      listAccountLabelsPagedCallable() {
    return listAccountLabelsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAccountLabelRequest, AccountLabel> createAccountLabelCallable() {
    return createAccountLabelCallable;
  }

  @Override
  public UnaryCallable<UpdateAccountLabelRequest, AccountLabel> updateAccountLabelCallable() {
    return updateAccountLabelCallable;
  }

  @Override
  public UnaryCallable<DeleteAccountLabelRequest, Empty> deleteAccountLabelCallable() {
    return deleteAccountLabelCallable;
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
