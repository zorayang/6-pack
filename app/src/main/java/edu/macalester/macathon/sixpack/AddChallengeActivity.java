package edu.macalester.macathon.sixpack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import edu.macalester.macathon.sixpack.data.Challenge;

public class AddChallengeActivity extends AppCompatActivity {
    public static final String KEY_CHALLENGE = "KEY_CHALLENGE";
    private Spinner spinnerChallengeCategory;
    private EditText etName;
    private EditText etReward;
    private CheckBox cbCompeleted;
    private EditText etChallengeDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_challenge);

        spinnerChallengeCategory = (Spinner) findViewById(R.id.challengeTypeSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChallengeCategory.setAdapter(adapter);

        etName = (EditText) findViewById(R.id.etChallengeeName);
        etReward = (EditText) findViewById(R.id.etRewardAmount);
        cbCompeleted = (CheckBox) findViewById(R.id.cbCompleted);
        etChallengeDesc = (EditText) findViewById(R.id.etChallengeDesc);

        Button btnAddItem = (Button) findViewById(R.id.btnAddChallenge);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveItem();
            }
        });
    }

    private void saveItem() {
        Intent intentResult = new Intent();
        try{
            intentResult.putExtra(KEY_CHALLENGE,
                    new Challenge(etName.getText().toString(),
                            Double.parseDouble(etReward.getText().toString()),
                            etChallengeDesc.getText().toString(),
                            cbCompeleted.isChecked()
                    ));
            setResult(RESULT_OK, intentResult);
            finish();
        }catch (NumberFormatException e) {
            etReward.setError("please enter a value number");
        }

    }
}