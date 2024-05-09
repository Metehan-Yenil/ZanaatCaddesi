package com.meyer.zanaatcaddesi.ui.profil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Button;




import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.meyer.zanaatcaddesi.R;

import java.util.Calendar;


public class ProfilFragment extends Fragment {
    Button tarihGöster;
    DatePicker datePicker;
    TextView text;
    int ay,yil,gun;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_profil,container,false);


        datePicker = root.findViewById(R.id.datepicker);
        tarihGöster = root.findViewById(R.id.buttonTarih);
        text = root.findViewById(R.id.dogum_tarihi);


        tarihGöster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Güncel Tarihi Al
                gun = datePicker.getDayOfMonth();
                ay = datePicker.getMonth() + 1;
                yil = datePicker.getYear();


                String formattedDate = String.format("%d/%d/%d", gun, ay, yil);


                text.setText(formattedDate);
            }
        });

        return root;






    }


}