package com.example.midterm;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ColorActivity extends AppCompatActivity {

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layout = findViewById(R.id.colorLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.color_menu, menu);

        MenuItem redItem = menu.findItem(R.id.menu_red);
        redItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onOptionsItemSelected(item);
                return true;
            }
        });

        MenuItem greenItem = menu.findItem(R.id.menu_green);
        greenItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onOptionsItemSelected(item);
                return true;
            }
        });

        MenuItem yellowItem = menu.findItem(R.id.menu_yellow);
        yellowItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                onOptionsItemSelected(item);
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_red) {
            changeLayoutColor(Color.RED);
            return true;
        } else if (id == R.id.menu_green) {
            changeLayoutColor(Color.GREEN);
            return true;
        } else if (id == R.id.menu_yellow) {
            changeLayoutColor(Color.YELLOW);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void changeLayoutColor(int color) {
        View view = findViewById(R.id.colorLayout);
        view.setBackgroundColor(color);
    }

}



