package app.example.app.androidviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CheckBox check1, check2;
    RadioGroup rGroup;
    RadioButton radioBtn;
    ToggleButton btnTog;
    RatingBar rBar;
    SeekBar sBar;
    DatePicker datePick;
    TimePicker timePick;
    Switch btnSwitch;
    CalendarView calendar;

    boolean android_checkbox;
    boolean ios_checkbox;
    String radio_selectedItem;
    boolean toggle_btn;
    boolean switch_btn;
    Float rating_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        check1=(CheckBox)findViewById(R.id.checkBox1);
        check2=(CheckBox)findViewById(R.id.checkBox2);
        rGroup=(RadioGroup) findViewById(R.id.radioGroup);
        btnTog=(ToggleButton)findViewById(R.id.toggleBtn);
        rBar=(RatingBar)findViewById(R.id.ratingBar);
        sBar=(SeekBar)findViewById(R.id.seekBar);
        datePick=(DatePicker)findViewById(R.id.datePicker);
        calendar = (CalendarView) findViewById(R.id.calenderView);
        timePick=(TimePicker)findViewById(R.id.timePicker);
        btnSwitch=(Switch)findViewById(R.id.switchBtn);



        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                android_checkbox = isChecked;
                //Toast.makeText(getApplicationContext(), buttonView.getText()+" is "+isChecked+"", Toast.LENGTH_LONG).show();

            }
        });

        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ios_checkbox = isChecked;
                //Toast.makeText(getApplicationContext(),isChecked+"", Toast.LENGTH_LONG).show();

            }
        });

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioBtn = (RadioButton)findViewById(checkedId);
                radio_selectedItem = radioBtn.getText().toString();
                Toast.makeText(getApplicationContext(),radioBtn.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });


        btnTog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggle_btn = isChecked;
            }
        });


        btnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch_btn = isChecked;
            }
        });


        rBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rating_value = rating;
            }
        });


        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(MainActivity.this,Integer.toString(progress),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        datePick.init(datePick.getYear(), datePick.getMonth(), datePick.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(MainActivity.this,(monthOfYear+1)+"/"+dayOfMonth+"/"+year,Toast.LENGTH_LONG).show();
            }
        });

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this,(month+1)+"/"+dayOfMonth+"/"+year,Toast.LENGTH_LONG).show();
            }
        });


        timePick.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String am_pm = (hourOfDay < 12) ? "AM" : "PM";
                Toast.makeText(MainActivity.this,"Hours: "+hourOfDay+" Mins: "+minute+" "+am_pm,Toast.LENGTH_LONG).show();
            }
        });
    }



}
