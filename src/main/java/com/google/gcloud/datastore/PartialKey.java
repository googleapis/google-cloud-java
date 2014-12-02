package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static com.google.gcloud.datastore.DatastoreServiceOptions.validateDataset;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class PartialKey implements Serializable {

  private static final long serialVersionUID = -75301206578793347L;

  private final transient String dataset;
  private final transient String namespace;
  private final transient ImmutableList<PathElement> path;
  private transient DatastoreV1.Key tempKeyPb; // only for deserialization

  public static final class PathElement implements Serializable {

    private static final long serialVersionUID = -7968078857690784595L;

    private final transient String kind;
    private final transient Long id;
    private final transient String name;
    private transient DatastoreV1.Key.PathElement tempPathElementPb;  // only for deserialization

    private PathElement(String kind) {
      this(kind, null);
    }

    public PathElement(String kind, long id) {
      this.kind = kind;
      this.id = id;
      this.name = null;
    }

    public PathElement(String kind, String name) {
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

    public Object getNameOrId() {
      return id == null ? name : id;
    }

    @Override
    public String toString() {
      return toPb().toString();
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

    static PathElement fromPb(DatastoreV1.Key.PathElement pathElementPb) {
      String kind = pathElementPb.getKind();
      if (pathElementPb.hasId()) {
        return new PathElement(kind, pathElementPb.getId());
      } else if (pathElementPb.hasName()) {
        return new PathElement(kind, pathElementPb.getName());
      }
      return new PathElement(kind);
    }

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

    private void writeObject(ObjectOutputStream out) throws IOException {
      out.defaultWriteObject();
      out.writeObject(toPb().toByteArray());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
      in.defaultReadObject();
      byte[] bytes = (byte[]) in.readObject();
      tempPathElementPb = DatastoreV1.Key.PathElement.parseFrom(bytes);
    }

    @SuppressWarnings("unused")
    private Object readResolve() throws ObjectStreamException {
      return fromPb(tempPathElementPb);
    }
  }

  public static final class Builder {

    private String dataset;
    private String namespace = DEFAULT_NAMESPACE;
    private String kind;
    private List<PathElement> path = new LinkedList<>();

    private static final String DEFAULT_NAMESPACE = "";
    private static final int MAX_PATH = 100;

    public Builder(String dataset, String kind) {
      this.dataset = validateDataset(dataset);
      this.kind = validateKind(kind);
    }

    public Builder(PartialKey key) {
      dataset = key.dataset;
      namespace = key.namespace;
      kind = key.getKind();
      path.addAll(key.getAncestorPath());
    }

    public Builder addToPath(String kind, long id) {
      checkArgument(id != 0, "id must not be equal to zero");
      return addToPath(new PathElement(kind, id));
    }

    public Builder addToPath(String kind, String name) {
      checkArgument(Strings.isNullOrEmpty(name) , "name must not be empty or null");
      checkArgument(name.length() <= 500, "name must not exceed 500 characters");
      return addToPath(new PathElement(kind, name));
    }

    public Builder addToPath(PathElement pathEntry) {
      Preconditions.checkState(path.size() < MAX_PATH, "path can have at most 100 elements");
      path.add(pathEntry);
      return this;
    }

    public Builder setKind(String kind) {
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

    public Builder setDataset(String dataset) {
      this.dataset = validateDataset(dataset);
      return this;
    }

    public Builder setNamespace(String namespace) {
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

  public String getDataset() {
    return dataset;
  }

  public String getNamespace() {
    return namespace;
  }

  public List<PathElement> getAncestorPath() {
    return path.subList(0, path.size() - 1);
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
    if (!(other instanceof PartialKey)) {
      return false;
    }
    PartialKey otherKey = (PartialKey) other;
    return Objects.equals(dataset, otherKey.dataset)
        && Objects.equals(namespace, otherKey.namespace)
        && Objects.equals(path, otherKey.path);
  }

  PathElement getLeaf() {
    return path.get(path.size() - 1);
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

  DatastoreV1.Key toPb() {
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

  private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
    out.writeObject(toPb().toByteArray());
  }

  private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    byte[] bytes = (byte[]) in.readObject();
    tempKeyPb = DatastoreV1.Key.parseFrom(bytes);
  }

  @SuppressWarnings("unused")
  protected Object readResolve() throws ObjectStreamException {
    return fromPb(tempKeyPb);
  }
}
