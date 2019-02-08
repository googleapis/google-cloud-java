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
public final class CommitmentsScopedList implements ApiMessage {
  private final List<Commitment> commitments;
  private final Warning warning;

  private CommitmentsScopedList() {
    this.commitments = null;
    this.warning = null;
  }

  private CommitmentsScopedList(List<Commitment> commitments, Warning warning) {
    this.commitments = commitments;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("commitments".equals(fieldName)) {
      return commitments;
    }
    if ("warning".equals(fieldName)) {
      return warning;
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
  public List<String> getFieldMask() {
    return null;
  }

  /** [Output Only] A list of commitments contained in this scope. */
  public List<Commitment> getCommitmentsList() {
    return commitments;
  }

  /**
   * [Output Only] Informational warning which replaces the list of commitments when the list is
   * empty.
   */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(CommitmentsScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static CommitmentsScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final CommitmentsScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new CommitmentsScopedList();
  }

  public static class Builder {
    private List<Commitment> commitments;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(CommitmentsScopedList other) {
      if (other == CommitmentsScopedList.getDefaultInstance()) return this;
      if (other.getCommitmentsList() != null) {
        this.commitments = other.commitments;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(CommitmentsScopedList source) {
      this.commitments = source.commitments;
      this.warning = source.warning;
    }

    /** [Output Only] A list of commitments contained in this scope. */
    public List<Commitment> getCommitmentsList() {
      return commitments;
    }

    /** [Output Only] A list of commitments contained in this scope. */
    public Builder addAllCommitments(List<Commitment> commitments) {
      if (this.commitments == null) {
        this.commitments = new LinkedList<>();
      }
      this.commitments.addAll(commitments);
      return this;
    }

    /** [Output Only] A list of commitments contained in this scope. */
    public Builder addCommitments(Commitment commitments) {
      if (this.commitments == null) {
        this.commitments = new LinkedList<>();
      }
      this.commitments.add(commitments);
      return this;
    }

    /**
     * [Output Only] Informational warning which replaces the list of commitments when the list is
     * empty.
     */
    public Warning getWarning() {
      return warning;
    }

    /**
     * [Output Only] Informational warning which replaces the list of commitments when the list is
     * empty.
     */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public CommitmentsScopedList build() {

      return new CommitmentsScopedList(commitments, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllCommitments(this.commitments);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "CommitmentsScopedList{"
        + "commitments="
        + commitments
        + ", "
        + "warning="
        + warning
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CommitmentsScopedList) {
      CommitmentsScopedList that = (CommitmentsScopedList) o;
      return Objects.equals(this.commitments, that.getCommitmentsList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(commitments, warning);
  }
}
