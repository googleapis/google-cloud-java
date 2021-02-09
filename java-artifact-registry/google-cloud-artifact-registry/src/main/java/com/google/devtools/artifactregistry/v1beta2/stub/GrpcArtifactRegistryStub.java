/*
 * Copyright 2020 Google LLC
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

package com.google.devtools.artifactregistry.v1beta2.stub;

import static com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient.ListFilesPagedResponse;
import static com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient.ListPackagesPagedResponse;
import static com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient.ListRepositoriesPagedResponse;
import static com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient.ListTagsPagedResponse;
import static com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryClient.ListVersionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest;
import com.google.devtools.artifactregistry.v1beta2.CreateTagRequest;
import com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest;
import com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest;
import com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest;
import com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest;
import com.google.devtools.artifactregistry.v1beta2.File;
import com.google.devtools.artifactregistry.v1beta2.GetFileRequest;
import com.google.devtools.artifactregistry.v1beta2.GetPackageRequest;
import com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest;
import com.google.devtools.artifactregistry.v1beta2.GetTagRequest;
import com.google.devtools.artifactregistry.v1beta2.GetVersionRequest;
import com.google.devtools.artifactregistry.v1beta2.ListFilesRequest;
import com.google.devtools.artifactregistry.v1beta2.ListFilesResponse;
import com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest;
import com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse;
import com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest;
import com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse;
import com.google.devtools.artifactregistry.v1beta2.ListTagsRequest;
import com.google.devtools.artifactregistry.v1beta2.ListTagsResponse;
import com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest;
import com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse;
import com.google.devtools.artifactregistry.v1beta2.OperationMetadata;
import com.google.devtools.artifactregistry.v1beta2.Package;
import com.google.devtools.artifactregistry.v1beta2.Repository;
import com.google.devtools.artifactregistry.v1beta2.Tag;
import com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest;
import com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest;
import com.google.devtools.artifactregistry.v1beta2.Version;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ArtifactRegistry service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcArtifactRegistryStub extends ArtifactRegistryStub {
  private static final MethodDescriptor<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesMethodDescriptor =
          MethodDescriptor.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/ListRepositories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRepositoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRepositoriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRepositoryRequest, Repository>
      getRepositoryMethodDescriptor =
          MethodDescriptor.<GetRepositoryRequest, Repository>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/GetRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Repository.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateRepositoryRequest, Operation>
      createRepositoryMethodDescriptor =
          MethodDescriptor.<CreateRepositoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/CreateRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRepositoryRequest, Repository>
      updateRepositoryMethodDescriptor =
          MethodDescriptor.<UpdateRepositoryRequest, Repository>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/UpdateRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Repository.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRepositoryRequest, Operation>
      deleteRepositoryMethodDescriptor =
          MethodDescriptor.<DeleteRepositoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/DeleteRepository")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRepositoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPackagesRequest, ListPackagesResponse>
      listPackagesMethodDescriptor =
          MethodDescriptor.<ListPackagesRequest, ListPackagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/ListPackages")
              .setRequestMarshaller(ProtoUtils.marshaller(ListPackagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPackagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPackageRequest, Package> getPackageMethodDescriptor =
      MethodDescriptor.<GetPackageRequest, Package>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1beta2.ArtifactRegistry/GetPackage")
          .setRequestMarshaller(ProtoUtils.marshaller(GetPackageRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Package.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeletePackageRequest, Operation>
      deletePackageMethodDescriptor =
          MethodDescriptor.<DeletePackageRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/DeletePackage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePackageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListVersionsRequest, ListVersionsResponse>
      listVersionsMethodDescriptor =
          MethodDescriptor.<ListVersionsRequest, ListVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/ListVersions")
              .setRequestMarshaller(ProtoUtils.marshaller(ListVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVersionRequest, Version> getVersionMethodDescriptor =
      MethodDescriptor.<GetVersionRequest, Version>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1beta2.ArtifactRegistry/GetVersion")
          .setRequestMarshaller(ProtoUtils.marshaller(GetVersionRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Version.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteVersionRequest, Operation>
      deleteVersionMethodDescriptor =
          MethodDescriptor.<DeleteVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/DeleteVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListFilesRequest, ListFilesResponse>
      listFilesMethodDescriptor =
          MethodDescriptor.<ListFilesRequest, ListFilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/ListFiles")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListFilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFileRequest, File> getFileMethodDescriptor =
      MethodDescriptor.<GetFileRequest, File>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1beta2.ArtifactRegistry/GetFile")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFileRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(File.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListTagsRequest, ListTagsResponse>
      listTagsMethodDescriptor =
          MethodDescriptor.<ListTagsRequest, ListTagsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/ListTags")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTagsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTagsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTagRequest, Tag> getTagMethodDescriptor =
      MethodDescriptor.<GetTagRequest, Tag>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1beta2.ArtifactRegistry/GetTag")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTagRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tag.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateTagRequest, Tag> createTagMethodDescriptor =
      MethodDescriptor.<CreateTagRequest, Tag>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1beta2.ArtifactRegistry/CreateTag")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateTagRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tag.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateTagRequest, Tag> updateTagMethodDescriptor =
      MethodDescriptor.<UpdateTagRequest, Tag>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1beta2.ArtifactRegistry/UpdateTag")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateTagRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Tag.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteTagRequest, Empty> deleteTagMethodDescriptor =
      MethodDescriptor.<DeleteTagRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.artifactregistry.v1beta2.ArtifactRegistry/DeleteTag")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteTagRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.artifactregistry.v1beta2.ArtifactRegistry/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable;
  private final UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable;
  private final UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable;
  private final UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable;
  private final OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable;
  private final UnaryCallable<UpdateRepositoryRequest, Repository> updateRepositoryCallable;
  private final UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable;
  private final OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable;
  private final UnaryCallable<ListPackagesRequest, ListPackagesResponse> listPackagesCallable;
  private final UnaryCallable<ListPackagesRequest, ListPackagesPagedResponse>
      listPackagesPagedCallable;
  private final UnaryCallable<GetPackageRequest, Package> getPackageCallable;
  private final UnaryCallable<DeletePackageRequest, Operation> deletePackageCallable;
  private final OperationCallable<DeletePackageRequest, Empty, OperationMetadata>
      deletePackageOperationCallable;
  private final UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable;
  private final UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse>
      listVersionsPagedCallable;
  private final UnaryCallable<GetVersionRequest, Version> getVersionCallable;
  private final UnaryCallable<DeleteVersionRequest, Operation> deleteVersionCallable;
  private final OperationCallable<DeleteVersionRequest, Empty, OperationMetadata>
      deleteVersionOperationCallable;
  private final UnaryCallable<ListFilesRequest, ListFilesResponse> listFilesCallable;
  private final UnaryCallable<ListFilesRequest, ListFilesPagedResponse> listFilesPagedCallable;
  private final UnaryCallable<GetFileRequest, File> getFileCallable;
  private final UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable;
  private final UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable;
  private final UnaryCallable<GetTagRequest, Tag> getTagCallable;
  private final UnaryCallable<CreateTagRequest, Tag> createTagCallable;
  private final UnaryCallable<UpdateTagRequest, Tag> updateTagCallable;
  private final UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcArtifactRegistryStub create(ArtifactRegistryStubSettings settings)
      throws IOException {
    return new GrpcArtifactRegistryStub(settings, ClientContext.create(settings));
  }

  public static final GrpcArtifactRegistryStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcArtifactRegistryStub(
        ArtifactRegistryStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcArtifactRegistryStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcArtifactRegistryStub(
        ArtifactRegistryStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcArtifactRegistryStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcArtifactRegistryStub(
      ArtifactRegistryStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcArtifactRegistryCallableFactory());
  }

  /**
   * Constructs an instance of GrpcArtifactRegistryStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcArtifactRegistryStub(
      ArtifactRegistryStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListRepositoriesRequest, ListRepositoriesResponse>
        listRepositoriesTransportSettings =
            GrpcCallSettings.<ListRepositoriesRequest, ListRepositoriesResponse>newBuilder()
                .setMethodDescriptor(listRepositoriesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListRepositoriesRequest>() {
                      @Override
                      public Map<String, String> extract(ListRepositoriesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetRepositoryRequest, Repository> getRepositoryTransportSettings =
        GrpcCallSettings.<GetRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(getRepositoryMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetRepositoryRequest>() {
                  @Override
                  public Map<String, String> extract(GetRepositoryRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateRepositoryRequest, Operation> createRepositoryTransportSettings =
        GrpcCallSettings.<CreateRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(createRepositoryMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateRepositoryRequest>() {
                  @Override
                  public Map<String, String> extract(CreateRepositoryRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateRepositoryRequest, Repository> updateRepositoryTransportSettings =
        GrpcCallSettings.<UpdateRepositoryRequest, Repository>newBuilder()
            .setMethodDescriptor(updateRepositoryMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateRepositoryRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateRepositoryRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "repository.name", String.valueOf(request.getRepository().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteRepositoryRequest, Operation> deleteRepositoryTransportSettings =
        GrpcCallSettings.<DeleteRepositoryRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRepositoryMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteRepositoryRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteRepositoryRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListPackagesRequest, ListPackagesResponse> listPackagesTransportSettings =
        GrpcCallSettings.<ListPackagesRequest, ListPackagesResponse>newBuilder()
            .setMethodDescriptor(listPackagesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListPackagesRequest>() {
                  @Override
                  public Map<String, String> extract(ListPackagesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetPackageRequest, Package> getPackageTransportSettings =
        GrpcCallSettings.<GetPackageRequest, Package>newBuilder()
            .setMethodDescriptor(getPackageMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetPackageRequest>() {
                  @Override
                  public Map<String, String> extract(GetPackageRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeletePackageRequest, Operation> deletePackageTransportSettings =
        GrpcCallSettings.<DeletePackageRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePackageMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeletePackageRequest>() {
                  @Override
                  public Map<String, String> extract(DeletePackageRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListVersionsRequest, ListVersionsResponse> listVersionsTransportSettings =
        GrpcCallSettings.<ListVersionsRequest, ListVersionsResponse>newBuilder()
            .setMethodDescriptor(listVersionsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListVersionsRequest>() {
                  @Override
                  public Map<String, String> extract(ListVersionsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetVersionRequest, Version> getVersionTransportSettings =
        GrpcCallSettings.<GetVersionRequest, Version>newBuilder()
            .setMethodDescriptor(getVersionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetVersionRequest>() {
                  @Override
                  public Map<String, String> extract(GetVersionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteVersionRequest, Operation> deleteVersionTransportSettings =
        GrpcCallSettings.<DeleteVersionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteVersionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteVersionRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteVersionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListFilesRequest, ListFilesResponse> listFilesTransportSettings =
        GrpcCallSettings.<ListFilesRequest, ListFilesResponse>newBuilder()
            .setMethodDescriptor(listFilesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListFilesRequest>() {
                  @Override
                  public Map<String, String> extract(ListFilesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetFileRequest, File> getFileTransportSettings =
        GrpcCallSettings.<GetFileRequest, File>newBuilder()
            .setMethodDescriptor(getFileMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetFileRequest>() {
                  @Override
                  public Map<String, String> extract(GetFileRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListTagsRequest, ListTagsResponse> listTagsTransportSettings =
        GrpcCallSettings.<ListTagsRequest, ListTagsResponse>newBuilder()
            .setMethodDescriptor(listTagsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListTagsRequest>() {
                  @Override
                  public Map<String, String> extract(ListTagsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetTagRequest, Tag> getTagTransportSettings =
        GrpcCallSettings.<GetTagRequest, Tag>newBuilder()
            .setMethodDescriptor(getTagMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetTagRequest>() {
                  @Override
                  public Map<String, String> extract(GetTagRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateTagRequest, Tag> createTagTransportSettings =
        GrpcCallSettings.<CreateTagRequest, Tag>newBuilder()
            .setMethodDescriptor(createTagMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateTagRequest>() {
                  @Override
                  public Map<String, String> extract(CreateTagRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateTagRequest, Tag> updateTagTransportSettings =
        GrpcCallSettings.<UpdateTagRequest, Tag>newBuilder()
            .setMethodDescriptor(updateTagMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateTagRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateTagRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("tag.name", String.valueOf(request.getTag().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteTagRequest, Empty> deleteTagTransportSettings =
        GrpcCallSettings.<DeleteTagRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTagMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteTagRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteTagRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(SetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(GetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<TestIamPermissionsRequest>() {
                      @Override
                      public Map<String, String> extract(TestIamPermissionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("resource", String.valueOf(request.getResource()));
                        return params.build();
                      }
                    })
                .build();

    this.listRepositoriesCallable =
        callableFactory.createUnaryCallable(
            listRepositoriesTransportSettings, settings.listRepositoriesSettings(), clientContext);
    this.listRepositoriesPagedCallable =
        callableFactory.createPagedCallable(
            listRepositoriesTransportSettings, settings.listRepositoriesSettings(), clientContext);
    this.getRepositoryCallable =
        callableFactory.createUnaryCallable(
            getRepositoryTransportSettings, settings.getRepositorySettings(), clientContext);
    this.createRepositoryCallable =
        callableFactory.createUnaryCallable(
            createRepositoryTransportSettings, settings.createRepositorySettings(), clientContext);
    this.createRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            createRepositoryTransportSettings,
            settings.createRepositoryOperationSettings(),
            clientContext,
            operationsStub);
    this.updateRepositoryCallable =
        callableFactory.createUnaryCallable(
            updateRepositoryTransportSettings, settings.updateRepositorySettings(), clientContext);
    this.deleteRepositoryCallable =
        callableFactory.createUnaryCallable(
            deleteRepositoryTransportSettings, settings.deleteRepositorySettings(), clientContext);
    this.deleteRepositoryOperationCallable =
        callableFactory.createOperationCallable(
            deleteRepositoryTransportSettings,
            settings.deleteRepositoryOperationSettings(),
            clientContext,
            operationsStub);
    this.listPackagesCallable =
        callableFactory.createUnaryCallable(
            listPackagesTransportSettings, settings.listPackagesSettings(), clientContext);
    this.listPackagesPagedCallable =
        callableFactory.createPagedCallable(
            listPackagesTransportSettings, settings.listPackagesSettings(), clientContext);
    this.getPackageCallable =
        callableFactory.createUnaryCallable(
            getPackageTransportSettings, settings.getPackageSettings(), clientContext);
    this.deletePackageCallable =
        callableFactory.createUnaryCallable(
            deletePackageTransportSettings, settings.deletePackageSettings(), clientContext);
    this.deletePackageOperationCallable =
        callableFactory.createOperationCallable(
            deletePackageTransportSettings,
            settings.deletePackageOperationSettings(),
            clientContext,
            operationsStub);
    this.listVersionsCallable =
        callableFactory.createUnaryCallable(
            listVersionsTransportSettings, settings.listVersionsSettings(), clientContext);
    this.listVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listVersionsTransportSettings, settings.listVersionsSettings(), clientContext);
    this.getVersionCallable =
        callableFactory.createUnaryCallable(
            getVersionTransportSettings, settings.getVersionSettings(), clientContext);
    this.deleteVersionCallable =
        callableFactory.createUnaryCallable(
            deleteVersionTransportSettings, settings.deleteVersionSettings(), clientContext);
    this.deleteVersionOperationCallable =
        callableFactory.createOperationCallable(
            deleteVersionTransportSettings,
            settings.deleteVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.listFilesCallable =
        callableFactory.createUnaryCallable(
            listFilesTransportSettings, settings.listFilesSettings(), clientContext);
    this.listFilesPagedCallable =
        callableFactory.createPagedCallable(
            listFilesTransportSettings, settings.listFilesSettings(), clientContext);
    this.getFileCallable =
        callableFactory.createUnaryCallable(
            getFileTransportSettings, settings.getFileSettings(), clientContext);
    this.listTagsCallable =
        callableFactory.createUnaryCallable(
            listTagsTransportSettings, settings.listTagsSettings(), clientContext);
    this.listTagsPagedCallable =
        callableFactory.createPagedCallable(
            listTagsTransportSettings, settings.listTagsSettings(), clientContext);
    this.getTagCallable =
        callableFactory.createUnaryCallable(
            getTagTransportSettings, settings.getTagSettings(), clientContext);
    this.createTagCallable =
        callableFactory.createUnaryCallable(
            createTagTransportSettings, settings.createTagSettings(), clientContext);
    this.updateTagCallable =
        callableFactory.createUnaryCallable(
            updateTagTransportSettings, settings.updateTagSettings(), clientContext);
    this.deleteTagCallable =
        callableFactory.createUnaryCallable(
            deleteTagTransportSettings, settings.deleteTagSettings(), clientContext);
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

  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesResponse>
      listRepositoriesCallable() {
    return listRepositoriesCallable;
  }

  public UnaryCallable<ListRepositoriesRequest, ListRepositoriesPagedResponse>
      listRepositoriesPagedCallable() {
    return listRepositoriesPagedCallable;
  }

  public UnaryCallable<GetRepositoryRequest, Repository> getRepositoryCallable() {
    return getRepositoryCallable;
  }

  public UnaryCallable<CreateRepositoryRequest, Operation> createRepositoryCallable() {
    return createRepositoryCallable;
  }

  public OperationCallable<CreateRepositoryRequest, Repository, OperationMetadata>
      createRepositoryOperationCallable() {
    return createRepositoryOperationCallable;
  }

  public UnaryCallable<UpdateRepositoryRequest, Repository> updateRepositoryCallable() {
    return updateRepositoryCallable;
  }

  public UnaryCallable<DeleteRepositoryRequest, Operation> deleteRepositoryCallable() {
    return deleteRepositoryCallable;
  }

  public OperationCallable<DeleteRepositoryRequest, Empty, OperationMetadata>
      deleteRepositoryOperationCallable() {
    return deleteRepositoryOperationCallable;
  }

  public UnaryCallable<ListPackagesRequest, ListPackagesResponse> listPackagesCallable() {
    return listPackagesCallable;
  }

  public UnaryCallable<ListPackagesRequest, ListPackagesPagedResponse> listPackagesPagedCallable() {
    return listPackagesPagedCallable;
  }

  public UnaryCallable<GetPackageRequest, Package> getPackageCallable() {
    return getPackageCallable;
  }

  public UnaryCallable<DeletePackageRequest, Operation> deletePackageCallable() {
    return deletePackageCallable;
  }

  public OperationCallable<DeletePackageRequest, Empty, OperationMetadata>
      deletePackageOperationCallable() {
    return deletePackageOperationCallable;
  }

  public UnaryCallable<ListVersionsRequest, ListVersionsResponse> listVersionsCallable() {
    return listVersionsCallable;
  }

  public UnaryCallable<ListVersionsRequest, ListVersionsPagedResponse> listVersionsPagedCallable() {
    return listVersionsPagedCallable;
  }

  public UnaryCallable<GetVersionRequest, Version> getVersionCallable() {
    return getVersionCallable;
  }

  public UnaryCallable<DeleteVersionRequest, Operation> deleteVersionCallable() {
    return deleteVersionCallable;
  }

  public OperationCallable<DeleteVersionRequest, Empty, OperationMetadata>
      deleteVersionOperationCallable() {
    return deleteVersionOperationCallable;
  }

  public UnaryCallable<ListFilesRequest, ListFilesResponse> listFilesCallable() {
    return listFilesCallable;
  }

  public UnaryCallable<ListFilesRequest, ListFilesPagedResponse> listFilesPagedCallable() {
    return listFilesPagedCallable;
  }

  public UnaryCallable<GetFileRequest, File> getFileCallable() {
    return getFileCallable;
  }

  public UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable() {
    return listTagsCallable;
  }

  public UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable() {
    return listTagsPagedCallable;
  }

  public UnaryCallable<GetTagRequest, Tag> getTagCallable() {
    return getTagCallable;
  }

  public UnaryCallable<CreateTagRequest, Tag> createTagCallable() {
    return createTagCallable;
  }

  public UnaryCallable<UpdateTagRequest, Tag> updateTagCallable() {
    return updateTagCallable;
  }

  public UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable() {
    return deleteTagCallable;
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
