/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossariesPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossaryCategoriesPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossaryTermsPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.CreateGlossaryRequest;
import com.google.cloud.dataplex.v1.CreateGlossaryTermRequest;
import com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.DeleteGlossaryRequest;
import com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest;
import com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.GetGlossaryRequest;
import com.google.cloud.dataplex.v1.GetGlossaryTermRequest;
import com.google.cloud.dataplex.v1.Glossary;
import com.google.cloud.dataplex.v1.GlossaryCategory;
import com.google.cloud.dataplex.v1.GlossaryTerm;
import com.google.cloud.dataplex.v1.ListGlossariesRequest;
import com.google.cloud.dataplex.v1.ListGlossariesResponse;
import com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest;
import com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse;
import com.google.cloud.dataplex.v1.ListGlossaryTermsRequest;
import com.google.cloud.dataplex.v1.ListGlossaryTermsResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.UpdateGlossaryRequest;
import com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * gRPC stub implementation for the BusinessGlossaryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcBusinessGlossaryServiceStub extends BusinessGlossaryServiceStub {
  private static final MethodDescriptor<CreateGlossaryRequest, Operation>
      createGlossaryMethodDescriptor =
          MethodDescriptor.<CreateGlossaryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.BusinessGlossaryService/CreateGlossary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGlossaryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateGlossaryRequest, Operation>
      updateGlossaryMethodDescriptor =
          MethodDescriptor.<UpdateGlossaryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.BusinessGlossaryService/UpdateGlossary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGlossaryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteGlossaryRequest, Operation>
      deleteGlossaryMethodDescriptor =
          MethodDescriptor.<DeleteGlossaryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.BusinessGlossaryService/DeleteGlossary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGlossaryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetGlossaryRequest, Glossary> getGlossaryMethodDescriptor =
      MethodDescriptor.<GetGlossaryRequest, Glossary>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.BusinessGlossaryService/GetGlossary")
          .setRequestMarshaller(ProtoUtils.marshaller(GetGlossaryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Glossary.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListGlossariesRequest, ListGlossariesResponse>
      listGlossariesMethodDescriptor =
          MethodDescriptor.<ListGlossariesRequest, ListGlossariesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.BusinessGlossaryService/ListGlossaries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGlossariesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGlossariesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateGlossaryCategoryRequest, GlossaryCategory>
      createGlossaryCategoryMethodDescriptor =
          MethodDescriptor.<CreateGlossaryCategoryRequest, GlossaryCategory>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/CreateGlossaryCategory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGlossaryCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GlossaryCategory.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateGlossaryCategoryRequest, GlossaryCategory>
      updateGlossaryCategoryMethodDescriptor =
          MethodDescriptor.<UpdateGlossaryCategoryRequest, GlossaryCategory>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/UpdateGlossaryCategory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGlossaryCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GlossaryCategory.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteGlossaryCategoryRequest, Empty>
      deleteGlossaryCategoryMethodDescriptor =
          MethodDescriptor.<DeleteGlossaryCategoryRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/DeleteGlossaryCategory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGlossaryCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetGlossaryCategoryRequest, GlossaryCategory>
      getGlossaryCategoryMethodDescriptor =
          MethodDescriptor.<GetGlossaryCategoryRequest, GlossaryCategory>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/GetGlossaryCategory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGlossaryCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GlossaryCategory.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>
      listGlossaryCategoriesMethodDescriptor =
          MethodDescriptor
              .<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/ListGlossaryCategories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGlossaryCategoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGlossaryCategoriesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateGlossaryTermRequest, GlossaryTerm>
      createGlossaryTermMethodDescriptor =
          MethodDescriptor.<CreateGlossaryTermRequest, GlossaryTerm>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/CreateGlossaryTerm")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGlossaryTermRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GlossaryTerm.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateGlossaryTermRequest, GlossaryTerm>
      updateGlossaryTermMethodDescriptor =
          MethodDescriptor.<UpdateGlossaryTermRequest, GlossaryTerm>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/UpdateGlossaryTerm")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGlossaryTermRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GlossaryTerm.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteGlossaryTermRequest, Empty>
      deleteGlossaryTermMethodDescriptor =
          MethodDescriptor.<DeleteGlossaryTermRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/DeleteGlossaryTerm")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGlossaryTermRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetGlossaryTermRequest, GlossaryTerm>
      getGlossaryTermMethodDescriptor =
          MethodDescriptor.<GetGlossaryTermRequest, GlossaryTerm>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.BusinessGlossaryService/GetGlossaryTerm")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGlossaryTermRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GlossaryTerm.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListGlossaryTermsRequest, ListGlossaryTermsResponse>
      listGlossaryTermsMethodDescriptor =
          MethodDescriptor.<ListGlossaryTermsRequest, ListGlossaryTermsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.BusinessGlossaryService/ListGlossaryTerms")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGlossaryTermsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGlossaryTermsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<CreateGlossaryRequest, Operation> createGlossaryCallable;
  private final OperationCallable<CreateGlossaryRequest, Glossary, OperationMetadata>
      createGlossaryOperationCallable;
  private final UnaryCallable<UpdateGlossaryRequest, Operation> updateGlossaryCallable;
  private final OperationCallable<UpdateGlossaryRequest, Glossary, OperationMetadata>
      updateGlossaryOperationCallable;
  private final UnaryCallable<DeleteGlossaryRequest, Operation> deleteGlossaryCallable;
  private final OperationCallable<DeleteGlossaryRequest, Empty, OperationMetadata>
      deleteGlossaryOperationCallable;
  private final UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable;
  private final UnaryCallable<ListGlossariesRequest, ListGlossariesResponse> listGlossariesCallable;
  private final UnaryCallable<ListGlossariesRequest, ListGlossariesPagedResponse>
      listGlossariesPagedCallable;
  private final UnaryCallable<CreateGlossaryCategoryRequest, GlossaryCategory>
      createGlossaryCategoryCallable;
  private final UnaryCallable<UpdateGlossaryCategoryRequest, GlossaryCategory>
      updateGlossaryCategoryCallable;
  private final UnaryCallable<DeleteGlossaryCategoryRequest, Empty> deleteGlossaryCategoryCallable;
  private final UnaryCallable<GetGlossaryCategoryRequest, GlossaryCategory>
      getGlossaryCategoryCallable;
  private final UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>
      listGlossaryCategoriesCallable;
  private final UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesPagedResponse>
      listGlossaryCategoriesPagedCallable;
  private final UnaryCallable<CreateGlossaryTermRequest, GlossaryTerm> createGlossaryTermCallable;
  private final UnaryCallable<UpdateGlossaryTermRequest, GlossaryTerm> updateGlossaryTermCallable;
  private final UnaryCallable<DeleteGlossaryTermRequest, Empty> deleteGlossaryTermCallable;
  private final UnaryCallable<GetGlossaryTermRequest, GlossaryTerm> getGlossaryTermCallable;
  private final UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsResponse>
      listGlossaryTermsCallable;
  private final UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsPagedResponse>
      listGlossaryTermsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBusinessGlossaryServiceStub create(
      BusinessGlossaryServiceStubSettings settings) throws IOException {
    return new GrpcBusinessGlossaryServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBusinessGlossaryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBusinessGlossaryServiceStub(
        BusinessGlossaryServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBusinessGlossaryServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBusinessGlossaryServiceStub(
        BusinessGlossaryServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBusinessGlossaryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBusinessGlossaryServiceStub(
      BusinessGlossaryServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcBusinessGlossaryServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBusinessGlossaryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBusinessGlossaryServiceStub(
      BusinessGlossaryServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateGlossaryRequest, Operation> createGlossaryTransportSettings =
        GrpcCallSettings.<CreateGlossaryRequest, Operation>newBuilder()
            .setMethodDescriptor(createGlossaryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateGlossaryRequest, Operation> updateGlossaryTransportSettings =
        GrpcCallSettings.<UpdateGlossaryRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGlossaryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("glossary.name", String.valueOf(request.getGlossary().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteGlossaryRequest, Operation> deleteGlossaryTransportSettings =
        GrpcCallSettings.<DeleteGlossaryRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGlossaryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetGlossaryRequest, Glossary> getGlossaryTransportSettings =
        GrpcCallSettings.<GetGlossaryRequest, Glossary>newBuilder()
            .setMethodDescriptor(getGlossaryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGlossariesRequest, ListGlossariesResponse>
        listGlossariesTransportSettings =
            GrpcCallSettings.<ListGlossariesRequest, ListGlossariesResponse>newBuilder()
                .setMethodDescriptor(listGlossariesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateGlossaryCategoryRequest, GlossaryCategory>
        createGlossaryCategoryTransportSettings =
            GrpcCallSettings.<CreateGlossaryCategoryRequest, GlossaryCategory>newBuilder()
                .setMethodDescriptor(createGlossaryCategoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateGlossaryCategoryRequest, GlossaryCategory>
        updateGlossaryCategoryTransportSettings =
            GrpcCallSettings.<UpdateGlossaryCategoryRequest, GlossaryCategory>newBuilder()
                .setMethodDescriptor(updateGlossaryCategoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("category.name", String.valueOf(request.getCategory().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteGlossaryCategoryRequest, Empty> deleteGlossaryCategoryTransportSettings =
        GrpcCallSettings.<DeleteGlossaryCategoryRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteGlossaryCategoryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetGlossaryCategoryRequest, GlossaryCategory>
        getGlossaryCategoryTransportSettings =
            GrpcCallSettings.<GetGlossaryCategoryRequest, GlossaryCategory>newBuilder()
                .setMethodDescriptor(getGlossaryCategoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>
        listGlossaryCategoriesTransportSettings =
            GrpcCallSettings
                .<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>newBuilder()
                .setMethodDescriptor(listGlossaryCategoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateGlossaryTermRequest, GlossaryTerm> createGlossaryTermTransportSettings =
        GrpcCallSettings.<CreateGlossaryTermRequest, GlossaryTerm>newBuilder()
            .setMethodDescriptor(createGlossaryTermMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateGlossaryTermRequest, GlossaryTerm> updateGlossaryTermTransportSettings =
        GrpcCallSettings.<UpdateGlossaryTermRequest, GlossaryTerm>newBuilder()
            .setMethodDescriptor(updateGlossaryTermMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("term.name", String.valueOf(request.getTerm().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteGlossaryTermRequest, Empty> deleteGlossaryTermTransportSettings =
        GrpcCallSettings.<DeleteGlossaryTermRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteGlossaryTermMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetGlossaryTermRequest, GlossaryTerm> getGlossaryTermTransportSettings =
        GrpcCallSettings.<GetGlossaryTermRequest, GlossaryTerm>newBuilder()
            .setMethodDescriptor(getGlossaryTermMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListGlossaryTermsRequest, ListGlossaryTermsResponse>
        listGlossaryTermsTransportSettings =
            GrpcCallSettings.<ListGlossaryTermsRequest, ListGlossaryTermsResponse>newBuilder()
                .setMethodDescriptor(listGlossaryTermsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createGlossaryCallable =
        callableFactory.createUnaryCallable(
            createGlossaryTransportSettings, settings.createGlossarySettings(), clientContext);
    this.createGlossaryOperationCallable =
        callableFactory.createOperationCallable(
            createGlossaryTransportSettings,
            settings.createGlossaryOperationSettings(),
            clientContext,
            operationsStub);
    this.updateGlossaryCallable =
        callableFactory.createUnaryCallable(
            updateGlossaryTransportSettings, settings.updateGlossarySettings(), clientContext);
    this.updateGlossaryOperationCallable =
        callableFactory.createOperationCallable(
            updateGlossaryTransportSettings,
            settings.updateGlossaryOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGlossaryCallable =
        callableFactory.createUnaryCallable(
            deleteGlossaryTransportSettings, settings.deleteGlossarySettings(), clientContext);
    this.deleteGlossaryOperationCallable =
        callableFactory.createOperationCallable(
            deleteGlossaryTransportSettings,
            settings.deleteGlossaryOperationSettings(),
            clientContext,
            operationsStub);
    this.getGlossaryCallable =
        callableFactory.createUnaryCallable(
            getGlossaryTransportSettings, settings.getGlossarySettings(), clientContext);
    this.listGlossariesCallable =
        callableFactory.createUnaryCallable(
            listGlossariesTransportSettings, settings.listGlossariesSettings(), clientContext);
    this.listGlossariesPagedCallable =
        callableFactory.createPagedCallable(
            listGlossariesTransportSettings, settings.listGlossariesSettings(), clientContext);
    this.createGlossaryCategoryCallable =
        callableFactory.createUnaryCallable(
            createGlossaryCategoryTransportSettings,
            settings.createGlossaryCategorySettings(),
            clientContext);
    this.updateGlossaryCategoryCallable =
        callableFactory.createUnaryCallable(
            updateGlossaryCategoryTransportSettings,
            settings.updateGlossaryCategorySettings(),
            clientContext);
    this.deleteGlossaryCategoryCallable =
        callableFactory.createUnaryCallable(
            deleteGlossaryCategoryTransportSettings,
            settings.deleteGlossaryCategorySettings(),
            clientContext);
    this.getGlossaryCategoryCallable =
        callableFactory.createUnaryCallable(
            getGlossaryCategoryTransportSettings,
            settings.getGlossaryCategorySettings(),
            clientContext);
    this.listGlossaryCategoriesCallable =
        callableFactory.createUnaryCallable(
            listGlossaryCategoriesTransportSettings,
            settings.listGlossaryCategoriesSettings(),
            clientContext);
    this.listGlossaryCategoriesPagedCallable =
        callableFactory.createPagedCallable(
            listGlossaryCategoriesTransportSettings,
            settings.listGlossaryCategoriesSettings(),
            clientContext);
    this.createGlossaryTermCallable =
        callableFactory.createUnaryCallable(
            createGlossaryTermTransportSettings,
            settings.createGlossaryTermSettings(),
            clientContext);
    this.updateGlossaryTermCallable =
        callableFactory.createUnaryCallable(
            updateGlossaryTermTransportSettings,
            settings.updateGlossaryTermSettings(),
            clientContext);
    this.deleteGlossaryTermCallable =
        callableFactory.createUnaryCallable(
            deleteGlossaryTermTransportSettings,
            settings.deleteGlossaryTermSettings(),
            clientContext);
    this.getGlossaryTermCallable =
        callableFactory.createUnaryCallable(
            getGlossaryTermTransportSettings, settings.getGlossaryTermSettings(), clientContext);
    this.listGlossaryTermsCallable =
        callableFactory.createUnaryCallable(
            listGlossaryTermsTransportSettings,
            settings.listGlossaryTermsSettings(),
            clientContext);
    this.listGlossaryTermsPagedCallable =
        callableFactory.createPagedCallable(
            listGlossaryTermsTransportSettings,
            settings.listGlossaryTermsSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateGlossaryRequest, Operation> createGlossaryCallable() {
    return createGlossaryCallable;
  }

  @Override
  public OperationCallable<CreateGlossaryRequest, Glossary, OperationMetadata>
      createGlossaryOperationCallable() {
    return createGlossaryOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGlossaryRequest, Operation> updateGlossaryCallable() {
    return updateGlossaryCallable;
  }

  @Override
  public OperationCallable<UpdateGlossaryRequest, Glossary, OperationMetadata>
      updateGlossaryOperationCallable() {
    return updateGlossaryOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGlossaryRequest, Operation> deleteGlossaryCallable() {
    return deleteGlossaryCallable;
  }

  @Override
  public OperationCallable<DeleteGlossaryRequest, Empty, OperationMetadata>
      deleteGlossaryOperationCallable() {
    return deleteGlossaryOperationCallable;
  }

  @Override
  public UnaryCallable<GetGlossaryRequest, Glossary> getGlossaryCallable() {
    return getGlossaryCallable;
  }

  @Override
  public UnaryCallable<ListGlossariesRequest, ListGlossariesResponse> listGlossariesCallable() {
    return listGlossariesCallable;
  }

  @Override
  public UnaryCallable<ListGlossariesRequest, ListGlossariesPagedResponse>
      listGlossariesPagedCallable() {
    return listGlossariesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateGlossaryCategoryRequest, GlossaryCategory>
      createGlossaryCategoryCallable() {
    return createGlossaryCategoryCallable;
  }

  @Override
  public UnaryCallable<UpdateGlossaryCategoryRequest, GlossaryCategory>
      updateGlossaryCategoryCallable() {
    return updateGlossaryCategoryCallable;
  }

  @Override
  public UnaryCallable<DeleteGlossaryCategoryRequest, Empty> deleteGlossaryCategoryCallable() {
    return deleteGlossaryCategoryCallable;
  }

  @Override
  public UnaryCallable<GetGlossaryCategoryRequest, GlossaryCategory> getGlossaryCategoryCallable() {
    return getGlossaryCategoryCallable;
  }

  @Override
  public UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>
      listGlossaryCategoriesCallable() {
    return listGlossaryCategoriesCallable;
  }

  @Override
  public UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesPagedResponse>
      listGlossaryCategoriesPagedCallable() {
    return listGlossaryCategoriesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateGlossaryTermRequest, GlossaryTerm> createGlossaryTermCallable() {
    return createGlossaryTermCallable;
  }

  @Override
  public UnaryCallable<UpdateGlossaryTermRequest, GlossaryTerm> updateGlossaryTermCallable() {
    return updateGlossaryTermCallable;
  }

  @Override
  public UnaryCallable<DeleteGlossaryTermRequest, Empty> deleteGlossaryTermCallable() {
    return deleteGlossaryTermCallable;
  }

  @Override
  public UnaryCallable<GetGlossaryTermRequest, GlossaryTerm> getGlossaryTermCallable() {
    return getGlossaryTermCallable;
  }

  @Override
  public UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsResponse>
      listGlossaryTermsCallable() {
    return listGlossaryTermsCallable;
  }

  @Override
  public UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsPagedResponse>
      listGlossaryTermsPagedCallable() {
    return listGlossaryTermsPagedCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
