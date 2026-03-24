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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListDataAssetsPagedResponse;
import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListDataProductsPagedResponse;
import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.CreateDataAssetRequest;
import com.google.cloud.dataplex.v1.CreateDataProductRequest;
import com.google.cloud.dataplex.v1.DataAsset;
import com.google.cloud.dataplex.v1.DataProduct;
import com.google.cloud.dataplex.v1.DeleteDataAssetRequest;
import com.google.cloud.dataplex.v1.DeleteDataProductRequest;
import com.google.cloud.dataplex.v1.GetDataAssetRequest;
import com.google.cloud.dataplex.v1.GetDataProductRequest;
import com.google.cloud.dataplex.v1.ListDataAssetsRequest;
import com.google.cloud.dataplex.v1.ListDataAssetsResponse;
import com.google.cloud.dataplex.v1.ListDataProductsRequest;
import com.google.cloud.dataplex.v1.ListDataProductsResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateDataAssetRequest;
import com.google.cloud.dataplex.v1.UpdateDataProductRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * gRPC stub implementation for the DataProductService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataProductServiceStub extends DataProductServiceStub {
  private static final MethodDescriptor<CreateDataProductRequest, Operation>
      createDataProductMethodDescriptor =
          MethodDescriptor.<CreateDataProductRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/CreateDataProduct")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataProductRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDataProductRequest, Operation>
      deleteDataProductMethodDescriptor =
          MethodDescriptor.<DeleteDataProductRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/DeleteDataProduct")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataProductRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDataProductRequest, DataProduct>
      getDataProductMethodDescriptor =
          MethodDescriptor.<GetDataProductRequest, DataProduct>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/GetDataProduct")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataProductRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataProduct.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDataProductsRequest, ListDataProductsResponse>
      listDataProductsMethodDescriptor =
          MethodDescriptor.<ListDataProductsRequest, ListDataProductsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/ListDataProducts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataProductsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDataProductRequest, Operation>
      updateDataProductMethodDescriptor =
          MethodDescriptor.<UpdateDataProductRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/UpdateDataProduct")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataProductRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateDataAssetRequest, Operation>
      createDataAssetMethodDescriptor =
          MethodDescriptor.<CreateDataAssetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/CreateDataAsset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDataAssetRequest, Operation>
      updateDataAssetMethodDescriptor =
          MethodDescriptor.<UpdateDataAssetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/UpdateDataAsset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDataAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDataAssetRequest, Operation>
      deleteDataAssetMethodDescriptor =
          MethodDescriptor.<DeleteDataAssetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/DeleteDataAsset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDataAssetRequest, DataAsset>
      getDataAssetMethodDescriptor =
          MethodDescriptor.<GetDataAssetRequest, DataAsset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/GetDataAsset")
              .setRequestMarshaller(ProtoUtils.marshaller(GetDataAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataAsset.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDataAssetsRequest, ListDataAssetsResponse>
      listDataAssetsMethodDescriptor =
          MethodDescriptor.<ListDataAssetsRequest, ListDataAssetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataplex.v1.DataProductService/ListDataAssets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataAssetsResponse.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateDataProductRequest, Operation> createDataProductCallable;
  private final OperationCallable<CreateDataProductRequest, DataProduct, OperationMetadata>
      createDataProductOperationCallable;
  private final UnaryCallable<DeleteDataProductRequest, Operation> deleteDataProductCallable;
  private final OperationCallable<DeleteDataProductRequest, Empty, OperationMetadata>
      deleteDataProductOperationCallable;
  private final UnaryCallable<GetDataProductRequest, DataProduct> getDataProductCallable;
  private final UnaryCallable<ListDataProductsRequest, ListDataProductsResponse>
      listDataProductsCallable;
  private final UnaryCallable<ListDataProductsRequest, ListDataProductsPagedResponse>
      listDataProductsPagedCallable;
  private final UnaryCallable<UpdateDataProductRequest, Operation> updateDataProductCallable;
  private final OperationCallable<UpdateDataProductRequest, DataProduct, OperationMetadata>
      updateDataProductOperationCallable;
  private final UnaryCallable<CreateDataAssetRequest, Operation> createDataAssetCallable;
  private final OperationCallable<CreateDataAssetRequest, DataAsset, OperationMetadata>
      createDataAssetOperationCallable;
  private final UnaryCallable<UpdateDataAssetRequest, Operation> updateDataAssetCallable;
  private final OperationCallable<UpdateDataAssetRequest, DataAsset, OperationMetadata>
      updateDataAssetOperationCallable;
  private final UnaryCallable<DeleteDataAssetRequest, Operation> deleteDataAssetCallable;
  private final OperationCallable<DeleteDataAssetRequest, Empty, OperationMetadata>
      deleteDataAssetOperationCallable;
  private final UnaryCallable<GetDataAssetRequest, DataAsset> getDataAssetCallable;
  private final UnaryCallable<ListDataAssetsRequest, ListDataAssetsResponse> listDataAssetsCallable;
  private final UnaryCallable<ListDataAssetsRequest, ListDataAssetsPagedResponse>
      listDataAssetsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataProductServiceStub create(DataProductServiceStubSettings settings)
      throws IOException {
    return new GrpcDataProductServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataProductServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataProductServiceStub(
        DataProductServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataProductServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataProductServiceStub(
        DataProductServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataProductServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataProductServiceStub(
      DataProductServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataProductServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataProductServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataProductServiceStub(
      DataProductServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDataProductRequest, Operation> createDataProductTransportSettings =
        GrpcCallSettings.<CreateDataProductRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataProductMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDataProductRequest, Operation> deleteDataProductTransportSettings =
        GrpcCallSettings.<DeleteDataProductRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDataProductMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDataProductRequest, DataProduct> getDataProductTransportSettings =
        GrpcCallSettings.<GetDataProductRequest, DataProduct>newBuilder()
            .setMethodDescriptor(getDataProductMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDataProductsRequest, ListDataProductsResponse>
        listDataProductsTransportSettings =
            GrpcCallSettings.<ListDataProductsRequest, ListDataProductsResponse>newBuilder()
                .setMethodDescriptor(listDataProductsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateDataProductRequest, Operation> updateDataProductTransportSettings =
        GrpcCallSettings.<UpdateDataProductRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataProductMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "data_product.name", String.valueOf(request.getDataProduct().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDataAssetRequest, Operation> createDataAssetTransportSettings =
        GrpcCallSettings.<CreateDataAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(createDataAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDataAssetRequest, Operation> updateDataAssetTransportSettings =
        GrpcCallSettings.<UpdateDataAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDataAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_asset.name", String.valueOf(request.getDataAsset().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDataAssetRequest, Operation> deleteDataAssetTransportSettings =
        GrpcCallSettings.<DeleteDataAssetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDataAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDataAssetRequest, DataAsset> getDataAssetTransportSettings =
        GrpcCallSettings.<GetDataAssetRequest, DataAsset>newBuilder()
            .setMethodDescriptor(getDataAssetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDataAssetsRequest, ListDataAssetsResponse>
        listDataAssetsTransportSettings =
            GrpcCallSettings.<ListDataAssetsRequest, ListDataAssetsResponse>newBuilder()
                .setMethodDescriptor(listDataAssetsMethodDescriptor)
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
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.createDataProductCallable =
        callableFactory.createUnaryCallable(
            createDataProductTransportSettings,
            settings.createDataProductSettings(),
            clientContext);
    this.createDataProductOperationCallable =
        callableFactory.createOperationCallable(
            createDataProductTransportSettings,
            settings.createDataProductOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDataProductCallable =
        callableFactory.createUnaryCallable(
            deleteDataProductTransportSettings,
            settings.deleteDataProductSettings(),
            clientContext);
    this.deleteDataProductOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataProductTransportSettings,
            settings.deleteDataProductOperationSettings(),
            clientContext,
            operationsStub);
    this.getDataProductCallable =
        callableFactory.createUnaryCallable(
            getDataProductTransportSettings, settings.getDataProductSettings(), clientContext);
    this.listDataProductsCallable =
        callableFactory.createUnaryCallable(
            listDataProductsTransportSettings, settings.listDataProductsSettings(), clientContext);
    this.listDataProductsPagedCallable =
        callableFactory.createPagedCallable(
            listDataProductsTransportSettings, settings.listDataProductsSettings(), clientContext);
    this.updateDataProductCallable =
        callableFactory.createUnaryCallable(
            updateDataProductTransportSettings,
            settings.updateDataProductSettings(),
            clientContext);
    this.updateDataProductOperationCallable =
        callableFactory.createOperationCallable(
            updateDataProductTransportSettings,
            settings.updateDataProductOperationSettings(),
            clientContext,
            operationsStub);
    this.createDataAssetCallable =
        callableFactory.createUnaryCallable(
            createDataAssetTransportSettings, settings.createDataAssetSettings(), clientContext);
    this.createDataAssetOperationCallable =
        callableFactory.createOperationCallable(
            createDataAssetTransportSettings,
            settings.createDataAssetOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDataAssetCallable =
        callableFactory.createUnaryCallable(
            updateDataAssetTransportSettings, settings.updateDataAssetSettings(), clientContext);
    this.updateDataAssetOperationCallable =
        callableFactory.createOperationCallable(
            updateDataAssetTransportSettings,
            settings.updateDataAssetOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDataAssetCallable =
        callableFactory.createUnaryCallable(
            deleteDataAssetTransportSettings, settings.deleteDataAssetSettings(), clientContext);
    this.deleteDataAssetOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataAssetTransportSettings,
            settings.deleteDataAssetOperationSettings(),
            clientContext,
            operationsStub);
    this.getDataAssetCallable =
        callableFactory.createUnaryCallable(
            getDataAssetTransportSettings, settings.getDataAssetSettings(), clientContext);
    this.listDataAssetsCallable =
        callableFactory.createUnaryCallable(
            listDataAssetsTransportSettings, settings.listDataAssetsSettings(), clientContext);
    this.listDataAssetsPagedCallable =
        callableFactory.createPagedCallable(
            listDataAssetsTransportSettings, settings.listDataAssetsSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateDataProductRequest, Operation> createDataProductCallable() {
    return createDataProductCallable;
  }

  @Override
  public OperationCallable<CreateDataProductRequest, DataProduct, OperationMetadata>
      createDataProductOperationCallable() {
    return createDataProductOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataProductRequest, Operation> deleteDataProductCallable() {
    return deleteDataProductCallable;
  }

  @Override
  public OperationCallable<DeleteDataProductRequest, Empty, OperationMetadata>
      deleteDataProductOperationCallable() {
    return deleteDataProductOperationCallable;
  }

  @Override
  public UnaryCallable<GetDataProductRequest, DataProduct> getDataProductCallable() {
    return getDataProductCallable;
  }

  @Override
  public UnaryCallable<ListDataProductsRequest, ListDataProductsResponse>
      listDataProductsCallable() {
    return listDataProductsCallable;
  }

  @Override
  public UnaryCallable<ListDataProductsRequest, ListDataProductsPagedResponse>
      listDataProductsPagedCallable() {
    return listDataProductsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateDataProductRequest, Operation> updateDataProductCallable() {
    return updateDataProductCallable;
  }

  @Override
  public OperationCallable<UpdateDataProductRequest, DataProduct, OperationMetadata>
      updateDataProductOperationCallable() {
    return updateDataProductOperationCallable;
  }

  @Override
  public UnaryCallable<CreateDataAssetRequest, Operation> createDataAssetCallable() {
    return createDataAssetCallable;
  }

  @Override
  public OperationCallable<CreateDataAssetRequest, DataAsset, OperationMetadata>
      createDataAssetOperationCallable() {
    return createDataAssetOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDataAssetRequest, Operation> updateDataAssetCallable() {
    return updateDataAssetCallable;
  }

  @Override
  public OperationCallable<UpdateDataAssetRequest, DataAsset, OperationMetadata>
      updateDataAssetOperationCallable() {
    return updateDataAssetOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDataAssetRequest, Operation> deleteDataAssetCallable() {
    return deleteDataAssetCallable;
  }

  @Override
  public OperationCallable<DeleteDataAssetRequest, Empty, OperationMetadata>
      deleteDataAssetOperationCallable() {
    return deleteDataAssetOperationCallable;
  }

  @Override
  public UnaryCallable<GetDataAssetRequest, DataAsset> getDataAssetCallable() {
    return getDataAssetCallable;
  }

  @Override
  public UnaryCallable<ListDataAssetsRequest, ListDataAssetsResponse> listDataAssetsCallable() {
    return listDataAssetsCallable;
  }

  @Override
  public UnaryCallable<ListDataAssetsRequest, ListDataAssetsPagedResponse>
      listDataAssetsPagedCallable() {
    return listDataAssetsPagedCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
