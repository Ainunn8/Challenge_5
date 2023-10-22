package org.Binar.Challenge.controller;

import lombok.extern.slf4j.Slf4j;
import org.Binar.Challenge.model.Merchant;
import org.Binar.Challenge.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/Merchant")
@Slf4j
public class MerchantController {

    @Autowired
    MerchantService merchantService;


    // Menambahkan merchant
    @PostMapping(value = "add-Merchant")
    public ResponseEntity addMerchant(@RequestBody Merchant merchant) {
        merchantService.addMerchant(Merchant.builder()
                .merchantCode(merchant.getMerchantCode())
                .nameMerchant(merchant.getNameMerchant())
                .location(merchant.getLocation())
                .isOpen(merchant.getIsOpen())
                .build());
        return ResponseEntity.ok("Add new merchant successful!");

    }
    //Edit status merchant buka/tutup
    @PutMapping("/{id}/status")
    public ResponseEntity editMerchantStatus(
            @PathVariable int merchantCode,
            @RequestParam String isOpen) {
        Merchant updatedMerchant = merchantService.editMerchantStatus(merchantCode, isOpen);
        if (updatedMerchant != null) {
            return ResponseEntity.ok(updatedMerchant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Menampilkan Merchant yang Sedang Buka
    @GetMapping("/Open")
    public List<Merchant> getOpenMerchants() {
        List<Merchant> openMerchants = merchantService.getOpenMerchants();
        return openMerchants;
    }

}
