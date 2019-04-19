/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.firestore.v1.stub;

import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListFieldsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListIndexesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.firestore.admin.v1.CreateIndexRequest;
import com.google.firestore.admin.v1.DeleteIndexRequest;
import com.google.firestore.admin.v1.ExportDocumentsRequest;
import com.google.firestore.admin.v1.Field;
import com.google.firestore.admin.v1.GetFieldRequest;
import com.google.firestore.admin.v1.GetIndexRequest;
import com.google.firestore.admin.v1.ImportDocumentsRequest;
import com.google.firestore.admin.v1.Index;
import com.google.firestore.admin.v1.ListFieldsRequest;
import com.google.firestore.admin.v1.ListFieldsResponse;
import com.google.firestore.admin.v1.ListIndexesRequest;
import com.google.firestore.admin.v1.ListIndexesResponse;
import com.google.firestore.admin.v1.UpdateFieldRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Google Cloud Firestore Admin API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcFirestoreAdminStub extends FirestoreAdminStub {

  private static final MethodDescriptor<CreateIndexRequest, Operation> createIndexMethodDescriptor =
      MethodDescriptor.<CreateIndexRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/CreateIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListIndexesRequest, ListIndexesResponse>
      listIndexesMethodDescriptor =
          MethodDescriptor.<ListIndexesRequest, ListIndexesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListIndexes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListIndexesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIndexesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetIndexRequest, Index> getIndexMethodDescriptor =
      MethodDescriptor.<GetIndexRequest, Index>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Index.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<DeleteIndexRequest, Empty> deleteIndexMethodDescriptor =
      MethodDescriptor.<DeleteIndexRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DeleteIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ImportDocumentsRequest, Operation>
      importDocumentsMethodDescriptor =
          MethodDescriptor.<ImportDocumentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ImportDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ExportDocumentsRequest, Operation>
      exportDocumentsMethodDescriptor =
          MethodDescriptor.<ExportDocumentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ExportDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetFieldRequest, Field> getFieldMethodDescriptor =
      MethodDescriptor.<GetFieldRequest, Field>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetField")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFieldRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Field.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListFieldsRequest, ListFieldsResponse>
      listFieldsMethodDescriptor =
          MethodDescriptor.<ListFieldsRequest, ListFieldsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListFields")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFieldsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListFieldsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateFieldRequest, Operation> updateFieldMethodDescriptor =
      MethodDescriptor.<UpdateFieldRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/UpdateField")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateFieldRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<CreateIndexRequest, Operation> createIndexCallable;
  private final UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable;
  private final UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse>
      listIndexesPagedCallable;
  private final UnaryCallable<GetIndexRequest, Index> getIndexCallable;
  private final UnaryCallable<DeleteIndexRequest, Empty> deleteIndexCallable;
  private final UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable;
  private final UnaryCallable<ExportDocumentsRequest, Operation> exportDocumentsCallable;
  private final UnaryCallable<GetFieldRequest, Field> getFieldCallable;
  private final UnaryCallable<ListFieldsRequest, ListFieldsResponse> listFieldsCallable;
  private final UnaryCallable<ListFieldsRequest, ListFieldsPagedResponse> listFieldsPagedCallable;
  private final UnaryCallable<UpdateFieldRequest, Operation> updateFieldCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcFirestoreAdminStub create(FirestoreAdminStubSettings settings)
      throws IOException {
    return new GrpcFirestoreAdminStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFirestoreAdminStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcFirestoreAdminStub(
        FirestoreAdminStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFirestoreAdminStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFirestoreAdminStub(
        FirestoreAdminStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFirestoreAdminStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFirestoreAdminStub(FirestoreAdminStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFirestoreAdminCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFirestoreAdminStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFirestoreAdminStub(
      FirestoreAdminStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<CreateIndexRequest, Operation> createIndexTransportSettings =
        GrpcCallSettings.<CreateIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(createIndexMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateIndexRequest>() {
                  @Override
                  public Map<String, String> extract(CreateIndexRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListIndexesRequest, ListIndexesResponse> listIndexesTransportSettings =
        GrpcCallSettings.<ListIndexesRequest, ListIndexesResponse>newBuilder()
            .setMethodDescriptor(listIndexesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListIndexesRequest>() {
                  @Override
                  public Map<String, String> extract(ListIndexesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetIndexRequest, Index> getIndexTransportSettings =
        GrpcCallSettings.<GetIndexRequest, Index>newBuilder()
            .setMethodDescriptor(getIndexMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetIndexRequest>() {
                  @Override
                  public Map<String, String> extract(GetIndexRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteIndexRequest, Empty> deleteIndexTransportSettings =
        GrpcCallSettings.<DeleteIndexRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteIndexMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteIndexRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteIndexRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ImportDocumentsRequest, Operation> importDocumentsTransportSettings =
        GrpcCallSettings.<ImportDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(importDocumentsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ImportDocumentsRequest>() {
                  @Override
                  public Map<String, String> extract(ImportDocumentsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ExportDocumentsRequest, Operation> exportDocumentsTransportSettings =
        GrpcCallSettings.<ExportDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDocumentsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ExportDocumentsRequest>() {
                  @Override
                  public Map<String, String> extract(ExportDocumentsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetFieldRequest, Field> getFieldTransportSettings =
        GrpcCallSettings.<GetFieldRequest, Field>newBuilder()
            .setMethodDescriptor(getFieldMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetFieldRequest>() {
                  @Override
                  public Map<String, String> extract(GetFieldRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListFieldsRequest, ListFieldsResponse> listFieldsTransportSettings =
        GrpcCallSettings.<ListFieldsRequest, ListFieldsResponse>newBuilder()
            .setMethodDescriptor(listFieldsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListFieldsRequest>() {
                  @Override
                  public Map<String, String> extract(ListFieldsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateFieldRequest, Operation> updateFieldTransportSettings =
        GrpcCallSettings.<UpdateFieldRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFieldMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateFieldRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateFieldRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("field.name", String.valueOf(request.getField().getName()));
                    return params.build();
                  }
                })
            .build();

    this.createIndexCallable =
        callableFactory.createUnaryCallable(
            createIndexTransportSettings, settings.createIndexSettings(), clientContext);
    this.listIndexesCallable =
        callableFactory.createUnaryCallable(
            listIndexesTransportSettings, settings.listIndexesSettings(), clientContext);
    this.listIndexesPagedCallable =
        callableFactory.createPagedCallable(
            listIndexesTransportSettings, settings.listIndexesSettings(), clientContext);
    this.getIndexCallable =
        callableFactory.createUnaryCallable(
            getIndexTransportSettings, settings.getIndexSettings(), clientContext);
    this.deleteIndexCallable =
        callableFactory.createUnaryCallable(
            deleteIndexTransportSettings, settings.deleteIndexSettings(), clientContext);
    this.importDocumentsCallable =
        callableFactory.createUnaryCallable(
            importDocumentsTransportSettings, settings.importDocumentsSettings(), clientContext);
    this.exportDocumentsCallable =
        callableFactory.createUnaryCallable(
            exportDocumentsTransportSettings, settings.exportDocumentsSettings(), clientContext);
    this.getFieldCallable =
        callableFactory.createUnaryCallable(
            getFieldTransportSettings, settings.getFieldSettings(), clientContext);
    this.listFieldsCallable =
        callableFactory.createUnaryCallable(
            listFieldsTransportSettings, settings.listFieldsSettings(), clientContext);
    this.listFieldsPagedCallable =
        callableFactory.createPagedCallable(
            listFieldsTransportSettings, settings.listFieldsSettings(), clientContext);
    this.updateFieldCallable =
        callableFactory.createUnaryCallable(
            updateFieldTransportSettings, settings.updateFieldSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    return createIndexCallable;
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse> listIndexesPagedCallable() {
    return listIndexesPagedCallable;
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    return listIndexesCallable;
  }

  public UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    return getIndexCallable;
  }

  public UnaryCallable<DeleteIndexRequest, Empty> deleteIndexCallable() {
    return deleteIndexCallable;
  }

  public UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    return importDocumentsCallable;
  }

  public UnaryCallable<ExportDocumentsRequest, Operation> exportDocumentsCallable() {
    return exportDocumentsCallable;
  }

  public UnaryCallable<GetFieldRequest, Field> getFieldCallable() {
    return getFieldCallable;
  }

  public UnaryCallable<ListFieldsRequest, ListFieldsPagedResponse> listFieldsPagedCallable() {
    return listFieldsPagedCallable;
  }

  public UnaryCallable<ListFieldsRequest, ListFieldsResponse> listFieldsCallable() {
    return listFieldsCallable;
  }

  public UnaryCallable<UpdateFieldRequest, Operation> updateFieldCallable() {
    return updateFieldCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
