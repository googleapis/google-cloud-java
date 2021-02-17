/*
 * Copyright 2020 Google LLC
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
import static com.google.cloud.logging.v2.ConfigClient.ListSinksPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListViewsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.logging.v2.CmekSettings;
import com.google.logging.v2.CreateBucketRequest;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.CreateViewRequest;
import com.google.logging.v2.DeleteBucketRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.DeleteViewRequest;
import com.google.logging.v2.GetBucketRequest;
import com.google.logging.v2.GetCmekSettingsRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.GetViewRequest;
import com.google.logging.v2.ListBucketsRequest;
import com.google.logging.v2.ListBucketsResponse;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.ListViewsRequest;
import com.google.logging.v2.ListViewsResponse;
import com.google.logging.v2.LogBucket;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.LogView;
import com.google.logging.v2.UndeleteBucketRequest;
import com.google.logging.v2.UpdateBucketRequest;
import com.google.logging.v2.UpdateCmekSettingsRequest;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.UpdateViewRequest;
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

  private final UnaryCallable<ListBucketsRequest, ListBucketsResponse> listBucketsCallable;
  private final UnaryCallable<ListBucketsRequest, ListBucketsPagedResponse>
      listBucketsPagedCallable;
  private final UnaryCallable<GetBucketRequest, LogBucket> getBucketCallable;
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
  private final UnaryCallable<ListExclusionsRequest, ListExclusionsResponse> listExclusionsCallable;
  private final UnaryCallable<ListExclusionsRequest, ListExclusionsPagedResponse>
      listExclusionsPagedCallable;
  private final UnaryCallable<GetExclusionRequest, LogExclusion> getExclusionCallable;
  private final UnaryCallable<CreateExclusionRequest, LogExclusion> createExclusionCallable;
  private final UnaryCallable<UpdateExclusionRequest, LogExclusion> updateExclusionCallable;
  private final UnaryCallable<DeleteExclusionRequest, Empty> deleteExclusionCallable;
  private final UnaryCallable<GetCmekSettingsRequest, CmekSettings> getCmekSettingsCallable;
  private final UnaryCallable<UpdateCmekSettingsRequest, CmekSettings> updateCmekSettingsCallable;

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
                new RequestParamsExtractor<ListBucketsRequest>() {
                  @Override
                  public Map<String, String> extract(ListBucketsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetBucketRequest, LogBucket> getBucketTransportSettings =
        GrpcCallSettings.<GetBucketRequest, LogBucket>newBuilder()
            .setMethodDescriptor(getBucketMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetBucketRequest>() {
                  @Override
                  public Map<String, String> extract(GetBucketRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateBucketRequest, LogBucket> createBucketTransportSettings =
        GrpcCallSettings.<CreateBucketRequest, LogBucket>newBuilder()
            .setMethodDescriptor(createBucketMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateBucketRequest>() {
                  @Override
                  public Map<String, String> extract(CreateBucketRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateBucketRequest, LogBucket> updateBucketTransportSettings =
        GrpcCallSettings.<UpdateBucketRequest, LogBucket>newBuilder()
            .setMethodDescriptor(updateBucketMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateBucketRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateBucketRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteBucketRequest, Empty> deleteBucketTransportSettings =
        GrpcCallSettings.<DeleteBucketRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBucketMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteBucketRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteBucketRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UndeleteBucketRequest, Empty> undeleteBucketTransportSettings =
        GrpcCallSettings.<UndeleteBucketRequest, Empty>newBuilder()
            .setMethodDescriptor(undeleteBucketMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UndeleteBucketRequest>() {
                  @Override
                  public Map<String, String> extract(UndeleteBucketRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListViewsRequest, ListViewsResponse> listViewsTransportSettings =
        GrpcCallSettings.<ListViewsRequest, ListViewsResponse>newBuilder()
            .setMethodDescriptor(listViewsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListViewsRequest>() {
                  @Override
                  public Map<String, String> extract(ListViewsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetViewRequest, LogView> getViewTransportSettings =
        GrpcCallSettings.<GetViewRequest, LogView>newBuilder()
            .setMethodDescriptor(getViewMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetViewRequest>() {
                  @Override
                  public Map<String, String> extract(GetViewRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateViewRequest, LogView> createViewTransportSettings =
        GrpcCallSettings.<CreateViewRequest, LogView>newBuilder()
            .setMethodDescriptor(createViewMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateViewRequest>() {
                  @Override
                  public Map<String, String> extract(CreateViewRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateViewRequest, LogView> updateViewTransportSettings =
        GrpcCallSettings.<UpdateViewRequest, LogView>newBuilder()
            .setMethodDescriptor(updateViewMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateViewRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateViewRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteViewRequest, Empty> deleteViewTransportSettings =
        GrpcCallSettings.<DeleteViewRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteViewMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteViewRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteViewRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListSinksRequest, ListSinksResponse> listSinksTransportSettings =
        GrpcCallSettings.<ListSinksRequest, ListSinksResponse>newBuilder()
            .setMethodDescriptor(listSinksMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListSinksRequest>() {
                  @Override
                  public Map<String, String> extract(ListSinksRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetSinkRequest, LogSink> getSinkTransportSettings =
        GrpcCallSettings.<GetSinkRequest, LogSink>newBuilder()
            .setMethodDescriptor(getSinkMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetSinkRequest>() {
                  @Override
                  public Map<String, String> extract(GetSinkRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("sink_name", String.valueOf(request.getSinkName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateSinkRequest, LogSink> createSinkTransportSettings =
        GrpcCallSettings.<CreateSinkRequest, LogSink>newBuilder()
            .setMethodDescriptor(createSinkMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateSinkRequest>() {
                  @Override
                  public Map<String, String> extract(CreateSinkRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateSinkRequest, LogSink> updateSinkTransportSettings =
        GrpcCallSettings.<UpdateSinkRequest, LogSink>newBuilder()
            .setMethodDescriptor(updateSinkMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateSinkRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateSinkRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("sink_name", String.valueOf(request.getSinkName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteSinkRequest, Empty> deleteSinkTransportSettings =
        GrpcCallSettings.<DeleteSinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSinkMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteSinkRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteSinkRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("sink_name", String.valueOf(request.getSinkName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListExclusionsRequest, ListExclusionsResponse>
        listExclusionsTransportSettings =
            GrpcCallSettings.<ListExclusionsRequest, ListExclusionsResponse>newBuilder()
                .setMethodDescriptor(listExclusionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListExclusionsRequest>() {
                      @Override
                      public Map<String, String> extract(ListExclusionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetExclusionRequest, LogExclusion> getExclusionTransportSettings =
        GrpcCallSettings.<GetExclusionRequest, LogExclusion>newBuilder()
            .setMethodDescriptor(getExclusionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetExclusionRequest>() {
                  @Override
                  public Map<String, String> extract(GetExclusionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateExclusionRequest, LogExclusion> createExclusionTransportSettings =
        GrpcCallSettings.<CreateExclusionRequest, LogExclusion>newBuilder()
            .setMethodDescriptor(createExclusionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateExclusionRequest>() {
                  @Override
                  public Map<String, String> extract(CreateExclusionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateExclusionRequest, LogExclusion> updateExclusionTransportSettings =
        GrpcCallSettings.<UpdateExclusionRequest, LogExclusion>newBuilder()
            .setMethodDescriptor(updateExclusionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateExclusionRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateExclusionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteExclusionRequest, Empty> deleteExclusionTransportSettings =
        GrpcCallSettings.<DeleteExclusionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteExclusionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteExclusionRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteExclusionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetCmekSettingsRequest, CmekSettings> getCmekSettingsTransportSettings =
        GrpcCallSettings.<GetCmekSettingsRequest, CmekSettings>newBuilder()
            .setMethodDescriptor(getCmekSettingsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetCmekSettingsRequest>() {
                  @Override
                  public Map<String, String> extract(GetCmekSettingsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateCmekSettingsRequest, CmekSettings> updateCmekSettingsTransportSettings =
        GrpcCallSettings.<UpdateCmekSettingsRequest, CmekSettings>newBuilder()
            .setMethodDescriptor(updateCmekSettingsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateCmekSettingsRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateCmekSettingsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
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
