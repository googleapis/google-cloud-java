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

package com.google.cloud.orchestration.airflow.service.v1.stub;

import static com.google.cloud.orchestration.airflow.service.v1.ImageVersionsClient.ListImageVersionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.orchestration.airflow.service.v1.ListImageVersionsRequest;
import com.google.cloud.orchestration.airflow.service.v1.ListImageVersionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ImageVersions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ImageVersionsStub implements BackgroundResource {

  public UnaryCallable<ListImageVersionsRequest, ListImageVersionsPagedResponse>
      listImageVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listImageVersionsPagedCallable()");
  }

  public UnaryCallable<ListImageVersionsRequest, ListImageVersionsResponse>
      listImageVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listImageVersionsCallable()");
  }

  @Override
  public abstract void close();
}
