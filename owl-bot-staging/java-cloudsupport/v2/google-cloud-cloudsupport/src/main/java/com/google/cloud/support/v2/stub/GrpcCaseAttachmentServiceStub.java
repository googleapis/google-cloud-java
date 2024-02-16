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

package com.google.cloud.support.v2.stub;

import static com.google.cloud.support.v2.CaseAttachmentServiceClient.ListAttachmentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2.ListAttachmentsRequest;
import com.google.cloud.support.v2.ListAttachmentsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CaseAttachmentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCaseAttachmentServiceStub extends CaseAttachmentServiceStub {
  private static final MethodDescriptor<ListAttachmentsRequest, ListAttachmentsResponse>
      listAttachmentsMethodDescriptor =
          MethodDescriptor.<ListAttachmentsRequest, ListAttachmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.support.v2.CaseAttachmentService/ListAttachments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAttachmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAttachmentsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListAttachmentsRequest, ListAttachmentsResponse>
      listAttachmentsCallable;
  private final UnaryCallable<ListAttachmentsRequest, ListAttachmentsPagedResponse>
      listAttachmentsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCaseAttachmentServiceStub create(
      CaseAttachmentServiceStubSettings settings) throws IOException {
    return new GrpcCaseAttachmentServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCaseAttachmentServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCaseAttachmentServiceStub(
        CaseAttachmentServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCaseAttachmentServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCaseAttachmentServiceStub(
        CaseAttachmentServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCaseAttachmentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCaseAttachmentServiceStub(
      CaseAttachmentServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCaseAttachmentServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCaseAttachmentServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCaseAttachmentServiceStub(
      CaseAttachmentServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAttachmentsRequest, ListAttachmentsResponse>
        listAttachmentsTransportSettings =
            GrpcCallSettings.<ListAttachmentsRequest, ListAttachmentsResponse>newBuilder()
                .setMethodDescriptor(listAttachmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listAttachmentsCallable =
        callableFactory.createUnaryCallable(
            listAttachmentsTransportSettings, settings.listAttachmentsSettings(), clientContext);
    this.listAttachmentsPagedCallable =
        callableFactory.createPagedCallable(
            listAttachmentsTransportSettings, settings.listAttachmentsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListAttachmentsRequest, ListAttachmentsResponse> listAttachmentsCallable() {
    return listAttachmentsCallable;
  }

  @Override
  public UnaryCallable<ListAttachmentsRequest, ListAttachmentsPagedResponse>
      listAttachmentsPagedCallable() {
    return listAttachmentsPagedCallable;
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
