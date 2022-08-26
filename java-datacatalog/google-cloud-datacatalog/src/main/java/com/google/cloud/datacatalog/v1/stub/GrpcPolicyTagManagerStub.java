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

package com.google.cloud.datacatalog.v1.stub;

import static com.google.cloud.datacatalog.v1.PolicyTagManagerClient.ListPolicyTagsPagedResponse;
import static com.google.cloud.datacatalog.v1.PolicyTagManagerClient.ListTaxonomiesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.v1.CreatePolicyTagRequest;
import com.google.cloud.datacatalog.v1.CreateTaxonomyRequest;
import com.google.cloud.datacatalog.v1.DeletePolicyTagRequest;
import com.google.cloud.datacatalog.v1.DeleteTaxonomyRequest;
import com.google.cloud.datacatalog.v1.GetPolicyTagRequest;
import com.google.cloud.datacatalog.v1.GetTaxonomyRequest;
import com.google.cloud.datacatalog.v1.ListPolicyTagsRequest;
import com.google.cloud.datacatalog.v1.ListPolicyTagsResponse;
import com.google.cloud.datacatalog.v1.ListTaxonomiesRequest;
import com.google.cloud.datacatalog.v1.ListTaxonomiesResponse;
import com.google.cloud.datacatalog.v1.PolicyTag;
import com.google.cloud.datacatalog.v1.Taxonomy;
import com.google.cloud.datacatalog.v1.UpdatePolicyTagRequest;
import com.google.cloud.datacatalog.v1.UpdateTaxonomyRequest;
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
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the PolicyTagManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcPolicyTagManagerStub extends PolicyTagManagerStub {
  private static final MethodDescriptor<CreateTaxonomyRequest, Taxonomy>
      createTaxonomyMethodDescriptor =
          MethodDescriptor.<CreateTaxonomyRequest, Taxonomy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/CreateTaxonomy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Taxonomy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTaxonomyRequest, Empty>
      deleteTaxonomyMethodDescriptor =
          MethodDescriptor.<DeleteTaxonomyRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/DeleteTaxonomy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTaxonomyRequest, Taxonomy>
      updateTaxonomyMethodDescriptor =
          MethodDescriptor.<UpdateTaxonomyRequest, Taxonomy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/UpdateTaxonomy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTaxonomyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Taxonomy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTaxonomiesRequest, ListTaxonomiesResponse>
      listTaxonomiesMethodDescriptor =
          MethodDescriptor.<ListTaxonomiesRequest, ListTaxonomiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/ListTaxonomies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTaxonomiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTaxonomiesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTaxonomyRequest, Taxonomy> getTaxonomyMethodDescriptor =
      MethodDescriptor.<GetTaxonomyRequest, Taxonomy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/GetTaxonomy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTaxonomyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Taxonomy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreatePolicyTagRequest, PolicyTag>
      createPolicyTagMethodDescriptor =
          MethodDescriptor.<CreatePolicyTagRequest, PolicyTag>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/CreatePolicyTag")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePolicyTagRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PolicyTag.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeletePolicyTagRequest, Empty>
      deletePolicyTagMethodDescriptor =
          MethodDescriptor.<DeletePolicyTagRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/DeletePolicyTag")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePolicyTagRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdatePolicyTagRequest, PolicyTag>
      updatePolicyTagMethodDescriptor =
          MethodDescriptor.<UpdatePolicyTagRequest, PolicyTag>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/UpdatePolicyTag")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePolicyTagRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PolicyTag.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPolicyTagsRequest, ListPolicyTagsResponse>
      listPolicyTagsMethodDescriptor =
          MethodDescriptor.<ListPolicyTagsRequest, ListPolicyTagsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/ListPolicyTags")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPolicyTagsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPolicyTagsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPolicyTagRequest, PolicyTag>
      getPolicyTagMethodDescriptor =
          MethodDescriptor.<GetPolicyTagRequest, PolicyTag>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/GetPolicyTag")
              .setRequestMarshaller(ProtoUtils.marshaller(GetPolicyTagRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PolicyTag.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.datacatalog.v1.PolicyTagManager/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateTaxonomyRequest, Taxonomy> createTaxonomyCallable;
  private final UnaryCallable<DeleteTaxonomyRequest, Empty> deleteTaxonomyCallable;
  private final UnaryCallable<UpdateTaxonomyRequest, Taxonomy> updateTaxonomyCallable;
  private final UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesResponse> listTaxonomiesCallable;
  private final UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesPagedResponse>
      listTaxonomiesPagedCallable;
  private final UnaryCallable<GetTaxonomyRequest, Taxonomy> getTaxonomyCallable;
  private final UnaryCallable<CreatePolicyTagRequest, PolicyTag> createPolicyTagCallable;
  private final UnaryCallable<DeletePolicyTagRequest, Empty> deletePolicyTagCallable;
  private final UnaryCallable<UpdatePolicyTagRequest, PolicyTag> updatePolicyTagCallable;
  private final UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsResponse> listPolicyTagsCallable;
  private final UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsPagedResponse>
      listPolicyTagsPagedCallable;
  private final UnaryCallable<GetPolicyTagRequest, PolicyTag> getPolicyTagCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPolicyTagManagerStub create(PolicyTagManagerStubSettings settings)
      throws IOException {
    return new GrpcPolicyTagManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPolicyTagManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPolicyTagManagerStub(
        PolicyTagManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPolicyTagManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPolicyTagManagerStub(
        PolicyTagManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPolicyTagManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPolicyTagManagerStub(
      PolicyTagManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcPolicyTagManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPolicyTagManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPolicyTagManagerStub(
      PolicyTagManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateTaxonomyRequest, Taxonomy> createTaxonomyTransportSettings =
        GrpcCallSettings.<CreateTaxonomyRequest, Taxonomy>newBuilder()
            .setMethodDescriptor(createTaxonomyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteTaxonomyRequest, Empty> deleteTaxonomyTransportSettings =
        GrpcCallSettings.<DeleteTaxonomyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTaxonomyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateTaxonomyRequest, Taxonomy> updateTaxonomyTransportSettings =
        GrpcCallSettings.<UpdateTaxonomyRequest, Taxonomy>newBuilder()
            .setMethodDescriptor(updateTaxonomyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("taxonomy.name", String.valueOf(request.getTaxonomy().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListTaxonomiesRequest, ListTaxonomiesResponse>
        listTaxonomiesTransportSettings =
            GrpcCallSettings.<ListTaxonomiesRequest, ListTaxonomiesResponse>newBuilder()
                .setMethodDescriptor(listTaxonomiesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetTaxonomyRequest, Taxonomy> getTaxonomyTransportSettings =
        GrpcCallSettings.<GetTaxonomyRequest, Taxonomy>newBuilder()
            .setMethodDescriptor(getTaxonomyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreatePolicyTagRequest, PolicyTag> createPolicyTagTransportSettings =
        GrpcCallSettings.<CreatePolicyTagRequest, PolicyTag>newBuilder()
            .setMethodDescriptor(createPolicyTagMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeletePolicyTagRequest, Empty> deletePolicyTagTransportSettings =
        GrpcCallSettings.<DeletePolicyTagRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePolicyTagMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdatePolicyTagRequest, PolicyTag> updatePolicyTagTransportSettings =
        GrpcCallSettings.<UpdatePolicyTagRequest, PolicyTag>newBuilder()
            .setMethodDescriptor(updatePolicyTagMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("policy_tag.name", String.valueOf(request.getPolicyTag().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListPolicyTagsRequest, ListPolicyTagsResponse>
        listPolicyTagsTransportSettings =
            GrpcCallSettings.<ListPolicyTagsRequest, ListPolicyTagsResponse>newBuilder()
                .setMethodDescriptor(listPolicyTagsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetPolicyTagRequest, PolicyTag> getPolicyTagTransportSettings =
        GrpcCallSettings.<GetPolicyTagRequest, PolicyTag>newBuilder()
            .setMethodDescriptor(getPolicyTagMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
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

    this.createTaxonomyCallable =
        callableFactory.createUnaryCallable(
            createTaxonomyTransportSettings, settings.createTaxonomySettings(), clientContext);
    this.deleteTaxonomyCallable =
        callableFactory.createUnaryCallable(
            deleteTaxonomyTransportSettings, settings.deleteTaxonomySettings(), clientContext);
    this.updateTaxonomyCallable =
        callableFactory.createUnaryCallable(
            updateTaxonomyTransportSettings, settings.updateTaxonomySettings(), clientContext);
    this.listTaxonomiesCallable =
        callableFactory.createUnaryCallable(
            listTaxonomiesTransportSettings, settings.listTaxonomiesSettings(), clientContext);
    this.listTaxonomiesPagedCallable =
        callableFactory.createPagedCallable(
            listTaxonomiesTransportSettings, settings.listTaxonomiesSettings(), clientContext);
    this.getTaxonomyCallable =
        callableFactory.createUnaryCallable(
            getTaxonomyTransportSettings, settings.getTaxonomySettings(), clientContext);
    this.createPolicyTagCallable =
        callableFactory.createUnaryCallable(
            createPolicyTagTransportSettings, settings.createPolicyTagSettings(), clientContext);
    this.deletePolicyTagCallable =
        callableFactory.createUnaryCallable(
            deletePolicyTagTransportSettings, settings.deletePolicyTagSettings(), clientContext);
    this.updatePolicyTagCallable =
        callableFactory.createUnaryCallable(
            updatePolicyTagTransportSettings, settings.updatePolicyTagSettings(), clientContext);
    this.listPolicyTagsCallable =
        callableFactory.createUnaryCallable(
            listPolicyTagsTransportSettings, settings.listPolicyTagsSettings(), clientContext);
    this.listPolicyTagsPagedCallable =
        callableFactory.createPagedCallable(
            listPolicyTagsTransportSettings, settings.listPolicyTagsSettings(), clientContext);
    this.getPolicyTagCallable =
        callableFactory.createUnaryCallable(
            getPolicyTagTransportSettings, settings.getPolicyTagSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
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
  public UnaryCallable<CreateTaxonomyRequest, Taxonomy> createTaxonomyCallable() {
    return createTaxonomyCallable;
  }

  @Override
  public UnaryCallable<DeleteTaxonomyRequest, Empty> deleteTaxonomyCallable() {
    return deleteTaxonomyCallable;
  }

  @Override
  public UnaryCallable<UpdateTaxonomyRequest, Taxonomy> updateTaxonomyCallable() {
    return updateTaxonomyCallable;
  }

  @Override
  public UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesResponse> listTaxonomiesCallable() {
    return listTaxonomiesCallable;
  }

  @Override
  public UnaryCallable<ListTaxonomiesRequest, ListTaxonomiesPagedResponse>
      listTaxonomiesPagedCallable() {
    return listTaxonomiesPagedCallable;
  }

  @Override
  public UnaryCallable<GetTaxonomyRequest, Taxonomy> getTaxonomyCallable() {
    return getTaxonomyCallable;
  }

  @Override
  public UnaryCallable<CreatePolicyTagRequest, PolicyTag> createPolicyTagCallable() {
    return createPolicyTagCallable;
  }

  @Override
  public UnaryCallable<DeletePolicyTagRequest, Empty> deletePolicyTagCallable() {
    return deletePolicyTagCallable;
  }

  @Override
  public UnaryCallable<UpdatePolicyTagRequest, PolicyTag> updatePolicyTagCallable() {
    return updatePolicyTagCallable;
  }

  @Override
  public UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsResponse> listPolicyTagsCallable() {
    return listPolicyTagsCallable;
  }

  @Override
  public UnaryCallable<ListPolicyTagsRequest, ListPolicyTagsPagedResponse>
      listPolicyTagsPagedCallable() {
    return listPolicyTagsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPolicyTagRequest, PolicyTag> getPolicyTagCallable() {
    return getPolicyTagCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
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
