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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.TypeRegistry;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1beta1.Assessment;
import com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the RecaptchaEnterpriseServiceV1Beta1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonRecaptchaEnterpriseServiceV1Beta1Stub
    extends RecaptchaEnterpriseServiceV1Beta1Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateAssessmentRequest, Assessment>
      createAssessmentMethodDescriptor =
          ApiMethodDescriptor.<CreateAssessmentRequest, Assessment>newBuilder()
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1/CreateAssessment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAssessmentRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*}/assessments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAssessmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAssessmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("assessment", request.getAssessment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Assessment>newBuilder()
                      .setDefaultInstance(Assessment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentMethodDescriptor =
          ApiMethodDescriptor.<AnnotateAssessmentRequest, AnnotateAssessmentResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1/AnnotateAssessment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnnotateAssessmentRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/assessments/*}:annotate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnnotateAssessmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnnotateAssessmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnnotateAssessmentResponse>newBuilder()
                      .setDefaultInstance(AnnotateAssessmentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateAssessmentRequest, Assessment> createAssessmentCallable;
  private final UnaryCallable<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
      annotateAssessmentCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRecaptchaEnterpriseServiceV1Beta1Stub create(
      RecaptchaEnterpriseServiceV1Beta1StubSettings settings) throws IOException {
    return new HttpJsonRecaptchaEnterpriseServiceV1Beta1Stub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonRecaptchaEnterpriseServiceV1Beta1Stub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonRecaptchaEnterpriseServiceV1Beta1Stub(
        RecaptchaEnterpriseServiceV1Beta1StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRecaptchaEnterpriseServiceV1Beta1Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRecaptchaEnterpriseServiceV1Beta1Stub(
        RecaptchaEnterpriseServiceV1Beta1StubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRecaptchaEnterpriseServiceV1Beta1Stub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonRecaptchaEnterpriseServiceV1Beta1Stub(
      RecaptchaEnterpriseServiceV1Beta1StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRecaptchaEnterpriseServiceV1Beta1CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRecaptchaEnterpriseServiceV1Beta1Stub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonRecaptchaEnterpriseServiceV1Beta1Stub(
      RecaptchaEnterpriseServiceV1Beta1StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateAssessmentRequest, Assessment> createAssessmentTransportSettings =
        HttpJsonCallSettings.<CreateAssessmentRequest, Assessment>newBuilder()
            .setMethodDescriptor(createAssessmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AnnotateAssessmentRequest, AnnotateAssessmentResponse>
        annotateAssessmentTransportSettings =
            HttpJsonCallSettings.<AnnotateAssessmentRequest, AnnotateAssessmentResponse>newBuilder()
                .setMethodDescriptor(annotateAssessmentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createAssessmentMethodDescriptor);
    methodDescriptors.add(annotateAssessmentMethodDescriptor);
    return methodDescriptors;
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
