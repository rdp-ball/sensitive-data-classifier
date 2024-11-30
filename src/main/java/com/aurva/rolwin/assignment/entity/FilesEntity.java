package com.aurva.rolwin.assignment.entity;

import com.aurva.rolwin.assignment.converter.StringListConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "files")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FilesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "pans")
//    @ElementCollection
//    @CollectionTable(name = "pan_list", joinColumns = @JoinColumn(name = "id"))
    @Convert(converter = StringListConverter.class)
    private List<String> panList;

    @Column(name = "ssns")
//    @ElementCollection
//    @CollectionTable(name = "social_security_numbers", joinColumns = @JoinColumn(name = "library_id"))
    @Convert(converter = StringListConverter.class)
    private List<String> ssns;

    @Column(name = "credit_card_numbers")
//    @ElementCollection
//    @CollectionTable(name = "credit_card_numbers", joinColumns = @JoinColumn(name = "id"))
    @Convert(converter = StringListConverter.class)
    private List<String> creditCardNumbers;

    @Column(name = "medical_records")
    private String medicalRecords;
}
