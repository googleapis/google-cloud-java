package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static com.google.gcloud.datastore.DatastoreServiceOptions.validateDataset;

import com.google.api.services.datastore.DatastoreV1;
import com.google.api.services.datastore.DatastoreV1.Key.PathElement;
import com.google.api.services.datastore.DatastoreV1.PartitionId;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;

public final class Key {

  private final String dataset;
  private final String namespace;
  private final ImmutableList<PathEntry> path;

  public static final class PathEntry {

    private final String kind;
    private final Long id;
    private final String name;

    PathEntry(String kind) {
      this.kind = kind;
      this.id = null;
      this.name = null;
    }

    PathEntry(String kind, long id) {
      checkArgument(id != 0, "id must not be equal to zero");
      this.kind = kind;
      this.id = id;
      this.name = null;
    }

    PathEntry(String kind, String name) {
      checkArgument(Strings.isNullOrEmpty(name) , "name must not be empty or null");
      checkArgument(name.length() <= 500, "name must not exceed 500 characters");
      this.kind = kind;
      this.name = name;
      this.id = null;
    }

    public String getKind() {
      return kind;
    }

    public boolean hasId() {
      return id != null;
    }

    public long getId() {
      return id == null ? 0 : id;
    }

    public boolean hasName() {
      return name != null;
    }

    public String getName() {
      return name == null ? "" : name;
    }
  }

  public static class Builder {

    private String dataset;
    private String namespace;
    private ImmutableList.Builder<PathEntry> path = ImmutableList.builder();

    public Builder addChild(String kind, long id) {
      path.add(new PathEntry(kind, id));
      return this;
    }

    public Builder addChild(String kind, String name) {
      path.add(new PathEntry(kind, name));
      return this;
    }

    public Builder addChild(String kind) {
      path.add(new PathEntry(kind));
      return this;
    }

    public Builder setDataset(String dataset) {
      this.dataset = dataset == null ? null : validateDataset(dataset);
      return this;
    }

    public Builder setNamespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    public Key build() {
      return new Key(dataset, namespace, path.build());
    }
  }

  private Key(String dataset, String namespace, ImmutableList<PathEntry> path) {
    checkState(!path.isEmpty(), "path must not be empty");
    this.dataset = dataset;
    this.namespace = namespace;
    this.path = path;
  }

  public String getDataset() {
    return dataset;
  }

  public String getNamespace() {
    return namespace;
  }

  public List<PathEntry> getPath() {
    return path;
  }

  public String getKind() {
    return getLeaf().getKind();
  }

  @Override
  public String toString() {
    return toPb().toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataset, namespace, path);
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Key)) {
      return false;
    }
    Key otherKey = (Key) other;
    return Objects.equals(dataset, otherKey.dataset)
        && Objects.equals(namespace, otherKey.namespace)
        && Objects.equals(path, otherKey.path);
  }

  PathEntry getLeaf() {
    return path.get(path.size() - 1);
  }

  static Key fromPb(DatastoreV1.Key keyPb) {
    Builder builder = new Builder();
    if (keyPb.hasPartitionId()) {
      PartitionId partitionIdPb = keyPb.getPartitionId();
      if (partitionIdPb.hasDatasetId()) {
        builder.setDataset(partitionIdPb.getDatasetId());
      }
      if (partitionIdPb.hasNamespace()) {
        builder.setNamespace(partitionIdPb.getNamespace());
      }
    }
    for (PathElement pathElementPb : keyPb.getPathElementList()) {
      String kind = pathElementPb.getKind();
      if (pathElementPb.hasId()) {
        builder.addChild(kind, pathElementPb.getId());
      } else if (pathElementPb.hasName()) {
        builder.addChild(kind, pathElementPb.getName());
      } else {
        builder.addChild(kind);
      }
    }
    return builder.build();
  }

  DatastoreV1.Key toPb() {
    DatastoreV1.Key.Builder keyPb = DatastoreV1.Key.newBuilder();
    PartitionId.Builder partitionIdPb = PartitionId.newBuilder();
    if (dataset != null) {
      partitionIdPb.setDatasetId(dataset);
    }
    if (namespace != null) {
      partitionIdPb.setNamespace(namespace);
    }
    if (partitionIdPb.hasDatasetId() || partitionIdPb.hasNamespace()) {
      keyPb.setPartitionId(partitionIdPb.build());
    }
    for (PathEntry pathEntry : path) {
      PathElement.Builder pathElementPb = PathElement.newBuilder();
      pathElementPb.setKind(pathEntry.kind);
      if (pathEntry.id != null) {
        pathElementPb.setId(pathEntry.id);
      } else if (pathEntry.name != null) {
        pathElementPb.setName(pathEntry.name);
      }
      keyPb.addPathElement(pathElementPb.build());
    }
    return keyPb.build();
  }
}
