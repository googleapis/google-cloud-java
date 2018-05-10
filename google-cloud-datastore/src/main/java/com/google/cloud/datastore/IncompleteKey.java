/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * An incomplete key (without a name or id).
 * This class is immutable.
 */
public class IncompleteKey extends BaseKey {

  private static final long serialVersionUID = 4947014765344279019L;

  public static class Builder extends BaseKey.Builder<Builder> {

    private Builder(String projectId, String kind) {
      super(projectId, kind);
    }

    private Builder(IncompleteKey copyFrom) {
      super(copyFrom);
    }

    @Override
    public IncompleteKey build() {
      ImmutableList<PathElement> path = ImmutableList.<PathElement>builder()
          .addAll(ancestors).add(PathElement.of(kind)).build();
      return new IncompleteKey(projectId, namespace, path);
    }
  }

  IncompleteKey(String projectId, String namespace, ImmutableList<PathElement> path) {
    super(projectId, namespace, path);
  }

  static IncompleteKey fromPb(com.google.datastore.v1.Key keyPb) {
    String projectId = "";
    String namespace = "";
    if (keyPb.hasPartitionId()) {
      com.google.datastore.v1.PartitionId partitionIdPb = keyPb.getPartitionId();
      projectId = partitionIdPb.getProjectId();
      namespace = partitionIdPb.getNamespaceId();
    }
    List<com.google.datastore.v1.Key.PathElement> pathElementsPb = keyPb.getPathList();
    Preconditions.checkArgument(!pathElementsPb.isEmpty(), "Path must not be empty");
    ImmutableList.Builder<PathElement> pathBuilder = ImmutableList.builder();
    for (com.google.datastore.v1.Key.PathElement pathElementPb : pathElementsPb) {
      pathBuilder.add(PathElement.fromPb(pathElementPb));
    }
    ImmutableList<PathElement> path = pathBuilder.build();
    PathElement leaf = path.get(path.size() - 1);
    if (leaf.getNameOrId() != null) {
      return new Key(projectId, namespace, path);
    }
    return new IncompleteKey(projectId, namespace, path);
  }


  /**
   * Returns the key's parent.
   */
  @Override
  public Key getParent() {
    List<PathElement> ancestors = getAncestors();
    if (ancestors.isEmpty()) {
      return null;
    }
    PathElement parent = ancestors.get(ancestors.size() - 1);
    Key.Builder keyBuilder;
    if (parent.hasName()) {
      keyBuilder = Key.newBuilder(getProjectId(), parent.getKind(), parent.getName());
    } else {
      keyBuilder = Key.newBuilder(getProjectId(), parent.getKind(), parent.getId());
    }
    String namespace = getNamespace();
    if (namespace != null) {
      keyBuilder.setNamespace(namespace);
    }
    return keyBuilder.addAncestors(ancestors.subList(0, ancestors.size() - 1)).build();
  }


  public static Builder newBuilder(String projectId, String kind) {
    return new Builder(projectId, kind);
  }


  public static Builder newBuilder(IncompleteKey copyFrom) {
    return new Builder(copyFrom);
  }


  public static Builder newBuilder(Key parent, String kind) {
    return newBuilder(parent.getProjectId(), kind)
        .setNamespace(parent.getNamespace())
        .addAncestors(parent.getPath());
  }
}
