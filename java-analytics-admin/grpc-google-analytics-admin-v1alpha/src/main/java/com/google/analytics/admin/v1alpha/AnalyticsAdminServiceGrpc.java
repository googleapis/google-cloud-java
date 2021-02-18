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
package com.google.analytics.admin.v1alpha;

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
 * Service Interface for the Analytics Admin API (GA4).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/analytics/admin/v1alpha/analytics_admin.proto")
public final class AnalyticsAdminServiceGrpc {

  private AnalyticsAdminServiceGrpc() {}

  public static final String SERVICE_NAME = "google.analytics.admin.v1alpha.AnalyticsAdminService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAccountRequest,
          com.google.analytics.admin.v1alpha.Account>
      getGetAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccount",
      requestType = com.google.analytics.admin.v1alpha.GetAccountRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAccountRequest,
          com.google.analytics.admin.v1alpha.Account>
      getGetAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetAccountRequest,
            com.google.analytics.admin.v1alpha.Account>
        getGetAccountMethod;
    if ((getGetAccountMethod = AnalyticsAdminServiceGrpc.getGetAccountMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetAccountMethod = AnalyticsAdminServiceGrpc.getGetAccountMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetAccountMethod =
              getGetAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetAccountRequest,
                          com.google.analytics.admin.v1alpha.Account>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetAccountRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Account.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetAccount"))
                      .build();
        }
      }
    }
    return getGetAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAccountsRequest,
          com.google.analytics.admin.v1alpha.ListAccountsResponse>
      getListAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccounts",
      requestType = com.google.analytics.admin.v1alpha.ListAccountsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListAccountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAccountsRequest,
          com.google.analytics.admin.v1alpha.ListAccountsResponse>
      getListAccountsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListAccountsRequest,
            com.google.analytics.admin.v1alpha.ListAccountsResponse>
        getListAccountsMethod;
    if ((getListAccountsMethod = AnalyticsAdminServiceGrpc.getListAccountsMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListAccountsMethod = AnalyticsAdminServiceGrpc.getListAccountsMethod) == null) {
          AnalyticsAdminServiceGrpc.getListAccountsMethod =
              getListAccountsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListAccountsRequest,
                          com.google.analytics.admin.v1alpha.ListAccountsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccounts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAccountsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAccountsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListAccounts"))
                      .build();
        }
      }
    }
    return getListAccountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteAccountRequest, com.google.protobuf.Empty>
      getDeleteAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAccount",
      requestType = com.google.analytics.admin.v1alpha.DeleteAccountRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteAccountRequest, com.google.protobuf.Empty>
      getDeleteAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteAccountRequest, com.google.protobuf.Empty>
        getDeleteAccountMethod;
    if ((getDeleteAccountMethod = AnalyticsAdminServiceGrpc.getDeleteAccountMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteAccountMethod = AnalyticsAdminServiceGrpc.getDeleteAccountMethod) == null) {
          AnalyticsAdminServiceGrpc.getDeleteAccountMethod =
              getDeleteAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteAccountRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteAccountRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteAccount"))
                      .build();
        }
      }
    }
    return getDeleteAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateAccountRequest,
          com.google.analytics.admin.v1alpha.Account>
      getUpdateAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccount",
      requestType = com.google.analytics.admin.v1alpha.UpdateAccountRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Account.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateAccountRequest,
          com.google.analytics.admin.v1alpha.Account>
      getUpdateAccountMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateAccountRequest,
            com.google.analytics.admin.v1alpha.Account>
        getUpdateAccountMethod;
    if ((getUpdateAccountMethod = AnalyticsAdminServiceGrpc.getUpdateAccountMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateAccountMethod = AnalyticsAdminServiceGrpc.getUpdateAccountMethod) == null) {
          AnalyticsAdminServiceGrpc.getUpdateAccountMethod =
              getUpdateAccountMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateAccountRequest,
                          com.google.analytics.admin.v1alpha.Account>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccount"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateAccountRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Account.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateAccount"))
                      .build();
        }
      }
    }
    return getUpdateAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest,
          com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
      getProvisionAccountTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProvisionAccountTicket",
      requestType = com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest,
          com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
      getProvisionAccountTicketMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest,
            com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
        getProvisionAccountTicketMethod;
    if ((getProvisionAccountTicketMethod =
            AnalyticsAdminServiceGrpc.getProvisionAccountTicketMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getProvisionAccountTicketMethod =
                AnalyticsAdminServiceGrpc.getProvisionAccountTicketMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getProvisionAccountTicketMethod =
              getProvisionAccountTicketMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest,
                          com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ProvisionAccountTicket"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ProvisionAccountTicket"))
                      .build();
        }
      }
    }
    return getProvisionAccountTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAccountSummariesRequest,
          com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
      getListAccountSummariesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccountSummaries",
      requestType = com.google.analytics.admin.v1alpha.ListAccountSummariesRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListAccountSummariesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAccountSummariesRequest,
          com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
      getListAccountSummariesMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListAccountSummariesRequest,
            com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
        getListAccountSummariesMethod;
    if ((getListAccountSummariesMethod = AnalyticsAdminServiceGrpc.getListAccountSummariesMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListAccountSummariesMethod =
                AnalyticsAdminServiceGrpc.getListAccountSummariesMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListAccountSummariesMethod =
              getListAccountSummariesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListAccountSummariesRequest,
                          com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAccountSummaries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAccountSummariesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAccountSummariesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListAccountSummaries"))
                      .build();
        }
      }
    }
    return getListAccountSummariesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetPropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getGetPropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProperty",
      requestType = com.google.analytics.admin.v1alpha.GetPropertyRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Property.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetPropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getGetPropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetPropertyRequest,
            com.google.analytics.admin.v1alpha.Property>
        getGetPropertyMethod;
    if ((getGetPropertyMethod = AnalyticsAdminServiceGrpc.getGetPropertyMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetPropertyMethod = AnalyticsAdminServiceGrpc.getGetPropertyMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetPropertyMethod =
              getGetPropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetPropertyRequest,
                          com.google.analytics.admin.v1alpha.Property>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetPropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Property.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetProperty"))
                      .build();
        }
      }
    }
    return getGetPropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListPropertiesRequest,
          com.google.analytics.admin.v1alpha.ListPropertiesResponse>
      getListPropertiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProperties",
      requestType = com.google.analytics.admin.v1alpha.ListPropertiesRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListPropertiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListPropertiesRequest,
          com.google.analytics.admin.v1alpha.ListPropertiesResponse>
      getListPropertiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListPropertiesRequest,
            com.google.analytics.admin.v1alpha.ListPropertiesResponse>
        getListPropertiesMethod;
    if ((getListPropertiesMethod = AnalyticsAdminServiceGrpc.getListPropertiesMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListPropertiesMethod = AnalyticsAdminServiceGrpc.getListPropertiesMethod) == null) {
          AnalyticsAdminServiceGrpc.getListPropertiesMethod =
              getListPropertiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListPropertiesRequest,
                          com.google.analytics.admin.v1alpha.ListPropertiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProperties"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListPropertiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListPropertiesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListProperties"))
                      .build();
        }
      }
    }
    return getListPropertiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreatePropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getCreatePropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProperty",
      requestType = com.google.analytics.admin.v1alpha.CreatePropertyRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Property.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreatePropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getCreatePropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreatePropertyRequest,
            com.google.analytics.admin.v1alpha.Property>
        getCreatePropertyMethod;
    if ((getCreatePropertyMethod = AnalyticsAdminServiceGrpc.getCreatePropertyMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreatePropertyMethod = AnalyticsAdminServiceGrpc.getCreatePropertyMethod) == null) {
          AnalyticsAdminServiceGrpc.getCreatePropertyMethod =
              getCreatePropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreatePropertyRequest,
                          com.google.analytics.admin.v1alpha.Property>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreatePropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Property.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateProperty"))
                      .build();
        }
      }
    }
    return getCreatePropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeletePropertyRequest, com.google.protobuf.Empty>
      getDeletePropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProperty",
      requestType = com.google.analytics.admin.v1alpha.DeletePropertyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeletePropertyRequest, com.google.protobuf.Empty>
      getDeletePropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeletePropertyRequest, com.google.protobuf.Empty>
        getDeletePropertyMethod;
    if ((getDeletePropertyMethod = AnalyticsAdminServiceGrpc.getDeletePropertyMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeletePropertyMethod = AnalyticsAdminServiceGrpc.getDeletePropertyMethod) == null) {
          AnalyticsAdminServiceGrpc.getDeletePropertyMethod =
              getDeletePropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeletePropertyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeletePropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteProperty"))
                      .build();
        }
      }
    }
    return getDeletePropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdatePropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getUpdatePropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProperty",
      requestType = com.google.analytics.admin.v1alpha.UpdatePropertyRequest.class,
      responseType = com.google.analytics.admin.v1alpha.Property.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdatePropertyRequest,
          com.google.analytics.admin.v1alpha.Property>
      getUpdatePropertyMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdatePropertyRequest,
            com.google.analytics.admin.v1alpha.Property>
        getUpdatePropertyMethod;
    if ((getUpdatePropertyMethod = AnalyticsAdminServiceGrpc.getUpdatePropertyMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdatePropertyMethod = AnalyticsAdminServiceGrpc.getUpdatePropertyMethod) == null) {
          AnalyticsAdminServiceGrpc.getUpdatePropertyMethod =
              getUpdatePropertyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdatePropertyRequest,
                          com.google.analytics.admin.v1alpha.Property>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProperty"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdatePropertyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.Property.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateProperty"))
                      .build();
        }
      }
    }
    return getUpdatePropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetUserLinkRequest,
          com.google.analytics.admin.v1alpha.UserLink>
      getGetUserLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserLink",
      requestType = com.google.analytics.admin.v1alpha.GetUserLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.UserLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetUserLinkRequest,
          com.google.analytics.admin.v1alpha.UserLink>
      getGetUserLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetUserLinkRequest,
            com.google.analytics.admin.v1alpha.UserLink>
        getGetUserLinkMethod;
    if ((getGetUserLinkMethod = AnalyticsAdminServiceGrpc.getGetUserLinkMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetUserLinkMethod = AnalyticsAdminServiceGrpc.getGetUserLinkMethod) == null) {
          AnalyticsAdminServiceGrpc.getGetUserLinkMethod =
              getGetUserLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetUserLinkRequest,
                          com.google.analytics.admin.v1alpha.UserLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetUserLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UserLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetUserLink"))
                      .build();
        }
      }
    }
    return getGetUserLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest,
          com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
      getBatchGetUserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchGetUserLinks",
      requestType = com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest,
          com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
      getBatchGetUserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest,
            com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
        getBatchGetUserLinksMethod;
    if ((getBatchGetUserLinksMethod = AnalyticsAdminServiceGrpc.getBatchGetUserLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getBatchGetUserLinksMethod = AnalyticsAdminServiceGrpc.getBatchGetUserLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getBatchGetUserLinksMethod =
              getBatchGetUserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest,
                          com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchGetUserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("BatchGetUserLinks"))
                      .build();
        }
      }
    }
    return getBatchGetUserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListUserLinksRequest,
          com.google.analytics.admin.v1alpha.ListUserLinksResponse>
      getListUserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserLinks",
      requestType = com.google.analytics.admin.v1alpha.ListUserLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListUserLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListUserLinksRequest,
          com.google.analytics.admin.v1alpha.ListUserLinksResponse>
      getListUserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListUserLinksRequest,
            com.google.analytics.admin.v1alpha.ListUserLinksResponse>
        getListUserLinksMethod;
    if ((getListUserLinksMethod = AnalyticsAdminServiceGrpc.getListUserLinksMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListUserLinksMethod = AnalyticsAdminServiceGrpc.getListUserLinksMethod) == null) {
          AnalyticsAdminServiceGrpc.getListUserLinksMethod =
              getListUserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListUserLinksRequest,
                          com.google.analytics.admin.v1alpha.ListUserLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListUserLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListUserLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListUserLinks"))
                      .build();
        }
      }
    }
    return getListUserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.AuditUserLinksRequest,
          com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
      getAuditUserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AuditUserLinks",
      requestType = com.google.analytics.admin.v1alpha.AuditUserLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AuditUserLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.AuditUserLinksRequest,
          com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
      getAuditUserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.AuditUserLinksRequest,
            com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
        getAuditUserLinksMethod;
    if ((getAuditUserLinksMethod = AnalyticsAdminServiceGrpc.getAuditUserLinksMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getAuditUserLinksMethod = AnalyticsAdminServiceGrpc.getAuditUserLinksMethod) == null) {
          AnalyticsAdminServiceGrpc.getAuditUserLinksMethod =
              getAuditUserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.AuditUserLinksRequest,
                          com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AuditUserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AuditUserLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AuditUserLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("AuditUserLinks"))
                      .build();
        }
      }
    }
    return getAuditUserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateUserLinkRequest,
          com.google.analytics.admin.v1alpha.UserLink>
      getCreateUserLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUserLink",
      requestType = com.google.analytics.admin.v1alpha.CreateUserLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.UserLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateUserLinkRequest,
          com.google.analytics.admin.v1alpha.UserLink>
      getCreateUserLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateUserLinkRequest,
            com.google.analytics.admin.v1alpha.UserLink>
        getCreateUserLinkMethod;
    if ((getCreateUserLinkMethod = AnalyticsAdminServiceGrpc.getCreateUserLinkMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateUserLinkMethod = AnalyticsAdminServiceGrpc.getCreateUserLinkMethod) == null) {
          AnalyticsAdminServiceGrpc.getCreateUserLinkMethod =
              getCreateUserLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateUserLinkRequest,
                          com.google.analytics.admin.v1alpha.UserLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUserLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateUserLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UserLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateUserLink"))
                      .build();
        }
      }
    }
    return getCreateUserLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest,
          com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
      getBatchCreateUserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateUserLinks",
      requestType = com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest,
          com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
      getBatchCreateUserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest,
            com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
        getBatchCreateUserLinksMethod;
    if ((getBatchCreateUserLinksMethod = AnalyticsAdminServiceGrpc.getBatchCreateUserLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getBatchCreateUserLinksMethod =
                AnalyticsAdminServiceGrpc.getBatchCreateUserLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getBatchCreateUserLinksMethod =
              getBatchCreateUserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest,
                          com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateUserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("BatchCreateUserLinks"))
                      .build();
        }
      }
    }
    return getBatchCreateUserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateUserLinkRequest,
          com.google.analytics.admin.v1alpha.UserLink>
      getUpdateUserLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserLink",
      requestType = com.google.analytics.admin.v1alpha.UpdateUserLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.UserLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateUserLinkRequest,
          com.google.analytics.admin.v1alpha.UserLink>
      getUpdateUserLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateUserLinkRequest,
            com.google.analytics.admin.v1alpha.UserLink>
        getUpdateUserLinkMethod;
    if ((getUpdateUserLinkMethod = AnalyticsAdminServiceGrpc.getUpdateUserLinkMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateUserLinkMethod = AnalyticsAdminServiceGrpc.getUpdateUserLinkMethod) == null) {
          AnalyticsAdminServiceGrpc.getUpdateUserLinkMethod =
              getUpdateUserLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateUserLinkRequest,
                          com.google.analytics.admin.v1alpha.UserLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUserLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateUserLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UserLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateUserLink"))
                      .build();
        }
      }
    }
    return getUpdateUserLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest,
          com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
      getBatchUpdateUserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdateUserLinks",
      requestType = com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest,
          com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
      getBatchUpdateUserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest,
            com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
        getBatchUpdateUserLinksMethod;
    if ((getBatchUpdateUserLinksMethod = AnalyticsAdminServiceGrpc.getBatchUpdateUserLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getBatchUpdateUserLinksMethod =
                AnalyticsAdminServiceGrpc.getBatchUpdateUserLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getBatchUpdateUserLinksMethod =
              getBatchUpdateUserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest,
                          com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchUpdateUserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("BatchUpdateUserLinks"))
                      .build();
        }
      }
    }
    return getBatchUpdateUserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteUserLinkRequest, com.google.protobuf.Empty>
      getDeleteUserLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteUserLink",
      requestType = com.google.analytics.admin.v1alpha.DeleteUserLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteUserLinkRequest, com.google.protobuf.Empty>
      getDeleteUserLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteUserLinkRequest, com.google.protobuf.Empty>
        getDeleteUserLinkMethod;
    if ((getDeleteUserLinkMethod = AnalyticsAdminServiceGrpc.getDeleteUserLinkMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteUserLinkMethod = AnalyticsAdminServiceGrpc.getDeleteUserLinkMethod) == null) {
          AnalyticsAdminServiceGrpc.getDeleteUserLinkMethod =
              getDeleteUserLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteUserLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteUserLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteUserLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteUserLink"))
                      .build();
        }
      }
    }
    return getDeleteUserLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest, com.google.protobuf.Empty>
      getBatchDeleteUserLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteUserLinks",
      requestType = com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest, com.google.protobuf.Empty>
      getBatchDeleteUserLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest,
            com.google.protobuf.Empty>
        getBatchDeleteUserLinksMethod;
    if ((getBatchDeleteUserLinksMethod = AnalyticsAdminServiceGrpc.getBatchDeleteUserLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getBatchDeleteUserLinksMethod =
                AnalyticsAdminServiceGrpc.getBatchDeleteUserLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getBatchDeleteUserLinksMethod =
              getBatchDeleteUserLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteUserLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("BatchDeleteUserLinks"))
                      .build();
        }
      }
    }
    return getBatchDeleteUserLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetWebDataStreamRequest,
          com.google.analytics.admin.v1alpha.WebDataStream>
      getGetWebDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWebDataStream",
      requestType = com.google.analytics.admin.v1alpha.GetWebDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1alpha.WebDataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetWebDataStreamRequest,
          com.google.analytics.admin.v1alpha.WebDataStream>
      getGetWebDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetWebDataStreamRequest,
            com.google.analytics.admin.v1alpha.WebDataStream>
        getGetWebDataStreamMethod;
    if ((getGetWebDataStreamMethod = AnalyticsAdminServiceGrpc.getGetWebDataStreamMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetWebDataStreamMethod = AnalyticsAdminServiceGrpc.getGetWebDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetWebDataStreamMethod =
              getGetWebDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetWebDataStreamRequest,
                          com.google.analytics.admin.v1alpha.WebDataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWebDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetWebDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.WebDataStream
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetWebDataStream"))
                      .build();
        }
      }
    }
    return getGetWebDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest, com.google.protobuf.Empty>
      getDeleteWebDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWebDataStream",
      requestType = com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest, com.google.protobuf.Empty>
      getDeleteWebDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest,
            com.google.protobuf.Empty>
        getDeleteWebDataStreamMethod;
    if ((getDeleteWebDataStreamMethod = AnalyticsAdminServiceGrpc.getDeleteWebDataStreamMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteWebDataStreamMethod = AnalyticsAdminServiceGrpc.getDeleteWebDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteWebDataStreamMethod =
              getDeleteWebDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteWebDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteWebDataStream"))
                      .build();
        }
      }
    }
    return getDeleteWebDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest,
          com.google.analytics.admin.v1alpha.WebDataStream>
      getUpdateWebDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWebDataStream",
      requestType = com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1alpha.WebDataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest,
          com.google.analytics.admin.v1alpha.WebDataStream>
      getUpdateWebDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest,
            com.google.analytics.admin.v1alpha.WebDataStream>
        getUpdateWebDataStreamMethod;
    if ((getUpdateWebDataStreamMethod = AnalyticsAdminServiceGrpc.getUpdateWebDataStreamMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateWebDataStreamMethod = AnalyticsAdminServiceGrpc.getUpdateWebDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateWebDataStreamMethod =
              getUpdateWebDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest,
                          com.google.analytics.admin.v1alpha.WebDataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateWebDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.WebDataStream
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateWebDataStream"))
                      .build();
        }
      }
    }
    return getUpdateWebDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest,
          com.google.analytics.admin.v1alpha.WebDataStream>
      getCreateWebDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWebDataStream",
      requestType = com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1alpha.WebDataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest,
          com.google.analytics.admin.v1alpha.WebDataStream>
      getCreateWebDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest,
            com.google.analytics.admin.v1alpha.WebDataStream>
        getCreateWebDataStreamMethod;
    if ((getCreateWebDataStreamMethod = AnalyticsAdminServiceGrpc.getCreateWebDataStreamMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateWebDataStreamMethod = AnalyticsAdminServiceGrpc.getCreateWebDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateWebDataStreamMethod =
              getCreateWebDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest,
                          com.google.analytics.admin.v1alpha.WebDataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateWebDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.WebDataStream
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateWebDataStream"))
                      .build();
        }
      }
    }
    return getCreateWebDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest,
          com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse>
      getListWebDataStreamsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWebDataStreams",
      requestType = com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest,
          com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse>
      getListWebDataStreamsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest,
            com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse>
        getListWebDataStreamsMethod;
    if ((getListWebDataStreamsMethod = AnalyticsAdminServiceGrpc.getListWebDataStreamsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListWebDataStreamsMethod = AnalyticsAdminServiceGrpc.getListWebDataStreamsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListWebDataStreamsMethod =
              getListWebDataStreamsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest,
                          com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWebDataStreams"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListWebDataStreams"))
                      .build();
        }
      }
    }
    return getListWebDataStreamsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest,
          com.google.analytics.admin.v1alpha.IosAppDataStream>
      getGetIosAppDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIosAppDataStream",
      requestType = com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1alpha.IosAppDataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest,
          com.google.analytics.admin.v1alpha.IosAppDataStream>
      getGetIosAppDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest,
            com.google.analytics.admin.v1alpha.IosAppDataStream>
        getGetIosAppDataStreamMethod;
    if ((getGetIosAppDataStreamMethod = AnalyticsAdminServiceGrpc.getGetIosAppDataStreamMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetIosAppDataStreamMethod = AnalyticsAdminServiceGrpc.getGetIosAppDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetIosAppDataStreamMethod =
              getGetIosAppDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest,
                          com.google.analytics.admin.v1alpha.IosAppDataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetIosAppDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.IosAppDataStream
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetIosAppDataStream"))
                      .build();
        }
      }
    }
    return getGetIosAppDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest,
          com.google.protobuf.Empty>
      getDeleteIosAppDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIosAppDataStream",
      requestType = com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest,
          com.google.protobuf.Empty>
      getDeleteIosAppDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest,
            com.google.protobuf.Empty>
        getDeleteIosAppDataStreamMethod;
    if ((getDeleteIosAppDataStreamMethod =
            AnalyticsAdminServiceGrpc.getDeleteIosAppDataStreamMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteIosAppDataStreamMethod =
                AnalyticsAdminServiceGrpc.getDeleteIosAppDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteIosAppDataStreamMethod =
              getDeleteIosAppDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteIosAppDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteIosAppDataStream"))
                      .build();
        }
      }
    }
    return getDeleteIosAppDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest,
          com.google.analytics.admin.v1alpha.IosAppDataStream>
      getUpdateIosAppDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIosAppDataStream",
      requestType = com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1alpha.IosAppDataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest,
          com.google.analytics.admin.v1alpha.IosAppDataStream>
      getUpdateIosAppDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest,
            com.google.analytics.admin.v1alpha.IosAppDataStream>
        getUpdateIosAppDataStreamMethod;
    if ((getUpdateIosAppDataStreamMethod =
            AnalyticsAdminServiceGrpc.getUpdateIosAppDataStreamMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateIosAppDataStreamMethod =
                AnalyticsAdminServiceGrpc.getUpdateIosAppDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateIosAppDataStreamMethod =
              getUpdateIosAppDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest,
                          com.google.analytics.admin.v1alpha.IosAppDataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateIosAppDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.IosAppDataStream
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateIosAppDataStream"))
                      .build();
        }
      }
    }
    return getUpdateIosAppDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest,
          com.google.analytics.admin.v1alpha.IosAppDataStream>
      getCreateIosAppDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIosAppDataStream",
      requestType = com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1alpha.IosAppDataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest,
          com.google.analytics.admin.v1alpha.IosAppDataStream>
      getCreateIosAppDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest,
            com.google.analytics.admin.v1alpha.IosAppDataStream>
        getCreateIosAppDataStreamMethod;
    if ((getCreateIosAppDataStreamMethod =
            AnalyticsAdminServiceGrpc.getCreateIosAppDataStreamMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateIosAppDataStreamMethod =
                AnalyticsAdminServiceGrpc.getCreateIosAppDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateIosAppDataStreamMethod =
              getCreateIosAppDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest,
                          com.google.analytics.admin.v1alpha.IosAppDataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateIosAppDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.IosAppDataStream
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateIosAppDataStream"))
                      .build();
        }
      }
    }
    return getCreateIosAppDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest,
          com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse>
      getListIosAppDataStreamsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIosAppDataStreams",
      requestType = com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest,
          com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse>
      getListIosAppDataStreamsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest,
            com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse>
        getListIosAppDataStreamsMethod;
    if ((getListIosAppDataStreamsMethod = AnalyticsAdminServiceGrpc.getListIosAppDataStreamsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListIosAppDataStreamsMethod =
                AnalyticsAdminServiceGrpc.getListIosAppDataStreamsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListIosAppDataStreamsMethod =
              getListIosAppDataStreamsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest,
                          com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListIosAppDataStreams"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ListIosAppDataStreams"))
                      .build();
        }
      }
    }
    return getListIosAppDataStreamsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest,
          com.google.analytics.admin.v1alpha.AndroidAppDataStream>
      getGetAndroidAppDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAndroidAppDataStream",
      requestType = com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AndroidAppDataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest,
          com.google.analytics.admin.v1alpha.AndroidAppDataStream>
      getGetAndroidAppDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest,
            com.google.analytics.admin.v1alpha.AndroidAppDataStream>
        getGetAndroidAppDataStreamMethod;
    if ((getGetAndroidAppDataStreamMethod =
            AnalyticsAdminServiceGrpc.getGetAndroidAppDataStreamMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetAndroidAppDataStreamMethod =
                AnalyticsAdminServiceGrpc.getGetAndroidAppDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetAndroidAppDataStreamMethod =
              getGetAndroidAppDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest,
                          com.google.analytics.admin.v1alpha.AndroidAppDataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAndroidAppDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AndroidAppDataStream
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetAndroidAppDataStream"))
                      .build();
        }
      }
    }
    return getGetAndroidAppDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest,
          com.google.protobuf.Empty>
      getDeleteAndroidAppDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAndroidAppDataStream",
      requestType = com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest,
          com.google.protobuf.Empty>
      getDeleteAndroidAppDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest,
            com.google.protobuf.Empty>
        getDeleteAndroidAppDataStreamMethod;
    if ((getDeleteAndroidAppDataStreamMethod =
            AnalyticsAdminServiceGrpc.getDeleteAndroidAppDataStreamMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteAndroidAppDataStreamMethod =
                AnalyticsAdminServiceGrpc.getDeleteAndroidAppDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteAndroidAppDataStreamMethod =
              getDeleteAndroidAppDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAndroidAppDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "DeleteAndroidAppDataStream"))
                      .build();
        }
      }
    }
    return getDeleteAndroidAppDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest,
          com.google.analytics.admin.v1alpha.AndroidAppDataStream>
      getUpdateAndroidAppDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAndroidAppDataStream",
      requestType = com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AndroidAppDataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest,
          com.google.analytics.admin.v1alpha.AndroidAppDataStream>
      getUpdateAndroidAppDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest,
            com.google.analytics.admin.v1alpha.AndroidAppDataStream>
        getUpdateAndroidAppDataStreamMethod;
    if ((getUpdateAndroidAppDataStreamMethod =
            AnalyticsAdminServiceGrpc.getUpdateAndroidAppDataStreamMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateAndroidAppDataStreamMethod =
                AnalyticsAdminServiceGrpc.getUpdateAndroidAppDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateAndroidAppDataStreamMethod =
              getUpdateAndroidAppDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest,
                          com.google.analytics.admin.v1alpha.AndroidAppDataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAndroidAppDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AndroidAppDataStream
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateAndroidAppDataStream"))
                      .build();
        }
      }
    }
    return getUpdateAndroidAppDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest,
          com.google.analytics.admin.v1alpha.AndroidAppDataStream>
      getCreateAndroidAppDataStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAndroidAppDataStream",
      requestType = com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest.class,
      responseType = com.google.analytics.admin.v1alpha.AndroidAppDataStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest,
          com.google.analytics.admin.v1alpha.AndroidAppDataStream>
      getCreateAndroidAppDataStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest,
            com.google.analytics.admin.v1alpha.AndroidAppDataStream>
        getCreateAndroidAppDataStreamMethod;
    if ((getCreateAndroidAppDataStreamMethod =
            AnalyticsAdminServiceGrpc.getCreateAndroidAppDataStreamMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateAndroidAppDataStreamMethod =
                AnalyticsAdminServiceGrpc.getCreateAndroidAppDataStreamMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateAndroidAppDataStreamMethod =
              getCreateAndroidAppDataStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest,
                          com.google.analytics.admin.v1alpha.AndroidAppDataStream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAndroidAppDataStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.AndroidAppDataStream
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "CreateAndroidAppDataStream"))
                      .build();
        }
      }
    }
    return getCreateAndroidAppDataStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest,
          com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse>
      getListAndroidAppDataStreamsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAndroidAppDataStreams",
      requestType = com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest,
          com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse>
      getListAndroidAppDataStreamsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest,
            com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse>
        getListAndroidAppDataStreamsMethod;
    if ((getListAndroidAppDataStreamsMethod =
            AnalyticsAdminServiceGrpc.getListAndroidAppDataStreamsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListAndroidAppDataStreamsMethod =
                AnalyticsAdminServiceGrpc.getListAndroidAppDataStreamsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListAndroidAppDataStreamsMethod =
              getListAndroidAppDataStreamsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest,
                          com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAndroidAppDataStreams"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "ListAndroidAppDataStreams"))
                      .build();
        }
      }
    }
    return getListAndroidAppDataStreamsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest,
          com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
      getGetEnhancedMeasurementSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnhancedMeasurementSettings",
      requestType = com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest,
          com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
      getGetEnhancedMeasurementSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest,
            com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
        getGetEnhancedMeasurementSettingsMethod;
    if ((getGetEnhancedMeasurementSettingsMethod =
            AnalyticsAdminServiceGrpc.getGetEnhancedMeasurementSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetEnhancedMeasurementSettingsMethod =
                AnalyticsAdminServiceGrpc.getGetEnhancedMeasurementSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetEnhancedMeasurementSettingsMethod =
              getGetEnhancedMeasurementSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest,
                          com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetEnhancedMeasurementSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .GetEnhancedMeasurementSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetEnhancedMeasurementSettings"))
                      .build();
        }
      }
    }
    return getGetEnhancedMeasurementSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest,
          com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
      getUpdateEnhancedMeasurementSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEnhancedMeasurementSettings",
      requestType =
          com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest,
          com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
      getUpdateEnhancedMeasurementSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest,
            com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
        getUpdateEnhancedMeasurementSettingsMethod;
    if ((getUpdateEnhancedMeasurementSettingsMethod =
            AnalyticsAdminServiceGrpc.getUpdateEnhancedMeasurementSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateEnhancedMeasurementSettingsMethod =
                AnalyticsAdminServiceGrpc.getUpdateEnhancedMeasurementSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateEnhancedMeasurementSettingsMethod =
              getUpdateEnhancedMeasurementSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest,
                          com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateEnhancedMeasurementSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha
                                  .UpdateEnhancedMeasurementSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "UpdateEnhancedMeasurementSettings"))
                      .build();
        }
      }
    }
    return getUpdateEnhancedMeasurementSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest,
          com.google.analytics.admin.v1alpha.FirebaseLink>
      getCreateFirebaseLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFirebaseLink",
      requestType = com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.FirebaseLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest,
          com.google.analytics.admin.v1alpha.FirebaseLink>
      getCreateFirebaseLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest,
            com.google.analytics.admin.v1alpha.FirebaseLink>
        getCreateFirebaseLinkMethod;
    if ((getCreateFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getCreateFirebaseLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getCreateFirebaseLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateFirebaseLinkMethod =
              getCreateFirebaseLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest,
                          com.google.analytics.admin.v1alpha.FirebaseLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFirebaseLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.FirebaseLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateFirebaseLink"))
                      .build();
        }
      }
    }
    return getCreateFirebaseLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest,
          com.google.analytics.admin.v1alpha.FirebaseLink>
      getUpdateFirebaseLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFirebaseLink",
      requestType = com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.FirebaseLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest,
          com.google.analytics.admin.v1alpha.FirebaseLink>
      getUpdateFirebaseLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest,
            com.google.analytics.admin.v1alpha.FirebaseLink>
        getUpdateFirebaseLinkMethod;
    if ((getUpdateFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getUpdateFirebaseLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getUpdateFirebaseLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateFirebaseLinkMethod =
              getUpdateFirebaseLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest,
                          com.google.analytics.admin.v1alpha.FirebaseLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFirebaseLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.FirebaseLink.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateFirebaseLink"))
                      .build();
        }
      }
    }
    return getUpdateFirebaseLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest, com.google.protobuf.Empty>
      getDeleteFirebaseLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFirebaseLink",
      requestType = com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest, com.google.protobuf.Empty>
      getDeleteFirebaseLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest, com.google.protobuf.Empty>
        getDeleteFirebaseLinkMethod;
    if ((getDeleteFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getDeleteFirebaseLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteFirebaseLinkMethod = AnalyticsAdminServiceGrpc.getDeleteFirebaseLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteFirebaseLinkMethod =
              getDeleteFirebaseLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFirebaseLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteFirebaseLink"))
                      .build();
        }
      }
    }
    return getDeleteFirebaseLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest,
          com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
      getListFirebaseLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFirebaseLinks",
      requestType = com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest,
          com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
      getListFirebaseLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest,
            com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
        getListFirebaseLinksMethod;
    if ((getListFirebaseLinksMethod = AnalyticsAdminServiceGrpc.getListFirebaseLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListFirebaseLinksMethod = AnalyticsAdminServiceGrpc.getListFirebaseLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListFirebaseLinksMethod =
              getListFirebaseLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest,
                          com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFirebaseLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListFirebaseLinks"))
                      .build();
        }
      }
    }
    return getListFirebaseLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest,
          com.google.analytics.admin.v1alpha.GlobalSiteTag>
      getGetGlobalSiteTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGlobalSiteTag",
      requestType = com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest.class,
      responseType = com.google.analytics.admin.v1alpha.GlobalSiteTag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest,
          com.google.analytics.admin.v1alpha.GlobalSiteTag>
      getGetGlobalSiteTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest,
            com.google.analytics.admin.v1alpha.GlobalSiteTag>
        getGetGlobalSiteTagMethod;
    if ((getGetGlobalSiteTagMethod = AnalyticsAdminServiceGrpc.getGetGlobalSiteTagMethod) == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetGlobalSiteTagMethod = AnalyticsAdminServiceGrpc.getGetGlobalSiteTagMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetGlobalSiteTagMethod =
              getGetGlobalSiteTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest,
                          com.google.analytics.admin.v1alpha.GlobalSiteTag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGlobalSiteTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GlobalSiteTag
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("GetGlobalSiteTag"))
                      .build();
        }
      }
    }
    return getGetGlobalSiteTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest,
          com.google.analytics.admin.v1alpha.GoogleAdsLink>
      getCreateGoogleAdsLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGoogleAdsLink",
      requestType = com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.GoogleAdsLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest,
          com.google.analytics.admin.v1alpha.GoogleAdsLink>
      getCreateGoogleAdsLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest,
            com.google.analytics.admin.v1alpha.GoogleAdsLink>
        getCreateGoogleAdsLinkMethod;
    if ((getCreateGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getCreateGoogleAdsLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getCreateGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getCreateGoogleAdsLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getCreateGoogleAdsLinkMethod =
              getCreateGoogleAdsLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest,
                          com.google.analytics.admin.v1alpha.GoogleAdsLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateGoogleAdsLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GoogleAdsLink
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("CreateGoogleAdsLink"))
                      .build();
        }
      }
    }
    return getCreateGoogleAdsLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest,
          com.google.analytics.admin.v1alpha.GoogleAdsLink>
      getUpdateGoogleAdsLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGoogleAdsLink",
      requestType = com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest.class,
      responseType = com.google.analytics.admin.v1alpha.GoogleAdsLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest,
          com.google.analytics.admin.v1alpha.GoogleAdsLink>
      getUpdateGoogleAdsLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest,
            com.google.analytics.admin.v1alpha.GoogleAdsLink>
        getUpdateGoogleAdsLinkMethod;
    if ((getUpdateGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getUpdateGoogleAdsLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getUpdateGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getUpdateGoogleAdsLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getUpdateGoogleAdsLinkMethod =
              getUpdateGoogleAdsLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest,
                          com.google.analytics.admin.v1alpha.GoogleAdsLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateGoogleAdsLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GoogleAdsLink
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("UpdateGoogleAdsLink"))
                      .build();
        }
      }
    }
    return getUpdateGoogleAdsLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest, com.google.protobuf.Empty>
      getDeleteGoogleAdsLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGoogleAdsLink",
      requestType = com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest, com.google.protobuf.Empty>
      getDeleteGoogleAdsLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest,
            com.google.protobuf.Empty>
        getDeleteGoogleAdsLinkMethod;
    if ((getDeleteGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getDeleteGoogleAdsLinkMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getDeleteGoogleAdsLinkMethod = AnalyticsAdminServiceGrpc.getDeleteGoogleAdsLinkMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getDeleteGoogleAdsLinkMethod =
              getDeleteGoogleAdsLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteGoogleAdsLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("DeleteGoogleAdsLink"))
                      .build();
        }
      }
    }
    return getDeleteGoogleAdsLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest,
          com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
      getListGoogleAdsLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGoogleAdsLinks",
      requestType = com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest.class,
      responseType = com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest,
          com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
      getListGoogleAdsLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest,
            com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
        getListGoogleAdsLinksMethod;
    if ((getListGoogleAdsLinksMethod = AnalyticsAdminServiceGrpc.getListGoogleAdsLinksMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getListGoogleAdsLinksMethod = AnalyticsAdminServiceGrpc.getListGoogleAdsLinksMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getListGoogleAdsLinksMethod =
              getListGoogleAdsLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest,
                          com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGoogleAdsLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier("ListGoogleAdsLinks"))
                      .build();
        }
      }
    }
    return getListGoogleAdsLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest,
          com.google.analytics.admin.v1alpha.DataSharingSettings>
      getGetDataSharingSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataSharingSettings",
      requestType = com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest.class,
      responseType = com.google.analytics.admin.v1alpha.DataSharingSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest,
          com.google.analytics.admin.v1alpha.DataSharingSettings>
      getGetDataSharingSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest,
            com.google.analytics.admin.v1alpha.DataSharingSettings>
        getGetDataSharingSettingsMethod;
    if ((getGetDataSharingSettingsMethod =
            AnalyticsAdminServiceGrpc.getGetDataSharingSettingsMethod)
        == null) {
      synchronized (AnalyticsAdminServiceGrpc.class) {
        if ((getGetDataSharingSettingsMethod =
                AnalyticsAdminServiceGrpc.getGetDataSharingSettingsMethod)
            == null) {
          AnalyticsAdminServiceGrpc.getGetDataSharingSettingsMethod =
              getGetDataSharingSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest,
                          com.google.analytics.admin.v1alpha.DataSharingSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDataSharingSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.admin.v1alpha.DataSharingSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsAdminServiceMethodDescriptorSupplier(
                              "GetDataSharingSettings"))
                      .build();
        }
      }
    }
    return getGetDataSharingSettingsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AnalyticsAdminServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsAdminServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsAdminServiceStub>() {
          @java.lang.Override
          public AnalyticsAdminServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsAdminServiceStub(channel, callOptions);
          }
        };
    return AnalyticsAdminServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnalyticsAdminServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsAdminServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsAdminServiceBlockingStub>() {
          @java.lang.Override
          public AnalyticsAdminServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsAdminServiceBlockingStub(channel, callOptions);
          }
        };
    return AnalyticsAdminServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AnalyticsAdminServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsAdminServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsAdminServiceFutureStub>() {
          @java.lang.Override
          public AnalyticsAdminServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsAdminServiceFutureStub(channel, callOptions);
          }
        };
    return AnalyticsAdminServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service Interface for the Analytics Admin API (GA4).
   * </pre>
   */
  public abstract static class AnalyticsAdminServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lookup for a single Account.
     * </pre>
     */
    public void getAccount(
        com.google.analytics.admin.v1alpha.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Account> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all accounts accessible by the caller.
     * Note that these accounts might not currently have GA4 properties.
     * Soft-deleted (ie: "trashed") accounts are excluded by default.
     * Returns an empty list if no relevant accounts are found.
     * </pre>
     */
    public void listAccounts(
        com.google.analytics.admin.v1alpha.ListAccountsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAccountsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListAccountsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks target Account as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted accounts.
     * However, they can be restored using the Trash Can UI.
     * If the accounts are not restored before the expiration time, the account
     * and all child resources (eg: Properties, GoogleAdsLinks, Streams,
     * UserLinks) will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found.
     * </pre>
     */
    public void deleteAccount(
        com.google.analytics.admin.v1alpha.DeleteAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an account.
     * </pre>
     */
    public void updateAccount(
        com.google.analytics.admin.v1alpha.UpdateAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Account> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateAccountMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Requests a ticket for creating an account.
     * </pre>
     */
    public void provisionAccountTicket(
        com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getProvisionAccountTicketMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns summaries of all accounts accessible by the caller.
     * </pre>
     */
    public void listAccountSummaries(
        com.google.analytics.admin.v1alpha.ListAccountSummariesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListAccountSummariesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single "GA4" Property.
     * </pre>
     */
    public void getProperty(
        com.google.analytics.admin.v1alpha.GetPropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child Properties under the specified parent Account.
     * Only "GA4" properties will be returned.
     * Properties will be excluded if the caller does not have access.
     * Soft-deleted (ie: "trashed") properties are excluded by default.
     * Returns an empty list if no relevant properties are found.
     * </pre>
     */
    public void listProperties(
        com.google.analytics.admin.v1alpha.ListPropertiesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListPropertiesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListPropertiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an "GA4" property with the specified location and attributes.
     * </pre>
     */
    public void createProperty(
        com.google.analytics.admin.v1alpha.CreatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      asyncUnimplementedUnaryCall(getCreatePropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks target Property as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted properties.
     * However, they can be restored using the Trash Can UI.
     * If the properties are not restored before the expiration time, the Property
     * and all child resources (eg: GoogleAdsLinks, Streams, UserLinks)
     * will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found, or is not an GA4 Property.
     * </pre>
     */
    public void deleteProperty(
        com.google.analytics.admin.v1alpha.DeletePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeletePropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a property.
     * </pre>
     */
    public void updateProperty(
        com.google.analytics.admin.v1alpha.UpdatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdatePropertyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a user's link to an account or property.
     * </pre>
     */
    public void getUserLink(
        com.google.analytics.admin.v1alpha.GetUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about multiple users' links to an account or property.
     * </pre>
     */
    public void batchGetUserLinks(
        com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchGetUserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property.
     * </pre>
     */
    public void listUserLinks(
        com.google.analytics.admin.v1alpha.ListUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListUserLinksResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListUserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property, including implicit ones
     * that come from effective permissions granted by groups or organization
     * admin roles.
     * If a returned user link does not have direct permissions, they cannot
     * be removed from the account or property directly with the DeleteUserLink
     * command. They have to be removed from the group/etc that gives them
     * permissions, which is currently only usable/discoverable in the GA or GMP
     * UIs.
     * </pre>
     */
    public void auditUserLinks(
        com.google.analytics.admin.v1alpha.AuditUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getAuditUserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a user link on an account or property.
     * If the user with the specified email already has permissions on the
     * account or property, then the user's existing permissions will be unioned
     * with the permissions specified in the new UserLink.
     * </pre>
     */
    public void createUserLink(
        com.google.analytics.admin.v1alpha.CreateUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateUserLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates information about multiple users' links to an account or property.
     * This method is transactional. If any UserLink cannot be created, none of
     * the UserLinks will be created.
     * </pre>
     */
    public void batchCreateUserLinks(
        com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchCreateUserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a user link on an account or property.
     * </pre>
     */
    public void updateUserLink(
        com.google.analytics.admin.v1alpha.UpdateUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateUserLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates information about multiple users' links to an account or property.
     * </pre>
     */
    public void batchUpdateUserLinks(
        com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchUpdateUserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user link on an account or property.
     * </pre>
     */
    public void deleteUserLink(
        com.google.analytics.admin.v1alpha.DeleteUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteUserLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes information about multiple users' links to an account or property.
     * </pre>
     */
    public void batchDeleteUserLinks(
        com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchDeleteUserLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single WebDataStream
     * </pre>
     */
    public void getWebDataStream(
        com.google.analytics.admin.v1alpha.GetWebDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.WebDataStream>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetWebDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a web stream on a property.
     * </pre>
     */
    public void deleteWebDataStream(
        com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteWebDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a web stream on a property.
     * </pre>
     */
    public void updateWebDataStream(
        com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.WebDataStream>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateWebDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a web stream with the specified location and attributes.
     * </pre>
     */
    public void createWebDataStream(
        com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.WebDataStream>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateWebDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child web data streams under the specified parent property.
     * Web data streams will be excluded if the caller does not have access.
     * Returns an empty list if no relevant web data streams are found.
     * </pre>
     */
    public void listWebDataStreams(
        com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListWebDataStreamsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single IosAppDataStream
     * </pre>
     */
    public void getIosAppDataStream(
        com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.IosAppDataStream>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetIosAppDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an iOS app stream on a property.
     * </pre>
     */
    public void deleteIosAppDataStream(
        com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteIosAppDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an iOS app stream on a property.
     * </pre>
     */
    public void updateIosAppDataStream(
        com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.IosAppDataStream>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateIosAppDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an iOS app data stream with the specified location and attributes.
     * </pre>
     */
    public void createIosAppDataStream(
        com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.IosAppDataStream>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateIosAppDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child iOS app data streams under the specified parent property.
     * iOS app data streams will be excluded if the caller does not have access.
     * Returns an empty list if no relevant iOS app data streams are found.
     * </pre>
     */
    public void listIosAppDataStreams(
        com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListIosAppDataStreamsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single AndroidAppDataStream
     * </pre>
     */
    public void getAndroidAppDataStream(
        com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AndroidAppDataStream>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetAndroidAppDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an android app stream on a property.
     * </pre>
     */
    public void deleteAndroidAppDataStream(
        com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteAndroidAppDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an android app stream on a property.
     * </pre>
     */
    public void updateAndroidAppDataStream(
        com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AndroidAppDataStream>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateAndroidAppDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an android app stream with the specified location and attributes.
     * </pre>
     */
    public void createAndroidAppDataStream(
        com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AndroidAppDataStream>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateAndroidAppDataStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child android app streams under the specified parent property.
     * Android app streams will be excluded if the caller does not have access.
     * Returns an empty list if no relevant android app streams are found.
     * </pre>
     */
    public void listAndroidAppDataStreams(
        com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListAndroidAppDataStreamsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the singleton enhanced measurement settings for this web stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public void getEnhancedMeasurementSettings(
        com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetEnhancedMeasurementSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the singleton enhanced measurement settings for this web stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public void updateEnhancedMeasurementSettings(
        com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateEnhancedMeasurementSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a FirebaseLink.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public void createFirebaseLink(
        com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.FirebaseLink>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateFirebaseLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a FirebaseLink on a property
     * </pre>
     */
    public void updateFirebaseLink(
        com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.FirebaseLink>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateFirebaseLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a FirebaseLink on a property
     * </pre>
     */
    public void deleteFirebaseLink(
        com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteFirebaseLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists FirebaseLinks on a property.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public void listFirebaseLinks(
        com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListFirebaseLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Site Tag for the specified web stream.
     * Site Tags are immutable singletons.
     * </pre>
     */
    public void getGlobalSiteTag(
        com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GlobalSiteTag>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetGlobalSiteTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a GoogleAdsLink.
     * </pre>
     */
    public void createGoogleAdsLink(
        com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleAdsLink>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateGoogleAdsLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a GoogleAdsLink on a property
     * </pre>
     */
    public void updateGoogleAdsLink(
        com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleAdsLink>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGoogleAdsLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GoogleAdsLink on a property
     * </pre>
     */
    public void deleteGoogleAdsLink(
        com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteGoogleAdsLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GoogleAdsLinks on a property.
     * </pre>
     */
    public void listGoogleAdsLinks(
        com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListGoogleAdsLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get data sharing settings on an account.
     * Data sharing settings are singletons.
     * </pre>
     */
    public void getDataSharingSettings(
        com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataSharingSettings>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetDataSharingSettingsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetAccountMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetAccountRequest,
                      com.google.analytics.admin.v1alpha.Account>(this, METHODID_GET_ACCOUNT)))
          .addMethod(
              getListAccountsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListAccountsRequest,
                      com.google.analytics.admin.v1alpha.ListAccountsResponse>(
                      this, METHODID_LIST_ACCOUNTS)))
          .addMethod(
              getDeleteAccountMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteAccountRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ACCOUNT)))
          .addMethod(
              getUpdateAccountMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateAccountRequest,
                      com.google.analytics.admin.v1alpha.Account>(this, METHODID_UPDATE_ACCOUNT)))
          .addMethod(
              getProvisionAccountTicketMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest,
                      com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>(
                      this, METHODID_PROVISION_ACCOUNT_TICKET)))
          .addMethod(
              getListAccountSummariesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListAccountSummariesRequest,
                      com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>(
                      this, METHODID_LIST_ACCOUNT_SUMMARIES)))
          .addMethod(
              getGetPropertyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetPropertyRequest,
                      com.google.analytics.admin.v1alpha.Property>(this, METHODID_GET_PROPERTY)))
          .addMethod(
              getListPropertiesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListPropertiesRequest,
                      com.google.analytics.admin.v1alpha.ListPropertiesResponse>(
                      this, METHODID_LIST_PROPERTIES)))
          .addMethod(
              getCreatePropertyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreatePropertyRequest,
                      com.google.analytics.admin.v1alpha.Property>(this, METHODID_CREATE_PROPERTY)))
          .addMethod(
              getDeletePropertyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeletePropertyRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_PROPERTY)))
          .addMethod(
              getUpdatePropertyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdatePropertyRequest,
                      com.google.analytics.admin.v1alpha.Property>(this, METHODID_UPDATE_PROPERTY)))
          .addMethod(
              getGetUserLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetUserLinkRequest,
                      com.google.analytics.admin.v1alpha.UserLink>(this, METHODID_GET_USER_LINK)))
          .addMethod(
              getBatchGetUserLinksMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest,
                      com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>(
                      this, METHODID_BATCH_GET_USER_LINKS)))
          .addMethod(
              getListUserLinksMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListUserLinksRequest,
                      com.google.analytics.admin.v1alpha.ListUserLinksResponse>(
                      this, METHODID_LIST_USER_LINKS)))
          .addMethod(
              getAuditUserLinksMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.AuditUserLinksRequest,
                      com.google.analytics.admin.v1alpha.AuditUserLinksResponse>(
                      this, METHODID_AUDIT_USER_LINKS)))
          .addMethod(
              getCreateUserLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateUserLinkRequest,
                      com.google.analytics.admin.v1alpha.UserLink>(
                      this, METHODID_CREATE_USER_LINK)))
          .addMethod(
              getBatchCreateUserLinksMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest,
                      com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>(
                      this, METHODID_BATCH_CREATE_USER_LINKS)))
          .addMethod(
              getUpdateUserLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateUserLinkRequest,
                      com.google.analytics.admin.v1alpha.UserLink>(
                      this, METHODID_UPDATE_USER_LINK)))
          .addMethod(
              getBatchUpdateUserLinksMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest,
                      com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>(
                      this, METHODID_BATCH_UPDATE_USER_LINKS)))
          .addMethod(
              getDeleteUserLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteUserLinkRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_USER_LINK)))
          .addMethod(
              getBatchDeleteUserLinksMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest,
                      com.google.protobuf.Empty>(this, METHODID_BATCH_DELETE_USER_LINKS)))
          .addMethod(
              getGetWebDataStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetWebDataStreamRequest,
                      com.google.analytics.admin.v1alpha.WebDataStream>(
                      this, METHODID_GET_WEB_DATA_STREAM)))
          .addMethod(
              getDeleteWebDataStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_WEB_DATA_STREAM)))
          .addMethod(
              getUpdateWebDataStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest,
                      com.google.analytics.admin.v1alpha.WebDataStream>(
                      this, METHODID_UPDATE_WEB_DATA_STREAM)))
          .addMethod(
              getCreateWebDataStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest,
                      com.google.analytics.admin.v1alpha.WebDataStream>(
                      this, METHODID_CREATE_WEB_DATA_STREAM)))
          .addMethod(
              getListWebDataStreamsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest,
                      com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse>(
                      this, METHODID_LIST_WEB_DATA_STREAMS)))
          .addMethod(
              getGetIosAppDataStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest,
                      com.google.analytics.admin.v1alpha.IosAppDataStream>(
                      this, METHODID_GET_IOS_APP_DATA_STREAM)))
          .addMethod(
              getDeleteIosAppDataStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_IOS_APP_DATA_STREAM)))
          .addMethod(
              getUpdateIosAppDataStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest,
                      com.google.analytics.admin.v1alpha.IosAppDataStream>(
                      this, METHODID_UPDATE_IOS_APP_DATA_STREAM)))
          .addMethod(
              getCreateIosAppDataStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest,
                      com.google.analytics.admin.v1alpha.IosAppDataStream>(
                      this, METHODID_CREATE_IOS_APP_DATA_STREAM)))
          .addMethod(
              getListIosAppDataStreamsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest,
                      com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse>(
                      this, METHODID_LIST_IOS_APP_DATA_STREAMS)))
          .addMethod(
              getGetAndroidAppDataStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest,
                      com.google.analytics.admin.v1alpha.AndroidAppDataStream>(
                      this, METHODID_GET_ANDROID_APP_DATA_STREAM)))
          .addMethod(
              getDeleteAndroidAppDataStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ANDROID_APP_DATA_STREAM)))
          .addMethod(
              getUpdateAndroidAppDataStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest,
                      com.google.analytics.admin.v1alpha.AndroidAppDataStream>(
                      this, METHODID_UPDATE_ANDROID_APP_DATA_STREAM)))
          .addMethod(
              getCreateAndroidAppDataStreamMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest,
                      com.google.analytics.admin.v1alpha.AndroidAppDataStream>(
                      this, METHODID_CREATE_ANDROID_APP_DATA_STREAM)))
          .addMethod(
              getListAndroidAppDataStreamsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest,
                      com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse>(
                      this, METHODID_LIST_ANDROID_APP_DATA_STREAMS)))
          .addMethod(
              getGetEnhancedMeasurementSettingsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest,
                      com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>(
                      this, METHODID_GET_ENHANCED_MEASUREMENT_SETTINGS)))
          .addMethod(
              getUpdateEnhancedMeasurementSettingsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest,
                      com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>(
                      this, METHODID_UPDATE_ENHANCED_MEASUREMENT_SETTINGS)))
          .addMethod(
              getCreateFirebaseLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest,
                      com.google.analytics.admin.v1alpha.FirebaseLink>(
                      this, METHODID_CREATE_FIREBASE_LINK)))
          .addMethod(
              getUpdateFirebaseLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest,
                      com.google.analytics.admin.v1alpha.FirebaseLink>(
                      this, METHODID_UPDATE_FIREBASE_LINK)))
          .addMethod(
              getDeleteFirebaseLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_FIREBASE_LINK)))
          .addMethod(
              getListFirebaseLinksMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest,
                      com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>(
                      this, METHODID_LIST_FIREBASE_LINKS)))
          .addMethod(
              getGetGlobalSiteTagMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest,
                      com.google.analytics.admin.v1alpha.GlobalSiteTag>(
                      this, METHODID_GET_GLOBAL_SITE_TAG)))
          .addMethod(
              getCreateGoogleAdsLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest,
                      com.google.analytics.admin.v1alpha.GoogleAdsLink>(
                      this, METHODID_CREATE_GOOGLE_ADS_LINK)))
          .addMethod(
              getUpdateGoogleAdsLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest,
                      com.google.analytics.admin.v1alpha.GoogleAdsLink>(
                      this, METHODID_UPDATE_GOOGLE_ADS_LINK)))
          .addMethod(
              getDeleteGoogleAdsLinkMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_GOOGLE_ADS_LINK)))
          .addMethod(
              getListGoogleAdsLinksMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest,
                      com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>(
                      this, METHODID_LIST_GOOGLE_ADS_LINKS)))
          .addMethod(
              getGetDataSharingSettingsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest,
                      com.google.analytics.admin.v1alpha.DataSharingSettings>(
                      this, METHODID_GET_DATA_SHARING_SETTINGS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service Interface for the Analytics Admin API (GA4).
   * </pre>
   */
  public static final class AnalyticsAdminServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AnalyticsAdminServiceStub> {
    private AnalyticsAdminServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsAdminServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsAdminServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single Account.
     * </pre>
     */
    public void getAccount(
        com.google.analytics.admin.v1alpha.GetAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Account> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns all accounts accessible by the caller.
     * Note that these accounts might not currently have GA4 properties.
     * Soft-deleted (ie: "trashed") accounts are excluded by default.
     * Returns an empty list if no relevant accounts are found.
     * </pre>
     */
    public void listAccounts(
        com.google.analytics.admin.v1alpha.ListAccountsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAccountsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListAccountsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks target Account as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted accounts.
     * However, they can be restored using the Trash Can UI.
     * If the accounts are not restored before the expiration time, the account
     * and all child resources (eg: Properties, GoogleAdsLinks, Streams,
     * UserLinks) will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found.
     * </pre>
     */
    public void deleteAccount(
        com.google.analytics.admin.v1alpha.DeleteAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteAccountMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an account.
     * </pre>
     */
    public void updateAccount(
        com.google.analytics.admin.v1alpha.UpdateAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Account> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateAccountMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Requests a ticket for creating an account.
     * </pre>
     */
    public void provisionAccountTicket(
        com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProvisionAccountTicketMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns summaries of all accounts accessible by the caller.
     * </pre>
     */
    public void listAccountSummaries(
        com.google.analytics.admin.v1alpha.ListAccountSummariesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListAccountSummariesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single "GA4" Property.
     * </pre>
     */
    public void getProperty(
        com.google.analytics.admin.v1alpha.GetPropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPropertyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child Properties under the specified parent Account.
     * Only "GA4" properties will be returned.
     * Properties will be excluded if the caller does not have access.
     * Soft-deleted (ie: "trashed") properties are excluded by default.
     * Returns an empty list if no relevant properties are found.
     * </pre>
     */
    public void listProperties(
        com.google.analytics.admin.v1alpha.ListPropertiesRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListPropertiesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListPropertiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an "GA4" property with the specified location and attributes.
     * </pre>
     */
    public void createProperty(
        com.google.analytics.admin.v1alpha.CreatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreatePropertyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks target Property as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted properties.
     * However, they can be restored using the Trash Can UI.
     * If the properties are not restored before the expiration time, the Property
     * and all child resources (eg: GoogleAdsLinks, Streams, UserLinks)
     * will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found, or is not an GA4 Property.
     * </pre>
     */
    public void deleteProperty(
        com.google.analytics.admin.v1alpha.DeletePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeletePropertyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a property.
     * </pre>
     */
    public void updateProperty(
        com.google.analytics.admin.v1alpha.UpdatePropertyRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdatePropertyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a user's link to an account or property.
     * </pre>
     */
    public void getUserLink(
        com.google.analytics.admin.v1alpha.GetUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about multiple users' links to an account or property.
     * </pre>
     */
    public void batchGetUserLinks(
        com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchGetUserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property.
     * </pre>
     */
    public void listUserLinks(
        com.google.analytics.admin.v1alpha.ListUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListUserLinksResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListUserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property, including implicit ones
     * that come from effective permissions granted by groups or organization
     * admin roles.
     * If a returned user link does not have direct permissions, they cannot
     * be removed from the account or property directly with the DeleteUserLink
     * command. They have to be removed from the group/etc that gives them
     * permissions, which is currently only usable/discoverable in the GA or GMP
     * UIs.
     * </pre>
     */
    public void auditUserLinks(
        com.google.analytics.admin.v1alpha.AuditUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAuditUserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a user link on an account or property.
     * If the user with the specified email already has permissions on the
     * account or property, then the user's existing permissions will be unioned
     * with the permissions specified in the new UserLink.
     * </pre>
     */
    public void createUserLink(
        com.google.analytics.admin.v1alpha.CreateUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateUserLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates information about multiple users' links to an account or property.
     * This method is transactional. If any UserLink cannot be created, none of
     * the UserLinks will be created.
     * </pre>
     */
    public void batchCreateUserLinks(
        com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchCreateUserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a user link on an account or property.
     * </pre>
     */
    public void updateUserLink(
        com.google.analytics.admin.v1alpha.UpdateUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateUserLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates information about multiple users' links to an account or property.
     * </pre>
     */
    public void batchUpdateUserLinks(
        com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchUpdateUserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user link on an account or property.
     * </pre>
     */
    public void deleteUserLink(
        com.google.analytics.admin.v1alpha.DeleteUserLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteUserLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes information about multiple users' links to an account or property.
     * </pre>
     */
    public void batchDeleteUserLinks(
        com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchDeleteUserLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single WebDataStream
     * </pre>
     */
    public void getWebDataStream(
        com.google.analytics.admin.v1alpha.GetWebDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.WebDataStream>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetWebDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a web stream on a property.
     * </pre>
     */
    public void deleteWebDataStream(
        com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteWebDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a web stream on a property.
     * </pre>
     */
    public void updateWebDataStream(
        com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.WebDataStream>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateWebDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a web stream with the specified location and attributes.
     * </pre>
     */
    public void createWebDataStream(
        com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.WebDataStream>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateWebDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child web data streams under the specified parent property.
     * Web data streams will be excluded if the caller does not have access.
     * Returns an empty list if no relevant web data streams are found.
     * </pre>
     */
    public void listWebDataStreams(
        com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListWebDataStreamsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single IosAppDataStream
     * </pre>
     */
    public void getIosAppDataStream(
        com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.IosAppDataStream>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIosAppDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an iOS app stream on a property.
     * </pre>
     */
    public void deleteIosAppDataStream(
        com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteIosAppDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an iOS app stream on a property.
     * </pre>
     */
    public void updateIosAppDataStream(
        com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.IosAppDataStream>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateIosAppDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an iOS app data stream with the specified location and attributes.
     * </pre>
     */
    public void createIosAppDataStream(
        com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.IosAppDataStream>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateIosAppDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child iOS app data streams under the specified parent property.
     * iOS app data streams will be excluded if the caller does not have access.
     * Returns an empty list if no relevant iOS app data streams are found.
     * </pre>
     */
    public void listIosAppDataStreams(
        com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListIosAppDataStreamsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single AndroidAppDataStream
     * </pre>
     */
    public void getAndroidAppDataStream(
        com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AndroidAppDataStream>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAndroidAppDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an android app stream on a property.
     * </pre>
     */
    public void deleteAndroidAppDataStream(
        com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteAndroidAppDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an android app stream on a property.
     * </pre>
     */
    public void updateAndroidAppDataStream(
        com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AndroidAppDataStream>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateAndroidAppDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an android app stream with the specified location and attributes.
     * </pre>
     */
    public void createAndroidAppDataStream(
        com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AndroidAppDataStream>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateAndroidAppDataStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns child android app streams under the specified parent property.
     * Android app streams will be excluded if the caller does not have access.
     * Returns an empty list if no relevant android app streams are found.
     * </pre>
     */
    public void listAndroidAppDataStreams(
        com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListAndroidAppDataStreamsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the singleton enhanced measurement settings for this web stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public void getEnhancedMeasurementSettings(
        com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEnhancedMeasurementSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the singleton enhanced measurement settings for this web stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public void updateEnhancedMeasurementSettings(
        com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateEnhancedMeasurementSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a FirebaseLink.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public void createFirebaseLink(
        com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.FirebaseLink>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateFirebaseLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a FirebaseLink on a property
     * </pre>
     */
    public void updateFirebaseLink(
        com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.FirebaseLink>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateFirebaseLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a FirebaseLink on a property
     * </pre>
     */
    public void deleteFirebaseLink(
        com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteFirebaseLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists FirebaseLinks on a property.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public void listFirebaseLinks(
        com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListFirebaseLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the Site Tag for the specified web stream.
     * Site Tags are immutable singletons.
     * </pre>
     */
    public void getGlobalSiteTag(
        com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GlobalSiteTag>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGlobalSiteTagMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a GoogleAdsLink.
     * </pre>
     */
    public void createGoogleAdsLink(
        com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleAdsLink>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateGoogleAdsLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a GoogleAdsLink on a property
     * </pre>
     */
    public void updateGoogleAdsLink(
        com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleAdsLink>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGoogleAdsLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GoogleAdsLink on a property
     * </pre>
     */
    public void deleteGoogleAdsLink(
        com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteGoogleAdsLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GoogleAdsLinks on a property.
     * </pre>
     */
    public void listGoogleAdsLinks(
        com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListGoogleAdsLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get data sharing settings on an account.
     * Data sharing settings are singletons.
     * </pre>
     */
    public void getDataSharingSettings(
        com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataSharingSettings>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDataSharingSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service Interface for the Analytics Admin API (GA4).
   * </pre>
   */
  public static final class AnalyticsAdminServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AnalyticsAdminServiceBlockingStub> {
    private AnalyticsAdminServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsAdminServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsAdminServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single Account.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Account getAccount(
        com.google.analytics.admin.v1alpha.GetAccountRequest request) {
      return blockingUnaryCall(getChannel(), getGetAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all accounts accessible by the caller.
     * Note that these accounts might not currently have GA4 properties.
     * Soft-deleted (ie: "trashed") accounts are excluded by default.
     * Returns an empty list if no relevant accounts are found.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListAccountsResponse listAccounts(
        com.google.analytics.admin.v1alpha.ListAccountsRequest request) {
      return blockingUnaryCall(getChannel(), getListAccountsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks target Account as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted accounts.
     * However, they can be restored using the Trash Can UI.
     * If the accounts are not restored before the expiration time, the account
     * and all child resources (eg: Properties, GoogleAdsLinks, Streams,
     * UserLinks) will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAccount(
        com.google.analytics.admin.v1alpha.DeleteAccountRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an account.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Account updateAccount(
        com.google.analytics.admin.v1alpha.UpdateAccountRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateAccountMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Requests a ticket for creating an account.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse provisionAccountTicket(
        com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest request) {
      return blockingUnaryCall(
          getChannel(), getProvisionAccountTicketMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns summaries of all accounts accessible by the caller.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListAccountSummariesResponse listAccountSummaries(
        com.google.analytics.admin.v1alpha.ListAccountSummariesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListAccountSummariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single "GA4" Property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Property getProperty(
        com.google.analytics.admin.v1alpha.GetPropertyRequest request) {
      return blockingUnaryCall(getChannel(), getGetPropertyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child Properties under the specified parent Account.
     * Only "GA4" properties will be returned.
     * Properties will be excluded if the caller does not have access.
     * Soft-deleted (ie: "trashed") properties are excluded by default.
     * Returns an empty list if no relevant properties are found.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListPropertiesResponse listProperties(
        com.google.analytics.admin.v1alpha.ListPropertiesRequest request) {
      return blockingUnaryCall(getChannel(), getListPropertiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an "GA4" property with the specified location and attributes.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Property createProperty(
        com.google.analytics.admin.v1alpha.CreatePropertyRequest request) {
      return blockingUnaryCall(getChannel(), getCreatePropertyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks target Property as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted properties.
     * However, they can be restored using the Trash Can UI.
     * If the properties are not restored before the expiration time, the Property
     * and all child resources (eg: GoogleAdsLinks, Streams, UserLinks)
     * will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found, or is not an GA4 Property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteProperty(
        com.google.analytics.admin.v1alpha.DeletePropertyRequest request) {
      return blockingUnaryCall(getChannel(), getDeletePropertyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.Property updateProperty(
        com.google.analytics.admin.v1alpha.UpdatePropertyRequest request) {
      return blockingUnaryCall(getChannel(), getUpdatePropertyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a user's link to an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.UserLink getUserLink(
        com.google.analytics.admin.v1alpha.GetUserLinkRequest request) {
      return blockingUnaryCall(getChannel(), getGetUserLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse batchGetUserLinks(
        com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchGetUserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListUserLinksResponse listUserLinks(
        com.google.analytics.admin.v1alpha.ListUserLinksRequest request) {
      return blockingUnaryCall(getChannel(), getListUserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property, including implicit ones
     * that come from effective permissions granted by groups or organization
     * admin roles.
     * If a returned user link does not have direct permissions, they cannot
     * be removed from the account or property directly with the DeleteUserLink
     * command. They have to be removed from the group/etc that gives them
     * permissions, which is currently only usable/discoverable in the GA or GMP
     * UIs.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AuditUserLinksResponse auditUserLinks(
        com.google.analytics.admin.v1alpha.AuditUserLinksRequest request) {
      return blockingUnaryCall(getChannel(), getAuditUserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a user link on an account or property.
     * If the user with the specified email already has permissions on the
     * account or property, then the user's existing permissions will be unioned
     * with the permissions specified in the new UserLink.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.UserLink createUserLink(
        com.google.analytics.admin.v1alpha.CreateUserLinkRequest request) {
      return blockingUnaryCall(getChannel(), getCreateUserLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates information about multiple users' links to an account or property.
     * This method is transactional. If any UserLink cannot be created, none of
     * the UserLinks will be created.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse batchCreateUserLinks(
        com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchCreateUserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user link on an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.UserLink updateUserLink(
        com.google.analytics.admin.v1alpha.UpdateUserLinkRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateUserLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse batchUpdateUserLinks(
        com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchUpdateUserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user link on an account or property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUserLink(
        com.google.analytics.admin.v1alpha.DeleteUserLinkRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteUserLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeleteUserLinks(
        com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchDeleteUserLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single WebDataStream
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.WebDataStream getWebDataStream(
        com.google.analytics.admin.v1alpha.GetWebDataStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetWebDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a web stream on a property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteWebDataStream(
        com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteWebDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a web stream on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.WebDataStream updateWebDataStream(
        com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateWebDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a web stream with the specified location and attributes.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.WebDataStream createWebDataStream(
        com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateWebDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child web data streams under the specified parent property.
     * Web data streams will be excluded if the caller does not have access.
     * Returns an empty list if no relevant web data streams are found.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse listWebDataStreams(
        com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListWebDataStreamsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single IosAppDataStream
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.IosAppDataStream getIosAppDataStream(
        com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetIosAppDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an iOS app stream on a property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIosAppDataStream(
        com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteIosAppDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an iOS app stream on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.IosAppDataStream updateIosAppDataStream(
        com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateIosAppDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an iOS app data stream with the specified location and attributes.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.IosAppDataStream createIosAppDataStream(
        com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateIosAppDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child iOS app data streams under the specified parent property.
     * iOS app data streams will be excluded if the caller does not have access.
     * Returns an empty list if no relevant iOS app data streams are found.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse listIosAppDataStreams(
        com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListIosAppDataStreamsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single AndroidAppDataStream
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AndroidAppDataStream getAndroidAppDataStream(
        com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAndroidAppDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an android app stream on a property.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAndroidAppDataStream(
        com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteAndroidAppDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an android app stream on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AndroidAppDataStream updateAndroidAppDataStream(
        com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateAndroidAppDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an android app stream with the specified location and attributes.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.AndroidAppDataStream createAndroidAppDataStream(
        com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateAndroidAppDataStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child android app streams under the specified parent property.
     * Android app streams will be excluded if the caller does not have access.
     * Returns an empty list if no relevant android app streams are found.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse
        listAndroidAppDataStreams(
            com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListAndroidAppDataStreamsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the singleton enhanced measurement settings for this web stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings
        getEnhancedMeasurementSettings(
            com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetEnhancedMeasurementSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the singleton enhanced measurement settings for this web stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings
        updateEnhancedMeasurementSettings(
            com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateEnhancedMeasurementSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a FirebaseLink.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.FirebaseLink createFirebaseLink(
        com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateFirebaseLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a FirebaseLink on a property
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.FirebaseLink updateFirebaseLink(
        com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateFirebaseLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a FirebaseLink on a property
     * </pre>
     */
    public com.google.protobuf.Empty deleteFirebaseLink(
        com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteFirebaseLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists FirebaseLinks on a property.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse listFirebaseLinks(
        com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest request) {
      return blockingUnaryCall(
          getChannel(), getListFirebaseLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Site Tag for the specified web stream.
     * Site Tags are immutable singletons.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.GlobalSiteTag getGlobalSiteTag(
        com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetGlobalSiteTagMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a GoogleAdsLink.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.GoogleAdsLink createGoogleAdsLink(
        com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateGoogleAdsLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a GoogleAdsLink on a property
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.GoogleAdsLink updateGoogleAdsLink(
        com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGoogleAdsLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GoogleAdsLink on a property
     * </pre>
     */
    public com.google.protobuf.Empty deleteGoogleAdsLink(
        com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteGoogleAdsLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GoogleAdsLinks on a property.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse listGoogleAdsLinks(
        com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest request) {
      return blockingUnaryCall(
          getChannel(), getListGoogleAdsLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get data sharing settings on an account.
     * Data sharing settings are singletons.
     * </pre>
     */
    public com.google.analytics.admin.v1alpha.DataSharingSettings getDataSharingSettings(
        com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDataSharingSettingsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service Interface for the Analytics Admin API (GA4).
   * </pre>
   */
  public static final class AnalyticsAdminServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AnalyticsAdminServiceFutureStub> {
    private AnalyticsAdminServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsAdminServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsAdminServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single Account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Account>
        getAccount(com.google.analytics.admin.v1alpha.GetAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns all accounts accessible by the caller.
     * Note that these accounts might not currently have GA4 properties.
     * Soft-deleted (ie: "trashed") accounts are excluded by default.
     * Returns an empty list if no relevant accounts are found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListAccountsResponse>
        listAccounts(com.google.analytics.admin.v1alpha.ListAccountsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListAccountsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Marks target Account as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted accounts.
     * However, they can be restored using the Trash Can UI.
     * If the accounts are not restored before the expiration time, the account
     * and all child resources (eg: Properties, GoogleAdsLinks, Streams,
     * UserLinks) will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAccount(com.google.analytics.admin.v1alpha.DeleteAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Account>
        updateAccount(com.google.analytics.admin.v1alpha.UpdateAccountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateAccountMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Requests a ticket for creating an account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>
        provisionAccountTicket(
            com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProvisionAccountTicketMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns summaries of all accounts accessible by the caller.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>
        listAccountSummaries(
            com.google.analytics.admin.v1alpha.ListAccountSummariesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListAccountSummariesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single "GA4" Property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Property>
        getProperty(com.google.analytics.admin.v1alpha.GetPropertyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPropertyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child Properties under the specified parent Account.
     * Only "GA4" properties will be returned.
     * Properties will be excluded if the caller does not have access.
     * Soft-deleted (ie: "trashed") properties are excluded by default.
     * Returns an empty list if no relevant properties are found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListPropertiesResponse>
        listProperties(com.google.analytics.admin.v1alpha.ListPropertiesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListPropertiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an "GA4" property with the specified location and attributes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Property>
        createProperty(com.google.analytics.admin.v1alpha.CreatePropertyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreatePropertyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Marks target Property as soft-deleted (ie: "trashed") and returns it.
     * This API does not have a method to restore soft-deleted properties.
     * However, they can be restored using the Trash Can UI.
     * If the properties are not restored before the expiration time, the Property
     * and all child resources (eg: GoogleAdsLinks, Streams, UserLinks)
     * will be permanently purged.
     * https://support.google.com/analytics/answer/6154772
     * Returns an error if the target is not found, or is not an GA4 Property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteProperty(com.google.analytics.admin.v1alpha.DeletePropertyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeletePropertyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.Property>
        updateProperty(com.google.analytics.admin.v1alpha.UpdatePropertyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdatePropertyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a user's link to an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.UserLink>
        getUserLink(com.google.analytics.admin.v1alpha.GetUserLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>
        batchGetUserLinks(com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchGetUserLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListUserLinksResponse>
        listUserLinks(com.google.analytics.admin.v1alpha.ListUserLinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListUserLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all user links on an account or property, including implicit ones
     * that come from effective permissions granted by groups or organization
     * admin roles.
     * If a returned user link does not have direct permissions, they cannot
     * be removed from the account or property directly with the DeleteUserLink
     * command. They have to be removed from the group/etc that gives them
     * permissions, which is currently only usable/discoverable in the GA or GMP
     * UIs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AuditUserLinksResponse>
        auditUserLinks(com.google.analytics.admin.v1alpha.AuditUserLinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAuditUserLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a user link on an account or property.
     * If the user with the specified email already has permissions on the
     * account or property, then the user's existing permissions will be unioned
     * with the permissions specified in the new UserLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.UserLink>
        createUserLink(com.google.analytics.admin.v1alpha.CreateUserLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateUserLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates information about multiple users' links to an account or property.
     * This method is transactional. If any UserLink cannot be created, none of
     * the UserLinks will be created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>
        batchCreateUserLinks(
            com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchCreateUserLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user link on an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.UserLink>
        updateUserLink(com.google.analytics.admin.v1alpha.UpdateUserLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateUserLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>
        batchUpdateUserLinks(
            com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchUpdateUserLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a user link on an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteUserLink(com.google.analytics.admin.v1alpha.DeleteUserLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteUserLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes information about multiple users' links to an account or property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        batchDeleteUserLinks(
            com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchDeleteUserLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single WebDataStream
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.WebDataStream>
        getWebDataStream(com.google.analytics.admin.v1alpha.GetWebDataStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetWebDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a web stream on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteWebDataStream(com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteWebDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a web stream on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.WebDataStream>
        updateWebDataStream(com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateWebDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a web stream with the specified location and attributes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.WebDataStream>
        createWebDataStream(com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateWebDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child web data streams under the specified parent property.
     * Web data streams will be excluded if the caller does not have access.
     * Returns an empty list if no relevant web data streams are found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse>
        listWebDataStreams(com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListWebDataStreamsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single IosAppDataStream
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.IosAppDataStream>
        getIosAppDataStream(com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIosAppDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an iOS app stream on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteIosAppDataStream(
            com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteIosAppDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an iOS app stream on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.IosAppDataStream>
        updateIosAppDataStream(
            com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateIosAppDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an iOS app data stream with the specified location and attributes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.IosAppDataStream>
        createIosAppDataStream(
            com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateIosAppDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child iOS app data streams under the specified parent property.
     * iOS app data streams will be excluded if the caller does not have access.
     * Returns an empty list if no relevant iOS app data streams are found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse>
        listIosAppDataStreams(
            com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListIosAppDataStreamsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single AndroidAppDataStream
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AndroidAppDataStream>
        getAndroidAppDataStream(
            com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAndroidAppDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an android app stream on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAndroidAppDataStream(
            com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteAndroidAppDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an android app stream on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AndroidAppDataStream>
        updateAndroidAppDataStream(
            com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateAndroidAppDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an android app stream with the specified location and attributes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.AndroidAppDataStream>
        createAndroidAppDataStream(
            com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateAndroidAppDataStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns child android app streams under the specified parent property.
     * Android app streams will be excluded if the caller does not have access.
     * Returns an empty list if no relevant android app streams are found.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse>
        listAndroidAppDataStreams(
            com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListAndroidAppDataStreamsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the singleton enhanced measurement settings for this web stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
        getEnhancedMeasurementSettings(
            com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEnhancedMeasurementSettingsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates the singleton enhanced measurement settings for this web stream.
     * Note that the stream must enable enhanced measurement for these settings to
     * take effect.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>
        updateEnhancedMeasurementSettings(
            com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateEnhancedMeasurementSettingsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a FirebaseLink.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.FirebaseLink>
        createFirebaseLink(com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateFirebaseLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a FirebaseLink on a property
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.FirebaseLink>
        updateFirebaseLink(com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateFirebaseLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a FirebaseLink on a property
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteFirebaseLink(com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteFirebaseLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists FirebaseLinks on a property.
     * Properties can have at most one FirebaseLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>
        listFirebaseLinks(com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListFirebaseLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the Site Tag for the specified web stream.
     * Site Tags are immutable singletons.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.GlobalSiteTag>
        getGlobalSiteTag(com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGlobalSiteTagMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a GoogleAdsLink.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.GoogleAdsLink>
        createGoogleAdsLink(com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateGoogleAdsLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a GoogleAdsLink on a property
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.GoogleAdsLink>
        updateGoogleAdsLink(com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGoogleAdsLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GoogleAdsLink on a property
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteGoogleAdsLink(com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteGoogleAdsLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GoogleAdsLinks on a property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>
        listGoogleAdsLinks(com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListGoogleAdsLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get data sharing settings on an account.
     * Data sharing settings are singletons.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.admin.v1alpha.DataSharingSettings>
        getDataSharingSettings(
            com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDataSharingSettingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ACCOUNT = 0;
  private static final int METHODID_LIST_ACCOUNTS = 1;
  private static final int METHODID_DELETE_ACCOUNT = 2;
  private static final int METHODID_UPDATE_ACCOUNT = 3;
  private static final int METHODID_PROVISION_ACCOUNT_TICKET = 4;
  private static final int METHODID_LIST_ACCOUNT_SUMMARIES = 5;
  private static final int METHODID_GET_PROPERTY = 6;
  private static final int METHODID_LIST_PROPERTIES = 7;
  private static final int METHODID_CREATE_PROPERTY = 8;
  private static final int METHODID_DELETE_PROPERTY = 9;
  private static final int METHODID_UPDATE_PROPERTY = 10;
  private static final int METHODID_GET_USER_LINK = 11;
  private static final int METHODID_BATCH_GET_USER_LINKS = 12;
  private static final int METHODID_LIST_USER_LINKS = 13;
  private static final int METHODID_AUDIT_USER_LINKS = 14;
  private static final int METHODID_CREATE_USER_LINK = 15;
  private static final int METHODID_BATCH_CREATE_USER_LINKS = 16;
  private static final int METHODID_UPDATE_USER_LINK = 17;
  private static final int METHODID_BATCH_UPDATE_USER_LINKS = 18;
  private static final int METHODID_DELETE_USER_LINK = 19;
  private static final int METHODID_BATCH_DELETE_USER_LINKS = 20;
  private static final int METHODID_GET_WEB_DATA_STREAM = 21;
  private static final int METHODID_DELETE_WEB_DATA_STREAM = 22;
  private static final int METHODID_UPDATE_WEB_DATA_STREAM = 23;
  private static final int METHODID_CREATE_WEB_DATA_STREAM = 24;
  private static final int METHODID_LIST_WEB_DATA_STREAMS = 25;
  private static final int METHODID_GET_IOS_APP_DATA_STREAM = 26;
  private static final int METHODID_DELETE_IOS_APP_DATA_STREAM = 27;
  private static final int METHODID_UPDATE_IOS_APP_DATA_STREAM = 28;
  private static final int METHODID_CREATE_IOS_APP_DATA_STREAM = 29;
  private static final int METHODID_LIST_IOS_APP_DATA_STREAMS = 30;
  private static final int METHODID_GET_ANDROID_APP_DATA_STREAM = 31;
  private static final int METHODID_DELETE_ANDROID_APP_DATA_STREAM = 32;
  private static final int METHODID_UPDATE_ANDROID_APP_DATA_STREAM = 33;
  private static final int METHODID_CREATE_ANDROID_APP_DATA_STREAM = 34;
  private static final int METHODID_LIST_ANDROID_APP_DATA_STREAMS = 35;
  private static final int METHODID_GET_ENHANCED_MEASUREMENT_SETTINGS = 36;
  private static final int METHODID_UPDATE_ENHANCED_MEASUREMENT_SETTINGS = 37;
  private static final int METHODID_CREATE_FIREBASE_LINK = 38;
  private static final int METHODID_UPDATE_FIREBASE_LINK = 39;
  private static final int METHODID_DELETE_FIREBASE_LINK = 40;
  private static final int METHODID_LIST_FIREBASE_LINKS = 41;
  private static final int METHODID_GET_GLOBAL_SITE_TAG = 42;
  private static final int METHODID_CREATE_GOOGLE_ADS_LINK = 43;
  private static final int METHODID_UPDATE_GOOGLE_ADS_LINK = 44;
  private static final int METHODID_DELETE_GOOGLE_ADS_LINK = 45;
  private static final int METHODID_LIST_GOOGLE_ADS_LINKS = 46;
  private static final int METHODID_GET_DATA_SHARING_SETTINGS = 47;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AnalyticsAdminServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AnalyticsAdminServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ACCOUNT:
          serviceImpl.getAccount(
              (com.google.analytics.admin.v1alpha.GetAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Account>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCOUNTS:
          serviceImpl.listAccounts(
              (com.google.analytics.admin.v1alpha.ListAccountsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.ListAccountsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ACCOUNT:
          serviceImpl.deleteAccount(
              (com.google.analytics.admin.v1alpha.DeleteAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_ACCOUNT:
          serviceImpl.updateAccount(
              (com.google.analytics.admin.v1alpha.UpdateAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Account>)
                  responseObserver);
          break;
        case METHODID_PROVISION_ACCOUNT_TICKET:
          serviceImpl.provisionAccountTicket(
              (com.google.analytics.admin.v1alpha.ProvisionAccountTicketRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ProvisionAccountTicketResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ACCOUNT_SUMMARIES:
          serviceImpl.listAccountSummaries(
              (com.google.analytics.admin.v1alpha.ListAccountSummariesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListAccountSummariesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PROPERTY:
          serviceImpl.getProperty(
              (com.google.analytics.admin.v1alpha.GetPropertyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property>)
                  responseObserver);
          break;
        case METHODID_LIST_PROPERTIES:
          serviceImpl.listProperties(
              (com.google.analytics.admin.v1alpha.ListPropertiesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListPropertiesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_PROPERTY:
          serviceImpl.createProperty(
              (com.google.analytics.admin.v1alpha.CreatePropertyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property>)
                  responseObserver);
          break;
        case METHODID_DELETE_PROPERTY:
          serviceImpl.deleteProperty(
              (com.google.analytics.admin.v1alpha.DeletePropertyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_PROPERTY:
          serviceImpl.updateProperty(
              (com.google.analytics.admin.v1alpha.UpdatePropertyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.Property>)
                  responseObserver);
          break;
        case METHODID_GET_USER_LINK:
          serviceImpl.getUserLink(
              (com.google.analytics.admin.v1alpha.GetUserLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink>)
                  responseObserver);
          break;
        case METHODID_BATCH_GET_USER_LINKS:
          serviceImpl.batchGetUserLinks(
              (com.google.analytics.admin.v1alpha.BatchGetUserLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.BatchGetUserLinksResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_USER_LINKS:
          serviceImpl.listUserLinks(
              (com.google.analytics.admin.v1alpha.ListUserLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListUserLinksResponse>)
                  responseObserver);
          break;
        case METHODID_AUDIT_USER_LINKS:
          serviceImpl.auditUserLinks(
              (com.google.analytics.admin.v1alpha.AuditUserLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.AuditUserLinksResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_USER_LINK:
          serviceImpl.createUserLink(
              (com.google.analytics.admin.v1alpha.CreateUserLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink>)
                  responseObserver);
          break;
        case METHODID_BATCH_CREATE_USER_LINKS:
          serviceImpl.batchCreateUserLinks(
              (com.google.analytics.admin.v1alpha.BatchCreateUserLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.BatchCreateUserLinksResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_USER_LINK:
          serviceImpl.updateUserLink(
              (com.google.analytics.admin.v1alpha.UpdateUserLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.UserLink>)
                  responseObserver);
          break;
        case METHODID_BATCH_UPDATE_USER_LINKS:
          serviceImpl.batchUpdateUserLinks(
              (com.google.analytics.admin.v1alpha.BatchUpdateUserLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.BatchUpdateUserLinksResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_USER_LINK:
          serviceImpl.deleteUserLink(
              (com.google.analytics.admin.v1alpha.DeleteUserLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_USER_LINKS:
          serviceImpl.batchDeleteUserLinks(
              (com.google.analytics.admin.v1alpha.BatchDeleteUserLinksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_WEB_DATA_STREAM:
          serviceImpl.getWebDataStream(
              (com.google.analytics.admin.v1alpha.GetWebDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.WebDataStream>)
                  responseObserver);
          break;
        case METHODID_DELETE_WEB_DATA_STREAM:
          serviceImpl.deleteWebDataStream(
              (com.google.analytics.admin.v1alpha.DeleteWebDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_WEB_DATA_STREAM:
          serviceImpl.updateWebDataStream(
              (com.google.analytics.admin.v1alpha.UpdateWebDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.WebDataStream>)
                  responseObserver);
          break;
        case METHODID_CREATE_WEB_DATA_STREAM:
          serviceImpl.createWebDataStream(
              (com.google.analytics.admin.v1alpha.CreateWebDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.WebDataStream>)
                  responseObserver);
          break;
        case METHODID_LIST_WEB_DATA_STREAMS:
          serviceImpl.listWebDataStreams(
              (com.google.analytics.admin.v1alpha.ListWebDataStreamsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListWebDataStreamsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_IOS_APP_DATA_STREAM:
          serviceImpl.getIosAppDataStream(
              (com.google.analytics.admin.v1alpha.GetIosAppDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.IosAppDataStream>)
                  responseObserver);
          break;
        case METHODID_DELETE_IOS_APP_DATA_STREAM:
          serviceImpl.deleteIosAppDataStream(
              (com.google.analytics.admin.v1alpha.DeleteIosAppDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_IOS_APP_DATA_STREAM:
          serviceImpl.updateIosAppDataStream(
              (com.google.analytics.admin.v1alpha.UpdateIosAppDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.IosAppDataStream>)
                  responseObserver);
          break;
        case METHODID_CREATE_IOS_APP_DATA_STREAM:
          serviceImpl.createIosAppDataStream(
              (com.google.analytics.admin.v1alpha.CreateIosAppDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.IosAppDataStream>)
                  responseObserver);
          break;
        case METHODID_LIST_IOS_APP_DATA_STREAMS:
          serviceImpl.listIosAppDataStreams(
              (com.google.analytics.admin.v1alpha.ListIosAppDataStreamsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListIosAppDataStreamsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ANDROID_APP_DATA_STREAM:
          serviceImpl.getAndroidAppDataStream(
              (com.google.analytics.admin.v1alpha.GetAndroidAppDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AndroidAppDataStream>)
                  responseObserver);
          break;
        case METHODID_DELETE_ANDROID_APP_DATA_STREAM:
          serviceImpl.deleteAndroidAppDataStream(
              (com.google.analytics.admin.v1alpha.DeleteAndroidAppDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_ANDROID_APP_DATA_STREAM:
          serviceImpl.updateAndroidAppDataStream(
              (com.google.analytics.admin.v1alpha.UpdateAndroidAppDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AndroidAppDataStream>)
                  responseObserver);
          break;
        case METHODID_CREATE_ANDROID_APP_DATA_STREAM:
          serviceImpl.createAndroidAppDataStream(
              (com.google.analytics.admin.v1alpha.CreateAndroidAppDataStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.AndroidAppDataStream>)
                  responseObserver);
          break;
        case METHODID_LIST_ANDROID_APP_DATA_STREAMS:
          serviceImpl.listAndroidAppDataStreams(
              (com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListAndroidAppDataStreamsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENHANCED_MEASUREMENT_SETTINGS:
          serviceImpl.getEnhancedMeasurementSettings(
              (com.google.analytics.admin.v1alpha.GetEnhancedMeasurementSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ENHANCED_MEASUREMENT_SETTINGS:
          serviceImpl.updateEnhancedMeasurementSettings(
              (com.google.analytics.admin.v1alpha.UpdateEnhancedMeasurementSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.EnhancedMeasurementSettings>)
                  responseObserver);
          break;
        case METHODID_CREATE_FIREBASE_LINK:
          serviceImpl.createFirebaseLink(
              (com.google.analytics.admin.v1alpha.CreateFirebaseLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.FirebaseLink>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FIREBASE_LINK:
          serviceImpl.updateFirebaseLink(
              (com.google.analytics.admin.v1alpha.UpdateFirebaseLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.FirebaseLink>)
                  responseObserver);
          break;
        case METHODID_DELETE_FIREBASE_LINK:
          serviceImpl.deleteFirebaseLink(
              (com.google.analytics.admin.v1alpha.DeleteFirebaseLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_FIREBASE_LINKS:
          serviceImpl.listFirebaseLinks(
              (com.google.analytics.admin.v1alpha.ListFirebaseLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListFirebaseLinksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GLOBAL_SITE_TAG:
          serviceImpl.getGlobalSiteTag(
              (com.google.analytics.admin.v1alpha.GetGlobalSiteTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GlobalSiteTag>)
                  responseObserver);
          break;
        case METHODID_CREATE_GOOGLE_ADS_LINK:
          serviceImpl.createGoogleAdsLink(
              (com.google.analytics.admin.v1alpha.CreateGoogleAdsLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleAdsLink>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GOOGLE_ADS_LINK:
          serviceImpl.updateGoogleAdsLink(
              (com.google.analytics.admin.v1alpha.UpdateGoogleAdsLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.GoogleAdsLink>)
                  responseObserver);
          break;
        case METHODID_DELETE_GOOGLE_ADS_LINK:
          serviceImpl.deleteGoogleAdsLink(
              (com.google.analytics.admin.v1alpha.DeleteGoogleAdsLinkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_GOOGLE_ADS_LINKS:
          serviceImpl.listGoogleAdsLinks(
              (com.google.analytics.admin.v1alpha.ListGoogleAdsLinksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.admin.v1alpha.ListGoogleAdsLinksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_SHARING_SETTINGS:
          serviceImpl.getDataSharingSettings(
              (com.google.analytics.admin.v1alpha.GetDataSharingSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.admin.v1alpha.DataSharingSettings>)
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

  private abstract static class AnalyticsAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AnalyticsAdminServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.analytics.admin.v1alpha.AnalyticsAdminProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AnalyticsAdminService");
    }
  }

  private static final class AnalyticsAdminServiceFileDescriptorSupplier
      extends AnalyticsAdminServiceBaseDescriptorSupplier {
    AnalyticsAdminServiceFileDescriptorSupplier() {}
  }

  private static final class AnalyticsAdminServiceMethodDescriptorSupplier
      extends AnalyticsAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AnalyticsAdminServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AnalyticsAdminServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AnalyticsAdminServiceFileDescriptorSupplier())
                      .addMethod(getGetAccountMethod())
                      .addMethod(getListAccountsMethod())
                      .addMethod(getDeleteAccountMethod())
                      .addMethod(getUpdateAccountMethod())
                      .addMethod(getProvisionAccountTicketMethod())
                      .addMethod(getListAccountSummariesMethod())
                      .addMethod(getGetPropertyMethod())
                      .addMethod(getListPropertiesMethod())
                      .addMethod(getCreatePropertyMethod())
                      .addMethod(getDeletePropertyMethod())
                      .addMethod(getUpdatePropertyMethod())
                      .addMethod(getGetUserLinkMethod())
                      .addMethod(getBatchGetUserLinksMethod())
                      .addMethod(getListUserLinksMethod())
                      .addMethod(getAuditUserLinksMethod())
                      .addMethod(getCreateUserLinkMethod())
                      .addMethod(getBatchCreateUserLinksMethod())
                      .addMethod(getUpdateUserLinkMethod())
                      .addMethod(getBatchUpdateUserLinksMethod())
                      .addMethod(getDeleteUserLinkMethod())
                      .addMethod(getBatchDeleteUserLinksMethod())
                      .addMethod(getGetWebDataStreamMethod())
                      .addMethod(getDeleteWebDataStreamMethod())
                      .addMethod(getUpdateWebDataStreamMethod())
                      .addMethod(getCreateWebDataStreamMethod())
                      .addMethod(getListWebDataStreamsMethod())
                      .addMethod(getGetIosAppDataStreamMethod())
                      .addMethod(getDeleteIosAppDataStreamMethod())
                      .addMethod(getUpdateIosAppDataStreamMethod())
                      .addMethod(getCreateIosAppDataStreamMethod())
                      .addMethod(getListIosAppDataStreamsMethod())
                      .addMethod(getGetAndroidAppDataStreamMethod())
                      .addMethod(getDeleteAndroidAppDataStreamMethod())
                      .addMethod(getUpdateAndroidAppDataStreamMethod())
                      .addMethod(getCreateAndroidAppDataStreamMethod())
                      .addMethod(getListAndroidAppDataStreamsMethod())
                      .addMethod(getGetEnhancedMeasurementSettingsMethod())
                      .addMethod(getUpdateEnhancedMeasurementSettingsMethod())
                      .addMethod(getCreateFirebaseLinkMethod())
                      .addMethod(getUpdateFirebaseLinkMethod())
                      .addMethod(getDeleteFirebaseLinkMethod())
                      .addMethod(getListFirebaseLinksMethod())
                      .addMethod(getGetGlobalSiteTagMethod())
                      .addMethod(getCreateGoogleAdsLinkMethod())
                      .addMethod(getUpdateGoogleAdsLinkMethod())
                      .addMethod(getDeleteGoogleAdsLinkMethod())
                      .addMethod(getListGoogleAdsLinksMethod())
                      .addMethod(getGetDataSharingSettingsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
