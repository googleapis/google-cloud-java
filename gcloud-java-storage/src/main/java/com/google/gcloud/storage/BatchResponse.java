/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google Storage batch response.
 */
public final class BatchResponse implements Serializable {

  private static final long serialVersionUID = 1057416839397037706L;

  private final List<Result<Boolean>> deleteResult;
  private final List<Result<Blob>> updateResult;
  private final List<Result<Blob>> getResult;

  public static class Result<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -1946539570170529094L;
    private static final Result EMPTY = new BatchResponse.Result(null);

    private final T value;
    private final StorageServiceException exception;


    public Result(T value) {
      this.value = value;
      this.exception = null;
    }

    public Result(StorageServiceException exception) {
      this.exception = exception;
      this.value = null;
    }

    static <T extends Serializable> Result<T> of(T value) {
      return new Result<>(value);
    }

    /**
     * Returns the result.
     *
     * @throws StorageServiceException if failed
     */
    public T get() throws StorageServiceException {
      if (failed()) {
        throw failure();
      }
      return value;
    }

    /**
     * Returns the failure or {@code null} if was successful.
     */
    public StorageServiceException failure() {
      return exception;
    }

    /**
     * Returns {@code true} if failed, {@code false} otherwise.
     */
    public boolean failed() {
      return exception != null;
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, exception);
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof Result)) {
        return false;
      }
      Result<?> other = (Result<?>) obj;
      return Objects.equals(value, other.value)
          && Objects.equals(exception, other.exception);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("value", value)
          .add("exception", exception)
          .toString();
    }

    @SuppressWarnings("unchecked")
    static <T extends Serializable> Result<T> empty() {
      return EMPTY;
    }
  }

  public BatchResponse(List<Result<Boolean>> deleteResult, List<Result<Blob>> updateResult,
      List<Result<Blob>> getResult) {
    this.deleteResult = ImmutableList.copyOf(deleteResult);
    this.updateResult = ImmutableList.copyOf(updateResult);
    this.getResult = ImmutableList.copyOf(getResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deleteResult, updateResult, getResult);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof BatchResponse)) {
      return false;
    }
    BatchResponse other = (BatchResponse) obj;
    return Objects.equals(deleteResult, other.deleteResult)
        && Objects.equals(updateResult, other.updateResult)
        && Objects.equals(updateResult, other.updateResult);
  }

  /**
   * Returns the results for the delete operations using the request order.
   */
  public List<Result<Boolean>> deletes() {
    return deleteResult;
  }

  /**
   * Returns the results for the update operations using the request order.
   */
  public List<Result<Blob>> updates() {
    return updateResult;
  }

  /**
   * Returns the results for the get operations using the request order.
   */
  public List<Result<Blob>> gets() {
    return getResult;
  }
}
