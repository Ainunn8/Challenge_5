package org.Binar.Challenge.service;

import org.Binar.Challenge.model.Merchant;

import java.util.List;

public interface MerchantService {
    // Menambahkan merchant baru
    Merchant addMerchant(Merchant merchant);

    // Mengedit status merchant (buka/tutup)
    Merchant editMerchantStatus(int merchantCode, String isOpen);

    // Menampilkan merchant yang sedang buka
    List<Merchant> getOpenMerchants();
}
