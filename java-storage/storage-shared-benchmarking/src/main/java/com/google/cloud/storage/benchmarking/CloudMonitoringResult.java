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

package com.google.cloud.storage.benchmarking;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.NonNull;

final class CloudMonitoringResult {
  @NonNull private final String library;
  @NonNull private final String api;
  @NonNull private final String op;

  private final int workers;
  private final int objectSize;
  private final int appBufferSize;
  private final int chunksize;
  private final boolean crc32CEnabled;
  private final boolean md5Enabled;
  private final int cpuTimeUs;
  @NonNull private final String bucketName;
  @NonNull private final String status;
  @NonNull private final String transferSize;
  @NonNull private final String transferOffset;
  @NonNull private final String failureMsg;
  private final double latency;

  CloudMonitoringResult(
      String library,
      String api,
      String op,
      int workers,
      int objectSize,
      int appBufferSize,
      int chunksize,
      boolean crc32cEnabled,
      boolean md5Enabled,
      int cpuTimeUs,
      String bucketName,
      String status,
      String transferSize,
      String transferOffset,
      String failureMsg,
      double latency) {
    this.library = library;
    this.api = api;
    this.op = op;
    this.workers = workers;
    this.objectSize = objectSize;
    this.appBufferSize = appBufferSize;
    this.chunksize = chunksize;
    this.crc32CEnabled = crc32cEnabled;
    this.md5Enabled = md5Enabled;
    this.cpuTimeUs = cpuTimeUs;
    this.bucketName = bucketName;
    this.status = status;
    this.transferSize = transferSize;
    this.transferOffset = transferOffset;
    this.failureMsg = failureMsg;
    this.latency = latency;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("library", library)
        .add("api", api)
        .add("op", op)
        .add("workers", workers)
        .add("objectSize", objectSize)
        .add("appBufferSize", appBufferSize)
        .add("chunksize", chunksize)
        .add("crc32CEnabled", crc32CEnabled)
        .add("md5Enabled", md5Enabled)
        .add("cpuTimeUs", cpuTimeUs)
        .add("bucketName", bucketName)
        .add("status", status)
        .add("transferSize", transferSize)
        .add("transferOffset", transferOffset)
        .add("failureMsg", failureMsg)
        .add("latency", latency)
        .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CloudMonitoringResult)) {
      return false;
    }
    CloudMonitoringResult result = (CloudMonitoringResult) o;
    return workers == result.workers
        && objectSize == result.objectSize
        && appBufferSize == result.appBufferSize
        && chunksize == result.chunksize
        && crc32CEnabled == result.crc32CEnabled
        && md5Enabled == result.md5Enabled
        && cpuTimeUs == result.cpuTimeUs
        && Double.compare(result.latency, latency) == 0
        && Objects.equals(library, result.library)
        && Objects.equals(api, result.api)
        && Objects.equals(op, result.op)
        && Objects.equals(bucketName, result.bucketName)
        && Objects.equals(status, result.status)
        && Objects.equals(transferSize, result.transferSize)
        && Objects.equals(transferOffset, result.transferOffset)
        && Objects.equals(failureMsg, result.failureMsg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        library,
        api,
        op,
        workers,
        objectSize,
        appBufferSize,
        chunksize,
        crc32CEnabled,
        md5Enabled,
        cpuTimeUs,
        bucketName,
        status,
        transferSize,
        transferOffset,
        failureMsg,
        latency);
  }

  public String formatAsCustomMetric() {
    return String.format(
        "api_latency{library=%s,api=%s,op=%s,object_size=%d,chunksize=%d,workers=%d,crc32c_enabled=%b,md5_enabled=%b,bucket_name=%s,status=%s,app_buffer_size=%d}%.1f",
        library,
        api,
        op,
        objectSize,
        chunksize,
        workers,
        crc32CEnabled,
        md5Enabled,
        bucketName,
        status,
        appBufferSize,
        latency);
  }

  public static class Builder {

    @NonNull private String library;
    @NonNull private String api;
    @NonNull private String op;
    private int workers;
    private int objectSize;
    private int appBufferSize;
    private int chunksize;
    private boolean crc32cEnabled;
    private boolean md5Enabled;
    private int cpuTimeUs;
    @NonNull private String bucketName;
    @NonNull private String status;
    @NonNull private String transferSize;
    @NonNull private String transferOffset;
    @NonNull private String failureMsg;
    private double latency;

    Builder() {
      library = "";
      api = "";
      op = "";
      bucketName = "";
      status = "";
      transferSize = "";
      transferOffset = "";
      failureMsg = "";
    }

    public Builder setLibrary(String library) {
      this.library = library;
      return this;
    }

    public Builder setApi(String api) {
      this.api = api;
      return this;
    }

    public Builder setOp(String op) {
      this.op = op;
      return this;
    }

    public Builder setWorkers(int workers) {
      this.workers = workers;
      return this;
    }

    public Builder setObjectSize(int objectSize) {
      this.objectSize = objectSize;
      return this;
    }

    public Builder setAppBufferSize(int appBufferSize) {
      this.appBufferSize = appBufferSize;
      return this;
    }

    public Builder setChunksize(int chunksize) {
      this.chunksize = chunksize;
      return this;
    }

    public Builder setCrc32cEnabled(boolean crc32cEnabled) {
      this.crc32cEnabled = crc32cEnabled;
      return this;
    }

    public Builder setMd5Enabled(boolean md5Enabled) {
      this.md5Enabled = md5Enabled;
      return this;
    }

    public Builder setCpuTimeUs(int cpuTimeUs) {
      this.cpuTimeUs = cpuTimeUs;
      return this;
    }

    public Builder setBucketName(String bucketName) {
      this.bucketName = bucketName;
      return this;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public Builder setTransferSize(String transferSize) {
      this.transferSize = transferSize;
      return this;
    }

    public Builder setTransferOffset(String transferOffset) {
      this.transferOffset = transferOffset;
      return this;
    }

    public Builder setFailureMsg(String failureMsg) {
      this.failureMsg = failureMsg;
      return this;
    }

    public Builder setLatency(double latency) {
      this.latency = latency;
      return this;
    }

    public CloudMonitoringResult build() {
      checkNotNull(library);
      checkNotNull(api);
      checkNotNull(op);
      checkNotNull(bucketName);
      checkNotNull(status);
      checkNotNull(transferSize);
      checkNotNull(transferOffset);
      checkNotNull(failureMsg);
      return new CloudMonitoringResult(
          library,
          api,
          op,
          workers,
          objectSize,
          appBufferSize,
          chunksize,
          crc32cEnabled,
          md5Enabled,
          cpuTimeUs,
          bucketName,
          status,
          transferSize,
          transferOffset,
          failureMsg,
          latency);
    }
  }
}
