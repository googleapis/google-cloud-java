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

package com.google.cloud.retail.v2beta.stub;

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
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the GenerativeQuestionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonGenerativeQuestionServiceStub extends GenerativeQuestionServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          UpdateGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
      updateGenerativeQuestionsFeatureConfigMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2beta.GenerativeQuestionService/UpdateGenerativeQuestionsFeatureConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateGenerativeQuestionsFeatureConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{generativeQuestionsFeatureConfig.catalog=projects/*/locations/*/catalogs/*}/generativeQuestionFeature",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGenerativeQuestionsFeatureConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "generativeQuestionsFeatureConfig.catalog",
                                request.getGenerativeQuestionsFeatureConfig().getCatalog());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGenerativeQuestionsFeatureConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "generativeQuestionsFeatureConfig",
                                      request.getGenerativeQuestionsFeatureConfig(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerativeQuestionsFeatureConfig>newBuilder()
                      .setDefaultInstance(GenerativeQuestionsFeatureConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
      getGenerativeQuestionsFeatureConfigMethodDescriptor =
          ApiMethodDescriptor
              .<GetGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2beta.GenerativeQuestionService/GetGenerativeQuestionsFeatureConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetGenerativeQuestionsFeatureConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{catalog=projects/*/locations/*/catalogs/*}/generativeQuestionFeature",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetGenerativeQuestionsFeatureConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "catalog", request.getCatalog());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetGenerativeQuestionsFeatureConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerativeQuestionsFeatureConfig>newBuilder()
                      .setDefaultInstance(GenerativeQuestionsFeatureConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListGenerativeQuestionConfigsRequest, ListGenerativeQuestionConfigsResponse>
      listGenerativeQuestionConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListGenerativeQuestionConfigsRequest, ListGenerativeQuestionConfigsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2beta.GenerativeQuestionService/ListGenerativeQuestionConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListGenerativeQuestionConfigsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*/catalogs/*}/generativeQuestions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListGenerativeQuestionConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListGenerativeQuestionConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListGenerativeQuestionConfigsResponse>newBuilder()
                      .setDefaultInstance(
                          ListGenerativeQuestionConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateGenerativeQuestionConfigRequest, GenerativeQuestionConfig>
      updateGenerativeQuestionConfigMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateGenerativeQuestionConfigRequest, GenerativeQuestionConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2beta.GenerativeQuestionService/UpdateGenerativeQuestionConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateGenerativeQuestionConfigRequest>newBuilder()
                      .setPath(
                          "/v2beta/{generativeQuestionConfig.catalog=projects/*/locations/*/catalogs/*}/generativeQuestion",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGenerativeQuestionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "generativeQuestionConfig.catalog",
                                request.getGenerativeQuestionConfig().getCatalog());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateGenerativeQuestionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "generativeQuestionConfig",
                                      request.getGenerativeQuestionConfig(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerativeQuestionConfig>newBuilder()
                      .setDefaultInstance(GenerativeQuestionConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateGenerativeQuestionConfigsRequest, BatchUpdateGenerativeQuestionConfigsResponse>
      batchUpdateGenerativeQuestionConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateGenerativeQuestionConfigsRequest,
                  BatchUpdateGenerativeQuestionConfigsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2beta.GenerativeQuestionService/BatchUpdateGenerativeQuestionConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<BatchUpdateGenerativeQuestionConfigsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*/catalogs/*}/generativeQuestion:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateGenerativeQuestionConfigsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateGenerativeQuestionConfigsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<BatchUpdateGenerativeQuestionConfigsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchUpdateGenerativeQuestionConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGenerativeQuestionServiceStub create(
      GenerativeQuestionServiceStubSettings settings) throws IOException {
    return new HttpJsonGenerativeQuestionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGenerativeQuestionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGenerativeQuestionServiceStub(
        GenerativeQuestionServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGenerativeQuestionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGenerativeQuestionServiceStub(
        GenerativeQuestionServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGenerativeQuestionServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGenerativeQuestionServiceStub(
      GenerativeQuestionServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGenerativeQuestionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGenerativeQuestionServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGenerativeQuestionServiceStub(
      GenerativeQuestionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            UpdateGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
        updateGenerativeQuestionsFeatureConfigTransportSettings =
            HttpJsonCallSettings
                .<UpdateGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
                    newBuilder()
                .setMethodDescriptor(updateGenerativeQuestionsFeatureConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
    HttpJsonCallSettings<
            GetGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
        getGenerativeQuestionsFeatureConfigTransportSettings =
            HttpJsonCallSettings
                .<GetGenerativeQuestionsFeatureConfigRequest, GenerativeQuestionsFeatureConfig>
                    newBuilder()
                .setMethodDescriptor(getGenerativeQuestionsFeatureConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("catalog", String.valueOf(request.getCatalog()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListGenerativeQuestionConfigsRequest, ListGenerativeQuestionConfigsResponse>
        listGenerativeQuestionConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListGenerativeQuestionConfigsRequest, ListGenerativeQuestionConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(listGenerativeQuestionConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateGenerativeQuestionConfigRequest, GenerativeQuestionConfig>
        updateGenerativeQuestionConfigTransportSettings =
            HttpJsonCallSettings
                .<UpdateGenerativeQuestionConfigRequest, GenerativeQuestionConfig>newBuilder()
                .setMethodDescriptor(updateGenerativeQuestionConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "generative_question_config.catalog",
                          String.valueOf(request.getGenerativeQuestionConfig().getCatalog()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchUpdateGenerativeQuestionConfigsRequest,
            BatchUpdateGenerativeQuestionConfigsResponse>
        batchUpdateGenerativeQuestionConfigsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateGenerativeQuestionConfigsRequest,
                    BatchUpdateGenerativeQuestionConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateGenerativeQuestionConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(updateGenerativeQuestionsFeatureConfigMethodDescriptor);
    methodDescriptors.add(getGenerativeQuestionsFeatureConfigMethodDescriptor);
    methodDescriptors.add(listGenerativeQuestionConfigsMethodDescriptor);
    methodDescriptors.add(updateGenerativeQuestionConfigMethodDescriptor);
    methodDescriptors.add(batchUpdateGenerativeQuestionConfigsMethodDescriptor);
    return methodDescriptors;
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
