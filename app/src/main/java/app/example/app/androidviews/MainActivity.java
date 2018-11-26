package app.example.app.androidviews;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText text, mobile;
    CheckBox check1, check2;
    RadioGroup rGroup;
    RadioButton radioBtn;
    ToggleButton btnTog;
    SeekBar sBar;
    DatePicker datePick;
    TimePicker timePick;
    Switch btnSwitch;
//    CalendarView calendar;
    Spinner spinValues;
    Button submit_btn;


    boolean regular_checkbox;
    boolean weekend_checkbox;
    String radio_selectedItem;
    boolean toggle_btn;
    boolean switch_btn;
    String time_selected;
    String date_selected;
    String spinner_selected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.editText1);
        mobile = (EditText) findViewById(R.id.editText2);
        check1=(CheckBox)findViewById(R.id.checkBox1);
        check2=(CheckBox)findViewById(R.id.checkBox2);
        rGroup=(RadioGroup) findViewById(R.id.radioGroup);
        btnTog=(ToggleButton)findViewById(R.id.toggleBtn);
        sBar=(SeekBar)findViewById(R.id.seekBar);
        btnSwitch=(Switch)findViewById(R.id.switchBtn);
        datePick=(DatePicker)findViewById(R.id.datePicker);
//        calendar = (CalendarView) findViewById(R.id.calenderView);
        timePick=(TimePicker)findViewById(R.id.timePicker);
        spinValues = (Spinner) findViewById(R.id.spinnerItems);


        //Submit Button
        submit_btn = (Button) findViewById(R.id.submitButton);
        submit_btn.setEnabled(false);



        //Spinner Insert Values
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.spinner_input));
        spinValues.setAdapter(adapter);




        //Checkbox Listeners
        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                regular_checkbox = isChecked;
            }
        });

        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                weekend_checkbox = isChecked;
            }
        });



        //RadioGroup Listener
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioBtn = (RadioButton)findViewById(checkedId);
                radio_selectedItem = radioBtn.getText().toString();
            }
        });



        //Spinner Listener
        spinValues.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_selected = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        //Toggle Button Listener
        btnTog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                toggle_btn = isChecked;
            }
        });




        //Switch Button Listener
        btnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch_btn = isChecked;
            }
        });




        //DatePicker Initialization
        datePick.init(datePick.getYear(), datePick.getMonth(), datePick.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date_selected = (monthOfYear+1)+"/"+dayOfMonth+"/"+year;
            }
        });



//        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                Toast.makeText(MainActivity.this,(month+1)+"/"+dayOfMonth+"/"+year,Toast.LENGTH_LONG).show();
//            }
//        });




        //Time Picker Listener
        timePick.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String am_pm = (hourOfDay < 12) ? "AM" : "PM";
                time_selected = hourOfDay+":"+minute+" "+am_pm;
            }
        });




        //Seek Bar Listener
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress == 100){
                    submit_btn.setEnabled(true);
                }else{
                    Toast.makeText(getApplicationContext(), "Slide the bar until it reached end", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        //Submit Button Listener
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(text.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Enter your name", Toast.LENGTH_SHORT).show();
                }else if(mobile.getText().length() != 10){
                    Toast.makeText(getApplicationContext(), "Enter the valid mobile number", Toast.LENGTH_SHORT).show();
                }else {
                    AlertDialog confirm_values = new AlertDialog.Builder(MainActivity.this).create();
                    confirm_values.setTitle("Want to Proceed?");
                    confirm_values.setMessage(
                            "Name: " + text.getText().toString() +
                                    "\nMobile: " + mobile.getText().toString() +
                                    "\nGender: " + radio_selectedItem +
                                    "\nCourse: " + spinner_selected +
                                    "\nRegular: " + regular_checkbox +
                                    "\nWeekend: " + weekend_checkbox +
                                    "\nFlexible with Time: " + switch_btn +
                                    "\nFastrack Class: " + toggle_btn +
                                    "\nJoining Date: " + date_selected +
                                    "\nPreferred Time: " + time_selected);

                    confirm_values.setButton(Dialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivityForResult(new Intent(MainActivity.this, Main2Activity.class), 1);
                        }
                    });
                    confirm_values.setButton(Dialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    confirm_values.show();
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");
                String rating = data.getStringExtra("rating");
                Toast.makeText(getApplicationContext(), "Application Sent: "+result+". Thank you for giving Rating as: "+rating, Toast.LENGTH_LONG).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                String result=data.getStringExtra("result");
                Toast.makeText(getApplicationContext(), "Application Sent: "+result+". Thank you for Choosing us!", Toast.LENGTH_LONG).show();
            }
        }
    }

}
