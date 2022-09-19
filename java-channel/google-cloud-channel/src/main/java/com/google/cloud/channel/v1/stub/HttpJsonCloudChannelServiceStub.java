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

package com.google.cloud.channel.v1.stub;

import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListChannelPartnerLinksPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListChannelPartnerRepricingConfigsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListCustomerRepricingConfigsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListCustomersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListEntitlementsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListOffersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListProductsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListPurchasableOffersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListPurchasableSkusPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListSkusPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListSubscribersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListTransferableOffersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListTransferableSkusPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.channel.v1.ActivateEntitlementRequest;
import com.google.cloud.channel.v1.CancelEntitlementRequest;
import com.google.cloud.channel.v1.ChangeOfferRequest;
import com.google.cloud.channel.v1.ChangeParametersRequest;
import com.google.cloud.channel.v1.ChangeRenewalSettingsRequest;
import com.google.cloud.channel.v1.ChannelPartnerLink;
import com.google.cloud.channel.v1.ChannelPartnerRepricingConfig;
import com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest;
import com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse;
import com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest;
import com.google.cloud.channel.v1.CreateChannelPartnerRepricingConfigRequest;
import com.google.cloud.channel.v1.CreateCustomerRepricingConfigRequest;
import com.google.cloud.channel.v1.CreateCustomerRequest;
import com.google.cloud.channel.v1.CreateEntitlementRequest;
import com.google.cloud.channel.v1.Customer;
import com.google.cloud.channel.v1.CustomerRepricingConfig;
import com.google.cloud.channel.v1.DeleteChannelPartnerRepricingConfigRequest;
import com.google.cloud.channel.v1.DeleteCustomerRepricingConfigRequest;
import com.google.cloud.channel.v1.DeleteCustomerRequest;
import com.google.cloud.channel.v1.Entitlement;
import com.google.cloud.channel.v1.GetChannelPartnerLinkRequest;
import com.google.cloud.channel.v1.GetChannelPartnerRepricingConfigRequest;
import com.google.cloud.channel.v1.GetCustomerRepricingConfigRequest;
import com.google.cloud.channel.v1.GetCustomerRequest;
import com.google.cloud.channel.v1.GetEntitlementRequest;
import com.google.cloud.channel.v1.ImportCustomerRequest;
import com.google.cloud.channel.v1.ListChannelPartnerLinksRequest;
import com.google.cloud.channel.v1.ListChannelPartnerLinksResponse;
import com.google.cloud.channel.v1.ListChannelPartnerRepricingConfigsRequest;
import com.google.cloud.channel.v1.ListChannelPartnerRepricingConfigsResponse;
import com.google.cloud.channel.v1.ListCustomerRepricingConfigsRequest;
import com.google.cloud.channel.v1.ListCustomerRepricingConfigsResponse;
import com.google.cloud.channel.v1.ListCustomersRequest;
import com.google.cloud.channel.v1.ListCustomersResponse;
import com.google.cloud.channel.v1.ListEntitlementsRequest;
import com.google.cloud.channel.v1.ListEntitlementsResponse;
import com.google.cloud.channel.v1.ListOffersRequest;
import com.google.cloud.channel.v1.ListOffersResponse;
import com.google.cloud.channel.v1.ListProductsRequest;
import com.google.cloud.channel.v1.ListProductsResponse;
import com.google.cloud.channel.v1.ListPurchasableOffersRequest;
import com.google.cloud.channel.v1.ListPurchasableOffersResponse;
import com.google.cloud.channel.v1.ListPurchasableSkusRequest;
import com.google.cloud.channel.v1.ListPurchasableSkusResponse;
import com.google.cloud.channel.v1.ListSkusRequest;
import com.google.cloud.channel.v1.ListSkusResponse;
import com.google.cloud.channel.v1.ListSubscribersRequest;
import com.google.cloud.channel.v1.ListSubscribersResponse;
import com.google.cloud.channel.v1.ListTransferableOffersRequest;
import com.google.cloud.channel.v1.ListTransferableOffersResponse;
import com.google.cloud.channel.v1.ListTransferableSkusRequest;
import com.google.cloud.channel.v1.ListTransferableSkusResponse;
import com.google.cloud.channel.v1.LookupOfferRequest;
import com.google.cloud.channel.v1.Offer;
import com.google.cloud.channel.v1.OperationMetadata;
import com.google.cloud.channel.v1.ProvisionCloudIdentityRequest;
import com.google.cloud.channel.v1.RegisterSubscriberRequest;
import com.google.cloud.channel.v1.RegisterSubscriberResponse;
import com.google.cloud.channel.v1.StartPaidServiceRequest;
import com.google.cloud.channel.v1.SuspendEntitlementRequest;
import com.google.cloud.channel.v1.TransferEntitlementsRequest;
import com.google.cloud.channel.v1.TransferEntitlementsResponse;
import com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest;
import com.google.cloud.channel.v1.UnregisterSubscriberRequest;
import com.google.cloud.channel.v1.UnregisterSubscriberResponse;
import com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest;
import com.google.cloud.channel.v1.UpdateChannelPartnerRepricingConfigRequest;
import com.google.cloud.channel.v1.UpdateCustomerRepricingConfigRequest;
import com.google.cloud.channel.v1.UpdateCustomerRequest;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the CloudChannelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCloudChannelServiceStub extends CloudChannelServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(TransferEntitlementsResponse.getDescriptor())
          .add(Entitlement.getDescriptor())
          .add(Empty.getDescriptor())
          .add(Customer.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListCustomersRequest, ListCustomersResponse>
      listCustomersMethodDescriptor =
          ApiMethodDescriptor.<ListCustomersRequest, ListCustomersResponse>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListCustomers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}/customers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=accounts/*/channelPartnerLinks/*}/customers")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCustomersResponse>newBuilder()
                      .setDefaultInstance(ListCustomersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCustomerRequest, Customer>
      getCustomerMethodDescriptor =
          ApiMethodDescriptor.<GetCustomerRequest, Customer>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/GetCustomer")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/customers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=accounts/*/channelPartnerLinks/*/customers/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Customer>newBuilder()
                      .setDefaultInstance(Customer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
      checkCloudIdentityAccountsExistMethodDescriptor =
          ApiMethodDescriptor
              .<CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/CheckCloudIdentityAccountsExist")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CheckCloudIdentityAccountsExistRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}:checkCloudIdentityAccountsExist",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CheckCloudIdentityAccountsExistRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CheckCloudIdentityAccountsExistRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CheckCloudIdentityAccountsExistResponse>newBuilder()
                      .setDefaultInstance(
                          CheckCloudIdentityAccountsExistResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCustomerRequest, Customer>
      createCustomerMethodDescriptor =
          ApiMethodDescriptor.<CreateCustomerRequest, Customer>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/CreateCustomer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomerRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}/customers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=accounts/*/channelPartnerLinks/*}/customers")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customer", request.getCustomer(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Customer>newBuilder()
                      .setDefaultInstance(Customer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCustomerRequest, Customer>
      updateCustomerMethodDescriptor =
          ApiMethodDescriptor.<UpdateCustomerRequest, Customer>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/UpdateCustomer")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomerRequest>newBuilder()
                      .setPath(
                          "/v1/{customer.name=accounts/*/customers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "customer.name", request.getCustomer().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{customer.name=accounts/*/channelPartnerLinks/*/customers/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("customer", request.getCustomer(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Customer>newBuilder()
                      .setDefaultInstance(Customer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCustomerRequest, Empty>
      deleteCustomerMethodDescriptor =
          ApiMethodDescriptor.<DeleteCustomerRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/DeleteCustomer")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCustomerRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/customers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=accounts/*/channelPartnerLinks/*/customers/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCustomerRequest> serializer =
                                ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<ImportCustomerRequest, Customer>
      importCustomerMethodDescriptor =
          ApiMethodDescriptor.<ImportCustomerRequest, Customer>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ImportCustomer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportCustomerRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}/customers:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=accounts/*/channelPartnerLinks/*}/customers:import")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Customer>newBuilder()
                      .setDefaultInstance(Customer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ProvisionCloudIdentityRequest, Operation>
      provisionCloudIdentityMethodDescriptor =
          ApiMethodDescriptor.<ProvisionCloudIdentityRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ProvisionCloudIdentity")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ProvisionCloudIdentityRequest>newBuilder()
                      .setPath(
                          "/v1/{customer=accounts/*/customers/*}:provisionCloudIdentity",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ProvisionCloudIdentityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "customer", request.getCustomer());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ProvisionCloudIdentityRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearCustomer().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ProvisionCloudIdentityRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsMethodDescriptor =
          ApiMethodDescriptor.<ListEntitlementsRequest, ListEntitlementsResponse>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListEntitlements")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEntitlementsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*/customers/*}/entitlements",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntitlementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEntitlementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEntitlementsResponse>newBuilder()
                      .setDefaultInstance(ListEntitlementsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListTransferableSkusRequest, ListTransferableSkusResponse>
      listTransferableSkusMethodDescriptor =
          ApiMethodDescriptor
              .<ListTransferableSkusRequest, ListTransferableSkusResponse>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListTransferableSkus")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTransferableSkusRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}:listTransferableSkus",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTransferableSkusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTransferableSkusRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTransferableSkusResponse>newBuilder()
                      .setDefaultInstance(ListTransferableSkusResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListTransferableOffersRequest, ListTransferableOffersResponse>
      listTransferableOffersMethodDescriptor =
          ApiMethodDescriptor
              .<ListTransferableOffersRequest, ListTransferableOffersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ListTransferableOffers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTransferableOffersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}:listTransferableOffers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTransferableOffersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTransferableOffersRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTransferableOffersResponse>newBuilder()
                      .setDefaultInstance(ListTransferableOffersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEntitlementRequest, Entitlement>
      getEntitlementMethodDescriptor =
          ApiMethodDescriptor.<GetEntitlementRequest, Entitlement>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/GetEntitlement")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEntitlementRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/customers/*/entitlements/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Entitlement>newBuilder()
                      .setDefaultInstance(Entitlement.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateEntitlementRequest, Operation>
      createEntitlementMethodDescriptor =
          ApiMethodDescriptor.<CreateEntitlementRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/CreateEntitlement")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEntitlementRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*/customers/*}/entitlements",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEntitlementRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ChangeParametersRequest, Operation>
      changeParametersMethodDescriptor =
          ApiMethodDescriptor.<ChangeParametersRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ChangeParameters")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ChangeParametersRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/customers/*/entitlements/*}:changeParameters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ChangeParametersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ChangeParametersRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ChangeParametersRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ChangeRenewalSettingsRequest, Operation>
      changeRenewalSettingsMethodDescriptor =
          ApiMethodDescriptor.<ChangeRenewalSettingsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ChangeRenewalSettings")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ChangeRenewalSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/customers/*/entitlements/*}:changeRenewalSettings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ChangeRenewalSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ChangeRenewalSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ChangeRenewalSettingsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ChangeOfferRequest, Operation>
      changeOfferMethodDescriptor =
          ApiMethodDescriptor.<ChangeOfferRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ChangeOffer")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ChangeOfferRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/customers/*/entitlements/*}:changeOffer",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ChangeOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ChangeOfferRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ChangeOfferRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StartPaidServiceRequest, Operation>
      startPaidServiceMethodDescriptor =
          ApiMethodDescriptor.<StartPaidServiceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/StartPaidService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartPaidServiceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/customers/*/entitlements/*}:startPaidService",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartPaidServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartPaidServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (StartPaidServiceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<SuspendEntitlementRequest, Operation>
      suspendEntitlementMethodDescriptor =
          ApiMethodDescriptor.<SuspendEntitlementRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/SuspendEntitlement")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SuspendEntitlementRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/customers/*/entitlements/*}:suspend",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SuspendEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SuspendEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SuspendEntitlementRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CancelEntitlementRequest, Operation>
      cancelEntitlementMethodDescriptor =
          ApiMethodDescriptor.<CancelEntitlementRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/CancelEntitlement")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CancelEntitlementRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/customers/*/entitlements/*}:cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CancelEntitlementRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ActivateEntitlementRequest, Operation>
      activateEntitlementMethodDescriptor =
          ApiMethodDescriptor.<ActivateEntitlementRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ActivateEntitlement")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ActivateEntitlementRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/customers/*/entitlements/*}:activate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ActivateEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ActivateEntitlementRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ActivateEntitlementRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<TransferEntitlementsRequest, Operation>
      transferEntitlementsMethodDescriptor =
          ApiMethodDescriptor.<TransferEntitlementsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/TransferEntitlements")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferEntitlementsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*/customers/*}:transferEntitlements",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferEntitlementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferEntitlementsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (TransferEntitlementsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<TransferEntitlementsToGoogleRequest, Operation>
      transferEntitlementsToGoogleMethodDescriptor =
          ApiMethodDescriptor.<TransferEntitlementsToGoogleRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/TransferEntitlementsToGoogle")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TransferEntitlementsToGoogleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*/customers/*}:transferEntitlementsToGoogle",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TransferEntitlementsToGoogleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TransferEntitlementsToGoogleRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (TransferEntitlementsToGoogleRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>
      listChannelPartnerLinksMethodDescriptor =
          ApiMethodDescriptor
              .<ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ListChannelPartnerLinks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListChannelPartnerLinksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}/channelPartnerLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListChannelPartnerLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListChannelPartnerLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListChannelPartnerLinksResponse>newBuilder()
                      .setDefaultInstance(ListChannelPartnerLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetChannelPartnerLinkRequest, ChannelPartnerLink>
      getChannelPartnerLinkMethodDescriptor =
          ApiMethodDescriptor.<GetChannelPartnerLinkRequest, ChannelPartnerLink>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/GetChannelPartnerLink")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetChannelPartnerLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/channelPartnerLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetChannelPartnerLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetChannelPartnerLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChannelPartnerLink>newBuilder()
                      .setDefaultInstance(ChannelPartnerLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateChannelPartnerLinkRequest, ChannelPartnerLink>
      createChannelPartnerLinkMethodDescriptor =
          ApiMethodDescriptor.<CreateChannelPartnerLinkRequest, ChannelPartnerLink>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/CreateChannelPartnerLink")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateChannelPartnerLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}/channelPartnerLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChannelPartnerLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChannelPartnerLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "channelPartnerLink", request.getChannelPartnerLink(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChannelPartnerLink>newBuilder()
                      .setDefaultInstance(ChannelPartnerLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>
      updateChannelPartnerLinkMethodDescriptor =
          ApiMethodDescriptor.<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/UpdateChannelPartnerLink")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateChannelPartnerLinkRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/channelPartnerLinks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateChannelPartnerLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateChannelPartnerLinkRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChannelPartnerLink>newBuilder()
                      .setDefaultInstance(ChannelPartnerLink.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetCustomerRepricingConfigRequest, CustomerRepricingConfig>
      getCustomerRepricingConfigMethodDescriptor =
          ApiMethodDescriptor
              .<GetCustomerRepricingConfigRequest, CustomerRepricingConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/GetCustomerRepricingConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomerRepricingConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/customers/*/customerRepricingConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomerRepricingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomerRepricingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomerRepricingConfig>newBuilder()
                      .setDefaultInstance(CustomerRepricingConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsResponse>
      listCustomerRepricingConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ListCustomerRepricingConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomerRepricingConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*/customers/*}/customerRepricingConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomerRepricingConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomerRepricingConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCustomerRepricingConfigsResponse>newBuilder()
                      .setDefaultInstance(ListCustomerRepricingConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>
      createCustomerRepricingConfigMethodDescriptor =
          ApiMethodDescriptor
              .<CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/CreateCustomerRepricingConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCustomerRepricingConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*/customers/*}/customerRepricingConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomerRepricingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCustomerRepricingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "customerRepricingConfig",
                                      request.getCustomerRepricingConfig(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomerRepricingConfig>newBuilder()
                      .setDefaultInstance(CustomerRepricingConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>
      updateCustomerRepricingConfigMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/UpdateCustomerRepricingConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCustomerRepricingConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{customerRepricingConfig.name=accounts/*/customers/*/customerRepricingConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomerRepricingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "customerRepricingConfig.name",
                                request.getCustomerRepricingConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCustomerRepricingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "customerRepricingConfig",
                                      request.getCustomerRepricingConfig(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CustomerRepricingConfig>newBuilder()
                      .setDefaultInstance(CustomerRepricingConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCustomerRepricingConfigRequest, Empty>
      deleteCustomerRepricingConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteCustomerRepricingConfigRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/DeleteCustomerRepricingConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCustomerRepricingConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/customers/*/customerRepricingConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCustomerRepricingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCustomerRepricingConfigRequest> serializer =
                                ProtoRestSerializer.create();
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
          GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      getChannelPartnerRepricingConfigMethodDescriptor =
          ApiMethodDescriptor
              .<GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/GetChannelPartnerRepricingConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetChannelPartnerRepricingConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/channelPartnerLinks/*/channelPartnerRepricingConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetChannelPartnerRepricingConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetChannelPartnerRepricingConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChannelPartnerRepricingConfig>newBuilder()
                      .setDefaultInstance(ChannelPartnerRepricingConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListChannelPartnerRepricingConfigsRequest, ListChannelPartnerRepricingConfigsResponse>
      listChannelPartnerRepricingConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListChannelPartnerRepricingConfigsRequest,
                  ListChannelPartnerRepricingConfigsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ListChannelPartnerRepricingConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListChannelPartnerRepricingConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*/channelPartnerLinks/*}/channelPartnerRepricingConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListChannelPartnerRepricingConfigsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListChannelPartnerRepricingConfigsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListChannelPartnerRepricingConfigsResponse>newBuilder()
                      .setDefaultInstance(
                          ListChannelPartnerRepricingConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      createChannelPartnerRepricingConfigMethodDescriptor =
          ApiMethodDescriptor
              .<CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/CreateChannelPartnerRepricingConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateChannelPartnerRepricingConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*/channelPartnerLinks/*}/channelPartnerRepricingConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChannelPartnerRepricingConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateChannelPartnerRepricingConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "channelPartnerRepricingConfig",
                                      request.getChannelPartnerRepricingConfig(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChannelPartnerRepricingConfig>newBuilder()
                      .setDefaultInstance(ChannelPartnerRepricingConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      updateChannelPartnerRepricingConfigMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/UpdateChannelPartnerRepricingConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateChannelPartnerRepricingConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{channelPartnerRepricingConfig.name=accounts/*/channelPartnerLinks/*/channelPartnerRepricingConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateChannelPartnerRepricingConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "channelPartnerRepricingConfig.name",
                                request.getChannelPartnerRepricingConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateChannelPartnerRepricingConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "channelPartnerRepricingConfig",
                                      request.getChannelPartnerRepricingConfig(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ChannelPartnerRepricingConfig>newBuilder()
                      .setDefaultInstance(ChannelPartnerRepricingConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteChannelPartnerRepricingConfigRequest, Empty>
      deleteChannelPartnerRepricingConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteChannelPartnerRepricingConfigRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/DeleteChannelPartnerRepricingConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteChannelPartnerRepricingConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=accounts/*/channelPartnerLinks/*/channelPartnerRepricingConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteChannelPartnerRepricingConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteChannelPartnerRepricingConfigRequest>
                                serializer = ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<LookupOfferRequest, Offer> lookupOfferMethodDescriptor =
      ApiMethodDescriptor.<LookupOfferRequest, Offer>newBuilder()
          .setFullMethodName("google.cloud.channel.v1.CloudChannelService/LookupOffer")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<LookupOfferRequest>newBuilder()
                  .setPath(
                      "/v1/{entitlement=accounts/*/customers/*/entitlements/*}:lookupOffer",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<LookupOfferRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "entitlement", request.getEntitlement());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<LookupOfferRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Offer>newBuilder()
                  .setDefaultInstance(Offer.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListProductsRequest, ListProductsResponse>
      listProductsMethodDescriptor =
          ApiMethodDescriptor.<ListProductsRequest, ListProductsResponse>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListProducts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProductsRequest>newBuilder()
                      .setPath(
                          "/v1/products",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "account", request.getAccount());
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProductsResponse>newBuilder()
                      .setDefaultInstance(ListProductsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSkusRequest, ListSkusResponse>
      listSkusMethodDescriptor =
          ApiMethodDescriptor.<ListSkusRequest, ListSkusResponse>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListSkus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSkusRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=products/*}/skus",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSkusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSkusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "account", request.getAccount());
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSkusResponse>newBuilder()
                      .setDefaultInstance(ListSkusResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListOffersRequest, ListOffersResponse>
      listOffersMethodDescriptor =
          ApiMethodDescriptor.<ListOffersRequest, ListOffersResponse>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListOffers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOffersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=accounts/*}/offers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOffersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOffersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOffersResponse>newBuilder()
                      .setDefaultInstance(ListOffersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPurchasableSkusRequest, ListPurchasableSkusResponse>
      listPurchasableSkusMethodDescriptor =
          ApiMethodDescriptor.<ListPurchasableSkusRequest, ListPurchasableSkusResponse>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListPurchasableSkus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPurchasableSkusRequest>newBuilder()
                      .setPath(
                          "/v1/{customer=accounts/*/customers/*}:listPurchasableSkus",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPurchasableSkusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "customer", request.getCustomer());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPurchasableSkusRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "changeOfferPurchase", request.getChangeOfferPurchase());
                            serializer.putQueryParam(
                                fields,
                                "createEntitlementPurchase",
                                request.getCreateEntitlementPurchase());
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPurchasableSkusResponse>newBuilder()
                      .setDefaultInstance(ListPurchasableSkusResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPurchasableOffersRequest, ListPurchasableOffersResponse>
      listPurchasableOffersMethodDescriptor =
          ApiMethodDescriptor
              .<ListPurchasableOffersRequest, ListPurchasableOffersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ListPurchasableOffers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPurchasableOffersRequest>newBuilder()
                      .setPath(
                          "/v1/{customer=accounts/*/customers/*}:listPurchasableOffers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPurchasableOffersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "customer", request.getCustomer());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPurchasableOffersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "changeOfferPurchase", request.getChangeOfferPurchase());
                            serializer.putQueryParam(
                                fields,
                                "createEntitlementPurchase",
                                request.getCreateEntitlementPurchase());
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPurchasableOffersResponse>newBuilder()
                      .setDefaultInstance(ListPurchasableOffersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RegisterSubscriberRequest, RegisterSubscriberResponse>
      registerSubscriberMethodDescriptor =
          ApiMethodDescriptor.<RegisterSubscriberRequest, RegisterSubscriberResponse>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/RegisterSubscriber")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RegisterSubscriberRequest>newBuilder()
                      .setPath(
                          "/v1/{account=accounts/*}:register",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RegisterSubscriberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "account", request.getAccount());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RegisterSubscriberRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearAccount().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RegisterSubscriberResponse>newBuilder()
                      .setDefaultInstance(RegisterSubscriberResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UnregisterSubscriberRequest, UnregisterSubscriberResponse>
      unregisterSubscriberMethodDescriptor =
          ApiMethodDescriptor
              .<UnregisterSubscriberRequest, UnregisterSubscriberResponse>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/UnregisterSubscriber")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UnregisterSubscriberRequest>newBuilder()
                      .setPath(
                          "/v1/{account=accounts/*}:unregister",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UnregisterSubscriberRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "account", request.getAccount());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UnregisterSubscriberRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearAccount().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UnregisterSubscriberResponse>newBuilder()
                      .setDefaultInstance(UnregisterSubscriberResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSubscribersRequest, ListSubscribersResponse>
      listSubscribersMethodDescriptor =
          ApiMethodDescriptor.<ListSubscribersRequest, ListSubscribersResponse>newBuilder()
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListSubscribers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSubscribersRequest>newBuilder()
                      .setPath(
                          "/v1/{account=accounts/*}:listSubscribers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubscribersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "account", request.getAccount());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSubscribersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSubscribersResponse>newBuilder()
                      .setDefaultInstance(ListSubscribersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListCustomersRequest, ListCustomersResponse> listCustomersCallable;
  private final UnaryCallable<ListCustomersRequest, ListCustomersPagedResponse>
      listCustomersPagedCallable;
  private final UnaryCallable<GetCustomerRequest, Customer> getCustomerCallable;
  private final UnaryCallable<
          CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
      checkCloudIdentityAccountsExistCallable;
  private final UnaryCallable<CreateCustomerRequest, Customer> createCustomerCallable;
  private final UnaryCallable<UpdateCustomerRequest, Customer> updateCustomerCallable;
  private final UnaryCallable<DeleteCustomerRequest, Empty> deleteCustomerCallable;
  private final UnaryCallable<ImportCustomerRequest, Customer> importCustomerCallable;
  private final UnaryCallable<ProvisionCloudIdentityRequest, Operation>
      provisionCloudIdentityCallable;
  private final OperationCallable<ProvisionCloudIdentityRequest, Customer, OperationMetadata>
      provisionCloudIdentityOperationCallable;
  private final UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable;
  private final UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable;
  private final UnaryCallable<ListTransferableSkusRequest, ListTransferableSkusResponse>
      listTransferableSkusCallable;
  private final UnaryCallable<ListTransferableSkusRequest, ListTransferableSkusPagedResponse>
      listTransferableSkusPagedCallable;
  private final UnaryCallable<ListTransferableOffersRequest, ListTransferableOffersResponse>
      listTransferableOffersCallable;
  private final UnaryCallable<ListTransferableOffersRequest, ListTransferableOffersPagedResponse>
      listTransferableOffersPagedCallable;
  private final UnaryCallable<GetEntitlementRequest, Entitlement> getEntitlementCallable;
  private final UnaryCallable<CreateEntitlementRequest, Operation> createEntitlementCallable;
  private final OperationCallable<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationCallable;
  private final UnaryCallable<ChangeParametersRequest, Operation> changeParametersCallable;
  private final OperationCallable<ChangeParametersRequest, Entitlement, OperationMetadata>
      changeParametersOperationCallable;
  private final UnaryCallable<ChangeRenewalSettingsRequest, Operation>
      changeRenewalSettingsCallable;
  private final OperationCallable<ChangeRenewalSettingsRequest, Entitlement, OperationMetadata>
      changeRenewalSettingsOperationCallable;
  private final UnaryCallable<ChangeOfferRequest, Operation> changeOfferCallable;
  private final OperationCallable<ChangeOfferRequest, Entitlement, OperationMetadata>
      changeOfferOperationCallable;
  private final UnaryCallable<StartPaidServiceRequest, Operation> startPaidServiceCallable;
  private final OperationCallable<StartPaidServiceRequest, Entitlement, OperationMetadata>
      startPaidServiceOperationCallable;
  private final UnaryCallable<SuspendEntitlementRequest, Operation> suspendEntitlementCallable;
  private final OperationCallable<SuspendEntitlementRequest, Entitlement, OperationMetadata>
      suspendEntitlementOperationCallable;
  private final UnaryCallable<CancelEntitlementRequest, Operation> cancelEntitlementCallable;
  private final OperationCallable<CancelEntitlementRequest, Empty, OperationMetadata>
      cancelEntitlementOperationCallable;
  private final UnaryCallable<ActivateEntitlementRequest, Operation> activateEntitlementCallable;
  private final OperationCallable<ActivateEntitlementRequest, Entitlement, OperationMetadata>
      activateEntitlementOperationCallable;
  private final UnaryCallable<TransferEntitlementsRequest, Operation> transferEntitlementsCallable;
  private final OperationCallable<
          TransferEntitlementsRequest, TransferEntitlementsResponse, OperationMetadata>
      transferEntitlementsOperationCallable;
  private final UnaryCallable<TransferEntitlementsToGoogleRequest, Operation>
      transferEntitlementsToGoogleCallable;
  private final OperationCallable<TransferEntitlementsToGoogleRequest, Empty, OperationMetadata>
      transferEntitlementsToGoogleOperationCallable;
  private final UnaryCallable<ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>
      listChannelPartnerLinksCallable;
  private final UnaryCallable<ListChannelPartnerLinksRequest, ListChannelPartnerLinksPagedResponse>
      listChannelPartnerLinksPagedCallable;
  private final UnaryCallable<GetChannelPartnerLinkRequest, ChannelPartnerLink>
      getChannelPartnerLinkCallable;
  private final UnaryCallable<CreateChannelPartnerLinkRequest, ChannelPartnerLink>
      createChannelPartnerLinkCallable;
  private final UnaryCallable<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>
      updateChannelPartnerLinkCallable;
  private final UnaryCallable<GetCustomerRepricingConfigRequest, CustomerRepricingConfig>
      getCustomerRepricingConfigCallable;
  private final UnaryCallable<
          ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsResponse>
      listCustomerRepricingConfigsCallable;
  private final UnaryCallable<
          ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsPagedResponse>
      listCustomerRepricingConfigsPagedCallable;
  private final UnaryCallable<CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>
      createCustomerRepricingConfigCallable;
  private final UnaryCallable<UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>
      updateCustomerRepricingConfigCallable;
  private final UnaryCallable<DeleteCustomerRepricingConfigRequest, Empty>
      deleteCustomerRepricingConfigCallable;
  private final UnaryCallable<
          GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      getChannelPartnerRepricingConfigCallable;
  private final UnaryCallable<
          ListChannelPartnerRepricingConfigsRequest, ListChannelPartnerRepricingConfigsResponse>
      listChannelPartnerRepricingConfigsCallable;
  private final UnaryCallable<
          ListChannelPartnerRepricingConfigsRequest,
          ListChannelPartnerRepricingConfigsPagedResponse>
      listChannelPartnerRepricingConfigsPagedCallable;
  private final UnaryCallable<
          CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      createChannelPartnerRepricingConfigCallable;
  private final UnaryCallable<
          UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      updateChannelPartnerRepricingConfigCallable;
  private final UnaryCallable<DeleteChannelPartnerRepricingConfigRequest, Empty>
      deleteChannelPartnerRepricingConfigCallable;
  private final UnaryCallable<LookupOfferRequest, Offer> lookupOfferCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable;
  private final UnaryCallable<ListProductsRequest, ListProductsPagedResponse>
      listProductsPagedCallable;
  private final UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable;
  private final UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable;
  private final UnaryCallable<ListOffersRequest, ListOffersResponse> listOffersCallable;
  private final UnaryCallable<ListOffersRequest, ListOffersPagedResponse> listOffersPagedCallable;
  private final UnaryCallable<ListPurchasableSkusRequest, ListPurchasableSkusResponse>
      listPurchasableSkusCallable;
  private final UnaryCallable<ListPurchasableSkusRequest, ListPurchasableSkusPagedResponse>
      listPurchasableSkusPagedCallable;
  private final UnaryCallable<ListPurchasableOffersRequest, ListPurchasableOffersResponse>
      listPurchasableOffersCallable;
  private final UnaryCallable<ListPurchasableOffersRequest, ListPurchasableOffersPagedResponse>
      listPurchasableOffersPagedCallable;
  private final UnaryCallable<RegisterSubscriberRequest, RegisterSubscriberResponse>
      registerSubscriberCallable;
  private final UnaryCallable<UnregisterSubscriberRequest, UnregisterSubscriberResponse>
      unregisterSubscriberCallable;
  private final UnaryCallable<ListSubscribersRequest, ListSubscribersResponse>
      listSubscribersCallable;
  private final UnaryCallable<ListSubscribersRequest, ListSubscribersPagedResponse>
      listSubscribersPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudChannelServiceStub create(
      CloudChannelServiceStubSettings settings) throws IOException {
    return new HttpJsonCloudChannelServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudChannelServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudChannelServiceStub(
        CloudChannelServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudChannelServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudChannelServiceStub(
        CloudChannelServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudChannelServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudChannelServiceStub(
      CloudChannelServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCloudChannelServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudChannelServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudChannelServiceStub(
      CloudChannelServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListCustomersRequest, ListCustomersResponse>
        listCustomersTransportSettings =
            HttpJsonCallSettings.<ListCustomersRequest, ListCustomersResponse>newBuilder()
                .setMethodDescriptor(listCustomersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetCustomerRequest, Customer> getCustomerTransportSettings =
        HttpJsonCallSettings.<GetCustomerRequest, Customer>newBuilder()
            .setMethodDescriptor(getCustomerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<
            CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
        checkCloudIdentityAccountsExistTransportSettings =
            HttpJsonCallSettings
                .<CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
                    newBuilder()
                .setMethodDescriptor(checkCloudIdentityAccountsExistMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateCustomerRequest, Customer> createCustomerTransportSettings =
        HttpJsonCallSettings.<CreateCustomerRequest, Customer>newBuilder()
            .setMethodDescriptor(createCustomerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateCustomerRequest, Customer> updateCustomerTransportSettings =
        HttpJsonCallSettings.<UpdateCustomerRequest, Customer>newBuilder()
            .setMethodDescriptor(updateCustomerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteCustomerRequest, Empty> deleteCustomerTransportSettings =
        HttpJsonCallSettings.<DeleteCustomerRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCustomerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ImportCustomerRequest, Customer> importCustomerTransportSettings =
        HttpJsonCallSettings.<ImportCustomerRequest, Customer>newBuilder()
            .setMethodDescriptor(importCustomerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ProvisionCloudIdentityRequest, Operation>
        provisionCloudIdentityTransportSettings =
            HttpJsonCallSettings.<ProvisionCloudIdentityRequest, Operation>newBuilder()
                .setMethodDescriptor(provisionCloudIdentityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListEntitlementsRequest, ListEntitlementsResponse>
        listEntitlementsTransportSettings =
            HttpJsonCallSettings.<ListEntitlementsRequest, ListEntitlementsResponse>newBuilder()
                .setMethodDescriptor(listEntitlementsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListTransferableSkusRequest, ListTransferableSkusResponse>
        listTransferableSkusTransportSettings =
            HttpJsonCallSettings
                .<ListTransferableSkusRequest, ListTransferableSkusResponse>newBuilder()
                .setMethodDescriptor(listTransferableSkusMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListTransferableOffersRequest, ListTransferableOffersResponse>
        listTransferableOffersTransportSettings =
            HttpJsonCallSettings
                .<ListTransferableOffersRequest, ListTransferableOffersResponse>newBuilder()
                .setMethodDescriptor(listTransferableOffersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetEntitlementRequest, Entitlement> getEntitlementTransportSettings =
        HttpJsonCallSettings.<GetEntitlementRequest, Entitlement>newBuilder()
            .setMethodDescriptor(getEntitlementMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateEntitlementRequest, Operation> createEntitlementTransportSettings =
        HttpJsonCallSettings.<CreateEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(createEntitlementMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ChangeParametersRequest, Operation> changeParametersTransportSettings =
        HttpJsonCallSettings.<ChangeParametersRequest, Operation>newBuilder()
            .setMethodDescriptor(changeParametersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ChangeRenewalSettingsRequest, Operation>
        changeRenewalSettingsTransportSettings =
            HttpJsonCallSettings.<ChangeRenewalSettingsRequest, Operation>newBuilder()
                .setMethodDescriptor(changeRenewalSettingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ChangeOfferRequest, Operation> changeOfferTransportSettings =
        HttpJsonCallSettings.<ChangeOfferRequest, Operation>newBuilder()
            .setMethodDescriptor(changeOfferMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StartPaidServiceRequest, Operation> startPaidServiceTransportSettings =
        HttpJsonCallSettings.<StartPaidServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(startPaidServiceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SuspendEntitlementRequest, Operation> suspendEntitlementTransportSettings =
        HttpJsonCallSettings.<SuspendEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(suspendEntitlementMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CancelEntitlementRequest, Operation> cancelEntitlementTransportSettings =
        HttpJsonCallSettings.<CancelEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(cancelEntitlementMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ActivateEntitlementRequest, Operation>
        activateEntitlementTransportSettings =
            HttpJsonCallSettings.<ActivateEntitlementRequest, Operation>newBuilder()
                .setMethodDescriptor(activateEntitlementMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferEntitlementsRequest, Operation>
        transferEntitlementsTransportSettings =
            HttpJsonCallSettings.<TransferEntitlementsRequest, Operation>newBuilder()
                .setMethodDescriptor(transferEntitlementsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<TransferEntitlementsToGoogleRequest, Operation>
        transferEntitlementsToGoogleTransportSettings =
            HttpJsonCallSettings.<TransferEntitlementsToGoogleRequest, Operation>newBuilder()
                .setMethodDescriptor(transferEntitlementsToGoogleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>
        listChannelPartnerLinksTransportSettings =
            HttpJsonCallSettings
                .<ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>newBuilder()
                .setMethodDescriptor(listChannelPartnerLinksMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetChannelPartnerLinkRequest, ChannelPartnerLink>
        getChannelPartnerLinkTransportSettings =
            HttpJsonCallSettings.<GetChannelPartnerLinkRequest, ChannelPartnerLink>newBuilder()
                .setMethodDescriptor(getChannelPartnerLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateChannelPartnerLinkRequest, ChannelPartnerLink>
        createChannelPartnerLinkTransportSettings =
            HttpJsonCallSettings.<CreateChannelPartnerLinkRequest, ChannelPartnerLink>newBuilder()
                .setMethodDescriptor(createChannelPartnerLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>
        updateChannelPartnerLinkTransportSettings =
            HttpJsonCallSettings.<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>newBuilder()
                .setMethodDescriptor(updateChannelPartnerLinkMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetCustomerRepricingConfigRequest, CustomerRepricingConfig>
        getCustomerRepricingConfigTransportSettings =
            HttpJsonCallSettings
                .<GetCustomerRepricingConfigRequest, CustomerRepricingConfig>newBuilder()
                .setMethodDescriptor(getCustomerRepricingConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsResponse>
        listCustomerRepricingConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(listCustomerRepricingConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>
        createCustomerRepricingConfigTransportSettings =
            HttpJsonCallSettings
                .<CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>newBuilder()
                .setMethodDescriptor(createCustomerRepricingConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>
        updateCustomerRepricingConfigTransportSettings =
            HttpJsonCallSettings
                .<UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>newBuilder()
                .setMethodDescriptor(updateCustomerRepricingConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteCustomerRepricingConfigRequest, Empty>
        deleteCustomerRepricingConfigTransportSettings =
            HttpJsonCallSettings.<DeleteCustomerRepricingConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteCustomerRepricingConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
        getChannelPartnerRepricingConfigTransportSettings =
            HttpJsonCallSettings
                .<GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
                    newBuilder()
                .setMethodDescriptor(getChannelPartnerRepricingConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListChannelPartnerRepricingConfigsRequest, ListChannelPartnerRepricingConfigsResponse>
        listChannelPartnerRepricingConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListChannelPartnerRepricingConfigsRequest,
                    ListChannelPartnerRepricingConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(listChannelPartnerRepricingConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
        createChannelPartnerRepricingConfigTransportSettings =
            HttpJsonCallSettings
                .<CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
                    newBuilder()
                .setMethodDescriptor(createChannelPartnerRepricingConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
        updateChannelPartnerRepricingConfigTransportSettings =
            HttpJsonCallSettings
                .<UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
                    newBuilder()
                .setMethodDescriptor(updateChannelPartnerRepricingConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteChannelPartnerRepricingConfigRequest, Empty>
        deleteChannelPartnerRepricingConfigTransportSettings =
            HttpJsonCallSettings.<DeleteChannelPartnerRepricingConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteChannelPartnerRepricingConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<LookupOfferRequest, Offer> lookupOfferTransportSettings =
        HttpJsonCallSettings.<LookupOfferRequest, Offer>newBuilder()
            .setMethodDescriptor(lookupOfferMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListProductsRequest, ListProductsResponse> listProductsTransportSettings =
        HttpJsonCallSettings.<ListProductsRequest, ListProductsResponse>newBuilder()
            .setMethodDescriptor(listProductsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListSkusRequest, ListSkusResponse> listSkusTransportSettings =
        HttpJsonCallSettings.<ListSkusRequest, ListSkusResponse>newBuilder()
            .setMethodDescriptor(listSkusMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListOffersRequest, ListOffersResponse> listOffersTransportSettings =
        HttpJsonCallSettings.<ListOffersRequest, ListOffersResponse>newBuilder()
            .setMethodDescriptor(listOffersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListPurchasableSkusRequest, ListPurchasableSkusResponse>
        listPurchasableSkusTransportSettings =
            HttpJsonCallSettings
                .<ListPurchasableSkusRequest, ListPurchasableSkusResponse>newBuilder()
                .setMethodDescriptor(listPurchasableSkusMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListPurchasableOffersRequest, ListPurchasableOffersResponse>
        listPurchasableOffersTransportSettings =
            HttpJsonCallSettings
                .<ListPurchasableOffersRequest, ListPurchasableOffersResponse>newBuilder()
                .setMethodDescriptor(listPurchasableOffersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RegisterSubscriberRequest, RegisterSubscriberResponse>
        registerSubscriberTransportSettings =
            HttpJsonCallSettings.<RegisterSubscriberRequest, RegisterSubscriberResponse>newBuilder()
                .setMethodDescriptor(registerSubscriberMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UnregisterSubscriberRequest, UnregisterSubscriberResponse>
        unregisterSubscriberTransportSettings =
            HttpJsonCallSettings
                .<UnregisterSubscriberRequest, UnregisterSubscriberResponse>newBuilder()
                .setMethodDescriptor(unregisterSubscriberMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListSubscribersRequest, ListSubscribersResponse>
        listSubscribersTransportSettings =
            HttpJsonCallSettings.<ListSubscribersRequest, ListSubscribersResponse>newBuilder()
                .setMethodDescriptor(listSubscribersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listCustomersCallable =
        callableFactory.createUnaryCallable(
            listCustomersTransportSettings, settings.listCustomersSettings(), clientContext);
    this.listCustomersPagedCallable =
        callableFactory.createPagedCallable(
            listCustomersTransportSettings, settings.listCustomersSettings(), clientContext);
    this.getCustomerCallable =
        callableFactory.createUnaryCallable(
            getCustomerTransportSettings, settings.getCustomerSettings(), clientContext);
    this.checkCloudIdentityAccountsExistCallable =
        callableFactory.createUnaryCallable(
            checkCloudIdentityAccountsExistTransportSettings,
            settings.checkCloudIdentityAccountsExistSettings(),
            clientContext);
    this.createCustomerCallable =
        callableFactory.createUnaryCallable(
            createCustomerTransportSettings, settings.createCustomerSettings(), clientContext);
    this.updateCustomerCallable =
        callableFactory.createUnaryCallable(
            updateCustomerTransportSettings, settings.updateCustomerSettings(), clientContext);
    this.deleteCustomerCallable =
        callableFactory.createUnaryCallable(
            deleteCustomerTransportSettings, settings.deleteCustomerSettings(), clientContext);
    this.importCustomerCallable =
        callableFactory.createUnaryCallable(
            importCustomerTransportSettings, settings.importCustomerSettings(), clientContext);
    this.provisionCloudIdentityCallable =
        callableFactory.createUnaryCallable(
            provisionCloudIdentityTransportSettings,
            settings.provisionCloudIdentitySettings(),
            clientContext);
    this.provisionCloudIdentityOperationCallable =
        callableFactory.createOperationCallable(
            provisionCloudIdentityTransportSettings,
            settings.provisionCloudIdentityOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listEntitlementsCallable =
        callableFactory.createUnaryCallable(
            listEntitlementsTransportSettings, settings.listEntitlementsSettings(), clientContext);
    this.listEntitlementsPagedCallable =
        callableFactory.createPagedCallable(
            listEntitlementsTransportSettings, settings.listEntitlementsSettings(), clientContext);
    this.listTransferableSkusCallable =
        callableFactory.createUnaryCallable(
            listTransferableSkusTransportSettings,
            settings.listTransferableSkusSettings(),
            clientContext);
    this.listTransferableSkusPagedCallable =
        callableFactory.createPagedCallable(
            listTransferableSkusTransportSettings,
            settings.listTransferableSkusSettings(),
            clientContext);
    this.listTransferableOffersCallable =
        callableFactory.createUnaryCallable(
            listTransferableOffersTransportSettings,
            settings.listTransferableOffersSettings(),
            clientContext);
    this.listTransferableOffersPagedCallable =
        callableFactory.createPagedCallable(
            listTransferableOffersTransportSettings,
            settings.listTransferableOffersSettings(),
            clientContext);
    this.getEntitlementCallable =
        callableFactory.createUnaryCallable(
            getEntitlementTransportSettings, settings.getEntitlementSettings(), clientContext);
    this.createEntitlementCallable =
        callableFactory.createUnaryCallable(
            createEntitlementTransportSettings,
            settings.createEntitlementSettings(),
            clientContext);
    this.createEntitlementOperationCallable =
        callableFactory.createOperationCallable(
            createEntitlementTransportSettings,
            settings.createEntitlementOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.changeParametersCallable =
        callableFactory.createUnaryCallable(
            changeParametersTransportSettings, settings.changeParametersSettings(), clientContext);
    this.changeParametersOperationCallable =
        callableFactory.createOperationCallable(
            changeParametersTransportSettings,
            settings.changeParametersOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.changeRenewalSettingsCallable =
        callableFactory.createUnaryCallable(
            changeRenewalSettingsTransportSettings,
            settings.changeRenewalSettingsSettings(),
            clientContext);
    this.changeRenewalSettingsOperationCallable =
        callableFactory.createOperationCallable(
            changeRenewalSettingsTransportSettings,
            settings.changeRenewalSettingsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.changeOfferCallable =
        callableFactory.createUnaryCallable(
            changeOfferTransportSettings, settings.changeOfferSettings(), clientContext);
    this.changeOfferOperationCallable =
        callableFactory.createOperationCallable(
            changeOfferTransportSettings,
            settings.changeOfferOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.startPaidServiceCallable =
        callableFactory.createUnaryCallable(
            startPaidServiceTransportSettings, settings.startPaidServiceSettings(), clientContext);
    this.startPaidServiceOperationCallable =
        callableFactory.createOperationCallable(
            startPaidServiceTransportSettings,
            settings.startPaidServiceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.suspendEntitlementCallable =
        callableFactory.createUnaryCallable(
            suspendEntitlementTransportSettings,
            settings.suspendEntitlementSettings(),
            clientContext);
    this.suspendEntitlementOperationCallable =
        callableFactory.createOperationCallable(
            suspendEntitlementTransportSettings,
            settings.suspendEntitlementOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.cancelEntitlementCallable =
        callableFactory.createUnaryCallable(
            cancelEntitlementTransportSettings,
            settings.cancelEntitlementSettings(),
            clientContext);
    this.cancelEntitlementOperationCallable =
        callableFactory.createOperationCallable(
            cancelEntitlementTransportSettings,
            settings.cancelEntitlementOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.activateEntitlementCallable =
        callableFactory.createUnaryCallable(
            activateEntitlementTransportSettings,
            settings.activateEntitlementSettings(),
            clientContext);
    this.activateEntitlementOperationCallable =
        callableFactory.createOperationCallable(
            activateEntitlementTransportSettings,
            settings.activateEntitlementOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.transferEntitlementsCallable =
        callableFactory.createUnaryCallable(
            transferEntitlementsTransportSettings,
            settings.transferEntitlementsSettings(),
            clientContext);
    this.transferEntitlementsOperationCallable =
        callableFactory.createOperationCallable(
            transferEntitlementsTransportSettings,
            settings.transferEntitlementsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.transferEntitlementsToGoogleCallable =
        callableFactory.createUnaryCallable(
            transferEntitlementsToGoogleTransportSettings,
            settings.transferEntitlementsToGoogleSettings(),
            clientContext);
    this.transferEntitlementsToGoogleOperationCallable =
        callableFactory.createOperationCallable(
            transferEntitlementsToGoogleTransportSettings,
            settings.transferEntitlementsToGoogleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listChannelPartnerLinksCallable =
        callableFactory.createUnaryCallable(
            listChannelPartnerLinksTransportSettings,
            settings.listChannelPartnerLinksSettings(),
            clientContext);
    this.listChannelPartnerLinksPagedCallable =
        callableFactory.createPagedCallable(
            listChannelPartnerLinksTransportSettings,
            settings.listChannelPartnerLinksSettings(),
            clientContext);
    this.getChannelPartnerLinkCallable =
        callableFactory.createUnaryCallable(
            getChannelPartnerLinkTransportSettings,
            settings.getChannelPartnerLinkSettings(),
            clientContext);
    this.createChannelPartnerLinkCallable =
        callableFactory.createUnaryCallable(
            createChannelPartnerLinkTransportSettings,
            settings.createChannelPartnerLinkSettings(),
            clientContext);
    this.updateChannelPartnerLinkCallable =
        callableFactory.createUnaryCallable(
            updateChannelPartnerLinkTransportSettings,
            settings.updateChannelPartnerLinkSettings(),
            clientContext);
    this.getCustomerRepricingConfigCallable =
        callableFactory.createUnaryCallable(
            getCustomerRepricingConfigTransportSettings,
            settings.getCustomerRepricingConfigSettings(),
            clientContext);
    this.listCustomerRepricingConfigsCallable =
        callableFactory.createUnaryCallable(
            listCustomerRepricingConfigsTransportSettings,
            settings.listCustomerRepricingConfigsSettings(),
            clientContext);
    this.listCustomerRepricingConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listCustomerRepricingConfigsTransportSettings,
            settings.listCustomerRepricingConfigsSettings(),
            clientContext);
    this.createCustomerRepricingConfigCallable =
        callableFactory.createUnaryCallable(
            createCustomerRepricingConfigTransportSettings,
            settings.createCustomerRepricingConfigSettings(),
            clientContext);
    this.updateCustomerRepricingConfigCallable =
        callableFactory.createUnaryCallable(
            updateCustomerRepricingConfigTransportSettings,
            settings.updateCustomerRepricingConfigSettings(),
            clientContext);
    this.deleteCustomerRepricingConfigCallable =
        callableFactory.createUnaryCallable(
            deleteCustomerRepricingConfigTransportSettings,
            settings.deleteCustomerRepricingConfigSettings(),
            clientContext);
    this.getChannelPartnerRepricingConfigCallable =
        callableFactory.createUnaryCallable(
            getChannelPartnerRepricingConfigTransportSettings,
            settings.getChannelPartnerRepricingConfigSettings(),
            clientContext);
    this.listChannelPartnerRepricingConfigsCallable =
        callableFactory.createUnaryCallable(
            listChannelPartnerRepricingConfigsTransportSettings,
            settings.listChannelPartnerRepricingConfigsSettings(),
            clientContext);
    this.listChannelPartnerRepricingConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listChannelPartnerRepricingConfigsTransportSettings,
            settings.listChannelPartnerRepricingConfigsSettings(),
            clientContext);
    this.createChannelPartnerRepricingConfigCallable =
        callableFactory.createUnaryCallable(
            createChannelPartnerRepricingConfigTransportSettings,
            settings.createChannelPartnerRepricingConfigSettings(),
            clientContext);
    this.updateChannelPartnerRepricingConfigCallable =
        callableFactory.createUnaryCallable(
            updateChannelPartnerRepricingConfigTransportSettings,
            settings.updateChannelPartnerRepricingConfigSettings(),
            clientContext);
    this.deleteChannelPartnerRepricingConfigCallable =
        callableFactory.createUnaryCallable(
            deleteChannelPartnerRepricingConfigTransportSettings,
            settings.deleteChannelPartnerRepricingConfigSettings(),
            clientContext);
    this.lookupOfferCallable =
        callableFactory.createUnaryCallable(
            lookupOfferTransportSettings, settings.lookupOfferSettings(), clientContext);
    this.listProductsCallable =
        callableFactory.createUnaryCallable(
            listProductsTransportSettings, settings.listProductsSettings(), clientContext);
    this.listProductsPagedCallable =
        callableFactory.createPagedCallable(
            listProductsTransportSettings, settings.listProductsSettings(), clientContext);
    this.listSkusCallable =
        callableFactory.createUnaryCallable(
            listSkusTransportSettings, settings.listSkusSettings(), clientContext);
    this.listSkusPagedCallable =
        callableFactory.createPagedCallable(
            listSkusTransportSettings, settings.listSkusSettings(), clientContext);
    this.listOffersCallable =
        callableFactory.createUnaryCallable(
            listOffersTransportSettings, settings.listOffersSettings(), clientContext);
    this.listOffersPagedCallable =
        callableFactory.createPagedCallable(
            listOffersTransportSettings, settings.listOffersSettings(), clientContext);
    this.listPurchasableSkusCallable =
        callableFactory.createUnaryCallable(
            listPurchasableSkusTransportSettings,
            settings.listPurchasableSkusSettings(),
            clientContext);
    this.listPurchasableSkusPagedCallable =
        callableFactory.createPagedCallable(
            listPurchasableSkusTransportSettings,
            settings.listPurchasableSkusSettings(),
            clientContext);
    this.listPurchasableOffersCallable =
        callableFactory.createUnaryCallable(
            listPurchasableOffersTransportSettings,
            settings.listPurchasableOffersSettings(),
            clientContext);
    this.listPurchasableOffersPagedCallable =
        callableFactory.createPagedCallable(
            listPurchasableOffersTransportSettings,
            settings.listPurchasableOffersSettings(),
            clientContext);
    this.registerSubscriberCallable =
        callableFactory.createUnaryCallable(
            registerSubscriberTransportSettings,
            settings.registerSubscriberSettings(),
            clientContext);
    this.unregisterSubscriberCallable =
        callableFactory.createUnaryCallable(
            unregisterSubscriberTransportSettings,
            settings.unregisterSubscriberSettings(),
            clientContext);
    this.listSubscribersCallable =
        callableFactory.createUnaryCallable(
            listSubscribersTransportSettings, settings.listSubscribersSettings(), clientContext);
    this.listSubscribersPagedCallable =
        callableFactory.createPagedCallable(
            listSubscribersTransportSettings, settings.listSubscribersSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listCustomersMethodDescriptor);
    methodDescriptors.add(getCustomerMethodDescriptor);
    methodDescriptors.add(checkCloudIdentityAccountsExistMethodDescriptor);
    methodDescriptors.add(createCustomerMethodDescriptor);
    methodDescriptors.add(updateCustomerMethodDescriptor);
    methodDescriptors.add(deleteCustomerMethodDescriptor);
    methodDescriptors.add(importCustomerMethodDescriptor);
    methodDescriptors.add(provisionCloudIdentityMethodDescriptor);
    methodDescriptors.add(listEntitlementsMethodDescriptor);
    methodDescriptors.add(listTransferableSkusMethodDescriptor);
    methodDescriptors.add(listTransferableOffersMethodDescriptor);
    methodDescriptors.add(getEntitlementMethodDescriptor);
    methodDescriptors.add(createEntitlementMethodDescriptor);
    methodDescriptors.add(changeParametersMethodDescriptor);
    methodDescriptors.add(changeRenewalSettingsMethodDescriptor);
    methodDescriptors.add(changeOfferMethodDescriptor);
    methodDescriptors.add(startPaidServiceMethodDescriptor);
    methodDescriptors.add(suspendEntitlementMethodDescriptor);
    methodDescriptors.add(cancelEntitlementMethodDescriptor);
    methodDescriptors.add(activateEntitlementMethodDescriptor);
    methodDescriptors.add(transferEntitlementsMethodDescriptor);
    methodDescriptors.add(transferEntitlementsToGoogleMethodDescriptor);
    methodDescriptors.add(listChannelPartnerLinksMethodDescriptor);
    methodDescriptors.add(getChannelPartnerLinkMethodDescriptor);
    methodDescriptors.add(createChannelPartnerLinkMethodDescriptor);
    methodDescriptors.add(updateChannelPartnerLinkMethodDescriptor);
    methodDescriptors.add(getCustomerRepricingConfigMethodDescriptor);
    methodDescriptors.add(listCustomerRepricingConfigsMethodDescriptor);
    methodDescriptors.add(createCustomerRepricingConfigMethodDescriptor);
    methodDescriptors.add(updateCustomerRepricingConfigMethodDescriptor);
    methodDescriptors.add(deleteCustomerRepricingConfigMethodDescriptor);
    methodDescriptors.add(getChannelPartnerRepricingConfigMethodDescriptor);
    methodDescriptors.add(listChannelPartnerRepricingConfigsMethodDescriptor);
    methodDescriptors.add(createChannelPartnerRepricingConfigMethodDescriptor);
    methodDescriptors.add(updateChannelPartnerRepricingConfigMethodDescriptor);
    methodDescriptors.add(deleteChannelPartnerRepricingConfigMethodDescriptor);
    methodDescriptors.add(lookupOfferMethodDescriptor);
    methodDescriptors.add(listProductsMethodDescriptor);
    methodDescriptors.add(listSkusMethodDescriptor);
    methodDescriptors.add(listOffersMethodDescriptor);
    methodDescriptors.add(listPurchasableSkusMethodDescriptor);
    methodDescriptors.add(listPurchasableOffersMethodDescriptor);
    methodDescriptors.add(registerSubscriberMethodDescriptor);
    methodDescriptors.add(unregisterSubscriberMethodDescriptor);
    methodDescriptors.add(listSubscribersMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListCustomersRequest, ListCustomersResponse> listCustomersCallable() {
    return listCustomersCallable;
  }

  @Override
  public UnaryCallable<ListCustomersRequest, ListCustomersPagedResponse>
      listCustomersPagedCallable() {
    return listCustomersPagedCallable;
  }

  @Override
  public UnaryCallable<GetCustomerRequest, Customer> getCustomerCallable() {
    return getCustomerCallable;
  }

  @Override
  public UnaryCallable<
          CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
      checkCloudIdentityAccountsExistCallable() {
    return checkCloudIdentityAccountsExistCallable;
  }

  @Override
  public UnaryCallable<CreateCustomerRequest, Customer> createCustomerCallable() {
    return createCustomerCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomerRequest, Customer> updateCustomerCallable() {
    return updateCustomerCallable;
  }

  @Override
  public UnaryCallable<DeleteCustomerRequest, Empty> deleteCustomerCallable() {
    return deleteCustomerCallable;
  }

  @Override
  public UnaryCallable<ImportCustomerRequest, Customer> importCustomerCallable() {
    return importCustomerCallable;
  }

  @Override
  public UnaryCallable<ProvisionCloudIdentityRequest, Operation> provisionCloudIdentityCallable() {
    return provisionCloudIdentityCallable;
  }

  @Override
  public OperationCallable<ProvisionCloudIdentityRequest, Customer, OperationMetadata>
      provisionCloudIdentityOperationCallable() {
    return provisionCloudIdentityOperationCallable;
  }

  @Override
  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsCallable() {
    return listEntitlementsCallable;
  }

  @Override
  public UnaryCallable<ListEntitlementsRequest, ListEntitlementsPagedResponse>
      listEntitlementsPagedCallable() {
    return listEntitlementsPagedCallable;
  }

  @Override
  public UnaryCallable<ListTransferableSkusRequest, ListTransferableSkusResponse>
      listTransferableSkusCallable() {
    return listTransferableSkusCallable;
  }

  @Override
  public UnaryCallable<ListTransferableSkusRequest, ListTransferableSkusPagedResponse>
      listTransferableSkusPagedCallable() {
    return listTransferableSkusPagedCallable;
  }

  @Override
  public UnaryCallable<ListTransferableOffersRequest, ListTransferableOffersResponse>
      listTransferableOffersCallable() {
    return listTransferableOffersCallable;
  }

  @Override
  public UnaryCallable<ListTransferableOffersRequest, ListTransferableOffersPagedResponse>
      listTransferableOffersPagedCallable() {
    return listTransferableOffersPagedCallable;
  }

  @Override
  public UnaryCallable<GetEntitlementRequest, Entitlement> getEntitlementCallable() {
    return getEntitlementCallable;
  }

  @Override
  public UnaryCallable<CreateEntitlementRequest, Operation> createEntitlementCallable() {
    return createEntitlementCallable;
  }

  @Override
  public OperationCallable<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationCallable() {
    return createEntitlementOperationCallable;
  }

  @Override
  public UnaryCallable<ChangeParametersRequest, Operation> changeParametersCallable() {
    return changeParametersCallable;
  }

  @Override
  public OperationCallable<ChangeParametersRequest, Entitlement, OperationMetadata>
      changeParametersOperationCallable() {
    return changeParametersOperationCallable;
  }

  @Override
  public UnaryCallable<ChangeRenewalSettingsRequest, Operation> changeRenewalSettingsCallable() {
    return changeRenewalSettingsCallable;
  }

  @Override
  public OperationCallable<ChangeRenewalSettingsRequest, Entitlement, OperationMetadata>
      changeRenewalSettingsOperationCallable() {
    return changeRenewalSettingsOperationCallable;
  }

  @Override
  public UnaryCallable<ChangeOfferRequest, Operation> changeOfferCallable() {
    return changeOfferCallable;
  }

  @Override
  public OperationCallable<ChangeOfferRequest, Entitlement, OperationMetadata>
      changeOfferOperationCallable() {
    return changeOfferOperationCallable;
  }

  @Override
  public UnaryCallable<StartPaidServiceRequest, Operation> startPaidServiceCallable() {
    return startPaidServiceCallable;
  }

  @Override
  public OperationCallable<StartPaidServiceRequest, Entitlement, OperationMetadata>
      startPaidServiceOperationCallable() {
    return startPaidServiceOperationCallable;
  }

  @Override
  public UnaryCallable<SuspendEntitlementRequest, Operation> suspendEntitlementCallable() {
    return suspendEntitlementCallable;
  }

  @Override
  public OperationCallable<SuspendEntitlementRequest, Entitlement, OperationMetadata>
      suspendEntitlementOperationCallable() {
    return suspendEntitlementOperationCallable;
  }

  @Override
  public UnaryCallable<CancelEntitlementRequest, Operation> cancelEntitlementCallable() {
    return cancelEntitlementCallable;
  }

  @Override
  public OperationCallable<CancelEntitlementRequest, Empty, OperationMetadata>
      cancelEntitlementOperationCallable() {
    return cancelEntitlementOperationCallable;
  }

  @Override
  public UnaryCallable<ActivateEntitlementRequest, Operation> activateEntitlementCallable() {
    return activateEntitlementCallable;
  }

  @Override
  public OperationCallable<ActivateEntitlementRequest, Entitlement, OperationMetadata>
      activateEntitlementOperationCallable() {
    return activateEntitlementOperationCallable;
  }

  @Override
  public UnaryCallable<TransferEntitlementsRequest, Operation> transferEntitlementsCallable() {
    return transferEntitlementsCallable;
  }

  @Override
  public OperationCallable<
          TransferEntitlementsRequest, TransferEntitlementsResponse, OperationMetadata>
      transferEntitlementsOperationCallable() {
    return transferEntitlementsOperationCallable;
  }

  @Override
  public UnaryCallable<TransferEntitlementsToGoogleRequest, Operation>
      transferEntitlementsToGoogleCallable() {
    return transferEntitlementsToGoogleCallable;
  }

  @Override
  public OperationCallable<TransferEntitlementsToGoogleRequest, Empty, OperationMetadata>
      transferEntitlementsToGoogleOperationCallable() {
    return transferEntitlementsToGoogleOperationCallable;
  }

  @Override
  public UnaryCallable<ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>
      listChannelPartnerLinksCallable() {
    return listChannelPartnerLinksCallable;
  }

  @Override
  public UnaryCallable<ListChannelPartnerLinksRequest, ListChannelPartnerLinksPagedResponse>
      listChannelPartnerLinksPagedCallable() {
    return listChannelPartnerLinksPagedCallable;
  }

  @Override
  public UnaryCallable<GetChannelPartnerLinkRequest, ChannelPartnerLink>
      getChannelPartnerLinkCallable() {
    return getChannelPartnerLinkCallable;
  }

  @Override
  public UnaryCallable<CreateChannelPartnerLinkRequest, ChannelPartnerLink>
      createChannelPartnerLinkCallable() {
    return createChannelPartnerLinkCallable;
  }

  @Override
  public UnaryCallable<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>
      updateChannelPartnerLinkCallable() {
    return updateChannelPartnerLinkCallable;
  }

  @Override
  public UnaryCallable<GetCustomerRepricingConfigRequest, CustomerRepricingConfig>
      getCustomerRepricingConfigCallable() {
    return getCustomerRepricingConfigCallable;
  }

  @Override
  public UnaryCallable<ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsResponse>
      listCustomerRepricingConfigsCallable() {
    return listCustomerRepricingConfigsCallable;
  }

  @Override
  public UnaryCallable<
          ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsPagedResponse>
      listCustomerRepricingConfigsPagedCallable() {
    return listCustomerRepricingConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>
      createCustomerRepricingConfigCallable() {
    return createCustomerRepricingConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>
      updateCustomerRepricingConfigCallable() {
    return updateCustomerRepricingConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteCustomerRepricingConfigRequest, Empty>
      deleteCustomerRepricingConfigCallable() {
    return deleteCustomerRepricingConfigCallable;
  }

  @Override
  public UnaryCallable<GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      getChannelPartnerRepricingConfigCallable() {
    return getChannelPartnerRepricingConfigCallable;
  }

  @Override
  public UnaryCallable<
          ListChannelPartnerRepricingConfigsRequest, ListChannelPartnerRepricingConfigsResponse>
      listChannelPartnerRepricingConfigsCallable() {
    return listChannelPartnerRepricingConfigsCallable;
  }

  @Override
  public UnaryCallable<
          ListChannelPartnerRepricingConfigsRequest,
          ListChannelPartnerRepricingConfigsPagedResponse>
      listChannelPartnerRepricingConfigsPagedCallable() {
    return listChannelPartnerRepricingConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      createChannelPartnerRepricingConfigCallable() {
    return createChannelPartnerRepricingConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      updateChannelPartnerRepricingConfigCallable() {
    return updateChannelPartnerRepricingConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteChannelPartnerRepricingConfigRequest, Empty>
      deleteChannelPartnerRepricingConfigCallable() {
    return deleteChannelPartnerRepricingConfigCallable;
  }

  @Override
  public UnaryCallable<LookupOfferRequest, Offer> lookupOfferCallable() {
    return lookupOfferCallable;
  }

  @Override
  public UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    return listProductsCallable;
  }

  @Override
  public UnaryCallable<ListProductsRequest, ListProductsPagedResponse> listProductsPagedCallable() {
    return listProductsPagedCallable;
  }

  @Override
  public UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    return listSkusCallable;
  }

  @Override
  public UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    return listSkusPagedCallable;
  }

  @Override
  public UnaryCallable<ListOffersRequest, ListOffersResponse> listOffersCallable() {
    return listOffersCallable;
  }

  @Override
  public UnaryCallable<ListOffersRequest, ListOffersPagedResponse> listOffersPagedCallable() {
    return listOffersPagedCallable;
  }

  @Override
  public UnaryCallable<ListPurchasableSkusRequest, ListPurchasableSkusResponse>
      listPurchasableSkusCallable() {
    return listPurchasableSkusCallable;
  }

  @Override
  public UnaryCallable<ListPurchasableSkusRequest, ListPurchasableSkusPagedResponse>
      listPurchasableSkusPagedCallable() {
    return listPurchasableSkusPagedCallable;
  }

  @Override
  public UnaryCallable<ListPurchasableOffersRequest, ListPurchasableOffersResponse>
      listPurchasableOffersCallable() {
    return listPurchasableOffersCallable;
  }

  @Override
  public UnaryCallable<ListPurchasableOffersRequest, ListPurchasableOffersPagedResponse>
      listPurchasableOffersPagedCallable() {
    return listPurchasableOffersPagedCallable;
  }

  @Override
  public UnaryCallable<RegisterSubscriberRequest, RegisterSubscriberResponse>
      registerSubscriberCallable() {
    return registerSubscriberCallable;
  }

  @Override
  public UnaryCallable<UnregisterSubscriberRequest, UnregisterSubscriberResponse>
      unregisterSubscriberCallable() {
    return unregisterSubscriberCallable;
  }

  @Override
  public UnaryCallable<ListSubscribersRequest, ListSubscribersResponse> listSubscribersCallable() {
    return listSubscribersCallable;
  }

  @Override
  public UnaryCallable<ListSubscribersRequest, ListSubscribersPagedResponse>
      listSubscribersPagedCallable() {
    return listSubscribersPagedCallable;
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
