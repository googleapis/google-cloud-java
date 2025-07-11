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

package com.google.cloud.licensemanager.v1.stub;

import static com.google.cloud.licensemanager.v1.LicenseManagerClient.AggregateUsagePagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListConfigurationsPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListInstancesPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.licensemanager.v1.LicenseManagerClient.ListProductsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.licensemanager.v1.AggregateUsageRequest;
import com.google.cloud.licensemanager.v1.AggregateUsageResponse;
import com.google.cloud.licensemanager.v1.Configuration;
import com.google.cloud.licensemanager.v1.CreateConfigurationRequest;
import com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest;
import com.google.cloud.licensemanager.v1.DeleteConfigurationRequest;
import com.google.cloud.licensemanager.v1.GetConfigurationRequest;
import com.google.cloud.licensemanager.v1.GetInstanceRequest;
import com.google.cloud.licensemanager.v1.GetProductRequest;
import com.google.cloud.licensemanager.v1.Instance;
import com.google.cloud.licensemanager.v1.ListConfigurationsRequest;
import com.google.cloud.licensemanager.v1.ListConfigurationsResponse;
import com.google.cloud.licensemanager.v1.ListInstancesRequest;
import com.google.cloud.licensemanager.v1.ListInstancesResponse;
import com.google.cloud.licensemanager.v1.ListProductsRequest;
import com.google.cloud.licensemanager.v1.ListProductsResponse;
import com.google.cloud.licensemanager.v1.OperationMetadata;
import com.google.cloud.licensemanager.v1.Product;
import com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest;
import com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse;
import com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest;
import com.google.cloud.licensemanager.v1.UpdateConfigurationRequest;
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
 * gRPC stub implementation for the LicenseManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcLicenseManagerStub extends LicenseManagerStub {
  private static final MethodDescriptor<ListConfigurationsRequest, ListConfigurationsResponse>
      listConfigurationsMethodDescriptor =
          MethodDescriptor.<ListConfigurationsRequest, ListConfigurationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/ListConfigurations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConfigurationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConfigurationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConfigurationRequest, Configuration>
      getConfigurationMethodDescriptor =
          MethodDescriptor.<GetConfigurationRequest, Configuration>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/GetConfiguration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConfigurationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Configuration.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConfigurationRequest, Operation>
      createConfigurationMethodDescriptor =
          MethodDescriptor.<CreateConfigurationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.licensemanager.v1.LicenseManager/CreateConfiguration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConfigurationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConfigurationRequest, Operation>
      updateConfigurationMethodDescriptor =
          MethodDescriptor.<UpdateConfigurationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.licensemanager.v1.LicenseManager/UpdateConfiguration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConfigurationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConfigurationRequest, Operation>
      deleteConfigurationMethodDescriptor =
          MethodDescriptor.<DeleteConfigurationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.licensemanager.v1.LicenseManager/DeleteConfiguration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConfigurationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeactivateConfigurationRequest, Operation>
      deactivateConfigurationMethodDescriptor =
          MethodDescriptor.<DeactivateConfigurationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.licensemanager.v1.LicenseManager/DeactivateConfiguration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeactivateConfigurationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReactivateConfigurationRequest, Operation>
      reactivateConfigurationMethodDescriptor =
          MethodDescriptor.<ReactivateConfigurationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.licensemanager.v1.LicenseManager/ReactivateConfiguration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReactivateConfigurationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
      queryConfigurationLicenseUsageMethodDescriptor =
          MethodDescriptor
              .<QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.licensemanager.v1.LicenseManager/QueryConfigurationLicenseUsage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(QueryConfigurationLicenseUsageRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      QueryConfigurationLicenseUsageResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AggregateUsageRequest, AggregateUsageResponse>
      aggregateUsageMethodDescriptor =
          MethodDescriptor.<AggregateUsageRequest, AggregateUsageResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/AggregateUsage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AggregateUsageRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AggregateUsageResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListProductsRequest, ListProductsResponse>
      listProductsMethodDescriptor =
          MethodDescriptor.<ListProductsRequest, ListProductsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/ListProducts")
              .setRequestMarshaller(ProtoUtils.marshaller(ListProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProductsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProductRequest, Product> getProductMethodDescriptor =
      MethodDescriptor.<GetProductRequest, Product>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.licensemanager.v1.LicenseManager/GetProduct")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProductRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Product.getDefaultInstance()))
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

  private final UnaryCallable<ListConfigurationsRequest, ListConfigurationsResponse>
      listConfigurationsCallable;
  private final UnaryCallable<ListConfigurationsRequest, ListConfigurationsPagedResponse>
      listConfigurationsPagedCallable;
  private final UnaryCallable<GetConfigurationRequest, Configuration> getConfigurationCallable;
  private final UnaryCallable<CreateConfigurationRequest, Operation> createConfigurationCallable;
  private final OperationCallable<CreateConfigurationRequest, Configuration, OperationMetadata>
      createConfigurationOperationCallable;
  private final UnaryCallable<UpdateConfigurationRequest, Operation> updateConfigurationCallable;
  private final OperationCallable<UpdateConfigurationRequest, Configuration, OperationMetadata>
      updateConfigurationOperationCallable;
  private final UnaryCallable<DeleteConfigurationRequest, Operation> deleteConfigurationCallable;
  private final OperationCallable<DeleteConfigurationRequest, Empty, OperationMetadata>
      deleteConfigurationOperationCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<DeactivateConfigurationRequest, Operation>
      deactivateConfigurationCallable;
  private final OperationCallable<DeactivateConfigurationRequest, Configuration, OperationMetadata>
      deactivateConfigurationOperationCallable;
  private final UnaryCallable<ReactivateConfigurationRequest, Operation>
      reactivateConfigurationCallable;
  private final OperationCallable<ReactivateConfigurationRequest, Configuration, OperationMetadata>
      reactivateConfigurationOperationCallable;
  private final UnaryCallable<
          QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
      queryConfigurationLicenseUsageCallable;
  private final UnaryCallable<AggregateUsageRequest, AggregateUsageResponse> aggregateUsageCallable;
  private final UnaryCallable<AggregateUsageRequest, AggregateUsagePagedResponse>
      aggregateUsagePagedCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable;
  private final UnaryCallable<GetProductRequest, Product> getProductCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLicenseManagerStub create(LicenseManagerStubSettings settings)
      throws IOException {
    return new GrpcLicenseManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLicenseManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLicenseManagerStub(
        LicenseManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLicenseManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLicenseManagerStub(
        LicenseManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLicenseManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLicenseManagerStub(LicenseManagerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcLicenseManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLicenseManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLicenseManagerStub(
      LicenseManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListConfigurationsRequest, ListConfigurationsResponse>
        listConfigurationsTransportSettings =
            GrpcCallSettings.<ListConfigurationsRequest, ListConfigurationsResponse>newBuilder()
                .setMethodDescriptor(listConfigurationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConfigurationRequest, Configuration> getConfigurationTransportSettings =
        GrpcCallSettings.<GetConfigurationRequest, Configuration>newBuilder()
            .setMethodDescriptor(getConfigurationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateConfigurationRequest, Operation> createConfigurationTransportSettings =
        GrpcCallSettings.<CreateConfigurationRequest, Operation>newBuilder()
            .setMethodDescriptor(createConfigurationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateConfigurationRequest, Operation> updateConfigurationTransportSettings =
        GrpcCallSettings.<UpdateConfigurationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateConfigurationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "configuration.name", String.valueOf(request.getConfiguration().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteConfigurationRequest, Operation> deleteConfigurationTransportSettings =
        GrpcCallSettings.<DeleteConfigurationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteConfigurationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeactivateConfigurationRequest, Operation>
        deactivateConfigurationTransportSettings =
            GrpcCallSettings.<DeactivateConfigurationRequest, Operation>newBuilder()
                .setMethodDescriptor(deactivateConfigurationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ReactivateConfigurationRequest, Operation>
        reactivateConfigurationTransportSettings =
            GrpcCallSettings.<ReactivateConfigurationRequest, Operation>newBuilder()
                .setMethodDescriptor(reactivateConfigurationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
        queryConfigurationLicenseUsageTransportSettings =
            GrpcCallSettings
                .<QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
                    newBuilder()
                .setMethodDescriptor(queryConfigurationLicenseUsageMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<AggregateUsageRequest, AggregateUsageResponse>
        aggregateUsageTransportSettings =
            GrpcCallSettings.<AggregateUsageRequest, AggregateUsageResponse>newBuilder()
                .setMethodDescriptor(aggregateUsageMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListProductsRequest, ListProductsResponse> listProductsTransportSettings =
        GrpcCallSettings.<ListProductsRequest, ListProductsResponse>newBuilder()
            .setMethodDescriptor(listProductsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetProductRequest, Product> getProductTransportSettings =
        GrpcCallSettings.<GetProductRequest, Product>newBuilder()
            .setMethodDescriptor(getProductMethodDescriptor)
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

    this.listConfigurationsCallable =
        callableFactory.createUnaryCallable(
            listConfigurationsTransportSettings,
            settings.listConfigurationsSettings(),
            clientContext);
    this.listConfigurationsPagedCallable =
        callableFactory.createPagedCallable(
            listConfigurationsTransportSettings,
            settings.listConfigurationsSettings(),
            clientContext);
    this.getConfigurationCallable =
        callableFactory.createUnaryCallable(
            getConfigurationTransportSettings, settings.getConfigurationSettings(), clientContext);
    this.createConfigurationCallable =
        callableFactory.createUnaryCallable(
            createConfigurationTransportSettings,
            settings.createConfigurationSettings(),
            clientContext);
    this.createConfigurationOperationCallable =
        callableFactory.createOperationCallable(
            createConfigurationTransportSettings,
            settings.createConfigurationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateConfigurationCallable =
        callableFactory.createUnaryCallable(
            updateConfigurationTransportSettings,
            settings.updateConfigurationSettings(),
            clientContext);
    this.updateConfigurationOperationCallable =
        callableFactory.createOperationCallable(
            updateConfigurationTransportSettings,
            settings.updateConfigurationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteConfigurationCallable =
        callableFactory.createUnaryCallable(
            deleteConfigurationTransportSettings,
            settings.deleteConfigurationSettings(),
            clientContext);
    this.deleteConfigurationOperationCallable =
        callableFactory.createOperationCallable(
            deleteConfigurationTransportSettings,
            settings.deleteConfigurationOperationSettings(),
            clientContext,
            operationsStub);
    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.deactivateConfigurationCallable =
        callableFactory.createUnaryCallable(
            deactivateConfigurationTransportSettings,
            settings.deactivateConfigurationSettings(),
            clientContext);
    this.deactivateConfigurationOperationCallable =
        callableFactory.createOperationCallable(
            deactivateConfigurationTransportSettings,
            settings.deactivateConfigurationOperationSettings(),
            clientContext,
            operationsStub);
    this.reactivateConfigurationCallable =
        callableFactory.createUnaryCallable(
            reactivateConfigurationTransportSettings,
            settings.reactivateConfigurationSettings(),
            clientContext);
    this.reactivateConfigurationOperationCallable =
        callableFactory.createOperationCallable(
            reactivateConfigurationTransportSettings,
            settings.reactivateConfigurationOperationSettings(),
            clientContext,
            operationsStub);
    this.queryConfigurationLicenseUsageCallable =
        callableFactory.createUnaryCallable(
            queryConfigurationLicenseUsageTransportSettings,
            settings.queryConfigurationLicenseUsageSettings(),
            clientContext);
    this.aggregateUsageCallable =
        callableFactory.createUnaryCallable(
            aggregateUsageTransportSettings, settings.aggregateUsageSettings(), clientContext);
    this.aggregateUsagePagedCallable =
        callableFactory.createPagedCallable(
            aggregateUsageTransportSettings, settings.aggregateUsageSettings(), clientContext);
    this.listProductsCallable =
        callableFactory.createUnaryCallable(
            listProductsTransportSettings, settings.listProductsSettings(), clientContext);
    this.listProductsPagedCallable =
        callableFactory.createPagedCallable(
            listProductsTransportSettings, settings.listProductsSettings(), clientContext);
    this.getProductCallable =
        callableFactory.createUnaryCallable(
            getProductTransportSettings, settings.getProductSettings(), clientContext);
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
  public UnaryCallable<ListConfigurationsRequest, ListConfigurationsResponse>
      listConfigurationsCallable() {
    return listConfigurationsCallable;
  }

  @Override
  public UnaryCallable<ListConfigurationsRequest, ListConfigurationsPagedResponse>
      listConfigurationsPagedCallable() {
    return listConfigurationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConfigurationRequest, Configuration> getConfigurationCallable() {
    return getConfigurationCallable;
  }

  @Override
  public UnaryCallable<CreateConfigurationRequest, Operation> createConfigurationCallable() {
    return createConfigurationCallable;
  }

  @Override
  public OperationCallable<CreateConfigurationRequest, Configuration, OperationMetadata>
      createConfigurationOperationCallable() {
    return createConfigurationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConfigurationRequest, Operation> updateConfigurationCallable() {
    return updateConfigurationCallable;
  }

  @Override
  public OperationCallable<UpdateConfigurationRequest, Configuration, OperationMetadata>
      updateConfigurationOperationCallable() {
    return updateConfigurationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConfigurationRequest, Operation> deleteConfigurationCallable() {
    return deleteConfigurationCallable;
  }

  @Override
  public OperationCallable<DeleteConfigurationRequest, Empty, OperationMetadata>
      deleteConfigurationOperationCallable() {
    return deleteConfigurationOperationCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<DeactivateConfigurationRequest, Operation>
      deactivateConfigurationCallable() {
    return deactivateConfigurationCallable;
  }

  @Override
  public OperationCallable<DeactivateConfigurationRequest, Configuration, OperationMetadata>
      deactivateConfigurationOperationCallable() {
    return deactivateConfigurationOperationCallable;
  }

  @Override
  public UnaryCallable<ReactivateConfigurationRequest, Operation>
      reactivateConfigurationCallable() {
    return reactivateConfigurationCallable;
  }

  @Override
  public OperationCallable<ReactivateConfigurationRequest, Configuration, OperationMetadata>
      reactivateConfigurationOperationCallable() {
    return reactivateConfigurationOperationCallable;
  }

  @Override
  public UnaryCallable<
          QueryConfigurationLicenseUsageRequest, QueryConfigurationLicenseUsageResponse>
      queryConfigurationLicenseUsageCallable() {
    return queryConfigurationLicenseUsageCallable;
  }

  @Override
  public UnaryCallable<AggregateUsageRequest, AggregateUsageResponse> aggregateUsageCallable() {
    return aggregateUsageCallable;
  }

  @Override
  public UnaryCallable<AggregateUsageRequest, AggregateUsagePagedResponse>
      aggregateUsagePagedCallable() {
    return aggregateUsagePagedCallable;
  }

  @Override
  public UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    return listProductsCallable;
  }

  @Override
  public UnaryCallable<ListProductsRequest, ListProductsPagedResponse> listProductsPagedCallable() {
    return listProductsPagedCallable;
  }

  @Override
  public UnaryCallable<GetProductRequest, Product> getProductCallable() {
    return getProductCallable;
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
