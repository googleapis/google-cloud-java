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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributeBindingsPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataTaxonomiesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.CreateDataAttributeRequest;
import com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest;
import com.google.cloud.dataplex.v1.DataAttribute;
import com.google.cloud.dataplex.v1.DataAttributeBinding;
import com.google.cloud.dataplex.v1.DataTaxonomy;
import com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.DeleteDataAttributeRequest;
import com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest;
import com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.GetDataAttributeRequest;
import com.google.cloud.dataplex.v1.GetDataTaxonomyRequest;
import com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest;
import com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse;
import com.google.cloud.dataplex.v1.ListDataAttributesRequest;
import com.google.cloud.dataplex.v1.ListDataAttributesResponse;
import com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest;
import com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.UpdateDataAttributeRequest;
import com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest;
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
 * gRPC stub implementation for the DataTaxonomyService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataTaxonomyServiceStub extends DataTaxonomyServiceStub {
  private static final MethodDescriptor<CreateDataTaxonomyRequest, Operation>
      createDataTaxonomyMethodDescriptor =
          MethodDescriptor.<CreateDataTaxonomyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/CreateDataTaxonomy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataTaxonomyRequest, Operation>
      updateDataTaxonomyMethodDescriptor =
          MethodDescriptor.<UpdateDataTaxonomyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/UpdateDataTaxonomy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataTaxonomyRequest, Operation>
      deleteDataTaxonomyMethodDescriptor =
          MethodDescriptor.<DeleteDataTaxonomyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/DeleteDataTaxonomy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>
      listDataTaxonomiesMethodDescriptor =
          MethodDescriptor.<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/ListDataTaxonomies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataTaxonomiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataTaxonomiesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataTaxonomyRequest, DataTaxonomy>
      getDataTaxonomyMethodDescriptor =
          MethodDescriptor.<GetDataTaxonomyRequest, DataTaxonomy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/GetDataTaxonomy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataTaxonomy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDataAttributeBindingRequest, Operation>
      createDataAttributeBindingMethodDescriptor =
          MethodDescriptor.<CreateDataAttributeBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.DataTaxonomyService/CreateDataAttributeBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataAttributeBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataAttributeBindingRequest, Operation>
      updateDataAttributeBindingMethodDescriptor =
          MethodDescriptor.<UpdateDataAttributeBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.DataTaxonomyService/UpdateDataAttributeBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataAttributeBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataAttributeBindingRequest, Operation>
      deleteDataAttributeBindingMethodDescriptor =
          MethodDescriptor.<DeleteDataAttributeBindingRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.DataTaxonomyService/DeleteDataAttributeBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataAttributeBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>
      listDataAttributeBindingsMethodDescriptor =
          MethodDescriptor
              .<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.DataTaxonomyService/ListDataAttributeBindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataAttributeBindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataAttributeBindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataAttributeBindingRequest, DataAttributeBinding>
      getDataAttributeBindingMethodDescriptor =
          MethodDescriptor.<GetDataAttributeBindingRequest, DataAttributeBinding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dataplex.v1.DataTaxonomyService/GetDataAttributeBinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataAttributeBindingRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DataAttributeBinding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDataAttributeRequest, Operation>
      createDataAttributeMethodDescriptor =
          MethodDescriptor.<CreateDataAttributeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/CreateDataAttribute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDataAttributeRequest, Operation>
      updateDataAttributeMethodDescriptor =
          MethodDescriptor.<UpdateDataAttributeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/UpdateDataAttribute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataAttributeRequest, Operation>
      deleteDataAttributeMethodDescriptor =
          MethodDescriptor.<DeleteDataAttributeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/DeleteDataAttribute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataAttributesRequest, ListDataAttributesResponse>
      listDataAttributesMethodDescriptor =
          MethodDescriptor.<ListDataAttributesRequest, ListDataAttributesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/ListDataAttributes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataAttributesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataAttributesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataAttributeRequest, DataAttribute>
      getDataAttributeMethodDescriptor =
          MethodDescriptor.<GetDataAttributeRequest, DataAttribute>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataTaxonomyService/GetDataAttribute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataAttribute.getDefaultInstance()))
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

  private final UnaryCallable<CreateDataTaxonomyRequest, Operation> createDataTaxonomyCallable;
  private final OperationCallable<CreateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      createDataTaxonomyOperationCallable;
  private final UnaryCallable<UpdateDataTaxonomyRequest, Operation> updateDataTaxonomyCallable;
  private final OperationCallable<UpdateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      updateDataTaxonomyOperationCallable;
  private final UnaryCallable<DeleteDataTaxonomyRequest, Operation> deleteDataTaxonomyCallable;
  private final OperationCallable<DeleteDataTaxonomyRequest, Empty, OperationMetadata>
      deleteDataTaxonomyOperationCallable;
  private final UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>
      listDataTaxonomiesCallable;
  private final UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesPagedResponse>
      listDataTaxonomiesPagedCallable;
  private final UnaryCallable<GetDataTaxonomyRequest, DataTaxonomy> getDataTaxonomyCallable;
  private final UnaryCallable<CreateDataAttributeBindingRequest, Operation>
      createDataAttributeBindingCallable;
  private final OperationCallable<
          CreateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      createDataAttributeBindingOperationCallable;
  private final UnaryCallable<UpdateDataAttributeBindingRequest, Operation>
      updateDataAttributeBindingCallable;
  private final OperationCallable<
          UpdateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      updateDataAttributeBindingOperationCallable;
  private final UnaryCallable<DeleteDataAttributeBindingRequest, Operation>
      deleteDataAttributeBindingCallable;
  private final OperationCallable<DeleteDataAttributeBindingRequest, Empty, OperationMetadata>
      deleteDataAttributeBindingOperationCallable;
  private final UnaryCallable<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>
      listDataAttributeBindingsCallable;
  private final UnaryCallable<
          ListDataAttributeBindingsRequest, ListDataAttributeBindingsPagedResponse>
      listDataAttributeBindingsPagedCallable;
  private final UnaryCallable<GetDataAttributeBindingRequest, DataAttributeBinding>
      getDataAttributeBindingCallable;
  private final UnaryCallable<CreateDataAttributeRequest, Operation> createDataAttributeCallable;
  private final OperationCallable<CreateDataAttributeRequest, DataAttribute, OperationMetadata>
      createDataAttributeOperationCallable;
  private final UnaryCallable<UpdateDataAttributeRequest, Operation> updateDataAttributeCallable;
  private final OperationCallable<UpdateDataAttributeRequest, DataAttribute, OperationMetadata>
      updateDataAttributeOperationCallable;
  private final UnaryCallable<DeleteDataAttributeRequest, Operation> deleteDataAttributeCallable;
  private final OperationCallable<DeleteDataAttributeRequest, Empty, OperationMetadata>
      deleteDataAttributeOperationCallable;
  private final UnaryCallable<ListDataAttributesRequest, ListDataAttributesResponse>
      listDataAttributesCallable;
  private final UnaryCallable<ListDataAttributesRequest, ListDataAttributesPagedResponse>
      listDataAttributesPagedCallable;
  private final UnaryCallable<GetDataAttributeRequest, DataAttribute> getDataAttributeCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataTaxonomyServiceStub create(DataTaxonomyServiceStubSettings settings)
      throws IOException {
    return new GrpcDataTaxonomyServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataTaxonomyServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataTaxonomyServiceStub(
        DataTaxonomyServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataTaxonomyServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataTaxonomyServiceStub(
        DataTaxonomyServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataTaxonomyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataTaxonomyServiceStub(
      DataTaxonomyServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataTaxonomyServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataTaxonomyServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataTaxonomyServiceStub(
      DataTaxonomyServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDataTaxonomyRequest, Operation> createDataTaxonomyTransportSettings =
        GrpcCallSettings.<CreateDataTaxonomyRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataTaxonomyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDataTaxonomyRequest, Operation> updateDataTaxonomyTransportSettings =
        GrpcCallSettings.<UpdateDataTaxonomyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataTaxonomyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_taxonomy.name", String.valueOf(request.getDataTaxonomy().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDataTaxonomyRequest, Operation> deleteDataTaxonomyTransportSettings =
        GrpcCallSettings.<DeleteDataTaxonomyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDataTaxonomyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>
        listDataTaxonomiesTransportSettings =
            GrpcCallSettings.<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>newBuilder()
                .setMethodDescriptor(listDataTaxonomiesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDataTaxonomyRequest, DataTaxonomy> getDataTaxonomyTransportSettings =
        GrpcCallSettings.<GetDataTaxonomyRequest, DataTaxonomy>newBuilder()
            .setMethodDescriptor(getDataTaxonomyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDataAttributeBindingRequest, Operation>
        createDataAttributeBindingTransportSettings =
            GrpcCallSettings.<CreateDataAttributeBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(createDataAttributeBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateDataAttributeBindingRequest, Operation>
        updateDataAttributeBindingTransportSettings =
            GrpcCallSettings.<UpdateDataAttributeBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(updateDataAttributeBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "data_attribute_binding.name",
                          String.valueOf(request.getDataAttributeBinding().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteDataAttributeBindingRequest, Operation>
        deleteDataAttributeBindingTransportSettings =
            GrpcCallSettings.<DeleteDataAttributeBindingRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDataAttributeBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>
        listDataAttributeBindingsTransportSettings =
            GrpcCallSettings
                .<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>newBuilder()
                .setMethodDescriptor(listDataAttributeBindingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDataAttributeBindingRequest, DataAttributeBinding>
        getDataAttributeBindingTransportSettings =
            GrpcCallSettings.<GetDataAttributeBindingRequest, DataAttributeBinding>newBuilder()
                .setMethodDescriptor(getDataAttributeBindingMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateDataAttributeRequest, Operation> createDataAttributeTransportSettings =
        GrpcCallSettings.<CreateDataAttributeRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataAttributeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDataAttributeRequest, Operation> updateDataAttributeTransportSettings =
        GrpcCallSettings.<UpdateDataAttributeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataAttributeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_attribute.name", String.valueOf(request.getDataAttribute().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDataAttributeRequest, Operation> deleteDataAttributeTransportSettings =
        GrpcCallSettings.<DeleteDataAttributeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDataAttributeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDataAttributesRequest, ListDataAttributesResponse>
        listDataAttributesTransportSettings =
            GrpcCallSettings.<ListDataAttributesRequest, ListDataAttributesResponse>newBuilder()
                .setMethodDescriptor(listDataAttributesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDataAttributeRequest, DataAttribute> getDataAttributeTransportSettings =
        GrpcCallSettings.<GetDataAttributeRequest, DataAttribute>newBuilder()
            .setMethodDescriptor(getDataAttributeMethodDescriptor)
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

    this.createDataTaxonomyCallable =
        callableFactory.createUnaryCallable(
            createDataTaxonomyTransportSettings,
            settings.createDataTaxonomySettings(),
            clientContext);
    this.createDataTaxonomyOperationCallable =
        callableFactory.createOperationCallable(
            createDataTaxonomyTransportSettings,
            settings.createDataTaxonomyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDataTaxonomyCallable =
        callableFactory.createUnaryCallable(
            updateDataTaxonomyTransportSettings,
            settings.updateDataTaxonomySettings(),
            clientContext);
    this.updateDataTaxonomyOperationCallable =
        callableFactory.createOperationCallable(
            updateDataTaxonomyTransportSettings,
            settings.updateDataTaxonomyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDataTaxonomyCallable =
        callableFactory.createUnaryCallable(
            deleteDataTaxonomyTransportSettings,
            settings.deleteDataTaxonomySettings(),
            clientContext);
    this.deleteDataTaxonomyOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataTaxonomyTransportSettings,
            settings.deleteDataTaxonomyOperationSettings(),
            clientContext,
            operationsStub);
    this.listDataTaxonomiesCallable =
        callableFactory.createUnaryCallable(
            listDataTaxonomiesTransportSettings,
            settings.listDataTaxonomiesSettings(),
            clientContext);
    this.listDataTaxonomiesPagedCallable =
        callableFactory.createPagedCallable(
            listDataTaxonomiesTransportSettings,
            settings.listDataTaxonomiesSettings(),
            clientContext);
    this.getDataTaxonomyCallable =
        callableFactory.createUnaryCallable(
            getDataTaxonomyTransportSettings, settings.getDataTaxonomySettings(), clientContext);
    this.createDataAttributeBindingCallable =
        callableFactory.createUnaryCallable(
            createDataAttributeBindingTransportSettings,
            settings.createDataAttributeBindingSettings(),
            clientContext);
    this.createDataAttributeBindingOperationCallable =
        callableFactory.createOperationCallable(
            createDataAttributeBindingTransportSettings,
            settings.createDataAttributeBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDataAttributeBindingCallable =
        callableFactory.createUnaryCallable(
            updateDataAttributeBindingTransportSettings,
            settings.updateDataAttributeBindingSettings(),
            clientContext);
    this.updateDataAttributeBindingOperationCallable =
        callableFactory.createOperationCallable(
            updateDataAttributeBindingTransportSettings,
            settings.updateDataAttributeBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDataAttributeBindingCallable =
        callableFactory.createUnaryCallable(
            deleteDataAttributeBindingTransportSettings,
            settings.deleteDataAttributeBindingSettings(),
            clientContext);
    this.deleteDataAttributeBindingOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataAttributeBindingTransportSettings,
            settings.deleteDataAttributeBindingOperationSettings(),
            clientContext,
            operationsStub);
    this.listDataAttributeBindingsCallable =
        callableFactory.createUnaryCallable(
            listDataAttributeBindingsTransportSettings,
            settings.listDataAttributeBindingsSettings(),
            clientContext);
    this.listDataAttributeBindingsPagedCallable =
        callableFactory.createPagedCallable(
            listDataAttributeBindingsTransportSettings,
            settings.listDataAttributeBindingsSettings(),
            clientContext);
    this.getDataAttributeBindingCallable =
        callableFactory.createUnaryCallable(
            getDataAttributeBindingTransportSettings,
            settings.getDataAttributeBindingSettings(),
            clientContext);
    this.createDataAttributeCallable =
        callableFactory.createUnaryCallable(
            createDataAttributeTransportSettings,
            settings.createDataAttributeSettings(),
            clientContext);
    this.createDataAttributeOperationCallable =
        callableFactory.createOperationCallable(
            createDataAttributeTransportSettings,
            settings.createDataAttributeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDataAttributeCallable =
        callableFactory.createUnaryCallable(
            updateDataAttributeTransportSettings,
            settings.updateDataAttributeSettings(),
            clientContext);
    this.updateDataAttributeOperationCallable =
        callableFactory.createOperationCallable(
            updateDataAttributeTransportSettings,
            settings.updateDataAttributeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDataAttributeCallable =
        callableFactory.createUnaryCallable(
            deleteDataAttributeTransportSettings,
            settings.deleteDataAttributeSettings(),
            clientContext);
    this.deleteDataAttributeOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataAttributeTransportSettings,
            settings.deleteDataAttributeOperationSettings(),
            clientContext,
            operationsStub);
    this.listDataAttributesCallable =
        callableFactory.createUnaryCallable(
            listDataAttributesTransportSettings,
            settings.listDataAttributesSettings(),
            clientContext);
    this.listDataAttributesPagedCallable =
        callableFactory.createPagedCallable(
            listDataAttributesTransportSettings,
            settings.listDataAttributesSettings(),
            clientContext);
    this.getDataAttributeCallable =
        callableFactory.createUnaryCallable(
            getDataAttributeTransportSettings, settings.getDataAttributeSettings(), clientContext);
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
  public UnaryCallable<CreateDataTaxonomyRequest, Operation> createDataTaxonomyCallable() {
    return createDataTaxonomyCallable;
  }

  @Override
  public OperationCallable<CreateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      createDataTaxonomyOperationCallable() {
    return createDataTaxonomyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataTaxonomyRequest, Operation> updateDataTaxonomyCallable() {
    return updateDataTaxonomyCallable;
  }

  @Override
  public OperationCallable<UpdateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      updateDataTaxonomyOperationCallable() {
    return updateDataTaxonomyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataTaxonomyRequest, Operation> deleteDataTaxonomyCallable() {
    return deleteDataTaxonomyCallable;
  }

  @Override
  public OperationCallable<DeleteDataTaxonomyRequest, Empty, OperationMetadata>
      deleteDataTaxonomyOperationCallable() {
    return deleteDataTaxonomyOperationCallable;
  }

  @Override
  public UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse>
      listDataTaxonomiesCallable() {
    return listDataTaxonomiesCallable;
  }

  @Override
  public UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesPagedResponse>
      listDataTaxonomiesPagedCallable() {
    return listDataTaxonomiesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataTaxonomyRequest, DataTaxonomy> getDataTaxonomyCallable() {
    return getDataTaxonomyCallable;
  }

  @Override
  public UnaryCallable<CreateDataAttributeBindingRequest, Operation>
      createDataAttributeBindingCallable() {
    return createDataAttributeBindingCallable;
  }

  @Override
  public OperationCallable<
          CreateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      createDataAttributeBindingOperationCallable() {
    return createDataAttributeBindingOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataAttributeBindingRequest, Operation>
      updateDataAttributeBindingCallable() {
    return updateDataAttributeBindingCallable;
  }

  @Override
  public OperationCallable<
          UpdateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      updateDataAttributeBindingOperationCallable() {
    return updateDataAttributeBindingOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataAttributeBindingRequest, Operation>
      deleteDataAttributeBindingCallable() {
    return deleteDataAttributeBindingCallable;
  }

  @Override
  public OperationCallable<DeleteDataAttributeBindingRequest, Empty, OperationMetadata>
      deleteDataAttributeBindingOperationCallable() {
    return deleteDataAttributeBindingOperationCallable;
  }

  @Override
  public UnaryCallable<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>
      listDataAttributeBindingsCallable() {
    return listDataAttributeBindingsCallable;
  }

  @Override
  public UnaryCallable<ListDataAttributeBindingsRequest, ListDataAttributeBindingsPagedResponse>
      listDataAttributeBindingsPagedCallable() {
    return listDataAttributeBindingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataAttributeBindingRequest, DataAttributeBinding>
      getDataAttributeBindingCallable() {
    return getDataAttributeBindingCallable;
  }

  @Override
  public UnaryCallable<CreateDataAttributeRequest, Operation> createDataAttributeCallable() {
    return createDataAttributeCallable;
  }

  @Override
  public OperationCallable<CreateDataAttributeRequest, DataAttribute, OperationMetadata>
      createDataAttributeOperationCallable() {
    return createDataAttributeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataAttributeRequest, Operation> updateDataAttributeCallable() {
    return updateDataAttributeCallable;
  }

  @Override
  public OperationCallable<UpdateDataAttributeRequest, DataAttribute, OperationMetadata>
      updateDataAttributeOperationCallable() {
    return updateDataAttributeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataAttributeRequest, Operation> deleteDataAttributeCallable() {
    return deleteDataAttributeCallable;
  }

  @Override
  public OperationCallable<DeleteDataAttributeRequest, Empty, OperationMetadata>
      deleteDataAttributeOperationCallable() {
    return deleteDataAttributeOperationCallable;
  }

  @Override
  public UnaryCallable<ListDataAttributesRequest, ListDataAttributesResponse>
      listDataAttributesCallable() {
    return listDataAttributesCallable;
  }

  @Override
  public UnaryCallable<ListDataAttributesRequest, ListDataAttributesPagedResponse>
      listDataAttributesPagedCallable() {
    return listDataAttributesPagedCallable;
  }

  @Override
  public UnaryCallable<GetDataAttributeRequest, DataAttribute> getDataAttributeCallable() {
    return getDataAttributeCallable;
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
