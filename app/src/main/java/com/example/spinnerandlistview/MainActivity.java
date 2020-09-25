package com.example.spinnerandlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener {

    ListView list;
    Spinner spin;
    TextView city;
    TextView population;
    TextView language;
    TextView anthem;
    String continent="";
    String[] continents={"אסיה","אמריקה הצפונית","אמריקה הדרומית","אירופה"};
    String[][] countries=new String[4][7];
    String[][] data=new String[28][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView) findViewById(R.id.list);
        spin=(Spinner) findViewById(R.id.spin);
        city=(TextView) findViewById(R.id.city);
        population=(TextView) findViewById(R.id.population);
        language=(TextView) findViewById(R.id.language);
        anthem=(TextView) findViewById(R.id.anthem);

        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> adp1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,continents);
        spin.setAdapter(adp1);

        list.setOnItemClickListener(this);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        countries[0][0]="יפן"; countries[0][1]="הודו"; countries[0][2]="סין"; countries[0][3]="תאילנד"; countries[0][4]="ישראל"; countries[0][5]="לבנון"; countries[0][6]="איראן";
        countries[1][0]="ארצות הברית"; countries[1][1]="קנדה"; countries[1][2]="מקסיקו"; countries[1][3]="קובה"; countries[1][4]="פנמה"; countries[1][5]="הונדורס"; countries[1][6]="קוסטה ריקה";
        countries[2][0]="ברזיל"; countries[2][1]="ארגנטינה"; countries[2][2]="קולומביה"; countries[2][3]="פרו"; countries[2][4]="צ'ילה"; countries[2][5]="אורוגוואי"; countries[2][6]="בוליביה";
        countries[3][0]="גרמניה"; countries[3][1]="צרפת"; countries[3][2]="איטליה"; countries[3][3]="בריטניה"; countries[3][4]="הולנד"; countries[3][5]="יוון"; countries[3][6]="שוויץ";

        data[0][0]="עיר בירה: טוקיו"; data[0][1]="אוכלוסייה: 126.5 מיליון"; data[0][2]="שפה רשמית: יפנית"; data[0][3]="המנון לאומי: שלטונך";
        data[1][0]="עיר בירה: ניו דלהי"; data[1][1]="אוכלוסייה: 1.38 מיליארד"; data[1][2]="שפה רשמית: הודית"; data[1][3]="המנון לאומי: ג'אנה גאנה מאנה";
        data[2][0]="עיר בירה: בייג'ינג"; data[2][1]="אוכלוסייה: 1.439 מיליארד"; data[2][2]="שפה רשמית: סינית"; data[2][3]="המנון לאומי: מארש המתנדבים";
        data[3][0]="עיר בירה: בנקוק"; data[3][1]="אוכלוסייה: 69.43 מיליון"; data[3][2]="שפה רשמית: תאית"; data[3][3]="המנון לאומי: פלנג צאט";
        data[4][0]="עיר בירה: ירושלים"; data[4][1]="אוכלוסייה: 8.884 מיליון"; data[4][2]="שפה רשמית: עברית"; data[4][3]="המנון לאומי: התקווה";
        data[5][0]="עיר בירה: ביירות"; data[5][1]="אוכלוסייה: 6.825 מיליון"; data[5][2]="שפה רשמית: ערבית"; data[5][3]="המנון לאומי: כולנו למען המולדת, התהילה והדגל";
        data[6][0]="עיר בירה: טהרן"; data[6][1]="אוכלוסייה: 81.8 מיליון"; data[6][2]="שפה רשמית: פרסית"; data[6][3]="המנון לאומי: ההמנון הלאומי של הרפובליקה האסלאמית של איראן";
        data[7][0]="עיר בירה: וושינגטון"; data[7][1]="אוכלוסייה: 328.2 מיליון"; data[7][2]="שפה רשמית: אנגלית"; data[7][3]="המנון לאומי: הדגל זרוע-הכוכבים";
        data[8][0]="עיר בירה: אוטוואה"; data[8][1]="אוכלוסייה: 37 מיליון"; data[8][2]="שפה רשמית: אנגלית"; data[8][3]="המנון לאומי: הו קנדה";
        data[9][0]="עיר בירה: מקסיקו סיטי"; data[9][1]="אוכלוסייה: 128.932 מיליון"; data[9][2]="שפה רשמית: ספרדית"; data[9][3]="המנון לאומי: ההמנון הלאומי המקסיקני";
        data[10][0]="עיר בירה: הוואנה"; data[10][1]="אוכלוסייה: 11.326 מיליון"; data[10][2]="שפה רשמית: ספרדית"; data[10][3]="המנון לאומי: שיר הביימו";
        data[11][0]="עיר בירה: פנמה סיטי"; data[11][1]="אוכלוסייה: 4.314 מיליון"; data[11][2]="שפה רשמית: ספרדית"; data[11][3]="המנון לאומי: מצר היבשה";
        data[12][0]="עיר בירה: טגוסיגאלפה"; data[12][1]="אוכלוסייה: 9.588 מיליון"; data[12][2]="שפה רשמית: ספרדית"; data[12][3]="המנון לאומי: דגלך מואר באופן שמיימי";
        data[13][0]="עיר בירה: סן חוסה"; data[13][1]="אוכלוסייה: 5.094 מיליון"; data[13][2]="שפה רשמית: ספרדית"; data[13][3]="המנון לאומי: מולדת אצילה, דגלך היפה";
        data[14][0]="עיר בירה: ברזיליה"; data[14][1]="אוכלוסייה: 212.559 מיליון"; data[14][2]="שפה רשמית: פורטוגזית"; data[14][3]="המנון לאומי: ההמנון הברזילאי הלאומי";
        data[15][0]="עיר בירה: בואנוס איירס"; data[15][1]="אוכלוסייה: 45.195 מיליון"; data[15][2]="שפה רשמית: ספרדית"; data[15][3]="המנון לאומי: ההמנון הלאומי של ארגנטינה";
        data[16][0]="עיר בירה: בוגוטה"; data[16][1]="אוכלוסייה: 49.65 מיליון"; data[16][2]="שפה רשמית: ספרדית"; data[16][3]="המנון לאומי: המנון קולומביה";
        data[17][0]="עיר בירה: לימה"; data[17][1]="אוכלוסייה: 31.99 מיליון"; data[17][2]="שפה רשמית: ספרדית"; data[17][3]="המנון לאומי: אנחנו חופשיים, ולעד ניהיה כאלה";
        data[18][0]="עיר בירה: סנטיאגו"; data[18][1]="אוכלוסייה: 18.73 מיליון"; data[18][2]="שפה רשמית: ספרדית"; data[18][3]="המנון לאומי: השיר הלאומי";
        data[19][0]="עיר בירה: מונטווידאו"; data[19][1]="אוכלוסייה: 3.473 מיליון"; data[19][2]="שפה רשמית: ספרדית"; data[19][3]="המנון לאומי: בני המזרח, המולדת או הקבר";
        data[20][0]="עיר בירה: לה פאס, סוקרה"; data[20][1]="אוכלוסייה: 11.673 מיליון"; data[20][2]="שפה רשמית: ספרדית"; data[20][3]="המנון לאומי: Bolivianos, el hado propicio";
        data[21][0]="עיר בירה: ברלין"; data[21][1]="אוכלוסייה: 83.783 מיליון"; data[21][2]="שפה רשמית: גרמנית"; data[21][3]="המנון לאומי: שיר הגרמנים";
        data[22][0]="עיר בירה: פריז"; data[22][1]="אוכלוסייה: 65.273 מיליון"; data[22][2]="שפה רשמית: צרפתית"; data[22][3]="המנון לאומי: המארסייז";
        data[23][0]="עיר בירה: רומא"; data[23][1]="אוכלוסייה: 60.461 מיליון"; data[23][2]="שפה רשמית: איטלקית"; data[23][3]="המנון לאומי: המנון האיטלקים";
        data[24][0]="עיר בירה: לונדון"; data[24][1]="אוכלוסייה: 67.886 מיליון"; data[24][2]="שפה רשמית: אנגלית"; data[24][3]="המנון לאומי: אלוהים נצור את המלאכה";
        data[25][0]="עיר בירה: אמסטרדם"; data[25][1]="אוכלוסייה: 17.134 מיליון"; data[25][2]="שפה רשמית: הולנדית"; data[25][3]="המנון לאומי: שירו של וילהלמוס";
        data[26][0]="עיר בירה: אתונה"; data[26][1]="אוכלוסייה: 10.423 מיליון"; data[26][2]="שפה רשמית: יוונית"; data[26][3]="המנון לאומי: המנון לחירות";
        data[27][0]="עיר בירה: ברן"; data[27][1]="אוכלוסייה: 8.654 מיליון"; data[27][2]="שפה רשמית: גרמנית"; data[27][3]="המנון לאומי: מזמור שוויץ";
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (continent.equals("אסיה"))
        {
            city.setText(data[position][0]);
            population.setText(data[position][1]);
            language.setText(data[position][2]);
            anthem.setText(data[position][3]);
        }
        if (continent.equals("אמריקה הצפונית"))
        {
            city.setText(data[position+7][0]);
            population.setText(data[position+7][1]);
            language.setText(data[position+7][2]);
            anthem.setText(data[position+7][3]);
        }
        if (continent.equals("אמריקה הדרומית"))
        {
            city.setText(data[position+14][0]);
            population.setText(data[position+14][1]);
            language.setText(data[position+14][2]);
            anthem.setText(data[position+14][3]);
        }
        if (continent.equals("אירופה"))
        {
            city.setText(data[position+21][0]);
            population.setText(data[position+21][1]);
            language.setText(data[position+21][2]);
            anthem.setText(data[position+21][3]);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position==0)
        {
            continent="אסיה";
            ArrayAdapter<String> adp2=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,countries[0]);
            list.setAdapter(adp2);
        }
        else if (position==1)
        {
            continent="אמריקה הצפונית";
            ArrayAdapter<String> adp2=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,countries[1]);
            list.setAdapter(adp2);
        }
        else if (position==2)
        {
            continent="אמריקה הדרומית";
            ArrayAdapter<String> adp2=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,countries[2]);
            list.setAdapter(adp2);
        }
        else if (position==3)
        {
            continent="אירופה";
            ArrayAdapter<String> adp2=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,countries[3]);
            list.setAdapter(adp2);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}