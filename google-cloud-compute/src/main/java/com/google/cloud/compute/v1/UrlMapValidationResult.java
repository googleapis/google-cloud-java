/*
 * Copyright 2018 Google LLC
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
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
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
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("loadErrors") && loadErrors != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (String item : loadErrors) {
        stringList.add(item.toString());
      }
      fieldMap.put("loadErrors", stringList.build());
    }
    if (fieldNames.contains("loadSucceeded") && loadSucceeded != null) {
      fieldMap.put("loadSucceeded", Collections.singletonList(String.valueOf(loadSucceeded)));
    }
    if (fieldNames.contains("testFailures") && testFailures != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (TestFailure item : testFailures) {
        stringList.add(item.toString());
      }
      fieldMap.put("testFailures", stringList.build());
    }
    if (fieldNames.contains("testPassed") && testPassed != null) {
      fieldMap.put("testPassed", Collections.singletonList(String.valueOf(testPassed)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("loadErrors")) {
      return String.valueOf(loadErrors);
    }
    if (fieldName.equals("loadSucceeded")) {
      return String.valueOf(loadSucceeded);
    }
    if (fieldName.equals("testFailures")) {
      return String.valueOf(testFailures);
    }
    if (fieldName.equals("testPassed")) {
      return String.valueOf(testPassed);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  public List<String> getLoadErrorsList() {
    return loadErrors;
  }

  public Boolean getLoadSucceeded() {
    return loadSucceeded;
  }

  public List<TestFailure> getTestFailuresList() {
    return testFailures;
  }

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
        this.loadErrors = new ArrayList<>(loadErrors.size());
      }
      this.loadErrors.addAll(loadErrors);
      return this;
    }

    public Builder addLoadErrors(String loadErrors) {
      this.loadErrors.add(loadErrors);
      return this;
    }

    public Boolean getLoadSucceeded() {
      return loadSucceeded;
    }

    public Builder setLoadSucceeded(Boolean loadSucceeded) {
      this.loadSucceeded = loadSucceeded;
      return this;
    }

    public List<TestFailure> getTestFailuresList() {
      return testFailures;
    }

    public Builder addAllTestFailures(List<TestFailure> testFailures) {
      if (this.testFailures == null) {
        this.testFailures = new ArrayList<>(testFailures.size());
      }
      this.testFailures.addAll(testFailures);
      return this;
    }

    public Builder addTestFailures(TestFailure testFailures) {
      this.testFailures.add(testFailures);
      return this;
    }

    public Boolean getTestPassed() {
      return testPassed;
    }

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
