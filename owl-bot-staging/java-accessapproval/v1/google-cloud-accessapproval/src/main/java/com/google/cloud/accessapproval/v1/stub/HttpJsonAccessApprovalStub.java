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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
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
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AccessApproval service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAccessApprovalStub extends AccessApprovalStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ListApprovalRequestsMessage, ListApprovalRequestsResponse>
      listApprovalRequestsMethodDescriptor =
          ApiMethodDescriptor
              .<ListApprovalRequestsMessage, ListApprovalRequestsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/ListApprovalRequests")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListApprovalRequestsMessage>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*}/approvalRequests",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListApprovalRequestsMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*}/approvalRequests",
                          "/v1/{parent=organizations/*}/approvalRequests")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListApprovalRequestsMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListApprovalRequestsResponse>newBuilder()
                      .setDefaultInstance(ListApprovalRequestsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetApprovalRequestMessage, ApprovalRequest>
      getApprovalRequestMethodDescriptor =
          ApiMethodDescriptor.<GetApprovalRequestMessage, ApprovalRequest>newBuilder()
              .setFullMethodName("google.cloud.accessapproval.v1.AccessApproval/GetApprovalRequest")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetApprovalRequestMessage>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/approvalRequests/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetApprovalRequestMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/approvalRequests/*}",
                          "/v1/{name=organizations/*/approvalRequests/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetApprovalRequestMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApprovalRequest>newBuilder()
                      .setDefaultInstance(ApprovalRequest.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ApproveApprovalRequestMessage, ApprovalRequest>
      approveApprovalRequestMethodDescriptor =
          ApiMethodDescriptor.<ApproveApprovalRequestMessage, ApprovalRequest>newBuilder()
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/ApproveApprovalRequest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ApproveApprovalRequestMessage>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/approvalRequests/*}:approve",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveApprovalRequestMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/approvalRequests/*}:approve",
                          "/v1/{name=organizations/*/approvalRequests/*}:approve")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApproveApprovalRequestMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApprovalRequest>newBuilder()
                      .setDefaultInstance(ApprovalRequest.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DismissApprovalRequestMessage, ApprovalRequest>
      dismissApprovalRequestMethodDescriptor =
          ApiMethodDescriptor.<DismissApprovalRequestMessage, ApprovalRequest>newBuilder()
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/DismissApprovalRequest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DismissApprovalRequestMessage>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/approvalRequests/*}:dismiss",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DismissApprovalRequestMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/approvalRequests/*}:dismiss",
                          "/v1/{name=organizations/*/approvalRequests/*}:dismiss")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DismissApprovalRequestMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApprovalRequest>newBuilder()
                      .setDefaultInstance(ApprovalRequest.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InvalidateApprovalRequestMessage, ApprovalRequest>
      invalidateApprovalRequestMethodDescriptor =
          ApiMethodDescriptor.<InvalidateApprovalRequestMessage, ApprovalRequest>newBuilder()
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/InvalidateApprovalRequest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InvalidateApprovalRequestMessage>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/approvalRequests/*}:invalidate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InvalidateApprovalRequestMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/approvalRequests/*}:invalidate",
                          "/v1/{name=organizations/*/approvalRequests/*}:invalidate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InvalidateApprovalRequestMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ApprovalRequest>newBuilder()
                      .setDefaultInstance(ApprovalRequest.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
      getAccessApprovalSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetAccessApprovalSettingsMessage, AccessApprovalSettings>newBuilder()
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/GetAccessApprovalSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAccessApprovalSettingsMessage>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/accessApprovalSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessApprovalSettingsMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/accessApprovalSettings}",
                          "/v1/{name=organizations/*/accessApprovalSettings}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessApprovalSettingsMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccessApprovalSettings>newBuilder()
                      .setDefaultInstance(AccessApprovalSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
      updateAccessApprovalSettingsMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>newBuilder()
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/UpdateAccessApprovalSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAccessApprovalSettingsMessage>newBuilder()
                      .setPath(
                          "/v1/{settings.name=projects/*/accessApprovalSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccessApprovalSettingsMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "settings.name", request.getSettings().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{settings.name=folders/*/accessApprovalSettings}",
                          "/v1/{settings.name=organizations/*/accessApprovalSettings}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAccessApprovalSettingsMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("settings", request.getSettings(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccessApprovalSettings>newBuilder()
                      .setDefaultInstance(AccessApprovalSettings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAccessApprovalSettingsMessage, Empty>
      deleteAccessApprovalSettingsMethodDescriptor =
          ApiMethodDescriptor.<DeleteAccessApprovalSettingsMessage, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/DeleteAccessApprovalSettings")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAccessApprovalSettingsMessage>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/accessApprovalSettings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccessApprovalSettingsMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/accessApprovalSettings}",
                          "/v1/{name=organizations/*/accessApprovalSettings}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAccessApprovalSettingsMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
      getAccessApprovalServiceAccountMethodDescriptor =
          ApiMethodDescriptor
              .<GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>newBuilder()
              .setFullMethodName(
                  "google.cloud.accessapproval.v1.AccessApproval/GetAccessApprovalServiceAccount")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAccessApprovalServiceAccountMessage>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/serviceAccount}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessApprovalServiceAccountMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/serviceAccount}",
                          "/v1/{name=organizations/*/serviceAccount}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAccessApprovalServiceAccountMessage> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AccessApprovalServiceAccount>newBuilder()
                      .setDefaultInstance(AccessApprovalServiceAccount.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAccessApprovalStub create(AccessApprovalStubSettings settings)
      throws IOException {
    return new HttpJsonAccessApprovalStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAccessApprovalStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAccessApprovalStub(
        AccessApprovalStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAccessApprovalStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAccessApprovalStub(
        AccessApprovalStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAccessApprovalStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccessApprovalStub(
      AccessApprovalStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAccessApprovalCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAccessApprovalStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAccessApprovalStub(
      AccessApprovalStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListApprovalRequestsMessage, ListApprovalRequestsResponse>
        listApprovalRequestsTransportSettings =
            HttpJsonCallSettings
                .<ListApprovalRequestsMessage, ListApprovalRequestsResponse>newBuilder()
                .setMethodDescriptor(listApprovalRequestsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetApprovalRequestMessage, ApprovalRequest>
        getApprovalRequestTransportSettings =
            HttpJsonCallSettings.<GetApprovalRequestMessage, ApprovalRequest>newBuilder()
                .setMethodDescriptor(getApprovalRequestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ApproveApprovalRequestMessage, ApprovalRequest>
        approveApprovalRequestTransportSettings =
            HttpJsonCallSettings.<ApproveApprovalRequestMessage, ApprovalRequest>newBuilder()
                .setMethodDescriptor(approveApprovalRequestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DismissApprovalRequestMessage, ApprovalRequest>
        dismissApprovalRequestTransportSettings =
            HttpJsonCallSettings.<DismissApprovalRequestMessage, ApprovalRequest>newBuilder()
                .setMethodDescriptor(dismissApprovalRequestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InvalidateApprovalRequestMessage, ApprovalRequest>
        invalidateApprovalRequestTransportSettings =
            HttpJsonCallSettings.<InvalidateApprovalRequestMessage, ApprovalRequest>newBuilder()
                .setMethodDescriptor(invalidateApprovalRequestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
        getAccessApprovalSettingsTransportSettings =
            HttpJsonCallSettings
                .<GetAccessApprovalSettingsMessage, AccessApprovalSettings>newBuilder()
                .setMethodDescriptor(getAccessApprovalSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
        updateAccessApprovalSettingsTransportSettings =
            HttpJsonCallSettings
                .<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>newBuilder()
                .setMethodDescriptor(updateAccessApprovalSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAccessApprovalSettingsMessage, Empty>
        deleteAccessApprovalSettingsTransportSettings =
            HttpJsonCallSettings.<DeleteAccessApprovalSettingsMessage, Empty>newBuilder()
                .setMethodDescriptor(deleteAccessApprovalSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
        getAccessApprovalServiceAccountTransportSettings =
            HttpJsonCallSettings
                .<GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>newBuilder()
                .setMethodDescriptor(getAccessApprovalServiceAccountMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listApprovalRequestsMethodDescriptor);
    methodDescriptors.add(getApprovalRequestMethodDescriptor);
    methodDescriptors.add(approveApprovalRequestMethodDescriptor);
    methodDescriptors.add(dismissApprovalRequestMethodDescriptor);
    methodDescriptors.add(invalidateApprovalRequestMethodDescriptor);
    methodDescriptors.add(getAccessApprovalSettingsMethodDescriptor);
    methodDescriptors.add(updateAccessApprovalSettingsMethodDescriptor);
    methodDescriptors.add(deleteAccessApprovalSettingsMethodDescriptor);
    methodDescriptors.add(getAccessApprovalServiceAccountMethodDescriptor);
    return methodDescriptors;
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
