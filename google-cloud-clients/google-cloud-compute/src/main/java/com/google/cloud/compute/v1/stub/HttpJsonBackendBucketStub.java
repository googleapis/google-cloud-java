/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.BackendBucketClient.ListBackendBucketsPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMessageHttpRequestFormatter;
import com.google.api.gax.httpjson.ApiMessageHttpResponseParser;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.AddSignedUrlKeyBackendBucketHttpRequest;
import com.google.cloud.compute.v1.BackendBucket;
import com.google.cloud.compute.v1.BackendBucketList;
import com.google.cloud.compute.v1.DeleteBackendBucketHttpRequest;
import com.google.cloud.compute.v1.DeleteSignedUrlKeyBackendBucketHttpRequest;
import com.google.cloud.compute.v1.GetBackendBucketHttpRequest;
import com.google.cloud.compute.v1.InsertBackendBucketHttpRequest;
import com.google.cloud.compute.v1.ListBackendBucketsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchBackendBucketHttpRequest;
import com.google.cloud.compute.v1.ProjectGlobalBackendBucketName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.UpdateBackendBucketHttpRequest;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * HTTP stub implementation for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonBackendBucketStub extends BackendBucketStub {
  @InternalApi
  public static final ApiMethodDescriptor<AddSignedUrlKeyBackendBucketHttpRequest, Operation>
      addSignedUrlKeyBackendBucketMethodDescriptor =
          ApiMethodDescriptor.<AddSignedUrlKeyBackendBucketHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.backendBuckets.addSignedUrlKey")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AddSignedUrlKeyBackendBucketHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/backendBuckets/{backendBucket}/addSignedUrlKey"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalBackendBucketName.newFactory())
                      .setResourceNameField("backendBucket")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteBackendBucketHttpRequest, Operation>
      deleteBackendBucketMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackendBucketHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.backendBuckets.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteBackendBucketHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/backendBuckets/{backendBucket}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalBackendBucketName.newFactory())
                      .setResourceNameField("backendBucket")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteSignedUrlKeyBackendBucketHttpRequest, Operation>
      deleteSignedUrlKeyBackendBucketMethodDescriptor =
          ApiMethodDescriptor.<DeleteSignedUrlKeyBackendBucketHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.backendBuckets.deleteSignedUrlKey")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<DeleteSignedUrlKeyBackendBucketHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/backendBuckets/{backendBucket}/deleteSignedUrlKey"))
                      .setQueryParams(Sets.<String>newHashSet("keyName", "requestId"))
                      .setResourceNameFactory(ProjectGlobalBackendBucketName.newFactory())
                      .setResourceNameField("backendBucket")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetBackendBucketHttpRequest, BackendBucket>
      getBackendBucketMethodDescriptor =
          ApiMethodDescriptor.<GetBackendBucketHttpRequest, BackendBucket>newBuilder()
              .setFullMethodName("compute.backendBuckets.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetBackendBucketHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/backendBuckets/{backendBucket}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalBackendBucketName.newFactory())
                      .setResourceNameField("backendBucket")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<BackendBucket>newBuilder()
                      .setResponseInstance(BackendBucket.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertBackendBucketHttpRequest, Operation>
      insertBackendBucketMethodDescriptor =
          ApiMethodDescriptor.<InsertBackendBucketHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.backendBuckets.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertBackendBucketHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/backendBuckets"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListBackendBucketsHttpRequest, BackendBucketList>
      listBackendBucketsMethodDescriptor =
          ApiMethodDescriptor.<ListBackendBucketsHttpRequest, BackendBucketList>newBuilder()
              .setFullMethodName("compute.backendBuckets.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListBackendBucketsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/backendBuckets"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<BackendBucketList>newBuilder()
                      .setResponseInstance(BackendBucketList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchBackendBucketHttpRequest, Operation>
      patchBackendBucketMethodDescriptor =
          ApiMethodDescriptor.<PatchBackendBucketHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.backendBuckets.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchBackendBucketHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/backendBuckets/{backendBucket}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalBackendBucketName.newFactory())
                      .setResourceNameField("backendBucket")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateBackendBucketHttpRequest, Operation>
      updateBackendBucketMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackendBucketHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.backendBuckets.update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<UpdateBackendBucketHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/backendBuckets/{backendBucket}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalBackendBucketName.newFactory())
                      .setResourceNameField("backendBucket")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AddSignedUrlKeyBackendBucketHttpRequest, Operation>
      addSignedUrlKeyBackendBucketCallable;
  private final UnaryCallable<DeleteBackendBucketHttpRequest, Operation>
      deleteBackendBucketCallable;
  private final UnaryCallable<DeleteSignedUrlKeyBackendBucketHttpRequest, Operation>
      deleteSignedUrlKeyBackendBucketCallable;
  private final UnaryCallable<GetBackendBucketHttpRequest, BackendBucket> getBackendBucketCallable;
  private final UnaryCallable<InsertBackendBucketHttpRequest, Operation>
      insertBackendBucketCallable;
  private final UnaryCallable<ListBackendBucketsHttpRequest, BackendBucketList>
      listBackendBucketsCallable;
  private final UnaryCallable<ListBackendBucketsHttpRequest, ListBackendBucketsPagedResponse>
      listBackendBucketsPagedCallable;
  private final UnaryCallable<PatchBackendBucketHttpRequest, Operation> patchBackendBucketCallable;
  private final UnaryCallable<UpdateBackendBucketHttpRequest, Operation>
      updateBackendBucketCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBackendBucketStub create(BackendBucketStubSettings settings)
      throws IOException {
    return new HttpJsonBackendBucketStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBackendBucketStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBackendBucketStub(
        BackendBucketStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonBackendBucketStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBackendBucketStub(
        BackendBucketStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBackendBucketStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBackendBucketStub(
      BackendBucketStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBackendBucketCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBackendBucketStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBackendBucketStub(
      BackendBucketStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddSignedUrlKeyBackendBucketHttpRequest, Operation>
        addSignedUrlKeyBackendBucketTransportSettings =
            HttpJsonCallSettings.<AddSignedUrlKeyBackendBucketHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(addSignedUrlKeyBackendBucketMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteBackendBucketHttpRequest, Operation>
        deleteBackendBucketTransportSettings =
            HttpJsonCallSettings.<DeleteBackendBucketHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteBackendBucketMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteSignedUrlKeyBackendBucketHttpRequest, Operation>
        deleteSignedUrlKeyBackendBucketTransportSettings =
            HttpJsonCallSettings.<DeleteSignedUrlKeyBackendBucketHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteSignedUrlKeyBackendBucketMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetBackendBucketHttpRequest, BackendBucket>
        getBackendBucketTransportSettings =
            HttpJsonCallSettings.<GetBackendBucketHttpRequest, BackendBucket>newBuilder()
                .setMethodDescriptor(getBackendBucketMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertBackendBucketHttpRequest, Operation>
        insertBackendBucketTransportSettings =
            HttpJsonCallSettings.<InsertBackendBucketHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertBackendBucketMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListBackendBucketsHttpRequest, BackendBucketList>
        listBackendBucketsTransportSettings =
            HttpJsonCallSettings.<ListBackendBucketsHttpRequest, BackendBucketList>newBuilder()
                .setMethodDescriptor(listBackendBucketsMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchBackendBucketHttpRequest, Operation>
        patchBackendBucketTransportSettings =
            HttpJsonCallSettings.<PatchBackendBucketHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchBackendBucketMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateBackendBucketHttpRequest, Operation>
        updateBackendBucketTransportSettings =
            HttpJsonCallSettings.<UpdateBackendBucketHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(updateBackendBucketMethodDescriptor)
                .build();

    this.addSignedUrlKeyBackendBucketCallable =
        callableFactory.createUnaryCallable(
            addSignedUrlKeyBackendBucketTransportSettings,
            settings.addSignedUrlKeyBackendBucketSettings(),
            clientContext);
    this.deleteBackendBucketCallable =
        callableFactory.createUnaryCallable(
            deleteBackendBucketTransportSettings,
            settings.deleteBackendBucketSettings(),
            clientContext);
    this.deleteSignedUrlKeyBackendBucketCallable =
        callableFactory.createUnaryCallable(
            deleteSignedUrlKeyBackendBucketTransportSettings,
            settings.deleteSignedUrlKeyBackendBucketSettings(),
            clientContext);
    this.getBackendBucketCallable =
        callableFactory.createUnaryCallable(
            getBackendBucketTransportSettings, settings.getBackendBucketSettings(), clientContext);
    this.insertBackendBucketCallable =
        callableFactory.createUnaryCallable(
            insertBackendBucketTransportSettings,
            settings.insertBackendBucketSettings(),
            clientContext);
    this.listBackendBucketsCallable =
        callableFactory.createUnaryCallable(
            listBackendBucketsTransportSettings,
            settings.listBackendBucketsSettings(),
            clientContext);
    this.listBackendBucketsPagedCallable =
        callableFactory.createPagedCallable(
            listBackendBucketsTransportSettings,
            settings.listBackendBucketsSettings(),
            clientContext);
    this.patchBackendBucketCallable =
        callableFactory.createUnaryCallable(
            patchBackendBucketTransportSettings,
            settings.patchBackendBucketSettings(),
            clientContext);
    this.updateBackendBucketCallable =
        callableFactory.createUnaryCallable(
            updateBackendBucketTransportSettings,
            settings.updateBackendBucketSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AddSignedUrlKeyBackendBucketHttpRequest, Operation>
      addSignedUrlKeyBackendBucketCallable() {
    return addSignedUrlKeyBackendBucketCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteBackendBucketHttpRequest, Operation> deleteBackendBucketCallable() {
    return deleteBackendBucketCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteSignedUrlKeyBackendBucketHttpRequest, Operation>
      deleteSignedUrlKeyBackendBucketCallable() {
    return deleteSignedUrlKeyBackendBucketCallable;
  }

  @BetaApi
  public UnaryCallable<GetBackendBucketHttpRequest, BackendBucket> getBackendBucketCallable() {
    return getBackendBucketCallable;
  }

  @BetaApi
  public UnaryCallable<InsertBackendBucketHttpRequest, Operation> insertBackendBucketCallable() {
    return insertBackendBucketCallable;
  }

  @BetaApi
  public UnaryCallable<ListBackendBucketsHttpRequest, ListBackendBucketsPagedResponse>
      listBackendBucketsPagedCallable() {
    return listBackendBucketsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListBackendBucketsHttpRequest, BackendBucketList>
      listBackendBucketsCallable() {
    return listBackendBucketsCallable;
  }

  @BetaApi
  public UnaryCallable<PatchBackendBucketHttpRequest, Operation> patchBackendBucketCallable() {
    return patchBackendBucketCallable;
  }

  @BetaApi
  public UnaryCallable<UpdateBackendBucketHttpRequest, Operation> updateBackendBucketCallable() {
    return updateBackendBucketCallable;
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
