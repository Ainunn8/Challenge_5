package org.Binar.Challenge.service;

import lombok.extern.slf4j.Slf4j;
import org.Binar.Challenge.model.Merchant;
import org.Binar.Challenge.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MerchantServiceImpl implements MerchantService {
    private final org.Binar.Challenge.repository.MerchantRepository merchantRepository;

    @Autowired
    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public Merchant addMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant updateMerchant(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant getMerchantByCode(int merchantCode) {
        return merchantRepository.findByMerchantCode(merchantCode);
    }

    @Override
    public Merchant editMerchantStatus(int merchantCode, String isOpen) {
        return null; // Merchant not found
    }

    @Override
    public List<Merchant> getOpenMerchants() {
        return merchantRepository.findByIsOpen(true);
    }
}
