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

package com.google.protos.google.cloud.binaryauthorization.v1.stub;

import static com.google.protos.google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1Client.ListAttestorsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.protos.google.cloud.binaryauthorization.v1.Resources;
import com.google.protos.google.cloud.binaryauthorization.v1.Service;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the BinauthzManagementServiceV1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcBinauthzManagementServiceV1Stub extends BinauthzManagementServiceV1Stub {
  private static final MethodDescriptor<Service.GetPolicyRequest, Resources.Policy>
      getPolicyMethodDescriptor =
          MethodDescriptor.<Service.GetPolicyRequest, Resources.Policy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/GetPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Service.GetPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Resources.Policy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<Service.UpdatePolicyRequest, Resources.Policy>
      updatePolicyMethodDescriptor =
          MethodDescriptor.<Service.UpdatePolicyRequest, Resources.Policy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/UpdatePolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Service.UpdatePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Resources.Policy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<Service.CreateAttestorRequest, Resources.Attestor>
      createAttestorMethodDescriptor =
          MethodDescriptor.<Service.CreateAttestorRequest, Resources.Attestor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/CreateAttestor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Service.CreateAttestorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Resources.Attestor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<Service.GetAttestorRequest, Resources.Attestor>
      getAttestorMethodDescriptor =
          MethodDescriptor.<Service.GetAttestorRequest, Resources.Attestor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/GetAttestor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Service.GetAttestorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Resources.Attestor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<Service.UpdateAttestorRequest, Resources.Attestor>
      updateAttestorMethodDescriptor =
          MethodDescriptor.<Service.UpdateAttestorRequest, Resources.Attestor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/UpdateAttestor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Service.UpdateAttestorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Resources.Attestor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<Service.ListAttestorsRequest, Service.ListAttestorsResponse>
      listAttestorsMethodDescriptor =
          MethodDescriptor.<Service.ListAttestorsRequest, Service.ListAttestorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/ListAttestors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Service.ListAttestorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(Service.ListAttestorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<Service.DeleteAttestorRequest, Empty>
      deleteAttestorMethodDescriptor =
          MethodDescriptor.<Service.DeleteAttestorRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1/DeleteAttestor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Service.DeleteAttestorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<Service.GetPolicyRequest, Resources.Policy> getPolicyCallable;
  private final UnaryCallable<Service.UpdatePolicyRequest, Resources.Policy> updatePolicyCallable;
  private final UnaryCallable<Service.CreateAttestorRequest, Resources.Attestor>
      createAttestorCallable;
  private final UnaryCallable<Service.GetAttestorRequest, Resources.Attestor> getAttestorCallable;
  private final UnaryCallable<Service.UpdateAttestorRequest, Resources.Attestor>
      updateAttestorCallable;
  private final UnaryCallable<Service.ListAttestorsRequest, Service.ListAttestorsResponse>
      listAttestorsCallable;
  private final UnaryCallable<Service.ListAttestorsRequest, ListAttestorsPagedResponse>
      listAttestorsPagedCallable;
  private final UnaryCallable<Service.DeleteAttestorRequest, Empty> deleteAttestorCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBinauthzManagementServiceV1Stub create(
      BinauthzManagementServiceV1StubSettings settings) throws IOException {
    return new GrpcBinauthzManagementServiceV1Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcBinauthzManagementServiceV1Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBinauthzManagementServiceV1Stub(
        BinauthzManagementServiceV1StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBinauthzManagementServiceV1Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBinauthzManagementServiceV1Stub(
        BinauthzManagementServiceV1StubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcBinauthzManagementServiceV1Stub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBinauthzManagementServiceV1Stub(
      BinauthzManagementServiceV1StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcBinauthzManagementServiceV1CallableFactory());
  }

  /**
   * Constructs an instance of GrpcBinauthzManagementServiceV1Stub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBinauthzManagementServiceV1Stub(
      BinauthzManagementServiceV1StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<Service.GetPolicyRequest, Resources.Policy> getPolicyTransportSettings =
        GrpcCallSettings.<Service.GetPolicyRequest, Resources.Policy>newBuilder()
            .setMethodDescriptor(getPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<Service.UpdatePolicyRequest, Resources.Policy> updatePolicyTransportSettings =
        GrpcCallSettings.<Service.UpdatePolicyRequest, Resources.Policy>newBuilder()
            .setMethodDescriptor(updatePolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("policy.name", String.valueOf(request.getPolicy().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<Service.CreateAttestorRequest, Resources.Attestor>
        createAttestorTransportSettings =
            GrpcCallSettings.<Service.CreateAttestorRequest, Resources.Attestor>newBuilder()
                .setMethodDescriptor(createAttestorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<Service.GetAttestorRequest, Resources.Attestor> getAttestorTransportSettings =
        GrpcCallSettings.<Service.GetAttestorRequest, Resources.Attestor>newBuilder()
            .setMethodDescriptor(getAttestorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<Service.UpdateAttestorRequest, Resources.Attestor>
        updateAttestorTransportSettings =
            GrpcCallSettings.<Service.UpdateAttestorRequest, Resources.Attestor>newBuilder()
                .setMethodDescriptor(updateAttestorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("attestor.name", String.valueOf(request.getAttestor().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<Service.ListAttestorsRequest, Service.ListAttestorsResponse>
        listAttestorsTransportSettings =
            GrpcCallSettings
                .<Service.ListAttestorsRequest, Service.ListAttestorsResponse>newBuilder()
                .setMethodDescriptor(listAttestorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<Service.DeleteAttestorRequest, Empty> deleteAttestorTransportSettings =
        GrpcCallSettings.<Service.DeleteAttestorRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAttestorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.getPolicyCallable =
        callableFactory.createUnaryCallable(
            getPolicyTransportSettings, settings.getPolicySettings(), clientContext);
    this.updatePolicyCallable =
        callableFactory.createUnaryCallable(
            updatePolicyTransportSettings, settings.updatePolicySettings(), clientContext);
    this.createAttestorCallable =
        callableFactory.createUnaryCallable(
            createAttestorTransportSettings, settings.createAttestorSettings(), clientContext);
    this.getAttestorCallable =
        callableFactory.createUnaryCallable(
            getAttestorTransportSettings, settings.getAttestorSettings(), clientContext);
    this.updateAttestorCallable =
        callableFactory.createUnaryCallable(
            updateAttestorTransportSettings, settings.updateAttestorSettings(), clientContext);
    this.listAttestorsCallable =
        callableFactory.createUnaryCallable(
            listAttestorsTransportSettings, settings.listAttestorsSettings(), clientContext);
    this.listAttestorsPagedCallable =
        callableFactory.createPagedCallable(
            listAttestorsTransportSettings, settings.listAttestorsSettings(), clientContext);
    this.deleteAttestorCallable =
        callableFactory.createUnaryCallable(
            deleteAttestorTransportSettings, settings.deleteAttestorSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<Service.GetPolicyRequest, Resources.Policy> getPolicyCallable() {
    return getPolicyCallable;
  }

  @Override
  public UnaryCallable<Service.UpdatePolicyRequest, Resources.Policy> updatePolicyCallable() {
    return updatePolicyCallable;
  }

  @Override
  public UnaryCallable<Service.CreateAttestorRequest, Resources.Attestor> createAttestorCallable() {
    return createAttestorCallable;
  }

  @Override
  public UnaryCallable<Service.GetAttestorRequest, Resources.Attestor> getAttestorCallable() {
    return getAttestorCallable;
  }

  @Override
  public UnaryCallable<Service.UpdateAttestorRequest, Resources.Attestor> updateAttestorCallable() {
    return updateAttestorCallable;
  }

  @Override
  public UnaryCallable<Service.ListAttestorsRequest, Service.ListAttestorsResponse>
      listAttestorsCallable() {
    return listAttestorsCallable;
  }

  @Override
  public UnaryCallable<Service.ListAttestorsRequest, ListAttestorsPagedResponse>
      listAttestorsPagedCallable() {
    return listAttestorsPagedCallable;
  }

  @Override
  public UnaryCallable<Service.DeleteAttestorRequest, Empty> deleteAttestorCallable() {
    return deleteAttestorCallable;
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
