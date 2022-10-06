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

package com.google.cloud.binaryauthorization.v1beta1.stub;

import static com.google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1Client.ListAttestorsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.binaryauthorization.v1beta1.Attestor;
import com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest;
import com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest;
import com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse;
import com.google.cloud.binaryauthorization.v1beta1.Policy;
import com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the BinauthzManagementServiceV1Beta1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcBinauthzManagementServiceV1Beta1Stub extends BinauthzManagementServiceV1Beta1Stub {
  private static final MethodDescriptor<GetPolicyRequest, Policy> getPolicyMethodDescriptor =
      MethodDescriptor.<GetPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/GetPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdatePolicyRequest, Policy> updatePolicyMethodDescriptor =
      MethodDescriptor.<UpdatePolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/UpdatePolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdatePolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateAttestorRequest, Attestor>
      createAttestorMethodDescriptor =
          MethodDescriptor.<CreateAttestorRequest, Attestor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/CreateAttestor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAttestorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Attestor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAttestorRequest, Attestor> getAttestorMethodDescriptor =
      MethodDescriptor.<GetAttestorRequest, Attestor>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/GetAttestor")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAttestorRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Attestor.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateAttestorRequest, Attestor>
      updateAttestorMethodDescriptor =
          MethodDescriptor.<UpdateAttestorRequest, Attestor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/UpdateAttestor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAttestorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Attestor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAttestorsRequest, ListAttestorsResponse>
      listAttestorsMethodDescriptor =
          MethodDescriptor.<ListAttestorsRequest, ListAttestorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/ListAttestors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAttestorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAttestorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAttestorRequest, Empty>
      deleteAttestorMethodDescriptor =
          MethodDescriptor.<DeleteAttestorRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1/DeleteAttestor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAttestorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable;
  private final UnaryCallable<UpdatePolicyRequest, Policy> updatePolicyCallable;
  private final UnaryCallable<CreateAttestorRequest, Attestor> createAttestorCallable;
  private final UnaryCallable<GetAttestorRequest, Attestor> getAttestorCallable;
  private final UnaryCallable<UpdateAttestorRequest, Attestor> updateAttestorCallable;
  private final UnaryCallable<ListAttestorsRequest, ListAttestorsResponse> listAttestorsCallable;
  private final UnaryCallable<ListAttestorsRequest, ListAttestorsPagedResponse>
      listAttestorsPagedCallable;
  private final UnaryCallable<DeleteAttestorRequest, Empty> deleteAttestorCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBinauthzManagementServiceV1Beta1Stub create(
      BinauthzManagementServiceV1Beta1StubSettings settings) throws IOException {
    return new GrpcBinauthzManagementServiceV1Beta1Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcBinauthzManagementServiceV1Beta1Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBinauthzManagementServiceV1Beta1Stub(
        BinauthzManagementServiceV1Beta1StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBinauthzManagementServiceV1Beta1Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBinauthzManagementServiceV1Beta1Stub(
        BinauthzManagementServiceV1Beta1StubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcBinauthzManagementServiceV1Beta1Stub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcBinauthzManagementServiceV1Beta1Stub(
      BinauthzManagementServiceV1Beta1StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcBinauthzManagementServiceV1Beta1CallableFactory());
  }

  /**
   * Constructs an instance of GrpcBinauthzManagementServiceV1Beta1Stub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcBinauthzManagementServiceV1Beta1Stub(
      BinauthzManagementServiceV1Beta1StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetPolicyRequest, Policy> getPolicyTransportSettings =
        GrpcCallSettings.<GetPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdatePolicyRequest, Policy> updatePolicyTransportSettings =
        GrpcCallSettings.<UpdatePolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(updatePolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("policy.name", String.valueOf(request.getPolicy().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateAttestorRequest, Attestor> createAttestorTransportSettings =
        GrpcCallSettings.<CreateAttestorRequest, Attestor>newBuilder()
            .setMethodDescriptor(createAttestorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetAttestorRequest, Attestor> getAttestorTransportSettings =
        GrpcCallSettings.<GetAttestorRequest, Attestor>newBuilder()
            .setMethodDescriptor(getAttestorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateAttestorRequest, Attestor> updateAttestorTransportSettings =
        GrpcCallSettings.<UpdateAttestorRequest, Attestor>newBuilder()
            .setMethodDescriptor(updateAttestorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("attestor.name", String.valueOf(request.getAttestor().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAttestorsRequest, ListAttestorsResponse> listAttestorsTransportSettings =
        GrpcCallSettings.<ListAttestorsRequest, ListAttestorsResponse>newBuilder()
            .setMethodDescriptor(listAttestorsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteAttestorRequest, Empty> deleteAttestorTransportSettings =
        GrpcCallSettings.<DeleteAttestorRequest, Empty>newBuilder()
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
  public UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable() {
    return getPolicyCallable;
  }

  @Override
  public UnaryCallable<UpdatePolicyRequest, Policy> updatePolicyCallable() {
    return updatePolicyCallable;
  }

  @Override
  public UnaryCallable<CreateAttestorRequest, Attestor> createAttestorCallable() {
    return createAttestorCallable;
  }

  @Override
  public UnaryCallable<GetAttestorRequest, Attestor> getAttestorCallable() {
    return getAttestorCallable;
  }

  @Override
  public UnaryCallable<UpdateAttestorRequest, Attestor> updateAttestorCallable() {
    return updateAttestorCallable;
  }

  @Override
  public UnaryCallable<ListAttestorsRequest, ListAttestorsResponse> listAttestorsCallable() {
    return listAttestorsCallable;
  }

  @Override
  public UnaryCallable<ListAttestorsRequest, ListAttestorsPagedResponse>
      listAttestorsPagedCallable() {
    return listAttestorsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAttestorRequest, Empty> deleteAttestorCallable() {
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
