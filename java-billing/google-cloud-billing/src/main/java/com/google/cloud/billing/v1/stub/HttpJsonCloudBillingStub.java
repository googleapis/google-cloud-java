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

package com.google.cloud.billing.v1.stub;

import static com.google.cloud.billing.v1.CloudBillingClient.ListBillingAccountsPagedResponse;
import static com.google.cloud.billing.v1.CloudBillingClient.ListProjectBillingInfoPagedResponse;

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
import com.google.cloud.billing.v1.BillingAccount;
import com.google.cloud.billing.v1.CreateBillingAccountRequest;
import com.google.cloud.billing.v1.GetBillingAccountRequest;
import com.google.cloud.billing.v1.GetProjectBillingInfoRequest;
import com.google.cloud.billing.v1.ListBillingAccountsRequest;
import com.google.cloud.billing.v1.ListBillingAccountsResponse;
import com.google.cloud.billing.v1.ListProjectBillingInfoRequest;
import com.google.cloud.billing.v1.ListProjectBillingInfoResponse;
import com.google.cloud.billing.v1.ProjectBillingInfo;
import com.google.cloud.billing.v1.UpdateBillingAccountRequest;
import com.google.cloud.billing.v1.UpdateProjectBillingInfoRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the CloudBilling service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCloudBillingStub extends CloudBillingStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetBillingAccountRequest, BillingAccount>
      getBillingAccountMethodDescriptor =
          ApiMethodDescriptor.<GetBillingAccountRequest, BillingAccount>newBuilder()
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/GetBillingAccount")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBillingAccountRequest>newBuilder()
                      .setPath(
                          "/v1/{name=billingAccounts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBillingAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBillingAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BillingAccount>newBuilder()
                      .setDefaultInstance(BillingAccount.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBillingAccountsRequest, ListBillingAccountsResponse>
      listBillingAccountsMethodDescriptor =
          ApiMethodDescriptor.<ListBillingAccountsRequest, ListBillingAccountsResponse>newBuilder()
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/ListBillingAccounts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBillingAccountsRequest>newBuilder()
                      .setPath(
                          "/v1/billingAccounts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBillingAccountsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBillingAccountsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBillingAccountsResponse>newBuilder()
                      .setDefaultInstance(ListBillingAccountsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBillingAccountRequest, BillingAccount>
      updateBillingAccountMethodDescriptor =
          ApiMethodDescriptor.<UpdateBillingAccountRequest, BillingAccount>newBuilder()
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/UpdateBillingAccount")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBillingAccountRequest>newBuilder()
                      .setPath(
                          "/v1/{name=billingAccounts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBillingAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBillingAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("account", request.getAccount(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BillingAccount>newBuilder()
                      .setDefaultInstance(BillingAccount.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateBillingAccountRequest, BillingAccount>
      createBillingAccountMethodDescriptor =
          ApiMethodDescriptor.<CreateBillingAccountRequest, BillingAccount>newBuilder()
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/CreateBillingAccount")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBillingAccountRequest>newBuilder()
                      .setPath(
                          "/v1/billingAccounts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBillingAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBillingAccountRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("billingAccount", request.getBillingAccount(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BillingAccount>newBuilder()
                      .setDefaultInstance(BillingAccount.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>
      listProjectBillingInfoMethodDescriptor =
          ApiMethodDescriptor
              .<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>newBuilder()
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/ListProjectBillingInfo")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProjectBillingInfoRequest>newBuilder()
                      .setPath(
                          "/v1/{name=billingAccounts/*}/projects",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProjectBillingInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProjectBillingInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProjectBillingInfoResponse>newBuilder()
                      .setDefaultInstance(ListProjectBillingInfoResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetProjectBillingInfoRequest, ProjectBillingInfo>
      getProjectBillingInfoMethodDescriptor =
          ApiMethodDescriptor.<GetProjectBillingInfoRequest, ProjectBillingInfo>newBuilder()
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/GetProjectBillingInfo")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetProjectBillingInfoRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/billingInfo",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetProjectBillingInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetProjectBillingInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProjectBillingInfo>newBuilder()
                      .setDefaultInstance(ProjectBillingInfo.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
      updateProjectBillingInfoMethodDescriptor =
          ApiMethodDescriptor.<UpdateProjectBillingInfoRequest, ProjectBillingInfo>newBuilder()
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/UpdateProjectBillingInfo")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProjectBillingInfoRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/billingInfo",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProjectBillingInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProjectBillingInfoRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "projectBillingInfo", request.getProjectBillingInfo(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProjectBillingInfo>newBuilder()
                      .setDefaultInstance(ProjectBillingInfo.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=billingAccounts/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "options", request.getOptions());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=billingAccounts/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.billing.v1.CloudBilling/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=billingAccounts/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetBillingAccountRequest, BillingAccount> getBillingAccountCallable;
  private final UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsResponse>
      listBillingAccountsCallable;
  private final UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsPagedResponse>
      listBillingAccountsPagedCallable;
  private final UnaryCallable<UpdateBillingAccountRequest, BillingAccount>
      updateBillingAccountCallable;
  private final UnaryCallable<CreateBillingAccountRequest, BillingAccount>
      createBillingAccountCallable;
  private final UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>
      listProjectBillingInfoCallable;
  private final UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoPagedResponse>
      listProjectBillingInfoPagedCallable;
  private final UnaryCallable<GetProjectBillingInfoRequest, ProjectBillingInfo>
      getProjectBillingInfoCallable;
  private final UnaryCallable<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
      updateProjectBillingInfoCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudBillingStub create(CloudBillingStubSettings settings)
      throws IOException {
    return new HttpJsonCloudBillingStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudBillingStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudBillingStub(
        CloudBillingStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudBillingStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudBillingStub(
        CloudBillingStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudBillingStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCloudBillingStub(CloudBillingStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCloudBillingCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudBillingStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCloudBillingStub(
      CloudBillingStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetBillingAccountRequest, BillingAccount>
        getBillingAccountTransportSettings =
            HttpJsonCallSettings.<GetBillingAccountRequest, BillingAccount>newBuilder()
                .setMethodDescriptor(getBillingAccountMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListBillingAccountsRequest, ListBillingAccountsResponse>
        listBillingAccountsTransportSettings =
            HttpJsonCallSettings
                .<ListBillingAccountsRequest, ListBillingAccountsResponse>newBuilder()
                .setMethodDescriptor(listBillingAccountsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateBillingAccountRequest, BillingAccount>
        updateBillingAccountTransportSettings =
            HttpJsonCallSettings.<UpdateBillingAccountRequest, BillingAccount>newBuilder()
                .setMethodDescriptor(updateBillingAccountMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateBillingAccountRequest, BillingAccount>
        createBillingAccountTransportSettings =
            HttpJsonCallSettings.<CreateBillingAccountRequest, BillingAccount>newBuilder()
                .setMethodDescriptor(createBillingAccountMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>
        listProjectBillingInfoTransportSettings =
            HttpJsonCallSettings
                .<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>newBuilder()
                .setMethodDescriptor(listProjectBillingInfoMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetProjectBillingInfoRequest, ProjectBillingInfo>
        getProjectBillingInfoTransportSettings =
            HttpJsonCallSettings.<GetProjectBillingInfoRequest, ProjectBillingInfo>newBuilder()
                .setMethodDescriptor(getProjectBillingInfoMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
        updateProjectBillingInfoTransportSettings =
            HttpJsonCallSettings.<UpdateProjectBillingInfoRequest, ProjectBillingInfo>newBuilder()
                .setMethodDescriptor(updateProjectBillingInfoMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.getBillingAccountCallable =
        callableFactory.createUnaryCallable(
            getBillingAccountTransportSettings,
            settings.getBillingAccountSettings(),
            clientContext);
    this.listBillingAccountsCallable =
        callableFactory.createUnaryCallable(
            listBillingAccountsTransportSettings,
            settings.listBillingAccountsSettings(),
            clientContext);
    this.listBillingAccountsPagedCallable =
        callableFactory.createPagedCallable(
            listBillingAccountsTransportSettings,
            settings.listBillingAccountsSettings(),
            clientContext);
    this.updateBillingAccountCallable =
        callableFactory.createUnaryCallable(
            updateBillingAccountTransportSettings,
            settings.updateBillingAccountSettings(),
            clientContext);
    this.createBillingAccountCallable =
        callableFactory.createUnaryCallable(
            createBillingAccountTransportSettings,
            settings.createBillingAccountSettings(),
            clientContext);
    this.listProjectBillingInfoCallable =
        callableFactory.createUnaryCallable(
            listProjectBillingInfoTransportSettings,
            settings.listProjectBillingInfoSettings(),
            clientContext);
    this.listProjectBillingInfoPagedCallable =
        callableFactory.createPagedCallable(
            listProjectBillingInfoTransportSettings,
            settings.listProjectBillingInfoSettings(),
            clientContext);
    this.getProjectBillingInfoCallable =
        callableFactory.createUnaryCallable(
            getProjectBillingInfoTransportSettings,
            settings.getProjectBillingInfoSettings(),
            clientContext);
    this.updateProjectBillingInfoCallable =
        callableFactory.createUnaryCallable(
            updateProjectBillingInfoTransportSettings,
            settings.updateProjectBillingInfoSettings(),
            clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getBillingAccountMethodDescriptor);
    methodDescriptors.add(listBillingAccountsMethodDescriptor);
    methodDescriptors.add(updateBillingAccountMethodDescriptor);
    methodDescriptors.add(createBillingAccountMethodDescriptor);
    methodDescriptors.add(listProjectBillingInfoMethodDescriptor);
    methodDescriptors.add(getProjectBillingInfoMethodDescriptor);
    methodDescriptors.add(updateProjectBillingInfoMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetBillingAccountRequest, BillingAccount> getBillingAccountCallable() {
    return getBillingAccountCallable;
  }

  @Override
  public UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsResponse>
      listBillingAccountsCallable() {
    return listBillingAccountsCallable;
  }

  @Override
  public UnaryCallable<ListBillingAccountsRequest, ListBillingAccountsPagedResponse>
      listBillingAccountsPagedCallable() {
    return listBillingAccountsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateBillingAccountRequest, BillingAccount> updateBillingAccountCallable() {
    return updateBillingAccountCallable;
  }

  @Override
  public UnaryCallable<CreateBillingAccountRequest, BillingAccount> createBillingAccountCallable() {
    return createBillingAccountCallable;
  }

  @Override
  public UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoResponse>
      listProjectBillingInfoCallable() {
    return listProjectBillingInfoCallable;
  }

  @Override
  public UnaryCallable<ListProjectBillingInfoRequest, ListProjectBillingInfoPagedResponse>
      listProjectBillingInfoPagedCallable() {
    return listProjectBillingInfoPagedCallable;
  }

  @Override
  public UnaryCallable<GetProjectBillingInfoRequest, ProjectBillingInfo>
      getProjectBillingInfoCallable() {
    return getProjectBillingInfoCallable;
  }

  @Override
  public UnaryCallable<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
      updateProjectBillingInfoCallable() {
    return updateProjectBillingInfoCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
