package com.google.cloud.managedidentities.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * API Overview
 * The `managedidentites.googleapis.com` service implements the Google Cloud
 * Managed Identites API for identity services
 * (e.g. Microsoft Active Directory).
 * The Managed Identities service provides methods to manage
 * (create/read/update/delete) domains, reset managed identities admin password,
 * add/remove domain controllers in GCP regions and add/remove VPC peering.
 * Data Model
 * The Managed Identities service exposes the following resources:
 * * Locations as global, named as follows:
 *   `projects/{project_id}/locations/global`.
 * * Domains, named as follows:
 *   `/projects/{project_id}/locations/global/domain/{domain_name}`.
 * The `{domain_name}` refers to fully qualified domain name in the customer
 * project e.g. mydomain.myorganization.com, with the following restrictions:
 *  * Must contain only lowercase letters, numbers, periods and hyphens.
 *  * Must start with a letter.
 *  * Must contain between 2-64 characters.
 *  * Must end with a number or a letter.
 *  * Must not start with period.
 *  * First segement length (mydomain form example above) shouldn't exceed
 *    15 chars.
 *  * The last segment cannot be fully numeric.
 *  * Must be unique within the customer project.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/managedidentities/v1/managed_identities_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ManagedIdentitiesServiceGrpc {

  private ManagedIdentitiesServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.managedidentities.v1.ManagedIdentitiesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest,
      com.google.longrunning.Operation> getCreateMicrosoftAdDomainMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMicrosoftAdDomain",
      requestType = com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest,
      com.google.longrunning.Operation> getCreateMicrosoftAdDomainMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest, com.google.longrunning.Operation> getCreateMicrosoftAdDomainMethod;
    if ((getCreateMicrosoftAdDomainMethod = ManagedIdentitiesServiceGrpc.getCreateMicrosoftAdDomainMethod) == null) {
      synchronized (ManagedIdentitiesServiceGrpc.class) {
        if ((getCreateMicrosoftAdDomainMethod = ManagedIdentitiesServiceGrpc.getCreateMicrosoftAdDomainMethod) == null) {
          ManagedIdentitiesServiceGrpc.getCreateMicrosoftAdDomainMethod = getCreateMicrosoftAdDomainMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMicrosoftAdDomain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedIdentitiesServiceMethodDescriptorSupplier("CreateMicrosoftAdDomain"))
              .build();
        }
      }
    }
    return getCreateMicrosoftAdDomainMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest,
      com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse> getResetAdminPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetAdminPassword",
      requestType = com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest.class,
      responseType = com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest,
      com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse> getResetAdminPasswordMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest, com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse> getResetAdminPasswordMethod;
    if ((getResetAdminPasswordMethod = ManagedIdentitiesServiceGrpc.getResetAdminPasswordMethod) == null) {
      synchronized (ManagedIdentitiesServiceGrpc.class) {
        if ((getResetAdminPasswordMethod = ManagedIdentitiesServiceGrpc.getResetAdminPasswordMethod) == null) {
          ManagedIdentitiesServiceGrpc.getResetAdminPasswordMethod = getResetAdminPasswordMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest, com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetAdminPassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedIdentitiesServiceMethodDescriptorSupplier("ResetAdminPassword"))
              .build();
        }
      }
    }
    return getResetAdminPasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.ListDomainsRequest,
      com.google.cloud.managedidentities.v1.ListDomainsResponse> getListDomainsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDomains",
      requestType = com.google.cloud.managedidentities.v1.ListDomainsRequest.class,
      responseType = com.google.cloud.managedidentities.v1.ListDomainsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.ListDomainsRequest,
      com.google.cloud.managedidentities.v1.ListDomainsResponse> getListDomainsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.ListDomainsRequest, com.google.cloud.managedidentities.v1.ListDomainsResponse> getListDomainsMethod;
    if ((getListDomainsMethod = ManagedIdentitiesServiceGrpc.getListDomainsMethod) == null) {
      synchronized (ManagedIdentitiesServiceGrpc.class) {
        if ((getListDomainsMethod = ManagedIdentitiesServiceGrpc.getListDomainsMethod) == null) {
          ManagedIdentitiesServiceGrpc.getListDomainsMethod = getListDomainsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.managedidentities.v1.ListDomainsRequest, com.google.cloud.managedidentities.v1.ListDomainsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDomains"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.ListDomainsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.ListDomainsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedIdentitiesServiceMethodDescriptorSupplier("ListDomains"))
              .build();
        }
      }
    }
    return getListDomainsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.GetDomainRequest,
      com.google.cloud.managedidentities.v1.Domain> getGetDomainMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDomain",
      requestType = com.google.cloud.managedidentities.v1.GetDomainRequest.class,
      responseType = com.google.cloud.managedidentities.v1.Domain.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.GetDomainRequest,
      com.google.cloud.managedidentities.v1.Domain> getGetDomainMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.GetDomainRequest, com.google.cloud.managedidentities.v1.Domain> getGetDomainMethod;
    if ((getGetDomainMethod = ManagedIdentitiesServiceGrpc.getGetDomainMethod) == null) {
      synchronized (ManagedIdentitiesServiceGrpc.class) {
        if ((getGetDomainMethod = ManagedIdentitiesServiceGrpc.getGetDomainMethod) == null) {
          ManagedIdentitiesServiceGrpc.getGetDomainMethod = getGetDomainMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.managedidentities.v1.GetDomainRequest, com.google.cloud.managedidentities.v1.Domain>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDomain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.GetDomainRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.Domain.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedIdentitiesServiceMethodDescriptorSupplier("GetDomain"))
              .build();
        }
      }
    }
    return getGetDomainMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.UpdateDomainRequest,
      com.google.longrunning.Operation> getUpdateDomainMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDomain",
      requestType = com.google.cloud.managedidentities.v1.UpdateDomainRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.UpdateDomainRequest,
      com.google.longrunning.Operation> getUpdateDomainMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.UpdateDomainRequest, com.google.longrunning.Operation> getUpdateDomainMethod;
    if ((getUpdateDomainMethod = ManagedIdentitiesServiceGrpc.getUpdateDomainMethod) == null) {
      synchronized (ManagedIdentitiesServiceGrpc.class) {
        if ((getUpdateDomainMethod = ManagedIdentitiesServiceGrpc.getUpdateDomainMethod) == null) {
          ManagedIdentitiesServiceGrpc.getUpdateDomainMethod = getUpdateDomainMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.managedidentities.v1.UpdateDomainRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDomain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.UpdateDomainRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedIdentitiesServiceMethodDescriptorSupplier("UpdateDomain"))
              .build();
        }
      }
    }
    return getUpdateDomainMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.DeleteDomainRequest,
      com.google.longrunning.Operation> getDeleteDomainMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDomain",
      requestType = com.google.cloud.managedidentities.v1.DeleteDomainRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.DeleteDomainRequest,
      com.google.longrunning.Operation> getDeleteDomainMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.DeleteDomainRequest, com.google.longrunning.Operation> getDeleteDomainMethod;
    if ((getDeleteDomainMethod = ManagedIdentitiesServiceGrpc.getDeleteDomainMethod) == null) {
      synchronized (ManagedIdentitiesServiceGrpc.class) {
        if ((getDeleteDomainMethod = ManagedIdentitiesServiceGrpc.getDeleteDomainMethod) == null) {
          ManagedIdentitiesServiceGrpc.getDeleteDomainMethod = getDeleteDomainMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.managedidentities.v1.DeleteDomainRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDomain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.DeleteDomainRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedIdentitiesServiceMethodDescriptorSupplier("DeleteDomain"))
              .build();
        }
      }
    }
    return getDeleteDomainMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.AttachTrustRequest,
      com.google.longrunning.Operation> getAttachTrustMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AttachTrust",
      requestType = com.google.cloud.managedidentities.v1.AttachTrustRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.AttachTrustRequest,
      com.google.longrunning.Operation> getAttachTrustMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.AttachTrustRequest, com.google.longrunning.Operation> getAttachTrustMethod;
    if ((getAttachTrustMethod = ManagedIdentitiesServiceGrpc.getAttachTrustMethod) == null) {
      synchronized (ManagedIdentitiesServiceGrpc.class) {
        if ((getAttachTrustMethod = ManagedIdentitiesServiceGrpc.getAttachTrustMethod) == null) {
          ManagedIdentitiesServiceGrpc.getAttachTrustMethod = getAttachTrustMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.managedidentities.v1.AttachTrustRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AttachTrust"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.AttachTrustRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedIdentitiesServiceMethodDescriptorSupplier("AttachTrust"))
              .build();
        }
      }
    }
    return getAttachTrustMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.ReconfigureTrustRequest,
      com.google.longrunning.Operation> getReconfigureTrustMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReconfigureTrust",
      requestType = com.google.cloud.managedidentities.v1.ReconfigureTrustRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.ReconfigureTrustRequest,
      com.google.longrunning.Operation> getReconfigureTrustMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.ReconfigureTrustRequest, com.google.longrunning.Operation> getReconfigureTrustMethod;
    if ((getReconfigureTrustMethod = ManagedIdentitiesServiceGrpc.getReconfigureTrustMethod) == null) {
      synchronized (ManagedIdentitiesServiceGrpc.class) {
        if ((getReconfigureTrustMethod = ManagedIdentitiesServiceGrpc.getReconfigureTrustMethod) == null) {
          ManagedIdentitiesServiceGrpc.getReconfigureTrustMethod = getReconfigureTrustMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.managedidentities.v1.ReconfigureTrustRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReconfigureTrust"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.ReconfigureTrustRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedIdentitiesServiceMethodDescriptorSupplier("ReconfigureTrust"))
              .build();
        }
      }
    }
    return getReconfigureTrustMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.DetachTrustRequest,
      com.google.longrunning.Operation> getDetachTrustMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DetachTrust",
      requestType = com.google.cloud.managedidentities.v1.DetachTrustRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.DetachTrustRequest,
      com.google.longrunning.Operation> getDetachTrustMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.DetachTrustRequest, com.google.longrunning.Operation> getDetachTrustMethod;
    if ((getDetachTrustMethod = ManagedIdentitiesServiceGrpc.getDetachTrustMethod) == null) {
      synchronized (ManagedIdentitiesServiceGrpc.class) {
        if ((getDetachTrustMethod = ManagedIdentitiesServiceGrpc.getDetachTrustMethod) == null) {
          ManagedIdentitiesServiceGrpc.getDetachTrustMethod = getDetachTrustMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.managedidentities.v1.DetachTrustRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DetachTrust"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.DetachTrustRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedIdentitiesServiceMethodDescriptorSupplier("DetachTrust"))
              .build();
        }
      }
    }
    return getDetachTrustMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.ValidateTrustRequest,
      com.google.longrunning.Operation> getValidateTrustMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateTrust",
      requestType = com.google.cloud.managedidentities.v1.ValidateTrustRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.ValidateTrustRequest,
      com.google.longrunning.Operation> getValidateTrustMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.managedidentities.v1.ValidateTrustRequest, com.google.longrunning.Operation> getValidateTrustMethod;
    if ((getValidateTrustMethod = ManagedIdentitiesServiceGrpc.getValidateTrustMethod) == null) {
      synchronized (ManagedIdentitiesServiceGrpc.class) {
        if ((getValidateTrustMethod = ManagedIdentitiesServiceGrpc.getValidateTrustMethod) == null) {
          ManagedIdentitiesServiceGrpc.getValidateTrustMethod = getValidateTrustMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.managedidentities.v1.ValidateTrustRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateTrust"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.managedidentities.v1.ValidateTrustRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ManagedIdentitiesServiceMethodDescriptorSupplier("ValidateTrust"))
              .build();
        }
      }
    }
    return getValidateTrustMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ManagedIdentitiesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedIdentitiesServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManagedIdentitiesServiceStub>() {
        @java.lang.Override
        public ManagedIdentitiesServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManagedIdentitiesServiceStub(channel, callOptions);
        }
      };
    return ManagedIdentitiesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ManagedIdentitiesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedIdentitiesServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManagedIdentitiesServiceBlockingStub>() {
        @java.lang.Override
        public ManagedIdentitiesServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManagedIdentitiesServiceBlockingStub(channel, callOptions);
        }
      };
    return ManagedIdentitiesServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ManagedIdentitiesServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedIdentitiesServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManagedIdentitiesServiceFutureStub>() {
        @java.lang.Override
        public ManagedIdentitiesServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManagedIdentitiesServiceFutureStub(channel, callOptions);
        }
      };
    return ManagedIdentitiesServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * API Overview
   * The `managedidentites.googleapis.com` service implements the Google Cloud
   * Managed Identites API for identity services
   * (e.g. Microsoft Active Directory).
   * The Managed Identities service provides methods to manage
   * (create/read/update/delete) domains, reset managed identities admin password,
   * add/remove domain controllers in GCP regions and add/remove VPC peering.
   * Data Model
   * The Managed Identities service exposes the following resources:
   * * Locations as global, named as follows:
   *   `projects/{project_id}/locations/global`.
   * * Domains, named as follows:
   *   `/projects/{project_id}/locations/global/domain/{domain_name}`.
   * The `{domain_name}` refers to fully qualified domain name in the customer
   * project e.g. mydomain.myorganization.com, with the following restrictions:
   *  * Must contain only lowercase letters, numbers, periods and hyphens.
   *  * Must start with a letter.
   *  * Must contain between 2-64 characters.
   *  * Must end with a number or a letter.
   *  * Must not start with period.
   *  * First segement length (mydomain form example above) shouldn't exceed
   *    15 chars.
   *  * The last segment cannot be fully numeric.
   *  * Must be unique within the customer project.
   * </pre>
   */
  public static abstract class ManagedIdentitiesServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a Microsoft AD domain.
     * </pre>
     */
    public void createMicrosoftAdDomain(com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMicrosoftAdDomainMethod(), responseObserver);
    }

    /**
     * <pre>
     * Resets a domain's administrator password.
     * </pre>
     */
    public void resetAdminPassword(com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResetAdminPasswordMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists domains in a project.
     * </pre>
     */
    public void listDomains(com.google.cloud.managedidentities.v1.ListDomainsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedidentities.v1.ListDomainsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDomainsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets information about a domain.
     * </pre>
     */
    public void getDomain(com.google.cloud.managedidentities.v1.GetDomainRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedidentities.v1.Domain> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDomainMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the metadata and configuration of a domain.
     * </pre>
     */
    public void updateDomain(com.google.cloud.managedidentities.v1.UpdateDomainRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateDomainMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a domain.
     * </pre>
     */
    public void deleteDomain(com.google.cloud.managedidentities.v1.DeleteDomainRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteDomainMethod(), responseObserver);
    }

    /**
     * <pre>
     * Adds an AD trust to a domain.
     * </pre>
     */
    public void attachTrust(com.google.cloud.managedidentities.v1.AttachTrustRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAttachTrustMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the DNS conditional forwarder.
     * </pre>
     */
    public void reconfigureTrust(com.google.cloud.managedidentities.v1.ReconfigureTrustRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReconfigureTrustMethod(), responseObserver);
    }

    /**
     * <pre>
     * Removes an AD trust.
     * </pre>
     */
    public void detachTrust(com.google.cloud.managedidentities.v1.DetachTrustRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDetachTrustMethod(), responseObserver);
    }

    /**
     * <pre>
     * Validates a trust state, that the target domain is reachable, and that the
     * target domain is able to accept incoming trust requests.
     * </pre>
     */
    public void validateTrust(com.google.cloud.managedidentities.v1.ValidateTrustRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateTrustMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMicrosoftAdDomainMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_MICROSOFT_AD_DOMAIN)))
          .addMethod(
            getResetAdminPasswordMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest,
                com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse>(
                  this, METHODID_RESET_ADMIN_PASSWORD)))
          .addMethod(
            getListDomainsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.managedidentities.v1.ListDomainsRequest,
                com.google.cloud.managedidentities.v1.ListDomainsResponse>(
                  this, METHODID_LIST_DOMAINS)))
          .addMethod(
            getGetDomainMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.managedidentities.v1.GetDomainRequest,
                com.google.cloud.managedidentities.v1.Domain>(
                  this, METHODID_GET_DOMAIN)))
          .addMethod(
            getUpdateDomainMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.managedidentities.v1.UpdateDomainRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_DOMAIN)))
          .addMethod(
            getDeleteDomainMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.managedidentities.v1.DeleteDomainRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_DOMAIN)))
          .addMethod(
            getAttachTrustMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.managedidentities.v1.AttachTrustRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_ATTACH_TRUST)))
          .addMethod(
            getReconfigureTrustMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.managedidentities.v1.ReconfigureTrustRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RECONFIGURE_TRUST)))
          .addMethod(
            getDetachTrustMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.managedidentities.v1.DetachTrustRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DETACH_TRUST)))
          .addMethod(
            getValidateTrustMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.managedidentities.v1.ValidateTrustRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_VALIDATE_TRUST)))
          .build();
    }
  }

  /**
   * <pre>
   * API Overview
   * The `managedidentites.googleapis.com` service implements the Google Cloud
   * Managed Identites API for identity services
   * (e.g. Microsoft Active Directory).
   * The Managed Identities service provides methods to manage
   * (create/read/update/delete) domains, reset managed identities admin password,
   * add/remove domain controllers in GCP regions and add/remove VPC peering.
   * Data Model
   * The Managed Identities service exposes the following resources:
   * * Locations as global, named as follows:
   *   `projects/{project_id}/locations/global`.
   * * Domains, named as follows:
   *   `/projects/{project_id}/locations/global/domain/{domain_name}`.
   * The `{domain_name}` refers to fully qualified domain name in the customer
   * project e.g. mydomain.myorganization.com, with the following restrictions:
   *  * Must contain only lowercase letters, numbers, periods and hyphens.
   *  * Must start with a letter.
   *  * Must contain between 2-64 characters.
   *  * Must end with a number or a letter.
   *  * Must not start with period.
   *  * First segement length (mydomain form example above) shouldn't exceed
   *    15 chars.
   *  * The last segment cannot be fully numeric.
   *  * Must be unique within the customer project.
   * </pre>
   */
  public static final class ManagedIdentitiesServiceStub extends io.grpc.stub.AbstractAsyncStub<ManagedIdentitiesServiceStub> {
    private ManagedIdentitiesServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedIdentitiesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedIdentitiesServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Microsoft AD domain.
     * </pre>
     */
    public void createMicrosoftAdDomain(com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMicrosoftAdDomainMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Resets a domain's administrator password.
     * </pre>
     */
    public void resetAdminPassword(com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetAdminPasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists domains in a project.
     * </pre>
     */
    public void listDomains(com.google.cloud.managedidentities.v1.ListDomainsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedidentities.v1.ListDomainsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDomainsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets information about a domain.
     * </pre>
     */
    public void getDomain(com.google.cloud.managedidentities.v1.GetDomainRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedidentities.v1.Domain> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDomainMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the metadata and configuration of a domain.
     * </pre>
     */
    public void updateDomain(com.google.cloud.managedidentities.v1.UpdateDomainRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDomainMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a domain.
     * </pre>
     */
    public void deleteDomain(com.google.cloud.managedidentities.v1.DeleteDomainRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDomainMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Adds an AD trust to a domain.
     * </pre>
     */
    public void attachTrust(com.google.cloud.managedidentities.v1.AttachTrustRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAttachTrustMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the DNS conditional forwarder.
     * </pre>
     */
    public void reconfigureTrust(com.google.cloud.managedidentities.v1.ReconfigureTrustRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReconfigureTrustMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Removes an AD trust.
     * </pre>
     */
    public void detachTrust(com.google.cloud.managedidentities.v1.DetachTrustRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDetachTrustMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Validates a trust state, that the target domain is reachable, and that the
     * target domain is able to accept incoming trust requests.
     * </pre>
     */
    public void validateTrust(com.google.cloud.managedidentities.v1.ValidateTrustRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateTrustMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * API Overview
   * The `managedidentites.googleapis.com` service implements the Google Cloud
   * Managed Identites API for identity services
   * (e.g. Microsoft Active Directory).
   * The Managed Identities service provides methods to manage
   * (create/read/update/delete) domains, reset managed identities admin password,
   * add/remove domain controllers in GCP regions and add/remove VPC peering.
   * Data Model
   * The Managed Identities service exposes the following resources:
   * * Locations as global, named as follows:
   *   `projects/{project_id}/locations/global`.
   * * Domains, named as follows:
   *   `/projects/{project_id}/locations/global/domain/{domain_name}`.
   * The `{domain_name}` refers to fully qualified domain name in the customer
   * project e.g. mydomain.myorganization.com, with the following restrictions:
   *  * Must contain only lowercase letters, numbers, periods and hyphens.
   *  * Must start with a letter.
   *  * Must contain between 2-64 characters.
   *  * Must end with a number or a letter.
   *  * Must not start with period.
   *  * First segement length (mydomain form example above) shouldn't exceed
   *    15 chars.
   *  * The last segment cannot be fully numeric.
   *  * Must be unique within the customer project.
   * </pre>
   */
  public static final class ManagedIdentitiesServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ManagedIdentitiesServiceBlockingStub> {
    private ManagedIdentitiesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedIdentitiesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedIdentitiesServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Microsoft AD domain.
     * </pre>
     */
    public com.google.longrunning.Operation createMicrosoftAdDomain(com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMicrosoftAdDomainMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Resets a domain's administrator password.
     * </pre>
     */
    public com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse resetAdminPassword(com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetAdminPasswordMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists domains in a project.
     * </pre>
     */
    public com.google.cloud.managedidentities.v1.ListDomainsResponse listDomains(com.google.cloud.managedidentities.v1.ListDomainsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDomainsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets information about a domain.
     * </pre>
     */
    public com.google.cloud.managedidentities.v1.Domain getDomain(com.google.cloud.managedidentities.v1.GetDomainRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDomainMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the metadata and configuration of a domain.
     * </pre>
     */
    public com.google.longrunning.Operation updateDomain(com.google.cloud.managedidentities.v1.UpdateDomainRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDomainMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a domain.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDomain(com.google.cloud.managedidentities.v1.DeleteDomainRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDomainMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Adds an AD trust to a domain.
     * </pre>
     */
    public com.google.longrunning.Operation attachTrust(com.google.cloud.managedidentities.v1.AttachTrustRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAttachTrustMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the DNS conditional forwarder.
     * </pre>
     */
    public com.google.longrunning.Operation reconfigureTrust(com.google.cloud.managedidentities.v1.ReconfigureTrustRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReconfigureTrustMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Removes an AD trust.
     * </pre>
     */
    public com.google.longrunning.Operation detachTrust(com.google.cloud.managedidentities.v1.DetachTrustRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDetachTrustMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Validates a trust state, that the target domain is reachable, and that the
     * target domain is able to accept incoming trust requests.
     * </pre>
     */
    public com.google.longrunning.Operation validateTrust(com.google.cloud.managedidentities.v1.ValidateTrustRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateTrustMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * API Overview
   * The `managedidentites.googleapis.com` service implements the Google Cloud
   * Managed Identites API for identity services
   * (e.g. Microsoft Active Directory).
   * The Managed Identities service provides methods to manage
   * (create/read/update/delete) domains, reset managed identities admin password,
   * add/remove domain controllers in GCP regions and add/remove VPC peering.
   * Data Model
   * The Managed Identities service exposes the following resources:
   * * Locations as global, named as follows:
   *   `projects/{project_id}/locations/global`.
   * * Domains, named as follows:
   *   `/projects/{project_id}/locations/global/domain/{domain_name}`.
   * The `{domain_name}` refers to fully qualified domain name in the customer
   * project e.g. mydomain.myorganization.com, with the following restrictions:
   *  * Must contain only lowercase letters, numbers, periods and hyphens.
   *  * Must start with a letter.
   *  * Must contain between 2-64 characters.
   *  * Must end with a number or a letter.
   *  * Must not start with period.
   *  * First segement length (mydomain form example above) shouldn't exceed
   *    15 chars.
   *  * The last segment cannot be fully numeric.
   *  * Must be unique within the customer project.
   * </pre>
   */
  public static final class ManagedIdentitiesServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ManagedIdentitiesServiceFutureStub> {
    private ManagedIdentitiesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedIdentitiesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedIdentitiesServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a Microsoft AD domain.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createMicrosoftAdDomain(
        com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMicrosoftAdDomainMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Resets a domain's administrator password.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse> resetAdminPassword(
        com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetAdminPasswordMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists domains in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.managedidentities.v1.ListDomainsResponse> listDomains(
        com.google.cloud.managedidentities.v1.ListDomainsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDomainsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets information about a domain.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.managedidentities.v1.Domain> getDomain(
        com.google.cloud.managedidentities.v1.GetDomainRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDomainMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the metadata and configuration of a domain.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateDomain(
        com.google.cloud.managedidentities.v1.UpdateDomainRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDomainMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a domain.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteDomain(
        com.google.cloud.managedidentities.v1.DeleteDomainRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDomainMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Adds an AD trust to a domain.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> attachTrust(
        com.google.cloud.managedidentities.v1.AttachTrustRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAttachTrustMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the DNS conditional forwarder.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> reconfigureTrust(
        com.google.cloud.managedidentities.v1.ReconfigureTrustRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReconfigureTrustMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Removes an AD trust.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> detachTrust(
        com.google.cloud.managedidentities.v1.DetachTrustRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDetachTrustMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Validates a trust state, that the target domain is reachable, and that the
     * target domain is able to accept incoming trust requests.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> validateTrust(
        com.google.cloud.managedidentities.v1.ValidateTrustRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateTrustMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_MICROSOFT_AD_DOMAIN = 0;
  private static final int METHODID_RESET_ADMIN_PASSWORD = 1;
  private static final int METHODID_LIST_DOMAINS = 2;
  private static final int METHODID_GET_DOMAIN = 3;
  private static final int METHODID_UPDATE_DOMAIN = 4;
  private static final int METHODID_DELETE_DOMAIN = 5;
  private static final int METHODID_ATTACH_TRUST = 6;
  private static final int METHODID_RECONFIGURE_TRUST = 7;
  private static final int METHODID_DETACH_TRUST = 8;
  private static final int METHODID_VALIDATE_TRUST = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ManagedIdentitiesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ManagedIdentitiesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_MICROSOFT_AD_DOMAIN:
          serviceImpl.createMicrosoftAdDomain((com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESET_ADMIN_PASSWORD:
          serviceImpl.resetAdminPassword((com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse>) responseObserver);
          break;
        case METHODID_LIST_DOMAINS:
          serviceImpl.listDomains((com.google.cloud.managedidentities.v1.ListDomainsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedidentities.v1.ListDomainsResponse>) responseObserver);
          break;
        case METHODID_GET_DOMAIN:
          serviceImpl.getDomain((com.google.cloud.managedidentities.v1.GetDomainRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedidentities.v1.Domain>) responseObserver);
          break;
        case METHODID_UPDATE_DOMAIN:
          serviceImpl.updateDomain((com.google.cloud.managedidentities.v1.UpdateDomainRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DOMAIN:
          serviceImpl.deleteDomain((com.google.cloud.managedidentities.v1.DeleteDomainRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ATTACH_TRUST:
          serviceImpl.attachTrust((com.google.cloud.managedidentities.v1.AttachTrustRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RECONFIGURE_TRUST:
          serviceImpl.reconfigureTrust((com.google.cloud.managedidentities.v1.ReconfigureTrustRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DETACH_TRUST:
          serviceImpl.detachTrust((com.google.cloud.managedidentities.v1.DetachTrustRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_VALIDATE_TRUST:
          serviceImpl.validateTrust((com.google.cloud.managedidentities.v1.ValidateTrustRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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

  private static abstract class ManagedIdentitiesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ManagedIdentitiesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.managedidentities.v1.ManagedIdentitiesServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ManagedIdentitiesService");
    }
  }

  private static final class ManagedIdentitiesServiceFileDescriptorSupplier
      extends ManagedIdentitiesServiceBaseDescriptorSupplier {
    ManagedIdentitiesServiceFileDescriptorSupplier() {}
  }

  private static final class ManagedIdentitiesServiceMethodDescriptorSupplier
      extends ManagedIdentitiesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ManagedIdentitiesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ManagedIdentitiesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ManagedIdentitiesServiceFileDescriptorSupplier())
              .addMethod(getCreateMicrosoftAdDomainMethod())
              .addMethod(getResetAdminPasswordMethod())
              .addMethod(getListDomainsMethod())
              .addMethod(getGetDomainMethod())
              .addMethod(getUpdateDomainMethod())
              .addMethod(getDeleteDomainMethod())
              .addMethod(getAttachTrustMethod())
              .addMethod(getReconfigureTrustMethod())
              .addMethod(getDetachTrustMethod())
              .addMethod(getValidateTrustMethod())
              .build();
        }
      }
    }
    return result;
  }
}
