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

package com.google.cloud.run.v2.stub;

import static com.google.cloud.run.v2.RevisionsClient.ListRevisionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.run.v2.DeleteRevisionRequest;
import com.google.cloud.run.v2.GetRevisionRequest;
import com.google.cloud.run.v2.ListRevisionsRequest;
import com.google.cloud.run.v2.ListRevisionsResponse;
import com.google.cloud.run.v2.Revision;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Revisions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcRevisionsStub extends RevisionsStub {
  private static final MethodDescriptor<GetRevisionRequest, Revision> getRevisionMethodDescriptor =
      MethodDescriptor.<GetRevisionRequest, Revision>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.run.v2.Revisions/GetRevision")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRevisionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Revision.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListRevisionsRequest, ListRevisionsResponse>
      listRevisionsMethodDescriptor =
          MethodDescriptor.<ListRevisionsRequest, ListRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.run.v2.Revisions/ListRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRevisionRequest, Operation>
      deleteRevisionMethodDescriptor =
          MethodDescriptor.<DeleteRevisionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.run.v2.Revisions/DeleteRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable;
  private final UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable;
  private final UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable;
  private final UnaryCallable<DeleteRevisionRequest, Operation> deleteRevisionCallable;
  private final OperationCallable<DeleteRevisionRequest, Revision, Revision>
      deleteRevisionOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate GET_REVISION_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/**");
  private static final PathTemplate LIST_REVISIONS_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/**");
  private static final PathTemplate DELETE_REVISION_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/**");

  public static final GrpcRevisionsStub create(RevisionsStubSettings settings) throws IOException {
    return new GrpcRevisionsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRevisionsStub create(ClientContext clientContext) throws IOException {
    return new GrpcRevisionsStub(RevisionsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRevisionsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRevisionsStub(
        RevisionsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcRevisionsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcRevisionsStub(RevisionsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRevisionsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRevisionsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcRevisionsStub(
      RevisionsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetRevisionRequest, Revision> getRevisionTransportSettings =
        GrpcCallSettings.<GetRevisionRequest, Revision>newBuilder()
            .setMethodDescriptor(getRevisionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "location", GET_REVISION_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRevisionsRequest, ListRevisionsResponse> listRevisionsTransportSettings =
        GrpcCallSettings.<ListRevisionsRequest, ListRevisionsResponse>newBuilder()
            .setMethodDescriptor(listRevisionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "location", LIST_REVISIONS_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRevisionRequest, Operation> deleteRevisionTransportSettings =
        GrpcCallSettings.<DeleteRevisionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRevisionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "location", DELETE_REVISION_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();

    this.getRevisionCallable =
        callableFactory.createUnaryCallable(
            getRevisionTransportSettings, settings.getRevisionSettings(), clientContext);
    this.listRevisionsCallable =
        callableFactory.createUnaryCallable(
            listRevisionsTransportSettings, settings.listRevisionsSettings(), clientContext);
    this.listRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listRevisionsTransportSettings, settings.listRevisionsSettings(), clientContext);
    this.deleteRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteRevisionTransportSettings, settings.deleteRevisionSettings(), clientContext);
    this.deleteRevisionOperationCallable =
        callableFactory.createOperationCallable(
            deleteRevisionTransportSettings,
            settings.deleteRevisionOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable() {
    return getRevisionCallable;
  }

  @Override
  public UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable() {
    return listRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable() {
    return listRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRevisionRequest, Operation> deleteRevisionCallable() {
    return deleteRevisionCallable;
  }

  @Override
  public OperationCallable<DeleteRevisionRequest, Revision, Revision>
      deleteRevisionOperationCallable() {
    return deleteRevisionOperationCallable;
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
