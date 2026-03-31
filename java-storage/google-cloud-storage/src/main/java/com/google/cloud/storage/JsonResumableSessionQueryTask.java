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

import static com.google.cloud.storage.HttpClientContext.firstHeaderValue;

import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.services.storage.model.StorageObject;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import org.checkerframework.checker.nullness.qual.Nullable;

final class JsonResumableSessionQueryTask
    implements Callable<ResumableOperationResult<@Nullable StorageObject>> {

  private final HttpClientContext context;
  private final JsonResumableWrite jsonResumableWrite;

  JsonResumableSessionQueryTask(HttpClientContext context, JsonResumableWrite jsonResumableWrite) {
    this.context = context;
    this.jsonResumableWrite = jsonResumableWrite;
  }

  public ResumableOperationResult<@Nullable StorageObject> call() {
    HttpResponse response = null;
    String uploadId = jsonResumableWrite.getUploadId();
    try {
      HttpRequest req =
          context
              .getRequestFactory()
              .buildPutRequest(new GenericUrl(uploadId), new EmptyContent())
              .setParser(context.getObjectParser());
      req.setThrowExceptionOnExecuteError(false);
      HttpHeaders headers = req.getHeaders();
      headers.setContentRange(HttpContentRange.query().getHeaderValue());
      for (Entry<String, String> e : jsonResumableWrite.getExtraHeaders().entrySet()) {
        headers.set(e.getKey(), e.getValue());
      }

      response = req.execute();

      int code = response.getStatusCode();
      if (UploadFailureScenario.isOk(code)) {
        @Nullable StorageObject storageObject;
        @Nullable BigInteger actualSize;

        Long contentLength = response.getHeaders().getContentLength();
        String contentType = response.getHeaders().getContentType();
        String storedContentLength =
            firstHeaderValue(response.getHeaders(), "x-goog-stored-content-length");
        boolean isJson = contentType != null && contentType.startsWith("application/json");
        if (isJson) {
          storageObject = response.parseAs(StorageObject.class);
          actualSize = storageObject != null ? storageObject.getSize() : null;
        } else if ((contentLength == null || contentLength == 0) && storedContentLength != null) {
          // when a signed url is used, the finalize response is empty
          response.ignore();
          actualSize = new BigInteger(storedContentLength, 10);
          storageObject = null;
        } else {
          response.ignore();
          throw UploadFailureScenario.SCENARIO_0_1.toStorageException(
              uploadId, response, null, () -> null);
        }
        if (actualSize != null) {
          if (storageObject != null) {
            return ResumableOperationResult.complete(storageObject, actualSize.longValue());
          } else {
            return ResumableOperationResult.incremental(actualSize.longValue());
          }
        } else {
          throw UploadFailureScenario.SCENARIO_0.toStorageException(
              uploadId,
              response,
              null,
              () -> storageObject != null ? storageObject.toString() : null);
        }
      } else if (UploadFailureScenario.isContinue(code)) {
        String range1 = response.getHeaders().getRange();
        if (range1 != null) {
          ByteRangeSpec range = ByteRangeSpec.parse(range1);
          long endOffset = range.endOffset();
          return ResumableOperationResult.incremental(endOffset);
        } else {
          // According to
          // https://cloud.google.com/storage/docs/performing-resumable-uploads#status-check a 308
          // response that does not contain a Range header should be interpreted as GCS having
          // received no data.
          return ResumableOperationResult.incremental(0);
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
          if (errorMessage.contains("content-range")) {
            throw UploadFailureScenario.SCENARIO_5.toStorageException(
                uploadId, response, cause, cause::getContent);
          }
        }
        throw UploadFailureScenario.toStorageException(response, cause, uploadId);
      }
    } catch (StorageException se) {
      throw se;
    } catch (Exception e) {
      throw UploadFailureScenario.SCENARIO_0.toStorageException(uploadId, response, e);
    } finally {
      if (response != null) {
        try {
          response.ignore();
        } catch (IOException ignore) {
        }
      }
    }
  }
}
