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

import com.google.cloud.storage.BlobInfo;
import java.nio.file.Path;
import org.checkerframework.checker.nullness.qual.NonNull;

final class DownloadSegment {
  private final BlobInfo input;

  private final Path outputDestination;

  private final TransferStatus status;

  private final Exception exception;

  private final Long generation;

  private DownloadSegment(
      BlobInfo input,
      Path outputDestination,
      TransferStatus status,
      Exception exception,
      Long generation) {
    this.input = input;
    this.outputDestination = outputDestination;
    this.status = status;
    this.exception = exception;
    this.generation = generation;
  }

  public BlobInfo getInput() {
    return input;
  }

  public Path getOutputDestination() {
    return outputDestination;
  }

  public TransferStatus getStatus() {
    return status;
  }

  public Exception getException() {
    return exception;
  }

  public static Builder newBuilder(BlobInfo input, TransferStatus status) {
    return new Builder(input, status);
  }

  public Long getGeneration() {
    return generation;
  }

  public DownloadResult toResult() {
    DownloadResult.Builder b = DownloadResult.newBuilder(input, status);
    if (exception != null) {
      b.setException(exception);
    }
    if (outputDestination != null) {
      b.setOutputDestination(outputDestination);
    }
    return b.build();
  }

  @NonNull
  public static DownloadResult reduce(
      @NonNull DownloadResult result, @NonNull DownloadSegment segment) {
    if (TransferStatus.COMPARE_NULL_SAFE.compare(result.getStatus(), segment.getStatus()) <= 0) {
      return result;
    } else {
      return segment.toResult();
    }
  }

  public static final class Builder {

    private BlobInfo input;
    private Path outputDestination;
    private TransferStatus status;
    private Exception exception;
    private Long generation;

    private Builder(BlobInfo input, TransferStatus status) {
      this.input = input;
      this.status = status;
    }

    public Builder setInput(BlobInfo input) {
      this.input = input;
      return this;
    }

    public Builder setOutputDestination(Path outputDestination) {
      this.outputDestination = outputDestination;
      return this;
    }

    public Builder setStatus(TransferStatus status) {
      this.status = status;
      return this;
    }

    public Builder setException(Exception exception) {
      this.exception = exception;
      return this;
    }

    public Builder setGeneration(Long generation) {
      this.generation = generation;
      return this;
    }

    public DownloadSegment build() {
      return new DownloadSegment(input, outputDestination, status, exception, generation);
    }
  }
}
