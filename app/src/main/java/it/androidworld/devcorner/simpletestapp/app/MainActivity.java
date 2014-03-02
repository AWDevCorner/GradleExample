package it.androidworld.devcorner.simpletestapp.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    private TextView txtTesto;
    private Button btnCambiaTesto, btnAvviaBrowser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTesto = (TextView) findViewById(R.id.txtCaption);
        btnCambiaTesto = (Button) findViewById(R.id.btnCambiaTesto);
        btnCambiaTesto.setOnClickListener(this);
        btnAvviaBrowser = (Button) findViewById(R.id.btnAvviaBrowser);
        btnAvviaBrowser.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        final int clickedViewID = view.getId();

        switch(clickedViewID){
            case R.id.btnCambiaTesto:
                cambiaTesto();
                break;
            case R.id.btnAvviaBrowser:
                avviaBrowser();
                break;
            default: break;
        }
    }

    private final void cambiaTesto(){

        final String testoCorrente = txtTesto.getText().toString();
        final String helloWorld = getString(R.string.hello_world);
        final String helloWorld2 = getString(R.string.hello_world_2);

        if(testoCorrente.equalsIgnoreCase(helloWorld)) txtTesto.setText(helloWorld2);
        else txtTesto.setText(helloWorld);

    }

    private final void avviaBrowser(){

        final String url = "http://www.androidworld.it";


        Intent intentAvviaBrowser = new Intent(Intent.ACTION_VIEW);
        intentAvviaBrowser.setData(Uri.parse(url));

        startActivity(intentAvviaBrowser);
    }
}
