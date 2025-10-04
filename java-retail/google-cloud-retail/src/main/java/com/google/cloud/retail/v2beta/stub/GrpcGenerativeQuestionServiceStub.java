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

package com.google.cloud.retail.v2beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2beta.BatchUpdateGenerativeQuestionConfigsRequest;
import com.google.cloud.retail.v2beta.BatchUpdateGenerativeQuestionConfigsResponse;
import com.google.cloud.retail.v2beta.GenerativeQuestionConfig;
import com.google.cloud.retail.v2beta.GenerativeQuestionsFeatureConfig;
import com.google.cloud.retail.v2beta.GetGenerativeQuestionsFeatureConfigRequest;
import com.google.cloud.retail.v2beta.ListGenerativeQuestionConfigsRequest;
import com.google.cloud.retail.v2beta.ListGenerativeQuestionConfigsResponse;
import com.google.cloud.retail.v2beta.UpdateGenerativeQuestionConfigRequest;
import com.google.cloud.retail.v2beta.UpdateGenerativeQuestionsFeatureConfigRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the GenerativeQuestionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcGenerativeQuestionServiceStub extends GenerativeQuestionServiceStub {
  private static final MethodDescriptor<
          UpdateGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
      updateGenerativeQuestionsFeatureConfigMethodDescriptor =
          MethodDescriptor
              .<UpdateGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2beta.GenerativeQuestionService/UpdateGenerativeQuestionsFeatureConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateGenerativeQuestionsFeatureConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerativeQuestionsFeatureConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
      getGenerativeQuestionsFeatureConfigMethodDescriptor =
          MethodDescriptor
              .<GetGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2beta.GenerativeQuestionService/GetGenerativeQuestionsFeatureConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetGenerativeQuestionsFeatureConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerativeQuestionsFeatureConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListGenerativeQuestionConfigsRequest, ListGenerativeQuestionConfigsResponse>
      listGenerativeQuestionConfigsMethodDescriptor =
          MethodDescriptor
              .<ListGenerativeQuestionConfigsRequest, ListGenerativeQuestionConfigsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2beta.GenerativeQuestionService/ListGenerativeQuestionConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGenerativeQuestionConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGenerativeQuestionConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          UpdateGenerativeQuestionConfigRequest, GenerativeQuestionConfig>
      updateGenerativeQuestionConfigMethodDescriptor =
          MethodDescriptor
              .<UpdateGenerativeQuestionConfigRequest, GenerativeQuestionConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2beta.GenerativeQuestionService/UpdateGenerativeQuestionConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGenerativeQuestionConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerativeQuestionConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          BatchUpdateGenerativeQuestionConfigsRequest, BatchUpdateGenerativeQuestionConfigsResponse>
      batchUpdateGenerativeQuestionConfigsMethodDescriptor =
          MethodDescriptor
              .<BatchUpdateGenerativeQuestionConfigsRequest,
                  BatchUpdateGenerativeQuestionConfigsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2beta.GenerativeQuestionService/BatchUpdateGenerativeQuestionConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      BatchUpdateGenerativeQuestionConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      BatchUpdateGenerativeQuestionConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<
          UpdateGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
      updateGenerativeQuestionsFeatureConfigCallable;
  private final UnaryCallable<
          GetGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
      getGenerativeQuestionsFeatureConfigCallable;
  private final UnaryCallable<
          ListGenerativeQuestionConfigsRequest, ListGenerativeQuestionConfigsResponse>
      listGenerativeQuestionConfigsCallable;
  private final UnaryCallable<UpdateGenerativeQuestionConfigRequest, GenerativeQuestionConfig>
      updateGenerativeQuestionConfigCallable;
  private final UnaryCallable<
          BatchUpdateGenerativeQuestionConfigsRequest, BatchUpdateGenerativeQuestionConfigsResponse>
      batchUpdateGenerativeQuestionConfigsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGenerativeQuestionServiceStub create(
      GenerativeQuestionServiceStubSettings settings) throws IOException {
    return new GrpcGenerativeQuestionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGenerativeQuestionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcGenerativeQuestionServiceStub(
        GenerativeQuestionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGenerativeQuestionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGenerativeQuestionServiceStub(
        GenerativeQuestionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGenerativeQuestionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGenerativeQuestionServiceStub(
      GenerativeQuestionServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcGenerativeQuestionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGenerativeQuestionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGenerativeQuestionServiceStub(
      GenerativeQuestionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<
            UpdateGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
        updateGenerativeQuestionsFeatureConfigTransportSettings =
            GrpcCallSettings
                .<UpdateGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
                    newBuilder()
                .setMethodDescriptor(updateGenerativeQuestionsFeatureConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "generative_questions_feature_config.catalog",
                          String.valueOf(
                              request.getGenerativeQuestionsFeatureConfig().getCatalog()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
        getGenerativeQuestionsFeatureConfigTransportSettings =
            GrpcCallSettings
                .<GetGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
                    newBuilder()
                .setMethodDescriptor(getGenerativeQuestionsFeatureConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("catalog", String.valueOf(request.getCatalog()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListGenerativeQuestionConfigsRequest, ListGenerativeQuestionConfigsResponse>
        listGenerativeQuestionConfigsTransportSettings =
            GrpcCallSettings
                .<ListGenerativeQuestionConfigsRequest, ListGenerativeQuestionConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(listGenerativeQuestionConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateGenerativeQuestionConfigRequest, GenerativeQuestionConfig>
        updateGenerativeQuestionConfigTransportSettings =
            GrpcCallSettings
                .<UpdateGenerativeQuestionConfigRequest, GenerativeQuestionConfig>newBuilder()
                .setMethodDescriptor(updateGenerativeQuestionConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "generative_question_config.catalog",
                          String.valueOf(request.getGenerativeQuestionConfig().getCatalog()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<
            BatchUpdateGenerativeQuestionConfigsRequest,
            BatchUpdateGenerativeQuestionConfigsResponse>
        batchUpdateGenerativeQuestionConfigsTransportSettings =
            GrpcCallSettings
                .<BatchUpdateGenerativeQuestionConfigsRequest,
                    BatchUpdateGenerativeQuestionConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateGenerativeQuestionConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.updateGenerativeQuestionsFeatureConfigCallable =
        callableFactory.createUnaryCallable(
            updateGenerativeQuestionsFeatureConfigTransportSettings,
            settings.updateGenerativeQuestionsFeatureConfigSettings(),
            clientContext);
    this.getGenerativeQuestionsFeatureConfigCallable =
        callableFactory.createUnaryCallable(
            getGenerativeQuestionsFeatureConfigTransportSettings,
            settings.getGenerativeQuestionsFeatureConfigSettings(),
            clientContext);
    this.listGenerativeQuestionConfigsCallable =
        callableFactory.createUnaryCallable(
            listGenerativeQuestionConfigsTransportSettings,
            settings.listGenerativeQuestionConfigsSettings(),
            clientContext);
    this.updateGenerativeQuestionConfigCallable =
        callableFactory.createUnaryCallable(
            updateGenerativeQuestionConfigTransportSettings,
            settings.updateGenerativeQuestionConfigSettings(),
            clientContext);
    this.batchUpdateGenerativeQuestionConfigsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateGenerativeQuestionConfigsTransportSettings,
            settings.batchUpdateGenerativeQuestionConfigsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<
          UpdateGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
      updateGenerativeQuestionsFeatureConfigCallable() {
    return updateGenerativeQuestionsFeatureConfigCallable;
  }

  @Override
  public UnaryCallable<GetGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
      getGenerativeQuestionsFeatureConfigCallable() {
    return getGenerativeQuestionsFeatureConfigCallable;
  }

  @Override
  public UnaryCallable<ListGenerativeQuestionConfigsRequest, ListGenerativeQuestionConfigsResponse>
      listGenerativeQuestionConfigsCallable() {
    return listGenerativeQuestionConfigsCallable;
  }

  @Override
  public UnaryCallable<UpdateGenerativeQuestionConfigRequest, GenerativeQuestionConfig>
      updateGenerativeQuestionConfigCallable() {
    return updateGenerativeQuestionConfigCallable;
  }

  @Override
  public UnaryCallable<
          BatchUpdateGenerativeQuestionConfigsRequest, BatchUpdateGenerativeQuestionConfigsResponse>
      batchUpdateGenerativeQuestionConfigsCallable() {
    return batchUpdateGenerativeQuestionConfigsCallable;
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
