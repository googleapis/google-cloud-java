/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.gcloud.resourcemanager;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a Google Cloud Resource Manager Resource ID
 */
public class ResourceId implements Serializable {

  private static final long serialVersionUID = 7928469304338358885L;
  private final String id;
  private final String type;

  private ResourceId(String id, String type) {
    this.id = checkNotNull(id);
    this.type = checkNotNull(type);
  }

  public String id() {
    return id;
  }

  public String type() {
    return type;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ResourceId && Objects.equals(toPb(), ((ResourceId) obj).toPb());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type);
  }

  public static ResourceId of(String id, String type) {
    return new ResourceId(id, type);
  }

  com.google.api.services.cloudresourcemanager.model.ResourceId toPb() {
    com.google.api.services.cloudresourcemanager.model.ResourceId resourceIdPb =
        new com.google.api.services.cloudresourcemanager.model.ResourceId();
    resourceIdPb.setId(id);
    resourceIdPb.setType(type.toString().toLowerCase());
    return resourceIdPb;
  }

  static ResourceId fromPb(
      com.google.api.services.cloudresourcemanager.model.ResourceId resourceIdPb) {
    return new ResourceId(resourceIdPb.getId(), resourceIdPb.getType());
  }
}
