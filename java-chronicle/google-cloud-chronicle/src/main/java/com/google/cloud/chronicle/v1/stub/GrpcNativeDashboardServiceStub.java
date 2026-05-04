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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.NativeDashboardServiceClient.ListNativeDashboardsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.AddChartRequest;
import com.google.cloud.chronicle.v1.AddChartResponse;
import com.google.cloud.chronicle.v1.CreateNativeDashboardRequest;
import com.google.cloud.chronicle.v1.DeleteNativeDashboardRequest;
import com.google.cloud.chronicle.v1.DuplicateChartRequest;
import com.google.cloud.chronicle.v1.DuplicateChartResponse;
import com.google.cloud.chronicle.v1.DuplicateNativeDashboardRequest;
import com.google.cloud.chronicle.v1.EditChartRequest;
import com.google.cloud.chronicle.v1.EditChartResponse;
import com.google.cloud.chronicle.v1.ExportNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ExportNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.GetNativeDashboardRequest;
import com.google.cloud.chronicle.v1.ImportNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ImportNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.ListNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ListNativeDashboardsResponse;
import com.google.cloud.chronicle.v1.NativeDashboard;
import com.google.cloud.chronicle.v1.RemoveChartRequest;
import com.google.cloud.chronicle.v1.UpdateNativeDashboardRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the NativeDashboardService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcNativeDashboardServiceStub extends NativeDashboardServiceStub {
  private static final MethodDescriptor<CreateNativeDashboardRequest, NativeDashboard>
      createNativeDashboardMethodDescriptor =
          MethodDescriptor.<CreateNativeDashboardRequest, NativeDashboard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/CreateNativeDashboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNativeDashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NativeDashboard.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetNativeDashboardRequest, NativeDashboard>
      getNativeDashboardMethodDescriptor =
          MethodDescriptor.<GetNativeDashboardRequest, NativeDashboard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/GetNativeDashboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNativeDashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NativeDashboard.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListNativeDashboardsRequest, ListNativeDashboardsResponse>
      listNativeDashboardsMethodDescriptor =
          MethodDescriptor.<ListNativeDashboardsRequest, ListNativeDashboardsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/ListNativeDashboards")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNativeDashboardsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNativeDashboardsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateNativeDashboardRequest, NativeDashboard>
      updateNativeDashboardMethodDescriptor =
          MethodDescriptor.<UpdateNativeDashboardRequest, NativeDashboard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/UpdateNativeDashboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNativeDashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NativeDashboard.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DuplicateNativeDashboardRequest, NativeDashboard>
      duplicateNativeDashboardMethodDescriptor =
          MethodDescriptor.<DuplicateNativeDashboardRequest, NativeDashboard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/DuplicateNativeDashboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DuplicateNativeDashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NativeDashboard.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteNativeDashboardRequest, Empty>
      deleteNativeDashboardMethodDescriptor =
          MethodDescriptor.<DeleteNativeDashboardRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/DeleteNativeDashboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNativeDashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AddChartRequest, AddChartResponse>
      addChartMethodDescriptor =
          MethodDescriptor.<AddChartRequest, AddChartResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.NativeDashboardService/AddChart")
              .setRequestMarshaller(ProtoUtils.marshaller(AddChartRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AddChartResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RemoveChartRequest, NativeDashboard>
      removeChartMethodDescriptor =
          MethodDescriptor.<RemoveChartRequest, NativeDashboard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.NativeDashboardService/RemoveChart")
              .setRequestMarshaller(ProtoUtils.marshaller(RemoveChartRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NativeDashboard.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<EditChartRequest, EditChartResponse>
      editChartMethodDescriptor =
          MethodDescriptor.<EditChartRequest, EditChartResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.NativeDashboardService/EditChart")
              .setRequestMarshaller(ProtoUtils.marshaller(EditChartRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EditChartResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DuplicateChartRequest, DuplicateChartResponse>
      duplicateChartMethodDescriptor =
          MethodDescriptor.<DuplicateChartRequest, DuplicateChartResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.NativeDashboardService/DuplicateChart")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DuplicateChartRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DuplicateChartResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
      exportNativeDashboardsMethodDescriptor =
          MethodDescriptor
              .<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/ExportNativeDashboards")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportNativeDashboardsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ExportNativeDashboardsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
      importNativeDashboardsMethodDescriptor =
          MethodDescriptor
              .<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.chronicle.v1.NativeDashboardService/ImportNativeDashboards")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportNativeDashboardsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ImportNativeDashboardsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateNativeDashboardRequest, NativeDashboard>
      createNativeDashboardCallable;
  private final UnaryCallable<GetNativeDashboardRequest, NativeDashboard>
      getNativeDashboardCallable;
  private final UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsResponse>
      listNativeDashboardsCallable;
  private final UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsPagedResponse>
      listNativeDashboardsPagedCallable;
  private final UnaryCallable<UpdateNativeDashboardRequest, NativeDashboard>
      updateNativeDashboardCallable;
  private final UnaryCallable<DuplicateNativeDashboardRequest, NativeDashboard>
      duplicateNativeDashboardCallable;
  private final UnaryCallable<DeleteNativeDashboardRequest, Empty> deleteNativeDashboardCallable;
  private final UnaryCallable<AddChartRequest, AddChartResponse> addChartCallable;
  private final UnaryCallable<RemoveChartRequest, NativeDashboard> removeChartCallable;
  private final UnaryCallable<EditChartRequest, EditChartResponse> editChartCallable;
  private final UnaryCallable<DuplicateChartRequest, DuplicateChartResponse> duplicateChartCallable;
  private final UnaryCallable<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
      exportNativeDashboardsCallable;
  private final UnaryCallable<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
      importNativeDashboardsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcNativeDashboardServiceStub create(
      NativeDashboardServiceStubSettings settings) throws IOException {
    return new GrpcNativeDashboardServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNativeDashboardServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcNativeDashboardServiceStub(
        NativeDashboardServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNativeDashboardServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNativeDashboardServiceStub(
        NativeDashboardServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcNativeDashboardServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcNativeDashboardServiceStub(
      NativeDashboardServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcNativeDashboardServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNativeDashboardServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcNativeDashboardServiceStub(
      NativeDashboardServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateNativeDashboardRequest, NativeDashboard>
        createNativeDashboardTransportSettings =
            GrpcCallSettings.<CreateNativeDashboardRequest, NativeDashboard>newBuilder()
                .setMethodDescriptor(createNativeDashboardMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetNativeDashboardRequest, NativeDashboard>
        getNativeDashboardTransportSettings =
            GrpcCallSettings.<GetNativeDashboardRequest, NativeDashboard>newBuilder()
                .setMethodDescriptor(getNativeDashboardMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListNativeDashboardsRequest, ListNativeDashboardsResponse>
        listNativeDashboardsTransportSettings =
            GrpcCallSettings.<ListNativeDashboardsRequest, ListNativeDashboardsResponse>newBuilder()
                .setMethodDescriptor(listNativeDashboardsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateNativeDashboardRequest, NativeDashboard>
        updateNativeDashboardTransportSettings =
            GrpcCallSettings.<UpdateNativeDashboardRequest, NativeDashboard>newBuilder()
                .setMethodDescriptor(updateNativeDashboardMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "native_dashboard.name",
                          String.valueOf(request.getNativeDashboard().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DuplicateNativeDashboardRequest, NativeDashboard>
        duplicateNativeDashboardTransportSettings =
            GrpcCallSettings.<DuplicateNativeDashboardRequest, NativeDashboard>newBuilder()
                .setMethodDescriptor(duplicateNativeDashboardMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<DeleteNativeDashboardRequest, Empty> deleteNativeDashboardTransportSettings =
        GrpcCallSettings.<DeleteNativeDashboardRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteNativeDashboardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<AddChartRequest, AddChartResponse> addChartTransportSettings =
        GrpcCallSettings.<AddChartRequest, AddChartResponse>newBuilder()
            .setMethodDescriptor(addChartMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<RemoveChartRequest, NativeDashboard> removeChartTransportSettings =
        GrpcCallSettings.<RemoveChartRequest, NativeDashboard>newBuilder()
            .setMethodDescriptor(removeChartMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<EditChartRequest, EditChartResponse> editChartTransportSettings =
        GrpcCallSettings.<EditChartRequest, EditChartResponse>newBuilder()
            .setMethodDescriptor(editChartMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<DuplicateChartRequest, DuplicateChartResponse>
        duplicateChartTransportSettings =
            GrpcCallSettings.<DuplicateChartRequest, DuplicateChartResponse>newBuilder()
                .setMethodDescriptor(duplicateChartMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
        exportNativeDashboardsTransportSettings =
            GrpcCallSettings
                .<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>newBuilder()
                .setMethodDescriptor(exportNativeDashboardsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
        importNativeDashboardsTransportSettings =
            GrpcCallSettings
                .<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>newBuilder()
                .setMethodDescriptor(importNativeDashboardsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.createNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            createNativeDashboardTransportSettings,
            settings.createNativeDashboardSettings(),
            clientContext);
    this.getNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            getNativeDashboardTransportSettings,
            settings.getNativeDashboardSettings(),
            clientContext);
    this.listNativeDashboardsCallable =
        callableFactory.createUnaryCallable(
            listNativeDashboardsTransportSettings,
            settings.listNativeDashboardsSettings(),
            clientContext);
    this.listNativeDashboardsPagedCallable =
        callableFactory.createPagedCallable(
            listNativeDashboardsTransportSettings,
            settings.listNativeDashboardsSettings(),
            clientContext);
    this.updateNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            updateNativeDashboardTransportSettings,
            settings.updateNativeDashboardSettings(),
            clientContext);
    this.duplicateNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            duplicateNativeDashboardTransportSettings,
            settings.duplicateNativeDashboardSettings(),
            clientContext);
    this.deleteNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            deleteNativeDashboardTransportSettings,
            settings.deleteNativeDashboardSettings(),
            clientContext);
    this.addChartCallable =
        callableFactory.createUnaryCallable(
            addChartTransportSettings, settings.addChartSettings(), clientContext);
    this.removeChartCallable =
        callableFactory.createUnaryCallable(
            removeChartTransportSettings, settings.removeChartSettings(), clientContext);
    this.editChartCallable =
        callableFactory.createUnaryCallable(
            editChartTransportSettings, settings.editChartSettings(), clientContext);
    this.duplicateChartCallable =
        callableFactory.createUnaryCallable(
            duplicateChartTransportSettings, settings.duplicateChartSettings(), clientContext);
    this.exportNativeDashboardsCallable =
        callableFactory.createUnaryCallable(
            exportNativeDashboardsTransportSettings,
            settings.exportNativeDashboardsSettings(),
            clientContext);
    this.importNativeDashboardsCallable =
        callableFactory.createUnaryCallable(
            importNativeDashboardsTransportSettings,
            settings.importNativeDashboardsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateNativeDashboardRequest, NativeDashboard>
      createNativeDashboardCallable() {
    return createNativeDashboardCallable;
  }

  @Override
  public UnaryCallable<GetNativeDashboardRequest, NativeDashboard> getNativeDashboardCallable() {
    return getNativeDashboardCallable;
  }

  @Override
  public UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsResponse>
      listNativeDashboardsCallable() {
    return listNativeDashboardsCallable;
  }

  @Override
  public UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsPagedResponse>
      listNativeDashboardsPagedCallable() {
    return listNativeDashboardsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateNativeDashboardRequest, NativeDashboard>
      updateNativeDashboardCallable() {
    return updateNativeDashboardCallable;
  }

  @Override
  public UnaryCallable<DuplicateNativeDashboardRequest, NativeDashboard>
      duplicateNativeDashboardCallable() {
    return duplicateNativeDashboardCallable;
  }

  @Override
  public UnaryCallable<DeleteNativeDashboardRequest, Empty> deleteNativeDashboardCallable() {
    return deleteNativeDashboardCallable;
  }

  @Override
  public UnaryCallable<AddChartRequest, AddChartResponse> addChartCallable() {
    return addChartCallable;
  }

  @Override
  public UnaryCallable<RemoveChartRequest, NativeDashboard> removeChartCallable() {
    return removeChartCallable;
  }

  @Override
  public UnaryCallable<EditChartRequest, EditChartResponse> editChartCallable() {
    return editChartCallable;
  }

  @Override
  public UnaryCallable<DuplicateChartRequest, DuplicateChartResponse> duplicateChartCallable() {
    return duplicateChartCallable;
  }

  @Override
  public UnaryCallable<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
      exportNativeDashboardsCallable() {
    return exportNativeDashboardsCallable;
  }

  @Override
  public UnaryCallable<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
      importNativeDashboardsCallable() {
    return importNativeDashboardsCallable;
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
