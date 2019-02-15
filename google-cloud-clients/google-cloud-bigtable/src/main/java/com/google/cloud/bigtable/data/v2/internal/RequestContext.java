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
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import java.io.Serializable;

/**
 * Contains information necessary to construct Bigtable protobuf requests from user facing models.
 *
 * <p>The intention is to extract repetitive details like instance names and app profiles into a
 * configurable values in {@link com.google.cloud.bigtable.data.v2.BigtableDataSettings} and expose
 * them (via this class) to each wrapper's toProto method.
 *
 * <p>This class is considered an internal implementation detail and not meant to be used by
 * applications.
 */
@InternalApi
@AutoValue
public abstract class RequestContext implements Serializable {

  /** Creates a new instance of the {@link RequestContext}. */
  public static RequestContext create(String projectId, String instanceId, String appProfileId) {
    return new AutoValue_RequestContext(projectId, instanceId, appProfileId);
  }

  /** The project id that the client is configured to target. */
  public abstract String getProjectId();

  /** The instance id that the client is configured to target. */
  public abstract String getInstanceId();

  /** The App Profile to use when processing the current request */
  public abstract String getAppProfileId();
}
