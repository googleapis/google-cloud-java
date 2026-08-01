/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.commerceproducer.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * APIs related to managing resources that model commercial transactions.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class CommerceTransactionGrpc {

  private CommerceTransactionGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.commerceproducer.v1beta.CommerceTransaction";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ListServicesRequest,
          com.google.cloud.commerceproducer.v1beta.ListServicesResponse>
      getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.google.cloud.commerceproducer.v1beta.ListServicesRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ListServicesRequest,
          com.google.cloud.commerceproducer.v1beta.ListServicesResponse>
      getListServicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.ListServicesRequest,
            com.google.cloud.commerceproducer.v1beta.ListServicesResponse>
        getListServicesMethod;
    if ((getListServicesMethod = CommerceTransactionGrpc.getListServicesMethod) == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getListServicesMethod = CommerceTransactionGrpc.getListServicesMethod) == null) {
          CommerceTransactionGrpc.getListServicesMethod =
              getListServicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.ListServicesRequest,
                          com.google.cloud.commerceproducer.v1beta.ListServicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.ListServicesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.ListServicesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("ListServices"))
                      .build();
        }
      }
    }
    return getListServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.GetServiceRequest,
          com.google.cloud.commerceproducer.v1beta.Service>
      getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetService",
      requestType = com.google.cloud.commerceproducer.v1beta.GetServiceRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.GetServiceRequest,
          com.google.cloud.commerceproducer.v1beta.Service>
      getGetServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.GetServiceRequest,
            com.google.cloud.commerceproducer.v1beta.Service>
        getGetServiceMethod;
    if ((getGetServiceMethod = CommerceTransactionGrpc.getGetServiceMethod) == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getGetServiceMethod = CommerceTransactionGrpc.getGetServiceMethod) == null) {
          CommerceTransactionGrpc.getGetServiceMethod =
              getGetServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.GetServiceRequest,
                          com.google.cloud.commerceproducer.v1beta.Service>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.GetServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.Service
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("GetService"))
                      .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest,
          com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse>
      getListPrivateOffersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPrivateOffers",
      requestType = com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest,
          com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse>
      getListPrivateOffersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest,
            com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse>
        getListPrivateOffersMethod;
    if ((getListPrivateOffersMethod = CommerceTransactionGrpc.getListPrivateOffersMethod) == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getListPrivateOffersMethod = CommerceTransactionGrpc.getListPrivateOffersMethod)
            == null) {
          CommerceTransactionGrpc.getListPrivateOffersMethod =
              getListPrivateOffersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest,
                          com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPrivateOffers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("ListPrivateOffers"))
                      .build();
        }
      }
    }
    return getListPrivateOffersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
      getGetPrivateOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPrivateOffer",
      requestType = com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.PrivateOffer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
      getGetPrivateOfferMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest,
            com.google.cloud.commerceproducer.v1beta.PrivateOffer>
        getGetPrivateOfferMethod;
    if ((getGetPrivateOfferMethod = CommerceTransactionGrpc.getGetPrivateOfferMethod) == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getGetPrivateOfferMethod = CommerceTransactionGrpc.getGetPrivateOfferMethod) == null) {
          CommerceTransactionGrpc.getGetPrivateOfferMethod =
              getGetPrivateOfferMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest,
                          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPrivateOffer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.PrivateOffer
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("GetPrivateOffer"))
                      .build();
        }
      }
    }
    return getGetPrivateOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest,
          com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse>
      getResolveAmendmentTargetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResolveAmendmentTarget",
      requestType = com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest,
          com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse>
      getResolveAmendmentTargetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest,
            com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse>
        getResolveAmendmentTargetMethod;
    if ((getResolveAmendmentTargetMethod = CommerceTransactionGrpc.getResolveAmendmentTargetMethod)
        == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getResolveAmendmentTargetMethod =
                CommerceTransactionGrpc.getResolveAmendmentTargetMethod)
            == null) {
          CommerceTransactionGrpc.getResolveAmendmentTargetMethod =
              getResolveAmendmentTargetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest,
                          com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ResolveAmendmentTarget"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta
                                  .ResolveAmendmentTargetResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("ResolveAmendmentTarget"))
                      .build();
        }
      }
    }
    return getResolveAmendmentTargetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
      getCreatePrivateOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePrivateOffer",
      requestType = com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.PrivateOffer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
      getCreatePrivateOfferMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest,
            com.google.cloud.commerceproducer.v1beta.PrivateOffer>
        getCreatePrivateOfferMethod;
    if ((getCreatePrivateOfferMethod = CommerceTransactionGrpc.getCreatePrivateOfferMethod)
        == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getCreatePrivateOfferMethod = CommerceTransactionGrpc.getCreatePrivateOfferMethod)
            == null) {
          CommerceTransactionGrpc.getCreatePrivateOfferMethod =
              getCreatePrivateOfferMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest,
                          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePrivateOffer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.PrivateOffer
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("CreatePrivateOffer"))
                      .build();
        }
      }
    }
    return getCreatePrivateOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
      getUpdatePrivateOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePrivateOffer",
      requestType = com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.PrivateOffer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
      getUpdatePrivateOfferMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest,
            com.google.cloud.commerceproducer.v1beta.PrivateOffer>
        getUpdatePrivateOfferMethod;
    if ((getUpdatePrivateOfferMethod = CommerceTransactionGrpc.getUpdatePrivateOfferMethod)
        == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getUpdatePrivateOfferMethod = CommerceTransactionGrpc.getUpdatePrivateOfferMethod)
            == null) {
          CommerceTransactionGrpc.getUpdatePrivateOfferMethod =
              getUpdatePrivateOfferMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest,
                          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePrivateOffer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.PrivateOffer
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("UpdatePrivateOffer"))
                      .build();
        }
      }
    }
    return getUpdatePrivateOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
      getPublishPrivateOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PublishPrivateOffer",
      requestType = com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.PrivateOffer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
      getPublishPrivateOfferMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest,
            com.google.cloud.commerceproducer.v1beta.PrivateOffer>
        getPublishPrivateOfferMethod;
    if ((getPublishPrivateOfferMethod = CommerceTransactionGrpc.getPublishPrivateOfferMethod)
        == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getPublishPrivateOfferMethod = CommerceTransactionGrpc.getPublishPrivateOfferMethod)
            == null) {
          CommerceTransactionGrpc.getPublishPrivateOfferMethod =
              getPublishPrivateOfferMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest,
                          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "PublishPrivateOffer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.PrivateOffer
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("PublishPrivateOffer"))
                      .build();
        }
      }
    }
    return getPublishPrivateOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
      getCancelPrivateOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelPrivateOffer",
      requestType = com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.PrivateOffer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
      getCancelPrivateOfferMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest,
            com.google.cloud.commerceproducer.v1beta.PrivateOffer>
        getCancelPrivateOfferMethod;
    if ((getCancelPrivateOfferMethod = CommerceTransactionGrpc.getCancelPrivateOfferMethod)
        == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getCancelPrivateOfferMethod = CommerceTransactionGrpc.getCancelPrivateOfferMethod)
            == null) {
          CommerceTransactionGrpc.getCancelPrivateOfferMethod =
              getCancelPrivateOfferMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest,
                          com.google.cloud.commerceproducer.v1beta.PrivateOffer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelPrivateOffer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.PrivateOffer
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("CancelPrivateOffer"))
                      .build();
        }
      }
    }
    return getCancelPrivateOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest,
          com.google.protobuf.Empty>
      getDeletePrivateOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePrivateOffer",
      requestType = com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest,
          com.google.protobuf.Empty>
      getDeletePrivateOfferMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest,
            com.google.protobuf.Empty>
        getDeletePrivateOfferMethod;
    if ((getDeletePrivateOfferMethod = CommerceTransactionGrpc.getDeletePrivateOfferMethod)
        == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getDeletePrivateOfferMethod = CommerceTransactionGrpc.getDeletePrivateOfferMethod)
            == null) {
          CommerceTransactionGrpc.getDeletePrivateOfferMethod =
              getDeletePrivateOfferMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePrivateOffer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("DeletePrivateOffer"))
                      .build();
        }
      }
    }
    return getDeletePrivateOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest,
          com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse>
      getListPrivateOfferDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPrivateOfferDocuments",
      requestType = com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest.class,
      responseType =
          com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest,
          com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse>
      getListPrivateOfferDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest,
            com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse>
        getListPrivateOfferDocumentsMethod;
    if ((getListPrivateOfferDocumentsMethod =
            CommerceTransactionGrpc.getListPrivateOfferDocumentsMethod)
        == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getListPrivateOfferDocumentsMethod =
                CommerceTransactionGrpc.getListPrivateOfferDocumentsMethod)
            == null) {
          CommerceTransactionGrpc.getListPrivateOfferDocumentsMethod =
              getListPrivateOfferDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest,
                          com.google.cloud.commerceproducer.v1beta
                              .ListPrivateOfferDocumentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPrivateOfferDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta
                                  .ListPrivateOfferDocumentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta
                                  .ListPrivateOfferDocumentsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier(
                              "ListPrivateOfferDocuments"))
                      .build();
        }
      }
    }
    return getListPrivateOfferDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
      getGetPrivateOfferDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPrivateOfferDocument",
      requestType = com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
      getGetPrivateOfferDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest,
            com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
        getGetPrivateOfferDocumentMethod;
    if ((getGetPrivateOfferDocumentMethod =
            CommerceTransactionGrpc.getGetPrivateOfferDocumentMethod)
        == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getGetPrivateOfferDocumentMethod =
                CommerceTransactionGrpc.getGetPrivateOfferDocumentMethod)
            == null) {
          CommerceTransactionGrpc.getGetPrivateOfferDocumentMethod =
              getGetPrivateOfferDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest,
                          com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetPrivateOfferDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta
                                  .GetPrivateOfferDocumentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier(
                              "GetPrivateOfferDocument"))
                      .build();
        }
      }
    }
    return getGetPrivateOfferDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
      getCreatePrivateOfferDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePrivateOfferDocument",
      requestType =
          com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
      getCreatePrivateOfferDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest,
            com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
        getCreatePrivateOfferDocumentMethod;
    if ((getCreatePrivateOfferDocumentMethod =
            CommerceTransactionGrpc.getCreatePrivateOfferDocumentMethod)
        == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getCreatePrivateOfferDocumentMethod =
                CommerceTransactionGrpc.getCreatePrivateOfferDocumentMethod)
            == null) {
          CommerceTransactionGrpc.getCreatePrivateOfferDocumentMethod =
              getCreatePrivateOfferDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest,
                          com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreatePrivateOfferDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta
                                  .CreatePrivateOfferDocumentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier(
                              "CreatePrivateOfferDocument"))
                      .build();
        }
      }
    }
    return getCreatePrivateOfferDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
      getUpdatePrivateOfferDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePrivateOfferDocument",
      requestType =
          com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest,
          com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
      getUpdatePrivateOfferDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest,
            com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
        getUpdatePrivateOfferDocumentMethod;
    if ((getUpdatePrivateOfferDocumentMethod =
            CommerceTransactionGrpc.getUpdatePrivateOfferDocumentMethod)
        == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getUpdatePrivateOfferDocumentMethod =
                CommerceTransactionGrpc.getUpdatePrivateOfferDocumentMethod)
            == null) {
          CommerceTransactionGrpc.getUpdatePrivateOfferDocumentMethod =
              getUpdatePrivateOfferDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest,
                          com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdatePrivateOfferDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta
                                  .UpdatePrivateOfferDocumentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier(
                              "UpdatePrivateOfferDocument"))
                      .build();
        }
      }
    }
    return getUpdatePrivateOfferDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest,
          com.google.protobuf.Empty>
      getDeletePrivateOfferDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePrivateOfferDocument",
      requestType =
          com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest,
          com.google.protobuf.Empty>
      getDeletePrivateOfferDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest,
            com.google.protobuf.Empty>
        getDeletePrivateOfferDocumentMethod;
    if ((getDeletePrivateOfferDocumentMethod =
            CommerceTransactionGrpc.getDeletePrivateOfferDocumentMethod)
        == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getDeletePrivateOfferDocumentMethod =
                CommerceTransactionGrpc.getDeletePrivateOfferDocumentMethod)
            == null) {
          CommerceTransactionGrpc.getDeletePrivateOfferDocumentMethod =
              getDeletePrivateOfferDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeletePrivateOfferDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta
                                  .DeletePrivateOfferDocumentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier(
                              "DeletePrivateOfferDocument"))
                      .build();
        }
      }
    }
    return getDeletePrivateOfferDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest,
          com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse>
      getListStandardOffersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListStandardOffers",
      requestType = com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest,
          com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse>
      getListStandardOffersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest,
            com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse>
        getListStandardOffersMethod;
    if ((getListStandardOffersMethod = CommerceTransactionGrpc.getListStandardOffersMethod)
        == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getListStandardOffersMethod = CommerceTransactionGrpc.getListStandardOffersMethod)
            == null) {
          CommerceTransactionGrpc.getListStandardOffersMethod =
              getListStandardOffersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest,
                          com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListStandardOffers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("ListStandardOffers"))
                      .build();
        }
      }
    }
    return getListStandardOffersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest,
          com.google.cloud.commerceproducer.v1beta.StandardOffer>
      getGetStandardOfferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStandardOffer",
      requestType = com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.StandardOffer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest,
          com.google.cloud.commerceproducer.v1beta.StandardOffer>
      getGetStandardOfferMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest,
            com.google.cloud.commerceproducer.v1beta.StandardOffer>
        getGetStandardOfferMethod;
    if ((getGetStandardOfferMethod = CommerceTransactionGrpc.getGetStandardOfferMethod) == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getGetStandardOfferMethod = CommerceTransactionGrpc.getGetStandardOfferMethod)
            == null) {
          CommerceTransactionGrpc.getGetStandardOfferMethod =
              getGetStandardOfferMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest,
                          com.google.cloud.commerceproducer.v1beta.StandardOffer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStandardOffer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.StandardOffer
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("GetStandardOffer"))
                      .build();
        }
      }
    }
    return getGetStandardOfferMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.GetSkuRequest,
          com.google.cloud.commerceproducer.v1beta.Sku>
      getGetSkuMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSku",
      requestType = com.google.cloud.commerceproducer.v1beta.GetSkuRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.Sku.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.GetSkuRequest,
          com.google.cloud.commerceproducer.v1beta.Sku>
      getGetSkuMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.GetSkuRequest,
            com.google.cloud.commerceproducer.v1beta.Sku>
        getGetSkuMethod;
    if ((getGetSkuMethod = CommerceTransactionGrpc.getGetSkuMethod) == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getGetSkuMethod = CommerceTransactionGrpc.getGetSkuMethod) == null) {
          CommerceTransactionGrpc.getGetSkuMethod =
              getGetSkuMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.GetSkuRequest,
                          com.google.cloud.commerceproducer.v1beta.Sku>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSku"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.GetSkuRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.Sku.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("GetSku"))
                      .build();
        }
      }
    }
    return getGetSkuMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ListSkusRequest,
          com.google.cloud.commerceproducer.v1beta.ListSkusResponse>
      getListSkusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSkus",
      requestType = com.google.cloud.commerceproducer.v1beta.ListSkusRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.ListSkusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ListSkusRequest,
          com.google.cloud.commerceproducer.v1beta.ListSkusResponse>
      getListSkusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.ListSkusRequest,
            com.google.cloud.commerceproducer.v1beta.ListSkusResponse>
        getListSkusMethod;
    if ((getListSkusMethod = CommerceTransactionGrpc.getListSkusMethod) == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getListSkusMethod = CommerceTransactionGrpc.getListSkusMethod) == null) {
          CommerceTransactionGrpc.getListSkusMethod =
              getListSkusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.ListSkusRequest,
                          com.google.cloud.commerceproducer.v1beta.ListSkusResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSkus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.ListSkusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.ListSkusResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("ListSkus"))
                      .build();
        }
      }
    }
    return getListSkusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest,
          com.google.cloud.commerceproducer.v1beta.SkuGroup>
      getGetSkuGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSkuGroup",
      requestType = com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.SkuGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest,
          com.google.cloud.commerceproducer.v1beta.SkuGroup>
      getGetSkuGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest,
            com.google.cloud.commerceproducer.v1beta.SkuGroup>
        getGetSkuGroupMethod;
    if ((getGetSkuGroupMethod = CommerceTransactionGrpc.getGetSkuGroupMethod) == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getGetSkuGroupMethod = CommerceTransactionGrpc.getGetSkuGroupMethod) == null) {
          CommerceTransactionGrpc.getGetSkuGroupMethod =
              getGetSkuGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest,
                          com.google.cloud.commerceproducer.v1beta.SkuGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSkuGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.SkuGroup
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("GetSkuGroup"))
                      .build();
        }
      }
    }
    return getGetSkuGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest,
          com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse>
      getListSkuGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSkuGroups",
      requestType = com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest.class,
      responseType = com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest,
          com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse>
      getListSkuGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest,
            com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse>
        getListSkuGroupsMethod;
    if ((getListSkuGroupsMethod = CommerceTransactionGrpc.getListSkuGroupsMethod) == null) {
      synchronized (CommerceTransactionGrpc.class) {
        if ((getListSkuGroupsMethod = CommerceTransactionGrpc.getListSkuGroupsMethod) == null) {
          CommerceTransactionGrpc.getListSkuGroupsMethod =
              getListSkuGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest,
                          com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSkuGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CommerceTransactionMethodDescriptorSupplier("ListSkuGroups"))
                      .build();
        }
      }
    }
    return getListSkuGroupsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CommerceTransactionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommerceTransactionStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CommerceTransactionStub>() {
          @java.lang.Override
          public CommerceTransactionStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CommerceTransactionStub(channel, callOptions);
          }
        };
    return CommerceTransactionStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CommerceTransactionBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommerceTransactionBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CommerceTransactionBlockingV2Stub>() {
          @java.lang.Override
          public CommerceTransactionBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CommerceTransactionBlockingV2Stub(channel, callOptions);
          }
        };
    return CommerceTransactionBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommerceTransactionBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommerceTransactionBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CommerceTransactionBlockingStub>() {
          @java.lang.Override
          public CommerceTransactionBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CommerceTransactionBlockingStub(channel, callOptions);
          }
        };
    return CommerceTransactionBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CommerceTransactionFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommerceTransactionFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CommerceTransactionFutureStub>() {
          @java.lang.Override
          public CommerceTransactionFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CommerceTransactionFutureStub(channel, callOptions);
          }
        };
    return CommerceTransactionFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * APIs related to managing resources that model commercial transactions.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Services in a given project and location.
     * </pre>
     */
    default void listServices(
        com.google.cloud.commerceproducer.v1beta.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServicesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Service.
     * </pre>
     */
    default void getService(
        com.google.cloud.commerceproducer.v1beta.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.Service>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists PrivateOffers for the given parent.
     * </pre>
     */
    default void listPrivateOffers(
        com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPrivateOffersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PrivateOffer.
     * </pre>
     */
    default void getPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPrivateOfferMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resolves the existing offer that must be amended when creating a new
     * PrivateOffer. Use this method to determine the correct amendment target
     * before creating or publishing an offer.
     * </pre>
     */
    default void resolveAmendmentTarget(
        com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResolveAmendmentTargetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new PrivateOffer in a given project and location.
     * </pre>
     */
    default void createPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePrivateOfferMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the target PrivateOffer.
     * </pre>
     */
    default void updatePrivateOffer(
        com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePrivateOfferMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Publishes the target PrivateOffer.
     * </pre>
     */
    default void publishPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPublishPrivateOfferMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels the target PrivateOffer.
     * </pre>
     */
    default void cancelPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelPrivateOfferMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the target PrivateOffer.
     * </pre>
     */
    default void deletePrivateOffer(
        com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePrivateOfferMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists PrivateOfferDocuments for the given parent.
     * </pre>
     */
    default void listPrivateOfferDocuments(
        com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPrivateOfferDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PrivateOfferDocument.
     * </pre>
     */
    default void getPrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPrivateOfferDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new PrivateOfferDocument in a given project and location.
     * </pre>
     */
    default void createPrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePrivateOfferDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the target PrivateOfferDocument.
     * </pre>
     */
    default void updatePrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePrivateOfferDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the target PrivateOfferDocument.
     * </pre>
     */
    default void deletePrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePrivateOfferDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists StandardOffers for the given parent.
     * </pre>
     */
    default void listStandardOffers(
        com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListStandardOffersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single StandardOffer.
     * </pre>
     */
    default void getStandardOffer(
        com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.StandardOffer>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetStandardOfferMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Sku.
     * </pre>
     */
    default void getSku(
        com.google.cloud.commerceproducer.v1beta.GetSkuRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.Sku>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSkuMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Skus for the given parent.
     * </pre>
     */
    default void listSkus(
        com.google.cloud.commerceproducer.v1beta.ListSkusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.ListSkusResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSkusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SkuGroup.
     * </pre>
     */
    default void getSkuGroup(
        com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.SkuGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSkuGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SkuGroups for the given parent.
     * </pre>
     */
    default void listSkuGroups(
        com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSkuGroupsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CommerceTransaction.
   *
   * <pre>
   * APIs related to managing resources that model commercial transactions.
   * </pre>
   */
  public abstract static class CommerceTransactionImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CommerceTransactionGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CommerceTransaction.
   *
   * <pre>
   * APIs related to managing resources that model commercial transactions.
   * </pre>
   */
  public static final class CommerceTransactionStub
      extends io.grpc.stub.AbstractAsyncStub<CommerceTransactionStub> {
    private CommerceTransactionStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommerceTransactionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommerceTransactionStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Services in a given project and location.
     * </pre>
     */
    public void listServices(
        com.google.cloud.commerceproducer.v1beta.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Service.
     * </pre>
     */
    public void getService(
        com.google.cloud.commerceproducer.v1beta.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.Service>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists PrivateOffers for the given parent.
     * </pre>
     */
    public void listPrivateOffers(
        com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPrivateOffersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PrivateOffer.
     * </pre>
     */
    public void getPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPrivateOfferMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resolves the existing offer that must be amended when creating a new
     * PrivateOffer. Use this method to determine the correct amendment target
     * before creating or publishing an offer.
     * </pre>
     */
    public void resolveAmendmentTarget(
        com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResolveAmendmentTargetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new PrivateOffer in a given project and location.
     * </pre>
     */
    public void createPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePrivateOfferMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the target PrivateOffer.
     * </pre>
     */
    public void updatePrivateOffer(
        com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePrivateOfferMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Publishes the target PrivateOffer.
     * </pre>
     */
    public void publishPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPublishPrivateOfferMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels the target PrivateOffer.
     * </pre>
     */
    public void cancelPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelPrivateOfferMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the target PrivateOffer.
     * </pre>
     */
    public void deletePrivateOffer(
        com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePrivateOfferMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists PrivateOfferDocuments for the given parent.
     * </pre>
     */
    public void listPrivateOfferDocuments(
        com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPrivateOfferDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PrivateOfferDocument.
     * </pre>
     */
    public void getPrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPrivateOfferDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new PrivateOfferDocument in a given project and location.
     * </pre>
     */
    public void createPrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePrivateOfferDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the target PrivateOfferDocument.
     * </pre>
     */
    public void updatePrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePrivateOfferDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the target PrivateOfferDocument.
     * </pre>
     */
    public void deletePrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePrivateOfferDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists StandardOffers for the given parent.
     * </pre>
     */
    public void listStandardOffers(
        com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListStandardOffersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single StandardOffer.
     * </pre>
     */
    public void getStandardOffer(
        com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.StandardOffer>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStandardOfferMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Sku.
     * </pre>
     */
    public void getSku(
        com.google.cloud.commerceproducer.v1beta.GetSkuRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.Sku>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSkuMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Skus for the given parent.
     * </pre>
     */
    public void listSkus(
        com.google.cloud.commerceproducer.v1beta.ListSkusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.ListSkusResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSkusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SkuGroup.
     * </pre>
     */
    public void getSkuGroup(
        com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.SkuGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSkuGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SkuGroups for the given parent.
     * </pre>
     */
    public void listSkuGroups(
        com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSkuGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CommerceTransaction.
   *
   * <pre>
   * APIs related to managing resources that model commercial transactions.
   * </pre>
   */
  public static final class CommerceTransactionBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CommerceTransactionBlockingV2Stub> {
    private CommerceTransactionBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommerceTransactionBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommerceTransactionBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Services in a given project and location.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ListServicesResponse listServices(
        com.google.cloud.commerceproducer.v1beta.ListServicesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Service.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.Service getService(
        com.google.cloud.commerceproducer.v1beta.GetServiceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists PrivateOffers for the given parent.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse listPrivateOffers(
        com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListPrivateOffersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PrivateOffer.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOffer getPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetPrivateOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resolves the existing offer that must be amended when creating a new
     * PrivateOffer. Use this method to determine the correct amendment target
     * before creating or publishing an offer.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse
        resolveAmendmentTarget(
            com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getResolveAmendmentTargetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new PrivateOffer in a given project and location.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOffer createPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreatePrivateOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the target PrivateOffer.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOffer updatePrivateOffer(
        com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdatePrivateOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Publishes the target PrivateOffer.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOffer publishPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPublishPrivateOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the target PrivateOffer.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOffer cancelPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCancelPrivateOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the target PrivateOffer.
     * </pre>
     */
    public com.google.protobuf.Empty deletePrivateOffer(
        com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeletePrivateOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists PrivateOfferDocuments for the given parent.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse
        listPrivateOfferDocuments(
            com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListPrivateOfferDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PrivateOfferDocument.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument getPrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetPrivateOfferDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new PrivateOfferDocument in a given project and location.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument createPrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreatePrivateOfferDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the target PrivateOfferDocument.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument updatePrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdatePrivateOfferDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the target PrivateOfferDocument.
     * </pre>
     */
    public com.google.protobuf.Empty deletePrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeletePrivateOfferDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists StandardOffers for the given parent.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse listStandardOffers(
        com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListStandardOffersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single StandardOffer.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.StandardOffer getStandardOffer(
        com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetStandardOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Sku.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.Sku getSku(
        com.google.cloud.commerceproducer.v1beta.GetSkuRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSkuMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Skus for the given parent.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ListSkusResponse listSkus(
        com.google.cloud.commerceproducer.v1beta.ListSkusRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSkusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SkuGroup.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.SkuGroup getSkuGroup(
        com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSkuGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SkuGroups for the given parent.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse listSkuGroups(
        com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSkuGroupsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CommerceTransaction.
   *
   * <pre>
   * APIs related to managing resources that model commercial transactions.
   * </pre>
   */
  public static final class CommerceTransactionBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CommerceTransactionBlockingStub> {
    private CommerceTransactionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommerceTransactionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommerceTransactionBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Services in a given project and location.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ListServicesResponse listServices(
        com.google.cloud.commerceproducer.v1beta.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Service.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.Service getService(
        com.google.cloud.commerceproducer.v1beta.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists PrivateOffers for the given parent.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse listPrivateOffers(
        com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPrivateOffersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PrivateOffer.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOffer getPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPrivateOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resolves the existing offer that must be amended when creating a new
     * PrivateOffer. Use this method to determine the correct amendment target
     * before creating or publishing an offer.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse
        resolveAmendmentTarget(
            com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResolveAmendmentTargetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new PrivateOffer in a given project and location.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOffer createPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePrivateOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the target PrivateOffer.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOffer updatePrivateOffer(
        com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePrivateOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Publishes the target PrivateOffer.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOffer publishPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPublishPrivateOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the target PrivateOffer.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOffer cancelPrivateOffer(
        com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelPrivateOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the target PrivateOffer.
     * </pre>
     */
    public com.google.protobuf.Empty deletePrivateOffer(
        com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePrivateOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists PrivateOfferDocuments for the given parent.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse
        listPrivateOfferDocuments(
            com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPrivateOfferDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PrivateOfferDocument.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument getPrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPrivateOfferDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new PrivateOfferDocument in a given project and location.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument createPrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePrivateOfferDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the target PrivateOfferDocument.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument updatePrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePrivateOfferDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the target PrivateOfferDocument.
     * </pre>
     */
    public com.google.protobuf.Empty deletePrivateOfferDocument(
        com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePrivateOfferDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists StandardOffers for the given parent.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse listStandardOffers(
        com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListStandardOffersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single StandardOffer.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.StandardOffer getStandardOffer(
        com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStandardOfferMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Sku.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.Sku getSku(
        com.google.cloud.commerceproducer.v1beta.GetSkuRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSkuMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Skus for the given parent.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ListSkusResponse listSkus(
        com.google.cloud.commerceproducer.v1beta.ListSkusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSkusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SkuGroup.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.SkuGroup getSkuGroup(
        com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSkuGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SkuGroups for the given parent.
     * </pre>
     */
    public com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse listSkuGroups(
        com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSkuGroupsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CommerceTransaction.
   *
   * <pre>
   * APIs related to managing resources that model commercial transactions.
   * </pre>
   */
  public static final class CommerceTransactionFutureStub
      extends io.grpc.stub.AbstractFutureStub<CommerceTransactionFutureStub> {
    private CommerceTransactionFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommerceTransactionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommerceTransactionFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Services in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.ListServicesResponse>
        listServices(com.google.cloud.commerceproducer.v1beta.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.Service>
        getService(com.google.cloud.commerceproducer.v1beta.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists PrivateOffers for the given parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse>
        listPrivateOffers(
            com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPrivateOffersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PrivateOffer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.PrivateOffer>
        getPrivateOffer(com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPrivateOfferMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resolves the existing offer that must be amended when creating a new
     * PrivateOffer. Use this method to determine the correct amendment target
     * before creating or publishing an offer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse>
        resolveAmendmentTarget(
            com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResolveAmendmentTargetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new PrivateOffer in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.PrivateOffer>
        createPrivateOffer(
            com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePrivateOfferMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the target PrivateOffer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.PrivateOffer>
        updatePrivateOffer(
            com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePrivateOfferMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Publishes the target PrivateOffer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.PrivateOffer>
        publishPrivateOffer(
            com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPublishPrivateOfferMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels the target PrivateOffer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.PrivateOffer>
        cancelPrivateOffer(
            com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelPrivateOfferMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the target PrivateOffer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deletePrivateOffer(
            com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePrivateOfferMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists PrivateOfferDocuments for the given parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse>
        listPrivateOfferDocuments(
            com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPrivateOfferDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single PrivateOfferDocument.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
        getPrivateOfferDocument(
            com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPrivateOfferDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new PrivateOfferDocument in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
        createPrivateOfferDocument(
            com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePrivateOfferDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the target PrivateOfferDocument.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>
        updatePrivateOfferDocument(
            com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePrivateOfferDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the target PrivateOfferDocument.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deletePrivateOfferDocument(
            com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePrivateOfferDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists StandardOffers for the given parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse>
        listStandardOffers(
            com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListStandardOffersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single StandardOffer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.StandardOffer>
        getStandardOffer(com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStandardOfferMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Sku.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.Sku>
        getSku(com.google.cloud.commerceproducer.v1beta.GetSkuRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSkuMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Skus for the given parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.ListSkusResponse>
        listSkus(com.google.cloud.commerceproducer.v1beta.ListSkusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSkusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single SkuGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.SkuGroup>
        getSkuGroup(com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSkuGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SkuGroups for the given parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse>
        listSkuGroups(com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSkuGroupsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SERVICES = 0;
  private static final int METHODID_GET_SERVICE = 1;
  private static final int METHODID_LIST_PRIVATE_OFFERS = 2;
  private static final int METHODID_GET_PRIVATE_OFFER = 3;
  private static final int METHODID_RESOLVE_AMENDMENT_TARGET = 4;
  private static final int METHODID_CREATE_PRIVATE_OFFER = 5;
  private static final int METHODID_UPDATE_PRIVATE_OFFER = 6;
  private static final int METHODID_PUBLISH_PRIVATE_OFFER = 7;
  private static final int METHODID_CANCEL_PRIVATE_OFFER = 8;
  private static final int METHODID_DELETE_PRIVATE_OFFER = 9;
  private static final int METHODID_LIST_PRIVATE_OFFER_DOCUMENTS = 10;
  private static final int METHODID_GET_PRIVATE_OFFER_DOCUMENT = 11;
  private static final int METHODID_CREATE_PRIVATE_OFFER_DOCUMENT = 12;
  private static final int METHODID_UPDATE_PRIVATE_OFFER_DOCUMENT = 13;
  private static final int METHODID_DELETE_PRIVATE_OFFER_DOCUMENT = 14;
  private static final int METHODID_LIST_STANDARD_OFFERS = 15;
  private static final int METHODID_GET_STANDARD_OFFER = 16;
  private static final int METHODID_GET_SKU = 17;
  private static final int METHODID_LIST_SKUS = 18;
  private static final int METHODID_GET_SKU_GROUP = 19;
  private static final int METHODID_LIST_SKU_GROUPS = 20;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices(
              (com.google.cloud.commerceproducer.v1beta.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerceproducer.v1beta.ListServicesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService(
              (com.google.cloud.commerceproducer.v1beta.GetServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.Service>)
                  responseObserver);
          break;
        case METHODID_LIST_PRIVATE_OFFERS:
          serviceImpl.listPrivateOffers(
              (com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PRIVATE_OFFER:
          serviceImpl.getPrivateOffer(
              (com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>)
                  responseObserver);
          break;
        case METHODID_RESOLVE_AMENDMENT_TARGET:
          serviceImpl.resolveAmendmentTarget(
              (com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_PRIVATE_OFFER:
          serviceImpl.createPrivateOffer(
              (com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PRIVATE_OFFER:
          serviceImpl.updatePrivateOffer(
              (com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>)
                  responseObserver);
          break;
        case METHODID_PUBLISH_PRIVATE_OFFER:
          serviceImpl.publishPrivateOffer(
              (com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>)
                  responseObserver);
          break;
        case METHODID_CANCEL_PRIVATE_OFFER:
          serviceImpl.cancelPrivateOffer(
              (com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.PrivateOffer>)
                  responseObserver);
          break;
        case METHODID_DELETE_PRIVATE_OFFER:
          serviceImpl.deletePrivateOffer(
              (com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_PRIVATE_OFFER_DOCUMENTS:
          serviceImpl.listPrivateOfferDocuments(
              (com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PRIVATE_OFFER_DOCUMENT:
          serviceImpl.getPrivateOfferDocument(
              (com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>)
                  responseObserver);
          break;
        case METHODID_CREATE_PRIVATE_OFFER_DOCUMENT:
          serviceImpl.createPrivateOfferDocument(
              (com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PRIVATE_OFFER_DOCUMENT:
          serviceImpl.updatePrivateOfferDocument(
              (com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>)
                  responseObserver);
          break;
        case METHODID_DELETE_PRIVATE_OFFER_DOCUMENT:
          serviceImpl.deletePrivateOfferDocument(
              (com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_STANDARD_OFFERS:
          serviceImpl.listStandardOffers(
              (com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_STANDARD_OFFER:
          serviceImpl.getStandardOffer(
              (com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.StandardOffer>)
                  responseObserver);
          break;
        case METHODID_GET_SKU:
          serviceImpl.getSku(
              (com.google.cloud.commerceproducer.v1beta.GetSkuRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.Sku>)
                  responseObserver);
          break;
        case METHODID_LIST_SKUS:
          serviceImpl.listSkus(
              (com.google.cloud.commerceproducer.v1beta.ListSkusRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerceproducer.v1beta.ListSkusResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SKU_GROUP:
          serviceImpl.getSkuGroup(
              (com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.commerceproducer.v1beta.SkuGroup>)
                  responseObserver);
          break;
        case METHODID_LIST_SKU_GROUPS:
          serviceImpl.listSkuGroups(
              (com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse>)
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListServicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.ListServicesRequest,
                    com.google.cloud.commerceproducer.v1beta.ListServicesResponse>(
                    service, METHODID_LIST_SERVICES)))
        .addMethod(
            getGetServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.GetServiceRequest,
                    com.google.cloud.commerceproducer.v1beta.Service>(
                    service, METHODID_GET_SERVICE)))
        .addMethod(
            getListPrivateOffersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest,
                    com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse>(
                    service, METHODID_LIST_PRIVATE_OFFERS)))
        .addMethod(
            getGetPrivateOfferMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest,
                    com.google.cloud.commerceproducer.v1beta.PrivateOffer>(
                    service, METHODID_GET_PRIVATE_OFFER)))
        .addMethod(
            getResolveAmendmentTargetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetRequest,
                    com.google.cloud.commerceproducer.v1beta.ResolveAmendmentTargetResponse>(
                    service, METHODID_RESOLVE_AMENDMENT_TARGET)))
        .addMethod(
            getCreatePrivateOfferMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest,
                    com.google.cloud.commerceproducer.v1beta.PrivateOffer>(
                    service, METHODID_CREATE_PRIVATE_OFFER)))
        .addMethod(
            getUpdatePrivateOfferMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest,
                    com.google.cloud.commerceproducer.v1beta.PrivateOffer>(
                    service, METHODID_UPDATE_PRIVATE_OFFER)))
        .addMethod(
            getPublishPrivateOfferMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest,
                    com.google.cloud.commerceproducer.v1beta.PrivateOffer>(
                    service, METHODID_PUBLISH_PRIVATE_OFFER)))
        .addMethod(
            getCancelPrivateOfferMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest,
                    com.google.cloud.commerceproducer.v1beta.PrivateOffer>(
                    service, METHODID_CANCEL_PRIVATE_OFFER)))
        .addMethod(
            getDeletePrivateOfferMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_PRIVATE_OFFER)))
        .addMethod(
            getListPrivateOfferDocumentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest,
                    com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse>(
                    service, METHODID_LIST_PRIVATE_OFFER_DOCUMENTS)))
        .addMethod(
            getGetPrivateOfferDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest,
                    com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>(
                    service, METHODID_GET_PRIVATE_OFFER_DOCUMENT)))
        .addMethod(
            getCreatePrivateOfferDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest,
                    com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>(
                    service, METHODID_CREATE_PRIVATE_OFFER_DOCUMENT)))
        .addMethod(
            getUpdatePrivateOfferDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest,
                    com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument>(
                    service, METHODID_UPDATE_PRIVATE_OFFER_DOCUMENT)))
        .addMethod(
            getDeletePrivateOfferDocumentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_PRIVATE_OFFER_DOCUMENT)))
        .addMethod(
            getListStandardOffersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest,
                    com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse>(
                    service, METHODID_LIST_STANDARD_OFFERS)))
        .addMethod(
            getGetStandardOfferMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest,
                    com.google.cloud.commerceproducer.v1beta.StandardOffer>(
                    service, METHODID_GET_STANDARD_OFFER)))
        .addMethod(
            getGetSkuMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.GetSkuRequest,
                    com.google.cloud.commerceproducer.v1beta.Sku>(service, METHODID_GET_SKU)))
        .addMethod(
            getListSkusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.ListSkusRequest,
                    com.google.cloud.commerceproducer.v1beta.ListSkusResponse>(
                    service, METHODID_LIST_SKUS)))
        .addMethod(
            getGetSkuGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest,
                    com.google.cloud.commerceproducer.v1beta.SkuGroup>(
                    service, METHODID_GET_SKU_GROUP)))
        .addMethod(
            getListSkuGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest,
                    com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse>(
                    service, METHODID_LIST_SKU_GROUPS)))
        .build();
  }

  private abstract static class CommerceTransactionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommerceTransactionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.commerceproducer.v1beta.CommerceTransactionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommerceTransaction");
    }
  }

  private static final class CommerceTransactionFileDescriptorSupplier
      extends CommerceTransactionBaseDescriptorSupplier {
    CommerceTransactionFileDescriptorSupplier() {}
  }

  private static final class CommerceTransactionMethodDescriptorSupplier
      extends CommerceTransactionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CommerceTransactionMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CommerceTransactionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CommerceTransactionFileDescriptorSupplier())
                      .addMethod(getListServicesMethod())
                      .addMethod(getGetServiceMethod())
                      .addMethod(getListPrivateOffersMethod())
                      .addMethod(getGetPrivateOfferMethod())
                      .addMethod(getResolveAmendmentTargetMethod())
                      .addMethod(getCreatePrivateOfferMethod())
                      .addMethod(getUpdatePrivateOfferMethod())
                      .addMethod(getPublishPrivateOfferMethod())
                      .addMethod(getCancelPrivateOfferMethod())
                      .addMethod(getDeletePrivateOfferMethod())
                      .addMethod(getListPrivateOfferDocumentsMethod())
                      .addMethod(getGetPrivateOfferDocumentMethod())
                      .addMethod(getCreatePrivateOfferDocumentMethod())
                      .addMethod(getUpdatePrivateOfferDocumentMethod())
                      .addMethod(getDeletePrivateOfferDocumentMethod())
                      .addMethod(getListStandardOffersMethod())
                      .addMethod(getGetStandardOfferMethod())
                      .addMethod(getGetSkuMethod())
                      .addMethod(getListSkusMethod())
                      .addMethod(getGetSkuGroupMethod())
                      .addMethod(getListSkuGroupsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
