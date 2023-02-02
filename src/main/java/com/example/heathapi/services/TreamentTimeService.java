package com.example.heathapi.services;

import com.example.heathapi.models.*;
import com.example.heathapi.repastory.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TreamentTimeService {

    private final PatientRepositrt patientRepositrt;

    private final TreamentFollowRepositry treamentFollowRepositrt;

    //    private final PatientRepositrt patientRepositrt;
    private final UserRepstory userRepstory;

    private final FollowingRepositry followingRepositry;


    private final TreamentRepositry treamentRepositry;
    private final TreamentTimeRepositry treamentTimeRepositry;

    public List<TreamentTime> treamentTimes() {
        return treamentTimeRepositry.findAll();
    }

    public void addTreamentTime(TreamentTime treamentTime) {
        treamentTimeRepositry.save(treamentTime);
    }

    public Boolean updateTreamentTime(Integer id, TreamentTime treamentTime) {
        TreamentTime u = treamentTimeRepositry.findByIdEquals(id);

        if (u == null) {
            return false;
        }
        treamentTime.setId(u.getId());
        treamentTimeRepositry.save(treamentTime);
        return true;
    }

    public Boolean deleteDTreamentTime(Integer id) {
        TreamentTime u = treamentTimeRepositry.findByIdEquals(id);
        if (u == null) {
            return false;

        }

        treamentTimeRepositry.delete(u);
        return true;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
     * Abdulaziz Alamri
     */


    public String getNotification(Integer id, String time) throws ParseException {
        Patient patient = patientRepositrt.findByIdEquals(id);

        if (patient != null) {
            Treament treament = treamentRepositry.findByPatientId(patient.getId());
            int treamentId = treament.getId();
            User user = userRepstory.findByIdEquals(patient.getUserId());
            String userName = user.getName();
            String userPhone = user.getPhone();

            TreamentTime treamentTime = treamentTimeRepositry.findByTreamsIdEquals(id);
            String getTreamentTime = treamentTime.getTime();

            Following following = followingRepositry.findByPatientIdEquals(patient.getId());
            User userFlowing = userRepstory.findByIdEquals(following.getId());
            double timeToTakeTrement = convertTimeToDecimal(getTreamentTime) - convertTimeToDecimal(time);
            TreamentFollow treamentFollow = treamentFollowRepositrt.TreamentTimeIde(treamentTime.getId());


            if (timeToTakeTrement < 1.0 && timeToTakeTrement > 0) {

                return "send notification you should take your drugs on " + formatTime(convertDecimalToTime(timeToTakeTrement)) + " \nPatient:" + user.getName() + " /phone:" + user.getPhone() + "\nUser: " + userFlowing.getName() + " phone: " + userFlowing.getPhone();
            } else if (timeToTakeTrement > 1.0) {
                return "it's not time to take your drugs" + formatTime(convertDecimalToTime(timeToTakeTrement));
            } else if (timeToTakeTrement < 0) {
                return "you missed time to take your drugs:" + formatTime(convertDecimalToTime(timeToTakeTrement));
            }
        }
        return null;
    }

    public String convertDecimalToTime(double t) {
        double buildTime = t;
        int hour = (int) t;
        int minute = (int) (t * 60) % 60;
        return hour + ":" + minute;
    }

    public double convertTimeToDecimal(String time) {
        String start = time;
        String[] sp = start.split(":");
        double h = Double.parseDouble(sp[0]);
        double m = Double.parseDouble(sp[1]);
        return h + (m * (1 / 60.0));
    }

    public static String formatTime(String time) throws ParseException {
        SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm");
        Date date = dataFormat.parse(time);
        return dataFormat.format(date);
    }
}