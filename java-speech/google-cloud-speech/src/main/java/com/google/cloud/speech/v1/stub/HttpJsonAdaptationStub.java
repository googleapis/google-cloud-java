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

package com.google.cloud.speech.v1.stub;

import static com.google.cloud.speech.v1.AdaptationClient.ListCustomClassesPagedResponse;
import static com.google.cloud.speech.v1.AdaptationClient.ListPhraseSetPagedResponse;

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
import com.google.cloud.speech.v1.CreateCustomClassRequest;
import com.google.cloud.speech.v1.CreatePhraseSetRequest;
import com.google.cloud.speech.v1.CustomClass;
import com.google.cloud.speech.v1.DeleteCustomClassRequest;
import com.google.cloud.speech.v1.DeletePhraseSetRequest;
import com.google.cloud.speech.v1.GetCustomClassRequest;
import com.google.cloud.speech.v1.GetPhraseSetRequest;
import com.google.cloud.speech.v1.ListCustomClassesRequest;
import com.google.cloud.speech.v1.ListCustomClassesResponse;
import com.google.cloud.speech.v1.ListPhraseSetRequest;
import com.google.cloud.speech.v1.ListPhraseSetResponse;
import com.google.cloud.speech.v1.PhraseSet;
import com.google.cloud.speech.v1.UpdateCustomClassRequest;
import com.google.cloud.speech.v1.UpdatePhraseSetRequest;
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
 * REST stub implementation for the Adaptation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAdaptationStub extends AdaptationStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreatePhraseSetRequest, PhraseSet>
      createPhraseSetMethodDescriptor =
          ApiMethodDescriptor.<CreatePhraseSetRequest, PhraseSet>newBuilder()
              .setFullMethodName("google.cloud.speech.v1.Adaptation/CreatePhraseSet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePhraseSetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/phraseSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePhraseSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePhraseSetRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PhraseSet>newBuilder()
                      .setDefaultInstance(PhraseSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPhraseSetRequest, PhraseSet>
      getPhraseSetMethodDescriptor =
          ApiMethodDescriptor.<GetPhraseSetRequest, PhraseSet>newBuilder()
              .setFullMethodName("google.cloud.speech.v1.Adaptation/GetPhraseSet")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPhraseSetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/phraseSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPhraseSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPhraseSetRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PhraseSet>newBuilder()
                      .setDefaultInstance(PhraseSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPhraseSetRequest, ListPhraseSetResponse>
      listPhraseSetMethodDescriptor =
          ApiMethodDescriptor.<ListPhraseSetRequest, ListPhraseSetResponse>newBuilder()
              .setFullMethodName("google.cloud.speech.v1.Adaptation/ListPhraseSet")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPhraseSetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/phraseSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPhraseSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPhraseSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPhraseSetResponse>newBuilder()
                      .setDefaultInstance(ListPhraseSetResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePhraseSetRequest, PhraseSet>
      updatePhraseSetMethodDescriptor =
          ApiMethodDescriptor.<UpdatePhraseSetRequest, PhraseSet>newBuilder()
              .setFullMethodName("google.cloud.speech.v1.Adaptation/UpdatePhraseSet")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePhraseSetRequest>newBuilder()
                      .setPath(
                          "/v1/{phraseSet.name=projects/*/locations/*/phraseSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePhraseSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "phraseSet.name", request.getPhraseSet().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePhraseSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("phraseSet", request.getPhraseSet(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PhraseSet>newBuilder()
                      .setDefaultInstance(PhraseSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePhraseSetRequest, Empty>
      deletePhraseSetMethodDescriptor =
          ApiMethodDescriptor.<DeletePhraseSetRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.speech.v1.Adaptation/DeletePhraseSet")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePhraseSetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/phraseSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePhraseSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePhraseSetRequest> serializer =
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

  private static final ApiMethodDescriptor<CreateCustomClassRequest, CustomClass>
      createCustomClassMethodDescriptor =
          ApiMethodDescriptor.<CreateCustomClassRequest, CustomClass>newBuilder()
              .setFullMethodName("google.cloud.speech.v1.Adaptation/CreateCustomClass")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomClassRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/customClasses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomClassRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomClassRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomClass>newBuilder()
                      .setDefaultInstance(CustomClass.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCustomClassRequest, CustomClass>
      getCustomClassMethodDescriptor =
          ApiMethodDescriptor.<GetCustomClassRequest, CustomClass>newBuilder()
              .setFullMethodName("google.cloud.speech.v1.Adaptation/GetCustomClass")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomClassRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/customClasses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomClassRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomClassRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomClass>newBuilder()
                      .setDefaultInstance(CustomClass.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCustomClassesRequest, ListCustomClassesResponse>
      listCustomClassesMethodDescriptor =
          ApiMethodDescriptor.<ListCustomClassesRequest, ListCustomClassesResponse>newBuilder()
              .setFullMethodName("google.cloud.speech.v1.Adaptation/ListCustomClasses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomClassesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/customClasses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomClassesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomClassesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCustomClassesResponse>newBuilder()
                      .setDefaultInstance(ListCustomClassesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCustomClassRequest, CustomClass>
      updateCustomClassMethodDescriptor =
          ApiMethodDescriptor.<UpdateCustomClassRequest, CustomClass>newBuilder()
              .setFullMethodName("google.cloud.speech.v1.Adaptation/UpdateCustomClass")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomClassRequest>newBuilder()
                      .setPath(
                          "/v1/{customClass.name=projects/*/locations/*/customClasses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomClassRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "customClass.name", request.getCustomClass().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomClassRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customClass", request.getCustomClass(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomClass>newBuilder()
                      .setDefaultInstance(CustomClass.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCustomClassRequest, Empty>
      deleteCustomClassMethodDescriptor =
          ApiMethodDescriptor.<DeleteCustomClassRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.speech.v1.Adaptation/DeleteCustomClass")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCustomClassRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/customClasses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCustomClassRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCustomClassRequest> serializer =
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

  private final UnaryCallable<CreatePhraseSetRequest, PhraseSet> createPhraseSetCallable;
  private final UnaryCallable<GetPhraseSetRequest, PhraseSet> getPhraseSetCallable;
  private final UnaryCallable<ListPhraseSetRequest, ListPhraseSetResponse> listPhraseSetCallable;
  private final UnaryCallable<ListPhraseSetRequest, ListPhraseSetPagedResponse>
      listPhraseSetPagedCallable;
  private final UnaryCallable<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetCallable;
  private final UnaryCallable<DeletePhraseSetRequest, Empty> deletePhraseSetCallable;
  private final UnaryCallable<CreateCustomClassRequest, CustomClass> createCustomClassCallable;
  private final UnaryCallable<GetCustomClassRequest, CustomClass> getCustomClassCallable;
  private final UnaryCallable<ListCustomClassesRequest, ListCustomClassesResponse>
      listCustomClassesCallable;
  private final UnaryCallable<ListCustomClassesRequest, ListCustomClassesPagedResponse>
      listCustomClassesPagedCallable;
  private final UnaryCallable<UpdateCustomClassRequest, CustomClass> updateCustomClassCallable;
  private final UnaryCallable<DeleteCustomClassRequest, Empty> deleteCustomClassCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAdaptationStub create(AdaptationStubSettings settings)
      throws IOException {
    return new HttpJsonAdaptationStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAdaptationStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAdaptationStub(
        AdaptationStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAdaptationStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAdaptationStub(
        AdaptationStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAdaptationStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAdaptationStub(AdaptationStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAdaptationCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAdaptationStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAdaptationStub(
      AdaptationStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreatePhraseSetRequest, PhraseSet> createPhraseSetTransportSettings =
        HttpJsonCallSettings.<CreatePhraseSetRequest, PhraseSet>newBuilder()
            .setMethodDescriptor(createPhraseSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetPhraseSetRequest, PhraseSet> getPhraseSetTransportSettings =
        HttpJsonCallSettings.<GetPhraseSetRequest, PhraseSet>newBuilder()
            .setMethodDescriptor(getPhraseSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListPhraseSetRequest, ListPhraseSetResponse>
        listPhraseSetTransportSettings =
            HttpJsonCallSettings.<ListPhraseSetRequest, ListPhraseSetResponse>newBuilder()
                .setMethodDescriptor(listPhraseSetMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetTransportSettings =
        HttpJsonCallSettings.<UpdatePhraseSetRequest, PhraseSet>newBuilder()
            .setMethodDescriptor(updatePhraseSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeletePhraseSetRequest, Empty> deletePhraseSetTransportSettings =
        HttpJsonCallSettings.<DeletePhraseSetRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePhraseSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateCustomClassRequest, CustomClass> createCustomClassTransportSettings =
        HttpJsonCallSettings.<CreateCustomClassRequest, CustomClass>newBuilder()
            .setMethodDescriptor(createCustomClassMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetCustomClassRequest, CustomClass> getCustomClassTransportSettings =
        HttpJsonCallSettings.<GetCustomClassRequest, CustomClass>newBuilder()
            .setMethodDescriptor(getCustomClassMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListCustomClassesRequest, ListCustomClassesResponse>
        listCustomClassesTransportSettings =
            HttpJsonCallSettings.<ListCustomClassesRequest, ListCustomClassesResponse>newBuilder()
                .setMethodDescriptor(listCustomClassesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateCustomClassRequest, CustomClass> updateCustomClassTransportSettings =
        HttpJsonCallSettings.<UpdateCustomClassRequest, CustomClass>newBuilder()
            .setMethodDescriptor(updateCustomClassMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteCustomClassRequest, Empty> deleteCustomClassTransportSettings =
        HttpJsonCallSettings.<DeleteCustomClassRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCustomClassMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createPhraseSetCallable =
        callableFactory.createUnaryCallable(
            createPhraseSetTransportSettings, settings.createPhraseSetSettings(), clientContext);
    this.getPhraseSetCallable =
        callableFactory.createUnaryCallable(
            getPhraseSetTransportSettings, settings.getPhraseSetSettings(), clientContext);
    this.listPhraseSetCallable =
        callableFactory.createUnaryCallable(
            listPhraseSetTransportSettings, settings.listPhraseSetSettings(), clientContext);
    this.listPhraseSetPagedCallable =
        callableFactory.createPagedCallable(
            listPhraseSetTransportSettings, settings.listPhraseSetSettings(), clientContext);
    this.updatePhraseSetCallable =
        callableFactory.createUnaryCallable(
            updatePhraseSetTransportSettings, settings.updatePhraseSetSettings(), clientContext);
    this.deletePhraseSetCallable =
        callableFactory.createUnaryCallable(
            deletePhraseSetTransportSettings, settings.deletePhraseSetSettings(), clientContext);
    this.createCustomClassCallable =
        callableFactory.createUnaryCallable(
            createCustomClassTransportSettings,
            settings.createCustomClassSettings(),
            clientContext);
    this.getCustomClassCallable =
        callableFactory.createUnaryCallable(
            getCustomClassTransportSettings, settings.getCustomClassSettings(), clientContext);
    this.listCustomClassesCallable =
        callableFactory.createUnaryCallable(
            listCustomClassesTransportSettings,
            settings.listCustomClassesSettings(),
            clientContext);
    this.listCustomClassesPagedCallable =
        callableFactory.createPagedCallable(
            listCustomClassesTransportSettings,
            settings.listCustomClassesSettings(),
            clientContext);
    this.updateCustomClassCallable =
        callableFactory.createUnaryCallable(
            updateCustomClassTransportSettings,
            settings.updateCustomClassSettings(),
            clientContext);
    this.deleteCustomClassCallable =
        callableFactory.createUnaryCallable(
            deleteCustomClassTransportSettings,
            settings.deleteCustomClassSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createPhraseSetMethodDescriptor);
    methodDescriptors.add(getPhraseSetMethodDescriptor);
    methodDescriptors.add(listPhraseSetMethodDescriptor);
    methodDescriptors.add(updatePhraseSetMethodDescriptor);
    methodDescriptors.add(deletePhraseSetMethodDescriptor);
    methodDescriptors.add(createCustomClassMethodDescriptor);
    methodDescriptors.add(getCustomClassMethodDescriptor);
    methodDescriptors.add(listCustomClassesMethodDescriptor);
    methodDescriptors.add(updateCustomClassMethodDescriptor);
    methodDescriptors.add(deleteCustomClassMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreatePhraseSetRequest, PhraseSet> createPhraseSetCallable() {
    return createPhraseSetCallable;
  }

  @Override
  public UnaryCallable<GetPhraseSetRequest, PhraseSet> getPhraseSetCallable() {
    return getPhraseSetCallable;
  }

  @Override
  public UnaryCallable<ListPhraseSetRequest, ListPhraseSetResponse> listPhraseSetCallable() {
    return listPhraseSetCallable;
  }

  @Override
  public UnaryCallable<ListPhraseSetRequest, ListPhraseSetPagedResponse>
      listPhraseSetPagedCallable() {
    return listPhraseSetPagedCallable;
  }

  @Override
  public UnaryCallable<UpdatePhraseSetRequest, PhraseSet> updatePhraseSetCallable() {
    return updatePhraseSetCallable;
  }

  @Override
  public UnaryCallable<DeletePhraseSetRequest, Empty> deletePhraseSetCallable() {
    return deletePhraseSetCallable;
  }

  @Override
  public UnaryCallable<CreateCustomClassRequest, CustomClass> createCustomClassCallable() {
    return createCustomClassCallable;
  }

  @Override
  public UnaryCallable<GetCustomClassRequest, CustomClass> getCustomClassCallable() {
    return getCustomClassCallable;
  }

  @Override
  public UnaryCallable<ListCustomClassesRequest, ListCustomClassesResponse>
      listCustomClassesCallable() {
    return listCustomClassesCallable;
  }

  @Override
  public UnaryCallable<ListCustomClassesRequest, ListCustomClassesPagedResponse>
      listCustomClassesPagedCallable() {
    return listCustomClassesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomClassRequest, CustomClass> updateCustomClassCallable() {
    return updateCustomClassCallable;
  }

  @Override
  public UnaryCallable<DeleteCustomClassRequest, Empty> deleteCustomClassCallable() {
    return deleteCustomClassCallable;
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
