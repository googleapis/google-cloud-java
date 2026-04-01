/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage;

import com.google.api.core.BetaApi;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.multipartupload.model.AbortMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.AbortMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CompleteMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadRequest;
import com.google.cloud.storage.multipartupload.model.CreateMultipartUploadResponse;
import com.google.cloud.storage.multipartupload.model.ListMultipartUploadsRequest;
import com.google.cloud.storage.multipartupload.model.ListMultipartUploadsResponse;
import com.google.cloud.storage.multipartupload.model.ListPartsRequest;
import com.google.cloud.storage.multipartupload.model.ListPartsResponse;
import com.google.cloud.storage.multipartupload.model.UploadPartRequest;
import com.google.cloud.storage.multipartupload.model.UploadPartResponse;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;

/**
 * A decorator for {@link MultipartUploadClient} that adds OpenTelemetry tracing.
 *
 * @since 2.62.0 This new api is in preview and is subject to breaking changes.
 */
@BetaApi
final class OtelMultipartUploadClientDecorator extends MultipartUploadClient {

  private final MultipartUploadClient delegate;
  private final Tracer tracer;

  private OtelMultipartUploadClientDecorator(
      MultipartUploadClient delegate, OpenTelemetry otel, Attributes baseAttributes) {
    this.delegate = delegate;
    this.tracer =
        OtelStorageDecorator.TracerDecorator.decorate(
            null, otel, baseAttributes, MultipartUploadClient.class.getName() + "/");
  }

  @Override
  public CreateMultipartUploadResponse createMultipartUpload(CreateMultipartUploadRequest request) {
    Span span =
        tracer
            .spanBuilder("createMultipartUpload")
            .setAttribute(
                "gsutil.uri", String.format("gs://%s/%s", request.bucket(), request.key()))
            .startSpan();
    try (Scope ignore = span.makeCurrent()) {
      return delegate.createMultipartUpload(request);
    } catch (Throwable t) {
      span.recordException(t);
      span.setStatus(StatusCode.ERROR, t.getClass().getSimpleName());
      throw t;
    } finally {
      span.end();
    }
  }

  @Override
  public ListPartsResponse listParts(ListPartsRequest request) {
    Span span =
        tracer
            .spanBuilder("listParts")
            .setAttribute(
                "gsutil.uri", String.format("gs://%s/%s", request.bucket(), request.key()))
            .startSpan();
    try (Scope ignore = span.makeCurrent()) {
      return delegate.listParts(request);
    } catch (Throwable t) {
      span.recordException(t);
      span.setStatus(StatusCode.ERROR, t.getClass().getSimpleName());
      throw t;
    } finally {
      span.end();
    }
  }

  @Override
  public AbortMultipartUploadResponse abortMultipartUpload(AbortMultipartUploadRequest request) {
    Span span =
        tracer
            .spanBuilder("abortMultipartUpload")
            .setAttribute(
                "gsutil.uri", String.format("gs://%s/%s", request.bucket(), request.key()))
            .startSpan();
    try (Scope ignore = span.makeCurrent()) {
      return delegate.abortMultipartUpload(request);
    } catch (Throwable t) {
      span.recordException(t);
      span.setStatus(StatusCode.ERROR, t.getClass().getSimpleName());
      throw t;
    } finally {
      span.end();
    }
  }

  @Override
  public CompleteMultipartUploadResponse completeMultipartUpload(
      CompleteMultipartUploadRequest request) {
    Span span =
        tracer
            .spanBuilder("completeMultipartUpload")
            .setAttribute(
                "gsutil.uri", String.format("gs://%s/%s", request.bucket(), request.key()))
            .startSpan();
    try (Scope ignore = span.makeCurrent()) {
      return delegate.completeMultipartUpload(request);
    } catch (Throwable t) {
      span.recordException(t);
      span.setStatus(StatusCode.ERROR, t.getClass().getSimpleName());
      throw t;
    } finally {
      span.end();
    }
  }

  @Override
  public UploadPartResponse uploadPart(UploadPartRequest request, RequestBody requestBody) {
    Span span =
        tracer
            .spanBuilder("uploadPart")
            .setAttribute(
                "gsutil.uri", String.format("gs://%s/%s", request.bucket(), request.key()))
            .setAttribute("partNumber", request.partNumber())
            .startSpan();
    try (Scope ignore = span.makeCurrent()) {
      return delegate.uploadPart(request, requestBody);
    } catch (Throwable t) {
      span.recordException(t);
      span.setStatus(StatusCode.ERROR, t.getClass().getSimpleName());
      throw t;
    } finally {
      span.end();
    }
  }

  @Override
  public ListMultipartUploadsResponse listMultipartUploads(ListMultipartUploadsRequest request) {
    Span span =
        tracer
            .spanBuilder("listMultipartUploads")
            .setAttribute("gsutil.uri", String.format("gs://%s/", request.bucket()))
            .startSpan();
    try (Scope ignore = span.makeCurrent()) {
      return delegate.listMultipartUploads(request);
    } catch (Throwable t) {
      span.recordException(t);
      span.setStatus(StatusCode.ERROR, t.getClass().getSimpleName());
      throw t;
    } finally {
      span.end();
    }
  }

  static MultipartUploadClient decorate(
      MultipartUploadClient delegate, OpenTelemetry otel, Transport transport) {
    if (otel == OpenTelemetry.noop()) {
      return delegate;
    }
    Attributes baseAttributes =
        Attributes.builder()
            .put("gcp.client.service", "Storage")
            .put("gcp.client.version", StorageOptions.getDefaultInstance().getLibraryVersion())
            .put("gcp.client.repo", "googleapis/java-storage")
            .put("gcp.client.artifact", "com.google.cloud:google-cloud-storage")
            .put("rpc.system", "XML")
            .put("service.name", "storage.googleapis.com")
            .build();
    return new OtelMultipartUploadClientDecorator(delegate, otel, baseAttributes);
  }
}
