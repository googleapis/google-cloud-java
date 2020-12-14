/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.recaptchaenterprise.v1.stub;

import static com.google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseServiceClient.ListKeysPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1.Assessment;
import com.google.recaptchaenterprise.v1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1.CreateKeyRequest;
import com.google.recaptchaenterprise.v1.DeleteKeyRequest;
import com.google.recaptchaenterprise.v1.GetKeyRequest;
import com.google.recaptchaenterprise.v1.Key;
import com.google.recaptchaenterprise.v1.ListKeysRequest;
import com.google.recaptchaenterprise.v1.ListKeysResponse;
import com.google.recaptchaenterprise.v1.UpdateKeyRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the RecaptchaEnterpriseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcRecaptchaEnterpriseServiceStub extends RecaptchaEnterpriseServiceStub {
  private static final MethodDescriptor<CreateAssessmentRequest, Assessment>
      createAssessmentMethodDescriptor =
          MethodDescriptor.<CreateAssessmentRequest, Assessment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/CreateAssessment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAssessmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Assessment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentMethodDescriptor =
          MethodDescriptor.<AnnotateAssessmentRequest, AnnotateAssessmentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/AnnotateAssessment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnnotateAssessmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnnotateAssessmentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateKeyRequest, Key> createKeyMethodDescriptor =
      MethodDescriptor.<CreateKeyRequest, Key>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/CreateKey")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Key.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListKeysRequest, ListKeysResponse>
      listKeysMethodDescriptor =
          MethodDescriptor.<ListKeysRequest, ListKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/ListKeys")
              .setRequestMarshaller(ProtoUtils.marshaller(ListKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListKeysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetKeyRequest, Key> getKeyMethodDescriptor =
      MethodDescriptor.<GetKeyRequest, Key>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/GetKey")
          .setRequestMarshaller(ProtoUtils.marshaller(GetKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Key.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateKeyRequest, Key> updateKeyMethodDescriptor =
      MethodDescriptor.<UpdateKeyRequest, Key>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/UpdateKey")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Key.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteKeyRequest, Empty> deleteKeyMethodDescriptor =
      MethodDescriptor.<DeleteKeyRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService/DeleteKey")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateAssessmentRequest, Assessment> createAssessmentCallable;
  private final UnaryCallable<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentCallable;
  private final UnaryCallable<CreateKeyRequest, Key> createKeyCallable;
  private final UnaryCallable<ListKeysRequest, ListKeysResponse> listKeysCallable;
  private final UnaryCallable<ListKeysRequest, ListKeysPagedResponse> listKeysPagedCallable;
  private final UnaryCallable<GetKeyRequest, Key> getKeyCallable;
  private final UnaryCallable<UpdateKeyRequest, Key> updateKeyCallable;
  private final UnaryCallable<DeleteKeyRequest, Empty> deleteKeyCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRecaptchaEnterpriseServiceStub create(
      RecaptchaEnterpriseServiceStubSettings settings) throws IOException {
    return new GrpcRecaptchaEnterpriseServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRecaptchaEnterpriseServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcRecaptchaEnterpriseServiceStub(
        RecaptchaEnterpriseServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRecaptchaEnterpriseServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRecaptchaEnterpriseServiceStub(
        RecaptchaEnterpriseServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcRecaptchaEnterpriseServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcRecaptchaEnterpriseServiceStub(
      RecaptchaEnterpriseServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRecaptchaEnterpriseServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRecaptchaEnterpriseServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcRecaptchaEnterpriseServiceStub(
      RecaptchaEnterpriseServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateAssessmentRequest, Assessment> createAssessmentTransportSettings =
        GrpcCallSettings.<CreateAssessmentRequest, Assessment>newBuilder()
            .setMethodDescriptor(createAssessmentMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateAssessmentRequest>() {
                  @Override
                  public Map<String, String> extract(CreateAssessmentRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
        annotateAssessmentTransportSettings =
            GrpcCallSettings.<AnnotateAssessmentRequest, AnnotateAssessmentResponse>newBuilder()
                .setMethodDescriptor(annotateAssessmentMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<AnnotateAssessmentRequest>() {
                      @Override
                      public Map<String, String> extract(AnnotateAssessmentRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateKeyRequest, Key> createKeyTransportSettings =
        GrpcCallSettings.<CreateKeyRequest, Key>newBuilder()
            .setMethodDescriptor(createKeyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateKeyRequest>() {
                  @Override
                  public Map<String, String> extract(CreateKeyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListKeysRequest, ListKeysResponse> listKeysTransportSettings =
        GrpcCallSettings.<ListKeysRequest, ListKeysResponse>newBuilder()
            .setMethodDescriptor(listKeysMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListKeysRequest>() {
                  @Override
                  public Map<String, String> extract(ListKeysRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetKeyRequest, Key> getKeyTransportSettings =
        GrpcCallSettings.<GetKeyRequest, Key>newBuilder()
            .setMethodDescriptor(getKeyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetKeyRequest>() {
                  @Override
                  public Map<String, String> extract(GetKeyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateKeyRequest, Key> updateKeyTransportSettings =
        GrpcCallSettings.<UpdateKeyRequest, Key>newBuilder()
            .setMethodDescriptor(updateKeyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateKeyRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateKeyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("key.name", String.valueOf(request.getKey().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteKeyRequest, Empty> deleteKeyTransportSettings =
        GrpcCallSettings.<DeleteKeyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteKeyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteKeyRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteKeyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.createAssessmentCallable =
        callableFactory.createUnaryCallable(
            createAssessmentTransportSettings, settings.createAssessmentSettings(), clientContext);
    this.annotateAssessmentCallable =
        callableFactory.createUnaryCallable(
            annotateAssessmentTransportSettings,
            settings.annotateAssessmentSettings(),
            clientContext);
    this.createKeyCallable =
        callableFactory.createUnaryCallable(
            createKeyTransportSettings, settings.createKeySettings(), clientContext);
    this.listKeysCallable =
        callableFactory.createUnaryCallable(
            listKeysTransportSettings, settings.listKeysSettings(), clientContext);
    this.listKeysPagedCallable =
        callableFactory.createPagedCallable(
            listKeysTransportSettings, settings.listKeysSettings(), clientContext);
    this.getKeyCallable =
        callableFactory.createUnaryCallable(
            getKeyTransportSettings, settings.getKeySettings(), clientContext);
    this.updateKeyCallable =
        callableFactory.createUnaryCallable(
            updateKeyTransportSettings, settings.updateKeySettings(), clientContext);
    this.deleteKeyCallable =
        callableFactory.createUnaryCallable(
            deleteKeyTransportSettings, settings.deleteKeySettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<CreateAssessmentRequest, Assessment> createAssessmentCallable() {
    return createAssessmentCallable;
  }

  public UnaryCallable<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentCallable() {
    return annotateAssessmentCallable;
  }

  public UnaryCallable<CreateKeyRequest, Key> createKeyCallable() {
    return createKeyCallable;
  }

  public UnaryCallable<ListKeysRequest, ListKeysResponse> listKeysCallable() {
    return listKeysCallable;
  }

  public UnaryCallable<ListKeysRequest, ListKeysPagedResponse> listKeysPagedCallable() {
    return listKeysPagedCallable;
  }

  public UnaryCallable<GetKeyRequest, Key> getKeyCallable() {
    return getKeyCallable;
  }

  public UnaryCallable<UpdateKeyRequest, Key> updateKeyCallable() {
    return updateKeyCallable;
  }

  public UnaryCallable<DeleteKeyRequest, Empty> deleteKeyCallable() {
    return deleteKeyCallable;
  }

  @Override
  public final void close() {
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
