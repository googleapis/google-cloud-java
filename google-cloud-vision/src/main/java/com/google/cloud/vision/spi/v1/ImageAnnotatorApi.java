/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.vision.spi.v1;

import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.BatchAnnotateImagesRequest;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service that performs Google Cloud Vision API detection tasks, such as face,
 * landmark, logo, label, and text detection, over client images, and returns
 * detected entities from the images.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ImageAnnotatorApi imageAnnotatorApi = ImageAnnotatorApi.create()) {
 *   List&lt;AnnotateImageRequest&gt; requests = new ArrayList&lt;&gt;();
 *   BatchAnnotateImagesResponse response = imageAnnotatorApi.batchAnnotateImages(requests);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the imageAnnotatorApi object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * ApiCallable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of ImageAnnotatorSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * ImageAnnotatorSettings imageAnnotatorSettings = ImageAnnotatorSettings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * ImageAnnotatorApi imageAnnotatorApi = ImageAnnotatorApi.create(imageAnnotatorSettings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class ImageAnnotatorApi implements AutoCloseable {
  private final ImageAnnotatorSettings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesCallable;

  /**
   * Constructs an instance of ImageAnnotatorApi with default settings.
   */
  public static final ImageAnnotatorApi create() throws IOException {
    return create(ImageAnnotatorSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of ImageAnnotatorApi, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final ImageAnnotatorApi create(ImageAnnotatorSettings settings) throws IOException {
    return new ImageAnnotatorApi(settings);
  }

  /**
   * Constructs an instance of ImageAnnotatorApi, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected ImageAnnotatorApi(ImageAnnotatorSettings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.batchAnnotateImagesCallable =
        ApiCallable.create(settings.batchAnnotateImagesSettings(), this.channel, this.executor);

    if (settings.getChannelProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              channel.shutdown();
            }
          });
    }
    if (settings.getExecutorProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              executor.shutdown();
            }
          });
    }
  }

  public final ImageAnnotatorSettings getSettings() {
    return settings;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run image detection and annotation for a batch of images.
   *
   * Sample code:
   * <pre><code>
   * try (ImageAnnotatorApi imageAnnotatorApi = ImageAnnotatorApi.create()) {
   *   List&lt;AnnotateImageRequest&gt; requests = new ArrayList&lt;&gt;();
   *   BatchAnnotateImagesResponse response = imageAnnotatorApi.batchAnnotateImages(requests);
   * }
   * </code></pre>
   *
   * @param requests Individual image annotation requests for this batch.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final BatchAnnotateImagesResponse batchAnnotateImages(
      List<AnnotateImageRequest> requests) {
    BatchAnnotateImagesRequest request =
        BatchAnnotateImagesRequest.newBuilder().addAllRequests(requests).build();
    return batchAnnotateImages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run image detection and annotation for a batch of images.
   *
   * Sample code:
   * <pre><code>
   * try (ImageAnnotatorApi imageAnnotatorApi = ImageAnnotatorApi.create()) {
   *   List&lt;AnnotateImageRequest&gt; requests = new ArrayList&lt;&gt;();
   *   BatchAnnotateImagesRequest request = BatchAnnotateImagesRequest.newBuilder()
   *     .addAllRequests(requests)
   *     .build();
   *   BatchAnnotateImagesResponse response = imageAnnotatorApi.batchAnnotateImages(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final BatchAnnotateImagesResponse batchAnnotateImages(
      BatchAnnotateImagesRequest request) {
    return batchAnnotateImagesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Run image detection and annotation for a batch of images.
   *
   * Sample code:
   * <pre><code>
   * try (ImageAnnotatorApi imageAnnotatorApi = ImageAnnotatorApi.create()) {
   *   List&lt;AnnotateImageRequest&gt; requests = new ArrayList&lt;&gt;();
   *   BatchAnnotateImagesRequest request = BatchAnnotateImagesRequest.newBuilder()
   *     .addAllRequests(requests)
   *     .build();
   *   ListenableFuture&lt;BatchAnnotateImagesResponse&gt; future = imageAnnotatorApi.batchAnnotateImagesCallable().futureCall(request);
   *   // Do something
   *   BatchAnnotateImagesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesCallable() {
    return batchAnnotateImagesCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }
}
