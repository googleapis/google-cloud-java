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

package com.google.cloud.storage.transfermanager;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.cloud.storage.BlobInfo;
import com.google.common.base.MoreObjects;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Result for a single upload performed by Transfer Manager.
 *
 * @see Builder
 */
public final class UploadResult {

  @NonNull private final BlobInfo input;
  @NonNull private final TransferStatus status;
  @MonotonicNonNull private final BlobInfo uploadedBlob;
  @MonotonicNonNull private final Exception exception;

  private UploadResult(
      @NonNull BlobInfo input,
      @NonNull TransferStatus status,
      BlobInfo uploadedBlob,
      Exception exception) {
    this.input = input;
    this.status = status;
    this.uploadedBlob = uploadedBlob;
    this.exception = exception;
  }

  /**
   * The {@link BlobInfo} for the object requested for upload.
   *
   * @see Builder#setInput(BlobInfo)
   */
  public @NonNull BlobInfo getInput() {
    return input;
  }

  /**
   * The status of the upload operation.
   *
   * @see TransferStatus
   * @see Builder#setStatus(TransferStatus)
   */
  public @NonNull TransferStatus getStatus() {
    return status;
  }

  /**
   * The {@link BlobInfo} for the Uploaded object. This field will only be populated if the Transfer
   * was {@link TransferStatus#SUCCESS success}ful.
   *
   * @see Builder#setUploadedBlob(BlobInfo)
   */
  public @NonNull BlobInfo getUploadedBlob() {
    checkState(
        status == TransferStatus.SUCCESS,
        "getUploadedBlob() only valid when status is SUCCESS but status was %s",
        status);
    return uploadedBlob;
  }

  /**
   * The exception produced by a failed upload operation. This field will only be populated if the
   * Transfer was not {@link TransferStatus#SUCCESS success}ful or {@link TransferStatus#SKIPPED
   * skipped}
   *
   * @see Builder#setException(Exception)
   */
  public @NonNull Exception getException() {
    checkState(
        status == TransferStatus.FAILED_TO_START || status == TransferStatus.FAILED_TO_FINISH,
        "getException() is only valid when an unexpected error has occurred but status was %s",
        status);
    return exception;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadResult that = (UploadResult) o;
    return input.equals(that.input)
        && status == that.status
        && uploadedBlob.equals(that.uploadedBlob)
        && exception.equals(that.exception);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, status, uploadedBlob, exception);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("input", input)
        .add("status", status)
        .add("uploadedBlob", uploadedBlob)
        .add("exception", exception)
        .toString();
  }

  public static Builder newBuilder(@NonNull BlobInfo input, @NonNull TransferStatus status) {
    return new Builder(input, status);
  }

  /**
   * Builds an instance of UploadResult
   *
   * @see UploadResult
   */
  public static final class Builder {

    private @NonNull BlobInfo input;
    private @NonNull TransferStatus status;
    private @MonotonicNonNull BlobInfo uploadedBlob;
    private @MonotonicNonNull Exception exception;

    private Builder(@NonNull BlobInfo input, @NonNull TransferStatus status) {
      this.input = input;
      this.status = status;
    }

    /**
     * Sets the {@link BlobInfo} for the object request for upload. This field is required.
     *
     * @return the Builder instance with the value for BlobInfo modified.
     * @see UploadResult#getInput()
     */
    public Builder setInput(@NonNull BlobInfo input) {
      this.input = input;
      return this;
    }

    /**
     * Sets the Status of the Upload request. This field is required.
     *
     * @return the Builder instance with the value for status modified.
     * @see TransferStatus
     * @see UploadResult#getStatus()
     */
    public Builder setStatus(@NonNull TransferStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Sets the {@link BlobInfo} for the uploaded object. This field will only be populated if the
     * Transfer was a {@link TransferStatus#SUCCESS SUCCESS}.
     *
     * @return the Builder instance with the value for uploadedBlob modified.
     */
    public Builder setUploadedBlob(@NonNull BlobInfo uploadedBlob) {
      this.uploadedBlob = uploadedBlob;
      return this;
    }

    /**
     * Sets the exception produced by a failed upload operation. This field will only be populated
     * if the Transfer was not {@link TransferStatus#SUCCESS success}ful or {@link
     * TransferStatus#SKIPPED skipped}
     *
     * @see UploadResult#getException()
     * @return the Builder instance with the value for exception modified.
     */
    public Builder setException(@NonNull Exception exception) {
      this.exception = exception;
      return this;
    }

    /**
     * Creates an UploadResult object.
     *
     * @return {@link UploadResult}
     */
    public UploadResult build() {
      checkNotNull(input);
      checkNotNull(status);
      if (status == TransferStatus.SUCCESS) {
        checkNotNull(uploadedBlob);
      } else if (status == TransferStatus.FAILED_TO_START
          || status == TransferStatus.FAILED_TO_FINISH) {
        checkNotNull(exception);
      }
      return new UploadResult(input, status, uploadedBlob, exception);
    }
  }
}
