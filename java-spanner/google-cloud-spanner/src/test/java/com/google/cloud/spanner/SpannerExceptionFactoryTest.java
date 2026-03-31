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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.cloud.spanner.SpannerException.ResourceNotFoundException;
import com.google.protobuf.Duration;
import com.google.rpc.ResourceInfo;
import com.google.rpc.RetryInfo;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.protobuf.lite.ProtoLiteUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

/** Unit tests for {@link SpannerExceptionFactory}. */
@RunWith(JUnit4.class)
public class SpannerExceptionFactoryTest {

  static SessionNotFoundException newSessionNotFoundException(String name) {
    return (SessionNotFoundException)
        newResourceNotFoundException(
            "Session", SpannerExceptionFactory.SESSION_RESOURCE_TYPE, name);
  }

  static DatabaseNotFoundException newDatabaseNotFoundException(String name) {
    return (DatabaseNotFoundException)
        newResourceNotFoundException(
            "Database", SpannerExceptionFactory.DATABASE_RESOURCE_TYPE, name);
  }

  static StatusRuntimeException newStatusDatabaseNotFoundException(String name) {
    return newStatusResourceNotFoundException(
        "Database", SpannerExceptionFactory.DATABASE_RESOURCE_TYPE, name);
  }

  static InstanceNotFoundException newInstanceNotFoundException(String name) {
    return (InstanceNotFoundException)
        newResourceNotFoundException(
            "Instance", SpannerExceptionFactory.INSTANCE_RESOURCE_TYPE, name);
  }

  static StatusRuntimeException newStatusResourceNotFoundException(
      String shortName, String resourceType, String resourceName) {
    ResourceInfo resourceInfo =
        ResourceInfo.newBuilder()
            .setResourceType(resourceType)
            .setResourceName(resourceName)
            .build();
    Metadata.Key<ResourceInfo> key =
        Metadata.Key.of(
            resourceInfo.getDescriptorForType().getFullName() + Metadata.BINARY_HEADER_SUFFIX,
            ProtoLiteUtils.metadataMarshaller(resourceInfo));
    Metadata trailers = new Metadata();
    trailers.put(key, resourceInfo);
    String message =
        String.format("%s not found: %s with id %s not found", shortName, shortName, resourceName);
    return Status.NOT_FOUND.withDescription(message).asRuntimeException(trailers);
  }

  private static ResourceNotFoundException newResourceNotFoundException(
      String shortName, String resourceType, String resourceName) {
    return (ResourceNotFoundException)
        SpannerExceptionFactory.newSpannerException(
            newStatusResourceNotFoundException(shortName, resourceType, resourceName));
  }

  @Test
  public void http2InternalErrorIsRetryable() {
    Status status =
        Status.fromCodeValue(Status.Code.INTERNAL.value())
            .withDescription("HTTP/2 error code: INTERNAL_ERROR");
    SpannerException e =
        SpannerExceptionFactory.newSpannerException(new StatusRuntimeException(status));
    assertThat(e.isRetryable()).isTrue();
  }

  @Test
  public void connectionClosedIsRetryable() {
    Status status =
        Status.fromCodeValue(Status.Code.INTERNAL.value())
            .withDescription("Connection closed with unknown cause");
    SpannerException e =
        SpannerExceptionFactory.newSpannerException(new StatusRuntimeException(status));
    assertThat(e.isRetryable()).isTrue();
  }

  @Test
  public void resourceExhausted() {
    Status status =
        Status.fromCodeValue(Status.Code.RESOURCE_EXHAUSTED.value())
            .withDescription("Memory pushback");
    SpannerException e =
        SpannerExceptionFactory.newSpannerException(new StatusRuntimeException(status));
    assertThat(e.isRetryable()).isFalse();
  }

  @Test
  public void resourceExhaustedWithBackoff() {
    Status status =
        Status.fromCodeValue(Status.Code.RESOURCE_EXHAUSTED.value())
            .withDescription("Memory pushback");
    Metadata trailers = new Metadata();
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(Duration.newBuilder().setNanos(1000000).setSeconds(1L))
            .build();
    trailers.put(key, retryInfo);
    SpannerException e =
        SpannerExceptionFactory.newSpannerException(new StatusRuntimeException(status, trailers));
    assertThat(e.isRetryable()).isTrue();
    assertThat(e.getRetryDelayInMillis()).isEqualTo(1001);
  }

