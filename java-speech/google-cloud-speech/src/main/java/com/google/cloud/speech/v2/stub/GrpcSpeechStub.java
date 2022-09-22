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

package com.google.cloud.speech.v2.stub;

import static com.google.cloud.speech.v2.SpeechClient.ListCustomClassesPagedResponse;
import static com.google.cloud.speech.v2.SpeechClient.ListPhraseSetsPagedResponse;
import static com.google.cloud.speech.v2.SpeechClient.ListRecognizersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.speech.v2.BatchRecognizeRequest;
import com.google.cloud.speech.v2.BatchRecognizeResponse;
import com.google.cloud.speech.v2.Config;
import com.google.cloud.speech.v2.CreateCustomClassRequest;
import com.google.cloud.speech.v2.CreatePhraseSetRequest;
import com.google.cloud.speech.v2.CreateRecognizerRequest;
import com.google.cloud.speech.v2.CustomClass;
import com.google.cloud.speech.v2.DeleteCustomClassRequest;
import com.google.cloud.speech.v2.DeletePhraseSetRequest;
import com.google.cloud.speech.v2.DeleteRecognizerRequest;
import com.google.cloud.speech.v2.GetConfigRequest;
import com.google.cloud.speech.v2.GetCustomClassRequest;
import com.google.cloud.speech.v2.GetPhraseSetRequest;
import com.google.cloud.speech.v2.GetRecognizerRequest;
import com.google.cloud.speech.v2.ListCustomClassesRequest;
import com.google.cloud.speech.v2.ListCustomClassesResponse;
import com.google.cloud.speech.v2.ListPhraseSetsRequest;
import com.google.cloud.speech.v2.ListPhraseSetsResponse;
import com.google.cloud.speech.v2.ListRecognizersRequest;
import com.google.cloud.speech.v2.ListRecognizersResponse;
import com.google.cloud.speech.v2.OperationMetadata;
import com.google.cloud.speech.v2.PhraseSet;
import com.google.cloud.speech.v2.RecognizeRequest;
import com.google.cloud.speech.v2.RecognizeResponse;
import com.google.cloud.speech.v2.Recognizer;
import com.google.cloud.speech.v2.StreamingRecognizeRequest;
import com.google.cloud.speech.v2.StreamingRecognizeResponse;
import com.google.cloud.speech.v2.UndeleteCustomClassRequest;
import com.google.cloud.speech.v2.UndeletePhraseSetRequest;
import com.google.cloud.speech.v2.UndeleteRecognizerRequest;
import com.google.cloud.speech.v2.UpdateConfigRequest;
import com.google.cloud.speech.v2.UpdateCustomClassRequest;
import com.google.cloud.speech.v2.UpdatePhraseSetRequest;
import com.google.cloud.speech.v2.UpdateRecognizerRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Speech service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSpeechStub extends SpeechStub {
  private static final MethodDescriptor<CreateRecognizerRequest, Operation>
      createRecognizerMethodDescriptor =
          MethodDescriptor.<CreateRecognizerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/CreateRecognizer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRecognizerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRecognizersRequest, ListRecognizersResponse>
      listRecognizersMethodDescriptor =
          MethodDescriptor.<ListRecognizersRequest, ListRecognizersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/ListRecognizers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRecognizersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRecognizersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRecognizerRequest, Recognizer>
      getRecognizerMethodDescriptor =
          MethodDescriptor.<GetRecognizerRequest, Recognizer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/GetRecognizer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRecognizerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Recognizer.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRecognizerRequest, Operation>
      updateRecognizerMethodDescriptor =
          MethodDescriptor.<UpdateRecognizerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/UpdateRecognizer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRecognizerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRecognizerRequest, Operation>
      deleteRecognizerMethodDescriptor =
          MethodDescriptor.<DeleteRecognizerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/DeleteRecognizer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRecognizerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeleteRecognizerRequest, Operation>
      undeleteRecognizerMethodDescriptor =
          MethodDescriptor.<UndeleteRecognizerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/UndeleteRecognizer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeleteRecognizerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RecognizeRequest, RecognizeResponse>
      recognizeMethodDescriptor =
          MethodDescriptor.<RecognizeRequest, RecognizeResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/Recognize")
              .setRequestMarshaller(ProtoUtils.marshaller(RecognizeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RecognizeResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeMethodDescriptor =
          MethodDescriptor.<StreamingRecognizeRequest, StreamingRecognizeResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.cloud.speech.v2.Speech/StreamingRecognize")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamingRecognizeRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamingRecognizeResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchRecognizeRequest, Operation>
      batchRecognizeMethodDescriptor =
          MethodDescriptor.<BatchRecognizeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/BatchRecognize")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchRecognizeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConfigRequest, Config> getConfigMethodDescriptor =
      MethodDescriptor.<GetConfigRequest, Config>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.speech.v2.Speech/GetConfig")
          .setRequestMarshaller(ProtoUtils.marshaller(GetConfigRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Config.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateConfigRequest, Config> updateConfigMethodDescriptor =
      MethodDescriptor.<UpdateConfigRequest, Config>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.speech.v2.Speech/UpdateConfig")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateConfigRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Config.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateCustomClassRequest, Operation>
      createCustomClassMethodDescriptor =
          MethodDescriptor.<CreateCustomClassRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/CreateCustomClass")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCustomClassRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCustomClassesRequest, ListCustomClassesResponse>
      listCustomClassesMethodDescriptor =
          MethodDescriptor.<ListCustomClassesRequest, ListCustomClassesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/ListCustomClasses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCustomClassesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCustomClassesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCustomClassRequest, CustomClass>
      getCustomClassMethodDescriptor =
          MethodDescriptor.<GetCustomClassRequest, CustomClass>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/GetCustomClass")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCustomClassRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomClass.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCustomClassRequest, Operation>
      updateCustomClassMethodDescriptor =
          MethodDescriptor.<UpdateCustomClassRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/UpdateCustomClass")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCustomClassRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCustomClassRequest, Operation>
      deleteCustomClassMethodDescriptor =
          MethodDescriptor.<DeleteCustomClassRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/DeleteCustomClass")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCustomClassRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeleteCustomClassRequest, Operation>
      undeleteCustomClassMethodDescriptor =
          MethodDescriptor.<UndeleteCustomClassRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/UndeleteCustomClass")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeleteCustomClassRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreatePhraseSetRequest, Operation>
      createPhraseSetMethodDescriptor =
          MethodDescriptor.<CreatePhraseSetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/CreatePhraseSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePhraseSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPhraseSetsRequest, ListPhraseSetsResponse>
      listPhraseSetsMethodDescriptor =
          MethodDescriptor.<ListPhraseSetsRequest, ListPhraseSetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/ListPhraseSets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPhraseSetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPhraseSetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPhraseSetRequest, PhraseSet>
      getPhraseSetMethodDescriptor =
          MethodDescriptor.<GetPhraseSetRequest, PhraseSet>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/GetPhraseSet")
              .setRequestMarshaller(ProtoUtils.marshaller(GetPhraseSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PhraseSet.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePhraseSetRequest, Operation>
      updatePhraseSetMethodDescriptor =
          MethodDescriptor.<UpdatePhraseSetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/UpdatePhraseSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePhraseSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePhraseSetRequest, Operation>
      deletePhraseSetMethodDescriptor =
          MethodDescriptor.<DeletePhraseSetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/DeletePhraseSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePhraseSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeletePhraseSetRequest, Operation>
      undeletePhraseSetMethodDescriptor =
          MethodDescriptor.<UndeletePhraseSetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.speech.v2.Speech/UndeletePhraseSet")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeletePhraseSetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateRecognizerRequest, Operation> createRecognizerCallable;
  private final OperationCallable<CreateRecognizerRequest, Recognizer, OperationMetadata>
      createRecognizerOperationCallable;
  private final UnaryCallable<ListRecognizersRequest, ListRecognizersResponse>
      listRecognizersCallable;
  private final UnaryCallable<ListRecognizersRequest, ListRecognizersPagedResponse>
      listRecognizersPagedCallable;
  private final UnaryCallable<GetRecognizerRequest, Recognizer> getRecognizerCallable;
  private final UnaryCallable<UpdateRecognizerRequest, Operation> updateRecognizerCallable;
  private final OperationCallable<UpdateRecognizerRequest, Recognizer, OperationMetadata>
      updateRecognizerOperationCallable;
  private final UnaryCallable<DeleteRecognizerRequest, Operation> deleteRecognizerCallable;
  private final OperationCallable<DeleteRecognizerRequest, Recognizer, OperationMetadata>
      deleteRecognizerOperationCallable;
  private final UnaryCallable<UndeleteRecognizerRequest, Operation> undeleteRecognizerCallable;
  private final OperationCallable<UndeleteRecognizerRequest, Recognizer, OperationMetadata>
      undeleteRecognizerOperationCallable;
  private final UnaryCallable<RecognizeRequest, RecognizeResponse> recognizeCallable;
  private final BidiStreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeCallable;
  private final UnaryCallable<BatchRecognizeRequest, Operation> batchRecognizeCallable;
  private final OperationCallable<BatchRecognizeRequest, BatchRecognizeResponse, OperationMetadata>
      batchRecognizeOperationCallable;
  private final UnaryCallable<GetConfigRequest, Config> getConfigCallable;
  private final UnaryCallable<UpdateConfigRequest, Config> updateConfigCallable;
  private final UnaryCallable<CreateCustomClassRequest, Operation> createCustomClassCallable;
  private final OperationCallable<CreateCustomClassRequest, CustomClass, OperationMetadata>
      createCustomClassOperationCallable;
  private final UnaryCallable<ListCustomClassesRequest, ListCustomClassesResponse>
      listCustomClassesCallable;
  private final UnaryCallable<ListCustomClassesRequest, ListCustomClassesPagedResponse>
      listCustomClassesPagedCallable;
  private final UnaryCallable<GetCustomClassRequest, CustomClass> getCustomClassCallable;
  private final UnaryCallable<UpdateCustomClassRequest, Operation> updateCustomClassCallable;
  private final OperationCallable<UpdateCustomClassRequest, CustomClass, OperationMetadata>
      updateCustomClassOperationCallable;
  private final UnaryCallable<DeleteCustomClassRequest, Operation> deleteCustomClassCallable;
  private final OperationCallable<DeleteCustomClassRequest, CustomClass, OperationMetadata>
      deleteCustomClassOperationCallable;
  private final UnaryCallable<UndeleteCustomClassRequest, Operation> undeleteCustomClassCallable;
  private final OperationCallable<UndeleteCustomClassRequest, CustomClass, OperationMetadata>
      undeleteCustomClassOperationCallable;
  private final UnaryCallable<CreatePhraseSetRequest, Operation> createPhraseSetCallable;
  private final OperationCallable<CreatePhraseSetRequest, PhraseSet, OperationMetadata>
      createPhraseSetOperationCallable;
  private final UnaryCallable<ListPhraseSetsRequest, ListPhraseSetsResponse> listPhraseSetsCallable;
  private final UnaryCallable<ListPhraseSetsRequest, ListPhraseSetsPagedResponse>
      listPhraseSetsPagedCallable;
  private final UnaryCallable<GetPhraseSetRequest, PhraseSet> getPhraseSetCallable;
  private final UnaryCallable<UpdatePhraseSetRequest, Operation> updatePhraseSetCallable;
  private final OperationCallable<UpdatePhraseSetRequest, PhraseSet, OperationMetadata>
      updatePhraseSetOperationCallable;
  private final UnaryCallable<DeletePhraseSetRequest, Operation> deletePhraseSetCallable;
  private final OperationCallable<DeletePhraseSetRequest, PhraseSet, OperationMetadata>
      deletePhraseSetOperationCallable;
  private final UnaryCallable<UndeletePhraseSetRequest, Operation> undeletePhraseSetCallable;
  private final OperationCallable<UndeletePhraseSetRequest, PhraseSet, OperationMetadata>
      undeletePhraseSetOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSpeechStub create(SpeechStubSettings settings) throws IOException {
    return new GrpcSpeechStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSpeechStub create(ClientContext clientContext) throws IOException {
    return new GrpcSpeechStub(SpeechStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSpeechStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSpeechStub(
        SpeechStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSpeechStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcSpeechStub(SpeechStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSpeechCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSpeechStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcSpeechStub(
      SpeechStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateRecognizerRequest, Operation> createRecognizerTransportSettings =
        GrpcCallSettings.<CreateRecognizerRequest, Operation>newBuilder()
            .setMethodDescriptor(createRecognizerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListRecognizersRequest, ListRecognizersResponse>
        listRecognizersTransportSettings =
            GrpcCallSettings.<ListRecognizersRequest, ListRecognizersResponse>newBuilder()
                .setMethodDescriptor(listRecognizersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetRecognizerRequest, Recognizer> getRecognizerTransportSettings =
        GrpcCallSettings.<GetRecognizerRequest, Recognizer>newBuilder()
            .setMethodDescriptor(getRecognizerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateRecognizerRequest, Operation> updateRecognizerTransportSettings =
        GrpcCallSettings.<UpdateRecognizerRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRecognizerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("recognizer.name", String.valueOf(request.getRecognizer().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteRecognizerRequest, Operation> deleteRecognizerTransportSettings =
        GrpcCallSettings.<DeleteRecognizerRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRecognizerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeleteRecognizerRequest, Operation> undeleteRecognizerTransportSettings =
        GrpcCallSettings.<UndeleteRecognizerRequest, Operation>newBuilder()
            .setMethodDescriptor(undeleteRecognizerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RecognizeRequest, RecognizeResponse> recognizeTransportSettings =
        GrpcCallSettings.<RecognizeRequest, RecognizeResponse>newBuilder()
            .setMethodDescriptor(recognizeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("recognizer", String.valueOf(request.getRecognizer()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StreamingRecognizeRequest, StreamingRecognizeResponse>
        streamingRecognizeTransportSettings =
            GrpcCallSettings.<StreamingRecognizeRequest, StreamingRecognizeResponse>newBuilder()
                .setMethodDescriptor(streamingRecognizeMethodDescriptor)
                .build();
    GrpcCallSettings<BatchRecognizeRequest, Operation> batchRecognizeTransportSettings =
        GrpcCallSettings.<BatchRecognizeRequest, Operation>newBuilder()
            .setMethodDescriptor(batchRecognizeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("recognizer", String.valueOf(request.getRecognizer()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetConfigRequest, Config> getConfigTransportSettings =
        GrpcCallSettings.<GetConfigRequest, Config>newBuilder()
            .setMethodDescriptor(getConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateConfigRequest, Config> updateConfigTransportSettings =
        GrpcCallSettings.<UpdateConfigRequest, Config>newBuilder()
            .setMethodDescriptor(updateConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("config.name", String.valueOf(request.getConfig().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateCustomClassRequest, Operation> createCustomClassTransportSettings =
        GrpcCallSettings.<CreateCustomClassRequest, Operation>newBuilder()
            .setMethodDescriptor(createCustomClassMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListCustomClassesRequest, ListCustomClassesResponse>
        listCustomClassesTransportSettings =
            GrpcCallSettings.<ListCustomClassesRequest, ListCustomClassesResponse>newBuilder()
                .setMethodDescriptor(listCustomClassesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetCustomClassRequest, CustomClass> getCustomClassTransportSettings =
        GrpcCallSettings.<GetCustomClassRequest, CustomClass>newBuilder()
            .setMethodDescriptor(getCustomClassMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateCustomClassRequest, Operation> updateCustomClassTransportSettings =
        GrpcCallSettings.<UpdateCustomClassRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCustomClassMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "custom_class.name", String.valueOf(request.getCustomClass().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteCustomClassRequest, Operation> deleteCustomClassTransportSettings =
        GrpcCallSettings.<DeleteCustomClassRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCustomClassMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeleteCustomClassRequest, Operation> undeleteCustomClassTransportSettings =
        GrpcCallSettings.<UndeleteCustomClassRequest, Operation>newBuilder()
            .setMethodDescriptor(undeleteCustomClassMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreatePhraseSetRequest, Operation> createPhraseSetTransportSettings =
        GrpcCallSettings.<CreatePhraseSetRequest, Operation>newBuilder()
            .setMethodDescriptor(createPhraseSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListPhraseSetsRequest, ListPhraseSetsResponse>
        listPhraseSetsTransportSettings =
            GrpcCallSettings.<ListPhraseSetsRequest, ListPhraseSetsResponse>newBuilder()
                .setMethodDescriptor(listPhraseSetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetPhraseSetRequest, PhraseSet> getPhraseSetTransportSettings =
        GrpcCallSettings.<GetPhraseSetRequest, PhraseSet>newBuilder()
            .setMethodDescriptor(getPhraseSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdatePhraseSetRequest, Operation> updatePhraseSetTransportSettings =
        GrpcCallSettings.<UpdatePhraseSetRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePhraseSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("phrase_set.name", String.valueOf(request.getPhraseSet().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeletePhraseSetRequest, Operation> deletePhraseSetTransportSettings =
        GrpcCallSettings.<DeletePhraseSetRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePhraseSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeletePhraseSetRequest, Operation> undeletePhraseSetTransportSettings =
        GrpcCallSettings.<UndeletePhraseSetRequest, Operation>newBuilder()
            .setMethodDescriptor(undeletePhraseSetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.createRecognizerCallable =
        callableFactory.createUnaryCallable(
            createRecognizerTransportSettings, settings.createRecognizerSettings(), clientContext);
    this.createRecognizerOperationCallable =
        callableFactory.createOperationCallable(
            createRecognizerTransportSettings,
            settings.createRecognizerOperationSettings(),
            clientContext,
            operationsStub);
    this.listRecognizersCallable =
        callableFactory.createUnaryCallable(
            listRecognizersTransportSettings, settings.listRecognizersSettings(), clientContext);
    this.listRecognizersPagedCallable =
        callableFactory.createPagedCallable(
            listRecognizersTransportSettings, settings.listRecognizersSettings(), clientContext);
    this.getRecognizerCallable =
        callableFactory.createUnaryCallable(
            getRecognizerTransportSettings, settings.getRecognizerSettings(), clientContext);
    this.updateRecognizerCallable =
        callableFactory.createUnaryCallable(
            updateRecognizerTransportSettings, settings.updateRecognizerSettings(), clientContext);
    this.updateRecognizerOperationCallable =
        callableFactory.createOperationCallable(
            updateRecognizerTransportSettings,
            settings.updateRecognizerOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteRecognizerCallable =
        callableFactory.createUnaryCallable(
            deleteRecognizerTransportSettings, settings.deleteRecognizerSettings(), clientContext);
    this.deleteRecognizerOperationCallable =
        callableFactory.createOperationCallable(
            deleteRecognizerTransportSettings,
            settings.deleteRecognizerOperationSettings(),
            clientContext,
            operationsStub);
    this.undeleteRecognizerCallable =
        callableFactory.createUnaryCallable(
            undeleteRecognizerTransportSettings,
            settings.undeleteRecognizerSettings(),
            clientContext);
    this.undeleteRecognizerOperationCallable =
        callableFactory.createOperationCallable(
            undeleteRecognizerTransportSettings,
            settings.undeleteRecognizerOperationSettings(),
            clientContext,
            operationsStub);
    this.recognizeCallable =
        callableFactory.createUnaryCallable(
            recognizeTransportSettings, settings.recognizeSettings(), clientContext);
    this.streamingRecognizeCallable =
        callableFactory.createBidiStreamingCallable(
            streamingRecognizeTransportSettings,
            settings.streamingRecognizeSettings(),
            clientContext);
    this.batchRecognizeCallable =
        callableFactory.createUnaryCallable(
            batchRecognizeTransportSettings, settings.batchRecognizeSettings(), clientContext);
    this.batchRecognizeOperationCallable =
        callableFactory.createOperationCallable(
            batchRecognizeTransportSettings,
            settings.batchRecognizeOperationSettings(),
            clientContext,
            operationsStub);
    this.getConfigCallable =
        callableFactory.createUnaryCallable(
            getConfigTransportSettings, settings.getConfigSettings(), clientContext);
    this.updateConfigCallable =
        callableFactory.createUnaryCallable(
            updateConfigTransportSettings, settings.updateConfigSettings(), clientContext);
    this.createCustomClassCallable =
        callableFactory.createUnaryCallable(
            createCustomClassTransportSettings,
            settings.createCustomClassSettings(),
            clientContext);
    this.createCustomClassOperationCallable =
        callableFactory.createOperationCallable(
            createCustomClassTransportSettings,
            settings.createCustomClassOperationSettings(),
            clientContext,
            operationsStub);
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
    this.getCustomClassCallable =
        callableFactory.createUnaryCallable(
            getCustomClassTransportSettings, settings.getCustomClassSettings(), clientContext);
    this.updateCustomClassCallable =
        callableFactory.createUnaryCallable(
            updateCustomClassTransportSettings,
            settings.updateCustomClassSettings(),
            clientContext);
    this.updateCustomClassOperationCallable =
        callableFactory.createOperationCallable(
            updateCustomClassTransportSettings,
            settings.updateCustomClassOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCustomClassCallable =
        callableFactory.createUnaryCallable(
            deleteCustomClassTransportSettings,
            settings.deleteCustomClassSettings(),
            clientContext);
    this.deleteCustomClassOperationCallable =
        callableFactory.createOperationCallable(
            deleteCustomClassTransportSettings,
            settings.deleteCustomClassOperationSettings(),
            clientContext,
            operationsStub);
    this.undeleteCustomClassCallable =
        callableFactory.createUnaryCallable(
            undeleteCustomClassTransportSettings,
            settings.undeleteCustomClassSettings(),
            clientContext);
    this.undeleteCustomClassOperationCallable =
        callableFactory.createOperationCallable(
            undeleteCustomClassTransportSettings,
            settings.undeleteCustomClassOperationSettings(),
            clientContext,
            operationsStub);
    this.createPhraseSetCallable =
        callableFactory.createUnaryCallable(
            createPhraseSetTransportSettings, settings.createPhraseSetSettings(), clientContext);
    this.createPhraseSetOperationCallable =
        callableFactory.createOperationCallable(
            createPhraseSetTransportSettings,
            settings.createPhraseSetOperationSettings(),
            clientContext,
            operationsStub);
    this.listPhraseSetsCallable =
        callableFactory.createUnaryCallable(
            listPhraseSetsTransportSettings, settings.listPhraseSetsSettings(), clientContext);
    this.listPhraseSetsPagedCallable =
        callableFactory.createPagedCallable(
            listPhraseSetsTransportSettings, settings.listPhraseSetsSettings(), clientContext);
    this.getPhraseSetCallable =
        callableFactory.createUnaryCallable(
            getPhraseSetTransportSettings, settings.getPhraseSetSettings(), clientContext);
    this.updatePhraseSetCallable =
        callableFactory.createUnaryCallable(
            updatePhraseSetTransportSettings, settings.updatePhraseSetSettings(), clientContext);
    this.updatePhraseSetOperationCallable =
        callableFactory.createOperationCallable(
            updatePhraseSetTransportSettings,
            settings.updatePhraseSetOperationSettings(),
            clientContext,
            operationsStub);
    this.deletePhraseSetCallable =
        callableFactory.createUnaryCallable(
            deletePhraseSetTransportSettings, settings.deletePhraseSetSettings(), clientContext);
    this.deletePhraseSetOperationCallable =
        callableFactory.createOperationCallable(
            deletePhraseSetTransportSettings,
            settings.deletePhraseSetOperationSettings(),
            clientContext,
            operationsStub);
    this.undeletePhraseSetCallable =
        callableFactory.createUnaryCallable(
            undeletePhraseSetTransportSettings,
            settings.undeletePhraseSetSettings(),
            clientContext);
    this.undeletePhraseSetOperationCallable =
        callableFactory.createOperationCallable(
            undeletePhraseSetTransportSettings,
            settings.undeletePhraseSetOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateRecognizerRequest, Operation> createRecognizerCallable() {
    return createRecognizerCallable;
  }

  @Override
  public OperationCallable<CreateRecognizerRequest, Recognizer, OperationMetadata>
      createRecognizerOperationCallable() {
    return createRecognizerOperationCallable;
  }

  @Override
  public UnaryCallable<ListRecognizersRequest, ListRecognizersResponse> listRecognizersCallable() {
    return listRecognizersCallable;
  }

  @Override
  public UnaryCallable<ListRecognizersRequest, ListRecognizersPagedResponse>
      listRecognizersPagedCallable() {
    return listRecognizersPagedCallable;
  }

  @Override
  public UnaryCallable<GetRecognizerRequest, Recognizer> getRecognizerCallable() {
    return getRecognizerCallable;
  }

  @Override
  public UnaryCallable<UpdateRecognizerRequest, Operation> updateRecognizerCallable() {
    return updateRecognizerCallable;
  }

  @Override
  public OperationCallable<UpdateRecognizerRequest, Recognizer, OperationMetadata>
      updateRecognizerOperationCallable() {
    return updateRecognizerOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRecognizerRequest, Operation> deleteRecognizerCallable() {
    return deleteRecognizerCallable;
  }

  @Override
  public OperationCallable<DeleteRecognizerRequest, Recognizer, OperationMetadata>
      deleteRecognizerOperationCallable() {
    return deleteRecognizerOperationCallable;
  }

  @Override
  public UnaryCallable<UndeleteRecognizerRequest, Operation> undeleteRecognizerCallable() {
    return undeleteRecognizerCallable;
  }

  @Override
  public OperationCallable<UndeleteRecognizerRequest, Recognizer, OperationMetadata>
      undeleteRecognizerOperationCallable() {
    return undeleteRecognizerOperationCallable;
  }

  @Override
  public UnaryCallable<RecognizeRequest, RecognizeResponse> recognizeCallable() {
    return recognizeCallable;
  }

  @Override
  public BidiStreamingCallable<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeCallable() {
    return streamingRecognizeCallable;
  }

  @Override
  public UnaryCallable<BatchRecognizeRequest, Operation> batchRecognizeCallable() {
    return batchRecognizeCallable;
  }

  @Override
  public OperationCallable<BatchRecognizeRequest, BatchRecognizeResponse, OperationMetadata>
      batchRecognizeOperationCallable() {
    return batchRecognizeOperationCallable;
  }

  @Override
  public UnaryCallable<GetConfigRequest, Config> getConfigCallable() {
    return getConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateConfigRequest, Config> updateConfigCallable() {
    return updateConfigCallable;
  }

  @Override
  public UnaryCallable<CreateCustomClassRequest, Operation> createCustomClassCallable() {
    return createCustomClassCallable;
  }

  @Override
  public OperationCallable<CreateCustomClassRequest, CustomClass, OperationMetadata>
      createCustomClassOperationCallable() {
    return createCustomClassOperationCallable;
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
  public UnaryCallable<GetCustomClassRequest, CustomClass> getCustomClassCallable() {
    return getCustomClassCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomClassRequest, Operation> updateCustomClassCallable() {
    return updateCustomClassCallable;
  }

  @Override
  public OperationCallable<UpdateCustomClassRequest, CustomClass, OperationMetadata>
      updateCustomClassOperationCallable() {
    return updateCustomClassOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCustomClassRequest, Operation> deleteCustomClassCallable() {
    return deleteCustomClassCallable;
  }

  @Override
  public OperationCallable<DeleteCustomClassRequest, CustomClass, OperationMetadata>
      deleteCustomClassOperationCallable() {
    return deleteCustomClassOperationCallable;
  }

  @Override
  public UnaryCallable<UndeleteCustomClassRequest, Operation> undeleteCustomClassCallable() {
    return undeleteCustomClassCallable;
  }

  @Override
  public OperationCallable<UndeleteCustomClassRequest, CustomClass, OperationMetadata>
      undeleteCustomClassOperationCallable() {
    return undeleteCustomClassOperationCallable;
  }

  @Override
  public UnaryCallable<CreatePhraseSetRequest, Operation> createPhraseSetCallable() {
    return createPhraseSetCallable;
  }

  @Override
  public OperationCallable<CreatePhraseSetRequest, PhraseSet, OperationMetadata>
      createPhraseSetOperationCallable() {
    return createPhraseSetOperationCallable;
  }

  @Override
  public UnaryCallable<ListPhraseSetsRequest, ListPhraseSetsResponse> listPhraseSetsCallable() {
    return listPhraseSetsCallable;
  }

  @Override
  public UnaryCallable<ListPhraseSetsRequest, ListPhraseSetsPagedResponse>
      listPhraseSetsPagedCallable() {
    return listPhraseSetsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPhraseSetRequest, PhraseSet> getPhraseSetCallable() {
    return getPhraseSetCallable;
  }

  @Override
  public UnaryCallable<UpdatePhraseSetRequest, Operation> updatePhraseSetCallable() {
    return updatePhraseSetCallable;
  }

  @Override
  public OperationCallable<UpdatePhraseSetRequest, PhraseSet, OperationMetadata>
      updatePhraseSetOperationCallable() {
    return updatePhraseSetOperationCallable;
  }

  @Override
  public UnaryCallable<DeletePhraseSetRequest, Operation> deletePhraseSetCallable() {
    return deletePhraseSetCallable;
  }

  @Override
  public OperationCallable<DeletePhraseSetRequest, PhraseSet, OperationMetadata>
      deletePhraseSetOperationCallable() {
    return deletePhraseSetOperationCallable;
  }

  @Override
  public UnaryCallable<UndeletePhraseSetRequest, Operation> undeletePhraseSetCallable() {
    return undeletePhraseSetCallable;
  }

  @Override
  public OperationCallable<UndeletePhraseSetRequest, PhraseSet, OperationMetadata>
      undeletePhraseSetOperationCallable() {
    return undeletePhraseSetOperationCallable;
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
