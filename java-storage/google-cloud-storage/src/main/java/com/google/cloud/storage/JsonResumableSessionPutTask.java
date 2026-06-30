/*
 * Copyright 2023 Google LLC
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

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.HttpContentRange.HasRange;
import com.google.cloud.storage.StorageException.IOExceptionCallable;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.opencensus.common.Scope;
import io.opencensus.trace.Span;
import io.opencensus.trace.Status;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import org.checkerframework.checker.nullness.qual.Nullable;

final class JsonResumableSessionPutTask
    implements Callable<ResumableOperationResult<@Nullable StorageObject>> {

  private final HttpClientContext context;
  private final JsonResumableWrite jsonResumableWrite;
  private final RewindableContent content;
  private final HttpContentRange originalContentRange;
  private final @Nullable Crc32cValue<?> cumulativeCrc32c;

  private HttpContentRange contentRange;

  @VisibleForTesting
  JsonResumableSessionPutTask(
      HttpClientContext httpClientContext,
      JsonResumableWrite jsonResumableWrite,
      RewindableContent content,
      HttpContentRange originalContentRange) {
    this(httpClientContext, jsonResumableWrite, content, originalContentRange, null);
  }

  @VisibleForTesting
  JsonResumableSessionPutTask(
      HttpClientContext httpClientContext,
      JsonResumableWrite jsonResumableWrite,
      RewindableContent content,
      HttpContentRange originalContentRange,
      @Nullable Crc32cValue<?> cumulativeCrc32c) {
    this.context = httpClientContext;
    this.jsonResumableWrite = jsonResumableWrite;
    this.content = content;
    this.originalContentRange = originalContentRange;
    this.contentRange = originalContentRange;
    this.cumulativeCrc32c = cumulativeCrc32c;
  }

  public void rewindTo(long offset) {
    if (originalContentRange instanceof HasRange<?>) {
      HasRange<?> hasRange = (HasRange<?>) originalContentRange;
      ByteRangeSpec range = hasRange.range();
      long originalBegin = range.beginOffset();
      long contentOffset = offset - originalBegin;
      Preconditions.checkArgument(
          0 <= contentOffset && contentOffset < range.length(),
          "Rewind offset is out of bounds. (%s <= %s < %s)",
          originalBegin,
          offset,
          range.endOffset());
      content.rewindTo(contentOffset);
    } else {
      content.rewindTo(0);
    }

    if (contentRange instanceof HttpContentRange.HasRange) {
      HttpContentRange.HasRange<?> range = (HttpContentRange.HasRange<?>) contentRange;
      contentRange = range.map(s -> s.withNewBeginOffset(offset));
    }
  }

  public ResumableOperationResult<@Nullable StorageObject> call() throws IOException {
    Span span = context.startSpan(JsonResumableSession.SPAN_NAME_WRITE);
    Scope scope = context.getTracer().withSpan(span);

    boolean success = false;
    boolean finalizing = originalContentRange.isFinalizing();

    String uploadId = jsonResumableWrite.getUploadId();
    HttpRequest req =
        context
            .getRequestFactory()
            .buildPutRequest(new GenericUrl(uploadId), content)
            .setParser(context.getObjectParser());
    req.setThrowExceptionOnExecuteError(false);
    HttpHeaders headers = req.getHeaders();
    headers.setContentRange(contentRange.getHeaderValue());
    for (Entry<String, String> e : jsonResumableWrite.getExtraHeaders().entrySet()) {
      headers.set(e.getKey(), e.getValue());
    }
    if (cumulativeCrc32c != null) {
      headers.set("x-goog-hash", "crc32c=" + Utils.crc32cCodec.encode(cumulativeCrc32c.getValue()));
    }

    HttpResponse response = null;
    try {
      response = req.execute();

      int code = response.getStatusCode();

      if (!finalizing && UploadFailureScenario.isContinue(code)) {
        long effectiveEnd = ((HttpContentRange.HasRange<?>) contentRange).range().endOffset();
        @Nullable String range = response.getHeaders().getRange();
        ByteRangeSpec ackRange = ByteRangeSpec.parse(range);
        if (ackRange.endOffset() == effectiveEnd) {
          success = true;
          return ResumableOperationResult.incremental(ackRange.endOffset());
        } else if (ackRange.endOffset() < effectiveEnd) {
          rewindTo(ackRange.endOffset());
          success = true;
          return ResumableOperationResult.incremental(ackRange.endOffset());
        } else {
          StorageException se =
              UploadFailureScenario.SCENARIO_7.toStorageException(uploadId, response);
          span.setStatus(Status.UNKNOWN.withDescription(se.getMessage()));
          throw se;
        }
      } else if (finalizing && UploadFailureScenario.isOk(code)) {
        @Nullable StorageObject storageObject;
        BigInteger actualSize = BigInteger.ZERO;

        Long contentLength = response.getHeaders().getContentLength();
        String contentType = response.getHeaders().getContentType();
        String storedContentLength =
            HttpClientContext.firstHeaderValue(
                response.getHeaders(), "x-goog-stored-content-length");
        boolean isJson = contentType != null && contentType.startsWith("application/json");
        if (isJson) {
          storageObject = response.parseAs(StorageObject.class);
          if (storageObject != null) {
            BigInteger size = storageObject.getSize();
            if (size != null) {
              actualSize = size;
            }
          }
        } else if ((contentLength == null || contentLength == 0) && storedContentLength != null) {
          // when a signed url is used, the finalize response is empty
          response.ignore();
          actualSize = new BigInteger(storedContentLength, 10);
          success = true;
          storageObject = null;
        } else {
          response.ignore();
          StorageException se =
              UploadFailureScenario.SCENARIO_0_1.toStorageException(
                  uploadId, response, null, () -> null);
          span.setStatus(Status.UNKNOWN.withDescription(se.getMessage()));
          throw se;
        }
        BigInteger expectedSize =
            BigInteger.valueOf(((HttpContentRange.HasSize) contentRange).getSize());
        int compare = expectedSize.compareTo(actualSize);
        if (compare == 0) {
          success = true;
          return ResumableOperationResult.complete(storageObject, actualSize.longValue());
        } else if (compare > 0) {
          StorageException se =
              UploadFailureScenario.SCENARIO_4_1.toStorageException(
                  uploadId, response, null, toString(storageObject));
          span.setStatus(Status.UNKNOWN.withDescription(se.getMessage()));
          throw se;
        } else {
          StorageException se =
              UploadFailureScenario.SCENARIO_4_2.toStorageException(
                  uploadId, response, null, toString(storageObject));
          span.setStatus(Status.UNKNOWN.withDescription(se.getMessage()));
          throw se;
        }
      } else if (!finalizing && UploadFailureScenario.isOk(code)) {
        StorageException se =
            UploadFailureScenario.SCENARIO_1.toStorageException(uploadId, response);
        span.setStatus(Status.UNKNOWN.withDescription(se.getMessage()));
        throw se;
      } else if (finalizing && UploadFailureScenario.isContinue(code)) {
        // in order to finalize the content range must have a size, cast down to read it
        HttpContentRange.HasSize size = (HttpContentRange.HasSize) contentRange;

        ByteRangeSpec range = ByteRangeSpec.parse(response.getHeaders().getRange());
        if (range.endOffsetInclusive() < size.getSize()) {
          StorageException se =
              UploadFailureScenario.SCENARIO_3.toStorageException(uploadId, response);
          span.setStatus(Status.UNKNOWN.withDescription(se.getMessage()));
          throw se;
        } else {
          StorageException se =
              UploadFailureScenario.SCENARIO_2.toStorageException(uploadId, response);
          span.setStatus(Status.UNKNOWN.withDescription(se.getMessage()));
          throw se;
        }
      } else {
        HttpResponseException cause = new HttpResponseException(response);
        String contentType = response.getHeaders().getContentType();
        Long contentLength = response.getHeaders().getContentLength();
        // If the content-range header value has run ahead of the backend, it will respond with
        // a 503 with plain text content
        // Attempt to detect this very loosely as to minimize impact of modified error message
        // This is accurate circa 2023-06
        if ((!UploadFailureScenario.isOk(code) && !UploadFailureScenario.isContinue(code))
            && contentType != null
            && contentType.startsWith("text/plain")
            && contentLength != null
            && contentLength > 0) {
          String errorMessage = cause.getContent().toLowerCase(Locale.US);
          if (errorMessage.contains("content-range")
              && !errorMessage.contains("earlier")) { // TODO: exclude "earlier request"
            StorageException se =
                UploadFailureScenario.SCENARIO_5.toStorageException(
                    uploadId, response, cause, cause::getContent);
            span.setStatus(Status.UNKNOWN.withDescription(se.getMessage()));
            throw se;
          }
        }
        StorageException se = UploadFailureScenario.toStorageException(response, cause, uploadId);
        span.setStatus(Status.UNKNOWN.withDescription(se.getMessage()));
        throw se;
      }
    } catch (StorageException | IllegalArgumentException e) {
      // IllegalArgumentException can happen if there is no json in the body and we try to parse it
      // Our retry algorithms have special case for this, so in an effort to keep compatibility
      // with those existing behaviors, explicitly rethrow an IllegalArgumentException that may have
      // happened
      span.setStatus(Status.UNKNOWN.withDescription(e.getMessage()));
      throw e;
    } catch (Exception e) {
      StorageException se =
          UploadFailureScenario.SCENARIO_0.toStorageException(uploadId, response, e);
      span.setStatus(Status.UNKNOWN.withDescription(se.getMessage()));
      throw se;
    } finally {
      if (success && !finalizing && response != null) {
        response.ignore();
      }
      scope.close();
      span.end(JsonResumableSession.END_SPAN_OPTIONS);
    }
  }

  static IOExceptionCallable<@Nullable String> toString(@Nullable Object o) {
    return () -> o != null ? o.toString() : null;
  }
}
