package com.app.customermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.app.customermanagement.dto.model.InventoryDTO;
import com.app.customermanagement.dto.model.InventoryReportDTO;
import com.app.customermanagement.model.Inventory;
import com.app.customermanagement.model.MedicalSupplies;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
	
	List<Inventory> findByMedicalSupplies(MedicalSupplies medicalSupplies);
	
	@Query("SELECT new com.app.customermanagement.dto.model.InventoryDTO(" +
            "i.id, " +
            "ms.medicineName, " +
            "ms.unitPrice, " +
            "i.quantity, " +
            "i.location, " +
            "i.status, " +
            "ms.supplier, " +					
            "i.createdAt, " +
            "i.createdBy, " +
            "i.updatedAt, " +
            "i.updatedBy" +
            ") " +
            "FROM Inventory i " +
            "INNER JOIN i.medicalSupplies ms ORDER BY ms.medicineName,i.receivedDate")
    List<InventoryDTO> fetchInventoryWithMedicalSupplies();
	

//	WITH inventory_detail AS (
//		    SELECT 
//		        i1_0.medical_supplies_id,
//		        ms1_0.medicine_name,
//		        i1_0.status,
//		        i1_0.quantity,
//		        i1_0.location,
//		        i1_0.received_date,
//		        NULL AS total_quantity,       -- placeholder để đồng nhất với summary
//		        'DETAIL' AS record_type       -- để phân biệt dòng chi tiết
//		    FROM inventory i1_0 
//		    JOIN medical_supplies ms1_0 
//		        ON ms1_0.id = i1_0.medical_supplies_id
//		),
//
//		inventory_summary AS (
//		    SELECT 
//		        i.medical_supplies_id,
//		        NULL AS medicine_name,
//		        i.status,
//		        NULL AS quantity,
//		        NULL AS location,
//		        NULL AS received_date,
//		        SUM(i.quantity) AS total_quantity,
//		        'SUMMARY' AS record_type
//		    FROM inventory i
//		    GROUP BY i.medical_supplies_id, i.status
//		)
//
//		-- UNION cả 2 lại
//		SELECT * FROM inventory_detail
//		UNION ALL
//		SELECT * FROM inventory_summary
//		ORDER BY medical_supplies_id,received_date;
	
	@Query(value = """
		    WITH inventory_detail AS (
    SELECT 
        i.id,
        i.medical_supplies_id,
        ms.medicine_name,
        ms.unit_price,
        i.quantity,
        i.location,
        i.status,
        ms.supplier,
        i.created_at,
        i.created_by,
        i.updated_at,
        i.updated_by,
        i.received_date,
        NULL AS total_quantity,
        'DETAIL' AS record_type
    FROM inventory i
    JOIN medical_supplies ms ON ms.id = i.medical_supplies_id
),
inventory_summary AS (
    SELECT 
        NULL AS id,
        i.medical_supplies_id,
        ms.medicine_name,
        ms.unit_price,
        NULL AS quantity,
        i.location,
        i.status,
        ms.supplier,
        NULL AS created_at,
        NULL AS created_by,
        NULL AS updated_at,
        NULL AS updated_by,
        NULL AS received_date,
        SUM(i.quantity) AS total_quantity,
        'SUMMARY' AS record_type
    FROM inventory i
    JOIN medical_supplies ms ON ms.id = i.medical_supplies_id
    GROUP BY i.medical_supplies_id, i.status, ms.medicine_name, ms.unit_price,i.location, ms.supplier
),
combined AS (
    SELECT * FROM inventory_detail
    UNION ALL
    SELECT * FROM inventory_summary
)

    SELECT *,
           ROW_NUMBER() OVER (PARTITION BY medical_supplies_id, status ORDER BY record_type DESC, received_date) AS row_order
    FROM combined

ORDER BY medical_supplies_id, status, row_order

		    """, nativeQuery = true)
	List<InventoryReportDTO> getInventoryReport();


	
	
	@Transactional
	@Modifying
	@Query("update Inventory i set i.quantity = :quantity,i.status = :status,i.location= :location where i.id = :id")
	void update(@Param("quantity") Integer quantity,@Param("status") String status
	,@Param("location") String location, @Param("id") Long id);

}