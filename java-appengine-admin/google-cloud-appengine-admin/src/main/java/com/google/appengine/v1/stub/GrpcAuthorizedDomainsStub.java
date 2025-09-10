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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.AuthorizedDomainsClient.ListAuthorizedDomainsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.ListAuthorizedDomainsRequest;
import com.google.appengine.v1.ListAuthorizedDomainsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AuthorizedDomains service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAuthorizedDomainsStub extends AuthorizedDomainsStub {
  private static final MethodDescriptor<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>
      listAuthorizedDomainsMethodDescriptor =
          MethodDescriptor.<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.AuthorizedDomains/ListAuthorizedDomains")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAuthorizedDomainsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAuthorizedDomainsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>
      listAuthorizedDomainsCallable;
  private final UnaryCallable<ListAuthorizedDomainsRequest, ListAuthorizedDomainsPagedResponse>
      listAuthorizedDomainsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAuthorizedDomainsStub create(AuthorizedDomainsStubSettings settings)
      throws IOException {
    return new GrpcAuthorizedDomainsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAuthorizedDomainsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAuthorizedDomainsStub(
        AuthorizedDomainsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAuthorizedDomainsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAuthorizedDomainsStub(
        AuthorizedDomainsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAuthorizedDomainsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAuthorizedDomainsStub(
      AuthorizedDomainsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAuthorizedDomainsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAuthorizedDomainsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAuthorizedDomainsStub(
      AuthorizedDomainsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>
        listAuthorizedDomainsTransportSettings =
            GrpcCallSettings
                .<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>newBuilder()
                .setMethodDescriptor(listAuthorizedDomainsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listAuthorizedDomainsCallable =
        callableFactory.createUnaryCallable(
            listAuthorizedDomainsTransportSettings,
            settings.listAuthorizedDomainsSettings(),
            clientContext);
    this.listAuthorizedDomainsPagedCallable =
        callableFactory.createPagedCallable(
            listAuthorizedDomainsTransportSettings,
            settings.listAuthorizedDomainsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListAuthorizedDomainsRequest, ListAuthorizedDomainsResponse>
      listAuthorizedDomainsCallable() {
    return listAuthorizedDomainsCallable;
  }

  @Override
  public UnaryCallable<ListAuthorizedDomainsRequest, ListAuthorizedDomainsPagedResponse>
      listAuthorizedDomainsPagedCallable() {
    return listAuthorizedDomainsPagedCallable;
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
