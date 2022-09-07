/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.apigeeregistry.v1.stub;

import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiDeploymentRevisionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiDeploymentsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiSpecRevisionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiSpecsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiVersionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApisPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListArtifactsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListLocationsPagedResponse;

import com.google.api.HttpBody;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apigeeregistry.v1.Api;
import com.google.cloud.apigeeregistry.v1.ApiDeployment;
import com.google.cloud.apigeeregistry.v1.ApiSpec;
import com.google.cloud.apigeeregistry.v1.ApiVersion;
import com.google.cloud.apigeeregistry.v1.Artifact;
import com.google.cloud.apigeeregistry.v1.CreateApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.CreateApiRequest;
import com.google.cloud.apigeeregistry.v1.CreateApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.CreateApiVersionRequest;
import com.google.cloud.apigeeregistry.v1.CreateArtifactRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiDeploymentRevisionRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiSpecRevisionRequest;
import com.google.cloud.apigeeregistry.v1.DeleteApiVersionRequest;
import com.google.cloud.apigeeregistry.v1.DeleteArtifactRequest;
import com.google.cloud.apigeeregistry.v1.GetApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.GetApiRequest;
import com.google.cloud.apigeeregistry.v1.GetApiSpecContentsRequest;
import com.google.cloud.apigeeregistry.v1.GetApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.GetApiVersionRequest;
import com.google.cloud.apigeeregistry.v1.GetArtifactContentsRequest;
import com.google.cloud.apigeeregistry.v1.GetArtifactRequest;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentRevisionsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiDeploymentsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiSpecRevisionsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiSpecsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiSpecsResponse;
import com.google.cloud.apigeeregistry.v1.ListApiVersionsRequest;
import com.google.cloud.apigeeregistry.v1.ListApiVersionsResponse;
import com.google.cloud.apigeeregistry.v1.ListApisRequest;
import com.google.cloud.apigeeregistry.v1.ListApisResponse;
import com.google.cloud.apigeeregistry.v1.ListArtifactsRequest;
import com.google.cloud.apigeeregistry.v1.ListArtifactsResponse;
import com.google.cloud.apigeeregistry.v1.ReplaceArtifactRequest;
import com.google.cloud.apigeeregistry.v1.RollbackApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.RollbackApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.TagApiDeploymentRevisionRequest;
import com.google.cloud.apigeeregistry.v1.TagApiSpecRevisionRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiDeploymentRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiSpecRequest;
import com.google.cloud.apigeeregistry.v1.UpdateApiVersionRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Registry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcRegistryStub extends RegistryStub {
  private static final MethodDescriptor<ListApisRequest, ListApisResponse>
      listApisMethodDescriptor =
          MethodDescriptor.<ListApisRequest, ListApisResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ListApis")
              .setRequestMarshaller(ProtoUtils.marshaller(ListApisRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListApisResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetApiRequest, Api> getApiMethodDescriptor =
      MethodDescriptor.<GetApiRequest, Api>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetApi")
          .setRequestMarshaller(ProtoUtils.marshaller(GetApiRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Api.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateApiRequest, Api> createApiMethodDescriptor =
      MethodDescriptor.<CreateApiRequest, Api>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/CreateApi")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateApiRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Api.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateApiRequest, Api> updateApiMethodDescriptor =
      MethodDescriptor.<UpdateApiRequest, Api>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/UpdateApi")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateApiRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Api.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteApiRequest, Empty> deleteApiMethodDescriptor =
      MethodDescriptor.<DeleteApiRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/DeleteApi")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteApiRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListApiVersionsRequest, ListApiVersionsResponse>
      listApiVersionsMethodDescriptor =
          MethodDescriptor.<ListApiVersionsRequest, ListApiVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ListApiVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListApiVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApiVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetApiVersionRequest, ApiVersion>
      getApiVersionMethodDescriptor =
          MethodDescriptor.<GetApiVersionRequest, ApiVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetApiVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetApiVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateApiVersionRequest, ApiVersion>
      createApiVersionMethodDescriptor =
          MethodDescriptor.<CreateApiVersionRequest, ApiVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/CreateApiVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateApiVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateApiVersionRequest, ApiVersion>
      updateApiVersionMethodDescriptor =
          MethodDescriptor.<UpdateApiVersionRequest, ApiVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/UpdateApiVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateApiVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteApiVersionRequest, Empty>
      deleteApiVersionMethodDescriptor =
          MethodDescriptor.<DeleteApiVersionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/DeleteApiVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteApiVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListApiSpecsRequest, ListApiSpecsResponse>
      listApiSpecsMethodDescriptor =
          MethodDescriptor.<ListApiSpecsRequest, ListApiSpecsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ListApiSpecs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListApiSpecsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApiSpecsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetApiSpecRequest, ApiSpec> getApiSpecMethodDescriptor =
      MethodDescriptor.<GetApiSpecRequest, ApiSpec>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetApiSpec")
          .setRequestMarshaller(ProtoUtils.marshaller(GetApiSpecRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ApiSpec.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetApiSpecContentsRequest, HttpBody>
      getApiSpecContentsMethodDescriptor =
          MethodDescriptor.<GetApiSpecContentsRequest, HttpBody>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetApiSpecContents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetApiSpecContentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateApiSpecRequest, ApiSpec>
      createApiSpecMethodDescriptor =
          MethodDescriptor.<CreateApiSpecRequest, ApiSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/CreateApiSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateApiSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiSpec.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateApiSpecRequest, ApiSpec>
      updateApiSpecMethodDescriptor =
          MethodDescriptor.<UpdateApiSpecRequest, ApiSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/UpdateApiSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateApiSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiSpec.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteApiSpecRequest, Empty> deleteApiSpecMethodDescriptor =
      MethodDescriptor.<DeleteApiSpecRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/DeleteApiSpec")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteApiSpecRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TagApiSpecRevisionRequest, ApiSpec>
      tagApiSpecRevisionMethodDescriptor =
          MethodDescriptor.<TagApiSpecRevisionRequest, ApiSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/TagApiSpecRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TagApiSpecRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiSpec.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>
      listApiSpecRevisionsMethodDescriptor =
          MethodDescriptor.<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ListApiSpecRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListApiSpecRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApiSpecRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RollbackApiSpecRequest, ApiSpec>
      rollbackApiSpecMethodDescriptor =
          MethodDescriptor.<RollbackApiSpecRequest, ApiSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/RollbackApiSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RollbackApiSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiSpec.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteApiSpecRevisionRequest, ApiSpec>
      deleteApiSpecRevisionMethodDescriptor =
          MethodDescriptor.<DeleteApiSpecRevisionRequest, ApiSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/DeleteApiSpecRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteApiSpecRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiSpec.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListApiDeploymentsRequest, ListApiDeploymentsResponse>
      listApiDeploymentsMethodDescriptor =
          MethodDescriptor.<ListApiDeploymentsRequest, ListApiDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ListApiDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListApiDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApiDeploymentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetApiDeploymentRequest, ApiDeployment>
      getApiDeploymentMethodDescriptor =
          MethodDescriptor.<GetApiDeploymentRequest, ApiDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetApiDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetApiDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateApiDeploymentRequest, ApiDeployment>
      createApiDeploymentMethodDescriptor =
          MethodDescriptor.<CreateApiDeploymentRequest, ApiDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/CreateApiDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateApiDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateApiDeploymentRequest, ApiDeployment>
      updateApiDeploymentMethodDescriptor =
          MethodDescriptor.<UpdateApiDeploymentRequest, ApiDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/UpdateApiDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateApiDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteApiDeploymentRequest, Empty>
      deleteApiDeploymentMethodDescriptor =
          MethodDescriptor.<DeleteApiDeploymentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/DeleteApiDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteApiDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TagApiDeploymentRevisionRequest, ApiDeployment>
      tagApiDeploymentRevisionMethodDescriptor =
          MethodDescriptor.<TagApiDeploymentRevisionRequest, ApiDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/TagApiDeploymentRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TagApiDeploymentRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>
      listApiDeploymentRevisionsMethodDescriptor =
          MethodDescriptor
              .<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.apigeeregistry.v1.Registry/ListApiDeploymentRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListApiDeploymentRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListApiDeploymentRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RollbackApiDeploymentRequest, ApiDeployment>
      rollbackApiDeploymentMethodDescriptor =
          MethodDescriptor.<RollbackApiDeploymentRequest, ApiDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/RollbackApiDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RollbackApiDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteApiDeploymentRevisionRequest, ApiDeployment>
      deleteApiDeploymentRevisionMethodDescriptor =
          MethodDescriptor.<DeleteApiDeploymentRevisionRequest, ApiDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.apigeeregistry.v1.Registry/DeleteApiDeploymentRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteApiDeploymentRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ApiDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListArtifactsRequest, ListArtifactsResponse>
      listArtifactsMethodDescriptor =
          MethodDescriptor.<ListArtifactsRequest, ListArtifactsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ListArtifacts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListArtifactsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListArtifactsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetArtifactRequest, Artifact> getArtifactMethodDescriptor =
      MethodDescriptor.<GetArtifactRequest, Artifact>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetArtifact")
          .setRequestMarshaller(ProtoUtils.marshaller(GetArtifactRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Artifact.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetArtifactContentsRequest, HttpBody>
      getArtifactContentsMethodDescriptor =
          MethodDescriptor.<GetArtifactContentsRequest, HttpBody>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/GetArtifactContents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetArtifactContentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateArtifactRequest, Artifact>
      createArtifactMethodDescriptor =
          MethodDescriptor.<CreateArtifactRequest, Artifact>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/CreateArtifact")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateArtifactRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Artifact.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReplaceArtifactRequest, Artifact>
      replaceArtifactMethodDescriptor =
          MethodDescriptor.<ReplaceArtifactRequest, Artifact>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/ReplaceArtifact")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReplaceArtifactRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Artifact.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteArtifactRequest, Empty>
      deleteArtifactMethodDescriptor =
          MethodDescriptor.<DeleteArtifactRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.apigeeregistry.v1.Registry/DeleteArtifact")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteArtifactRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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

  private final UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable;
  private final UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable;
  private final UnaryCallable<GetApiRequest, Api> getApiCallable;
  private final UnaryCallable<CreateApiRequest, Api> createApiCallable;
  private final UnaryCallable<UpdateApiRequest, Api> updateApiCallable;
  private final UnaryCallable<DeleteApiRequest, Empty> deleteApiCallable;
  private final UnaryCallable<ListApiVersionsRequest, ListApiVersionsResponse>
      listApiVersionsCallable;
  private final UnaryCallable<ListApiVersionsRequest, ListApiVersionsPagedResponse>
      listApiVersionsPagedCallable;
  private final UnaryCallable<GetApiVersionRequest, ApiVersion> getApiVersionCallable;
  private final UnaryCallable<CreateApiVersionRequest, ApiVersion> createApiVersionCallable;
  private final UnaryCallable<UpdateApiVersionRequest, ApiVersion> updateApiVersionCallable;
  private final UnaryCallable<DeleteApiVersionRequest, Empty> deleteApiVersionCallable;
  private final UnaryCallable<ListApiSpecsRequest, ListApiSpecsResponse> listApiSpecsCallable;
  private final UnaryCallable<ListApiSpecsRequest, ListApiSpecsPagedResponse>
      listApiSpecsPagedCallable;
  private final UnaryCallable<GetApiSpecRequest, ApiSpec> getApiSpecCallable;
  private final UnaryCallable<GetApiSpecContentsRequest, HttpBody> getApiSpecContentsCallable;
  private final UnaryCallable<CreateApiSpecRequest, ApiSpec> createApiSpecCallable;
  private final UnaryCallable<UpdateApiSpecRequest, ApiSpec> updateApiSpecCallable;
  private final UnaryCallable<DeleteApiSpecRequest, Empty> deleteApiSpecCallable;
  private final UnaryCallable<TagApiSpecRevisionRequest, ApiSpec> tagApiSpecRevisionCallable;
  private final UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>
      listApiSpecRevisionsCallable;
  private final UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsPagedResponse>
      listApiSpecRevisionsPagedCallable;
  private final UnaryCallable<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecCallable;
  private final UnaryCallable<DeleteApiSpecRevisionRequest, ApiSpec> deleteApiSpecRevisionCallable;
  private final UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsResponse>
      listApiDeploymentsCallable;
  private final UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsPagedResponse>
      listApiDeploymentsPagedCallable;
  private final UnaryCallable<GetApiDeploymentRequest, ApiDeployment> getApiDeploymentCallable;
  private final UnaryCallable<CreateApiDeploymentRequest, ApiDeployment>
      createApiDeploymentCallable;
  private final UnaryCallable<UpdateApiDeploymentRequest, ApiDeployment>
      updateApiDeploymentCallable;
  private final UnaryCallable<DeleteApiDeploymentRequest, Empty> deleteApiDeploymentCallable;
  private final UnaryCallable<TagApiDeploymentRevisionRequest, ApiDeployment>
      tagApiDeploymentRevisionCallable;
  private final UnaryCallable<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>
      listApiDeploymentRevisionsCallable;
  private final UnaryCallable<
          ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsPagedResponse>
      listApiDeploymentRevisionsPagedCallable;
  private final UnaryCallable<RollbackApiDeploymentRequest, ApiDeployment>
      rollbackApiDeploymentCallable;
  private final UnaryCallable<DeleteApiDeploymentRevisionRequest, ApiDeployment>
      deleteApiDeploymentRevisionCallable;
  private final UnaryCallable<ListArtifactsRequest, ListArtifactsResponse> listArtifactsCallable;
  private final UnaryCallable<ListArtifactsRequest, ListArtifactsPagedResponse>
      listArtifactsPagedCallable;
  private final UnaryCallable<GetArtifactRequest, Artifact> getArtifactCallable;
  private final UnaryCallable<GetArtifactContentsRequest, HttpBody> getArtifactContentsCallable;
  private final UnaryCallable<CreateArtifactRequest, Artifact> createArtifactCallable;
  private final UnaryCallable<ReplaceArtifactRequest, Artifact> replaceArtifactCallable;
  private final UnaryCallable<DeleteArtifactRequest, Empty> deleteArtifactCallable;
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

  public static final GrpcRegistryStub create(RegistryStubSettings settings) throws IOException {
    return new GrpcRegistryStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRegistryStub create(ClientContext clientContext) throws IOException {
    return new GrpcRegistryStub(RegistryStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRegistryStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRegistryStub(
        RegistryStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcRegistryStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcRegistryStub(RegistryStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRegistryCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRegistryStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcRegistryStub(
      RegistryStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListApisRequest, ListApisResponse> listApisTransportSettings =
        GrpcCallSettings.<ListApisRequest, ListApisResponse>newBuilder()
            .setMethodDescriptor(listApisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetApiRequest, Api> getApiTransportSettings =
        GrpcCallSettings.<GetApiRequest, Api>newBuilder()
            .setMethodDescriptor(getApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateApiRequest, Api> createApiTransportSettings =
        GrpcCallSettings.<CreateApiRequest, Api>newBuilder()
            .setMethodDescriptor(createApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateApiRequest, Api> updateApiTransportSettings =
        GrpcCallSettings.<UpdateApiRequest, Api>newBuilder()
            .setMethodDescriptor(updateApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("api.name", String.valueOf(request.getApi().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteApiRequest, Empty> deleteApiTransportSettings =
        GrpcCallSettings.<DeleteApiRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteApiMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListApiVersionsRequest, ListApiVersionsResponse>
        listApiVersionsTransportSettings =
            GrpcCallSettings.<ListApiVersionsRequest, ListApiVersionsResponse>newBuilder()
                .setMethodDescriptor(listApiVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetApiVersionRequest, ApiVersion> getApiVersionTransportSettings =
        GrpcCallSettings.<GetApiVersionRequest, ApiVersion>newBuilder()
            .setMethodDescriptor(getApiVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateApiVersionRequest, ApiVersion> createApiVersionTransportSettings =
        GrpcCallSettings.<CreateApiVersionRequest, ApiVersion>newBuilder()
            .setMethodDescriptor(createApiVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateApiVersionRequest, ApiVersion> updateApiVersionTransportSettings =
        GrpcCallSettings.<UpdateApiVersionRequest, ApiVersion>newBuilder()
            .setMethodDescriptor(updateApiVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("api_version.name", String.valueOf(request.getApiVersion().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteApiVersionRequest, Empty> deleteApiVersionTransportSettings =
        GrpcCallSettings.<DeleteApiVersionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteApiVersionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListApiSpecsRequest, ListApiSpecsResponse> listApiSpecsTransportSettings =
        GrpcCallSettings.<ListApiSpecsRequest, ListApiSpecsResponse>newBuilder()
            .setMethodDescriptor(listApiSpecsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetApiSpecRequest, ApiSpec> getApiSpecTransportSettings =
        GrpcCallSettings.<GetApiSpecRequest, ApiSpec>newBuilder()
            .setMethodDescriptor(getApiSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetApiSpecContentsRequest, HttpBody> getApiSpecContentsTransportSettings =
        GrpcCallSettings.<GetApiSpecContentsRequest, HttpBody>newBuilder()
            .setMethodDescriptor(getApiSpecContentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateApiSpecRequest, ApiSpec> createApiSpecTransportSettings =
        GrpcCallSettings.<CreateApiSpecRequest, ApiSpec>newBuilder()
            .setMethodDescriptor(createApiSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateApiSpecRequest, ApiSpec> updateApiSpecTransportSettings =
        GrpcCallSettings.<UpdateApiSpecRequest, ApiSpec>newBuilder()
            .setMethodDescriptor(updateApiSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("api_spec.name", String.valueOf(request.getApiSpec().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteApiSpecRequest, Empty> deleteApiSpecTransportSettings =
        GrpcCallSettings.<DeleteApiSpecRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteApiSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TagApiSpecRevisionRequest, ApiSpec> tagApiSpecRevisionTransportSettings =
        GrpcCallSettings.<TagApiSpecRevisionRequest, ApiSpec>newBuilder()
            .setMethodDescriptor(tagApiSpecRevisionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>
        listApiSpecRevisionsTransportSettings =
            GrpcCallSettings.<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>newBuilder()
                .setMethodDescriptor(listApiSpecRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecTransportSettings =
        GrpcCallSettings.<RollbackApiSpecRequest, ApiSpec>newBuilder()
            .setMethodDescriptor(rollbackApiSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteApiSpecRevisionRequest, ApiSpec> deleteApiSpecRevisionTransportSettings =
        GrpcCallSettings.<DeleteApiSpecRevisionRequest, ApiSpec>newBuilder()
            .setMethodDescriptor(deleteApiSpecRevisionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListApiDeploymentsRequest, ListApiDeploymentsResponse>
        listApiDeploymentsTransportSettings =
            GrpcCallSettings.<ListApiDeploymentsRequest, ListApiDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listApiDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetApiDeploymentRequest, ApiDeployment> getApiDeploymentTransportSettings =
        GrpcCallSettings.<GetApiDeploymentRequest, ApiDeployment>newBuilder()
            .setMethodDescriptor(getApiDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateApiDeploymentRequest, ApiDeployment>
        createApiDeploymentTransportSettings =
            GrpcCallSettings.<CreateApiDeploymentRequest, ApiDeployment>newBuilder()
                .setMethodDescriptor(createApiDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateApiDeploymentRequest, ApiDeployment>
        updateApiDeploymentTransportSettings =
            GrpcCallSettings.<UpdateApiDeploymentRequest, ApiDeployment>newBuilder()
                .setMethodDescriptor(updateApiDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "api_deployment.name",
                          String.valueOf(request.getApiDeployment().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteApiDeploymentRequest, Empty> deleteApiDeploymentTransportSettings =
        GrpcCallSettings.<DeleteApiDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteApiDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TagApiDeploymentRevisionRequest, ApiDeployment>
        tagApiDeploymentRevisionTransportSettings =
            GrpcCallSettings.<TagApiDeploymentRevisionRequest, ApiDeployment>newBuilder()
                .setMethodDescriptor(tagApiDeploymentRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>
        listApiDeploymentRevisionsTransportSettings =
            GrpcCallSettings
                .<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>newBuilder()
                .setMethodDescriptor(listApiDeploymentRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<RollbackApiDeploymentRequest, ApiDeployment>
        rollbackApiDeploymentTransportSettings =
            GrpcCallSettings.<RollbackApiDeploymentRequest, ApiDeployment>newBuilder()
                .setMethodDescriptor(rollbackApiDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteApiDeploymentRevisionRequest, ApiDeployment>
        deleteApiDeploymentRevisionTransportSettings =
            GrpcCallSettings.<DeleteApiDeploymentRevisionRequest, ApiDeployment>newBuilder()
                .setMethodDescriptor(deleteApiDeploymentRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListArtifactsRequest, ListArtifactsResponse> listArtifactsTransportSettings =
        GrpcCallSettings.<ListArtifactsRequest, ListArtifactsResponse>newBuilder()
            .setMethodDescriptor(listArtifactsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetArtifactRequest, Artifact> getArtifactTransportSettings =
        GrpcCallSettings.<GetArtifactRequest, Artifact>newBuilder()
            .setMethodDescriptor(getArtifactMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetArtifactContentsRequest, HttpBody> getArtifactContentsTransportSettings =
        GrpcCallSettings.<GetArtifactContentsRequest, HttpBody>newBuilder()
            .setMethodDescriptor(getArtifactContentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateArtifactRequest, Artifact> createArtifactTransportSettings =
        GrpcCallSettings.<CreateArtifactRequest, Artifact>newBuilder()
            .setMethodDescriptor(createArtifactMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ReplaceArtifactRequest, Artifact> replaceArtifactTransportSettings =
        GrpcCallSettings.<ReplaceArtifactRequest, Artifact>newBuilder()
            .setMethodDescriptor(replaceArtifactMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("artifact.name", String.valueOf(request.getArtifact().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteArtifactRequest, Empty> deleteArtifactTransportSettings =
        GrpcCallSettings.<DeleteArtifactRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteArtifactMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
                .build();

    this.listApisCallable =
        callableFactory.createUnaryCallable(
            listApisTransportSettings, settings.listApisSettings(), clientContext);
    this.listApisPagedCallable =
        callableFactory.createPagedCallable(
            listApisTransportSettings, settings.listApisSettings(), clientContext);
    this.getApiCallable =
        callableFactory.createUnaryCallable(
            getApiTransportSettings, settings.getApiSettings(), clientContext);
    this.createApiCallable =
        callableFactory.createUnaryCallable(
            createApiTransportSettings, settings.createApiSettings(), clientContext);
    this.updateApiCallable =
        callableFactory.createUnaryCallable(
            updateApiTransportSettings, settings.updateApiSettings(), clientContext);
    this.deleteApiCallable =
        callableFactory.createUnaryCallable(
            deleteApiTransportSettings, settings.deleteApiSettings(), clientContext);
    this.listApiVersionsCallable =
        callableFactory.createUnaryCallable(
            listApiVersionsTransportSettings, settings.listApiVersionsSettings(), clientContext);
    this.listApiVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listApiVersionsTransportSettings, settings.listApiVersionsSettings(), clientContext);
    this.getApiVersionCallable =
        callableFactory.createUnaryCallable(
            getApiVersionTransportSettings, settings.getApiVersionSettings(), clientContext);
    this.createApiVersionCallable =
        callableFactory.createUnaryCallable(
            createApiVersionTransportSettings, settings.createApiVersionSettings(), clientContext);
    this.updateApiVersionCallable =
        callableFactory.createUnaryCallable(
            updateApiVersionTransportSettings, settings.updateApiVersionSettings(), clientContext);
    this.deleteApiVersionCallable =
        callableFactory.createUnaryCallable(
            deleteApiVersionTransportSettings, settings.deleteApiVersionSettings(), clientContext);
    this.listApiSpecsCallable =
        callableFactory.createUnaryCallable(
            listApiSpecsTransportSettings, settings.listApiSpecsSettings(), clientContext);
    this.listApiSpecsPagedCallable =
        callableFactory.createPagedCallable(
            listApiSpecsTransportSettings, settings.listApiSpecsSettings(), clientContext);
    this.getApiSpecCallable =
        callableFactory.createUnaryCallable(
            getApiSpecTransportSettings, settings.getApiSpecSettings(), clientContext);
    this.getApiSpecContentsCallable =
        callableFactory.createUnaryCallable(
            getApiSpecContentsTransportSettings,
            settings.getApiSpecContentsSettings(),
            clientContext);
    this.createApiSpecCallable =
        callableFactory.createUnaryCallable(
            createApiSpecTransportSettings, settings.createApiSpecSettings(), clientContext);
    this.updateApiSpecCallable =
        callableFactory.createUnaryCallable(
            updateApiSpecTransportSettings, settings.updateApiSpecSettings(), clientContext);
    this.deleteApiSpecCallable =
        callableFactory.createUnaryCallable(
            deleteApiSpecTransportSettings, settings.deleteApiSpecSettings(), clientContext);
    this.tagApiSpecRevisionCallable =
        callableFactory.createUnaryCallable(
            tagApiSpecRevisionTransportSettings,
            settings.tagApiSpecRevisionSettings(),
            clientContext);
    this.listApiSpecRevisionsCallable =
        callableFactory.createUnaryCallable(
            listApiSpecRevisionsTransportSettings,
            settings.listApiSpecRevisionsSettings(),
            clientContext);
    this.listApiSpecRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listApiSpecRevisionsTransportSettings,
            settings.listApiSpecRevisionsSettings(),
            clientContext);
    this.rollbackApiSpecCallable =
        callableFactory.createUnaryCallable(
            rollbackApiSpecTransportSettings, settings.rollbackApiSpecSettings(), clientContext);
    this.deleteApiSpecRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteApiSpecRevisionTransportSettings,
            settings.deleteApiSpecRevisionSettings(),
            clientContext);
    this.listApiDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listApiDeploymentsTransportSettings,
            settings.listApiDeploymentsSettings(),
            clientContext);
    this.listApiDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listApiDeploymentsTransportSettings,
            settings.listApiDeploymentsSettings(),
            clientContext);
    this.getApiDeploymentCallable =
        callableFactory.createUnaryCallable(
            getApiDeploymentTransportSettings, settings.getApiDeploymentSettings(), clientContext);
    this.createApiDeploymentCallable =
        callableFactory.createUnaryCallable(
            createApiDeploymentTransportSettings,
            settings.createApiDeploymentSettings(),
            clientContext);
    this.updateApiDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateApiDeploymentTransportSettings,
            settings.updateApiDeploymentSettings(),
            clientContext);
    this.deleteApiDeploymentCallable =
        callableFactory.createUnaryCallable(
            deleteApiDeploymentTransportSettings,
            settings.deleteApiDeploymentSettings(),
            clientContext);
    this.tagApiDeploymentRevisionCallable =
        callableFactory.createUnaryCallable(
            tagApiDeploymentRevisionTransportSettings,
            settings.tagApiDeploymentRevisionSettings(),
            clientContext);
    this.listApiDeploymentRevisionsCallable =
        callableFactory.createUnaryCallable(
            listApiDeploymentRevisionsTransportSettings,
            settings.listApiDeploymentRevisionsSettings(),
            clientContext);
    this.listApiDeploymentRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listApiDeploymentRevisionsTransportSettings,
            settings.listApiDeploymentRevisionsSettings(),
            clientContext);
    this.rollbackApiDeploymentCallable =
        callableFactory.createUnaryCallable(
            rollbackApiDeploymentTransportSettings,
            settings.rollbackApiDeploymentSettings(),
            clientContext);
    this.deleteApiDeploymentRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteApiDeploymentRevisionTransportSettings,
            settings.deleteApiDeploymentRevisionSettings(),
            clientContext);
    this.listArtifactsCallable =
        callableFactory.createUnaryCallable(
            listArtifactsTransportSettings, settings.listArtifactsSettings(), clientContext);
    this.listArtifactsPagedCallable =
        callableFactory.createPagedCallable(
            listArtifactsTransportSettings, settings.listArtifactsSettings(), clientContext);
    this.getArtifactCallable =
        callableFactory.createUnaryCallable(
            getArtifactTransportSettings, settings.getArtifactSettings(), clientContext);
    this.getArtifactContentsCallable =
        callableFactory.createUnaryCallable(
            getArtifactContentsTransportSettings,
            settings.getArtifactContentsSettings(),
            clientContext);
    this.createArtifactCallable =
        callableFactory.createUnaryCallable(
            createArtifactTransportSettings, settings.createArtifactSettings(), clientContext);
    this.replaceArtifactCallable =
        callableFactory.createUnaryCallable(
            replaceArtifactTransportSettings, settings.replaceArtifactSettings(), clientContext);
    this.deleteArtifactCallable =
        callableFactory.createUnaryCallable(
            deleteArtifactTransportSettings, settings.deleteArtifactSettings(), clientContext);
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
  public UnaryCallable<ListApisRequest, ListApisResponse> listApisCallable() {
    return listApisCallable;
  }

  @Override
  public UnaryCallable<ListApisRequest, ListApisPagedResponse> listApisPagedCallable() {
    return listApisPagedCallable;
  }

  @Override
  public UnaryCallable<GetApiRequest, Api> getApiCallable() {
    return getApiCallable;
  }

  @Override
  public UnaryCallable<CreateApiRequest, Api> createApiCallable() {
    return createApiCallable;
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
  public UnaryCallable<ListApiVersionsRequest, ListApiVersionsResponse> listApiVersionsCallable() {
    return listApiVersionsCallable;
  }

  @Override
  public UnaryCallable<ListApiVersionsRequest, ListApiVersionsPagedResponse>
      listApiVersionsPagedCallable() {
    return listApiVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetApiVersionRequest, ApiVersion> getApiVersionCallable() {
    return getApiVersionCallable;
  }

  @Override
  public UnaryCallable<CreateApiVersionRequest, ApiVersion> createApiVersionCallable() {
    return createApiVersionCallable;
  }

  @Override
  public UnaryCallable<UpdateApiVersionRequest, ApiVersion> updateApiVersionCallable() {
    return updateApiVersionCallable;
  }

  @Override
  public UnaryCallable<DeleteApiVersionRequest, Empty> deleteApiVersionCallable() {
    return deleteApiVersionCallable;
  }

  @Override
  public UnaryCallable<ListApiSpecsRequest, ListApiSpecsResponse> listApiSpecsCallable() {
    return listApiSpecsCallable;
  }

  @Override
  public UnaryCallable<ListApiSpecsRequest, ListApiSpecsPagedResponse> listApiSpecsPagedCallable() {
    return listApiSpecsPagedCallable;
  }

  @Override
  public UnaryCallable<GetApiSpecRequest, ApiSpec> getApiSpecCallable() {
    return getApiSpecCallable;
  }

  @Override
  public UnaryCallable<GetApiSpecContentsRequest, HttpBody> getApiSpecContentsCallable() {
    return getApiSpecContentsCallable;
  }

  @Override
  public UnaryCallable<CreateApiSpecRequest, ApiSpec> createApiSpecCallable() {
    return createApiSpecCallable;
  }

  @Override
  public UnaryCallable<UpdateApiSpecRequest, ApiSpec> updateApiSpecCallable() {
    return updateApiSpecCallable;
  }

  @Override
  public UnaryCallable<DeleteApiSpecRequest, Empty> deleteApiSpecCallable() {
    return deleteApiSpecCallable;
  }

  @Override
  public UnaryCallable<TagApiSpecRevisionRequest, ApiSpec> tagApiSpecRevisionCallable() {
    return tagApiSpecRevisionCallable;
  }

  @Override
  public UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsResponse>
      listApiSpecRevisionsCallable() {
    return listApiSpecRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListApiSpecRevisionsRequest, ListApiSpecRevisionsPagedResponse>
      listApiSpecRevisionsPagedCallable() {
    return listApiSpecRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecCallable() {
    return rollbackApiSpecCallable;
  }

  @Override
  public UnaryCallable<DeleteApiSpecRevisionRequest, ApiSpec> deleteApiSpecRevisionCallable() {
    return deleteApiSpecRevisionCallable;
  }

  @Override
  public UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsResponse>
      listApiDeploymentsCallable() {
    return listApiDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListApiDeploymentsRequest, ListApiDeploymentsPagedResponse>
      listApiDeploymentsPagedCallable() {
    return listApiDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetApiDeploymentRequest, ApiDeployment> getApiDeploymentCallable() {
    return getApiDeploymentCallable;
  }

  @Override
  public UnaryCallable<CreateApiDeploymentRequest, ApiDeployment> createApiDeploymentCallable() {
    return createApiDeploymentCallable;
  }

  @Override
  public UnaryCallable<UpdateApiDeploymentRequest, ApiDeployment> updateApiDeploymentCallable() {
    return updateApiDeploymentCallable;
  }

  @Override
  public UnaryCallable<DeleteApiDeploymentRequest, Empty> deleteApiDeploymentCallable() {
    return deleteApiDeploymentCallable;
  }

  @Override
  public UnaryCallable<TagApiDeploymentRevisionRequest, ApiDeployment>
      tagApiDeploymentRevisionCallable() {
    return tagApiDeploymentRevisionCallable;
  }

  @Override
  public UnaryCallable<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsResponse>
      listApiDeploymentRevisionsCallable() {
    return listApiDeploymentRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListApiDeploymentRevisionsRequest, ListApiDeploymentRevisionsPagedResponse>
      listApiDeploymentRevisionsPagedCallable() {
    return listApiDeploymentRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<RollbackApiDeploymentRequest, ApiDeployment>
      rollbackApiDeploymentCallable() {
    return rollbackApiDeploymentCallable;
  }

  @Override
  public UnaryCallable<DeleteApiDeploymentRevisionRequest, ApiDeployment>
      deleteApiDeploymentRevisionCallable() {
    return deleteApiDeploymentRevisionCallable;
  }

  @Override
  public UnaryCallable<ListArtifactsRequest, ListArtifactsResponse> listArtifactsCallable() {
    return listArtifactsCallable;
  }

  @Override
  public UnaryCallable<ListArtifactsRequest, ListArtifactsPagedResponse>
      listArtifactsPagedCallable() {
    return listArtifactsPagedCallable;
  }

  @Override
  public UnaryCallable<GetArtifactRequest, Artifact> getArtifactCallable() {
    return getArtifactCallable;
  }

  @Override
  public UnaryCallable<GetArtifactContentsRequest, HttpBody> getArtifactContentsCallable() {
    return getArtifactContentsCallable;
  }

  @Override
  public UnaryCallable<CreateArtifactRequest, Artifact> createArtifactCallable() {
    return createArtifactCallable;
  }

  @Override
  public UnaryCallable<ReplaceArtifactRequest, Artifact> replaceArtifactCallable() {
    return replaceArtifactCallable;
  }

  @Override
  public UnaryCallable<DeleteArtifactRequest, Empty> deleteArtifactCallable() {
    return deleteArtifactCallable;
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
