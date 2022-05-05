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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the CloudChannelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCloudChannelServiceStub extends CloudChannelServiceStub {
  private static final MethodDescriptor<ListCustomersRequest, ListCustomersResponse>
      listCustomersMethodDescriptor =
          MethodDescriptor.<ListCustomersRequest, ListCustomersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListCustomers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCustomersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCustomersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCustomerRequest, Customer> getCustomerMethodDescriptor =
      MethodDescriptor.<GetCustomerRequest, Customer>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.channel.v1.CloudChannelService/GetCustomer")
          .setRequestMarshaller(ProtoUtils.marshaller(GetCustomerRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Customer.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<
          CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
      checkCloudIdentityAccountsExistMethodDescriptor =
          MethodDescriptor
              .<CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/CheckCloudIdentityAccountsExist")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CheckCloudIdentityAccountsExistRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      CheckCloudIdentityAccountsExistResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCustomerRequest, Customer>
      createCustomerMethodDescriptor =
          MethodDescriptor.<CreateCustomerRequest, Customer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/CreateCustomer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Customer.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCustomerRequest, Customer>
      updateCustomerMethodDescriptor =
          MethodDescriptor.<UpdateCustomerRequest, Customer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/UpdateCustomer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Customer.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCustomerRequest, Empty>
      deleteCustomerMethodDescriptor =
          MethodDescriptor.<DeleteCustomerRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/DeleteCustomer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportCustomerRequest, Customer>
      importCustomerMethodDescriptor =
          MethodDescriptor.<ImportCustomerRequest, Customer>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ImportCustomer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Customer.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ProvisionCloudIdentityRequest, Operation>
      provisionCloudIdentityMethodDescriptor =
          MethodDescriptor.<ProvisionCloudIdentityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ProvisionCloudIdentity")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ProvisionCloudIdentityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEntitlementsRequest, ListEntitlementsResponse>
      listEntitlementsMethodDescriptor =
          MethodDescriptor.<ListEntitlementsRequest, ListEntitlementsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListEntitlements")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEntitlementsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEntitlementsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTransferableSkusRequest, ListTransferableSkusResponse>
      listTransferableSkusMethodDescriptor =
          MethodDescriptor.<ListTransferableSkusRequest, ListTransferableSkusResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListTransferableSkus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTransferableSkusRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTransferableSkusResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListTransferableOffersRequest, ListTransferableOffersResponse>
      listTransferableOffersMethodDescriptor =
          MethodDescriptor
              .<ListTransferableOffersRequest, ListTransferableOffersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ListTransferableOffers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTransferableOffersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTransferableOffersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEntitlementRequest, Entitlement>
      getEntitlementMethodDescriptor =
          MethodDescriptor.<GetEntitlementRequest, Entitlement>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/GetEntitlement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEntitlementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Entitlement.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateEntitlementRequest, Operation>
      createEntitlementMethodDescriptor =
          MethodDescriptor.<CreateEntitlementRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/CreateEntitlement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEntitlementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ChangeParametersRequest, Operation>
      changeParametersMethodDescriptor =
          MethodDescriptor.<ChangeParametersRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ChangeParameters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ChangeParametersRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ChangeRenewalSettingsRequest, Operation>
      changeRenewalSettingsMethodDescriptor =
          MethodDescriptor.<ChangeRenewalSettingsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ChangeRenewalSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ChangeRenewalSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ChangeOfferRequest, Operation> changeOfferMethodDescriptor =
      MethodDescriptor.<ChangeOfferRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ChangeOffer")
          .setRequestMarshaller(ProtoUtils.marshaller(ChangeOfferRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<StartPaidServiceRequest, Operation>
      startPaidServiceMethodDescriptor =
          MethodDescriptor.<StartPaidServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/StartPaidService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartPaidServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SuspendEntitlementRequest, Operation>
      suspendEntitlementMethodDescriptor =
          MethodDescriptor.<SuspendEntitlementRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/SuspendEntitlement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SuspendEntitlementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelEntitlementRequest, Operation>
      cancelEntitlementMethodDescriptor =
          MethodDescriptor.<CancelEntitlementRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/CancelEntitlement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelEntitlementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ActivateEntitlementRequest, Operation>
      activateEntitlementMethodDescriptor =
          MethodDescriptor.<ActivateEntitlementRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ActivateEntitlement")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ActivateEntitlementRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TransferEntitlementsRequest, Operation>
      transferEntitlementsMethodDescriptor =
          MethodDescriptor.<TransferEntitlementsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/TransferEntitlements")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TransferEntitlementsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TransferEntitlementsToGoogleRequest, Operation>
      transferEntitlementsToGoogleMethodDescriptor =
          MethodDescriptor.<TransferEntitlementsToGoogleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/TransferEntitlementsToGoogle")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TransferEntitlementsToGoogleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>
      listChannelPartnerLinksMethodDescriptor =
          MethodDescriptor
              .<ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ListChannelPartnerLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListChannelPartnerLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListChannelPartnerLinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetChannelPartnerLinkRequest, ChannelPartnerLink>
      getChannelPartnerLinkMethodDescriptor =
          MethodDescriptor.<GetChannelPartnerLinkRequest, ChannelPartnerLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/GetChannelPartnerLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetChannelPartnerLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ChannelPartnerLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateChannelPartnerLinkRequest, ChannelPartnerLink>
      createChannelPartnerLinkMethodDescriptor =
          MethodDescriptor.<CreateChannelPartnerLinkRequest, ChannelPartnerLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/CreateChannelPartnerLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateChannelPartnerLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ChannelPartnerLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>
      updateChannelPartnerLinkMethodDescriptor =
          MethodDescriptor.<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/UpdateChannelPartnerLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateChannelPartnerLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ChannelPartnerLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCustomerRepricingConfigRequest, CustomerRepricingConfig>
      getCustomerRepricingConfigMethodDescriptor =
          MethodDescriptor.<GetCustomerRepricingConfigRequest, CustomerRepricingConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/GetCustomerRepricingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCustomerRepricingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CustomerRepricingConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsResponse>
      listCustomerRepricingConfigsMethodDescriptor =
          MethodDescriptor
              .<ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ListCustomerRepricingConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCustomerRepricingConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCustomerRepricingConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>
      createCustomerRepricingConfigMethodDescriptor =
          MethodDescriptor
              .<CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/CreateCustomerRepricingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCustomerRepricingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CustomerRepricingConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>
      updateCustomerRepricingConfigMethodDescriptor =
          MethodDescriptor
              .<UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/UpdateCustomerRepricingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCustomerRepricingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CustomerRepricingConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCustomerRepricingConfigRequest, Empty>
      deleteCustomerRepricingConfigMethodDescriptor =
          MethodDescriptor.<DeleteCustomerRepricingConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/DeleteCustomerRepricingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCustomerRepricingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      getChannelPartnerRepricingConfigMethodDescriptor =
          MethodDescriptor
              .<GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/GetChannelPartnerRepricingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetChannelPartnerRepricingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ChannelPartnerRepricingConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListChannelPartnerRepricingConfigsRequest, ListChannelPartnerRepricingConfigsResponse>
      listChannelPartnerRepricingConfigsMethodDescriptor =
          MethodDescriptor
              .<ListChannelPartnerRepricingConfigsRequest,
                  ListChannelPartnerRepricingConfigsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ListChannelPartnerRepricingConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListChannelPartnerRepricingConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListChannelPartnerRepricingConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      createChannelPartnerRepricingConfigMethodDescriptor =
          MethodDescriptor
              .<CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/CreateChannelPartnerRepricingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateChannelPartnerRepricingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ChannelPartnerRepricingConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      updateChannelPartnerRepricingConfigMethodDescriptor =
          MethodDescriptor
              .<UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/UpdateChannelPartnerRepricingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateChannelPartnerRepricingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ChannelPartnerRepricingConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteChannelPartnerRepricingConfigRequest, Empty>
      deleteChannelPartnerRepricingConfigMethodDescriptor =
          MethodDescriptor.<DeleteChannelPartnerRepricingConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/DeleteChannelPartnerRepricingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteChannelPartnerRepricingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<LookupOfferRequest, Offer> lookupOfferMethodDescriptor =
      MethodDescriptor.<LookupOfferRequest, Offer>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.channel.v1.CloudChannelService/LookupOffer")
          .setRequestMarshaller(ProtoUtils.marshaller(LookupOfferRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Offer.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListProductsRequest, ListProductsResponse>
      listProductsMethodDescriptor =
          MethodDescriptor.<ListProductsRequest, ListProductsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListProducts")
              .setRequestMarshaller(ProtoUtils.marshaller(ListProductsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProductsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSkusRequest, ListSkusResponse>
      listSkusMethodDescriptor =
          MethodDescriptor.<ListSkusRequest, ListSkusResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListSkus")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSkusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSkusResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListOffersRequest, ListOffersResponse>
      listOffersMethodDescriptor =
          MethodDescriptor.<ListOffersRequest, ListOffersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListOffers")
              .setRequestMarshaller(ProtoUtils.marshaller(ListOffersRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListOffersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPurchasableSkusRequest, ListPurchasableSkusResponse>
      listPurchasableSkusMethodDescriptor =
          MethodDescriptor.<ListPurchasableSkusRequest, ListPurchasableSkusResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListPurchasableSkus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPurchasableSkusRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPurchasableSkusResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPurchasableOffersRequest, ListPurchasableOffersResponse>
      listPurchasableOffersMethodDescriptor =
          MethodDescriptor.<ListPurchasableOffersRequest, ListPurchasableOffersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.channel.v1.CloudChannelService/ListPurchasableOffers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPurchasableOffersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPurchasableOffersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RegisterSubscriberRequest, RegisterSubscriberResponse>
      registerSubscriberMethodDescriptor =
          MethodDescriptor.<RegisterSubscriberRequest, RegisterSubscriberResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/RegisterSubscriber")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RegisterSubscriberRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RegisterSubscriberResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UnregisterSubscriberRequest, UnregisterSubscriberResponse>
      unregisterSubscriberMethodDescriptor =
          MethodDescriptor.<UnregisterSubscriberRequest, UnregisterSubscriberResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/UnregisterSubscriber")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UnregisterSubscriberRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UnregisterSubscriberResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSubscribersRequest, ListSubscribersResponse>
      listSubscribersMethodDescriptor =
          MethodDescriptor.<ListSubscribersRequest, ListSubscribersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.channel.v1.CloudChannelService/ListSubscribers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSubscribersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSubscribersResponse.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudChannelServiceStub create(CloudChannelServiceStubSettings settings)
      throws IOException {
    return new GrpcCloudChannelServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudChannelServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCloudChannelServiceStub(
        CloudChannelServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudChannelServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudChannelServiceStub(
        CloudChannelServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudChannelServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudChannelServiceStub(
      CloudChannelServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCloudChannelServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudChannelServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudChannelServiceStub(
      CloudChannelServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListCustomersRequest, ListCustomersResponse> listCustomersTransportSettings =
        GrpcCallSettings.<ListCustomersRequest, ListCustomersResponse>newBuilder()
            .setMethodDescriptor(listCustomersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetCustomerRequest, Customer> getCustomerTransportSettings =
        GrpcCallSettings.<GetCustomerRequest, Customer>newBuilder()
            .setMethodDescriptor(getCustomerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<
            CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
        checkCloudIdentityAccountsExistTransportSettings =
            GrpcCallSettings
                .<CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
                    newBuilder()
                .setMethodDescriptor(checkCloudIdentityAccountsExistMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateCustomerRequest, Customer> createCustomerTransportSettings =
        GrpcCallSettings.<CreateCustomerRequest, Customer>newBuilder()
            .setMethodDescriptor(createCustomerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateCustomerRequest, Customer> updateCustomerTransportSettings =
        GrpcCallSettings.<UpdateCustomerRequest, Customer>newBuilder()
            .setMethodDescriptor(updateCustomerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("customer.name", String.valueOf(request.getCustomer().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteCustomerRequest, Empty> deleteCustomerTransportSettings =
        GrpcCallSettings.<DeleteCustomerRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteCustomerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ImportCustomerRequest, Customer> importCustomerTransportSettings =
        GrpcCallSettings.<ImportCustomerRequest, Customer>newBuilder()
            .setMethodDescriptor(importCustomerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ProvisionCloudIdentityRequest, Operation>
        provisionCloudIdentityTransportSettings =
            GrpcCallSettings.<ProvisionCloudIdentityRequest, Operation>newBuilder()
                .setMethodDescriptor(provisionCloudIdentityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("customer", String.valueOf(request.getCustomer()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListEntitlementsRequest, ListEntitlementsResponse>
        listEntitlementsTransportSettings =
            GrpcCallSettings.<ListEntitlementsRequest, ListEntitlementsResponse>newBuilder()
                .setMethodDescriptor(listEntitlementsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListTransferableSkusRequest, ListTransferableSkusResponse>
        listTransferableSkusTransportSettings =
            GrpcCallSettings.<ListTransferableSkusRequest, ListTransferableSkusResponse>newBuilder()
                .setMethodDescriptor(listTransferableSkusMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListTransferableOffersRequest, ListTransferableOffersResponse>
        listTransferableOffersTransportSettings =
            GrpcCallSettings
                .<ListTransferableOffersRequest, ListTransferableOffersResponse>newBuilder()
                .setMethodDescriptor(listTransferableOffersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetEntitlementRequest, Entitlement> getEntitlementTransportSettings =
        GrpcCallSettings.<GetEntitlementRequest, Entitlement>newBuilder()
            .setMethodDescriptor(getEntitlementMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateEntitlementRequest, Operation> createEntitlementTransportSettings =
        GrpcCallSettings.<CreateEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(createEntitlementMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ChangeParametersRequest, Operation> changeParametersTransportSettings =
        GrpcCallSettings.<ChangeParametersRequest, Operation>newBuilder()
            .setMethodDescriptor(changeParametersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ChangeRenewalSettingsRequest, Operation>
        changeRenewalSettingsTransportSettings =
            GrpcCallSettings.<ChangeRenewalSettingsRequest, Operation>newBuilder()
                .setMethodDescriptor(changeRenewalSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ChangeOfferRequest, Operation> changeOfferTransportSettings =
        GrpcCallSettings.<ChangeOfferRequest, Operation>newBuilder()
            .setMethodDescriptor(changeOfferMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StartPaidServiceRequest, Operation> startPaidServiceTransportSettings =
        GrpcCallSettings.<StartPaidServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(startPaidServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SuspendEntitlementRequest, Operation> suspendEntitlementTransportSettings =
        GrpcCallSettings.<SuspendEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(suspendEntitlementMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CancelEntitlementRequest, Operation> cancelEntitlementTransportSettings =
        GrpcCallSettings.<CancelEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(cancelEntitlementMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ActivateEntitlementRequest, Operation> activateEntitlementTransportSettings =
        GrpcCallSettings.<ActivateEntitlementRequest, Operation>newBuilder()
            .setMethodDescriptor(activateEntitlementMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TransferEntitlementsRequest, Operation> transferEntitlementsTransportSettings =
        GrpcCallSettings.<TransferEntitlementsRequest, Operation>newBuilder()
            .setMethodDescriptor(transferEntitlementsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TransferEntitlementsToGoogleRequest, Operation>
        transferEntitlementsToGoogleTransportSettings =
            GrpcCallSettings.<TransferEntitlementsToGoogleRequest, Operation>newBuilder()
                .setMethodDescriptor(transferEntitlementsToGoogleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>
        listChannelPartnerLinksTransportSettings =
            GrpcCallSettings
                .<ListChannelPartnerLinksRequest, ListChannelPartnerLinksResponse>newBuilder()
                .setMethodDescriptor(listChannelPartnerLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetChannelPartnerLinkRequest, ChannelPartnerLink>
        getChannelPartnerLinkTransportSettings =
            GrpcCallSettings.<GetChannelPartnerLinkRequest, ChannelPartnerLink>newBuilder()
                .setMethodDescriptor(getChannelPartnerLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateChannelPartnerLinkRequest, ChannelPartnerLink>
        createChannelPartnerLinkTransportSettings =
            GrpcCallSettings.<CreateChannelPartnerLinkRequest, ChannelPartnerLink>newBuilder()
                .setMethodDescriptor(createChannelPartnerLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>
        updateChannelPartnerLinkTransportSettings =
            GrpcCallSettings.<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>newBuilder()
                .setMethodDescriptor(updateChannelPartnerLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetCustomerRepricingConfigRequest, CustomerRepricingConfig>
        getCustomerRepricingConfigTransportSettings =
            GrpcCallSettings
                .<GetCustomerRepricingConfigRequest, CustomerRepricingConfig>newBuilder()
                .setMethodDescriptor(getCustomerRepricingConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsResponse>
        listCustomerRepricingConfigsTransportSettings =
            GrpcCallSettings
                .<ListCustomerRepricingConfigsRequest, ListCustomerRepricingConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(listCustomerRepricingConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>
        createCustomerRepricingConfigTransportSettings =
            GrpcCallSettings
                .<CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>newBuilder()
                .setMethodDescriptor(createCustomerRepricingConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>
        updateCustomerRepricingConfigTransportSettings =
            GrpcCallSettings
                .<UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>newBuilder()
                .setMethodDescriptor(updateCustomerRepricingConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "customer_repricing_config.name",
                          String.valueOf(request.getCustomerRepricingConfig().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteCustomerRepricingConfigRequest, Empty>
        deleteCustomerRepricingConfigTransportSettings =
            GrpcCallSettings.<DeleteCustomerRepricingConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteCustomerRepricingConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
        getChannelPartnerRepricingConfigTransportSettings =
            GrpcCallSettings
                .<GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
                    newBuilder()
                .setMethodDescriptor(getChannelPartnerRepricingConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<
            ListChannelPartnerRepricingConfigsRequest, ListChannelPartnerRepricingConfigsResponse>
        listChannelPartnerRepricingConfigsTransportSettings =
            GrpcCallSettings
                .<ListChannelPartnerRepricingConfigsRequest,
                    ListChannelPartnerRepricingConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(listChannelPartnerRepricingConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
        createChannelPartnerRepricingConfigTransportSettings =
            GrpcCallSettings
                .<CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
                    newBuilder()
                .setMethodDescriptor(createChannelPartnerRepricingConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
        updateChannelPartnerRepricingConfigTransportSettings =
            GrpcCallSettings
                .<UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
                    newBuilder()
                .setMethodDescriptor(updateChannelPartnerRepricingConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "channel_partner_repricing_config.name",
                          String.valueOf(request.getChannelPartnerRepricingConfig().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteChannelPartnerRepricingConfigRequest, Empty>
        deleteChannelPartnerRepricingConfigTransportSettings =
            GrpcCallSettings.<DeleteChannelPartnerRepricingConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteChannelPartnerRepricingConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<LookupOfferRequest, Offer> lookupOfferTransportSettings =
        GrpcCallSettings.<LookupOfferRequest, Offer>newBuilder()
            .setMethodDescriptor(lookupOfferMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("entitlement", String.valueOf(request.getEntitlement()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListProductsRequest, ListProductsResponse> listProductsTransportSettings =
        GrpcCallSettings.<ListProductsRequest, ListProductsResponse>newBuilder()
            .setMethodDescriptor(listProductsMethodDescriptor)
            .build();
    GrpcCallSettings<ListSkusRequest, ListSkusResponse> listSkusTransportSettings =
        GrpcCallSettings.<ListSkusRequest, ListSkusResponse>newBuilder()
            .setMethodDescriptor(listSkusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListOffersRequest, ListOffersResponse> listOffersTransportSettings =
        GrpcCallSettings.<ListOffersRequest, ListOffersResponse>newBuilder()
            .setMethodDescriptor(listOffersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListPurchasableSkusRequest, ListPurchasableSkusResponse>
        listPurchasableSkusTransportSettings =
            GrpcCallSettings.<ListPurchasableSkusRequest, ListPurchasableSkusResponse>newBuilder()
                .setMethodDescriptor(listPurchasableSkusMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("customer", String.valueOf(request.getCustomer()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListPurchasableOffersRequest, ListPurchasableOffersResponse>
        listPurchasableOffersTransportSettings =
            GrpcCallSettings
                .<ListPurchasableOffersRequest, ListPurchasableOffersResponse>newBuilder()
                .setMethodDescriptor(listPurchasableOffersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("customer", String.valueOf(request.getCustomer()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<RegisterSubscriberRequest, RegisterSubscriberResponse>
        registerSubscriberTransportSettings =
            GrpcCallSettings.<RegisterSubscriberRequest, RegisterSubscriberResponse>newBuilder()
                .setMethodDescriptor(registerSubscriberMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("account", String.valueOf(request.getAccount()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UnregisterSubscriberRequest, UnregisterSubscriberResponse>
        unregisterSubscriberTransportSettings =
            GrpcCallSettings.<UnregisterSubscriberRequest, UnregisterSubscriberResponse>newBuilder()
                .setMethodDescriptor(unregisterSubscriberMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("account", String.valueOf(request.getAccount()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListSubscribersRequest, ListSubscribersResponse>
        listSubscribersTransportSettings =
            GrpcCallSettings.<ListSubscribersRequest, ListSubscribersResponse>newBuilder()
                .setMethodDescriptor(listSubscribersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("account", String.valueOf(request.getAccount()));
                      return params.build();
                    })
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
            operationsStub);
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
            operationsStub);
    this.changeParametersCallable =
        callableFactory.createUnaryCallable(
            changeParametersTransportSettings, settings.changeParametersSettings(), clientContext);
    this.changeParametersOperationCallable =
        callableFactory.createOperationCallable(
            changeParametersTransportSettings,
            settings.changeParametersOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
    this.changeOfferCallable =
        callableFactory.createUnaryCallable(
            changeOfferTransportSettings, settings.changeOfferSettings(), clientContext);
    this.changeOfferOperationCallable =
        callableFactory.createOperationCallable(
            changeOfferTransportSettings,
            settings.changeOfferOperationSettings(),
            clientContext,
            operationsStub);
    this.startPaidServiceCallable =
        callableFactory.createUnaryCallable(
            startPaidServiceTransportSettings, settings.startPaidServiceSettings(), clientContext);
    this.startPaidServiceOperationCallable =
        callableFactory.createOperationCallable(
            startPaidServiceTransportSettings,
            settings.startPaidServiceOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
