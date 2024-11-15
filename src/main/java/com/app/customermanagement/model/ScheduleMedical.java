package com.app.customermanagement.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedule_medical")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleMedical extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String fullName;
    String timeRegister;
    String dateRegister;
    Integer status;
    
    
    public ScheduleMedical(Integer id) {
		super();
		this.id = id;
	}


	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(columnDefinition = "customer_id")
    Customer customer;

}
