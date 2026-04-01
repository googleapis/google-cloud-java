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

import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Retrying.Retrier;
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
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This class is an implementation of {@link MultipartUploadClient} that uses the Google Cloud
 * Storage XML API to perform multipart uploads.
 */
final class MultipartUploadClientImpl extends MultipartUploadClient {

  private final MultipartUploadHttpRequestManager httpRequestManager;
  private final Retrier retrier;
  private final HttpRetryAlgorithmManager retryAlgorithmManager;

  MultipartUploadClientImpl(
      Retrier retrier,
      MultipartUploadHttpRequestManager multipartUploadHttpRequestManager,
      HttpRetryAlgorithmManager retryAlgorithmManager) {
    this.httpRequestManager = multipartUploadHttpRequestManager;
    this.retrier = retrier;
    this.retryAlgorithmManager = retryAlgorithmManager;
  }

  @Override
  public CreateMultipartUploadResponse createMultipartUpload(CreateMultipartUploadRequest request) {
    return retrier.run(
        retryAlgorithmManager.nonIdempotent(),
        () -> httpRequestManager.sendCreateMultipartUploadRequest(request),
        Decoder.identity());
  }

  @Override
  public ListPartsResponse listParts(ListPartsRequest request) {

    return retrier.run(
        retryAlgorithmManager.idempotent(),
        () -> httpRequestManager.sendListPartsRequest(request),
        Decoder.identity());
  }

  @Override
  public AbortMultipartUploadResponse abortMultipartUpload(AbortMultipartUploadRequest request) {

    return retrier.run(
        retryAlgorithmManager.idempotent(),
        () -> httpRequestManager.sendAbortMultipartUploadRequest(request),
        Decoder.identity());
  }

  @Override
  public CompleteMultipartUploadResponse completeMultipartUpload(
      CompleteMultipartUploadRequest request) {
    return retrier.run(
        retryAlgorithmManager.idempotent(),
        () -> httpRequestManager.sendCompleteMultipartUploadRequest(request),
        Decoder.identity());
  }

  @Override
  public UploadPartResponse uploadPart(UploadPartRequest request, RequestBody requestBody) {
    AtomicBoolean dirty = new AtomicBoolean(false);
    return retrier.run(
        retryAlgorithmManager.idempotent(),
        () -> {
          if (dirty.getAndSet(true)) {
            requestBody.getContent().rewindTo(0);
          }
          return httpRequestManager.sendUploadPartRequest(request, requestBody.getContent());
        },
        Decoder.identity());
  }

  @Override
  public ListMultipartUploadsResponse listMultipartUploads(ListMultipartUploadsRequest request) {
    return retrier.run(
        retryAlgorithmManager.idempotent(),
        () -> httpRequestManager.sendListMultipartUploadsRequest(request),
        Decoder.identity());
  }
}
