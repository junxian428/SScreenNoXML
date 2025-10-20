package com.example.sscreennoxml;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a TableLayout dynamically
        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setStretchAllColumns(true);
        tableLayout.setPadding(20, 50, 20, 50);

        // Detect screen size using Configuration (Method 2)
        int screenLayout = getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK;

        int rows = 0;
        int cols = 0;
        String title = "";

        switch (screenLayout) {
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                title = "📱 Small Screen Table";
                rows = 2; cols = 2;
                Toast.makeText(this, "Small Screen Detected", Toast.LENGTH_SHORT).show();
                break;

            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                title = "📲 Normal Screen Table";
                rows = 4; cols = 2;
                Toast.makeText(this, "Normal Screen Detected", Toast.LENGTH_SHORT).show();
                break;

            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                title = "💻 Large Screen Table";
                rows = 4; cols = 4;
                Toast.makeText(this, "Large Screen Detected", Toast.LENGTH_SHORT).show();
                break;

            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                title = "🖥️ Extra Large Screen Table";
                rows = 5; cols = 5;
                Toast.makeText(this, "Extra Large Screen Detected", Toast.LENGTH_SHORT).show();
                break;

            default:
                title = "📱 Default Table";
                rows = 3; cols = 3;
                Toast.makeText(this, "Default Layout", Toast.LENGTH_SHORT).show();
        }

        // --- Title Row ---
        TableRow titleRow = new TableRow(this);
        TextView titleText = new TextView(this);
        titleText.setText(title);
        titleText.setTextSize(22);
        titleText.setTextColor(Color.WHITE);
        titleText.setBackgroundColor(Color.DKGRAY);
        titleText.setPadding(10, 30, 10, 30);
        titleText.setGravity(Gravity.CENTER);
        titleText.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));
        titleRow.addView(titleText);
        tableLayout.addView(titleRow);

        // --- Data Rows ---
        for (int r = 0; r < rows; r++) {
            TableRow row = new TableRow(this);
            for (int c = 0; c < cols; c++) {
                TextView cell = new TextView(this);
                cell.setText("R" + (r + 1) + "C" + (c + 1));
                cell.setPadding(20, 20, 20, 20);
                cell.setGravity(Gravity.CENTER);
                cell.setBackgroundColor(Color.rgb(70 + r * 20, 150 + c * 10, 200));
                cell.setTextColor(Color.WHITE);
                row.addView(cell);
            }
            tableLayout.addView(row);
        }

        // Display the dynamically generated table
        setContentView(tableLayout);
    }
}