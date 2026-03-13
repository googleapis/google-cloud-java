/*
 * Copyright 2020 Google LLC
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

package com.google.cloud;

import com.google.api.core.BetaApi;
import com.google.auto.value.AutoValue;
import javax.annotation.Nullable;

/**
 * Class for Identity and Access Management (IAM) policies. IAM policies are used to specify access
 * settings for Cloud Platform resources. A policy is a list of bindings. A binding assigns a set of
 * identities to a role, where the identities can be user accounts, Google groups, Google domains,
 * and service accounts. A role is a named list of permissions defined by IAM.
 *
 * @see <a href="https://cloud.google.com/iam/docs/reference/rest/v1/Policy">Policy</a>
 * @see <a href="https://cloud.google.com/iam/docs/conditions-overview">IAM Conditions</a>
 */
@BetaApi("This is a Beta API is not stable yet and may change in the future.")
@AutoValue
public abstract class Condition {
  /** Get IAM Policy Binding Condition Title */
  @Nullable
  public abstract String getTitle();

  /** Get IAM Policy Binding Condition Description */
  @Nullable
  public abstract String getDescription();

  /** Get IAM Policy Binding Condition Expression */
  public abstract String getExpression();

  /** Create a new Condition.Builder from an existing Condition */
  public abstract Builder toBuilder();

  /** Create a new Condition.Builder */
  public static Builder newBuilder() {
    return new AutoValue_Condition.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    /** Set IAM Policy Binding Condition Title */
    public abstract Builder setTitle(@Nullable String title);

    /** Set IAM Policy Binding Condition Description */
    public abstract Builder setDescription(@Nullable String description);

    /** Set IAM Policy Binding Condition Expression */
    public abstract Builder setExpression(String expression);

    /** Build Builder which creates a Condition instance */
    public abstract Condition build();
  }
}
