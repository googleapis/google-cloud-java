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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.ApiHubClient.ListApiOperationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListApisPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListAttributesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListDeploymentsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListExternalApisPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListSpecsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListVersionsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.SearchResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.Api;
import com.google.cloud.apihub.v1.ApiOperation;
import com.google.cloud.apihub.v1.Attribute;
import com.google.cloud.apihub.v1.CreateApiRequest;
import com.google.cloud.apihub.v1.CreateAttributeRequest;
import com.google.cloud.apihub.v1.CreateDeploymentRequest;
import com.google.cloud.apihub.v1.CreateExternalApiRequest;
import com.google.cloud.apihub.v1.CreateSpecRequest;
import com.google.cloud.apihub.v1.CreateVersionRequest;
import com.google.cloud.apihub.v1.Definition;
import com.google.cloud.apihub.v1.DeleteApiRequest;
import com.google.cloud.apihub.v1.DeleteAttributeRequest;
import com.google.cloud.apihub.v1.DeleteDeploymentRequest;
import com.google.cloud.apihub.v1.DeleteExternalApiRequest;
import com.google.cloud.apihub.v1.DeleteSpecRequest;
import com.google.cloud.apihub.v1.DeleteVersionRequest;
import com.google.cloud.apihub.v1.Deployment;
import com.google.cloud.apihub.v1.ExternalApi;
import com.google.cloud.apihub.v1.GetApiOperationRequest;
import com.google.cloud.apihub.v1.GetApiRequest;
import com.google.cloud.apihub.v1.GetAttributeRequest;
import com.google.cloud.apihub.v1.GetDefinitionRequest;
import com.google.cloud.apihub.v1.GetDeploymentRequest;
import com.google.cloud.apihub.v1.GetExternalApiRequest;
import com.google.cloud.apihub.v1.GetSpecContentsRequest;
import com.google.cloud.apihub.v1.GetSpecRequest;
import com.google.cloud.apihub.v1.GetVersionRequest;
import com.google.cloud.apihub.v1.ListApiOperationsRequest;
import com.google.cloud.apihub.v1.ListApiOperationsResponse;
import com.google.cloud.apihub.v1.ListApisRequest;
import com.google.cloud.apihub.v1.ListApisResponse;
import com.google.cloud.apihub.v1.ListAttributesRequest;
import com.google.cloud.apihub.v1.ListAttributesResponse;
import com.google.cloud.apihub.v1.ListDeploymentsRequest;
import com.google.cloud.apihub.v1.ListDeploymentsResponse;
import com.google.cloud.apihub.v1.ListExternalApisRequest;
import com.google.cloud.apihub.v1.ListExternalApisResponse;
import com.google.cloud.apihub.v1.ListSpecsRequest;
import com.google.cloud.apihub.v1.ListSpecsResponse;
import com.google.cloud.apihub.v1.ListVersionsRequest;
import com.google.cloud.apihub.v1.ListVersionsResponse;
import com.google.cloud.apihub.v1.SearchResourcesRequest;
import com.google.cloud.apihub.v1.SearchResourcesResponse;
import com.google.cloud.apihub.v1.Spec;
import com.google.cloud.apihub.v1.SpecContents;
import com.google.cloud.apihub.v1.UpdateApiRequest;
import com.google.cloud.apihub.v1.UpdateAttributeRequest;
import com.google.cloud.apihub.v1.UpdateDeploymentRequest;
import com.google.cloud.apihub.v1.UpdateExternalApiRequest;
import com.google.cloud.apihub.v1.UpdateSpecRequest;
import com.google.cloud.apihub.v1.UpdateVersionRequest;
import com.google.cloud.apihub.v1.Version;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ApiHub service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcApiHubStub extends ApiHubStub {
  private static final MethodDescriptor<CreateApiRequest, Api> createApiMethodDescriptor =
      MethodDescriptor.<CreateApiRequest, Api>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/CreateApi")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateApiRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Api.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetApiRequest, Api> getApiMethodDescriptor =
      MethodDescriptor.<GetApiRequest, Api>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetApi")
          .setRequestMarshaller(ProtoUtils.marshaller(GetApiRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Api.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListApisRequest, ListApisResponse>
      listApisMethodDescriptor =
          MethodDescriptor.<ListApisRequest, ListApisResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListApis")
              .setRequestMarshaller(ProtoUtils.marshaller(ListApisRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListApisResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateApiRequest, Api> updateApiMethodDescriptor =
      MethodDescriptor.<UpdateApiRequest, Api>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/UpdateApi")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateApiRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Api.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteApiRequest, Empty> deleteApiMethodDescriptor =
      MethodDescriptor.<DeleteApiRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/DeleteApi")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteApiRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateVersionRequest, Version>
      createVersionMethodDescriptor =
          MethodDescriptor.<CreateVersionRequest, Version>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/CreateVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Version.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVersionRequest, Version> getVersionMethodDescriptor =
      MethodDescriptor.<GetVersionRequest, Version>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetVersion")
          .setRequestMarshaller(ProtoUtils.marshaller(GetVersionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Version.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListVersionsRequest, ListVersionsResponse>
      listVersionsMethodDescriptor =
          MethodDescriptor.<ListVersionsRequest, ListVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListVersions")
              .setRequestMarshaller(ProtoUtils.marshaller(ListVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateVersionRequest, Version>
      updateVersionMethodDescriptor =
          MethodDescriptor.<UpdateVersionRequest, Version>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/UpdateVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Version.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteVersionRequest, Empty> deleteVersionMethodDescriptor =
      MethodDescriptor.<DeleteVersionRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/DeleteVersion")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteVersionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSpecRequest, Spec> createSpecMethodDescriptor =
      MethodDescriptor.<CreateSpecRequest, Spec>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/CreateSpec")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSpecRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Spec.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetSpecRequest, Spec> getSpecMethodDescriptor =
      MethodDescriptor.<GetSpecRequest, Spec>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetSpec")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSpecRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Spec.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetSpecContentsRequest, SpecContents>
      getSpecContentsMethodDescriptor =
          MethodDescriptor.<GetSpecContentsRequest, SpecContents>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetSpecContents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSpecContentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SpecContents.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSpecsRequest, ListSpecsResponse>
      listSpecsMethodDescriptor =
          MethodDescriptor.<ListSpecsRequest, ListSpecsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListSpecs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSpecsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSpecsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSpecRequest, Spec> updateSpecMethodDescriptor =
      MethodDescriptor.<UpdateSpecRequest, Spec>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/UpdateSpec")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSpecRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Spec.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteSpecRequest, Empty> deleteSpecMethodDescriptor =
      MethodDescriptor.<DeleteSpecRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apihub.v1.ApiHub/DeleteSpec")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSpecRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetApiOperationRequest, ApiOperation>
      getApiOperationMethodDescriptor =
          MethodDescriptor.<GetApiOperationRequest, ApiOperation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetApiOperation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetApiOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiOperation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListApiOperationsRequest, ListApiOperationsResponse>
      listApiOperationsMethodDescriptor =
          MethodDescriptor.<ListApiOperationsRequest, ListApiOperationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListApiOperations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListApiOperationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApiOperationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDefinitionRequest, Definition>
      getDefinitionMethodDescriptor =
          MethodDescriptor.<GetDefinitionRequest, Definition>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetDefinition")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDefinitionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Definition.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDeploymentRequest, Deployment>
      createDeploymentMethodDescriptor =
          MethodDescriptor.<CreateDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/CreateDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDeploymentRequest, Deployment>
      getDeploymentMethodDescriptor =
          MethodDescriptor.<GetDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsMethodDescriptor =
          MethodDescriptor.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeploymentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDeploymentRequest, Deployment>
      updateDeploymentMethodDescriptor =
          MethodDescriptor.<UpdateDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/UpdateDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDeploymentRequest, Empty>
      deleteDeploymentMethodDescriptor =
          MethodDescriptor.<DeleteDeploymentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/DeleteDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAttributeRequest, Attribute>
      createAttributeMethodDescriptor =
          MethodDescriptor.<CreateAttributeRequest, Attribute>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/CreateAttribute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Attribute.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAttributeRequest, Attribute>
      getAttributeMethodDescriptor =
          MethodDescriptor.<GetAttributeRequest, Attribute>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetAttribute")
              .setRequestMarshaller(ProtoUtils.marshaller(GetAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Attribute.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAttributeRequest, Attribute>
      updateAttributeMethodDescriptor =
          MethodDescriptor.<UpdateAttributeRequest, Attribute>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/UpdateAttribute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Attribute.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAttributeRequest, Empty>
      deleteAttributeMethodDescriptor =
          MethodDescriptor.<DeleteAttributeRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/DeleteAttribute")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAttributesRequest, ListAttributesResponse>
      listAttributesMethodDescriptor =
          MethodDescriptor.<ListAttributesRequest, ListAttributesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListAttributes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAttributesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAttributesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchResourcesRequest, SearchResourcesResponse>
      searchResourcesMethodDescriptor =
          MethodDescriptor.<SearchResourcesRequest, SearchResourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/SearchResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchResourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateExternalApiRequest, ExternalApi>
      createExternalApiMethodDescriptor =
          MethodDescriptor.<CreateExternalApiRequest, ExternalApi>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/CreateExternalApi")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExternalApiRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExternalApi.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetExternalApiRequest, ExternalApi>
      getExternalApiMethodDescriptor =
          MethodDescriptor.<GetExternalApiRequest, ExternalApi>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/GetExternalApi")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetExternalApiRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExternalApi.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateExternalApiRequest, ExternalApi>
      updateExternalApiMethodDescriptor =
          MethodDescriptor.<UpdateExternalApiRequest, ExternalApi>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/UpdateExternalApi")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExternalApiRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExternalApi.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteExternalApiRequest, Empty>
      deleteExternalApiMethodDescriptor =
          MethodDescriptor.<DeleteExternalApiRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/DeleteExternalApi")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExternalApiRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListExternalApisRequest, ListExternalApisResponse>
      listExternalApisMethodDescriptor =
          MethodDescriptor.<ListExternalApisRequest, ListExternalApisResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apihub.v1.ApiHub/ListExternalApis")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExternalApisRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExternalApisResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateApiRequest, Api> createApiCallable;
  private final UnaryCallable<GetApiRequest, Api> getApiCallable;
  private final UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable;
  private final UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable;
  private final UnaryCallable<UpdateApiRequest, Api> updateApiCallable;
  private final UnaryCallable<DeleteApiRequest, Empty> deleteApiCallable;
  private final UnaryCallable<CreateVersionRequest, Version> createVersionCallable;
  private final UnaryCallable<GetVersionRequest, Version> getVersionCallable;
  private final UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable;
  private final UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse>
      listVersionsPagedCallable;
  private final UnaryCallable<UpdateVersionRequest, Version> updateVersionCallable;
  private final UnaryCallable<DeleteVersionRequest, Empty> deleteVersionCallable;
  private final UnaryCallable<CreateSpecRequest, Spec> createSpecCallable;
  private final UnaryCallable<GetSpecRequest, Spec> getSpecCallable;
  private final UnaryCallable<GetSpecContentsRequest, SpecContents> getSpecContentsCallable;
  private final UnaryCallable<ListSpecsRequest, ListSpecsResponse> listSpecsCallable;
  private final UnaryCallable<ListSpecsRequest, ListSpecsPagedResponse> listSpecsPagedCallable;
  private final UnaryCallable<UpdateSpecRequest, Spec> updateSpecCallable;
  private final UnaryCallable<DeleteSpecRequest, Empty> deleteSpecCallable;
  private final UnaryCallable<GetApiOperationRequest, ApiOperation> getApiOperationCallable;
  private final UnaryCallable<ListApiOperationsRequest, ListApiOperationsResponse>
      listApiOperationsCallable;
  private final UnaryCallable<ListApiOperationsRequest, ListApiOperationsPagedResponse>
      listApiOperationsPagedCallable;
  private final UnaryCallable<GetDefinitionRequest, Definition> getDefinitionCallable;
  private final UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable;
  private final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable;
  private final UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable;
  private final UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable;
  private final UnaryCallable<CreateAttributeRequest, Attribute> createAttributeCallable;
  private final UnaryCallable<GetAttributeRequest, Attribute> getAttributeCallable;
  private final UnaryCallable<UpdateAttributeRequest, Attribute> updateAttributeCallable;
  private final UnaryCallable<DeleteAttributeRequest, Empty> deleteAttributeCallable;
  private final UnaryCallable<ListAttributesRequest, ListAttributesResponse> listAttributesCallable;
  private final UnaryCallable<ListAttributesRequest, ListAttributesPagedResponse>
      listAttributesPagedCallable;
  private final UnaryCallable<SearchResourcesRequest, SearchResourcesResponse>
      searchResourcesCallable;
  private final UnaryCallable<SearchResourcesRequest, SearchResourcesPagedResponse>
      searchResourcesPagedCallable;
  private final UnaryCallable<CreateExternalApiRequest, ExternalApi> createExternalApiCallable;
  private final UnaryCallable<GetExternalApiRequest, ExternalApi> getExternalApiCallable;
  private final UnaryCallable<UpdateExternalApiRequest, ExternalApi> updateExternalApiCallable;
  private final UnaryCallable<DeleteExternalApiRequest, Empty> deleteExternalApiCallable;
  private final UnaryCallable<ListExternalApisRequest, ListExternalApisResponse>
      listExternalApisCallable;
  private final UnaryCallable<ListExternalApisRequest, ListExternalApisPagedResponse>
      listExternalApisPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcApiHubStub create(ApiHubStubSettings settings) throws IOException {
    return new GrpcApiHubStub(settings, ClientContext.create(settings));
  }

  public static final GrpcApiHubStub create(ClientContext clientContext) throws IOException {
    return new GrpcApiHubStub(ApiHubStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcApiHubStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcApiHubStub(
        ApiHubStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcApiHubStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcApiHubStub(ApiHubStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcApiHubCallableFactory());
  }

  /**
   * Constructs an instance of GrpcApiHubStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcApiHubStub(
      ApiHubStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateApiRequest, Api> createApiTransportSettings =
        GrpcCallSettings.<CreateApiRequest, Api>newBuilder()
            .setMethodDescriptor(createApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetApiRequest, Api> getApiTransportSettings =
        GrpcCallSettings.<GetApiRequest, Api>newBuilder()
            .setMethodDescriptor(getApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListApisRequest, ListApisResponse> listApisTransportSettings =
        GrpcCallSettings.<ListApisRequest, ListApisResponse>newBuilder()
            .setMethodDescriptor(listApisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateApiRequest, Api> updateApiTransportSettings =
        GrpcCallSettings.<UpdateApiRequest, Api>newBuilder()
            .setMethodDescriptor(updateApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("api.name", String.valueOf(request.getApi().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteApiRequest, Empty> deleteApiTransportSettings =
        GrpcCallSettings.<DeleteApiRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateVersionRequest, Version> createVersionTransportSettings =
        GrpcCallSettings.<CreateVersionRequest, Version>newBuilder()
            .setMethodDescriptor(createVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetVersionRequest, Version> getVersionTransportSettings =
        GrpcCallSettings.<GetVersionRequest, Version>newBuilder()
            .setMethodDescriptor(getVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListVersionsRequest, ListVersionsResponse> listVersionsTransportSettings =
        GrpcCallSettings.<ListVersionsRequest, ListVersionsResponse>newBuilder()
            .setMethodDescriptor(listVersionsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateVersionRequest, Version> updateVersionTransportSettings =
        GrpcCallSettings.<UpdateVersionRequest, Version>newBuilder()
            .setMethodDescriptor(updateVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("version.name", String.valueOf(request.getVersion().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteVersionRequest, Empty> deleteVersionTransportSettings =
        GrpcCallSettings.<DeleteVersionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSpecRequest, Spec> createSpecTransportSettings =
        GrpcCallSettings.<CreateSpecRequest, Spec>newBuilder()
            .setMethodDescriptor(createSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSpecRequest, Spec> getSpecTransportSettings =
        GrpcCallSettings.<GetSpecRequest, Spec>newBuilder()
            .setMethodDescriptor(getSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSpecContentsRequest, SpecContents> getSpecContentsTransportSettings =
        GrpcCallSettings.<GetSpecContentsRequest, SpecContents>newBuilder()
            .setMethodDescriptor(getSpecContentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSpecsRequest, ListSpecsResponse> listSpecsTransportSettings =
        GrpcCallSettings.<ListSpecsRequest, ListSpecsResponse>newBuilder()
            .setMethodDescriptor(listSpecsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSpecRequest, Spec> updateSpecTransportSettings =
        GrpcCallSettings.<UpdateSpecRequest, Spec>newBuilder()
            .setMethodDescriptor(updateSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("spec.name", String.valueOf(request.getSpec().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSpecRequest, Empty> deleteSpecTransportSettings =
        GrpcCallSettings.<DeleteSpecRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetApiOperationRequest, ApiOperation> getApiOperationTransportSettings =
        GrpcCallSettings.<GetApiOperationRequest, ApiOperation>newBuilder()
            .setMethodDescriptor(getApiOperationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListApiOperationsRequest, ListApiOperationsResponse>
        listApiOperationsTransportSettings =
            GrpcCallSettings.<ListApiOperationsRequest, ListApiOperationsResponse>newBuilder()
                .setMethodDescriptor(listApiOperationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDefinitionRequest, Definition> getDefinitionTransportSettings =
        GrpcCallSettings.<GetDefinitionRequest, Definition>newBuilder()
            .setMethodDescriptor(getDefinitionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDeploymentRequest, Deployment> createDeploymentTransportSettings =
        GrpcCallSettings.<CreateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(createDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDeploymentRequest, Deployment> getDeploymentTransportSettings =
        GrpcCallSettings.<GetDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(getDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDeploymentsRequest, ListDeploymentsResponse>
        listDeploymentsTransportSettings =
            GrpcCallSettings.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentTransportSettings =
        GrpcCallSettings.<UpdateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(updateDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("deployment.name", String.valueOf(request.getDeployment().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentTransportSettings =
        GrpcCallSettings.<DeleteDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAttributeRequest, Attribute> createAttributeTransportSettings =
        GrpcCallSettings.<CreateAttributeRequest, Attribute>newBuilder()
            .setMethodDescriptor(createAttributeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAttributeRequest, Attribute> getAttributeTransportSettings =
        GrpcCallSettings.<GetAttributeRequest, Attribute>newBuilder()
            .setMethodDescriptor(getAttributeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAttributeRequest, Attribute> updateAttributeTransportSettings =
        GrpcCallSettings.<UpdateAttributeRequest, Attribute>newBuilder()
            .setMethodDescriptor(updateAttributeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("attribute.name", String.valueOf(request.getAttribute().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAttributeRequest, Empty> deleteAttributeTransportSettings =
        GrpcCallSettings.<DeleteAttributeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAttributeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAttributesRequest, ListAttributesResponse>
        listAttributesTransportSettings =
            GrpcCallSettings.<ListAttributesRequest, ListAttributesResponse>newBuilder()
                .setMethodDescriptor(listAttributesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchResourcesRequest, SearchResourcesResponse>
        searchResourcesTransportSettings =
            GrpcCallSettings.<SearchResourcesRequest, SearchResourcesResponse>newBuilder()
                .setMethodDescriptor(searchResourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("location", String.valueOf(request.getLocation()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateExternalApiRequest, ExternalApi> createExternalApiTransportSettings =
        GrpcCallSettings.<CreateExternalApiRequest, ExternalApi>newBuilder()
            .setMethodDescriptor(createExternalApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetExternalApiRequest, ExternalApi> getExternalApiTransportSettings =
        GrpcCallSettings.<GetExternalApiRequest, ExternalApi>newBuilder()
            .setMethodDescriptor(getExternalApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateExternalApiRequest, ExternalApi> updateExternalApiTransportSettings =
        GrpcCallSettings.<UpdateExternalApiRequest, ExternalApi>newBuilder()
            .setMethodDescriptor(updateExternalApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "external_api.name", String.valueOf(request.getExternalApi().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteExternalApiRequest, Empty> deleteExternalApiTransportSettings =
        GrpcCallSettings.<DeleteExternalApiRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteExternalApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListExternalApisRequest, ListExternalApisResponse>
        listExternalApisTransportSettings =
            GrpcCallSettings.<ListExternalApisRequest, ListExternalApisResponse>newBuilder()
                .setMethodDescriptor(listExternalApisMethodDescriptor)
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

    this.createApiCallable =
        callableFactory.createUnaryCallable(
            createApiTransportSettings, settings.createApiSettings(), clientContext);
    this.getApiCallable =
        callableFactory.createUnaryCallable(
            getApiTransportSettings, settings.getApiSettings(), clientContext);
    this.listApisCallable =
        callableFactory.createUnaryCallable(
            listApisTransportSettings, settings.listApisSettings(), clientContext);
    this.listApisPagedCallable =
        callableFactory.createPagedCallable(
            listApisTransportSettings, settings.listApisSettings(), clientContext);
    this.updateApiCallable =
        callableFactory.createUnaryCallable(
            updateApiTransportSettings, settings.updateApiSettings(), clientContext);
    this.deleteApiCallable =
        callableFactory.createUnaryCallable(
            deleteApiTransportSettings, settings.deleteApiSettings(), clientContext);
    this.createVersionCallable =
        callableFactory.createUnaryCallable(
            createVersionTransportSettings, settings.createVersionSettings(), clientContext);
    this.getVersionCallable =
        callableFactory.createUnaryCallable(
            getVersionTransportSettings, settings.getVersionSettings(), clientContext);
    this.listVersionsCallable =
        callableFactory.createUnaryCallable(
            listVersionsTransportSettings, settings.listVersionsSettings(), clientContext);
    this.listVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listVersionsTransportSettings, settings.listVersionsSettings(), clientContext);
    this.updateVersionCallable =
        callableFactory.createUnaryCallable(
            updateVersionTransportSettings, settings.updateVersionSettings(), clientContext);
    this.deleteVersionCallable =
        callableFactory.createUnaryCallable(
            deleteVersionTransportSettings, settings.deleteVersionSettings(), clientContext);
    this.createSpecCallable =
        callableFactory.createUnaryCallable(
            createSpecTransportSettings, settings.createSpecSettings(), clientContext);
    this.getSpecCallable =
        callableFactory.createUnaryCallable(
            getSpecTransportSettings, settings.getSpecSettings(), clientContext);
    this.getSpecContentsCallable =
        callableFactory.createUnaryCallable(
            getSpecContentsTransportSettings, settings.getSpecContentsSettings(), clientContext);
    this.listSpecsCallable =
        callableFactory.createUnaryCallable(
            listSpecsTransportSettings, settings.listSpecsSettings(), clientContext);
    this.listSpecsPagedCallable =
        callableFactory.createPagedCallable(
            listSpecsTransportSettings, settings.listSpecsSettings(), clientContext);
    this.updateSpecCallable =
        callableFactory.createUnaryCallable(
            updateSpecTransportSettings, settings.updateSpecSettings(), clientContext);
    this.deleteSpecCallable =
        callableFactory.createUnaryCallable(
            deleteSpecTransportSettings, settings.deleteSpecSettings(), clientContext);
    this.getApiOperationCallable =
        callableFactory.createUnaryCallable(
            getApiOperationTransportSettings, settings.getApiOperationSettings(), clientContext);
    this.listApiOperationsCallable =
        callableFactory.createUnaryCallable(
            listApiOperationsTransportSettings,
            settings.listApiOperationsSettings(),
            clientContext);
    this.listApiOperationsPagedCallable =
        callableFactory.createPagedCallable(
            listApiOperationsTransportSettings,
            settings.listApiOperationsSettings(),
            clientContext);
    this.getDefinitionCallable =
        callableFactory.createUnaryCallable(
            getDefinitionTransportSettings, settings.getDefinitionSettings(), clientContext);
    this.createDeploymentCallable =
        callableFactory.createUnaryCallable(
            createDeploymentTransportSettings, settings.createDeploymentSettings(), clientContext);
    this.getDeploymentCallable =
        callableFactory.createUnaryCallable(
            getDeploymentTransportSettings, settings.getDeploymentSettings(), clientContext);
    this.listDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.listDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.updateDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateDeploymentTransportSettings, settings.updateDeploymentSettings(), clientContext);
    this.deleteDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteDeploymentTransportSettings, settings.deleteDeploymentSettings(), clientContext);
    this.createAttributeCallable =
        callableFactory.createUnaryCallable(
            createAttributeTransportSettings, settings.createAttributeSettings(), clientContext);
    this.getAttributeCallable =
        callableFactory.createUnaryCallable(
            getAttributeTransportSettings, settings.getAttributeSettings(), clientContext);
    this.updateAttributeCallable =
        callableFactory.createUnaryCallable(
            updateAttributeTransportSettings, settings.updateAttributeSettings(), clientContext);
    this.deleteAttributeCallable =
        callableFactory.createUnaryCallable(
            deleteAttributeTransportSettings, settings.deleteAttributeSettings(), clientContext);
    this.listAttributesCallable =
        callableFactory.createUnaryCallable(
            listAttributesTransportSettings, settings.listAttributesSettings(), clientContext);
    this.listAttributesPagedCallable =
        callableFactory.createPagedCallable(
            listAttributesTransportSettings, settings.listAttributesSettings(), clientContext);
    this.searchResourcesCallable =
        callableFactory.createUnaryCallable(
            searchResourcesTransportSettings, settings.searchResourcesSettings(), clientContext);
    this.searchResourcesPagedCallable =
        callableFactory.createPagedCallable(
            searchResourcesTransportSettings, settings.searchResourcesSettings(), clientContext);
    this.createExternalApiCallable =
        callableFactory.createUnaryCallable(
            createExternalApiTransportSettings,
            settings.createExternalApiSettings(),
            clientContext);
    this.getExternalApiCallable =
        callableFactory.createUnaryCallable(
            getExternalApiTransportSettings, settings.getExternalApiSettings(), clientContext);
    this.updateExternalApiCallable =
        callableFactory.createUnaryCallable(
            updateExternalApiTransportSettings,
            settings.updateExternalApiSettings(),
            clientContext);
    this.deleteExternalApiCallable =
        callableFactory.createUnaryCallable(
            deleteExternalApiTransportSettings,
            settings.deleteExternalApiSettings(),
            clientContext);
    this.listExternalApisCallable =
        callableFactory.createUnaryCallable(
            listExternalApisTransportSettings, settings.listExternalApisSettings(), clientContext);
    this.listExternalApisPagedCallable =
        callableFactory.createPagedCallable(
            listExternalApisTransportSettings, settings.listExternalApisSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateApiRequest, Api> createApiCallable() {
    return createApiCallable;
  }

  @Override
  public UnaryCallable<GetApiRequest, Api> getApiCallable() {
    return getApiCallable;
  }

  @Override
  public UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable() {
    return listApisCallable;
  }

  @Override
  public UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable() {
    return listApisPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateApiRequest, Api> updateApiCallable() {
    return updateApiCallable;
  }

  @Override
  public UnaryCallable<DeleteApiRequest, Empty> deleteApiCallable() {
    return deleteApiCallable;
  }

  @Override
  public UnaryCallable<CreateVersionRequest, Version> createVersionCallable() {
    return createVersionCallable;
  }

  @Override
  public UnaryCallable<GetVersionRequest, Version> getVersionCallable() {
    return getVersionCallable;
  }

  @Override
  public UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable() {
    return listVersionsCallable;
  }

  @Override
  public UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse> listVersionsPagedCallable() {
    return listVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateVersionRequest, Version> updateVersionCallable() {
    return updateVersionCallable;
  }

  @Override
  public UnaryCallable<DeleteVersionRequest, Empty> deleteVersionCallable() {
    return deleteVersionCallable;
  }

  @Override
  public UnaryCallable<CreateSpecRequest, Spec> createSpecCallable() {
    return createSpecCallable;
  }

  @Override
  public UnaryCallable<GetSpecRequest, Spec> getSpecCallable() {
    return getSpecCallable;
  }

  @Override
  public UnaryCallable<GetSpecContentsRequest, SpecContents> getSpecContentsCallable() {
    return getSpecContentsCallable;
  }

  @Override
  public UnaryCallable<ListSpecsRequest, ListSpecsResponse> listSpecsCallable() {
    return listSpecsCallable;
  }

  @Override
  public UnaryCallable<ListSpecsRequest, ListSpecsPagedResponse> listSpecsPagedCallable() {
    return listSpecsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateSpecRequest, Spec> updateSpecCallable() {
    return updateSpecCallable;
  }

  @Override
  public UnaryCallable<DeleteSpecRequest, Empty> deleteSpecCallable() {
    return deleteSpecCallable;
  }

  @Override
  public UnaryCallable<GetApiOperationRequest, ApiOperation> getApiOperationCallable() {
    return getApiOperationCallable;
  }

  @Override
  public UnaryCallable<ListApiOperationsRequest, ListApiOperationsResponse>
      listApiOperationsCallable() {
    return listApiOperationsCallable;
  }

  @Override
  public UnaryCallable<ListApiOperationsRequest, ListApiOperationsPagedResponse>
      listApiOperationsPagedCallable() {
    return listApiOperationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDefinitionRequest, Definition> getDefinitionCallable() {
    return getDefinitionCallable;
  }

  @Override
  public UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    return createDeploymentCallable;
  }

  @Override
  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return getDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    return listDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return listDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable() {
    return updateDeploymentCallable;
  }

  @Override
  public UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable() {
    return deleteDeploymentCallable;
  }

  @Override
  public UnaryCallable<CreateAttributeRequest, Attribute> createAttributeCallable() {
    return createAttributeCallable;
  }

  @Override
  public UnaryCallable<GetAttributeRequest, Attribute> getAttributeCallable() {
    return getAttributeCallable;
  }

  @Override
  public UnaryCallable<UpdateAttributeRequest, Attribute> updateAttributeCallable() {
    return updateAttributeCallable;
  }

  @Override
  public UnaryCallable<DeleteAttributeRequest, Empty> deleteAttributeCallable() {
    return deleteAttributeCallable;
  }

  @Override
  public UnaryCallable<ListAttributesRequest, ListAttributesResponse> listAttributesCallable() {
    return listAttributesCallable;
  }

  @Override
  public UnaryCallable<ListAttributesRequest, ListAttributesPagedResponse>
      listAttributesPagedCallable() {
    return listAttributesPagedCallable;
  }

  @Override
  public UnaryCallable<SearchResourcesRequest, SearchResourcesResponse> searchResourcesCallable() {
    return searchResourcesCallable;
  }

  @Override
  public UnaryCallable<SearchResourcesRequest, SearchResourcesPagedResponse>
      searchResourcesPagedCallable() {
    return searchResourcesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateExternalApiRequest, ExternalApi> createExternalApiCallable() {
    return createExternalApiCallable;
  }

  @Override
  public UnaryCallable<GetExternalApiRequest, ExternalApi> getExternalApiCallable() {
    return getExternalApiCallable;
  }

  @Override
  public UnaryCallable<UpdateExternalApiRequest, ExternalApi> updateExternalApiCallable() {
    return updateExternalApiCallable;
  }

  @Override
  public UnaryCallable<DeleteExternalApiRequest, Empty> deleteExternalApiCallable() {
    return deleteExternalApiCallable;
  }

  @Override
  public UnaryCallable<ListExternalApisRequest, ListExternalApisResponse>
      listExternalApisCallable() {
    return listExternalApisCallable;
  }

  @Override
  public UnaryCallable<ListExternalApisRequest, ListExternalApisPagedResponse>
      listExternalApisPagedCallable() {
    return listExternalApisPagedCallable;
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
