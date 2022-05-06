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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.AuthorizedCertificatesClient.ListAuthorizedCertificatesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.AuthorizedCertificate;
import com.google.appengine.v1.CreateAuthorizedCertificateRequest;
import com.google.appengine.v1.DeleteAuthorizedCertificateRequest;
import com.google.appengine.v1.GetAuthorizedCertificateRequest;
import com.google.appengine.v1.ListAuthorizedCertificatesRequest;
import com.google.appengine.v1.ListAuthorizedCertificatesResponse;
import com.google.appengine.v1.UpdateAuthorizedCertificateRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AuthorizedCertificates service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAuthorizedCertificatesStub extends AuthorizedCertificatesStub {
  private static final MethodDescriptor<
          ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>
      listAuthorizedCertificatesMethodDescriptor =
          MethodDescriptor
              .<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.appengine.v1.AuthorizedCertificates/ListAuthorizedCertificates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAuthorizedCertificatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAuthorizedCertificatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAuthorizedCertificateRequest, AuthorizedCertificate>
      getAuthorizedCertificateMethodDescriptor =
          MethodDescriptor.<GetAuthorizedCertificateRequest, AuthorizedCertificate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.appengine.v1.AuthorizedCertificates/GetAuthorizedCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAuthorizedCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AuthorizedCertificate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAuthorizedCertificateRequest, AuthorizedCertificate>
      createAuthorizedCertificateMethodDescriptor =
          MethodDescriptor.<CreateAuthorizedCertificateRequest, AuthorizedCertificate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.appengine.v1.AuthorizedCertificates/CreateAuthorizedCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAuthorizedCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AuthorizedCertificate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
      updateAuthorizedCertificateMethodDescriptor =
          MethodDescriptor.<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.appengine.v1.AuthorizedCertificates/UpdateAuthorizedCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAuthorizedCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AuthorizedCertificate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAuthorizedCertificateRequest, Empty>
      deleteAuthorizedCertificateMethodDescriptor =
          MethodDescriptor.<DeleteAuthorizedCertificateRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.appengine.v1.AuthorizedCertificates/DeleteAuthorizedCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAuthorizedCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>
      listAuthorizedCertificatesCallable;
  private final UnaryCallable<
          ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesPagedResponse>
      listAuthorizedCertificatesPagedCallable;
  private final UnaryCallable<GetAuthorizedCertificateRequest, AuthorizedCertificate>
      getAuthorizedCertificateCallable;
  private final UnaryCallable<CreateAuthorizedCertificateRequest, AuthorizedCertificate>
      createAuthorizedCertificateCallable;
  private final UnaryCallable<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
      updateAuthorizedCertificateCallable;
  private final UnaryCallable<DeleteAuthorizedCertificateRequest, Empty>
      deleteAuthorizedCertificateCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAuthorizedCertificatesStub create(
      AuthorizedCertificatesStubSettings settings) throws IOException {
    return new GrpcAuthorizedCertificatesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAuthorizedCertificatesStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAuthorizedCertificatesStub(
        AuthorizedCertificatesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAuthorizedCertificatesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAuthorizedCertificatesStub(
        AuthorizedCertificatesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAuthorizedCertificatesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAuthorizedCertificatesStub(
      AuthorizedCertificatesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcAuthorizedCertificatesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAuthorizedCertificatesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAuthorizedCertificatesStub(
      AuthorizedCertificatesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>
        listAuthorizedCertificatesTransportSettings =
            GrpcCallSettings
                .<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>newBuilder()
                .setMethodDescriptor(listAuthorizedCertificatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAuthorizedCertificateRequest, AuthorizedCertificate>
        getAuthorizedCertificateTransportSettings =
            GrpcCallSettings.<GetAuthorizedCertificateRequest, AuthorizedCertificate>newBuilder()
                .setMethodDescriptor(getAuthorizedCertificateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateAuthorizedCertificateRequest, AuthorizedCertificate>
        createAuthorizedCertificateTransportSettings =
            GrpcCallSettings.<CreateAuthorizedCertificateRequest, AuthorizedCertificate>newBuilder()
                .setMethodDescriptor(createAuthorizedCertificateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
        updateAuthorizedCertificateTransportSettings =
            GrpcCallSettings.<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>newBuilder()
                .setMethodDescriptor(updateAuthorizedCertificateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteAuthorizedCertificateRequest, Empty>
        deleteAuthorizedCertificateTransportSettings =
            GrpcCallSettings.<DeleteAuthorizedCertificateRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteAuthorizedCertificateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.listAuthorizedCertificatesCallable =
        callableFactory.createUnaryCallable(
            listAuthorizedCertificatesTransportSettings,
            settings.listAuthorizedCertificatesSettings(),
            clientContext);
    this.listAuthorizedCertificatesPagedCallable =
        callableFactory.createPagedCallable(
            listAuthorizedCertificatesTransportSettings,
            settings.listAuthorizedCertificatesSettings(),
            clientContext);
    this.getAuthorizedCertificateCallable =
        callableFactory.createUnaryCallable(
            getAuthorizedCertificateTransportSettings,
            settings.getAuthorizedCertificateSettings(),
            clientContext);
    this.createAuthorizedCertificateCallable =
        callableFactory.createUnaryCallable(
            createAuthorizedCertificateTransportSettings,
            settings.createAuthorizedCertificateSettings(),
            clientContext);
    this.updateAuthorizedCertificateCallable =
        callableFactory.createUnaryCallable(
            updateAuthorizedCertificateTransportSettings,
            settings.updateAuthorizedCertificateSettings(),
            clientContext);
    this.deleteAuthorizedCertificateCallable =
        callableFactory.createUnaryCallable(
            deleteAuthorizedCertificateTransportSettings,
            settings.deleteAuthorizedCertificateSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesResponse>
      listAuthorizedCertificatesCallable() {
    return listAuthorizedCertificatesCallable;
  }

  @Override
  public UnaryCallable<ListAuthorizedCertificatesRequest, ListAuthorizedCertificatesPagedResponse>
      listAuthorizedCertificatesPagedCallable() {
    return listAuthorizedCertificatesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuthorizedCertificateRequest, AuthorizedCertificate>
      getAuthorizedCertificateCallable() {
    return getAuthorizedCertificateCallable;
  }

  @Override
  public UnaryCallable<CreateAuthorizedCertificateRequest, AuthorizedCertificate>
      createAuthorizedCertificateCallable() {
    return createAuthorizedCertificateCallable;
  }

  @Override
  public UnaryCallable<UpdateAuthorizedCertificateRequest, AuthorizedCertificate>
      updateAuthorizedCertificateCallable() {
    return updateAuthorizedCertificateCallable;
  }

  @Override
  public UnaryCallable<DeleteAuthorizedCertificateRequest, Empty>
      deleteAuthorizedCertificateCallable() {
    return deleteAuthorizedCertificateCallable;
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
