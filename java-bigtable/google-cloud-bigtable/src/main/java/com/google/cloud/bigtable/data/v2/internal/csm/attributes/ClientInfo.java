/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.csm.attributes;

import com.google.auto.value.AutoValue;
import com.google.cloud.bigtable.Version;
import com.google.cloud.bigtable.data.v2.internal.api.InstanceName;

/**
 * A value class to capture parameters that the client was instantiated with. These parameters will
 * be used by the Exporter to derive MonitoredResource for GrpcMetrics.
 */
@AutoValue
public abstract class ClientInfo {
  /** The name and version of the client. */
  public abstract String getClientName();

  /** A unique identifier to disambiguate TimeSeries from multiple processes on the same VM. */
  public abstract InstanceName getInstanceName();

  public abstract String getAppProfileId();

  public abstract Builder toBuilder();

  public static Builder builder() {
    return new AutoValue_ClientInfo.Builder().setClientName("java-bigtable/" + Version.VERSION);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setClientName(String name);

    public abstract Builder setInstanceName(InstanceName name);

    public abstract Builder setAppProfileId(String appProfileId);

    public abstract ClientInfo build();
  }
}
