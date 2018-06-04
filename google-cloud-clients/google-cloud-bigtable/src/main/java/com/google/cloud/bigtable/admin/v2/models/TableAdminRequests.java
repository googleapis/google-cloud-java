package com.google.cloud.bigtable.admin.v2.models;

import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.Table.TimestampGranularity;
import com.google.bigtable.admin.v2.CreateTableRequest.Split;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification;
import com.google.cloud.bigtable.admin.v2.models.GCRules.GCRule;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;

/**
 * Idiomatic models to build Bigtable admin requests
 * 
 */
public final class TableAdminRequests {
  private TableAdminRequests() {}

  public static CreateTable createTable(String tableId) {
    return new CreateTable(tableId);
  }

  public static ModifyFamilies modifyFamilies(String tableId) {
    return new ModifyFamilies(tableId);
  }

  public static final class CreateTable {
    private final CreateTableRequest.Builder createTableRequest = CreateTableRequest.newBuilder();
    private final Table.Builder tableRequest = Table.newBuilder();

    private CreateTable(String tableId) {
      createTableRequest.setTableId(tableId);
    }

    public CreateTable withGranularity(TimestampGranularity granularity) {
      Preconditions.checkNotNull(granularity);
      tableRequest.setGranularity(granularity);
      return this;
    }

    public CreateTable addColumnFamily(String familyId) {
      Preconditions.checkNotNull(familyId);
      tableRequest.putColumnFamilies(familyId, ColumnFamily.newBuilder().build());
      return this;
    }

    public CreateTable addColumnFamily(String familyId, GCRule gcRule) {
      Preconditions.checkNotNull(familyId);
      tableRequest.putColumnFamilies(familyId,
          ColumnFamily.newBuilder().setGcRule(gcRule.toProto()).build());
      return this;
    }

    public CreateTable addSplit(ByteString key) {
      Preconditions.checkNotNull(key);
      createTableRequest.addInitialSplits(Split.newBuilder().setKey(key).build());
      return this;
    }

    public CreateTable adduniformSplits(ByteString key) {
      Preconditions.checkNotNull(key);
      // TODO: add implementation
      throw new UnsupportedOperationException();
    }

    public CreateTableRequest toProto(String parent) {
      Preconditions.checkNotNull(parent);
      return createTableRequest.setParent(parent).setTable(tableRequest.build()).build();
    }
  }

  public static class ModifyFamilies {
    final ModifyColumnFamiliesRequest.Builder modFamilyRequest =
        ModifyColumnFamiliesRequest.newBuilder();
    String tableId;

    private ModifyFamilies(String tableId) {
      Preconditions.checkNotNull(tableId);
      this.tableId = tableId;
    }

    public String getTableId() {
      return this.tableId;
    }

    private Modification.Builder verifyAndCreate(String familyId) {
      Preconditions.checkNotNull(familyId);
      Modification.Builder modification = Modification.newBuilder();
      modification.setId(familyId);
      return modification;
    }

    public ModifyFamilies create(String familyId) {
      Modification.Builder modification = verifyAndCreate(familyId);
      modification.setCreate(ColumnFamily.newBuilder());
      modFamilyRequest.addModifications(modification.build());
      return this;
    }

    public ModifyFamilies createWithGCRule(String familyId, GCRule gcRule) {
      Modification.Builder modification = verifyAndCreate(familyId);
      Preconditions.checkNotNull(gcRule);
      modification.setCreate(ColumnFamily.newBuilder().setGcRule(gcRule.toProto()));
      modFamilyRequest.addModifications(modification.build());
      return this;
    }

    public ModifyFamilies update(String familyId) {
      Modification.Builder modification = verifyAndCreate(familyId);
      modification.setUpdate(ColumnFamily.newBuilder());
      modFamilyRequest.addModifications(modification.build());
      return this;
    }

    public ModifyFamilies updateWithGCRule(String familyId, GCRule gcRule) {
      Modification.Builder modification = verifyAndCreate(familyId);
      Preconditions.checkNotNull(gcRule);
      modification.setUpdate(ColumnFamily.newBuilder().setGcRule(gcRule.toProto()));
      modFamilyRequest.addModifications(modification.build());
      return this;
    }

    public ModifyFamilies drop(String familyId) {
      Modification.Builder modification = verifyAndCreate(familyId);
      modification.setId(familyId).setDrop(true);
      modFamilyRequest.addModifications(modification.build());
      return this;
    }

    public ModifyColumnFamiliesRequest toProto(String uniqueTableName) {
      Preconditions.checkNotNull(uniqueTableName);
      return modFamilyRequest.setName(uniqueTableName).build();
    }
  }
}
