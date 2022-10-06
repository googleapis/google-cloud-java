/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.accessapproval.v1.stub;

import static com.google.cloud.accessapproval.v1.AccessApprovalAdminClient.ListApprovalRequestsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount;
import com.google.cloud.accessapproval.v1.AccessApprovalSettings;
import com.google.cloud.accessapproval.v1.ApprovalRequest;
import com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage;
import com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage;
import com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage;
import com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage;
import com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage;
import com.google.cloud.accessapproval.v1.GetApprovalRequestMessage;
import com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage;
import com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage;
import com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse;
import com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AccessApproval service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAccessApprovalStub extends AccessApprovalStub {
  private static final MethodDescriptor<ListApprovalRequestsMessage, ListApprovalRequestsResponse>
      listApprovalRequestsMethodDescriptor =
          MethodDescriptor.<ListApprovalRequestsMessage, ListApprovalRequestsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/ListApprovalRequests")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListApprovalRequestsMessage.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApprovalRequestsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetApprovalRequestMessage, ApprovalRequest>
      getApprovalRequestMethodDescriptor =
          MethodDescriptor.<GetApprovalRequestMessage, ApprovalRequest>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.accessapproval.v1.AccessApproval/GetApprovalRequest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetApprovalRequestMessage.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApprovalRequest.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ApproveApprovalRequestMessage, ApprovalRequest>
      approveApprovalRequestMethodDescriptor =
          MethodDescriptor.<ApproveApprovalRequestMessage, ApprovalRequest>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/ApproveApprovalRequest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ApproveApprovalRequestMessage.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApprovalRequest.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DismissApprovalRequestMessage, ApprovalRequest>
      dismissApprovalRequestMethodDescriptor =
          MethodDescriptor.<DismissApprovalRequestMessage, ApprovalRequest>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/DismissApprovalRequest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DismissApprovalRequestMessage.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApprovalRequest.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<InvalidateApprovalRequestMessage, ApprovalRequest>
      invalidateApprovalRequestMethodDescriptor =
          MethodDescriptor.<InvalidateApprovalRequestMessage, ApprovalRequest>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/InvalidateApprovalRequest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InvalidateApprovalRequestMessage.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApprovalRequest.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
      getAccessApprovalSettingsMethodDescriptor =
          MethodDescriptor.<GetAccessApprovalSettingsMessage, AccessApprovalSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/GetAccessApprovalSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAccessApprovalSettingsMessage.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AccessApprovalSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
      updateAccessApprovalSettingsMethodDescriptor =
          MethodDescriptor.<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/UpdateAccessApprovalSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAccessApprovalSettingsMessage.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AccessApprovalSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAccessApprovalSettingsMessage, Empty>
      deleteAccessApprovalSettingsMethodDescriptor =
          MethodDescriptor.<DeleteAccessApprovalSettingsMessage, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/DeleteAccessApprovalSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAccessApprovalSettingsMessage.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
      getAccessApprovalServiceAccountMethodDescriptor =
          MethodDescriptor
              .<GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/GetAccessApprovalServiceAccount")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetAccessApprovalServiceAccountMessage.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AccessApprovalServiceAccount.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListApprovalRequestsMessage, ListApprovalRequestsResponse>
      listApprovalRequestsCallable;
  private final UnaryCallable<ListApprovalRequestsMessage, ListApprovalRequestsPagedResponse>
      listApprovalRequestsPagedCallable;
  private final UnaryCallable<GetApprovalRequestMessage, ApprovalRequest>
      getApprovalRequestCallable;
  private final UnaryCallable<ApproveApprovalRequestMessage, ApprovalRequest>
      approveApprovalRequestCallable;
  private final UnaryCallable<DismissApprovalRequestMessage, ApprovalRequest>
      dismissApprovalRequestCallable;
  private final UnaryCallable<InvalidateApprovalRequestMessage, ApprovalRequest>
      invalidateApprovalRequestCallable;
  private final UnaryCallable<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
      getAccessApprovalSettingsCallable;
  private final UnaryCallable<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
      updateAccessApprovalSettingsCallable;
  private final UnaryCallable<DeleteAccessApprovalSettingsMessage, Empty>
      deleteAccessApprovalSettingsCallable;
  private final UnaryCallable<GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
      getAccessApprovalServiceAccountCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAccessApprovalStub create(AccessApprovalStubSettings settings)
      throws IOException {
    return new GrpcAccessApprovalStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAccessApprovalStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAccessApprovalStub(
        AccessApprovalStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAccessApprovalStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAccessApprovalStub(
        AccessApprovalStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAccessApprovalStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAccessApprovalStub(AccessApprovalStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAccessApprovalCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAccessApprovalStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAccessApprovalStub(
      AccessApprovalStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListApprovalRequestsMessage, ListApprovalRequestsResponse>
        listApprovalRequestsTransportSettings =
            GrpcCallSettings.<ListApprovalRequestsMessage, ListApprovalRequestsResponse>newBuilder()
                .setMethodDescriptor(listApprovalRequestsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetApprovalRequestMessage, ApprovalRequest>
        getApprovalRequestTransportSettings =
            GrpcCallSettings.<GetApprovalRequestMessage, ApprovalRequest>newBuilder()
                .setMethodDescriptor(getApprovalRequestMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ApproveApprovalRequestMessage, ApprovalRequest>
        approveApprovalRequestTransportSettings =
            GrpcCallSettings.<ApproveApprovalRequestMessage, ApprovalRequest>newBuilder()
                .setMethodDescriptor(approveApprovalRequestMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DismissApprovalRequestMessage, ApprovalRequest>
        dismissApprovalRequestTransportSettings =
            GrpcCallSettings.<DismissApprovalRequestMessage, ApprovalRequest>newBuilder()
                .setMethodDescriptor(dismissApprovalRequestMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<InvalidateApprovalRequestMessage, ApprovalRequest>
        invalidateApprovalRequestTransportSettings =
            GrpcCallSettings.<InvalidateApprovalRequestMessage, ApprovalRequest>newBuilder()
                .setMethodDescriptor(invalidateApprovalRequestMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
        getAccessApprovalSettingsTransportSettings =
            GrpcCallSettings.<GetAccessApprovalSettingsMessage, AccessApprovalSettings>newBuilder()
                .setMethodDescriptor(getAccessApprovalSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
        updateAccessApprovalSettingsTransportSettings =
            GrpcCallSettings
                .<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>newBuilder()
                .setMethodDescriptor(updateAccessApprovalSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("settings.name", String.valueOf(request.getSettings().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteAccessApprovalSettingsMessage, Empty>
        deleteAccessApprovalSettingsTransportSettings =
            GrpcCallSettings.<DeleteAccessApprovalSettingsMessage, Empty>newBuilder()
                .setMethodDescriptor(deleteAccessApprovalSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
        getAccessApprovalServiceAccountTransportSettings =
            GrpcCallSettings
                .<GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>newBuilder()
                .setMethodDescriptor(getAccessApprovalServiceAccountMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();

    this.listApprovalRequestsCallable =
        callableFactory.createUnaryCallable(
            listApprovalRequestsTransportSettings,
            settings.listApprovalRequestsSettings(),
            clientContext);
    this.listApprovalRequestsPagedCallable =
        callableFactory.createPagedCallable(
            listApprovalRequestsTransportSettings,
            settings.listApprovalRequestsSettings(),
            clientContext);
    this.getApprovalRequestCallable =
        callableFactory.createUnaryCallable(
            getApprovalRequestTransportSettings,
            settings.getApprovalRequestSettings(),
            clientContext);
    this.approveApprovalRequestCallable =
        callableFactory.createUnaryCallable(
            approveApprovalRequestTransportSettings,
            settings.approveApprovalRequestSettings(),
            clientContext);
    this.dismissApprovalRequestCallable =
        callableFactory.createUnaryCallable(
            dismissApprovalRequestTransportSettings,
            settings.dismissApprovalRequestSettings(),
            clientContext);
    this.invalidateApprovalRequestCallable =
        callableFactory.createUnaryCallable(
            invalidateApprovalRequestTransportSettings,
            settings.invalidateApprovalRequestSettings(),
            clientContext);
    this.getAccessApprovalSettingsCallable =
        callableFactory.createUnaryCallable(
            getAccessApprovalSettingsTransportSettings,
            settings.getAccessApprovalSettingsSettings(),
            clientContext);
    this.updateAccessApprovalSettingsCallable =
        callableFactory.createUnaryCallable(
            updateAccessApprovalSettingsTransportSettings,
            settings.updateAccessApprovalSettingsSettings(),
            clientContext);
    this.deleteAccessApprovalSettingsCallable =
        callableFactory.createUnaryCallable(
            deleteAccessApprovalSettingsTransportSettings,
            settings.deleteAccessApprovalSettingsSettings(),
            clientContext);
    this.getAccessApprovalServiceAccountCallable =
        callableFactory.createUnaryCallable(
            getAccessApprovalServiceAccountTransportSettings,
            settings.getAccessApprovalServiceAccountSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListApprovalRequestsMessage, ListApprovalRequestsResponse>
      listApprovalRequestsCallable() {
    return listApprovalRequestsCallable;
  }

  @Override
  public UnaryCallable<ListApprovalRequestsMessage, ListApprovalRequestsPagedResponse>
      listApprovalRequestsPagedCallable() {
    return listApprovalRequestsPagedCallable;
  }

  @Override
  public UnaryCallable<GetApprovalRequestMessage, ApprovalRequest> getApprovalRequestCallable() {
    return getApprovalRequestCallable;
  }

  @Override
  public UnaryCallable<ApproveApprovalRequestMessage, ApprovalRequest>
      approveApprovalRequestCallable() {
    return approveApprovalRequestCallable;
  }

  @Override
  public UnaryCallable<DismissApprovalRequestMessage, ApprovalRequest>
      dismissApprovalRequestCallable() {
    return dismissApprovalRequestCallable;
  }

  @Override
  public UnaryCallable<InvalidateApprovalRequestMessage, ApprovalRequest>
      invalidateApprovalRequestCallable() {
    return invalidateApprovalRequestCallable;
  }

  @Override
  public UnaryCallable<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
      getAccessApprovalSettingsCallable() {
    return getAccessApprovalSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
      updateAccessApprovalSettingsCallable() {
    return updateAccessApprovalSettingsCallable;
  }

  @Override
  public UnaryCallable<DeleteAccessApprovalSettingsMessage, Empty>
      deleteAccessApprovalSettingsCallable() {
    return deleteAccessApprovalSettingsCallable;
  }

  @Override
  public UnaryCallable<GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
      getAccessApprovalServiceAccountCallable() {
    return getAccessApprovalServiceAccountCallable;
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
