/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.networksecurity.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Organization AddressGroup is created under organization. Requests against
 * Organization AddressGroup will use project from request credential for
 * activation/quota/visibility check.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/networksecurity/v1/address_group.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrganizationAddressGroupServiceGrpc {

  private OrganizationAddressGroupServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networksecurity.v1.OrganizationAddressGroupService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListAddressGroupsRequest,
          com.google.cloud.networksecurity.v1.ListAddressGroupsResponse>
      getListAddressGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAddressGroups",
      requestType = com.google.cloud.networksecurity.v1.ListAddressGroupsRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListAddressGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListAddressGroupsRequest,
          com.google.cloud.networksecurity.v1.ListAddressGroupsResponse>
      getListAddressGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListAddressGroupsRequest,
            com.google.cloud.networksecurity.v1.ListAddressGroupsResponse>
        getListAddressGroupsMethod;
    if ((getListAddressGroupsMethod =
            OrganizationAddressGroupServiceGrpc.getListAddressGroupsMethod)
        == null) {
      synchronized (OrganizationAddressGroupServiceGrpc.class) {
        if ((getListAddressGroupsMethod =
                OrganizationAddressGroupServiceGrpc.getListAddressGroupsMethod)
            == null) {
          OrganizationAddressGroupServiceGrpc.getListAddressGroupsMethod =
              getListAddressGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListAddressGroupsRequest,
                          com.google.cloud.networksecurity.v1.ListAddressGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAddressGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListAddressGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListAddressGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationAddressGroupServiceMethodDescriptorSupplier(
                              "ListAddressGroups"))
                      .build();
        }
      }
    }
    return getListAddressGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetAddressGroupRequest,
          com.google.cloud.networksecurity.v1.AddressGroup>
      getGetAddressGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAddressGroup",
      requestType = com.google.cloud.networksecurity.v1.GetAddressGroupRequest.class,
      responseType = com.google.cloud.networksecurity.v1.AddressGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetAddressGroupRequest,
          com.google.cloud.networksecurity.v1.AddressGroup>
      getGetAddressGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetAddressGroupRequest,
            com.google.cloud.networksecurity.v1.AddressGroup>
        getGetAddressGroupMethod;
    if ((getGetAddressGroupMethod = OrganizationAddressGroupServiceGrpc.getGetAddressGroupMethod)
        == null) {
      synchronized (OrganizationAddressGroupServiceGrpc.class) {
        if ((getGetAddressGroupMethod =
                OrganizationAddressGroupServiceGrpc.getGetAddressGroupMethod)
            == null) {
          OrganizationAddressGroupServiceGrpc.getGetAddressGroupMethod =
              getGetAddressGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetAddressGroupRequest,
                          com.google.cloud.networksecurity.v1.AddressGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAddressGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetAddressGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.AddressGroup
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationAddressGroupServiceMethodDescriptorSupplier(
                              "GetAddressGroup"))
                      .build();
        }
      }
    }
    return getGetAddressGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateAddressGroupRequest,
          com.google.longrunning.Operation>
      getCreateAddressGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAddressGroup",
      requestType = com.google.cloud.networksecurity.v1.CreateAddressGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateAddressGroupRequest,
          com.google.longrunning.Operation>
      getCreateAddressGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateAddressGroupRequest,
            com.google.longrunning.Operation>
        getCreateAddressGroupMethod;
    if ((getCreateAddressGroupMethod =
            OrganizationAddressGroupServiceGrpc.getCreateAddressGroupMethod)
        == null) {
      synchronized (OrganizationAddressGroupServiceGrpc.class) {
        if ((getCreateAddressGroupMethod =
                OrganizationAddressGroupServiceGrpc.getCreateAddressGroupMethod)
            == null) {
          OrganizationAddressGroupServiceGrpc.getCreateAddressGroupMethod =
              getCreateAddressGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateAddressGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAddressGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateAddressGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationAddressGroupServiceMethodDescriptorSupplier(
                              "CreateAddressGroup"))
                      .build();
        }
      }
    }
    return getCreateAddressGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest,
          com.google.longrunning.Operation>
      getUpdateAddressGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAddressGroup",
      requestType = com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest,
          com.google.longrunning.Operation>
      getUpdateAddressGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest,
            com.google.longrunning.Operation>
        getUpdateAddressGroupMethod;
    if ((getUpdateAddressGroupMethod =
            OrganizationAddressGroupServiceGrpc.getUpdateAddressGroupMethod)
        == null) {
      synchronized (OrganizationAddressGroupServiceGrpc.class) {
        if ((getUpdateAddressGroupMethod =
                OrganizationAddressGroupServiceGrpc.getUpdateAddressGroupMethod)
            == null) {
          OrganizationAddressGroupServiceGrpc.getUpdateAddressGroupMethod =
              getUpdateAddressGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAddressGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationAddressGroupServiceMethodDescriptorSupplier(
                              "UpdateAddressGroup"))
                      .build();
        }
      }
    }
    return getUpdateAddressGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest,
          com.google.longrunning.Operation>
      getAddAddressGroupItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddAddressGroupItems",
      requestType = com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest,
          com.google.longrunning.Operation>
      getAddAddressGroupItemsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest,
            com.google.longrunning.Operation>
        getAddAddressGroupItemsMethod;
    if ((getAddAddressGroupItemsMethod =
            OrganizationAddressGroupServiceGrpc.getAddAddressGroupItemsMethod)
        == null) {
      synchronized (OrganizationAddressGroupServiceGrpc.class) {
        if ((getAddAddressGroupItemsMethod =
                OrganizationAddressGroupServiceGrpc.getAddAddressGroupItemsMethod)
            == null) {
          OrganizationAddressGroupServiceGrpc.getAddAddressGroupItemsMethod =
              getAddAddressGroupItemsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AddAddressGroupItems"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationAddressGroupServiceMethodDescriptorSupplier(
                              "AddAddressGroupItems"))
                      .build();
        }
      }
    }
    return getAddAddressGroupItemsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest,
          com.google.longrunning.Operation>
      getRemoveAddressGroupItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveAddressGroupItems",
      requestType = com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest,
          com.google.longrunning.Operation>
      getRemoveAddressGroupItemsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest,
            com.google.longrunning.Operation>
        getRemoveAddressGroupItemsMethod;
    if ((getRemoveAddressGroupItemsMethod =
            OrganizationAddressGroupServiceGrpc.getRemoveAddressGroupItemsMethod)
        == null) {
      synchronized (OrganizationAddressGroupServiceGrpc.class) {
        if ((getRemoveAddressGroupItemsMethod =
                OrganizationAddressGroupServiceGrpc.getRemoveAddressGroupItemsMethod)
            == null) {
          OrganizationAddressGroupServiceGrpc.getRemoveAddressGroupItemsMethod =
              getRemoveAddressGroupItemsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RemoveAddressGroupItems"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationAddressGroupServiceMethodDescriptorSupplier(
                              "RemoveAddressGroupItems"))
                      .build();
        }
      }
    }
    return getRemoveAddressGroupItemsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest,
          com.google.longrunning.Operation>
      getCloneAddressGroupItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloneAddressGroupItems",
      requestType = com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest,
          com.google.longrunning.Operation>
      getCloneAddressGroupItemsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest,
            com.google.longrunning.Operation>
        getCloneAddressGroupItemsMethod;
    if ((getCloneAddressGroupItemsMethod =
            OrganizationAddressGroupServiceGrpc.getCloneAddressGroupItemsMethod)
        == null) {
      synchronized (OrganizationAddressGroupServiceGrpc.class) {
        if ((getCloneAddressGroupItemsMethod =
                OrganizationAddressGroupServiceGrpc.getCloneAddressGroupItemsMethod)
            == null) {
          OrganizationAddressGroupServiceGrpc.getCloneAddressGroupItemsMethod =
              getCloneAddressGroupItemsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CloneAddressGroupItems"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationAddressGroupServiceMethodDescriptorSupplier(
                              "CloneAddressGroupItems"))
                      .build();
        }
      }
    }
    return getCloneAddressGroupItemsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest,
          com.google.longrunning.Operation>
      getDeleteAddressGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAddressGroup",
      requestType = com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest,
          com.google.longrunning.Operation>
      getDeleteAddressGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest,
            com.google.longrunning.Operation>
        getDeleteAddressGroupMethod;
    if ((getDeleteAddressGroupMethod =
            OrganizationAddressGroupServiceGrpc.getDeleteAddressGroupMethod)
        == null) {
      synchronized (OrganizationAddressGroupServiceGrpc.class) {
        if ((getDeleteAddressGroupMethod =
                OrganizationAddressGroupServiceGrpc.getDeleteAddressGroupMethod)
            == null) {
          OrganizationAddressGroupServiceGrpc.getDeleteAddressGroupMethod =
              getDeleteAddressGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAddressGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationAddressGroupServiceMethodDescriptorSupplier(
                              "DeleteAddressGroup"))
                      .build();
        }
      }
    }
    return getDeleteAddressGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest,
          com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse>
      getListAddressGroupReferencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAddressGroupReferences",
      requestType = com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest,
          com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse>
      getListAddressGroupReferencesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest,
            com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse>
        getListAddressGroupReferencesMethod;
    if ((getListAddressGroupReferencesMethod =
            OrganizationAddressGroupServiceGrpc.getListAddressGroupReferencesMethod)
        == null) {
      synchronized (OrganizationAddressGroupServiceGrpc.class) {
        if ((getListAddressGroupReferencesMethod =
                OrganizationAddressGroupServiceGrpc.getListAddressGroupReferencesMethod)
            == null) {
          OrganizationAddressGroupServiceGrpc.getListAddressGroupReferencesMethod =
              getListAddressGroupReferencesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest,
                          com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAddressGroupReferences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationAddressGroupServiceMethodDescriptorSupplier(
                              "ListAddressGroupReferences"))
                      .build();
        }
      }
    }
    return getListAddressGroupReferencesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static OrganizationAddressGroupServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrganizationAddressGroupServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrganizationAddressGroupServiceStub>() {
          @java.lang.Override
          public OrganizationAddressGroupServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrganizationAddressGroupServiceStub(channel, callOptions);
          }
        };
    return OrganizationAddressGroupServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static OrganizationAddressGroupServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrganizationAddressGroupServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrganizationAddressGroupServiceBlockingV2Stub>() {
          @java.lang.Override
          public OrganizationAddressGroupServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrganizationAddressGroupServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return OrganizationAddressGroupServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrganizationAddressGroupServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrganizationAddressGroupServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrganizationAddressGroupServiceBlockingStub>() {
          @java.lang.Override
          public OrganizationAddressGroupServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrganizationAddressGroupServiceBlockingStub(channel, callOptions);
          }
        };
    return OrganizationAddressGroupServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static OrganizationAddressGroupServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrganizationAddressGroupServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrganizationAddressGroupServiceFutureStub>() {
          @java.lang.Override
          public OrganizationAddressGroupServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrganizationAddressGroupServiceFutureStub(channel, callOptions);
          }
        };
    return OrganizationAddressGroupServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Organization AddressGroup is created under organization. Requests against
   * Organization AddressGroup will use project from request credential for
   * activation/quota/visibility check.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists address groups in a given project and location.
     * </pre>
     */
    default void listAddressGroups(
        com.google.cloud.networksecurity.v1.ListAddressGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListAddressGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAddressGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single address group.
     * </pre>
     */
    default void getAddressGroup(
        com.google.cloud.networksecurity.v1.GetAddressGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.AddressGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAddressGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new address group in a given project and location.
     * </pre>
     */
    default void createAddressGroup(
        com.google.cloud.networksecurity.v1.CreateAddressGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAddressGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates parameters of an address group.
     * </pre>
     */
    default void updateAddressGroup(
        com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAddressGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds items to an address group.
     * </pre>
     */
    default void addAddressGroupItems(
        com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddAddressGroupItemsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes items from an address group.
     * </pre>
     */
    default void removeAddressGroupItems(
        com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveAddressGroupItemsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Clones items from one address group to another.
     * </pre>
     */
    default void cloneAddressGroupItems(
        com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCloneAddressGroupItemsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an address group.
     * </pre>
     */
    default void deleteAddressGroup(
        com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAddressGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists references of an address group.
     * </pre>
     */
    default void listAddressGroupReferences(
        com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAddressGroupReferencesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OrganizationAddressGroupService.
   *
   * <pre>
   * Organization AddressGroup is created under organization. Requests against
   * Organization AddressGroup will use project from request credential for
   * activation/quota/visibility check.
   * </pre>
   */
  public abstract static class OrganizationAddressGroupServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return OrganizationAddressGroupServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service
   * OrganizationAddressGroupService.
   *
   * <pre>
   * Organization AddressGroup is created under organization. Requests against
   * Organization AddressGroup will use project from request credential for
   * activation/quota/visibility check.
   * </pre>
   */
  public static final class OrganizationAddressGroupServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OrganizationAddressGroupServiceStub> {
    private OrganizationAddressGroupServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrganizationAddressGroupServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrganizationAddressGroupServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists address groups in a given project and location.
     * </pre>
     */
    public void listAddressGroups(
        com.google.cloud.networksecurity.v1.ListAddressGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListAddressGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAddressGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single address group.
     * </pre>
     */
    public void getAddressGroup(
        com.google.cloud.networksecurity.v1.GetAddressGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.AddressGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAddressGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new address group in a given project and location.
     * </pre>
     */
    public void createAddressGroup(
        com.google.cloud.networksecurity.v1.CreateAddressGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAddressGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates parameters of an address group.
     * </pre>
     */
    public void updateAddressGroup(
        com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAddressGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds items to an address group.
     * </pre>
     */
    public void addAddressGroupItems(
        com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddAddressGroupItemsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes items from an address group.
     * </pre>
     */
    public void removeAddressGroupItems(
        com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveAddressGroupItemsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Clones items from one address group to another.
     * </pre>
     */
    public void cloneAddressGroupItems(
        com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloneAddressGroupItemsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an address group.
     * </pre>
     */
    public void deleteAddressGroup(
        com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAddressGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists references of an address group.
     * </pre>
     */
    public void listAddressGroupReferences(
        com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAddressGroupReferencesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OrganizationAddressGroupService.
   *
   * <pre>
   * Organization AddressGroup is created under organization. Requests against
   * Organization AddressGroup will use project from request credential for
   * activation/quota/visibility check.
   * </pre>
   */
  public static final class OrganizationAddressGroupServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<OrganizationAddressGroupServiceBlockingV2Stub> {
    private OrganizationAddressGroupServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrganizationAddressGroupServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrganizationAddressGroupServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists address groups in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListAddressGroupsResponse listAddressGroups(
        com.google.cloud.networksecurity.v1.ListAddressGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAddressGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single address group.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.AddressGroup getAddressGroup(
        com.google.cloud.networksecurity.v1.GetAddressGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAddressGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new address group in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAddressGroup(
        com.google.cloud.networksecurity.v1.CreateAddressGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAddressGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates parameters of an address group.
     * </pre>
     */
    public com.google.longrunning.Operation updateAddressGroup(
        com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAddressGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds items to an address group.
     * </pre>
     */
    public com.google.longrunning.Operation addAddressGroupItems(
        com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddAddressGroupItemsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes items from an address group.
     * </pre>
     */
    public com.google.longrunning.Operation removeAddressGroupItems(
        com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveAddressGroupItemsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Clones items from one address group to another.
     * </pre>
     */
    public com.google.longrunning.Operation cloneAddressGroupItems(
        com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloneAddressGroupItemsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an address group.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAddressGroup(
        com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAddressGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists references of an address group.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse
        listAddressGroupReferences(
            com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAddressGroupReferencesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * OrganizationAddressGroupService.
   *
   * <pre>
   * Organization AddressGroup is created under organization. Requests against
   * Organization AddressGroup will use project from request credential for
   * activation/quota/visibility check.
   * </pre>
   */
  public static final class OrganizationAddressGroupServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OrganizationAddressGroupServiceBlockingStub> {
    private OrganizationAddressGroupServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrganizationAddressGroupServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrganizationAddressGroupServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists address groups in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListAddressGroupsResponse listAddressGroups(
        com.google.cloud.networksecurity.v1.ListAddressGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAddressGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single address group.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.AddressGroup getAddressGroup(
        com.google.cloud.networksecurity.v1.GetAddressGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAddressGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new address group in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAddressGroup(
        com.google.cloud.networksecurity.v1.CreateAddressGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAddressGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates parameters of an address group.
     * </pre>
     */
    public com.google.longrunning.Operation updateAddressGroup(
        com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAddressGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds items to an address group.
     * </pre>
     */
    public com.google.longrunning.Operation addAddressGroupItems(
        com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddAddressGroupItemsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes items from an address group.
     * </pre>
     */
    public com.google.longrunning.Operation removeAddressGroupItems(
        com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveAddressGroupItemsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Clones items from one address group to another.
     * </pre>
     */
    public com.google.longrunning.Operation cloneAddressGroupItems(
        com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloneAddressGroupItemsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an address group.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAddressGroup(
        com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAddressGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists references of an address group.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse
        listAddressGroupReferences(
            com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAddressGroupReferencesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * OrganizationAddressGroupService.
   *
   * <pre>
   * Organization AddressGroup is created under organization. Requests against
   * Organization AddressGroup will use project from request credential for
   * activation/quota/visibility check.
   * </pre>
   */
  public static final class OrganizationAddressGroupServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OrganizationAddressGroupServiceFutureStub> {
    private OrganizationAddressGroupServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrganizationAddressGroupServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrganizationAddressGroupServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists address groups in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListAddressGroupsResponse>
        listAddressGroups(com.google.cloud.networksecurity.v1.ListAddressGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAddressGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single address group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.AddressGroup>
        getAddressGroup(com.google.cloud.networksecurity.v1.GetAddressGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAddressGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new address group in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAddressGroup(com.google.cloud.networksecurity.v1.CreateAddressGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAddressGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates parameters of an address group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAddressGroup(com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAddressGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds items to an address group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        addAddressGroupItems(
            com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddAddressGroupItemsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes items from an address group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        removeAddressGroupItems(
            com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveAddressGroupItemsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Clones items from one address group to another.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        cloneAddressGroupItems(
            com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloneAddressGroupItemsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an address group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAddressGroup(com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAddressGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists references of an address group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse>
        listAddressGroupReferences(
            com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAddressGroupReferencesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ADDRESS_GROUPS = 0;
  private static final int METHODID_GET_ADDRESS_GROUP = 1;
  private static final int METHODID_CREATE_ADDRESS_GROUP = 2;
  private static final int METHODID_UPDATE_ADDRESS_GROUP = 3;
  private static final int METHODID_ADD_ADDRESS_GROUP_ITEMS = 4;
  private static final int METHODID_REMOVE_ADDRESS_GROUP_ITEMS = 5;
  private static final int METHODID_CLONE_ADDRESS_GROUP_ITEMS = 6;
  private static final int METHODID_DELETE_ADDRESS_GROUP = 7;
  private static final int METHODID_LIST_ADDRESS_GROUP_REFERENCES = 8;

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
        case METHODID_LIST_ADDRESS_GROUPS:
          serviceImpl.listAddressGroups(
              (com.google.cloud.networksecurity.v1.ListAddressGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListAddressGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ADDRESS_GROUP:
          serviceImpl.getAddressGroup(
              (com.google.cloud.networksecurity.v1.GetAddressGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.AddressGroup>)
                  responseObserver);
          break;
        case METHODID_CREATE_ADDRESS_GROUP:
          serviceImpl.createAddressGroup(
              (com.google.cloud.networksecurity.v1.CreateAddressGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ADDRESS_GROUP:
          serviceImpl.updateAddressGroup(
              (com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ADD_ADDRESS_GROUP_ITEMS:
          serviceImpl.addAddressGroupItems(
              (com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REMOVE_ADDRESS_GROUP_ITEMS:
          serviceImpl.removeAddressGroupItems(
              (com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CLONE_ADDRESS_GROUP_ITEMS:
          serviceImpl.cloneAddressGroupItems(
              (com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ADDRESS_GROUP:
          serviceImpl.deleteAddressGroup(
              (com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ADDRESS_GROUP_REFERENCES:
          serviceImpl.listAddressGroupReferences(
              (com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse>)
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
            getListAddressGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListAddressGroupsRequest,
                    com.google.cloud.networksecurity.v1.ListAddressGroupsResponse>(
                    service, METHODID_LIST_ADDRESS_GROUPS)))
        .addMethod(
            getGetAddressGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetAddressGroupRequest,
                    com.google.cloud.networksecurity.v1.AddressGroup>(
                    service, METHODID_GET_ADDRESS_GROUP)))
        .addMethod(
            getCreateAddressGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateAddressGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ADDRESS_GROUP)))
        .addMethod(
            getUpdateAddressGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.UpdateAddressGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ADDRESS_GROUP)))
        .addMethod(
            getAddAddressGroupItemsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.AddAddressGroupItemsRequest,
                    com.google.longrunning.Operation>(service, METHODID_ADD_ADDRESS_GROUP_ITEMS)))
        .addMethod(
            getRemoveAddressGroupItemsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.RemoveAddressGroupItemsRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_REMOVE_ADDRESS_GROUP_ITEMS)))
        .addMethod(
            getCloneAddressGroupItemsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CloneAddressGroupItemsRequest,
                    com.google.longrunning.Operation>(service, METHODID_CLONE_ADDRESS_GROUP_ITEMS)))
        .addMethod(
            getDeleteAddressGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteAddressGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ADDRESS_GROUP)))
        .addMethod(
            getListAddressGroupReferencesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListAddressGroupReferencesRequest,
                    com.google.cloud.networksecurity.v1.ListAddressGroupReferencesResponse>(
                    service, METHODID_LIST_ADDRESS_GROUP_REFERENCES)))
        .build();
  }

  private abstract static class OrganizationAddressGroupServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrganizationAddressGroupServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networksecurity.v1.AddressGroupProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrganizationAddressGroupService");
    }
  }

  private static final class OrganizationAddressGroupServiceFileDescriptorSupplier
      extends OrganizationAddressGroupServiceBaseDescriptorSupplier {
    OrganizationAddressGroupServiceFileDescriptorSupplier() {}
  }

  private static final class OrganizationAddressGroupServiceMethodDescriptorSupplier
      extends OrganizationAddressGroupServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OrganizationAddressGroupServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OrganizationAddressGroupServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new OrganizationAddressGroupServiceFileDescriptorSupplier())
                      .addMethod(getListAddressGroupsMethod())
                      .addMethod(getGetAddressGroupMethod())
                      .addMethod(getCreateAddressGroupMethod())
                      .addMethod(getUpdateAddressGroupMethod())
                      .addMethod(getAddAddressGroupItemsMethod())
                      .addMethod(getRemoveAddressGroupItemsMethod())
                      .addMethod(getCloneAddressGroupItemsMethod())
                      .addMethod(getDeleteAddressGroupMethod())
                      .addMethod(getListAddressGroupReferencesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
