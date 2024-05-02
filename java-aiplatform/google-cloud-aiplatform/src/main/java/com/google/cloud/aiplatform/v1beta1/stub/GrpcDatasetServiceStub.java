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

import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListAnnotationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDataItemsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDatasetVersionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDatasetsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListSavedQueriesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.SearchDataItemsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.AnnotationSpec;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetVersionOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetVersionRequest;
import com.google.cloud.aiplatform.v1beta1.Dataset;
import com.google.cloud.aiplatform.v1beta1.DatasetVersion;
import com.google.cloud.aiplatform.v1beta1.DeleteDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteDatasetVersionRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteSavedQueryRequest;
import com.google.cloud.aiplatform.v1beta1.ExportDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExportDataRequest;
import com.google.cloud.aiplatform.v1beta1.ExportDataResponse;
import com.google.cloud.aiplatform.v1beta1.GetAnnotationSpecRequest;
import com.google.cloud.aiplatform.v1beta1.GetDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.GetDatasetVersionRequest;
import com.google.cloud.aiplatform.v1beta1.ImportDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportDataRequest;
import com.google.cloud.aiplatform.v1beta1.ImportDataResponse;
import com.google.cloud.aiplatform.v1beta1.ListAnnotationsRequest;
import com.google.cloud.aiplatform.v1beta1.ListAnnotationsResponse;
import com.google.cloud.aiplatform.v1beta1.ListDataItemsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDataItemsResponse;
import com.google.cloud.aiplatform.v1beta1.ListDatasetVersionsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDatasetVersionsResponse;
import com.google.cloud.aiplatform.v1beta1.ListDatasetsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDatasetsResponse;
import com.google.cloud.aiplatform.v1beta1.ListSavedQueriesRequest;
import com.google.cloud.aiplatform.v1beta1.ListSavedQueriesResponse;
import com.google.cloud.aiplatform.v1beta1.RestoreDatasetVersionOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.RestoreDatasetVersionRequest;
import com.google.cloud.aiplatform.v1beta1.SearchDataItemsRequest;
import com.google.cloud.aiplatform.v1beta1.SearchDataItemsResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateDatasetVersionRequest;
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
 * gRPC stub implementation for the DatasetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDatasetServiceStub extends DatasetServiceStub {
  private static final MethodDescriptor<CreateDatasetRequest, Operation>
      createDatasetMethodDescriptor =
          MethodDescriptor.<CreateDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/CreateDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDatasetRequest, Dataset> getDatasetMethodDescriptor =
      MethodDescriptor.<GetDatasetRequest, Dataset>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/GetDataset")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDatasetRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateDatasetRequest, Dataset>
      updateDatasetMethodDescriptor =
          MethodDescriptor.<UpdateDatasetRequest, Dataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/UpdateDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Dataset.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDatasetsRequest, ListDatasetsResponse>
      listDatasetsMethodDescriptor =
          MethodDescriptor.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/ListDatasets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatasetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDatasetRequest, Operation>
      deleteDatasetMethodDescriptor =
          MethodDescriptor.<DeleteDatasetRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/DeleteDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportDataRequest, Operation> importDataMethodDescriptor =
      MethodDescriptor.<ImportDataRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/ImportData")
          .setRequestMarshaller(ProtoUtils.marshaller(ImportDataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ExportDataRequest, Operation> exportDataMethodDescriptor =
      MethodDescriptor.<ExportDataRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/ExportData")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportDataRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateDatasetVersionRequest, Operation>
      createDatasetVersionMethodDescriptor =
          MethodDescriptor.<CreateDatasetVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.DatasetService/CreateDatasetVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatasetVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDatasetVersionRequest, DatasetVersion>
      updateDatasetVersionMethodDescriptor =
          MethodDescriptor.<UpdateDatasetVersionRequest, DatasetVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.DatasetService/UpdateDatasetVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatasetVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DatasetVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDatasetVersionRequest, Operation>
      deleteDatasetVersionMethodDescriptor =
          MethodDescriptor.<DeleteDatasetVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.DatasetService/DeleteDatasetVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDatasetVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDatasetVersionRequest, DatasetVersion>
      getDatasetVersionMethodDescriptor =
          MethodDescriptor.<GetDatasetVersionRequest, DatasetVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/GetDatasetVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDatasetVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DatasetVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDatasetVersionsRequest, ListDatasetVersionsResponse>
      listDatasetVersionsMethodDescriptor =
          MethodDescriptor.<ListDatasetVersionsRequest, ListDatasetVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.DatasetService/ListDatasetVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDatasetVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatasetVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RestoreDatasetVersionRequest, Operation>
      restoreDatasetVersionMethodDescriptor =
          MethodDescriptor.<RestoreDatasetVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.DatasetService/RestoreDatasetVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreDatasetVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataItemsRequest, ListDataItemsResponse>
      listDataItemsMethodDescriptor =
          MethodDescriptor.<ListDataItemsRequest, ListDataItemsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/ListDataItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataItemsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchDataItemsRequest, SearchDataItemsResponse>
      searchDataItemsMethodDescriptor =
          MethodDescriptor.<SearchDataItemsRequest, SearchDataItemsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/SearchDataItems")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchDataItemsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchDataItemsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSavedQueriesRequest, ListSavedQueriesResponse>
      listSavedQueriesMethodDescriptor =
          MethodDescriptor.<ListSavedQueriesRequest, ListSavedQueriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/ListSavedQueries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSavedQueriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSavedQueriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSavedQueryRequest, Operation>
      deleteSavedQueryMethodDescriptor =
          MethodDescriptor.<DeleteSavedQueryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/DeleteSavedQuery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSavedQueryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAnnotationSpecRequest, AnnotationSpec>
      getAnnotationSpecMethodDescriptor =
          MethodDescriptor.<GetAnnotationSpecRequest, AnnotationSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/GetAnnotationSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAnnotationSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnnotationSpec.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAnnotationsRequest, ListAnnotationsResponse>
      listAnnotationsMethodDescriptor =
          MethodDescriptor.<ListAnnotationsRequest, ListAnnotationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1beta1.DatasetService/ListAnnotations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAnnotationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnnotationsResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable;
  private final OperationCallable<CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
      createDatasetOperationCallable;
  private final UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable;
  private final UnaryCallable<UpdateDatasetRequest, Dataset> updateDatasetCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable;
  private final UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse>
      listDatasetsPagedCallable;
  private final UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable;
  private final OperationCallable<DeleteDatasetRequest, Empty, DeleteOperationMetadata>
      deleteDatasetOperationCallable;
  private final UnaryCallable<ImportDataRequest, Operation> importDataCallable;
  private final OperationCallable<
          ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
      importDataOperationCallable;
  private final UnaryCallable<ExportDataRequest, Operation> exportDataCallable;
  private final OperationCallable<
          ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
      exportDataOperationCallable;
  private final UnaryCallable<CreateDatasetVersionRequest, Operation> createDatasetVersionCallable;
  private final OperationCallable<
          CreateDatasetVersionRequest, DatasetVersion, CreateDatasetVersionOperationMetadata>
      createDatasetVersionOperationCallable;
  private final UnaryCallable<UpdateDatasetVersionRequest, DatasetVersion>
      updateDatasetVersionCallable;
  private final UnaryCallable<DeleteDatasetVersionRequest, Operation> deleteDatasetVersionCallable;
  private final OperationCallable<DeleteDatasetVersionRequest, Empty, DeleteOperationMetadata>
      deleteDatasetVersionOperationCallable;
  private final UnaryCallable<GetDatasetVersionRequest, DatasetVersion> getDatasetVersionCallable;
  private final UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsResponse>
      listDatasetVersionsCallable;
  private final UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsPagedResponse>
      listDatasetVersionsPagedCallable;
  private final UnaryCallable<RestoreDatasetVersionRequest, Operation>
      restoreDatasetVersionCallable;
  private final OperationCallable<
          RestoreDatasetVersionRequest, DatasetVersion, RestoreDatasetVersionOperationMetadata>
      restoreDatasetVersionOperationCallable;
  private final UnaryCallable<ListDataItemsRequest, ListDataItemsResponse> listDataItemsCallable;
  private final UnaryCallable<ListDataItemsRequest, ListDataItemsPagedResponse>
      listDataItemsPagedCallable;
  private final UnaryCallable<SearchDataItemsRequest, SearchDataItemsResponse>
      searchDataItemsCallable;
  private final UnaryCallable<SearchDataItemsRequest, SearchDataItemsPagedResponse>
      searchDataItemsPagedCallable;
  private final UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesResponse>
      listSavedQueriesCallable;
  private final UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesPagedResponse>
      listSavedQueriesPagedCallable;
  private final UnaryCallable<DeleteSavedQueryRequest, Operation> deleteSavedQueryCallable;
  private final OperationCallable<DeleteSavedQueryRequest, Empty, DeleteOperationMetadata>
      deleteSavedQueryOperationCallable;
  private final UnaryCallable<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecCallable;
  private final UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse>
      listAnnotationsCallable;
  private final UnaryCallable<ListAnnotationsRequest, ListAnnotationsPagedResponse>
      listAnnotationsPagedCallable;
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

  public static final GrpcDatasetServiceStub create(DatasetServiceStubSettings settings)
      throws IOException {
    return new GrpcDatasetServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDatasetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDatasetServiceStub(
        DatasetServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDatasetServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDatasetServiceStub(
        DatasetServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDatasetServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDatasetServiceStub(DatasetServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDatasetServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDatasetServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDatasetServiceStub(
      DatasetServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateDatasetRequest, Operation> createDatasetTransportSettings =
        GrpcCallSettings.<CreateDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(createDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDatasetRequest, Dataset> getDatasetTransportSettings =
        GrpcCallSettings.<GetDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(getDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDatasetRequest, Dataset> updateDatasetTransportSettings =
        GrpcCallSettings.<UpdateDatasetRequest, Dataset>newBuilder()
            .setMethodDescriptor(updateDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("dataset.name", String.valueOf(request.getDataset().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDatasetsRequest, ListDatasetsResponse> listDatasetsTransportSettings =
        GrpcCallSettings.<ListDatasetsRequest, ListDatasetsResponse>newBuilder()
            .setMethodDescriptor(listDatasetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDatasetRequest, Operation> deleteDatasetTransportSettings =
        GrpcCallSettings.<DeleteDatasetRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDatasetMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportDataRequest, Operation> importDataTransportSettings =
        GrpcCallSettings.<ImportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(importDataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportDataRequest, Operation> exportDataTransportSettings =
        GrpcCallSettings.<ExportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDatasetVersionRequest, Operation> createDatasetVersionTransportSettings =
        GrpcCallSettings.<CreateDatasetVersionRequest, Operation>newBuilder()
            .setMethodDescriptor(createDatasetVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDatasetVersionRequest, DatasetVersion>
        updateDatasetVersionTransportSettings =
            GrpcCallSettings.<UpdateDatasetVersionRequest, DatasetVersion>newBuilder()
                .setMethodDescriptor(updateDatasetVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "dataset_version.name",
                          String.valueOf(request.getDatasetVersion().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteDatasetVersionRequest, Operation> deleteDatasetVersionTransportSettings =
        GrpcCallSettings.<DeleteDatasetVersionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDatasetVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDatasetVersionRequest, DatasetVersion> getDatasetVersionTransportSettings =
        GrpcCallSettings.<GetDatasetVersionRequest, DatasetVersion>newBuilder()
            .setMethodDescriptor(getDatasetVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDatasetVersionsRequest, ListDatasetVersionsResponse>
        listDatasetVersionsTransportSettings =
            GrpcCallSettings.<ListDatasetVersionsRequest, ListDatasetVersionsResponse>newBuilder()
                .setMethodDescriptor(listDatasetVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RestoreDatasetVersionRequest, Operation>
        restoreDatasetVersionTransportSettings =
            GrpcCallSettings.<RestoreDatasetVersionRequest, Operation>newBuilder()
                .setMethodDescriptor(restoreDatasetVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDataItemsRequest, ListDataItemsResponse> listDataItemsTransportSettings =
        GrpcCallSettings.<ListDataItemsRequest, ListDataItemsResponse>newBuilder()
            .setMethodDescriptor(listDataItemsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SearchDataItemsRequest, SearchDataItemsResponse>
        searchDataItemsTransportSettings =
            GrpcCallSettings.<SearchDataItemsRequest, SearchDataItemsResponse>newBuilder()
                .setMethodDescriptor(searchDataItemsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("dataset", String.valueOf(request.getDataset()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListSavedQueriesRequest, ListSavedQueriesResponse>
        listSavedQueriesTransportSettings =
            GrpcCallSettings.<ListSavedQueriesRequest, ListSavedQueriesResponse>newBuilder()
                .setMethodDescriptor(listSavedQueriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteSavedQueryRequest, Operation> deleteSavedQueryTransportSettings =
        GrpcCallSettings.<DeleteSavedQueryRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSavedQueryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecTransportSettings =
        GrpcCallSettings.<GetAnnotationSpecRequest, AnnotationSpec>newBuilder()
            .setMethodDescriptor(getAnnotationSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAnnotationsRequest, ListAnnotationsResponse>
        listAnnotationsTransportSettings =
            GrpcCallSettings.<ListAnnotationsRequest, ListAnnotationsResponse>newBuilder()
                .setMethodDescriptor(listAnnotationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
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

    this.createDatasetCallable =
        callableFactory.createUnaryCallable(
            createDatasetTransportSettings, settings.createDatasetSettings(), clientContext);
    this.createDatasetOperationCallable =
        callableFactory.createOperationCallable(
            createDatasetTransportSettings,
            settings.createDatasetOperationSettings(),
            clientContext,
            operationsStub);
    this.getDatasetCallable =
        callableFactory.createUnaryCallable(
            getDatasetTransportSettings, settings.getDatasetSettings(), clientContext);
    this.updateDatasetCallable =
        callableFactory.createUnaryCallable(
            updateDatasetTransportSettings, settings.updateDatasetSettings(), clientContext);
    this.listDatasetsCallable =
        callableFactory.createUnaryCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.listDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetsTransportSettings, settings.listDatasetsSettings(), clientContext);
    this.deleteDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteDatasetTransportSettings, settings.deleteDatasetSettings(), clientContext);
    this.deleteDatasetOperationCallable =
        callableFactory.createOperationCallable(
            deleteDatasetTransportSettings,
            settings.deleteDatasetOperationSettings(),
            clientContext,
            operationsStub);
    this.importDataCallable =
        callableFactory.createUnaryCallable(
            importDataTransportSettings, settings.importDataSettings(), clientContext);
    this.importDataOperationCallable =
        callableFactory.createOperationCallable(
            importDataTransportSettings,
            settings.importDataOperationSettings(),
            clientContext,
            operationsStub);
    this.exportDataCallable =
        callableFactory.createUnaryCallable(
            exportDataTransportSettings, settings.exportDataSettings(), clientContext);
    this.exportDataOperationCallable =
        callableFactory.createOperationCallable(
            exportDataTransportSettings,
            settings.exportDataOperationSettings(),
            clientContext,
            operationsStub);
    this.createDatasetVersionCallable =
        callableFactory.createUnaryCallable(
            createDatasetVersionTransportSettings,
            settings.createDatasetVersionSettings(),
            clientContext);
    this.createDatasetVersionOperationCallable =
        callableFactory.createOperationCallable(
            createDatasetVersionTransportSettings,
            settings.createDatasetVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDatasetVersionCallable =
        callableFactory.createUnaryCallable(
            updateDatasetVersionTransportSettings,
            settings.updateDatasetVersionSettings(),
            clientContext);
    this.deleteDatasetVersionCallable =
        callableFactory.createUnaryCallable(
            deleteDatasetVersionTransportSettings,
            settings.deleteDatasetVersionSettings(),
            clientContext);
    this.deleteDatasetVersionOperationCallable =
        callableFactory.createOperationCallable(
            deleteDatasetVersionTransportSettings,
            settings.deleteDatasetVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.getDatasetVersionCallable =
        callableFactory.createUnaryCallable(
            getDatasetVersionTransportSettings,
            settings.getDatasetVersionSettings(),
            clientContext);
    this.listDatasetVersionsCallable =
        callableFactory.createUnaryCallable(
            listDatasetVersionsTransportSettings,
            settings.listDatasetVersionsSettings(),
            clientContext);
    this.listDatasetVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listDatasetVersionsTransportSettings,
            settings.listDatasetVersionsSettings(),
            clientContext);
    this.restoreDatasetVersionCallable =
        callableFactory.createUnaryCallable(
            restoreDatasetVersionTransportSettings,
            settings.restoreDatasetVersionSettings(),
            clientContext);
    this.restoreDatasetVersionOperationCallable =
        callableFactory.createOperationCallable(
            restoreDatasetVersionTransportSettings,
            settings.restoreDatasetVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.listDataItemsCallable =
        callableFactory.createUnaryCallable(
            listDataItemsTransportSettings, settings.listDataItemsSettings(), clientContext);
    this.listDataItemsPagedCallable =
        callableFactory.createPagedCallable(
            listDataItemsTransportSettings, settings.listDataItemsSettings(), clientContext);
    this.searchDataItemsCallable =
        callableFactory.createUnaryCallable(
            searchDataItemsTransportSettings, settings.searchDataItemsSettings(), clientContext);
    this.searchDataItemsPagedCallable =
        callableFactory.createPagedCallable(
            searchDataItemsTransportSettings, settings.searchDataItemsSettings(), clientContext);
    this.listSavedQueriesCallable =
        callableFactory.createUnaryCallable(
            listSavedQueriesTransportSettings, settings.listSavedQueriesSettings(), clientContext);
    this.listSavedQueriesPagedCallable =
        callableFactory.createPagedCallable(
            listSavedQueriesTransportSettings, settings.listSavedQueriesSettings(), clientContext);
    this.deleteSavedQueryCallable =
        callableFactory.createUnaryCallable(
            deleteSavedQueryTransportSettings, settings.deleteSavedQuerySettings(), clientContext);
    this.deleteSavedQueryOperationCallable =
        callableFactory.createOperationCallable(
            deleteSavedQueryTransportSettings,
            settings.deleteSavedQueryOperationSettings(),
            clientContext,
            operationsStub);
    this.getAnnotationSpecCallable =
        callableFactory.createUnaryCallable(
            getAnnotationSpecTransportSettings,
            settings.getAnnotationSpecSettings(),
            clientContext);
    this.listAnnotationsCallable =
        callableFactory.createUnaryCallable(
            listAnnotationsTransportSettings, settings.listAnnotationsSettings(), clientContext);
    this.listAnnotationsPagedCallable =
        callableFactory.createPagedCallable(
            listAnnotationsTransportSettings, settings.listAnnotationsSettings(), clientContext);
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
  public UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable() {
    return createDatasetCallable;
  }

  @Override
  public OperationCallable<CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
      createDatasetOperationCallable() {
    return createDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    return getDatasetCallable;
  }

  @Override
  public UnaryCallable<UpdateDatasetRequest, Dataset> updateDatasetCallable() {
    return updateDatasetCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    return listDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    return listDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable() {
    return deleteDatasetCallable;
  }

  @Override
  public OperationCallable<DeleteDatasetRequest, Empty, DeleteOperationMetadata>
      deleteDatasetOperationCallable() {
    return deleteDatasetOperationCallable;
  }

  @Override
  public UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    return importDataCallable;
  }

  @Override
  public OperationCallable<ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
      importDataOperationCallable() {
    return importDataOperationCallable;
  }

  @Override
  public UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    return exportDataCallable;
  }

  @Override
  public OperationCallable<ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
      exportDataOperationCallable() {
    return exportDataOperationCallable;
  }

  @Override
  public UnaryCallable<CreateDatasetVersionRequest, Operation> createDatasetVersionCallable() {
    return createDatasetVersionCallable;
  }

  @Override
  public OperationCallable<
          CreateDatasetVersionRequest, DatasetVersion, CreateDatasetVersionOperationMetadata>
      createDatasetVersionOperationCallable() {
    return createDatasetVersionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDatasetVersionRequest, DatasetVersion> updateDatasetVersionCallable() {
    return updateDatasetVersionCallable;
  }

  @Override
  public UnaryCallable<DeleteDatasetVersionRequest, Operation> deleteDatasetVersionCallable() {
    return deleteDatasetVersionCallable;
  }

  @Override
  public OperationCallable<DeleteDatasetVersionRequest, Empty, DeleteOperationMetadata>
      deleteDatasetVersionOperationCallable() {
    return deleteDatasetVersionOperationCallable;
  }

  @Override
  public UnaryCallable<GetDatasetVersionRequest, DatasetVersion> getDatasetVersionCallable() {
    return getDatasetVersionCallable;
  }

  @Override
  public UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsResponse>
      listDatasetVersionsCallable() {
    return listDatasetVersionsCallable;
  }

  @Override
  public UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsPagedResponse>
      listDatasetVersionsPagedCallable() {
    return listDatasetVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<RestoreDatasetVersionRequest, Operation> restoreDatasetVersionCallable() {
    return restoreDatasetVersionCallable;
  }

  @Override
  public OperationCallable<
          RestoreDatasetVersionRequest, DatasetVersion, RestoreDatasetVersionOperationMetadata>
      restoreDatasetVersionOperationCallable() {
    return restoreDatasetVersionOperationCallable;
  }

  @Override
  public UnaryCallable<ListDataItemsRequest, ListDataItemsResponse> listDataItemsCallable() {
    return listDataItemsCallable;
  }

  @Override
  public UnaryCallable<ListDataItemsRequest, ListDataItemsPagedResponse>
      listDataItemsPagedCallable() {
    return listDataItemsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchDataItemsRequest, SearchDataItemsResponse> searchDataItemsCallable() {
    return searchDataItemsCallable;
  }

  @Override
  public UnaryCallable<SearchDataItemsRequest, SearchDataItemsPagedResponse>
      searchDataItemsPagedCallable() {
    return searchDataItemsPagedCallable;
  }

  @Override
  public UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesResponse>
      listSavedQueriesCallable() {
    return listSavedQueriesCallable;
  }

  @Override
  public UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesPagedResponse>
      listSavedQueriesPagedCallable() {
    return listSavedQueriesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSavedQueryRequest, Operation> deleteSavedQueryCallable() {
    return deleteSavedQueryCallable;
  }

  @Override
  public OperationCallable<DeleteSavedQueryRequest, Empty, DeleteOperationMetadata>
      deleteSavedQueryOperationCallable() {
    return deleteSavedQueryOperationCallable;
  }

  @Override
  public UnaryCallable<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecCallable() {
    return getAnnotationSpecCallable;
  }

  @Override
  public UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse> listAnnotationsCallable() {
    return listAnnotationsCallable;
  }

  @Override
  public UnaryCallable<ListAnnotationsRequest, ListAnnotationsPagedResponse>
      listAnnotationsPagedCallable() {
    return listAnnotationsPagedCallable;
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
