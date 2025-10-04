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

package com.google.cloud.policysimulator.v1.stub;

import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPagedResponse;
import static com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewServiceClient.ListOrgPolicyViolationsPreviewsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewOperationMetadata;
import com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest;
import com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest;
import com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse;
import com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the OrgPolicyViolationsPreviewService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcOrgPolicyViolationsPreviewServiceStub
    extends OrgPolicyViolationsPreviewServiceStub {
  private static final MethodDescriptor<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
      listOrgPolicyViolationsPreviewsMethodDescriptor =
          MethodDescriptor
              .<ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewService/ListOrgPolicyViolationsPreviews")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListOrgPolicyViolationsPreviewsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListOrgPolicyViolationsPreviewsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
      getOrgPolicyViolationsPreviewMethodDescriptor =
          MethodDescriptor
              .<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewService/GetOrgPolicyViolationsPreview")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOrgPolicyViolationsPreviewRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(OrgPolicyViolationsPreview.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateOrgPolicyViolationsPreviewRequest, Operation>
      createOrgPolicyViolationsPreviewMethodDescriptor =
          MethodDescriptor.<CreateOrgPolicyViolationsPreviewRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewService/CreateOrgPolicyViolationsPreview")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateOrgPolicyViolationsPreviewRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>
      listOrgPolicyViolationsMethodDescriptor =
          MethodDescriptor
              .<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewService/ListOrgPolicyViolations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOrgPolicyViolationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOrgPolicyViolationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
      listOrgPolicyViolationsPreviewsCallable;
  private final UnaryCallable<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsPagedResponse>
      listOrgPolicyViolationsPreviewsPagedCallable;
  private final UnaryCallable<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
      getOrgPolicyViolationsPreviewCallable;
  private final UnaryCallable<CreateOrgPolicyViolationsPreviewRequest, Operation>
      createOrgPolicyViolationsPreviewCallable;
  private final OperationCallable<
          CreateOrgPolicyViolationsPreviewRequest,
          OrgPolicyViolationsPreview,
          CreateOrgPolicyViolationsPreviewOperationMetadata>
      createOrgPolicyViolationsPreviewOperationCallable;
  private final UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>
      listOrgPolicyViolationsCallable;
  private final UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsPagedResponse>
      listOrgPolicyViolationsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcOrgPolicyViolationsPreviewServiceStub create(
      OrgPolicyViolationsPreviewServiceStubSettings settings) throws IOException {
    return new GrpcOrgPolicyViolationsPreviewServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOrgPolicyViolationsPreviewServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOrgPolicyViolationsPreviewServiceStub(
        OrgPolicyViolationsPreviewServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOrgPolicyViolationsPreviewServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOrgPolicyViolationsPreviewServiceStub(
        OrgPolicyViolationsPreviewServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcOrgPolicyViolationsPreviewServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcOrgPolicyViolationsPreviewServiceStub(
      OrgPolicyViolationsPreviewServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcOrgPolicyViolationsPreviewServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOrgPolicyViolationsPreviewServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcOrgPolicyViolationsPreviewServiceStub(
      OrgPolicyViolationsPreviewServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<
            ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
        listOrgPolicyViolationsPreviewsTransportSettings =
            GrpcCallSettings
                .<ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
                    newBuilder()
                .setMethodDescriptor(listOrgPolicyViolationsPreviewsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
        getOrgPolicyViolationsPreviewTransportSettings =
            GrpcCallSettings
                .<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>newBuilder()
                .setMethodDescriptor(getOrgPolicyViolationsPreviewMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateOrgPolicyViolationsPreviewRequest, Operation>
        createOrgPolicyViolationsPreviewTransportSettings =
            GrpcCallSettings.<CreateOrgPolicyViolationsPreviewRequest, Operation>newBuilder()
                .setMethodDescriptor(createOrgPolicyViolationsPreviewMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>
        listOrgPolicyViolationsTransportSettings =
            GrpcCallSettings
                .<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>newBuilder()
                .setMethodDescriptor(listOrgPolicyViolationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listOrgPolicyViolationsPreviewsCallable =
        callableFactory.createUnaryCallable(
            listOrgPolicyViolationsPreviewsTransportSettings,
            settings.listOrgPolicyViolationsPreviewsSettings(),
            clientContext);
    this.listOrgPolicyViolationsPreviewsPagedCallable =
        callableFactory.createPagedCallable(
            listOrgPolicyViolationsPreviewsTransportSettings,
            settings.listOrgPolicyViolationsPreviewsSettings(),
            clientContext);
    this.getOrgPolicyViolationsPreviewCallable =
        callableFactory.createUnaryCallable(
            getOrgPolicyViolationsPreviewTransportSettings,
            settings.getOrgPolicyViolationsPreviewSettings(),
            clientContext);
    this.createOrgPolicyViolationsPreviewCallable =
        callableFactory.createUnaryCallable(
            createOrgPolicyViolationsPreviewTransportSettings,
            settings.createOrgPolicyViolationsPreviewSettings(),
            clientContext);
    this.createOrgPolicyViolationsPreviewOperationCallable =
        callableFactory.createOperationCallable(
            createOrgPolicyViolationsPreviewTransportSettings,
            settings.createOrgPolicyViolationsPreviewOperationSettings(),
            clientContext,
            operationsStub);
    this.listOrgPolicyViolationsCallable =
        callableFactory.createUnaryCallable(
            listOrgPolicyViolationsTransportSettings,
            settings.listOrgPolicyViolationsSettings(),
            clientContext);
    this.listOrgPolicyViolationsPagedCallable =
        callableFactory.createPagedCallable(
            listOrgPolicyViolationsTransportSettings,
            settings.listOrgPolicyViolationsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsResponse>
      listOrgPolicyViolationsPreviewsCallable() {
    return listOrgPolicyViolationsPreviewsCallable;
  }

  @Override
  public UnaryCallable<
          ListOrgPolicyViolationsPreviewsRequest, ListOrgPolicyViolationsPreviewsPagedResponse>
      listOrgPolicyViolationsPreviewsPagedCallable() {
    return listOrgPolicyViolationsPreviewsPagedCallable;
  }

  @Override
  public UnaryCallable<GetOrgPolicyViolationsPreviewRequest, OrgPolicyViolationsPreview>
      getOrgPolicyViolationsPreviewCallable() {
    return getOrgPolicyViolationsPreviewCallable;
  }

  @Override
  public UnaryCallable<CreateOrgPolicyViolationsPreviewRequest, Operation>
      createOrgPolicyViolationsPreviewCallable() {
    return createOrgPolicyViolationsPreviewCallable;
  }

  @Override
  public OperationCallable<
          CreateOrgPolicyViolationsPreviewRequest,
          OrgPolicyViolationsPreview,
          CreateOrgPolicyViolationsPreviewOperationMetadata>
      createOrgPolicyViolationsPreviewOperationCallable() {
    return createOrgPolicyViolationsPreviewOperationCallable;
  }

  @Override
  public UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsResponse>
      listOrgPolicyViolationsCallable() {
    return listOrgPolicyViolationsCallable;
  }

  @Override
  public UnaryCallable<ListOrgPolicyViolationsRequest, ListOrgPolicyViolationsPagedResponse>
      listOrgPolicyViolationsPagedCallable() {
    return listOrgPolicyViolationsPagedCallable;
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
