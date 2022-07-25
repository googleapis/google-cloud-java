package com.google.cloud.datacatalog.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Policy Tag Manager API service allows you to manage your policy tags and
 * taxonomies.
 * Policy tags are used to tag BigQuery columns and apply additional access
 * control policies. A taxonomy is a hierarchical grouping of policy tags that
 * classify data along a common axis.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/datacatalog/v1/policytagmanager.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PolicyTagManagerGrpc {

  private PolicyTagManagerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.datacatalog.v1.PolicyTagManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.CreateTaxonomyRequest,
      com.google.cloud.datacatalog.v1.Taxonomy> getCreateTaxonomyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTaxonomy",
      requestType = com.google.cloud.datacatalog.v1.CreateTaxonomyRequest.class,
      responseType = com.google.cloud.datacatalog.v1.Taxonomy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.CreateTaxonomyRequest,
      com.google.cloud.datacatalog.v1.Taxonomy> getCreateTaxonomyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.CreateTaxonomyRequest, com.google.cloud.datacatalog.v1.Taxonomy> getCreateTaxonomyMethod;
    if ((getCreateTaxonomyMethod = PolicyTagManagerGrpc.getCreateTaxonomyMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getCreateTaxonomyMethod = PolicyTagManagerGrpc.getCreateTaxonomyMethod) == null) {
          PolicyTagManagerGrpc.getCreateTaxonomyMethod = getCreateTaxonomyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.CreateTaxonomyRequest, com.google.cloud.datacatalog.v1.Taxonomy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTaxonomy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.CreateTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.Taxonomy.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("CreateTaxonomy"))
              .build();
        }
      }
    }
    return getCreateTaxonomyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest,
      com.google.protobuf.Empty> getDeleteTaxonomyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTaxonomy",
      requestType = com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest,
      com.google.protobuf.Empty> getDeleteTaxonomyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest, com.google.protobuf.Empty> getDeleteTaxonomyMethod;
    if ((getDeleteTaxonomyMethod = PolicyTagManagerGrpc.getDeleteTaxonomyMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getDeleteTaxonomyMethod = PolicyTagManagerGrpc.getDeleteTaxonomyMethod) == null) {
          PolicyTagManagerGrpc.getDeleteTaxonomyMethod = getDeleteTaxonomyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTaxonomy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("DeleteTaxonomy"))
              .build();
        }
      }
    }
    return getDeleteTaxonomyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest,
      com.google.cloud.datacatalog.v1.Taxonomy> getUpdateTaxonomyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTaxonomy",
      requestType = com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest.class,
      responseType = com.google.cloud.datacatalog.v1.Taxonomy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest,
      com.google.cloud.datacatalog.v1.Taxonomy> getUpdateTaxonomyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest, com.google.cloud.datacatalog.v1.Taxonomy> getUpdateTaxonomyMethod;
    if ((getUpdateTaxonomyMethod = PolicyTagManagerGrpc.getUpdateTaxonomyMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getUpdateTaxonomyMethod = PolicyTagManagerGrpc.getUpdateTaxonomyMethod) == null) {
          PolicyTagManagerGrpc.getUpdateTaxonomyMethod = getUpdateTaxonomyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest, com.google.cloud.datacatalog.v1.Taxonomy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTaxonomy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.Taxonomy.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("UpdateTaxonomy"))
              .build();
        }
      }
    }
    return getUpdateTaxonomyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ListTaxonomiesRequest,
      com.google.cloud.datacatalog.v1.ListTaxonomiesResponse> getListTaxonomiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTaxonomies",
      requestType = com.google.cloud.datacatalog.v1.ListTaxonomiesRequest.class,
      responseType = com.google.cloud.datacatalog.v1.ListTaxonomiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ListTaxonomiesRequest,
      com.google.cloud.datacatalog.v1.ListTaxonomiesResponse> getListTaxonomiesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ListTaxonomiesRequest, com.google.cloud.datacatalog.v1.ListTaxonomiesResponse> getListTaxonomiesMethod;
    if ((getListTaxonomiesMethod = PolicyTagManagerGrpc.getListTaxonomiesMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getListTaxonomiesMethod = PolicyTagManagerGrpc.getListTaxonomiesMethod) == null) {
          PolicyTagManagerGrpc.getListTaxonomiesMethod = getListTaxonomiesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.ListTaxonomiesRequest, com.google.cloud.datacatalog.v1.ListTaxonomiesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTaxonomies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.ListTaxonomiesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.ListTaxonomiesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("ListTaxonomies"))
              .build();
        }
      }
    }
    return getListTaxonomiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.GetTaxonomyRequest,
      com.google.cloud.datacatalog.v1.Taxonomy> getGetTaxonomyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTaxonomy",
      requestType = com.google.cloud.datacatalog.v1.GetTaxonomyRequest.class,
      responseType = com.google.cloud.datacatalog.v1.Taxonomy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.GetTaxonomyRequest,
      com.google.cloud.datacatalog.v1.Taxonomy> getGetTaxonomyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.GetTaxonomyRequest, com.google.cloud.datacatalog.v1.Taxonomy> getGetTaxonomyMethod;
    if ((getGetTaxonomyMethod = PolicyTagManagerGrpc.getGetTaxonomyMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getGetTaxonomyMethod = PolicyTagManagerGrpc.getGetTaxonomyMethod) == null) {
          PolicyTagManagerGrpc.getGetTaxonomyMethod = getGetTaxonomyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.GetTaxonomyRequest, com.google.cloud.datacatalog.v1.Taxonomy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTaxonomy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.GetTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.Taxonomy.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("GetTaxonomy"))
              .build();
        }
      }
    }
    return getGetTaxonomyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.CreatePolicyTagRequest,
      com.google.cloud.datacatalog.v1.PolicyTag> getCreatePolicyTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePolicyTag",
      requestType = com.google.cloud.datacatalog.v1.CreatePolicyTagRequest.class,
      responseType = com.google.cloud.datacatalog.v1.PolicyTag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.CreatePolicyTagRequest,
      com.google.cloud.datacatalog.v1.PolicyTag> getCreatePolicyTagMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.CreatePolicyTagRequest, com.google.cloud.datacatalog.v1.PolicyTag> getCreatePolicyTagMethod;
    if ((getCreatePolicyTagMethod = PolicyTagManagerGrpc.getCreatePolicyTagMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getCreatePolicyTagMethod = PolicyTagManagerGrpc.getCreatePolicyTagMethod) == null) {
          PolicyTagManagerGrpc.getCreatePolicyTagMethod = getCreatePolicyTagMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.CreatePolicyTagRequest, com.google.cloud.datacatalog.v1.PolicyTag>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePolicyTag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.CreatePolicyTagRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.PolicyTag.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("CreatePolicyTag"))
              .build();
        }
      }
    }
    return getCreatePolicyTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.DeletePolicyTagRequest,
      com.google.protobuf.Empty> getDeletePolicyTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePolicyTag",
      requestType = com.google.cloud.datacatalog.v1.DeletePolicyTagRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.DeletePolicyTagRequest,
      com.google.protobuf.Empty> getDeletePolicyTagMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.DeletePolicyTagRequest, com.google.protobuf.Empty> getDeletePolicyTagMethod;
    if ((getDeletePolicyTagMethod = PolicyTagManagerGrpc.getDeletePolicyTagMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getDeletePolicyTagMethod = PolicyTagManagerGrpc.getDeletePolicyTagMethod) == null) {
          PolicyTagManagerGrpc.getDeletePolicyTagMethod = getDeletePolicyTagMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.DeletePolicyTagRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePolicyTag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.DeletePolicyTagRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("DeletePolicyTag"))
              .build();
        }
      }
    }
    return getDeletePolicyTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest,
      com.google.cloud.datacatalog.v1.PolicyTag> getUpdatePolicyTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePolicyTag",
      requestType = com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest.class,
      responseType = com.google.cloud.datacatalog.v1.PolicyTag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest,
      com.google.cloud.datacatalog.v1.PolicyTag> getUpdatePolicyTagMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest, com.google.cloud.datacatalog.v1.PolicyTag> getUpdatePolicyTagMethod;
    if ((getUpdatePolicyTagMethod = PolicyTagManagerGrpc.getUpdatePolicyTagMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getUpdatePolicyTagMethod = PolicyTagManagerGrpc.getUpdatePolicyTagMethod) == null) {
          PolicyTagManagerGrpc.getUpdatePolicyTagMethod = getUpdatePolicyTagMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest, com.google.cloud.datacatalog.v1.PolicyTag>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePolicyTag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.PolicyTag.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("UpdatePolicyTag"))
              .build();
        }
      }
    }
    return getUpdatePolicyTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ListPolicyTagsRequest,
      com.google.cloud.datacatalog.v1.ListPolicyTagsResponse> getListPolicyTagsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPolicyTags",
      requestType = com.google.cloud.datacatalog.v1.ListPolicyTagsRequest.class,
      responseType = com.google.cloud.datacatalog.v1.ListPolicyTagsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ListPolicyTagsRequest,
      com.google.cloud.datacatalog.v1.ListPolicyTagsResponse> getListPolicyTagsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.ListPolicyTagsRequest, com.google.cloud.datacatalog.v1.ListPolicyTagsResponse> getListPolicyTagsMethod;
    if ((getListPolicyTagsMethod = PolicyTagManagerGrpc.getListPolicyTagsMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getListPolicyTagsMethod = PolicyTagManagerGrpc.getListPolicyTagsMethod) == null) {
          PolicyTagManagerGrpc.getListPolicyTagsMethod = getListPolicyTagsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.ListPolicyTagsRequest, com.google.cloud.datacatalog.v1.ListPolicyTagsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPolicyTags"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.ListPolicyTagsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.ListPolicyTagsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("ListPolicyTags"))
              .build();
        }
      }
    }
    return getListPolicyTagsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.GetPolicyTagRequest,
      com.google.cloud.datacatalog.v1.PolicyTag> getGetPolicyTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPolicyTag",
      requestType = com.google.cloud.datacatalog.v1.GetPolicyTagRequest.class,
      responseType = com.google.cloud.datacatalog.v1.PolicyTag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.GetPolicyTagRequest,
      com.google.cloud.datacatalog.v1.PolicyTag> getGetPolicyTagMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.datacatalog.v1.GetPolicyTagRequest, com.google.cloud.datacatalog.v1.PolicyTag> getGetPolicyTagMethod;
    if ((getGetPolicyTagMethod = PolicyTagManagerGrpc.getGetPolicyTagMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getGetPolicyTagMethod = PolicyTagManagerGrpc.getGetPolicyTagMethod) == null) {
          PolicyTagManagerGrpc.getGetPolicyTagMethod = getGetPolicyTagMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.datacatalog.v1.GetPolicyTagRequest, com.google.cloud.datacatalog.v1.PolicyTag>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPolicyTag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.GetPolicyTagRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.datacatalog.v1.PolicyTag.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("GetPolicyTag"))
              .build();
        }
      }
    }
    return getGetPolicyTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = PolicyTagManagerGrpc.getGetIamPolicyMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getGetIamPolicyMethod = PolicyTagManagerGrpc.getGetIamPolicyMethod) == null) {
          PolicyTagManagerGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("GetIamPolicy"))
              .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = PolicyTagManagerGrpc.getSetIamPolicyMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getSetIamPolicyMethod = PolicyTagManagerGrpc.getSetIamPolicyMethod) == null) {
          PolicyTagManagerGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("SetIamPolicy"))
              .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = PolicyTagManagerGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getTestIamPermissionsMethod = PolicyTagManagerGrpc.getTestIamPermissionsMethod) == null) {
          PolicyTagManagerGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PolicyTagManagerMethodDescriptorSupplier("TestIamPermissions"))
              .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PolicyTagManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyTagManagerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PolicyTagManagerStub>() {
        @java.lang.Override
        public PolicyTagManagerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PolicyTagManagerStub(channel, callOptions);
        }
      };
    return PolicyTagManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PolicyTagManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyTagManagerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PolicyTagManagerBlockingStub>() {
        @java.lang.Override
        public PolicyTagManagerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PolicyTagManagerBlockingStub(channel, callOptions);
        }
      };
    return PolicyTagManagerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PolicyTagManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyTagManagerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PolicyTagManagerFutureStub>() {
        @java.lang.Override
        public PolicyTagManagerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PolicyTagManagerFutureStub(channel, callOptions);
        }
      };
    return PolicyTagManagerFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Policy Tag Manager API service allows you to manage your policy tags and
   * taxonomies.
   * Policy tags are used to tag BigQuery columns and apply additional access
   * control policies. A taxonomy is a hierarchical grouping of policy tags that
   * classify data along a common axis.
   * </pre>
   */
  public static abstract class PolicyTagManagerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a taxonomy in a specified project.
     * The taxonomy is initially empty, that is, it doesn't contain policy tags.
     * </pre>
     */
    public void createTaxonomy(com.google.cloud.datacatalog.v1.CreateTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.Taxonomy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTaxonomyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a taxonomy, including all policy tags in this
     * taxonomy, their associated policies, and the policy tags references from
     * BigQuery columns.
     * </pre>
     */
    public void deleteTaxonomy(com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTaxonomyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a taxonomy, including its display name,
     * description, and activated policy types.
     * </pre>
     */
    public void updateTaxonomy(com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.Taxonomy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTaxonomyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all taxonomies in a project in a particular location that you
     * have a permission to view.
     * </pre>
     */
    public void listTaxonomies(com.google.cloud.datacatalog.v1.ListTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.ListTaxonomiesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTaxonomiesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a taxonomy.
     * </pre>
     */
    public void getTaxonomy(com.google.cloud.datacatalog.v1.GetTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.Taxonomy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTaxonomyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a policy tag in a taxonomy.
     * </pre>
     */
    public void createPolicyTag(com.google.cloud.datacatalog.v1.CreatePolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.PolicyTag> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePolicyTagMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a policy tag together with the following:
     * * All of its descendant policy tags, if any
     * * Policies associated with the policy tag and its descendants
     * * References from BigQuery table schema of the policy tag and its
     *   descendants
     * </pre>
     */
    public void deletePolicyTag(com.google.cloud.datacatalog.v1.DeletePolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePolicyTagMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a policy tag, including its display
     * name, description, and parent policy tag.
     * </pre>
     */
    public void updatePolicyTag(com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.PolicyTag> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePolicyTagMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all policy tags in a taxonomy.
     * </pre>
     */
    public void listPolicyTags(com.google.cloud.datacatalog.v1.ListPolicyTagsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.ListPolicyTagsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPolicyTagsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a policy tag.
     * </pre>
     */
    public void getPolicyTag(com.google.cloud.datacatalog.v1.GetPolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.PolicyTag> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPolicyTagMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the IAM policy for a policy tag or a taxonomy.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sets the IAM policy for a policy tag or a taxonomy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns your permissions on a specified policy tag or
     * taxonomy.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateTaxonomyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.CreateTaxonomyRequest,
                com.google.cloud.datacatalog.v1.Taxonomy>(
                  this, METHODID_CREATE_TAXONOMY)))
          .addMethod(
            getDeleteTaxonomyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_TAXONOMY)))
          .addMethod(
            getUpdateTaxonomyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest,
                com.google.cloud.datacatalog.v1.Taxonomy>(
                  this, METHODID_UPDATE_TAXONOMY)))
          .addMethod(
            getListTaxonomiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.ListTaxonomiesRequest,
                com.google.cloud.datacatalog.v1.ListTaxonomiesResponse>(
                  this, METHODID_LIST_TAXONOMIES)))
          .addMethod(
            getGetTaxonomyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.GetTaxonomyRequest,
                com.google.cloud.datacatalog.v1.Taxonomy>(
                  this, METHODID_GET_TAXONOMY)))
          .addMethod(
            getCreatePolicyTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.CreatePolicyTagRequest,
                com.google.cloud.datacatalog.v1.PolicyTag>(
                  this, METHODID_CREATE_POLICY_TAG)))
          .addMethod(
            getDeletePolicyTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.DeletePolicyTagRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_POLICY_TAG)))
          .addMethod(
            getUpdatePolicyTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest,
                com.google.cloud.datacatalog.v1.PolicyTag>(
                  this, METHODID_UPDATE_POLICY_TAG)))
          .addMethod(
            getListPolicyTagsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.ListPolicyTagsRequest,
                com.google.cloud.datacatalog.v1.ListPolicyTagsResponse>(
                  this, METHODID_LIST_POLICY_TAGS)))
          .addMethod(
            getGetPolicyTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.datacatalog.v1.GetPolicyTagRequest,
                com.google.cloud.datacatalog.v1.PolicyTag>(
                  this, METHODID_GET_POLICY_TAG)))
          .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * Policy Tag Manager API service allows you to manage your policy tags and
   * taxonomies.
   * Policy tags are used to tag BigQuery columns and apply additional access
   * control policies. A taxonomy is a hierarchical grouping of policy tags that
   * classify data along a common axis.
   * </pre>
   */
  public static final class PolicyTagManagerStub extends io.grpc.stub.AbstractAsyncStub<PolicyTagManagerStub> {
    private PolicyTagManagerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyTagManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyTagManagerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a taxonomy in a specified project.
     * The taxonomy is initially empty, that is, it doesn't contain policy tags.
     * </pre>
     */
    public void createTaxonomy(com.google.cloud.datacatalog.v1.CreateTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.Taxonomy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTaxonomyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a taxonomy, including all policy tags in this
     * taxonomy, their associated policies, and the policy tags references from
     * BigQuery columns.
     * </pre>
     */
    public void deleteTaxonomy(com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTaxonomyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a taxonomy, including its display name,
     * description, and activated policy types.
     * </pre>
     */
    public void updateTaxonomy(com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.Taxonomy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTaxonomyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all taxonomies in a project in a particular location that you
     * have a permission to view.
     * </pre>
     */
    public void listTaxonomies(com.google.cloud.datacatalog.v1.ListTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.ListTaxonomiesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTaxonomiesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a taxonomy.
     * </pre>
     */
    public void getTaxonomy(com.google.cloud.datacatalog.v1.GetTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.Taxonomy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTaxonomyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a policy tag in a taxonomy.
     * </pre>
     */
    public void createPolicyTag(com.google.cloud.datacatalog.v1.CreatePolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.PolicyTag> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePolicyTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a policy tag together with the following:
     * * All of its descendant policy tags, if any
     * * Policies associated with the policy tag and its descendants
     * * References from BigQuery table schema of the policy tag and its
     *   descendants
     * </pre>
     */
    public void deletePolicyTag(com.google.cloud.datacatalog.v1.DeletePolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePolicyTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a policy tag, including its display
     * name, description, and parent policy tag.
     * </pre>
     */
    public void updatePolicyTag(com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.PolicyTag> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePolicyTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all policy tags in a taxonomy.
     * </pre>
     */
    public void listPolicyTags(com.google.cloud.datacatalog.v1.ListPolicyTagsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.ListPolicyTagsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPolicyTagsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a policy tag.
     * </pre>
     */
    public void getPolicyTag(com.google.cloud.datacatalog.v1.GetPolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.PolicyTag> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPolicyTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the IAM policy for a policy tag or a taxonomy.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the IAM policy for a policy tag or a taxonomy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns your permissions on a specified policy tag or
     * taxonomy.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Policy Tag Manager API service allows you to manage your policy tags and
   * taxonomies.
   * Policy tags are used to tag BigQuery columns and apply additional access
   * control policies. A taxonomy is a hierarchical grouping of policy tags that
   * classify data along a common axis.
   * </pre>
   */
  public static final class PolicyTagManagerBlockingStub extends io.grpc.stub.AbstractBlockingStub<PolicyTagManagerBlockingStub> {
    private PolicyTagManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyTagManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyTagManagerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a taxonomy in a specified project.
     * The taxonomy is initially empty, that is, it doesn't contain policy tags.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1.Taxonomy createTaxonomy(com.google.cloud.datacatalog.v1.CreateTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTaxonomyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a taxonomy, including all policy tags in this
     * taxonomy, their associated policies, and the policy tags references from
     * BigQuery columns.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTaxonomy(com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTaxonomyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a taxonomy, including its display name,
     * description, and activated policy types.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1.Taxonomy updateTaxonomy(com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTaxonomyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all taxonomies in a project in a particular location that you
     * have a permission to view.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1.ListTaxonomiesResponse listTaxonomies(com.google.cloud.datacatalog.v1.ListTaxonomiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTaxonomiesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a taxonomy.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1.Taxonomy getTaxonomy(com.google.cloud.datacatalog.v1.GetTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTaxonomyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a policy tag in a taxonomy.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1.PolicyTag createPolicyTag(com.google.cloud.datacatalog.v1.CreatePolicyTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePolicyTagMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a policy tag together with the following:
     * * All of its descendant policy tags, if any
     * * Policies associated with the policy tag and its descendants
     * * References from BigQuery table schema of the policy tag and its
     *   descendants
     * </pre>
     */
    public com.google.protobuf.Empty deletePolicyTag(com.google.cloud.datacatalog.v1.DeletePolicyTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePolicyTagMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a policy tag, including its display
     * name, description, and parent policy tag.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1.PolicyTag updatePolicyTag(com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePolicyTagMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all policy tags in a taxonomy.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1.ListPolicyTagsResponse listPolicyTags(com.google.cloud.datacatalog.v1.ListPolicyTagsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPolicyTagsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a policy tag.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1.PolicyTag getPolicyTag(com.google.cloud.datacatalog.v1.GetPolicyTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPolicyTagMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the IAM policy for a policy tag or a taxonomy.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the IAM policy for a policy tag or a taxonomy.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns your permissions on a specified policy tag or
     * taxonomy.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Policy Tag Manager API service allows you to manage your policy tags and
   * taxonomies.
   * Policy tags are used to tag BigQuery columns and apply additional access
   * control policies. A taxonomy is a hierarchical grouping of policy tags that
   * classify data along a common axis.
   * </pre>
   */
  public static final class PolicyTagManagerFutureStub extends io.grpc.stub.AbstractFutureStub<PolicyTagManagerFutureStub> {
    private PolicyTagManagerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyTagManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyTagManagerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a taxonomy in a specified project.
     * The taxonomy is initially empty, that is, it doesn't contain policy tags.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1.Taxonomy> createTaxonomy(
        com.google.cloud.datacatalog.v1.CreateTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTaxonomyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a taxonomy, including all policy tags in this
     * taxonomy, their associated policies, and the policy tags references from
     * BigQuery columns.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTaxonomy(
        com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTaxonomyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a taxonomy, including its display name,
     * description, and activated policy types.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1.Taxonomy> updateTaxonomy(
        com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTaxonomyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all taxonomies in a project in a particular location that you
     * have a permission to view.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1.ListTaxonomiesResponse> listTaxonomies(
        com.google.cloud.datacatalog.v1.ListTaxonomiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTaxonomiesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a taxonomy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1.Taxonomy> getTaxonomy(
        com.google.cloud.datacatalog.v1.GetTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTaxonomyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a policy tag in a taxonomy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1.PolicyTag> createPolicyTag(
        com.google.cloud.datacatalog.v1.CreatePolicyTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePolicyTagMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a policy tag together with the following:
     * * All of its descendant policy tags, if any
     * * Policies associated with the policy tag and its descendants
     * * References from BigQuery table schema of the policy tag and its
     *   descendants
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deletePolicyTag(
        com.google.cloud.datacatalog.v1.DeletePolicyTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePolicyTagMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a policy tag, including its display
     * name, description, and parent policy tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1.PolicyTag> updatePolicyTag(
        com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePolicyTagMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all policy tags in a taxonomy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1.ListPolicyTagsResponse> listPolicyTags(
        com.google.cloud.datacatalog.v1.ListPolicyTagsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPolicyTagsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a policy tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.v1.PolicyTag> getPolicyTag(
        com.google.cloud.datacatalog.v1.GetPolicyTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPolicyTagMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the IAM policy for a policy tag or a taxonomy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the IAM policy for a policy tag or a taxonomy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns your permissions on a specified policy tag or
     * taxonomy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TAXONOMY = 0;
  private static final int METHODID_DELETE_TAXONOMY = 1;
  private static final int METHODID_UPDATE_TAXONOMY = 2;
  private static final int METHODID_LIST_TAXONOMIES = 3;
  private static final int METHODID_GET_TAXONOMY = 4;
  private static final int METHODID_CREATE_POLICY_TAG = 5;
  private static final int METHODID_DELETE_POLICY_TAG = 6;
  private static final int METHODID_UPDATE_POLICY_TAG = 7;
  private static final int METHODID_LIST_POLICY_TAGS = 8;
  private static final int METHODID_GET_POLICY_TAG = 9;
  private static final int METHODID_GET_IAM_POLICY = 10;
  private static final int METHODID_SET_IAM_POLICY = 11;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 12;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PolicyTagManagerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PolicyTagManagerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TAXONOMY:
          serviceImpl.createTaxonomy((com.google.cloud.datacatalog.v1.CreateTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.Taxonomy>) responseObserver);
          break;
        case METHODID_DELETE_TAXONOMY:
          serviceImpl.deleteTaxonomy((com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_TAXONOMY:
          serviceImpl.updateTaxonomy((com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.Taxonomy>) responseObserver);
          break;
        case METHODID_LIST_TAXONOMIES:
          serviceImpl.listTaxonomies((com.google.cloud.datacatalog.v1.ListTaxonomiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.ListTaxonomiesResponse>) responseObserver);
          break;
        case METHODID_GET_TAXONOMY:
          serviceImpl.getTaxonomy((com.google.cloud.datacatalog.v1.GetTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.Taxonomy>) responseObserver);
          break;
        case METHODID_CREATE_POLICY_TAG:
          serviceImpl.createPolicyTag((com.google.cloud.datacatalog.v1.CreatePolicyTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.PolicyTag>) responseObserver);
          break;
        case METHODID_DELETE_POLICY_TAG:
          serviceImpl.deletePolicyTag((com.google.cloud.datacatalog.v1.DeletePolicyTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_POLICY_TAG:
          serviceImpl.updatePolicyTag((com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.PolicyTag>) responseObserver);
          break;
        case METHODID_LIST_POLICY_TAGS:
          serviceImpl.listPolicyTags((com.google.cloud.datacatalog.v1.ListPolicyTagsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.ListPolicyTagsResponse>) responseObserver);
          break;
        case METHODID_GET_POLICY_TAG:
          serviceImpl.getPolicyTag((com.google.cloud.datacatalog.v1.GetPolicyTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1.PolicyTag>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
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

  private static abstract class PolicyTagManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PolicyTagManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.datacatalog.v1.PolicyTagManagerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PolicyTagManager");
    }
  }

  private static final class PolicyTagManagerFileDescriptorSupplier
      extends PolicyTagManagerBaseDescriptorSupplier {
    PolicyTagManagerFileDescriptorSupplier() {}
  }

  private static final class PolicyTagManagerMethodDescriptorSupplier
      extends PolicyTagManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PolicyTagManagerMethodDescriptorSupplier(String methodName) {
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
      synchronized (PolicyTagManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PolicyTagManagerFileDescriptorSupplier())
              .addMethod(getCreateTaxonomyMethod())
              .addMethod(getDeleteTaxonomyMethod())
              .addMethod(getUpdateTaxonomyMethod())
              .addMethod(getListTaxonomiesMethod())
              .addMethod(getGetTaxonomyMethod())
              .addMethod(getCreatePolicyTagMethod())
              .addMethod(getDeletePolicyTagMethod())
              .addMethod(getUpdatePolicyTagMethod())
              .addMethod(getListPolicyTagsMethod())
              .addMethod(getGetPolicyTagMethod())
              .addMethod(getGetIamPolicyMethod())
              .addMethod(getSetIamPolicyMethod())
              .addMethod(getTestIamPermissionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
