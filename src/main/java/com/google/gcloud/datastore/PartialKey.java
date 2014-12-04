package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static com.google.gcloud.datastore.DatastoreServiceOptions.validateDataset;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * A partial key (without a name or id).
 * Could be used as metadata for {@link PartialEntity}.
 * This class is immutable. To edit (a copy) use {@link #builder()}.
 */
public class PartialKey extends Serializable<DatastoreV1.Key> {

  private static final long serialVersionUID = -75301206578793347L;

  private final transient String dataset;
  private final transient String namespace;
  private final transient ImmutableList<PathElement> path;

  public static final class PathElement extends Serializable<DatastoreV1.Key.PathElement> {

    private static final long serialVersionUID = -7968078857690784595L;

    private final transient String kind;
    private final transient Long id;
    private final transient String name;

    private PathElement(String kind) {
      this(kind, null);
    }

    public PathElement(String kind, long id) {
      this.kind = kind;
      this.id = id;
      name = null;
    }

    public PathElement(String kind, String name) {
      this.kind = kind;
      this.name = name;
      id = null;
    }

    public String kind() {
      return kind;
    }

    public boolean hasId() {
      return id != null;
    }

    public long id() {
      return id == null ? 0 : id;
    }

    public boolean hasName() {
      return name != null;
    }

    public String name() {
      return name == null ? "" : name;
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
      if (!(obj instanceof PathElement)) {
        return false;
      }
      PathElement other = (PathElement) obj;
      return Objects.equals(kind, other.kind)
          && Objects.equals(id, other.id)
          && Objects.equals(name, other.name);
    }

    @Override
    protected DatastoreV1.Key.PathElement toPb() {
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
    protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
      return fromPb(DatastoreV1.Key.PathElement.parseFrom(bytesPb));
    }

    static PathElement fromPb(DatastoreV1.Key.PathElement pathElementPb) {
      String kind = pathElementPb.getKind();
      if (pathElementPb.hasId()) {
        return new PathElement(kind, pathElementPb.getId());
      } else if (pathElementPb.hasName()) {
        return new PathElement(kind, pathElementPb.getName());
      }
      return new PathElement(kind);
    }
  }

  public static class Builder {

    private String dataset;
    private String namespace = DEFAULT_NAMESPACE;
    private String kind;
    private final List<PathElement> path = new LinkedList<>();

    private static final String DEFAULT_NAMESPACE = "";
    private static final int MAX_PATH = 100;

    public Builder(String dataset, String kind) {
      this.dataset = validateDataset(dataset);
      this.kind = validateKind(kind);
    }

    public Builder(Key parent, String kind) {
      dataset = parent.dataset();
      namespace = parent.namespace();
      path.addAll(parent.ancestors());
      path.add(parent.getLeaf());
      this.kind = kind;
    }

    public Builder addAncestor(String kind, long id) {
      checkArgument(id != 0, "id must not be equal to zero");
      return addAncestor(new PathElement(kind, id));
    }

    public Builder addAncestor(String kind, String name) {
      checkArgument(Strings.isNullOrEmpty(name) , "name must not be empty or null");
      checkArgument(name.length() <= 500, "name must not exceed 500 characters");
      return addAncestor(new PathElement(kind, name));
    }

    public Builder addAncestor(PathElement... ancestor) {
      Preconditions.checkState(path.size() + ancestor.length <= MAX_PATH,
          "path can have at most 100 elements");
      for (PathElement pathElement : ancestor) {
        path.add(pathElement);
      }
      return this;
    }

    public Builder addAncestors(Iterable<PathElement> ancestors) {
      for (PathElement pathElement : ancestors) {
        addAncestor(pathElement);
      }
      return this;
    }

    public Builder kind(String kind) {
      this.kind = validateKind(kind);
      return this;
    }

    private String validateKind(String kind) {
      checkArgument(!Strings.isNullOrEmpty(kind), "kind must not be empty or null");
      checkArgument(kind.length() <= 500, "kind must not contain more than 500 characters");
      return kind;
    }

    public Builder clearPath() {
      path.clear();
      return this;
    }

    public Builder dataset(String dataset) {
      this.dataset = validateDataset(dataset);
      return this;
    }

    public Builder namespace(String namespace) {
      this.namespace = checkNotNull(namespace);
      return this;
    }

    public PartialKey build() {
      PathElement leaf = new PathElement(kind);
      ImmutableList<PathElement> pathList =
          ImmutableList.<PathElement>builder().addAll(path).add(leaf).build();
      return new PartialKey(dataset, namespace, pathList);
    }
  }

  PartialKey(String dataset, String namespace, ImmutableList<PathElement> path) {
    checkState(!path.isEmpty(), "path must not be empty");
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
   * Returns the key's namespace.
   */
  public String namespace() {
    return namespace;
  }

  /**
   * Returns an immutable list with the key's ancestors.
   */
  public List<PathElement> ancestors() {
    return path.subList(0, path.size() - 1);
  }

  /**
   * Returns the key's kind.
   */
  public String kind() {
    return getLeaf().kind();
  }

  public Builder builder() {
    return new Builder(dataset(), kind()).namespace(namespace()).addAncestors(ancestors());
  }

  public Key toKey(String name) {
    return new Key.Builder(dataset(), kind(), name)
        .namespace(namespace())
        .addAncestors(ancestors())
        .build();
  }

  public Key toKey(long id) {
    return new Key.Builder(dataset(), kind(), id)
        .namespace(namespace())
        .addAncestors(ancestors())
        .build();
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataset, namespace, path);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof PartialKey)) {
      return false;
    }
    PartialKey other = (PartialKey) obj;
    return Objects.equals(dataset, other.dataset)
        && Objects.equals(namespace, other.namespace)
        && Objects.equals(path, other.path);
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

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(DatastoreV1.Key.parseFrom(bytesPb));
  }

  static PartialKey fromPb(DatastoreV1.Key keyPb) {
    String dataset = null;
    String namespace = null;
    if (keyPb.hasPartitionId()) {
      DatastoreV1.PartitionId partitionIdPb = keyPb.getPartitionId();
      if (partitionIdPb.hasDatasetId()) {
        dataset = partitionIdPb.getDatasetId();
      }
      if (partitionIdPb.hasNamespace()) {
        namespace = partitionIdPb.getNamespace();
      }
    }
    ImmutableList.Builder<PathElement> pathBuilder = ImmutableList.builder();
    for (DatastoreV1.Key.PathElement pathElementPb : keyPb.getPathElementList()) {
      pathBuilder.add(PathElement.fromPb(pathElementPb));
    }
    return new PartialKey(dataset, namespace, pathBuilder.build());
  }

  PathElement getLeaf() {
    return path.get(path.size() - 1);
  }
}
