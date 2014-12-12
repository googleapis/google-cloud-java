package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.List;

/**
 * A partial key (without a name or id).
 * Could be used as metadata for {@link PartialEntity}.
 * This class is immutable.
 */
public class PartialKey extends BaseKey {

  private static final long serialVersionUID = -75301206578793347L;

  public static class Builder extends BaseKey.Builder<PartialKey, Builder> {

    private Builder(String dataset, String kind) {
      super(dataset, kind);
    }

    private Builder(PartialKey copyFrom) {
      super(copyFrom);
    }

    @Override
    protected PartialKey build(String dataset, String namespace,
        ImmutableList<PathElement> ancestors, String kind) {
      return new PartialKey(dataset, namespace, ancestors, kind);
    }
  }

  PartialKey(String dataset, String namespace, ImmutableList<PathElement> ancestors, String kind) {
    super(dataset, namespace, ancestors, kind);
  }

  public Key newKey(String name) {
    return new Key(dataset(), namespace(), ImmutableList.copyOf(ancestors()), kind(), name);
  }

  public Key newKey(long id) {
    return new Key(dataset(), namespace(), ImmutableList.copyOf(ancestors()), kind(), id);
  }

  @Override
  protected PathElement leaf() {
    return new PathElement(kind());
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
    List<DatastoreV1.Key.PathElement> pathElementsPb = keyPb.getPathElementList();
    if (pathElementsPb.isEmpty()) {
      return new PartialKey(dataset, namespace, ImmutableList.<PathElement>of(), null);
    }
    ImmutableList.Builder<PathElement> pathBuilder = ImmutableList.builder();
    for (int i = 0; i < pathElementsPb.size() - 1; i++) {
      pathBuilder.add(PathElement.fromPb(pathElementsPb.get(i)));
    }
    DatastoreV1.Key.PathElement leaf = pathElementsPb.get(pathElementsPb.size() - 1);
    String kind = leaf.getKind();
    if (leaf.hasId()) {
      return new Key(dataset, namespace, pathBuilder.build(), kind, leaf.getId());
    } else if (leaf.hasName()) {
      return new Key(dataset, namespace, pathBuilder.build(), kind, leaf.getName());
    }
    return new PartialKey(dataset, namespace, pathBuilder.build(), kind);
  }

  public static Builder builder(String dataset, String kind) {
    return new Builder(dataset, kind);
  }

  public static Builder builder(PartialKey copyFrom) {
    return new Builder(copyFrom);
  }

  public static Builder builder(Key parent, String kind) {
    Builder builder = new Builder(parent.dataset(), kind)
        .namespace(parent.namespace())
        .addAncestors(parent.ancestors());
    if (parent.hasId()) {
      builder.addAncestor(new PathElement(parent.kind(), parent.id()));
    } else {
      builder.addAncestor(new PathElement(parent.kind(), parent.name()));
    }
    return builder;
  }
}
