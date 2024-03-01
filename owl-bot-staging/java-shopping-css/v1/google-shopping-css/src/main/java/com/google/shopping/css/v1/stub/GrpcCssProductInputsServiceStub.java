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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.css.v1.CssProductInput;
import com.google.shopping.css.v1.DeleteCssProductInputRequest;
import com.google.shopping.css.v1.InsertCssProductInputRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CssProductInputsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCssProductInputsServiceStub extends CssProductInputsServiceStub {
  private static final MethodDescriptor<InsertCssProductInputRequest, CssProductInput>
      insertCssProductInputMethodDescriptor =
          MethodDescriptor.<InsertCssProductInputRequest, CssProductInput>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.css.v1.CssProductInputsService/InsertCssProductInput")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InsertCssProductInputRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CssProductInput.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCssProductInputRequest, Empty>
      deleteCssProductInputMethodDescriptor =
          MethodDescriptor.<DeleteCssProductInputRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.css.v1.CssProductInputsService/DeleteCssProductInput")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCssProductInputRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<InsertCssProductInputRequest, CssProductInput>
      insertCssProductInputCallable;
  private final UnaryCallable<DeleteCssProductInputRequest, Empty> deleteCssProductInputCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCssProductInputsServiceStub create(
      CssProductInputsServiceStubSettings settings) throws IOException {
    return new GrpcCssProductInputsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCssProductInputsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCssProductInputsServiceStub(
        CssProductInputsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCssProductInputsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCssProductInputsServiceStub(
        CssProductInputsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCssProductInputsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCssProductInputsServiceStub(
      CssProductInputsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCssProductInputsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCssProductInputsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCssProductInputsServiceStub(
      CssProductInputsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<InsertCssProductInputRequest, CssProductInput>
        insertCssProductInputTransportSettings =
            GrpcCallSettings.<InsertCssProductInputRequest, CssProductInput>newBuilder()
                .setMethodDescriptor(insertCssProductInputMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteCssProductInputRequest, Empty> deleteCssProductInputTransportSettings =
        GrpcCallSettings.<DeleteCssProductInputRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCssProductInputMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.insertCssProductInputCallable =
        callableFactory.createUnaryCallable(
            insertCssProductInputTransportSettings,
            settings.insertCssProductInputSettings(),
            clientContext);
    this.deleteCssProductInputCallable =
        callableFactory.createUnaryCallable(
            deleteCssProductInputTransportSettings,
            settings.deleteCssProductInputSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<InsertCssProductInputRequest, CssProductInput>
      insertCssProductInputCallable() {
    return insertCssProductInputCallable;
  }

  @Override
  public UnaryCallable<DeleteCssProductInputRequest, Empty> deleteCssProductInputCallable() {
    return deleteCssProductInputCallable;
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
