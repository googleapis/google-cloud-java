package com.google.cloud.bigtable.admin.v2.it;

import static com.google.cloud.bigtable.admin.v2.models.GCRules.GCRULES;
import static org.junit.Assert.*;
import java.io.IOException;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.Table.TimestampGranularity;
import com.google.bigtable.admin.v2.TableName;
import com.google.cloud.bigtable.admin.v2.TableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests.CreateTable;
import com.google.cloud.bigtable.admin.v2.models.TableAdminRequests.ModifyFamilies;
import com.google.protobuf.ByteString;

public class TableAdminClientIT {
  static TableAdminClient tableAdmin;

  @BeforeClass
  public static void setup() throws IOException {
    tableAdmin = TableAdminClient.create(InstanceName.of("sduskis-hello-shakespear", "beam-test"));
  }

  @AfterClass
  public static void cleanup() throws Exception {
    tableAdmin.close();
  }

  @Test
  public void createTable() throws Exception {
    String tableId = "adminCreateTest";
    CreateTable createTableReq =
        TableAdminRequests.createTable(tableId).addColumnFamily("cf1")
                          .addColumnFamily("cf2", GCRULES.versions().maxNum(10))
                          .withGranularity(TimestampGranularity.MILLIS)
                          .addSplit(ByteString.copyFromUtf8("b"))
                          .addSplit(ByteString.copyFromUtf8("q"));

    try {
      Table table = tableAdmin.createTable(createTableReq);
      assertNotNull(table);
      assertTrue(table.getName().endsWith(tableId));
      assertEquals(2, table.getColumnFamiliesCount());
      assertFalse(table.getColumnFamiliesMap().get("cf1").hasGcRule());
      assertTrue(table.getColumnFamiliesMap().get("cf2").hasGcRule());
      assertEquals(10, table.getColumnFamiliesMap().get("cf2").getGcRule().getMaxNumVersions());
      assertEquals(TimestampGranularity.MILLIS, table.getGranularity());
      // TODO: is there a way to test splits here?
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void modifyFamilies() {
    String tableId = "adminModifyFamTest";
    ModifyFamilies modifyFamiliesReq = TableAdminRequests.modifyFamilies(tableId);
    modifyFamiliesReq.create("mf1").createWithGCRule("mf2", GCRULES.age().seconds(1000).nanos(20000))
                     .updateWithGCRule("mf1",
                                       GCRULES.union().rule(GCRULES.age().seconds(100))
                                              .rule(GCRULES.versions().maxNum(1)))
                     .createWithGCRule("mf3",
                                       GCRULES.intersection().rule(GCRULES.age().seconds(2000))
                                              .rule(GCRULES.versions().maxNum(10)))
                     .createWithGCRule("mf4",
                                       GCRULES.intersection().rule(GCRULES.age().seconds(360)))
                     .create("mf5").create("mf6").drop("mf5").drop("mf6").create("mf7");

    try {
      tableAdmin.createTable(TableAdminRequests.createTable(tableId));
      Table table = tableAdmin.modifyFamilies(modifyFamiliesReq);
      assertEquals(5, table.getColumnFamiliesCount());
      assertNotNull(table.getColumnFamiliesOrThrow("mf1"));
      assertNotNull(table.getColumnFamiliesOrThrow("mf2"));
      assertTrue(table.getColumnFamiliesOrThrow("mf1").getGcRule().hasUnion());
      assertEquals(1000,
                   table.getColumnFamiliesOrThrow("mf2").getGcRule().getMaxAge().getSeconds());
      assertEquals(20000, table.getColumnFamiliesOrThrow("mf2").getGcRule().getMaxAge().getNanos());
      assertTrue(table.getColumnFamiliesOrThrow("mf3").getGcRule().hasIntersection());
      assertFalse(table.getColumnFamiliesOrThrow("mf4").getGcRule().hasIntersection());
      assertTrue(table.getColumnFamiliesOrThrow("mf4").getGcRule().hasMaxAge());
      assertNotNull(table.getColumnFamiliesOrThrow("mf7"));
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void deleteTable() {
    String tableId = "adminDeleteTest";
    tableAdmin.createTable(TableAdminRequests.createTable(tableId));
    tableAdmin.deleteTable(tableId);
  }

  @Test
  public void getTable() {
    String tableId = "adminGetTest";
    
    try {
      tableAdmin.createTable(TableAdminRequests.createTable(tableId));
      Table table = tableAdmin.getTable(tableId);
      assertNotNull(table);
      assertTrue(table.getName().endsWith(tableId));
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }

  @Test
  public void listTables() {
    String tableId = "adminListTest";

    try {
      tableAdmin.createTable(TableAdminRequests.createTable(tableId));
      List<TableName> tables = tableAdmin.listTables();
      assertNotNull(tables);
      assertEquals(1, tables.size());
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }
  
  @Test
  public void listTablesAsync() throws Exception {
    String tableId = "adminListTest";

    try {
      tableAdmin.createTable(TableAdminRequests.createTable(tableId));
      List<TableName> tables = tableAdmin.listTablesAsync().get();
      assertNotNull(tables);
      assertEquals(1, tables.size());
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }
  
  @Test
  public void dropRowRange() {
    String tableId = "adminDropRowrangeTest";

    try {
      tableAdmin.createTable(TableAdminRequests.createTable(tableId));
      tableAdmin.dropRowRange(tableId, "*");
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }
  
  @Test
  public void CheckConsistency() {
    String tableId = "adminConsistencyTest";

    try {
      tableAdmin.createTable(TableAdminRequests.createTable(tableId));
      String token = tableAdmin.GenerateConsistencyToken(tableId);
      boolean consistent = tableAdmin.isConsistent(tableId, token);
      assertNotNull(token);
      assertTrue(consistent);
    } finally {
      tableAdmin.deleteTable(tableId);
    }
  }
}
