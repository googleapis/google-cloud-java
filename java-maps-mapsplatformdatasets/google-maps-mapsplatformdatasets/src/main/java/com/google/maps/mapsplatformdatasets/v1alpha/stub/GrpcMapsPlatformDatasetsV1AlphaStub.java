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

package com.google.maps.mapsplatformdatasets.v1alpha.stub;

import static com.google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1AlphaClient.ListDatasetVersionsPagedResponse;
import static com.google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1AlphaClient.ListDatasetsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.maps.mapsplatformdatasets.v1alpha.CreateDatasetRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.Dataset;
import com.google.maps.mapsplatformdatasets.v1alpha.DeleteDatasetRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.DeleteDatasetVersionRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.GetDatasetRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.ListDatasetVersionsRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.ListDatasetVersionsResponse;
import com.google.maps.mapsplatformdatasets.v1alpha.ListDatasetsRequest;
import com.google.maps.mapsplatformdatasets.v1alpha.ListDatasetsResponse;
import com.google.maps.mapsplatformdatasets.v1alpha.UpdateDatasetMetadataRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MapsPlatformDatasetsV1Alpha service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMapsPlatformDatasetsV1AlphaStub extends MapsPlatformDatasetsV1AlphaStub {
  private static final MethodDescriptor<CreateDatasetRequest, Dataset>
      createDatasetMethodDescriptor =
          MethodDescriptor.<CreateDatasetRequest, Dataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1Alpha/CreateDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDatasetMetadataRequest, Dataset>
      updateDatasetMetadataMethodDescriptor =
          MethodDescriptor.<UpdateDatasetMetadataRequest, Dataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1Alpha/UpdateDatasetMetadata")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatasetMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      MethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1Alpha/GetDataset")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDatasetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListDatasetVersionsRequest, ListDatasetVersionsResponse>
      listDatasetVersionsMethodDescriptor =
          MethodDescriptor.<ListDatasetVersionsRequest, ListDatasetVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1Alpha/ListDatasetVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDatasetVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatasetVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          MethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1Alpha/ListDatasets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatasetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDatasetRequest, Empty> deleteDatasetMethodDescriptor =
      MethodDescriptor.<DeleteDatasetRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1Alpha/DeleteDataset")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteDatasetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteDatasetVersionRequest, Empty>
      deleteDatasetVersionMethodDescriptor =
          MethodDescriptor.<DeleteDatasetVersionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.maps.mapsplatformdatasets.v1alpha.MapsPlatformDatasetsV1Alpha/DeleteDatasetVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDatasetVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable;
  private final UnaryCallable<UpdateDatasetMetadataRequest, Dataset> updateDatasetMetadataCallable;
  private final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable;
  private final UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsResponse>
      listDatasetVersionsCallable;
  private final UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsPagedResponse>
      listDatasetVersionsPagedCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable;
  private final UnaryCallable<DeleteDatasetRequest, Empty> deleteDatasetCallable;
  private final UnaryCallable<DeleteDatasetVersionRequest, Empty> deleteDatasetVersionCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMapsPlatformDatasetsV1AlphaStub create(
      MapsPlatformDatasetsV1AlphaStubSettings settings) throws IOException {
    return new GrpcMapsPlatformDatasetsV1AlphaStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMapsPlatformDatasetsV1AlphaStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMapsPlatformDatasetsV1AlphaStub(
        MapsPlatformDatasetsV1AlphaStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMapsPlatformDatasetsV1AlphaStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMapsPlatformDatasetsV1AlphaStub(
        MapsPlatformDatasetsV1AlphaStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcMapsPlatformDatasetsV1AlphaStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMapsPlatformDatasetsV1AlphaStub(
      MapsPlatformDatasetsV1AlphaStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMapsPlatformDatasetsV1AlphaCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMapsPlatformDatasetsV1AlphaStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMapsPlatformDatasetsV1AlphaStub(
      MapsPlatformDatasetsV1AlphaStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDatasetRequest, Dataset> createDatasetTransportSettings =
        GrpcCallSettings.<CreateDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(createDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDatasetMetadataRequest, Dataset> updateDatasetMetadataTransportSettings =
        GrpcCallSettings.<UpdateDatasetMetadataRequest, Dataset>newBuilder()
            .setMethodDescriptor(updateDatasetMetadataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset.name", String.valueOf(request.getDataset().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        GrpcCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDatasetVersionsRequest, ListDatasetVersionsResponse>
        listDatasetVersionsTransportSettings =
            GrpcCallSettings.<ListDatasetVersionsRequest, ListDatasetVersionsResponse>newBuilder()
                .setMethodDescriptor(listDatasetVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        GrpcCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDatasetRequest, Empty> deleteDatasetTransportSettings =
        GrpcCallSettings.<DeleteDatasetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDatasetVersionRequest, Empty> deleteDatasetVersionTransportSettings =
        GrpcCallSettings.<DeleteDatasetVersionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDatasetVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createDatasetCallable =
        callableFactory.createUnaryCallable(
            createDatasetTransportSettings, settings.createDatasetSettings(), clientContext);
    this.updateDatasetMetadataCallable =
        callableFactory.createUnaryCallable(
            updateDatasetMetadataTransportSettings,
            settings.updateDatasetMetadataSettings(),
            clientContext);
    this.getDatasetCallable =
        callableFactory.createUnaryCallable(
            getDatasetTransportSettings, settings.getDatasetSettings(), clientContext);
    this.listDatasetVersionsCallable =
        callableFactory.createUnaryCallable(
            listDatasetVersionsTransportSettings,
            settings.listDatasetVersionsSettings(),
            clientContext);
    this.listDatasetVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetVersionsTransportSettings,
            settings.listDatasetVersionsSettings(),
            clientContext);
    this.listDatasetsCallable =
        callableFactory.createUnaryCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.listDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.deleteDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteDatasetTransportSettings, settings.deleteDatasetSettings(), clientContext);
    this.deleteDatasetVersionCallable =
        callableFactory.createUnaryCallable(
            deleteDatasetVersionTransportSettings,
            settings.deleteDatasetVersionSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable() {
    return createDatasetCallable;
  }

  @Override
  public UnaryCallable<UpdateDatasetMetadataRequest, Dataset> updateDatasetMetadataCallable() {
    return updateDatasetMetadataCallable;
  }

  @Override
  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return getDatasetCallable;
  }

  @Override
  public UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsResponse>
      listDatasetVersionsCallable() {
    return listDatasetVersionsCallable;
  }

  @Override
  public UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsPagedResponse>
      listDatasetVersionsPagedCallable() {
    return listDatasetVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return listDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    return listDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDatasetRequest, Empty> deleteDatasetCallable() {
    return deleteDatasetCallable;
  }

  @Override
  public UnaryCallable<DeleteDatasetVersionRequest, Empty> deleteDatasetVersionCallable() {
    return deleteDatasetVersionCallable;
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
