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

package com.google.shopping.merchant.accounts.v1beta.stub;

import static com.google.shopping.merchant.accounts.v1beta.ProgramsServiceClient.ListProgramsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest;
import com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest;
import com.google.shopping.merchant.accounts.v1beta.GetProgramRequest;
import com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse;
import com.google.shopping.merchant.accounts.v1beta.Program;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ProgramsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcProgramsServiceStub extends ProgramsServiceStub {
  private static final MethodDescriptor<GetProgramRequest, Program> getProgramMethodDescriptor =
      MethodDescriptor.<GetProgramRequest, Program>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.merchant.accounts.v1beta.ProgramsService/GetProgram")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProgramRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Program.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListProgramsRequest, ListProgramsResponse>
      listProgramsMethodDescriptor =
          MethodDescriptor.<ListProgramsRequest, ListProgramsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.ProgramsService/ListPrograms")
              .setRequestMarshaller(ProtoUtils.marshaller(ListProgramsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProgramsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EnableProgramRequest, Program>
      enableProgramMethodDescriptor =
          MethodDescriptor.<EnableProgramRequest, Program>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.ProgramsService/EnableProgram")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableProgramRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Program.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DisableProgramRequest, Program>
      disableProgramMethodDescriptor =
          MethodDescriptor.<DisableProgramRequest, Program>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.ProgramsService/DisableProgram")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableProgramRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Program.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetProgramRequest, Program> getProgramCallable;
  private final UnaryCallable<ListProgramsRequest, ListProgramsResponse> listProgramsCallable;
  private final UnaryCallable<ListProgramsRequest, ListProgramsPagedResponse>
      listProgramsPagedCallable;
  private final UnaryCallable<EnableProgramRequest, Program> enableProgramCallable;
  private final UnaryCallable<DisableProgramRequest, Program> disableProgramCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcProgramsServiceStub create(ProgramsServiceStubSettings settings)
      throws IOException {
    return new GrpcProgramsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcProgramsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcProgramsServiceStub(
        ProgramsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcProgramsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcProgramsServiceStub(
        ProgramsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcProgramsServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProgramsServiceStub(
      ProgramsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcProgramsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcProgramsServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProgramsServiceStub(
      ProgramsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetProgramRequest, Program> getProgramTransportSettings =
        GrpcCallSettings.<GetProgramRequest, Program>newBuilder()
            .setMethodDescriptor(getProgramMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListProgramsRequest, ListProgramsResponse> listProgramsTransportSettings =
        GrpcCallSettings.<ListProgramsRequest, ListProgramsResponse>newBuilder()
            .setMethodDescriptor(listProgramsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<EnableProgramRequest, Program> enableProgramTransportSettings =
        GrpcCallSettings.<EnableProgramRequest, Program>newBuilder()
            .setMethodDescriptor(enableProgramMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DisableProgramRequest, Program> disableProgramTransportSettings =
        GrpcCallSettings.<DisableProgramRequest, Program>newBuilder()
            .setMethodDescriptor(disableProgramMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getProgramCallable =
        callableFactory.createUnaryCallable(
            getProgramTransportSettings, settings.getProgramSettings(), clientContext);
    this.listProgramsCallable =
        callableFactory.createUnaryCallable(
            listProgramsTransportSettings, settings.listProgramsSettings(), clientContext);
    this.listProgramsPagedCallable =
        callableFactory.createPagedCallable(
            listProgramsTransportSettings, settings.listProgramsSettings(), clientContext);
    this.enableProgramCallable =
        callableFactory.createUnaryCallable(
            enableProgramTransportSettings, settings.enableProgramSettings(), clientContext);
    this.disableProgramCallable =
        callableFactory.createUnaryCallable(
            disableProgramTransportSettings, settings.disableProgramSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetProgramRequest, Program> getProgramCallable() {
    return getProgramCallable;
  }

  @Override
  public UnaryCallable<ListProgramsRequest, ListProgramsResponse> listProgramsCallable() {
    return listProgramsCallable;
  }

  @Override
  public UnaryCallable<ListProgramsRequest, ListProgramsPagedResponse> listProgramsPagedCallable() {
    return listProgramsPagedCallable;
  }

  @Override
  public UnaryCallable<EnableProgramRequest, Program> enableProgramCallable() {
    return enableProgramCallable;
  }

  @Override
  public UnaryCallable<DisableProgramRequest, Program> disableProgramCallable() {
    return disableProgramCallable;
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
