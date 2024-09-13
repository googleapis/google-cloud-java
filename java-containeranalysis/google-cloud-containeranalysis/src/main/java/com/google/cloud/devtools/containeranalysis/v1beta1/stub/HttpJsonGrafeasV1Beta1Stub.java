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

package com.google.cloud.devtools.containeranalysis.v1beta1.stub;

import static com.google.cloud.devtools.containeranalysis.v1beta1.GrafeasV1Beta1Client.ListNoteOccurrencesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1beta1.GrafeasV1Beta1Client.ListNotesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1beta1.GrafeasV1Beta1Client.ListOccurrencesPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import io.grafeas.v1beta1.BatchCreateNotesRequest;
import io.grafeas.v1beta1.BatchCreateNotesResponse;
import io.grafeas.v1beta1.BatchCreateOccurrencesRequest;
import io.grafeas.v1beta1.BatchCreateOccurrencesResponse;
import io.grafeas.v1beta1.CreateNoteRequest;
import io.grafeas.v1beta1.CreateOccurrenceRequest;
import io.grafeas.v1beta1.DeleteNoteRequest;
import io.grafeas.v1beta1.DeleteOccurrenceRequest;
import io.grafeas.v1beta1.GetNoteRequest;
import io.grafeas.v1beta1.GetOccurrenceNoteRequest;
import io.grafeas.v1beta1.GetOccurrenceRequest;
import io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest;
import io.grafeas.v1beta1.ListNoteOccurrencesRequest;
import io.grafeas.v1beta1.ListNoteOccurrencesResponse;
import io.grafeas.v1beta1.ListNotesRequest;
import io.grafeas.v1beta1.ListNotesResponse;
import io.grafeas.v1beta1.ListOccurrencesRequest;
import io.grafeas.v1beta1.ListOccurrencesResponse;
import io.grafeas.v1beta1.Note;
import io.grafeas.v1beta1.Occurrence;
import io.grafeas.v1beta1.UpdateNoteRequest;
import io.grafeas.v1beta1.UpdateOccurrenceRequest;
import io.grafeas.v1beta1.VulnerabilityOccurrencesSummary;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the GrafeasV1Beta1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonGrafeasV1Beta1Stub extends GrafeasV1Beta1Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetOccurrenceRequest, Occurrence>
      getOccurrenceMethodDescriptor =
          ApiMethodDescriptor.<GetOccurrenceRequest, Occurrence>newBuilder()
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/GetOccurrence")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOccurrenceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/occurrences/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOccurrenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOccurrenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Occurrence>newBuilder()
                      .setDefaultInstance(Occurrence.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListOccurrencesRequest, ListOccurrencesResponse>
      listOccurrencesMethodDescriptor =
          ApiMethodDescriptor.<ListOccurrencesRequest, ListOccurrencesResponse>newBuilder()
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/ListOccurrences")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOccurrencesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*}/occurrences",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOccurrencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOccurrencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOccurrencesResponse>newBuilder()
                      .setDefaultInstance(ListOccurrencesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteOccurrenceRequest, Empty>
      deleteOccurrenceMethodDescriptor =
          ApiMethodDescriptor.<DeleteOccurrenceRequest, Empty>newBuilder()
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/DeleteOccurrence")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteOccurrenceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/occurrences/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOccurrenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOccurrenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<CreateOccurrenceRequest, Occurrence>
      createOccurrenceMethodDescriptor =
          ApiMethodDescriptor.<CreateOccurrenceRequest, Occurrence>newBuilder()
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/CreateOccurrence")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateOccurrenceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*}/occurrences",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOccurrenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateOccurrenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("occurrence", request.getOccurrence(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Occurrence>newBuilder()
                      .setDefaultInstance(Occurrence.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
      batchCreateOccurrencesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>newBuilder()
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/BatchCreateOccurrences")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateOccurrencesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*}/occurrences:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateOccurrencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateOccurrencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchCreateOccurrencesResponse>newBuilder()
                      .setDefaultInstance(BatchCreateOccurrencesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateOccurrenceRequest, Occurrence>
      updateOccurrenceMethodDescriptor =
          ApiMethodDescriptor.<UpdateOccurrenceRequest, Occurrence>newBuilder()
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/UpdateOccurrence")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateOccurrenceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/occurrences/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOccurrenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOccurrenceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("occurrence", request.getOccurrence(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Occurrence>newBuilder()
                      .setDefaultInstance(Occurrence.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetOccurrenceNoteRequest, Note>
      getOccurrenceNoteMethodDescriptor =
          ApiMethodDescriptor.<GetOccurrenceNoteRequest, Note>newBuilder()
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/GetOccurrenceNote")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOccurrenceNoteRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/occurrences/*}/notes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOccurrenceNoteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOccurrenceNoteRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Note>newBuilder()
                      .setDefaultInstance(Note.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNoteRequest, Note> getNoteMethodDescriptor =
      ApiMethodDescriptor.<GetNoteRequest, Note>newBuilder()
          .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/GetNote")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetNoteRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/notes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetNoteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetNoteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Note>newBuilder()
                  .setDefaultInstance(Note.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListNotesRequest, ListNotesResponse>
      listNotesMethodDescriptor =
          ApiMethodDescriptor.<ListNotesRequest, ListNotesResponse>newBuilder()
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/ListNotes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNotesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*}/notes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNotesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNotesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNotesResponse>newBuilder()
                      .setDefaultInstance(ListNotesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteNoteRequest, Empty> deleteNoteMethodDescriptor =
      ApiMethodDescriptor.<DeleteNoteRequest, Empty>newBuilder()
          .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/DeleteNote")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteNoteRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/notes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteNoteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteNoteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<CreateNoteRequest, Note> createNoteMethodDescriptor =
      ApiMethodDescriptor.<CreateNoteRequest, Note>newBuilder()
          .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/CreateNote")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateNoteRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{parent=projects/*}/notes",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateNoteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateNoteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "noteId", request.getNoteId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("note", request.getNote(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Note>newBuilder()
                  .setDefaultInstance(Note.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<BatchCreateNotesRequest, BatchCreateNotesResponse>
      batchCreateNotesMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateNotesRequest, BatchCreateNotesResponse>newBuilder()
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/BatchCreateNotes")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateNotesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*}/notes:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateNotesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateNotesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchCreateNotesResponse>newBuilder()
                      .setDefaultInstance(BatchCreateNotesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateNoteRequest, Note> updateNoteMethodDescriptor =
      ApiMethodDescriptor.<UpdateNoteRequest, Note>newBuilder()
          .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/UpdateNote")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateNoteRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{name=projects/*/notes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateNoteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateNoteRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("note", request.getNote(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Note>newBuilder()
                  .setDefaultInstance(Note.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesMethodDescriptor =
          ApiMethodDescriptor.<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>newBuilder()
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/ListNoteOccurrences")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNoteOccurrencesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/notes/*}/occurrences",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNoteOccurrencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNoteOccurrencesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNoteOccurrencesResponse>newBuilder()
                      .setDefaultInstance(ListNoteOccurrencesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
      getVulnerabilityOccurrencesSummaryMethodDescriptor =
          ApiMethodDescriptor
              .<GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
                  newBuilder()
              .setFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1/GetVulnerabilityOccurrencesSummary")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetVulnerabilityOccurrencesSummaryRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*}/occurrences:vulnerabilitySummary",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetVulnerabilityOccurrencesSummaryRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetVulnerabilityOccurrencesSummaryRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VulnerabilityOccurrencesSummary>newBuilder()
                      .setDefaultInstance(VulnerabilityOccurrencesSummary.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetOccurrenceRequest, Occurrence> getOccurrenceCallable;
  private final UnaryCallable<ListOccurrencesRequest, ListOccurrencesResponse>
      listOccurrencesCallable;
  private final UnaryCallable<ListOccurrencesRequest, ListOccurrencesPagedResponse>
      listOccurrencesPagedCallable;
  private final UnaryCallable<DeleteOccurrenceRequest, Empty> deleteOccurrenceCallable;
  private final UnaryCallable<CreateOccurrenceRequest, Occurrence> createOccurrenceCallable;
  private final UnaryCallable<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
      batchCreateOccurrencesCallable;
  private final UnaryCallable<UpdateOccurrenceRequest, Occurrence> updateOccurrenceCallable;
  private final UnaryCallable<GetOccurrenceNoteRequest, Note> getOccurrenceNoteCallable;
  private final UnaryCallable<GetNoteRequest, Note> getNoteCallable;
  private final UnaryCallable<ListNotesRequest, ListNotesResponse> listNotesCallable;
  private final UnaryCallable<ListNotesRequest, ListNotesPagedResponse> listNotesPagedCallable;
  private final UnaryCallable<DeleteNoteRequest, Empty> deleteNoteCallable;
  private final UnaryCallable<CreateNoteRequest, Note> createNoteCallable;
  private final UnaryCallable<BatchCreateNotesRequest, BatchCreateNotesResponse>
      batchCreateNotesCallable;
  private final UnaryCallable<UpdateNoteRequest, Note> updateNoteCallable;
  private final UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesCallable;
  private final UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesPagedCallable;
  private final UnaryCallable<
          GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
      getVulnerabilityOccurrencesSummaryCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGrafeasV1Beta1Stub create(GrafeasV1Beta1StubSettings settings)
      throws IOException {
    return new HttpJsonGrafeasV1Beta1Stub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGrafeasV1Beta1Stub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGrafeasV1Beta1Stub(
        GrafeasV1Beta1StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGrafeasV1Beta1Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGrafeasV1Beta1Stub(
        GrafeasV1Beta1StubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGrafeasV1Beta1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGrafeasV1Beta1Stub(
      GrafeasV1Beta1StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGrafeasV1Beta1CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGrafeasV1Beta1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGrafeasV1Beta1Stub(
      GrafeasV1Beta1StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetOccurrenceRequest, Occurrence> getOccurrenceTransportSettings =
        HttpJsonCallSettings.<GetOccurrenceRequest, Occurrence>newBuilder()
            .setMethodDescriptor(getOccurrenceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListOccurrencesRequest, ListOccurrencesResponse>
        listOccurrencesTransportSettings =
            HttpJsonCallSettings.<ListOccurrencesRequest, ListOccurrencesResponse>newBuilder()
                .setMethodDescriptor(listOccurrencesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteOccurrenceRequest, Empty> deleteOccurrenceTransportSettings =
        HttpJsonCallSettings.<DeleteOccurrenceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteOccurrenceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateOccurrenceRequest, Occurrence> createOccurrenceTransportSettings =
        HttpJsonCallSettings.<CreateOccurrenceRequest, Occurrence>newBuilder()
            .setMethodDescriptor(createOccurrenceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
        batchCreateOccurrencesTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>newBuilder()
                .setMethodDescriptor(batchCreateOccurrencesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateOccurrenceRequest, Occurrence> updateOccurrenceTransportSettings =
        HttpJsonCallSettings.<UpdateOccurrenceRequest, Occurrence>newBuilder()
            .setMethodDescriptor(updateOccurrenceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetOccurrenceNoteRequest, Note> getOccurrenceNoteTransportSettings =
        HttpJsonCallSettings.<GetOccurrenceNoteRequest, Note>newBuilder()
            .setMethodDescriptor(getOccurrenceNoteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetNoteRequest, Note> getNoteTransportSettings =
        HttpJsonCallSettings.<GetNoteRequest, Note>newBuilder()
            .setMethodDescriptor(getNoteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListNotesRequest, ListNotesResponse> listNotesTransportSettings =
        HttpJsonCallSettings.<ListNotesRequest, ListNotesResponse>newBuilder()
            .setMethodDescriptor(listNotesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteNoteRequest, Empty> deleteNoteTransportSettings =
        HttpJsonCallSettings.<DeleteNoteRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteNoteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateNoteRequest, Note> createNoteTransportSettings =
        HttpJsonCallSettings.<CreateNoteRequest, Note>newBuilder()
            .setMethodDescriptor(createNoteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchCreateNotesRequest, BatchCreateNotesResponse>
        batchCreateNotesTransportSettings =
            HttpJsonCallSettings.<BatchCreateNotesRequest, BatchCreateNotesResponse>newBuilder()
                .setMethodDescriptor(batchCreateNotesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateNoteRequest, Note> updateNoteTransportSettings =
        HttpJsonCallSettings.<UpdateNoteRequest, Note>newBuilder()
            .setMethodDescriptor(updateNoteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
        listNoteOccurrencesTransportSettings =
            HttpJsonCallSettings
                .<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>newBuilder()
                .setMethodDescriptor(listNoteOccurrencesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
        getVulnerabilityOccurrencesSummaryTransportSettings =
            HttpJsonCallSettings
                .<GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
                    newBuilder()
                .setMethodDescriptor(getVulnerabilityOccurrencesSummaryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getOccurrenceCallable =
        callableFactory.createUnaryCallable(
            getOccurrenceTransportSettings, settings.getOccurrenceSettings(), clientContext);
    this.listOccurrencesCallable =
        callableFactory.createUnaryCallable(
            listOccurrencesTransportSettings, settings.listOccurrencesSettings(), clientContext);
    this.listOccurrencesPagedCallable =
        callableFactory.createPagedCallable(
            listOccurrencesTransportSettings, settings.listOccurrencesSettings(), clientContext);
    this.deleteOccurrenceCallable =
        callableFactory.createUnaryCallable(
            deleteOccurrenceTransportSettings, settings.deleteOccurrenceSettings(), clientContext);
    this.createOccurrenceCallable =
        callableFactory.createUnaryCallable(
            createOccurrenceTransportSettings, settings.createOccurrenceSettings(), clientContext);
    this.batchCreateOccurrencesCallable =
        callableFactory.createUnaryCallable(
            batchCreateOccurrencesTransportSettings,
            settings.batchCreateOccurrencesSettings(),
            clientContext);
    this.updateOccurrenceCallable =
        callableFactory.createUnaryCallable(
            updateOccurrenceTransportSettings, settings.updateOccurrenceSettings(), clientContext);
    this.getOccurrenceNoteCallable =
        callableFactory.createUnaryCallable(
            getOccurrenceNoteTransportSettings,
            settings.getOccurrenceNoteSettings(),
            clientContext);
    this.getNoteCallable =
        callableFactory.createUnaryCallable(
            getNoteTransportSettings, settings.getNoteSettings(), clientContext);
    this.listNotesCallable =
        callableFactory.createUnaryCallable(
            listNotesTransportSettings, settings.listNotesSettings(), clientContext);
    this.listNotesPagedCallable =
        callableFactory.createPagedCallable(
            listNotesTransportSettings, settings.listNotesSettings(), clientContext);
    this.deleteNoteCallable =
        callableFactory.createUnaryCallable(
            deleteNoteTransportSettings, settings.deleteNoteSettings(), clientContext);
    this.createNoteCallable =
        callableFactory.createUnaryCallable(
            createNoteTransportSettings, settings.createNoteSettings(), clientContext);
    this.batchCreateNotesCallable =
        callableFactory.createUnaryCallable(
            batchCreateNotesTransportSettings, settings.batchCreateNotesSettings(), clientContext);
    this.updateNoteCallable =
        callableFactory.createUnaryCallable(
            updateNoteTransportSettings, settings.updateNoteSettings(), clientContext);
    this.listNoteOccurrencesCallable =
        callableFactory.createUnaryCallable(
            listNoteOccurrencesTransportSettings,
            settings.listNoteOccurrencesSettings(),
            clientContext);
    this.listNoteOccurrencesPagedCallable =
        callableFactory.createPagedCallable(
            listNoteOccurrencesTransportSettings,
            settings.listNoteOccurrencesSettings(),
            clientContext);
    this.getVulnerabilityOccurrencesSummaryCallable =
        callableFactory.createUnaryCallable(
            getVulnerabilityOccurrencesSummaryTransportSettings,
            settings.getVulnerabilityOccurrencesSummarySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getOccurrenceMethodDescriptor);
    methodDescriptors.add(listOccurrencesMethodDescriptor);
    methodDescriptors.add(deleteOccurrenceMethodDescriptor);
    methodDescriptors.add(createOccurrenceMethodDescriptor);
    methodDescriptors.add(batchCreateOccurrencesMethodDescriptor);
    methodDescriptors.add(updateOccurrenceMethodDescriptor);
    methodDescriptors.add(getOccurrenceNoteMethodDescriptor);
    methodDescriptors.add(getNoteMethodDescriptor);
    methodDescriptors.add(listNotesMethodDescriptor);
    methodDescriptors.add(deleteNoteMethodDescriptor);
    methodDescriptors.add(createNoteMethodDescriptor);
    methodDescriptors.add(batchCreateNotesMethodDescriptor);
    methodDescriptors.add(updateNoteMethodDescriptor);
    methodDescriptors.add(listNoteOccurrencesMethodDescriptor);
    methodDescriptors.add(getVulnerabilityOccurrencesSummaryMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetOccurrenceRequest, Occurrence> getOccurrenceCallable() {
    return getOccurrenceCallable;
  }

  @Override
  public UnaryCallable<ListOccurrencesRequest, ListOccurrencesResponse> listOccurrencesCallable() {
    return listOccurrencesCallable;
  }

  @Override
  public UnaryCallable<ListOccurrencesRequest, ListOccurrencesPagedResponse>
      listOccurrencesPagedCallable() {
    return listOccurrencesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteOccurrenceRequest, Empty> deleteOccurrenceCallable() {
    return deleteOccurrenceCallable;
  }

  @Override
  public UnaryCallable<CreateOccurrenceRequest, Occurrence> createOccurrenceCallable() {
    return createOccurrenceCallable;
  }

  @Override
  public UnaryCallable<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
      batchCreateOccurrencesCallable() {
    return batchCreateOccurrencesCallable;
  }

  @Override
  public UnaryCallable<UpdateOccurrenceRequest, Occurrence> updateOccurrenceCallable() {
    return updateOccurrenceCallable;
  }

  @Override
  public UnaryCallable<GetOccurrenceNoteRequest, Note> getOccurrenceNoteCallable() {
    return getOccurrenceNoteCallable;
  }

  @Override
  public UnaryCallable<GetNoteRequest, Note> getNoteCallable() {
    return getNoteCallable;
  }

  @Override
  public UnaryCallable<ListNotesRequest, ListNotesResponse> listNotesCallable() {
    return listNotesCallable;
  }

  @Override
  public UnaryCallable<ListNotesRequest, ListNotesPagedResponse> listNotesPagedCallable() {
    return listNotesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteNoteRequest, Empty> deleteNoteCallable() {
    return deleteNoteCallable;
  }

  @Override
  public UnaryCallable<CreateNoteRequest, Note> createNoteCallable() {
    return createNoteCallable;
  }

  @Override
  public UnaryCallable<BatchCreateNotesRequest, BatchCreateNotesResponse>
      batchCreateNotesCallable() {
    return batchCreateNotesCallable;
  }

  @Override
  public UnaryCallable<UpdateNoteRequest, Note> updateNoteCallable() {
    return updateNoteCallable;
  }

  @Override
  public UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesCallable() {
    return listNoteOccurrencesCallable;
  }

  @Override
  public UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesPagedCallable() {
    return listNoteOccurrencesPagedCallable;
  }

  @Override
  public UnaryCallable<GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
      getVulnerabilityOccurrencesSummaryCallable() {
    return getVulnerabilityOccurrencesSummaryCallable;
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
