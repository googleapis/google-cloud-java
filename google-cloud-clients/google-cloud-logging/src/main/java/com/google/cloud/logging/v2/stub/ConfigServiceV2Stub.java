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
package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.ConfigClient.ListExclusionsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListSinksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Stackdriver Logging API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class ConfigServiceV2Stub implements BackgroundResource {

  public UnaryCallable<ListSinksRequest, ListSinksPagedResponse> listSinksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSinksPagedCallable()");
  }

  public UnaryCallable<ListSinksRequest, ListSinksResponse> listSinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listSinksCallable()");
  }

  public UnaryCallable<GetSinkRequest, LogSink> getSinkCallable() {
    throw new UnsupportedOperationException("Not implemented: getSinkCallable()");
  }

  public UnaryCallable<CreateSinkRequest, LogSink> createSinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createSinkCallable()");
  }

  public UnaryCallable<UpdateSinkRequest, LogSink> updateSinkCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSinkCallable()");
  }

  public UnaryCallable<DeleteSinkRequest, Empty> deleteSinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSinkCallable()");
  }

  public UnaryCallable<ListExclusionsRequest, ListExclusionsPagedResponse>
      listExclusionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExclusionsPagedCallable()");
  }

  public UnaryCallable<ListExclusionsRequest, ListExclusionsResponse> listExclusionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listExclusionsCallable()");
  }

  public UnaryCallable<GetExclusionRequest, LogExclusion> getExclusionCallable() {
    throw new UnsupportedOperationException("Not implemented: getExclusionCallable()");
  }

  public UnaryCallable<CreateExclusionRequest, LogExclusion> createExclusionCallable() {
    throw new UnsupportedOperationException("Not implemented: createExclusionCallable()");
  }

  public UnaryCallable<UpdateExclusionRequest, LogExclusion> updateExclusionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExclusionCallable()");
  }

  public UnaryCallable<DeleteExclusionRequest, Empty> deleteExclusionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExclusionCallable()");
  }

  @Override
  public abstract void close();
}
