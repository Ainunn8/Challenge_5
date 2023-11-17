package org.Binar.Challenge.model.request;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleRequest {

    // Menjalankan setiap hari pukul 12:00 (makan siang)
    @Scheduled(cron = "0 0 12 * * ?")
    public void remindLunchPromo() {
        // Implementasi pengingat promo makan siang
        System.out.println("Waktunya makan siang! Ada promo di BinarFud. Cek sekarang!");

    }

    // Menjalankan setiap hari pukul 19:00 (makan malam)
    @Scheduled(cron = "0 0 19 * * ?")
    public void remindDinnerPromo() {
        // Implementasi pengingat promo makan malam
        System.out.println("Waktunya makan malam! Ada promo di BinarFud. Cek sekarang!");
    }
}