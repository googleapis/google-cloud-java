/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.pubsub.v1.stub;

import static com.google.cloud.pubsub.v1.SchemaServiceClient.ListSchemaRevisionsPagedResponse;
import static com.google.cloud.pubsub.v1.SchemaServiceClient.ListSchemasPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.CommitSchemaRequest;
import com.google.pubsub.v1.CreateSchemaRequest;
import com.google.pubsub.v1.DeleteSchemaRequest;
import com.google.pubsub.v1.DeleteSchemaRevisionRequest;
import com.google.pubsub.v1.GetSchemaRequest;
import com.google.pubsub.v1.ListSchemaRevisionsRequest;
import com.google.pubsub.v1.ListSchemaRevisionsResponse;
import com.google.pubsub.v1.ListSchemasRequest;
import com.google.pubsub.v1.ListSchemasResponse;
import com.google.pubsub.v1.RollbackSchemaRequest;
import com.google.pubsub.v1.Schema;
import com.google.pubsub.v1.ValidateMessageRequest;
import com.google.pubsub.v1.ValidateMessageResponse;
import com.google.pubsub.v1.ValidateSchemaRequest;
import com.google.pubsub.v1.ValidateSchemaResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SchemaService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSchemaServiceStub extends SchemaServiceStub {
  private static final MethodDescriptor<CreateSchemaRequest, Schema> createSchemaMethodDescriptor =
      MethodDescriptor.<CreateSchemaRequest, Schema>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.SchemaService/CreateSchema")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSchemaRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Schema.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetSchemaRequest, Schema> getSchemaMethodDescriptor =
      MethodDescriptor.<GetSchemaRequest, Schema>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.SchemaService/GetSchema")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSchemaRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Schema.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListSchemasRequest, ListSchemasResponse>
      listSchemasMethodDescriptor =
          MethodDescriptor.<ListSchemasRequest, ListSchemasResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.SchemaService/ListSchemas")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSchemasRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSchemasResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSchemaRevisionsRequest, ListSchemaRevisionsResponse>
      listSchemaRevisionsMethodDescriptor =
          MethodDescriptor.<ListSchemaRevisionsRequest, ListSchemaRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.SchemaService/ListSchemaRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSchemaRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSchemaRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CommitSchemaRequest, Schema> commitSchemaMethodDescriptor =
      MethodDescriptor.<CommitSchemaRequest, Schema>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.SchemaService/CommitSchema")
          .setRequestMarshaller(ProtoUtils.marshaller(CommitSchemaRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Schema.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<RollbackSchemaRequest, Schema>
      rollbackSchemaMethodDescriptor =
          MethodDescriptor.<RollbackSchemaRequest, Schema>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.SchemaService/RollbackSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RollbackSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Schema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSchemaRevisionRequest, Schema>
      deleteSchemaRevisionMethodDescriptor =
          MethodDescriptor.<DeleteSchemaRevisionRequest, Schema>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.SchemaService/DeleteSchemaRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSchemaRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Schema.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSchemaRequest, Empty> deleteSchemaMethodDescriptor =
      MethodDescriptor.<DeleteSchemaRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.pubsub.v1.SchemaService/DeleteSchema")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSchemaRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ValidateSchemaRequest, ValidateSchemaResponse>
      validateSchemaMethodDescriptor =
          MethodDescriptor.<ValidateSchemaRequest, ValidateSchemaResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.SchemaService/ValidateSchema")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ValidateSchemaRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ValidateSchemaResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ValidateMessageRequest, ValidateMessageResponse>
      validateMessageMethodDescriptor =
          MethodDescriptor.<ValidateMessageRequest, ValidateMessageResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.pubsub.v1.SchemaService/ValidateMessage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ValidateMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ValidateMessageResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateSchemaRequest, Schema> createSchemaCallable;
  private final UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable;
  private final UnaryCallable<ListSchemasRequest, ListSchemasResponse> listSchemasCallable;
  private final UnaryCallable<ListSchemasRequest, ListSchemasPagedResponse>
      listSchemasPagedCallable;
  private final UnaryCallable<ListSchemaRevisionsRequest, ListSchemaRevisionsResponse>
      listSchemaRevisionsCallable;
  private final UnaryCallable<ListSchemaRevisionsRequest, ListSchemaRevisionsPagedResponse>
      listSchemaRevisionsPagedCallable;
  private final UnaryCallable<CommitSchemaRequest, Schema> commitSchemaCallable;
  private final UnaryCallable<RollbackSchemaRequest, Schema> rollbackSchemaCallable;
  private final UnaryCallable<DeleteSchemaRevisionRequest, Schema> deleteSchemaRevisionCallable;
  private final UnaryCallable<DeleteSchemaRequest, Empty> deleteSchemaCallable;
  private final UnaryCallable<ValidateSchemaRequest, ValidateSchemaResponse> validateSchemaCallable;
  private final UnaryCallable<ValidateMessageRequest, ValidateMessageResponse>
      validateMessageCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSchemaServiceStub create(SchemaServiceStubSettings settings)
      throws IOException {
    return new GrpcSchemaServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSchemaServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcSchemaServiceStub(SchemaServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSchemaServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSchemaServiceStub(
        SchemaServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSchemaServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSchemaServiceStub(SchemaServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSchemaServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSchemaServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSchemaServiceStub(
      SchemaServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSchemaRequest, Schema> createSchemaTransportSettings =
        GrpcCallSettings.<CreateSchemaRequest, Schema>newBuilder()
            .setMethodDescriptor(createSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSchemaRequest, Schema> getSchemaTransportSettings =
        GrpcCallSettings.<GetSchemaRequest, Schema>newBuilder()
            .setMethodDescriptor(getSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSchemasRequest, ListSchemasResponse> listSchemasTransportSettings =
        GrpcCallSettings.<ListSchemasRequest, ListSchemasResponse>newBuilder()
            .setMethodDescriptor(listSchemasMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSchemaRevisionsRequest, ListSchemaRevisionsResponse>
        listSchemaRevisionsTransportSettings =
            GrpcCallSettings.<ListSchemaRevisionsRequest, ListSchemaRevisionsResponse>newBuilder()
                .setMethodDescriptor(listSchemaRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CommitSchemaRequest, Schema> commitSchemaTransportSettings =
        GrpcCallSettings.<CommitSchemaRequest, Schema>newBuilder()
            .setMethodDescriptor(commitSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RollbackSchemaRequest, Schema> rollbackSchemaTransportSettings =
        GrpcCallSettings.<RollbackSchemaRequest, Schema>newBuilder()
            .setMethodDescriptor(rollbackSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSchemaRevisionRequest, Schema> deleteSchemaRevisionTransportSettings =
        GrpcCallSettings.<DeleteSchemaRevisionRequest, Schema>newBuilder()
            .setMethodDescriptor(deleteSchemaRevisionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSchemaRequest, Empty> deleteSchemaTransportSettings =
        GrpcCallSettings.<DeleteSchemaRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSchemaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ValidateSchemaRequest, ValidateSchemaResponse>
        validateSchemaTransportSettings =
            GrpcCallSettings.<ValidateSchemaRequest, ValidateSchemaResponse>newBuilder()
                .setMethodDescriptor(validateSchemaMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ValidateMessageRequest, ValidateMessageResponse>
        validateMessageTransportSettings =
            GrpcCallSettings.<ValidateMessageRequest, ValidateMessageResponse>newBuilder()
                .setMethodDescriptor(validateMessageMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.createSchemaCallable =
        callableFactory.createUnaryCallable(
            createSchemaTransportSettings, settings.createSchemaSettings(), clientContext);
    this.getSchemaCallable =
        callableFactory.createUnaryCallable(
            getSchemaTransportSettings, settings.getSchemaSettings(), clientContext);
    this.listSchemasCallable =
        callableFactory.createUnaryCallable(
            listSchemasTransportSettings, settings.listSchemasSettings(), clientContext);
    this.listSchemasPagedCallable =
        callableFactory.createPagedCallable(
            listSchemasTransportSettings, settings.listSchemasSettings(), clientContext);
    this.listSchemaRevisionsCallable =
        callableFactory.createUnaryCallable(
            listSchemaRevisionsTransportSettings,
            settings.listSchemaRevisionsSettings(),
            clientContext);
    this.listSchemaRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listSchemaRevisionsTransportSettings,
            settings.listSchemaRevisionsSettings(),
            clientContext);
    this.commitSchemaCallable =
        callableFactory.createUnaryCallable(
            commitSchemaTransportSettings, settings.commitSchemaSettings(), clientContext);
    this.rollbackSchemaCallable =
        callableFactory.createUnaryCallable(
            rollbackSchemaTransportSettings, settings.rollbackSchemaSettings(), clientContext);
    this.deleteSchemaRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteSchemaRevisionTransportSettings,
            settings.deleteSchemaRevisionSettings(),
            clientContext);
    this.deleteSchemaCallable =
        callableFactory.createUnaryCallable(
            deleteSchemaTransportSettings, settings.deleteSchemaSettings(), clientContext);
    this.validateSchemaCallable =
        callableFactory.createUnaryCallable(
            validateSchemaTransportSettings, settings.validateSchemaSettings(), clientContext);
    this.validateMessageCallable =
        callableFactory.createUnaryCallable(
            validateMessageTransportSettings, settings.validateMessageSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateSchemaRequest, Schema> createSchemaCallable() {
    return createSchemaCallable;
  }

  @Override
  public UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable() {
    return getSchemaCallable;
  }

  @Override
  public UnaryCallable<ListSchemasRequest, ListSchemasResponse> listSchemasCallable() {
    return listSchemasCallable;
  }

  @Override
  public UnaryCallable<ListSchemasRequest, ListSchemasPagedResponse> listSchemasPagedCallable() {
    return listSchemasPagedCallable;
  }

  @Override
  public UnaryCallable<ListSchemaRevisionsRequest, ListSchemaRevisionsResponse>
      listSchemaRevisionsCallable() {
    return listSchemaRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListSchemaRevisionsRequest, ListSchemaRevisionsPagedResponse>
      listSchemaRevisionsPagedCallable() {
    return listSchemaRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<CommitSchemaRequest, Schema> commitSchemaCallable() {
    return commitSchemaCallable;
  }

  @Override
  public UnaryCallable<RollbackSchemaRequest, Schema> rollbackSchemaCallable() {
    return rollbackSchemaCallable;
  }

  @Override
  public UnaryCallable<DeleteSchemaRevisionRequest, Schema> deleteSchemaRevisionCallable() {
    return deleteSchemaRevisionCallable;
  }

  @Override
  public UnaryCallable<DeleteSchemaRequest, Empty> deleteSchemaCallable() {
    return deleteSchemaCallable;
  }

  @Override
  public UnaryCallable<ValidateSchemaRequest, ValidateSchemaResponse> validateSchemaCallable() {
    return validateSchemaCallable;
  }

  @Override
  public UnaryCallable<ValidateMessageRequest, ValidateMessageResponse> validateMessageCallable() {
    return validateMessageCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
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
