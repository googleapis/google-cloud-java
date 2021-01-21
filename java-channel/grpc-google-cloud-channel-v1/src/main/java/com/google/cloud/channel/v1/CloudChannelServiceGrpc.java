/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.channel.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * CloudChannelService enables Google cloud resellers and distributors to manage
 * their customers, channel partners, entitlements and reports.
 * Using this service:
 * 1. Resellers or distributors can manage a customer entity.
 * 2. Distributors can register an authorized reseller in their channel and then
 *    enable delegated admin access for the reseller.
 * 3. Resellers or distributors can manage entitlements for their customers.
 * The service primarily exposes the following resources:
 * - [Customer][google.cloud.channel.v1.Customer]s: A Customer represents an entity managed by a reseller or
 * distributor. A customer typically represents an enterprise. In an n-tier
 * resale channel hierarchy, customers are generally represented as leaf nodes.
 * Customers primarily have an Entitlement sub-resource discussed below.
 * - [Entitlement][google.cloud.channel.v1.Entitlement]s: An Entitlement represents an entity which provides a
 * customer means to start using a service. Entitlements are created or updated
 * as a result of a successful fulfillment.
 * - [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s: A ChannelPartnerLink is an entity that identifies
 * links between distributors and their indirect resellers in a channel.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/channel/v1/service.proto")
public final class CloudChannelServiceGrpc {

  private CloudChannelServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.channel.v1.CloudChannelService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListCustomersRequest,
          com.google.cloud.channel.v1.ListCustomersResponse>
      getListCustomersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCustomers",
      requestType = com.google.cloud.channel.v1.ListCustomersRequest.class,
      responseType = com.google.cloud.channel.v1.ListCustomersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListCustomersRequest,
          com.google.cloud.channel.v1.ListCustomersResponse>
      getListCustomersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ListCustomersRequest,
            com.google.cloud.channel.v1.ListCustomersResponse>
        getListCustomersMethod;
    if ((getListCustomersMethod = CloudChannelServiceGrpc.getListCustomersMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getListCustomersMethod = CloudChannelServiceGrpc.getListCustomersMethod) == null) {
          CloudChannelServiceGrpc.getListCustomersMethod =
              getListCustomersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ListCustomersRequest,
                          com.google.cloud.channel.v1.ListCustomersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCustomers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListCustomersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListCustomersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ListCustomers"))
                      .build();
        }
      }
    }
    return getListCustomersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.GetCustomerRequest, com.google.cloud.channel.v1.Customer>
      getGetCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomer",
      requestType = com.google.cloud.channel.v1.GetCustomerRequest.class,
      responseType = com.google.cloud.channel.v1.Customer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.GetCustomerRequest, com.google.cloud.channel.v1.Customer>
      getGetCustomerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.GetCustomerRequest, com.google.cloud.channel.v1.Customer>
        getGetCustomerMethod;
    if ((getGetCustomerMethod = CloudChannelServiceGrpc.getGetCustomerMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getGetCustomerMethod = CloudChannelServiceGrpc.getGetCustomerMethod) == null) {
          CloudChannelServiceGrpc.getGetCustomerMethod =
              getGetCustomerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.GetCustomerRequest,
                          com.google.cloud.channel.v1.Customer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.GetCustomerRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.Customer.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("GetCustomer"))
                      .build();
        }
      }
    }
    return getGetCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest,
          com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse>
      getCheckCloudIdentityAccountsExistMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckCloudIdentityAccountsExist",
      requestType = com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest.class,
      responseType = com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest,
          com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse>
      getCheckCloudIdentityAccountsExistMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest,
            com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse>
        getCheckCloudIdentityAccountsExistMethod;
    if ((getCheckCloudIdentityAccountsExistMethod =
            CloudChannelServiceGrpc.getCheckCloudIdentityAccountsExistMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getCheckCloudIdentityAccountsExistMethod =
                CloudChannelServiceGrpc.getCheckCloudIdentityAccountsExistMethod)
            == null) {
          CloudChannelServiceGrpc.getCheckCloudIdentityAccountsExistMethod =
              getCheckCloudIdentityAccountsExistMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest,
                          com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CheckCloudIdentityAccountsExist"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier(
                              "CheckCloudIdentityAccountsExist"))
                      .build();
        }
      }
    }
    return getCheckCloudIdentityAccountsExistMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.CreateCustomerRequest, com.google.cloud.channel.v1.Customer>
      getCreateCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCustomer",
      requestType = com.google.cloud.channel.v1.CreateCustomerRequest.class,
      responseType = com.google.cloud.channel.v1.Customer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.CreateCustomerRequest, com.google.cloud.channel.v1.Customer>
      getCreateCustomerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.CreateCustomerRequest, com.google.cloud.channel.v1.Customer>
        getCreateCustomerMethod;
    if ((getCreateCustomerMethod = CloudChannelServiceGrpc.getCreateCustomerMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getCreateCustomerMethod = CloudChannelServiceGrpc.getCreateCustomerMethod) == null) {
          CloudChannelServiceGrpc.getCreateCustomerMethod =
              getCreateCustomerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.CreateCustomerRequest,
                          com.google.cloud.channel.v1.Customer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCustomer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.CreateCustomerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.Customer.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("CreateCustomer"))
                      .build();
        }
      }
    }
    return getCreateCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.UpdateCustomerRequest, com.google.cloud.channel.v1.Customer>
      getUpdateCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomer",
      requestType = com.google.cloud.channel.v1.UpdateCustomerRequest.class,
      responseType = com.google.cloud.channel.v1.Customer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.UpdateCustomerRequest, com.google.cloud.channel.v1.Customer>
      getUpdateCustomerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.UpdateCustomerRequest, com.google.cloud.channel.v1.Customer>
        getUpdateCustomerMethod;
    if ((getUpdateCustomerMethod = CloudChannelServiceGrpc.getUpdateCustomerMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getUpdateCustomerMethod = CloudChannelServiceGrpc.getUpdateCustomerMethod) == null) {
          CloudChannelServiceGrpc.getUpdateCustomerMethod =
              getUpdateCustomerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.UpdateCustomerRequest,
                          com.google.cloud.channel.v1.Customer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCustomer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.UpdateCustomerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.Customer.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("UpdateCustomer"))
                      .build();
        }
      }
    }
    return getUpdateCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.DeleteCustomerRequest, com.google.protobuf.Empty>
      getDeleteCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCustomer",
      requestType = com.google.cloud.channel.v1.DeleteCustomerRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.DeleteCustomerRequest, com.google.protobuf.Empty>
      getDeleteCustomerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.DeleteCustomerRequest, com.google.protobuf.Empty>
        getDeleteCustomerMethod;
    if ((getDeleteCustomerMethod = CloudChannelServiceGrpc.getDeleteCustomerMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getDeleteCustomerMethod = CloudChannelServiceGrpc.getDeleteCustomerMethod) == null) {
          CloudChannelServiceGrpc.getDeleteCustomerMethod =
              getDeleteCustomerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.DeleteCustomerRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCustomer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.DeleteCustomerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("DeleteCustomer"))
                      .build();
        }
      }
    }
    return getDeleteCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ProvisionCloudIdentityRequest,
          com.google.longrunning.Operation>
      getProvisionCloudIdentityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProvisionCloudIdentity",
      requestType = com.google.cloud.channel.v1.ProvisionCloudIdentityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ProvisionCloudIdentityRequest,
          com.google.longrunning.Operation>
      getProvisionCloudIdentityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ProvisionCloudIdentityRequest,
            com.google.longrunning.Operation>
        getProvisionCloudIdentityMethod;
    if ((getProvisionCloudIdentityMethod = CloudChannelServiceGrpc.getProvisionCloudIdentityMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getProvisionCloudIdentityMethod =
                CloudChannelServiceGrpc.getProvisionCloudIdentityMethod)
            == null) {
          CloudChannelServiceGrpc.getProvisionCloudIdentityMethod =
              getProvisionCloudIdentityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ProvisionCloudIdentityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ProvisionCloudIdentity"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ProvisionCloudIdentityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ProvisionCloudIdentity"))
                      .build();
        }
      }
    }
    return getProvisionCloudIdentityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListEntitlementsRequest,
          com.google.cloud.channel.v1.ListEntitlementsResponse>
      getListEntitlementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntitlements",
      requestType = com.google.cloud.channel.v1.ListEntitlementsRequest.class,
      responseType = com.google.cloud.channel.v1.ListEntitlementsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListEntitlementsRequest,
          com.google.cloud.channel.v1.ListEntitlementsResponse>
      getListEntitlementsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ListEntitlementsRequest,
            com.google.cloud.channel.v1.ListEntitlementsResponse>
        getListEntitlementsMethod;
    if ((getListEntitlementsMethod = CloudChannelServiceGrpc.getListEntitlementsMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getListEntitlementsMethod = CloudChannelServiceGrpc.getListEntitlementsMethod)
            == null) {
          CloudChannelServiceGrpc.getListEntitlementsMethod =
              getListEntitlementsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ListEntitlementsRequest,
                          com.google.cloud.channel.v1.ListEntitlementsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEntitlements"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListEntitlementsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListEntitlementsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ListEntitlements"))
                      .build();
        }
      }
    }
    return getListEntitlementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListTransferableSkusRequest,
          com.google.cloud.channel.v1.ListTransferableSkusResponse>
      getListTransferableSkusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTransferableSkus",
      requestType = com.google.cloud.channel.v1.ListTransferableSkusRequest.class,
      responseType = com.google.cloud.channel.v1.ListTransferableSkusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListTransferableSkusRequest,
          com.google.cloud.channel.v1.ListTransferableSkusResponse>
      getListTransferableSkusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ListTransferableSkusRequest,
            com.google.cloud.channel.v1.ListTransferableSkusResponse>
        getListTransferableSkusMethod;
    if ((getListTransferableSkusMethod = CloudChannelServiceGrpc.getListTransferableSkusMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getListTransferableSkusMethod = CloudChannelServiceGrpc.getListTransferableSkusMethod)
            == null) {
          CloudChannelServiceGrpc.getListTransferableSkusMethod =
              getListTransferableSkusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ListTransferableSkusRequest,
                          com.google.cloud.channel.v1.ListTransferableSkusResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListTransferableSkus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListTransferableSkusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListTransferableSkusResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ListTransferableSkus"))
                      .build();
        }
      }
    }
    return getListTransferableSkusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListTransferableOffersRequest,
          com.google.cloud.channel.v1.ListTransferableOffersResponse>
      getListTransferableOffersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTransferableOffers",
      requestType = com.google.cloud.channel.v1.ListTransferableOffersRequest.class,
      responseType = com.google.cloud.channel.v1.ListTransferableOffersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListTransferableOffersRequest,
          com.google.cloud.channel.v1.ListTransferableOffersResponse>
      getListTransferableOffersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ListTransferableOffersRequest,
            com.google.cloud.channel.v1.ListTransferableOffersResponse>
        getListTransferableOffersMethod;
    if ((getListTransferableOffersMethod = CloudChannelServiceGrpc.getListTransferableOffersMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getListTransferableOffersMethod =
                CloudChannelServiceGrpc.getListTransferableOffersMethod)
            == null) {
          CloudChannelServiceGrpc.getListTransferableOffersMethod =
              getListTransferableOffersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ListTransferableOffersRequest,
                          com.google.cloud.channel.v1.ListTransferableOffersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListTransferableOffers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListTransferableOffersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListTransferableOffersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ListTransferableOffers"))
                      .build();
        }
      }
    }
    return getListTransferableOffersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.GetEntitlementRequest,
          com.google.cloud.channel.v1.Entitlement>
      getGetEntitlementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntitlement",
      requestType = com.google.cloud.channel.v1.GetEntitlementRequest.class,
      responseType = com.google.cloud.channel.v1.Entitlement.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.GetEntitlementRequest,
          com.google.cloud.channel.v1.Entitlement>
      getGetEntitlementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.GetEntitlementRequest,
            com.google.cloud.channel.v1.Entitlement>
        getGetEntitlementMethod;
    if ((getGetEntitlementMethod = CloudChannelServiceGrpc.getGetEntitlementMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getGetEntitlementMethod = CloudChannelServiceGrpc.getGetEntitlementMethod) == null) {
          CloudChannelServiceGrpc.getGetEntitlementMethod =
              getGetEntitlementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.GetEntitlementRequest,
                          com.google.cloud.channel.v1.Entitlement>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEntitlement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.GetEntitlementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.Entitlement.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("GetEntitlement"))
                      .build();
        }
      }
    }
    return getGetEntitlementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.CreateEntitlementRequest, com.google.longrunning.Operation>
      getCreateEntitlementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEntitlement",
      requestType = com.google.cloud.channel.v1.CreateEntitlementRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.CreateEntitlementRequest, com.google.longrunning.Operation>
      getCreateEntitlementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.CreateEntitlementRequest, com.google.longrunning.Operation>
        getCreateEntitlementMethod;
    if ((getCreateEntitlementMethod = CloudChannelServiceGrpc.getCreateEntitlementMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getCreateEntitlementMethod = CloudChannelServiceGrpc.getCreateEntitlementMethod)
            == null) {
          CloudChannelServiceGrpc.getCreateEntitlementMethod =
              getCreateEntitlementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.CreateEntitlementRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEntitlement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.CreateEntitlementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("CreateEntitlement"))
                      .build();
        }
      }
    }
    return getCreateEntitlementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ChangeParametersRequest, com.google.longrunning.Operation>
      getChangeParametersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeParameters",
      requestType = com.google.cloud.channel.v1.ChangeParametersRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ChangeParametersRequest, com.google.longrunning.Operation>
      getChangeParametersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ChangeParametersRequest, com.google.longrunning.Operation>
        getChangeParametersMethod;
    if ((getChangeParametersMethod = CloudChannelServiceGrpc.getChangeParametersMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getChangeParametersMethod = CloudChannelServiceGrpc.getChangeParametersMethod)
            == null) {
          CloudChannelServiceGrpc.getChangeParametersMethod =
              getChangeParametersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ChangeParametersRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ChangeParameters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ChangeParametersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ChangeParameters"))
                      .build();
        }
      }
    }
    return getChangeParametersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ChangeRenewalSettingsRequest,
          com.google.longrunning.Operation>
      getChangeRenewalSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeRenewalSettings",
      requestType = com.google.cloud.channel.v1.ChangeRenewalSettingsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ChangeRenewalSettingsRequest,
          com.google.longrunning.Operation>
      getChangeRenewalSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ChangeRenewalSettingsRequest,
            com.google.longrunning.Operation>
        getChangeRenewalSettingsMethod;
    if ((getChangeRenewalSettingsMethod = CloudChannelServiceGrpc.getChangeRenewalSettingsMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getChangeRenewalSettingsMethod =
                CloudChannelServiceGrpc.getChangeRenewalSettingsMethod)
            == null) {
          CloudChannelServiceGrpc.getChangeRenewalSettingsMethod =
              getChangeRenewalSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ChangeRenewalSettingsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ChangeRenewalSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ChangeRenewalSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ChangeRenewalSettings"))
                      .build();
        }
      }
    }
    return getChangeRenewalSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ChangeOfferRequest, com.google.longrunning.Operation>
      getChangeOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeOffer",
      requestType = com.google.cloud.channel.v1.ChangeOfferRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ChangeOfferRequest, com.google.longrunning.Operation>
      getChangeOfferMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ChangeOfferRequest, com.google.longrunning.Operation>
        getChangeOfferMethod;
    if ((getChangeOfferMethod = CloudChannelServiceGrpc.getChangeOfferMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getChangeOfferMethod = CloudChannelServiceGrpc.getChangeOfferMethod) == null) {
          CloudChannelServiceGrpc.getChangeOfferMethod =
              getChangeOfferMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ChangeOfferRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ChangeOffer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ChangeOfferRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ChangeOffer"))
                      .build();
        }
      }
    }
    return getChangeOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.StartPaidServiceRequest, com.google.longrunning.Operation>
      getStartPaidServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartPaidService",
      requestType = com.google.cloud.channel.v1.StartPaidServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.StartPaidServiceRequest, com.google.longrunning.Operation>
      getStartPaidServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.StartPaidServiceRequest, com.google.longrunning.Operation>
        getStartPaidServiceMethod;
    if ((getStartPaidServiceMethod = CloudChannelServiceGrpc.getStartPaidServiceMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getStartPaidServiceMethod = CloudChannelServiceGrpc.getStartPaidServiceMethod)
            == null) {
          CloudChannelServiceGrpc.getStartPaidServiceMethod =
              getStartPaidServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.StartPaidServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartPaidService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.StartPaidServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("StartPaidService"))
                      .build();
        }
      }
    }
    return getStartPaidServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.SuspendEntitlementRequest, com.google.longrunning.Operation>
      getSuspendEntitlementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SuspendEntitlement",
      requestType = com.google.cloud.channel.v1.SuspendEntitlementRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.SuspendEntitlementRequest, com.google.longrunning.Operation>
      getSuspendEntitlementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.SuspendEntitlementRequest, com.google.longrunning.Operation>
        getSuspendEntitlementMethod;
    if ((getSuspendEntitlementMethod = CloudChannelServiceGrpc.getSuspendEntitlementMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getSuspendEntitlementMethod = CloudChannelServiceGrpc.getSuspendEntitlementMethod)
            == null) {
          CloudChannelServiceGrpc.getSuspendEntitlementMethod =
              getSuspendEntitlementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.SuspendEntitlementRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SuspendEntitlement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.SuspendEntitlementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("SuspendEntitlement"))
                      .build();
        }
      }
    }
    return getSuspendEntitlementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.CancelEntitlementRequest, com.google.longrunning.Operation>
      getCancelEntitlementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelEntitlement",
      requestType = com.google.cloud.channel.v1.CancelEntitlementRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.CancelEntitlementRequest, com.google.longrunning.Operation>
      getCancelEntitlementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.CancelEntitlementRequest, com.google.longrunning.Operation>
        getCancelEntitlementMethod;
    if ((getCancelEntitlementMethod = CloudChannelServiceGrpc.getCancelEntitlementMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getCancelEntitlementMethod = CloudChannelServiceGrpc.getCancelEntitlementMethod)
            == null) {
          CloudChannelServiceGrpc.getCancelEntitlementMethod =
              getCancelEntitlementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.CancelEntitlementRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelEntitlement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.CancelEntitlementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("CancelEntitlement"))
                      .build();
        }
      }
    }
    return getCancelEntitlementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ActivateEntitlementRequest, com.google.longrunning.Operation>
      getActivateEntitlementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ActivateEntitlement",
      requestType = com.google.cloud.channel.v1.ActivateEntitlementRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ActivateEntitlementRequest, com.google.longrunning.Operation>
      getActivateEntitlementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ActivateEntitlementRequest,
            com.google.longrunning.Operation>
        getActivateEntitlementMethod;
    if ((getActivateEntitlementMethod = CloudChannelServiceGrpc.getActivateEntitlementMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getActivateEntitlementMethod = CloudChannelServiceGrpc.getActivateEntitlementMethod)
            == null) {
          CloudChannelServiceGrpc.getActivateEntitlementMethod =
              getActivateEntitlementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ActivateEntitlementRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ActivateEntitlement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ActivateEntitlementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ActivateEntitlement"))
                      .build();
        }
      }
    }
    return getActivateEntitlementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.TransferEntitlementsRequest, com.google.longrunning.Operation>
      getTransferEntitlementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TransferEntitlements",
      requestType = com.google.cloud.channel.v1.TransferEntitlementsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.TransferEntitlementsRequest, com.google.longrunning.Operation>
      getTransferEntitlementsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.TransferEntitlementsRequest,
            com.google.longrunning.Operation>
        getTransferEntitlementsMethod;
    if ((getTransferEntitlementsMethod = CloudChannelServiceGrpc.getTransferEntitlementsMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getTransferEntitlementsMethod = CloudChannelServiceGrpc.getTransferEntitlementsMethod)
            == null) {
          CloudChannelServiceGrpc.getTransferEntitlementsMethod =
              getTransferEntitlementsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.TransferEntitlementsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "TransferEntitlements"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.TransferEntitlementsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("TransferEntitlements"))
                      .build();
        }
      }
    }
    return getTransferEntitlementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest,
          com.google.longrunning.Operation>
      getTransferEntitlementsToGoogleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TransferEntitlementsToGoogle",
      requestType = com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest,
          com.google.longrunning.Operation>
      getTransferEntitlementsToGoogleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest,
            com.google.longrunning.Operation>
        getTransferEntitlementsToGoogleMethod;
    if ((getTransferEntitlementsToGoogleMethod =
            CloudChannelServiceGrpc.getTransferEntitlementsToGoogleMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getTransferEntitlementsToGoogleMethod =
                CloudChannelServiceGrpc.getTransferEntitlementsToGoogleMethod)
            == null) {
          CloudChannelServiceGrpc.getTransferEntitlementsToGoogleMethod =
              getTransferEntitlementsToGoogleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "TransferEntitlementsToGoogle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier(
                              "TransferEntitlementsToGoogle"))
                      .build();
        }
      }
    }
    return getTransferEntitlementsToGoogleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListChannelPartnerLinksRequest,
          com.google.cloud.channel.v1.ListChannelPartnerLinksResponse>
      getListChannelPartnerLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListChannelPartnerLinks",
      requestType = com.google.cloud.channel.v1.ListChannelPartnerLinksRequest.class,
      responseType = com.google.cloud.channel.v1.ListChannelPartnerLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListChannelPartnerLinksRequest,
          com.google.cloud.channel.v1.ListChannelPartnerLinksResponse>
      getListChannelPartnerLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ListChannelPartnerLinksRequest,
            com.google.cloud.channel.v1.ListChannelPartnerLinksResponse>
        getListChannelPartnerLinksMethod;
    if ((getListChannelPartnerLinksMethod =
            CloudChannelServiceGrpc.getListChannelPartnerLinksMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getListChannelPartnerLinksMethod =
                CloudChannelServiceGrpc.getListChannelPartnerLinksMethod)
            == null) {
          CloudChannelServiceGrpc.getListChannelPartnerLinksMethod =
              getListChannelPartnerLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ListChannelPartnerLinksRequest,
                          com.google.cloud.channel.v1.ListChannelPartnerLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListChannelPartnerLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListChannelPartnerLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListChannelPartnerLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier(
                              "ListChannelPartnerLinks"))
                      .build();
        }
      }
    }
    return getListChannelPartnerLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.GetChannelPartnerLinkRequest,
          com.google.cloud.channel.v1.ChannelPartnerLink>
      getGetChannelPartnerLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChannelPartnerLink",
      requestType = com.google.cloud.channel.v1.GetChannelPartnerLinkRequest.class,
      responseType = com.google.cloud.channel.v1.ChannelPartnerLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.GetChannelPartnerLinkRequest,
          com.google.cloud.channel.v1.ChannelPartnerLink>
      getGetChannelPartnerLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.GetChannelPartnerLinkRequest,
            com.google.cloud.channel.v1.ChannelPartnerLink>
        getGetChannelPartnerLinkMethod;
    if ((getGetChannelPartnerLinkMethod = CloudChannelServiceGrpc.getGetChannelPartnerLinkMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getGetChannelPartnerLinkMethod =
                CloudChannelServiceGrpc.getGetChannelPartnerLinkMethod)
            == null) {
          CloudChannelServiceGrpc.getGetChannelPartnerLinkMethod =
              getGetChannelPartnerLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.GetChannelPartnerLinkRequest,
                          com.google.cloud.channel.v1.ChannelPartnerLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetChannelPartnerLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.GetChannelPartnerLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ChannelPartnerLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("GetChannelPartnerLink"))
                      .build();
        }
      }
    }
    return getGetChannelPartnerLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest,
          com.google.cloud.channel.v1.ChannelPartnerLink>
      getCreateChannelPartnerLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateChannelPartnerLink",
      requestType = com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest.class,
      responseType = com.google.cloud.channel.v1.ChannelPartnerLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest,
          com.google.cloud.channel.v1.ChannelPartnerLink>
      getCreateChannelPartnerLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest,
            com.google.cloud.channel.v1.ChannelPartnerLink>
        getCreateChannelPartnerLinkMethod;
    if ((getCreateChannelPartnerLinkMethod =
            CloudChannelServiceGrpc.getCreateChannelPartnerLinkMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getCreateChannelPartnerLinkMethod =
                CloudChannelServiceGrpc.getCreateChannelPartnerLinkMethod)
            == null) {
          CloudChannelServiceGrpc.getCreateChannelPartnerLinkMethod =
              getCreateChannelPartnerLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest,
                          com.google.cloud.channel.v1.ChannelPartnerLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateChannelPartnerLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ChannelPartnerLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier(
                              "CreateChannelPartnerLink"))
                      .build();
        }
      }
    }
    return getCreateChannelPartnerLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest,
          com.google.cloud.channel.v1.ChannelPartnerLink>
      getUpdateChannelPartnerLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateChannelPartnerLink",
      requestType = com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest.class,
      responseType = com.google.cloud.channel.v1.ChannelPartnerLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest,
          com.google.cloud.channel.v1.ChannelPartnerLink>
      getUpdateChannelPartnerLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest,
            com.google.cloud.channel.v1.ChannelPartnerLink>
        getUpdateChannelPartnerLinkMethod;
    if ((getUpdateChannelPartnerLinkMethod =
            CloudChannelServiceGrpc.getUpdateChannelPartnerLinkMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getUpdateChannelPartnerLinkMethod =
                CloudChannelServiceGrpc.getUpdateChannelPartnerLinkMethod)
            == null) {
          CloudChannelServiceGrpc.getUpdateChannelPartnerLinkMethod =
              getUpdateChannelPartnerLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest,
                          com.google.cloud.channel.v1.ChannelPartnerLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateChannelPartnerLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ChannelPartnerLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier(
                              "UpdateChannelPartnerLink"))
                      .build();
        }
      }
    }
    return getUpdateChannelPartnerLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListProductsRequest,
          com.google.cloud.channel.v1.ListProductsResponse>
      getListProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProducts",
      requestType = com.google.cloud.channel.v1.ListProductsRequest.class,
      responseType = com.google.cloud.channel.v1.ListProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListProductsRequest,
          com.google.cloud.channel.v1.ListProductsResponse>
      getListProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ListProductsRequest,
            com.google.cloud.channel.v1.ListProductsResponse>
        getListProductsMethod;
    if ((getListProductsMethod = CloudChannelServiceGrpc.getListProductsMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getListProductsMethod = CloudChannelServiceGrpc.getListProductsMethod) == null) {
          CloudChannelServiceGrpc.getListProductsMethod =
              getListProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ListProductsRequest,
                          com.google.cloud.channel.v1.ListProductsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListProductsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListProductsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ListProducts"))
                      .build();
        }
      }
    }
    return getListProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListSkusRequest, com.google.cloud.channel.v1.ListSkusResponse>
      getListSkusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSkus",
      requestType = com.google.cloud.channel.v1.ListSkusRequest.class,
      responseType = com.google.cloud.channel.v1.ListSkusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListSkusRequest, com.google.cloud.channel.v1.ListSkusResponse>
      getListSkusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ListSkusRequest,
            com.google.cloud.channel.v1.ListSkusResponse>
        getListSkusMethod;
    if ((getListSkusMethod = CloudChannelServiceGrpc.getListSkusMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getListSkusMethod = CloudChannelServiceGrpc.getListSkusMethod) == null) {
          CloudChannelServiceGrpc.getListSkusMethod =
              getListSkusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ListSkusRequest,
                          com.google.cloud.channel.v1.ListSkusResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSkus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListSkusRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListSkusResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ListSkus"))
                      .build();
        }
      }
    }
    return getListSkusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListOffersRequest,
          com.google.cloud.channel.v1.ListOffersResponse>
      getListOffersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOffers",
      requestType = com.google.cloud.channel.v1.ListOffersRequest.class,
      responseType = com.google.cloud.channel.v1.ListOffersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListOffersRequest,
          com.google.cloud.channel.v1.ListOffersResponse>
      getListOffersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ListOffersRequest,
            com.google.cloud.channel.v1.ListOffersResponse>
        getListOffersMethod;
    if ((getListOffersMethod = CloudChannelServiceGrpc.getListOffersMethod) == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getListOffersMethod = CloudChannelServiceGrpc.getListOffersMethod) == null) {
          CloudChannelServiceGrpc.getListOffersMethod =
              getListOffersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ListOffersRequest,
                          com.google.cloud.channel.v1.ListOffersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOffers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListOffersRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListOffersResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ListOffers"))
                      .build();
        }
      }
    }
    return getListOffersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListPurchasableSkusRequest,
          com.google.cloud.channel.v1.ListPurchasableSkusResponse>
      getListPurchasableSkusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPurchasableSkus",
      requestType = com.google.cloud.channel.v1.ListPurchasableSkusRequest.class,
      responseType = com.google.cloud.channel.v1.ListPurchasableSkusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListPurchasableSkusRequest,
          com.google.cloud.channel.v1.ListPurchasableSkusResponse>
      getListPurchasableSkusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ListPurchasableSkusRequest,
            com.google.cloud.channel.v1.ListPurchasableSkusResponse>
        getListPurchasableSkusMethod;
    if ((getListPurchasableSkusMethod = CloudChannelServiceGrpc.getListPurchasableSkusMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getListPurchasableSkusMethod = CloudChannelServiceGrpc.getListPurchasableSkusMethod)
            == null) {
          CloudChannelServiceGrpc.getListPurchasableSkusMethod =
              getListPurchasableSkusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ListPurchasableSkusRequest,
                          com.google.cloud.channel.v1.ListPurchasableSkusResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPurchasableSkus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListPurchasableSkusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListPurchasableSkusResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ListPurchasableSkus"))
                      .build();
        }
      }
    }
    return getListPurchasableSkusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListPurchasableOffersRequest,
          com.google.cloud.channel.v1.ListPurchasableOffersResponse>
      getListPurchasableOffersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPurchasableOffers",
      requestType = com.google.cloud.channel.v1.ListPurchasableOffersRequest.class,
      responseType = com.google.cloud.channel.v1.ListPurchasableOffersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.channel.v1.ListPurchasableOffersRequest,
          com.google.cloud.channel.v1.ListPurchasableOffersResponse>
      getListPurchasableOffersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.channel.v1.ListPurchasableOffersRequest,
            com.google.cloud.channel.v1.ListPurchasableOffersResponse>
        getListPurchasableOffersMethod;
    if ((getListPurchasableOffersMethod = CloudChannelServiceGrpc.getListPurchasableOffersMethod)
        == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        if ((getListPurchasableOffersMethod =
                CloudChannelServiceGrpc.getListPurchasableOffersMethod)
            == null) {
          CloudChannelServiceGrpc.getListPurchasableOffersMethod =
              getListPurchasableOffersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.channel.v1.ListPurchasableOffersRequest,
                          com.google.cloud.channel.v1.ListPurchasableOffersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPurchasableOffers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListPurchasableOffersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.channel.v1.ListPurchasableOffersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudChannelServiceMethodDescriptorSupplier("ListPurchasableOffers"))
                      .build();
        }
      }
    }
    return getListPurchasableOffersMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudChannelServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudChannelServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudChannelServiceStub>() {
          @java.lang.Override
          public CloudChannelServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudChannelServiceStub(channel, callOptions);
          }
        };
    return CloudChannelServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudChannelServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudChannelServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudChannelServiceBlockingStub>() {
          @java.lang.Override
          public CloudChannelServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudChannelServiceBlockingStub(channel, callOptions);
          }
        };
    return CloudChannelServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudChannelServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudChannelServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudChannelServiceFutureStub>() {
          @java.lang.Override
          public CloudChannelServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudChannelServiceFutureStub(channel, callOptions);
          }
        };
    return CloudChannelServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * CloudChannelService enables Google cloud resellers and distributors to manage
   * their customers, channel partners, entitlements and reports.
   * Using this service:
   * 1. Resellers or distributors can manage a customer entity.
   * 2. Distributors can register an authorized reseller in their channel and then
   *    enable delegated admin access for the reseller.
   * 3. Resellers or distributors can manage entitlements for their customers.
   * The service primarily exposes the following resources:
   * - [Customer][google.cloud.channel.v1.Customer]s: A Customer represents an entity managed by a reseller or
   * distributor. A customer typically represents an enterprise. In an n-tier
   * resale channel hierarchy, customers are generally represented as leaf nodes.
   * Customers primarily have an Entitlement sub-resource discussed below.
   * - [Entitlement][google.cloud.channel.v1.Entitlement]s: An Entitlement represents an entity which provides a
   * customer means to start using a service. Entitlements are created or updated
   * as a result of a successful fulfillment.
   * - [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s: A ChannelPartnerLink is an entity that identifies
   * links between distributors and their indirect resellers in a channel.
   * </pre>
   */
  public abstract static class CloudChannelServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * List downstream [Customer][google.cloud.channel.v1.Customer]s.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * Return Value:
     * &lt;br/&gt; List of [Customer][google.cloud.channel.v1.Customer]s pertaining to the reseller or empty list if
     * there are none.
     * </pre>
     */
    public void listCustomers(
        com.google.cloud.channel.v1.ListCustomersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListCustomersResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListCustomersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a requested [Customer][google.cloud.channel.v1.Customer] resource.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: If the customer resource doesn't exist. Usually
     * the result of an invalid name parameter.
     * Return Value:
     * &lt;br/&gt; [Customer][google.cloud.channel.v1.Customer] resource if found, error otherwise.
     * </pre>
     */
    public void getCustomer(
        com.google.cloud.channel.v1.GetCustomerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.Customer> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCustomerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Confirms the existence of Cloud Identity accounts, based on the domain and
     * whether the Cloud Identity accounts are owned by the reseller.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * INVALID_VALUE: Invalid domain value in the request.
     * * NOT_FOUND: If there is no [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] customer
     * for the domain specified in the request.
     * Return Value:
     * &lt;br/&gt; List of [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] resources if any exist for
     * the domain, otherwise an error is returned.
     * </pre>
     */
    public void checkCloudIdentityAccountsExist(
        com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCheckCloudIdentityAccountsExistMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [Customer][google.cloud.channel.v1.Customer] resource under the reseller or distributor
     * account.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt;PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.&lt;/li&gt;
     * &lt;li&gt; INVALID_ARGUMENT:
     * &lt;ul&gt;
     *  &lt;li&gt; Missing or invalid required parameters in the request. &lt;/li&gt;
     *  &lt;li&gt; Domain field value doesn't match the domain specified in primary
     *  email.&lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; If successful, the newly created [Customer][google.cloud.channel.v1.Customer] resource, otherwise
     * returns an error.
     * </pre>
     */
    public void createCustomer(
        com.google.cloud.channel.v1.CreateCustomerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.Customer> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateCustomerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing [Customer][google.cloud.channel.v1.Customer] resource belonging to the reseller or
     * distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
     * specified in the request.
     * Return Value:
     * &lt;br/&gt; If successful, the updated [Customer][google.cloud.channel.v1.Customer] resource, otherwise returns
     * an error.
     * </pre>
     */
    public void updateCustomer(
        com.google.cloud.channel.v1.UpdateCustomerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.Customer> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCustomerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the given [Customer][google.cloud.channel.v1.Customer] permanently and irreversibly.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the account making the request does not own
     * this customer.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * FAILED_PRECONDITION: If the customer has existing entitlements.
     * * NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
     * specified in the request.
     * </pre>
     */
    public void deleteCustomer(
        com.google.cloud.channel.v1.DeleteCustomerRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteCustomerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Cloud Identity for the given customer using the customer's
     * information or the information provided here, if present.
     * Possible Error Codes:
     * *  PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * *  INVALID_ARGUMENT: Missing or invalid required parameters in the request.
     * *  NOT_FOUND: If the customer is not found for the reseller.
     * *  ALREADY_EXISTS: If the customer's primary email already exists. In this
     *    case, retry after changing the customer's primary contact email.
     * *  INTERNAL: Any non-user error related to a technical issue in the
     *    backend. Contact Cloud Channel support in this case.
     * *  UNKNOWN: Any non-user error related to a technical issue in the backend.
     *    Contact Cloud Channel support in this case.
     * Return Value:
     * &lt;br/&gt;  Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void provisionCloudIdentity(
        com.google.cloud.channel.v1.ProvisionCloudIdentityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getProvisionCloudIdentityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to a customer.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the request.
     * Return Value:
     * &lt;br/&gt; List of [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to the customer, or empty list if
     * there are none.
     * </pre>
     */
    public void listEntitlements(
        com.google.cloud.channel.v1.ListEntitlementsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListEntitlementsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListEntitlementsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List [TransferableSku][google.cloud.channel.v1.TransferableSku]s of a customer based on Cloud Identity ID or
     * Customer Name in the request.
     * This method is used when a reseller lists the entitlements
     * information of a customer that is not owned. The reseller should provide
     * the customer's Cloud Identity ID or Customer Name.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt;PERMISSION_DENIED, due to one of the following reasons:
     * &lt;ul&gt;
     *    &lt;li&gt; If the customer doesn't belong to the reseller and no auth token,
     *    or an invalid auth token is supplied. &lt;/li&gt; &lt;li&gt; If the reseller account
     *    making the request and the reseller account being queried for are
     *    different. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.&lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; List of [TransferableSku][google.cloud.channel.v1.TransferableSku] for the given customer.
     * </pre>
     */
    public void listTransferableSkus(
        com.google.cloud.channel.v1.ListTransferableSkusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListTransferableSkusResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListTransferableSkusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List [TransferableOffer][google.cloud.channel.v1.TransferableOffer]s of a customer based on Cloud Identity ID or
     * Customer Name in the request.
     * This method is used when a reseller gets the entitlement
     * information of a customer that is not owned. The reseller should provide
     * the customer's Cloud Identity ID or Customer Name.
     * Possible Error Codes:
     * * PERMISSION_DENIED, due to one of the following reasons: (a) If the
     * customer doesn't belong to the reseller and no auth token or invalid auth
     * token is supplied. (b) If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * Return Value:
     * List of [TransferableOffer][google.cloud.channel.v1.TransferableOffer] for the given customer and SKU.
     * </pre>
     */
    public void listTransferableOffers(
        com.google.cloud.channel.v1.ListTransferableOffersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListTransferableOffersResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListTransferableOffersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a requested [Entitlement][google.cloud.channel.v1.Entitlement] resource.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: If the entitlement is not found for the customer.
     * Return Value:
     * &lt;br/&gt; If found, the requested [Entitlement][google.cloud.channel.v1.Entitlement] resource, otherwise returns
     * an error.
     * </pre>
     */
    public void getEntitlement(
        com.google.cloud.channel.v1.GetEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.Entitlement> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEntitlementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an entitlement for a customer.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: &lt;ul&gt;
     *   &lt;li&gt; Missing or invalid required parameters in the request. &lt;/li&gt;
     *   &lt;li&gt; Cannot purchase an entitlement if there is already an
     *    entitlement for customer, for a SKU from the same product family. &lt;/li&gt;
     *   &lt;li&gt; INVALID_VALUE: Offer passed in isn't valid. Make sure OfferId is
     * valid. If it is valid, then contact Google Channel support for further
     * troubleshooting. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; NOT_FOUND: If the customer or offer resource is not found for the
     * reseller. &lt;/li&gt;
     * &lt;li&gt; ALREADY_EXISTS: This failure can happen in the following cases:
     *   &lt;ul&gt;
     *     &lt;li&gt;If the SKU has been already purchased for the customer.&lt;/li&gt;
     *     &lt;li&gt;If the customer's primary email already exists. In this case retry
     *         after changing the customer's primary contact email.
     *     &lt;/li&gt;
     *   &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; CONDITION_NOT_MET or FAILED_PRECONDITION: This
     * failure can happen in the following cases:
     * &lt;ul&gt;
     *    &lt;li&gt; Purchasing a SKU that requires domain verification and the
     *    domain has not been verified. &lt;/li&gt;
     *    &lt;li&gt; Purchasing an Add-On SKU like Vault or Drive without purchasing
     *    the pre-requisite SKU, such as Google Workspace Business Starter. &lt;/li&gt;
     *    &lt;li&gt; Applicable only for developer accounts: reseller and resold
     *    domain. Must meet the following domain naming requirements:
     *     &lt;ul&gt;
     *       &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt;
     *       &lt;li&gt; Resold domain names must include the reseller domain. &lt;/li&gt;
     *     &lt;/ul&gt;
     *    &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. Contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. Contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void createEntitlement(
        com.google.cloud.channel.v1.CreateEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateEntitlementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Change parameters of the entitlement
     * An entitlement parameters update is a long-running operation and results in
     * updates to the entitlement as a result of fulfillment.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request. For example, if the number of seats being changed to is greater
     * than the allowed number of max seats for the resource. Or decreasing seats
     * for a commitment based plan.
     * * NOT_FOUND: Entitlement resource not found.
     * * INTERNAL: Any non-user error related to a technical issue
     * in the backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void changeParameters(
        com.google.cloud.channel.v1.ChangeParametersRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeParametersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the renewal settings for an existing customer entitlement.
     * An entitlement update is a long-running operation and results in updates to
     * the entitlement as a result of fulfillment.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * NOT_COMMITMENT_PLAN: Renewal Settings are only applicable for a
     * commitment plan. Can't enable or disable renewal for non-commitment plans.
     * * INTERNAL: Any non user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void changeRenewalSettings(
        com.google.cloud.channel.v1.ChangeRenewalSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeRenewalSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Offer for an existing customer entitlement.
     * An entitlement update is a long-running operation and results in updates to
     * the entitlement as a result of fulfillment.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Offer or Entitlement resource not found.
     * * INTERNAL: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void changeOffer(
        com.google.cloud.channel.v1.ChangeOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeOfferMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts paid service for a trial entitlement.
     * Starts paid service for a trial entitlement immediately. This method is
     * only applicable if a plan has already been set up for a trial entitlement
     * but has some trial days remaining.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * FAILED_PRECONDITION/NOT_IN_TRIAL: This method only works for
     * entitlement on trial plans.
     * * INTERNAL: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue
     * in the backend. In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void startPaidService(
        com.google.cloud.channel.v1.StartPaidServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getStartPaidServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Suspends a previously fulfilled entitlement.
     * An entitlement suspension is a long-running operation.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * NOT_ACTIVE: Entitlement is not active.
     * * INTERNAL: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void suspendEntitlement(
        com.google.cloud.channel.v1.SuspendEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getSuspendEntitlementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a previously fulfilled entitlement.
     * An entitlement cancellation is a long-running operation.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller or
     * if the reseller account making the request and reseller account being
     * queried for are different.
     * * FAILED_PRECONDITION: If there are any Google Cloud projects linked to the
     * Google Cloud entitlement's Cloud Billing subaccount.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * DELETION_TYPE_NOT_ALLOWED: Cancel is only allowed for Google Workspace
     * add-ons or entitlements for Google Cloud's development platform.
     * * INTERNAL: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The response will contain
     * google.protobuf.Empty on success. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void cancelEntitlement(
        com.google.cloud.channel.v1.CancelEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelEntitlementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Activates a previously suspended entitlement. The entitlement must be in a
     * suspended state for it to be activated. Entitlements suspended for pending
     * ToS acceptance can't be activated using this method. An entitlement
     * activation is a long-running operation and can result in updates to
     * the state of the customer entitlement.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller or
     * if the reseller account making the request and reseller account being
     * queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * SUSPENSION_NOT_RESELLER_INITIATED: Can't activate an
     * entitlement that is pending TOS acceptance. Only reseller initiated
     * suspensions can be activated.
     * * NOT_SUSPENDED: Can't activate entitlements that are already in ACTIVE
     * state. Can only activate suspended entitlements.
     * * INTERNAL: Any non-user error related to a technical issue
     * in the backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void activateEntitlement(
        com.google.cloud.channel.v1.ActivateEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getActivateEntitlementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Transfers customer entitlements to new reseller.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the customer doesn't belong to the
     * reseller.&lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required
     * parameters in the request. &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer
     * resource is not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: If the
     * SKU has been already transferred for the customer. &lt;/li&gt; &lt;li&gt;
     * CONDITION_NOT_MET or FAILED_PRECONDITION: This failure can happen in the
     * following cases: &lt;ul&gt;
     *    &lt;li&gt; Transferring a SKU that requires domain verification and the
     * domain has not been verified. &lt;/li&gt;
     *    &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without transferring
     * the pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for
     * developer accounts: reseller and resold domain must follow the domain
     * naming convention as follows:
     *      &lt;ul&gt;
     *         &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt;
     *         &lt;li&gt; Resold domain names must include the reseller domain. &lt;/li&gt;
     *      &lt;/ul&gt;
     *   &lt;/li&gt;
     *   &lt;li&gt; All transferring entitlements must be specified. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void transferEntitlements(
        com.google.cloud.channel.v1.TransferEntitlementsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getTransferEntitlementsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Transfers customer entitlements from current reseller to Google.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request. &lt;/li&gt;
     * &lt;li&gt; NOT_FOUND: If the customer or offer resource is not found
     * for the reseller. &lt;/li&gt;
     * &lt;li&gt; ALREADY_EXISTS: If the SKU has been already
     * transferred for the customer. &lt;/li&gt;
     * &lt;li&gt; CONDITION_NOT_MET or FAILED_PRECONDITION: This failure can happen in
     * the following cases:
     * &lt;ul&gt;
     *    &lt;li&gt; Transferring a SKU that requires domain verification and the
     * domain has not been verified. &lt;/li&gt;
     *    &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without purchasing
     * the pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for
     * developer accounts: reseller and resold domain must follow the domain
     * naming convention as follows:
     *      &lt;ul&gt;
     *         &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt;
     *         &lt;li&gt; Resold domain names must include the reseller domain. &lt;/li&gt;
     *      &lt;/ul&gt;
     *    &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case.&lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The response will contain
     * google.protobuf.Empty on success. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void transferEntitlementsToGoogle(
        com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getTransferEntitlementsToGoogleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s belonging to a distributor.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * Return Value:
     * &lt;br/&gt; If successful, returns the list of [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resources
     * for the distributor account, otherwise returns an error.
     * </pre>
     */
    public void listChannelPartnerLinks(
        com.google.cloud.channel.v1.ListChannelPartnerLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListChannelPartnerLinksResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListChannelPartnerLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a requested [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: ChannelPartnerLink resource not found. Results
     * due invalid channel partner link name.
     * Return Value:
     * &lt;br/&gt; [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource if found, otherwise returns an error.
     * </pre>
     */
    public void getChannelPartnerLink(
        com.google.cloud.channel.v1.GetChannelPartnerLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ChannelPartnerLink>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetChannelPartnerLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a channel partner link between a distributor and a reseller or
     * between resellers in an n-tier reseller channel.
     * To accept the invite, the invited partner should follow the invite_link_uri
     * provided in the response. If the link creation is accepted, a valid link is
     * set up between the two involved parties.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * ALREADY_EXISTS: If the ChannelPartnerLink sent in the request already
     * exists.
     * * NOT_FOUND: If no Cloud Identity customer exists for domain provided.
     * * INTERNAL: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in
     * the backend. In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Newly created [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource if successful,
     * otherwise error is returned.
     * </pre>
     */
    public void createChannelPartnerLink(
        com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ChannelPartnerLink>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateChannelPartnerLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a channel partner link. A distributor calls this method to change a
     * link's status. For example, suspend a partner link.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different. &lt;/li&gt;
     * &lt;li&gt; INVALID_ARGUMENT:
     * &lt;ul&gt;
     *   &lt;li&gt; Missing or invalid required parameters in the request. &lt;/li&gt;
     *   &lt;li&gt; Updating link state from invited to active or suspended. &lt;/li&gt;
     *   &lt;li&gt; Sending reseller_cloud_identity_id, invite_url or name in update
     *   mask. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; NOT_FOUND: ChannelPartnerLink resource not found.&lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.&lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; If successful, the updated [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource, otherwise
     * returns an error.
     * </pre>
     */
    public void updateChannelPartnerLink(
        com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ChannelPartnerLink>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateChannelPartnerLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Products the reseller is authorized to sell.
     * Possible Error Codes:
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public void listProducts(
        com.google.cloud.channel.v1.ListProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListProductsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListProductsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the SKUs for a product the reseller is authorized to sell.
     * Possible Error Codes:
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public void listSkus(
        com.google.cloud.channel.v1.ListSkusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListSkusResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListSkusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Offers the reseller can sell.
     * Possible Error Codes:
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public void listOffers(
        com.google.cloud.channel.v1.ListOffersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListOffersResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListOffersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Purchasable SKUs for following cases:
     * * SKUs that can be newly purchased for a customer
     * * SKUs that can be upgraded/downgraded to, for an entitlement.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public void listPurchasableSkus(
        com.google.cloud.channel.v1.ListPurchasableSkusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListPurchasableSkusResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListPurchasableSkusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Purchasable Offers for the following cases:
     * * Offers that can be newly purchased for a customer
     * * Offers that can be changed to, for an entitlement.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public void listPurchasableOffers(
        com.google.cloud.channel.v1.ListPurchasableOffersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListPurchasableOffersResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListPurchasableOffersMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListCustomersMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ListCustomersRequest,
                      com.google.cloud.channel.v1.ListCustomersResponse>(
                      this, METHODID_LIST_CUSTOMERS)))
          .addMethod(
              getGetCustomerMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.GetCustomerRequest,
                      com.google.cloud.channel.v1.Customer>(this, METHODID_GET_CUSTOMER)))
          .addMethod(
              getCheckCloudIdentityAccountsExistMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest,
                      com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse>(
                      this, METHODID_CHECK_CLOUD_IDENTITY_ACCOUNTS_EXIST)))
          .addMethod(
              getCreateCustomerMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.CreateCustomerRequest,
                      com.google.cloud.channel.v1.Customer>(this, METHODID_CREATE_CUSTOMER)))
          .addMethod(
              getUpdateCustomerMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.UpdateCustomerRequest,
                      com.google.cloud.channel.v1.Customer>(this, METHODID_UPDATE_CUSTOMER)))
          .addMethod(
              getDeleteCustomerMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.DeleteCustomerRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_CUSTOMER)))
          .addMethod(
              getProvisionCloudIdentityMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ProvisionCloudIdentityRequest,
                      com.google.longrunning.Operation>(this, METHODID_PROVISION_CLOUD_IDENTITY)))
          .addMethod(
              getListEntitlementsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ListEntitlementsRequest,
                      com.google.cloud.channel.v1.ListEntitlementsResponse>(
                      this, METHODID_LIST_ENTITLEMENTS)))
          .addMethod(
              getListTransferableSkusMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ListTransferableSkusRequest,
                      com.google.cloud.channel.v1.ListTransferableSkusResponse>(
                      this, METHODID_LIST_TRANSFERABLE_SKUS)))
          .addMethod(
              getListTransferableOffersMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ListTransferableOffersRequest,
                      com.google.cloud.channel.v1.ListTransferableOffersResponse>(
                      this, METHODID_LIST_TRANSFERABLE_OFFERS)))
          .addMethod(
              getGetEntitlementMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.GetEntitlementRequest,
                      com.google.cloud.channel.v1.Entitlement>(this, METHODID_GET_ENTITLEMENT)))
          .addMethod(
              getCreateEntitlementMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.CreateEntitlementRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_ENTITLEMENT)))
          .addMethod(
              getChangeParametersMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ChangeParametersRequest,
                      com.google.longrunning.Operation>(this, METHODID_CHANGE_PARAMETERS)))
          .addMethod(
              getChangeRenewalSettingsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ChangeRenewalSettingsRequest,
                      com.google.longrunning.Operation>(this, METHODID_CHANGE_RENEWAL_SETTINGS)))
          .addMethod(
              getChangeOfferMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ChangeOfferRequest,
                      com.google.longrunning.Operation>(this, METHODID_CHANGE_OFFER)))
          .addMethod(
              getStartPaidServiceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.StartPaidServiceRequest,
                      com.google.longrunning.Operation>(this, METHODID_START_PAID_SERVICE)))
          .addMethod(
              getSuspendEntitlementMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.SuspendEntitlementRequest,
                      com.google.longrunning.Operation>(this, METHODID_SUSPEND_ENTITLEMENT)))
          .addMethod(
              getCancelEntitlementMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.CancelEntitlementRequest,
                      com.google.longrunning.Operation>(this, METHODID_CANCEL_ENTITLEMENT)))
          .addMethod(
              getActivateEntitlementMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ActivateEntitlementRequest,
                      com.google.longrunning.Operation>(this, METHODID_ACTIVATE_ENTITLEMENT)))
          .addMethod(
              getTransferEntitlementsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.TransferEntitlementsRequest,
                      com.google.longrunning.Operation>(this, METHODID_TRANSFER_ENTITLEMENTS)))
          .addMethod(
              getTransferEntitlementsToGoogleMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_TRANSFER_ENTITLEMENTS_TO_GOOGLE)))
          .addMethod(
              getListChannelPartnerLinksMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ListChannelPartnerLinksRequest,
                      com.google.cloud.channel.v1.ListChannelPartnerLinksResponse>(
                      this, METHODID_LIST_CHANNEL_PARTNER_LINKS)))
          .addMethod(
              getGetChannelPartnerLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.GetChannelPartnerLinkRequest,
                      com.google.cloud.channel.v1.ChannelPartnerLink>(
                      this, METHODID_GET_CHANNEL_PARTNER_LINK)))
          .addMethod(
              getCreateChannelPartnerLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest,
                      com.google.cloud.channel.v1.ChannelPartnerLink>(
                      this, METHODID_CREATE_CHANNEL_PARTNER_LINK)))
          .addMethod(
              getUpdateChannelPartnerLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest,
                      com.google.cloud.channel.v1.ChannelPartnerLink>(
                      this, METHODID_UPDATE_CHANNEL_PARTNER_LINK)))
          .addMethod(
              getListProductsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ListProductsRequest,
                      com.google.cloud.channel.v1.ListProductsResponse>(
                      this, METHODID_LIST_PRODUCTS)))
          .addMethod(
              getListSkusMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ListSkusRequest,
                      com.google.cloud.channel.v1.ListSkusResponse>(this, METHODID_LIST_SKUS)))
          .addMethod(
              getListOffersMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ListOffersRequest,
                      com.google.cloud.channel.v1.ListOffersResponse>(this, METHODID_LIST_OFFERS)))
          .addMethod(
              getListPurchasableSkusMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ListPurchasableSkusRequest,
                      com.google.cloud.channel.v1.ListPurchasableSkusResponse>(
                      this, METHODID_LIST_PURCHASABLE_SKUS)))
          .addMethod(
              getListPurchasableOffersMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.channel.v1.ListPurchasableOffersRequest,
                      com.google.cloud.channel.v1.ListPurchasableOffersResponse>(
                      this, METHODID_LIST_PURCHASABLE_OFFERS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * CloudChannelService enables Google cloud resellers and distributors to manage
   * their customers, channel partners, entitlements and reports.
   * Using this service:
   * 1. Resellers or distributors can manage a customer entity.
   * 2. Distributors can register an authorized reseller in their channel and then
   *    enable delegated admin access for the reseller.
   * 3. Resellers or distributors can manage entitlements for their customers.
   * The service primarily exposes the following resources:
   * - [Customer][google.cloud.channel.v1.Customer]s: A Customer represents an entity managed by a reseller or
   * distributor. A customer typically represents an enterprise. In an n-tier
   * resale channel hierarchy, customers are generally represented as leaf nodes.
   * Customers primarily have an Entitlement sub-resource discussed below.
   * - [Entitlement][google.cloud.channel.v1.Entitlement]s: An Entitlement represents an entity which provides a
   * customer means to start using a service. Entitlements are created or updated
   * as a result of a successful fulfillment.
   * - [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s: A ChannelPartnerLink is an entity that identifies
   * links between distributors and their indirect resellers in a channel.
   * </pre>
   */
  public static final class CloudChannelServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CloudChannelServiceStub> {
    private CloudChannelServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudChannelServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudChannelServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List downstream [Customer][google.cloud.channel.v1.Customer]s.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * Return Value:
     * &lt;br/&gt; List of [Customer][google.cloud.channel.v1.Customer]s pertaining to the reseller or empty list if
     * there are none.
     * </pre>
     */
    public void listCustomers(
        com.google.cloud.channel.v1.ListCustomersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListCustomersResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListCustomersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a requested [Customer][google.cloud.channel.v1.Customer] resource.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: If the customer resource doesn't exist. Usually
     * the result of an invalid name parameter.
     * Return Value:
     * &lt;br/&gt; [Customer][google.cloud.channel.v1.Customer] resource if found, error otherwise.
     * </pre>
     */
    public void getCustomer(
        com.google.cloud.channel.v1.GetCustomerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.Customer> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCustomerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Confirms the existence of Cloud Identity accounts, based on the domain and
     * whether the Cloud Identity accounts are owned by the reseller.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * INVALID_VALUE: Invalid domain value in the request.
     * * NOT_FOUND: If there is no [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] customer
     * for the domain specified in the request.
     * Return Value:
     * &lt;br/&gt; List of [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] resources if any exist for
     * the domain, otherwise an error is returned.
     * </pre>
     */
    public void checkCloudIdentityAccountsExist(
        com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckCloudIdentityAccountsExistMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [Customer][google.cloud.channel.v1.Customer] resource under the reseller or distributor
     * account.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt;PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.&lt;/li&gt;
     * &lt;li&gt; INVALID_ARGUMENT:
     * &lt;ul&gt;
     *  &lt;li&gt; Missing or invalid required parameters in the request. &lt;/li&gt;
     *  &lt;li&gt; Domain field value doesn't match the domain specified in primary
     *  email.&lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; If successful, the newly created [Customer][google.cloud.channel.v1.Customer] resource, otherwise
     * returns an error.
     * </pre>
     */
    public void createCustomer(
        com.google.cloud.channel.v1.CreateCustomerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.Customer> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateCustomerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing [Customer][google.cloud.channel.v1.Customer] resource belonging to the reseller or
     * distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
     * specified in the request.
     * Return Value:
     * &lt;br/&gt; If successful, the updated [Customer][google.cloud.channel.v1.Customer] resource, otherwise returns
     * an error.
     * </pre>
     */
    public void updateCustomer(
        com.google.cloud.channel.v1.UpdateCustomerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.Customer> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCustomerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the given [Customer][google.cloud.channel.v1.Customer] permanently and irreversibly.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the account making the request does not own
     * this customer.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * FAILED_PRECONDITION: If the customer has existing entitlements.
     * * NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
     * specified in the request.
     * </pre>
     */
    public void deleteCustomer(
        com.google.cloud.channel.v1.DeleteCustomerRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteCustomerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Cloud Identity for the given customer using the customer's
     * information or the information provided here, if present.
     * Possible Error Codes:
     * *  PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * *  INVALID_ARGUMENT: Missing or invalid required parameters in the request.
     * *  NOT_FOUND: If the customer is not found for the reseller.
     * *  ALREADY_EXISTS: If the customer's primary email already exists. In this
     *    case, retry after changing the customer's primary contact email.
     * *  INTERNAL: Any non-user error related to a technical issue in the
     *    backend. Contact Cloud Channel support in this case.
     * *  UNKNOWN: Any non-user error related to a technical issue in the backend.
     *    Contact Cloud Channel support in this case.
     * Return Value:
     * &lt;br/&gt;  Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void provisionCloudIdentity(
        com.google.cloud.channel.v1.ProvisionCloudIdentityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProvisionCloudIdentityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to a customer.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the request.
     * Return Value:
     * &lt;br/&gt; List of [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to the customer, or empty list if
     * there are none.
     * </pre>
     */
    public void listEntitlements(
        com.google.cloud.channel.v1.ListEntitlementsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListEntitlementsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListEntitlementsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List [TransferableSku][google.cloud.channel.v1.TransferableSku]s of a customer based on Cloud Identity ID or
     * Customer Name in the request.
     * This method is used when a reseller lists the entitlements
     * information of a customer that is not owned. The reseller should provide
     * the customer's Cloud Identity ID or Customer Name.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt;PERMISSION_DENIED, due to one of the following reasons:
     * &lt;ul&gt;
     *    &lt;li&gt; If the customer doesn't belong to the reseller and no auth token,
     *    or an invalid auth token is supplied. &lt;/li&gt; &lt;li&gt; If the reseller account
     *    making the request and the reseller account being queried for are
     *    different. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.&lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; List of [TransferableSku][google.cloud.channel.v1.TransferableSku] for the given customer.
     * </pre>
     */
    public void listTransferableSkus(
        com.google.cloud.channel.v1.ListTransferableSkusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListTransferableSkusResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTransferableSkusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List [TransferableOffer][google.cloud.channel.v1.TransferableOffer]s of a customer based on Cloud Identity ID or
     * Customer Name in the request.
     * This method is used when a reseller gets the entitlement
     * information of a customer that is not owned. The reseller should provide
     * the customer's Cloud Identity ID or Customer Name.
     * Possible Error Codes:
     * * PERMISSION_DENIED, due to one of the following reasons: (a) If the
     * customer doesn't belong to the reseller and no auth token or invalid auth
     * token is supplied. (b) If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * Return Value:
     * List of [TransferableOffer][google.cloud.channel.v1.TransferableOffer] for the given customer and SKU.
     * </pre>
     */
    public void listTransferableOffers(
        com.google.cloud.channel.v1.ListTransferableOffersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListTransferableOffersResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTransferableOffersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a requested [Entitlement][google.cloud.channel.v1.Entitlement] resource.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: If the entitlement is not found for the customer.
     * Return Value:
     * &lt;br/&gt; If found, the requested [Entitlement][google.cloud.channel.v1.Entitlement] resource, otherwise returns
     * an error.
     * </pre>
     */
    public void getEntitlement(
        com.google.cloud.channel.v1.GetEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.Entitlement> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEntitlementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an entitlement for a customer.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: &lt;ul&gt;
     *   &lt;li&gt; Missing or invalid required parameters in the request. &lt;/li&gt;
     *   &lt;li&gt; Cannot purchase an entitlement if there is already an
     *    entitlement for customer, for a SKU from the same product family. &lt;/li&gt;
     *   &lt;li&gt; INVALID_VALUE: Offer passed in isn't valid. Make sure OfferId is
     * valid. If it is valid, then contact Google Channel support for further
     * troubleshooting. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; NOT_FOUND: If the customer or offer resource is not found for the
     * reseller. &lt;/li&gt;
     * &lt;li&gt; ALREADY_EXISTS: This failure can happen in the following cases:
     *   &lt;ul&gt;
     *     &lt;li&gt;If the SKU has been already purchased for the customer.&lt;/li&gt;
     *     &lt;li&gt;If the customer's primary email already exists. In this case retry
     *         after changing the customer's primary contact email.
     *     &lt;/li&gt;
     *   &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; CONDITION_NOT_MET or FAILED_PRECONDITION: This
     * failure can happen in the following cases:
     * &lt;ul&gt;
     *    &lt;li&gt; Purchasing a SKU that requires domain verification and the
     *    domain has not been verified. &lt;/li&gt;
     *    &lt;li&gt; Purchasing an Add-On SKU like Vault or Drive without purchasing
     *    the pre-requisite SKU, such as Google Workspace Business Starter. &lt;/li&gt;
     *    &lt;li&gt; Applicable only for developer accounts: reseller and resold
     *    domain. Must meet the following domain naming requirements:
     *     &lt;ul&gt;
     *       &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt;
     *       &lt;li&gt; Resold domain names must include the reseller domain. &lt;/li&gt;
     *     &lt;/ul&gt;
     *    &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. Contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. Contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void createEntitlement(
        com.google.cloud.channel.v1.CreateEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateEntitlementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Change parameters of the entitlement
     * An entitlement parameters update is a long-running operation and results in
     * updates to the entitlement as a result of fulfillment.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request. For example, if the number of seats being changed to is greater
     * than the allowed number of max seats for the resource. Or decreasing seats
     * for a commitment based plan.
     * * NOT_FOUND: Entitlement resource not found.
     * * INTERNAL: Any non-user error related to a technical issue
     * in the backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void changeParameters(
        com.google.cloud.channel.v1.ChangeParametersRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeParametersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the renewal settings for an existing customer entitlement.
     * An entitlement update is a long-running operation and results in updates to
     * the entitlement as a result of fulfillment.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * NOT_COMMITMENT_PLAN: Renewal Settings are only applicable for a
     * commitment plan. Can't enable or disable renewal for non-commitment plans.
     * * INTERNAL: Any non user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void changeRenewalSettings(
        com.google.cloud.channel.v1.ChangeRenewalSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeRenewalSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Offer for an existing customer entitlement.
     * An entitlement update is a long-running operation and results in updates to
     * the entitlement as a result of fulfillment.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Offer or Entitlement resource not found.
     * * INTERNAL: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void changeOffer(
        com.google.cloud.channel.v1.ChangeOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeOfferMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts paid service for a trial entitlement.
     * Starts paid service for a trial entitlement immediately. This method is
     * only applicable if a plan has already been set up for a trial entitlement
     * but has some trial days remaining.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * FAILED_PRECONDITION/NOT_IN_TRIAL: This method only works for
     * entitlement on trial plans.
     * * INTERNAL: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue
     * in the backend. In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void startPaidService(
        com.google.cloud.channel.v1.StartPaidServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStartPaidServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Suspends a previously fulfilled entitlement.
     * An entitlement suspension is a long-running operation.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * NOT_ACTIVE: Entitlement is not active.
     * * INTERNAL: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void suspendEntitlement(
        com.google.cloud.channel.v1.SuspendEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSuspendEntitlementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a previously fulfilled entitlement.
     * An entitlement cancellation is a long-running operation.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller or
     * if the reseller account making the request and reseller account being
     * queried for are different.
     * * FAILED_PRECONDITION: If there are any Google Cloud projects linked to the
     * Google Cloud entitlement's Cloud Billing subaccount.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * DELETION_TYPE_NOT_ALLOWED: Cancel is only allowed for Google Workspace
     * add-ons or entitlements for Google Cloud's development platform.
     * * INTERNAL: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The response will contain
     * google.protobuf.Empty on success. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void cancelEntitlement(
        com.google.cloud.channel.v1.CancelEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelEntitlementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Activates a previously suspended entitlement. The entitlement must be in a
     * suspended state for it to be activated. Entitlements suspended for pending
     * ToS acceptance can't be activated using this method. An entitlement
     * activation is a long-running operation and can result in updates to
     * the state of the customer entitlement.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller or
     * if the reseller account making the request and reseller account being
     * queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * SUSPENSION_NOT_RESELLER_INITIATED: Can't activate an
     * entitlement that is pending TOS acceptance. Only reseller initiated
     * suspensions can be activated.
     * * NOT_SUSPENDED: Can't activate entitlements that are already in ACTIVE
     * state. Can only activate suspended entitlements.
     * * INTERNAL: Any non-user error related to a technical issue
     * in the backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void activateEntitlement(
        com.google.cloud.channel.v1.ActivateEntitlementRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getActivateEntitlementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Transfers customer entitlements to new reseller.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the customer doesn't belong to the
     * reseller.&lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required
     * parameters in the request. &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer
     * resource is not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: If the
     * SKU has been already transferred for the customer. &lt;/li&gt; &lt;li&gt;
     * CONDITION_NOT_MET or FAILED_PRECONDITION: This failure can happen in the
     * following cases: &lt;ul&gt;
     *    &lt;li&gt; Transferring a SKU that requires domain verification and the
     * domain has not been verified. &lt;/li&gt;
     *    &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without transferring
     * the pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for
     * developer accounts: reseller and resold domain must follow the domain
     * naming convention as follows:
     *      &lt;ul&gt;
     *         &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt;
     *         &lt;li&gt; Resold domain names must include the reseller domain. &lt;/li&gt;
     *      &lt;/ul&gt;
     *   &lt;/li&gt;
     *   &lt;li&gt; All transferring entitlements must be specified. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void transferEntitlements(
        com.google.cloud.channel.v1.TransferEntitlementsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTransferEntitlementsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Transfers customer entitlements from current reseller to Google.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request. &lt;/li&gt;
     * &lt;li&gt; NOT_FOUND: If the customer or offer resource is not found
     * for the reseller. &lt;/li&gt;
     * &lt;li&gt; ALREADY_EXISTS: If the SKU has been already
     * transferred for the customer. &lt;/li&gt;
     * &lt;li&gt; CONDITION_NOT_MET or FAILED_PRECONDITION: This failure can happen in
     * the following cases:
     * &lt;ul&gt;
     *    &lt;li&gt; Transferring a SKU that requires domain verification and the
     * domain has not been verified. &lt;/li&gt;
     *    &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without purchasing
     * the pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for
     * developer accounts: reseller and resold domain must follow the domain
     * naming convention as follows:
     *      &lt;ul&gt;
     *         &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt;
     *         &lt;li&gt; Resold domain names must include the reseller domain. &lt;/li&gt;
     *      &lt;/ul&gt;
     *    &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case.&lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The response will contain
     * google.protobuf.Empty on success. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public void transferEntitlementsToGoogle(
        com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTransferEntitlementsToGoogleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s belonging to a distributor.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * Return Value:
     * &lt;br/&gt; If successful, returns the list of [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resources
     * for the distributor account, otherwise returns an error.
     * </pre>
     */
    public void listChannelPartnerLinks(
        com.google.cloud.channel.v1.ListChannelPartnerLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListChannelPartnerLinksResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListChannelPartnerLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a requested [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: ChannelPartnerLink resource not found. Results
     * due invalid channel partner link name.
     * Return Value:
     * &lt;br/&gt; [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource if found, otherwise returns an error.
     * </pre>
     */
    public void getChannelPartnerLink(
        com.google.cloud.channel.v1.GetChannelPartnerLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ChannelPartnerLink>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetChannelPartnerLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a channel partner link between a distributor and a reseller or
     * between resellers in an n-tier reseller channel.
     * To accept the invite, the invited partner should follow the invite_link_uri
     * provided in the response. If the link creation is accepted, a valid link is
     * set up between the two involved parties.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * ALREADY_EXISTS: If the ChannelPartnerLink sent in the request already
     * exists.
     * * NOT_FOUND: If no Cloud Identity customer exists for domain provided.
     * * INTERNAL: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in
     * the backend. In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Newly created [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource if successful,
     * otherwise error is returned.
     * </pre>
     */
    public void createChannelPartnerLink(
        com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ChannelPartnerLink>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateChannelPartnerLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a channel partner link. A distributor calls this method to change a
     * link's status. For example, suspend a partner link.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different. &lt;/li&gt;
     * &lt;li&gt; INVALID_ARGUMENT:
     * &lt;ul&gt;
     *   &lt;li&gt; Missing or invalid required parameters in the request. &lt;/li&gt;
     *   &lt;li&gt; Updating link state from invited to active or suspended. &lt;/li&gt;
     *   &lt;li&gt; Sending reseller_cloud_identity_id, invite_url or name in update
     *   mask. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; NOT_FOUND: ChannelPartnerLink resource not found.&lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.&lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; If successful, the updated [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource, otherwise
     * returns an error.
     * </pre>
     */
    public void updateChannelPartnerLink(
        com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ChannelPartnerLink>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateChannelPartnerLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Products the reseller is authorized to sell.
     * Possible Error Codes:
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public void listProducts(
        com.google.cloud.channel.v1.ListProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListProductsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the SKUs for a product the reseller is authorized to sell.
     * Possible Error Codes:
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public void listSkus(
        com.google.cloud.channel.v1.ListSkusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListSkusResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListSkusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Offers the reseller can sell.
     * Possible Error Codes:
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public void listOffers(
        com.google.cloud.channel.v1.ListOffersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListOffersResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListOffersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Purchasable SKUs for following cases:
     * * SKUs that can be newly purchased for a customer
     * * SKUs that can be upgraded/downgraded to, for an entitlement.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public void listPurchasableSkus(
        com.google.cloud.channel.v1.ListPurchasableSkusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListPurchasableSkusResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListPurchasableSkusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Purchasable Offers for the following cases:
     * * Offers that can be newly purchased for a customer
     * * Offers that can be changed to, for an entitlement.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public void listPurchasableOffers(
        com.google.cloud.channel.v1.ListPurchasableOffersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListPurchasableOffersResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListPurchasableOffersMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * CloudChannelService enables Google cloud resellers and distributors to manage
   * their customers, channel partners, entitlements and reports.
   * Using this service:
   * 1. Resellers or distributors can manage a customer entity.
   * 2. Distributors can register an authorized reseller in their channel and then
   *    enable delegated admin access for the reseller.
   * 3. Resellers or distributors can manage entitlements for their customers.
   * The service primarily exposes the following resources:
   * - [Customer][google.cloud.channel.v1.Customer]s: A Customer represents an entity managed by a reseller or
   * distributor. A customer typically represents an enterprise. In an n-tier
   * resale channel hierarchy, customers are generally represented as leaf nodes.
   * Customers primarily have an Entitlement sub-resource discussed below.
   * - [Entitlement][google.cloud.channel.v1.Entitlement]s: An Entitlement represents an entity which provides a
   * customer means to start using a service. Entitlements are created or updated
   * as a result of a successful fulfillment.
   * - [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s: A ChannelPartnerLink is an entity that identifies
   * links between distributors and their indirect resellers in a channel.
   * </pre>
   */
  public static final class CloudChannelServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudChannelServiceBlockingStub> {
    private CloudChannelServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudChannelServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudChannelServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List downstream [Customer][google.cloud.channel.v1.Customer]s.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * Return Value:
     * &lt;br/&gt; List of [Customer][google.cloud.channel.v1.Customer]s pertaining to the reseller or empty list if
     * there are none.
     * </pre>
     */
    public com.google.cloud.channel.v1.ListCustomersResponse listCustomers(
        com.google.cloud.channel.v1.ListCustomersRequest request) {
      return blockingUnaryCall(getChannel(), getListCustomersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a requested [Customer][google.cloud.channel.v1.Customer] resource.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: If the customer resource doesn't exist. Usually
     * the result of an invalid name parameter.
     * Return Value:
     * &lt;br/&gt; [Customer][google.cloud.channel.v1.Customer] resource if found, error otherwise.
     * </pre>
     */
    public com.google.cloud.channel.v1.Customer getCustomer(
        com.google.cloud.channel.v1.GetCustomerRequest request) {
      return blockingUnaryCall(getChannel(), getGetCustomerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Confirms the existence of Cloud Identity accounts, based on the domain and
     * whether the Cloud Identity accounts are owned by the reseller.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * INVALID_VALUE: Invalid domain value in the request.
     * * NOT_FOUND: If there is no [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] customer
     * for the domain specified in the request.
     * Return Value:
     * &lt;br/&gt; List of [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] resources if any exist for
     * the domain, otherwise an error is returned.
     * </pre>
     */
    public com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse
        checkCloudIdentityAccountsExist(
            com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckCloudIdentityAccountsExistMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [Customer][google.cloud.channel.v1.Customer] resource under the reseller or distributor
     * account.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt;PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.&lt;/li&gt;
     * &lt;li&gt; INVALID_ARGUMENT:
     * &lt;ul&gt;
     *  &lt;li&gt; Missing or invalid required parameters in the request. &lt;/li&gt;
     *  &lt;li&gt; Domain field value doesn't match the domain specified in primary
     *  email.&lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; If successful, the newly created [Customer][google.cloud.channel.v1.Customer] resource, otherwise
     * returns an error.
     * </pre>
     */
    public com.google.cloud.channel.v1.Customer createCustomer(
        com.google.cloud.channel.v1.CreateCustomerRequest request) {
      return blockingUnaryCall(getChannel(), getCreateCustomerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing [Customer][google.cloud.channel.v1.Customer] resource belonging to the reseller or
     * distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
     * specified in the request.
     * Return Value:
     * &lt;br/&gt; If successful, the updated [Customer][google.cloud.channel.v1.Customer] resource, otherwise returns
     * an error.
     * </pre>
     */
    public com.google.cloud.channel.v1.Customer updateCustomer(
        com.google.cloud.channel.v1.UpdateCustomerRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateCustomerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the given [Customer][google.cloud.channel.v1.Customer] permanently and irreversibly.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the account making the request does not own
     * this customer.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * FAILED_PRECONDITION: If the customer has existing entitlements.
     * * NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
     * specified in the request.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCustomer(
        com.google.cloud.channel.v1.DeleteCustomerRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteCustomerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Cloud Identity for the given customer using the customer's
     * information or the information provided here, if present.
     * Possible Error Codes:
     * *  PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * *  INVALID_ARGUMENT: Missing or invalid required parameters in the request.
     * *  NOT_FOUND: If the customer is not found for the reseller.
     * *  ALREADY_EXISTS: If the customer's primary email already exists. In this
     *    case, retry after changing the customer's primary contact email.
     * *  INTERNAL: Any non-user error related to a technical issue in the
     *    backend. Contact Cloud Channel support in this case.
     * *  UNKNOWN: Any non-user error related to a technical issue in the backend.
     *    Contact Cloud Channel support in this case.
     * Return Value:
     * &lt;br/&gt;  Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation provisionCloudIdentity(
        com.google.cloud.channel.v1.ProvisionCloudIdentityRequest request) {
      return blockingUnaryCall(
          getChannel(), getProvisionCloudIdentityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to a customer.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the request.
     * Return Value:
     * &lt;br/&gt; List of [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to the customer, or empty list if
     * there are none.
     * </pre>
     */
    public com.google.cloud.channel.v1.ListEntitlementsResponse listEntitlements(
        com.google.cloud.channel.v1.ListEntitlementsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListEntitlementsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List [TransferableSku][google.cloud.channel.v1.TransferableSku]s of a customer based on Cloud Identity ID or
     * Customer Name in the request.
     * This method is used when a reseller lists the entitlements
     * information of a customer that is not owned. The reseller should provide
     * the customer's Cloud Identity ID or Customer Name.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt;PERMISSION_DENIED, due to one of the following reasons:
     * &lt;ul&gt;
     *    &lt;li&gt; If the customer doesn't belong to the reseller and no auth token,
     *    or an invalid auth token is supplied. &lt;/li&gt; &lt;li&gt; If the reseller account
     *    making the request and the reseller account being queried for are
     *    different. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.&lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; List of [TransferableSku][google.cloud.channel.v1.TransferableSku] for the given customer.
     * </pre>
     */
    public com.google.cloud.channel.v1.ListTransferableSkusResponse listTransferableSkus(
        com.google.cloud.channel.v1.ListTransferableSkusRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTransferableSkusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List [TransferableOffer][google.cloud.channel.v1.TransferableOffer]s of a customer based on Cloud Identity ID or
     * Customer Name in the request.
     * This method is used when a reseller gets the entitlement
     * information of a customer that is not owned. The reseller should provide
     * the customer's Cloud Identity ID or Customer Name.
     * Possible Error Codes:
     * * PERMISSION_DENIED, due to one of the following reasons: (a) If the
     * customer doesn't belong to the reseller and no auth token or invalid auth
     * token is supplied. (b) If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * Return Value:
     * List of [TransferableOffer][google.cloud.channel.v1.TransferableOffer] for the given customer and SKU.
     * </pre>
     */
    public com.google.cloud.channel.v1.ListTransferableOffersResponse listTransferableOffers(
        com.google.cloud.channel.v1.ListTransferableOffersRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTransferableOffersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a requested [Entitlement][google.cloud.channel.v1.Entitlement] resource.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: If the entitlement is not found for the customer.
     * Return Value:
     * &lt;br/&gt; If found, the requested [Entitlement][google.cloud.channel.v1.Entitlement] resource, otherwise returns
     * an error.
     * </pre>
     */
    public com.google.cloud.channel.v1.Entitlement getEntitlement(
        com.google.cloud.channel.v1.GetEntitlementRequest request) {
      return blockingUnaryCall(getChannel(), getGetEntitlementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an entitlement for a customer.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: &lt;ul&gt;
     *   &lt;li&gt; Missing or invalid required parameters in the request. &lt;/li&gt;
     *   &lt;li&gt; Cannot purchase an entitlement if there is already an
     *    entitlement for customer, for a SKU from the same product family. &lt;/li&gt;
     *   &lt;li&gt; INVALID_VALUE: Offer passed in isn't valid. Make sure OfferId is
     * valid. If it is valid, then contact Google Channel support for further
     * troubleshooting. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; NOT_FOUND: If the customer or offer resource is not found for the
     * reseller. &lt;/li&gt;
     * &lt;li&gt; ALREADY_EXISTS: This failure can happen in the following cases:
     *   &lt;ul&gt;
     *     &lt;li&gt;If the SKU has been already purchased for the customer.&lt;/li&gt;
     *     &lt;li&gt;If the customer's primary email already exists. In this case retry
     *         after changing the customer's primary contact email.
     *     &lt;/li&gt;
     *   &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; CONDITION_NOT_MET or FAILED_PRECONDITION: This
     * failure can happen in the following cases:
     * &lt;ul&gt;
     *    &lt;li&gt; Purchasing a SKU that requires domain verification and the
     *    domain has not been verified. &lt;/li&gt;
     *    &lt;li&gt; Purchasing an Add-On SKU like Vault or Drive without purchasing
     *    the pre-requisite SKU, such as Google Workspace Business Starter. &lt;/li&gt;
     *    &lt;li&gt; Applicable only for developer accounts: reseller and resold
     *    domain. Must meet the following domain naming requirements:
     *     &lt;ul&gt;
     *       &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt;
     *       &lt;li&gt; Resold domain names must include the reseller domain. &lt;/li&gt;
     *     &lt;/ul&gt;
     *    &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. Contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. Contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation createEntitlement(
        com.google.cloud.channel.v1.CreateEntitlementRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateEntitlementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Change parameters of the entitlement
     * An entitlement parameters update is a long-running operation and results in
     * updates to the entitlement as a result of fulfillment.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request. For example, if the number of seats being changed to is greater
     * than the allowed number of max seats for the resource. Or decreasing seats
     * for a commitment based plan.
     * * NOT_FOUND: Entitlement resource not found.
     * * INTERNAL: Any non-user error related to a technical issue
     * in the backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation changeParameters(
        com.google.cloud.channel.v1.ChangeParametersRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangeParametersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the renewal settings for an existing customer entitlement.
     * An entitlement update is a long-running operation and results in updates to
     * the entitlement as a result of fulfillment.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * NOT_COMMITMENT_PLAN: Renewal Settings are only applicable for a
     * commitment plan. Can't enable or disable renewal for non-commitment plans.
     * * INTERNAL: Any non user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation changeRenewalSettings(
        com.google.cloud.channel.v1.ChangeRenewalSettingsRequest request) {
      return blockingUnaryCall(
          getChannel(), getChangeRenewalSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Offer for an existing customer entitlement.
     * An entitlement update is a long-running operation and results in updates to
     * the entitlement as a result of fulfillment.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Offer or Entitlement resource not found.
     * * INTERNAL: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation changeOffer(
        com.google.cloud.channel.v1.ChangeOfferRequest request) {
      return blockingUnaryCall(getChannel(), getChangeOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts paid service for a trial entitlement.
     * Starts paid service for a trial entitlement immediately. This method is
     * only applicable if a plan has already been set up for a trial entitlement
     * but has some trial days remaining.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * FAILED_PRECONDITION/NOT_IN_TRIAL: This method only works for
     * entitlement on trial plans.
     * * INTERNAL: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue
     * in the backend. In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation startPaidService(
        com.google.cloud.channel.v1.StartPaidServiceRequest request) {
      return blockingUnaryCall(
          getChannel(), getStartPaidServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Suspends a previously fulfilled entitlement.
     * An entitlement suspension is a long-running operation.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * NOT_ACTIVE: Entitlement is not active.
     * * INTERNAL: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation suspendEntitlement(
        com.google.cloud.channel.v1.SuspendEntitlementRequest request) {
      return blockingUnaryCall(
          getChannel(), getSuspendEntitlementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a previously fulfilled entitlement.
     * An entitlement cancellation is a long-running operation.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller or
     * if the reseller account making the request and reseller account being
     * queried for are different.
     * * FAILED_PRECONDITION: If there are any Google Cloud projects linked to the
     * Google Cloud entitlement's Cloud Billing subaccount.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * DELETION_TYPE_NOT_ALLOWED: Cancel is only allowed for Google Workspace
     * add-ons or entitlements for Google Cloud's development platform.
     * * INTERNAL: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The response will contain
     * google.protobuf.Empty on success. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation cancelEntitlement(
        com.google.cloud.channel.v1.CancelEntitlementRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelEntitlementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Activates a previously suspended entitlement. The entitlement must be in a
     * suspended state for it to be activated. Entitlements suspended for pending
     * ToS acceptance can't be activated using this method. An entitlement
     * activation is a long-running operation and can result in updates to
     * the state of the customer entitlement.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller or
     * if the reseller account making the request and reseller account being
     * queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * SUSPENSION_NOT_RESELLER_INITIATED: Can't activate an
     * entitlement that is pending TOS acceptance. Only reseller initiated
     * suspensions can be activated.
     * * NOT_SUSPENDED: Can't activate entitlements that are already in ACTIVE
     * state. Can only activate suspended entitlements.
     * * INTERNAL: Any non-user error related to a technical issue
     * in the backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation activateEntitlement(
        com.google.cloud.channel.v1.ActivateEntitlementRequest request) {
      return blockingUnaryCall(
          getChannel(), getActivateEntitlementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Transfers customer entitlements to new reseller.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the customer doesn't belong to the
     * reseller.&lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required
     * parameters in the request. &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer
     * resource is not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: If the
     * SKU has been already transferred for the customer. &lt;/li&gt; &lt;li&gt;
     * CONDITION_NOT_MET or FAILED_PRECONDITION: This failure can happen in the
     * following cases: &lt;ul&gt;
     *    &lt;li&gt; Transferring a SKU that requires domain verification and the
     * domain has not been verified. &lt;/li&gt;
     *    &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without transferring
     * the pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for
     * developer accounts: reseller and resold domain must follow the domain
     * naming convention as follows:
     *      &lt;ul&gt;
     *         &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt;
     *         &lt;li&gt; Resold domain names must include the reseller domain. &lt;/li&gt;
     *      &lt;/ul&gt;
     *   &lt;/li&gt;
     *   &lt;li&gt; All transferring entitlements must be specified. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation transferEntitlements(
        com.google.cloud.channel.v1.TransferEntitlementsRequest request) {
      return blockingUnaryCall(
          getChannel(), getTransferEntitlementsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Transfers customer entitlements from current reseller to Google.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request. &lt;/li&gt;
     * &lt;li&gt; NOT_FOUND: If the customer or offer resource is not found
     * for the reseller. &lt;/li&gt;
     * &lt;li&gt; ALREADY_EXISTS: If the SKU has been already
     * transferred for the customer. &lt;/li&gt;
     * &lt;li&gt; CONDITION_NOT_MET or FAILED_PRECONDITION: This failure can happen in
     * the following cases:
     * &lt;ul&gt;
     *    &lt;li&gt; Transferring a SKU that requires domain verification and the
     * domain has not been verified. &lt;/li&gt;
     *    &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without purchasing
     * the pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for
     * developer accounts: reseller and resold domain must follow the domain
     * naming convention as follows:
     *      &lt;ul&gt;
     *         &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt;
     *         &lt;li&gt; Resold domain names must include the reseller domain. &lt;/li&gt;
     *      &lt;/ul&gt;
     *    &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case.&lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The response will contain
     * google.protobuf.Empty on success. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.longrunning.Operation transferEntitlementsToGoogle(
        com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest request) {
      return blockingUnaryCall(
          getChannel(), getTransferEntitlementsToGoogleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s belonging to a distributor.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * Return Value:
     * &lt;br/&gt; If successful, returns the list of [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resources
     * for the distributor account, otherwise returns an error.
     * </pre>
     */
    public com.google.cloud.channel.v1.ListChannelPartnerLinksResponse listChannelPartnerLinks(
        com.google.cloud.channel.v1.ListChannelPartnerLinksRequest request) {
      return blockingUnaryCall(
          getChannel(), getListChannelPartnerLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a requested [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: ChannelPartnerLink resource not found. Results
     * due invalid channel partner link name.
     * Return Value:
     * &lt;br/&gt; [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource if found, otherwise returns an error.
     * </pre>
     */
    public com.google.cloud.channel.v1.ChannelPartnerLink getChannelPartnerLink(
        com.google.cloud.channel.v1.GetChannelPartnerLinkRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetChannelPartnerLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a channel partner link between a distributor and a reseller or
     * between resellers in an n-tier reseller channel.
     * To accept the invite, the invited partner should follow the invite_link_uri
     * provided in the response. If the link creation is accepted, a valid link is
     * set up between the two involved parties.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * ALREADY_EXISTS: If the ChannelPartnerLink sent in the request already
     * exists.
     * * NOT_FOUND: If no Cloud Identity customer exists for domain provided.
     * * INTERNAL: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in
     * the backend. In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Newly created [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource if successful,
     * otherwise error is returned.
     * </pre>
     */
    public com.google.cloud.channel.v1.ChannelPartnerLink createChannelPartnerLink(
        com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateChannelPartnerLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a channel partner link. A distributor calls this method to change a
     * link's status. For example, suspend a partner link.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different. &lt;/li&gt;
     * &lt;li&gt; INVALID_ARGUMENT:
     * &lt;ul&gt;
     *   &lt;li&gt; Missing or invalid required parameters in the request. &lt;/li&gt;
     *   &lt;li&gt; Updating link state from invited to active or suspended. &lt;/li&gt;
     *   &lt;li&gt; Sending reseller_cloud_identity_id, invite_url or name in update
     *   mask. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; NOT_FOUND: ChannelPartnerLink resource not found.&lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.&lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; If successful, the updated [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource, otherwise
     * returns an error.
     * </pre>
     */
    public com.google.cloud.channel.v1.ChannelPartnerLink updateChannelPartnerLink(
        com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateChannelPartnerLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Products the reseller is authorized to sell.
     * Possible Error Codes:
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public com.google.cloud.channel.v1.ListProductsResponse listProducts(
        com.google.cloud.channel.v1.ListProductsRequest request) {
      return blockingUnaryCall(getChannel(), getListProductsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the SKUs for a product the reseller is authorized to sell.
     * Possible Error Codes:
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public com.google.cloud.channel.v1.ListSkusResponse listSkus(
        com.google.cloud.channel.v1.ListSkusRequest request) {
      return blockingUnaryCall(getChannel(), getListSkusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Offers the reseller can sell.
     * Possible Error Codes:
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public com.google.cloud.channel.v1.ListOffersResponse listOffers(
        com.google.cloud.channel.v1.ListOffersRequest request) {
      return blockingUnaryCall(getChannel(), getListOffersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Purchasable SKUs for following cases:
     * * SKUs that can be newly purchased for a customer
     * * SKUs that can be upgraded/downgraded to, for an entitlement.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public com.google.cloud.channel.v1.ListPurchasableSkusResponse listPurchasableSkus(
        com.google.cloud.channel.v1.ListPurchasableSkusRequest request) {
      return blockingUnaryCall(
          getChannel(), getListPurchasableSkusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Purchasable Offers for the following cases:
     * * Offers that can be newly purchased for a customer
     * * Offers that can be changed to, for an entitlement.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public com.google.cloud.channel.v1.ListPurchasableOffersResponse listPurchasableOffers(
        com.google.cloud.channel.v1.ListPurchasableOffersRequest request) {
      return blockingUnaryCall(
          getChannel(), getListPurchasableOffersMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * CloudChannelService enables Google cloud resellers and distributors to manage
   * their customers, channel partners, entitlements and reports.
   * Using this service:
   * 1. Resellers or distributors can manage a customer entity.
   * 2. Distributors can register an authorized reseller in their channel and then
   *    enable delegated admin access for the reseller.
   * 3. Resellers or distributors can manage entitlements for their customers.
   * The service primarily exposes the following resources:
   * - [Customer][google.cloud.channel.v1.Customer]s: A Customer represents an entity managed by a reseller or
   * distributor. A customer typically represents an enterprise. In an n-tier
   * resale channel hierarchy, customers are generally represented as leaf nodes.
   * Customers primarily have an Entitlement sub-resource discussed below.
   * - [Entitlement][google.cloud.channel.v1.Entitlement]s: An Entitlement represents an entity which provides a
   * customer means to start using a service. Entitlements are created or updated
   * as a result of a successful fulfillment.
   * - [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s: A ChannelPartnerLink is an entity that identifies
   * links between distributors and their indirect resellers in a channel.
   * </pre>
   */
  public static final class CloudChannelServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudChannelServiceFutureStub> {
    private CloudChannelServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudChannelServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudChannelServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List downstream [Customer][google.cloud.channel.v1.Customer]s.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * Return Value:
     * &lt;br/&gt; List of [Customer][google.cloud.channel.v1.Customer]s pertaining to the reseller or empty list if
     * there are none.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ListCustomersResponse>
        listCustomers(com.google.cloud.channel.v1.ListCustomersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListCustomersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a requested [Customer][google.cloud.channel.v1.Customer] resource.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: If the customer resource doesn't exist. Usually
     * the result of an invalid name parameter.
     * Return Value:
     * &lt;br/&gt; [Customer][google.cloud.channel.v1.Customer] resource if found, error otherwise.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.channel.v1.Customer>
        getCustomer(com.google.cloud.channel.v1.GetCustomerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCustomerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Confirms the existence of Cloud Identity accounts, based on the domain and
     * whether the Cloud Identity accounts are owned by the reseller.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * INVALID_VALUE: Invalid domain value in the request.
     * * NOT_FOUND: If there is no [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] customer
     * for the domain specified in the request.
     * Return Value:
     * &lt;br/&gt; List of [CloudIdentityCustomerAccount][google.cloud.channel.v1.CloudIdentityCustomerAccount] resources if any exist for
     * the domain, otherwise an error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse>
        checkCloudIdentityAccountsExist(
            com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckCloudIdentityAccountsExistMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [Customer][google.cloud.channel.v1.Customer] resource under the reseller or distributor
     * account.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt;PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.&lt;/li&gt;
     * &lt;li&gt; INVALID_ARGUMENT:
     * &lt;ul&gt;
     *  &lt;li&gt; Missing or invalid required parameters in the request. &lt;/li&gt;
     *  &lt;li&gt; Domain field value doesn't match the domain specified in primary
     *  email.&lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; If successful, the newly created [Customer][google.cloud.channel.v1.Customer] resource, otherwise
     * returns an error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.channel.v1.Customer>
        createCustomer(com.google.cloud.channel.v1.CreateCustomerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateCustomerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing [Customer][google.cloud.channel.v1.Customer] resource belonging to the reseller or
     * distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
     * specified in the request.
     * Return Value:
     * &lt;br/&gt; If successful, the updated [Customer][google.cloud.channel.v1.Customer] resource, otherwise returns
     * an error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.channel.v1.Customer>
        updateCustomer(com.google.cloud.channel.v1.UpdateCustomerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCustomerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the given [Customer][google.cloud.channel.v1.Customer] permanently and irreversibly.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the account making the request does not own
     * this customer.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * FAILED_PRECONDITION: If the customer has existing entitlements.
     * * NOT_FOUND: No [Customer][google.cloud.channel.v1.Customer] resource found for the name
     * specified in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCustomer(com.google.cloud.channel.v1.DeleteCustomerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteCustomerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Cloud Identity for the given customer using the customer's
     * information or the information provided here, if present.
     * Possible Error Codes:
     * *  PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * *  INVALID_ARGUMENT: Missing or invalid required parameters in the request.
     * *  NOT_FOUND: If the customer is not found for the reseller.
     * *  ALREADY_EXISTS: If the customer's primary email already exists. In this
     *    case, retry after changing the customer's primary contact email.
     * *  INTERNAL: Any non-user error related to a technical issue in the
     *    backend. Contact Cloud Channel support in this case.
     * *  UNKNOWN: Any non-user error related to a technical issue in the backend.
     *    Contact Cloud Channel support in this case.
     * Return Value:
     * &lt;br/&gt;  Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        provisionCloudIdentity(com.google.cloud.channel.v1.ProvisionCloudIdentityRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProvisionCloudIdentityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to a customer.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the request.
     * Return Value:
     * &lt;br/&gt; List of [Entitlement][google.cloud.channel.v1.Entitlement]s belonging to the customer, or empty list if
     * there are none.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ListEntitlementsResponse>
        listEntitlements(com.google.cloud.channel.v1.ListEntitlementsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListEntitlementsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List [TransferableSku][google.cloud.channel.v1.TransferableSku]s of a customer based on Cloud Identity ID or
     * Customer Name in the request.
     * This method is used when a reseller lists the entitlements
     * information of a customer that is not owned. The reseller should provide
     * the customer's Cloud Identity ID or Customer Name.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt;PERMISSION_DENIED, due to one of the following reasons:
     * &lt;ul&gt;
     *    &lt;li&gt; If the customer doesn't belong to the reseller and no auth token,
     *    or an invalid auth token is supplied. &lt;/li&gt; &lt;li&gt; If the reseller account
     *    making the request and the reseller account being queried for are
     *    different. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.&lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; List of [TransferableSku][google.cloud.channel.v1.TransferableSku] for the given customer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ListTransferableSkusResponse>
        listTransferableSkus(com.google.cloud.channel.v1.ListTransferableSkusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTransferableSkusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List [TransferableOffer][google.cloud.channel.v1.TransferableOffer]s of a customer based on Cloud Identity ID or
     * Customer Name in the request.
     * This method is used when a reseller gets the entitlement
     * information of a customer that is not owned. The reseller should provide
     * the customer's Cloud Identity ID or Customer Name.
     * Possible Error Codes:
     * * PERMISSION_DENIED, due to one of the following reasons: (a) If the
     * customer doesn't belong to the reseller and no auth token or invalid auth
     * token is supplied. (b) If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * Return Value:
     * List of [TransferableOffer][google.cloud.channel.v1.TransferableOffer] for the given customer and SKU.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ListTransferableOffersResponse>
        listTransferableOffers(com.google.cloud.channel.v1.ListTransferableOffersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTransferableOffersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a requested [Entitlement][google.cloud.channel.v1.Entitlement] resource.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: If the entitlement is not found for the customer.
     * Return Value:
     * &lt;br/&gt; If found, the requested [Entitlement][google.cloud.channel.v1.Entitlement] resource, otherwise returns
     * an error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.Entitlement>
        getEntitlement(com.google.cloud.channel.v1.GetEntitlementRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEntitlementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an entitlement for a customer.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: &lt;ul&gt;
     *   &lt;li&gt; Missing or invalid required parameters in the request. &lt;/li&gt;
     *   &lt;li&gt; Cannot purchase an entitlement if there is already an
     *    entitlement for customer, for a SKU from the same product family. &lt;/li&gt;
     *   &lt;li&gt; INVALID_VALUE: Offer passed in isn't valid. Make sure OfferId is
     * valid. If it is valid, then contact Google Channel support for further
     * troubleshooting. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; NOT_FOUND: If the customer or offer resource is not found for the
     * reseller. &lt;/li&gt;
     * &lt;li&gt; ALREADY_EXISTS: This failure can happen in the following cases:
     *   &lt;ul&gt;
     *     &lt;li&gt;If the SKU has been already purchased for the customer.&lt;/li&gt;
     *     &lt;li&gt;If the customer's primary email already exists. In this case retry
     *         after changing the customer's primary contact email.
     *     &lt;/li&gt;
     *   &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; CONDITION_NOT_MET or FAILED_PRECONDITION: This
     * failure can happen in the following cases:
     * &lt;ul&gt;
     *    &lt;li&gt; Purchasing a SKU that requires domain verification and the
     *    domain has not been verified. &lt;/li&gt;
     *    &lt;li&gt; Purchasing an Add-On SKU like Vault or Drive without purchasing
     *    the pre-requisite SKU, such as Google Workspace Business Starter. &lt;/li&gt;
     *    &lt;li&gt; Applicable only for developer accounts: reseller and resold
     *    domain. Must meet the following domain naming requirements:
     *     &lt;ul&gt;
     *       &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt;
     *       &lt;li&gt; Resold domain names must include the reseller domain. &lt;/li&gt;
     *     &lt;/ul&gt;
     *    &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. Contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. Contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEntitlement(com.google.cloud.channel.v1.CreateEntitlementRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateEntitlementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Change parameters of the entitlement
     * An entitlement parameters update is a long-running operation and results in
     * updates to the entitlement as a result of fulfillment.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request. For example, if the number of seats being changed to is greater
     * than the allowed number of max seats for the resource. Or decreasing seats
     * for a commitment based plan.
     * * NOT_FOUND: Entitlement resource not found.
     * * INTERNAL: Any non-user error related to a technical issue
     * in the backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        changeParameters(com.google.cloud.channel.v1.ChangeParametersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeParametersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the renewal settings for an existing customer entitlement.
     * An entitlement update is a long-running operation and results in updates to
     * the entitlement as a result of fulfillment.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * NOT_COMMITMENT_PLAN: Renewal Settings are only applicable for a
     * commitment plan. Can't enable or disable renewal for non-commitment plans.
     * * INTERNAL: Any non user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        changeRenewalSettings(com.google.cloud.channel.v1.ChangeRenewalSettingsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeRenewalSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Offer for an existing customer entitlement.
     * An entitlement update is a long-running operation and results in updates to
     * the entitlement as a result of fulfillment.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Offer or Entitlement resource not found.
     * * INTERNAL: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        changeOffer(com.google.cloud.channel.v1.ChangeOfferRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeOfferMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts paid service for a trial entitlement.
     * Starts paid service for a trial entitlement immediately. This method is
     * only applicable if a plan has already been set up for a trial entitlement
     * but has some trial days remaining.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * FAILED_PRECONDITION/NOT_IN_TRIAL: This method only works for
     * entitlement on trial plans.
     * * INTERNAL: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue
     * in the backend. In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startPaidService(com.google.cloud.channel.v1.StartPaidServiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStartPaidServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Suspends a previously fulfilled entitlement.
     * An entitlement suspension is a long-running operation.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * NOT_ACTIVE: Entitlement is not active.
     * * INTERNAL: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        suspendEntitlement(com.google.cloud.channel.v1.SuspendEntitlementRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSuspendEntitlementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a previously fulfilled entitlement.
     * An entitlement cancellation is a long-running operation.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller or
     * if the reseller account making the request and reseller account being
     * queried for are different.
     * * FAILED_PRECONDITION: If there are any Google Cloud projects linked to the
     * Google Cloud entitlement's Cloud Billing subaccount.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * DELETION_TYPE_NOT_ALLOWED: Cancel is only allowed for Google Workspace
     * add-ons or entitlements for Google Cloud's development platform.
     * * INTERNAL: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The response will contain
     * google.protobuf.Empty on success. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        cancelEntitlement(com.google.cloud.channel.v1.CancelEntitlementRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelEntitlementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Activates a previously suspended entitlement. The entitlement must be in a
     * suspended state for it to be activated. Entitlements suspended for pending
     * ToS acceptance can't be activated using this method. An entitlement
     * activation is a long-running operation and can result in updates to
     * the state of the customer entitlement.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller or
     * if the reseller account making the request and reseller account being
     * queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: Entitlement resource not found.
     * * SUSPENSION_NOT_RESELLER_INITIATED: Can't activate an
     * entitlement that is pending TOS acceptance. Only reseller initiated
     * suspensions can be activated.
     * * NOT_SUSPENDED: Can't activate entitlements that are already in ACTIVE
     * state. Can only activate suspended entitlements.
     * * INTERNAL: Any non-user error related to a technical issue
     * in the backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in the backend.
     * In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        activateEntitlement(com.google.cloud.channel.v1.ActivateEntitlementRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getActivateEntitlementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Transfers customer entitlements to new reseller.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the customer doesn't belong to the
     * reseller.&lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required
     * parameters in the request. &lt;/li&gt; &lt;li&gt; NOT_FOUND: If the customer or offer
     * resource is not found for the reseller. &lt;/li&gt; &lt;li&gt; ALREADY_EXISTS: If the
     * SKU has been already transferred for the customer. &lt;/li&gt; &lt;li&gt;
     * CONDITION_NOT_MET or FAILED_PRECONDITION: This failure can happen in the
     * following cases: &lt;ul&gt;
     *    &lt;li&gt; Transferring a SKU that requires domain verification and the
     * domain has not been verified. &lt;/li&gt;
     *    &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without transferring
     * the pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for
     * developer accounts: reseller and resold domain must follow the domain
     * naming convention as follows:
     *      &lt;ul&gt;
     *         &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt;
     *         &lt;li&gt; Resold domain names must include the reseller domain. &lt;/li&gt;
     *      &lt;/ul&gt;
     *   &lt;/li&gt;
     *   &lt;li&gt; All transferring entitlements must be specified. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        transferEntitlements(com.google.cloud.channel.v1.TransferEntitlementsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTransferEntitlementsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Transfers customer entitlements from current reseller to Google.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the customer doesn't belong to the reseller.
     * &lt;/li&gt; &lt;li&gt; INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request. &lt;/li&gt;
     * &lt;li&gt; NOT_FOUND: If the customer or offer resource is not found
     * for the reseller. &lt;/li&gt;
     * &lt;li&gt; ALREADY_EXISTS: If the SKU has been already
     * transferred for the customer. &lt;/li&gt;
     * &lt;li&gt; CONDITION_NOT_MET or FAILED_PRECONDITION: This failure can happen in
     * the following cases:
     * &lt;ul&gt;
     *    &lt;li&gt; Transferring a SKU that requires domain verification and the
     * domain has not been verified. &lt;/li&gt;
     *    &lt;li&gt; Transferring an Add-On SKU like Vault or Drive without purchasing
     * the pre-requisite SKU, such as G Suite Basic &lt;/li&gt; &lt;li&gt; Applicable only for
     * developer accounts: reseller and resold domain must follow the domain
     * naming convention as follows:
     *      &lt;ul&gt;
     *         &lt;li&gt; Domain names must start with goog-test. &lt;/li&gt;
     *         &lt;li&gt; Resold domain names must include the reseller domain. &lt;/li&gt;
     *      &lt;/ul&gt;
     *    &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. Please contact Cloud Channel Support in this case.&lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; Long Running Operation ID.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The response will contain
     * google.protobuf.Empty on success. The Operation metadata will contain an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        transferEntitlementsToGoogle(
            com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTransferEntitlementsToGoogleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink]s belonging to a distributor.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * Return Value:
     * &lt;br/&gt; If successful, returns the list of [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resources
     * for the distributor account, otherwise returns an error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ListChannelPartnerLinksResponse>
        listChannelPartnerLinks(
            com.google.cloud.channel.v1.ListChannelPartnerLinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListChannelPartnerLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a requested [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * NOT_FOUND: ChannelPartnerLink resource not found. Results
     * due invalid channel partner link name.
     * Return Value:
     * &lt;br/&gt; [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource if found, otherwise returns an error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ChannelPartnerLink>
        getChannelPartnerLink(com.google.cloud.channel.v1.GetChannelPartnerLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetChannelPartnerLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a channel partner link between a distributor and a reseller or
     * between resellers in an n-tier reseller channel.
     * To accept the invite, the invited partner should follow the invite_link_uri
     * provided in the response. If the link creation is accepted, a valid link is
     * set up between the two involved parties.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different.
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * * ALREADY_EXISTS: If the ChannelPartnerLink sent in the request already
     * exists.
     * * NOT_FOUND: If no Cloud Identity customer exists for domain provided.
     * * INTERNAL: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue in
     * the backend. In this case, contact Cloud Channel support.
     * Return Value:
     * &lt;br/&gt; Newly created [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource if successful,
     * otherwise error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ChannelPartnerLink>
        createChannelPartnerLink(
            com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateChannelPartnerLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a channel partner link. A distributor calls this method to change a
     * link's status. For example, suspend a partner link.
     * To call this method, you must be a distributor.
     * Possible Error Codes:
     * &lt;ul&gt;
     * &lt;li&gt; PERMISSION_DENIED: If the reseller account making the request and the
     * reseller account being queried for are different. &lt;/li&gt;
     * &lt;li&gt; INVALID_ARGUMENT:
     * &lt;ul&gt;
     *   &lt;li&gt; Missing or invalid required parameters in the request. &lt;/li&gt;
     *   &lt;li&gt; Updating link state from invited to active or suspended. &lt;/li&gt;
     *   &lt;li&gt; Sending reseller_cloud_identity_id, invite_url or name in update
     *   mask. &lt;/li&gt;
     * &lt;/ul&gt;
     * &lt;/li&gt;
     * &lt;li&gt; NOT_FOUND: ChannelPartnerLink resource not found.&lt;/li&gt;
     * &lt;li&gt; INTERNAL: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support. &lt;/li&gt;
     * &lt;li&gt; UNKNOWN: Any non-user error related to a technical issue in the
     * backend. In this case, contact Cloud Channel support.&lt;/li&gt;
     * &lt;/ul&gt;
     * Return Value:
     * &lt;br/&gt; If successful, the updated [ChannelPartnerLink][google.cloud.channel.v1.ChannelPartnerLink] resource, otherwise
     * returns an error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ChannelPartnerLink>
        updateChannelPartnerLink(
            com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateChannelPartnerLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Products the reseller is authorized to sell.
     * Possible Error Codes:
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ListProductsResponse>
        listProducts(com.google.cloud.channel.v1.ListProductsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the SKUs for a product the reseller is authorized to sell.
     * Possible Error Codes:
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ListSkusResponse>
        listSkus(com.google.cloud.channel.v1.ListSkusRequest request) {
      return futureUnaryCall(getChannel().newCall(getListSkusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Offers the reseller can sell.
     * Possible Error Codes:
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ListOffersResponse>
        listOffers(com.google.cloud.channel.v1.ListOffersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListOffersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Purchasable SKUs for following cases:
     * * SKUs that can be newly purchased for a customer
     * * SKUs that can be upgraded/downgraded to, for an entitlement.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ListPurchasableSkusResponse>
        listPurchasableSkus(com.google.cloud.channel.v1.ListPurchasableSkusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListPurchasableSkusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Purchasable Offers for the following cases:
     * * Offers that can be newly purchased for a customer
     * * Offers that can be changed to, for an entitlement.
     * Possible Error Codes:
     * * PERMISSION_DENIED: If the customer doesn't belong to the reseller
     * * INVALID_ARGUMENT: Missing or invalid required parameters in the
     * request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.channel.v1.ListPurchasableOffersResponse>
        listPurchasableOffers(com.google.cloud.channel.v1.ListPurchasableOffersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListPurchasableOffersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CUSTOMERS = 0;
  private static final int METHODID_GET_CUSTOMER = 1;
  private static final int METHODID_CHECK_CLOUD_IDENTITY_ACCOUNTS_EXIST = 2;
  private static final int METHODID_CREATE_CUSTOMER = 3;
  private static final int METHODID_UPDATE_CUSTOMER = 4;
  private static final int METHODID_DELETE_CUSTOMER = 5;
  private static final int METHODID_PROVISION_CLOUD_IDENTITY = 6;
  private static final int METHODID_LIST_ENTITLEMENTS = 7;
  private static final int METHODID_LIST_TRANSFERABLE_SKUS = 8;
  private static final int METHODID_LIST_TRANSFERABLE_OFFERS = 9;
  private static final int METHODID_GET_ENTITLEMENT = 10;
  private static final int METHODID_CREATE_ENTITLEMENT = 11;
  private static final int METHODID_CHANGE_PARAMETERS = 12;
  private static final int METHODID_CHANGE_RENEWAL_SETTINGS = 13;
  private static final int METHODID_CHANGE_OFFER = 14;
  private static final int METHODID_START_PAID_SERVICE = 15;
  private static final int METHODID_SUSPEND_ENTITLEMENT = 16;
  private static final int METHODID_CANCEL_ENTITLEMENT = 17;
  private static final int METHODID_ACTIVATE_ENTITLEMENT = 18;
  private static final int METHODID_TRANSFER_ENTITLEMENTS = 19;
  private static final int METHODID_TRANSFER_ENTITLEMENTS_TO_GOOGLE = 20;
  private static final int METHODID_LIST_CHANNEL_PARTNER_LINKS = 21;
  private static final int METHODID_GET_CHANNEL_PARTNER_LINK = 22;
  private static final int METHODID_CREATE_CHANNEL_PARTNER_LINK = 23;
  private static final int METHODID_UPDATE_CHANNEL_PARTNER_LINK = 24;
  private static final int METHODID_LIST_PRODUCTS = 25;
  private static final int METHODID_LIST_SKUS = 26;
  private static final int METHODID_LIST_OFFERS = 27;
  private static final int METHODID_LIST_PURCHASABLE_SKUS = 28;
  private static final int METHODID_LIST_PURCHASABLE_OFFERS = 29;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CloudChannelServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CloudChannelServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CUSTOMERS:
          serviceImpl.listCustomers(
              (com.google.cloud.channel.v1.ListCustomersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListCustomersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CUSTOMER:
          serviceImpl.getCustomer(
              (com.google.cloud.channel.v1.GetCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.Customer>) responseObserver);
          break;
        case METHODID_CHECK_CLOUD_IDENTITY_ACCOUNTS_EXIST:
          serviceImpl.checkCloudIdentityAccountsExist(
              (com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.channel.v1.CheckCloudIdentityAccountsExistResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CUSTOMER:
          serviceImpl.createCustomer(
              (com.google.cloud.channel.v1.CreateCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.Customer>) responseObserver);
          break;
        case METHODID_UPDATE_CUSTOMER:
          serviceImpl.updateCustomer(
              (com.google.cloud.channel.v1.UpdateCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.Customer>) responseObserver);
          break;
        case METHODID_DELETE_CUSTOMER:
          serviceImpl.deleteCustomer(
              (com.google.cloud.channel.v1.DeleteCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_PROVISION_CLOUD_IDENTITY:
          serviceImpl.provisionCloudIdentity(
              (com.google.cloud.channel.v1.ProvisionCloudIdentityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ENTITLEMENTS:
          serviceImpl.listEntitlements(
              (com.google.cloud.channel.v1.ListEntitlementsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListEntitlementsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_TRANSFERABLE_SKUS:
          serviceImpl.listTransferableSkus(
              (com.google.cloud.channel.v1.ListTransferableSkusRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.channel.v1.ListTransferableSkusResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_TRANSFERABLE_OFFERS:
          serviceImpl.listTransferableOffers(
              (com.google.cloud.channel.v1.ListTransferableOffersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.channel.v1.ListTransferableOffersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENTITLEMENT:
          serviceImpl.getEntitlement(
              (com.google.cloud.channel.v1.GetEntitlementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.Entitlement>)
                  responseObserver);
          break;
        case METHODID_CREATE_ENTITLEMENT:
          serviceImpl.createEntitlement(
              (com.google.cloud.channel.v1.CreateEntitlementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CHANGE_PARAMETERS:
          serviceImpl.changeParameters(
              (com.google.cloud.channel.v1.ChangeParametersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CHANGE_RENEWAL_SETTINGS:
          serviceImpl.changeRenewalSettings(
              (com.google.cloud.channel.v1.ChangeRenewalSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CHANGE_OFFER:
          serviceImpl.changeOffer(
              (com.google.cloud.channel.v1.ChangeOfferRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_PAID_SERVICE:
          serviceImpl.startPaidService(
              (com.google.cloud.channel.v1.StartPaidServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SUSPEND_ENTITLEMENT:
          serviceImpl.suspendEntitlement(
              (com.google.cloud.channel.v1.SuspendEntitlementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_ENTITLEMENT:
          serviceImpl.cancelEntitlement(
              (com.google.cloud.channel.v1.CancelEntitlementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ACTIVATE_ENTITLEMENT:
          serviceImpl.activateEntitlement(
              (com.google.cloud.channel.v1.ActivateEntitlementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_TRANSFER_ENTITLEMENTS:
          serviceImpl.transferEntitlements(
              (com.google.cloud.channel.v1.TransferEntitlementsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_TRANSFER_ENTITLEMENTS_TO_GOOGLE:
          serviceImpl.transferEntitlementsToGoogle(
              (com.google.cloud.channel.v1.TransferEntitlementsToGoogleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CHANNEL_PARTNER_LINKS:
          serviceImpl.listChannelPartnerLinks(
              (com.google.cloud.channel.v1.ListChannelPartnerLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.channel.v1.ListChannelPartnerLinksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CHANNEL_PARTNER_LINK:
          serviceImpl.getChannelPartnerLink(
              (com.google.cloud.channel.v1.GetChannelPartnerLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ChannelPartnerLink>)
                  responseObserver);
          break;
        case METHODID_CREATE_CHANNEL_PARTNER_LINK:
          serviceImpl.createChannelPartnerLink(
              (com.google.cloud.channel.v1.CreateChannelPartnerLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ChannelPartnerLink>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CHANNEL_PARTNER_LINK:
          serviceImpl.updateChannelPartnerLink(
              (com.google.cloud.channel.v1.UpdateChannelPartnerLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ChannelPartnerLink>)
                  responseObserver);
          break;
        case METHODID_LIST_PRODUCTS:
          serviceImpl.listProducts(
              (com.google.cloud.channel.v1.ListProductsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListProductsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SKUS:
          serviceImpl.listSkus(
              (com.google.cloud.channel.v1.ListSkusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListSkusResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_OFFERS:
          serviceImpl.listOffers(
              (com.google.cloud.channel.v1.ListOffersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListOffersResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_PURCHASABLE_SKUS:
          serviceImpl.listPurchasableSkus(
              (com.google.cloud.channel.v1.ListPurchasableSkusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListPurchasableSkusResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_PURCHASABLE_OFFERS:
          serviceImpl.listPurchasableOffers(
              (com.google.cloud.channel.v1.ListPurchasableOffersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.channel.v1.ListPurchasableOffersResponse>)
                  responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class CloudChannelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudChannelServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.channel.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudChannelService");
    }
  }

  private static final class CloudChannelServiceFileDescriptorSupplier
      extends CloudChannelServiceBaseDescriptorSupplier {
    CloudChannelServiceFileDescriptorSupplier() {}
  }

  private static final class CloudChannelServiceMethodDescriptorSupplier
      extends CloudChannelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CloudChannelServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CloudChannelServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CloudChannelServiceFileDescriptorSupplier())
                      .addMethod(getListCustomersMethod())
                      .addMethod(getGetCustomerMethod())
                      .addMethod(getCheckCloudIdentityAccountsExistMethod())
                      .addMethod(getCreateCustomerMethod())
                      .addMethod(getUpdateCustomerMethod())
                      .addMethod(getDeleteCustomerMethod())
                      .addMethod(getProvisionCloudIdentityMethod())
                      .addMethod(getListEntitlementsMethod())
                      .addMethod(getListTransferableSkusMethod())
                      .addMethod(getListTransferableOffersMethod())
                      .addMethod(getGetEntitlementMethod())
                      .addMethod(getCreateEntitlementMethod())
                      .addMethod(getChangeParametersMethod())
                      .addMethod(getChangeRenewalSettingsMethod())
                      .addMethod(getChangeOfferMethod())
                      .addMethod(getStartPaidServiceMethod())
                      .addMethod(getSuspendEntitlementMethod())
                      .addMethod(getCancelEntitlementMethod())
                      .addMethod(getActivateEntitlementMethod())
                      .addMethod(getTransferEntitlementsMethod())
                      .addMethod(getTransferEntitlementsToGoogleMethod())
                      .addMethod(getListChannelPartnerLinksMethod())
                      .addMethod(getGetChannelPartnerLinkMethod())
                      .addMethod(getCreateChannelPartnerLinkMethod())
                      .addMethod(getUpdateChannelPartnerLinkMethod())
                      .addMethod(getListProductsMethod())
                      .addMethod(getListSkusMethod())
                      .addMethod(getListOffersMethod())
                      .addMethod(getListPurchasableSkusMethod())
                      .addMethod(getListPurchasableOffersMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
