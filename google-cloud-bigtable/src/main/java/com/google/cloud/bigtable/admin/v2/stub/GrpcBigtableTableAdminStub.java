/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2.stub;

import static com.google.cloud.bigtable.admin.v2.PagedResponseWrappers.ListTablesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ListTablesResponse;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Cloud Bigtable Admin API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcBigtableTableAdminStub extends BigtableTableAdminStub {
  private static final UnaryCallable<CreateTableRequest, Table> directCreateTableCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.bigtable.admin.v2.BigtableTableAdmin/CreateTable",
              io.grpc.protobuf.ProtoUtils.marshaller(CreateTableRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Table.getDefaultInstance())));
  private static final UnaryCallable<ListTablesRequest, ListTablesResponse>
      directListTablesCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.bigtable.admin.v2.BigtableTableAdmin/ListTables",
                  io.grpc.protobuf.ProtoUtils.marshaller(ListTablesRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(ListTablesResponse.getDefaultInstance())));
  private static final UnaryCallable<GetTableRequest, Table> directGetTableCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.bigtable.admin.v2.BigtableTableAdmin/GetTable",
              io.grpc.protobuf.ProtoUtils.marshaller(GetTableRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Table.getDefaultInstance())));
  private static final UnaryCallable<DeleteTableRequest, Empty> directDeleteTableCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.bigtable.admin.v2.BigtableTableAdmin/DeleteTable",
              io.grpc.protobuf.ProtoUtils.marshaller(DeleteTableRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final UnaryCallable<ModifyColumnFamiliesRequest, Table>
      directModifyColumnFamiliesCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.bigtable.admin.v2.BigtableTableAdmin/ModifyColumnFamilies",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ModifyColumnFamiliesRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(Table.getDefaultInstance())));
  private static final UnaryCallable<DropRowRangeRequest, Empty> directDropRowRangeCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.bigtable.admin.v2.BigtableTableAdmin/DropRowRange",
              io.grpc.protobuf.ProtoUtils.marshaller(DropRowRangeRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<CreateTableRequest, Table> createTableCallable;
  private final UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable;
  private final UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable;
  private final UnaryCallable<GetTableRequest, Table> getTableCallable;
  private final UnaryCallable<DeleteTableRequest, Empty> deleteTableCallable;
  private final UnaryCallable<ModifyColumnFamiliesRequest, Table> modifyColumnFamiliesCallable;
  private final UnaryCallable<DropRowRangeRequest, Empty> dropRowRangeCallable;

  public static final GrpcBigtableTableAdminStub create(BigtableTableAdminSettings settings)
      throws IOException {
    return new GrpcBigtableTableAdminStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBigtableTableAdminStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBigtableTableAdminStub(
        BigtableTableAdminSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcBigtableTableAdminStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBigtableTableAdminStub(
      BigtableTableAdminSettings settings, ClientContext clientContext) throws IOException {

    this.createTableCallable =
        GrpcCallableFactory.create(
            directCreateTableCallable, settings.createTableSettings(), clientContext);
    this.listTablesCallable =
        GrpcCallableFactory.create(
            directListTablesCallable, settings.listTablesSettings(), clientContext);
    this.listTablesPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListTablesCallable, settings.listTablesSettings(), clientContext);
    this.getTableCallable =
        GrpcCallableFactory.create(
            directGetTableCallable, settings.getTableSettings(), clientContext);
    this.deleteTableCallable =
        GrpcCallableFactory.create(
            directDeleteTableCallable, settings.deleteTableSettings(), clientContext);
    this.modifyColumnFamiliesCallable =
        GrpcCallableFactory.create(
            directModifyColumnFamiliesCallable,
            settings.modifyColumnFamiliesSettings(),
            clientContext);
    this.dropRowRangeCallable =
        GrpcCallableFactory.create(
            directDropRowRangeCallable, settings.dropRowRangeSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<CreateTableRequest, Table> createTableCallable() {
    return createTableCallable;
  }

  public UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable() {
    return listTablesPagedCallable;
  }

  public UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable() {
    return listTablesCallable;
  }

  public UnaryCallable<GetTableRequest, Table> getTableCallable() {
    return getTableCallable;
  }

  public UnaryCallable<DeleteTableRequest, Empty> deleteTableCallable() {
    return deleteTableCallable;
  }

  public UnaryCallable<ModifyColumnFamiliesRequest, Table> modifyColumnFamiliesCallable() {
    return modifyColumnFamiliesCallable;
  }

  public UnaryCallable<DropRowRangeRequest, Empty> dropRowRangeCallable() {
    return dropRowRangeCallable;
  }

  @Override
  public final void close() throws Exception {
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
