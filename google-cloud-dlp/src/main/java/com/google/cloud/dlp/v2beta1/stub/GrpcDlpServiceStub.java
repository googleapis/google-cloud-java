/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dlp.v2beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dlp.v2beta1.DlpServiceSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest;
import com.google.privacy.dlp.v2beta1.InspectContentRequest;
import com.google.privacy.dlp.v2beta1.InspectContentResponse;
import com.google.privacy.dlp.v2beta1.InspectOperationMetadata;
import com.google.privacy.dlp.v2beta1.InspectOperationResult;
import com.google.privacy.dlp.v2beta1.ListInfoTypesRequest;
import com.google.privacy.dlp.v2beta1.ListInfoTypesResponse;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse;
import com.google.privacy.dlp.v2beta1.RedactContentRequest;
import com.google.privacy.dlp.v2beta1.RedactContentResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for DLP API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcDlpServiceStub extends DlpServiceStub {
  private static final UnaryCallable<InspectContentRequest, InspectContentResponse>
      directInspectContentCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.privacy.dlp.v2beta1.DlpService/InspectContent",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      InspectContentRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      InspectContentResponse.getDefaultInstance())));
  private static final UnaryCallable<RedactContentRequest, RedactContentResponse>
      directRedactContentCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.privacy.dlp.v2beta1.DlpService/RedactContent",
                  io.grpc.protobuf.ProtoUtils.marshaller(RedactContentRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      RedactContentResponse.getDefaultInstance())));
  private static final UnaryCallable<CreateInspectOperationRequest, Operation>
      directCreateInspectOperationCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.privacy.dlp.v2beta1.DlpService/CreateInspectOperation",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      CreateInspectOperationRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(Operation.getDefaultInstance())));
  private static final UnaryCallable<ListInspectFindingsRequest, ListInspectFindingsResponse>
      directListInspectFindingsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.privacy.dlp.v2beta1.DlpService/ListInspectFindings",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListInspectFindingsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListInspectFindingsResponse.getDefaultInstance())));
  private static final UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse>
      directListInfoTypesCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.privacy.dlp.v2beta1.DlpService/ListInfoTypes",
                  io.grpc.protobuf.ProtoUtils.marshaller(ListInfoTypesRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListInfoTypesResponse.getDefaultInstance())));
  private static final UnaryCallable<ListRootCategoriesRequest, ListRootCategoriesResponse>
      directListRootCategoriesCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.privacy.dlp.v2beta1.DlpService/ListRootCategories",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListRootCategoriesRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListRootCategoriesResponse.getDefaultInstance())));

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;

  private final UnaryCallable<InspectContentRequest, InspectContentResponse> inspectContentCallable;
  private final UnaryCallable<RedactContentRequest, RedactContentResponse> redactContentCallable;
  private final UnaryCallable<CreateInspectOperationRequest, Operation>
      createInspectOperationCallable;
  private final OperationCallable<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata,
          Operation>
      createInspectOperationOperationCallable;
  private final UnaryCallable<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsCallable;
  private final UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable;
  private final UnaryCallable<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesCallable;

  public static final GrpcDlpServiceStub create(DlpServiceSettings settings) throws IOException {
    return new GrpcDlpServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDlpServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcDlpServiceStub(DlpServiceSettings.defaultBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcDlpServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDlpServiceStub(DlpServiceSettings settings, ClientContext clientContext)
      throws IOException {
    this.operationsStub = GrpcOperationsStub.create(clientContext);

    this.inspectContentCallable =
        GrpcCallableFactory.create(
            directInspectContentCallable, settings.inspectContentSettings(), clientContext);
    this.redactContentCallable =
        GrpcCallableFactory.create(
            directRedactContentCallable, settings.redactContentSettings(), clientContext);
    this.createInspectOperationCallable =
        GrpcCallableFactory.create(
            directCreateInspectOperationCallable,
            settings.createInspectOperationSettings().getInitialCallSettings(),
            clientContext);
    this.createInspectOperationOperationCallable =
        GrpcCallableFactory.create(
            directCreateInspectOperationCallable,
            settings.createInspectOperationSettings(),
            clientContext,
            this.operationsStub);
    this.listInspectFindingsCallable =
        GrpcCallableFactory.create(
            directListInspectFindingsCallable,
            settings.listInspectFindingsSettings(),
            clientContext);
    this.listInfoTypesCallable =
        GrpcCallableFactory.create(
            directListInfoTypesCallable, settings.listInfoTypesSettings(), clientContext);
    this.listRootCategoriesCallable =
        GrpcCallableFactory.create(
            directListRootCategoriesCallable, settings.listRootCategoriesSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<InspectContentRequest, InspectContentResponse> inspectContentCallable() {
    return inspectContentCallable;
  }

  public UnaryCallable<RedactContentRequest, RedactContentResponse> redactContentCallable() {
    return redactContentCallable;
  }

  public OperationCallable<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata,
          Operation>
      createInspectOperationOperationCallable() {
    return createInspectOperationOperationCallable;
  }

  public UnaryCallable<CreateInspectOperationRequest, Operation> createInspectOperationCallable() {
    return createInspectOperationCallable;
  }

  public UnaryCallable<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsCallable() {
    return listInspectFindingsCallable;
  }

  public UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable() {
    return listInfoTypesCallable;
  }

  public UnaryCallable<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesCallable() {
    return listRootCategoriesCallable;
  }

  @Override
  public final void close() throws Exception {
    shutdown();
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
