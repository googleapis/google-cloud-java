/*
 * Copyright 2018 Google LLC
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

package com.google.cloud.bigquery;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Objects;

public final class EncryptionConfiguration implements Serializable {
  private static final long serialVersionUID = -100849671239964L;

  private final String kmsKeyName;

  public String getKmsKeyName() {
    return this.kmsKeyName;
  }

  public com.google.api.services.bigquery.model.EncryptionConfiguration toPb() {
    com.google.api.services.bigquery.model.EncryptionConfiguration encryptionConfigurationPb =
        new com.google.api.services.bigquery.model.EncryptionConfiguration();
    encryptionConfigurationPb.setKmsKeyName(kmsKeyName);
    return encryptionConfigurationPb;
  }

  public static final class Builder {
    private String kmsKeyName;

    private Builder() {}

    private Builder(EncryptionConfiguration options) {
      kmsKeyName = options.kmsKeyName;
    }

    public Builder(
        com.google.api.services.bigquery.model.EncryptionConfiguration encryptionConfigurationPb) {
      setKmsKeyName(encryptionConfigurationPb.getKmsKeyName());
    }

    public EncryptionConfiguration.Builder setKmsKeyName(String kmsKeyName) {
      this.kmsKeyName = kmsKeyName;
      return this;
    }

    /** Creates a {@code EncryptionConfiguration} object. */
    public EncryptionConfiguration build() {
      return new EncryptionConfiguration(this);
    }
  }

  private EncryptionConfiguration(EncryptionConfiguration.Builder builder) {
    this.kmsKeyName = builder.kmsKeyName;
  }

  /** Returns a builder for the {@code EncryptionConfiguration} object. */
  public EncryptionConfiguration.Builder toBuilder() {
    return new EncryptionConfiguration.Builder(this);
  }

  /** Returns a builder for a {@code EncryptionConfiguration} object. */
  public static EncryptionConfiguration.Builder newBuilder() {
    return new EncryptionConfiguration.Builder();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("kmsKeyName", kmsKeyName).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(kmsKeyName);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof EncryptionConfiguration
            && Objects.equals(kmsKeyName, ((EncryptionConfiguration) obj).getKmsKeyName());
  }
}
