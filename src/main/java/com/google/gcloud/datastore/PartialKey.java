package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;
import static com.google.gcloud.datastore.DatastoreServiceOptions.validateDataset;
import static com.google.gcloud.datastore.DatastoreServiceOptions.validateNamespace;

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
  private final transient ImmutableList<Ancestor> ancestors;

  public static final class Ancestor extends Serializable<DatastoreV1.Key.PathElement> {

    private static final long serialVersionUID = -7968078857690784595L;

    private final transient String kind;
    private final transient Long id;
    private final transient String name;

    private Ancestor(String kind) {
      this(kind, null);
    }

    public Ancestor(String kind, long id) {
      this.kind = kind;
      this.id = id;
      name = null;
    }

    public Ancestor(String kind, String name) {
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
      if (!(obj instanceof Ancestor)) {
        return false;
      }
      Ancestor other = (Ancestor) obj;
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

    static Ancestor fromPb(DatastoreV1.Key.PathElement pathElementPb) {
      String kind = pathElementPb.getKind();
      if (pathElementPb.hasId()) {
        return new Ancestor(kind, pathElementPb.getId());
      } else if (pathElementPb.hasName()) {
        return new Ancestor(kind, pathElementPb.getName());
      }
      return new Ancestor(kind);
    }
  }

  public static class Builder {

    private String dataset;
    private String namespace;
    private String kind;
    private final List<Ancestor> ancestors = new LinkedList<>();

    private static final int MAX_PATH = 100;

    public Builder(String dataset, String kind) {
      this.dataset = validateDataset(dataset);
      this.kind = validateKind(kind);
    }

    public Builder(Key parent, String kind) {
      dataset = parent.dataset();
      namespace = parent.namespace();
      ancestors.addAll(parent.ancestors());
      ancestors.add(parent.getLeaf());
      this.kind = kind;
    }

    public Builder addAncestor(String kind, long id) {
      checkArgument(id != 0, "id must not be equal to zero");
      return addAncestor(new Ancestor(kind, id));
    }

    public Builder addAncestor(String kind, String name) {
      checkArgument(Strings.isNullOrEmpty(name) , "name must not be empty or null");
      checkArgument(name.length() <= 500, "name must not exceed 500 characters");
      return addAncestor(new Ancestor(kind, name));
    }

    public Builder addAncestor(Ancestor... ancestor) {
      Preconditions.checkState(ancestors.size() + ancestor.length <= MAX_PATH,
          "path can have at most 100 elements");
      for (Ancestor pathElement : ancestor) {
        ancestors.add(pathElement);
      }
      return this;
    }

    public Builder addAncestors(Iterable<Ancestor> ancestors) {
      for (Ancestor pathElement : ancestors) {
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
      ancestors.clear();
      return this;
    }

    public Builder dataset(String dataset) {
      this.dataset = validateDataset(dataset);
      return this;
    }

    public Builder namespace(String namespace) {
      this.namespace = validateNamespace(namespace);
      return this;
    }

    public PartialKey build() {
      Ancestor leaf = new Ancestor(kind);
      ImmutableList<Ancestor> pathList =
          ImmutableList.<Ancestor>builder().addAll(ancestors).add(leaf).build();
      return new PartialKey(dataset, namespace, pathList);
    }
  }

  PartialKey(String dataset, String namespace, ImmutableList<Ancestor> path) {
    checkState(!path.isEmpty(), "path must not be empty");
    this.dataset = dataset;
    this.namespace = namespace;
    this.ancestors = path;
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
  public List<Ancestor> ancestors() {
    return ancestors.subList(0, ancestors.size() - 1);
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
    return Objects.hash(dataset, namespace, ancestors);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof PartialKey)) {
      return false;
    }
    PartialKey other = (PartialKey) obj;
    return Objects.equals(dataset, other.dataset)
        && Objects.equals(namespace, other.namespace)
        && Objects.equals(ancestors, other.ancestors);
  }

  @Override
  protected DatastoreV1.Key toPb() {
    return toPb(this).build();
  }

  static DatastoreV1.Key.Builder toPb(PartialKey key) {
    DatastoreV1.Key.Builder keyPb = DatastoreV1.Key.newBuilder();
    DatastoreV1.PartitionId.Builder partitionIdPb = DatastoreV1.PartitionId.newBuilder();
    if (key.dataset != null) {
      partitionIdPb.setDatasetId(key.dataset);
    }
    if (key.namespace != null) {
      partitionIdPb.setNamespace(key.namespace);
    }
    if (partitionIdPb.hasDatasetId() || partitionIdPb.hasNamespace()) {
      keyPb.setPartitionId(partitionIdPb.build());
    }
    for (Ancestor pathEntry : key.ancestors) {
      keyPb.addPathElement(pathEntry.toPb());
    }
    return keyPb;
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
    ImmutableList.Builder<Ancestor> pathBuilder = ImmutableList.builder();
    for (DatastoreV1.Key.PathElement pathElementPb : keyPb.getPathElementList()) {
      pathBuilder.add(Ancestor.fromPb(pathElementPb));
    }
    return new PartialKey(dataset, namespace, pathBuilder.build());
  }

  Ancestor getLeaf() {
    return ancestors.get(ancestors.size() - 1);
  }
}
