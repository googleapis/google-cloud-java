/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.ProposalServiceClient.FetchMarketplaceCommentsPagedResponse;
import static com.google.ads.admanager.v1.ProposalServiceClient.ListProposalsPagedResponse;

import com.google.ads.admanager.v1.BatchArchiveProposalsRequest;
import com.google.ads.admanager.v1.BatchArchiveProposalsResponse;
import com.google.ads.admanager.v1.BatchCreateProposalsRequest;
import com.google.ads.admanager.v1.BatchCreateProposalsResponse;
import com.google.ads.admanager.v1.BatchDiscardDraftProposalsRequest;
import com.google.ads.admanager.v1.BatchDiscardDraftProposalsResponse;
import com.google.ads.admanager.v1.BatchPauseProposalsRequest;
import com.google.ads.admanager.v1.BatchPauseProposalsResponse;
import com.google.ads.admanager.v1.BatchPushToOrderProposalsRequest;
import com.google.ads.admanager.v1.BatchPushToOrderProposalsResponse;
import com.google.ads.admanager.v1.BatchRedraftProposalsRequest;
import com.google.ads.admanager.v1.BatchRedraftProposalsResponse;
import com.google.ads.admanager.v1.BatchRequestBuyerAcceptProposalsRequest;
import com.google.ads.admanager.v1.BatchRequestBuyerAcceptProposalsResponse;
import com.google.ads.admanager.v1.BatchRequestBuyerReviewProposalsRequest;
import com.google.ads.admanager.v1.BatchRequestBuyerReviewProposalsResponse;
import com.google.ads.admanager.v1.BatchReserveProposalsRequest;
import com.google.ads.admanager.v1.BatchReserveProposalsResponse;
import com.google.ads.admanager.v1.BatchResumeProposalsRequest;
import com.google.ads.admanager.v1.BatchResumeProposalsResponse;
import com.google.ads.admanager.v1.BatchTerminateProposalsRequest;
import com.google.ads.admanager.v1.BatchTerminateProposalsResponse;
import com.google.ads.admanager.v1.BatchUnarchiveProposalsRequest;
import com.google.ads.admanager.v1.BatchUnarchiveProposalsResponse;
import com.google.ads.admanager.v1.BatchUpdateProposalsRequest;
import com.google.ads.admanager.v1.BatchUpdateProposalsResponse;
import com.google.ads.admanager.v1.CreateProposalRequest;
import com.google.ads.admanager.v1.FetchMarketplaceCommentsRequest;
import com.google.ads.admanager.v1.FetchMarketplaceCommentsResponse;
import com.google.ads.admanager.v1.GetProposalRequest;
import com.google.ads.admanager.v1.ListProposalsRequest;
import com.google.ads.admanager.v1.ListProposalsResponse;
import com.google.ads.admanager.v1.Proposal;
import com.google.ads.admanager.v1.UpdateProposalRequest;
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
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ProposalService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonProposalServiceStub extends ProposalServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetProposalRequest, Proposal>
      getProposalMethodDescriptor =
          ApiMethodDescriptor.<GetProposalRequest, Proposal>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/GetProposal")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetProposalRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/proposals/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetProposalRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetProposalRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Proposal>newBuilder()
                      .setDefaultInstance(Proposal.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListProposalsRequest, ListProposalsResponse>
      listProposalsMethodDescriptor =
          ApiMethodDescriptor.<ListProposalsRequest, ListProposalsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/ListProposals")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProposalsResponse>newBuilder()
                      .setDefaultInstance(ListProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateProposalRequest, Proposal>
      createProposalMethodDescriptor =
          ApiMethodDescriptor.<CreateProposalRequest, Proposal>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/CreateProposal")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateProposalRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProposalRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProposalRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("proposal", request.getProposal(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Proposal>newBuilder()
                      .setDefaultInstance(Proposal.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateProposalsRequest, BatchCreateProposalsResponse>
      batchCreateProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateProposalsRequest, BatchCreateProposalsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/BatchCreateProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateProposalsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateProposalsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateProposalRequest, Proposal>
      updateProposalMethodDescriptor =
          ApiMethodDescriptor.<UpdateProposalRequest, Proposal>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/UpdateProposal")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProposalRequest>newBuilder()
                      .setPath(
                          "/v1/{proposal.name=networks/*/proposals/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProposalRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "proposal.name", request.getProposal().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProposalRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("proposal", request.getProposal(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Proposal>newBuilder()
                      .setDefaultInstance(Proposal.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>
      batchUpdateProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/BatchUpdateProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateProposalsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateProposalsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>
      batchArchiveProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/BatchArchiveProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchArchiveProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchArchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveProposalsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchArchiveProposalsResponse>newBuilder()
                      .setDefaultInstance(BatchArchiveProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>
      batchUnarchiveProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/BatchUnarchiveProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUnarchiveProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchUnarchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUnarchiveProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUnarchiveProposalsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUnarchiveProposalsResponse>newBuilder()
                      .setDefaultInstance(BatchUnarchiveProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchPauseProposalsRequest, BatchPauseProposalsResponse>
      batchPauseProposalsMethodDescriptor =
          ApiMethodDescriptor.<BatchPauseProposalsRequest, BatchPauseProposalsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/BatchPauseProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchPauseProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchPause",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchPauseProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchPauseProposalsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchPauseProposalsResponse>newBuilder()
                      .setDefaultInstance(BatchPauseProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchResumeProposalsRequest, BatchResumeProposalsResponse>
      batchResumeProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchResumeProposalsRequest, BatchResumeProposalsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/BatchResumeProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchResumeProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchResume",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchResumeProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchResumeProposalsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchResumeProposalsResponse>newBuilder()
                      .setDefaultInstance(BatchResumeProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
      batchRequestBuyerReviewProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ProposalService/BatchRequestBuyerReviewProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchRequestBuyerReviewProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchRequestBuyerReview",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRequestBuyerReviewProposalsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRequestBuyerReviewProposalsRequest>
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
                  ProtoMessageResponseParser.<BatchRequestBuyerReviewProposalsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchRequestBuyerReviewProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
      batchRequestBuyerAcceptProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ProposalService/BatchRequestBuyerAcceptProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchRequestBuyerAcceptProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchRequestBuyerAccept",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRequestBuyerAcceptProposalsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRequestBuyerAcceptProposalsRequest>
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
                  ProtoMessageResponseParser.<BatchRequestBuyerAcceptProposalsResponse>newBuilder()
                      .setDefaultInstance(
                          BatchRequestBuyerAcceptProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchReserveProposalsRequest, BatchReserveProposalsResponse>
      batchReserveProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchReserveProposalsRequest, BatchReserveProposalsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/BatchReserveProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchReserveProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchReserve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchReserveProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchReserveProposalsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchReserveProposalsResponse>newBuilder()
                      .setDefaultInstance(BatchReserveProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>
      batchRedraftProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/BatchRedraftProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchRedraftProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchRedraft",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRedraftProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRedraftProposalsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchRedraftProposalsResponse>newBuilder()
                      .setDefaultInstance(BatchRedraftProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>
      batchDiscardDraftProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ProposalService/BatchDiscardDraftProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDiscardDraftProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchDiscardDraft",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDiscardDraftProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDiscardDraftProposalsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchDiscardDraftProposalsResponse>newBuilder()
                      .setDefaultInstance(BatchDiscardDraftProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>
      batchTerminateProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/BatchTerminateProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchTerminateProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchTerminate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchTerminateProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchTerminateProposalsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchTerminateProposalsResponse>newBuilder()
                      .setDefaultInstance(BatchTerminateProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>
      batchPushToOrderProposalsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ProposalService/BatchPushToOrderProposals")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchPushToOrderProposalsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:batchPushToOrder",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchPushToOrderProposalsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchPushToOrderProposalsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchPushToOrderProposalsResponse>newBuilder()
                      .setDefaultInstance(BatchPushToOrderProposalsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsResponse>
      fetchMarketplaceCommentsMethodDescriptor =
          ApiMethodDescriptor
              .<FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ProposalService/FetchMarketplaceComments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchMarketplaceCommentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/proposals:fetchMarketplaceComments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchMarketplaceCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchMarketplaceCommentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "names", request.getNamesList());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchMarketplaceCommentsResponse>newBuilder()
                      .setDefaultInstance(FetchMarketplaceCommentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetProposalRequest, Proposal> getProposalCallable;
  private final UnaryCallable<ListProposalsRequest, ListProposalsResponse> listProposalsCallable;
  private final UnaryCallable<ListProposalsRequest, ListProposalsPagedResponse>
      listProposalsPagedCallable;
  private final UnaryCallable<CreateProposalRequest, Proposal> createProposalCallable;
  private final UnaryCallable<BatchCreateProposalsRequest, BatchCreateProposalsResponse>
      batchCreateProposalsCallable;
  private final UnaryCallable<UpdateProposalRequest, Proposal> updateProposalCallable;
  private final UnaryCallable<BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>
      batchUpdateProposalsCallable;
  private final UnaryCallable<BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>
      batchArchiveProposalsCallable;
  private final UnaryCallable<BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>
      batchUnarchiveProposalsCallable;
  private final UnaryCallable<BatchPauseProposalsRequest, BatchPauseProposalsResponse>
      batchPauseProposalsCallable;
  private final UnaryCallable<BatchResumeProposalsRequest, BatchResumeProposalsResponse>
      batchResumeProposalsCallable;
  private final UnaryCallable<
          BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
      batchRequestBuyerReviewProposalsCallable;
  private final UnaryCallable<
          BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
      batchRequestBuyerAcceptProposalsCallable;
  private final UnaryCallable<BatchReserveProposalsRequest, BatchReserveProposalsResponse>
      batchReserveProposalsCallable;
  private final UnaryCallable<BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>
      batchRedraftProposalsCallable;
  private final UnaryCallable<BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>
      batchDiscardDraftProposalsCallable;
  private final UnaryCallable<BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>
      batchTerminateProposalsCallable;
  private final UnaryCallable<BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>
      batchPushToOrderProposalsCallable;
  private final UnaryCallable<FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsResponse>
      fetchMarketplaceCommentsCallable;
  private final UnaryCallable<
          FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsPagedResponse>
      fetchMarketplaceCommentsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProposalServiceStub create(ProposalServiceStubSettings settings)
      throws IOException {
    return new HttpJsonProposalServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProposalServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonProposalServiceStub(
        ProposalServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonProposalServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProposalServiceStub(
        ProposalServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProposalServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProposalServiceStub(
      ProposalServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonProposalServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProposalServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonProposalServiceStub(
      ProposalServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetProposalRequest, Proposal> getProposalTransportSettings =
        HttpJsonCallSettings.<GetProposalRequest, Proposal>newBuilder()
            .setMethodDescriptor(getProposalMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListProposalsRequest, ListProposalsResponse>
        listProposalsTransportSettings =
            HttpJsonCallSettings.<ListProposalsRequest, ListProposalsResponse>newBuilder()
                .setMethodDescriptor(listProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateProposalRequest, Proposal> createProposalTransportSettings =
        HttpJsonCallSettings.<CreateProposalRequest, Proposal>newBuilder()
            .setMethodDescriptor(createProposalMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchCreateProposalsRequest, BatchCreateProposalsResponse>
        batchCreateProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateProposalsRequest, BatchCreateProposalsResponse>newBuilder()
                .setMethodDescriptor(batchCreateProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateProposalRequest, Proposal> updateProposalTransportSettings =
        HttpJsonCallSettings.<UpdateProposalRequest, Proposal>newBuilder()
            .setMethodDescriptor(updateProposalMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("proposal.name", String.valueOf(request.getProposal().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>
        batchUpdateProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>
        batchArchiveProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>newBuilder()
                .setMethodDescriptor(batchArchiveProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>
        batchUnarchiveProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>newBuilder()
                .setMethodDescriptor(batchUnarchiveProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchPauseProposalsRequest, BatchPauseProposalsResponse>
        batchPauseProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchPauseProposalsRequest, BatchPauseProposalsResponse>newBuilder()
                .setMethodDescriptor(batchPauseProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchResumeProposalsRequest, BatchResumeProposalsResponse>
        batchResumeProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchResumeProposalsRequest, BatchResumeProposalsResponse>newBuilder()
                .setMethodDescriptor(batchResumeProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
        batchRequestBuyerReviewProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
                    newBuilder()
                .setMethodDescriptor(batchRequestBuyerReviewProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
        batchRequestBuyerAcceptProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
                    newBuilder()
                .setMethodDescriptor(batchRequestBuyerAcceptProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchReserveProposalsRequest, BatchReserveProposalsResponse>
        batchReserveProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchReserveProposalsRequest, BatchReserveProposalsResponse>newBuilder()
                .setMethodDescriptor(batchReserveProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>
        batchRedraftProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>newBuilder()
                .setMethodDescriptor(batchRedraftProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>
        batchDiscardDraftProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>newBuilder()
                .setMethodDescriptor(batchDiscardDraftProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>
        batchTerminateProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>newBuilder()
                .setMethodDescriptor(batchTerminateProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>
        batchPushToOrderProposalsTransportSettings =
            HttpJsonCallSettings
                .<BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>newBuilder()
                .setMethodDescriptor(batchPushToOrderProposalsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsResponse>
        fetchMarketplaceCommentsTransportSettings =
            HttpJsonCallSettings
                .<FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsResponse>newBuilder()
                .setMethodDescriptor(fetchMarketplaceCommentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getProposalCallable =
        callableFactory.createUnaryCallable(
            getProposalTransportSettings, settings.getProposalSettings(), clientContext);
    this.listProposalsCallable =
        callableFactory.createUnaryCallable(
            listProposalsTransportSettings, settings.listProposalsSettings(), clientContext);
    this.listProposalsPagedCallable =
        callableFactory.createPagedCallable(
            listProposalsTransportSettings, settings.listProposalsSettings(), clientContext);
    this.createProposalCallable =
        callableFactory.createUnaryCallable(
            createProposalTransportSettings, settings.createProposalSettings(), clientContext);
    this.batchCreateProposalsCallable =
        callableFactory.createUnaryCallable(
            batchCreateProposalsTransportSettings,
            settings.batchCreateProposalsSettings(),
            clientContext);
    this.updateProposalCallable =
        callableFactory.createUnaryCallable(
            updateProposalTransportSettings, settings.updateProposalSettings(), clientContext);
    this.batchUpdateProposalsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateProposalsTransportSettings,
            settings.batchUpdateProposalsSettings(),
            clientContext);
    this.batchArchiveProposalsCallable =
        callableFactory.createUnaryCallable(
            batchArchiveProposalsTransportSettings,
            settings.batchArchiveProposalsSettings(),
            clientContext);
    this.batchUnarchiveProposalsCallable =
        callableFactory.createUnaryCallable(
            batchUnarchiveProposalsTransportSettings,
            settings.batchUnarchiveProposalsSettings(),
            clientContext);
    this.batchPauseProposalsCallable =
        callableFactory.createUnaryCallable(
            batchPauseProposalsTransportSettings,
            settings.batchPauseProposalsSettings(),
            clientContext);
    this.batchResumeProposalsCallable =
        callableFactory.createUnaryCallable(
            batchResumeProposalsTransportSettings,
            settings.batchResumeProposalsSettings(),
            clientContext);
    this.batchRequestBuyerReviewProposalsCallable =
        callableFactory.createUnaryCallable(
            batchRequestBuyerReviewProposalsTransportSettings,
            settings.batchRequestBuyerReviewProposalsSettings(),
            clientContext);
    this.batchRequestBuyerAcceptProposalsCallable =
        callableFactory.createUnaryCallable(
            batchRequestBuyerAcceptProposalsTransportSettings,
            settings.batchRequestBuyerAcceptProposalsSettings(),
            clientContext);
    this.batchReserveProposalsCallable =
        callableFactory.createUnaryCallable(
            batchReserveProposalsTransportSettings,
            settings.batchReserveProposalsSettings(),
            clientContext);
    this.batchRedraftProposalsCallable =
        callableFactory.createUnaryCallable(
            batchRedraftProposalsTransportSettings,
            settings.batchRedraftProposalsSettings(),
            clientContext);
    this.batchDiscardDraftProposalsCallable =
        callableFactory.createUnaryCallable(
            batchDiscardDraftProposalsTransportSettings,
            settings.batchDiscardDraftProposalsSettings(),
            clientContext);
    this.batchTerminateProposalsCallable =
        callableFactory.createUnaryCallable(
            batchTerminateProposalsTransportSettings,
            settings.batchTerminateProposalsSettings(),
            clientContext);
    this.batchPushToOrderProposalsCallable =
        callableFactory.createUnaryCallable(
            batchPushToOrderProposalsTransportSettings,
            settings.batchPushToOrderProposalsSettings(),
            clientContext);
    this.fetchMarketplaceCommentsCallable =
        callableFactory.createUnaryCallable(
            fetchMarketplaceCommentsTransportSettings,
            settings.fetchMarketplaceCommentsSettings(),
            clientContext);
    this.fetchMarketplaceCommentsPagedCallable =
        callableFactory.createPagedCallable(
            fetchMarketplaceCommentsTransportSettings,
            settings.fetchMarketplaceCommentsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getProposalMethodDescriptor);
    methodDescriptors.add(listProposalsMethodDescriptor);
    methodDescriptors.add(createProposalMethodDescriptor);
    methodDescriptors.add(batchCreateProposalsMethodDescriptor);
    methodDescriptors.add(updateProposalMethodDescriptor);
    methodDescriptors.add(batchUpdateProposalsMethodDescriptor);
    methodDescriptors.add(batchArchiveProposalsMethodDescriptor);
    methodDescriptors.add(batchUnarchiveProposalsMethodDescriptor);
    methodDescriptors.add(batchPauseProposalsMethodDescriptor);
    methodDescriptors.add(batchResumeProposalsMethodDescriptor);
    methodDescriptors.add(batchRequestBuyerReviewProposalsMethodDescriptor);
    methodDescriptors.add(batchRequestBuyerAcceptProposalsMethodDescriptor);
    methodDescriptors.add(batchReserveProposalsMethodDescriptor);
    methodDescriptors.add(batchRedraftProposalsMethodDescriptor);
    methodDescriptors.add(batchDiscardDraftProposalsMethodDescriptor);
    methodDescriptors.add(batchTerminateProposalsMethodDescriptor);
    methodDescriptors.add(batchPushToOrderProposalsMethodDescriptor);
    methodDescriptors.add(fetchMarketplaceCommentsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetProposalRequest, Proposal> getProposalCallable() {
    return getProposalCallable;
  }

  @Override
  public UnaryCallable<ListProposalsRequest, ListProposalsResponse> listProposalsCallable() {
    return listProposalsCallable;
  }

  @Override
  public UnaryCallable<ListProposalsRequest, ListProposalsPagedResponse>
      listProposalsPagedCallable() {
    return listProposalsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateProposalRequest, Proposal> createProposalCallable() {
    return createProposalCallable;
  }

  @Override
  public UnaryCallable<BatchCreateProposalsRequest, BatchCreateProposalsResponse>
      batchCreateProposalsCallable() {
    return batchCreateProposalsCallable;
  }

  @Override
  public UnaryCallable<UpdateProposalRequest, Proposal> updateProposalCallable() {
    return updateProposalCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>
      batchUpdateProposalsCallable() {
    return batchUpdateProposalsCallable;
  }

  @Override
  public UnaryCallable<BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>
      batchArchiveProposalsCallable() {
    return batchArchiveProposalsCallable;
  }

  @Override
  public UnaryCallable<BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>
      batchUnarchiveProposalsCallable() {
    return batchUnarchiveProposalsCallable;
  }

  @Override
  public UnaryCallable<BatchPauseProposalsRequest, BatchPauseProposalsResponse>
      batchPauseProposalsCallable() {
    return batchPauseProposalsCallable;
  }

  @Override
  public UnaryCallable<BatchResumeProposalsRequest, BatchResumeProposalsResponse>
      batchResumeProposalsCallable() {
    return batchResumeProposalsCallable;
  }

  @Override
  public UnaryCallable<
          BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
      batchRequestBuyerReviewProposalsCallable() {
    return batchRequestBuyerReviewProposalsCallable;
  }

  @Override
  public UnaryCallable<
          BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
      batchRequestBuyerAcceptProposalsCallable() {
    return batchRequestBuyerAcceptProposalsCallable;
  }

  @Override
  public UnaryCallable<BatchReserveProposalsRequest, BatchReserveProposalsResponse>
      batchReserveProposalsCallable() {
    return batchReserveProposalsCallable;
  }

  @Override
  public UnaryCallable<BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>
      batchRedraftProposalsCallable() {
    return batchRedraftProposalsCallable;
  }

  @Override
  public UnaryCallable<BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>
      batchDiscardDraftProposalsCallable() {
    return batchDiscardDraftProposalsCallable;
  }

  @Override
  public UnaryCallable<BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>
      batchTerminateProposalsCallable() {
    return batchTerminateProposalsCallable;
  }

  @Override
  public UnaryCallable<BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>
      batchPushToOrderProposalsCallable() {
    return batchPushToOrderProposalsCallable;
  }

  @Override
  public UnaryCallable<FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsResponse>
      fetchMarketplaceCommentsCallable() {
    return fetchMarketplaceCommentsCallable;
  }

  @Override
  public UnaryCallable<FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsPagedResponse>
      fetchMarketplaceCommentsPagedCallable() {
    return fetchMarketplaceCommentsPagedCallable;
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
