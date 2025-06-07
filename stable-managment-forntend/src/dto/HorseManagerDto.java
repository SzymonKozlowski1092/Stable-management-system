package dto;

import java.time.LocalDate;

import enums.HorseGender;

public class HorseManagerDto {
 private Long id;
 private String name;
 private String ownerFullName;
 private String ownerPhone;
 private HorseGender gender;
 private LocalDate birthDate;

 public HorseManagerDto() { }

 public HorseManagerDto(Long id, String name, String ownerFullName, String ownerPhone, HorseGender gender, LocalDate birthDate) {
     this.id = id;
     this.name = name;
     this.ownerFullName = ownerFullName;
     this.ownerPhone = ownerPhone;
     this.gender = gender;
     this.birthDate = birthDate;
 }

 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getOwnerFullName() {
     return ownerFullName;
 }

 public void setOwnerFullName(String ownerFullName) {
     this.ownerFullName = ownerFullName;
 }

 public String getOwnerPhone() {
     return ownerPhone;
 }

 public void setOwnerPhone(String ownerPhone) {
     this.ownerPhone = ownerPhone;
 }

 public HorseGender getGender() {
     return gender;
 }

 public void setGender(HorseGender gender) {
     this.gender = gender;
 }

 public LocalDate getbirthDate() {
     return birthDate;
 }

 public void setbirthDate(LocalDate birthDate) {
     this.birthDate = birthDate;
 }
}
