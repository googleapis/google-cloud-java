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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListAspectTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntriesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryGroupsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListEntryTypesPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.CatalogServiceClient.SearchEntriesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.AspectType;
import com.google.cloud.dataplex.v1.CreateAspectTypeRequest;
import com.google.cloud.dataplex.v1.CreateEntryGroupRequest;
import com.google.cloud.dataplex.v1.CreateEntryRequest;
import com.google.cloud.dataplex.v1.CreateEntryTypeRequest;
import com.google.cloud.dataplex.v1.DeleteAspectTypeRequest;
import com.google.cloud.dataplex.v1.DeleteEntryGroupRequest;
import com.google.cloud.dataplex.v1.DeleteEntryRequest;
import com.google.cloud.dataplex.v1.DeleteEntryTypeRequest;
import com.google.cloud.dataplex.v1.Entry;
import com.google.cloud.dataplex.v1.EntryGroup;
import com.google.cloud.dataplex.v1.EntryType;
import com.google.cloud.dataplex.v1.GetAspectTypeRequest;
import com.google.cloud.dataplex.v1.GetEntryGroupRequest;
import com.google.cloud.dataplex.v1.GetEntryRequest;
import com.google.cloud.dataplex.v1.GetEntryTypeRequest;
import com.google.cloud.dataplex.v1.ListAspectTypesRequest;
import com.google.cloud.dataplex.v1.ListAspectTypesResponse;
import com.google.cloud.dataplex.v1.ListEntriesRequest;
import com.google.cloud.dataplex.v1.ListEntriesResponse;
import com.google.cloud.dataplex.v1.ListEntryGroupsRequest;
import com.google.cloud.dataplex.v1.ListEntryGroupsResponse;
import com.google.cloud.dataplex.v1.ListEntryTypesRequest;
import com.google.cloud.dataplex.v1.ListEntryTypesResponse;
import com.google.cloud.dataplex.v1.LookupEntryRequest;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.SearchEntriesRequest;
import com.google.cloud.dataplex.v1.SearchEntriesResponse;
import com.google.cloud.dataplex.v1.UpdateAspectTypeRequest;
import com.google.cloud.dataplex.v1.UpdateEntryGroupRequest;
import com.google.cloud.dataplex.v1.UpdateEntryRequest;
import com.google.cloud.dataplex.v1.UpdateEntryTypeRequest;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CatalogService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCatalogServiceStub extends CatalogServiceStub {
  private static final MethodDescriptor<CreateEntryTypeRequest, Operation>
      createEntryTypeMethodDescriptor =
          MethodDescriptor.<CreateEntryTypeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/CreateEntryType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEntryTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEntryTypeRequest, Operation>
      updateEntryTypeMethodDescriptor =
          MethodDescriptor.<UpdateEntryTypeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/UpdateEntryType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEntryTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEntryTypeRequest, Operation>
      deleteEntryTypeMethodDescriptor =
          MethodDescriptor.<DeleteEntryTypeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/DeleteEntryType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEntryTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEntryTypesRequest, ListEntryTypesResponse>
      listEntryTypesMethodDescriptor =
          MethodDescriptor.<ListEntryTypesRequest, ListEntryTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/ListEntryTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEntryTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEntryTypesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEntryTypeRequest, EntryType>
      getEntryTypeMethodDescriptor =
          MethodDescriptor.<GetEntryTypeRequest, EntryType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/GetEntryType")
              .setRequestMarshaller(ProtoUtils.marshaller(GetEntryTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EntryType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAspectTypeRequest, Operation>
      createAspectTypeMethodDescriptor =
          MethodDescriptor.<CreateAspectTypeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/CreateAspectType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAspectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAspectTypeRequest, Operation>
      updateAspectTypeMethodDescriptor =
          MethodDescriptor.<UpdateAspectTypeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/UpdateAspectType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAspectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAspectTypeRequest, Operation>
      deleteAspectTypeMethodDescriptor =
          MethodDescriptor.<DeleteAspectTypeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/DeleteAspectType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAspectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAspectTypesRequest, ListAspectTypesResponse>
      listAspectTypesMethodDescriptor =
          MethodDescriptor.<ListAspectTypesRequest, ListAspectTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/ListAspectTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAspectTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAspectTypesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAspectTypeRequest, AspectType>
      getAspectTypeMethodDescriptor =
          MethodDescriptor.<GetAspectTypeRequest, AspectType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/GetAspectType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAspectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AspectType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateEntryGroupRequest, Operation>
      createEntryGroupMethodDescriptor =
          MethodDescriptor.<CreateEntryGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/CreateEntryGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEntryGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEntryGroupRequest, Operation>
      updateEntryGroupMethodDescriptor =
          MethodDescriptor.<UpdateEntryGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/UpdateEntryGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEntryGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEntryGroupRequest, Operation>
      deleteEntryGroupMethodDescriptor =
          MethodDescriptor.<DeleteEntryGroupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/DeleteEntryGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEntryGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEntryGroupsRequest, ListEntryGroupsResponse>
      listEntryGroupsMethodDescriptor =
          MethodDescriptor.<ListEntryGroupsRequest, ListEntryGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/ListEntryGroups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEntryGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEntryGroupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEntryGroupRequest, EntryGroup>
      getEntryGroupMethodDescriptor =
          MethodDescriptor.<GetEntryGroupRequest, EntryGroup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/GetEntryGroup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEntryGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EntryGroup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateEntryRequest, Entry> createEntryMethodDescriptor =
      MethodDescriptor.<CreateEntryRequest, Entry>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.CatalogService/CreateEntry")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateEntryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Entry.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateEntryRequest, Entry> updateEntryMethodDescriptor =
      MethodDescriptor.<UpdateEntryRequest, Entry>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.CatalogService/UpdateEntry")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateEntryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Entry.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteEntryRequest, Entry> deleteEntryMethodDescriptor =
      MethodDescriptor.<DeleteEntryRequest, Entry>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.CatalogService/DeleteEntry")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteEntryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Entry.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListEntriesRequest, ListEntriesResponse>
      listEntriesMethodDescriptor =
          MethodDescriptor.<ListEntriesRequest, ListEntriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/ListEntries")
              .setRequestMarshaller(ProtoUtils.marshaller(ListEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEntriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEntryRequest, Entry> getEntryMethodDescriptor =
      MethodDescriptor.<GetEntryRequest, Entry>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.CatalogService/GetEntry")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEntryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Entry.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<LookupEntryRequest, Entry> lookupEntryMethodDescriptor =
      MethodDescriptor.<LookupEntryRequest, Entry>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataplex.v1.CatalogService/LookupEntry")
          .setRequestMarshaller(ProtoUtils.marshaller(LookupEntryRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Entry.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SearchEntriesRequest, SearchEntriesResponse>
      searchEntriesMethodDescriptor =
          MethodDescriptor.<SearchEntriesRequest, SearchEntriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.CatalogService/SearchEntries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchEntriesResponse.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateEntryTypeRequest, Operation> createEntryTypeCallable;
  private final OperationCallable<CreateEntryTypeRequest, EntryType, OperationMetadata>
      createEntryTypeOperationCallable;
  private final UnaryCallable<UpdateEntryTypeRequest, Operation> updateEntryTypeCallable;
  private final OperationCallable<UpdateEntryTypeRequest, EntryType, OperationMetadata>
      updateEntryTypeOperationCallable;
  private final UnaryCallable<DeleteEntryTypeRequest, Operation> deleteEntryTypeCallable;
  private final OperationCallable<DeleteEntryTypeRequest, Empty, OperationMetadata>
      deleteEntryTypeOperationCallable;
  private final UnaryCallable<ListEntryTypesRequest, ListEntryTypesResponse> listEntryTypesCallable;
  private final UnaryCallable<ListEntryTypesRequest, ListEntryTypesPagedResponse>
      listEntryTypesPagedCallable;
  private final UnaryCallable<GetEntryTypeRequest, EntryType> getEntryTypeCallable;
  private final UnaryCallable<CreateAspectTypeRequest, Operation> createAspectTypeCallable;
  private final OperationCallable<CreateAspectTypeRequest, AspectType, OperationMetadata>
      createAspectTypeOperationCallable;
  private final UnaryCallable<UpdateAspectTypeRequest, Operation> updateAspectTypeCallable;
  private final OperationCallable<UpdateAspectTypeRequest, AspectType, OperationMetadata>
      updateAspectTypeOperationCallable;
  private final UnaryCallable<DeleteAspectTypeRequest, Operation> deleteAspectTypeCallable;
  private final OperationCallable<DeleteAspectTypeRequest, Empty, OperationMetadata>
      deleteAspectTypeOperationCallable;
  private final UnaryCallable<ListAspectTypesRequest, ListAspectTypesResponse>
      listAspectTypesCallable;
  private final UnaryCallable<ListAspectTypesRequest, ListAspectTypesPagedResponse>
      listAspectTypesPagedCallable;
  private final UnaryCallable<GetAspectTypeRequest, AspectType> getAspectTypeCallable;
  private final UnaryCallable<CreateEntryGroupRequest, Operation> createEntryGroupCallable;
  private final OperationCallable<CreateEntryGroupRequest, EntryGroup, OperationMetadata>
      createEntryGroupOperationCallable;
  private final UnaryCallable<UpdateEntryGroupRequest, Operation> updateEntryGroupCallable;
  private final OperationCallable<UpdateEntryGroupRequest, EntryGroup, OperationMetadata>
      updateEntryGroupOperationCallable;
  private final UnaryCallable<DeleteEntryGroupRequest, Operation> deleteEntryGroupCallable;
  private final OperationCallable<DeleteEntryGroupRequest, Empty, OperationMetadata>
      deleteEntryGroupOperationCallable;
  private final UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse>
      listEntryGroupsCallable;
  private final UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable;
  private final UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable;
  private final UnaryCallable<CreateEntryRequest, Entry> createEntryCallable;
  private final UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable;
  private final UnaryCallable<DeleteEntryRequest, Entry> deleteEntryCallable;
  private final UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable;
  private final UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse>
      listEntriesPagedCallable;
  private final UnaryCallable<GetEntryRequest, Entry> getEntryCallable;
  private final UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable;
  private final UnaryCallable<SearchEntriesRequest, SearchEntriesResponse> searchEntriesCallable;
  private final UnaryCallable<SearchEntriesRequest, SearchEntriesPagedResponse>
      searchEntriesPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCatalogServiceStub create(CatalogServiceStubSettings settings)
      throws IOException {
    return new GrpcCatalogServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCatalogServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCatalogServiceStub(
        CatalogServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCatalogServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCatalogServiceStub(
        CatalogServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCatalogServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCatalogServiceStub(CatalogServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCatalogServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCatalogServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcCatalogServiceStub(
      CatalogServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateEntryTypeRequest, Operation> createEntryTypeTransportSettings =
        GrpcCallSettings.<CreateEntryTypeRequest, Operation>newBuilder()
            .setMethodDescriptor(createEntryTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateEntryTypeRequest, Operation> updateEntryTypeTransportSettings =
        GrpcCallSettings.<UpdateEntryTypeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEntryTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("entry_type.name", String.valueOf(request.getEntryType().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEntryTypeRequest, Operation> deleteEntryTypeTransportSettings =
        GrpcCallSettings.<DeleteEntryTypeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEntryTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEntryTypesRequest, ListEntryTypesResponse>
        listEntryTypesTransportSettings =
            GrpcCallSettings.<ListEntryTypesRequest, ListEntryTypesResponse>newBuilder()
                .setMethodDescriptor(listEntryTypesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEntryTypeRequest, EntryType> getEntryTypeTransportSettings =
        GrpcCallSettings.<GetEntryTypeRequest, EntryType>newBuilder()
            .setMethodDescriptor(getEntryTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAspectTypeRequest, Operation> createAspectTypeTransportSettings =
        GrpcCallSettings.<CreateAspectTypeRequest, Operation>newBuilder()
            .setMethodDescriptor(createAspectTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAspectTypeRequest, Operation> updateAspectTypeTransportSettings =
        GrpcCallSettings.<UpdateAspectTypeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAspectTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "aspect_type.name", String.valueOf(request.getAspectType().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAspectTypeRequest, Operation> deleteAspectTypeTransportSettings =
        GrpcCallSettings.<DeleteAspectTypeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAspectTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAspectTypesRequest, ListAspectTypesResponse>
        listAspectTypesTransportSettings =
            GrpcCallSettings.<ListAspectTypesRequest, ListAspectTypesResponse>newBuilder()
                .setMethodDescriptor(listAspectTypesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetAspectTypeRequest, AspectType> getAspectTypeTransportSettings =
        GrpcCallSettings.<GetAspectTypeRequest, AspectType>newBuilder()
            .setMethodDescriptor(getAspectTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateEntryGroupRequest, Operation> createEntryGroupTransportSettings =
        GrpcCallSettings.<CreateEntryGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(createEntryGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateEntryGroupRequest, Operation> updateEntryGroupTransportSettings =
        GrpcCallSettings.<UpdateEntryGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEntryGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "entry_group.name", String.valueOf(request.getEntryGroup().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEntryGroupRequest, Operation> deleteEntryGroupTransportSettings =
        GrpcCallSettings.<DeleteEntryGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEntryGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEntryGroupsRequest, ListEntryGroupsResponse>
        listEntryGroupsTransportSettings =
            GrpcCallSettings.<ListEntryGroupsRequest, ListEntryGroupsResponse>newBuilder()
                .setMethodDescriptor(listEntryGroupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEntryGroupRequest, EntryGroup> getEntryGroupTransportSettings =
        GrpcCallSettings.<GetEntryGroupRequest, EntryGroup>newBuilder()
            .setMethodDescriptor(getEntryGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateEntryRequest, Entry> createEntryTransportSettings =
        GrpcCallSettings.<CreateEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(createEntryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateEntryRequest, Entry> updateEntryTransportSettings =
        GrpcCallSettings.<UpdateEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(updateEntryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("entry.name", String.valueOf(request.getEntry().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEntryRequest, Entry> deleteEntryTransportSettings =
        GrpcCallSettings.<DeleteEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(deleteEntryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEntriesRequest, ListEntriesResponse> listEntriesTransportSettings =
        GrpcCallSettings.<ListEntriesRequest, ListEntriesResponse>newBuilder()
            .setMethodDescriptor(listEntriesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEntryRequest, Entry> getEntryTransportSettings =
        GrpcCallSettings.<GetEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(getEntryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<LookupEntryRequest, Entry> lookupEntryTransportSettings =
        GrpcCallSettings.<LookupEntryRequest, Entry>newBuilder()
            .setMethodDescriptor(lookupEntryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchEntriesRequest, SearchEntriesResponse> searchEntriesTransportSettings =
        GrpcCallSettings.<SearchEntriesRequest, SearchEntriesResponse>newBuilder()
            .setMethodDescriptor(searchEntriesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
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

    this.createEntryTypeCallable =
        callableFactory.createUnaryCallable(
            createEntryTypeTransportSettings, settings.createEntryTypeSettings(), clientContext);
    this.createEntryTypeOperationCallable =
        callableFactory.createOperationCallable(
            createEntryTypeTransportSettings,
            settings.createEntryTypeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateEntryTypeCallable =
        callableFactory.createUnaryCallable(
            updateEntryTypeTransportSettings, settings.updateEntryTypeSettings(), clientContext);
    this.updateEntryTypeOperationCallable =
        callableFactory.createOperationCallable(
            updateEntryTypeTransportSettings,
            settings.updateEntryTypeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEntryTypeCallable =
        callableFactory.createUnaryCallable(
            deleteEntryTypeTransportSettings, settings.deleteEntryTypeSettings(), clientContext);
    this.deleteEntryTypeOperationCallable =
        callableFactory.createOperationCallable(
            deleteEntryTypeTransportSettings,
            settings.deleteEntryTypeOperationSettings(),
            clientContext,
            operationsStub);
    this.listEntryTypesCallable =
        callableFactory.createUnaryCallable(
            listEntryTypesTransportSettings, settings.listEntryTypesSettings(), clientContext);
    this.listEntryTypesPagedCallable =
        callableFactory.createPagedCallable(
            listEntryTypesTransportSettings, settings.listEntryTypesSettings(), clientContext);
    this.getEntryTypeCallable =
        callableFactory.createUnaryCallable(
            getEntryTypeTransportSettings, settings.getEntryTypeSettings(), clientContext);
    this.createAspectTypeCallable =
        callableFactory.createUnaryCallable(
            createAspectTypeTransportSettings, settings.createAspectTypeSettings(), clientContext);
    this.createAspectTypeOperationCallable =
        callableFactory.createOperationCallable(
            createAspectTypeTransportSettings,
            settings.createAspectTypeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAspectTypeCallable =
        callableFactory.createUnaryCallable(
            updateAspectTypeTransportSettings, settings.updateAspectTypeSettings(), clientContext);
    this.updateAspectTypeOperationCallable =
        callableFactory.createOperationCallable(
            updateAspectTypeTransportSettings,
            settings.updateAspectTypeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAspectTypeCallable =
        callableFactory.createUnaryCallable(
            deleteAspectTypeTransportSettings, settings.deleteAspectTypeSettings(), clientContext);
    this.deleteAspectTypeOperationCallable =
        callableFactory.createOperationCallable(
            deleteAspectTypeTransportSettings,
            settings.deleteAspectTypeOperationSettings(),
            clientContext,
            operationsStub);
    this.listAspectTypesCallable =
        callableFactory.createUnaryCallable(
            listAspectTypesTransportSettings, settings.listAspectTypesSettings(), clientContext);
    this.listAspectTypesPagedCallable =
        callableFactory.createPagedCallable(
            listAspectTypesTransportSettings, settings.listAspectTypesSettings(), clientContext);
    this.getAspectTypeCallable =
        callableFactory.createUnaryCallable(
            getAspectTypeTransportSettings, settings.getAspectTypeSettings(), clientContext);
    this.createEntryGroupCallable =
        callableFactory.createUnaryCallable(
            createEntryGroupTransportSettings, settings.createEntryGroupSettings(), clientContext);
    this.createEntryGroupOperationCallable =
        callableFactory.createOperationCallable(
            createEntryGroupTransportSettings,
            settings.createEntryGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.updateEntryGroupCallable =
        callableFactory.createUnaryCallable(
            updateEntryGroupTransportSettings, settings.updateEntryGroupSettings(), clientContext);
    this.updateEntryGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateEntryGroupTransportSettings,
            settings.updateEntryGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEntryGroupCallable =
        callableFactory.createUnaryCallable(
            deleteEntryGroupTransportSettings, settings.deleteEntryGroupSettings(), clientContext);
    this.deleteEntryGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteEntryGroupTransportSettings,
            settings.deleteEntryGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.listEntryGroupsCallable =
        callableFactory.createUnaryCallable(
            listEntryGroupsTransportSettings, settings.listEntryGroupsSettings(), clientContext);
    this.listEntryGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listEntryGroupsTransportSettings, settings.listEntryGroupsSettings(), clientContext);
    this.getEntryGroupCallable =
        callableFactory.createUnaryCallable(
            getEntryGroupTransportSettings, settings.getEntryGroupSettings(), clientContext);
    this.createEntryCallable =
        callableFactory.createUnaryCallable(
            createEntryTransportSettings, settings.createEntrySettings(), clientContext);
    this.updateEntryCallable =
        callableFactory.createUnaryCallable(
            updateEntryTransportSettings, settings.updateEntrySettings(), clientContext);
    this.deleteEntryCallable =
        callableFactory.createUnaryCallable(
            deleteEntryTransportSettings, settings.deleteEntrySettings(), clientContext);
    this.listEntriesCallable =
        callableFactory.createUnaryCallable(
            listEntriesTransportSettings, settings.listEntriesSettings(), clientContext);
    this.listEntriesPagedCallable =
        callableFactory.createPagedCallable(
            listEntriesTransportSettings, settings.listEntriesSettings(), clientContext);
    this.getEntryCallable =
        callableFactory.createUnaryCallable(
            getEntryTransportSettings, settings.getEntrySettings(), clientContext);
    this.lookupEntryCallable =
        callableFactory.createUnaryCallable(
            lookupEntryTransportSettings, settings.lookupEntrySettings(), clientContext);
    this.searchEntriesCallable =
        callableFactory.createUnaryCallable(
            searchEntriesTransportSettings, settings.searchEntriesSettings(), clientContext);
    this.searchEntriesPagedCallable =
        callableFactory.createPagedCallable(
            searchEntriesTransportSettings, settings.searchEntriesSettings(), clientContext);
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
  public UnaryCallable<CreateEntryTypeRequest, Operation> createEntryTypeCallable() {
    return createEntryTypeCallable;
  }

  @Override
  public OperationCallable<CreateEntryTypeRequest, EntryType, OperationMetadata>
      createEntryTypeOperationCallable() {
    return createEntryTypeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEntryTypeRequest, Operation> updateEntryTypeCallable() {
    return updateEntryTypeCallable;
  }

  @Override
  public OperationCallable<UpdateEntryTypeRequest, EntryType, OperationMetadata>
      updateEntryTypeOperationCallable() {
    return updateEntryTypeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEntryTypeRequest, Operation> deleteEntryTypeCallable() {
    return deleteEntryTypeCallable;
  }

  @Override
  public OperationCallable<DeleteEntryTypeRequest, Empty, OperationMetadata>
      deleteEntryTypeOperationCallable() {
    return deleteEntryTypeOperationCallable;
  }

  @Override
  public UnaryCallable<ListEntryTypesRequest, ListEntryTypesResponse> listEntryTypesCallable() {
    return listEntryTypesCallable;
  }

  @Override
  public UnaryCallable<ListEntryTypesRequest, ListEntryTypesPagedResponse>
      listEntryTypesPagedCallable() {
    return listEntryTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetEntryTypeRequest, EntryType> getEntryTypeCallable() {
    return getEntryTypeCallable;
  }

  @Override
  public UnaryCallable<CreateAspectTypeRequest, Operation> createAspectTypeCallable() {
    return createAspectTypeCallable;
  }

  @Override
  public OperationCallable<CreateAspectTypeRequest, AspectType, OperationMetadata>
      createAspectTypeOperationCallable() {
    return createAspectTypeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAspectTypeRequest, Operation> updateAspectTypeCallable() {
    return updateAspectTypeCallable;
  }

  @Override
  public OperationCallable<UpdateAspectTypeRequest, AspectType, OperationMetadata>
      updateAspectTypeOperationCallable() {
    return updateAspectTypeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAspectTypeRequest, Operation> deleteAspectTypeCallable() {
    return deleteAspectTypeCallable;
  }

  @Override
  public OperationCallable<DeleteAspectTypeRequest, Empty, OperationMetadata>
      deleteAspectTypeOperationCallable() {
    return deleteAspectTypeOperationCallable;
  }

  @Override
  public UnaryCallable<ListAspectTypesRequest, ListAspectTypesResponse> listAspectTypesCallable() {
    return listAspectTypesCallable;
  }

  @Override
  public UnaryCallable<ListAspectTypesRequest, ListAspectTypesPagedResponse>
      listAspectTypesPagedCallable() {
    return listAspectTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAspectTypeRequest, AspectType> getAspectTypeCallable() {
    return getAspectTypeCallable;
  }

  @Override
  public UnaryCallable<CreateEntryGroupRequest, Operation> createEntryGroupCallable() {
    return createEntryGroupCallable;
  }

  @Override
  public OperationCallable<CreateEntryGroupRequest, EntryGroup, OperationMetadata>
      createEntryGroupOperationCallable() {
    return createEntryGroupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEntryGroupRequest, Operation> updateEntryGroupCallable() {
    return updateEntryGroupCallable;
  }

  @Override
  public OperationCallable<UpdateEntryGroupRequest, EntryGroup, OperationMetadata>
      updateEntryGroupOperationCallable() {
    return updateEntryGroupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEntryGroupRequest, Operation> deleteEntryGroupCallable() {
    return deleteEntryGroupCallable;
  }

  @Override
  public OperationCallable<DeleteEntryGroupRequest, Empty, OperationMetadata>
      deleteEntryGroupOperationCallable() {
    return deleteEntryGroupOperationCallable;
  }

  @Override
  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse> listEntryGroupsCallable() {
    return listEntryGroupsCallable;
  }

  @Override
  public UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable() {
    return listEntryGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable() {
    return getEntryGroupCallable;
  }

  @Override
  public UnaryCallable<CreateEntryRequest, Entry> createEntryCallable() {
    return createEntryCallable;
  }

  @Override
  public UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable() {
    return updateEntryCallable;
  }

  @Override
  public UnaryCallable<DeleteEntryRequest, Entry> deleteEntryCallable() {
    return deleteEntryCallable;
  }

  @Override
  public UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable() {
    return listEntriesCallable;
  }

  @Override
  public UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse> listEntriesPagedCallable() {
    return listEntriesPagedCallable;
  }

  @Override
  public UnaryCallable<GetEntryRequest, Entry> getEntryCallable() {
    return getEntryCallable;
  }

  @Override
  public UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable() {
    return lookupEntryCallable;
  }

  @Override
  public UnaryCallable<SearchEntriesRequest, SearchEntriesResponse> searchEntriesCallable() {
    return searchEntriesCallable;
  }

  @Override
  public UnaryCallable<SearchEntriesRequest, SearchEntriesPagedResponse>
      searchEntriesPagedCallable() {
    return searchEntriesPagedCallable;
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
