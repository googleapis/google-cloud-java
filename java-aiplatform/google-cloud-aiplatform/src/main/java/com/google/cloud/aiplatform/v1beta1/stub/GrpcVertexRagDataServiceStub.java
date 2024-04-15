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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagCorporaPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.VertexRagDataServiceClient.ListRagFilesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateRagCorpusOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateRagCorpusRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteRagCorpusRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteRagFileRequest;
import com.google.cloud.aiplatform.v1beta1.GetRagCorpusRequest;
import com.google.cloud.aiplatform.v1beta1.GetRagFileRequest;
import com.google.cloud.aiplatform.v1beta1.ImportRagFilesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportRagFilesRequest;
import com.google.cloud.aiplatform.v1beta1.ImportRagFilesResponse;
import com.google.cloud.aiplatform.v1beta1.ListRagCorporaRequest;
import com.google.cloud.aiplatform.v1beta1.ListRagCorporaResponse;
import com.google.cloud.aiplatform.v1beta1.ListRagFilesRequest;
import com.google.cloud.aiplatform.v1beta1.ListRagFilesResponse;
import com.google.cloud.aiplatform.v1beta1.RagCorpus;
import com.google.cloud.aiplatform.v1beta1.RagFile;
import com.google.cloud.aiplatform.v1beta1.UploadRagFileRequest;
import com.google.cloud.aiplatform.v1beta1.UploadRagFileResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * gRPC stub implementation for the VertexRagDataService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcVertexRagDataServiceStub extends VertexRagDataServiceStub {
  private static final MethodDescriptor<CreateRagCorpusRequest, Operation>
      createRagCorpusMethodDescriptor =
          MethodDescriptor.<CreateRagCorpusRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.VertexRagDataService/CreateRagCorpus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRagCorpusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRagCorpusRequest, RagCorpus>
      getRagCorpusMethodDescriptor =
          MethodDescriptor.<GetRagCorpusRequest, RagCorpus>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.VertexRagDataService/GetRagCorpus")
              .setRequestMarshaller(ProtoUtils.marshaller(GetRagCorpusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RagCorpus.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRagCorporaRequest, ListRagCorporaResponse>
      listRagCorporaMethodDescriptor =
          MethodDescriptor.<ListRagCorporaRequest, ListRagCorporaResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.VertexRagDataService/ListRagCorpora")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRagCorporaRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRagCorporaResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRagCorpusRequest, Operation>
      deleteRagCorpusMethodDescriptor =
          MethodDescriptor.<DeleteRagCorpusRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.VertexRagDataService/DeleteRagCorpus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRagCorpusRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UploadRagFileRequest, UploadRagFileResponse>
      uploadRagFileMethodDescriptor =
          MethodDescriptor.<UploadRagFileRequest, UploadRagFileResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.VertexRagDataService/UploadRagFile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UploadRagFileRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UploadRagFileResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportRagFilesRequest, Operation>
      importRagFilesMethodDescriptor =
          MethodDescriptor.<ImportRagFilesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.VertexRagDataService/ImportRagFiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportRagFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRagFileRequest, RagFile> getRagFileMethodDescriptor =
      MethodDescriptor.<GetRagFileRequest, RagFile>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.VertexRagDataService/GetRagFile")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRagFileRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(RagFile.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListRagFilesRequest, ListRagFilesResponse>
      listRagFilesMethodDescriptor =
          MethodDescriptor.<ListRagFilesRequest, ListRagFilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.VertexRagDataService/ListRagFiles")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRagFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRagFilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRagFileRequest, Operation>
      deleteRagFileMethodDescriptor =
          MethodDescriptor.<DeleteRagFileRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.VertexRagDataService/DeleteRagFile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRagFileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
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

  private final UnaryCallable<CreateRagCorpusRequest, Operation> createRagCorpusCallable;
  private final OperationCallable<
          CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
      createRagCorpusOperationCallable;
  private final UnaryCallable<GetRagCorpusRequest, RagCorpus> getRagCorpusCallable;
  private final UnaryCallable<ListRagCorporaRequest, ListRagCorporaResponse> listRagCorporaCallable;
  private final UnaryCallable<ListRagCorporaRequest, ListRagCorporaPagedResponse>
      listRagCorporaPagedCallable;
  private final UnaryCallable<DeleteRagCorpusRequest, Operation> deleteRagCorpusCallable;
  private final OperationCallable<DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
      deleteRagCorpusOperationCallable;
  private final UnaryCallable<UploadRagFileRequest, UploadRagFileResponse> uploadRagFileCallable;
  private final UnaryCallable<ImportRagFilesRequest, Operation> importRagFilesCallable;
  private final OperationCallable<
          ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesOperationCallable;
  private final UnaryCallable<GetRagFileRequest, RagFile> getRagFileCallable;
  private final UnaryCallable<ListRagFilesRequest, ListRagFilesResponse> listRagFilesCallable;
  private final UnaryCallable<ListRagFilesRequest, ListRagFilesPagedResponse>
      listRagFilesPagedCallable;
  private final UnaryCallable<DeleteRagFileRequest, Operation> deleteRagFileCallable;
  private final OperationCallable<DeleteRagFileRequest, Empty, DeleteOperationMetadata>
      deleteRagFileOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcVertexRagDataServiceStub create(VertexRagDataServiceStubSettings settings)
      throws IOException {
    return new GrpcVertexRagDataServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcVertexRagDataServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcVertexRagDataServiceStub(
        VertexRagDataServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcVertexRagDataServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcVertexRagDataServiceStub(
        VertexRagDataServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcVertexRagDataServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcVertexRagDataServiceStub(
      VertexRagDataServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcVertexRagDataServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcVertexRagDataServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcVertexRagDataServiceStub(
      VertexRagDataServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateRagCorpusRequest, Operation> createRagCorpusTransportSettings =
        GrpcCallSettings.<CreateRagCorpusRequest, Operation>newBuilder()
            .setMethodDescriptor(createRagCorpusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetRagCorpusRequest, RagCorpus> getRagCorpusTransportSettings =
        GrpcCallSettings.<GetRagCorpusRequest, RagCorpus>newBuilder()
            .setMethodDescriptor(getRagCorpusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRagCorporaRequest, ListRagCorporaResponse>
        listRagCorporaTransportSettings =
            GrpcCallSettings.<ListRagCorporaRequest, ListRagCorporaResponse>newBuilder()
                .setMethodDescriptor(listRagCorporaMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteRagCorpusRequest, Operation> deleteRagCorpusTransportSettings =
        GrpcCallSettings.<DeleteRagCorpusRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRagCorpusMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UploadRagFileRequest, UploadRagFileResponse> uploadRagFileTransportSettings =
        GrpcCallSettings.<UploadRagFileRequest, UploadRagFileResponse>newBuilder()
            .setMethodDescriptor(uploadRagFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportRagFilesRequest, Operation> importRagFilesTransportSettings =
        GrpcCallSettings.<ImportRagFilesRequest, Operation>newBuilder()
            .setMethodDescriptor(importRagFilesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetRagFileRequest, RagFile> getRagFileTransportSettings =
        GrpcCallSettings.<GetRagFileRequest, RagFile>newBuilder()
            .setMethodDescriptor(getRagFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRagFilesRequest, ListRagFilesResponse> listRagFilesTransportSettings =
        GrpcCallSettings.<ListRagFilesRequest, ListRagFilesResponse>newBuilder()
            .setMethodDescriptor(listRagFilesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteRagFileRequest, Operation> deleteRagFileTransportSettings =
        GrpcCallSettings.<DeleteRagFileRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRagFileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
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

    this.createRagCorpusCallable =
        callableFactory.createUnaryCallable(
            createRagCorpusTransportSettings, settings.createRagCorpusSettings(), clientContext);
    this.createRagCorpusOperationCallable =
        callableFactory.createOperationCallable(
            createRagCorpusTransportSettings,
            settings.createRagCorpusOperationSettings(),
            clientContext,
            operationsStub);
    this.getRagCorpusCallable =
        callableFactory.createUnaryCallable(
            getRagCorpusTransportSettings, settings.getRagCorpusSettings(), clientContext);
    this.listRagCorporaCallable =
        callableFactory.createUnaryCallable(
            listRagCorporaTransportSettings, settings.listRagCorporaSettings(), clientContext);
    this.listRagCorporaPagedCallable =
        callableFactory.createPagedCallable(
            listRagCorporaTransportSettings, settings.listRagCorporaSettings(), clientContext);
    this.deleteRagCorpusCallable =
        callableFactory.createUnaryCallable(
            deleteRagCorpusTransportSettings, settings.deleteRagCorpusSettings(), clientContext);
    this.deleteRagCorpusOperationCallable =
        callableFactory.createOperationCallable(
            deleteRagCorpusTransportSettings,
            settings.deleteRagCorpusOperationSettings(),
            clientContext,
            operationsStub);
    this.uploadRagFileCallable =
        callableFactory.createUnaryCallable(
            uploadRagFileTransportSettings, settings.uploadRagFileSettings(), clientContext);
    this.importRagFilesCallable =
        callableFactory.createUnaryCallable(
            importRagFilesTransportSettings, settings.importRagFilesSettings(), clientContext);
    this.importRagFilesOperationCallable =
        callableFactory.createOperationCallable(
            importRagFilesTransportSettings,
            settings.importRagFilesOperationSettings(),
            clientContext,
            operationsStub);
    this.getRagFileCallable =
        callableFactory.createUnaryCallable(
            getRagFileTransportSettings, settings.getRagFileSettings(), clientContext);
    this.listRagFilesCallable =
        callableFactory.createUnaryCallable(
            listRagFilesTransportSettings, settings.listRagFilesSettings(), clientContext);
    this.listRagFilesPagedCallable =
        callableFactory.createPagedCallable(
            listRagFilesTransportSettings, settings.listRagFilesSettings(), clientContext);
    this.deleteRagFileCallable =
        callableFactory.createUnaryCallable(
            deleteRagFileTransportSettings, settings.deleteRagFileSettings(), clientContext);
    this.deleteRagFileOperationCallable =
        callableFactory.createOperationCallable(
            deleteRagFileTransportSettings,
            settings.deleteRagFileOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
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
  public UnaryCallable<CreateRagCorpusRequest, Operation> createRagCorpusCallable() {
    return createRagCorpusCallable;
  }

  @Override
  public OperationCallable<CreateRagCorpusRequest, RagCorpus, CreateRagCorpusOperationMetadata>
      createRagCorpusOperationCallable() {
    return createRagCorpusOperationCallable;
  }

  @Override
  public UnaryCallable<GetRagCorpusRequest, RagCorpus> getRagCorpusCallable() {
    return getRagCorpusCallable;
  }

  @Override
  public UnaryCallable<ListRagCorporaRequest, ListRagCorporaResponse> listRagCorporaCallable() {
    return listRagCorporaCallable;
  }

  @Override
  public UnaryCallable<ListRagCorporaRequest, ListRagCorporaPagedResponse>
      listRagCorporaPagedCallable() {
    return listRagCorporaPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRagCorpusRequest, Operation> deleteRagCorpusCallable() {
    return deleteRagCorpusCallable;
  }

  @Override
  public OperationCallable<DeleteRagCorpusRequest, Empty, DeleteOperationMetadata>
      deleteRagCorpusOperationCallable() {
    return deleteRagCorpusOperationCallable;
  }

  @Override
  public UnaryCallable<UploadRagFileRequest, UploadRagFileResponse> uploadRagFileCallable() {
    return uploadRagFileCallable;
  }

  @Override
  public UnaryCallable<ImportRagFilesRequest, Operation> importRagFilesCallable() {
    return importRagFilesCallable;
  }

  @Override
  public OperationCallable<
          ImportRagFilesRequest, ImportRagFilesResponse, ImportRagFilesOperationMetadata>
      importRagFilesOperationCallable() {
    return importRagFilesOperationCallable;
  }

  @Override
  public UnaryCallable<GetRagFileRequest, RagFile> getRagFileCallable() {
    return getRagFileCallable;
  }

  @Override
  public UnaryCallable<ListRagFilesRequest, ListRagFilesResponse> listRagFilesCallable() {
    return listRagFilesCallable;
  }

  @Override
  public UnaryCallable<ListRagFilesRequest, ListRagFilesPagedResponse> listRagFilesPagedCallable() {
    return listRagFilesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRagFileRequest, Operation> deleteRagFileCallable() {
    return deleteRagFileCallable;
  }

  @Override
  public OperationCallable<DeleteRagFileRequest, Empty, DeleteOperationMetadata>
      deleteRagFileOperationCallable() {
    return deleteRagFileOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
