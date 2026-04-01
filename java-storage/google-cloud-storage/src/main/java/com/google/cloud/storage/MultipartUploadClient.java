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

import com.google.api.core.InternalExtensionOnly;
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

/**
 * A client for interacting with Google Cloud Storage's Multipart Upload API.
 *
 * <p>This class is for internal use only and is not intended for public consumption. It provides a
 * low-level interface for creating and managing multipart uploads.
 *
 * @see <a href="https://cloud.google.com/storage/docs/multipart-uploads">Multipart Uploads</a>
 * @since 2.60.0
 */
@InternalExtensionOnly
public abstract class MultipartUploadClient {

  MultipartUploadClient() {}

  /**
   * Creates a new multipart upload.
   *
   * @param request The request object containing the details for creating the multipart upload.
   * @return A {@link CreateMultipartUploadResponse} object containing the upload ID.
   * @since 2.60.0
   */
  public abstract CreateMultipartUploadResponse createMultipartUpload(
      CreateMultipartUploadRequest request);

  /**
   * Lists the parts that have been uploaded for a specific multipart upload.
   *
   * @param listPartsRequest The request object containing the details for listing the parts.
   * @return A {@link ListPartsResponse} object containing the list of parts.
   * @since 2.60.0
   */
  public abstract ListPartsResponse listParts(ListPartsRequest listPartsRequest);

  /**
   * Aborts a multipart upload.
   *
   * @param request The request object containing the details for aborting the multipart upload.
   * @return An {@link AbortMultipartUploadResponse} object.
   * @since 2.60.0
   */
  public abstract AbortMultipartUploadResponse abortMultipartUpload(
      AbortMultipartUploadRequest request);

  /**
   * Completes a multipart upload.
   *
   * @param request The request object containing the details for completing the multipart upload.
   * @return A {@link CompleteMultipartUploadResponse} object containing information about the
   *     completed upload.
   * @since 2.60.0
   */
  public abstract CompleteMultipartUploadResponse completeMultipartUpload(
      CompleteMultipartUploadRequest request);

  /**
   * Uploads a part in a multipart upload.
   *
   * @param request The request object containing the details for uploading the part.
   * @param requestBody The content of the part to upload.
   * @return An {@link UploadPartResponse} object containing the ETag of the uploaded part.
   * @since 2.60.0
   */
  public abstract UploadPartResponse uploadPart(UploadPartRequest request, RequestBody requestBody);

  /**
   * Lists all multipart uploads in a bucket.
   *
   * @param request The request object containing the details for listing the multipart uploads.
   * @return A {@link ListMultipartUploadsResponse} object containing the list of multipart uploads.
   * @since 2.61.0
   */
  public abstract ListMultipartUploadsResponse listMultipartUploads(
      ListMultipartUploadsRequest request);

  /**
   * Creates a new instance of {@link MultipartUploadClient}.
   *
   * @param config The configuration for the client.
   * @return A new {@link MultipartUploadClient} instance.
   * @since 2.60.0
   */
  public static MultipartUploadClient create(MultipartUploadSettings config) {
    HttpStorageOptions options = config.getOptions();
    MultipartUploadClient client =
        new MultipartUploadClientImpl(
            options.createRetrier(),
            MultipartUploadHttpRequestManager.createFrom(options),
            options.getRetryAlgorithmManager());
    return OtelMultipartUploadClientDecorator.decorate(
        client, options.getOpenTelemetry(), Transport.HTTP);
  }
}
