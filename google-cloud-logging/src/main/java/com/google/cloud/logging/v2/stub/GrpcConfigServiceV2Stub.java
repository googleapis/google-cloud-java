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

package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.ConfigClient.ListBucketsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListExclusionsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListLinksPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListSinksPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListViewsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.logging.v2.BucketMetadata;
import com.google.logging.v2.CmekSettings;
import com.google.logging.v2.CopyLogEntriesMetadata;
import com.google.logging.v2.CopyLogEntriesRequest;
import com.google.logging.v2.CopyLogEntriesResponse;
import com.google.logging.v2.CreateBucketRequest;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateLinkRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.CreateViewRequest;
import com.google.logging.v2.DeleteBucketRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteLinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.DeleteViewRequest;
import com.google.logging.v2.GetBucketRequest;
import com.google.logging.v2.GetCmekSettingsRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetLinkRequest;
import com.google.logging.v2.GetSettingsRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.GetViewRequest;
import com.google.logging.v2.Link;
import com.google.logging.v2.LinkMetadata;
import com.google.logging.v2.ListBucketsRequest;
import com.google.logging.v2.ListBucketsResponse;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListLinksRequest;
import com.google.logging.v2.ListLinksResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.ListViewsRequest;
import com.google.logging.v2.ListViewsResponse;
import com.google.logging.v2.LogBucket;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.LogView;
import com.google.logging.v2.Settings;
import com.google.logging.v2.UndeleteBucketRequest;
import com.google.logging.v2.UpdateBucketRequest;
import com.google.logging.v2.UpdateCmekSettingsRequest;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSettingsRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.UpdateViewRequest;
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
 * gRPC stub implementation for the ConfigServiceV2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcConfigServiceV2Stub extends ConfigServiceV2Stub {
  private static final MethodDescriptor<ListBucketsRequest, ListBucketsResponse>
      listBucketsMethodDescriptor =
          MethodDescriptor.<ListBucketsRequest, ListBucketsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/ListBuckets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBucketsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBucketsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBucketRequest, LogBucket> getBucketMethodDescriptor =
      MethodDescriptor.<GetBucketRequest, LogBucket>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/GetBucket")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBucketRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(LogBucket.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateBucketRequest, Operation>
      createBucketAsyncMethodDescriptor =
          MethodDescriptor.<CreateBucketRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/CreateBucketAsync")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateBucketRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateBucketRequest, Operation>
      updateBucketAsyncMethodDescriptor =
          MethodDescriptor.<UpdateBucketRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/UpdateBucketAsync")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateBucketRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateBucketRequest, LogBucket>
      createBucketMethodDescriptor =
          MethodDescriptor.<CreateBucketRequest, LogBucket>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/CreateBucket")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateBucketRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LogBucket.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateBucketRequest, LogBucket>
      updateBucketMethodDescriptor =
          MethodDescriptor.<UpdateBucketRequest, LogBucket>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/UpdateBucket")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateBucketRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LogBucket.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBucketRequest, Empty> deleteBucketMethodDescriptor =
      MethodDescriptor.<DeleteBucketRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/DeleteBucket")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteBucketRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UndeleteBucketRequest, Empty>
      undeleteBucketMethodDescriptor =
          MethodDescriptor.<UndeleteBucketRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/UndeleteBucket")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeleteBucketRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListViewsRequest, ListViewsResponse>
      listViewsMethodDescriptor =
          MethodDescriptor.<ListViewsRequest, ListViewsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/ListViews")
              .setRequestMarshaller(ProtoUtils.marshaller(ListViewsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListViewsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetViewRequest, LogView> getViewMethodDescriptor =
      MethodDescriptor.<GetViewRequest, LogView>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/GetView")
          .setRequestMarshaller(ProtoUtils.marshaller(GetViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(LogView.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateViewRequest, LogView> createViewMethodDescriptor =
      MethodDescriptor.<CreateViewRequest, LogView>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/CreateView")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(LogView.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateViewRequest, LogView> updateViewMethodDescriptor =
      MethodDescriptor.<UpdateViewRequest, LogView>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/UpdateView")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(LogView.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteViewRequest, Empty> deleteViewMethodDescriptor =
      MethodDescriptor.<DeleteViewRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/DeleteView")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListSinksRequest, ListSinksResponse>
      listSinksMethodDescriptor =
          MethodDescriptor.<ListSinksRequest, ListSinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/ListSinks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSinksRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSinkRequest, LogSink> getSinkMethodDescriptor =
      MethodDescriptor.<GetSinkRequest, LogSink>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/GetSink")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(LogSink.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSinkRequest, LogSink> createSinkMethodDescriptor =
      MethodDescriptor.<CreateSinkRequest, LogSink>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/CreateSink")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(LogSink.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSinkRequest, LogSink> updateSinkMethodDescriptor =
      MethodDescriptor.<UpdateSinkRequest, LogSink>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/UpdateSink")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(LogSink.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteSinkRequest, Empty> deleteSinkMethodDescriptor =
      MethodDescriptor.<DeleteSinkRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/DeleteSink")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateLinkRequest, Operation> createLinkMethodDescriptor =
      MethodDescriptor.<CreateLinkRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/CreateLink")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateLinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteLinkRequest, Operation> deleteLinkMethodDescriptor =
      MethodDescriptor.<DeleteLinkRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/DeleteLink")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteLinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListLinksRequest, ListLinksResponse>
      listLinksMethodDescriptor =
          MethodDescriptor.<ListLinksRequest, ListLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/ListLinks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListLinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLinkRequest, Link> getLinkMethodDescriptor =
      MethodDescriptor.<GetLinkRequest, Link>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/GetLink")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Link.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListExclusionsRequest, ListExclusionsResponse>
      listExclusionsMethodDescriptor =
          MethodDescriptor.<ListExclusionsRequest, ListExclusionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/ListExclusions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExclusionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExclusionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetExclusionRequest, LogExclusion>
      getExclusionMethodDescriptor =
          MethodDescriptor.<GetExclusionRequest, LogExclusion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/GetExclusion")
              .setRequestMarshaller(ProtoUtils.marshaller(GetExclusionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LogExclusion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateExclusionRequest, LogExclusion>
      createExclusionMethodDescriptor =
          MethodDescriptor.<CreateExclusionRequest, LogExclusion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/CreateExclusion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExclusionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LogExclusion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateExclusionRequest, LogExclusion>
      updateExclusionMethodDescriptor =
          MethodDescriptor.<UpdateExclusionRequest, LogExclusion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/UpdateExclusion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExclusionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LogExclusion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteExclusionRequest, Empty>
      deleteExclusionMethodDescriptor =
          MethodDescriptor.<DeleteExclusionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/DeleteExclusion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExclusionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCmekSettingsRequest, CmekSettings>
      getCmekSettingsMethodDescriptor =
          MethodDescriptor.<GetCmekSettingsRequest, CmekSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/GetCmekSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCmekSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CmekSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCmekSettingsRequest, CmekSettings>
      updateCmekSettingsMethodDescriptor =
          MethodDescriptor.<UpdateCmekSettingsRequest, CmekSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/UpdateCmekSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCmekSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CmekSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSettingsRequest, Settings> getSettingsMethodDescriptor =
      MethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/GetSettings")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSettingsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSettingsRequest, Settings>
      updateSettingsMethodDescriptor =
          MethodDescriptor.<UpdateSettingsRequest, Settings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/UpdateSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CopyLogEntriesRequest, Operation>
      copyLogEntriesMethodDescriptor =
          MethodDescriptor.<CopyLogEntriesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/CopyLogEntries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CopyLogEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable;
  private final UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse>
      listBucketsPagedCallable;
  private final UnaryCallable<GetBucketRequest, LogBucket> getBucketCallable;
  private final UnaryCallable<CreateBucketRequest, Operation> createBucketAsyncCallable;
  private final OperationCallable<CreateBucketRequest, LogBucket, BucketMetadata>
      createBucketAsyncOperationCallable;
  private final UnaryCallable<UpdateBucketRequest, Operation> updateBucketAsyncCallable;
  private final OperationCallable<UpdateBucketRequest, LogBucket, BucketMetadata>
      updateBucketAsyncOperationCallable;
  private final UnaryCallable<CreateBucketRequest, LogBucket> createBucketCallable;
  private final UnaryCallable<UpdateBucketRequest, LogBucket> updateBucketCallable;
  private final UnaryCallable<DeleteBucketRequest, Empty> deleteBucketCallable;
  private final UnaryCallable<UndeleteBucketRequest, Empty> undeleteBucketCallable;
  private final UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable;
  private final UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable;
  private final UnaryCallable<GetViewRequest, LogView> getViewCallable;
  private final UnaryCallable<CreateViewRequest, LogView> createViewCallable;
  private final UnaryCallable<UpdateViewRequest, LogView> updateViewCallable;
  private final UnaryCallable<DeleteViewRequest, Empty> deleteViewCallable;
  private final UnaryCallable<ListSinksRequest, ListSinksResponse> listSinksCallable;
  private final UnaryCallable<ListSinksRequest, ListSinksPagedResponse> listSinksPagedCallable;
  private final UnaryCallable<GetSinkRequest, LogSink> getSinkCallable;
  private final UnaryCallable<CreateSinkRequest, LogSink> createSinkCallable;
  private final UnaryCallable<UpdateSinkRequest, LogSink> updateSinkCallable;
  private final UnaryCallable<DeleteSinkRequest, Empty> deleteSinkCallable;
  private final UnaryCallable<CreateLinkRequest, Operation> createLinkCallable;
  private final OperationCallable<CreateLinkRequest, Link, LinkMetadata>
      createLinkOperationCallable;
  private final UnaryCallable<DeleteLinkRequest, Operation> deleteLinkCallable;
  private final OperationCallable<DeleteLinkRequest, Empty, LinkMetadata>
      deleteLinkOperationCallable;
  private final UnaryCallable<ListLinksRequest, ListLinksResponse> listLinksCallable;
  private final UnaryCallable<ListLinksRequest, ListLinksPagedResponse> listLinksPagedCallable;
  private final UnaryCallable<GetLinkRequest, Link> getLinkCallable;
  private final UnaryCallable<ListExclusionsRequest, ListExclusionsResponse> listExclusionsCallable;
  private final UnaryCallable<ListExclusionsRequest, ListExclusionsPagedResponse>
      listExclusionsPagedCallable;
  private final UnaryCallable<GetExclusionRequest, LogExclusion> getExclusionCallable;
  private final UnaryCallable<CreateExclusionRequest, LogExclusion> createExclusionCallable;
  private final UnaryCallable<UpdateExclusionRequest, LogExclusion> updateExclusionCallable;
  private final UnaryCallable<DeleteExclusionRequest, Empty> deleteExclusionCallable;
  private final UnaryCallable<GetCmekSettingsRequest, CmekSettings> getCmekSettingsCallable;
  private final UnaryCallable<UpdateCmekSettingsRequest, CmekSettings> updateCmekSettingsCallable;
  private final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable;
  private final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable;
  private final UnaryCallable<CopyLogEntriesRequest, Operation> copyLogEntriesCallable;
  private final OperationCallable<
          CopyLogEntriesRequest, CopyLogEntriesResponse, CopyLogEntriesMetadata>
      copyLogEntriesOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConfigServiceV2Stub create(ConfigServiceV2StubSettings settings)
      throws IOException {
    return new GrpcConfigServiceV2Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcConfigServiceV2Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConfigServiceV2Stub(
        ConfigServiceV2StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConfigServiceV2Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConfigServiceV2Stub(
        ConfigServiceV2StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConfigServiceV2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcConfigServiceV2Stub(
      ConfigServiceV2StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcConfigServiceV2CallableFactory());
  }

  /**
   * Constructs an instance of GrpcConfigServiceV2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcConfigServiceV2Stub(
      ConfigServiceV2StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListBucketsRequest, ListBucketsResponse> listBucketsTransportSettings =
        GrpcCallSettings.<ListBucketsRequest, ListBucketsResponse>newBuilder()
            .setMethodDescriptor(listBucketsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetBucketRequest, LogBucket> getBucketTransportSettings =
        GrpcCallSettings.<GetBucketRequest, LogBucket>newBuilder()
            .setMethodDescriptor(getBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBucketRequest, Operation> createBucketAsyncTransportSettings =
        GrpcCallSettings.<CreateBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(createBucketAsyncMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateBucketRequest, Operation> updateBucketAsyncTransportSettings =
        GrpcCallSettings.<UpdateBucketRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBucketAsyncMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBucketRequest, LogBucket> createBucketTransportSettings =
        GrpcCallSettings.<CreateBucketRequest, LogBucket>newBuilder()
            .setMethodDescriptor(createBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateBucketRequest, LogBucket> updateBucketTransportSettings =
        GrpcCallSettings.<UpdateBucketRequest, LogBucket>newBuilder()
            .setMethodDescriptor(updateBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBucketRequest, Empty> deleteBucketTransportSettings =
        GrpcCallSettings.<DeleteBucketRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UndeleteBucketRequest, Empty> undeleteBucketTransportSettings =
        GrpcCallSettings.<UndeleteBucketRequest, Empty>newBuilder()
            .setMethodDescriptor(undeleteBucketMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListViewsRequest, ListViewsResponse> listViewsTransportSettings =
        GrpcCallSettings.<ListViewsRequest, ListViewsResponse>newBuilder()
            .setMethodDescriptor(listViewsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetViewRequest, LogView> getViewTransportSettings =
        GrpcCallSettings.<GetViewRequest, LogView>newBuilder()
            .setMethodDescriptor(getViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateViewRequest, LogView> createViewTransportSettings =
        GrpcCallSettings.<CreateViewRequest, LogView>newBuilder()
            .setMethodDescriptor(createViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateViewRequest, LogView> updateViewTransportSettings =
        GrpcCallSettings.<UpdateViewRequest, LogView>newBuilder()
            .setMethodDescriptor(updateViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteViewRequest, Empty> deleteViewTransportSettings =
        GrpcCallSettings.<DeleteViewRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSinksRequest, ListSinksResponse> listSinksTransportSettings =
        GrpcCallSettings.<ListSinksRequest, ListSinksResponse>newBuilder()
            .setMethodDescriptor(listSinksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSinkRequest, LogSink> getSinkTransportSettings =
        GrpcCallSettings.<GetSinkRequest, LogSink>newBuilder()
            .setMethodDescriptor(getSinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("sink_name", String.valueOf(request.getSinkName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSinkRequest, LogSink> createSinkTransportSettings =
        GrpcCallSettings.<CreateSinkRequest, LogSink>newBuilder()
            .setMethodDescriptor(createSinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSinkRequest, LogSink> updateSinkTransportSettings =
        GrpcCallSettings.<UpdateSinkRequest, LogSink>newBuilder()
            .setMethodDescriptor(updateSinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("sink_name", String.valueOf(request.getSinkName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSinkRequest, Empty> deleteSinkTransportSettings =
        GrpcCallSettings.<DeleteSinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("sink_name", String.valueOf(request.getSinkName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateLinkRequest, Operation> createLinkTransportSettings =
        GrpcCallSettings.<CreateLinkRequest, Operation>newBuilder()
            .setMethodDescriptor(createLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteLinkRequest, Operation> deleteLinkTransportSettings =
        GrpcCallSettings.<DeleteLinkRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLinksRequest, ListLinksResponse> listLinksTransportSettings =
        GrpcCallSettings.<ListLinksRequest, ListLinksResponse>newBuilder()
            .setMethodDescriptor(listLinksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLinkRequest, Link> getLinkTransportSettings =
        GrpcCallSettings.<GetLinkRequest, Link>newBuilder()
            .setMethodDescriptor(getLinkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListExclusionsRequest, ListExclusionsResponse>
        listExclusionsTransportSettings =
            GrpcCallSettings.<ListExclusionsRequest, ListExclusionsResponse>newBuilder()
                .setMethodDescriptor(listExclusionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetExclusionRequest, LogExclusion> getExclusionTransportSettings =
        GrpcCallSettings.<GetExclusionRequest, LogExclusion>newBuilder()
            .setMethodDescriptor(getExclusionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateExclusionRequest, LogExclusion> createExclusionTransportSettings =
        GrpcCallSettings.<CreateExclusionRequest, LogExclusion>newBuilder()
            .setMethodDescriptor(createExclusionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateExclusionRequest, LogExclusion> updateExclusionTransportSettings =
        GrpcCallSettings.<UpdateExclusionRequest, LogExclusion>newBuilder()
            .setMethodDescriptor(updateExclusionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteExclusionRequest, Empty> deleteExclusionTransportSettings =
        GrpcCallSettings.<DeleteExclusionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteExclusionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetCmekSettingsRequest, CmekSettings> getCmekSettingsTransportSettings =
        GrpcCallSettings.<GetCmekSettingsRequest, CmekSettings>newBuilder()
            .setMethodDescriptor(getCmekSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateCmekSettingsRequest, CmekSettings> updateCmekSettingsTransportSettings =
        GrpcCallSettings.<UpdateCmekSettingsRequest, CmekSettings>newBuilder()
            .setMethodDescriptor(updateCmekSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        GrpcCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSettingsRequest, Settings> updateSettingsTransportSettings =
        GrpcCallSettings.<UpdateSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CopyLogEntriesRequest, Operation> copyLogEntriesTransportSettings =
        GrpcCallSettings.<CopyLogEntriesRequest, Operation>newBuilder()
            .setMethodDescriptor(copyLogEntriesMethodDescriptor)
            .build();

    this.listBucketsCallable =
        callableFactory.createUnaryCallable(
            listBucketsTransportSettings, settings.listBucketsSettings(), clientContext);
    this.listBucketsPagedCallable =
        callableFactory.createPagedCallable(
            listBucketsTransportSettings, settings.listBucketsSettings(), clientContext);
    this.getBucketCallable =
        callableFactory.createUnaryCallable(
            getBucketTransportSettings, settings.getBucketSettings(), clientContext);
    this.createBucketAsyncCallable =
        callableFactory.createUnaryCallable(
            createBucketAsyncTransportSettings,
            settings.createBucketAsyncSettings(),
            clientContext);
    this.createBucketAsyncOperationCallable =
        callableFactory.createOperationCallable(
            createBucketAsyncTransportSettings,
            settings.createBucketAsyncOperationSettings(),
            clientContext,
            operationsStub);
    this.updateBucketAsyncCallable =
        callableFactory.createUnaryCallable(
            updateBucketAsyncTransportSettings,
            settings.updateBucketAsyncSettings(),
            clientContext);
    this.updateBucketAsyncOperationCallable =
        callableFactory.createOperationCallable(
            updateBucketAsyncTransportSettings,
            settings.updateBucketAsyncOperationSettings(),
            clientContext,
            operationsStub);
    this.createBucketCallable =
        callableFactory.createUnaryCallable(
            createBucketTransportSettings, settings.createBucketSettings(), clientContext);
    this.updateBucketCallable =
        callableFactory.createUnaryCallable(
            updateBucketTransportSettings, settings.updateBucketSettings(), clientContext);
    this.deleteBucketCallable =
        callableFactory.createUnaryCallable(
            deleteBucketTransportSettings, settings.deleteBucketSettings(), clientContext);
    this.undeleteBucketCallable =
        callableFactory.createUnaryCallable(
            undeleteBucketTransportSettings, settings.undeleteBucketSettings(), clientContext);
    this.listViewsCallable =
        callableFactory.createUnaryCallable(
            listViewsTransportSettings, settings.listViewsSettings(), clientContext);
    this.listViewsPagedCallable =
        callableFactory.createPagedCallable(
            listViewsTransportSettings, settings.listViewsSettings(), clientContext);
    this.getViewCallable =
        callableFactory.createUnaryCallable(
            getViewTransportSettings, settings.getViewSettings(), clientContext);
    this.createViewCallable =
        callableFactory.createUnaryCallable(
            createViewTransportSettings, settings.createViewSettings(), clientContext);
    this.updateViewCallable =
        callableFactory.createUnaryCallable(
            updateViewTransportSettings, settings.updateViewSettings(), clientContext);
    this.deleteViewCallable =
        callableFactory.createUnaryCallable(
            deleteViewTransportSettings, settings.deleteViewSettings(), clientContext);
    this.listSinksCallable =
        callableFactory.createUnaryCallable(
            listSinksTransportSettings, settings.listSinksSettings(), clientContext);
    this.listSinksPagedCallable =
        callableFactory.createPagedCallable(
            listSinksTransportSettings, settings.listSinksSettings(), clientContext);
    this.getSinkCallable =
        callableFactory.createUnaryCallable(
            getSinkTransportSettings, settings.getSinkSettings(), clientContext);
    this.createSinkCallable =
        callableFactory.createUnaryCallable(
            createSinkTransportSettings, settings.createSinkSettings(), clientContext);
    this.updateSinkCallable =
        callableFactory.createUnaryCallable(
            updateSinkTransportSettings, settings.updateSinkSettings(), clientContext);
    this.deleteSinkCallable =
        callableFactory.createUnaryCallable(
            deleteSinkTransportSettings, settings.deleteSinkSettings(), clientContext);
    this.createLinkCallable =
        callableFactory.createUnaryCallable(
            createLinkTransportSettings, settings.createLinkSettings(), clientContext);
    this.createLinkOperationCallable =
        callableFactory.createOperationCallable(
            createLinkTransportSettings,
            settings.createLinkOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteLinkCallable =
        callableFactory.createUnaryCallable(
            deleteLinkTransportSettings, settings.deleteLinkSettings(), clientContext);
    this.deleteLinkOperationCallable =
        callableFactory.createOperationCallable(
            deleteLinkTransportSettings,
            settings.deleteLinkOperationSettings(),
            clientContext,
            operationsStub);
    this.listLinksCallable =
        callableFactory.createUnaryCallable(
            listLinksTransportSettings, settings.listLinksSettings(), clientContext);
    this.listLinksPagedCallable =
        callableFactory.createPagedCallable(
            listLinksTransportSettings, settings.listLinksSettings(), clientContext);
    this.getLinkCallable =
        callableFactory.createUnaryCallable(
            getLinkTransportSettings, settings.getLinkSettings(), clientContext);
    this.listExclusionsCallable =
        callableFactory.createUnaryCallable(
            listExclusionsTransportSettings, settings.listExclusionsSettings(), clientContext);
    this.listExclusionsPagedCallable =
        callableFactory.createPagedCallable(
            listExclusionsTransportSettings, settings.listExclusionsSettings(), clientContext);
    this.getExclusionCallable =
        callableFactory.createUnaryCallable(
            getExclusionTransportSettings, settings.getExclusionSettings(), clientContext);
    this.createExclusionCallable =
        callableFactory.createUnaryCallable(
            createExclusionTransportSettings, settings.createExclusionSettings(), clientContext);
    this.updateExclusionCallable =
        callableFactory.createUnaryCallable(
            updateExclusionTransportSettings, settings.updateExclusionSettings(), clientContext);
    this.deleteExclusionCallable =
        callableFactory.createUnaryCallable(
            deleteExclusionTransportSettings, settings.deleteExclusionSettings(), clientContext);
    this.getCmekSettingsCallable =
        callableFactory.createUnaryCallable(
            getCmekSettingsTransportSettings, settings.getCmekSettingsSettings(), clientContext);
    this.updateCmekSettingsCallable =
        callableFactory.createUnaryCallable(
            updateCmekSettingsTransportSettings,
            settings.updateCmekSettingsSettings(),
            clientContext);
    this.getSettingsCallable =
        callableFactory.createUnaryCallable(
            getSettingsTransportSettings, settings.getSettingsSettings(), clientContext);
    this.updateSettingsCallable =
        callableFactory.createUnaryCallable(
            updateSettingsTransportSettings, settings.updateSettingsSettings(), clientContext);
    this.copyLogEntriesCallable =
        callableFactory.createUnaryCallable(
            copyLogEntriesTransportSettings, settings.copyLogEntriesSettings(), clientContext);
    this.copyLogEntriesOperationCallable =
        callableFactory.createOperationCallable(
            copyLogEntriesTransportSettings,
            settings.copyLogEntriesOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable() {
    return listBucketsCallable;
  }

  @Override
  public UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse> listBucketsPagedCallable() {
    return listBucketsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBucketRequest, LogBucket> getBucketCallable() {
    return getBucketCallable;
  }

  @Override
  public UnaryCallable<CreateBucketRequest, Operation> createBucketAsyncCallable() {
    return createBucketAsyncCallable;
  }

  @Override
  public OperationCallable<CreateBucketRequest, LogBucket, BucketMetadata>
      createBucketAsyncOperationCallable() {
    return createBucketAsyncOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateBucketRequest, Operation> updateBucketAsyncCallable() {
    return updateBucketAsyncCallable;
  }

  @Override
  public OperationCallable<UpdateBucketRequest, LogBucket, BucketMetadata>
      updateBucketAsyncOperationCallable() {
    return updateBucketAsyncOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBucketRequest, LogBucket> createBucketCallable() {
    return createBucketCallable;
  }

  @Override
  public UnaryCallable<UpdateBucketRequest, LogBucket> updateBucketCallable() {
    return updateBucketCallable;
  }

  @Override
  public UnaryCallable<DeleteBucketRequest, Empty> deleteBucketCallable() {
    return deleteBucketCallable;
  }

  @Override
  public UnaryCallable<UndeleteBucketRequest, Empty> undeleteBucketCallable() {
    return undeleteBucketCallable;
  }

  @Override
  public UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable() {
    return listViewsCallable;
  }

  @Override
  public UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable() {
    return listViewsPagedCallable;
  }

  @Override
  public UnaryCallable<GetViewRequest, LogView> getViewCallable() {
    return getViewCallable;
  }

  @Override
  public UnaryCallable<CreateViewRequest, LogView> createViewCallable() {
    return createViewCallable;
  }

  @Override
  public UnaryCallable<UpdateViewRequest, LogView> updateViewCallable() {
    return updateViewCallable;
  }

  @Override
  public UnaryCallable<DeleteViewRequest, Empty> deleteViewCallable() {
    return deleteViewCallable;
  }

  @Override
  public UnaryCallable<ListSinksRequest, ListSinksResponse> listSinksCallable() {
    return listSinksCallable;
  }

  @Override
  public UnaryCallable<ListSinksRequest, ListSinksPagedResponse> listSinksPagedCallable() {
    return listSinksPagedCallable;
  }

  @Override
  public UnaryCallable<GetSinkRequest, LogSink> getSinkCallable() {
    return getSinkCallable;
  }

  @Override
  public UnaryCallable<CreateSinkRequest, LogSink> createSinkCallable() {
    return createSinkCallable;
  }

  @Override
  public UnaryCallable<UpdateSinkRequest, LogSink> updateSinkCallable() {
    return updateSinkCallable;
  }

  @Override
  public UnaryCallable<DeleteSinkRequest, Empty> deleteSinkCallable() {
    return deleteSinkCallable;
  }

  @Override
  public UnaryCallable<CreateLinkRequest, Operation> createLinkCallable() {
    return createLinkCallable;
  }

  @Override
  public OperationCallable<CreateLinkRequest, Link, LinkMetadata> createLinkOperationCallable() {
    return createLinkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteLinkRequest, Operation> deleteLinkCallable() {
    return deleteLinkCallable;
  }

  @Override
  public OperationCallable<DeleteLinkRequest, Empty, LinkMetadata> deleteLinkOperationCallable() {
    return deleteLinkOperationCallable;
  }

  @Override
  public UnaryCallable<ListLinksRequest, ListLinksResponse> listLinksCallable() {
    return listLinksCallable;
  }

  @Override
  public UnaryCallable<ListLinksRequest, ListLinksPagedResponse> listLinksPagedCallable() {
    return listLinksPagedCallable;
  }

  @Override
  public UnaryCallable<GetLinkRequest, Link> getLinkCallable() {
    return getLinkCallable;
  }

  @Override
  public UnaryCallable<ListExclusionsRequest, ListExclusionsResponse> listExclusionsCallable() {
    return listExclusionsCallable;
  }

  @Override
  public UnaryCallable<ListExclusionsRequest, ListExclusionsPagedResponse>
      listExclusionsPagedCallable() {
    return listExclusionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetExclusionRequest, LogExclusion> getExclusionCallable() {
    return getExclusionCallable;
  }

  @Override
  public UnaryCallable<CreateExclusionRequest, LogExclusion> createExclusionCallable() {
    return createExclusionCallable;
  }

  @Override
  public UnaryCallable<UpdateExclusionRequest, LogExclusion> updateExclusionCallable() {
    return updateExclusionCallable;
  }

  @Override
  public UnaryCallable<DeleteExclusionRequest, Empty> deleteExclusionCallable() {
    return deleteExclusionCallable;
  }

  @Override
  public UnaryCallable<GetCmekSettingsRequest, CmekSettings> getCmekSettingsCallable() {
    return getCmekSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateCmekSettingsRequest, CmekSettings> updateCmekSettingsCallable() {
    return updateCmekSettingsCallable;
  }

  @Override
  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return getSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    return updateSettingsCallable;
  }

  @Override
  public UnaryCallable<CopyLogEntriesRequest, Operation> copyLogEntriesCallable() {
    return copyLogEntriesCallable;
  }

  @Override
  public OperationCallable<CopyLogEntriesRequest, CopyLogEntriesResponse, CopyLogEntriesMetadata>
      copyLogEntriesOperationCallable() {
    return copyLogEntriesOperationCallable;
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
