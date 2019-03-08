/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Message representing the validation result for a UrlMap. */
public final class UrlMapValidationResult implements ApiMessage {
  private final List<String> loadErrors;
  private final Boolean loadSucceeded;
  private final List<TestFailure> testFailures;
  private final Boolean testPassed;

  private UrlMapValidationResult() {
    this.loadErrors = null;
    this.loadSucceeded = null;
    this.testFailures = null;
    this.testPassed = null;
  }

  private UrlMapValidationResult(
      List<String> loadErrors,
      Boolean loadSucceeded,
      List<TestFailure> testFailures,
      Boolean testPassed) {
    this.loadErrors = loadErrors;
    this.loadSucceeded = loadSucceeded;
    this.testFailures = testFailures;
    this.testPassed = testPassed;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("loadErrors".equals(fieldName)) {
      return loadErrors;
    }
    if ("loadSucceeded".equals(fieldName)) {
      return loadSucceeded;
    }
    if ("testFailures".equals(fieldName)) {
      return testFailures;
    }
    if ("testPassed".equals(fieldName)) {
      return testPassed;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  public List<String> getLoadErrorsList() {
    return loadErrors;
  }

  /**
   * Whether the given UrlMap can be successfully loaded. If false, 'loadErrors' indicates the
   * reasons.
   */
  public Boolean getLoadSucceeded() {
    return loadSucceeded;
  }

  public List<TestFailure> getTestFailuresList() {
    return testFailures;
  }

  /**
   * If successfully loaded, this field indicates whether the test passed. If false, 'testFailures's
   * indicate the reason of failure.
   */
  public Boolean getTestPassed() {
    return testPassed;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(UrlMapValidationResult prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static UrlMapValidationResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final UrlMapValidationResult DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new UrlMapValidationResult();
  }

  public static class Builder {
    private List<String> loadErrors;
    private Boolean loadSucceeded;
    private List<TestFailure> testFailures;
    private Boolean testPassed;

    Builder() {}

    public Builder mergeFrom(UrlMapValidationResult other) {
      if (other == UrlMapValidationResult.getDefaultInstance()) return this;
      if (other.getLoadErrorsList() != null) {
        this.loadErrors = other.loadErrors;
      }
      if (other.getLoadSucceeded() != null) {
        this.loadSucceeded = other.loadSucceeded;
      }
      if (other.getTestFailuresList() != null) {
        this.testFailures = other.testFailures;
      }
      if (other.getTestPassed() != null) {
        this.testPassed = other.testPassed;
      }
      return this;
    }

    Builder(UrlMapValidationResult source) {
      this.loadErrors = source.loadErrors;
      this.loadSucceeded = source.loadSucceeded;
      this.testFailures = source.testFailures;
      this.testPassed = source.testPassed;
    }

    public List<String> getLoadErrorsList() {
      return loadErrors;
    }

    public Builder addAllLoadErrors(List<String> loadErrors) {
      if (this.loadErrors == null) {
        this.loadErrors = new LinkedList<>();
      }
      this.loadErrors.addAll(loadErrors);
      return this;
    }

    public Builder addLoadErrors(String loadErrors) {
      if (this.loadErrors == null) {
        this.loadErrors = new LinkedList<>();
      }
      this.loadErrors.add(loadErrors);
      return this;
    }

    /**
     * Whether the given UrlMap can be successfully loaded. If false, 'loadErrors' indicates the
     * reasons.
     */
    public Boolean getLoadSucceeded() {
      return loadSucceeded;
    }

    /**
     * Whether the given UrlMap can be successfully loaded. If false, 'loadErrors' indicates the
     * reasons.
     */
    public Builder setLoadSucceeded(Boolean loadSucceeded) {
      this.loadSucceeded = loadSucceeded;
      return this;
    }

    public List<TestFailure> getTestFailuresList() {
      return testFailures;
    }

    public Builder addAllTestFailures(List<TestFailure> testFailures) {
      if (this.testFailures == null) {
        this.testFailures = new LinkedList<>();
      }
      this.testFailures.addAll(testFailures);
      return this;
    }

    public Builder addTestFailures(TestFailure testFailures) {
      if (this.testFailures == null) {
        this.testFailures = new LinkedList<>();
      }
      this.testFailures.add(testFailures);
      return this;
    }

    /**
     * If successfully loaded, this field indicates whether the test passed. If false,
     * 'testFailures's indicate the reason of failure.
     */
    public Boolean getTestPassed() {
      return testPassed;
    }

    /**
     * If successfully loaded, this field indicates whether the test passed. If false,
     * 'testFailures's indicate the reason of failure.
     */
    public Builder setTestPassed(Boolean testPassed) {
      this.testPassed = testPassed;
      return this;
    }

    public UrlMapValidationResult build() {

      return new UrlMapValidationResult(loadErrors, loadSucceeded, testFailures, testPassed);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllLoadErrors(this.loadErrors);
      newBuilder.setLoadSucceeded(this.loadSucceeded);
      newBuilder.addAllTestFailures(this.testFailures);
      newBuilder.setTestPassed(this.testPassed);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "UrlMapValidationResult{"
        + "loadErrors="
        + loadErrors
        + ", "
        + "loadSucceeded="
        + loadSucceeded
        + ", "
        + "testFailures="
        + testFailures
        + ", "
        + "testPassed="
        + testPassed
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UrlMapValidationResult) {
      UrlMapValidationResult that = (UrlMapValidationResult) o;
      return Objects.equals(this.loadErrors, that.getLoadErrorsList())
          && Objects.equals(this.loadSucceeded, that.getLoadSucceeded())
          && Objects.equals(this.testFailures, that.getTestFailuresList())
          && Objects.equals(this.testPassed, that.getTestPassed());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(loadErrors, loadSucceeded, testFailures, testPassed);
  }
}
