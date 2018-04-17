/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFunction;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationSnapshot;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/** A wrapper class to augment proto results returned from get() */
public class TransformingOperationFuture<ResponseT, RawResponseT, MetadataT>
    implements OperationFuture<ResponseT, MetadataT> {

  private OperationFuture<RawResponseT, MetadataT> rawOperationFuture;
  private ApiFunction<RawResponseT, ResponseT> transformingFunction;

  public TransformingOperationFuture(
      OperationFuture<RawResponseT, MetadataT> rawOperationFuture,
      ApiFunction<RawResponseT, ResponseT> transformingFunction) {
    checkNotNull(rawOperationFuture);
    checkNotNull(transformingFunction);
    this.rawOperationFuture = rawOperationFuture;
    this.transformingFunction = transformingFunction;
  }

  public ApiFuture<OperationSnapshot> getInitialFuture() {
    return rawOperationFuture.getInitialFuture();
  }

  public ApiFuture<MetadataT> getMetadata() {
    return rawOperationFuture.getMetadata();
  }

  public String getName() throws InterruptedException, ExecutionException {
    return rawOperationFuture.getName();
  }

  public ApiFuture<MetadataT> peekMetadata() {
    return rawOperationFuture.peekMetadata();
  }

  public void addListener(Runnable listener, Executor executor) {
    rawOperationFuture.addListener(listener, executor);
  }

  public boolean cancel(boolean mayInterruptIfRunning) {
    return rawOperationFuture.cancel(mayInterruptIfRunning);
  }
  
  public boolean isCancelled() {
    return rawOperationFuture.isCancelled();
  }

  public boolean isDone() {
    return rawOperationFuture.isDone();
  }

  public ResponseT get() throws InterruptedException, ExecutionException {
    return transformingFunction.apply(rawOperationFuture.get());
  }

  public ResponseT get(long timeout, TimeUnit unit) throws 
      InterruptedException, ExecutionException, TimeoutException {
    return transformingFunction.apply(rawOperationFuture.get());
  }
}