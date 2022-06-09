package sg.edu.rp.c346.id21027604.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextInputEditText taskEnter;
    Button btnAdd;
    Button btnDelete;
    Button btnClear;
    ListView allTasks;
    Spinner spnAddDelete;

    ArrayList<String> taskList;
    ArrayAdapter<String> taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskEnter = findViewById(R.id.enterTask);
        btnAdd = findViewById(R.id.buttonAdd);
        btnDelete = findViewById(R.id.buttonDelete);
        btnClear = findViewById(R.id.buttonClear);
        allTasks = findViewById(R.id.taskView);
        spnAddDelete = findViewById(R.id.deleteAddSpinner);

        taskList = new ArrayList<>();
        taskAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);

        allTasks.setAdapter(taskAdapter);

        spnAddDelete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0:
                    //code for add item selected
                        btnDelete.setEnabled(false);
                        btnAdd.setEnabled(true);
                        break;

                    case 1:
                    //code for delete selected
                        btnAdd.setEnabled(false);
                        btnDelete.setEnabled(true);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newTask = taskEnter.getText().toString();
                taskList.add(newTask);
                taskAdapter.notifyDataSetChanged();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deleteTask = taskEnter.getText().toString();
                taskList.remove(deleteTask);
                taskAdapter.notifyDataSetChanged();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskList.clear();
                taskAdapter.notifyDataSetChanged();
            }
        });
    }
}