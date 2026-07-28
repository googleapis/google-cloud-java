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
package com.google.cloud.bigtable.admin.v2.models;

import com.google.api.core.InternalApi;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Exception thrown when some zones are unavailable and listInstances is unable to return a full
 * instance list. This exception can be inspected to get a partial list.
 */
public class PartialListInstancesException extends RuntimeException {
  private final List<String> unavailableZones;
  private final List<Instance> instances;

  @InternalApi
  public PartialListInstancesException(
      @Nonnull List<String> unavailableZones, @Nonnull List<Instance> instances) {
    super("Failed to list all instances, some zones were unavailable: " + unavailableZones);

    this.unavailableZones = ImmutableList.copyOf(unavailableZones);
    this.instances = ImmutableList.copyOf(instances);
  }

  /** A list of zones, whose unavailability caused this error. */
  public List<String> getUnavailableZones() {
    return unavailableZones;
  }

  /** A partial list of instances that were found in the available zones. */
  public List<Instance> getInstances() {
    return instances;
  }
}
