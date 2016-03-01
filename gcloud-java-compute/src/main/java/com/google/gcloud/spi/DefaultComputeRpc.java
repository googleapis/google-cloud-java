/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.spi;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.compute.Compute;
import com.google.gcloud.compute.ComputeException;
import com.google.gcloud.compute.ComputeOptions;

import java.io.IOException;

public class DefaultComputeRpc implements ComputeRpc {

  private final ComputeOptions options;
  private final Compute compute;

  public DefaultComputeRpc(ComputeOptions options) {
    HttpTransport transport = options.httpTransportFactory().create();
    HttpRequestInitializer initializer = options.httpRequestInitializer();
    this.options = options;
    compute = new Compute.Builder(transport, new JacksonFactory(), initializer)
        .setRootUrl(options.host())
        .setApplicationName(options.applicationName())
        .build();
  }

  private static ComputeException translate(IOException exception) {
    return new ComputeException(exception);
  }
}
