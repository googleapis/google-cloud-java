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

package com.google.cloud.support.v2.stub;

import static com.google.cloud.support.v2.CaseServiceClient.ListCasesPagedResponse;
import static com.google.cloud.support.v2.CaseServiceClient.SearchCaseClassificationsPagedResponse;
import static com.google.cloud.support.v2.CaseServiceClient.SearchCasesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2.Case;
import com.google.cloud.support.v2.CloseCaseRequest;
import com.google.cloud.support.v2.CreateCaseRequest;
import com.google.cloud.support.v2.EscalateCaseRequest;
import com.google.cloud.support.v2.GetCaseRequest;
import com.google.cloud.support.v2.ListCasesRequest;
import com.google.cloud.support.v2.ListCasesResponse;
import com.google.cloud.support.v2.SearchCaseClassificationsRequest;
import com.google.cloud.support.v2.SearchCaseClassificationsResponse;
import com.google.cloud.support.v2.SearchCasesRequest;
import com.google.cloud.support.v2.SearchCasesResponse;
import com.google.cloud.support.v2.UpdateCaseRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CaseService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCaseServiceStub extends CaseServiceStub {
  private static final MethodDescriptor<GetCaseRequest, Case> getCaseMethodDescriptor =
      MethodDescriptor.<GetCaseRequest, Case>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.support.v2.CaseService/GetCase")
          .setRequestMarshaller(ProtoUtils.marshaller(GetCaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Case.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListCasesRequest, ListCasesResponse>
      listCasesMethodDescriptor =
          MethodDescriptor.<ListCasesRequest, ListCasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.support.v2.CaseService/ListCases")
              .setRequestMarshaller(ProtoUtils.marshaller(ListCasesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListCasesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchCasesRequest, SearchCasesResponse>
      searchCasesMethodDescriptor =
          MethodDescriptor.<SearchCasesRequest, SearchCasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.support.v2.CaseService/SearchCases")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchCasesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchCasesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCaseRequest, Case> createCaseMethodDescriptor =
      MethodDescriptor.<CreateCaseRequest, Case>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.support.v2.CaseService/CreateCase")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateCaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Case.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateCaseRequest, Case> updateCaseMethodDescriptor =
      MethodDescriptor.<UpdateCaseRequest, Case>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.support.v2.CaseService/UpdateCase")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateCaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Case.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<EscalateCaseRequest, Case> escalateCaseMethodDescriptor =
      MethodDescriptor.<EscalateCaseRequest, Case>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.support.v2.CaseService/EscalateCase")
          .setRequestMarshaller(ProtoUtils.marshaller(EscalateCaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Case.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CloseCaseRequest, Case> closeCaseMethodDescriptor =
      MethodDescriptor.<CloseCaseRequest, Case>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.support.v2.CaseService/CloseCase")
          .setRequestMarshaller(ProtoUtils.marshaller(CloseCaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Case.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<
          SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>
      searchCaseClassificationsMethodDescriptor =
          MethodDescriptor
              .<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.support.v2.CaseService/SearchCaseClassifications")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchCaseClassificationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchCaseClassificationsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetCaseRequest, Case> getCaseCallable;
  private final UnaryCallable<ListCasesRequest, ListCasesResponse> listCasesCallable;
  private final UnaryCallable<ListCasesRequest, ListCasesPagedResponse> listCasesPagedCallable;
  private final UnaryCallable<SearchCasesRequest, SearchCasesResponse> searchCasesCallable;
  private final UnaryCallable<SearchCasesRequest, SearchCasesPagedResponse>
      searchCasesPagedCallable;
  private final UnaryCallable<CreateCaseRequest, Case> createCaseCallable;
  private final UnaryCallable<UpdateCaseRequest, Case> updateCaseCallable;
  private final UnaryCallable<EscalateCaseRequest, Case> escalateCaseCallable;
  private final UnaryCallable<CloseCaseRequest, Case> closeCaseCallable;
  private final UnaryCallable<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>
      searchCaseClassificationsCallable;
  private final UnaryCallable<
          SearchCaseClassificationsRequest, SearchCaseClassificationsPagedResponse>
      searchCaseClassificationsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCaseServiceStub create(CaseServiceStubSettings settings)
      throws IOException {
    return new GrpcCaseServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCaseServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcCaseServiceStub(CaseServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCaseServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCaseServiceStub(
        CaseServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCaseServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCaseServiceStub(CaseServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCaseServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCaseServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCaseServiceStub(
      CaseServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetCaseRequest, Case> getCaseTransportSettings =
        GrpcCallSettings.<GetCaseRequest, Case>newBuilder()
            .setMethodDescriptor(getCaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCasesRequest, ListCasesResponse> listCasesTransportSettings =
        GrpcCallSettings.<ListCasesRequest, ListCasesResponse>newBuilder()
            .setMethodDescriptor(listCasesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchCasesRequest, SearchCasesResponse> searchCasesTransportSettings =
        GrpcCallSettings.<SearchCasesRequest, SearchCasesResponse>newBuilder()
            .setMethodDescriptor(searchCasesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateCaseRequest, Case> createCaseTransportSettings =
        GrpcCallSettings.<CreateCaseRequest, Case>newBuilder()
            .setMethodDescriptor(createCaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateCaseRequest, Case> updateCaseTransportSettings =
        GrpcCallSettings.<UpdateCaseRequest, Case>newBuilder()
            .setMethodDescriptor(updateCaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("case.name", String.valueOf(request.getCase().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<EscalateCaseRequest, Case> escalateCaseTransportSettings =
        GrpcCallSettings.<EscalateCaseRequest, Case>newBuilder()
            .setMethodDescriptor(escalateCaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CloseCaseRequest, Case> closeCaseTransportSettings =
        GrpcCallSettings.<CloseCaseRequest, Case>newBuilder()
            .setMethodDescriptor(closeCaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>
        searchCaseClassificationsTransportSettings =
            GrpcCallSettings
                .<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>newBuilder()
                .setMethodDescriptor(searchCaseClassificationsMethodDescriptor)
                .build();

    this.getCaseCallable =
        callableFactory.createUnaryCallable(
            getCaseTransportSettings, settings.getCaseSettings(), clientContext);
    this.listCasesCallable =
        callableFactory.createUnaryCallable(
            listCasesTransportSettings, settings.listCasesSettings(), clientContext);
    this.listCasesPagedCallable =
        callableFactory.createPagedCallable(
            listCasesTransportSettings, settings.listCasesSettings(), clientContext);
    this.searchCasesCallable =
        callableFactory.createUnaryCallable(
            searchCasesTransportSettings, settings.searchCasesSettings(), clientContext);
    this.searchCasesPagedCallable =
        callableFactory.createPagedCallable(
            searchCasesTransportSettings, settings.searchCasesSettings(), clientContext);
    this.createCaseCallable =
        callableFactory.createUnaryCallable(
            createCaseTransportSettings, settings.createCaseSettings(), clientContext);
    this.updateCaseCallable =
        callableFactory.createUnaryCallable(
            updateCaseTransportSettings, settings.updateCaseSettings(), clientContext);
    this.escalateCaseCallable =
        callableFactory.createUnaryCallable(
            escalateCaseTransportSettings, settings.escalateCaseSettings(), clientContext);
    this.closeCaseCallable =
        callableFactory.createUnaryCallable(
            closeCaseTransportSettings, settings.closeCaseSettings(), clientContext);
    this.searchCaseClassificationsCallable =
        callableFactory.createUnaryCallable(
            searchCaseClassificationsTransportSettings,
            settings.searchCaseClassificationsSettings(),
            clientContext);
    this.searchCaseClassificationsPagedCallable =
        callableFactory.createPagedCallable(
            searchCaseClassificationsTransportSettings,
            settings.searchCaseClassificationsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetCaseRequest, Case> getCaseCallable() {
    return getCaseCallable;
  }

  @Override
  public UnaryCallable<ListCasesRequest, ListCasesResponse> listCasesCallable() {
    return listCasesCallable;
  }

  @Override
  public UnaryCallable<ListCasesRequest, ListCasesPagedResponse> listCasesPagedCallable() {
    return listCasesPagedCallable;
  }

  @Override
  public UnaryCallable<SearchCasesRequest, SearchCasesResponse> searchCasesCallable() {
    return searchCasesCallable;
  }

  @Override
  public UnaryCallable<SearchCasesRequest, SearchCasesPagedResponse> searchCasesPagedCallable() {
    return searchCasesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateCaseRequest, Case> createCaseCallable() {
    return createCaseCallable;
  }

  @Override
  public UnaryCallable<UpdateCaseRequest, Case> updateCaseCallable() {
    return updateCaseCallable;
  }

  @Override
  public UnaryCallable<EscalateCaseRequest, Case> escalateCaseCallable() {
    return escalateCaseCallable;
  }

  @Override
  public UnaryCallable<CloseCaseRequest, Case> closeCaseCallable() {
    return closeCaseCallable;
  }

  @Override
  public UnaryCallable<SearchCaseClassificationsRequest, SearchCaseClassificationsResponse>
      searchCaseClassificationsCallable() {
    return searchCaseClassificationsCallable;
  }

  @Override
  public UnaryCallable<SearchCaseClassificationsRequest, SearchCaseClassificationsPagedResponse>
      searchCaseClassificationsPagedCallable() {
    return searchCaseClassificationsPagedCallable;
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
