package com.google.gcloud.datastore;

import static com.google.gcloud.datastore.Validator.validateDataset;
import static com.google.gcloud.datastore.Validator.validateKind;
import static com.google.gcloud.datastore.Validator.validateNamespace;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Base class for keys.
 */
abstract class BaseKey extends Serializable<DatastoreV1.Key> {

  private static final long serialVersionUID = -4671243265877410635L;

  private final transient String dataset;
  private final transient String namespace;
  private final transient ImmutableList<PathElement> path;

  abstract static class Builder<B extends Builder<B>> {

    String dataset;
    String namespace;
    String kind;
    final List<PathElement> ancestors;

    private static final int MAX_PATH = 100;

    Builder(String dataset) {
      this.dataset = validateDataset(dataset);
      ancestors = new LinkedList<>();
    }

    Builder(String dataset, String kind) {
      this(dataset);
      this.kind = validateKind(kind);
    }

    Builder(BaseKey copyFrom) {
      dataset = copyFrom.dataset();
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

    public B dataset(String dataset) {
      this.dataset = validateDataset(dataset);
      return self();
    }

    public B namespace(String namespace) {
      this.namespace = validateNamespace(namespace);
      return self();
    }

    protected abstract BaseKey build();
  }

  BaseKey(String dataset, String namespace, ImmutableList<PathElement> path) {
    this.dataset = dataset;
    this.namespace = namespace;
    this.path = path;
  }

  /**
   * Returns the key's dataset.
   */
  public String dataset() {
    return dataset;
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

  @Override
  public int hashCode() {
    return Objects.hash(dataset(), namespace(), path());
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof BaseKey)) {
      return false;
    }
    PartialKey other = (PartialKey) obj;
    return Objects.equals(dataset(), other.dataset())
        && Objects.equals(namespace(), other.namespace())
        && Objects.equals(path(), other.path());
  }

  @Override
  protected DatastoreV1.Key toPb() {
    DatastoreV1.Key.Builder keyPb = DatastoreV1.Key.newBuilder();
    DatastoreV1.PartitionId.Builder partitionIdPb = DatastoreV1.PartitionId.newBuilder();
    if (dataset != null) {
      partitionIdPb.setDatasetId(dataset);
    }
    if (namespace != null) {
      partitionIdPb.setNamespace(namespace);
    }
    if (partitionIdPb.hasDatasetId() || partitionIdPb.hasNamespace()) {
      keyPb.setPartitionId(partitionIdPb.build());
    }
    for (PathElement pathEntry : path) {
      keyPb.addPathElement(pathEntry.toPb());
    }
    return keyPb.build();
  }
}
