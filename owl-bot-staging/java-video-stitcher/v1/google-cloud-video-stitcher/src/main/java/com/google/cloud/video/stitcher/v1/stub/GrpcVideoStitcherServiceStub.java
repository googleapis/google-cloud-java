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

package com.google.cloud.video.stitcher.v1.stub;

import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListCdnKeysPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListLiveAdTagDetailsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListLiveConfigsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListSlatesPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodAdTagDetailsPagedResponse;
import static com.google.cloud.video.stitcher.v1.VideoStitcherServiceClient.ListVodStitchDetailsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.video.stitcher.v1.CdnKey;
import com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest;
import com.google.cloud.video.stitcher.v1.CreateLiveConfigRequest;
import com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest;
import com.google.cloud.video.stitcher.v1.CreateSlateRequest;
import com.google.cloud.video.stitcher.v1.CreateVodSessionRequest;
import com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest;
import com.google.cloud.video.stitcher.v1.DeleteLiveConfigRequest;
import com.google.cloud.video.stitcher.v1.DeleteSlateRequest;
import com.google.cloud.video.stitcher.v1.GetCdnKeyRequest;
import com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest;
import com.google.cloud.video.stitcher.v1.GetLiveConfigRequest;
import com.google.cloud.video.stitcher.v1.GetLiveSessionRequest;
import com.google.cloud.video.stitcher.v1.GetSlateRequest;
import com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest;
import com.google.cloud.video.stitcher.v1.GetVodSessionRequest;
import com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest;
import com.google.cloud.video.stitcher.v1.ListCdnKeysRequest;
import com.google.cloud.video.stitcher.v1.ListCdnKeysResponse;
import com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest;
import com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse;
import com.google.cloud.video.stitcher.v1.ListLiveConfigsRequest;
import com.google.cloud.video.stitcher.v1.ListLiveConfigsResponse;
import com.google.cloud.video.stitcher.v1.ListSlatesRequest;
import com.google.cloud.video.stitcher.v1.ListSlatesResponse;
import com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest;
import com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse;
import com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest;
import com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse;
import com.google.cloud.video.stitcher.v1.LiveAdTagDetail;
import com.google.cloud.video.stitcher.v1.LiveConfig;
import com.google.cloud.video.stitcher.v1.LiveSession;
import com.google.cloud.video.stitcher.v1.OperationMetadata;
import com.google.cloud.video.stitcher.v1.Slate;
import com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest;
import com.google.cloud.video.stitcher.v1.UpdateSlateRequest;
import com.google.cloud.video.stitcher.v1.VodAdTagDetail;
import com.google.cloud.video.stitcher.v1.VodSession;
import com.google.cloud.video.stitcher.v1.VodStitchDetail;
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
 * gRPC stub implementation for the VideoStitcherService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcVideoStitcherServiceStub extends VideoStitcherServiceStub {
  private static final MethodDescriptor<CreateCdnKeyRequest, Operation>
      createCdnKeyMethodDescriptor =
          MethodDescriptor.<CreateCdnKeyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.stitcher.v1.VideoStitcherService/CreateCdnKey")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateCdnKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCdnKeysRequest, ListCdnKeysResponse>
      listCdnKeysMethodDescriptor =
          MethodDescriptor.<ListCdnKeysRequest, ListCdnKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.stitcher.v1.VideoStitcherService/ListCdnKeys")
              .setRequestMarshaller(ProtoUtils.marshaller(ListCdnKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCdnKeysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCdnKeyRequest, CdnKey> getCdnKeyMethodDescriptor =
      MethodDescriptor.<GetCdnKeyRequest, CdnKey>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.stitcher.v1.VideoStitcherService/GetCdnKey")
          .setRequestMarshaller(ProtoUtils.marshaller(GetCdnKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(CdnKey.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteCdnKeyRequest, Operation>
      deleteCdnKeyMethodDescriptor =
          MethodDescriptor.<DeleteCdnKeyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.stitcher.v1.VideoStitcherService/DeleteCdnKey")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteCdnKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCdnKeyRequest, Operation>
      updateCdnKeyMethodDescriptor =
          MethodDescriptor.<UpdateCdnKeyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.stitcher.v1.VideoStitcherService/UpdateCdnKey")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateCdnKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateVodSessionRequest, VodSession>
      createVodSessionMethodDescriptor =
          MethodDescriptor.<CreateVodSessionRequest, VodSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/CreateVodSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateVodSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VodSession.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVodSessionRequest, VodSession>
      getVodSessionMethodDescriptor =
          MethodDescriptor.<GetVodSessionRequest, VodSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/GetVodSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetVodSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VodSession.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse>
      listVodStitchDetailsMethodDescriptor =
          MethodDescriptor.<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/ListVodStitchDetails")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListVodStitchDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVodStitchDetailsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVodStitchDetailRequest, VodStitchDetail>
      getVodStitchDetailMethodDescriptor =
          MethodDescriptor.<GetVodStitchDetailRequest, VodStitchDetail>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/GetVodStitchDetail")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetVodStitchDetailRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VodStitchDetail.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse>
      listVodAdTagDetailsMethodDescriptor =
          MethodDescriptor.<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/ListVodAdTagDetails")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListVodAdTagDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVodAdTagDetailsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVodAdTagDetailRequest, VodAdTagDetail>
      getVodAdTagDetailMethodDescriptor =
          MethodDescriptor.<GetVodAdTagDetailRequest, VodAdTagDetail>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/GetVodAdTagDetail")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetVodAdTagDetailRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VodAdTagDetail.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse>
      listLiveAdTagDetailsMethodDescriptor =
          MethodDescriptor.<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/ListLiveAdTagDetails")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLiveAdTagDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLiveAdTagDetailsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLiveAdTagDetailRequest, LiveAdTagDetail>
      getLiveAdTagDetailMethodDescriptor =
          MethodDescriptor.<GetLiveAdTagDetailRequest, LiveAdTagDetail>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/GetLiveAdTagDetail")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLiveAdTagDetailRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LiveAdTagDetail.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSlateRequest, Operation> createSlateMethodDescriptor =
      MethodDescriptor.<CreateSlateRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.stitcher.v1.VideoStitcherService/CreateSlate")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSlateRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListSlatesRequest, ListSlatesResponse>
      listSlatesMethodDescriptor =
          MethodDescriptor.<ListSlatesRequest, ListSlatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.video.stitcher.v1.VideoStitcherService/ListSlates")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSlatesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSlatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSlateRequest, Slate> getSlateMethodDescriptor =
      MethodDescriptor.<GetSlateRequest, Slate>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.stitcher.v1.VideoStitcherService/GetSlate")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSlateRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Slate.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSlateRequest, Operation> updateSlateMethodDescriptor =
      MethodDescriptor.<UpdateSlateRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.stitcher.v1.VideoStitcherService/UpdateSlate")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSlateRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteSlateRequest, Operation> deleteSlateMethodDescriptor =
      MethodDescriptor.<DeleteSlateRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.video.stitcher.v1.VideoStitcherService/DeleteSlate")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSlateRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateLiveSessionRequest, LiveSession>
      createLiveSessionMethodDescriptor =
          MethodDescriptor.<CreateLiveSessionRequest, LiveSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/CreateLiveSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateLiveSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LiveSession.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLiveSessionRequest, LiveSession>
      getLiveSessionMethodDescriptor =
          MethodDescriptor.<GetLiveSessionRequest, LiveSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/GetLiveSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLiveSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LiveSession.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateLiveConfigRequest, Operation>
      createLiveConfigMethodDescriptor =
          MethodDescriptor.<CreateLiveConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/CreateLiveConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateLiveConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLiveConfigsRequest, ListLiveConfigsResponse>
      listLiveConfigsMethodDescriptor =
          MethodDescriptor.<ListLiveConfigsRequest, ListLiveConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/ListLiveConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLiveConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLiveConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLiveConfigRequest, LiveConfig>
      getLiveConfigMethodDescriptor =
          MethodDescriptor.<GetLiveConfigRequest, LiveConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/GetLiveConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetLiveConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LiveConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteLiveConfigRequest, Operation>
      deleteLiveConfigMethodDescriptor =
          MethodDescriptor.<DeleteLiveConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.video.stitcher.v1.VideoStitcherService/DeleteLiveConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteLiveConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateCdnKeyRequest, Operation> createCdnKeyCallable;
  private final OperationCallable<CreateCdnKeyRequest, CdnKey, OperationMetadata>
      createCdnKeyOperationCallable;
  private final UnaryCallable<ListCdnKeysRequest, ListCdnKeysResponse> listCdnKeysCallable;
  private final UnaryCallable<ListCdnKeysRequest, ListCdnKeysPagedResponse>
      listCdnKeysPagedCallable;
  private final UnaryCallable<GetCdnKeyRequest, CdnKey> getCdnKeyCallable;
  private final UnaryCallable<DeleteCdnKeyRequest, Operation> deleteCdnKeyCallable;
  private final OperationCallable<DeleteCdnKeyRequest, Empty, OperationMetadata>
      deleteCdnKeyOperationCallable;
  private final UnaryCallable<UpdateCdnKeyRequest, Operation> updateCdnKeyCallable;
  private final OperationCallable<UpdateCdnKeyRequest, CdnKey, OperationMetadata>
      updateCdnKeyOperationCallable;
  private final UnaryCallable<CreateVodSessionRequest, VodSession> createVodSessionCallable;
  private final UnaryCallable<GetVodSessionRequest, VodSession> getVodSessionCallable;
  private final UnaryCallable<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse>
      listVodStitchDetailsCallable;
  private final UnaryCallable<ListVodStitchDetailsRequest, ListVodStitchDetailsPagedResponse>
      listVodStitchDetailsPagedCallable;
  private final UnaryCallable<GetVodStitchDetailRequest, VodStitchDetail>
      getVodStitchDetailCallable;
  private final UnaryCallable<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse>
      listVodAdTagDetailsCallable;
  private final UnaryCallable<ListVodAdTagDetailsRequest, ListVodAdTagDetailsPagedResponse>
      listVodAdTagDetailsPagedCallable;
  private final UnaryCallable<GetVodAdTagDetailRequest, VodAdTagDetail> getVodAdTagDetailCallable;
  private final UnaryCallable<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse>
      listLiveAdTagDetailsCallable;
  private final UnaryCallable<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsPagedResponse>
      listLiveAdTagDetailsPagedCallable;
  private final UnaryCallable<GetLiveAdTagDetailRequest, LiveAdTagDetail>
      getLiveAdTagDetailCallable;
  private final UnaryCallable<CreateSlateRequest, Operation> createSlateCallable;
  private final OperationCallable<CreateSlateRequest, Slate, OperationMetadata>
      createSlateOperationCallable;
  private final UnaryCallable<ListSlatesRequest, ListSlatesResponse> listSlatesCallable;
  private final UnaryCallable<ListSlatesRequest, ListSlatesPagedResponse> listSlatesPagedCallable;
  private final UnaryCallable<GetSlateRequest, Slate> getSlateCallable;
  private final UnaryCallable<UpdateSlateRequest, Operation> updateSlateCallable;
  private final OperationCallable<UpdateSlateRequest, Slate, OperationMetadata>
      updateSlateOperationCallable;
  private final UnaryCallable<DeleteSlateRequest, Operation> deleteSlateCallable;
  private final OperationCallable<DeleteSlateRequest, Empty, OperationMetadata>
      deleteSlateOperationCallable;
  private final UnaryCallable<CreateLiveSessionRequest, LiveSession> createLiveSessionCallable;
  private final UnaryCallable<GetLiveSessionRequest, LiveSession> getLiveSessionCallable;
  private final UnaryCallable<CreateLiveConfigRequest, Operation> createLiveConfigCallable;
  private final OperationCallable<CreateLiveConfigRequest, LiveConfig, OperationMetadata>
      createLiveConfigOperationCallable;
  private final UnaryCallable<ListLiveConfigsRequest, ListLiveConfigsResponse>
      listLiveConfigsCallable;
  private final UnaryCallable<ListLiveConfigsRequest, ListLiveConfigsPagedResponse>
      listLiveConfigsPagedCallable;
  private final UnaryCallable<GetLiveConfigRequest, LiveConfig> getLiveConfigCallable;
  private final UnaryCallable<DeleteLiveConfigRequest, Operation> deleteLiveConfigCallable;
  private final OperationCallable<DeleteLiveConfigRequest, Empty, OperationMetadata>
      deleteLiveConfigOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcVideoStitcherServiceStub create(VideoStitcherServiceStubSettings settings)
      throws IOException {
    return new GrpcVideoStitcherServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcVideoStitcherServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcVideoStitcherServiceStub(
        VideoStitcherServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcVideoStitcherServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcVideoStitcherServiceStub(
        VideoStitcherServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcVideoStitcherServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcVideoStitcherServiceStub(
      VideoStitcherServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcVideoStitcherServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcVideoStitcherServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcVideoStitcherServiceStub(
      VideoStitcherServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateCdnKeyRequest, Operation> createCdnKeyTransportSettings =
        GrpcCallSettings.<CreateCdnKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(createCdnKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListCdnKeysRequest, ListCdnKeysResponse> listCdnKeysTransportSettings =
        GrpcCallSettings.<ListCdnKeysRequest, ListCdnKeysResponse>newBuilder()
            .setMethodDescriptor(listCdnKeysMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetCdnKeyRequest, CdnKey> getCdnKeyTransportSettings =
        GrpcCallSettings.<GetCdnKeyRequest, CdnKey>newBuilder()
            .setMethodDescriptor(getCdnKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteCdnKeyRequest, Operation> deleteCdnKeyTransportSettings =
        GrpcCallSettings.<DeleteCdnKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCdnKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateCdnKeyRequest, Operation> updateCdnKeyTransportSettings =
        GrpcCallSettings.<UpdateCdnKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCdnKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cdn_key.name", String.valueOf(request.getCdnKey().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateVodSessionRequest, VodSession> createVodSessionTransportSettings =
        GrpcCallSettings.<CreateVodSessionRequest, VodSession>newBuilder()
            .setMethodDescriptor(createVodSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetVodSessionRequest, VodSession> getVodSessionTransportSettings =
        GrpcCallSettings.<GetVodSessionRequest, VodSession>newBuilder()
            .setMethodDescriptor(getVodSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse>
        listVodStitchDetailsTransportSettings =
            GrpcCallSettings.<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse>newBuilder()
                .setMethodDescriptor(listVodStitchDetailsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetVodStitchDetailRequest, VodStitchDetail>
        getVodStitchDetailTransportSettings =
            GrpcCallSettings.<GetVodStitchDetailRequest, VodStitchDetail>newBuilder()
                .setMethodDescriptor(getVodStitchDetailMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse>
        listVodAdTagDetailsTransportSettings =
            GrpcCallSettings.<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse>newBuilder()
                .setMethodDescriptor(listVodAdTagDetailsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetVodAdTagDetailRequest, VodAdTagDetail> getVodAdTagDetailTransportSettings =
        GrpcCallSettings.<GetVodAdTagDetailRequest, VodAdTagDetail>newBuilder()
            .setMethodDescriptor(getVodAdTagDetailMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse>
        listLiveAdTagDetailsTransportSettings =
            GrpcCallSettings.<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse>newBuilder()
                .setMethodDescriptor(listLiveAdTagDetailsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetLiveAdTagDetailRequest, LiveAdTagDetail>
        getLiveAdTagDetailTransportSettings =
            GrpcCallSettings.<GetLiveAdTagDetailRequest, LiveAdTagDetail>newBuilder()
                .setMethodDescriptor(getLiveAdTagDetailMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateSlateRequest, Operation> createSlateTransportSettings =
        GrpcCallSettings.<CreateSlateRequest, Operation>newBuilder()
            .setMethodDescriptor(createSlateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSlatesRequest, ListSlatesResponse> listSlatesTransportSettings =
        GrpcCallSettings.<ListSlatesRequest, ListSlatesResponse>newBuilder()
            .setMethodDescriptor(listSlatesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSlateRequest, Slate> getSlateTransportSettings =
        GrpcCallSettings.<GetSlateRequest, Slate>newBuilder()
            .setMethodDescriptor(getSlateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSlateRequest, Operation> updateSlateTransportSettings =
        GrpcCallSettings.<UpdateSlateRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSlateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("slate.name", String.valueOf(request.getSlate().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSlateRequest, Operation> deleteSlateTransportSettings =
        GrpcCallSettings.<DeleteSlateRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSlateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateLiveSessionRequest, LiveSession> createLiveSessionTransportSettings =
        GrpcCallSettings.<CreateLiveSessionRequest, LiveSession>newBuilder()
            .setMethodDescriptor(createLiveSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLiveSessionRequest, LiveSession> getLiveSessionTransportSettings =
        GrpcCallSettings.<GetLiveSessionRequest, LiveSession>newBuilder()
            .setMethodDescriptor(getLiveSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateLiveConfigRequest, Operation> createLiveConfigTransportSettings =
        GrpcCallSettings.<CreateLiveConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(createLiveConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLiveConfigsRequest, ListLiveConfigsResponse>
        listLiveConfigsTransportSettings =
            GrpcCallSettings.<ListLiveConfigsRequest, ListLiveConfigsResponse>newBuilder()
                .setMethodDescriptor(listLiveConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetLiveConfigRequest, LiveConfig> getLiveConfigTransportSettings =
        GrpcCallSettings.<GetLiveConfigRequest, LiveConfig>newBuilder()
            .setMethodDescriptor(getLiveConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteLiveConfigRequest, Operation> deleteLiveConfigTransportSettings =
        GrpcCallSettings.<DeleteLiveConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteLiveConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createCdnKeyCallable =
        callableFactory.createUnaryCallable(
            createCdnKeyTransportSettings, settings.createCdnKeySettings(), clientContext);
    this.createCdnKeyOperationCallable =
        callableFactory.createOperationCallable(
            createCdnKeyTransportSettings,
            settings.createCdnKeyOperationSettings(),
            clientContext,
            operationsStub);
    this.listCdnKeysCallable =
        callableFactory.createUnaryCallable(
            listCdnKeysTransportSettings, settings.listCdnKeysSettings(), clientContext);
    this.listCdnKeysPagedCallable =
        callableFactory.createPagedCallable(
            listCdnKeysTransportSettings, settings.listCdnKeysSettings(), clientContext);
    this.getCdnKeyCallable =
        callableFactory.createUnaryCallable(
            getCdnKeyTransportSettings, settings.getCdnKeySettings(), clientContext);
    this.deleteCdnKeyCallable =
        callableFactory.createUnaryCallable(
            deleteCdnKeyTransportSettings, settings.deleteCdnKeySettings(), clientContext);
    this.deleteCdnKeyOperationCallable =
        callableFactory.createOperationCallable(
            deleteCdnKeyTransportSettings,
            settings.deleteCdnKeyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateCdnKeyCallable =
        callableFactory.createUnaryCallable(
            updateCdnKeyTransportSettings, settings.updateCdnKeySettings(), clientContext);
    this.updateCdnKeyOperationCallable =
        callableFactory.createOperationCallable(
            updateCdnKeyTransportSettings,
            settings.updateCdnKeyOperationSettings(),
            clientContext,
            operationsStub);
    this.createVodSessionCallable =
        callableFactory.createUnaryCallable(
            createVodSessionTransportSettings, settings.createVodSessionSettings(), clientContext);
    this.getVodSessionCallable =
        callableFactory.createUnaryCallable(
            getVodSessionTransportSettings, settings.getVodSessionSettings(), clientContext);
    this.listVodStitchDetailsCallable =
        callableFactory.createUnaryCallable(
            listVodStitchDetailsTransportSettings,
            settings.listVodStitchDetailsSettings(),
            clientContext);
    this.listVodStitchDetailsPagedCallable =
        callableFactory.createPagedCallable(
            listVodStitchDetailsTransportSettings,
            settings.listVodStitchDetailsSettings(),
            clientContext);
    this.getVodStitchDetailCallable =
        callableFactory.createUnaryCallable(
            getVodStitchDetailTransportSettings,
            settings.getVodStitchDetailSettings(),
            clientContext);
    this.listVodAdTagDetailsCallable =
        callableFactory.createUnaryCallable(
            listVodAdTagDetailsTransportSettings,
            settings.listVodAdTagDetailsSettings(),
            clientContext);
    this.listVodAdTagDetailsPagedCallable =
        callableFactory.createPagedCallable(
            listVodAdTagDetailsTransportSettings,
            settings.listVodAdTagDetailsSettings(),
            clientContext);
    this.getVodAdTagDetailCallable =
        callableFactory.createUnaryCallable(
            getVodAdTagDetailTransportSettings,
            settings.getVodAdTagDetailSettings(),
            clientContext);
    this.listLiveAdTagDetailsCallable =
        callableFactory.createUnaryCallable(
            listLiveAdTagDetailsTransportSettings,
            settings.listLiveAdTagDetailsSettings(),
            clientContext);
    this.listLiveAdTagDetailsPagedCallable =
        callableFactory.createPagedCallable(
            listLiveAdTagDetailsTransportSettings,
            settings.listLiveAdTagDetailsSettings(),
            clientContext);
    this.getLiveAdTagDetailCallable =
        callableFactory.createUnaryCallable(
            getLiveAdTagDetailTransportSettings,
            settings.getLiveAdTagDetailSettings(),
            clientContext);
    this.createSlateCallable =
        callableFactory.createUnaryCallable(
            createSlateTransportSettings, settings.createSlateSettings(), clientContext);
    this.createSlateOperationCallable =
        callableFactory.createOperationCallable(
            createSlateTransportSettings,
            settings.createSlateOperationSettings(),
            clientContext,
            operationsStub);
    this.listSlatesCallable =
        callableFactory.createUnaryCallable(
            listSlatesTransportSettings, settings.listSlatesSettings(), clientContext);
    this.listSlatesPagedCallable =
        callableFactory.createPagedCallable(
            listSlatesTransportSettings, settings.listSlatesSettings(), clientContext);
    this.getSlateCallable =
        callableFactory.createUnaryCallable(
            getSlateTransportSettings, settings.getSlateSettings(), clientContext);
    this.updateSlateCallable =
        callableFactory.createUnaryCallable(
            updateSlateTransportSettings, settings.updateSlateSettings(), clientContext);
    this.updateSlateOperationCallable =
        callableFactory.createOperationCallable(
            updateSlateTransportSettings,
            settings.updateSlateOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSlateCallable =
        callableFactory.createUnaryCallable(
            deleteSlateTransportSettings, settings.deleteSlateSettings(), clientContext);
    this.deleteSlateOperationCallable =
        callableFactory.createOperationCallable(
            deleteSlateTransportSettings,
            settings.deleteSlateOperationSettings(),
            clientContext,
            operationsStub);
    this.createLiveSessionCallable =
        callableFactory.createUnaryCallable(
            createLiveSessionTransportSettings,
            settings.createLiveSessionSettings(),
            clientContext);
    this.getLiveSessionCallable =
        callableFactory.createUnaryCallable(
            getLiveSessionTransportSettings, settings.getLiveSessionSettings(), clientContext);
    this.createLiveConfigCallable =
        callableFactory.createUnaryCallable(
            createLiveConfigTransportSettings, settings.createLiveConfigSettings(), clientContext);
    this.createLiveConfigOperationCallable =
        callableFactory.createOperationCallable(
            createLiveConfigTransportSettings,
            settings.createLiveConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.listLiveConfigsCallable =
        callableFactory.createUnaryCallable(
            listLiveConfigsTransportSettings, settings.listLiveConfigsSettings(), clientContext);
    this.listLiveConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listLiveConfigsTransportSettings, settings.listLiveConfigsSettings(), clientContext);
    this.getLiveConfigCallable =
        callableFactory.createUnaryCallable(
            getLiveConfigTransportSettings, settings.getLiveConfigSettings(), clientContext);
    this.deleteLiveConfigCallable =
        callableFactory.createUnaryCallable(
            deleteLiveConfigTransportSettings, settings.deleteLiveConfigSettings(), clientContext);
    this.deleteLiveConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteLiveConfigTransportSettings,
            settings.deleteLiveConfigOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateCdnKeyRequest, Operation> createCdnKeyCallable() {
    return createCdnKeyCallable;
  }

  @Override
  public OperationCallable<CreateCdnKeyRequest, CdnKey, OperationMetadata>
      createCdnKeyOperationCallable() {
    return createCdnKeyOperationCallable;
  }

  @Override
  public UnaryCallable<ListCdnKeysRequest, ListCdnKeysResponse> listCdnKeysCallable() {
    return listCdnKeysCallable;
  }

  @Override
  public UnaryCallable<ListCdnKeysRequest, ListCdnKeysPagedResponse> listCdnKeysPagedCallable() {
    return listCdnKeysPagedCallable;
  }

  @Override
  public UnaryCallable<GetCdnKeyRequest, CdnKey> getCdnKeyCallable() {
    return getCdnKeyCallable;
  }

  @Override
  public UnaryCallable<DeleteCdnKeyRequest, Operation> deleteCdnKeyCallable() {
    return deleteCdnKeyCallable;
  }

  @Override
  public OperationCallable<DeleteCdnKeyRequest, Empty, OperationMetadata>
      deleteCdnKeyOperationCallable() {
    return deleteCdnKeyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateCdnKeyRequest, Operation> updateCdnKeyCallable() {
    return updateCdnKeyCallable;
  }

  @Override
  public OperationCallable<UpdateCdnKeyRequest, CdnKey, OperationMetadata>
      updateCdnKeyOperationCallable() {
    return updateCdnKeyOperationCallable;
  }

  @Override
  public UnaryCallable<CreateVodSessionRequest, VodSession> createVodSessionCallable() {
    return createVodSessionCallable;
  }

  @Override
  public UnaryCallable<GetVodSessionRequest, VodSession> getVodSessionCallable() {
    return getVodSessionCallable;
  }

  @Override
  public UnaryCallable<ListVodStitchDetailsRequest, ListVodStitchDetailsResponse>
      listVodStitchDetailsCallable() {
    return listVodStitchDetailsCallable;
  }

  @Override
  public UnaryCallable<ListVodStitchDetailsRequest, ListVodStitchDetailsPagedResponse>
      listVodStitchDetailsPagedCallable() {
    return listVodStitchDetailsPagedCallable;
  }

  @Override
  public UnaryCallable<GetVodStitchDetailRequest, VodStitchDetail> getVodStitchDetailCallable() {
    return getVodStitchDetailCallable;
  }

  @Override
  public UnaryCallable<ListVodAdTagDetailsRequest, ListVodAdTagDetailsResponse>
      listVodAdTagDetailsCallable() {
    return listVodAdTagDetailsCallable;
  }

  @Override
  public UnaryCallable<ListVodAdTagDetailsRequest, ListVodAdTagDetailsPagedResponse>
      listVodAdTagDetailsPagedCallable() {
    return listVodAdTagDetailsPagedCallable;
  }

  @Override
  public UnaryCallable<GetVodAdTagDetailRequest, VodAdTagDetail> getVodAdTagDetailCallable() {
    return getVodAdTagDetailCallable;
  }

  @Override
  public UnaryCallable<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsResponse>
      listLiveAdTagDetailsCallable() {
    return listLiveAdTagDetailsCallable;
  }

  @Override
  public UnaryCallable<ListLiveAdTagDetailsRequest, ListLiveAdTagDetailsPagedResponse>
      listLiveAdTagDetailsPagedCallable() {
    return listLiveAdTagDetailsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLiveAdTagDetailRequest, LiveAdTagDetail> getLiveAdTagDetailCallable() {
    return getLiveAdTagDetailCallable;
  }

  @Override
  public UnaryCallable<CreateSlateRequest, Operation> createSlateCallable() {
    return createSlateCallable;
  }

  @Override
  public OperationCallable<CreateSlateRequest, Slate, OperationMetadata>
      createSlateOperationCallable() {
    return createSlateOperationCallable;
  }

  @Override
  public UnaryCallable<ListSlatesRequest, ListSlatesResponse> listSlatesCallable() {
    return listSlatesCallable;
  }

  @Override
  public UnaryCallable<ListSlatesRequest, ListSlatesPagedResponse> listSlatesPagedCallable() {
    return listSlatesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSlateRequest, Slate> getSlateCallable() {
    return getSlateCallable;
  }

  @Override
  public UnaryCallable<UpdateSlateRequest, Operation> updateSlateCallable() {
    return updateSlateCallable;
  }

  @Override
  public OperationCallable<UpdateSlateRequest, Slate, OperationMetadata>
      updateSlateOperationCallable() {
    return updateSlateOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSlateRequest, Operation> deleteSlateCallable() {
    return deleteSlateCallable;
  }

  @Override
  public OperationCallable<DeleteSlateRequest, Empty, OperationMetadata>
      deleteSlateOperationCallable() {
    return deleteSlateOperationCallable;
  }

  @Override
  public UnaryCallable<CreateLiveSessionRequest, LiveSession> createLiveSessionCallable() {
    return createLiveSessionCallable;
  }

  @Override
  public UnaryCallable<GetLiveSessionRequest, LiveSession> getLiveSessionCallable() {
    return getLiveSessionCallable;
  }

  @Override
  public UnaryCallable<CreateLiveConfigRequest, Operation> createLiveConfigCallable() {
    return createLiveConfigCallable;
  }

  @Override
  public OperationCallable<CreateLiveConfigRequest, LiveConfig, OperationMetadata>
      createLiveConfigOperationCallable() {
    return createLiveConfigOperationCallable;
  }

  @Override
  public UnaryCallable<ListLiveConfigsRequest, ListLiveConfigsResponse> listLiveConfigsCallable() {
    return listLiveConfigsCallable;
  }

  @Override
  public UnaryCallable<ListLiveConfigsRequest, ListLiveConfigsPagedResponse>
      listLiveConfigsPagedCallable() {
    return listLiveConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLiveConfigRequest, LiveConfig> getLiveConfigCallable() {
    return getLiveConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteLiveConfigRequest, Operation> deleteLiveConfigCallable() {
    return deleteLiveConfigCallable;
  }

  @Override
  public OperationCallable<DeleteLiveConfigRequest, Empty, OperationMetadata>
      deleteLiveConfigOperationCallable() {
    return deleteLiveConfigOperationCallable;
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
