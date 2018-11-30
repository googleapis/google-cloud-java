/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.compute.deprecated;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import java.util.Objects;

/** Base class for Google Compute Engine operation identities. */
public abstract class OperationId extends ResourceId {

  private static final long serialVersionUID = -5502909279744388604L;

  private final String operation;

  OperationId(String project, String operation) {
    super(project);
    this.operation = checkNotNull(operation);
  }

  /** Possible types for a Google Compute Engine operation identity. */
  enum Type {
    /**
     * Global operations are those operations that deal with global resources, such as global
     * addresses or snapshots.
     */
    GLOBAL,

    /**
     * Region operations are those operations that deal with resources that live in a region, such
     * as subnetworks.
     */
    REGION,

    /**
     * Zone operations are those operations that deal with resources that live in a zone, such as
     * disks and instances.
     */
    ZONE
  }

  /** Returns the type of this operation identity. */
  public abstract Type getType();

  /** Returns the name of the operation resource. */
  public String getOperation() {
    return operation;
  }

  @Override
  MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper().add("operation", operation);
  }

  @Override
  final int baseHashCode() {
    return Objects.hash(super.baseHashCode(), operation);
  }

  @Override
  final boolean baseEquals(ResourceId resourceId) {
    return resourceId instanceof OperationId
        && super.baseEquals(resourceId)
        && Objects.equals(operation, ((OperationId) resourceId).operation);
  }

  @Override
  abstract OperationId setProjectId(String projectId);
}
