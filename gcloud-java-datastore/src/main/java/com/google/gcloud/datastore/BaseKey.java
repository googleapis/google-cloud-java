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

import static com.google.gcloud.datastore.Validator.validateDatabase;
import static com.google.gcloud.datastore.Validator.validateKind;
import static com.google.gcloud.datastore.Validator.validateNamespace;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Base class for keys.
 */
public abstract class BaseKey extends Serializable<com.google.datastore.v1beta3.Key> {

  private static final long serialVersionUID = -4671243265877410635L;

  private final transient String projectId;
  private final transient String namespace;
  private final transient ImmutableList<PathElement> path;

  /**
   * Base class for key builders.
   *
   * @param <B> the key builder.
   */
  protected abstract static class Builder<B extends Builder<B>> {

    String projectId = "";
    String namespace = "";
    String kind;
    final List<PathElement> ancestors;

    private static final int MAX_PATH = 100;

    Builder(String projectId) {
      this.projectId = validateDatabase(projectId);
      ancestors = new LinkedList<>();
    }

    Builder(String projectId, String kind) {
      this(projectId);
      this.kind = validateKind(kind);
    }

    Builder(BaseKey copyFrom) {
      projectId = copyFrom.projectId();
      namespace = copyFrom.namespace();
      ancestors = new LinkedList<>(copyFrom.ancestors());
      kind = copyFrom.kind();
    }

    @SuppressWarnings("unchecked")
    B self() {
      return (B) this;
    }

    public B ancestors(PathElement ancestor) {
      Preconditions.checkState(ancestors.size() < MAX_PATH, "path can have at most 100 elements");
      ancestors.add(ancestor);
      return self();
    }

    public B ancestors(PathElement ancestor, PathElement... other) {
      return ancestors(ImmutableList.<PathElement>builder().add(ancestor).add(other).build());
    }

    public B ancestors(Iterable<PathElement> ancestors) {
      ImmutableList<PathElement> list = ImmutableList.copyOf(ancestors);
      Preconditions.checkState(this.ancestors.size() + list.size() < MAX_PATH,
          "path can have at most 100 elements");
      this.ancestors.addAll(list);
      return self();
    }

    public B kind(String kind) {
      this.kind = validateKind(kind);
      return self();
    }

    public B projectId(String projectId) {
      this.projectId = validateDatabase(projectId);
      return self();
    }

    public B namespace(String namespace) {
      this.namespace = validateNamespace(namespace);
      return self();
    }

    protected abstract BaseKey build();
  }

  BaseKey(String projectId, String namespace, ImmutableList<PathElement> path) {
    Preconditions.checkArgument(!path.isEmpty(), "Path must not be empty");
    this.projectId = projectId;
    this.namespace = namespace;
    this.path = path;
  }

  /**
   * Returns the key's projectId.
   */
  public String projectId() {
    return projectId;
  }

  /**
   * Returns the key's namespace or {@code null} if not provided.
   */
  public String namespace() {
    return namespace;
  }

  /**
   * Returns an immutable list with the key's ancestors.
   */
  public List<PathElement> ancestors() {
    return path().subList(0, path().size() - 1);
  }

  /**
   * Returns an immutable list of the key's path (ancestors + self).
   */
  List<PathElement> path() {
    return path;
  }

  PathElement leaf() {
    return path().get(path().size() - 1);
  }

  /**
   * Returns the key's kind.
   */
  public String kind() {
    return leaf().kind();
  }

  abstract BaseKey parent();

  @Override
  public int hashCode() {
    return Objects.hash(projectId(), namespace(), path());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof BaseKey)) {
      return false;
    }
    BaseKey other = (BaseKey) obj;
    return Objects.equals(projectId(), other.projectId())
        && Objects.equals(namespace(), other.namespace())
        && Objects.equals(path(), other.path());
  }

  @Override
  com.google.datastore.v1beta3.Key toPb() {
    com.google.datastore.v1beta3.Key.Builder keyPb = com.google.datastore.v1beta3.Key.newBuilder();
    com.google.datastore.v1beta3.PartitionId.Builder partitionIdPb =
        com.google.datastore.v1beta3.PartitionId.newBuilder();
    partitionIdPb.setProjectId(projectId);
    partitionIdPb.setNamespaceId(namespace);
    keyPb.setPartitionId(partitionIdPb.build());
    for (PathElement pathEntry : path) {
      keyPb.addPath(pathEntry.toPb());
    }
    return keyPb.build();
  }
}