  @Test
  public void abortWithRetryInfo() {
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    Status status = Status.fromCodeValue(Status.Code.ABORTED.value());
    Metadata trailers = new Metadata();
    RetryInfo retryInfo =
        RetryInfo.newBuilder()
            .setRetryDelay(Duration.newBuilder().setNanos(1000000).setSeconds(1L))
            .build();
    trailers.put(key, retryInfo);
    SpannerException e =
        SpannerExceptionFactory.newSpannerException(new StatusRuntimeException(status, trailers));
    assertThat(e).isInstanceOf(AbortedException.class);
    assertThat(e.getRetryDelayInMillis()).isEqualTo(1001L);
  }

  @Test
  public void abortWithoutRetryInfo() {
    Status status = Status.fromCodeValue(Status.Code.ABORTED.value());
    SpannerException e =
        SpannerExceptionFactory.newSpannerException(new StatusRuntimeException(status));
    assertThat(e).isInstanceOf(AbortedException.class);
    assertThat(e.getRetryDelayInMillis()).isEqualTo(-1L);
  }

  @Test
  public void abortWithoutDuration() {
    Metadata.Key<RetryInfo> key = ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
    Status status = Status.fromCodeValue(Status.Code.ABORTED.value());
    Metadata trailers = new Metadata();
    trailers.put(key, RetryInfo.getDefaultInstance());
    SpannerException e =
        SpannerExceptionFactory.newSpannerException(new StatusRuntimeException(status, trailers));
    assertThat(e).isInstanceOf(AbortedException.class);
    assertThat(e.getRetryDelayInMillis()).isEqualTo(-1L);
  }

  @Test
  public void nullCancel() {
    Context context = Mockito.mock(Context.class);
    Mockito.when(context.isCancelled()).thenReturn(true);
    Mockito.when(context.cancellationCause()).thenReturn(null);
    SpannerException spannerException =
        SpannerExceptionFactory.newSpannerExceptionForCancellation(context, null);
    assertThat(spannerException.getMessage()).isEqualTo("CANCELLED: Current context was cancelled");
  }

  @Test
  public void sessionNotFound() {
    SessionNotFoundException e =
        newSessionNotFoundException("projects/p/instances/i/databases/d/sessions/s");
    assertThat(e.getResourceName()).isEqualTo("projects/p/instances/i/databases/d/sessions/s");
  }

  @Test
  public void databaseNotFound() {
    DatabaseNotFoundException e =
        newDatabaseNotFoundException("projects/p/instances/i/databases/d");
    assertThat(e.getResourceName()).isEqualTo("projects/p/instances/i/databases/d");
  }

  @Test
  public void instanceNotFound() {
    InstanceNotFoundException e = newInstanceNotFoundException("projects/p/instances/i");
    assertThat(e.getResourceName()).isEqualTo("projects/p/instances/i");
  }

  @Test
  public void statusRuntimeExceptionSessionNotFound() {
    SpannerException spannerException =
        SpannerExceptionFactory.newSpannerException(
            Status.NOT_FOUND
                .withDescription(
                    "NOT_FOUND: Session not found: projects/p/instances/i/databases/d/sessions/s")
                .asRuntimeException(
                    createResourceTypeMetadata(
                        SpannerExceptionFactory.SESSION_RESOURCE_TYPE,
                        "projects/p/instances/i/databases/d/sessions/s")));
    assertThat(spannerException).isInstanceOf(SessionNotFoundException.class);
  }

  @Test
  public void apiExceptionSessionNotFound() {
    SpannerException spannerException =
        SpannerExceptionFactory.newSpannerException(
            ApiExceptionFactory.createException(
                "NOT_FOUND: Session not found: projects/p/instances/i/databases/d/sessions/s",
                Status.NOT_FOUND
                    .withDescription(
                        "NOT_FOUND: Session not found:"
                            + " projects/p/instances/i/databases/d/sessions/s")
                    .asRuntimeException(
                        createResourceTypeMetadata(
                            SpannerExceptionFactory.SESSION_RESOURCE_TYPE,
                            "projects/p/instances/i/databases/d/sessions/s")),
                GrpcStatusCode.of(Code.NOT_FOUND),
                false));
    assertThat(spannerException).isInstanceOf(SessionNotFoundException.class);
  }

  private Metadata createResourceTypeMetadata(String resourceType, String resourceName) {
    ResourceInfo resourceInfo =
        ResourceInfo.newBuilder()
            .setResourceType(resourceType)
            .setResourceName(resourceName)
            .build();
    Metadata.Key<ResourceInfo> key =
        Metadata.Key.of(
            resourceInfo.getDescriptorForType().getFullName() + Metadata.BINARY_HEADER_SUFFIX,
            ProtoLiteUtils.metadataMarshaller(resourceInfo));
    Metadata trailers = new Metadata();
    trailers.put(key, resourceInfo);

    return trailers;
  }
}
