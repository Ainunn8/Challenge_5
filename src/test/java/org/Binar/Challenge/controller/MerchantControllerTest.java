package org.Binar.Challenge.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.Binar.Challenge.model.Merchant;
import org.Binar.Challenge.service.MerchantService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public class MerchantControllerTest {

    @InjectMocks
    private MerchantController merchantController;

    @Mock
    private MerchantService merchantService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddMerchant() {
        // Buat objek Merchant yang akan digunakan dalam pengujian
        Merchant newMerchant = new Merchant();
        newMerchant.setMerchantCode(1);
        newMerchant.setNameMerchant("Merchant1");
        newMerchant.setLocation("Location1");
        newMerchant.setIsOpen("Yes");

        // Panggil metode yang akan diuji
        ResponseEntity responseEntity = merchantController.addMerchant(newMerchant);

        // Verifikasi bahwa metode addMerchant pada merchantService telah dipanggil dengan benar
        verify(merchantService, times(1)).addMerchant(newMerchant);

        // Verifikasi bahwa respon sesuai dengan yang diharapkan
        assertEquals(ResponseEntity.ok("Add new merchant successful!"), responseEntity);
    }

    @Test
    public void testUpdateMerchant() {
        int merchantCode = 1;

        // Buat objek Merchant yang akan digunakan dalam pengujian
        Merchant existingMerchant = new Merchant();
        existingMerchant.setMerchantCode(merchantCode);
        existingMerchant.setNameMerchant("Merchant1");
        existingMerchant.setLocation("Location1");
        existingMerchant.setIsOpen("Yes");

        Merchant updatedMerchant = new Merchant();
        updatedMerchant.setMerchantCode(merchantCode);
        updatedMerchant.setNameMerchant("UpdatedMerchant1");
        updatedMerchant.setLocation("UpdatedLocation1");
        updatedMerchant.setIsOpen("No");

        // Konfigurasi perilaku mock untuk merchantService
        when(merchantService.getMerchantByCode(merchantCode)).thenReturn(existingMerchant);
        when(merchantService.updateMerchant(existingMerchant)).thenReturn(updatedMerchant);

        // Panggil metode yang akan diuji
        ResponseEntity responseEntity = merchantController.updateMerchant(merchantCode, updatedMerchant);

        // Verifikasi bahwa metode getMerchantByCode pada merchantService telah dipanggil dengan benar
        verify(merchantService, times(1)).getMerchantByCode(merchantCode);

        // Verifikasi bahwa metode updateMerchant pada merchantService telah dipanggil dengan benar
        verify(merchantService, times(1)).updateMerchant(existingMerchant);

        // Verifikasi bahwa respon sesuai dengan yang diharapkan
        assertEquals(ResponseEntity.ok(updatedMerchant), responseEntity);
    }

    @Test
    public void testGetOpenMerchants() {
        // Buat beberapa objek Merchant sebagai contoh
        Merchant openMerchant1 = new Merchant();
        openMerchant1.setNameMerchant("Merchant1");
        openMerchant1.setIsOpen("Yes");

        Merchant closedMerchant = new Merchant();
        closedMerchant.setNameMerchant("Merchant2");
        closedMerchant.setIsOpen("No");

        Merchant openMerchant2 = new Merchant();
        openMerchant2.setNameMerchant("Merchant3");
        openMerchant2.setIsOpen("Yes");

        // Konfigurasi perilaku mock untuk merchantService
        when(merchantService.getOpenMerchants()).thenReturn(Arrays.asList(openMerchant1, openMerchant2));

        // Panggil metode yang akan diuji
        List<Merchant> openMerchants = merchantController.getOpenMerchants();

        // Verifikasi bahwa metode getOpenMerchants pada merchantService telah dipanggil
        verify(merchantService, times(1)).getOpenMerchants();

        // Verifikasi hasil pengujian
        assertEquals(2, openMerchants.size());
        assertEquals(openMerchant1, openMerchants.get(0));
        assertEquals(openMerchant2, openMerchants.get(1));
    }
}

