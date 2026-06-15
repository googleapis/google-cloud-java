/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigtable.data.v2.internal.api;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auto.value.AutoValue;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ChannelProvider;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.DirectAccess;
import java.io.IOException;
import javax.annotation.Nullable;

@AutoValue
public abstract class ClientSettings {
  public abstract ChannelProvider getChannelProvider();

  public abstract InstanceName getInstanceName();

  public abstract String getAppProfileId();

  public static Builder builder() {
    return new AutoValue_ClientSettings.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setChannelProvider(ChannelProvider channelProvider);

    @Nullable
    abstract ChannelProvider getChannelProvider();

    public abstract Builder setInstanceName(InstanceName name);

    public abstract Builder setAppProfileId(String appProfileId);

    abstract ClientSettings autoBuild(); // not public

    public ClientSettings build() {
      if (getChannelProvider() != null) {
        return autoBuild();
      }

      Credentials creds;
      try {
        creds = GoogleCredentials.getApplicationDefault();
      } catch (IOException e) {
        throw new RuntimeException("Failed to create default credentials");
      }

      if (getChannelProvider() == null) {
        setChannelProvider(DirectAccess.withFallback(ChannelProviders.DEFAULT_HOST, creds));
      }
      return autoBuild();
    }
  }
}
