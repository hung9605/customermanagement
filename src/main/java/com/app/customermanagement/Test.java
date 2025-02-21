package com.app.customermanagement;

import java.io.File;

public class Test {

    public static void main(String[] args) {
    	String uploadDir = "uploads/";
        File directory = new File(uploadDir);
        //if (!directory.exists()) {
          boolean mk =   directory.mkdirs();
          System.out.println(mk);
        //}
        String fileName = "test";
        File dest = new File(uploadDir + fileName);
    }
    
//    LOCK TABLES `menu` WRITE;
//    /*!40000 ALTER TABLE `menu` DISABLE KEYS */;
//    INSERT INTO `menu` VALUES (1,NULL,'2025-02-05 00:00:00.000000',NULL,'tnd','pi pi-register','Register','/register',NULL),(2,NULL,'2025-02-05 00:00:00.000000',NULL,'tnd','pi pi-listregister','List Register','/listregister',NULL),(3,NULL,'2025-02-05 00:00:00.000000',NULL,'tnd','pi pi-history','List History','/historycustomer',NULL),(4,NULL,'2025-02-05 00:00:00.000000',NULL,'tnd','pi pi-customer','List Customer','/listcustomer',NULL),(5,NULL,'2025-02-05 00:00:00.000000',NULL,'tnd','pi pi-test','Test','/test',NULL),(10,NULL,'2025-02-05 00:00:00.000000',NULL,'tnd','pi pi-money','Total Money','/money',NULL),(11,NULL,'2025-02-05 00:00:00.000000',NULL,'tnd','pi pi-backup','Backup','/db',NULL),(12,NULL,NULL,NULL,'tnd','pi pi-medicalsupplies','Medical Supplies',NULL,NULL);
//    /*!40000 ALTER TABLE `menu` ENABLE KEYS */;
//    UNLOCK TABLES;
}

