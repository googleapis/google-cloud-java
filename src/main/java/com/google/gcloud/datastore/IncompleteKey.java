package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static com.google.gcloud.datastore.DatastoreServiceOptions.validateDataset;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class IncompleteKey implements Serializable {

  private static final long serialVersionUID = -75301206578793347L;

  private final transient String dataset;
  private final transient String namespace;
  private final transient ImmutableList<PathEntry> path;
  private transient DatastoreV1.Key temp; // only for deserialization

  public static final class PathEntry implements Serializable {

    private static final long serialVersionUID = -7968078857690784595L;

    private final transient String kind;
    private final transient Long id;
    private final transient String name;
    private transient DatastoreV1.Key.PathElement tempPathElementPb;  // only for deserialization

    private PathEntry(String kind) {
      this(kind, null);
    }

    public PathEntry(String kind, long id) {
      this.kind = kind;
      this.id = id;
      this.name = null;
    }

    public PathEntry(String kind, String name) {
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
      if (!(obj instanceof PathEntry)) {
        return false;
      }
      PathEntry other = (PathEntry) obj;
      return Objects.equals(kind, other.kind)
          && Objects.equals(id, other.id)
          && Objects.equals(name, other.name);
    }

    static PathEntry fromPb(DatastoreV1.Key.PathElement pathElementPb) {
      String kind = pathElementPb.getKind();
      if (pathElementPb.hasId()) {
        return new PathEntry(kind, pathElementPb.getId());
      } else if (pathElementPb.hasName()) {
        return new PathEntry(kind, pathElementPb.getName());
      }
      return new PathEntry(kind);
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

  public static class Builder {

    private String dataset;
    private String namespace = DEFAULT_NAMESPACE;
    private String kind;
    private ImmutableList.Builder<PathEntry> path = ImmutableList.builder();

    private static final String DEFAULT_NAMESPACE = "";

    public Builder(String dataset, String kind) {
      this.dataset = validateDataset(dataset);
      this.kind = validateKind(kind);
    }

    public Builder(IncompleteKey key) {
      dataset = key.dataset;
      namespace = key.namespace;
      path = ImmutableList.<PathEntry>builder().addAll(key.getAncestorPath());
      kind = key.getKind();
    }

    public Builder addToPath(String kind, long id) {
      checkArgument(id != 0, "id must not be equal to zero");
      path.add(new PathEntry(kind, id));
      return this;
    }

    public Builder addToPath(String kind, String name) {
      checkArgument(Strings.isNullOrEmpty(name) , "name must not be empty or null");
      checkArgument(name.length() <= 500, "name must not exceed 500 characters");
      path.add(new PathEntry(kind, name));
      return this;
    }

    public void addToPath(PathEntry pathEntry) {
      path.add(pathEntry);
    }

    public Builder setKind(String kind) {
      this.kind = validateKind(kind);
      return this;
    }

    private String validateKind(String kind) {
      checkArgument(Strings.isNullOrEmpty(kind), "kind must not be empty or null");
      checkArgument(kind.length() <= 500, "kind must not contain more than 500 characters");
      return kind;
    }

    public Builder clearPath() {
      path = ImmutableList.builder();
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

    public IncompleteKey build() {
      PathEntry leaf = new PathEntry(kind);
      ImmutableList<PathEntry> pathList =
          ImmutableList.<PathEntry>builder().addAll(path.build()).add(leaf).build();
      return new IncompleteKey(dataset, namespace, pathList);
    }
  }

  IncompleteKey(String dataset, String namespace, ImmutableList<PathEntry> path) {
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

  protected List<PathEntry> getFullPath() {
    return path;
  }

  public List<PathEntry> getAncestorPath() {
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
    if (!(other instanceof IncompleteKey)) {
      return false;
    }
    IncompleteKey otherKey = (IncompleteKey) other;
    return Objects.equals(dataset, otherKey.dataset)
        && Objects.equals(namespace, otherKey.namespace)
        && Objects.equals(path, otherKey.path);
  }

  PathEntry getLeaf() {
    return path.get(path.size() - 1);
  }

  static IncompleteKey fromPb(DatastoreV1.Key keyPb) {
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
    ImmutableList.Builder<PathEntry> pathBuilder = ImmutableList.builder();
    for (DatastoreV1.Key.PathElement pathElementPb : keyPb.getPathElementList()) {
      pathBuilder.add(PathEntry.fromPb(pathElementPb));
    }
    return new IncompleteKey(dataset, namespace, pathBuilder.build());
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
    for (PathEntry pathEntry : path) {
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
    temp = DatastoreV1.Key.parseFrom(bytes);
  }

  @SuppressWarnings("unused")
  private Object readResolve() throws ObjectStreamException {
    return fromPb(temp);
  }
}
