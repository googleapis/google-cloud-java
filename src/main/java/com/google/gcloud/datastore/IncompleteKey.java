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

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.List;

/**
 * An incomplete key (without a name or id).
 * This class is immutable.
 */
public class IncompleteKey extends BaseKey {

  private static final long serialVersionUID = -75301206578793347L;

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

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Key.parseFrom(bytesPb));
  }

  static IncompleteKey fromPb(DatastoreV1.Key keyPb) {
    String projectId = null;
    String namespace = null;
    if (keyPb.hasPartitionId()) {
      DatastoreV1.PartitionId partitionIdPb = keyPb.getPartitionId();
      if (partitionIdPb.hasDatasetId()) {
        projectId = partitionIdPb.getDatasetId();
      }
      if (partitionIdPb.hasNamespace()) {
        namespace = partitionIdPb.getNamespace();
      }
    }
    List<DatastoreV1.Key.PathElement> pathElementsPb = keyPb.getPathElementList();
    Preconditions.checkArgument(!pathElementsPb.isEmpty(), "Path must not be empty");
    ImmutableList.Builder<PathElement> pathBuilder = ImmutableList.builder();
    for (DatastoreV1.Key.PathElement pathElementPb : pathElementsPb) {
      pathBuilder.add(PathElement.fromPb(pathElementPb));
    }
    ImmutableList<PathElement> path = pathBuilder.build();
    PathElement leaf = path.get(path.size() - 1);
    if (leaf.nameOrId() != null) {
      return new Key(projectId, namespace, path);
    }
    return new IncompleteKey(projectId, namespace, path);
  }

  public static Builder builder(String projectId, String kind) {
    return new Builder(projectId, kind);
  }

  public static Builder builder(IncompleteKey copyFrom) {
    return new Builder(copyFrom);
  }

  public static Builder builder(Key parent, String kind) {
    return builder(parent.projectId(), kind).namespace(parent.namespace()).ancestors(parent.path());
  }
}
