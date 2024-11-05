/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.firestore.telemetry;

import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.BaseApiTracer;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.threeten.bp.Duration;

/** Combines multiple {@link ApiTracer}s into a single {@link ApiTracer}. */
class CompositeApiTracer extends BaseApiTracer {
  private final List<ApiTracer> children;

  public CompositeApiTracer(List<ApiTracer> children) {
    this.children = ImmutableList.copyOf(children);
  }

  @Override
  public Scope inScope() {
    List<Scope> childScopes =
        children.stream()
            .map(ApiTracer::inScope)
            .collect(Collectors.toCollection(() -> new ArrayList<>(children.size())));

    return () -> childScopes.forEach(Scope::close);
  }

  @Override
  public void operationSucceeded() {
    children.forEach(ApiTracer::operationSucceeded);
  }

  @Override
  public void operationCancelled() {
    children.forEach(ApiTracer::operationCancelled);
  }

  @Override
  public void operationFailed(Throwable error) {
    children.forEach(child -> child.operationFailed(error));
  }

  @Override
  public void connectionSelected(String id) {
    children.forEach(child -> child.connectionSelected(id));
  }

  @Override
  public void attemptStarted(int attemptNumber) {
    children.forEach(child -> child.attemptStarted(null, attemptNumber));
  }

  @Override
  public void attemptStarted(Object request, int attemptNumber) {
    children.forEach(child -> child.attemptStarted(request, attemptNumber));
  }

  @Override
  public void attemptSucceeded() {
    children.forEach(ApiTracer::attemptSucceeded);
  }

  @Override
  public void attemptCancelled() {
    children.forEach(ApiTracer::attemptCancelled);
  }

  @Override
  public void attemptFailed(Throwable error, Duration delay) {
    children.forEach(child -> child.attemptFailed(error, delay));
  }

  @Override
  public void attemptFailedDuration(Throwable error, java.time.Duration delay) {
    children.forEach(child -> child.attemptFailedDuration(error, delay));
  }

  @Override
  public void attemptFailedRetriesExhausted(Throwable error) {
    children.forEach(child -> child.attemptFailedRetriesExhausted(error));
  }

  @Override
  public void attemptPermanentFailure(Throwable error) {
    children.forEach(child -> child.attemptPermanentFailure(error));
  }

  @Override
  public void lroStartFailed(Throwable error) {
    children.forEach(child -> child.lroStartFailed(error));
  }

  @Override
  public void lroStartSucceeded() {
    children.forEach(ApiTracer::lroStartSucceeded);
  }

  @Override
  public void responseReceived() {
    children.forEach(ApiTracer::responseReceived);
  }

  @Override
  public void requestSent() {
    children.forEach(ApiTracer::requestSent);
  }

  @Override
  public void batchRequestSent(long elementCount, long requestSize) {
    children.forEach(child -> child.batchRequestSent(elementCount, requestSize));
  }
}
