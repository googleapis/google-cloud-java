/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.ImageClient.ListImagesPagedResponse;

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
import com.google.cloud.compute.v1.DeleteImageHttpRequest;
import com.google.cloud.compute.v1.DeprecateImageHttpRequest;
import com.google.cloud.compute.v1.GetFromFamilyImageHttpRequest;
import com.google.cloud.compute.v1.GetImageHttpRequest;
import com.google.cloud.compute.v1.Image;
import com.google.cloud.compute.v1.ImageList;
import com.google.cloud.compute.v1.InsertImageHttpRequest;
import com.google.cloud.compute.v1.ListImagesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalImageFamilyName;
import com.google.cloud.compute.v1.ProjectGlobalImageName;
import com.google.cloud.compute.v1.ProjectGlobalImageResourceName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.SetLabelsImageHttpRequest;
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
public class HttpJsonImageStub extends ImageStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteImageHttpRequest, Operation>
      deleteImageMethodDescriptor =
          ApiMethodDescriptor.<DeleteImageHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.images.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteImageHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/images/{image}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalImageName.newFactory())
                      .setResourceNameField("image")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeprecateImageHttpRequest, Operation>
      deprecateImageMethodDescriptor =
          ApiMethodDescriptor.<DeprecateImageHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.images.deprecate")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeprecateImageHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/images/{image}/deprecate"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalImageName.newFactory())
                      .setResourceNameField("image")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetImageHttpRequest, Image> getImageMethodDescriptor =
      ApiMethodDescriptor.<GetImageHttpRequest, Image>newBuilder()
          .setFullMethodName("compute.images.get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ApiMessageHttpRequestFormatter.<GetImageHttpRequest>newBuilder()
                  .setPathTemplate(PathTemplate.create("{project}/global/images/{image}"))
                  .setQueryParams(Sets.<String>newHashSet())
                  .setResourceNameFactory(ProjectGlobalImageName.newFactory())
                  .setResourceNameField("image")
                  .build())
          .setResponseParser(
              ApiMessageHttpResponseParser.<Image>newBuilder()
                  .setResponseInstance(Image.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetFromFamilyImageHttpRequest, Image>
      getFromFamilyImageMethodDescriptor =
          ApiMethodDescriptor.<GetFromFamilyImageHttpRequest, Image>newBuilder()
              .setFullMethodName("compute.images.getFromFamily")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetFromFamilyImageHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/images/family/{family}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalImageFamilyName.newFactory())
                      .setResourceNameField("family")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Image>newBuilder()
                      .setResponseInstance(Image.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertImageHttpRequest, Operation>
      insertImageMethodDescriptor =
          ApiMethodDescriptor.<InsertImageHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.images.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertImageHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/images"))
                      .setQueryParams(Sets.<String>newHashSet("forceCreate", "requestId"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListImagesHttpRequest, ImageList>
      listImagesMethodDescriptor =
          ApiMethodDescriptor.<ListImagesHttpRequest, ImageList>newBuilder()
              .setFullMethodName("compute.images.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListImagesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/images"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<ImageList>newBuilder()
                      .setResponseInstance(ImageList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetLabelsImageHttpRequest, Operation>
      setLabelsImageMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsImageHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.images.setLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetLabelsImageHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/images/{resource}/setLabels"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalImageResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteImageHttpRequest, Operation> deleteImageCallable;
  private final UnaryCallable<DeprecateImageHttpRequest, Operation> deprecateImageCallable;
  private final UnaryCallable<GetImageHttpRequest, Image> getImageCallable;
  private final UnaryCallable<GetFromFamilyImageHttpRequest, Image> getFromFamilyImageCallable;
  private final UnaryCallable<InsertImageHttpRequest, Operation> insertImageCallable;
  private final UnaryCallable<ListImagesHttpRequest, ImageList> listImagesCallable;
  private final UnaryCallable<ListImagesHttpRequest, ListImagesPagedResponse>
      listImagesPagedCallable;
  private final UnaryCallable<SetLabelsImageHttpRequest, Operation> setLabelsImageCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonImageStub create(ImageStubSettings settings) throws IOException {
    return new HttpJsonImageStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonImageStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonImageStub(ImageStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonImageStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonImageStub(
        ImageStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonImageStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonImageStub(ImageStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonImageCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonImageStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonImageStub(
      ImageStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteImageHttpRequest, Operation> deleteImageTransportSettings =
        HttpJsonCallSettings.<DeleteImageHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteImageMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeprecateImageHttpRequest, Operation> deprecateImageTransportSettings =
        HttpJsonCallSettings.<DeprecateImageHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deprecateImageMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetImageHttpRequest, Image> getImageTransportSettings =
        HttpJsonCallSettings.<GetImageHttpRequest, Image>newBuilder()
            .setMethodDescriptor(getImageMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetFromFamilyImageHttpRequest, Image> getFromFamilyImageTransportSettings =
        HttpJsonCallSettings.<GetFromFamilyImageHttpRequest, Image>newBuilder()
            .setMethodDescriptor(getFromFamilyImageMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertImageHttpRequest, Operation> insertImageTransportSettings =
        HttpJsonCallSettings.<InsertImageHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertImageMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListImagesHttpRequest, ImageList> listImagesTransportSettings =
        HttpJsonCallSettings.<ListImagesHttpRequest, ImageList>newBuilder()
            .setMethodDescriptor(listImagesMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetLabelsImageHttpRequest, Operation> setLabelsImageTransportSettings =
        HttpJsonCallSettings.<SetLabelsImageHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsImageMethodDescriptor)
            .build();

    this.deleteImageCallable =
        callableFactory.createUnaryCallable(
            deleteImageTransportSettings, settings.deleteImageSettings(), clientContext);
    this.deprecateImageCallable =
        callableFactory.createUnaryCallable(
            deprecateImageTransportSettings, settings.deprecateImageSettings(), clientContext);
    this.getImageCallable =
        callableFactory.createUnaryCallable(
            getImageTransportSettings, settings.getImageSettings(), clientContext);
    this.getFromFamilyImageCallable =
        callableFactory.createUnaryCallable(
            getFromFamilyImageTransportSettings,
            settings.getFromFamilyImageSettings(),
            clientContext);
    this.insertImageCallable =
        callableFactory.createUnaryCallable(
            insertImageTransportSettings, settings.insertImageSettings(), clientContext);
    this.listImagesCallable =
        callableFactory.createUnaryCallable(
            listImagesTransportSettings, settings.listImagesSettings(), clientContext);
    this.listImagesPagedCallable =
        callableFactory.createPagedCallable(
            listImagesTransportSettings, settings.listImagesSettings(), clientContext);
    this.setLabelsImageCallable =
        callableFactory.createUnaryCallable(
            setLabelsImageTransportSettings, settings.setLabelsImageSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteImageHttpRequest, Operation> deleteImageCallable() {
    return deleteImageCallable;
  }

  @BetaApi
  public UnaryCallable<DeprecateImageHttpRequest, Operation> deprecateImageCallable() {
    return deprecateImageCallable;
  }

  @BetaApi
  public UnaryCallable<GetImageHttpRequest, Image> getImageCallable() {
    return getImageCallable;
  }

  @BetaApi
  public UnaryCallable<GetFromFamilyImageHttpRequest, Image> getFromFamilyImageCallable() {
    return getFromFamilyImageCallable;
  }

  @BetaApi
  public UnaryCallable<InsertImageHttpRequest, Operation> insertImageCallable() {
    return insertImageCallable;
  }

  @BetaApi
  public UnaryCallable<ListImagesHttpRequest, ListImagesPagedResponse> listImagesPagedCallable() {
    return listImagesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListImagesHttpRequest, ImageList> listImagesCallable() {
    return listImagesCallable;
  }

  @BetaApi
  public UnaryCallable<SetLabelsImageHttpRequest, Operation> setLabelsImageCallable() {
    return setLabelsImageCallable;
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
