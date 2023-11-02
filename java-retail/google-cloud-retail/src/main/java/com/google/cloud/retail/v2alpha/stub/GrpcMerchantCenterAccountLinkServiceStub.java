/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.retail.v2alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkMetadata;
import com.google.cloud.retail.v2alpha.CreateMerchantCenterAccountLinkRequest;
import com.google.cloud.retail.v2alpha.DeleteMerchantCenterAccountLinkRequest;
import com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksRequest;
import com.google.cloud.retail.v2alpha.ListMerchantCenterAccountLinksResponse;
import com.google.cloud.retail.v2alpha.MerchantCenterAccountLink;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MerchantCenterAccountLinkService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMerchantCenterAccountLinkServiceStub extends MerchantCenterAccountLinkServiceStub {
  private static final MethodDescriptor<
          ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
      listMerchantCenterAccountLinksMethodDescriptor =
          MethodDescriptor
              .<ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2alpha.MerchantCenterAccountLinkService/ListMerchantCenterAccountLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMerchantCenterAccountLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListMerchantCenterAccountLinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMerchantCenterAccountLinkRequest, Operation>
      createMerchantCenterAccountLinkMethodDescriptor =
          MethodDescriptor.<CreateMerchantCenterAccountLinkRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2alpha.MerchantCenterAccountLinkService/CreateMerchantCenterAccountLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateMerchantCenterAccountLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMerchantCenterAccountLinkRequest, Empty>
      deleteMerchantCenterAccountLinkMethodDescriptor =
          MethodDescriptor.<DeleteMerchantCenterAccountLinkRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2alpha.MerchantCenterAccountLinkService/DeleteMerchantCenterAccountLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteMerchantCenterAccountLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<
          ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
      listMerchantCenterAccountLinksCallable;
  private final UnaryCallable<CreateMerchantCenterAccountLinkRequest, Operation>
      createMerchantCenterAccountLinkCallable;
  private final OperationCallable<
          CreateMerchantCenterAccountLinkRequest,
          MerchantCenterAccountLink,
          CreateMerchantCenterAccountLinkMetadata>
      createMerchantCenterAccountLinkOperationCallable;
  private final UnaryCallable<DeleteMerchantCenterAccountLinkRequest, Empty>
      deleteMerchantCenterAccountLinkCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMerchantCenterAccountLinkServiceStub create(
      MerchantCenterAccountLinkServiceStubSettings settings) throws IOException {
    return new GrpcMerchantCenterAccountLinkServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMerchantCenterAccountLinkServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMerchantCenterAccountLinkServiceStub(
        MerchantCenterAccountLinkServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMerchantCenterAccountLinkServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMerchantCenterAccountLinkServiceStub(
        MerchantCenterAccountLinkServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcMerchantCenterAccountLinkServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcMerchantCenterAccountLinkServiceStub(
      MerchantCenterAccountLinkServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMerchantCenterAccountLinkServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMerchantCenterAccountLinkServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcMerchantCenterAccountLinkServiceStub(
      MerchantCenterAccountLinkServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
        listMerchantCenterAccountLinksTransportSettings =
            GrpcCallSettings
                .<ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
                    newBuilder()
                .setMethodDescriptor(listMerchantCenterAccountLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateMerchantCenterAccountLinkRequest, Operation>
        createMerchantCenterAccountLinkTransportSettings =
            GrpcCallSettings.<CreateMerchantCenterAccountLinkRequest, Operation>newBuilder()
                .setMethodDescriptor(createMerchantCenterAccountLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteMerchantCenterAccountLinkRequest, Empty>
        deleteMerchantCenterAccountLinkTransportSettings =
            GrpcCallSettings.<DeleteMerchantCenterAccountLinkRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteMerchantCenterAccountLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.listMerchantCenterAccountLinksCallable =
        callableFactory.createUnaryCallable(
            listMerchantCenterAccountLinksTransportSettings,
            settings.listMerchantCenterAccountLinksSettings(),
            clientContext);
    this.createMerchantCenterAccountLinkCallable =
        callableFactory.createUnaryCallable(
            createMerchantCenterAccountLinkTransportSettings,
            settings.createMerchantCenterAccountLinkSettings(),
            clientContext);
    this.createMerchantCenterAccountLinkOperationCallable =
        callableFactory.createOperationCallable(
            createMerchantCenterAccountLinkTransportSettings,
            settings.createMerchantCenterAccountLinkOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMerchantCenterAccountLinkCallable =
        callableFactory.createUnaryCallable(
            deleteMerchantCenterAccountLinkTransportSettings,
            settings.deleteMerchantCenterAccountLinkSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<
          ListMerchantCenterAccountLinksRequest, ListMerchantCenterAccountLinksResponse>
      listMerchantCenterAccountLinksCallable() {
    return listMerchantCenterAccountLinksCallable;
  }

  @Override
  public UnaryCallable<CreateMerchantCenterAccountLinkRequest, Operation>
      createMerchantCenterAccountLinkCallable() {
    return createMerchantCenterAccountLinkCallable;
  }

  @Override
  public OperationCallable<
          CreateMerchantCenterAccountLinkRequest,
          MerchantCenterAccountLink,
          CreateMerchantCenterAccountLinkMetadata>
      createMerchantCenterAccountLinkOperationCallable() {
    return createMerchantCenterAccountLinkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMerchantCenterAccountLinkRequest, Empty>
      deleteMerchantCenterAccountLinkCallable() {
    return deleteMerchantCenterAccountLinkCallable;
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
