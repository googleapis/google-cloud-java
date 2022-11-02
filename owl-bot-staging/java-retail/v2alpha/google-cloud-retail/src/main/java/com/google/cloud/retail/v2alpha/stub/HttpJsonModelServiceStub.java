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

package com.google.cloud.retail.v2alpha.stub;

import static com.google.cloud.retail.v2alpha.ModelServiceClient.ListModelsPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.CreateModelMetadata;
import com.google.cloud.retail.v2alpha.CreateModelRequest;
import com.google.cloud.retail.v2alpha.DeleteModelRequest;
import com.google.cloud.retail.v2alpha.ListModelsRequest;
import com.google.cloud.retail.v2alpha.ListModelsResponse;
import com.google.cloud.retail.v2alpha.Model;
import com.google.cloud.retail.v2alpha.PauseModelRequest;
import com.google.cloud.retail.v2alpha.ResumeModelRequest;
import com.google.cloud.retail.v2alpha.TuneModelMetadata;
import com.google.cloud.retail.v2alpha.TuneModelRequest;
import com.google.cloud.retail.v2alpha.TuneModelResponse;
import com.google.cloud.retail.v2alpha.UpdateModelRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the ModelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonModelServiceStub extends ModelServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(TuneModelMetadata.getDescriptor())
          .add(Model.getDescriptor())
          .add(TuneModelResponse.getDescriptor())
          .add(CreateModelMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateModelRequest, Operation>
      createModelMethodDescriptor =
          ApiMethodDescriptor.<CreateModelRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ModelService/CreateModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateModelRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{parent=projects/*/locations/*/catalogs/*}/models",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "dryRun", request.getDryRun());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("model", request.getModel(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<PauseModelRequest, Model> pauseModelMethodDescriptor =
      ApiMethodDescriptor.<PauseModelRequest, Model>newBuilder()
          .setFullMethodName("google.cloud.retail.v2alpha.ModelService/PauseModel")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PauseModelRequest>newBuilder()
                  .setPath(
                      "/v2alpha/{name=projects/*/locations/*/catalogs/*/models/*}:pause",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<PauseModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<PauseModelRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Model>newBuilder()
                  .setDefaultInstance(Model.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ResumeModelRequest, Model> resumeModelMethodDescriptor =
      ApiMethodDescriptor.<ResumeModelRequest, Model>newBuilder()
          .setFullMethodName("google.cloud.retail.v2alpha.ModelService/ResumeModel")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ResumeModelRequest>newBuilder()
                  .setPath(
                      "/v2alpha/{name=projects/*/locations/*/catalogs/*/models/*}:resume",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ResumeModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ResumeModelRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Model>newBuilder()
                  .setDefaultInstance(Model.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteModelRequest, Empty> deleteModelMethodDescriptor =
      ApiMethodDescriptor.<DeleteModelRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.retail.v2alpha.ModelService/DeleteModel")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteModelRequest>newBuilder()
                  .setPath(
                      "/v2alpha/{name=projects/*/locations/*/catalogs/*/models/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteModelRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListModelsRequest, ListModelsResponse>
      listModelsMethodDescriptor =
          ApiMethodDescriptor.<ListModelsRequest, ListModelsResponse>newBuilder()
              .setFullMethodName("google.cloud.retail.v2alpha.ModelService/ListModels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListModelsRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{parent=projects/*/locations/*/catalogs/*}/models",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListModelsResponse>newBuilder()
                      .setDefaultInstance(ListModelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateModelRequest, Model> updateModelMethodDescriptor =
      ApiMethodDescriptor.<UpdateModelRequest, Model>newBuilder()
          .setFullMethodName("google.cloud.retail.v2alpha.ModelService/UpdateModel")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateModelRequest>newBuilder()
                  .setPath(
                      "/v2alpha/{model.name=projects/*/locations/*/catalogs/*/models/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "model.name", request.getModel().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("model", request.getModel(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Model>newBuilder()
                  .setDefaultInstance(Model.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<TuneModelRequest, Operation> tuneModelMethodDescriptor =
      ApiMethodDescriptor.<TuneModelRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.retail.v2alpha.ModelService/TuneModel")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<TuneModelRequest>newBuilder()
                  .setPath(
                      "/v2alpha/{name=projects/*/locations/*/catalogs/*/models/*}:tune",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<TuneModelRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<TuneModelRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (TuneModelRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private final UnaryCallable<CreateModelRequest, Operation> createModelCallable;
  private final OperationCallable<CreateModelRequest, Model, CreateModelMetadata>
      createModelOperationCallable;
  private final UnaryCallable<PauseModelRequest, Model> pauseModelCallable;
  private final UnaryCallable<ResumeModelRequest, Model> resumeModelCallable;
  private final UnaryCallable<DeleteModelRequest, Empty> deleteModelCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable;
  private final UnaryCallable<UpdateModelRequest, Model> updateModelCallable;
  private final UnaryCallable<TuneModelRequest, Operation> tuneModelCallable;
  private final OperationCallable<TuneModelRequest, TuneModelResponse, TuneModelMetadata>
      tuneModelOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonModelServiceStub create(ModelServiceStubSettings settings)
      throws IOException {
    return new HttpJsonModelServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonModelServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonModelServiceStub(
        ModelServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonModelServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonModelServiceStub(
        ModelServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonModelServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonModelServiceStub(ModelServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonModelServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonModelServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonModelServiceStub(
      ModelServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateModelRequest, Operation> createModelTransportSettings =
        HttpJsonCallSettings.<CreateModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PauseModelRequest, Model> pauseModelTransportSettings =
        HttpJsonCallSettings.<PauseModelRequest, Model>newBuilder()
            .setMethodDescriptor(pauseModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ResumeModelRequest, Model> resumeModelTransportSettings =
        HttpJsonCallSettings.<ResumeModelRequest, Model>newBuilder()
            .setMethodDescriptor(resumeModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteModelRequest, Empty> deleteModelTransportSettings =
        HttpJsonCallSettings.<DeleteModelRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListModelsRequest, ListModelsResponse> listModelsTransportSettings =
        HttpJsonCallSettings.<ListModelsRequest, ListModelsResponse>newBuilder()
            .setMethodDescriptor(listModelsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateModelRequest, Model> updateModelTransportSettings =
        HttpJsonCallSettings.<UpdateModelRequest, Model>newBuilder()
            .setMethodDescriptor(updateModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TuneModelRequest, Operation> tuneModelTransportSettings =
        HttpJsonCallSettings.<TuneModelRequest, Operation>newBuilder()
            .setMethodDescriptor(tuneModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createModelCallable =
        callableFactory.createUnaryCallable(
            createModelTransportSettings, settings.createModelSettings(), clientContext);
    this.createModelOperationCallable =
        callableFactory.createOperationCallable(
            createModelTransportSettings,
            settings.createModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.pauseModelCallable =
        callableFactory.createUnaryCallable(
            pauseModelTransportSettings, settings.pauseModelSettings(), clientContext);
    this.resumeModelCallable =
        callableFactory.createUnaryCallable(
            resumeModelTransportSettings, settings.resumeModelSettings(), clientContext);
    this.deleteModelCallable =
        callableFactory.createUnaryCallable(
            deleteModelTransportSettings, settings.deleteModelSettings(), clientContext);
    this.listModelsCallable =
        callableFactory.createUnaryCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.listModelsPagedCallable =
        callableFactory.createPagedCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.updateModelCallable =
        callableFactory.createUnaryCallable(
            updateModelTransportSettings, settings.updateModelSettings(), clientContext);
    this.tuneModelCallable =
        callableFactory.createUnaryCallable(
            tuneModelTransportSettings, settings.tuneModelSettings(), clientContext);
    this.tuneModelOperationCallable =
        callableFactory.createOperationCallable(
            tuneModelTransportSettings,
            settings.tuneModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createModelMethodDescriptor);
    methodDescriptors.add(pauseModelMethodDescriptor);
    methodDescriptors.add(resumeModelMethodDescriptor);
    methodDescriptors.add(deleteModelMethodDescriptor);
    methodDescriptors.add(listModelsMethodDescriptor);
    methodDescriptors.add(updateModelMethodDescriptor);
    methodDescriptors.add(tuneModelMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateModelRequest, Operation> createModelCallable() {
    return createModelCallable;
  }

  @Override
  public OperationCallable<CreateModelRequest, Model, CreateModelMetadata>
      createModelOperationCallable() {
    return createModelOperationCallable;
  }

  @Override
  public UnaryCallable<PauseModelRequest, Model> pauseModelCallable() {
    return pauseModelCallable;
  }

  @Override
  public UnaryCallable<ResumeModelRequest, Model> resumeModelCallable() {
    return resumeModelCallable;
  }

  @Override
  public UnaryCallable<DeleteModelRequest, Empty> deleteModelCallable() {
    return deleteModelCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    return listModelsCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    return listModelsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateModelRequest, Model> updateModelCallable() {
    return updateModelCallable;
  }

  @Override
  public UnaryCallable<TuneModelRequest, Operation> tuneModelCallable() {
    return tuneModelCallable;
  }

  @Override
  public OperationCallable<TuneModelRequest, TuneModelResponse, TuneModelMetadata>
      tuneModelOperationCallable() {
    return tuneModelOperationCallable;
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
