/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.metastore.v1.stub;

import static com.google.cloud.metastore.v1.DataprocMetastoreClient.ListMetadataImportsPagedResponse;
import static com.google.cloud.metastore.v1.DataprocMetastoreClient.ListServicesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.metastore.v1.CreateMetadataImportRequest;
import com.google.cloud.metastore.v1.CreateServiceRequest;
import com.google.cloud.metastore.v1.DeleteServiceRequest;
import com.google.cloud.metastore.v1.ExportMetadataRequest;
import com.google.cloud.metastore.v1.GetMetadataImportRequest;
import com.google.cloud.metastore.v1.GetServiceRequest;
import com.google.cloud.metastore.v1.ListMetadataImportsRequest;
import com.google.cloud.metastore.v1.ListMetadataImportsResponse;
import com.google.cloud.metastore.v1.ListServicesRequest;
import com.google.cloud.metastore.v1.ListServicesResponse;
import com.google.cloud.metastore.v1.MetadataExport;
import com.google.cloud.metastore.v1.MetadataImport;
import com.google.cloud.metastore.v1.OperationMetadata;
import com.google.cloud.metastore.v1.Service;
import com.google.cloud.metastore.v1.UpdateMetadataImportRequest;
import com.google.cloud.metastore.v1.UpdateServiceRequest;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the DataprocMetastore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDataprocMetastoreStub extends DataprocMetastoreStub {
  private static final MethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          MethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1.DataprocMetastore/ListServices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      MethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.metastore.v1.DataprocMetastore/GetService")
          .setRequestMarshaller(ProtoUtils.marshaller(GetServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateServiceRequest, Operation>
      createServiceMethodDescriptor =
          MethodDescriptor.<CreateServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1.DataprocMetastore/CreateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateServiceRequest, Operation>
      updateServiceMethodDescriptor =
          MethodDescriptor.<UpdateServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1.DataprocMetastore/UpdateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServiceRequest, Operation>
      deleteServiceMethodDescriptor =
          MethodDescriptor.<DeleteServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1.DataprocMetastore/DeleteService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMetadataImportsRequest, ListMetadataImportsResponse>
      listMetadataImportsMethodDescriptor =
          MethodDescriptor.<ListMetadataImportsRequest, ListMetadataImportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1.DataprocMetastore/ListMetadataImports")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMetadataImportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMetadataImportsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMetadataImportRequest, MetadataImport>
      getMetadataImportMethodDescriptor =
          MethodDescriptor.<GetMetadataImportRequest, MetadataImport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1.DataprocMetastore/GetMetadataImport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMetadataImportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MetadataImport.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMetadataImportRequest, Operation>
      createMetadataImportMethodDescriptor =
          MethodDescriptor.<CreateMetadataImportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1.DataprocMetastore/CreateMetadataImport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMetadataImportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateMetadataImportRequest, Operation>
      updateMetadataImportMethodDescriptor =
          MethodDescriptor.<UpdateMetadataImportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1.DataprocMetastore/UpdateMetadataImport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMetadataImportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportMetadataRequest, Operation>
      exportMetadataMethodDescriptor =
          MethodDescriptor.<ExportMetadataRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.metastore.v1.DataprocMetastore/ExportMetadata")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<GetServiceRequest, Service> getServiceCallable;
  private final UnaryCallable<CreateServiceRequest, Operation> createServiceCallable;
  private final OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable;
  private final UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable;
  private final OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable;
  private final UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable;
  private final OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable;
  private final UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsResponse>
      listMetadataImportsCallable;
  private final UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsPagedResponse>
      listMetadataImportsPagedCallable;
  private final UnaryCallable<GetMetadataImportRequest, MetadataImport> getMetadataImportCallable;
  private final UnaryCallable<CreateMetadataImportRequest, Operation> createMetadataImportCallable;
  private final OperationCallable<CreateMetadataImportRequest, MetadataImport, OperationMetadata>
      createMetadataImportOperationCallable;
  private final UnaryCallable<UpdateMetadataImportRequest, Operation> updateMetadataImportCallable;
  private final OperationCallable<UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
      updateMetadataImportOperationCallable;
  private final UnaryCallable<ExportMetadataRequest, Operation> exportMetadataCallable;
  private final OperationCallable<ExportMetadataRequest, MetadataExport, OperationMetadata>
      exportMetadataOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataprocMetastoreStub create(DataprocMetastoreStubSettings settings)
      throws IOException {
    return new GrpcDataprocMetastoreStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataprocMetastoreStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataprocMetastoreStub(
        DataprocMetastoreStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataprocMetastoreStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataprocMetastoreStub(
        DataprocMetastoreStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataprocMetastoreStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataprocMetastoreStub(
      DataprocMetastoreStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDataprocMetastoreCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataprocMetastoreStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDataprocMetastoreStub(
      DataprocMetastoreStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        GrpcCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListServicesRequest>() {
                  @Override
                  public Map<String, String> extract(ListServicesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        GrpcCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetServiceRequest>() {
                  @Override
                  public Map<String, String> extract(GetServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateServiceRequest, Operation> createServiceTransportSettings =
        GrpcCallSettings.<CreateServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(createServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateServiceRequest>() {
                  @Override
                  public Map<String, String> extract(CreateServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateServiceRequest, Operation> updateServiceTransportSettings =
        GrpcCallSettings.<UpdateServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateServiceRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("service.name", String.valueOf(request.getService().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteServiceRequest, Operation> deleteServiceTransportSettings =
        GrpcCallSettings.<DeleteServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteServiceRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListMetadataImportsRequest, ListMetadataImportsResponse>
        listMetadataImportsTransportSettings =
            GrpcCallSettings.<ListMetadataImportsRequest, ListMetadataImportsResponse>newBuilder()
                .setMethodDescriptor(listMetadataImportsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListMetadataImportsRequest>() {
                      @Override
                      public Map<String, String> extract(ListMetadataImportsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetMetadataImportRequest, MetadataImport> getMetadataImportTransportSettings =
        GrpcCallSettings.<GetMetadataImportRequest, MetadataImport>newBuilder()
            .setMethodDescriptor(getMetadataImportMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetMetadataImportRequest>() {
                  @Override
                  public Map<String, String> extract(GetMetadataImportRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateMetadataImportRequest, Operation> createMetadataImportTransportSettings =
        GrpcCallSettings.<CreateMetadataImportRequest, Operation>newBuilder()
            .setMethodDescriptor(createMetadataImportMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateMetadataImportRequest>() {
                  @Override
                  public Map<String, String> extract(CreateMetadataImportRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateMetadataImportRequest, Operation> updateMetadataImportTransportSettings =
        GrpcCallSettings.<UpdateMetadataImportRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMetadataImportMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateMetadataImportRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateMetadataImportRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "metadata_import.name",
                        String.valueOf(request.getMetadataImport().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ExportMetadataRequest, Operation> exportMetadataTransportSettings =
        GrpcCallSettings.<ExportMetadataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportMetadataMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ExportMetadataRequest>() {
                  @Override
                  public Map<String, String> extract(ExportMetadataRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("service", String.valueOf(request.getService()));
                    return params.build();
                  }
                })
            .build();

    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.createServiceCallable =
        callableFactory.createUnaryCallable(
            createServiceTransportSettings, settings.createServiceSettings(), clientContext);
    this.createServiceOperationCallable =
        callableFactory.createOperationCallable(
            createServiceTransportSettings,
            settings.createServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.updateServiceCallable =
        callableFactory.createUnaryCallable(
            updateServiceTransportSettings, settings.updateServiceSettings(), clientContext);
    this.updateServiceOperationCallable =
        callableFactory.createOperationCallable(
            updateServiceTransportSettings,
            settings.updateServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteServiceCallable =
        callableFactory.createUnaryCallable(
            deleteServiceTransportSettings, settings.deleteServiceSettings(), clientContext);
    this.deleteServiceOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceTransportSettings,
            settings.deleteServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.listMetadataImportsCallable =
        callableFactory.createUnaryCallable(
            listMetadataImportsTransportSettings,
            settings.listMetadataImportsSettings(),
            clientContext);
    this.listMetadataImportsPagedCallable =
        callableFactory.createPagedCallable(
            listMetadataImportsTransportSettings,
            settings.listMetadataImportsSettings(),
            clientContext);
    this.getMetadataImportCallable =
        callableFactory.createUnaryCallable(
            getMetadataImportTransportSettings,
            settings.getMetadataImportSettings(),
            clientContext);
    this.createMetadataImportCallable =
        callableFactory.createUnaryCallable(
            createMetadataImportTransportSettings,
            settings.createMetadataImportSettings(),
            clientContext);
    this.createMetadataImportOperationCallable =
        callableFactory.createOperationCallable(
            createMetadataImportTransportSettings,
            settings.createMetadataImportOperationSettings(),
            clientContext,
            operationsStub);
    this.updateMetadataImportCallable =
        callableFactory.createUnaryCallable(
            updateMetadataImportTransportSettings,
            settings.updateMetadataImportSettings(),
            clientContext);
    this.updateMetadataImportOperationCallable =
        callableFactory.createOperationCallable(
            updateMetadataImportTransportSettings,
            settings.updateMetadataImportOperationSettings(),
            clientContext,
            operationsStub);
    this.exportMetadataCallable =
        callableFactory.createUnaryCallable(
            exportMetadataTransportSettings, settings.exportMetadataSettings(), clientContext);
    this.exportMetadataOperationCallable =
        callableFactory.createOperationCallable(
            exportMetadataTransportSettings,
            settings.exportMetadataOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return listServicesCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    return listServicesPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return getServiceCallable;
  }

  @Override
  public UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    return createServiceCallable;
  }

  @Override
  public OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable() {
    return createServiceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable() {
    return updateServiceCallable;
  }

  @Override
  public OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable() {
    return updateServiceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    return deleteServiceCallable;
  }

  @Override
  public OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    return deleteServiceOperationCallable;
  }

  @Override
  public UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsResponse>
      listMetadataImportsCallable() {
    return listMetadataImportsCallable;
  }

  @Override
  public UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsPagedResponse>
      listMetadataImportsPagedCallable() {
    return listMetadataImportsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMetadataImportRequest, MetadataImport> getMetadataImportCallable() {
    return getMetadataImportCallable;
  }

  @Override
  public UnaryCallable<CreateMetadataImportRequest, Operation> createMetadataImportCallable() {
    return createMetadataImportCallable;
  }

  @Override
  public OperationCallable<CreateMetadataImportRequest, MetadataImport, OperationMetadata>
      createMetadataImportOperationCallable() {
    return createMetadataImportOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMetadataImportRequest, Operation> updateMetadataImportCallable() {
    return updateMetadataImportCallable;
  }

  @Override
  public OperationCallable<UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
      updateMetadataImportOperationCallable() {
    return updateMetadataImportOperationCallable;
  }

  @Override
  public UnaryCallable<ExportMetadataRequest, Operation> exportMetadataCallable() {
    return exportMetadataCallable;
  }

  @Override
  public OperationCallable<ExportMetadataRequest, MetadataExport, OperationMetadata>
      exportMetadataOperationCallable() {
    return exportMetadataOperationCallable;
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
