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
package google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * RuleService provides interface for user-created rules.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/chronicle/v1/rule.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RuleServiceGrpc {

  private RuleServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.chronicle.v1.RuleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.CreateRuleRequest, google.cloud.chronicle.v1.Rule>
      getCreateRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRule",
      requestType = google.cloud.chronicle.v1.CreateRuleRequest.class,
      responseType = google.cloud.chronicle.v1.Rule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.CreateRuleRequest, google.cloud.chronicle.v1.Rule>
      getCreateRuleMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.CreateRuleRequest, google.cloud.chronicle.v1.Rule>
        getCreateRuleMethod;
    if ((getCreateRuleMethod = RuleServiceGrpc.getCreateRuleMethod) == null) {
      synchronized (RuleServiceGrpc.class) {
        if ((getCreateRuleMethod = RuleServiceGrpc.getCreateRuleMethod) == null) {
          RuleServiceGrpc.getCreateRuleMethod =
              getCreateRuleMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.CreateRuleRequest, google.cloud.chronicle.v1.Rule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.CreateRuleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.Rule.getDefaultInstance()))
                      .setSchemaDescriptor(new RuleServiceMethodDescriptorSupplier("CreateRule"))
                      .build();
        }
      }
    }
    return getCreateRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetRuleRequest, google.cloud.chronicle.v1.Rule>
      getGetRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRule",
      requestType = google.cloud.chronicle.v1.GetRuleRequest.class,
      responseType = google.cloud.chronicle.v1.Rule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetRuleRequest, google.cloud.chronicle.v1.Rule>
      getGetRuleMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.GetRuleRequest, google.cloud.chronicle.v1.Rule>
        getGetRuleMethod;
    if ((getGetRuleMethod = RuleServiceGrpc.getGetRuleMethod) == null) {
      synchronized (RuleServiceGrpc.class) {
        if ((getGetRuleMethod = RuleServiceGrpc.getGetRuleMethod) == null) {
          RuleServiceGrpc.getGetRuleMethod =
              getGetRuleMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.GetRuleRequest, google.cloud.chronicle.v1.Rule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.GetRuleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.Rule.getDefaultInstance()))
                      .setSchemaDescriptor(new RuleServiceMethodDescriptorSupplier("GetRule"))
                      .build();
        }
      }
    }
    return getGetRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListRulesRequest, google.cloud.chronicle.v1.ListRulesResponse>
      getListRulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRules",
      requestType = google.cloud.chronicle.v1.ListRulesRequest.class,
      responseType = google.cloud.chronicle.v1.ListRulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListRulesRequest, google.cloud.chronicle.v1.ListRulesResponse>
      getListRulesMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.ListRulesRequest, google.cloud.chronicle.v1.ListRulesResponse>
        getListRulesMethod;
    if ((getListRulesMethod = RuleServiceGrpc.getListRulesMethod) == null) {
      synchronized (RuleServiceGrpc.class) {
        if ((getListRulesMethod = RuleServiceGrpc.getListRulesMethod) == null) {
          RuleServiceGrpc.getListRulesMethod =
              getListRulesMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.ListRulesRequest,
                          google.cloud.chronicle.v1.ListRulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListRulesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListRulesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new RuleServiceMethodDescriptorSupplier("ListRules"))
                      .build();
        }
      }
    }
    return getListRulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.UpdateRuleRequest, google.cloud.chronicle.v1.Rule>
      getUpdateRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRule",
      requestType = google.cloud.chronicle.v1.UpdateRuleRequest.class,
      responseType = google.cloud.chronicle.v1.Rule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.UpdateRuleRequest, google.cloud.chronicle.v1.Rule>
      getUpdateRuleMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.UpdateRuleRequest, google.cloud.chronicle.v1.Rule>
        getUpdateRuleMethod;
    if ((getUpdateRuleMethod = RuleServiceGrpc.getUpdateRuleMethod) == null) {
      synchronized (RuleServiceGrpc.class) {
        if ((getUpdateRuleMethod = RuleServiceGrpc.getUpdateRuleMethod) == null) {
          RuleServiceGrpc.getUpdateRuleMethod =
              getUpdateRuleMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.UpdateRuleRequest, google.cloud.chronicle.v1.Rule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.UpdateRuleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.Rule.getDefaultInstance()))
                      .setSchemaDescriptor(new RuleServiceMethodDescriptorSupplier("UpdateRule"))
                      .build();
        }
      }
    }
    return getUpdateRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.DeleteRuleRequest, com.google.protobuf.Empty>
      getDeleteRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRule",
      requestType = google.cloud.chronicle.v1.DeleteRuleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.DeleteRuleRequest, com.google.protobuf.Empty>
      getDeleteRuleMethod() {
    io.grpc.MethodDescriptor<google.cloud.chronicle.v1.DeleteRuleRequest, com.google.protobuf.Empty>
        getDeleteRuleMethod;
    if ((getDeleteRuleMethod = RuleServiceGrpc.getDeleteRuleMethod) == null) {
      synchronized (RuleServiceGrpc.class) {
        if ((getDeleteRuleMethod = RuleServiceGrpc.getDeleteRuleMethod) == null) {
          RuleServiceGrpc.getDeleteRuleMethod =
              getDeleteRuleMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.DeleteRuleRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.DeleteRuleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new RuleServiceMethodDescriptorSupplier("DeleteRule"))
                      .build();
        }
      }
    }
    return getDeleteRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListRuleRevisionsRequest,
          google.cloud.chronicle.v1.ListRuleRevisionsResponse>
      getListRuleRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRuleRevisions",
      requestType = google.cloud.chronicle.v1.ListRuleRevisionsRequest.class,
      responseType = google.cloud.chronicle.v1.ListRuleRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListRuleRevisionsRequest,
          google.cloud.chronicle.v1.ListRuleRevisionsResponse>
      getListRuleRevisionsMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.ListRuleRevisionsRequest,
            google.cloud.chronicle.v1.ListRuleRevisionsResponse>
        getListRuleRevisionsMethod;
    if ((getListRuleRevisionsMethod = RuleServiceGrpc.getListRuleRevisionsMethod) == null) {
      synchronized (RuleServiceGrpc.class) {
        if ((getListRuleRevisionsMethod = RuleServiceGrpc.getListRuleRevisionsMethod) == null) {
          RuleServiceGrpc.getListRuleRevisionsMethod =
              getListRuleRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.ListRuleRevisionsRequest,
                          google.cloud.chronicle.v1.ListRuleRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRuleRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListRuleRevisionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListRuleRevisionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuleServiceMethodDescriptorSupplier("ListRuleRevisions"))
                      .build();
        }
      }
    }
    return getListRuleRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.CreateRetrohuntRequest, com.google.longrunning.Operation>
      getCreateRetrohuntMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRetrohunt",
      requestType = google.cloud.chronicle.v1.CreateRetrohuntRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.CreateRetrohuntRequest, com.google.longrunning.Operation>
      getCreateRetrohuntMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.CreateRetrohuntRequest, com.google.longrunning.Operation>
        getCreateRetrohuntMethod;
    if ((getCreateRetrohuntMethod = RuleServiceGrpc.getCreateRetrohuntMethod) == null) {
      synchronized (RuleServiceGrpc.class) {
        if ((getCreateRetrohuntMethod = RuleServiceGrpc.getCreateRetrohuntMethod) == null) {
          RuleServiceGrpc.getCreateRetrohuntMethod =
              getCreateRetrohuntMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.CreateRetrohuntRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRetrohunt"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.CreateRetrohuntRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuleServiceMethodDescriptorSupplier("CreateRetrohunt"))
                      .build();
        }
      }
    }
    return getCreateRetrohuntMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetRetrohuntRequest, google.cloud.chronicle.v1.Retrohunt>
      getGetRetrohuntMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRetrohunt",
      requestType = google.cloud.chronicle.v1.GetRetrohuntRequest.class,
      responseType = google.cloud.chronicle.v1.Retrohunt.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetRetrohuntRequest, google.cloud.chronicle.v1.Retrohunt>
      getGetRetrohuntMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.GetRetrohuntRequest, google.cloud.chronicle.v1.Retrohunt>
        getGetRetrohuntMethod;
    if ((getGetRetrohuntMethod = RuleServiceGrpc.getGetRetrohuntMethod) == null) {
      synchronized (RuleServiceGrpc.class) {
        if ((getGetRetrohuntMethod = RuleServiceGrpc.getGetRetrohuntMethod) == null) {
          RuleServiceGrpc.getGetRetrohuntMethod =
              getGetRetrohuntMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.GetRetrohuntRequest,
                          google.cloud.chronicle.v1.Retrohunt>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRetrohunt"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.GetRetrohuntRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.Retrohunt.getDefaultInstance()))
                      .setSchemaDescriptor(new RuleServiceMethodDescriptorSupplier("GetRetrohunt"))
                      .build();
        }
      }
    }
    return getGetRetrohuntMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListRetrohuntsRequest,
          google.cloud.chronicle.v1.ListRetrohuntsResponse>
      getListRetrohuntsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRetrohunts",
      requestType = google.cloud.chronicle.v1.ListRetrohuntsRequest.class,
      responseType = google.cloud.chronicle.v1.ListRetrohuntsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListRetrohuntsRequest,
          google.cloud.chronicle.v1.ListRetrohuntsResponse>
      getListRetrohuntsMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.ListRetrohuntsRequest,
            google.cloud.chronicle.v1.ListRetrohuntsResponse>
        getListRetrohuntsMethod;
    if ((getListRetrohuntsMethod = RuleServiceGrpc.getListRetrohuntsMethod) == null) {
      synchronized (RuleServiceGrpc.class) {
        if ((getListRetrohuntsMethod = RuleServiceGrpc.getListRetrohuntsMethod) == null) {
          RuleServiceGrpc.getListRetrohuntsMethod =
              getListRetrohuntsMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.ListRetrohuntsRequest,
                          google.cloud.chronicle.v1.ListRetrohuntsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRetrohunts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListRetrohuntsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListRetrohuntsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuleServiceMethodDescriptorSupplier("ListRetrohunts"))
                      .build();
        }
      }
    }
    return getListRetrohuntsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetRuleDeploymentRequest,
          google.cloud.chronicle.v1.RuleDeployment>
      getGetRuleDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRuleDeployment",
      requestType = google.cloud.chronicle.v1.GetRuleDeploymentRequest.class,
      responseType = google.cloud.chronicle.v1.RuleDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.GetRuleDeploymentRequest,
          google.cloud.chronicle.v1.RuleDeployment>
      getGetRuleDeploymentMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.GetRuleDeploymentRequest,
            google.cloud.chronicle.v1.RuleDeployment>
        getGetRuleDeploymentMethod;
    if ((getGetRuleDeploymentMethod = RuleServiceGrpc.getGetRuleDeploymentMethod) == null) {
      synchronized (RuleServiceGrpc.class) {
        if ((getGetRuleDeploymentMethod = RuleServiceGrpc.getGetRuleDeploymentMethod) == null) {
          RuleServiceGrpc.getGetRuleDeploymentMethod =
              getGetRuleDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.GetRuleDeploymentRequest,
                          google.cloud.chronicle.v1.RuleDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRuleDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.GetRuleDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.RuleDeployment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuleServiceMethodDescriptorSupplier("GetRuleDeployment"))
                      .build();
        }
      }
    }
    return getGetRuleDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListRuleDeploymentsRequest,
          google.cloud.chronicle.v1.ListRuleDeploymentsResponse>
      getListRuleDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRuleDeployments",
      requestType = google.cloud.chronicle.v1.ListRuleDeploymentsRequest.class,
      responseType = google.cloud.chronicle.v1.ListRuleDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.ListRuleDeploymentsRequest,
          google.cloud.chronicle.v1.ListRuleDeploymentsResponse>
      getListRuleDeploymentsMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.ListRuleDeploymentsRequest,
            google.cloud.chronicle.v1.ListRuleDeploymentsResponse>
        getListRuleDeploymentsMethod;
    if ((getListRuleDeploymentsMethod = RuleServiceGrpc.getListRuleDeploymentsMethod) == null) {
      synchronized (RuleServiceGrpc.class) {
        if ((getListRuleDeploymentsMethod = RuleServiceGrpc.getListRuleDeploymentsMethod) == null) {
          RuleServiceGrpc.getListRuleDeploymentsMethod =
              getListRuleDeploymentsMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.ListRuleDeploymentsRequest,
                          google.cloud.chronicle.v1.ListRuleDeploymentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListRuleDeployments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListRuleDeploymentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.ListRuleDeploymentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuleServiceMethodDescriptorSupplier("ListRuleDeployments"))
                      .build();
        }
      }
    }
    return getListRuleDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.UpdateRuleDeploymentRequest,
          google.cloud.chronicle.v1.RuleDeployment>
      getUpdateRuleDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRuleDeployment",
      requestType = google.cloud.chronicle.v1.UpdateRuleDeploymentRequest.class,
      responseType = google.cloud.chronicle.v1.RuleDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          google.cloud.chronicle.v1.UpdateRuleDeploymentRequest,
          google.cloud.chronicle.v1.RuleDeployment>
      getUpdateRuleDeploymentMethod() {
    io.grpc.MethodDescriptor<
            google.cloud.chronicle.v1.UpdateRuleDeploymentRequest,
            google.cloud.chronicle.v1.RuleDeployment>
        getUpdateRuleDeploymentMethod;
    if ((getUpdateRuleDeploymentMethod = RuleServiceGrpc.getUpdateRuleDeploymentMethod) == null) {
      synchronized (RuleServiceGrpc.class) {
        if ((getUpdateRuleDeploymentMethod = RuleServiceGrpc.getUpdateRuleDeploymentMethod)
            == null) {
          RuleServiceGrpc.getUpdateRuleDeploymentMethod =
              getUpdateRuleDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<google.cloud.chronicle.v1.UpdateRuleDeploymentRequest,
                          google.cloud.chronicle.v1.RuleDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateRuleDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.UpdateRuleDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              google.cloud.chronicle.v1.RuleDeployment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuleServiceMethodDescriptorSupplier("UpdateRuleDeployment"))
                      .build();
        }
      }
    }
    return getUpdateRuleDeploymentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RuleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuleServiceStub>() {
          @java.lang.Override
          public RuleServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuleServiceStub(channel, callOptions);
          }
        };
    return RuleServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static RuleServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuleServiceBlockingV2Stub>() {
          @java.lang.Override
          public RuleServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuleServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return RuleServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RuleServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuleServiceBlockingStub>() {
          @java.lang.Override
          public RuleServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuleServiceBlockingStub(channel, callOptions);
          }
        };
    return RuleServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RuleServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuleServiceFutureStub>() {
          @java.lang.Override
          public RuleServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuleServiceFutureStub(channel, callOptions);
          }
        };
    return RuleServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * RuleService provides interface for user-created rules.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new Rule.
     * </pre>
     */
    default void createRule(
        google.cloud.chronicle.v1.CreateRuleRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Rule> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Rule.
     * </pre>
     */
    default void getRule(
        google.cloud.chronicle.v1.GetRuleRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Rule> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Rules.
     * </pre>
     */
    default void listRules(
        google.cloud.chronicle.v1.ListRulesRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListRulesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Rule.
     * </pre>
     */
    default void updateRule(
        google.cloud.chronicle.v1.UpdateRuleRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Rule> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Rule.
     * </pre>
     */
    default void deleteRule(
        google.cloud.chronicle.v1.DeleteRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of the rule.
     * </pre>
     */
    default void listRuleRevisions(
        google.cloud.chronicle.v1.ListRuleRevisionsRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListRuleRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRuleRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a Retrohunt.
     * </pre>
     */
    default void createRetrohunt(
        google.cloud.chronicle.v1.CreateRetrohuntRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRetrohuntMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a Retrohunt.
     * </pre>
     */
    default void getRetrohunt(
        google.cloud.chronicle.v1.GetRetrohuntRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Retrohunt> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRetrohuntMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Retrohunts.
     * </pre>
     */
    default void listRetrohunts(
        google.cloud.chronicle.v1.ListRetrohuntsRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListRetrohuntsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRetrohuntsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a RuleDeployment.
     * </pre>
     */
    default void getRuleDeployment(
        google.cloud.chronicle.v1.GetRuleDeploymentRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.RuleDeployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRuleDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RuleDeployments across all Rules.
     * </pre>
     */
    default void listRuleDeployments(
        google.cloud.chronicle.v1.ListRuleDeploymentsRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListRuleDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRuleDeploymentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a RuleDeployment.
     * Failures are not necessarily atomic. If there is a request to update
     * multiple fields, and any update to a single field fails, an error will be
     * returned, but other fields may remain successfully updated.
     * </pre>
     */
    default void updateRuleDeployment(
        google.cloud.chronicle.v1.UpdateRuleDeploymentRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.RuleDeployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRuleDeploymentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RuleService.
   *
   * <pre>
   * RuleService provides interface for user-created rules.
   * </pre>
   */
  public abstract static class RuleServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return RuleServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RuleService.
   *
   * <pre>
   * RuleService provides interface for user-created rules.
   * </pre>
   */
  public static final class RuleServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RuleServiceStub> {
    private RuleServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Rule.
     * </pre>
     */
    public void createRule(
        google.cloud.chronicle.v1.CreateRuleRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Rule> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRuleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Rule.
     * </pre>
     */
    public void getRule(
        google.cloud.chronicle.v1.GetRuleRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Rule> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRuleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Rules.
     * </pre>
     */
    public void listRules(
        google.cloud.chronicle.v1.ListRulesRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListRulesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRulesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Rule.
     * </pre>
     */
    public void updateRule(
        google.cloud.chronicle.v1.UpdateRuleRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Rule> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRuleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Rule.
     * </pre>
     */
    public void deleteRule(
        google.cloud.chronicle.v1.DeleteRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRuleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of the rule.
     * </pre>
     */
    public void listRuleRevisions(
        google.cloud.chronicle.v1.ListRuleRevisionsRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListRuleRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRuleRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a Retrohunt.
     * </pre>
     */
    public void createRetrohunt(
        google.cloud.chronicle.v1.CreateRetrohuntRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRetrohuntMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a Retrohunt.
     * </pre>
     */
    public void getRetrohunt(
        google.cloud.chronicle.v1.GetRetrohuntRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Retrohunt> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRetrohuntMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Retrohunts.
     * </pre>
     */
    public void listRetrohunts(
        google.cloud.chronicle.v1.ListRetrohuntsRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListRetrohuntsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRetrohuntsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a RuleDeployment.
     * </pre>
     */
    public void getRuleDeployment(
        google.cloud.chronicle.v1.GetRuleDeploymentRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.RuleDeployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRuleDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists RuleDeployments across all Rules.
     * </pre>
     */
    public void listRuleDeployments(
        google.cloud.chronicle.v1.ListRuleDeploymentsRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListRuleDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRuleDeploymentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a RuleDeployment.
     * Failures are not necessarily atomic. If there is a request to update
     * multiple fields, and any update to a single field fails, an error will be
     * returned, but other fields may remain successfully updated.
     * </pre>
     */
    public void updateRuleDeployment(
        google.cloud.chronicle.v1.UpdateRuleDeploymentRequest request,
        io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.RuleDeployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRuleDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RuleService.
   *
   * <pre>
   * RuleService provides interface for user-created rules.
   * </pre>
   */
  public static final class RuleServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<RuleServiceBlockingV2Stub> {
    private RuleServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Rule.
     * </pre>
     */
    public google.cloud.chronicle.v1.Rule createRule(
        google.cloud.chronicle.v1.CreateRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Rule.
     * </pre>
     */
    public google.cloud.chronicle.v1.Rule getRule(
        google.cloud.chronicle.v1.GetRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Rules.
     * </pre>
     */
    public google.cloud.chronicle.v1.ListRulesResponse listRules(
        google.cloud.chronicle.v1.ListRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Rule.
     * </pre>
     */
    public google.cloud.chronicle.v1.Rule updateRule(
        google.cloud.chronicle.v1.UpdateRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Rule.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRule(
        google.cloud.chronicle.v1.DeleteRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of the rule.
     * </pre>
     */
    public google.cloud.chronicle.v1.ListRuleRevisionsResponse listRuleRevisions(
        google.cloud.chronicle.v1.ListRuleRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRuleRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a Retrohunt.
     * </pre>
     */
    public com.google.longrunning.Operation createRetrohunt(
        google.cloud.chronicle.v1.CreateRetrohuntRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRetrohuntMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a Retrohunt.
     * </pre>
     */
    public google.cloud.chronicle.v1.Retrohunt getRetrohunt(
        google.cloud.chronicle.v1.GetRetrohuntRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRetrohuntMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List Retrohunts.
     * </pre>
     */
    public google.cloud.chronicle.v1.ListRetrohuntsResponse listRetrohunts(
        google.cloud.chronicle.v1.ListRetrohuntsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRetrohuntsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RuleDeployment.
     * </pre>
     */
    public google.cloud.chronicle.v1.RuleDeployment getRuleDeployment(
        google.cloud.chronicle.v1.GetRuleDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRuleDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RuleDeployments across all Rules.
     * </pre>
     */
    public google.cloud.chronicle.v1.ListRuleDeploymentsResponse listRuleDeployments(
        google.cloud.chronicle.v1.ListRuleDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRuleDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a RuleDeployment.
     * Failures are not necessarily atomic. If there is a request to update
     * multiple fields, and any update to a single field fails, an error will be
     * returned, but other fields may remain successfully updated.
     * </pre>
     */
    public google.cloud.chronicle.v1.RuleDeployment updateRuleDeployment(
        google.cloud.chronicle.v1.UpdateRuleDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRuleDeploymentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service RuleService.
   *
   * <pre>
   * RuleService provides interface for user-created rules.
   * </pre>
   */
  public static final class RuleServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RuleServiceBlockingStub> {
    private RuleServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Rule.
     * </pre>
     */
    public google.cloud.chronicle.v1.Rule createRule(
        google.cloud.chronicle.v1.CreateRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Rule.
     * </pre>
     */
    public google.cloud.chronicle.v1.Rule getRule(
        google.cloud.chronicle.v1.GetRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Rules.
     * </pre>
     */
    public google.cloud.chronicle.v1.ListRulesResponse listRules(
        google.cloud.chronicle.v1.ListRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Rule.
     * </pre>
     */
    public google.cloud.chronicle.v1.Rule updateRule(
        google.cloud.chronicle.v1.UpdateRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Rule.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRule(
        google.cloud.chronicle.v1.DeleteRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of the rule.
     * </pre>
     */
    public google.cloud.chronicle.v1.ListRuleRevisionsResponse listRuleRevisions(
        google.cloud.chronicle.v1.ListRuleRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRuleRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a Retrohunt.
     * </pre>
     */
    public com.google.longrunning.Operation createRetrohunt(
        google.cloud.chronicle.v1.CreateRetrohuntRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRetrohuntMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a Retrohunt.
     * </pre>
     */
    public google.cloud.chronicle.v1.Retrohunt getRetrohunt(
        google.cloud.chronicle.v1.GetRetrohuntRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRetrohuntMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List Retrohunts.
     * </pre>
     */
    public google.cloud.chronicle.v1.ListRetrohuntsResponse listRetrohunts(
        google.cloud.chronicle.v1.ListRetrohuntsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRetrohuntsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RuleDeployment.
     * </pre>
     */
    public google.cloud.chronicle.v1.RuleDeployment getRuleDeployment(
        google.cloud.chronicle.v1.GetRuleDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRuleDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RuleDeployments across all Rules.
     * </pre>
     */
    public google.cloud.chronicle.v1.ListRuleDeploymentsResponse listRuleDeployments(
        google.cloud.chronicle.v1.ListRuleDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRuleDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a RuleDeployment.
     * Failures are not necessarily atomic. If there is a request to update
     * multiple fields, and any update to a single field fails, an error will be
     * returned, but other fields may remain successfully updated.
     * </pre>
     */
    public google.cloud.chronicle.v1.RuleDeployment updateRuleDeployment(
        google.cloud.chronicle.v1.UpdateRuleDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRuleDeploymentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RuleService.
   *
   * <pre>
   * RuleService provides interface for user-created rules.
   * </pre>
   */
  public static final class RuleServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RuleServiceFutureStub> {
    private RuleServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<google.cloud.chronicle.v1.Rule>
        createRule(google.cloud.chronicle.v1.CreateRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<google.cloud.chronicle.v1.Rule>
        getRule(google.cloud.chronicle.v1.GetRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Rules.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.ListRulesResponse>
        listRules(google.cloud.chronicle.v1.ListRulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRulesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<google.cloud.chronicle.v1.Rule>
        updateRule(google.cloud.chronicle.v1.UpdateRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteRule(
        google.cloud.chronicle.v1.DeleteRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions of the rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.ListRuleRevisionsResponse>
        listRuleRevisions(google.cloud.chronicle.v1.ListRuleRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRuleRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a Retrohunt.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRetrohunt(google.cloud.chronicle.v1.CreateRetrohuntRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRetrohuntMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a Retrohunt.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<google.cloud.chronicle.v1.Retrohunt>
        getRetrohunt(google.cloud.chronicle.v1.GetRetrohuntRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRetrohuntMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List Retrohunts.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.ListRetrohuntsResponse>
        listRetrohunts(google.cloud.chronicle.v1.ListRetrohuntsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRetrohuntsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a RuleDeployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.RuleDeployment>
        getRuleDeployment(google.cloud.chronicle.v1.GetRuleDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRuleDeploymentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists RuleDeployments across all Rules.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.ListRuleDeploymentsResponse>
        listRuleDeployments(google.cloud.chronicle.v1.ListRuleDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRuleDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a RuleDeployment.
     * Failures are not necessarily atomic. If there is a request to update
     * multiple fields, and any update to a single field fails, an error will be
     * returned, but other fields may remain successfully updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            google.cloud.chronicle.v1.RuleDeployment>
        updateRuleDeployment(google.cloud.chronicle.v1.UpdateRuleDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRuleDeploymentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RULE = 0;
  private static final int METHODID_GET_RULE = 1;
  private static final int METHODID_LIST_RULES = 2;
  private static final int METHODID_UPDATE_RULE = 3;
  private static final int METHODID_DELETE_RULE = 4;
  private static final int METHODID_LIST_RULE_REVISIONS = 5;
  private static final int METHODID_CREATE_RETROHUNT = 6;
  private static final int METHODID_GET_RETROHUNT = 7;
  private static final int METHODID_LIST_RETROHUNTS = 8;
  private static final int METHODID_GET_RULE_DEPLOYMENT = 9;
  private static final int METHODID_LIST_RULE_DEPLOYMENTS = 10;
  private static final int METHODID_UPDATE_RULE_DEPLOYMENT = 11;

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
        case METHODID_CREATE_RULE:
          serviceImpl.createRule(
              (google.cloud.chronicle.v1.CreateRuleRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Rule>) responseObserver);
          break;
        case METHODID_GET_RULE:
          serviceImpl.getRule(
              (google.cloud.chronicle.v1.GetRuleRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Rule>) responseObserver);
          break;
        case METHODID_LIST_RULES:
          serviceImpl.listRules(
              (google.cloud.chronicle.v1.ListRulesRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListRulesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_RULE:
          serviceImpl.updateRule(
              (google.cloud.chronicle.v1.UpdateRuleRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Rule>) responseObserver);
          break;
        case METHODID_DELETE_RULE:
          serviceImpl.deleteRule(
              (google.cloud.chronicle.v1.DeleteRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_RULE_REVISIONS:
          serviceImpl.listRuleRevisions(
              (google.cloud.chronicle.v1.ListRuleRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListRuleRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_RETROHUNT:
          serviceImpl.createRetrohunt(
              (google.cloud.chronicle.v1.CreateRetrohuntRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_RETROHUNT:
          serviceImpl.getRetrohunt(
              (google.cloud.chronicle.v1.GetRetrohuntRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.Retrohunt>) responseObserver);
          break;
        case METHODID_LIST_RETROHUNTS:
          serviceImpl.listRetrohunts(
              (google.cloud.chronicle.v1.ListRetrohuntsRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListRetrohuntsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RULE_DEPLOYMENT:
          serviceImpl.getRuleDeployment(
              (google.cloud.chronicle.v1.GetRuleDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.RuleDeployment>)
                  responseObserver);
          break;
        case METHODID_LIST_RULE_DEPLOYMENTS:
          serviceImpl.listRuleDeployments(
              (google.cloud.chronicle.v1.ListRuleDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.ListRuleDeploymentsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_RULE_DEPLOYMENT:
          serviceImpl.updateRuleDeployment(
              (google.cloud.chronicle.v1.UpdateRuleDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<google.cloud.chronicle.v1.RuleDeployment>)
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
            getCreateRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.CreateRuleRequest, google.cloud.chronicle.v1.Rule>(
                    service, METHODID_CREATE_RULE)))
        .addMethod(
            getGetRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.GetRuleRequest, google.cloud.chronicle.v1.Rule>(
                    service, METHODID_GET_RULE)))
        .addMethod(
            getListRulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.ListRulesRequest,
                    google.cloud.chronicle.v1.ListRulesResponse>(service, METHODID_LIST_RULES)))
        .addMethod(
            getUpdateRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.UpdateRuleRequest, google.cloud.chronicle.v1.Rule>(
                    service, METHODID_UPDATE_RULE)))
        .addMethod(
            getDeleteRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.DeleteRuleRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_RULE)))
        .addMethod(
            getListRuleRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.ListRuleRevisionsRequest,
                    google.cloud.chronicle.v1.ListRuleRevisionsResponse>(
                    service, METHODID_LIST_RULE_REVISIONS)))
        .addMethod(
            getCreateRetrohuntMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.CreateRetrohuntRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_RETROHUNT)))
        .addMethod(
            getGetRetrohuntMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.GetRetrohuntRequest,
                    google.cloud.chronicle.v1.Retrohunt>(service, METHODID_GET_RETROHUNT)))
        .addMethod(
            getListRetrohuntsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.ListRetrohuntsRequest,
                    google.cloud.chronicle.v1.ListRetrohuntsResponse>(
                    service, METHODID_LIST_RETROHUNTS)))
        .addMethod(
            getGetRuleDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.GetRuleDeploymentRequest,
                    google.cloud.chronicle.v1.RuleDeployment>(
                    service, METHODID_GET_RULE_DEPLOYMENT)))
        .addMethod(
            getListRuleDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.ListRuleDeploymentsRequest,
                    google.cloud.chronicle.v1.ListRuleDeploymentsResponse>(
                    service, METHODID_LIST_RULE_DEPLOYMENTS)))
        .addMethod(
            getUpdateRuleDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    google.cloud.chronicle.v1.UpdateRuleDeploymentRequest,
                    google.cloud.chronicle.v1.RuleDeployment>(
                    service, METHODID_UPDATE_RULE_DEPLOYMENT)))
        .build();
  }

  private abstract static class RuleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RuleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return google.cloud.chronicle.v1.RuleProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RuleService");
    }
  }

  private static final class RuleServiceFileDescriptorSupplier
      extends RuleServiceBaseDescriptorSupplier {
    RuleServiceFileDescriptorSupplier() {}
  }

  private static final class RuleServiceMethodDescriptorSupplier
      extends RuleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RuleServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RuleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RuleServiceFileDescriptorSupplier())
                      .addMethod(getCreateRuleMethod())
                      .addMethod(getGetRuleMethod())
                      .addMethod(getListRulesMethod())
                      .addMethod(getUpdateRuleMethod())
                      .addMethod(getDeleteRuleMethod())
                      .addMethod(getListRuleRevisionsMethod())
                      .addMethod(getCreateRetrohuntMethod())
                      .addMethod(getGetRetrohuntMethod())
                      .addMethod(getListRetrohuntsMethod())
                      .addMethod(getGetRuleDeploymentMethod())
                      .addMethod(getListRuleDeploymentsMethod())
                      .addMethod(getUpdateRuleDeploymentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
