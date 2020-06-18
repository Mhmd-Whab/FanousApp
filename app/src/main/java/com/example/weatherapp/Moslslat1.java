
package com.example.weatherapp;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;

        import com.google.firebase.auth.FirebaseAuth;

public class Moslslat1 extends AppCompatActivity {
    String [] array =new String [] {"El Ekhtyar","B 100 Wesh","W Neheb Tany Leeh","Al Nehaya","Kheyanet Ahd","Lama Kona Soghayarin","The Game","Al-Prince"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moslslat1);
        final ListView list =(ListView) findViewById(R.id.list2);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Moslslat1.this,android.R.layout.select_dialog_item, array);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) list.getItemAtPosition(position);
                Toast.makeText(Moslslat1.this,clickedItem,Toast.LENGTH_LONG).show();
                openMoslslat(position);
            }
        });
    }

    public void openMoslslat(int position){
        switch (position) {
            case 0:
                openEkhtyar();
                return;
            case 1:
                openWesh();
                return;
            case 2:
                openNehebTany();
                return;
            case 3:
                openNehaya();
                return;
            case 4:
                openKhyanet();
                return;
            case 5:
                openLama();
                return;
            case 6:
                openTheGame();
                return;
            case 7:
                openPrince();
                return;
            default:
                return;
        }
    }

    private void openPrince() {
        Intent Prince = new Intent(this, A_Prince.class);
        startActivity(Prince);
    }

    private void openTheGame() {
        Intent Game = new Intent(this, The_Game.class);
        startActivity(Game);
    }

    private void openLama() {
        Intent Lama = new Intent(this, Lama_Kona_Shogh.class);
        startActivity(Lama);
    }

    private void openKhyanet() {
        Intent Khyanet = new Intent(this, Khyanet_Ahd.class);
        startActivity(Khyanet);
    }

    private void openNehaya() {
        Intent Nehaya = new Intent(this, Al_Nehaya.class);
        startActivity(Nehaya);
    }

    private void openNehebTany() {
        Intent Neheb = new Intent(this, W_Neheb_Tany_Leeh.class);
        startActivity(Neheb);
    }

    private void openWesh() {
        Intent Wesh = new Intent(this, B_100_Wesh.class);
        startActivity(Wesh);
    }

    private void openEkhtyar() {
        Intent Ekhtyar = new Intent(this, El_Ekhtyar.class);
        startActivity(Ekhtyar);
    }

    public void onDestroy() {
        super.onDestroy();
        logout();
    }
    public void logout(){
        FirebaseAuth.getInstance().signOut();
        finish();
    }
    }