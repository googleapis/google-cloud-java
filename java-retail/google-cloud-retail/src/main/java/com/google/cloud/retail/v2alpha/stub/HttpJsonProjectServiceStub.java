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

package com.google.cloud.retail.v2alpha.stub;

import com.google.api.HttpRule;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.AcceptTermsRequest;
import com.google.cloud.retail.v2alpha.AlertConfig;
import com.google.cloud.retail.v2alpha.EnrollSolutionMetadata;
import com.google.cloud.retail.v2alpha.EnrollSolutionRequest;
import com.google.cloud.retail.v2alpha.EnrollSolutionResponse;
import com.google.cloud.retail.v2alpha.GetAlertConfigRequest;
import com.google.cloud.retail.v2alpha.GetLoggingConfigRequest;
import com.google.cloud.retail.v2alpha.GetProjectRequest;
import com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest;
import com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse;
import com.google.cloud.retail.v2alpha.LoggingConfig;
import com.google.cloud.retail.v2alpha.Project;
import com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest;
import com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the ProjectService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonProjectServiceStub extends ProjectServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(EnrollSolutionMetadata.getDescriptor())
          .add(EnrollSolutionResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetProjectRequest, Project> getProjectMethodDescriptor =
      ApiMethodDescriptor.<GetProjectRequest, Project>newBuilder()
          .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/GetProject")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetProjectRequest>newBuilder()
                  .setPath(
                      "/v2alpha/{name=projects/*/retailProject}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetProjectRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetProjectRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Project>newBuilder()
                  .setDefaultInstance(Project.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<AcceptTermsRequest, Project>
      acceptTermsMethodDescriptor =
          ApiMethodDescriptor.<AcceptTermsRequest, Project>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/AcceptTerms")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AcceptTermsRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{project=projects/*/retailProject}:acceptTerms",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AcceptTermsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AcceptTermsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProject().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Project>newBuilder()
                      .setDefaultInstance(Project.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EnrollSolutionRequest, Operation>
      enrollSolutionMethodDescriptor =
          ApiMethodDescriptor.<EnrollSolutionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/EnrollSolution")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnrollSolutionRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{project=projects/*}:enrollSolution",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnrollSolutionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnrollSolutionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearProject().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (EnrollSolutionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
      listEnrolledSolutionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/ListEnrolledSolutions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEnrolledSolutionsRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{parent=projects/*}:enrolledSolutions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEnrolledSolutionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEnrolledSolutionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEnrolledSolutionsResponse>newBuilder()
                      .setDefaultInstance(ListEnrolledSolutionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLoggingConfigRequest, LoggingConfig>
      getLoggingConfigMethodDescriptor =
          ApiMethodDescriptor.<GetLoggingConfigRequest, LoggingConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/GetLoggingConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLoggingConfigRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{name=projects/*/loggingConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLoggingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLoggingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LoggingConfig>newBuilder()
                      .setDefaultInstance(LoggingConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateLoggingConfigRequest, LoggingConfig>
      updateLoggingConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateLoggingConfigRequest, LoggingConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/UpdateLoggingConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateLoggingConfigRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{loggingConfig.name=projects/*/loggingConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLoggingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "loggingConfig.name", request.getLoggingConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateLoggingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("loggingConfig", request.getLoggingConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LoggingConfig>newBuilder()
                      .setDefaultInstance(LoggingConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAlertConfigRequest, AlertConfig>
      getAlertConfigMethodDescriptor =
          ApiMethodDescriptor.<GetAlertConfigRequest, AlertConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/GetAlertConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAlertConfigRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{name=projects/*/alertConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAlertConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAlertConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AlertConfig>newBuilder()
                      .setDefaultInstance(AlertConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAlertConfigRequest, AlertConfig>
      updateAlertConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateAlertConfigRequest, AlertConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ProjectService/UpdateAlertConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAlertConfigRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{alertConfig.name=projects/*/alertConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAlertConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "alertConfig.name", request.getAlertConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAlertConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("alertConfig", request.getAlertConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AlertConfig>newBuilder()
                      .setDefaultInstance(AlertConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetProjectRequest, Project> getProjectCallable;
  private final UnaryCallable<AcceptTermsRequest, Project> acceptTermsCallable;
  private final UnaryCallable<EnrollSolutionRequest, Operation> enrollSolutionCallable;
  private final OperationCallable<
          EnrollSolutionRequest, EnrollSolutionResponse, EnrollSolutionMetadata>
      enrollSolutionOperationCallable;
  private final UnaryCallable<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
      listEnrolledSolutionsCallable;
  private final UnaryCallable<GetLoggingConfigRequest, LoggingConfig> getLoggingConfigCallable;
  private final UnaryCallable<UpdateLoggingConfigRequest, LoggingConfig>
      updateLoggingConfigCallable;
  private final UnaryCallable<GetAlertConfigRequest, AlertConfig> getAlertConfigCallable;
  private final UnaryCallable<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProjectServiceStub create(ProjectServiceStubSettings settings)
      throws IOException {
    return new HttpJsonProjectServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProjectServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonProjectServiceStub(
        ProjectServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonProjectServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProjectServiceStub(
        ProjectServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProjectServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProjectServiceStub(
      ProjectServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonProjectServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProjectServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProjectServiceStub(
      ProjectServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet(
                            "/v2alpha/{name=projects/*/locations/*/catalogs/*/branches/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v2alpha/{name=projects/*/locations/*/catalogs/*/branches/*/places/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v2alpha/{name=projects/*/locations/*/catalogs/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v2alpha/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v2alpha/{name=projects/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v2alpha/{name=projects/*/locations/*/catalogs/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v2alpha/{name=projects/*/locations/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v2alpha/{name=projects/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<GetProjectRequest, Project> getProjectTransportSettings =
        HttpJsonCallSettings.<GetProjectRequest, Project>newBuilder()
            .setMethodDescriptor(getProjectMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<AcceptTermsRequest, Project> acceptTermsTransportSettings =
        HttpJsonCallSettings.<AcceptTermsRequest, Project>newBuilder()
            .setMethodDescriptor(acceptTermsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<EnrollSolutionRequest, Operation> enrollSolutionTransportSettings =
        HttpJsonCallSettings.<EnrollSolutionRequest, Operation>newBuilder()
            .setMethodDescriptor(enrollSolutionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
        listEnrolledSolutionsTransportSettings =
            HttpJsonCallSettings
                .<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>newBuilder()
                .setMethodDescriptor(listEnrolledSolutionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLoggingConfigRequest, LoggingConfig> getLoggingConfigTransportSettings =
        HttpJsonCallSettings.<GetLoggingConfigRequest, LoggingConfig>newBuilder()
            .setMethodDescriptor(getLoggingConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateLoggingConfigRequest, LoggingConfig>
        updateLoggingConfigTransportSettings =
            HttpJsonCallSettings.<UpdateLoggingConfigRequest, LoggingConfig>newBuilder()
                .setMethodDescriptor(updateLoggingConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "logging_config.name",
                          String.valueOf(request.getLoggingConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAlertConfigRequest, AlertConfig> getAlertConfigTransportSettings =
        HttpJsonCallSettings.<GetAlertConfigRequest, AlertConfig>newBuilder()
            .setMethodDescriptor(getAlertConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigTransportSettings =
        HttpJsonCallSettings.<UpdateAlertConfigRequest, AlertConfig>newBuilder()
            .setMethodDescriptor(updateAlertConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "alert_config.name", String.valueOf(request.getAlertConfig().getName()));
                  return builder.build();
                })
            .build();

    this.getProjectCallable =
        callableFactory.createUnaryCallable(
            getProjectTransportSettings, settings.getProjectSettings(), clientContext);
    this.acceptTermsCallable =
        callableFactory.createUnaryCallable(
            acceptTermsTransportSettings, settings.acceptTermsSettings(), clientContext);
    this.enrollSolutionCallable =
        callableFactory.createUnaryCallable(
            enrollSolutionTransportSettings, settings.enrollSolutionSettings(), clientContext);
    this.enrollSolutionOperationCallable =
        callableFactory.createOperationCallable(
            enrollSolutionTransportSettings,
            settings.enrollSolutionOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listEnrolledSolutionsCallable =
        callableFactory.createUnaryCallable(
            listEnrolledSolutionsTransportSettings,
            settings.listEnrolledSolutionsSettings(),
            clientContext);
    this.getLoggingConfigCallable =
        callableFactory.createUnaryCallable(
            getLoggingConfigTransportSettings, settings.getLoggingConfigSettings(), clientContext);
    this.updateLoggingConfigCallable =
        callableFactory.createUnaryCallable(
            updateLoggingConfigTransportSettings,
            settings.updateLoggingConfigSettings(),
            clientContext);
    this.getAlertConfigCallable =
        callableFactory.createUnaryCallable(
            getAlertConfigTransportSettings, settings.getAlertConfigSettings(), clientContext);
    this.updateAlertConfigCallable =
        callableFactory.createUnaryCallable(
            updateAlertConfigTransportSettings,
            settings.updateAlertConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getProjectMethodDescriptor);
    methodDescriptors.add(acceptTermsMethodDescriptor);
    methodDescriptors.add(enrollSolutionMethodDescriptor);
    methodDescriptors.add(listEnrolledSolutionsMethodDescriptor);
    methodDescriptors.add(getLoggingConfigMethodDescriptor);
    methodDescriptors.add(updateLoggingConfigMethodDescriptor);
    methodDescriptors.add(getAlertConfigMethodDescriptor);
    methodDescriptors.add(updateAlertConfigMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetProjectRequest, Project> getProjectCallable() {
    return getProjectCallable;
  }

  @Override
  public UnaryCallable<AcceptTermsRequest, Project> acceptTermsCallable() {
    return acceptTermsCallable;
  }

  @Override
  public UnaryCallable<EnrollSolutionRequest, Operation> enrollSolutionCallable() {
    return enrollSolutionCallable;
  }

  @Override
  public OperationCallable<EnrollSolutionRequest, EnrollSolutionResponse, EnrollSolutionMetadata>
      enrollSolutionOperationCallable() {
    return enrollSolutionOperationCallable;
  }

  @Override
  public UnaryCallable<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
      listEnrolledSolutionsCallable() {
    return listEnrolledSolutionsCallable;
  }

  @Override
  public UnaryCallable<GetLoggingConfigRequest, LoggingConfig> getLoggingConfigCallable() {
    return getLoggingConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateLoggingConfigRequest, LoggingConfig> updateLoggingConfigCallable() {
    return updateLoggingConfigCallable;
  }

  @Override
  public UnaryCallable<GetAlertConfigRequest, AlertConfig> getAlertConfigCallable() {
    return getAlertConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigCallable() {
    return updateAlertConfigCallable;
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
