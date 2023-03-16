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

package com.google.cloud.recaptchaenterprise.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1beta1.Assessment;
import com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the RecaptchaEnterpriseServiceV1Beta1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcRecaptchaEnterpriseServiceV1Beta1Stub
    extends RecaptchaEnterpriseServiceV1Beta1Stub {
  private static final MethodDescriptor<CreateAssessmentRequest, Assessment>
      createAssessmentMethodDescriptor =
          MethodDescriptor.<CreateAssessmentRequest, Assessment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1/CreateAssessment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAssessmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Assessment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentMethodDescriptor =
          MethodDescriptor.<AnnotateAssessmentRequest, AnnotateAssessmentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1/AnnotateAssessment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnnotateAssessmentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnnotateAssessmentResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateAssessmentRequest, Assessment> createAssessmentCallable;
  private final UnaryCallable<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRecaptchaEnterpriseServiceV1Beta1Stub create(
      RecaptchaEnterpriseServiceV1Beta1StubSettings settings) throws IOException {
    return new GrpcRecaptchaEnterpriseServiceV1Beta1Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcRecaptchaEnterpriseServiceV1Beta1Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcRecaptchaEnterpriseServiceV1Beta1Stub(
        RecaptchaEnterpriseServiceV1Beta1StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRecaptchaEnterpriseServiceV1Beta1Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRecaptchaEnterpriseServiceV1Beta1Stub(
        RecaptchaEnterpriseServiceV1Beta1StubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcRecaptchaEnterpriseServiceV1Beta1Stub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcRecaptchaEnterpriseServiceV1Beta1Stub(
      RecaptchaEnterpriseServiceV1Beta1StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRecaptchaEnterpriseServiceV1Beta1CallableFactory());
  }

  /**
   * Constructs an instance of GrpcRecaptchaEnterpriseServiceV1Beta1Stub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcRecaptchaEnterpriseServiceV1Beta1Stub(
      RecaptchaEnterpriseServiceV1Beta1StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateAssessmentRequest, Assessment> createAssessmentTransportSettings =
        GrpcCallSettings.<CreateAssessmentRequest, Assessment>newBuilder()
            .setMethodDescriptor(createAssessmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
        annotateAssessmentTransportSettings =
            GrpcCallSettings.<AnnotateAssessmentRequest, AnnotateAssessmentResponse>newBuilder()
                .setMethodDescriptor(annotateAssessmentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateAssessmentRequest, Assessment> createAssessmentCallable() {
    return createAssessmentCallable;
  }

  @Override
  public UnaryCallable<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentCallable() {
    return annotateAssessmentCallable;
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
