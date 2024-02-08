/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.SiteSearchEngineServiceClient.FetchDomainVerificationStatusPagedResponse;
import static com.google.cloud.discoveryengine.v1.SiteSearchEngineServiceClient.ListTargetSitesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.BatchCreateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1.BatchCreateTargetSitesRequest;
import com.google.cloud.discoveryengine.v1.BatchCreateTargetSitesResponse;
import com.google.cloud.discoveryengine.v1.BatchVerifyTargetSitesMetadata;
import com.google.cloud.discoveryengine.v1.BatchVerifyTargetSitesRequest;
import com.google.cloud.discoveryengine.v1.BatchVerifyTargetSitesResponse;
import com.google.cloud.discoveryengine.v1.CreateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1.CreateTargetSiteRequest;
import com.google.cloud.discoveryengine.v1.DeleteTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1.DeleteTargetSiteRequest;
import com.google.cloud.discoveryengine.v1.DisableAdvancedSiteSearchMetadata;
import com.google.cloud.discoveryengine.v1.DisableAdvancedSiteSearchRequest;
import com.google.cloud.discoveryengine.v1.DisableAdvancedSiteSearchResponse;
import com.google.cloud.discoveryengine.v1.EnableAdvancedSiteSearchMetadata;
import com.google.cloud.discoveryengine.v1.EnableAdvancedSiteSearchRequest;
import com.google.cloud.discoveryengine.v1.EnableAdvancedSiteSearchResponse;
import com.google.cloud.discoveryengine.v1.FetchDomainVerificationStatusRequest;
import com.google.cloud.discoveryengine.v1.FetchDomainVerificationStatusResponse;
import com.google.cloud.discoveryengine.v1.GetSiteSearchEngineRequest;
import com.google.cloud.discoveryengine.v1.GetTargetSiteRequest;
import com.google.cloud.discoveryengine.v1.ListTargetSitesRequest;
import com.google.cloud.discoveryengine.v1.ListTargetSitesResponse;
import com.google.cloud.discoveryengine.v1.RecrawlUrisMetadata;
import com.google.cloud.discoveryengine.v1.RecrawlUrisRequest;
import com.google.cloud.discoveryengine.v1.RecrawlUrisResponse;
import com.google.cloud.discoveryengine.v1.SiteSearchEngine;
import com.google.cloud.discoveryengine.v1.TargetSite;
import com.google.cloud.discoveryengine.v1.UpdateTargetSiteMetadata;
import com.google.cloud.discoveryengine.v1.UpdateTargetSiteRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SiteSearchEngineService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSiteSearchEngineServiceStub extends SiteSearchEngineServiceStub {
  private static final MethodDescriptor<GetSiteSearchEngineRequest, SiteSearchEngine>
      getSiteSearchEngineMethodDescriptor =
          MethodDescriptor.<GetSiteSearchEngineRequest, SiteSearchEngine>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.SiteSearchEngineService/GetSiteSearchEngine")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSiteSearchEngineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SiteSearchEngine.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTargetSiteRequest, Operation>
      createTargetSiteMethodDescriptor =
          MethodDescriptor.<CreateTargetSiteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.SiteSearchEngineService/CreateTargetSite")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTargetSiteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchCreateTargetSitesRequest, Operation>
      batchCreateTargetSitesMethodDescriptor =
          MethodDescriptor.<BatchCreateTargetSitesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.SiteSearchEngineService/BatchCreateTargetSites")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateTargetSitesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTargetSiteRequest, TargetSite>
      getTargetSiteMethodDescriptor =
          MethodDescriptor.<GetTargetSiteRequest, TargetSite>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.SiteSearchEngineService/GetTargetSite")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTargetSiteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TargetSite.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTargetSiteRequest, Operation>
      updateTargetSiteMethodDescriptor =
          MethodDescriptor.<UpdateTargetSiteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.SiteSearchEngineService/UpdateTargetSite")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTargetSiteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTargetSiteRequest, Operation>
      deleteTargetSiteMethodDescriptor =
          MethodDescriptor.<DeleteTargetSiteRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.SiteSearchEngineService/DeleteTargetSite")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTargetSiteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTargetSitesRequest, ListTargetSitesResponse>
      listTargetSitesMethodDescriptor =
          MethodDescriptor.<ListTargetSitesRequest, ListTargetSitesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.SiteSearchEngineService/ListTargetSites")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTargetSitesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTargetSitesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EnableAdvancedSiteSearchRequest, Operation>
      enableAdvancedSiteSearchMethodDescriptor =
          MethodDescriptor.<EnableAdvancedSiteSearchRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.SiteSearchEngineService/EnableAdvancedSiteSearch")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableAdvancedSiteSearchRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DisableAdvancedSiteSearchRequest, Operation>
      disableAdvancedSiteSearchMethodDescriptor =
          MethodDescriptor.<DisableAdvancedSiteSearchRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.SiteSearchEngineService/DisableAdvancedSiteSearch")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableAdvancedSiteSearchRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RecrawlUrisRequest, Operation> recrawlUrisMethodDescriptor =
      MethodDescriptor.<RecrawlUrisRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.discoveryengine.v1.SiteSearchEngineService/RecrawlUris")
          .setRequestMarshaller(ProtoUtils.marshaller(RecrawlUrisRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<BatchVerifyTargetSitesRequest, Operation>
      batchVerifyTargetSitesMethodDescriptor =
          MethodDescriptor.<BatchVerifyTargetSitesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.SiteSearchEngineService/BatchVerifyTargetSites")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchVerifyTargetSitesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
      fetchDomainVerificationStatusMethodDescriptor =
          MethodDescriptor
              .<FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.SiteSearchEngineService/FetchDomainVerificationStatus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchDomainVerificationStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchDomainVerificationStatusResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetSiteSearchEngineRequest, SiteSearchEngine>
      getSiteSearchEngineCallable;
  private final UnaryCallable<CreateTargetSiteRequest, Operation> createTargetSiteCallable;
  private final OperationCallable<CreateTargetSiteRequest, TargetSite, CreateTargetSiteMetadata>
      createTargetSiteOperationCallable;
  private final UnaryCallable<BatchCreateTargetSitesRequest, Operation>
      batchCreateTargetSitesCallable;
  private final OperationCallable<
          BatchCreateTargetSitesRequest,
          BatchCreateTargetSitesResponse,
          BatchCreateTargetSiteMetadata>
      batchCreateTargetSitesOperationCallable;
  private final UnaryCallable<GetTargetSiteRequest, TargetSite> getTargetSiteCallable;
  private final UnaryCallable<UpdateTargetSiteRequest, Operation> updateTargetSiteCallable;
  private final OperationCallable<UpdateTargetSiteRequest, TargetSite, UpdateTargetSiteMetadata>
      updateTargetSiteOperationCallable;
  private final UnaryCallable<DeleteTargetSiteRequest, Operation> deleteTargetSiteCallable;
  private final OperationCallable<DeleteTargetSiteRequest, Empty, DeleteTargetSiteMetadata>
      deleteTargetSiteOperationCallable;
  private final UnaryCallable<ListTargetSitesRequest, ListTargetSitesResponse>
      listTargetSitesCallable;
  private final UnaryCallable<ListTargetSitesRequest, ListTargetSitesPagedResponse>
      listTargetSitesPagedCallable;
  private final UnaryCallable<EnableAdvancedSiteSearchRequest, Operation>
      enableAdvancedSiteSearchCallable;
  private final OperationCallable<
          EnableAdvancedSiteSearchRequest,
          EnableAdvancedSiteSearchResponse,
          EnableAdvancedSiteSearchMetadata>
      enableAdvancedSiteSearchOperationCallable;
  private final UnaryCallable<DisableAdvancedSiteSearchRequest, Operation>
      disableAdvancedSiteSearchCallable;
  private final OperationCallable<
          DisableAdvancedSiteSearchRequest,
          DisableAdvancedSiteSearchResponse,
          DisableAdvancedSiteSearchMetadata>
      disableAdvancedSiteSearchOperationCallable;
  private final UnaryCallable<RecrawlUrisRequest, Operation> recrawlUrisCallable;
  private final OperationCallable<RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
      recrawlUrisOperationCallable;
  private final UnaryCallable<BatchVerifyTargetSitesRequest, Operation>
      batchVerifyTargetSitesCallable;
  private final OperationCallable<
          BatchVerifyTargetSitesRequest,
          BatchVerifyTargetSitesResponse,
          BatchVerifyTargetSitesMetadata>
      batchVerifyTargetSitesOperationCallable;
  private final UnaryCallable<
          FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
      fetchDomainVerificationStatusCallable;
  private final UnaryCallable<
          FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusPagedResponse>
      fetchDomainVerificationStatusPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSiteSearchEngineServiceStub create(
      SiteSearchEngineServiceStubSettings settings) throws IOException {
    return new GrpcSiteSearchEngineServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSiteSearchEngineServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSiteSearchEngineServiceStub(
        SiteSearchEngineServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSiteSearchEngineServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSiteSearchEngineServiceStub(
        SiteSearchEngineServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSiteSearchEngineServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSiteSearchEngineServiceStub(
      SiteSearchEngineServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSiteSearchEngineServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSiteSearchEngineServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSiteSearchEngineServiceStub(
      SiteSearchEngineServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetSiteSearchEngineRequest, SiteSearchEngine>
        getSiteSearchEngineTransportSettings =
            GrpcCallSettings.<GetSiteSearchEngineRequest, SiteSearchEngine>newBuilder()
                .setMethodDescriptor(getSiteSearchEngineMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateTargetSiteRequest, Operation> createTargetSiteTransportSettings =
        GrpcCallSettings.<CreateTargetSiteRequest, Operation>newBuilder()
            .setMethodDescriptor(createTargetSiteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchCreateTargetSitesRequest, Operation>
        batchCreateTargetSitesTransportSettings =
            GrpcCallSettings.<BatchCreateTargetSitesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchCreateTargetSitesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetTargetSiteRequest, TargetSite> getTargetSiteTransportSettings =
        GrpcCallSettings.<GetTargetSiteRequest, TargetSite>newBuilder()
            .setMethodDescriptor(getTargetSiteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateTargetSiteRequest, Operation> updateTargetSiteTransportSettings =
        GrpcCallSettings.<UpdateTargetSiteRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTargetSiteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "target_site.name", String.valueOf(request.getTargetSite().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteTargetSiteRequest, Operation> deleteTargetSiteTransportSettings =
        GrpcCallSettings.<DeleteTargetSiteRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTargetSiteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTargetSitesRequest, ListTargetSitesResponse>
        listTargetSitesTransportSettings =
            GrpcCallSettings.<ListTargetSitesRequest, ListTargetSitesResponse>newBuilder()
                .setMethodDescriptor(listTargetSitesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<EnableAdvancedSiteSearchRequest, Operation>
        enableAdvancedSiteSearchTransportSettings =
            GrpcCallSettings.<EnableAdvancedSiteSearchRequest, Operation>newBuilder()
                .setMethodDescriptor(enableAdvancedSiteSearchMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "site_search_engine", String.valueOf(request.getSiteSearchEngine()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DisableAdvancedSiteSearchRequest, Operation>
        disableAdvancedSiteSearchTransportSettings =
            GrpcCallSettings.<DisableAdvancedSiteSearchRequest, Operation>newBuilder()
                .setMethodDescriptor(disableAdvancedSiteSearchMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "site_search_engine", String.valueOf(request.getSiteSearchEngine()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RecrawlUrisRequest, Operation> recrawlUrisTransportSettings =
        GrpcCallSettings.<RecrawlUrisRequest, Operation>newBuilder()
            .setMethodDescriptor(recrawlUrisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("site_search_engine", String.valueOf(request.getSiteSearchEngine()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchVerifyTargetSitesRequest, Operation>
        batchVerifyTargetSitesTransportSettings =
            GrpcCallSettings.<BatchVerifyTargetSitesRequest, Operation>newBuilder()
                .setMethodDescriptor(batchVerifyTargetSitesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
        fetchDomainVerificationStatusTransportSettings =
            GrpcCallSettings
                .<FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
                    newBuilder()
                .setMethodDescriptor(fetchDomainVerificationStatusMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "site_search_engine", String.valueOf(request.getSiteSearchEngine()));
                      return builder.build();
                    })
                .build();

    this.getSiteSearchEngineCallable =
        callableFactory.createUnaryCallable(
            getSiteSearchEngineTransportSettings,
            settings.getSiteSearchEngineSettings(),
            clientContext);
    this.createTargetSiteCallable =
        callableFactory.createUnaryCallable(
            createTargetSiteTransportSettings, settings.createTargetSiteSettings(), clientContext);
    this.createTargetSiteOperationCallable =
        callableFactory.createOperationCallable(
            createTargetSiteTransportSettings,
            settings.createTargetSiteOperationSettings(),
            clientContext,
            operationsStub);
    this.batchCreateTargetSitesCallable =
        callableFactory.createUnaryCallable(
            batchCreateTargetSitesTransportSettings,
            settings.batchCreateTargetSitesSettings(),
            clientContext);
    this.batchCreateTargetSitesOperationCallable =
        callableFactory.createOperationCallable(
            batchCreateTargetSitesTransportSettings,
            settings.batchCreateTargetSitesOperationSettings(),
            clientContext,
            operationsStub);
    this.getTargetSiteCallable =
        callableFactory.createUnaryCallable(
            getTargetSiteTransportSettings, settings.getTargetSiteSettings(), clientContext);
    this.updateTargetSiteCallable =
        callableFactory.createUnaryCallable(
            updateTargetSiteTransportSettings, settings.updateTargetSiteSettings(), clientContext);
    this.updateTargetSiteOperationCallable =
        callableFactory.createOperationCallable(
            updateTargetSiteTransportSettings,
            settings.updateTargetSiteOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTargetSiteCallable =
        callableFactory.createUnaryCallable(
            deleteTargetSiteTransportSettings, settings.deleteTargetSiteSettings(), clientContext);
    this.deleteTargetSiteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTargetSiteTransportSettings,
            settings.deleteTargetSiteOperationSettings(),
            clientContext,
            operationsStub);
    this.listTargetSitesCallable =
        callableFactory.createUnaryCallable(
            listTargetSitesTransportSettings, settings.listTargetSitesSettings(), clientContext);
    this.listTargetSitesPagedCallable =
        callableFactory.createPagedCallable(
            listTargetSitesTransportSettings, settings.listTargetSitesSettings(), clientContext);
    this.enableAdvancedSiteSearchCallable =
        callableFactory.createUnaryCallable(
            enableAdvancedSiteSearchTransportSettings,
            settings.enableAdvancedSiteSearchSettings(),
            clientContext);
    this.enableAdvancedSiteSearchOperationCallable =
        callableFactory.createOperationCallable(
            enableAdvancedSiteSearchTransportSettings,
            settings.enableAdvancedSiteSearchOperationSettings(),
            clientContext,
            operationsStub);
    this.disableAdvancedSiteSearchCallable =
        callableFactory.createUnaryCallable(
            disableAdvancedSiteSearchTransportSettings,
            settings.disableAdvancedSiteSearchSettings(),
            clientContext);
    this.disableAdvancedSiteSearchOperationCallable =
        callableFactory.createOperationCallable(
            disableAdvancedSiteSearchTransportSettings,
            settings.disableAdvancedSiteSearchOperationSettings(),
            clientContext,
            operationsStub);
    this.recrawlUrisCallable =
        callableFactory.createUnaryCallable(
            recrawlUrisTransportSettings, settings.recrawlUrisSettings(), clientContext);
    this.recrawlUrisOperationCallable =
        callableFactory.createOperationCallable(
            recrawlUrisTransportSettings,
            settings.recrawlUrisOperationSettings(),
            clientContext,
            operationsStub);
    this.batchVerifyTargetSitesCallable =
        callableFactory.createUnaryCallable(
            batchVerifyTargetSitesTransportSettings,
            settings.batchVerifyTargetSitesSettings(),
            clientContext);
    this.batchVerifyTargetSitesOperationCallable =
        callableFactory.createOperationCallable(
            batchVerifyTargetSitesTransportSettings,
            settings.batchVerifyTargetSitesOperationSettings(),
            clientContext,
            operationsStub);
    this.fetchDomainVerificationStatusCallable =
        callableFactory.createUnaryCallable(
            fetchDomainVerificationStatusTransportSettings,
            settings.fetchDomainVerificationStatusSettings(),
            clientContext);
    this.fetchDomainVerificationStatusPagedCallable =
        callableFactory.createPagedCallable(
            fetchDomainVerificationStatusTransportSettings,
            settings.fetchDomainVerificationStatusSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetSiteSearchEngineRequest, SiteSearchEngine> getSiteSearchEngineCallable() {
    return getSiteSearchEngineCallable;
  }

  @Override
  public UnaryCallable<CreateTargetSiteRequest, Operation> createTargetSiteCallable() {
    return createTargetSiteCallable;
  }

  @Override
  public OperationCallable<CreateTargetSiteRequest, TargetSite, CreateTargetSiteMetadata>
      createTargetSiteOperationCallable() {
    return createTargetSiteOperationCallable;
  }

  @Override
  public UnaryCallable<BatchCreateTargetSitesRequest, Operation> batchCreateTargetSitesCallable() {
    return batchCreateTargetSitesCallable;
  }

  @Override
  public OperationCallable<
          BatchCreateTargetSitesRequest,
          BatchCreateTargetSitesResponse,
          BatchCreateTargetSiteMetadata>
      batchCreateTargetSitesOperationCallable() {
    return batchCreateTargetSitesOperationCallable;
  }

  @Override
  public UnaryCallable<GetTargetSiteRequest, TargetSite> getTargetSiteCallable() {
    return getTargetSiteCallable;
  }

  @Override
  public UnaryCallable<UpdateTargetSiteRequest, Operation> updateTargetSiteCallable() {
    return updateTargetSiteCallable;
  }

  @Override
  public OperationCallable<UpdateTargetSiteRequest, TargetSite, UpdateTargetSiteMetadata>
      updateTargetSiteOperationCallable() {
    return updateTargetSiteOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTargetSiteRequest, Operation> deleteTargetSiteCallable() {
    return deleteTargetSiteCallable;
  }

  @Override
  public OperationCallable<DeleteTargetSiteRequest, Empty, DeleteTargetSiteMetadata>
      deleteTargetSiteOperationCallable() {
    return deleteTargetSiteOperationCallable;
  }

  @Override
  public UnaryCallable<ListTargetSitesRequest, ListTargetSitesResponse> listTargetSitesCallable() {
    return listTargetSitesCallable;
  }

  @Override
  public UnaryCallable<ListTargetSitesRequest, ListTargetSitesPagedResponse>
      listTargetSitesPagedCallable() {
    return listTargetSitesPagedCallable;
  }

  @Override
  public UnaryCallable<EnableAdvancedSiteSearchRequest, Operation>
      enableAdvancedSiteSearchCallable() {
    return enableAdvancedSiteSearchCallable;
  }

  @Override
  public OperationCallable<
          EnableAdvancedSiteSearchRequest,
          EnableAdvancedSiteSearchResponse,
          EnableAdvancedSiteSearchMetadata>
      enableAdvancedSiteSearchOperationCallable() {
    return enableAdvancedSiteSearchOperationCallable;
  }

  @Override
  public UnaryCallable<DisableAdvancedSiteSearchRequest, Operation>
      disableAdvancedSiteSearchCallable() {
    return disableAdvancedSiteSearchCallable;
  }

  @Override
  public OperationCallable<
          DisableAdvancedSiteSearchRequest,
          DisableAdvancedSiteSearchResponse,
          DisableAdvancedSiteSearchMetadata>
      disableAdvancedSiteSearchOperationCallable() {
    return disableAdvancedSiteSearchOperationCallable;
  }

  @Override
  public UnaryCallable<RecrawlUrisRequest, Operation> recrawlUrisCallable() {
    return recrawlUrisCallable;
  }

  @Override
  public OperationCallable<RecrawlUrisRequest, RecrawlUrisResponse, RecrawlUrisMetadata>
      recrawlUrisOperationCallable() {
    return recrawlUrisOperationCallable;
  }

  @Override
  public UnaryCallable<BatchVerifyTargetSitesRequest, Operation> batchVerifyTargetSitesCallable() {
    return batchVerifyTargetSitesCallable;
  }

  @Override
  public OperationCallable<
          BatchVerifyTargetSitesRequest,
          BatchVerifyTargetSitesResponse,
          BatchVerifyTargetSitesMetadata>
      batchVerifyTargetSitesOperationCallable() {
    return batchVerifyTargetSitesOperationCallable;
  }

  @Override
  public UnaryCallable<FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusResponse>
      fetchDomainVerificationStatusCallable() {
    return fetchDomainVerificationStatusCallable;
  }

  @Override
  public UnaryCallable<
          FetchDomainVerificationStatusRequest, FetchDomainVerificationStatusPagedResponse>
      fetchDomainVerificationStatusPagedCallable() {
    return fetchDomainVerificationStatusPagedCallable;
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
