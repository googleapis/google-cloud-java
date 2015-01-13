package com.google.gcloud.datastore;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.Preconditions;
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

  public static class Builder extends BaseKey.Builder<Builder> {

    private Builder(String dataset, String kind) {
      super(dataset, kind);
    }

    private Builder(PartialKey copyFrom) {
      super(copyFrom);
    }

    @Override
    public PartialKey build() {
      ImmutableList<PathElement> path = ImmutableList.<PathElement>builder()
          .addAll(ancestors).add(PathElement.of(kind)).build();
      return new PartialKey(dataset, namespace, path);
    }
  }

  PartialKey(String dataset, String namespace, ImmutableList<PathElement> path) {
    super(dataset, namespace, path);
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
    Preconditions.checkArgument(!pathElementsPb.isEmpty(), "Path must not be empty");
    ImmutableList.Builder<PathElement> pathBuilder = ImmutableList.builder();
    for (DatastoreV1.Key.PathElement pathElementPb : pathElementsPb) {
      pathBuilder.add(PathElement.fromPb(pathElementPb));
    }
    ImmutableList<PathElement> path = pathBuilder.build();
    PathElement leaf = path.get(path.size() - 1);
    if (leaf.nameOrId() != null) {
      return new Key(dataset, namespace, path);
    }
    return new PartialKey(dataset, namespace, path);
  }

  public static Builder builder(String dataset, String kind) {
    return new Builder(dataset, kind);
  }

  public static Builder builder(PartialKey copyFrom) {
    return new Builder(copyFrom);
  }

  public static Builder builder(Key parent, String kind) {
    return builder(parent.dataset(), kind).namespace(parent.namespace()).ancestors(parent.path());
  }
}
