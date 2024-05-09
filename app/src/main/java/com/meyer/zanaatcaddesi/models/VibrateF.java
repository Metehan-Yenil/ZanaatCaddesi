package com.meyer.zanaatcaddesi.models;
import android.content.Context;
import android.os.Vibrator;

public class VibrateF {

    // Metod, titreşim uzunluğunu ve context'i parametre olarak alır
    public void vibrate(Context context, long milliseconds) {
        // Vibrator nesnesi oluşturulur
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        // Eğer cihaz titreşim destekliyorsa ve vibrator nesnesi null değilse
        if (vibrator != null && vibrator.hasVibrator()) {
            // Belirtilen süre boyunca titreşim gerçekleştirilir
            vibrator.vibrate(milliseconds);
        }
    }

    // İkinci bir metod, titreşim deseni ve context'i parametre olarak alır
    public void vibratePattern(Context context, long[] pattern, int repeat) {
        // Vibrator nesnesi oluşturulur
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        // Eğer cihaz titreşim destekliyorsa ve vibrator nesnesi null değilse
        if (vibrator != null && vibrator.hasVibrator()) {
            // Belirtilen desene göre titreşim gerçekleştirilir
            vibrator.vibrate(pattern, repeat);
        }
    }

    // Titreşimi durduran bir metod
    public void cancelVibration(Context context) {
        // Vibrator nesnesi oluşturulur
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        // Eğer cihaz titreşim destekliyorsa ve vibrator nesnesi null değilse
        if (vibrator != null && vibrator.hasVibrator()) {
            // Aktif titreşimi durdur
            vibrator.cancel();
        }
    }



}
