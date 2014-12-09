package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.gcloud.datastore.DatastoreServiceOptions.validateDataset;
import static com.google.gcloud.datastore.DatastoreServiceOptions.validateNamespace;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import java.util.LinkedList;
import java.util.List;

/**
 * Base class for keys.
 */
abstract class BaseKey extends Serializable<DatastoreV1.Key> {

  private static final long serialVersionUID = -4671243265877410635L;

  private final transient String dataset;
  private final transient String namespace;
  private final transient ImmutableList<PathElement> ancestors;
  private final transient String kind;

  abstract static class Builder<K extends PartialKey, B extends Builder<K, B>> {

    private String dataset;
    private String namespace;
    private String kind;
    private final List<PathElement> ancestors;

    private static final int MAX_PATH = 100;

    public Builder(String dataset, String kind) {
      this.dataset = validateDataset(dataset);
      this.kind = validateKind(kind);
      ancestors = new LinkedList<>();
    }

    public Builder(BaseKey copyFrom) {
      dataset = copyFrom.dataset();
      namespace = copyFrom.namespace();
      kind = copyFrom.kind();
      ancestors = new LinkedList<>(copyFrom.ancestors());
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    public B addAncestor(String kind, long id) {
      checkArgument(id != 0, "id must not be equal to zero");
      return addAncestor(new PathElement(kind, id));
    }

    public B addAncestor(String kind, String name) {
      checkArgument(Strings.isNullOrEmpty(name) , "name must not be empty or null");
      checkArgument(name.length() <= 500, "name must not exceed 500 characters");
      return addAncestor(new PathElement(kind, name));
    }

    public B addAncestor(PathElement... ancestor) {
      Preconditions.checkState(ancestors.size() + ancestor.length <= MAX_PATH,
          "path can have at most 100 elements");
      for (PathElement pathElement : ancestor) {
        ancestors.add(pathElement);
      }
      return self();
    }

    public B addAncestors(Iterable<PathElement> ancestors) {
      for (PathElement pathElement : ancestors) {
        addAncestor(pathElement);
      }
      return self();
    }

    public B kind(String kind) {
      this.kind = validateKind(kind);
      return self();
    }

    private String validateKind(String kind) {
      checkArgument(!Strings.isNullOrEmpty(kind), "kind must not be empty or null");
      checkArgument(kind.length() <= 500, "kind must not contain more than 500 characters");
      return kind;
    }

    public B clearPath() {
      ancestors.clear();
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

    public K build() {
      return build(dataset, namespace, ImmutableList.copyOf(ancestors), kind);
    }

    protected abstract K build(
        String dataset, String namespace, ImmutableList<PathElement> ancestors, String kind);
  }

  BaseKey(String dataset, String namespace, ImmutableList<PathElement> ancestors, String kind) {
    this.dataset = dataset;
    this.namespace = namespace;
    this.ancestors = ancestors;
    this.kind = kind;
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
    return ancestors;
  }

  /**
   * Returns the key's kind.
   */
  public String kind() {
    return kind;
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
    for (PathElement pathEntry : ancestors) {
      keyPb.addPathElement(pathEntry.toPb());
    }
    addLeaf(keyPb);
    return keyPb.build();
  }

  protected abstract void addLeaf(DatastoreV1.Key.Builder keyPb);
}
