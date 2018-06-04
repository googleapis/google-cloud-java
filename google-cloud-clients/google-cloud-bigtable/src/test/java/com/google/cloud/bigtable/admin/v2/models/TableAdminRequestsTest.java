package com.google.cloud.bigtable.admin.v2.models;

import static com.google.common.truth.Truth.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.google.bigtable.admin.v2.ColumnFamily;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.CreateTableRequest.Split;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest.Modification;
import com.google.bigtable.admin.v2.Table.TimestampGranularity;
import com.google.protobuf.ByteString;

@RunWith(JUnit4.class)
public class TableAdminRequestsTest {

  @Test
  public void createTable() {
    CreateTableRequest actual = TableAdminRequests.createTable("tableId")
        .withGranularity(TimestampGranularity.MILLIS)
        .addColumnFamily("cf1")
        .addColumnFamily("cf2", GCRules.GCRULES.versions().maxNum(1))
        .addSplit(ByteString.copyFromUtf8("c")).toProto("parent");
    
    CreateTableRequest expected =
        CreateTableRequest.newBuilder().setTableId("tableId").setParent("parent")
        .addInitialSplits(Split.newBuilder().setKey(ByteString.copyFromUtf8("c")))
        .setTable(
            Table.newBuilder().setGranularity(TimestampGranularity.MILLIS)
            .putColumnFamilies("cf1", ColumnFamily.newBuilder().build())
            .putColumnFamilies("cf2", ColumnFamily.newBuilder().setGcRule(GCRules.GCRULES.versions().maxNum(1).toProto()).build()))
            .build();
    
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test (expected = NullPointerException.class)
  public void createTable_RequiredTableId() {
    TableAdminRequests.createTable(null).toProto("parent");
  }

  @Test (expected = NullPointerException.class)
  public void createTable_RequiredParent() {
    TableAdminRequests.createTable("tableId").toProto(null);
  }
  
  @Test 
  public void modifyFamilies() {
    ModifyColumnFamiliesRequest actual = TableAdminRequests.modifyFamilies("tableId")
        .create("cf1")
        .createWithGCRule("cf2", GCRules.GCRULES.versions().maxNum(1))
        .create("cf3")
        .update("cf2")
        .updateWithGCRule("cf1", GCRules.GCRULES.versions().maxNum(5))
        .drop("cf3")
        .toProto("uniqueTableName");
    
    ModifyColumnFamiliesRequest expected = ModifyColumnFamiliesRequest.newBuilder()
        .setName("uniqueTableName")
        .addModifications(Modification.newBuilder().setId("cf1").setCreate(ColumnFamily.newBuilder()))
        .addModifications(Modification.newBuilder().setId("cf2").setCreate(ColumnFamily.newBuilder().setGcRule(GCRules.GCRULES.versions().maxNum(1).toProto())))
        .addModifications(Modification.newBuilder().setId("cf3").setCreate(ColumnFamily.newBuilder()))
        .addModifications(Modification.newBuilder().setId("cf2").setUpdate(ColumnFamily.newBuilder()))
        .addModifications(Modification.newBuilder().setId("cf1").setUpdate(ColumnFamily.newBuilder().setGcRule(GCRules.GCRULES.versions().maxNum(5).toProto())))
        .addModifications(Modification.newBuilder().setId("cf3").setDrop(true))
        .build();
    assertThat(actual).isEqualTo(expected);
  }
  
  @Test (expected = NullPointerException.class)
  public void modifyFamilies_RequiredTableId() {
    TableAdminRequests.modifyFamilies(null).toProto("uniqueTableName");
  }

  @Test (expected = NullPointerException.class)
  public void modifyFamilies_RequiredParent() {
    TableAdminRequests.modifyFamilies("tableId").toProto(null);
  }
}
