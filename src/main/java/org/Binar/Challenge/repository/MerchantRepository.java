package org.Binar.Challenge.repository;

import org.Binar.Challenge.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
    // Mengambil daftar merchant yang sedang buka
    public List<Merchant> findByIsOpen(boolean isOpen);

    @Query(nativeQuery = true, value ="insert into merchant (merchantCode, nameMerchant, location, isOpen)" +
            "value (:merchantCode, :nameMerchant, :location, :isOpen)")
    void addMerchant(
            @Param("merchantCode") int merchantCode,
            @Param("nameMerchant") String nameMerchant,
            @Param("location") String location,
            @Param("isOpen") boolean isOpen
    );
    @Modifying
    @Query("UPDATE Merchant m SET m.isOpen = :isOpen WHERE m.merchantCode = :merchantCode")
    void editMerchantStatus(@Param("merchantCode") int merchantCode, @Param("isOpen") String isOpen);

    @Query(nativeQuery = true, value = "SELECT m FROM Merchant m WHERE m.isOpen")
    List<Merchant> getOpenMerchants();

}
