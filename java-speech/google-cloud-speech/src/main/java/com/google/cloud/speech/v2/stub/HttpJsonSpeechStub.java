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
import com.google.cloud.speech.v2.UndeleteCustomClassRequest;
import com.google.cloud.speech.v2.UndeletePhraseSetRequest;
import com.google.cloud.speech.v2.UndeleteRecognizerRequest;
import com.google.cloud.speech.v2.UpdateConfigRequest;
import com.google.cloud.speech.v2.UpdateCustomClassRequest;
import com.google.cloud.speech.v2.UpdatePhraseSetRequest;
import com.google.cloud.speech.v2.UpdateRecognizerRequest;
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
 * REST stub implementation for the Speech service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonSpeechStub extends SpeechStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(OperationMetadata.getDescriptor())
          .add(CustomClass.getDescriptor())
          .add(Recognizer.getDescriptor())
          .add(PhraseSet.getDescriptor())
          .add(BatchRecognizeResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateRecognizerRequest, Operation>
      createRecognizerMethodDescriptor =
          ApiMethodDescriptor.<CreateRecognizerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/CreateRecognizer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRecognizerRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/recognizers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRecognizerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRecognizerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "recognizerId", request.getRecognizerId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("recognizer", request.getRecognizer(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateRecognizerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListRecognizersRequest, ListRecognizersResponse>
      listRecognizersMethodDescriptor =
          ApiMethodDescriptor.<ListRecognizersRequest, ListRecognizersResponse>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/ListRecognizers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRecognizersRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/recognizers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRecognizersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRecognizersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRecognizersResponse>newBuilder()
                      .setDefaultInstance(ListRecognizersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRecognizerRequest, Recognizer>
      getRecognizerMethodDescriptor =
          ApiMethodDescriptor.<GetRecognizerRequest, Recognizer>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/GetRecognizer")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRecognizerRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/recognizers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRecognizerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRecognizerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Recognizer>newBuilder()
                      .setDefaultInstance(Recognizer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRecognizerRequest, Operation>
      updateRecognizerMethodDescriptor =
          ApiMethodDescriptor.<UpdateRecognizerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/UpdateRecognizer")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRecognizerRequest>newBuilder()
                      .setPath(
                          "/v2/{recognizer.name=projects/*/locations/*/recognizers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRecognizerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "recognizer.name", request.getRecognizer().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRecognizerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("recognizer", request.getRecognizer(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateRecognizerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteRecognizerRequest, Operation>
      deleteRecognizerMethodDescriptor =
          ApiMethodDescriptor.<DeleteRecognizerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/DeleteRecognizer")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRecognizerRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/recognizers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRecognizerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRecognizerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteRecognizerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UndeleteRecognizerRequest, Operation>
      undeleteRecognizerMethodDescriptor =
          ApiMethodDescriptor.<UndeleteRecognizerRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/UndeleteRecognizer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeleteRecognizerRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/recognizers/*}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteRecognizerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteRecognizerRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UndeleteRecognizerRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RecognizeRequest, RecognizeResponse>
      recognizeMethodDescriptor =
          ApiMethodDescriptor.<RecognizeRequest, RecognizeResponse>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/Recognize")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RecognizeRequest>newBuilder()
                      .setPath(
                          "/v2/{recognizer=projects/*/locations/*/recognizers/*}:recognize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RecognizeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "recognizer", request.getRecognizer());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RecognizeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearRecognizer().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RecognizeResponse>newBuilder()
                      .setDefaultInstance(RecognizeResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchRecognizeRequest, Operation>
      batchRecognizeMethodDescriptor =
          ApiMethodDescriptor.<BatchRecognizeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/BatchRecognize")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchRecognizeRequest>newBuilder()
                      .setPath(
                          "/v2/{recognizer=projects/*/locations/*/recognizers/*}:batchRecognize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRecognizeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "recognizer", request.getRecognizer());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRecognizeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearRecognizer().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchRecognizeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetConfigRequest, Config> getConfigMethodDescriptor =
      ApiMethodDescriptor.<GetConfigRequest, Config>newBuilder()
          .setFullMethodName("google.cloud.speech.v2.Speech/GetConfig")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetConfigRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/config}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetConfigRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetConfigRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Config>newBuilder()
                  .setDefaultInstance(Config.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateConfigRequest, Config>
      updateConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateConfigRequest, Config>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/UpdateConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{config.name=projects/*/locations/*/config}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "config.name", request.getConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("config", request.getConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Config>newBuilder()
                      .setDefaultInstance(Config.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCustomClassRequest, Operation>
      createCustomClassMethodDescriptor =
          ApiMethodDescriptor.<CreateCustomClassRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/CreateCustomClass")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomClassRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/customClasses",
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
                            serializer.putQueryParam(
                                fields, "customClassId", request.getCustomClassId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customClass", request.getCustomClass(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCustomClassRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListCustomClassesRequest, ListCustomClassesResponse>
      listCustomClassesMethodDescriptor =
          ApiMethodDescriptor.<ListCustomClassesRequest, ListCustomClassesResponse>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/ListCustomClasses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomClassesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/customClasses",
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
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<GetCustomClassRequest, CustomClass>
      getCustomClassMethodDescriptor =
          ApiMethodDescriptor.<GetCustomClassRequest, CustomClass>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/GetCustomClass")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomClassRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/customClasses/*}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<UpdateCustomClassRequest, Operation>
      updateCustomClassMethodDescriptor =
          ApiMethodDescriptor.<UpdateCustomClassRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/UpdateCustomClass")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomClassRequest>newBuilder()
                      .setPath(
                          "/v2/{customClass.name=projects/*/locations/*/customClasses/*}",
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
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customClass", request.getCustomClass(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateCustomClassRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteCustomClassRequest, Operation>
      deleteCustomClassMethodDescriptor =
          ApiMethodDescriptor.<DeleteCustomClassRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/DeleteCustomClass")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCustomClassRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/customClasses/*}",
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
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteCustomClassRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UndeleteCustomClassRequest, Operation>
      undeleteCustomClassMethodDescriptor =
          ApiMethodDescriptor.<UndeleteCustomClassRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/UndeleteCustomClass")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeleteCustomClassRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/customClasses/*}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteCustomClassRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteCustomClassRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UndeleteCustomClassRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreatePhraseSetRequest, Operation>
      createPhraseSetMethodDescriptor =
          ApiMethodDescriptor.<CreatePhraseSetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/CreatePhraseSet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePhraseSetRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/phraseSets",
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
                            serializer.putQueryParam(
                                fields, "phraseSetId", request.getPhraseSetId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("phraseSet", request.getPhraseSet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreatePhraseSetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListPhraseSetsRequest, ListPhraseSetsResponse>
      listPhraseSetsMethodDescriptor =
          ApiMethodDescriptor.<ListPhraseSetsRequest, ListPhraseSetsResponse>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/ListPhraseSets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPhraseSetsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/phraseSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPhraseSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPhraseSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPhraseSetsResponse>newBuilder()
                      .setDefaultInstance(ListPhraseSetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPhraseSetRequest, PhraseSet>
      getPhraseSetMethodDescriptor =
          ApiMethodDescriptor.<GetPhraseSetRequest, PhraseSet>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/GetPhraseSet")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPhraseSetRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/phraseSets/*}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<UpdatePhraseSetRequest, Operation>
      updatePhraseSetMethodDescriptor =
          ApiMethodDescriptor.<UpdatePhraseSetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/UpdatePhraseSet")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePhraseSetRequest>newBuilder()
                      .setPath(
                          "/v2/{phraseSet.name=projects/*/locations/*/phraseSets/*}",
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
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("phraseSet", request.getPhraseSet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdatePhraseSetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeletePhraseSetRequest, Operation>
      deletePhraseSetMethodDescriptor =
          ApiMethodDescriptor.<DeletePhraseSetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/DeletePhraseSet")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePhraseSetRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/phraseSets/*}",
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
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeletePhraseSetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UndeletePhraseSetRequest, Operation>
      undeletePhraseSetMethodDescriptor =
          ApiMethodDescriptor.<UndeletePhraseSetRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v2.Speech/UndeletePhraseSet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeletePhraseSetRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/phraseSets/*}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeletePhraseSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeletePhraseSetRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UndeletePhraseSetRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSpeechStub create(SpeechStubSettings settings) throws IOException {
    return new HttpJsonSpeechStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSpeechStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonSpeechStub(SpeechStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSpeechStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSpeechStub(
        SpeechStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSpeechStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSpeechStub(SpeechStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSpeechCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSpeechStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSpeechStub(
      SpeechStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateRecognizerRequest, Operation> createRecognizerTransportSettings =
        HttpJsonCallSettings.<CreateRecognizerRequest, Operation>newBuilder()
            .setMethodDescriptor(createRecognizerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRecognizersRequest, ListRecognizersResponse>
        listRecognizersTransportSettings =
            HttpJsonCallSettings.<ListRecognizersRequest, ListRecognizersResponse>newBuilder()
                .setMethodDescriptor(listRecognizersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRecognizerRequest, Recognizer> getRecognizerTransportSettings =
        HttpJsonCallSettings.<GetRecognizerRequest, Recognizer>newBuilder()
            .setMethodDescriptor(getRecognizerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateRecognizerRequest, Operation> updateRecognizerTransportSettings =
        HttpJsonCallSettings.<UpdateRecognizerRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRecognizerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteRecognizerRequest, Operation> deleteRecognizerTransportSettings =
        HttpJsonCallSettings.<DeleteRecognizerRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRecognizerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UndeleteRecognizerRequest, Operation> undeleteRecognizerTransportSettings =
        HttpJsonCallSettings.<UndeleteRecognizerRequest, Operation>newBuilder()
            .setMethodDescriptor(undeleteRecognizerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RecognizeRequest, RecognizeResponse> recognizeTransportSettings =
        HttpJsonCallSettings.<RecognizeRequest, RecognizeResponse>newBuilder()
            .setMethodDescriptor(recognizeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchRecognizeRequest, Operation> batchRecognizeTransportSettings =
        HttpJsonCallSettings.<BatchRecognizeRequest, Operation>newBuilder()
            .setMethodDescriptor(batchRecognizeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetConfigRequest, Config> getConfigTransportSettings =
        HttpJsonCallSettings.<GetConfigRequest, Config>newBuilder()
            .setMethodDescriptor(getConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateConfigRequest, Config> updateConfigTransportSettings =
        HttpJsonCallSettings.<UpdateConfigRequest, Config>newBuilder()
            .setMethodDescriptor(updateConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateCustomClassRequest, Operation> createCustomClassTransportSettings =
        HttpJsonCallSettings.<CreateCustomClassRequest, Operation>newBuilder()
            .setMethodDescriptor(createCustomClassMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListCustomClassesRequest, ListCustomClassesResponse>
        listCustomClassesTransportSettings =
            HttpJsonCallSettings.<ListCustomClassesRequest, ListCustomClassesResponse>newBuilder()
                .setMethodDescriptor(listCustomClassesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetCustomClassRequest, CustomClass> getCustomClassTransportSettings =
        HttpJsonCallSettings.<GetCustomClassRequest, CustomClass>newBuilder()
            .setMethodDescriptor(getCustomClassMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateCustomClassRequest, Operation> updateCustomClassTransportSettings =
        HttpJsonCallSettings.<UpdateCustomClassRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCustomClassMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteCustomClassRequest, Operation> deleteCustomClassTransportSettings =
        HttpJsonCallSettings.<DeleteCustomClassRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCustomClassMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UndeleteCustomClassRequest, Operation>
        undeleteCustomClassTransportSettings =
            HttpJsonCallSettings.<UndeleteCustomClassRequest, Operation>newBuilder()
                .setMethodDescriptor(undeleteCustomClassMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreatePhraseSetRequest, Operation> createPhraseSetTransportSettings =
        HttpJsonCallSettings.<CreatePhraseSetRequest, Operation>newBuilder()
            .setMethodDescriptor(createPhraseSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListPhraseSetsRequest, ListPhraseSetsResponse>
        listPhraseSetsTransportSettings =
            HttpJsonCallSettings.<ListPhraseSetsRequest, ListPhraseSetsResponse>newBuilder()
                .setMethodDescriptor(listPhraseSetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetPhraseSetRequest, PhraseSet> getPhraseSetTransportSettings =
        HttpJsonCallSettings.<GetPhraseSetRequest, PhraseSet>newBuilder()
            .setMethodDescriptor(getPhraseSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdatePhraseSetRequest, Operation> updatePhraseSetTransportSettings =
        HttpJsonCallSettings.<UpdatePhraseSetRequest, Operation>newBuilder()
            .setMethodDescriptor(updatePhraseSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeletePhraseSetRequest, Operation> deletePhraseSetTransportSettings =
        HttpJsonCallSettings.<DeletePhraseSetRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePhraseSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UndeletePhraseSetRequest, Operation> undeletePhraseSetTransportSettings =
        HttpJsonCallSettings.<UndeletePhraseSetRequest, Operation>newBuilder()
            .setMethodDescriptor(undeletePhraseSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createRecognizerCallable =
        callableFactory.createUnaryCallable(
            createRecognizerTransportSettings, settings.createRecognizerSettings(), clientContext);
    this.createRecognizerOperationCallable =
        callableFactory.createOperationCallable(
            createRecognizerTransportSettings,
            settings.createRecognizerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.deleteRecognizerCallable =
        callableFactory.createUnaryCallable(
            deleteRecognizerTransportSettings, settings.deleteRecognizerSettings(), clientContext);
    this.deleteRecognizerOperationCallable =
        callableFactory.createOperationCallable(
            deleteRecognizerTransportSettings,
            settings.deleteRecognizerOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.recognizeCallable =
        callableFactory.createUnaryCallable(
            recognizeTransportSettings, settings.recognizeSettings(), clientContext);
    this.batchRecognizeCallable =
        callableFactory.createUnaryCallable(
            batchRecognizeTransportSettings, settings.batchRecognizeSettings(), clientContext);
    this.batchRecognizeOperationCallable =
        callableFactory.createOperationCallable(
            batchRecognizeTransportSettings,
            settings.batchRecognizeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.createPhraseSetCallable =
        callableFactory.createUnaryCallable(
            createPhraseSetTransportSettings, settings.createPhraseSetSettings(), clientContext);
    this.createPhraseSetOperationCallable =
        callableFactory.createOperationCallable(
            createPhraseSetTransportSettings,
            settings.createPhraseSetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.deletePhraseSetCallable =
        callableFactory.createUnaryCallable(
            deletePhraseSetTransportSettings, settings.deletePhraseSetSettings(), clientContext);
    this.deletePhraseSetOperationCallable =
        callableFactory.createOperationCallable(
            deletePhraseSetTransportSettings,
            settings.deletePhraseSetOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createRecognizerMethodDescriptor);
    methodDescriptors.add(listRecognizersMethodDescriptor);
    methodDescriptors.add(getRecognizerMethodDescriptor);
    methodDescriptors.add(updateRecognizerMethodDescriptor);
    methodDescriptors.add(deleteRecognizerMethodDescriptor);
    methodDescriptors.add(undeleteRecognizerMethodDescriptor);
    methodDescriptors.add(recognizeMethodDescriptor);
    methodDescriptors.add(batchRecognizeMethodDescriptor);
    methodDescriptors.add(getConfigMethodDescriptor);
    methodDescriptors.add(updateConfigMethodDescriptor);
    methodDescriptors.add(createCustomClassMethodDescriptor);
    methodDescriptors.add(listCustomClassesMethodDescriptor);
    methodDescriptors.add(getCustomClassMethodDescriptor);
    methodDescriptors.add(updateCustomClassMethodDescriptor);
    methodDescriptors.add(deleteCustomClassMethodDescriptor);
    methodDescriptors.add(undeleteCustomClassMethodDescriptor);
    methodDescriptors.add(createPhraseSetMethodDescriptor);
    methodDescriptors.add(listPhraseSetsMethodDescriptor);
    methodDescriptors.add(getPhraseSetMethodDescriptor);
    methodDescriptors.add(updatePhraseSetMethodDescriptor);
    methodDescriptors.add(deletePhraseSetMethodDescriptor);
    methodDescriptors.add(undeletePhraseSetMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
