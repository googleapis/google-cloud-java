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

package com.google.dataflow.v1beta3.stub;

import static com.google.dataflow.v1beta3.MessagesV1Beta3Client.ListJobMessagesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.dataflow.v1beta3.ListJobMessagesRequest;
import com.google.dataflow.v1beta3.ListJobMessagesResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MessagesV1Beta3 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class MessagesV1Beta3Stub implements BackgroundResource {

  public UnaryCallable<ListJobMessagesRequest, ListJobMessagesPagedResponse>
      listJobMessagesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobMessagesPagedCallable()");
  }

  public UnaryCallable<ListJobMessagesRequest, ListJobMessagesResponse> listJobMessagesCallable() {
    throw new UnsupportedOperationException("Not implemented: listJobMessagesCallable()");
  }

  @Override
  public abstract void close();
}
