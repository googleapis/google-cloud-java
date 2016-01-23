/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Strings;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Objects;

/**
 * Represents a single element in a key's path.
 */
public final class PathElement extends Serializable<DatastoreV1.Key.PathElement> {

  private static final long serialVersionUID = -7968078857690784595L;

  private final transient String kind;
  private final transient Long id;
  private final transient String name;

  private PathElement(String kind, String name, Long id) {
    this.kind = checkNotNull(kind, "kind must not be null");
    this.name = name;
    this.id = id;
  }

  public String kind() {
    return kind;
  }

  public boolean hasId() {
    return id != null;
  }

  public Long id() {
    return id;
  }

  public boolean hasName() {
    return name != null;
  }

  public String name() {
    return name;
  }

  public Object nameOrId() {
    return id == null ? name : id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, id, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof PathElement)) {
      return false;
    }
    PathElement other = (PathElement) obj;
    return Objects.equals(kind, other.kind)
        && Objects.equals(id, other.id)
        && Objects.equals(name, other.name);
  }

  @Override
  DatastoreV1.Key.PathElement toPb() {
    DatastoreV1.Key.PathElement.Builder pathElementPb = DatastoreV1.Key.PathElement.newBuilder();
    pathElementPb.setKind(kind);
    if (id != null) {
      pathElementPb.setId(id);
    } else if (name != null) {
      pathElementPb.setName(name);
    }
    return pathElementPb.build();
  }

  @Override
  Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Key.PathElement.parseFrom(bytesPb));
  }

  static PathElement fromPb(DatastoreV1.Key.PathElement pathElementPb) {
    String kind = pathElementPb.getKind();
    if (pathElementPb.hasId()) {
      return of(kind, pathElementPb.getId());
    }
    if (pathElementPb.hasName()) {
      return of(kind, pathElementPb.getName());
    }
    return of(kind);
  }

  static PathElement of(String kind) {
    return new PathElement(kind, null, null);
  }

  public static PathElement of(String kind, String name) {
    checkArgument(!Strings.isNullOrEmpty(name) , "name must not be empty or null");
    checkArgument(name.length() <= 500, "name must not exceed 500 characters");
    return new PathElement(kind, name, null);
  }

  public static PathElement of(String kind, long id) {
    checkArgument(id != 0, "id must not be equal to zero");
    return new PathElement(kind, null, id);
  }
}
